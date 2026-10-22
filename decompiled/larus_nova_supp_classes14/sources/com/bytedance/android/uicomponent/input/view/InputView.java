package com.bytedance.android.uicomponent.input.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import fm3.e;
import java.lang.reflect.Field;
import jm3.b;
import jm3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001!B\u0019\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0006H&J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001fR$\u0010'\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00105\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020\r8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006Q"}, d2 = {"Lcom/bytedance/android/uicomponent/input/view/InputView;", "Landroid/widget/FrameLayout;", "", "hint", "", "setErrorHint", "", "type", "setInputType", "getLayoutID", "", "size", "setTextSize", "Landroid/widget/EditText;", "getEditText", "setHint", "value", "setValue", "getValue", "color", "setCursorColor", "max", "setMaxNumber", "Landroid/text/TextWatcher;", "watcher", "setTextWatcher", "Landroid/widget/TextView$OnEditorActionListener;", "listener", "setOnEditorActionListener", "Landroid/view/View$OnFocusChangeListener;", "setEditFocusChangeListener", "Lim3/a;", "setOnClearListener", "a", "Landroid/text/TextWatcher;", "getMTextWatcher", "()Landroid/text/TextWatcher;", "setMTextWatcher", "(Landroid/text/TextWatcher;)V", "mTextWatcher", "b", "Landroid/widget/TextView$OnEditorActionListener;", "getMOnEditorActionListener", "()Landroid/widget/TextView$OnEditorActionListener;", "setMOnEditorActionListener", "(Landroid/widget/TextView$OnEditorActionListener;)V", "mOnEditorActionListener", "c", "Landroid/view/View$OnFocusChangeListener;", "getMOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setMOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "mOnFocusChangeListener", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getMErrorHintTv", "()Landroid/widget/TextView;", "setMErrorHintTv", "(Landroid/widget/TextView;)V", "mErrorHintTv", "e", "Landroid/widget/EditText;", "getMEditText", "()Landroid/widget/EditText;", "setMEditText", "(Landroid/widget/EditText;)V", "mEditText", "mOnClearListener", "Lim3/a;", "getMOnClearListener", "()Lim3/a;", "setMOnClearListener", "(Lim3/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class InputView extends FrameLayout {
    public TextWatcher a;
    public TextView.OnEditorActionListener b;
    public View.OnFocusChangeListener c;
    public TextView d;
    public EditText e;
    public TextView f;
    public int g;
    public String h;
    public String i;
    public boolean j;
    public float k;

    public static final class a {
    }

    static {
    }

    public abstract void b();

    public abstract void c();

    public abstract void d(TypedArray r1);

    public abstract void e();

    public abstract int getLayoutID();

    public final im3.a getMOnClearListener() {
        return null;
    }

    public final void setMOnClearListener(im3.a r1) {
    }

    public final void setOnClearListener(im3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void f() {
        if (this.g == 0) goto L24;
        EditText r0 = this.e;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L7:
        r0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.g)});
        if (this.j == false) goto L19;
        TextView r1 = this.f;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mMaxNumberTv");
    L12:
        r1.setVisibility(0);
        EditText r2 = this.e;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L15:
        int r3 = r2.length();
        TextView r4 = this.f;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mMaxNumberTv");
    L18:
        StringBuilder r5 = new StringBuilder();
        r5.append(r3);
        r5.append('/');
        r5.append(this.g);
        r4.setText(r5.toString());
        return;
    L19:
        TextView r6 = this.f;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mMaxNumberTv");
    L22:
        r6.setVisibility(8);
        return;
    }

    public final EditText getEditText() {
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        return r0;
    }

    public final EditText getMEditText() {
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        return r0;
    }

    public final TextView getMErrorHintTv() {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L5:
        return r0;
    }

    public final String getValue() {
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        Editable r1 = r0.getEditableText();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.toString();
    }

    public final TextView.OnEditorActionListener getMOnEditorActionListener() {
        return this.b;
    }

    public final View.OnFocusChangeListener getMOnFocusChangeListener() {
        return this.c;
    }

    public final TextWatcher getMTextWatcher() {
        return this.a;
    }

    public void a(Editable r2) {
        TextWatcher r0 = this.a;
        if (r0 == null) goto L6;
        r0.afterTextChanged(r2);
        return;
    }

    public final void setCursorColor(int r3) {
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        g(r0, r3);
    }

    public final void setEditFocusChangeListener(View.OnFocusChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void setErrorHint(String r4) {
        if (r4 != null) goto L11;
        TextView r5 = this.d;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L7:
        r5.setVisibility(8);
        TextView r6 = this.d;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L10:
        r6.setText(null);
        b();
        return;
    L11:
        TextView r1 = this.d;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L14:
        r1.setVisibility(0);
        TextView r2 = this.d;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mErrorHintTv");
    L17:
        r2.setText(r4);
        c();
    }

    public final void setHint(String r3) {
        Intrinsics.checkNotNullParameter(r3, "hint");
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r0.setHint(r3);
    }

    public final void setInputType(int r3) {
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r0.setInputType(r3);
    }

    public final void setMEditText(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMErrorHintTv(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMOnEditorActionListener(TextView.OnEditorActionListener r1) {
        this.b = r1;
    }

    public final void setMOnFocusChangeListener(View.OnFocusChangeListener r1) {
        this.c = r1;
    }

    public final void setMTextWatcher(TextWatcher r1) {
        this.a = r1;
    }

    public final void setMaxNumber(int r1) {
        this.g = r1;
        f();
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public final void setTextSize(float r3) {
        this.k = r3;
        EditText r4 = this.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r4.setTextSize(1, this.k);
    }

    public final void setTextWatcher(TextWatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        this.a = r2;
    }

    public final void setValue(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        EditText r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r0.setText(r3);
        EditText r4 = this.e;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L8:
        Editable r5 = r4.getText();
        if (r5 == null) goto L15;
        EditText r1 = this.e;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L13:
        r1.setSelection(r5.toString().length());
        return;
    }

    public InputView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attributes");
        super(r4, r5);
        this.k = 15.0f;
        LayoutInflater.from(r4).inflate(getLayoutID(), this, true);
        TypedArray r6 = getContext().obtainStyledAttributes(r5, new int[]{2130969951, 2130970216, 2130970367, 2130970369, 2130970384, 2130972702, 2130974073, 2130974574, 2130974584, 2130974593, 2130975025});
        this.g = r6.getInt(5, 0);
        this.j = r6.getBoolean(6, false);
        this.i = r6.getString(10);
        this.h = r6.getString(1);
        this.k = r6.getDimension(2, e.a(getContext(), 15.0f));
        d(r6);
        r6.recycle();
        this.d = (TextView) findViewById(2131375426);
        EditText r7 = (EditText) findViewById(2131375425);
        this.e = r7;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L5:
        r7.setTextSize(0, this.k);
        EditText r8 = this.e;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L8:
        r8.addTextChangedListener(new jm3.a(this));
        EditText r9 = this.e;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L11:
        r9.setOnEditorActionListener(new b(this));
        EditText r10 = this.e;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L14:
        r10.setOnFocusChangeListener(new c(this));
        EditText r11 = this.e;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L17:
        g(r11, getContext().getResources().getColor(2131108348));
        String r12 = this.h;
        if (r12 == null) goto L23;
        EditText r0 = this.e;
        if (r0 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L22:
        r0.setHint(r12);
    L23:
        String r13 = this.i;
        if (r13 == null) goto L29;
        EditText r1 = this.e;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L28:
        r1.setText(r13);
    L29:
        this.f = (TextView) findViewById(2131375430);
        f();
        e();
    }

    public final void g(TextView r6, int r7) {
        Field r1 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L5
        r1.setAccessible(true);     // Catch: Throwable -> L5
    L6:
        if (r1 != null) goto L26;
    L12:
        Object r2 = r6;
    L13:
        if (r1 != null) goto L15;
        Class<?> r3 = TextView.class;
    L16:
        Field r4 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L10
        r4.setAccessible(true);     // Catch: Throwable -> L10
        Drawable r8 = getContext().getDrawable(r4.getInt(r6));     // Catch: Throwable -> L10
        if (r8 != null) goto L19;
        return;
    L19:
        r8.setTint(r7);     // Catch: Throwable -> L10
        if (Build.VERSION.SDK_INT < 28) goto L22;
        Field r9 = r3.getDeclaredField("mDrawableForCursor");     // Catch: Throwable -> L10
        r9.setAccessible(true);     // Catch: Throwable -> L10
        r9.set(r2, r8);     // Catch: Throwable -> L10
        return;
    L22:
        Field r10 = r3.getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L10
        r10.setAccessible(true);     // Catch: Throwable -> L10
        r10.set(r2, new Drawable[]{r8, r8});     // Catch: Throwable -> L10
        return;
    L15:
        r3 = r2.getClass();     // Catch: Throwable -> L10
        goto L16
    L26:
        r2 = r1.get(r6);     // Catch: Throwable -> L10
        if (r2 != null) goto L13;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
