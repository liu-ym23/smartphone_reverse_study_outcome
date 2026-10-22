package com.ss.android.lark.thirdshare.base.export.downgrade;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class CtaBtnStyle implements Serializable {
    public static final CtaBtnStyle QQ = null;
    public static final CtaBtnStyle WB = null;
    public static final CtaBtnStyle WX = null;
    private int logoDrawableId;
    private int normalColorRes;
    private int pressedColorRes;
    private int textColorRes;
    private int textId;

    static {
        WX = new CtaBtnStyle(R.drawable.ts_icon_wx_logo, R.string.Lark_Invitation_ShareViaWeChat_ImageCreatedAndSaved_button, R.color.static_white, R.color.colorful_green, R.color.ud_G600);
        QQ = new CtaBtnStyle(R.drawable.ts_icon_qq_logo, R.string.Lark_Invitation_ShareViaQQ_ImageCreatedAndSaved_button, R.color.static_white, R.color.colorful_wathet, R.color.ud_W600);
        WB = new CtaBtnStyle(R.drawable.ts_icon_wb_logo, R.string.Lark_Invitation_ShareViaWeibo_ImageCreatedAndSaved_button, R.color.static_white, R.color.colorful_red, R.color.ud_R600);
    }

    public CtaBtnStyle() {
    }

    public static CtaBtnStyle getThirdAppCtaBtnStyle(ShareActionType r100) {
        if (ShareActionType.WX.equals(r100) == true) goto L18;
        if (ShareActionType.WX_TIMELINE.equals(r100) == true) goto L18;
        if (ShareActionType.QQ.equals(r100) == false) goto L12;
        return QQ;
    L12:
        if (ShareActionType.WB.equals(r100) == true) goto L14;
        return null;
    L14:
        return WB;
    L18:
        return WX;
    }

    public Drawable getLogoDrawable(Context r100) {
        int r101 = this.logoDrawableId;
        if (r101 != 0) goto L6;
        return null;
    L6:
        Drawable r102 = ContextCompat.getDrawable(r100, r101);
        r102.mutate();
        r102.setTint(ContextCompat.getColor(r100, R.color.static_white));
        return r102;
    }

    public int getNormalColor(Context r100) {
        return ContextCompat.getColor(r100, this.normalColorRes);
    }

    public int getPressedColor(Context r100) {
        return ContextCompat.getColor(r100, this.pressedColorRes);
    }

    public String getText(Context r100) {
        int r101 = this.textId;
        if (r101 != 0) goto L7;
        return null;
    L7:
        return r100.getString(r101);
    }

    public int getTextColor(Context r100) {
        return ContextCompat.getColor(r100, this.textColorRes);
    }

    public CtaBtnStyle(int r100, int r101, int r102, int r103, int r104) {
        this.logoDrawableId = r100;
        this.textId = r101;
        this.textColorRes = r102;
        this.normalColorRes = r103;
        this.pressedColorRes = r104;
    }
}
