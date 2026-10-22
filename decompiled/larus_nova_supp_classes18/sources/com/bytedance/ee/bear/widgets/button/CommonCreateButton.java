package com.bytedance.ee.bear.widgets.button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.util.ui.l;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kac.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/widgets/button/CommonCreateButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "createButtonFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getCreateButtonFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCreateButtonFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "createButtonShadowFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "getCreateButtonShadowFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "setCreateButtonShadowFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;)V", "setOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "getCreateButton", "setEnabled", "enabled", "", "setEnableStyle", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonCreateButton extends FrameLayout {
    public AppCompatImageView a;
    public SpaceShadowLayout b;

    public CommonCreateButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public CommonCreateButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public CommonCreateButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final AppCompatImageView getCreateButtonFromXml() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131368189);
        this.a = r0;
    L6:
        return r0;
    }

    public final SpaceShadowLayout getCreateButtonShadowFromXml() {
        UDShadowLayout r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131368191);
        this.b = (SpaceShadowLayout) r0;
    L6:
        return (SpaceShadowLayout) r0;
    }

    public final AppCompatImageView getCreateButton() {
        return getCreateButtonFromXml();
    }

    public final void setCreateButtonFromXml(AppCompatImageView r1) {
        this.a = r1;
    }

    public final void setCreateButtonShadowFromXml(SpaceShadowLayout r1) {
        this.b = r1;
    }

    public final void setEnableStyle(boolean r3) {
        if (r3 == false) goto L4;
        int r0 = 2131953893;
    L5:
        getCreateButtonShadowFromXml().c(r0);
        if (r3 == false) goto L8;
        int r4 = 2131109417;
    L9:
        Drawable r1 = AppCompatResources.getDrawable(getContext(), 2131256543);
        getCreateButtonFromXml().setImageDrawable(r1);
        l.c(getCreateButtonFromXml(), r4);
        return;
    L8:
        r4 = 2131101929;
        goto L9
    L4:
        r0 = 2131953888;
        goto L5
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        getCreateButtonFromXml().setEnabled(r3);
        if (r3 == false) goto L5;
        int r4 = 2131108969;
    L6:
        getCreateButtonShadowFromXml().setShadowColor(getContext().getResources().getColor(r4));
        return;
    L5:
        r4 = 2131108968;
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        getCreateButtonFromXml().setOnClickListener(r2);
    }

    public CommonCreateButton(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        LayoutInflater.from(r2).inflate(2131561088, this, true);
        findViewById(2131368190).setImageResource(a.b(2131253548));
    }
}
