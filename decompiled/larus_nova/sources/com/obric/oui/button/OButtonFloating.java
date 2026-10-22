package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OBaseTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/widget/TextView;", "getTitleView", "", "text", "", d.f25925o, "", "textRes", "Lcom/obric/oui/text/OBaseTextView;", "D", "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "textView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OButtonFloating extends OShadowFrame {
    public OBaseTextView D;

    public OButtonFloating(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OButtonFloating(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OButtonFloating(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r100 = this.D;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    }

    public final TextView getTitleView() {
        return getTextView();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void d(int r100) {
        super.d(r100);
    }

    public final void setTextView(OBaseTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.D = r100;
    }

    public final void setTitle(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        getTextView().setText(r100);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void t(boolean r100) {
        super.t(r100);
        if (r100 == false) goto L5;
        getTextView().setAlpha(1.0f);
        return;
    L5:
        getTextView().setAlpha(0.3f);
    }

    public final void setTitle(int r100) {
        getTextView().setText(r100);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void k(Context r100, OUIFrameLayout r110, TypedArray r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "contentView");
        CharSequence r101 = r111.getText(17);
        int r102 = r111.getResourceId(19, R.style.Button_2_Medium);
        int r103 = r111.getColor(18, getResources().getColor(R.color.oui_basic_text_1, null));
        OBaseTextView r104 = new OBaseTextView(r100, null, 6, 0);
        r104.setTextAppearance(r102);
        r104.setTextColor(r103);
        r104.setText(r101);
        r104.setSingleLine();
        r104.setIncludeFontPadding(false);
        r104.setGravity(17);
        setTextView(r104);
        View r105 = getTextView();
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 17;
        Unit r107 = Unit.INSTANCE;
        r110.addView(r105, r106);
        if (getMaterialApplied() == false) goto L6;
        l(r100, r111);
        return;
    }

    public OButtonFloating(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
    }
}
