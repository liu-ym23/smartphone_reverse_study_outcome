package zo8;

import com.larus.bmhome.utils.c4;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4 f573145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f573146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f573147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f573148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoPlayView.a f573149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<String, IVideoController, Unit> f573150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f573151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f573152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function4<g, String, String, Function1<? super Boolean, Unit>, Unit> f573153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f573154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f573155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f573156m;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f573144a, r101.f573144a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573145b, r101.f573145b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573146c, r101.f573146c) == true) goto L18;
        return false;
    L18:
        if (this.f573147d == r101.f573147d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573148e, r101.f573148e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f573149f, r101.f573149f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f573150g, r101.f573150g) == true) goto L30;
        return false;
    L30:
        if (this.f573151h == r101.f573151h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f573152i, r101.f573152i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f573153j, r101.f573153j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f573154k, r101.f573154k) == true) goto L42;
        return false;
    L42:
        if (this.f573155l == r101.f573155l) goto L45;
        return false;
    L45:
        if (this.f573156m == r101.f573156m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f573144a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((((r102 * 31) + this.f573145b.hashCode()) * 31) + this.f573146c.hashCode()) * 31) + this.f573147d) * 31) + this.f573148e.hashCode()) * 31;
        VideoPlayView.a r104 = this.f573149f;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function2<String, IVideoController, Unit> r107 = this.f573150g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.f573151h == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((((r109 + r111) * 31) + this.f573152i.hashCode()) * 31) + this.f573153j.hashCode()) * 31;
        String r113 = this.f573154k;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f573155l == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f573156m == true) goto L31;
        r110 = 1237;
    L31:
        return r116 + r110;
    L25:
        r115 = 1237;
        goto L26
    L17:
        r111 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoContent(creationIndex=" + this.f573144a + ", eventParams=" + this.f573145b + ", videoPlayData=" + this.f573146c + ", initProgress=" + this.f573147d + ", videoEngineKey=" + this.f573148e + ", afterClickCallBack=" + this.f573149f + ", onExit=" + this.f573150g + ", showVideoExtendFunction=" + this.f573151h + ", onVideoExtendShownBlk=" + this.f573152i + ", toVideoExtendBlk=" + this.f573153j + ", creationTaskId=" + this.f573154k + ", canPublish=" + this.f573155l + ", isBlockContent=" + this.f573156m + ')';
    }

    @Override // zo8.a
    public final String a() {
        return this.f573154k;
    }

    @Override // zo8.a
    public final String b() {
        return this.f573144a;
    }

    public e(String r110, c4 r111, g r112, int r113, String r114, VideoPlayView.a r210, Function2 r211, boolean r212, Function0 r213, Function4 r214, String r215, boolean r216, boolean r217, int r218) {
        String r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 32) == 0) goto L9;
        VideoPlayView.a r102 = null;
    L11:
        if ((r218 & 64) == 0) goto L13;
        Function2 r103 = null;
    L14:
        boolean r115 = false;
        if ((r218 & 128) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r218 & 256) == 0) goto L21;
        Function0 r116 = new c();
    L23:
        if ((r218 & 512) == 0) goto L25;
        Function4 r117 = new d();
    L27:
        if ((r218 & 1024) != 0) goto L31;
        r100 = r215;
    L31:
        if ((r218 & 2048) == 0) goto L33;
        boolean r118 = true;
    L35:
        if ((r218 & 4096) != 0) goto L38;
        r115 = r217;
    L38:
        Intrinsics.checkNotNullParameter(r111, "eventParams");
        Intrinsics.checkNotNullParameter(r112, "videoPlayData");
        Intrinsics.checkNotNullParameter(r114, "videoEngineKey");
        Intrinsics.checkNotNullParameter(r116, "onVideoExtendShownBlk");
        Intrinsics.checkNotNullParameter(r117, "toVideoExtendBlk");
        this.f573144a = r101;
        this.f573145b = r111;
        this.f573146c = r112;
        this.f573147d = r113;
        this.f573148e = r114;
        this.f573149f = r102;
        this.f573150g = r103;
        this.f573151h = r104;
        this.f573152i = r116;
        this.f573153j = r117;
        this.f573154k = r100;
        this.f573155l = r118;
        this.f573156m = r115;
        return;
    L33:
        r118 = r216;
        goto L35
    L25:
        r117 = r214;
        goto L27
    L21:
        r116 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L14
    L9:
        r102 = r210;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
