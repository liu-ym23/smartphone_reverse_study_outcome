package com.larus.canvas.feature.component.logic;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$reportSubCanvasCancel$1", f = "GenImagePlannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$reportSubCanvasCancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $canvasId;
    final /* synthetic */ String $reason;
    final /* synthetic */ List<ky8.f> $toCancelTasks;
    int label;

    public GenImagePlannerComponent$reportSubCanvasCancel$1(List<ky8.f> r100, Long r101, String r102, Continuation<? super GenImagePlannerComponent$reportSubCanvasCancel$1> r103) {
        this.$toCancelTasks = r100;
        this.$canvasId = r101;
        this.$reason = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GenImagePlannerComponent$reportSubCanvasCancel$1(this.$toCancelTasks, this.$canvasId, this.$reason, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GenImagePlannerComponent$reportSubCanvasCancel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r100);
        List<ky8.f> r101 = this.$toCancelTasks;
        Long r102 = this.$canvasId;
        String r103 = this.$reason;
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L24;
        ky8.f r105 = (ky8.f) r104.next();
        String r106 = null;
        if (r102 == null) goto L10;
        String r107 = r102.toString();
    L11:
        String r108 = r105.f506697a;
        ky8.h r109 = r105.f506699c;
        if ((r109 instanceof ky8.f) == false) goto L14;
        ky8.f r110 = (ky8.f) r109;
    L15:
        if (r110 == null) goto L17;
        r106 = r110.f506697a;
    L17:
        JSONObject r111 = new JSONObject();
        Intrinsics.checkNotNullParameter(r111, "params");
        r111.putOpt("canvas_id", r107);     // Catch: JSONException -> L20
        r111.putOpt("local_id", r108);     // Catch: JSONException -> L20
        r111.putOpt("based_local_id", r106);     // Catch: JSONException -> L20
        r111.putOpt("reason", r103);     // Catch: JSONException -> L20
    L22:
        TrackParams r112 = new TrackParams().merge(r111);
        by7.a r113 = new by7.a("ai_generate_sub_canvas_cancel");
        r113.f21463a.merge(r112);
        r113.b();
    L20:
        e = move-exception;
        FLogger.f375446a.e("mobAIGenerateSubCanvasCancel", "error: " + e.getLocalizedMessage());
        goto L22
    L14:
        r110 = null;
        goto L15
    L10:
        r107 = null;
        goto L11
    L24:
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
