package com.obric.oui.selection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alipay.sdk.m.x.d;
import com.obric.oui.lisitem.OListItemGeneral;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/selection/OActionSheetItemView;", "Lcom/obric/oui/lisitem/OListItemGeneral;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setIcon", "", "drawable", "Landroid/graphics/drawable/Drawable;", d.f25925o, "str", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheetItemView extends OListItemGeneral {
    public final void setIcon(Drawable r100) {
        setContentImage(r100);
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        setTitleString(r100);
    }

    public OActionSheetItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        setShowBackground(true);
    }
}
