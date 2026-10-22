package com.larus.office.base.plugins.toolbar.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0014J \u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u000e\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u000bJ\u0006\u0010#\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\u0015J\u0006\u0010%\u001a\u00020\u0015J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006+"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/view/KeyboardPlaceholderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "ariseAnimator", "Landroid/animation/ValueAnimator;", "fallAnimator", "cancelFollowKeyboard", "", "onAttachedToWindow", "", "holderHeight2", "getHolderHeight2", "()I", "holderHeight", "getHolderHeight", "onDetachedFromWindow", "onKeyboardHeightChanged", "khp", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "updateHeight", "height", "ariseIfKeyboardNotShowNoAnim", "ariseIfKeyboardNotShow", "fallIfKeyboardNotShow", "handleAnimatorWithKeyboardStatus", "status", "cancelFallAnimator", "cancelAriseAnimator", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardPlaceholderView extends FrameLayout implements KeyboardHeightObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f360972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f360973b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        FLogger.f375446a.i(this.f360972a, "ariseIfKeyboardNotShow");
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        if (KeyboardHeightProvider.Factory.get((Activity) r100).isKeyboardShowing() == false) goto L5;
        return;
    L5:
        int r101 = getHolderHeight2();
        if (getLayoutParams().height != r101) goto L8;
        return;
    L8:
        b(r101);
    }

    private final int getHolderHeight() {
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        return KeyboardHeightProvider.Factory.get((Activity) r100).getVisibleKeyboardHeight();
    }

    private final int getHolderHeight2() {
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        return KeyboardHeightProvider.Factory.get((Activity) r100).keyBoardRawHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.f375446a.i(this.f360972a, "onAttachedToWindow");
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        KeyboardHeightProvider.Factory.get((Activity) r100).addKeyboardHeightObserver(this);
        b(getHolderHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.f375446a.i(this.f360972a, "onDetachedFromWindow");
        Context r100 = getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        KeyboardHeightProvider.Factory.get((Activity) r100).removeKeyboardHeightObserver(this);
    }

    public KeyboardPlaceholderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f360972a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public final void b(int r100) {
        FLogger.f375446a.i(this.f360972a, "updateHeight:" + r100);
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101.height == r100) goto L5;
        r101.height = r100;
        requestLayout();
    L5:
        if (r100 <= 0) goto L7;
        int r102 = 0;
    L9:
        if (getVisibility() == r102) goto L12;
        setVisibility(r102);
        return;
    L12:
        return;
    L7:
        r102 = 8;
        goto L9
    }

    public KeyboardPlaceholderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f360972a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    public KeyboardPlaceholderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f360972a = "KeyboardPlaceholder#" + Integer.toHexString(hashCode());
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver
    public final void onKeyboardHeightChanged(KeyboardHeightProvider r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
        FLogger.f375446a.i(this.f360972a, "onKeyboardHeightChanged:" + r101);
        if (this.f360973b == true) goto L6;
        b(getHolderHeight());
        return;
    }
}
