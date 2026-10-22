package lv7;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.KeyAgreement;
import lv7.c;

/* JADX INFO: loaded from: classes23.dex */
public final class b<T_WRAPPER extends lv7.c<JcePrimitiveT>, JcePrimitiveT> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b<lv7.c.b, KeyAgreement> f510966b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b<lv7.c.d, KeyPairGenerator> f510967c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b<lv7.c.C6741c, KeyFactory> f510968d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<JcePrimitiveT> f510969a;

    public static class a<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lv7.c<JcePrimitiveT> f510970a;

        public a(lv7.c r100) {
            this.f510970a = r100;
        }

        @Override // lv7.b.d
        public final JcePrimitiveT a(String r100) throws GeneralSecurityException {
            String[] r101 = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList r102 = new ArrayList();
            int r103 = r101.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L8;
            Provider r105 = Security.getProvider(r101[r104]);
            if (r105 == null) goto L7;
            r102.add(r105);
        L7:
            r104 = r104 + 1;
            goto L3
        L8:
            Iterator r106 = r102.iterator();
            Exception r107 = null;
        L10:
            if (r106.hasNext() == false) goto L18;
            return this.f510970a.a(r100, (Provider) r106.next());
        L14:
            e = move-exception;
            if (r107 != null) goto L10;
            r107 = e;
            goto L10
        L18:
            return this.f510970a.a(r100, null);
        }
    }

    /* JADX INFO: renamed from: lv7.b$b, reason: collision with other inner class name */
    public static class C6740b<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lv7.c<JcePrimitiveT> f510971a;

        public C6740b(lv7.c r100) {
            this.f510971a = r100;
        }

        @Override // lv7.b.d
        public final JcePrimitiveT a(String r100) throws GeneralSecurityException {
            return this.f510971a.a(r100, null);
        }
    }

    public static class c<JcePrimitiveT> implements d<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lv7.c<JcePrimitiveT> f510972a;

        public c(lv7.c r100) {
            this.f510972a = r100;
        }

        @Override // lv7.b.d
        public final JcePrimitiveT a(String r100) throws GeneralSecurityException {
            String[] r101 = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};
            ArrayList r102 = new ArrayList();
            int r103 = r101.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L8;
            Provider r105 = Security.getProvider(r101[r104]);
            if (r105 == null) goto L7;
            r102.add(r105);
        L7:
            r104 = r104 + 1;
            goto L3
        L8:
            Iterator r106 = r102.iterator();
            Exception r107 = null;
        L10:
            if (r106.hasNext() == false) goto L18;
            Provider r108 = (Provider) r106.next();
            return this.f510972a.a(r100, r108);
        L14:
            e = move-exception;
            if (r107 != null) goto L10;
            r107 = e;
            goto L10
        L18:
            throw new GeneralSecurityException("No good Provider found.", r107);
        }
    }

    public interface d<JcePrimitiveT> {
        JcePrimitiveT a(String r100) throws GeneralSecurityException;
    }

    static {
        new b(new lv7.c.a());
        new b(new lv7.c.e());
        new b(new lv7.c.g());
        new b(new lv7.c.f());
        f510966b = new b(new lv7.c.b());
        f510967c = new b(new lv7.c.d());
        f510968d = new b(new lv7.c.C6741c());
    }

    public b(T_WRAPPER r100) {
        if (TinkFipsUtil.f275745b.get() == false) goto L6;
        this.f510969a = new c(r100);
        return;
    L6:
        if ("The Android Project".equals(System.getProperty("java.vendor")) == false) goto L8;
        this.f510969a = new a(r100);
        return;
    L8:
        this.f510969a = new C6740b(r100);
    }

    public final JcePrimitiveT a(String r100) throws GeneralSecurityException {
        return this.f510969a.a(r100);
    }
}
