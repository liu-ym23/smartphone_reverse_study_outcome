package okio.internal;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.g0;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f524037a = null;

    static {
        Intrinsics.checkNotNullParameter("0123456789abcdef", "<this>");
        f524037a = "0123456789abcdef".getBytes(Charsets.UTF_8);
    }

    public static final String b(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 <= 0) goto L7;
        long r102 = r101 - 1;
        if (r100.getByte(r102) != 13) goto L7;
        String r103 = r100.readUtf8(r102);
        r100.skip(2);
        return r103;
    L7:
        String r104 = r100.readUtf8(r101);
        r100.skip(1);
        return r104;
    }

    public static final boolean a(g0 r100, int r101, byte[] r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, MonitorConstants.SEGMENT);
        Intrinsics.checkNotNullParameter(r102, HTTP.CONTENT_RANGE_BYTES);
        int r103 = r100.f524019c;
        byte[] r104 = r100.f524017a;
        int r105 = 1;
    L3:
        if (r105 >= r110) goto L11;
        if (r101 != r103) goto L7;
        r100 = r100.f524022f;
        Intrinsics.checkNotNull(r100);
        byte[] r106 = r100.f524017a;
        int r107 = r100.f524018b;
        r104 = r106;
        r101 = r107;
        r103 = r100.f524019c;
    L7:
        if (r104[r101] != r102[r105]) goto L8;
        r101 = r101 + 1;
        r105 = r105 + 1;
        goto L3
    L8:
        return false;
    L11:
        return true;
    }
}
