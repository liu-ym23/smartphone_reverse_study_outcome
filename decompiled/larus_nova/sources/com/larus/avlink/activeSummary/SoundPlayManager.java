package com.larus.avlink.activeSummary;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.e1;
import com.larus.avlink.n1;
import com.larus.avlink.q1;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.n0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public final class SoundPlayManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f291437f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f291438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f291439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f291440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f291441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f291442e;

    public static final class a {
    }

    public interface b {
        void onBegin();

        void onEnd();

        void onError();
    }

    public interface c {
        void a();

        void b(int r100);

        void c(boolean r100);

        void onRenderStart();
    }

    public static final class d implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f291443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SoundPlayManager f291444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f291445c;

        @Override // com.larus.platform.api.n0
        public final void b(Integer r100, Integer r101) {
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
            n1.d("SummaryNotifySoundManager", "[NotificationTracer] [realPlayAudio] onCompletion");
            IVideoController r100 = this.f291444b.b();
            if (r100 == null) goto L5;
            r100.stop();
        L5:
            this.f291444b.getClass();
            b r101 = this.f291443a;
            if (r101 == null) goto L9;
            r101.onEnd();
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
            if (this.f291444b.f291442e == false) goto L9;
            n1.d("SummaryNotifySoundManager", "[realPlayAudio] stop requested before render, stop now");
            IVideoController r100 = this.f291444b.b();
            if (r100 == null) goto L7;
            r100.stop();
        L7:
            this.f291444b.getClass();
            return;
        L9:
            b r101 = this.f291443a;
            if (r101 == null) goto L12;
            r101.onBegin();
        L12:
            c r102 = this.f291445c;
            if (r102 == null) goto L15;
            r102.onRenderStart();
        L15:
            n1.b("SummaryNotifySoundManager", "[realPlayAudio] onRenderStart");
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            n1.b("SummaryNotifySoundManager", "[realPlayAudio] onError");
            b r102 = this.f291443a;
            if (r102 == null) goto L5;
            r102.onError();
        L5:
            this.f291444b.getClass();
            c r103 = this.f291445c;
            if (r103 == null) goto L12;
            if (r100 == null) goto L9;
            int r104 = r100.intValue();
        L10:
            r103.b(r104);
            return;
        L9:
            r104 = -2;
            goto L10
        }

        public d(b r100, SoundPlayManager r101, c r102) {
            this.f291443a = r100;
            this.f291444b = r101;
            this.f291445c = r102;
        }
    }

    static {
    }

    public final void h() {
        this.f291442e = true;
        BuildersKt.launch$default((CoroutineScope) this.f291441d.getValue(), null, null, new SoundPlayManager$stop$1(this, null), 3, null);
    }

    public final IVideoController b() {
        return (IVideoController) this.f291438a.getValue();
    }

    public SoundPlayManager() {
        this.f291438a = LazyKt.lazy(new p());
        this.f291439b = LazyKt.lazy(new q());
        this.f291440c = LazyKt.lazy(new r());
        this.f291441d = LazyKt.lazy(new s(this));
    }

    public final void f(String r110, e1 r111) {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        n1.b("SummaryNotifySoundManager", "[playAudio] startPlayLocalFile filePath is empty");
        r111.onError();
        return;
    L9:
        this.f291442e = false;
        BuildersKt.launch$default((CoroutineScope) this.f291441d.getValue(), null, null, new SoundPlayManager$startPlayLocalFile$1(this, r110, r111, true, null), 3, null);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void c(String r100, b r101, boolean r102, c r103) {
        if (r102 == false) goto L5;
    L11:
        n1.d("SummaryNotifySoundManager", "playMusic");
        if (this.f291442e == false) goto L15;
        n1.d("SummaryNotifySoundManager", "[realPlayAudio] stop requested before play, skip");
        return;
    L15:
        IVideoController r104 = b();
        if (r104 == null) goto L18;
        r104.setLocalURL(r100);
    L18:
        IVideoController r105 = b();
        if (r105 == null) goto L21;
        r105.setLooping(false);
    L21:
        IVideoController r106 = b();
        if (r106 == null) goto L24;
        r106.p(new d(r101, this, r103));
    L24:
        if (r103 == null) goto L26;
        r103.a();
    L26:
        IVideoController r107 = b();
        if (r107 == null) goto L30;
        r107.play();
        return;
    L30:
        return;
    L5:
        if (ia8.e.b().b() == true) goto L11;
        IVideoController r108 = b();
        if (r108 == null) goto L9;
        r108.stop();
    L9:
        n1.b("SummaryNotifySoundManager", "[realPlayAudio] is not connect");
    }

    public static final Object a(SoundPlayManager r100, String r101, String r102, Context r103, Continuation r104) {
        r100.getClass();
        if ((r104 instanceof SoundPlayManager$initCheckFile$1) == false) goto L7;
        SoundPlayManager$initCheckFile$1 r105 = (SoundPlayManager$initCheckFile$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L16;
        if (r109 != 1) goto L15;
        String r110 = (String) r105.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L24
    L29:
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r107);
        PolarisFileWrapper r111 = new PolarisFileWrapper(r102);     // Catch: Exception -> L24
        if (r111.exists() == false) goto L20;
        n1.d("SummaryNotifySoundManager", "initCheckFile local cache valid, assetName=" + r101);     // Catch: Exception -> L24
        return Boxing.boxBoolean(true);
    L20:
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Exception -> L24
        SoundPlayManager$initCheckFile$2 r113 = new SoundPlayManager$initCheckFile$2(r111, r103, r101, null);     // Catch: Exception -> L24
        r105.L$0 = r101;     // Catch: Exception -> L24
        r105.label = 1;     // Catch: Exception -> L24
        r107 = BuildersKt.withContext(r112, r113, r105);     // Catch: Exception -> L24
        if (r107 != r108) goto L29;
        return r108;
    L24:
        e = move-exception;
        n1.b("SummaryNotifySoundManager", "initCheckFile error, assetName=" + r101 + ", type=" + e.getClass().getSimpleName());
        return Boxing.boxBoolean(false);
    L7:
        r105 = new SoundPlayManager$initCheckFile$1(r100, r104);
        goto L8
    }

    public static /* synthetic */ void e(SoundPlayManager r100, Context r101, String r102, boolean r103, b r110) {
        r100.d(r101, r102, r103, r110, null);
    }

    public final void d(Context r110, String r111, boolean r112, b r113, c r114) {
        Intrinsics.checkNotNullParameter(r111, "assetName");
        if (r110 != null) goto L6;
        n1.a("SummaryNotifySoundManager", "[playAudio] startPlay context is null");
        return;
    L6:
        this.f291442e = false;
        BuildersKt.launch$default((CoroutineScope) this.f291439b.getValue(), null, null, new SoundPlayManager$startPlay$1(r111, this, r110, r114, r113, r112, null), 3, null);
    }

    public final void g(Context r110, String r111, String r210, b r211, q1.b r212) {
        Intrinsics.checkNotNullParameter(r111, "assetName");
        Intrinsics.checkNotNullParameter(r210, "geckoFileName");
        Intrinsics.checkNotNullParameter("com_flow_dora_netural_wakeup", "geckoChannel");
        if (r110 != null) goto L6;
        n1.a("SummaryNotifySoundManager", "[playAudio] startPlayWithGecko context is null");
        return;
    L6:
        this.f291442e = false;
        BuildersKt.launch$default((CoroutineScope) this.f291439b.getValue(), null, null, new SoundPlayManager$startPlayWithGecko$1(this, r210, "com_flow_dora_netural_wakeup", r212, r111, r110, true, r211, null), 3, null);
    }
}
