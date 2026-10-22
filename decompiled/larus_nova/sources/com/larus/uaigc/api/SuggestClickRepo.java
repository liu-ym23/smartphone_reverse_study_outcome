package com.larus.uaigc.api;

import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class SuggestClickRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SuggestClickRepo f370270a = null;

    static {
        f370270a = new SuggestClickRepo();
    }

    public SuggestClickRepo() {
    }

    public final Object a(String r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof SuggestClickRepo$reportSugClick$1) == false) goto L7;
        SuggestClickRepo$reportSugClick$1 r100 = (SuggestClickRepo$reportSugClick$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SuggestClickRepo$reportSugClick$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        dm9.a r114 = (dm9.a) r113;
        if ((r114 instanceof dm9.a.b) == false) goto L21;
        FLogger.f375446a.i("SuggestClickRepo", "creativity sug click successfully");
    L24:
        return Unit.INSTANCE;
    L21:
        if ((r114 instanceof dm9.a.C5690a) == false) goto L24;
        FLogger.f375446a.e("SuggestClickRepo", "creativity sug click failed: " + ((dm9.a.C5690a) r114).f469230c);
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        SugClickApi.a r115 = SugClickApi.f370268a;
        SuggestClickRepo$reportSugClick$result$1 r105 = new SuggestClickRepo$reportSugClick$result$1(r110, r111, null);
        r102.label = 1;
        r115.getClass();
        FlowHttpConnection r116 = FlowHttpConnection.f359975a;
        r113 = FlowHttpConnection.g(ServiceType.UGC, SugClickApi.class, r105, false, null, null, null, r102, 248);
        if (r113 != r103) goto L17;
        return r103;
    L7:
        r100 = new SuggestClickRepo$reportSugClick$1(this, r112);
        goto L8
    }
}
