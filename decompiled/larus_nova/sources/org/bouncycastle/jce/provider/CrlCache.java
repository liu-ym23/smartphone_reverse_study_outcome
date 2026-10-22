package org.bouncycastle.jce.provider;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.jcajce.PKIXCRLStore;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Iterable;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

/* JADX INFO: loaded from: classes42.dex */
class CrlCache {
    private static final int DEFAULT_TIMEOUT = 15000;
    private static Map<URI, WeakReference<PKIXCRLStore>> cache;

    public static class LocalCRLStore<T extends CRL> implements PKIXCRLStore, Iterable<CRL> {
        private Collection<CRL> _local;

        public LocalCRLStore(Store<CRL> r100) {
            this._local = new ArrayList(r100.getMatches(null));
        }

        @Override // org.bouncycastle.jcajce.PKIXCRLStore, org.bouncycastle.util.Store
        public Collection getMatches(Selector r100) {
            if (r100 == null) goto L4;
            ArrayList r101 = new ArrayList();
            Iterator<CRL> r102 = this._local.iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            CRL r103 = r102.next();
            if (r100.match(r103) == false) goto L7;
            r101.add(r103);
            goto L7
        L11:
            return r101;
        L4:
            return new ArrayList(this._local);
        }

        @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
        public Iterator<CRL> iterator() {
            return getMatches(null).iterator();
        }
    }

    static {
        cache = Collections.synchronizedMap(new WeakHashMap());
    }

    public CrlCache() {
    }

    public static synchronized PKIXCRLStore getCrl(CertificateFactory r100, Date r101, URI r102) throws IOException, CRLException {
        monitor-enter(CrlCache.class);
        WeakReference<PKIXCRLStore> r103 = cache.get(r102);     // Catch: Throwable -> L28
        if (r103 == null) goto L7;
        PKIXCRLStore r104 = r103.get();     // Catch: Throwable -> L28
    L8:
        if (r104 == null) goto L22;
        Iterator r105 = r104.getMatches(null).iterator();     // Catch: Throwable -> L28
    L11:
        if (r105.hasNext() == false) goto L17;
        Date r106 = ((X509CRL) r105.next()).getNextUpdate();     // Catch: Throwable -> L28
        if (r106 == null) goto L11;
        if (r106.before(r101) == false) goto L11;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L22;
        monitor-exit(CrlCache.class);
        return r104;
    L17:
        r107 = false;
    L22:
        if (r102.getScheme().equals("ldap") == false) goto L24;
        Collection r108 = getCrlsFromLDAP(r100, r102);     // Catch: Throwable -> L28
    L25:
        LocalCRLStore r109 = new LocalCRLStore(new CollectionStore(r108));     // Catch: Throwable -> L28
        cache.put(r102, new WeakReference(r109));     // Catch: Throwable -> L28
        monitor-exit(CrlCache.class);
        return r109;
    L24:
        r108 = getCrls(r100, r102);     // Catch: Throwable -> L28
        goto L25
    L7:
        r104 = null;
    L28:
        th = move-exception;
        throw th;
    }

    private static Collection getCrls(CertificateFactory r100, URI r101) throws IOException, CRLException {
        HttpURLConnection r102 = (HttpURLConnection) INVOKEVIRTUAL_org_bouncycastle_jce_provider_CrlCache_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r101.toURL());
        r102.setConnectTimeout(15000);
        r102.setReadTimeout(15000);
        InputStream r103 = r102.getInputStream();
        Collection<? extends CRL> r104 = r100.generateCRLs(r103);
        r103.close();
        return r104;
    }

    private static Collection getCrlsFromLDAP(CertificateFactory r100, URI r101) throws IOException, CRLException {
        Hashtable r102 = new Hashtable();
        r102.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
        r102.put("java.naming.provider.url", r101.toString());
        byte[] r103 = (byte[]) new InitialDirContext(r102).getAttributes("").get("certificateRevocationList;binary").get();     // Catch: NamingException -> L11
        if (r103 == null) goto L10;
        if (r103.length == 0) goto L10;
        return r100.generateCRLs(new ByteArrayInputStream(r103));
    L10:
        throw new CRLException("no CRL returned from: " + r101);
    L11:
        e = move-exception;
        throw new CRLException("issue connecting to: " + r101.toString(), e);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_org_bouncycastle_jce_provider_CrlCache_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
