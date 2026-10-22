package com.obric.oui.forms;

import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OBoxInputView.b f401014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OBoxInputView f401015b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (this.f401014a.f400878j == false) goto L6;
        AppCompatEditText r101 = this.f401015b.getEditText();
        final OBoxInputView r102 = this.f401015b;
        r101.post(new d(r102));
        return;
    }

    public e(OBoxInputView.b r100, OBoxInputView r101) {
        this.f401014a = r100;
        this.f401015b = r101;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (this.f401014a.f400872d == null) goto L24;
        Resources r104 = this.f401015b.getResources();
        Object[] r105 = new Object[2];
        if (r100 != null) goto L7;
        String r106 = null;
    L8:
        r105[0] = r106;
        r105[1] = String.valueOf(this.f401014a.f400872d);
        SpannableString r107 = new SpannableString(r104.getString(R.string.oui_form_counter, r105));
        if (r100 != null) goto L11;
        int r108 = 0;
    L12:
        Integer r109 = this.f401014a.f400872d;
        Intrinsics.checkNotNull(r109);
        if (r108 <= r109.intValue()) goto L22;
        ForegroundColorSpan r110 = new ForegroundColorSpan(ContextCompat.getColor(this.f401015b.getContext(), R.color.Primary));
        if (r100 != null) goto L17;
    L16:
        int r111 = 0;
    L21:
        r107.setSpan(r110, 0, r111, 18);
        goto L22
    L17:
        String r112 = Integer.valueOf(r100.length()).toString();
        if (r112 == null) goto L16;
        r111 = r112.length();
    L22:
        this.f401015b.getTvCounter().setText(r107, TextView.BufferType.SPANNABLE);
        return;
    L11:
        r108 = Integer.valueOf(r100.length()).intValue();
        goto L12
    L7:
        r106 = Integer.valueOf(r100.length()).toString();
        goto L8
    }
}
