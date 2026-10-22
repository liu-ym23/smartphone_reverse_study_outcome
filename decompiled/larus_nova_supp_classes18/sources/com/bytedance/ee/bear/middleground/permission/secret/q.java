package com.bytedance.ee.bear.middleground.permission.secret;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SecretLevel c;
    public final /* synthetic */ SecretLevelAdapter d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r12) {
        String r13 = String.valueOf(this.c.getCanModify());
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r13, "havePermission");
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r1.put("is_have_change_perm", r13);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_security_setting_click", r1);
        if (this.c.isSelected() == false) goto L11;
        com.bytedance.ee.bear.middleground.permission.c.Q("true");
        return;
    L11:
        if (this.c.getCanModify() == true) goto L14;
        com.bytedance.ee.bear.middleground.permission.c.Q("false");
        Toast.showFailureText(eu5.b.a, 2131889926);
        return;
    L14:
        Iterator r14 = this.d.getData().iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        ((SecretLevel) r14.next()).setSelected(false);
        goto L16
    L18:
        this.c.setSelected(true);
        this.d.notifyDataSetChanged();
        this.d.b.invoke(this.c);
        return;
    L5:
        r4 = "none";
        goto L6
    }

    public q(SecretLevel r1, SecretLevelAdapter r2) {
        this.c = r1;
        this.d = r2;
    }
}
