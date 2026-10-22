package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s {
    public static final void a(AppCompatImageView r100, TextView r101) {
        Intrinsics.checkNotNullParameter(r100, "baseIcon");
        Intrinsics.checkNotNullParameter(r101, "brandHint");
        Context r102 = r100.getContext();
        boolean r103 = en4.a.l();
        if (r103 == false) goto L5;
        IOfficeAppBaseInfo r104 = (IOfficeAppBaseInfo) LarkContext.spiByDwarf(IOfficeAppBaseInfo.class);
        Intrinsics.checkNotNull(r102);
        Drawable r105 = r104.getDouBaoIcon(r102);
    L6:
        if (r105 == null) goto L8;
        r100.setImageDrawable(r105);
    L10:
        if (r103 == false) goto L12;
        r101.setText(UIHelper.mustacheFormat(R.string.Bitable_Doubao_Form_GeneratedByDoubaoAIPoweredByBase_Desc, "APP_DISPLAY_NAME", r102.getString(R.string.LarkCCM_Growth_Discover_Feishu_Brandname)));
        return;
    L12:
        r101.setText(UIHelper.mustacheFormat(R.string.Bitable_NewSurvey_PoweredByBase_Text, "APP_DISPLAY_NAME", UIHelper.getAppName()));
        return;
    L8:
        r100.setImageResource(kac.a.b(R.drawable.ud_icon_file_bitable_colorful));
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
