package com.bytedance.ee.bear.bitable.card.view.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/record/FieldGroupHeaderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/util/io/NonProguard;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "leftIconView", "Landroidx/appcompat/widget/AppCompatImageView;", "titleView", "Landroidx/appcompat/widget/AppCompatTextView;", "descIconView", "chevronView", "dividerView", "Landroid/view/View;", d.f25925o, "", "name", "", "setDescriptionVisible", "visible", "", "setDescriptionClickListener", "listener", "Landroid/view/View$OnClickListener;", "setFolded", "isFolded", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldGroupHeaderView extends FrameLayout implements NonProguard {
    private final AppCompatImageView chevronView;
    private final AppCompatImageView descIconView;
    private final View dividerView;
    private final AppCompatImageView leftIconView;
    private final AppCompatTextView titleView;

    /* JADX WARN: Multi-variable type inference failed */
    public FieldGroupHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    public final void setDescriptionClickListener(View.OnClickListener r100) {
        this.descIconView.setOnClickListener(r100);
    }

    public final void setDescriptionVisible(boolean r100) {
        AppCompatImageView r101 = this.descIconView;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setFolded(boolean r100) {
        AppCompatImageView r101 = this.chevronView;
        if (r100 == false) goto L5;
        float r102 = 270.0f;
    L6:
        r101.setRotation(r102);
        ViewGroup.LayoutParams r103 = this.dividerView.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        return;
    L9:
        if (r100 == false) goto L11;
        float r104 = 16.0f;
    L12:
        int r105 = n.c(r104);
        int r106 = n.c(16.0f);
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r103;
        r107.setMarginStart(r105);
        r107.leftMargin = r105;
        r107.rightMargin = r106;
        this.dividerView.setLayoutParams(r103);
        return;
    L11:
        r104 = 38.0f;
        goto L12
    L5:
        r102 = 0.0f;
        goto L6
    }

    public final void setTitle(String r100) {
        AppCompatTextView r101 = this.titleView;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r101.setText(r100);
    }

    public FieldGroupHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_field_group_header_item, this, true);
        this.leftIconView = (AppCompatImageView) findViewById(R.id.field_group_left_icon);
        this.titleView = (AppCompatTextView) findViewById(R.id.field_group_title);
        this.descIconView = (AppCompatImageView) findViewById(R.id.field_group_desc_icon);
        this.chevronView = (AppCompatImageView) findViewById(R.id.field_group_chevron_icon);
        this.dividerView = findViewById(R.id.field_group_divider);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        Object r100 = this.titleView.getParent();
        if ((r100 instanceof View) == false) goto L5;
        View r101 = (View) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = r101.getMeasuredWidth();
        if (r102 > 0) goto L11;
        return;
    L11:
        int r103 = r101.getPaddingStart();
        int r104 = r101.getPaddingEnd();
        int r105 = this.leftIconView.getMeasuredWidth();
        ViewGroup.LayoutParams r106 = this.titleView.getLayoutParams();
        int r107 = 0;
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        int r108 = ((ViewGroup.MarginLayoutParams) r106).getMarginStart();
    L15:
        ViewGroup.LayoutParams r109 = this.descIconView.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        int r112 = ((ViewGroup.MarginLayoutParams) r109).getMarginStart();
    L19:
        int r113 = this.descIconView.getMeasuredWidth();
        if (this.descIconView.getVisibility() != 0) goto L22;
        boolean r114 = true;
    L23:
        ViewGroup.LayoutParams r115 = this.chevronView.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        int r116 = ((ViewGroup.MarginLayoutParams) r115).getMarginStart();
    L27:
        int r117 = this.chevronView.getMeasuredWidth();
        int r118 = (((r102 - r103) - r104) - r105) - r108;
        if (r114 == true) goto L31;
        r112 = 0;
    L31:
        int r119 = r118 - r112;
        if (r114 == false) goto L34;
        r107 = r113;
    L34:
        int r120 = ((r119 - r107) - r116) - r117;
        if (r120 <= 0) goto L38;
        this.titleView.setMaxWidth(r120);
        super.onMeasure(r110, r111);
        return;
    L38:
        return;
    L26:
        r116 = 0;
        goto L27
    L22:
        r114 = false;
        goto L23
    L18:
        r112 = 0;
        goto L19
    L14:
        r108 = 0;
        goto L15
    L5:
        r101 = null;
        goto L6
    }

    public /* synthetic */ FieldGroupHeaderView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
