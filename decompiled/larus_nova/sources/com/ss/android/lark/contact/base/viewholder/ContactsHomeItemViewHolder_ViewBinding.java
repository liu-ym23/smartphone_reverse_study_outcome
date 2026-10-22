package com.ss.android.lark.contact.base.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: classes35.dex */
public class ContactsHomeItemViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContactsHomeItemViewHolder f418957a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        ContactsHomeItemViewHolder r100 = this.f418957a;
        if (r100 == null) goto L7;
        this.f418957a = null;
        r100.userInfoLayoutWrapper = null;
        r100.contactLayout = null;
        r100.contactAvatar = null;
        r100.contactNameTV = null;
        r100.contactTenantTV = null;
        r100.contactUserStatus = null;
        r100.checkBox = null;
        r100.btnLayout = null;
        r100.deleteBtn = null;
        r100.specialFocusView = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public ContactsHomeItemViewHolder_ViewBinding(ContactsHomeItemViewHolder r100, View r101) {
        this.f418957a = r100;
        r100.userInfoLayoutWrapper = (LinearLayout) Utils.findRequiredViewAsType(r101, R.id.layout_user_info, "field 'userInfoLayoutWrapper'", LinearLayout.class);
        r100.contactLayout = (RelativeLayout) Utils.findRequiredViewAsType(r101, R.id.contact_item_layout, "field 'contactLayout'", RelativeLayout.class);
        r100.contactAvatar = (LKUIRoundedImageView2) Utils.findRequiredViewAsType(r101, R.id.contact_avatar, "field 'contactAvatar'", LKUIRoundedImageView2.class);
        r100.contactNameTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.contact_name, "field 'contactNameTV'", TextView.class);
        r100.contactTenantTV = (TenantNameTextView) Utils.findRequiredViewAsType(r101, R.id.contact_tenant, "field 'contactTenantTV'", TenantNameTextView.class);
        r100.contactUserStatus = (UserStatusLinearLayout) Utils.findRequiredViewAsType(r101, R.id.contact_user_status, "field 'contactUserStatus'", UserStatusLinearLayout.class);
        r100.checkBox = (UDCheckBox) Utils.findRequiredViewAsType(r101, R.id.select_box, "field 'checkBox'", UDCheckBox.class);
        r100.btnLayout = Utils.findRequiredView(r101, R.id.btn_layout, "field 'btnLayout'");
        r100.deleteBtn = Utils.findRequiredView(r101, R.id.delete_btn, "field 'deleteBtn'");
        r100.specialFocusView = Utils.findRequiredView(r101, R.id.iv_special_focus, "field 'specialFocusView'");
    }
}
