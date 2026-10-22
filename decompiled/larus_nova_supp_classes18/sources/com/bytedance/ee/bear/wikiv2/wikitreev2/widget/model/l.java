package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {

    public class a implements com.bytedance.ee.bear.contract.c0.e {
        public final /* synthetic */ boolean a;

        public final void onFail() {
            if (this.a == false) goto L5;
            Toast.showFailureText(eu5.b.a, 2131887874);
            return;
        L5:
            Toast.showFailureText(eu5.b.a, 2131887959);
        }

        public final void onSuccess() {
            if (this.a == false) goto L10;
            Activity r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity();
            if (r0 == null) goto L12;
            UDToast.a r1 = UDToast.build(r0);
            r1.b.e(2131887475);
            r1.d(Toast.getSuccessIcon());
            if (AppInfoUtils.f().booleanValue() == true) goto L9;
            r1.b(2131887460, new k());
        L9:
            r1.h();
            return;
        L12:
            return;
        L10:
            Toast.showSuccessText(eu5.b.a, 2131887476);
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    public static void a(Context r2, TreeNode r3, boolean r4, boolean r5) {
        if (r3.isShortcut() == false) goto L5;
        String r0 = r3.getOriginToken();
    L7:
        if (r3.origin_is_external == true) goto L9;
    L11:
        int r6 = 16;
    L12:
        a r1 = new a(r4);
        if (r5 == false) goto L15;
        ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).l0(r0, r6, r4, r1);
        return;
    L15:
        ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).P(r2, r0, r6, r4);
        return;
    L9:
        if (r3.isShortcut() == false) goto L11;
        r6 = r3.obj_type;
        goto L12
    L5:
        r0 = r3.wiki_token;
        goto L7
    }
}
