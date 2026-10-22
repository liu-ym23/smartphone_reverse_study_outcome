package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Role f215107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableProAdapter f215108d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f215107c.disableEditMembers() == false) goto L5;
        UDToast.show(BitableProAdapter.y2(this.f215108d), R.string.Bitable_AdvancedPermission_EnableFirstTip, R.drawable.ud_icon_warning_outlined);
        return;
    L5:
        i0 r101 = this.f215108d.f215049a;
        if (r101 == null) goto L8;
        r101.HB(this.f215107c);
    L8:
        int r102 = d.f215166a;
        String r103 = this.f215107c.getRoleId();
        JSONObject r104 = new JSONObject();
        r104.put("click", "manage_collaborator");
        r104.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_premium_permission_manage_collaborator_view");
        if (r103 == null) goto L11;
        r104.put("role_id", r103);
    L11:
        r104.put("is_template", "false");
        d.b("ccm_bitable_premium_permission_setting_click", r104);
    }

    public a(Role r100, BitableProAdapter r101) {
        this.f215107c = r100;
        this.f215108d = r101;
    }
}
