package l22;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f507099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f507100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f507101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f507102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f507103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f507104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f507105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f507106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f507107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f507108j;

    public static final class a {
    }

    static {
    }

    public final String b() {
        int r100 = this.f507099a;
        if (r100 != 0) goto L5;
        return "init";
    L5:
        if (r100 != 1) goto L7;
        return "recognition";
    L7:
        if (r100 != 2) goto L9;
        return "interrupted";
    L9:
        if (r100 != 3) goto L11;
        return "completing";
    L11:
        if (r100 == 4) goto L13;
        return "unknown";
    L13:
        return BitableAnalytic.SelectSceneClickType.COMPLETE;
    }

    public final String toString() {
        return "RecognitionInfo(reqId=" + this.f507100b + ", state=" + b() + ", keyword=" + this.f507107i + ", traceback=" + this.f507108j + ", asrResult=" + this.f507101c + ", asrStartTime=" + this.f507102d + ", duration=" + this.f507104f + ", path=" + this.f507105g + ')';
    }

    public final boolean a(String r100) {
        int r101 = this.f507099a;
        if (r101 != 1) goto L5;
    L8:
        this.f507099a = 4;
        this.f507105g = r100;
        this.f507104f = (System.currentTimeMillis() - this.f507102d) + this.f507108j;
        return true;
    L5:
        if (r101 == 3) goto L8;
        return false;
    }

    public f(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        this.f507107i = r100;
        this.f507108j = r101;
        this.f507101c = r100;
        this.f507102d = System.currentTimeMillis();
    }
}
