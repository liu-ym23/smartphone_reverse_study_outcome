package lv7;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes23.dex */
public interface c<T> {

    public static class a implements c<Cipher> {
        public a() {
        }

        @Override // lv7.c
        public final Cipher a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return Cipher.getInstance(r100);
        L5:
            return Cipher.getInstance(r100, r101);
        }
    }

    public static class b implements c<KeyAgreement> {
        public b() {
        }

        @Override // lv7.c
        public final KeyAgreement a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return KeyAgreement.getInstance(r100);
        L5:
            return KeyAgreement.getInstance(r100, r101);
        }
    }

    /* JADX INFO: renamed from: lv7.c$c, reason: collision with other inner class name */
    public static class C6741c implements c<KeyFactory> {
        public C6741c() {
        }

        @Override // lv7.c
        public final KeyFactory a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return KeyFactory.getInstance(r100);
        L5:
            return KeyFactory.getInstance(r100, r101);
        }
    }

    public static class d implements c<KeyPairGenerator> {
        public d() {
        }

        @Override // lv7.c
        public final KeyPairGenerator a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return KeyPairGenerator.getInstance(r100);
        L5:
            return KeyPairGenerator.getInstance(r100, r101);
        }
    }

    public static class e implements c<Mac> {
        public e() {
        }

        @Override // lv7.c
        public final Mac a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return Mac.getInstance(r100);
        L5:
            return Mac.getInstance(r100, r101);
        }
    }

    public static class f implements c<MessageDigest> {
        public f() {
        }

        @Override // lv7.c
        public final MessageDigest a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return MessageDigest.getInstance(r100);
        L5:
            return MessageDigest.getInstance(r100, r101);
        }
    }

    public static class g implements c<Signature> {
        public g() {
        }

        @Override // lv7.c
        public final Signature a(String r100, Provider r101) throws GeneralSecurityException {
            if (r101 != null) goto L5;
            return Signature.getInstance(r100);
        L5:
            return Signature.getInstance(r100, r101);
        }
    }

    T a(String r100, Provider r101) throws GeneralSecurityException;
}
