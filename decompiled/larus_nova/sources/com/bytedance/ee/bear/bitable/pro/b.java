package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Role f215158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableProAdapter f215159d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f215158c.isFaType() == false) goto L5;
        UDToast.show(BitableProAdapter.y2(this.f215159d), R.string.Bitable_AdvancedPermission_WhoCanManageOnboarding, R.drawable.ud_icon_warning_outlined);
        return;
    L5:
        i0 r101 = this.f215159d.f215049a;
        if (r101 == null) goto L8;
        r101.pJ(this.f215158c);
    L8:
        int r102 = d.f215166a;
        String r103 = this.f215158c.getRoleId();
        Boolean r104 = Boolean.valueOf(this.f215158c.isTemplate());
        JSONObject r105 = new JSONObject();
        r105.put("click", "permission_rulesetting");
        r105.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_premium_permission_rulesetting_view");
        if (r103 == null) goto L11;
        r105.put("role_id", r103);
    L11:
        if (r104 == null) goto L13;
        r105.put("is_template", r104.toString());
    L13:
        d.b("ccm_bitable_premium_permission_setting_click", r105);
    }

    public b(Role r100, BitableProAdapter r101) {
        this.f215158c = r100;
        this.f215159d = r101;
    }
}
