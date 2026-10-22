package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class LabelAtBean extends BaseAtBean {
    private static final long serialVersionUID = -5399462310353446789L;
    private int bgColorResId;
    String label;
    String subLabel;
    private int textSize;
    private int verticalPadding;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 3;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r100, ImageView r101, int r102, int r103) {
    }

    public int getBgColorResId() {
        return this.bgColorResId;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.label;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.label;
    }

    public String getSubLabel() {
        return this.subLabel;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public int getVerticalPadding() {
        return this.verticalPadding;
    }

    public LabelAtBean(String r100) {
        this.textSize = 14;
        this.bgColorResId = R.color.bg_base;
        this.verticalPadding = UIHelper.dp2px(9.0f);
        this.label = r100;
    }

    public void setBgColorResId(int r100) {
        this.bgColorResId = r100;
    }

    public void setTextSize(int r100) {
        this.textSize = r100;
    }

    public void setVerticalPadding(int r100) {
        this.verticalPadding = r100;
    }

    public LabelAtBean(String r100, String r101) {
        this.textSize = 14;
        this.bgColorResId = R.color.bg_base;
        this.verticalPadding = UIHelper.dp2px(9.0f);
        this.label = r100;
        this.subLabel = r101;
    }
}
