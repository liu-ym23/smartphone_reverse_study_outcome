package uoa;

import android.content.Context;
import android.util.Base64;
import com.privacy.azerothprivacy.AzerothPrivacy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f550964e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f550965f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f550966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f550967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f550968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f550969d;

    static {
        f550964e = new byte[]{-70, 84};
        f550965f = new byte[0];
    }

    public d(String r100) throws GeneralSecurityException {
        a(Base64.decode(r100, 0));     // Catch: IllegalArgumentException -> L5
        return;
    L5:
        e = move-exception;
        throw new GeneralSecurityException("cipher text is a illegal base64 string", e);
    }

    public final void a(byte[] r110) throws GeneralSecurityException {
        if (r110.length < 22) goto L39;
        ByteBuffer r111 = ByteBuffer.wrap(r110);
        byte[] r100 = new byte[2];
        this.f550966a = r100;
        r111.get(r100);
        if (Arrays.equals(this.f550966a, f550964e) == false) goto L7;
    L11:
        String r101 = AzerothPrivacy.getAppInfo().f530146e;
        long r102 = r111.order(ByteOrder.LITTLE_ENDIAN).getLong();
        this.f550967b = r102;
        String r103 = toa.a.f546969a;
        monitor-enter(toa.a.class);
        Context r104 = AzerothPrivacy.getAppContext();     // Catch: Throwable -> L26 Exception -> L28
        if (r102 != toa.a.c(r104, r101)) goto L20;
        Boolean r105 = Boolean.TRUE;     // Catch: Throwable -> L26 Exception -> L28
        monitor-exit(toa.a.class);
    L40:
    L31:
        if (r105.booleanValue() == false) goto L35;
        byte[] r106 = new byte[12];
        this.f550968c = r106;
        r111.get(r106);
        byte[] r107 = new byte[r111.remaining()];
        this.f550969d = r107;
        r111.get(r107);
        return;
    L35:
        throw new GeneralSecurityException(String.format(Locale.US, "invalid key version, cipher text key version is %d", new Object[]{Long.valueOf(this.f550967b)}));
    L20:
        if (r102 != toa.a.b(r104, r101)) goto L22;
        boolean r108 = true;
    L23:
        r105 = Boolean.valueOf(r108);     // Catch: Throwable -> L26 Exception -> L28
        monitor-exit(toa.a.class);
        goto L40
    L22:
        r108 = false;
    L28:
        r105 = Boolean.FALSE;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L7:
        if (Arrays.equals(this.f550966a, f550965f) == true) goto L11;
        throw new GeneralSecurityException("invalid cipher text with wrong header bytes " + Arrays.toString(this.f550966a));
    L39:
        throw new GeneralSecurityException("invalid cipher text with length " + r110.length);
    }

    public d(byte[] r100) throws GeneralSecurityException {
        a(r100);
    }
}
