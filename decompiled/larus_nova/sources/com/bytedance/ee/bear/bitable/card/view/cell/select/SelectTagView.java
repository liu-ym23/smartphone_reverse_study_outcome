package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.CapsuleModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTagView;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/CapsuleModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tagSize", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/BaseTagSize;", "applyTagSize", "", "size", "applyMultilineTagSize", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "applyBorderColor", "borderColor", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SelectTagView extends SelectTextView implements gv4.b<CapsuleModel> {

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public BaseTagSize f208101v2;

    public SelectTagView(Context r100) {
        super(r100);
        BaseTagSize r101 = BaseTagSize.MEDIUM;
        this.f208101v2 = r101;
        U(r101);
    }

    public final void S(String r100) {
        GradientDrawable r101 = getMBackgroundDrawable();
        if (r101 != null) goto L5;
        return;
    L5:
        BaseTagSize r102 = this.f208101v2;
        BaseTagSize.Companion.getClass();
        r102.applyBorderStroke(r101, BaseTagSize.a.a(r100));
        setBackground(r101);
    }

    public final void T(BaseTagSize r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        this.f208101v2 = r100;
        R(r100.getRadiusPx());
        setTextSize(r100.getTextSizeSp());
        setGravity(8388627);
        setSingleLine(false);
        setHorizontallyScrolling(false);
        setMaxLines(10);
        setEllipsize(TextUtils.TruncateAt.END);
        setMinHeight(com.bytedance.ee.util.ui.n.d(r100.getHeightDp()));
        setMaxHeight(Integer.MAX_VALUE);
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L5;
        r101.height = -2;
        setLayoutParams(r101);
    L5:
        setPadding(com.bytedance.ee.util.ui.n.d(r100.getTextPaddingHorizontalDp()), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(r100.getTextPaddingHorizontalDp()), com.bytedance.ee.util.ui.n.d(2));
    }

    public final void U(BaseTagSize r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        this.f208101v2 = r100;
        R(r100.getRadiusPx());
        setTextSize(r100.getTextSizeSp());
        setGravity(17);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setPadding(com.bytedance.ee.util.ui.n.d(r100.getTextPaddingHorizontalDp()), 0, com.bytedance.ee.util.ui.n.d(r100.getTextPaddingHorizontalDp()), 0);
        setHeight(com.bytedance.ee.util.ui.n.d(r100.getHeightDp()));
    }

    public SelectTagView(Context r100, AttributeSet r101) {
        super(r100, r101);
        BaseTagSize r102 = BaseTagSize.MEDIUM;
        this.f208101v2 = r102;
        U(r102);
    }
}
