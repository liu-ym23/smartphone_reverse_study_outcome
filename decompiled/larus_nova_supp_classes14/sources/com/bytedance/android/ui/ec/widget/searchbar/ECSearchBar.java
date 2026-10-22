package com.bytedance.android.ui.ec.widget.searchbar;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u0012J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0006\u0010*\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/searchbar/ECSearchBar;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "ivClear", "Landroid/view/View;", "tvAction", "Landroid/widget/TextView;", "addTextChangedListener", "", "textWatcher", "Landroid/text/TextWatcher;", "clearEditFocus", "getText", "", "hideClear", "hideSoftInput", "view", "hideTextAction", "setActionText", "text", "", "setHint", "hint", "setOnEditorActionListener", "editorActionListener", "Landroid/widget/TextView$OnEditorActionListener;", "setText", "setTextActionClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "showClear", "showSoftInput", "showTextAction", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBar extends RoundConstraintLayout {
    private final View.OnFocusChangeListener defaultFocusChangeListener;
    private final AppCompatEditText editText;
    private final View ivClear;
    private final TextView tvAction;

    public ECSearchBar(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ECSearchBar(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public final void clearEditFocus() {
        this.editText.clearFocus();
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final void hideClear() {
        this.ivClear.setVisibility(8);
    }

    public final void hideTextAction() {
        this.tvAction.setVisibility(8);
    }

    public final void showClear() {
        this.ivClear.setVisibility(0);
    }

    public final void showTextAction() {
        this.tvAction.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSoftInput(View r3) {
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L5;
        r0 = null;
    L5:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L9;
        r1.showSoftInput(r3, 0);
        return;
    }

    public final void addTextChangedListener(TextWatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "textWatcher");
        this.editText.addTextChangedListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hideSoftInput(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Object r0 = getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L5;
        r0 = null;
    L5:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L9;
        r1.hideSoftInputFromWindow(r3.getWindowToken(), 0);
        return;
    }

    public final void setActionText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.tvAction.setText(r2);
    }

    public final void setHint(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        this.editText.setHint(r2);
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "editorActionListener");
        this.editText.setOnEditorActionListener(r2);
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.editText.setText(r2);
    }

    public final void setTextActionClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        this.tvAction.setOnClickListener(r2);
    }

    public static final /* synthetic */ void access$showSoftInput(ECSearchBar r0, View r1) {
        r0.showSoftInput(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECSearchBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.OnFocusChangeListener r5 = new ECSearchBar$defaultFocusChangeListener$1(this);
        this.defaultFocusChangeListener = r5;
        LayoutInflater.from(r2).inflate(2131560677, this, true);
        AppCompatEditText r6 = findViewById(2131385509);
        this.editText = r6;
        View r7 = findViewById(2131385348);
        this.ivClear = r7;
        this.tvAction = (TextView) findViewById(2131385300);
        r6.setOnFocusChangeListener(r5);
        r7.setOnClickListener(new AnonymousClass1(this));
    }

    public /* synthetic */ ECSearchBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
