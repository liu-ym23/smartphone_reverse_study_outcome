package com.larus.enterprise.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.c;
import com.larus.bmhome.a0;
import com.larus.platform.api.n2;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.n0;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import hq9.l2;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class EnterpriseRouterInterceptor implements q97.a {

    public static final class a {
    }

    static {
    }

    public EnterpriseRouterInterceptor() {
    }

    @Override // q97.a
    public final boolean b(c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        Uri r103 = null;
        if (r100 == null) goto L7;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L7;
        String r105 = r104.getAuthority();
    L8:
        r102.append(r105);
        r101.d("EnterpriseRouterInterceptor", r102.toString());
        if (com.larus.enterprise.impl.a.a() == true) goto L11;
        return false;
    L11:
        if (r100 == null) goto L13;
        r103 = r100.f267530d;
    L13:
        String r106 = c(String.valueOf(r103));
        if (Intrinsics.areEqual(r106, "//flow/setting_notify_settings") == false) goto L25;
        LarkSocialExp r107 = LarkSocialExp.f365340a;
        a0.f294919z1.getClass();
        boolean r108 = a0.a.f294921b;
        r107.getClass();
        int r109 = l2.f486657a;
        boolean r110 = LarkSocialExp.f();
        boolean r111 = z2.f365865a.q().f486695n;
        if (r108 == true) goto L21;
        if (r110 == false) goto L20;
        if (r111 == true) goto L21;
    L20:
        boolean r112 = false;
    L22:
        if (r112 == false) goto L25;
        return false;
    L21:
        r112 = true;
    L25:
        if (Intrinsics.areEqual(r106, "//flow/chat_page") == true) goto L33;
        n2 r113 = n0.f365775a.c();
        if (r113 == null) goto L30;
        List<String> r114 = r113.a();
        if (r114 == null) goto L30;
    L32:
        if (CollectionsKt.contains(r114, r106) == false) goto L33;
        return false;
    L30:
        r114 = CollectionsKt.emptyList();
    L33:
        return true;
    L7:
        r105 = null;
        goto L8
    }

    public final String c(String r100) {
        String r101 = UriProtector.parse(r100).getSchemeSpecificPart();
        Intrinsics.checkNotNull(r101);
        String r102 = (String) CollectionsKt.first(StringsKt.split$default(r101, new String[]{"?"}, false, 0, 6, null));
        if (StringsKt.startsWith$default(r102, "//", false, 2, null) == false) goto L6;
        return r102;
    L6:
        return null;
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        if (r101 == null) goto L5;
        Uri r102 = r101.f267530d;
    L6:
        String r103 = c(String.valueOf(r102));
        n2 r104 = n0.f365775a.c();
        if (r104 == null) goto L10;
        List<String> r105 = r104.a();
        if (r105 == null) goto L10;
    L12:
        if (CollectionsKt.contains(r105, r103) == true) goto L15;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EnterpriseRouterInterceptor$onInterceptRoute$1(null), 3, null);
        FLogger.f375446a.i("EnterpriseRouterInterceptor", "Router onInterceptRoute customPath=" + r103);
        o r106 = o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("op", PrefetchTiming.ROUTER);
        r107.put("class_name", r103);
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("enterprise_page_deterioration", r107);
        return true;
    L15:
        return false;
    L10:
        r105 = CollectionsKt.emptyList();
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
