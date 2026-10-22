package lh6;

import com.bytedance.android.live.liveinteract.plantform.camera.SwitchCameraManager;
import com.bytedance.android.live.liveinteract.utils.b1;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.live.bizlink.api.platform.status.common.LinkBizApiLocalException;
import com.bytedance.live.bizlink.api.platform.status.event.StatusEventCategory;
import java.util.HashSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ng6.d;
import yb6.e;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ng6.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f509263i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f509264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ng6.b f509265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final lh6.a f509266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ng6.a f509267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1 f509268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, String> f509269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f509270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final mg6.a f509271h;

    public static final class a {
    }

    /* JADX INFO: renamed from: lh6.b$b, reason: collision with other inner class name */
    public static final class C6695b implements lg6.a<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f509272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoShowMode f509273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ lg6.a f509274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VideoShowMode f509275d;

        @Override // lg6.a
        public final void a(Unit r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            lh6.a r101 = this.f509272a.f509266c;
            VideoShowMode r102 = this.f509273b;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f509262b = r102;
            b r103 = this.f509272a;
            r103.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.C6925d.f519082b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("localStatus", r103.f509266c.f509261a), TuplesKt.to("realStatus", this.f509272a.f509266c.f509262b)})));
            this.f509274c.a(r100);
        }

        @Override // lg6.a
        public final void onFailed(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            int r101 = b.f509263i;
            jy0.b.c("VideoStatusController", "videoShowModeSwitcher openShowMode failed.", null, 4);
            lh6.a r102 = this.f509272a.f509266c;
            VideoShowMode r103 = this.f509275d;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r102.f509261a = r103;
            this.f509274c.onFailed(r100);
        }

        public C6695b(b r100, VideoShowMode r101, lg6.a r102, VideoShowMode r103) {
            this.f509272a = r100;
            this.f509273b = r101;
            this.f509274c = r102;
            this.f509275d = r103;
        }
    }

    static {
    }

    public final int b() {
        return this.f509270g.J();
    }

    public final boolean c() {
        boolean r100 = this.f509270g.m0();
        jy0.b.a("VideoStatusController", "hasLocalStartVideoCapture : " + r100);
        return r100;
    }

    public final boolean d() {
        ng6.a r100 = this.f509267d;
        if (r100 != null) goto L5;
        jy0.b.f("VideoStatusController", "camera switcher is empty so return false", null, 4);
        return false;
    L5:
        return r100.l5();
    }

    public final boolean e() {
        return !this.f509270g.a0(StreamType.VIDEO);
    }

    public final void l() {
        Intrinsics.checkNotNullParameter("force open camera", "reason");
        jy0.b.d("VideoStatusController", "use last videoCapture " + this.f509269f.getFirst().intValue() + ", which record by " + this.f509269f.getSecond() + ", current reason: force open camera,");
        n(this.f509269f.getFirst().intValue(), false, "force open camera");
    }

    public final void m() {
        Intrinsics.checkNotNullParameter("videotalkroom anchorwidget forceReverseCamera", "reason");
        jy0.b.d("VideoStatusController", "switchVideoCapture for videotalkroom anchorwidget forceReverseCamera");
        this.f509270g.o();
        this.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.b.f519080b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("hasLocalStartVideoCapture", Boolean.valueOf(c())), TuplesKt.to("currentVideoCapture", Integer.valueOf(b())), TuplesKt.to("reason", "videotalkroom anchorwidget forceReverseCamera")})));
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f509269f = new Pair(Integer.valueOf(b()), r100);
        jy0.b.d("VideoStatusController", "onlyRecordCurrentVideoCapture lastVideoCapture: " + this.f509269f.getFirst().intValue() + " for " + r100);
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        jy0.b.d("VideoStatusController", "startVideoCapture for " + r100);
        this.f509270g.e();
        this.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.b.f519080b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("hasLocalStartVideoCapture", Boolean.valueOf(c())), TuplesKt.to("currentVideoCapture", Integer.valueOf(b())), TuplesKt.to("reason", r100)})));
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        jy0.b.d("VideoStatusController", "stopVideoCapture for " + r100);
        this.f509270g.d();
        this.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.b.f519080b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("hasLocalStartVideoCapture", Boolean.valueOf(c())), TuplesKt.to("currentVideoCapture", Integer.valueOf(b())), TuplesKt.to("reason", r100)})));
    }

    public b(e r100, jh6.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaManager");
        Intrinsics.checkNotNullParameter(r101, "statusEventManager");
        this.f509270g = r100;
        this.f509271h = r101;
        this.f509264a = new HashSet();
        this.f509266c = new lh6.a(0);
        this.f509268e = new b1();
        this.f509269f = new Pair(2, "default");
    }

    @Override // ng6.c
    public final void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (r100 == false) goto L5;
        this.f509270g.d0(StreamType.VIDEO, r101);
    L7:
        if (r100 == true) goto L9;
        int r102 = 1;
    L10:
        this.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.c.f519081b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("videoPublishStatus", Integer.valueOf(r102))})));
        return;
    L9:
        r102 = 2;
        goto L10
    L5:
        this.f509270g.z(StreamType.VIDEO, r101);
        goto L7
    }

    public final void o(ng6.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        jy0.b.d("VideoStatusController", "updateCameraSwitcher for ".concat(r101));
        this.f509267d = r100;
    }

    public final void p(ng6.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        jy0.b.d("VideoStatusController", "updateVideoShowModeSwitcher for ".concat(r101));
        this.f509265b = r100;
    }

    public final void f(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r101 == false) goto L5;
        this.f509270g.t(StreamType.VIDEO, r100, r102);
        this.f509264a.add(r100);
        return;
    L5:
        this.f509270g.Z(StreamType.VIDEO, r100, r102);
        this.f509264a.remove(r100);
    }

    public final void n(int r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reason");
        jy0.b.d("VideoStatusController", "switchVideoCapture to " + r100 + " for " + r102);
        if (r101 == false) goto L5;
        g(r102);
    L5:
        this.f509270g.n0(r100);
        this.f509271h.a(new mg6.b(StatusEventCategory.VIDEO, d.b.f519080b, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("hasLocalStartVideoCapture", Boolean.valueOf(c())), TuplesKt.to("currentVideoCapture", Integer.valueOf(b())), TuplesKt.to("reason", r102)})));
    }

    public final void h(VideoShowMode r100, String r101, boolean r102, lg6.a<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "showMode");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r103, "resultConsumer");
        if (r102 == true) goto L9;
        if (this.f509268e.a() == true) goto L9;
        r103.onFailed(new LinkBizApiLocalException(-10, new Exception("操作太频繁，showMode=" + r100)));
        return;
    L9:
        if (this.f509266c.f509261a.getType() == this.f509266c.f509262b.getType()) goto L12;
        jy0.b.c("VideoStatusController", "is switching another showmode " + this.f509266c.f509261a.getType() + " but not $" + r100.getType(), null, 4);
        jy0.b.c("VideoStatusController", "localstatus: " + this.f509266c.f509261a.name() + ", realstatus: " + this.f509266c.f509262b.name(), null, 4);
        r103.onFailed(new Exception("is switching another showmode " + this.f509266c.f509261a.getType() + " but not " + r100.getType()));
        return;
    L12:
        jy0.b.d("VideoStatusController", "openShowMode from " + this.f509266c.f509262b.getType() + " to " + r100.getType());
        lh6.a r104 = this.f509266c;
        VideoShowMode r105 = r104.f509261a;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r104.f509261a = r100;
        ng6.b r106 = this.f509265b;
        if (r106 == null) goto L15;
        r106.Te(r100, this.f509266c.f509262b, new C6695b(this, r100, r103, r105), r101);
        return;
    L15:
        jy0.b.c("VideoStatusController", "videoShowModeSwitcher is null! Cannot perform operation.", null, 4);
    }

    public final void k(boolean r100, boolean r101, boolean r110, boolean r111, SwitchCameraManager.f r112, String r113) {
        Intrinsics.checkNotNullParameter(r113, "reason");
        jy0.b.d("VideoStatusController", "switchCamera for ".concat(r113));
        ng6.a r102 = this.f509267d;
        if (r102 == null) goto L5;
        r102.yf(r100, r101, r110, r111, new c(this, r112));
        return;
    L5:
        jy0.b.f("VideoStatusController", "camera switcher is empty", null, 4);
    }
}
