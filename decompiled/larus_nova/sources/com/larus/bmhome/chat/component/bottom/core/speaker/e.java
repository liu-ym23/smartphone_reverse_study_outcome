package com.larus.bmhome.chat.component.bottom.core.speaker;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f299397k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f299398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f299399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f299400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f299401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<c> f299402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f299403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f299404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f299405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f299406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f299407j;

    public static final class a {
    }

    public interface b {
        void A9();

        void B9(f r100);

        void C9(f r100);

        void D9(Function1<? super String, Boolean> r100);
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f299408a = null;

            static {
                f299408a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f299409a = null;

            static {
                f299409a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.speaker.e$c$c, reason: collision with other inner class name */
        public static final class C4034c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4034c f299410a = null;

            static {
                f299410a = new C4034c();
            }

            public C4034c() {
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f299411a = null;

            static {
                f299411a = new d();
            }

            public d() {
            }
        }

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.speaker.e$c$e, reason: collision with other inner class name */
        public static final class C4035e extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4035e f299412a = null;

            static {
                f299412a = new C4035e();
            }

            public C4035e() {
            }
        }

        public static final class f extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f299413a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f299413a, ((f) r100).f299413a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f299413a.hashCode();
            }

            public final String toString() {
                return "StreamResult(text=" + this.f299413a + ')';
            }

            public f(String r100) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f299413a = r100;
            }
        }

        public static final class g extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f299414a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f299415b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f299416c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof g) == true) goto L8;
                return false;
            L8:
                g r101 = (g) r100;
                if (Intrinsics.areEqual(this.f299414a, r101.f299414a) == true) goto L12;
                return false;
            L12:
                if (this.f299415b == r101.f299415b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f299416c, r101.f299416c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f299414a.hashCode() * 31) + this.f299415b) * 31;
                String r101 = this.f299416c;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Success(text=" + this.f299414a + ", streamResultLength=" + this.f299415b + ", asrLogId=" + this.f299416c + ')';
            }

            public g(String r100, int r101, String r102) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f299414a = r100;
                this.f299415b = r101;
                this.f299416c = r102;
            }
        }

        public static final class h extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final h f299417a = null;

            static {
                f299417a = new h();
            }

            public h() {
            }
        }

        public c() {
        }
    }

    static {
    }

    public final void a() {
        if (this.f299403f == false) goto L6;
        FLogger.f375446a.w("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][begin] skipped, lifecycle already running");
        return;
    L6:
        FLogger.f375446a.i("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][begin]");
        this.f299403f = true;
        this.f299404g = -1;
        this.f299398a.B9(this.f299407j);
        this.f299398a.D9(new com.larus.bmhome.chat.component.bottom.core.speaker.c());
        c(c.C4034c.f299410a);
    }

    public final void b() {
        if (this.f299403f == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][cancel]");
        this.f299398a.A9();
    }

    public final void f() {
        if (this.f299403f == true) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][onPressUp]");
        c(c.d.f299411a);
        if (this.f299406i == true) goto L8;
        r100.i("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][onPressUp] asr not started, cancel");
        c(c.a.f299408a);
        d("asr_not_started");
        return;
    L8:
        Job r101 = this.f299405h;
        if (r101 == null) goto L11;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L11:
        this.f299405h = null;
        this.f299405h = BuildersKt.launch$default(this.f299399b, null, null, new ChatSpeakerPressLifecycle$startTimer$1(this, null), 3, null);
    }

    public final void c(c r100) {
        if (this.f299402e.tryEmit(r100) == true) goto L6;
        FLogger.f375446a.w("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][tryEmit] dropped " + r100);
        return;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f299403f == true) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ChatSpeakerPressLifecycle", "[" + this.f299401d + "][end] lifecycle reason=" + r100);
        this.f299403f = false;
        this.f299404g = -1;
        this.f299406i = false;
        Job r101 = this.f299405h;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f299405h = null;
        this.f299398a.C9(this.f299407j);
        this.f299398a.D9(new d());
    }

    public final void e(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(this.f299402e, new ChatSpeakerPressLifecycle$observe$1(r100)), new ChatSpeakerPressLifecycle$observe$2(this, null)), this.f299399b);
    }

    public e(b r100, LifecycleCoroutineScope r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "tag");
        this.f299398a = r100;
        this.f299399b = r101;
        this.f299400c = 300000;
        this.f299401d = r102;
        this.f299402e = SharedFlowKt.MutableSharedFlow$default(0, 16, null, 4, null);
        this.f299404g = -1;
        this.f299407j = new f(this);
    }
}
