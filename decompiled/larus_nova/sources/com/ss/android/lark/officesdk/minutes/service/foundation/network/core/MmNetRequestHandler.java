package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.lark.rustclient.api.l;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.passportc.api.y;
import com.ss.android.lark.pb.improto.Command;
import hvb.f;
import hvb.g;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmNetRequestHandler implements com.ss.android.lark.officesdk.minutes.service.foundation.network.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f433892c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f433893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f433894b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433895a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f433896b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f433897c = null;

        static {
            int[] r100 = new int[MmRecordingSource.values().length];
            r100[MmRecordingSource.FEISHU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L71:
            r100[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L85:
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L55:
            r100[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L57:
            r100[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L67:
            r100[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L79:
            r100[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L59:
            r100[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L75:
            r100[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L77:
            r100[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L69:
            r100[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L19:
            f433895a = r100;
            int[] r101 = new int[MmHttpContentType.values().length];
            r101[MmHttpContentType.JSON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L63:
            r101[MmHttpContentType.FORM_URL_ENCODED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L22:
            f433896b = r101;
            int[] r102 = new int[MmHttpMethod.values().length];
            r102[MmHttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L53:
            r102[MmHttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L65:
            r102[MmHttpMethod.PUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L73:
            r102[MmHttpMethod.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L81:
            r102[MmHttpMethod.PATCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L28:
            f433897c = r102;
        }
    }

    static {
    }

    public final <R> Result<R> e(String r100) {
        String r101 = this.f433894b.getCurrentUserId();
        if (y.a(r101) == true) goto L6;
        return null;
    L6:
        lvb.a.e("MmNetRequestHandler", "[skipNetworkRequestForAbsentUser] requestPath=" + r100 + ", userId=" + r101);
        Result.Companion r102 = Result.Companion;
        return Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(MmCustomExceptionKt.f433915b)));
    }

    public MmNetRequestHandler(l r100, MinutesUCCImpl r101) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        Intrinsics.checkNotNullParameter(r101, "userContext");
        this.f433893a = r100;
        this.f433894b = r101;
    }

    public static void f(String r100, ErrorResult r101) {
        qvb.a.f534934a.f(r100, Integer.valueOf(r101.getCode()), Integer.valueOf(r101.getStatus()), r101.getLogId(), Integer.valueOf(r101.getStatus()), "request_failed");
    }

    public static int d(String r100, String r101, int r102) {
        Lazy r103 = MmNetworkReqPath.f433890a;
        Intrinsics.checkNotNullParameter(r100, "path");
        boolean r104 = false;
        if (StringsKt.endsWith$default(r100, "/quota", false, 2, null) == false) goto L5;
    L8:
        r104 = true;
    L9:
        if (r104 == true) goto L21;
        return r102;
    L21:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(JSONObjectProtectorUtils.getInt(JSONObjectProtectorUtils.getJSONObject(new JSONObject(r101), "error"), "id")));     // Catch: Throwable -> L13
    L15:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        lvb.a.b("MmNetRequestHandler", "resolveHttpErrorBizCode failed: path=" + r100 + ", err=" + r107.getMessage());
        r106 = Integer.valueOf(r102);
    L20:
        return ((Number) r106).intValue();
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (StringsKt.endsWith$default(r100, "/upload/prepare", false, 2, null) == true) goto L8;
        if (StringsKt.endsWith$default(r100, "/upload/finish", false, 2, null) == false) goto L9;
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object c(Class<R> r100, gvb.a r101, Continuation<? super Result<? extends R>> r102) {
        if ((r102 instanceof MmNetRequestHandler$sendHttpRequest$1) == false) goto L7;
        MmNetRequestHandler$sendHttpRequest$1 r103 = (MmNetRequestHandler$sendHttpRequest$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ExecutorCoroutineDispatcher r108 = MMCoroutines.a();
        MmNetRequestHandler$sendHttpRequest$2 r109 = new MmNetRequestHandler$sendHttpRequest$2(r101, this, r100, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new MmNetRequestHandler$sendHttpRequest$1(this, r102);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendServerPbRequest$3$callback$1, java.lang.Object] */
    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object a(final Command r110, final Class<R> r111, Message<?, ?> r210, Continuation<? super Result<? extends R>> r211) {
        if ((r211 instanceof MmNetRequestHandler$sendServerPbRequest$1) == false) goto L7;
        MmNetRequestHandler$sendServerPbRequest$1 r100 = (MmNetRequestHandler$sendServerPbRequest$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmNetRequestHandler$sendServerPbRequest$1 r112 = r100;
        Object r102 = r112.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Message r104 = (Message) r112.L$2;
        Class r105 = (Class) r112.L$1;
        Command r106 = (Command) r112.L$0;
        ResultKt.throwOnFailure(r102);
    L24:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Result<R> r107 = e(r110.getName());
        if (r107 != null) goto L17;
        r112.L$0 = r110;
        r112.L$1 = r111;
        r112.L$2 = r210;
        r112.label = 1;
        final SafeContinuation r114 = new SafeContinuation(IntrinsicsKt.intercepted(r112));
        lvb.a.e("MmNetRequestHandler", "[sendServerPbRequest] handle, command: " + r110 + ", input: " + r210);
        ProtoAdapter r108 = ProtoAdapter.get(r111);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<com.squareup.wire.Message<*, *>>");
        ?? r115 = new MmNetRequestHandler$sendServerPbRequest$3$callback$1(r114, r111, this, r110);
        int r109 = g.f487369a;
        l r116 = this.f433893a;
        Intrinsics.checkNotNullParameter(r116, "rustClient");
        Intrinsics.checkNotNullParameter(r110, "command");
        Intrinsics.checkNotNullParameter(r210, "request");
        Intrinsics.checkNotNullParameter(r108, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r115, "callBack");
        Ref.ObjectRef r117 = new Ref.ObjectRef();
        r117.element = r116.h(new com.bytedance.lark.rustclient.api.d(r210.newBuilder(), r108, com.bytedance.lark.pb.basic.v1.Command.POST_GATEWAY, null, null, r110, null, 184)).a().subscribe(new f(r115, r117));
        r102 = r114.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L21:
        if (r102 != r113) goto L24;
        return r113;
    L17:
        return r107.m9458unboximpl();
    L7:
        r100 = new MmNetRequestHandler$sendServerPbRequest$1(this, r211);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendPbRequest$3$callback$1, java.lang.Object] */
    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.b
    public final <R> Object b(final com.bytedance.lark.pb.basic.v1.Command r110, final Class<R> r111, Message<?, ?> r210, Continuation<? super Result<? extends R>> r211) {
        if ((r211 instanceof MmNetRequestHandler$sendPbRequest$1) == false) goto L7;
        MmNetRequestHandler$sendPbRequest$1 r100 = (MmNetRequestHandler$sendPbRequest$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmNetRequestHandler$sendPbRequest$1 r112 = r100;
        Object r102 = r112.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Message r104 = (Message) r112.L$2;
        Class r105 = (Class) r112.L$1;
        com.bytedance.lark.pb.basic.v1.Command r106 = (com.bytedance.lark.pb.basic.v1.Command) r112.L$0;
        ResultKt.throwOnFailure(r102);
    L24:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Result<R> r107 = e(r110.getName());
        if (r107 != null) goto L17;
        r112.L$0 = r110;
        r112.L$1 = r111;
        r112.L$2 = r210;
        r112.label = 1;
        final SafeContinuation r114 = new SafeContinuation(IntrinsicsKt.intercepted(r112));
        lvb.a.e("MmNetRequestHandler", "[sendPbRequest] handle, command=" + r110 + ", userId=" + this.f433894b.getCurrentUserId() + ", rustClientHash=" + System.identityHashCode(this.f433893a) + ", input=" + r210);
        ProtoAdapter r108 = ProtoAdapter.get(r111);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<com.squareup.wire.Message<*, *>>");
        ?? r115 = new MmNetRequestHandler$sendPbRequest$3$callback$1(r114, r111, this, r110);
        int r109 = g.f487369a;
        l r116 = this.f433893a;
        Intrinsics.checkNotNullParameter(r116, "rustClient");
        Intrinsics.checkNotNullParameter(r110, "command");
        Intrinsics.checkNotNullParameter(r210, "request");
        Intrinsics.checkNotNullParameter(r108, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r115, "callBack");
        Ref.ObjectRef r117 = new Ref.ObjectRef();
        r117.element = r116.h(new com.bytedance.lark.rustclient.api.d(r210.newBuilder(), r108, r110, null, null, null, null, 248)).a().subscribe(new hvb.e(r115, r117));
        r102 = r114.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L21:
        if (r102 != r113) goto L24;
        return r113;
    L17:
        return r107.m9458unboximpl();
    L7:
        r100 = new MmNetRequestHandler$sendPbRequest$1(this, r211);
        goto L8
    }
}
