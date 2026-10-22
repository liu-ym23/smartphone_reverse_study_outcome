package com.suite.lark.platform.component.cta.model;

import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.i;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class StuckSpotRequestExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f460520a;

    public StuckSpotRequestExecutor() {
        this.f460520a = LazyKt.lazy(StuckSpotRequestExecutor$larkHttp$2.INSTANCE);
    }

    public static final ErrorResult b(StuckSpotRequestExecutor r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof ErrorResult) == false) goto L6;
        return (ErrorResult) r101;
    L6:
        if ((r101 instanceof Exception) == false) goto L8;
        Exception r102 = (Exception) r101;
    L9:
        if (r102 != null) goto L11;
        r102 = new Exception(r101);
    L11:
        String r103 = r101.getMessage();
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        return new ErrorResult(r103, r102);
    L8:
        r102 = null;
        goto L9
    }

    public static final void a(StuckSpotRequestExecutor r100, i r101, com.larksuite.rucket.job.base.b r102) {
        r100.getClass();
        if (r101.isActive() == false) goto L6;
        r101.resumeWith(Result.m9449constructorimpl(r102));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r100, String r101, Map<String, String> r102, String r103, Continuation<? super com.larksuite.rucket.job.base.b<goc.b>> r104) {
        if ((r104 instanceof StuckSpotRequestExecutor$executeWithSdkSender$1) == false) goto L7;
        StuckSpotRequestExecutor$executeWithSdkSender$1 r105 = (StuckSpotRequestExecutor$executeWithSdkSender$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L14;
        if (r109 != 1) goto L13;
        d r110 = (d) r105.L$0;
        ResultKt.throwOnFailure(r107);
    L18:
        com.larksuite.rucket.job.base.b r111 = (com.larksuite.rucket.job.base.b) r107;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "<this>");
        if ((r111 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L22;
        return d.a(new String(((SendHttpResponse) ((com.larksuite.rucket.job.base.b.c) r111).f286079b).body.toByteArray(), Charsets.UTF_8));
    L22:
        if ((r111 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L25;
        return r111;
    L25:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r107);
        HashMap r112 = new HashMap(r102);
        r112.put("Cookie", "session=" + r100);
        SendHttpRequest.Builder r113 = new SendHttpRequest.Builder().url(r101).headers(r112).method(SendHttpRequest.Method.POST);
        ByteString.Companion.getClass();
        SendHttpRequest r114 = r113.body(ByteString.a.b(r103)).build();
        d r115 = d.f460524a;
        b r116 = (b) b38.b.f17382a.create(b.class);
        Intrinsics.checkNotNull(r114);
        RucketJob<SendHttpResponse> r117 = r116.fetchStuckSpot(r114);
        r105.L$0 = r115;
        r105.label = 1;
        r107 = r117.awaitGet(r105);
        if (r107 != r108) goto L17;
        return r108;
    L17:
        r110 = r115;
    L7:
        r105 = new StuckSpotRequestExecutor$executeWithSdkSender$1(this, r104);
        goto L8
    }
}
