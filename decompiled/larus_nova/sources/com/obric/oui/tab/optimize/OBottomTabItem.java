package com.obric.oui.tab.optimize;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wma.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006%"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabItem;", "Landroid/widget/RelativeLayout;", "", "selected", "", "setSelected", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "getSelectedIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectedIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "selectedIconDrawable", "e", "getUnselectedIconDrawable", "setUnselectedIconDrawable", "unselectedIconDrawable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBottomTabItem extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f403231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f403232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f403233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f403234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f403235e;

    public static final class a {
    }

    static {
    }

    public final ImageView getIcon() {
        return this.f403232b;
    }

    public final Drawable getSelectedIconDrawable() {
        return this.f403234d;
    }

    public final TextView getTitle() {
        return this.f403233c;
    }

    public final Drawable getUnselectedIconDrawable() {
        return this.f403235e;
    }

    public OBottomTabItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setImageAndTextTintColor(int r100) {
        a(r100, ContextCompat.getColor(getContext(), R.color.oui_text_3b), ContextCompat.getColor(getContext(), R.color.oui_accent_bg_low_contrast));
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        Drawable r101 = this.f403234d;
        if (r101 == null) goto L10;
        Drawable r102 = this.f403235e;
        if (r102 == null) goto L10;
        if (r100 == false) goto L9;
        this.f403232b.setImageDrawable(r101);
    L11:
        if (r100 == false) goto L13;
        this.f403233c.setTextAppearance(R.style.Label_S_Thick);
        return;
    L13:
        this.f403233c.setTextAppearance(R.style.Label_S);
        return;
    L9:
        this.f403232b.setImageDrawable(r102);
    L10:
        b.h("optimize.OBottomTabItem", "please set selectedIconDrawable and unselectedIconDrawable");
        goto L11
    }

    public final void setSelectedIconDrawable(Drawable r100) {
        this.f403234d = r100;
    }

    public final void setUnselectedIconDrawable(Drawable r100) {
        this.f403235e = r100;
    }

    public OBottomTabItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        setFocusable(false);
        LayoutInflater.from(r100).inflate(R.layout.o_tab_bottom_item, this, true);
        this.f403231a = (FrameLayout) findViewById(R.id.icon_container);
        this.f403232b = (ImageView) findViewById(R.id.icon);
        this.f403233c = (TextView) findViewById(R.id.title);
        a(ContextCompat.getColor(getContext(), R.color.oui_accent_fg), ContextCompat.getColor(getContext(), R.color.oui_text_3b), ContextCompat.getColor(getContext(), R.color.oui_accent_bg_low_contrast));
    }

    public final void a(int r100, int r101, int r102) {
        ColorStateList r103 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{r100, r101});
        this.f403232b.setImageTintList(r103);
        this.f403233c.setTextColor(r103);
    }
}
