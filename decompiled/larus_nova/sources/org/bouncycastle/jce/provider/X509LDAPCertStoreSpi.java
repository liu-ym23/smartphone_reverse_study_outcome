package org.bouncycastle.jce.provider;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;

/* JADX INFO: loaded from: classes42.dex */
public class X509LDAPCertStoreSpi extends CertStoreSpi {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private X509LDAPCertStoreParameters params;

    public X509LDAPCertStoreSpi(CertStoreParameters r100) throws InvalidAlgorithmParameterException {
        super(r100);
        if ((r100 instanceof X509LDAPCertStoreParameters) == false) goto L7;
        this.params = (X509LDAPCertStoreParameters) r100;
        return;
    L7:
        throw new InvalidAlgorithmParameterException(X509LDAPCertStoreSpi.class.getName() + ": parameter must be a " + X509LDAPCertStoreParameters.class.getName() + " object\n" + r100.toString());
    }

    private Set certSubjectSerialSearch(X509CertSelector r100, String[] r101, String r102, String r103) throws CertStoreException {
        HashSet r104 = new HashSet();
    L29:
        e = move-exception;
        throw new CertStoreException("exception processing selector: " + e);
    L5:
        if (r100.getSubjectAsBytes() != null) goto L15;
        if (r100.getSubjectAsString() != null) goto L15;
        if (r100.getCertificate() != null) goto L15;
        Set r105 = search(r102, "*", r101);     // Catch: IOException -> L29
    L12:
        r104.addAll(r105);     // Catch: IOException -> L29
    L28:
        return r104;
    L15:
        if (r100.getCertificate() == null) goto L18;
        String r106 = r100.getCertificate().getSubjectX500Principal().getName("RFC1779");     // Catch: IOException -> L29
        String r107 = r100.getCertificate().getSerialNumber().toString();     // Catch: IOException -> L29
    L22:
        r104.addAll(search(r102, "*" + parseDN(r106, r103) + "*", r101));     // Catch: IOException -> L29
        if (r107 == null) goto L28;
        if (this.params.getSearchForSerialNumberIn() == null) goto L28;
        r105 = search(this.params.getSearchForSerialNumberIn(), "*" + r107 + "*", r101);     // Catch: IOException -> L29
        goto L12
    L18:
        if (r100.getSubjectAsBytes() == null) goto L20;
        r106 = new X500Principal(r100.getSubjectAsBytes()).getName("RFC1779");     // Catch: IOException -> L29
    L21:
        r107 = null;
        goto L22
    L20:
        r106 = r100.getSubjectAsString();     // Catch: IOException -> L29
        goto L21
    }

    private DirContext connectLDAP() throws NamingException {
        Properties r100 = new Properties();
        r100.setProperty("java.naming.factory.initial", LDAP_PROVIDER);
        r100.setProperty("java.naming.batchsize", "0");
        r100.setProperty("java.naming.provider.url", this.params.getLdapURL());
        r100.setProperty("java.naming.factory.url.pkgs", URL_CONTEXT_PREFIX);
        r100.setProperty("java.naming.referral", REFERRALS_IGNORE);
        r100.setProperty("java.naming.security.authentication", "none");
        return new InitialDirContext(r100);
    }

    private Set getCACertificates(X509CertSelector r100) throws CertStoreException {
        String[] r101 = {this.params.getCACertificateAttribute()};
        Set r102 = certSubjectSerialSearch(r100, r101, this.params.getLdapCACertificateAttributeName(), this.params.getCACertificateSubjectAttributeName());
        if (r102.isEmpty() == false) goto L5;
        r102.addAll(search(null, "*", r101));
    L5:
        return r102;
    }

    private Set getCrossCertificates(X509CertSelector r100) throws CertStoreException {
        String[] r101 = {this.params.getCrossCertificateAttribute()};
        Set r102 = certSubjectSerialSearch(r100, r101, this.params.getLdapCrossCertificateAttributeName(), this.params.getCrossCertificateSubjectAttributeName());
        if (r102.isEmpty() == false) goto L5;
        r102.addAll(search(null, "*", r101));
    L5:
        return r102;
    }

    private Set getEndCertificates(X509CertSelector r100) throws CertStoreException {
        return certSubjectSerialSearch(r100, new String[]{this.params.getUserCertificateAttribute()}, this.params.getLdapUserCertificateAttributeName(), this.params.getUserCertificateSubjectAttributeName());
    }

    private String parseDN(String r100, String r101) {
        String r102 = r100.substring(r100.toLowerCase().indexOf(r101.toLowerCase()) + r101.length());
        int r103 = r102.indexOf(44);
        if (r103 != (-1)) goto L6;
        r103 = r102.length();
    L6:
        if (r102.charAt(r103 - 1) != '\\') goto L10;
        r103 = r102.indexOf(44, r103 + 1);
        if (r103 != (-1)) goto L6;
        r103 = r102.length();
        goto L6
    L10:
        String r104 = r102.substring(0, r103);
        String r105 = r104.substring(r104.indexOf(61) + 1);
        if (r105.charAt(0) != ' ') goto L14;
        r105 = r105.substring(1);
    L14:
        if (r105.startsWith("\"") == false) goto L17;
        r105 = r105.substring(1);
    L17:
        if (r105.endsWith("\"") == true) goto L19;
        return r105;
    L19:
        return r105.substring(0, r105.length() - 1);
    }

    private Set search(String r100, String r101, String[] r110) throws CertStoreException {
        String r102 = r100 + ContainerUtils.KEY_VALUE_DELIMITER + r101;
        DirContext r103 = null;
        if (r100 != null) goto L5;
        r102 = null;
    L5:
        HashSet r104 = new HashSet();
        r103 = connectLDAP();     // Catch: Throwable -> L24 Exception -> L26
        SearchControls r105 = new SearchControls();     // Catch: Throwable -> L24 Exception -> L26
        r105.setSearchScope(2);     // Catch: Throwable -> L24 Exception -> L26
        r105.setCountLimit(0);     // Catch: Throwable -> L24 Exception -> L26
        int r106 = 0;
    L7:
        if (r106 >= r110.length) goto L21;
        String[] r107 = {r110[r106]};     // Catch: Throwable -> L24 Exception -> L26
        r105.setReturningAttributes(r107);     // Catch: Throwable -> L24 Exception -> L26
        String r108 = "(&(" + r102 + ")(" + r107[0] + "=*))";     // Catch: Throwable -> L24 Exception -> L26
        if (r102 != null) goto L12;
        r108 = "(" + r107[0] + "=*)";     // Catch: Throwable -> L24 Exception -> L26
    L12:
        NamingEnumeration r109 = r103.search(this.params.getBaseDN(), r108, r105);     // Catch: Throwable -> L24 Exception -> L26
    L14:
        if (r109.hasMoreElements() == false) goto L20;
        NamingEnumeration r111 = ((Attribute) ((SearchResult) r109.next()).getAttributes().getAll().next()).getAll();     // Catch: Throwable -> L24 Exception -> L26
    L17:
        if (r111.hasMore() == false) goto L14;
        r104.add(r111.next());     // Catch: Throwable -> L24 Exception -> L26
        goto L17
    L20:
        r106 = r106 + 1;
        goto L7
    L21:
        if (r103 != null) goto L39;
    L23:
        return r104;
    L39:
        r103.close();     // Catch: Exception -> L32
        goto L23
    L26:
        e = move-exception;
        throw new CertStoreException("Error getting results from LDAP directory " + e);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r103 != null) goto L37;
    L31:
        throw th;
    L37:
        r103.close();     // Catch: Exception -> L33
        goto L31
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector r110) throws CertStoreException {
        String[] r100 = {this.params.getCertificateRevocationListAttribute()};
        if ((r110 instanceof X509CRLSelector) == false) goto L28;
        X509CRLSelector r111 = (X509CRLSelector) r110;
        HashSet r101 = new HashSet();
        String r102 = this.params.getLdapCertificateRevocationListAttributeName();
        HashSet r103 = new HashSet();
        if (r111.getIssuerNames() == null) goto L14;
        Iterator<Object> r104 = r111.getIssuerNames().iterator();
    L8:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if ((r105 instanceof String) == false) goto L12;
        String r106 = this.params.getCertificateRevocationListIssuerAttributeName();
        String r107 = (String) r105;
    L13:
        r103.addAll(search(r102, "*" + parseDN(r107, r106) + "*", r100));
        goto L8
    L12:
        r106 = this.params.getCertificateRevocationListIssuerAttributeName();
        r107 = new X500Principal((byte[]) r105).getName("RFC1779");
    L15:
        r103.addAll(search(null, "*", r100));
        Iterator r108 = r103.iterator();
        CertificateFactory r109 = CertificateFactory.getInstance("X.509", "BC");     // Catch: Exception -> L24
    L18:
        if (r108.hasNext() == false) goto L23;
        CRL r112 = r109.generateCRL(new ByteArrayInputStream((byte[]) r108.next()));     // Catch: Exception -> L24
        if (r111.match(r112) == false) goto L18;
        r101.add(r112);     // Catch: Exception -> L24
        goto L18
    L23:
        return r101;
    L24:
        e = move-exception;
        throw new CertStoreException("CRL cannot be constructed from LDAP result " + e);
    L14:
        r103.addAll(search(r102, "*", r100));
        goto L15
    L28:
        throw new CertStoreException("selector is not a X509CRLSelector");
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector r100) throws CertStoreException {
        if ((r100 instanceof X509CertSelector) == false) goto L33;
        X509CertSelector r101 = (X509CertSelector) r100;
        HashSet r102 = new HashSet();
        Set r103 = getEndCertificates(r101);
        r103.addAll(getCACertificates(r101));
        r103.addAll(getCrossCertificates(r101));
        Iterator r104 = r103.iterator();
        CertificateFactory r105 = CertificateFactory.getInstance("X.509", "BC");     // Catch: Exception -> L29
    L6:
        if (r104.hasNext() == false) goto L28;
        byte[] r106 = (byte[]) r104.next();     // Catch: Exception -> L29
        if (r106 == null) goto L6;
        if (r106.length == 0) goto L6;
        ArrayList r107 = new ArrayList();     // Catch: Exception -> L29
        r107.add(r106);     // Catch: Exception -> L29
        CertificatePair r108 = CertificatePair.getInstance(new ASN1InputStream(r106).readObject());     // Catch: Throwable -> L34 Exception -> L29
        r107.clear();     // Catch: Throwable -> L34 Exception -> L29
        if (r108.getForward() == null) goto L18;
        r107.add(r108.getForward().getEncoded());     // Catch: Throwable -> L34 Exception -> L29
    L18:
        if (r108.getReverse() == null) goto L20;
        r107.add(r108.getReverse().getEncoded());     // Catch: Throwable -> L34 Exception -> L29
    L20:
        Iterator r109 = r107.iterator();     // Catch: Exception -> L29
    L22:
        if (r109.hasNext() == false) goto L6;
        Certificate r110 = r105.generateCertificate(new ByteArrayInputStream((byte[]) r109.next()));     // Catch: Exception -> L35
        if (r101.match(r110) == false) goto L22;
        r102.add(r110);     // Catch: Exception -> L35
        goto L22
    L28:
        return r102;
    L29:
        e = move-exception;
        throw new CertStoreException("certificate cannot be constructed from LDAP result: " + e);
    L33:
        throw new CertStoreException("selector is not a X509CertSelector");
    }
}
