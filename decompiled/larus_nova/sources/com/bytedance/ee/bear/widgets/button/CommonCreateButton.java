package com.bytedance.ee.bear.widgets.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kac.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "createButtonFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getCreateButtonFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCreateButtonFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "createButtonShadowFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "getCreateButtonShadowFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "setCreateButtonShadowFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;)V", "setOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "getCreateButton", "setEnabled", "enabled", "", "setEnableStyle", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonCreateButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f240147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceShadowLayout f240148b;

    public CommonCreateButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public CommonCreateButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public CommonCreateButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final AppCompatImageView getCreateButtonFromXml() {
        KeyEvent.Callback r100 = this.f240147a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.create_button);
        this.f240147a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final SpaceShadowLayout getCreateButtonShadowFromXml() {
        KeyEvent.Callback r100 = this.f240148b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.create_button_shadow);
        this.f240148b = (SpaceShadowLayout) r100;
    L6:
        return (SpaceShadowLayout) r100;
    }

    public final AppCompatImageView getCreateButton() {
        return getCreateButtonFromXml();
    }

    public final void setCreateButtonFromXml(AppCompatImageView r100) {
        this.f240147a = r100;
    }

    public final void setCreateButtonShadowFromXml(SpaceShadowLayout r100) {
        this.f240148b = r100;
    }

    public final void setEnableStyle(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = R.style.UDShadow_S4;
    L5:
        getCreateButtonShadowFromXml().c(r101);
        if (r100 == false) goto L8;
        int r102 = R.color.widget_create_selector;
    L9:
        Drawable r103 = AppCompatResources.getDrawable(getContext(), R.drawable.widge_create_button_circle_shape);
        getCreateButtonFromXml().setImageDrawable(r103);
        l.c(getCreateButtonFromXml(), r102);
        return;
    L8:
        r102 = R.color.facade_selector_icon_n3;
        goto L9
    L4:
        r101 = R.style.UDShadow_S3_Down;
        goto L5
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        getCreateButtonFromXml().setEnabled(r100);
        if (r100 == false) goto L5;
        int r101 = R.color.ud_shadow_s4_pri;
    L6:
        getCreateButtonShadowFromXml().setShadowColor(getContext().getResources().getColor(r101));
        return;
    L5:
        r101 = R.color.ud_shadow_s4;
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        getCreateButtonFromXml().setOnClickListener(r100);
    }

    public CommonCreateButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        LayoutInflater.from(r100).inflate(R.layout.facade_layout_create_button, this, true);
        ((AppCompatImageView) findViewById(R.id.create_button_icon)).setImageResource(a.b(R.drawable.ud_icon_add_outlined));
    }
}
