package com.larus.profile.impl.bind_phone;

import com.bytedance.keva.Keva;
import com.larus.login.api.i0;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import com.larus.profile.impl.mine.r;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f366089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f366090b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static g f366091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f366092d;

    public c() {
    }

    static {
        f366089a = new c();
        f366090b = Keva.getRepo(AccountService.f365697a.getSecUserId() + '_' + o2.f365782a.e(), 0);
    }

    public static boolean b(g r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L28;
        String r102 = r100.a();
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L24;
        Keva r104 = f366090b;
        if (Intrinsics.areEqual(r102, r104.getString("key.bind.dialog.show.number", "BindPhoneManager")) == true) goto L24;
        if (r104.getBoolean("key.account.mix.has.show", false) == true) goto L24;
        boolean r105 = false;
    L25:
        if (r105 == true) goto L29;
        return true;
    L29:
        return false;
    L24:
        r105 = true;
        goto L25
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L28:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        r101 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(r r110, Continuation r111) {
        if ((r111 instanceof BindPhoneManager$checkBindPhoneInfo$1) == false) goto L7;
        BindPhoneManager$checkBindPhoneInfo$1 r100 = (BindPhoneManager$checkBindPhoneInfo$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BindPhoneManager$checkBindPhoneInfo$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Function0 r114 = (Function0) r112.L$0;
        ResultKt.throwOnFailure(r113);
        Function0 r115 = r114;
    L27:
        com.larus.network.http.a r116 = (com.larus.network.http.a) r113;
        if ((r116 instanceof com.larus.network.http.f) == false) goto L30;
        FLogger.f375446a.w("BindPhoneManager", "checkBindPhoneInfo request failed");
    L34:
        return Unit.INSTANCE;
    L30:
        g r117 = (g) r116.f360135b;
        f366091c = r117;
        if (b(r117) == false) goto L34;
        r115.invoke();
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        String r118 = f366092d;
        AccountService r104 = AccountService.f365697a;
        if (Intrinsics.areEqual(r118, r104.getUserId()) == true) goto L17;
        f366092d = r104.getUserId();
        f366091c = null;
    L17:
        g r119 = f366091c;
        if (r119 != null) goto L20;
        String r105 = i0.f357060d;
        JSONObject r106 = new JSONObject();
        r112.L$0 = r110;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.BASIC_SERVICE, g.class, r105, r106, null, null, false, null, null, null, r112, 1008);
        r115 = r110;
        if (r113 != r102) goto L27;
        return r102;
    L20:
        if (b(r119) == false) goto L23;
        r110.invoke();
    L23:
        return Unit.INSTANCE;
    L7:
        r100 = new BindPhoneManager$checkBindPhoneInfo$1(this, r111);
        goto L8
    }
}
