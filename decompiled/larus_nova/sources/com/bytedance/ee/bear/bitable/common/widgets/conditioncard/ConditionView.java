package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.util.ui.n;
import com.google.android.flexbox.FlexboxLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\"J\u000e\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020 2\u0006\u0010$\u001a\u00020%J\u0006\u0010*\u001a\u00020 R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "onCardRemoveListener", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView$OnCardRemoveListener;", "getOnCardRemoveListener", "()Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView$OnCardRemoveListener;", "setOnCardRemoveListener", "(Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionView$OnCardRemoveListener;)V", "conditionCellContainer", "Lcom/google/android/flexbox/FlexboxLayout;", "conditionCardTitle", "Landroid/widget/TextView;", "conditionCardClose", "Landroid/widget/ImageView;", "warningLayout", "warningInfoTv", "toPx", "", "addCellView", "Landroid/view/View;", "conditionItem", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionItem;", "generateCellView", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionCellView;", "setWarningInfo", "", "warningInfo", "", "setWarningInfoVisible", "visible", "", "setConditionTitle", "title", "setConditionTitleVisible", "setConditionCloseVisible", "removeAllCellView", "OnCardRemoveListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConditionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f209911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlexboxLayout f209912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f209913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f209914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f209915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f209916f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionView f209917a;

        public a(ConditionView r100) {
            this.f209917a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f209917a.getOnCardRemoveListener();
            if (r101 == null) goto L6;
            r101.onRemove();
            return;
        }
    }

    public interface b {
        void onRemove();
    }

    public final b getOnCardRemoveListener() {
        return this.f209911a;
    }

    public ConditionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setConditionCloseVisible(boolean r100) {
        ImageView r101 = this.f209914d;
        Integer r102 = 0;
        r102.intValue();
        if (r100 == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        r101.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    }

    public final void setConditionTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f209913c.setText(r100);
        this.f209913c.setVisibility(0);
    }

    public final void setConditionTitleVisible(boolean r100) {
        TextView r101 = this.f209913c;
        Integer r102 = 0;
        r102.intValue();
        if (r100 == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        r101.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    }

    public final void setOnCardRemoveListener(b r100) {
        this.f209911a = r100;
    }

    public final void setWarningInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "warningInfo");
        this.f209916f.setText(r100);
        this.f209915e.setVisibility(0);
    }

    public final void setWarningInfoVisible(boolean r100) {
        LinearLayout r101 = this.f209915e;
        Integer r102 = 0;
        r102.intValue();
        if (r100 == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L9:
        r101.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    }

    public ConditionView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        setPadding(n.d(16), n.d(14), n.d(16), n.d(8));
        setOrientation(1);
        setBackground(AppCompatResources.getDrawable(r110, R.drawable.facade_round_around_xl));
        setBackgroundTintList(ColorStateList.valueOf(r110.getResources().getColor(R.color.facade_selector_item_float)));
        LinearLayout r100 = new LinearLayout(r110);
        r100.setOrientation(0);
        r100.setGravity(16);
        TextView r101 = new TextView(r110);
        this.f209913c = r101;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);
        r102.weight = 1.0f;
        r101.setLayoutParams(r102);
        r101.setTextSize(14.0f);
        r101.setTextColor(r110.getResources().getColor(R.color.text_placeholder));
        r101.setVisibility(4);
        r100.addView(r101);
        ImageView r103 = new ImageView(r110);
        this.f209914d = r103;
        r103.setPadding(n.d(4), n.d(4), n.d(4), n.d(4));
        r103.setImageResource(R.drawable.ud_icon_close_outlined);
        r103.setImageTintList(AppCompatResources.getColorStateList(r110, R.color.icon_n3));
        r103.setBackground(AppCompatResources.getDrawable(r110, R.drawable.facade_round_around_s));
        r103.setBackgroundTintList(AppCompatResources.getColorStateList(r110, R.color.facade_selector_item_transparent));
        r103.setLayoutParams(new LinearLayout.LayoutParams(n.d(24), n.d(24)));
        r103.setOnClickListener(new a(this));
        r100.addView(r103);
        addView(r100);
        FlexboxLayout r104 = new FlexboxLayout(r110);
        this.f209912b = r104;
        r104.setVisibility(8);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-1, -2);
        r105.setMargins(0, n.d(8), 0, 0);
        r104.setLayoutParams(r105);
        r104.setFlexDirection(0);
        r104.setFlexWrap(1);
        addView(r104);
        LinearLayout r106 = new LinearLayout(r110);
        this.f209915e = r106;
        r106.setVisibility(8);
        r106.setOrientation(0);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-1, -2);
        r107.gravity = 16;
        r107.setMargins(0, n.d(8), 0, n.d(8));
        r106.setLayoutParams(r107);
        ImageView r112 = new ImageView(r110);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(n.d(18), n.d(18));
        r108.setMargins(0, 0, n.d(5), 0);
        r112.setLayoutParams(r108);
        r112.setImageResource(R.drawable.ud_icon_warning_colorful);
        r106.addView(r112);
        TextView r113 = new TextView(r110);
        this.f209916f = r113;
        new LinearLayout.LayoutParams(-2, -2);
        r113.setTextSize(14.0f);
        r113.setTextColor(r113.getResources().getColor(R.color.text_placeholder));
        r106.addView(r113);
        addView(r106);
    }
}
