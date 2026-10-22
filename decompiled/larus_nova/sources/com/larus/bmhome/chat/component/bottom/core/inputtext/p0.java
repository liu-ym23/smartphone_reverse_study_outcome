package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.widget.EditText;
import com.larus.bmhome.chat.component.bottom.core.m6;
import com.larus.bmhome.chat.component.bottom.core.o4;
import com.larus.bmhome.utils.x1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public interface p0 {
    void M5(CharSequence r100);

    InputFilter[] S0();

    void S9(long r100, Function0<Unit> r101);

    void T0(m6 r100);

    void U0();

    int V0();

    void W0();

    void X0(int r100);

    EditText Y0();

    s Z0();

    void a(boolean r100);

    void a1(boolean r100);

    void append(CharSequence r100);

    void b(int r100);

    Object b1();

    boolean c1();

    boolean d1();

    int e1();

    void f1(boolean r100);

    boolean g1(boolean r100, boolean r101);

    void h1(boolean r100, Function0<Boolean> r101, Function0<Unit> r102);

    void i1(boolean r100);

    boolean isFocusable();

    void j1();

    CharSequence k1();

    Editable l1();

    void m1(Function1<? super Boolean, Unit> r100);

    void n1(com.larus.bmhome.chat.component.receive.r r100, o4 r101);

    void o1();

    boolean p1(MotionEvent r100);

    void q1(int r100);

    void r1(x1 r100);

    void requestFocus();

    void requestLayout();

    void setAlpha(float r100);

    void setEnabled(boolean r100);

    void setFilters(InputFilter[] r100);

    void setSelection(int r100, int r101);

    void setText(CharSequence r100);

    void setTextColor(int r100);

    void setVisible(boolean r100);

    String text();
}
