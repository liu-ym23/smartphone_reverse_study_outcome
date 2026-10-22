package com.larus.audio.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.utils.AudioLoadManager$report$1", f = "AudioLoadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioLoadManager$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $error;
    final /* synthetic */ String $eventName;
    final /* synthetic */ String $styleId;
    final /* synthetic */ String $url;
    int label;

    public AudioLoadManager$report$1(String r100, String r101, String r102, String r103, Continuation<? super AudioLoadManager$report$1> r104) {
        this.$styleId = r100;
        this.$url = r101;
        this.$eventName = r102;
        this.$error = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioLoadManager$report$1(this.$styleId, this.$url, this.$eventName, this.$error, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AudioLoadManager$report$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        JSONObject r101 = new JSONObject();
        String r102 = this.$styleId;
        String r103 = this.$url;
        String r104 = this.$eventName;
        String r105 = this.$error;
        r101.put("id", r102);
        r101.put("url", r103);
        r101.put("event", r104);
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        r101.put("error", r105);
        r101.put("env", AppHost.f326268a.getBuildChannel());
        int r106 = com.larus.audio.report.g.f289811a;
        Intrinsics.checkNotNullParameter("tts_sample", "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r107 = new TrackParams().merge(r101);
        by7.a r108 = new by7.a("tts_sample");
        r108.f21463a.merge(r107);
        r108.b();
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
