package com.bytedance.ee.bear.widgets.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0001-B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001dH\u0016J&\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u001fJ\u0006\u0010,\u001a\u00020\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/widgets/button/CommonEditButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editButtonFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getEditButtonFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setEditButtonFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "editButtonShadowFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "getEditButtonShadowFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "setEditButtonShadowFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;)V", "editButtonContainerFromXml", "getEditButtonContainerFromXml", "()Landroid/widget/FrameLayout;", "setEditButtonContainerFromXml", "(Landroid/widget/FrameLayout;)V", "isLandscape", "", "setOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "getCreateButton", "applyFigmaEditButtonShadow", "setEnabled", "enabled", "setButtonContainerMargin", "left", "top", "right", "bottom", "setButtonPortrait", "setButtonLandscape", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonEditButton extends FrameLayout {
    public AppCompatImageView a;
    public SpaceShadowLayout b;
    public FrameLayout c;

    public static final class a implements View.OnGenericMotionListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View r1, MotionEvent r2) {
            return true;
        }
    }

    public static final class b {
    }

    static {
    }

    public CommonEditButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public CommonEditButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public CommonEditButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final FrameLayout getEditButtonContainerFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131371397);
        this.c = (FrameLayout) r0;
    L6:
        return (FrameLayout) r0;
    }

    public final AppCompatImageView getEditButtonFromXml() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131371396);
        this.a = r0;
    L6:
        return r0;
    }

    public final SpaceShadowLayout getEditButtonShadowFromXml() {
        UDShadowLayout r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131371399);
        this.b = (SpaceShadowLayout) r0;
    L6:
        return (SpaceShadowLayout) r0;
    }

    public final AppCompatImageView getCreateButton() {
        return getEditButtonFromXml();
    }

    public final void setEditButtonContainerFromXml(FrameLayout r1) {
        this.c = r1;
    }

    public final void setEditButtonFromXml(AppCompatImageView r1) {
        this.a = r1;
    }

    public final void setEditButtonShadowFromXml(SpaceShadowLayout r1) {
        this.b = r1;
    }

    @Override // android.view.View
    public void setEnabled(boolean r3) {
        getEditButtonFromXml().setEnabled(r3);
        if (r3 == false) goto L5;
        int r4 = 2131108969;
    L6:
        getEditButtonShadowFromXml().setShadowColor(getContext().getResources().getColor(r4));
        return;
    L5:
        r4 = 2131108968;
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        getEditButtonFromXml().setOnClickListener(r2);
    }

    public CommonEditButton(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        LayoutInflater.from(r2).inflate(2131561089, this, true);
        findViewById(2131371398).setImageResource(kac.a.b(2131254056));
        setVisibility(8);
        getEditButtonFromXml().setOnGenericMotionListener(a.a);
    }
}
