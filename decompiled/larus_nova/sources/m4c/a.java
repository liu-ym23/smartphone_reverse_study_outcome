package m4c;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.InvalidKeyException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511904a = 0;

    /* JADX INFO: renamed from: m4c.a$a, reason: collision with other inner class name */
    public static class C6771a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SecretKey f511905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SecretKey f511906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f511907c;

        public final int hashCode() {
            if (this.f511907c != (-1)) goto L6;
            this.f511907c = ((this.f511905a.hashCode() + 31) * 31) + this.f511906b.hashCode();
        L6:
            return this.f511907c;
        }

        public final String toString() {
            return Base64.encodeToString(this.f511905a.getEncoded(), 2) + ":" + Base64.encodeToString(this.f511906b.getEncoded(), 2);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (C6771a.class == r100.getClass()) goto L11;
            return false;
        L11:
            C6771a r101 = (C6771a) r100;
            if (this.f511906b.equals(r101.f511906b) == true) goto L15;
            return false;
        L15:
            if (this.f511905a.equals(r101.f511905a) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public C6771a(SecretKey r100, SecretKey r101) {
            this.f511907c = -1;
            this.f511905a = r100;
            this.f511906b = r101;
        }
    }

    static {
        new AtomicBoolean(false);
    }

    public static C6771a a(String r100) throws InvalidKeyException {
        String[] r101 = r100.split(":");
        if (r101.length != 2) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L18;
        byte[] r103 = Base64.decode(r101[0], 2);
        if (r103.length != 16) goto L16;
        byte[] r104 = Base64.decode(r101[1], 2);
        if (r104.length != 32) goto L14;
        return new C6771a(new SecretKeySpec(r103, 0, r103.length, CryptoConst.ALGORITHM_AES), new SecretKeySpec(r104, "HmacSHA256"));
    L14:
        throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
    L16:
        throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
    L18:
        throw new IllegalArgumentException("Cannot parse aesKey:".concat(r100));
    L5:
        r102 = false;
        goto L6
    }
}
