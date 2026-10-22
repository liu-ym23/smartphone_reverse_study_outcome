package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;

/* JADX INFO: loaded from: classes36.dex */
public class WantAtMemBean extends BaseAtBean {
    private static final long serialVersionUID = -6615256247996487612L;
    a chatterInfo;
    String guessType;
    String searchLocation;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 2;
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

    public String getGuessType() {
        return this.guessType;
    }

    public String getSearchLocation() {
        return this.searchLocation;
    }

    public WantAtMemBean(a r100) {
        this.guessType = "";
        this.searchLocation = "";
        this.chatterInfo = r100;
    }

    public void setGuessType(String r100) {
        this.guessType = r100;
    }

    public void setSearchLocation(String r100) {
        this.searchLocation = r100;
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
