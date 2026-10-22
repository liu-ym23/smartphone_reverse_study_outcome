package com.bytedance.ee.bear.drive.view.preview.retryview;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.ss.android.lark.utils.UIHelper;
import i75.g;
import z95.c;
import z95.e;
import z95.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FailedToRetryView extends SpaceEmptyState {
    public CharSequence a;
    public CharSequence b;
    public CharSequence c;
    public boolean d;
    public boolean e;
    public b f;
    public PreviewViewModel g;

    public class a extends ClickableSpan {
        public final /* synthetic */ FailedToRetryView a;

        public a(FailedToRetryView r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            if (this.a.f == null) goto L6;
            tt5.a.h("DRIVE_PREVIEW_FLOW", "showBlockState#btn retry click");
            ((ka5.b) this.a.f).a.liveInnerReload().postValue(null);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            super.updateDrawState(r2);
            r2.setColor(UIHelper.getColor(2131106620));
            r2.setUnderlineText(false);
        }
    }

    public interface b {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        setVisibility(0);
        Context r1 = getContext();
        if (e() == false) goto L9;
        setDesc(getResources().getString(2131887130));
        String r2 = r1.getString(2131888445);
        View.OnClickListener r3 = new z95.b(this);
        this.b = r2;
        setPrimaryText(r2);
        setPrimaryClickListener(new f(r3));
        if (this.e == true) goto L7;
        showPrimaryAction(false);
    L7:
        setPrimaryActionEnabled(false);
        return;
    L9:
        String r4 = r1.getString(2131888445);
        View.OnClickListener r5 = new c(this);
        this.b = r4;
        setPrimaryText(r4);
        setPrimaryClickListener(new f(r5));
        setPrimaryActionEnabled(true);
        showSecondaryAction(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CharSequence getDescriptionText() {
        if (TextUtils.isEmpty(this.a) == true) goto L7;
        return this.a;
    L7:
        if (this.d == false) goto L11;
        return getRetrySpannableString();
    L11:
        return getContext().getString(2131888419);
    }

    public static boolean e() {
        boolean r0 = g.a();
        boolean r1 = g.b();
        tt5.a.b("FailedToRetryView", "interceptWeakNetworkRequest: isUnUsableNetState=" + r0 + ", weakNetState=" + r1);
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SpannableString getRetrySpannableString() {
        String r0 = getResources().getString(2131887360);
        String r1 = getResources().getString(2131887361);
        SpannableString r2 = new SpannableString(r0 + r1);
        a r3 = new a(this);
        ForegroundColorSpan r4 = new ForegroundColorSpan(getResources().getColor(2131105548));
        r2.setSpan(r3, 0, r2.length(), 17);
        r2.setSpan(r4, r2.length() - r1.length(), r2.length(), 17);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [z95.a] */
    public final void g() {
        Context r0 = getContext();
        setVisibility(0);
        String r1 = getContext().getString(2131888429);
        View.OnClickListener r2 = new e(this);
        this.b = r1;
        setPrimaryText(r1);
        setPrimaryClickListener(new f(r2));
        if (e() == false) goto L5;
        return;
    L5:
        String r3 = r0.getString(2131888445);
        ?? r4 = new z95.a(this);
        this.c = r3;
        setSecondaryText(r3);
        setSecondaryClickListener(new z95.g(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.LinearLayout*/.onDetachedFromWindow();
    }

    public FailedToRetryView(Context r2) {
        super(r2);
        this.e = true;
        d(r2);
    }

    public static /* synthetic */ SpannableString b(FailedToRetryView r0) {
        return r0.getRetrySpannableString();
    }

    public static /* synthetic */ CharSequence c(FailedToRetryView r0) {
        return r0.getDescriptionText();
    }

    public final void d(Context r2) {
        setImageSizeResource(2131165486);
        setImageRes(2131232542);
        setDesc(r2.getString(2131888419));
        f();
    }

    public void setDescriptionText(CharSequence r3) {
        tt5.a.h("FailedToRetryView", "setDescriptionText: " + r3);
        setDesc(r3);
    }

    public void setPlaceHolderText(CharSequence r3) {
        tt5.a.h("FailedToRetryView", "setPlaceHolderText: " + r3);
        this.a = r3;
        setDesc(r3);
    }

    public void setRetryClickListener(b r1) {
        this.f = r1;
    }

    public FailedToRetryView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = true;
        d(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(FailedToRetryView r2, Boolean r3) {
        r2.getClass();
        if (r3 == null) goto L16;
        r2.setPrimaryActionEnabled(r3.booleanValue());
        r2.setSecondaryActionEnabled(r3.booleanValue());
        CharSequence r0 = r2.getResources().getString(2131887130);
        if (r3.booleanValue() == true) goto L9;
    L14:
        tt5.a.h("FailedToRetryView", "observeOuterNetState: " + r0);
        r2.setDesc(r0);
        return;
    L9:
        if (r2.d == true) goto L11;
    L13:
        r0 = r2.getDescriptionText();
        goto L14
    L11:
        if (e() == true) goto L13;
        r0 = r2.getRetrySpannableString();
        goto L14
    }

    public FailedToRetryView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = true;
        d(r1);
    }
}
