package okio;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Buffer.a f523972a = null;

    public static final long d(long r100) {
        long r101 = ((((((((-72057594037927936L) & r100) >>> 56) | ((71776119061217280L & r100) >>> 40)) | ((280375465082880L & r100) >>> 24)) | ((1095216660480L & r100) >>> 8)) | ((4278190080L & r100) << 8)) | ((16711680 & r100) << 24)) | ((65280 & r100) << 40);
        return ((r100 & 255) << 56) | r101;
    }

    static {
        f523972a = new Buffer.a();
    }

    public static final String e(byte r100) {
        char[] r101 = okio.internal.b.f524038a;
        return StringsKt.concatToString(new char[]{r101[(r100 >> 4) & 15], r101[r100 & 15]});
    }

    public static final String f(int r100) {
        if (r100 != 0) goto L5;
        return "0";
    L5:
        char[] r101 = okio.internal.b.f524038a;
        int r102 = 0;
        char[] r103 = {r101[(r100 >> 28) & 15], r101[(r100 >> 24) & 15], r101[(r100 >> 20) & 15], r101[(r100 >> 16) & 15], r101[(r100 >> 12) & 15], r101[(r100 >> 8) & 15], r101[(r100 >> 4) & 15], r101[r100 & 15]};
    L6:
        if (r102 >= 8) goto L11;
        if (r103[r102] != '0') goto L11;
        r102 = r102 + 1;
    L11:
        return StringsKt.concatToString(r103, r102, 8);
    }

    public static final int c(ByteString r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == (-1234567890)) goto L5;
        return r101;
    L5:
        return r100.size();
    }

    public static final void b(long r100, long r101, long r102) {
        if ((r101 | r102) < 0) goto L10;
        if (r101 > r100) goto L10;
        if ((r100 - r101) < r102) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r100 + " offset=" + r101 + " byteCount=" + r102);
    }

    public static final boolean a(byte[] r100, int r101, byte[] r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r102, "b");
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        if (r100[r105 + r101] != r102[r105 + r103]) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
