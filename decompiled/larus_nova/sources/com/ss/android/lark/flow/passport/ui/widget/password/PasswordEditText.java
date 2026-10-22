package com.ss.android.lark.flow.passport.ui.widget.password;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.flow.passport.ui.widget.common.h;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class PasswordEditText extends RelativeLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f423885k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SCEditText f423886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckBox f423887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f423888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f423889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f423890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnFocusChangeListener f423891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f423892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f423893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ValueAnimator> f423894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f423895j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PasswordEditText f423896a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (uzb.f.c(Contexts.requireActivity(this.f423896a.f423890e)) == true) goto L10;
            ((InputMethodManager) this.f423896a.f423886a.getContext().getSystemService("input_method")).showSoftInput(this.f423896a.f423886a, 0);     // Catch: Throwable -> L7
            return;
        }

        public a(PasswordEditText r100) {
            this.f423896a = r100;
        }
    }

    public class b extends InputFilter.LengthFilter {
        public b(int r100) {
            super(r100);
        }
    }

    public interface c {
        void a(String r100);
    }

    public interface d {
    }

    public interface e {
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f423897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f423898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f423899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f423900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f423901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f423902f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f423903g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f423904h;

        public f() {
            this.f423904h = R.drawable.signin_sdk_pw_cursor_bg_v2;
        }
    }

    public interface g {
        void h(String r100);
    }

    public void setKeyboardWillOpenListener(e r100) {
    }

    public void setOnKeyboardDetectorListener(d r100) {
    }

    public final void b() {
        SCEditText r100 = this.f423886a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setFocusable(true);
        this.f423886a.setFocusableInTouchMode(true);
        this.f423886a.requestFocus();
        postDelayed(new a(this), 500);
    }

    public String getString() {
        SCEditText r100 = this.f423886a;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getText().toString();
    }

    public PasswordEditText(Context r100) {
        this(r100, null);
    }

    public final int a(float r100) {
        Resources r101 = this.f423890e.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public void setMaxLength(int r100) {
        this.f423886a.setFilters(new InputFilter[]{new b(r100)});
    }

    public void setOnInputCompleteListener(c r100) {
        this.f423893h = r100;
    }

    public void setOnInputFocusChangeListener(View.OnFocusChangeListener r100) {
        this.f423891f = r100;
    }

    public void setTextChangeListener(g r100) {
        this.f423892g = r100;
    }

    public PasswordEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public PasswordEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f423894i = new ArrayList();
        Context r103 = getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f423895j = new h(r103, 0.0f, 6);
        this.f423890e = r100;
    }
}
