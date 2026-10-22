package com.larus.agents.impl.network;

import androidx.exifinterface.media.ExifInterface;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.WorkExperienceRemote$post$2", f = "WorkExperienceApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WorkExperienceRemote$post$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<Object>>, Object> {
    final /* synthetic */ JSONObject $body;
    final /* synthetic */ String $path;
    final /* synthetic */ Class<Object> $responseClass;
    int label;

    public WorkExperienceRemote$post$2(Class<Object> r100, String r101, JSONObject r102, Continuation<? super WorkExperienceRemote$post$2> r103) {
        this.$responseClass = r100;
        this.$path = r101;
        this.$body = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WorkExperienceRemote$post$2(this.$responseClass, this.$path, this.$body, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super dm9.a<Object>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super dm9.a<Object>> r101) {
        return ((WorkExperienceRemote$post$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r110);
        Triple r111 = HttpExtKt.c(ServiceType.BASIC_SERVICE, this.$responseClass, this.$path, "POST", null, this.$body, MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")), true, null, null, null, 7680);
        BizResponse r100 = (BizResponse) r111.component1();
        dm9.a.C5690a r101 = (dm9.a.C5690a) r111.component2();
        Throwable r112 = (Throwable) r111.component3();
        if (r100 == null) goto L9;
        if (r112 == null) goto L9;
        return new dm9.a.C5690a(-1000, "experience response was intercepted", r112);
    L9:
        if (r100 != null) goto L17;
        if (r101 == null) goto L14;
        return r101;
    L14:
        return new dm9.a.C5690a(-1000, "experience response is empty", r112);
    L17:
        return new dm9.a.b(r100, null);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
