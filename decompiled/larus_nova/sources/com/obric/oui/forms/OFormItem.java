package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/obric/oui/text/OTextView;", "getLabelView", "Lcom/obric/oui/forms/OInputView;", "getInputView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFormItem extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f400897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OInputView f400898b;

    public OFormItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OFormItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final OInputView getInputView() {
        return this.f400898b;
    }

    public final OTextView getLabelView() {
        return this.f400897a;
    }

    public OFormItem(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        OTextView r103 = new OTextView(new ContextThemeWrapper(r100, R.style.Label_L), null, 0, 14);
        this.f400897a = r103;
        OInputView r104 = new OInputView(r100, null, 6, 0);
        this.f400898b = r104;
        setGravity(16);
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.gravity, android.R.attr.orientation, android.R.attr.baselineAligned, android.R.attr.baselineAlignedChildIndex, android.R.attr.weightSum, R.attr.divider, R.attr.dividerPadding, R.attr.measureWithLargestChild, R.attr.showDividers}, r102, 0);
        int r106 = r105.getInt(0, -1);
        if (r106 < 0) goto L5;
        setGravity(r106);
    L5:
        r105.recycle();
        addView(r103);
        addView(r104);
        r104.setShowLabel(false);
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        if (r107 == null) goto L24;
        LinearLayoutCompat.LayoutParams r108 = (LinearLayoutCompat.LayoutParams) r107;
        if (getOrientation() != 0) goto L10;
        int r109 = pla.d.n(this, 72);
    L11:
        ((LinearLayout.LayoutParams) r108).width = r109;
        ((LinearLayout.LayoutParams) r108).height = -2;
        r103.setLayoutParams(r108);
        r103.setText("label");
        r104.setHint("hint");
        ViewGroup.LayoutParams r110 = r104.getLayoutParams();
        if (r110 == null) goto L22;
        LinearLayoutCompat.LayoutParams r111 = (LinearLayoutCompat.LayoutParams) r110;
        ((LinearLayout.LayoutParams) r111).weight = 1.0f;
        ((LinearLayout.LayoutParams) r111).width = -1;
        ((LinearLayout.LayoutParams) r111).height = -2;
        if (getOrientation() != 1) goto L17;
        ((LinearLayout.LayoutParams) r111).topMargin = pla.d.n(this, 8);
    L19:
        r104.setLayoutParams(r111);
        return;
    L17:
        if (getOrientation() != 0) goto L19;
        r111.setMarginStart(pla.d.n(this, 12));
        ((LinearLayout.LayoutParams) r111).leftMargin = pla.d.n(this, 12);
        goto L19
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    L10:
        r109 = -1;
        goto L11
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    }

    public /* synthetic */ OFormItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
