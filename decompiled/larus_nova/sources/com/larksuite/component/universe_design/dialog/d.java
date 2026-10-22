package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f284947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f284948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f284949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f284950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f284951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f284952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f284953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f284954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.larksuite.component.universe_design.dialog.c.a f284955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f284956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f284957p;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f284958a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "s");
        }

        public a(d r100) {
            this.f284958a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Intrinsics.checkNotNullParameter(r100, "s");
            com.larksuite.component.universe_design.dialog.c.a r101 = this.f284958a.f284955n;
            if (r101 == null) goto L5;
            r101.onTextChanged(r100);
        L5:
            c r102 = this.f284958a.f284956o;
            if (r102 == null) goto L9;
            r102.onTextChanged(r100);
            return;
        }
    }

    public static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f284959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f284960b;

        public b(d r100, EditText r101) {
            this.f284959a = r100;
            this.f284960b = r101;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L10;
            Object r102 = this.f284959a.getContext().getSystemService("input_method");
            if ((r102 instanceof InputMethodManager) == false) goto L6;
            InputMethodManager r103 = (InputMethodManager) r102;
        L7:
            if (r103 == null) goto L11;
            r103.showSoftInput(this.f284960b, 2);
            return;
        L11:
            return;
        L6:
            r103 = null;
            goto L7
        }
    }

    public static final class c implements com.larksuite.component.universe_design.dialog.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f284961a;

        public c(View r100) {
            this.f284961a = r100;
        }

        @Override // com.larksuite.component.universe_design.dialog.c.a
        public final void onTextChanged(CharSequence r100) {
            View r101 = this.f284961a;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            r101.setEnabled(!r102);
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.ud_dialog_input_content;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        if (r100 != null) goto L6;
        return null;
    L6:
        EditText r101 = (EditText) r100.findViewById(R.id.ud_dialog_content_et);
        r101.setText(this.f284952k);
        r101.addTextChangedListener(this.f284957p);
        int r102 = this.f284942a;
        if (r102 == (-1)) goto L9;
        r101.setInputType(r102);
    L9:
        CharSequence r103 = this.f284951j;
        if (r103 == null) goto L12;
        r101.setHint(r103);
    L12:
        boolean r104 = false;
        if (this.f284947f == (-1)) goto L16;
        r101.setSingleLine(false);
        r101.setMaxLines(this.f284947f);
    L16:
        if (this.f284948g == (-1)) goto L19;
        r101.setHintTextColor(UDColorUtils.getColor(getContext(), this.f284948g));
    L19:
        if (this.f284949h == (-1)) goto L21;
        r101.setTextColor(UDColorUtils.getColor(getContext(), this.f284949h));
    L21:
        int r105 = this.f284950i;
        if (r105 == (-1)) goto L25;
        r101.setBackgroundResource(r105);
    L25:
        if (this.f284954m == false) goto L27;
        r101.setOnFocusChangeListener(new b(this, r101));
        r101.requestFocus();
    L27:
        r101.setSelection(this.f284952k.length());
        setupViewPadding(r101, this.f284943b, this.f284944c, this.f284945d, this.f284946e);
        CharSequence r106 = getMMessage();
        if (r106 != null) goto L30;
    L31:
        r104 = true;
    L32:
        if (r104 == false) goto L36;
        TextView r107 = (TextView) r100.findViewById(R.id.ud_dialog_content_message_tv);
        if (r107 == null) goto L36;
        r107.setVisibility(8);
    L36:
        return r100;
    L30:
        if (r106.length() != 0) goto L32;
        goto L31
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r100 = super.onCreateFooter();
        if (r100 != null) goto L7;
        return null;
    L7:
        if (this.f284953l == false) goto L15;
        View r101 = r100.findViewById(R.id.ud_dialog_btn_primary);
        if (r101 == null) goto L15;
        if (this.f284952k.length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        r101.setEnabled(r102);
        this.f284956o = new c(r101);
        goto L15
    L13:
        r102 = false;
    L15:
        return r100;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284942a = -1;
        this.f284943b = -1;
        this.f284944c = -1;
        this.f284945d = -1;
        this.f284946e = -1;
        this.f284947f = -1;
        this.f284948g = -1;
        this.f284949h = -1;
        this.f284950i = -1;
        this.f284952k = "";
        this.f284957p = new a(this);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof com.larksuite.component.universe_design.dialog.c) == false) goto L7;
        super.apply(r100, r101);
        com.larksuite.component.universe_design.dialog.c r102 = (com.larksuite.component.universe_design.dialog.c) r100;
        this.f284942a = r102.f284877a;
        this.f284943b = r102.f284878b;
        this.f284944c = r102.f284879c;
        this.f284945d = r102.f284880d;
        this.f284946e = r102.f284881e;
        this.f284947f = r102.f284882f;
        this.f284948g = r102.f284883g;
        this.f284949h = r102.f284884h;
        this.f284950i = r102.f284885i;
        this.f284951j = r102.f284886j;
        this.f284952k = r102.f284887k;
        this.f284955n = r102.f284890n;
        this.f284953l = r102.f284888l;
        this.f284954m = r102.f284889m;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDInputDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController, com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public final void onCreate(UDDialog r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCreate(r100, r101);
        if (this.f284954m == false) goto L8;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L9;
        r102.setSoftInputMode(21);
        return;
    L9:
        return;
    }
}
