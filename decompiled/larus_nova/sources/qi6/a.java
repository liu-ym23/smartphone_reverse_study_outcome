package qi6;

import com.bytedance.live.livelink.kmp.api.base.video.VideoDataType;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f533151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoDataType f533152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f533153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f533154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f533155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f533156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f533157g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f533151a == r101.f533151a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f533152b, r101.f533152b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f533153c, r101.f533153c) == true) goto L12;
        return false;
    L12:
        if (this.f533154d == r101.f533154d) goto L14;
        return false;
    L14:
        if (this.f533155e == r101.f533155e) goto L16;
        return false;
    L16:
        if (this.f533156f == r101.f533156f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f533157g, r101.f533157g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean r100 = this.f533151a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        VideoDataType r103 = this.f533152b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        b r107 = this.f533153c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (((((r106 + r108) * 31) + this.f533154d) * 31) + this.f533155e) * 31;
        long r110 = this.f533156f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Map<String, Object> r112 = this.f533157g;
        if (r112 == null) goto L17;
        r104 = r112.hashCode();
    L17:
        return r111 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "CommonVideoFrame(isExtCustomFrame=" + this.f533151a + ", type=" + this.f533152b + ", frameData=" + this.f533153c + ", width=" + this.f533154d + ", height=" + this.f533155e + ", timestampNs=" + this.f533156f + ", extraData=" + this.f533157g + ")";
    }

    public final VideoDataType getType() {
        return this.f533152b;
    }

    public a(VideoDataType r100, b r101, int r102, int r103, long r104, Map r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "frameData");
        Intrinsics.checkNotNullParameter(r105, ControlRule.KEY_EXTRA_DATA);
        this.f533151a = false;
        this.f533152b = r100;
        this.f533153c = r101;
        this.f533154d = r102;
        this.f533155e = r103;
        this.f533156f = r104;
        this.f533157g = r105;
    }
}
