package com.lynx.xelement.input;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.x0;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/lynx/xelement/input/LynxUITextArea;", "Lcom/lynx/xelement/input/LynxUIBaseInput;", "", "maxLines", "", "setMaxLines", "", "enable", "setEnableScrollBar", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxUITextArea extends LynxUIBaseInput {
    public static final /* synthetic */ int E = 0;
    public int A;
    public boolean B;
    public h C;
    public final j D;

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final boolean W() {
        return true;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final void P() {
        new LynxInputUtils();
        Layout r100 = LynxInputUtils.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, getWidth());
        if (r100.getHeight() == this.A) goto L7;
        c0(r100.getHeight());
        this.A = r100.getHeight();
        if (this.B == true) goto L7;
        EventEmitter r101 = getLynxContext().getEventEmitter();
        m7a.a r102 = new m7a.a(getSign(), "line");
        r102.a("line", Integer.valueOf(r100.getLineCount()));
        r101.sendCustomEvent(r102);
    L7:
        this.B = false;
    }

    public final boolean b0() {
        int r100 = ((LynxEditTextView) this.mView).getImeOptions() & 255;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L15;
        if (r100 == 5) goto L15;
        if (r100 == 6) goto L15;
        return false;
    L15:
        return !this.f384158s;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        new LynxInputUtils();
        c0(LynxInputUtils.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, getWidth()).getHeight());
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput
    public final LynxEditTextView Q(Context r100) {
        LynxEditTextView r101 = super.Q(r100);
        r101.setHorizontallyScrolling(false);
        r101.setSingleLine(false);
        r101.setGravity(48);
        r101.setPadding(0, 0, 0, 0);
        r101.setOnEditorActionListener(new i(this));
        return r101;
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(x0 r100) {
        super.afterPropsUpdated(r100);
        h r101 = this.C;
        if (r101 == null) goto L5;
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{this.D, this.f384162w, this.f384161v, r101, this.f384160u});
        Unit r102 = Unit.INSTANCE;
    L6:
        if (r102 != null) goto L9;
        ((LynxEditTextView) this.mView).setFilters(new InputFilter[]{this.D, this.f384162w, this.f384161v, this.f384160u});
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void c0(final int r100) {
        new LynxInputUtils();
        final Layout r101 = LynxInputUtils.a(((LynxEditTextView) this.mView).getHint(), (EditText) this.mView, getWidth());
        getLynxContext().findShadowNodeAndRunTask(getSign(), new k(r101, r100));
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r100) {
        return Q(r100);
    }

    @LynxProp(defaultBoolean = false, name = "enable-scroll-bar")
    public final void setEnableScrollBar(boolean r100) {
        ((LynxEditTextView) this.mView).setVerticalScrollBarEnabled(r100);
        ((LynxEditTextView) this.mView).setHorizontalScrollBarEnabled(false);
        ((LynxEditTextView) this.mView).setScrollbarFadingEnabled(true);
        ((LynxEditTextView) this.mView).setScrollBarDefaultDelayBeforeFade(1000);
        if (Build.VERSION.SDK_INT < 29) goto L6;
        ((LynxEditTextView) this.mView).setVerticalScrollbarThumbDrawable(new ColorDrawable(FakePickerAvatarCreator.LTGRAY));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = Integer.MAX_VALUE, name = "maxlines")
    public final void setMaxLines(final int r100) {
        if (r100 > 0) goto L5;
        r100 = Integer.MAX_VALUE;
    L5:
        this.B = false;
        ((LynxEditTextView) this.mView).setMaxLines(r100);
        if (r100 != Integer.MAX_VALUE) goto L8;
        h r101 = 0;
    L9:
        this.C = r101;
        return;
    L8:
        r101 = new h(this, r100);
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.lynx.xelement.input.j] */
    public LynxUITextArea(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.A = -1;
        this.D = new j(this);
    }

    public static CharSequence a0(LynxUITextArea r100, int r101, CharSequence r102, int r103, int r104, Spanned r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.B = false;
        if (r101 == Integer.MAX_VALUE) goto L21;
        if (r101 <= 0) goto L21;
        if (r103 >= r104) goto L21;
        new LynxInputUtils();
        CharSequence r105 = r102.subSequence(r103, r104);
        int r106 = r105.length();
        int r107 = 0;
    L8:
        boolean r108 = true;
        if (r107 >= r106) goto L15;
        int r109 = ((r107 + r106) + 1) / 2;
        SpannableStringBuilder r113 = new SpannableStringBuilder(r110);
        r113.replace(r111, r112, r105.subSequence(0, r109));
        if (LynxInputUtils.a(r113, (EditText) r100.mView, r100.getWidth()).getLineCount() <= r101) goto L12;
        r106 = r109 - 1;
        goto L8
    L12:
        r107 = r109;
        goto L8
    L15:
        if (r107 < r105.length()) goto L18;
        r108 = false;
    L18:
        r100.B = r108;
        if (r108 == false) goto L21;
        EventEmitter r114 = r100.getLynxContext().getEventEmitter();
        m7a.a r115 = new m7a.a(r100.getSign(), "line");
        r115.a("line", -1);
        r114.sendCustomEvent(r115);
        return r105.subSequence(0, r107);
    L21:
        return null;
    }
}
