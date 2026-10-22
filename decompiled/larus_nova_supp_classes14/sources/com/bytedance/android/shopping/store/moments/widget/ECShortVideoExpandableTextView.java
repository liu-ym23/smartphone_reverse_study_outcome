package com.bytedance.android.shopping.store.moments.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/widget/ECShortVideoExpandableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "text", "", "setTextInner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShortVideoExpandableTextView extends AppCompatTextView {
    public int a;
    public final int b;
    public final int c;
    public boolean d;
    public final String e;
    public final String f;
    public String g;
    public final String h;
    public final int i;
    public CharSequence j;
    public boolean k;
    public final a l;

    public static final class a extends ClickableSpan {
        public final /* synthetic */ ECShortVideoExpandableTextView a;

        public a(ECShortVideoExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "widget");
            ECShortVideoExpandableTextView r4 = this.a;
            boolean r0 = !r4.d;
            r4.d = r0;
            if (r0 == false) goto L5;
            r4.g = r4.f;
            r4.a = r4.c;
            r4.k = true;
        L6:
            ECShortVideoExpandableTextView.x(r4, r4.j);
            this.a.invalidate();
            return;
        L5:
            r4.g = r4.e;
            r4.a = r4.b;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setTextInner(CharSequence r2) {
        super/*android.widget.TextView*/.setText(r2, TextView.BufferType.NORMAL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super/*android.widget.TextView*/.onDraw(r9);
        if (getLayout().getEllipsisCount(getLayout().getLineCount() - 1) <= 0) goto L5;
        boolean r10 = true;
    L7:
        if (getLayout().getLineCount() <= this.a) goto L9;
        boolean r2 = true;
    L10:
        if (r10 == true) goto L14;
        if (r2 == true) goto L14;
        boolean r11 = false;
    L15:
        if (r11 == false) goto L17;
    L18:
        CharSequence r3 = getLayout().getText();
        if (r11 == false) goto L25;
        int r12 = getLayout().getLineEnd(this.a - 1);
        CharSequence r4 = r3.subSequence(getLayout().getLineStart(this.a - 1), r12);
        int r5 = 1;
    L22:
        if (getPaint().measureText(r4, 0, r4.length() - r5) <= (getPaint().measureText(r4, 0, r4.length()) - (getPaint().measureText(this.h + this.g) + getLayout().getSpacingAdd()))) goto L24;
        r5 = r5 + 1;
        goto L22
    L24:
        r3 = r3.subSequence(0, (r12 - r5) - 1);
    L25:
        SpannableStringBuilder r13 = new SpannableStringBuilder().append(r3).append(this.h).append(this.g);
        TextPaint r1 = new TextPaint();
        r1.linkColor = this.i;
        this.l.updateDrawState(r1);
        r13.setSpan(this.l, r13.length() - this.g.length(), r13.length(), 33);
        setMovementMethod(LinkMovementMethod.getInstance());
        if (this.k == false) goto L28;
        this.k = false;
    L28:
        setTextInner(r13);
        return;
    L17:
        if (this.k == true) goto L18;
        return;
    L14:
        r11 = true;
        goto L15
    L9:
        r2 = false;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECShortVideoExpandableTextView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        this.a = 2;
        this.b = 2;
        this.c = 3;
        String r2 = "收起";
        this.e = "收起";
        String r3 = "展开";
        this.f = "展开";
        this.g = "展开";
        this.h = "... ";
        this.i = -1;
        this.j = "";
        this.l = new a(this);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setBreakStrategy(0);
    L5:
        if (r10 == null) goto L16;
        TypedArray r11 = r9.obtainStyledAttributes(r10, new int[]{2130969906, 2130969907, 2130969908, 2130969909, 2130969915});
        int r12 = r11.getInt(0, 2);
        this.b = r12;
        this.a = r12;
        this.c = r11.getInt(2, 3);
        String r13 = r11.getString(3);
        if (r13 == null) goto L10;
        r3 = r13;
    L10:
        this.f = r3;
        String r14 = r11.getString(1);
        if (r14 == null) goto L14;
        r2 = r14;
    L14:
        this.e = r2;
        this.g = r2;
        this.i = r11.getColor(4, -1);
        return;
    }

    public static final /* synthetic */ void x(ECShortVideoExpandableTextView r0, CharSequence r1) {
        r0.setTextInner(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        this.j = r1;
        super/*android.widget.TextView*/.setText(r1, r2);
    }
}
