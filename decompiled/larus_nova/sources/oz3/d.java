package oz3;

import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.k;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends g04.a<jz3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a f527180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f527181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oz3.a f527182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f527183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f527184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public jz3.a f527185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s f527186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f527187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n64.c f527188m;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527189a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f527189a = r100;
        }
    }

    @Override // g04.a
    public final void g() {
        this.f527181f.f195076b = 0;
        this.f527180e.f195163c.getFeedHomeContainerSelectedIndex().observe(this.f527180e.f195165e.f195172d, this.f527184i);
        if (this.f527180e.f195163c.isInFeedPage() == false) goto L13;
        m();
        this.f527186k.b();
        s r100 = this.f527186k;
        e r101 = this.f527187l;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.f195102e = r101;
        this.f527181f.c();
        k54.c r102 = iz3.a.c(this.f527180e);
        if (r102 == null) goto L12;
        jz3.a r103 = this.f527185j;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r103 = null;
    L10:
        r102.j(new k54.b.h(r103.f501173a.c(), 2));
        return;
    L12:
        return;
    }

    @Override // g04.a
    public final void h() {
        this.f527186k.f195102e = null;
        this.f527180e.f195165e.f195172d.getLifecycle().removeObserver(this.f527182g);
        this.f527180e.f195163c.getFeedHomeContainerDeliverHiddenState().removeObserver(this.f527183h);
    }

    public final void m() {
        k r100 = this.f527181f;
        String r101 = this.f527180e.f195163c.sceneId();
        n64.c r102 = this.f527188m;
        jz3.a r103 = this.f527185j;
        String r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r103 = null;
    L5:
        a0 r105 = r103.f501173a.f535622d;
        if (r105 == null) goto L8;
        r104 = r105.a();
    L8:
        r100.getClass();
        k.a(r101, r102, r104);
    }

    public final void n() {
        k r100 = this.f527181f;
        n64.c r101 = this.f527188m;
        jz3.a r102 = this.f527185j;
        String r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r102 = null;
    L5:
        a0 r104 = r102.f501173a.f535622d;
        if (r104 == null) goto L8;
        r103 = r104.a();
    L8:
        r100.b(r101, r103);
    }

    @Override // g04.a
    public final void i() {
        n();
        this.f527180e.f195163c.getFeedHomeContainerSelectedIndex().removeObserver(this.f527184i);
        s r100 = this.f527186k;
        r100.f195100c = 0;
        r100.f195101d = 0;
        r100.f195099b.removeCallbacks(r100.f195103f);
        k54.c r101 = iz3.a.c(this.f527180e);
        if (r101 == null) goto L9;
        jz3.a r102 = this.f527185j;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r102 = null;
    L7:
        r101.j(new k54.b.i(r102.f501173a.c(), 2));
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r100) {
        jz3.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f527185j = r101;
        AoLiveService r102 = AoLive.f198644a;
        v14.a r103 = r101.f501173a.j();
        if (r103 == null) goto L6;
        String r104 = r103.a();
        if (r104 == null) goto L6;
    L7:
        this.f527188m = AoLive.a(r104);
        r101.f501173a.getClass();
        this.f527180e.f195165e.f195172d.getLifecycle().addObserver(this.f527182g);
        this.f527180e.f195163c.getFeedHomeContainerDeliverHiddenState().observe(this.f527180e.f195165e.f195172d, this.f527183h);
        return;
    L6:
        r104 = "";
        goto L7
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [oz3.a] */
    /* JADX WARN: Type inference failed for: r4v2, types: [oz3.b] */
    /* JADX WARN: Type inference failed for: r4v3, types: [oz3.c] */
    public d(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r101, "liveEventRecorder");
        super(r100.f195161a);
        this.f527180e = r100;
        this.f527181f = r101;
        this.f527182g = new oz3.a(this);
        this.f527183h = new b(this);
        this.f527184i = new c(this);
        Long r102 = r100.f195163c.timeOnLiveRoom();
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        this.f527186k = new s(r103);
        this.f527187l = new e(this);
        return;
    L5:
        r103 = 100000;
        goto L6
    }
}
