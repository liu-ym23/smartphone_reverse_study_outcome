package com.larus.office.base;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.bdauth.api.UserInfoRequest;
import com.larus.login.api.BdauthService;
import com.larus.nova.R;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.IProfileApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeSdkInitor$setOfficeProfileProtocol$1 implements x1c.d {
    public OfficeSdkInitor$setOfficeProfileProtocol$1() {
    }

    @Override // x1c.d
    public final x1c.b y1() {
        r38.b r100 = IAccountService.f286094a.getUserInfo();
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.f();
        if (r102 == null) goto L6;
    L7:
        if (r100 == null) goto L13;
        String r103 = r100.g();
        if (r103 == null) goto L13;
        r101 = r103;
    L13:
        return new x1c.b(r102, r101, ILoginService.f286097a.getAccountInfo().f531534g, false);
    L6:
        r102 = "";
        goto L7
    }

    @Override // x1c.d
    public final void A0(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "doubaoUserId");
        com.bytedance.router.i r102 = SmartRouter.buildRoute(r100, "//flow/profile");
        r102.f267554c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_user_id", r101), TuplesKt.to("landing_tab", "MY_COLLECT")}));
        r102.f267555d = R.anim.larus_router_slide_in_right;
        r102.f267556e = R.anim.larus_router_no_anim;
        r102.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x1c.d
    public final Object C(String r110, Continuation<? super x1c.a> r111) {
        if ((r111 instanceof OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1) == false) goto L7;
        OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1 r100 = (OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L17:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r112;
        List r114 = new ArrayList();
        if ((r113 instanceof com.larus.network.http.y) == false) goto L37;
        fs9.b0 r115 = (fs9.b0) ((com.larus.network.http.y) r113).f360135b;
        if (r115 == null) goto L22;
        List<UserCreation> r116 = r115.a();
    L23:
        if (r116 == null) goto L35;
        ArrayList r104 = new ArrayList();
        Iterator<T> r117 = r116.iterator();
    L26:
        if (r117.hasNext() == false) goto L34;
        UserCreation r105 = (UserCreation) r117.next();
        int r106 = com.larus.utils.p0.f375454a;
        if (r105 == null) goto L30;
        String r107 = r105.e();
    L31:
        String r108 = com.larus.utils.p0.a(r107);
        if (r108 == null) goto L26;
        r104.add(r108);
        goto L26
    L30:
        r107 = null;
        goto L31
    L34:
        r114 = r104;
        goto L37
    L35:
        r114 = null;
        goto L37
    L22:
        r116 = null;
    L37:
        if (r114 != null) goto L40;
        r114 = CollectionsKt.emptyList();
    L40:
        return new x1c.a(r114);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        IProfileApi.Companion r118 = IProfileApi.f365981a;
        fs9.x r109 = new fs9.x(3, null, null, Boxing.boxInt(1), null, r110, Boxing.boxInt(1), 22);
        r100.label = 1;
        r112 = r118.a(r109, r100);
        if (r112 != r102) goto L17;
        return r102;
    L7:
        r100 = new OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoHomepageData$1(this, r111);
        goto L8
    }

    @Override // x1c.d
    public final Object n1(String r110, Continuation<? super x1c.b> r111) {
        if ((r111 instanceof OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoUserInfo$1) == false) goto L7;
        OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoUserInfo$1 r100 = (OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoUserInfo$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L17:
        dm9.a r113 = (dm9.a) r112;
        String r105 = "";
        if ((r113 instanceof dm9.a.C5690a) == true) goto L20;
    L21:
        boolean r114 = r113 instanceof dm9.a.b;
        if (r114 == true) goto L24;
    L27:
        if (r114 == false) goto L57;
        dm9.a.b r115 = (dm9.a.b) r113;
        if (r115.f469231a.isSuccess() == false) goto L57;
        t38.c r116 = (t38.c) r115.f469231a.getData();
        if (r116 == null) goto L36;
        r38.b r106 = r116.a();
        if (r106 == null) goto L36;
        String r107 = r106.f();
        if (r107 == null) goto L36;
    L37:
        if (r116 == null) goto L44;
        r38.b r108 = r116.a();
        if (r108 == null) goto L44;
        String r109 = r108.g();
        if (r109 == null) goto L44;
        r105 = r109;
    L44:
        if (r116 == null) goto L50;
        r38.b r117 = r116.a();
        if (r117 == null) goto L50;
        Integer r118 = r117.b();
        if (r118 == null) goto L50;
        int r119 = r118.intValue();
    L51:
        if (r119 > 0) goto L55;
        r104 = false;
    L55:
        return new x1c.b(r107, r105, r104, false);
    L50:
        r119 = 0;
    L36:
        r107 = "";
    L57:
        return new x1c.b("", "", false, false);
    L24:
        if (CollectionsKt.listOf(new Long[]{Boxing.boxLong(710012014), Boxing.boxLong(710052002)}).contains(Boxing.boxLong(((dm9.a.b) r113).f469231a.getCode())) == false) goto L27;
    L26:
        return new x1c.b("", "", false, true);
    L20:
        if (CollectionsKt.listOf(new Integer[]{Boxing.boxInt(710012014), Boxing.boxInt(710052002)}).contains(Boxing.boxInt(((dm9.a.C5690a) r113).f469228a)) == true) goto L26;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        BdauthService r120 = BdauthService.f356936a;
        UserInfoRequest r121 = new UserInfoRequest(null, r110, 1, 1, null);
        r100.label = 1;
        r112 = r120.requestUserInfo(r121, r100);
        if (r112 != r102) goto L17;
        return r102;
    L7:
        r100 = new OfficeSdkInitor$setOfficeProfileProtocol$1$getDoubaoUserInfo$1(this, r111);
        goto L8
    }
}
