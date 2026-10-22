package com.bytedance.ee.bear.bitable.uikit.setting.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.common.e;
import com.bytedance.ee.bear.bitable.databinding.BitableCardViewSettingCardLayoutBinding;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/setting/card/CardLayout;", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/setting/card/CardLayoutData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardViewSettingCardLayoutBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "applyShowCover", "showCover", "", "applyCol", "col", "appleSelect", "select", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardLayout extends RoundFrameLayout implements b<Object> {
    public final BitableCardViewSettingCardLayoutBinding g;

    public CardLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public CardLayout(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        View r14 = LayoutInflater.from(r11).inflate(2131558891, this, false);
        addView(r14);
        int r16 = 2131367095;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131367095);
        if (r2 == null) goto L23;
        r16 = 2131367096;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131367096);
        if (r3 == null) goto L23;
        r16 = 2131367097;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131367097);
        if (r4 == null) goto L23;
        r16 = 2131367098;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131367098);
        if (r5 == null) goto L23;
        r16 = 2131367099;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131367099);
        if (r6 == null) goto L23;
        r16 = 2131367102;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131367102);
        if (r7 == null) goto L23;
        r16 = 2131367092;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131367092)) == null) goto L23;
        r16 = 2131368133;
        View r8 = ViewBindings.findChildViewById(r14, 2131368133);
        if (r8 == null) goto L23;
        r16 = 2131377892;
        View r9 = ViewBindings.findChildViewById(r14, 2131377892);
        if (r9 == null) goto L23;
        this.g = new BitableCardViewSettingCardLayoutBinding((LinearLayout) r14, r2, r3, r4, r5, r6, r7, r8, r9);
        this.e = true;
        e.b(this, 0.97f, 4);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r16)));
    }

    public /* synthetic */ CardLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
