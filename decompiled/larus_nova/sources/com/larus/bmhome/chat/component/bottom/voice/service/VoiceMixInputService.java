package com.larus.bmhome.chat.component.bottom.voice.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes25.dex */
public final class VoiceMixInputService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f300461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f300462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f300463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f300464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f300465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f300466f;

    public static int d() {
        return z2.f365865a.getVoiceMixInputScene();
    }

    public final z0<g> c() {
        return (z0) this.f300464d.getValue();
    }

    public final VoiceMixInputManager.TextStreamWrapper e() {
        return (VoiceMixInputManager.TextStreamWrapper) this.f300465e.getValue();
    }

    public final VoiceMixInputManager.Timer f() {
        return (VoiceMixInputManager.Timer) this.f300466f.getValue();
    }

    public final h b() {
        VoiceMixInputManager.TextStreamWrapper r100 = e();
        r100.getClass();
        return new h(r100.f300451f + r100.f300450e, r100.f300453h, false);
    }

    public final boolean g() {
        g r100 = c().getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f300488a;
    }

    public final Job i(Function1<? super byte[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1((z0) this.f300463c.getValue(), new VoiceMixInputService$observeAudioData$1(r100)), new VoiceMixInputService$observeAudioData$2(null)), this.f300461a);
    }

    public final Job j(Function1<? super h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        VoiceMixInputManager.TextStreamWrapper r101 = e();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r101.f300448c, new VoiceMixInputManager$TextStreamWrapper$observeTextStream$1(r100)), new VoiceMixInputManager$TextStreamWrapper$observeTextStream$2(null)), r101.f300447b);
    }

    public final Job k(Function1<? super g, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(c(), new VoiceMixInputService$observeVoiceMixInputStatus$1(r100)), new VoiceMixInputService$observeVoiceMixInputStatus$2(null)), this.f300461a);
    }

    public final void l(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        int r101 = d0.f300410d;
        d0.a.a("stopVoiceMixInput");
        BuildersKt.launch$default(this.f300461a, null, null, new VoiceMixInputService$stopVoiceMixInput$1(this, r100, null), 3, null);
    }

    public VoiceMixInputService(final Context r100, CoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f300461a = r101;
        this.f300462b = LazyKt.lazy(new t());
        this.f300463c = LazyKt.lazy(new u());
        this.f300464d = LazyKt.lazy(new v());
        this.f300465e = LazyKt.lazy(new w(r100, this));
        this.f300466f = LazyKt.lazy(new x(this));
    }

    public final void h(boolean r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onBeforeStop");
        if (r100 == true) goto L5;
        ((VoiceMixInputManager) this.f300462b.getValue()).f300445c = false;
    L5:
        l(new VoiceMixInputService$interruptVoiceMixInput$1(r101, r100, this, null));
    }

    public static final Object a(VoiceMixInputService r110, String r111, boolean r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof VoiceMixInputService$configTextStream$1) == false) goto L7;
        VoiceMixInputService$configTextStream$1 r100 = (VoiceMixInputService$configTextStream$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L17:
        VoiceMixInputManager.TextStreamWrapper r115 = r110.e();
        if (r111.length() != 0) goto L20;
        boolean r116 = true;
    L21:
        if (r116 == false) goto L23;
        String r117 = AppHost.f326268a.getApplication().getString(R.string.larus_typeASR_placeholder_empty);
    L24:
        Intrinsics.checkNotNull(r117);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r111, "textContext");
        Intrinsics.checkNotNullParameter(r117, "hintContent");
        int r118 = d0.f300410d;
        d0.a.a("configTextStream: textContext=" + r111 + " hintContent=" + r117);
        r115.f300451f = r111;
        r115.f300452g = r117;
        r115.f300453h = true;
        BuildersKt.launch$default(r115.f300447b, null, null, new VoiceMixInputManager$TextStreamWrapper$tryUpdateHintTextStream$1(r115, null), 3, null);
        r115.c();
        return Unit.INSTANCE;
    L23:
        r117 = "";
        goto L24
    L20:
        r116 = false;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r110.e().f300455j = r112;
        VoiceMixInputManager.TextStreamWrapper r119 = r110.e();
        r100.L$0 = r111;
        r100.label = 1;
        if (r119.b(r100) != r102) goto L17;
        return r102;
    L7:
        r100 = new VoiceMixInputService$configTextStream$1(r110, r113);
        goto L8
    }

    public final void m(f r110, String r111, FragmentActivity r112, Function0<Unit> r113, Function0<Unit> r210, Function0<Unit> r211, Function0<Unit> r212) {
        Intrinsics.checkNotNullParameter(r110, "param");
        Intrinsics.checkNotNullParameter(r111, "textContext");
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(r113, "onBeforeStart");
        Intrinsics.checkNotNullParameter(r210, "onBeforeStop");
        Intrinsics.checkNotNullParameter(r211, "onTimeout");
        Intrinsics.checkNotNullParameter(r212, LynxVideoManagerLite.EVENT_ON_ERROR);
        int r100 = d0.f300410d;
        d0.a.a("switchVoiceInputStatus");
        if (g() == false) goto L5;
        l(new VoiceMixInputService$switchVoiceInputStatus$1(r210));
        return;
    L5:
        d0.a.a("startVoiceMixInput");
        BuildersKt.launch$default(this.f300461a, null, null, new VoiceMixInputService$startVoiceMixInput$1(this, r113, r111, r110, r112, r211, r212, r210, null), 3, null);
    }
}
