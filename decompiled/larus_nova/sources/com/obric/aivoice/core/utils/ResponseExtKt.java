package com.obric.aivoice.core.utils;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import com.obric.aivoice.core.data.IdlErrors;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.sdk.response.Response;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a,\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a+\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\n\u001a\u0004\u0018\u0001H\u00022\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006\u001a\u0012\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a:\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00150\u00012\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0015\u0012\u0006\u0012\u0004\u0018\u0001H\u00140\u0017\u001a\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0019\u001a\u0010\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u0019\u001a0\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00192\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u001d\u001a0\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00192\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u001d¨\u0006\u001f"}, d2 = {"newErr", "Lcom/obric/aivoice/sdk/response/Response;", ExifInterface.GPS_DIRECTION_TRUE, "errorCode", "", "errorInfo", "", "newFlowErr", "Lkotlinx/coroutines/flow/Flow;", "newRes", "data", "isFinish", "", "(Ljava/lang/Object;Z)Lcom/obric/aivoice/sdk/response/Response;", "toClassCastErrorResponse", "toErrorResponse", "code", "msg", "toNullResponse", "map", "Tt", "Ts", "block", "Lkotlin/Function1;", "toBasicTypeResponse", "Landroid/os/Bundle;", "toJsonResult", "Lorg/json/JSONObject;", "toNetResponse", "Lkotlin/Function2;", "toUserResponse", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ResponseExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.ResponseExtKt$newFlowErr$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/aivoice/sdk/response/Response;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.aivoice.core.utils.ResponseExtKt$newFlowErr$1", f = "ResponseExt.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super Response<T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $errorCode;
        final /* synthetic */ String $errorInfo;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(int r100, String r101, Continuation<? super AnonymousClass1> r102) {
            this.$errorCode = r100;
            this.$errorInfo = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$errorCode, this.$errorInfo, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke((FlowCollector) r100, r101);
        }

        public final Object invoke(FlowCollector<? super Response<T>> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            FlowCollector r103 = (FlowCollector) this.L$0;
            Response r104 = ResponseExtKt.newErr(this.$errorCode, this.$errorInfo);
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public static final <T> Response<T> toClassCastErrorResponse() {
        return new Response(101, "invalid type cast.", null, false, false, null, 56, null);
    }

    public static final <T> Response<T> toNullResponse() {
        return new Response(-1, AMapException.AMAP_CLIENT_UNKNOWN_ERROR, null, false, false, null, 56, null);
    }

    public static final <T> Response<T> toBasicTypeResponse(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new Response(r100.getInt(IdlKeys.ErrorCode, 0), r100.getString(IdlKeys.ErrorInfo), r100.get(IdlKeys.Result), r100.getBoolean(IdlKeys.IsFinish, true), r100.getBoolean(IdlKeys.IsTaskId, false), r100.getBundle(IdlKeys.Args_TimeLog));
    }

    public static final Response<JSONObject> toJsonResult(Bundle r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = r110.getInt(IdlKeys.ErrorCode, 0);
        String r101 = r110.getString(IdlKeys.ErrorInfo);
        Bundle r102 = r110.getBundle(IdlKeys.Result);
        if (r102 != null) goto L6;
        r102 = new Bundle();
    L6:
        return new Response(r100, r101, BundleExtKt.bundle2json(r102), r110.getBoolean(IdlKeys.IsFinish, true), r110.getBoolean(IdlKeys.IsTaskId, false), null, 32, null);
    }

    public static final <Ts, Tt> Response<Tt> map(Response<Ts> r100, Function1<? super Ts, ? extends Tt> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        return new Response(r100.getErrorCode(), r100.getErrorInfo(), r101.invoke(r100.getData()), r100.isFinish(), r100.isTaskId(), r100.getTimeLog());
    }

    public static final <T> Response<T> newErr(int r100, String r110) {
        if (r110 != null) goto L5;
        r110 = IdlErrors.INSTANCE.getDefaultErrInfo().get(Integer.valueOf(r100));
    L5:
        return new Response(r100, r110, null, true, false, null, 32, null);
    }

    public static final <T> Flow<Response<T>> newFlowErr(int r100, String r101) {
        return new c1(new AnonymousClass1(r100, r101, null));
    }

    public static final <T> Response<T> newRes(T r110, boolean r111) {
        if (r111 == false) goto L6;
        return new Response(0, null, r110, r111, false, null, 32, null);
    L6:
        return new Response(1, null, r110, r111, false, null, 32, null);
    }

    public static final <T> Response<T> toErrorResponse(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "msg");
        return new Response(r110, r111, null, false, false, null, 56, null);
    }

    public static final <T> Response<T> toNetResponse(Bundle r110, Function2<? super Bundle, ? super String, ? extends T> r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "block");
        int r100 = r110.getInt(IdlKeys.ErrorCode, -1);
        String r101 = r110.getString(IdlKeys.ErrorInfo);
        boolean r102 = r110.getBoolean(IdlKeys.IsFinish, true);
        boolean r103 = r110.getBoolean(IdlKeys.IsTaskId, false);
        return new Response(r100, r101, r111.invoke(r110, IdlKeys.Result), r102, r103, null, 32, null);
    }

    public static final <T> Response<T> toUserResponse(Bundle r110, Function2<? super Bundle, ? super String, ? extends T> r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "block");
        int r100 = r110.getInt(IdlKeys.ErrorCode, 0);
        String r101 = r110.getString(IdlKeys.ErrorInfo);
        boolean r102 = r110.getBoolean(IdlKeys.IsFinish, true);
        boolean r103 = r110.getBoolean(IdlKeys.IsTaskId, false);
        return new Response(r100, r101, r111.invoke(r110, IdlKeys.Result), r102, r103, null, 32, null);
    }

    public static /* synthetic */ Response newErr$default(int r100, String r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return newErr(r100, r101);
    }

    public static /* synthetic */ Flow newFlowErr$default(int r100, String r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return newFlowErr(r100, r101);
    }

    public static /* synthetic */ Response newRes$default(Object r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = true;
    L6:
        return newRes(r100, r101);
    }
}
