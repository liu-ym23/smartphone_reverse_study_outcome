package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.popover.PopoverLinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/view/LinkPopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "", "resId", "", "setLeftIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "", "charSequence", "setTips", "Landroid/widget/ImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "tvTips", "c", "getIvArrow", "ivArrow", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class LinkPopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f402455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f402456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f402457c;

    public final ImageView getIvArrow() {
        return this.f402457c;
    }

    public final ImageView getIvIcon() {
        return this.f402455a;
    }

    public final TextView getTvTips() {
        return this.f402456b;
    }

    public LinkPopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public void setLeftIcon(int r100) {
        this.f402455a.setImageResource(r100);
        j.f(this.f402455a);
    }

    public final void setTips(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f402456b.setText(r100);
    }

    public void setLeftIcon(Drawable r100) {
        this.f402455a.setImageDrawable(r100);
        j.f(this.f402455a);
    }

    public LinkPopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout.inflate(r100, R.layout.o_popover_link_view, this);
        setOrientation(0);
        int r102 = d.n(this, 12);
        setPadding(r102, r102, r102, r102);
        setBackground(ContextCompat.getDrawable(r100, R.drawable.o_popover_view_bg));
        this.f402455a = (ImageView) findViewById(R.id.iv_icon);
        this.f402456b = (TextView) findViewById(R.id.tv_tips);
        this.f402457c = (ImageView) findViewById(R.id.iv_arrow);
    }
}
