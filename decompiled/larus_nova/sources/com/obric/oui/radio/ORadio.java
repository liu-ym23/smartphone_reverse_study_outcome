package com.obric.oui.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "use OCheckBox")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "", "checked", "", "setChecked", "", "style", "setStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class ORadio extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f402603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f402604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f402605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f402606d;

    public ORadio(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public ORadio(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public ORadio(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void a() {
        if (this.f402603a == false) goto L6;
        return;
    L6:
        if (this.f402606d != 1) goto L9;
        setButtonDrawable(R.drawable.o_ic_radio_tick_checked);
    L13:
        setChecked(isChecked());
        return;
    L9:
        if (this.f402604b == false) goto L11;
        int r100 = R.drawable.o_radio_round_always_light;
    L12:
        setButtonDrawable(r100);
        goto L13
    L11:
        r100 = R.drawable.o_radio_round;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f402603a == false) goto L6;
        return;
    L6:
        if (this.f402605c == false) goto L9;
        j.a(this, d.n(this, 44));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r100) {
        super.setChecked(r100);
        if (this.f402603a == false) goto L6;
        return;
    L6:
        if (this.f402606d != 1) goto L12;
        if (r100 == false) goto L9;
        int r101 = 0;
    L10:
        setVisibility(r101);
        return;
    L9:
        r101 = 4;
        goto L10
    }

    public final void setStyle(int r100) {
        if (this.f402603a == false) goto L5;
        return;
    L5:
        this.f402606d = r100;
        a();
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Use OTextView individually", replaceWith = @ReplaceWith(expression = "OTextView", imports = {}))
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        super.setText(r100, r101);
    }

    public ORadio(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402603a = false;
        this.f402605c = true;
        if (r101 == null) goto L12;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_adapt_for_csr, R.attr.oui_fitOld, R.attr.oui_radioAlwaysLight, R.attr.oui_radioStyle}, r102, 0);
        this.f402603a = r104.getBoolean(1, false);
        this.f402606d = r104.getInt(3, 0);
        this.f402605c = r104.getBoolean(0, true);
        this.f402604b = r104.getBoolean(2, false);
        r104.recycle();
    L12:
        if (this.f402603a == true) goto L14;
        a();
        return;
    L14:
        setClickable(true);
    }
}
