package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/ECAutoHideKeyboardLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAutoHideKeyboardLayout extends FrameLayout {
    public ECAutoHideKeyboardLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECAutoHideKeyboardLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static View a(View r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.isFocused() == false) goto L9;
        return r2;
    L9:
        if ((r2 instanceof ViewGroup) == false) goto L12;
        return a(((ViewGroup) r2).getFocusedChild());
    L12:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getAction() != 0) goto L22;
        View r0 = a(this);
        if ((r0 instanceof EditText) == false) goto L22;
        Rect r1 = new Rect();
        r0.getGlobalVisibleRect(r1);
        if (r1.contains((int) r5.getRawX(), (int) r5.getRawY()) == true) goto L22;
        r0.clearFocus();
        EditText r2 = (EditText) r0;
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == true) goto L11;
        r3 = null;
    L11:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L14;
        r4.clearChildFocus(r0);
    L14:
        int r6 = o.a;
        Context r7 = getContext();
        Intrinsics.checkNotNullParameter(r2, "editText");
        if (r7 == null) goto L22;
        Object r8 = r7.getSystemService("input_method");
        if (r8 == null) goto L20;
        ((InputMethodManager) r8).hideSoftInputFromWindow(r2.getWindowToken(), 0);
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L22:
        return super.dispatchTouchEvent(r5);
    }

    public ECAutoHideKeyboardLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECAutoHideKeyboardLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
