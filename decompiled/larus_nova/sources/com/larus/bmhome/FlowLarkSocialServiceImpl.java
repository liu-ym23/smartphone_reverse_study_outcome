package com.larus.bmhome;

import com.bytedance.keva.Keva;
import com.larus.bmhome.utils.r3;
import com.larus.larkfeed.IFlowLarkFeedApi;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.SocialIMData;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class FlowLarkSocialServiceImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Function1<SocialIMData, Unit>, hza.b> f294914a;

    public final boolean c() {
        return IFlowLarkFeedApi.f355117a.f();
    }

    public FlowLarkSocialServiceImpl() {
        this.f294914a = new LinkedHashMap();
    }

    public static SocialIMData a(pza.a r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        String r102 = null;
        if (r101 == true) goto L18;
        if (r100 == null) goto L12;
        Long r103 = Long.valueOf(r100.f531134a);
    L13:
        if (r103 == null) goto L18;
        if (r100 == null) goto L17;
        Long r104 = Long.valueOf(r100.f531134a);
    L23:
        if (r100 == null) goto L25;
        Integer r105 = Integer.valueOf(r100.f531135b);
    L26:
        if (r100 == null) goto L28;
        Integer r106 = Integer.valueOf(r100.f531136c);
    L29:
        if (r100 == null) goto L31;
        r102 = r100.f531139f;
    L31:
        SocialIMData r107 = new SocialIMData(r104, r102, r105, r106);
        Keva r108 = com.larus.home.impl.utils.k.f346350a;
        Intrinsics.checkNotNullParameter(r107, "data");
        com.larus.home.impl.utils.k.f346350a.storeString("default_data_cache".concat(r3.a()), HttpExtKt.p(r107));
        return r107;
    L28:
        r106 = null;
        goto L29
    L25:
        r105 = null;
        goto L26
    L17:
        r104 = null;
        goto L23
    L12:
        r103 = null;
    L18:
        Keva r109 = com.larus.home.impl.utils.l.f346351a;
        long r110 = r109.getLong("default_update_time", 0);
        if (r110 != 0) goto L22;
        r110 = System.currentTimeMillis();
        r109.storeLong("default_update_time", r110);
    L22:
        r104 = Long.valueOf(r110);
        goto L23
    L5:
        if (r100.f531134a != 0) goto L7;
        r101 = true;
        goto L8
    }

    public final void e(com.larus.bmhome.chat.reddot.g r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        hza.b r101 = (hza.b) ((LinkedHashMap) this.f294914a).get(r100);
        if (r101 == null) goto L13;
        this.f294914a.remove(r100);
        Object r102 = xp9.o.f564776a;
        if ((r102 instanceof OfficeSDKUserApi) == false) goto L7;
        OfficeSDKUserApi r103 = (OfficeSDKUserApi) r102;
    L8:
        if (r103 == null) goto L14;
        aza.d r104 = (aza.d) r103.getService(aza.d.class);
        if (r104 == null) goto L15;
        r104.R6(r101);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final Object b(Object r100, Continuation<? super SocialIMData> r101) {
        if ((r101 instanceof FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1) == false) goto L7;
        FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1 r102 = (FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        pza.a r107 = null;
        Object r108 = null;
        r107 = null;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r109 = ((Result) r104).m9458unboximpl();
    L25:
        if (Result.m9455isFailureimpl(r109) == true) goto L28;
        r108 = r109;
    L28:
        r107 = (pza.a) r108;
    L30:
        return a(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if ((r100 instanceof OfficeSDKUserApi) == false) goto L17;
        OfficeSDKUserApi r110 = (OfficeSDKUserApi) r100;
    L18:
        if (r110 == null) goto L30;
        aza.d r111 = (aza.d) r110.getService(aza.d.class);
        if (r111 == null) goto L30;
        r102.label = 1;
        r109 = r111.ma(r102);
        if (r109 != r105) goto L25;
        return r105;
    L17:
        r110 = null;
    L7:
        r102 = new FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1(this, r101);
        goto L8
    }

    public final void d(Object r100, com.larus.bmhome.chat.reddot.g r101) {
        Intrinsics.checkNotNullParameter(r100, "userApi");
        Intrinsics.checkNotNullParameter(r101, "listener");
        v r102 = new v(r101, this);
        this.f294914a.put(r101, r102);
        if ((r100 instanceof OfficeSDKUserApi) == false) goto L5;
        OfficeSDKUserApi r103 = (OfficeSDKUserApi) r100;
    L6:
        if (r103 == null) goto L11;
        aza.d r104 = (aza.d) r103.getService(aza.d.class);
        if (r104 == null) goto L12;
        r104.J5(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
