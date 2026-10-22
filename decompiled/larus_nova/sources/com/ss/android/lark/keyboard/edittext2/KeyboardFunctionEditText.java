package com.ss.android.lark.keyboard.edittext2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.keyboard.edittext2.compat.c;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rcc.d;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0012J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J$\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0012\u00103\u001a\u00020\u00192\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0016J\u001b\u00105\u001a\u00020\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0000¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020$2\u0006\u0010&\u001a\u000209H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/KeyboardFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSizeChangeListener", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "selectionChangeListener", "Lcom/ss/android/lark/keyboard/edittext2/compat/OnSelectionChangedListener;", "keyPreIMeHandler", "Lcom/ss/android/lark/keyboard/edittext2/compat/OnKeyPreImeHandler;", "multiOnKeyListener", "", "Landroid/view/View$OnKeyListener;", "getMultiOnKeyListener", "()Ljava/util/List;", "setMultiOnKeyListener", "(Ljava/util/List;)V", "actionOnTouchFinish", "Lkotlin/Function0;", "", "setOnKeyPreImeHandler", "keyPreImeHandler", "setSelectionChangedListener", "listener", "setOnSizeChangeListener", "addOnKeyListener", "onKeyListener", "index", "removeOnKeyListener", "onKeyPreIme", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSelectionChanged", "selStart", "selEnd", "onSizeChanged", "w", "h", "oldw", "oldh", "handleKey", BaseSwitches.V, "Landroid/view/View;", "setOnKeyListener", "l", "doOnTouchFinish", "action", "doOnTouchFinish$keyboard_base_release", "onTouchEvent", "Landroid/view/MotionEvent;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class KeyboardFunctionEditText extends RichTextFunctionEditText {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f428951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.keyboard.edittext2.compat.d f428952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f428953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<View.OnKeyListener> f428954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f428955j;

    public static final class b {
    }

    static {
    }

    public KeyboardFunctionEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KeyboardFunctionEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public void setOnKeyListener(View.OnKeyListener r100) {
    }

    public final List<View.OnKeyListener> getMultiOnKeyListener() {
        return this.f428954i;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = super.onTouchEvent(r100);
        this.f428955j.invoke();
        return r101;
    }

    public final void setMultiOnKeyListener(List<View.OnKeyListener> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428954i = r100;
    }

    public final void setOnKeyPreImeHandler(c r100) {
        this.f428953h = r100;
    }

    public final void setOnSizeChangeListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onSizeChangeListener");
        this.f428951f = r100;
    }

    public final void setSelectionChangedListener(com.ss.android.lark.keyboard.edittext2.compat.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f428952g = r100;
        r100.C(getSelectionStart(), getSelectionEnd());
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int r100, KeyEvent r101) {
        c r102 = this.f428953h;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        return true;
    L11:
        if (r100 != 66) goto L20;
        if (r101 != null) goto L14;
    L16:
        if (r103 == false) goto L20;
        dispatchKeyEvent(r101);
        return true;
    L14:
        if (r101.isShiftPressed() != true) goto L16;
        r103 = true;
    L20:
        return super.onKeyPreIme(r100, r101);
    L5:
        if (r102.a(r100, r101) != true) goto L7;
        r104 = true;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText, android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        com.ss.android.lark.keyboard.edittext2.compat.d r102 = this.f428952g;
        if (r102 == null) goto L6;
        r102.C(getSelectionStart(), getSelectionEnd());
        return;
    }

    public KeyboardFunctionEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f428954i = new ArrayList();
        this.f428955j = KeyboardFunctionEditText$actionOnTouchFinish$1.INSTANCE;
        super.setOnKeyListener(new a(this));
    }

    public /* synthetic */ KeyboardFunctionEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d r104 = this.f428951f;
        if (r104 == null) goto L6;
        r104.a(r100, r102, r103);
        return;
    }
}
