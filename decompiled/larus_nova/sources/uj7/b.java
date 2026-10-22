package uj7;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550412a;

    public b(ProjectActivity r100) {
        this.f550412a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (TextUtils.isEmpty(this.f550412a.f271430a) == false) goto L5;
        ProjectActivity r101 = this.f550412a;
        r101.f271430a = com.bytedance.ug.sdk.luckycat.impl.utils.u.a().c("key_test_js_bridge_cache", "https://test-aweme.snssdk.com/falcon/jsb_tester_web/dmt/?caseId=&groupId=60&author=duchao.mark&authorId=6035362&isAutoTest=&productionId=9");
    L6:
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        ProjectActivity r103 = this.f550412a;
        r102.v(r103, r103.f271430a, null);
        return;
    L5:
        com.bytedance.ug.sdk.luckycat.impl.utils.u.a().g("key_test_js_bridge_cache", this.f550412a.f271430a);
        goto L6
    }
}
