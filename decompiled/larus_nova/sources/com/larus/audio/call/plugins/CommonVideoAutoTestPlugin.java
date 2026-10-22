package com.larus.audio.call.plugins;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.im.service.audio.ILLMVideoStreamIndex;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public final class CommonVideoAutoTestPlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements x0, w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f289392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f289393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f289394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f289395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f289396j;

    public static final class a implements com.larus.im.service.audio.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonVideoAutoTestPlugin f289397a;

        public a(CommonVideoAutoTestPlugin r100) {
            this.f289397a = r100;
        }

        @Override // com.larus.im.service.audio.w
        public final com.larus.im.service.audio.u a(ILLMVideoStreamIndex r100, com.larus.im.service.audio.u r101) {
            Intrinsics.checkNotNullParameter(r100, "streamIndex");
            if (r101 != null) goto L5;
            return r101;
        L5:
            int r102 = com.larus.im.a.f346406a;
            gd9.o r103 = com.larus.im.internal.d.f347913a;
            com.larus.im.internal.audio.u.f347501c.getClass();
            com.larus.im.internal.utils.x r104 = com.larus.im.internal.utils.x.f350563a;
            com.larus.im.internal.utils.x.f350566d.getClass();
            if (r100 != ILLMVideoStreamIndex.STREAM_INDEX_MAIN) goto L8;
            ((com.larus.audio.call.l) this.f289397a.f289392f.getValue()).b(r101);
        L8:
            com.larus.im.internal.utils.x.f350568f.getClass();
            if (r100 != ILLMVideoStreamIndex.STREAM_INDEX_SCREEN) goto L11;
            ((com.larus.audio.call.l) this.f289397a.f289393g.getValue()).b(r101);
        L11:
            return r101;
        }
    }

    @Override // com.larus.audio.call.plugins.w0
    public final void J2() {
        com.larus.audio.call.util.e.f289645a.i(this.f289396j, "[onEnterScreenShare] needRegisterScreenShareProcessor: " + this.f289394h);
        if (this.f289394h == false) goto L10;
        id9.d r100 = getContext().j();
        if (r100 == null) goto L9;
        com.larus.im.service.audio.y r101 = r100.a();
        if (r101 == null) goto L9;
        r101.q();
    L9:
        this.f289394h = false;
    L10:
        ((com.larus.audio.call.l) this.f289393g.getValue()).a();
    }

    @Override // com.larus.audio.call.plugins.x0
    public final void Q1() {
        com.larus.audio.call.util.e.f289645a.i(this.f289396j, "onExitCallVideo");
        CoroutineScope r100 = getContext().r();
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, null, null, new CommonVideoAutoTestPlugin$onExitCallVideo$1(this, null), 3, null);
        return;
    }

    @Override // com.larus.audio.call.plugins.w0
    public final void S() {
        com.larus.audio.call.util.e.f289645a.i(this.f289396j, "onExitScreenShare");
        CoroutineScope r100 = getContext().r();
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, null, null, new CommonVideoAutoTestPlugin$onExitScreenShare$1(this, null), 3, null);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        com.larus.audio.call.util.e.f289645a.i(this.f289396j, "onRelease");
        id9.d r100 = getContext().j();
        if (r100 == null) goto L7;
        com.larus.im.service.audio.z r101 = r100.e();
        if (r101 == null) goto L7;
        r101.q(null);
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CommonVideoAutoTestPlugin$onRelease$1(this, null), 3, null);
    }

    @Override // com.larus.audio.call.plugins.x0
    public final void k2() {
        com.larus.audio.call.util.e.f289645a.i(this.f289396j, "[onEnterCallVideo] needRegisterVideoCallProcessor: " + this.f289395i);
        ((com.larus.audio.call.l) this.f289392f.getValue()).a();
        CoroutineScope r100 = getContext().r();
        if (this.f289395i == false) goto L7;
        if (r100 == null) goto L8;
        this.f289395i = false;
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new CommonVideoAutoTestPlugin$onEnterCallVideo$1(this, null), 2, null);
        return;
    L8:
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        com.larus.audio.call.util.e.f289645a.i(this.f289396j, WidgetCostModule.TYPE_ON_START);
        id9.d r100 = getContext().j();
        if (r100 == null) goto L8;
        com.larus.im.service.audio.z r101 = r100.e();
        if (r101 == null) goto L9;
        r101.q(new a(this));
        return;
    L9:
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f289396j;
    }

    public CommonVideoAutoTestPlugin(final com.larus.audio.call.arch.c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f289392f = LazyKt.lazy(new n0(r100));
        this.f289393g = LazyKt.lazy(new o0(r100));
        this.f289394h = true;
        this.f289395i = true;
        this.f289396j = "CommonVideoDumpPlugin";
    }
}
