package org.bouncycastle.x509.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.jce.provider.X509AttrCertParser;
import org.bouncycastle.jce.provider.X509CRLParser;
import org.bouncycastle.jce.provider.X509CertPairParser;
import org.bouncycastle.jce.provider.X509CertParser;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CRLStoreSelector;
import org.bouncycastle.x509.X509CertPairStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;
import org.bouncycastle.x509.X509CertificatePair;

/* JADX INFO: loaded from: classes42.dex */
public class LDAPStoreHelper {
    private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
    private static String REFERRALS_IGNORE = "ignore";
    private static final String SEARCH_SECURITY_LEVEL = "none";
    private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
    private static int cacheSize = 32;
    private static long lifeTime = 60000;
    private Map cacheMap;
    private X509LDAPCertStoreParameters params;

    public LDAPStoreHelper(X509LDAPCertStoreParameters r100) {
        this.cacheMap = new HashMap(cacheSize);
        this.params = r100;
    }

    private synchronized void addToCache(String r100, List r110) {
        monitor-enter(this);
        Date r101 = new Date(System.currentTimeMillis());     // Catch: Throwable -> L20
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L20
        r102.add(r101);     // Catch: Throwable -> L20
        r102.add(r110);     // Catch: Throwable -> L20
        if (this.cacheMap.containsKey(r100) == false) goto L8;
        Map r111 = this.cacheMap;     // Catch: Throwable -> L20
    L6:
        r111.put(r100, r102);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L8:
        if (this.cacheMap.size() < cacheSize) goto L16;
        Iterator r112 = this.cacheMap.entrySet().iterator();     // Catch: Throwable -> L20
        long r103 = r101.getTime();     // Catch: Throwable -> L20
        Object r104 = null;
    L11:
        if (r112.hasNext() == false) goto L15;
        Map.Entry r105 = (Map.Entry) r112.next();     // Catch: Throwable -> L20
        long r106 = ((Date) ListProtector.get((List) r105.getValue(), 0)).getTime();     // Catch: Throwable -> L20
        if (r106 >= r103) goto L11;
        r104 = r105.getKey();     // Catch: Throwable -> L20
        r103 = r106;
        goto L11
    L15:
        this.cacheMap.remove(r104);     // Catch: Throwable -> L20
    L16:
        r111 = this.cacheMap;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private List attrCertSubjectSerialSearch(X509AttributeCertStoreSelector r100, String[] r101, String[] r102, String[] r110) throws StoreException {
        ArrayList r103 = new ArrayList();
        HashSet r104 = new HashSet();
        String r105 = null;
        if (r100.getHolder() != null) goto L5;
    L10:
        Principal[] r106 = null;
    L12:
        if (r100.getAttributeCert() != null) goto L14;
    L17:
        int r107 = 0;
        if (r106 == null) goto L24;
        Principal r108 = r106[0];
        if ((r108 instanceof X500Principal) == false) goto L22;
        r105 = ((X500Principal) r108).getName("RFC1779");
        goto L24
    L22:
        r105 = r108.getName();
    L24:
        if (r100.getSerialNumber() == null) goto L27;
        r104.add(r100.getSerialNumber().toString());
    L27:
        if (r105 == null) goto L32;
    L29:
        if (r107 >= r110.length) goto L32;
        r103.addAll(search(r102, "*" + parseDN(r105, r110[r107]) + "*", r101));
        r107 = r107 + 1;
    L32:
        if (r104.size() <= 0) goto L40;
        if (this.params.getSearchForSerialNumberIn() == null) goto L40;
        Iterator r111 = r104.iterator();
    L37:
        if (r111.hasNext() == false) goto L40;
        r103.addAll(search(splitString(this.params.getSearchForSerialNumberIn()), (String) r111.next(), r101));
    L40:
        if (r104.size() != 0) goto L43;
        if (r105 != null) goto L43;
        r103.addAll(search(r102, "*", r101));
    L43:
        return r103;
    L14:
        if (r100.getAttributeCert().getHolder().getEntityNames() == null) goto L16;
        r106 = r100.getAttributeCert().getHolder().getEntityNames();
    L16:
        r104.add(r100.getAttributeCert().getSerialNumber().toString());
        goto L17
    L5:
        if (r100.getHolder().getSerialNumber() == null) goto L8;
        r104.add(r100.getHolder().getSerialNumber().toString());
    L8:
        if (r100.getHolder().getEntityNames() == null) goto L10;
        r106 = r100.getHolder().getEntityNames();
        goto L12
    }

    private List cRLIssuerSearch(X509CRLStoreSelector r100, String[] r101, String[] r110, String[] r111) throws StoreException {
        ArrayList r102 = new ArrayList();
        HashSet r103 = new HashSet();
        if (r100.getIssuers() == null) goto L6;
        r103.addAll(r100.getIssuers());
    L6:
        if (r100.getCertificateChecking() == null) goto L9;
        r103.add(getCertificateIssuer(r100.getCertificateChecking()));
    L9:
        if (r100.getAttrCertificateChecking() == null) goto L17;
        Principal[] r104 = r100.getAttrCertificateChecking().getIssuer().getPrincipals();
        int r105 = 0;
    L12:
        if (r105 >= r104.length) goto L17;
        Principal r106 = r104[r105];
        if ((r106 instanceof X500Principal) == false) goto L16;
        r103.add(r106);
    L16:
        r105 = r105 + 1;
    L17:
        Iterator r107 = r103.iterator();
        String r108 = null;
    L19:
        if (r107.hasNext() == false) goto L24;
        r108 = ((X500Principal) r107.next()).getName("RFC1779");
        int r109 = 0;
    L22:
        if (r109 >= r111.length) goto L19;
        r102.addAll(search(r110, "*" + parseDN(r108, r111[r109]) + "*", r101));
        r109 = r109 + 1;
        goto L22
    L24:
        if (r108 != null) goto L26;
        r102.addAll(search(r110, "*", r101));
    L26:
        return r102;
    }

    private List certSubjectSerialSearch(X509CertStoreSelector r100, String[] r101, String[] r102, String[] r110) throws StoreException {
        ArrayList r103 = new ArrayList();
        String r104 = getSubjectAsString(r100);
        if (r100.getSerialNumber() == null) goto L5;
        String r105 = r100.getSerialNumber().toString();
    L7:
        if (r100.getCertificate() == null) goto L10;
        r104 = r100.getCertificate().getSubjectX500Principal().getName("RFC1779");
        r105 = r100.getCertificate().getSerialNumber().toString();
    L10:
        if (r104 == null) goto L15;
        int r106 = 0;
    L13:
        if (r106 >= r110.length) goto L15;
        r103.addAll(search(r102, "*" + parseDN(r104, r110[r106]) + "*", r101));
        r106 = r106 + 1;
    L15:
        if (r105 != null) goto L17;
    L19:
        if (r105 != null) goto L22;
        if (r104 != null) goto L22;
        r103.addAll(search(r102, "*", r101));
    L22:
        return r103;
    L17:
        if (this.params.getSearchForSerialNumberIn() == null) goto L19;
        r103.addAll(search(splitString(this.params.getSearchForSerialNumberIn()), r105, r101));
        goto L19
    L5:
        r105 = null;
        goto L7
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

    private Set createAttributeCertificates(List r100, X509AttributeCertStoreSelector r101) throws StoreException {
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
        X509AttrCertParser r104 = new X509AttrCertParser();
    L4:
        if (r103.hasNext() == false) goto L10;
        r104.engineInit(new ByteArrayInputStream((byte[]) r103.next()));     // Catch: StreamParsingException -> L9
        X509AttributeCertificate r105 = (X509AttributeCertificate) r104.engineRead();     // Catch: StreamParsingException -> L9
        if (r101.match(r105) == false) goto L4;
        r102.add(r105);     // Catch: StreamParsingException -> L9
        goto L4
    L10:
        return r102;
    }

    private Set createCRLs(List r100, X509CRLStoreSelector r101) throws StoreException {
        HashSet r102 = new HashSet();
        X509CRLParser r103 = new X509CRLParser();
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        r103.engineInit(new ByteArrayInputStream((byte[]) r104.next()));     // Catch: StreamParsingException -> L9
        X509CRL r105 = (X509CRL) r103.engineRead();     // Catch: StreamParsingException -> L9
        if (r101.match(r105) == false) goto L4;
        r102.add(r105);     // Catch: StreamParsingException -> L9
        goto L4
    L10:
        return r102;
    }

    private Set createCerts(List r100, X509CertStoreSelector r101) throws StoreException {
        HashSet r102 = new HashSet();
        Iterator r103 = r100.iterator();
        X509CertParser r104 = new X509CertParser();
    L4:
        if (r103.hasNext() == false) goto L10;
        r104.engineInit(new ByteArrayInputStream((byte[]) r103.next()));     // Catch: Exception -> L9
        X509Certificate r105 = (X509Certificate) r104.engineRead();     // Catch: Exception -> L9
        if (r101.match(r105) == false) goto L4;
        r102.add(r105);     // Catch: Exception -> L9
        goto L4
    L10:
        return r102;
    }

    private Set createCrossCertificatePairs(List r100, X509CertPairStoreSelector r110) throws StoreException {
        HashSet r101 = new HashSet();
        int r102 = 0;
    L4:
        if (r102 >= r100.size()) goto L12;
        X509CertPairParser r103 = new X509CertPairParser();     // Catch: StreamParsingException -> L7 Throwable -> L13
        r103.engineInit(new ByteArrayInputStream((byte[]) ListProtector.get(r100, r102)));     // Catch: StreamParsingException -> L7 Throwable -> L13
        X509CertificatePair r104 = (X509CertificatePair) r103.engineRead();     // Catch: StreamParsingException -> L7 Throwable -> L13
    L9:
        if (r110.match(r104) == false) goto L11;
        r101.add(r104);     // Catch: Throwable -> L13 Throwable -> L13
    L7:
        byte[] r105 = (byte[]) ListProtector.get(r100, r102);     // Catch: Throwable -> L13 Throwable -> L13
        int r106 = r102 + 1;     // Catch: Throwable -> L13 Throwable -> L13
        byte[] r107 = (byte[]) ListProtector.get(r100, r106);     // Catch: Throwable -> L13 Throwable -> L13
        r102 = r106;
        r104 = new X509CertificatePair(new CertificatePair(Certificate.getInstance(new ASN1InputStream(r105).readObject()), Certificate.getInstance(new ASN1InputStream(r107).readObject())));     // Catch: Throwable -> L13 Throwable -> L13
    L11:
        r102 = r102 + 1;
        goto L4
    L12:
        return r101;
    }

    private List crossCertificatePairSubjectSearch(X509CertPairStoreSelector r100, String[] r101, String[] r102, String[] r103) throws StoreException {
        ArrayList r104 = new ArrayList();
        if (r100.getForwardSelector() == null) goto L5;
        String r105 = getSubjectAsString(r100.getForwardSelector());
    L7:
        if (r100.getCertPair() == null) goto L12;
        if (r100.getCertPair().getForward() == null) goto L12;
        r105 = r100.getCertPair().getForward().getSubjectX500Principal().getName("RFC1779");
    L12:
        if (r105 == null) goto L17;
        int r106 = 0;
    L15:
        if (r106 >= r103.length) goto L17;
        r104.addAll(search(r102, "*" + parseDN(r105, r103[r106]) + "*", r101));
        r106 = r106 + 1;
    L17:
        if (r105 != null) goto L19;
        r104.addAll(search(r102, "*", r101));
    L19:
        return r104;
    L5:
        r105 = null;
        goto L7
    }

    private X500Principal getCertificateIssuer(X509Certificate r100) {
        return r100.getIssuerX500Principal();
    }

    private List getFromCache(String r100) {
        List r101 = (List) this.cacheMap.get(r100);
        long r102 = System.currentTimeMillis();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (((Date) ListProtector.get(r101, 0)).getTime() >= (r102 - lifeTime)) goto L8;
        return null;
    L8:
        return (List) ListProtector.get(r101, 1);
    }

    private String getSubjectAsString(X509CertStoreSelector r100) {
        byte[] r101 = r100.getSubjectAsBytes();     // Catch: IOException -> L8
        if (r101 == null) goto L6;
        return new X500Principal(r101).getName("RFC1779");
    L6:
        return null;
    L8:
        e = move-exception;
        throw new StoreException("exception processing name: " + e.getMessage(), e);
    }

    private String parseDN(String r100, String r101) {
        int r102 = r100.toLowerCase().indexOf(r101.toLowerCase() + ContainerUtils.KEY_VALUE_DELIMITER);
        if (r102 != (-1)) goto L6;
        return "";
    L6:
        String r103 = r100.substring(r102 + r101.length());
        int r104 = r103.indexOf(44);
        if (r104 != (-1)) goto L10;
        r104 = r103.length();
    L10:
        if (r103.charAt(r104 - 1) != '\\') goto L14;
        r104 = r103.indexOf(44, r104 + 1);
        if (r104 != (-1)) goto L10;
        r104 = r103.length();
        goto L10
    L14:
        String r105 = r103.substring(0, r104);
        String r106 = r105.substring(r105.indexOf(61) + 1);
        if (r106.charAt(0) != ' ') goto L18;
        r106 = r106.substring(1);
    L18:
        if (r106.startsWith("\"") == false) goto L21;
        r106 = r106.substring(1);
    L21:
        if (r106.endsWith("\"") == true) goto L23;
        return r106;
    L23:
        return r106.substring(0, r106.length() - 1);
    }

    private List search(String[] r110, String r111, String[] r112) throws StoreException {
        int r100 = 0;
        DirContext r101 = null;
        if (r110 != null) goto L6;
        String r113 = null;
    L13:
        String r114 = "";
    L15:
        if (r100 >= r112.length) goto L17;
        r114 = r114 + "(" + r112[r100] + "=*)";
        r100 = r100 + 1;
        goto L15
    L17:
        String r115 = "(|" + r114 + ")";
        String r102 = "(&" + r113 + "" + r115 + ")";
        if (r113 == null) goto L21;
        r115 = r102;
    L21:
        List r116 = getFromCache(r115);
        if (r116 == null) goto L24;
        return r116;
    L24:
        ArrayList r117 = new ArrayList();
        r101 = connectLDAP();     // Catch: Throwable -> L35 NamingException -> L39
        SearchControls r103 = new SearchControls();     // Catch: Throwable -> L35 NamingException -> L39
        r103.setSearchScope(2);     // Catch: Throwable -> L35 NamingException -> L39
        r103.setCountLimit(0);     // Catch: Throwable -> L35 NamingException -> L39
        r103.setReturningAttributes(r112);     // Catch: Throwable -> L35 NamingException -> L39
        NamingEnumeration r118 = r101.search(this.params.getBaseDN(), r115, r103);     // Catch: Throwable -> L35 NamingException -> L39
    L27:
        if (r118.hasMoreElements() == false) goto L32;
        NamingEnumeration r104 = ((Attribute) ((SearchResult) r118.next()).getAttributes().getAll().next()).getAll();     // Catch: Throwable -> L35 NamingException -> L39
    L30:
        if (r104.hasMore() == false) goto L27;
        r117.add(r104.next());     // Catch: Throwable -> L35 NamingException -> L39
        goto L30
    L32:
        addToCache(r115, r117);     // Catch: Throwable -> L35 NamingException -> L39
    L44:
        r101.close();     // Catch: Exception -> L42
    L41:
        return r117;
    L39:
        if (r101 == null) goto L41;
    L35:
        th = move-exception;
        if (r101 != null) goto L46;
    L38:
        throw th;
    L46:
        r101.close();     // Catch: Exception -> L43
        goto L38
    L6:
        if (r111.equals("**") == false) goto L8;
        r111 = "*";
    L8:
        String r105 = "";
        int r106 = 0;
    L10:
        if (r106 >= r110.length) goto L12;
        r105 = r105 + "(" + r110[r106] + ContainerUtils.KEY_VALUE_DELIMITER + r111 + ")";
        r106 = r106 + 1;
        goto L10
    L12:
        r113 = "(|" + r105 + ")";
        goto L13
    }

    private String[] splitString(String r100) {
        return r100.split("\\s+");
    }

    public Collection getAACertificates(X509AttributeCertStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getAACertificateAttribute());
        String[] r102 = splitString(this.params.getLdapAACertificateAttributeName());
        String[] r103 = splitString(this.params.getAACertificateSubjectAttributeName());
        Set r104 = createAttributeCertificates(attrCertSubjectSerialSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getAttributeAuthorityRevocationLists(X509CRLStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getAttributeAuthorityRevocationListAttribute());
        String[] r102 = splitString(this.params.getLdapAttributeAuthorityRevocationListAttributeName());
        String[] r103 = splitString(this.params.getAttributeAuthorityRevocationListIssuerAttributeName());
        Set r104 = createCRLs(cRLIssuerSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getAttributeCertificateAttributes(X509AttributeCertStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getAttributeCertificateAttributeAttribute());
        String[] r102 = splitString(this.params.getLdapAttributeCertificateAttributeAttributeName());
        String[] r103 = splitString(this.params.getAttributeCertificateAttributeSubjectAttributeName());
        Set r104 = createAttributeCertificates(attrCertSubjectSerialSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getAttributeCertificateRevocationLists(X509CRLStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getAttributeCertificateRevocationListAttribute());
        String[] r102 = splitString(this.params.getLdapAttributeCertificateRevocationListAttributeName());
        String[] r103 = splitString(this.params.getAttributeCertificateRevocationListIssuerAttributeName());
        Set r104 = createCRLs(cRLIssuerSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getAttributeDescriptorCertificates(X509AttributeCertStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getAttributeDescriptorCertificateAttribute());
        String[] r102 = splitString(this.params.getLdapAttributeDescriptorCertificateAttributeName());
        String[] r103 = splitString(this.params.getAttributeDescriptorCertificateSubjectAttributeName());
        Set r104 = createAttributeCertificates(attrCertSubjectSerialSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getAuthorityRevocationLists(X509CRLStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getAuthorityRevocationListAttribute());
        String[] r102 = splitString(this.params.getLdapAuthorityRevocationListAttributeName());
        String[] r103 = splitString(this.params.getAuthorityRevocationListIssuerAttributeName());
        Set r104 = createCRLs(cRLIssuerSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getCACertificates(X509CertStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getCACertificateAttribute());
        String[] r102 = splitString(this.params.getLdapCACertificateAttributeName());
        String[] r103 = splitString(this.params.getCACertificateSubjectAttributeName());
        Set r104 = createCerts(certSubjectSerialSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getCertificateRevocationLists(X509CRLStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getCertificateRevocationListAttribute());
        String[] r102 = splitString(this.params.getLdapCertificateRevocationListAttributeName());
        String[] r103 = splitString(this.params.getCertificateRevocationListIssuerAttributeName());
        Set r104 = createCRLs(cRLIssuerSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getCrossCertificatePairs(X509CertPairStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getCrossCertificateAttribute());
        String[] r102 = splitString(this.params.getLdapCrossCertificateAttributeName());
        String[] r103 = splitString(this.params.getCrossCertificateSubjectAttributeName());
        Set r104 = createCrossCertificatePairs(crossCertificatePairSubjectSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        X509CertStoreSelector r105 = new X509CertStoreSelector();
        X509CertPairStoreSelector r106 = new X509CertPairStoreSelector();
        r106.setForwardSelector(r105);
        r106.setReverseSelector(r105);
        r104.addAll(createCrossCertificatePairs(crossCertificatePairSubjectSearch(r106, r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getDeltaCertificateRevocationLists(X509CRLStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getDeltaRevocationListAttribute());
        String[] r102 = splitString(this.params.getLdapDeltaRevocationListAttributeName());
        String[] r103 = splitString(this.params.getDeltaRevocationListIssuerAttributeName());
        Set r104 = createCRLs(cRLIssuerSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }

    public Collection getUserCertificates(X509CertStoreSelector r100) throws StoreException {
        String[] r101 = splitString(this.params.getUserCertificateAttribute());
        String[] r102 = splitString(this.params.getLdapUserCertificateAttributeName());
        String[] r103 = splitString(this.params.getUserCertificateSubjectAttributeName());
        Set r104 = createCerts(certSubjectSerialSearch(r100, r101, r102, r103), r100);
        if (r104.size() != 0) goto L5;
        r104.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), r101, r102, r103), r100));
    L5:
        return r104;
    }
}
