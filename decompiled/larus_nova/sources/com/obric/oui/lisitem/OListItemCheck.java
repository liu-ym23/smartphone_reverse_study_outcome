package com.obric.oui.lisitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/lisitem/OListItemCheck;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "", "checked", "", "setChecked", "Landroid/widget/ImageView;", "getIcon", "light", "setCheckedIconLight", "", "str", com.alipay.sdk.m.x.d.f25925o, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OListItemCheck extends OListItemGeneral {
    public final void setCheckedIconLight(boolean r100) {
    }

    public final ImageView getIcon() {
        View r100 = getMTrailingElement().getChildAt(0);
        if (r100 == null) goto L7;
        return (ImageView) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void setChecked(boolean r100) {
        FrameLayout r101 = getMTrailingElement();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        setTitleString(r100);
    }

    public OListItemCheck(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setTrailingImageView(getResources().getDrawable(R.drawable.o_ic_radio_tick_checked));
        getMTrailingElement().setVisibility(8);
    }
}
