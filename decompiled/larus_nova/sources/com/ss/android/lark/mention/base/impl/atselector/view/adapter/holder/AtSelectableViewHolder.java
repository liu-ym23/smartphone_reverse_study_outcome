package com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.joooonho.SelectableRoundedImageView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: classes36.dex */
public class AtSelectableViewHolder extends RecyclerView.ViewHolder {

    @BindView(9330)
    public TextView departmentInfo;

    @BindView(9085)
    public UDCheckBox mAtSelectCheckBox;

    @BindView(9314)
    public ImageView mCustomStatus;

    @BindView(9358)
    public View mDividerView;

    @BindView(9869)
    public TextView mNameTV;

    @BindView(10261)
    public TextView mOwnerTV;

    @BindView(10129)
    public View mShadow;

    @BindView(10144)
    public SelectableRoundedImageView mSingleAvatarIV;

    @BindView(10236)
    public TextView mTagWrapper;

    @BindView(10403)
    public UserStatusLinearLayout mUserStatus;

    @BindView(10441)
    public TextView mWorkStatus;

    @BindView(9983)
    public ImageView profileInfoCard;

    public AtSelectableViewHolder(View r100) {
        super(r100);
        ButterKnife.bind(this, r100);
    }
}
