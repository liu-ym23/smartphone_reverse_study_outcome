package oz3;

import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.k;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.s;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final k f;
    public final oz3.a g;
    public final b h;
    public final c i;
    public jz3.a j;
    public final s k;
    public final e l;
    public n64.c m;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // g04.a
    public final void g() {
        this.f.b = 0;
        this.e.c.getFeedHomeContainerSelectedIndex().observe(this.e.e.d, this.i);
        if (this.e.c.isInFeedPage() == false) goto L13;
        m();
        this.k.b();
        s r0 = this.k;
        e r1 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.e = r1;
        this.f.c();
        k54.c r2 = iz3.a.c(this.e);
        if (r2 == null) goto L12;
        jz3.a r3 = this.j;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L10:
        r2.j(new k54.b.h(r3.a.c(), 2));
        return;
    L12:
        return;
    }

    @Override // g04.a
    public final void h() {
        this.k.e = null;
        this.e.e.d.getLifecycle().removeObserver(this.g);
        this.e.c.getFeedHomeContainerDeliverHiddenState().removeObserver(this.h);
    }

    public final void m() {
        k r0 = this.f;
        String r1 = this.e.c.sceneId();
        n64.c r2 = this.m;
        jz3.a r3 = this.j;
        String r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L5:
        a0 r5 = r3.a.d;
        if (r5 == null) goto L8;
        r4 = r5.a();
    L8:
        r0.getClass();
        k.a(r1, r2, r4);
    }

    public final void n() {
        k r0 = this.f;
        n64.c r1 = this.m;
        jz3.a r2 = this.j;
        String r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r2 = null;
    L5:
        a0 r4 = r2.a.d;
        if (r4 == null) goto L8;
        r3 = r4.a();
    L8:
        r0.b(r1, r3);
    }

    @Override // g04.a
    public final void i() {
        n();
        this.e.c.getFeedHomeContainerSelectedIndex().removeObserver(this.i);
        s r0 = this.k;
        r0.c = 0;
        r0.d = 0;
        r0.b.removeCallbacks(r0.f);
        k54.c r1 = iz3.a.c(this.e);
        if (r1 == null) goto L9;
        jz3.a r2 = this.j;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r2 = null;
    L7:
        r1.j(new k54.b.i(r2.a.c(), 2));
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r3) {
        jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.j = r4;
        AoLiveService r0 = AoLive.a;
        v14.a r1 = r4.a.j();
        if (r1 == null) goto L6;
        String r2 = r1.a();
        if (r2 == null) goto L6;
    L7:
        this.m = AoLive.a(r2);
        r4.a.getClass();
        this.e.e.d.getLifecycle().addObserver(this.g);
        this.e.c.getFeedHomeContainerDeliverHiddenState().observe(this.e.e.d, this.h);
        return;
    L6:
        r2 = "";
        goto L7
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [oz3.a] */
    /* JADX WARN: Type inference failed for: r4v2, types: [oz3.b] */
    /* JADX WARN: Type inference failed for: r4v3, types: [oz3.c] */
    public d(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3, k r4) {
        Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r4, "liveEventRecorder");
        super(r3.a);
        this.e = r3;
        this.f = r4;
        this.g = new oz3.a(this);
        this.h = new b(this);
        this.i = new c(this);
        Long r5 = r3.c.timeOnLiveRoom();
        if (r5 == null) goto L5;
        long r0 = r5.longValue();
    L6:
        this.k = new s(r0);
        this.l = new e(this);
        return;
    L5:
        r0 = 100000;
        goto L6
    }
}
