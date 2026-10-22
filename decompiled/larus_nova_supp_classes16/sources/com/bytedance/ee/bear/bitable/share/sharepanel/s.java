package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s {
    public static final void a(AppCompatImageView r3, TextView r4) {
        Intrinsics.checkNotNullParameter(r3, "baseIcon");
        Intrinsics.checkNotNullParameter(r4, "brandHint");
        Context r0 = r3.getContext();
        boolean r1 = en4.a.l();
        if (r1 == false) goto L5;
        IOfficeAppBaseInfo r2 = (IOfficeAppBaseInfo) LarkContext.spiByDwarf(IOfficeAppBaseInfo.class);
        Intrinsics.checkNotNull(r0);
        Drawable r5 = r2.getDouBaoIcon(r0);
    L6:
        if (r5 == null) goto L8;
        r3.setImageDrawable(r5);
    L10:
        if (r1 == false) goto L12;
        r4.setText(UIHelper.mustacheFormat(2131886409, "APP_DISPLAY_NAME", r0.getString(2131889517)));
        return;
    L12:
        r4.setText(UIHelper.mustacheFormat(2131886668, "APP_DISPLAY_NAME", UIHelper.getAppName()));
        return;
    L8:
        r3.setImageResource(kac.a.b(2131254400));
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
