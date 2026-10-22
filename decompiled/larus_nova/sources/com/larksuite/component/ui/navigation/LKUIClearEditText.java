package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import j08.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class LKUIClearEditText extends AppCompatEditText implements TextWatcher, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f284261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f284262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f284264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<TextWatcher> f284265e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public LKUIClearEditText(Context r100) {
        super(r100);
        this.f284262b = true;
        this.f284263c = R.drawable.ud_icon_close_filled;
        this.f284265e = null;
        c(null);
    }

    @Override // android.widget.TextView
    public final void addTextChangedListener(TextWatcher r100) {
        if (this.f284265e != null) goto L5;
        this.f284265e = new ArrayList();
    L5:
        this.f284265e.add(r100);
        super.addTextChangedListener(r100);
    }

    public final void c(AttributeSet r100) {
        if (r100 == null) goto L4;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.clear_drawable, R.attr.clear_size});
        this.f284263c = r101.getResourceId(0, this.f284263c);
        this.f284264d = r101.getDimension(1, b.a(getContext(), 16.0f));
        r101.recycle();
    L4:
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        setCompoundDrawablePadding((int) b.a(getContext(), 8.0f));
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = true;
        if (r100.getAction() != 1) goto L17;
        if (getCompoundDrawables()[2] == null) goto L17;
        if (r100.getX() > (getWidth() - getTotalPaddingRight())) goto L9;
    L11:
        r101 = false;
    L12:
        if (r101 == false) goto L17;
        if (this.f284262b == false) goto L17;
        setText("");
        goto L17
    L9:
        if (r100.getX() >= (getWidth() - getPaddingRight())) goto L11;
    L17:
        return super.onTouchEvent(r100);
    }

    @Override // android.widget.TextView
    public final void removeTextChangedListener(TextWatcher r100) {
        ArrayList<TextWatcher> r101 = this.f284265e;
        if (r101 == null) goto L5;
        r101.remove(r100);
    L5:
        super.removeTextChangedListener(r100);
    }

    public void setClearDrawable(Drawable r100) {
        if (r100 == null) goto L5;
        float r101 = this.f284264d;
        r100.setBounds(0, 0, (int) r101, (int) r101);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], r100, getCompoundDrawables()[3]);
        return;
    }

    public void setClearDrawableSize(float r100) {
        this.f284264d = r100;
        invalidate();
    }

    public void setClearEnable(boolean r100) {
        this.f284262b = r100;
    }

    public void setClearIconVisible(boolean r100) {
        Drawable r101 = getCompoundDrawables()[2];
        if (r101 == null) goto L5;
    L7:
        float r102 = this.f284264d;
        r101.setBounds(0, 0, (int) r102, (int) r102);
        if (r100 == true) goto L11;
        r101 = null;
    L11:
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], r101, getCompoundDrawables()[3]);
        return;
    L5:
        if (this.f284263c == 0) goto L7;
        r101 = AppCompatResources.getDrawable(getContext(), this.f284263c);
        goto L7
    }

    public void setCursorColor(int r100) {
        UIUtils.setTextViewCursorColor(getContext(), this, r100);
    }

    public void setCursorDrawable(int r100) {
        UIUtils.setTextViewEditorDrawable(this, getResources().getDrawable(r100));
    }

    public void setClearDrawable(int r100) {
        this.f284263c = r100;
        invalidate();
    }

    public LKUIClearEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f284262b = true;
        this.f284263c = R.drawable.ud_icon_close_filled;
        this.f284265e = null;
        c(r101);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        this.f284261a = r101;
        boolean r102 = false;
        if (r101 == true) goto L5;
        setClearIconVisible(false);
        return;
    L5:
        if (getText().length() <= 0) goto L7;
        r102 = true;
    L7:
        setClearIconVisible(r102);
    }

    public LKUIClearEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f284262b = true;
        this.f284263c = R.drawable.ud_icon_close_filled;
        this.f284265e = null;
        c(r101);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (this.f284261a == true) goto L5;
        return;
    L5:
        if (r100.length() > 0) goto L7;
    L9:
        boolean r104 = false;
    L10:
        setClearIconVisible(r104);
        return;
    L7:
        if (this.f284262b == false) goto L9;
        r104 = true;
        goto L10
    }
}
