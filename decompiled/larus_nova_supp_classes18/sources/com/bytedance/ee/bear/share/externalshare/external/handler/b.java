package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.supervisor.token.Token;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final Context a;
    public final ShareParams b;
    public final BaseOpenTencentHandler c;
    public final Function0<Unit> d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final String b(int r2) {
        return this.a.getString(r2);
    }

    public final void a(boolean r7, String r8) {
        if (this.b.getType() == 3) goto L5;
    L9:
        BaseOpenTencentHandler r0 = this.c;
        if (r0 == null) goto L12;
        String r1 = r0.g();
    L13:
        if (r1 != null) goto L15;
        r1 = "";
    L15:
        s45.i r2 = s45.i.a;
        int r3 = this.b.getType();
        boolean r4 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        r2.getClass();
        String r5 = s45.i.b(r1, r3, r4);
        if (r7 == false) goto L33;
        HashMap r6 = new HashMap();
        r6.put("APP_DISPLAY_NAME", b(2131890277));
        r6.put("link", r5);
        r6.put("password", r8);
        r5 = xo5.a.d(this.a, 2131887765, r6);
    L33:
        boolean r9 = ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r5, false, new Token("LARK-PSDA-ccm_android_share_dialog_copy_link"));     // Catch: Exception -> L21
    L23:
        if (r9 == false) goto L30;
        if (r7 == false) goto L26;
        Toast.showSuccessText(this.a, b(2131887723), 0);
    L31:
        this.d.invoke();
        return;
    L26:
        int r10 = n.a;
        if (n.e(this.b) == false) goto L29;
        Toast.showSuccessText(this.a, b(2131889373), 0);
        goto L31
    L29:
        Toast.showSuccessText(this.a, b(2131887727), 0);
        goto L31
    L30:
        Toast.showFailureText(this.a, b(2131887724), 0);
    L21:
        e = move-exception;
        tt5.a.f("BaseCopyLinkHandler", e, false);
        r9 = false;
    L12:
        r1 = null;
        goto L13
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.android.sheet_share_url_extra_params_enabled") == false) goto L9;
        BaseOpenTencentHandler r11 = this.c;
        if (r11 == null) goto L12;
        r1 = r11.e();
        goto L13
    }

    public b(Context r2, ShareParams r3, BaseOpenTencentHandler r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r5, "dismiss");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
