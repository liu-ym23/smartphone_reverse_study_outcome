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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/setting/card/CardLayout;", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/setting/card/CardLayoutData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardViewSettingCardLayoutBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "applyShowCover", "showCover", "", "applyCol", "col", "appleSelect", "select", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardLayout extends RoundFrameLayout implements b<Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BitableCardViewSettingCardLayoutBinding f216222g;

    public CardLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public CardLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        View r113 = LayoutInflater.from(r110).inflate(R.layout.bitable_card_view_setting_card_layout, this, false);
        addView(r113);
        int r114 = R.id.col_2;
        LinearLayout r100 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.col_2);
        if (r100 == null) goto L23;
        r114 = R.id.col_3;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.col_3);
        if (r101 == null) goto L23;
        r114 = R.id.col_4;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.col_4);
        if (r102 == null) goto L23;
        r114 = R.id.col_5;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.col_5);
        if (r103 == null) goto L23;
        r114 = R.id.col_6;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.col_6);
        if (r104 == null) goto L23;
        r114 = R.id.col_num;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r113, R.id.col_num);
        if (r105 == null) goto L23;
        r114 = R.id.colSelect1;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.colSelect1)) == null) goto L23;
        r114 = R.id.cover;
        View r106 = ViewBindings.findChildViewById(r113, R.id.cover);
        if (r106 == null) goto L23;
        r114 = R.id.line1;
        View r107 = ViewBindings.findChildViewById(r113, R.id.line1);
        if (r107 == null) goto L23;
        this.f216222g = new BitableCardViewSettingCardLayoutBinding((LinearLayout) r113, r100, r101, r102, r103, r104, r105, r106, r107);
        this.f226533e = true;
        e.b(this, 0.97f, 4);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public /* synthetic */ CardLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
