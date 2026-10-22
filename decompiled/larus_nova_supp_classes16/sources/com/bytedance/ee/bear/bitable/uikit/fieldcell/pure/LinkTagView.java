package com.bytedance.ee.bear.bitable.uikit.fieldcell.pure;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/pure/LinkTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "size", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;)V", "applyTagSize", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkTagView extends AppCompatTextView {
    public LinkTagView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, null, 6);
    }

    public LinkTagView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, null, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(BaseTagSize r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        setTextSize(r3.getTextSizeSp());
        int r0 = n.d(r3.getTextPaddingHorizontalDp());
        setPadding(r0, 0, r0, 0);
        m.e(this, n.d(r3.getHeightDp()));
        setBackground(r3.buildNeutralCapsuleBackground(getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkTagView(Context r2, AttributeSet r3, BaseTagSize r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = BaseTagSize.MEDIUM;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "size");
        super(r2, r3);
        setGravity(17);
        setIncludeFontPadding(false);
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        setTextColor(ContextCompat.getColor(r2, 2131106622));
        x(r4);
    }
}
