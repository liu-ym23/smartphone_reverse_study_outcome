package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import com.ss.android.lark.flow.passport.ui.widget.layout.MaxWidthLinerLayout;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: classes36.dex */
public class VerifyCodeEditText extends RelativeLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f423912h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SCEditText f423913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f423914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MaxWidthLinerLayout f423915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CodeView[] f423916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f423917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f423918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f423919g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyCodeEditText f423920a;

        @Override // java.lang.Runnable
        public final void run() {
            Activity r100 = qyb.d.a(this.f423920a);     // Catch: Throwable -> L16
            if (r100 != null) goto L5;
            return;
        L5:
            if (uzb.f.c(r100) == false) goto L8;
            return;
        L8:
            if (this.f423920a.f423913a.isFocused() == false) goto L24;
            SCEditText r101 = this.f423920a.f423913a;     // Catch: Throwable -> L16
            if (r101 == null) goto L25;
            InputMethodManager r102 = (InputMethodManager) r101.getContext().getSystemService("input_method");     // Catch: Throwable -> L16
            if (r102 == null) goto L26;
            r101.requestFocus();     // Catch: Throwable -> L16
            r102.showSoftInput(r101, 0);     // Catch: Throwable -> L16
            return;
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L27;
            throw th;
        }

        public a(VerifyCodeEditText r100) {
            this.f423920a = r100;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
        void a(String r100);
    }

    public interface f {
        void onFinish();
    }

    public void setOnInputCompleteListener(b r100) {
    }

    public void setOnInputProcessListener(c r100) {
    }

    public void setOnKeyboardWillShowListener(d r100) {
    }

    public final void b() {
        SCEditText r100 = this.f423913a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setFocusable(true);
        this.f423913a.setFocusableInTouchMode(true);
        this.f423913a.requestFocus();
        postDelayed(new a(this), 500);
    }

    public String getVerifyCodeText() {
        SCEditText r100 = this.f423913a;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getText().toString().trim();
    }

    public VerifyCodeEditText(Context r100) {
        this(r100, null);
    }

    public final void a(Editable r100) {
        int r101 = 0;
        if (r100.length() <= 0) goto L14;
        int r102 = r100.length();
    L6:
        if (r101 >= this.f423917e) goto L19;
        if (r101 >= r102) goto L9;
        char r103 = r100.charAt(r101);
        this.f423916d[r101].setText(String.valueOf(r103));
    L12:
        r101 = r101 + 1;
        goto L6
    L9:
        if (r101 != r102) goto L11;
        this.f423916d[r101].e();
        goto L12
    L11:
        this.f423916d[r101].c();
        goto L12
    L19:
        return;
    L14:
        if (r101 >= this.f423917e) goto L27;
        this.f423916d[r101].c();
        if (r101 != 0) goto L18;
        this.f423916d[r101].e();
    L18:
        r101 = r101 + 1;
        goto L14
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener r100) {
        super.setOnCreateContextMenuListener(r100);
    }

    public void setOnTextChangeListener(e r100) {
        this.f423919g = r100;
    }

    public void setOnTextFinishListener(f r100) {
        this.f423918f = r100;
    }

    public VerifyCodeEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        CodeView[] r102 = this.f423916d;
        int r103 = 0;
        if (r102 != null) goto L5;
    L7:
        if (r103 <= 0) goto L9;
        r101 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
    L9:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (r102.length <= 0) goto L7;
        r103 = r102[0].getMeasuredHeight();
        goto L7
    }

    public VerifyCodeEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f423917e = 4;
        this.f423914b = r100;
    }
}
