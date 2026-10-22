package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectEditTextView;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "initAttr", "", "applyTagSize", "size", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "applyBorderColor", "borderColor", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectEditTextView extends SelectTextView {
    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.SelectTextView
    public final void O() {
        setIncludeFontPadding(false);
        P(com.bytedance.ee.util.ui.n.d(28));
        setMBackgroundDrawable(new GradientDrawable());
        GradientDrawable r100 = getMBackgroundDrawable();
        if (r100 == null) goto L5;
        r100.setCornerRadii(getMBorderRadii());
    L5:
        setBackground(getMBackgroundDrawable());
        setPadding(com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(12), com.bytedance.ee.util.ui.n.d(4));
        setSingleLine();
        setFocusableInTouchMode(true);
        setTextIsSelectable(true);
    }

    public SelectEditTextView(Context r100) {
        super(r100);
    }

    public SelectEditTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
