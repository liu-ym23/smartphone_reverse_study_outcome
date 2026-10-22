package com.bytedance.awemeopen.apps.framework.player;

import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.base.player.PlayState;
import com.bytedance.awemeopen.infra.base.player.g;
import com.bytedance.awemeopen.infra.base.player.j;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FeedPlayerHelper implements p54.b {
    public final g a;
    public final CopyOnWriteArrayList<k> b;
    public final Lazy c;
    public c d;
    public boolean e;
    public final DiscardFirstValueLiveData<b> f;
    public final DiscardFirstValueLiveData<b> g;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper$b$b, reason: collision with other inner class name */
        public static final class C0101b extends b {
            public static final C0101b a = null;

            static {
                a = new C0101b();
            }

            public C0101b() {
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public b() {
        }
    }

    public interface c {
        void a();
    }

    static {
    }

    public final g e() {
        g r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (g) this.c.getValue();
    }

    public final void pausePlayer() {
        this.f.setValue(b.C0101b.a);
        e().pause();
    }

    public final void playPlayer() {
        this.f.setValue(b.c.a);
        e().resume();
    }

    public static void d() {
        if (StringsKt.equals(ThreadMethodProxy.currentThread().getName(), "main", true) == true) goto L6;
        AoNpthService r0 = AoExceptionReporter.a;
        AoExceptionReporter.a(ErrorPriority.p0, "feedplayerhelper", "thread", "process listeners not in main Thread", new Exception("t"));
        return;
    }

    public final boolean a() {
        if (e().getPlayState() != PlayState.STATE_PAUSE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (e().getPlayState() != PlayState.STATE_RESET) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean playerIsPlaying() {
        if (e().getPlayState() != PlayState.STATE_START) goto L5;
    L10:
        return true;
    L5:
        if (e().getPlayState() == PlayState.STATE_RESET) goto L10;
        if (e().getPlayState() == PlayState.STATE_PREPARE) goto L10;
        return false;
    }

    public FeedPlayerHelper(g r2) {
        this.a = r2;
        this.b = new CopyOnWriteArrayList();
        this.c = LazyKt.lazy(new FeedPlayerHelper$_sharedPlayer$2(this));
        DiscardFirstValueLiveData<b> r3 = new DiscardFirstValueLiveData(b.a.a);
        this.f = r3;
        this.g = r3;
    }

    public static j i(r14.c r1) {
        Intrinsics.checkNotNullParameter(r1, "aweme");
        d14.a r0 = b14.a.a;
        return b14.a.a(e34.a.class).Z2(r1);
    }

    public final void c(k r2) {
        Intrinsics.checkNotNullParameter(r2, "statusListener");
        d();
        if (this.b.contains(r2) == true) goto L6;
        this.b.add(r2);
        return;
    }

    public final void g(k r2) {
        Intrinsics.checkNotNullParameter(r2, "statusListener");
        d();
        this.b.remove(r2);
    }

    public static void h(ErrorPriority r2, String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "priority");
        Intrinsics.checkNotNullParameter(AosPagerListViewModel.API_TYPE_FEED, "bizType");
        Intrinsics.checkNotNullParameter(r3, "sign");
        Intrinsics.checkNotNullParameter(r4, "block");
        r4.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        AoNpthService r0 = AoExceptionReporter.a;
        AoExceptionReporter.a(r2, AosPagerListViewModel.API_TYPE_FEED, r3, "FeedPlayerHelper sharedPlayer  Exception", th);
    }

    public final void f(List<j> r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "preloadList");
        if (e().getPlayState() != PlayState.STATE_RELEASE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        e().j(r3, r4, r5);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
