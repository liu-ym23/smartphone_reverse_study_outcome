package com.larus.login.impl.multiaccount;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.router.SmartRouter;
import com.larus.platform.model.TriggerLoginScene;
import kotlin.Pair;
import kotlin.TuplesKt;
import tx9.g2;

/* JADX INFO: loaded from: classes30.dex */
public final class s0 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f358153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q38.b f358154b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(this.f358153a, "//flow/half_account_login");
        r100.f267554c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("trigger_login_scene_tag", Integer.valueOf(TriggerLoginScene.TRIGGER_LOGIN_INVALID_RELOGIN.getValue())), TuplesKt.to("account_previous_page", "account_switch")}));
        r100.d();
        if (this.f358154b.l() == false) goto L5;
        String r101 = "enterprise";
    L6:
        g2.e("relogin", r101, this.f358154b.j());
        return;
    L5:
        r101 = WikiSpaceType.PERSONAL;
        goto L6
    }

    public s0(FragmentActivity r100, q38.b r101) {
        this.f358153a = r100;
        this.f358154b = r101;
    }
}
