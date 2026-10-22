package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes36.dex */
public class AllAtBean extends BaseAtBean {
    private static final long serialVersionUID = -8614341601803028028L;
    public int allSize;

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return 0;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 1;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        if (this.allSize <= 0) goto L6;
        return UIHelper.getString(R.string.Lark_Legacy_AllPeople) + "(" + this.allSize + ")";
    L6:
        return UIHelper.getString(R.string.Lark_Legacy_AllPeople);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        Pattern r100 = o.f444744a;
        return "all";
    }

    public AllAtBean(int r100) {
        this.allSize = r100;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r100, ImageView r101, int r102, int r103) {
        r101.getLayoutParams().width = r102;
        r101.getLayoutParams().height = r103;
        r101.setImageResource(R.drawable.at_all);
    }
}
