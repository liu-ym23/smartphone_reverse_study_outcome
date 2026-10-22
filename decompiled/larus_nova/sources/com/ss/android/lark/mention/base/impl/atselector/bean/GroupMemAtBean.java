package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;

/* JADX INFO: loaded from: classes36.dex */
public class GroupMemAtBean extends BaseAtBean implements Comparable<GroupMemAtBean> {
    private static final long serialVersionUID = -4450297628440362719L;
    a chatterInfo;
    private boolean hideDivider;
    private char letter;
    private boolean showShadow;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.chatterInfo.f431697c;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.chatterInfo.f431695a;
    }

    public a getChatterInfo() {
        return this.chatterInfo;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return this.letter;
    }

    public boolean isHideDivider() {
        return this.hideDivider;
    }

    public boolean isShowShadow() {
        return this.showShadow;
    }

    public GroupMemAtBean(a r100) {
        this.chatterInfo = r100;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(GroupMemAtBean r100) {
        return this.chatterInfo.a(r100.chatterInfo);
    }

    public void setChatterInfo(a r100) {
        this.chatterInfo = r100;
    }

    public void setHideDivider(boolean r100) {
        this.hideDivider = r100;
    }

    public void setLetter(char r100) {
        this.letter = r100;
    }

    public void showShadow(boolean r100) {
        this.showShadow = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(GroupMemAtBean r100) {
        return compareTo2(r100);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r100, ImageView r101, int r102, int r103) {
        if (this.chatterInfo.b() == false) goto L5;
        r101.setImageDrawable(UIUtils.getDrawable(r100, R.drawable.ud_icon_myai_colorful));
        return;
    L5:
        a r104 = this.chatterInfo;
        String r105 = r104.f431696b;
        String r106 = r104.f431695a;
        LoadParams r107 = new LoadParams();
        r107.f426328a = r102;
        r107.f426329b = r103;
        ImageModule.a(r100, r101, r105, r106, r107);
    }
}
