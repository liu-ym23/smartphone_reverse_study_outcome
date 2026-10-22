package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TemplateTagTipsView extends LinearLayout implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public e c;
    public boolean d;

    public class a extends ClickableSpan {
        public final /* synthetic */ b a;
        public final /* synthetic */ TemplateTagTipsView b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r1) {
            b r2 = this.a;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            super.updateDrawState(r3);
            r3.setColor(this.b.getResources().getColor(2131105576));
            r3.setUnderlineText(false);
        }

        public a(TemplateTagTipsView r1, b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface b {
        void a();
    }

    public static class c {
        public final String a;
        public final String b;

        public c() {
        }

        public c(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class d {
        public final boolean a;
        public final boolean b;
        public final c c;
        public final long d;

        public d(boolean r1, boolean r2, c r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public interface e {
    }

    public final void b() {
        if (this.d == false) goto L5;
        this.a.setTextColor(getResources().getColor(2131105548));
        this.a.setBackgroundResource(2131233870);
        return;
    L5:
        this.a.setTextColor(getResources().getColor(2131106610));
        this.a.setBackgroundResource(2131233871);
    }

    public TemplateTagTipsView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (this.c != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == true) goto L12;
        if (this.d == false) goto L10;
        ((com.bytedance.ee.bear.document.tips.a0) this.c).w();
        return;
    L10:
        ((com.bytedance.ee.bear.document.tips.a0) this.c).x();
        return;
    L12:
        if (((com.bytedance.ee.bear.document.tips.a0) this.c).x() == true) goto L17;
        ((com.bytedance.ee.bear.document.tips.a0) this.c).w();
        return;
    }

    public void setClick(e r1) {
        this.c = r1;
    }

    public void setTagTitle(d r10) {
        if (r10.a == false) goto L14;
        this.b.setMovementMethod(u.a());
        TextView r0 = this.b;
        boolean r1 = r10.b;
        long r2 = r10.d;
        String r11 = getContext().getString(2131887431);
        if (r1 == false) goto L11;
        StringBuilder r3 = new StringBuilder();
        r3.append(getContext().getString(2131887441));
        r3.append(", ");
        Resources r4 = getResources();
        if (r2 <= 1) goto L9;
        int r5 = 2;
    L10:
        r3.append(r4.getQuantityString(2131755019, r5, new Object[]{Long.valueOf(r2)}));
        String r6 = r3.toString();
    L12:
        r0.setText(a(r11, r6, new v(this)));
        return;
    L9:
        r5 = 1;
        goto L10
    L11:
        r6 = getContext().getString(2131887441);
        goto L12
    L14:
        this.b.setMovementMethod(u.a());
        TextView r7 = this.b;
        c r12 = r10.c;
        final String r8 = r12.a;
        final String r13 = r12.b;
        String r9 = "@" + r8;
        r7.setText(a(r9, xo5.a.c(getContext(), 2131887447, "username", r9), new w(this, r8, r13)));
    }

    public TemplateTagTipsView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TemplateTagTipsView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = false;
        LinearLayout.inflate(getContext(), 2131560108, this);
        this.a = (TextView) findViewById(2131391980);
        this.b = (TextView) findViewById(2131388352);
        b();
        this.a.setOnClickListener(this);
    }

    public final CharSequence a(String r5, String r6, b r7) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r6);
        int r1 = r6.indexOf(r5);
        int r8 = r5.length() + r1;
        if (r1 < 0) goto L8;
        if (r1 >= r8) goto L8;
        if (r8 > r6.length()) goto L8;
        r0.setSpan(new ForegroundColorSpan(getResources().getColor(2131105576)), r1, r8, 33);
        r0.setSpan(new a(this, r7), r1, r8, 33);
    L8:
        return r0;
    }
}
