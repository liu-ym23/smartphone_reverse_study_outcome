package com.obric.oui.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R4\u0010$\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001b8\u0006@FX\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItemCustomView;", "Landroid/widget/RelativeLayout;", "", "selected", "", "setSelected", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroid/content/res/ColorStateList;", "value", "f", "Landroid/content/res/ColorStateList;", "getTextColor", "()Landroid/content/res/ColorStateList;", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "textColor", "", ce.f26391f, "Ljava/lang/Integer;", "getSelectedBgColor", "()Ljava/lang/Integer;", "setSelectedBgColor", "(Ljava/lang/Integer;)V", "getSelectedBgColor$annotations", "()V", "selectedBgColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBottomTabItemCustomView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f403122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f403123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f403124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f403125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f403126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f403127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f403128g;

    @Deprecated(message = "2024.11.4 最新的设计规范移除了选中状态的背景色")
    public static /* synthetic */ void getSelectedBgColor$annotations() {
    }

    public final ImageView getIcon() {
        return this.f403125d;
    }

    public final Integer getSelectedBgColor() {
        return this.f403128g;
    }

    public final ColorStateList getTextColor() {
        return this.f403127f;
    }

    public final TextView getTitle() {
        return this.f403126e;
    }

    public OBottomTabItemCustomView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        Integer r101 = null;
        if (r100 == false) goto L14;
        ColorStateList r102 = this.f403127f;
        if (r102 == null) goto L8;
        r101 = Integer.valueOf(r102.getColorForState(RelativeLayout.SELECTED_STATE_SET, this.f403124c));
    L8:
        if (r101 != null) goto L10;
        int r103 = this.f403124c;
    L11:
        this.f403126e.setTextColor(r103);
        if (this.f403125d.getDrawable() == null) goto L25;
        ImageView r104 = this.f403125d;
        Drawable r105 = DrawableCompat.wrap(r104.getDrawable());
        r105.setTint(r103);
        r104.setImageDrawable(r105);
        return;
    L25:
        return;
    L10:
        r103 = r101.intValue();
        goto L11
    L14:
        ColorStateList r106 = this.f403127f;
        if (r106 == null) goto L18;
        r101 = Integer.valueOf(r106.getDefaultColor());
    L18:
        if (r101 != null) goto L20;
        int r107 = this.f403123b;
    L21:
        this.f403126e.setTextColor(r107);
        if (this.f403125d.getDrawable() == null) goto L27;
        ImageView r108 = this.f403125d;
        Drawable r109 = DrawableCompat.wrap(r108.getDrawable());
        r109.setTint(r107);
        r108.setImageDrawable(r109);
        return;
    L27:
        return;
    L20:
        r107 = r101.intValue();
        goto L21
    }

    public final void setSelectedBgColor(Integer r100) {
        this.f403128g = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setCornerRadius(getResources().getDimension(R.dimen.oui_r_m1));
        r101.setColor(r100.intValue());
    }

    public final void setTextColor(ColorStateList r100) {
        this.f403127f = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f403126e.setTextColor(r100.getDefaultColor());
        if (this.f403125d.getDrawable() == null) goto L9;
        ImageView r101 = this.f403125d;
        Drawable r102 = DrawableCompat.wrap(r101.getDrawable());
        r102.setTint(r100.getDefaultColor());
        r101.setImageDrawable(r102);
        return;
    }

    public OBottomTabItemCustomView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r100).inflate(R.layout.o_tab_bottom_item, this, true);
        this.f403122a = (FrameLayout) findViewById(R.id.icon_container);
        this.f403125d = (ImageView) findViewById(R.id.icon);
        this.f403126e = (TextView) findViewById(R.id.title);
        this.f403123b = ContextCompat.getColor(getContext(), R.color.oui_text_3);
        this.f403124c = ContextCompat.getColor(getContext(), R.color.oui_accent_fg);
    }
}
