package com.bytedance.ee.android.file.picker.lib.v2.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerMainMenuBinding;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011J\u001c\u0010\u001c\u001a\u00020\u00142\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015J\u001c\u0010\u001d\u001a\u00020\u00142\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017J\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u0014J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0002J\"\u0010$\u001a\u00020\u00142\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b'H\u0082\bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/ui/view/PickerMenuView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mMenuHeight", "", "mBinding", "Lkotlin/Lazy;", "Lcom/bytedance/ee/android/file/picker/lib/databinding/FilePickerMainMenuBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "mTitle", "", "mSystemPickerClickListener", "Landroid/view/View$OnClickListener;", "mOnShowListener", "Lkotlin/Function0;", "", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/view/OnShowListener;", "mOnDismissListener", "Lcom/bytedance/ee/android/file/picker/lib/v2/ui/view/OnDismissListener;", d.f25925o, "text", "setSystemPickerClickListener", "listener", "setOnShowListener", "setOnDismissListener", "toggle", "isShowing", "", "show", "dismiss", "playAnim", "withBindingInitialized", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerMenuView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f206148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<FilePickerMainMenuBinding> f206149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f206150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f206151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f206152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f206153f;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f206154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PickerMenuView f206155b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f206154a == true) goto L6;
            this.f206155b.setVisibility(8);
            return;
        }

        public a(boolean r100, PickerMenuView r101) {
            this.f206154a = r100;
            this.f206155b = r101;
        }
    }

    public final void S5() {
        if (this.f206149b.isInitialized() == true) goto L5;
    L10:
        boolean r100 = false;
    L11:
        if (r100 == false) goto L15;
        R5(false);
        Function0<Unit> r101 = this.f206153f;
        if (r101 == null) goto L19;
        r101.invoke();
        return;
    L19:
        return;
    L15:
        setVisibility(0);
        R5(true);
        Function0<Unit> r102 = this.f206152e;
        if (r102 == null) goto L21;
        r102.invoke();
        return;
    L21:
        return;
    L5:
        if (getVisibility() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        r100 = true;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public PickerMenuView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void R5(boolean r100) {
        if (r100 == false) goto L4;
    L6:
        FilePickerMainMenuBinding r101 = this.f206149b.getValue();
        float r102 = 0.0f;
        if (r100 == false) goto L9;
        r102 = 1.0f;
        float r103 = 0.0f;
    L10:
        r101.f206005d.animate().alpha(r102).start();
        r101.f206004c.animate().translationY(r103).start();
        r101.f206003b.animate().translationY(r103).setListener(new a(r100, this)).start();
        return;
    L9:
        r103 = -this.f206148a;
        goto L10
    L4:
        if (this.f206149b.isInitialized() == true) goto L6;
    }

    public final void setOnDismissListener(Function0<Unit> r100) {
        this.f206153f = r100;
    }

    public final void setOnShowListener(Function0<Unit> r100) {
        this.f206152e = r100;
    }

    public final void setSystemPickerClickListener(View.OnClickListener r100) {
        this.f206151d = r100;
    }

    public final void setTitle(String r100) {
        this.f206150c = r100;
        if (this.f206149b.isInitialized() == false) goto L6;
        this.f206149b.getValue().f206003b.setText(this.f206150c);
        return;
    }

    public PickerMenuView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f206148a = UIUtils.dp2px(r100, 104.0f);
        this.f206149b = LazyKt.lazy(new PickerMenuView$mBinding$1(this));
    }
}
