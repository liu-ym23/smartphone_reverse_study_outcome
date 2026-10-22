package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public class SearchEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f418553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f418554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f418555c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchEditText f418556a;

        @Override // java.lang.Runnable
        public final void run() {
            SearchEditText r100 = this.f418556a;     // Catch: Throwable -> L8
            if (r100.f418553a == null) goto L11;
            String r101 = r100.getText().toString().replace(" ", "");     // Catch: Throwable -> L8
            if (TextUtils.equals(this.f418556a.f418554b, r101) == true) goto L15;
            SearchEditText r102 = this.f418556a;     // Catch: Throwable -> L8
            r102.f418554b = r101;     // Catch: Throwable -> L8
            r102.f418553a.h(r101);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(SearchEditText r100) {
            this.f418556a = r100;
        }
    }

    public interface b {
        void h(String r100);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f418555c);
        super.onDetachedFromWindow();
    }

    public SearchEditText(Context r100) {
        this(r100, null);
    }

    public void setTextWithoutSpaceChangedListener(b r100) {
        this.f418553a = r100;
    }

    public SearchEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f418554b = "";
        this.f418555c = new a(this);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        removeCallbacks(this.f418555c);
        postDelayed(this.f418555c, 300);
    }
}
