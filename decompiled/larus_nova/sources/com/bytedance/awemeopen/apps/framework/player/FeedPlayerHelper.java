package com.bytedance.awemeopen.apps.framework.player;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.base.player.PlayState;
import com.bytedance.awemeopen.infra.base.player.g;
import com.bytedance.awemeopen.infra.base.player.j;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public class FeedPlayerHelper implements p54.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f197242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<k> f197243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f197244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f197245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f197246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DiscardFirstValueLiveData<b> f197247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DiscardFirstValueLiveData<b> f197248g;

    public static final class a {
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f197250a = null;

            static {
                f197250a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper$b$b, reason: collision with other inner class name */
        public static final class C2828b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2828b f197251a = null;

            static {
                f197251a = new C2828b();
            }

            public C2828b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f197252a = null;

            static {
                f197252a = new c();
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
        g r100 = this.f197242a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (g) this.f197244c.getValue();
    }

    @Override // p54.b
    public final void pausePlayer() {
        this.f197247f.setValue(b.C2828b.f197251a);
        e().pause();
    }

    @Override // p54.b
    public final void playPlayer() {
        this.f197247f.setValue(b.c.f197252a);
        e().resume();
    }

    public static void d() {
        if (StringsKt.equals(ThreadMethodProxy.currentThread().getName(), PullConfiguration.PROCESS_NAME_MAIN, true) == true) goto L6;
        AoNpthService r100 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(ErrorPriority.f198710p0, "feedplayerhelper", "thread", "process listeners not in main Thread", new Exception("t"));
        return;
    }

    @Override // p54.b
    public final boolean a() {
        if (e().getPlayState() != PlayState.STATE_PAUSE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // p54.b
    public final boolean b() {
        if (e().getPlayState() != PlayState.STATE_RESET) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // p54.b
    public final boolean playerIsPlaying() {
        if (e().getPlayState() != PlayState.STATE_START) goto L5;
    L10:
        return true;
    L5:
        if (e().getPlayState() == PlayState.STATE_RESET) goto L10;
        if (e().getPlayState() == PlayState.STATE_PREPARE) goto L10;
        return false;
    }

    public FeedPlayerHelper(g r100) {
        this.f197242a = r100;
        this.f197243b = new CopyOnWriteArrayList();
        this.f197244c = LazyKt.lazy(new FeedPlayerHelper$_sharedPlayer$2(this));
        DiscardFirstValueLiveData<b> r101 = new DiscardFirstValueLiveData(b.a.f197250a);
        this.f197247f = r101;
        this.f197248g = r101;
    }

    public static j i(r14.c r100) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        d14.a r101 = b14.a.f16924a;
        return ((e34.a) b14.a.a(e34.a.class)).Z2(r100);
    }

    public final void c(k r100) {
        Intrinsics.checkNotNullParameter(r100, "statusListener");
        d();
        if (this.f197243b.contains(r100) == true) goto L6;
        this.f197243b.add(r100);
        return;
    }

    public final void g(k r100) {
        Intrinsics.checkNotNullParameter(r100, "statusListener");
        d();
        this.f197243b.remove(r100);
    }

    public static void h(ErrorPriority r100, String r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "priority");
        Intrinsics.checkNotNullParameter("feed", "bizType");
        Intrinsics.checkNotNullParameter(r101, "sign");
        Intrinsics.checkNotNullParameter(r102, "block");
        r102.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        AoNpthService r103 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(r100, "feed", r101, "FeedPlayerHelper sharedPlayer  Exception", th);
    }

    public final void f(List<j> r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "preloadList");
        if (e().getPlayState() != PlayState.STATE_RELEASE) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        e().j(r100, r101, r102);
        return;
    L9:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
