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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0001-B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001dH\u0016J&\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u001fJ\u0006\u0010,\u001a\u00020\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/widgets/button/CommonEditButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editButtonFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getEditButtonFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setEditButtonFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "editButtonShadowFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "getEditButtonShadowFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "setEditButtonShadowFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;)V", "editButtonContainerFromXml", "getEditButtonContainerFromXml", "()Landroid/widget/FrameLayout;", "setEditButtonContainerFromXml", "(Landroid/widget/FrameLayout;)V", "isLandscape", "", "setOnClickListener", "", "l", "Landroid/view/View$OnClickListener;", "getCreateButton", "applyFigmaEditButtonShadow", "setEnabled", "enabled", "setButtonContainerMargin", "left", "top", "right", "bottom", "setButtonPortrait", "setButtonLandscape", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonEditButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f240149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceShadowLayout f240150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f240151c;

    public static final class a implements View.OnGenericMotionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f240152a = null;

        static {
            f240152a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View r100, MotionEvent r101) {
            return true;
        }
    }

    public static final class b {
    }

    static {
    }

    public CommonEditButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public CommonEditButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public CommonEditButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final FrameLayout getEditButtonContainerFromXml() {
        KeyEvent.Callback r100 = this.f240151c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.edit_button_container);
        this.f240151c = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final AppCompatImageView getEditButtonFromXml() {
        KeyEvent.Callback r100 = this.f240149a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.edit_button);
        this.f240149a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final SpaceShadowLayout getEditButtonShadowFromXml() {
        KeyEvent.Callback r100 = this.f240150b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.edit_button_shadow);
        this.f240150b = (SpaceShadowLayout) r100;
    L6:
        return (SpaceShadowLayout) r100;
    }

    public final AppCompatImageView getCreateButton() {
        return getEditButtonFromXml();
    }

    public final void setEditButtonContainerFromXml(FrameLayout r100) {
        this.f240151c = r100;
    }

    public final void setEditButtonFromXml(AppCompatImageView r100) {
        this.f240149a = r100;
    }

    public final void setEditButtonShadowFromXml(SpaceShadowLayout r100) {
        this.f240150b = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        getEditButtonFromXml().setEnabled(r100);
        if (r100 == false) goto L5;
        int r101 = R.color.ud_shadow_s4_pri;
    L6:
        getEditButtonShadowFromXml().setShadowColor(getContext().getResources().getColor(r101));
        return;
    L5:
        r101 = R.color.ud_shadow_s4;
        goto L6
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        getEditButtonFromXml().setOnClickListener(r100);
    }

    public CommonEditButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        LayoutInflater.from(r100).inflate(R.layout.facade_layout_edit_button, this, true);
        ((AppCompatImageView) findViewById(R.id.edit_button_icon)).setImageResource(kac.a.b(R.drawable.ud_icon_ccm_edit_outlined));
        setVisibility(8);
        getEditButtonFromXml().setOnGenericMotionListener(a.f240152a);
    }
}
