package com.bytedance.ee.bear.lark.selector;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.im.internal.network.proto2.AvCmd;
import com.ss.android.lark.widget.recyclerview.SelectableViewHolder;

/* JADX INFO: loaded from: classes16.dex */
public class DocSearchItemHolderView$DocSearchItemViewHolder extends SelectableViewHolder {

    @BindView(14587)
    UDCheckBox mCheckBox;

    @BindView(12967)
    TextView mDescTV;

    @BindView(AvCmd.CommandEventType.TRIGGER_CLIENT_SUMMON_NOTICE_VALUE)
    TextView mNameTV;

    @BindView(12656)
    ImageView mSingleAvatorIV;

    @BindView(12086)
    TextView mTagTv;
}
