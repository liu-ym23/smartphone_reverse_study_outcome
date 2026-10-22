package com.ss.android.lark.contact.base.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: classes35.dex */
public class ContactsHomeItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(8636)
    public View btnLayout;

    @BindView(9380)
    public UDCheckBox checkBox;

    @BindView(8702)
    public LKUIRoundedImageView2 contactAvatar;

    @BindView(ErrorCode.MODULE_NOT_INIT)
    public RelativeLayout contactLayout;

    @BindView(ErrorCode.NOT_FLUSH)
    public TextView contactNameTV;

    @BindView(ErrorCode.INVALID_DATA)
    public TenantNameTextView contactTenantTV;

    @BindView(8709)
    public UserStatusLinearLayout contactUserStatus;

    @BindView(8738)
    public View deleteBtn;

    @BindView(8985)
    public View specialFocusView;

    @BindView(DataLoaderHelper.DATALOADER_KEY_ENABLE_NOTIFY_NOT_ONLY_NETWORK_ERROR)
    public LinearLayout userInfoLayoutWrapper;

    public ContactsHomeItemViewHolder(View r100) {
        super(r100);
        ButterKnife.bind(this, r100);
    }
}
