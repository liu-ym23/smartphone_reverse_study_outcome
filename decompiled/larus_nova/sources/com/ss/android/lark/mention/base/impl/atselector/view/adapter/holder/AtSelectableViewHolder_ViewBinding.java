package com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.joooonho.SelectableRoundedImageView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: classes36.dex */
public class AtSelectableViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtSelectableViewHolder f431841a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        AtSelectableViewHolder r100 = this.f431841a;
        if (r100 == null) goto L7;
        this.f431841a = null;
        r100.mAtSelectCheckBox = null;
        r100.mSingleAvatarIV = null;
        r100.mNameTV = null;
        r100.mOwnerTV = null;
        r100.mDividerView = null;
        r100.mCustomStatus = null;
        r100.mTagWrapper = null;
        r100.mUserStatus = null;
        r100.mWorkStatus = null;
        r100.mShadow = null;
        r100.profileInfoCard = null;
        r100.departmentInfo = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AtSelectableViewHolder_ViewBinding(AtSelectableViewHolder r100, View r101) {
        this.f431841a = r100;
        r100.mAtSelectCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r101, R.id.at_select_box, "field 'mAtSelectCheckBox'", UDCheckBox.class);
        r100.mSingleAvatarIV = (SelectableRoundedImageView) Utils.findRequiredViewAsType(r101, R.id.single_avator, "field 'mSingleAvatarIV'", SelectableRoundedImageView.class);
        r100.mNameTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.name, "field 'mNameTV'", TextView.class);
        r100.mOwnerTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.text_owner, "field 'mOwnerTV'", TextView.class);
        r100.mDividerView = Utils.findRequiredView(r101, R.id.divider, "field 'mDividerView'");
        r100.mCustomStatus = (ImageView) Utils.findRequiredViewAsType(r101, R.id.custom_status, "field 'mCustomStatus'", ImageView.class);
        r100.mTagWrapper = (TextView) Utils.findRequiredViewAsType(r101, R.id.tag_wrapper, "field 'mTagWrapper'", TextView.class);
        r100.mUserStatus = (UserStatusLinearLayout) Utils.findRequiredViewAsType(r101, R.id.user_status, "field 'mUserStatus'", UserStatusLinearLayout.class);
        r100.mWorkStatus = (TextView) Utils.findRequiredViewAsType(r101, R.id.workday_leave, "field 'mWorkStatus'", TextView.class);
        r100.mShadow = Utils.findRequiredView(r101, R.id.shadow, "field 'mShadow'");
        r100.profileInfoCard = (ImageView) Utils.findRequiredViewAsType(r101, R.id.profile_info_card, "field 'profileInfoCard'", ImageView.class);
        r100.departmentInfo = (TextView) Utils.findRequiredViewAsType(r101, R.id.department_info, "field 'departmentInfo'", TextView.class);
    }
}
