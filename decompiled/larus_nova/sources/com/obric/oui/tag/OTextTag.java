package com.obric.oui.tag;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/tag/OTextTag;", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OTextTag extends OTextView {
    public OTextTag(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OTextTag(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.text.OTextView, com.obric.oui.common.style.a
    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r100) {
    }

    @Override // com.obric.oui.text.OTextView
    public /* bridge */ /* synthetic */ void setFakePressed(boolean r100) {
    }

    public final void b(boolean r100) {
        int r101 = getPaddingTop();
        int r102 = getPaddingEnd();
        int r103 = getPaddingBottom();
        int r104 = RangesKt.coerceAtLeast(getCompoundDrawablePadding(), 0);
        if (r100 == false) goto L5;
        int r105 = RangesKt.coerceAtLeast(r102 - r104, 0);
    L7:
        if (r105 == getPaddingStart()) goto L10;
        setPaddingRelative(r105, r101, r102, r103);
        return;
    L10:
        return;
    L5:
        r105 = r102;
        goto L7
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OTextTag(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        setCompoundDrawableTintList(ColorStateList.valueOf(getCurrentTextColor()));
        boolean r103 = false;
        if (ArraysKt.getOrNull(getCompoundDrawables(), 0) == null) goto L5;
    L6:
        r103 = true;
    L7:
        b(r103);
        return;
    L5:
        if (ArraysKt.getOrNull(getCompoundDrawablesRelative(), 0) == null) goto L7;
        goto L6
    }

    public /* synthetic */ OTextTag(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawables(r100, r101, r102, r103);
        if (r100 == null) goto L5;
        boolean r104 = true;
    L6:
        b(r104);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawablesRelative(r100, r101, r102, r103);
        if (r100 == null) goto L5;
        boolean r104 = true;
    L6:
        b(r104);
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
