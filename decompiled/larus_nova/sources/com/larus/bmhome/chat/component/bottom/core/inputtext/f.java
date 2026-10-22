package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.larus.bmhome.chat.component.bottom.core.o4;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.utils.x1;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public abstract class f implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f298729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f298730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f298731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f298732d;

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void W0() {
        this.f298729a.setFocusableInTouchMode(true);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public boolean c1() {
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void j1() {
        this.f298729a.setMaxLines(1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final InputFilter[] S0() {
        return this.f298729a.getFilters();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final int V0() {
        return this.f298729a.getSelectionStart();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final s Z0() {
        return new s(this.f298729a);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean d1() {
        return this.f298729a.hasFocus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final int e1() {
        return this.f298729a.getSelectionEnd();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean isFocusable() {
        return this.f298729a.isFocusable();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final CharSequence k1() {
        CharSequence r100 = this.f298729a.getHint();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final Editable l1() {
        return this.f298729a.getEditableText();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void o1() {
        Editable r100 = this.f298729a.getEditableText();
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void requestFocus() {
        this.f298729a.requestFocus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void requestLayout() {
        this.f298729a.requestLayout();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final String text() {
        Editable r100 = this.f298729a.getText();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void U0() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.f298729a.post(new b(this));
        return;
    L6:
        this.f298729a.clearFocus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final EditText Y0() {
        return this.f298729a;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.c] */
    public f(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "baseInputText");
        this.f298729a = r100;
        this.f298731c = r100.isShown();
        this.f298732d = new c(this);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void M5(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        this.f298729a.setHint(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void X0(int r100) {
        this.f298729a.setMaxHeight(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void a1(boolean r100) {
        Lazy r101 = we8.e.f559400a;
        if (we8.e.f559403d != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L6;
        we8.a.b(this.f298729a, i5.t(), r100, null, null, 12);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void append(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f298729a.append(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void b(int r100) {
        this.f298729a.setSelection(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void f1(boolean r100) {
        this.f298729a.setCursorVisible(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void i1(boolean r100) {
        this.f298729a.setFocusable(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public void m1(Function1<? super Boolean, Unit> r100) {
        this.f298729a.removeOnLayoutChangeListener(this.f298732d);
        this.f298730b = r100;
        this.f298731c = this.f298729a.isShown();
        if (r100 == null) goto L6;
        this.f298729a.addOnLayoutChangeListener(this.f298732d);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean p1(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = com.larus.utils.w0.f375484a;
        EditText r102 = this.f298729a;
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r102 == null) goto L19;
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        float r104 = r100.getRawX();
        float r105 = r100.getRawY();
        int r106 = r103[0];
        if (r104 >= r106) goto L8;
        return false;
    L8:
        if (r104 > (r106 + r102.getWidth())) goto L16;
        int r107 = r103[1];
        if (r105 >= r107) goto L12;
        return false;
    L12:
        if (r105 > (r107 + r102.getHeight())) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L19:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void q1(int r100) {
        this.f298729a.setHintTextColor(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public void r1(x1 r100) {
        requestFocus();
        EditText r101 = this.f298729a;
        Object r102 = r101.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r102).showSoftInput(r101, 1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setAlpha(float r100) {
        this.f298729a.setAlpha(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setEnabled(boolean r100) {
        this.f298729a.setEnabled(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setFilters(InputFilter[] r100) {
        Intrinsics.checkNotNullParameter(r100, "filters");
        this.f298729a.setFilters(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setTextColor(int r100) {
        this.f298729a.setTextColor(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setVisible(boolean r100) {
        EditText r101 = this.f298729a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        boolean r103 = this.f298729a.isShown();
        if (r103 == this.f298731c) goto L14;
        this.f298731c = r103;
        Function1<? super Boolean, Unit> r104 = this.f298730b;
        if (r104 == null) goto L13;
        r104.invoke(Boolean.valueOf(r103));
        return;
    L13:
        return;
    L14:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void S9(long r100, final Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != 0) goto L5;
        this.f298729a.post(new d(r101));
        return;
    L5:
        this.f298729a.postDelayed(new e(r101), r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public boolean g1(boolean r100, boolean r101) {
        if (isFocusable() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.chat.component.receive.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.component.receive.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.chat.component.receive.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.bmhome.chat.component.receive.f] */
    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void n1(final com.larus.bmhome.chat.component.receive.r r110, final o4 r111) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        String[] r100 = com.larus.bmhome.chat.component.receive.i.f301392a;
        EditText r101 = this.f298729a;
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r110, "onSuccess");
        final String[] r102 = com.larus.bmhome.chat.component.receive.i.f301392a;
        final ?? r103 = new com.larus.bmhome.chat.component.receive.d();
        final ?? r104 = new com.larus.bmhome.chat.component.receive.e();
        final ?? r105 = new com.larus.bmhome.chat.component.receive.f(r111);
        final ?? r106 = new com.larus.bmhome.chat.component.receive.g(r110);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "mimeTypes");
        Intrinsics.checkNotNullParameter(r103, "predicateSource");
        Intrinsics.checkNotNullParameter(r104, "predicateItem");
        Intrinsics.checkNotNullParameter(r106, "onSuccess");
        ViewCompat.setOnReceiveContentListener(r101, r102, new com.larus.bmhome.chat.component.receive.h(r103, r102, r104, r106, r105));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setSelection(int r100, int r101) {
        this.f298729a.setSelection(r100, r101);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public void h1(boolean r100, Function0<Boolean> r101, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, "needPasteAndSend");
        n0.a(this.f298729a, r100, r101, r110, null, null);
    }
}
