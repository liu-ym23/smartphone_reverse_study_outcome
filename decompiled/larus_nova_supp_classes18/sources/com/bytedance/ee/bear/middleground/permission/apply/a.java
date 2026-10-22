package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.apply.a$a, reason: collision with other inner class name */
    public static final class C0088a {
    }

    static {
    }

    public a() {
    }

    public static Spanned a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "appContext");
        AccountService.Account r0 = ((com.bytedance.ee.bear.contract.h0) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r0 == null) goto L11;
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = ou5.a.d(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a(), r0.displayName, r0.userName, r0.enName);
        if (r0.isConsumer() == false) goto L7;
        String r3 = r6.getString(2131888107);
    L8:
        r1.put("UserName", b0.a(r3 + '-' + r2));
        Unit r4 = Unit.INSTANCE;
        Spanned r7 = Html.fromHtml(xo5.a.d(r6, 2131888813, r1));
        if (r7 == null) goto L11;
        return r7;
    L7:
        r3 = r0.tenantName;
    L11:
        return new SpannableString("");
    }

    public static Flowable b(String r4, int r5, String r6, int r7, NetService r8) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "netService");
        NetService.d r9 = r8.Vc(new ax4.a());
        NetService.f r0 = new NetService.f("/space/api/suite/permission/apply_permission_from_admin");
        ((NetService.e) r0).i = false;
        ((NetService.e) r0).c = 1;
        AuditControlParams r2 = new AuditControlParams();
        if (r7 != 2) goto L5;
        String r10 = "edit";
    L6:
        r2.setAction(r10);
        r2.setToken(r4);
        r2.setType(Integer.valueOf(r5));
        r2.setApprovalType(1);
        r2.setRemark(r6);
        ((NetService.e) r0).j = JSON.toJSONString(r2);
        return r9.a(r0);
    L5:
        r10 = "view";
        goto L6
    }
}
