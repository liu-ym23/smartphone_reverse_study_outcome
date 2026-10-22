package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SecretSetBannerView extends FrameLayout implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ViewGroup i;
    public LinearLayout j;
    public boolean k;
    public ImageView l;
    public View m;
    public float n;
    public final Handler o;
    public boolean p;
    public b q;
    public boolean r;
    public boolean s;

    public class a implements Runnable {
        public final /* synthetic */ SecretSetBannerView a;

        @Override // java.lang.Runnable
        public final void run() {
            SecretSetBannerView.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SecretSetBannerView r1) {
            this.a = r1;
        }
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public final void b() {
        if (this.p == false) goto L5;
        return;
    L5:
        this.m = FrameLayout.inflate(getContext(), 2131564493, this);
        this.a = (TextView) findViewById(2131385712);
        this.b = (TextView) findViewById(2131385715);
        this.c = (TextView) findViewById(2131385745);
        this.h = (ImageView) findViewById(2131385714);
        this.i = (ViewGroup) findViewById(2131385711);
        this.d = (TextView) findViewById(2131377115);
        this.e = (TextView) findViewById(2131377116);
        this.j = (LinearLayout) findViewById(2131366959);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.l = (ImageView) findViewById(2131366997);
        this.f = (TextView) findViewById(2131367655);
        this.g = (TextView) findViewById(2131377112);
        this.l.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.p = true;
    }

    public final void c() {
        this.o.removeCallbacks(null);
        this.o.post(new a(this));
    }

    public SecretSetBannerView(Context r2) {
        this(r2, null);
        b();
    }

    public static void a(SecretSetBannerView r10) {
        r10.getClass();
    L25:
        th = move-exception;
        tt5.a.f("SecretSetBannerView", th, false);
        return;
    L4:
        if (r10.k == false) goto L29;
        float r4 = r10.a.getPaint().measureText(r10.a.getText().toString());     // Catch: Throwable -> L25
        if (r10.c.getVisibility() != 0) goto L9;
        TextView r5 = r10.c;     // Catch: Throwable -> L25
    L11:
        if (r10.b.getVisibility() != 0) goto L13;
        TextView r6 = r10.b;     // Catch: Throwable -> L25
    L14:
        float r7 = r10.h.getMeasuredWidth();     // Catch: Throwable -> L25
        float r8 = r5.getPaint().measureText(r10.getContext().getString(2131889949)) + r6.getPaint().measureText(r10.getContext().getString(2131889946));     // Catch: Throwable -> L25
        if (r8 <= r10.n) goto L17;
        r10.n = r8;     // Catch: Throwable -> L25
    L17:
        float r9 = r10.n;     // Catch: Throwable -> L25
        float r11 = ((r7 + r4) + r9) + com.bytedance.ee.util.ui.n.d(73);     // Catch: Throwable -> L25
        float r12 = r10.getMeasuredWidth();     // Catch: Throwable -> L25
        if (r12 != 0.0f) goto L20;
        r12 = com.bytedance.ee.util.ui.n.v();     // Catch: Throwable -> L25
    L20:
        tt5.a.b("SecretSetBannerView", r4 + "," + r9 + "," + r11 + ",.." + r12 + ",.." + com.bytedance.ee.util.ui.n.v());     // Catch: Throwable -> L25
        if (r12 <= r11) goto L23;
        r10.setSingleLine(true);     // Catch: Throwable -> L25
        return;
    L23:
        r10.setSingleLine(false);     // Catch: Throwable -> L25
        return;
    L13:
        r6 = r10.d;     // Catch: Throwable -> L25
        goto L14
    L9:
        r5 = r10.e;     // Catch: Throwable -> L25
        goto L11
    }

    private void setBackgroundColor(boolean r8) {
        if (r8 == false) goto L4;
        this.h.setImageResource(2131256185);
        this.h.setColorFilter(null);
        this.i.setBackgroundResource(2131108748);
        this.b.setBackgroundResource(2131101106);
        this.b.setPadding(0, 0, 0, 0);
        this.d.setBackgroundResource(2131101106);
        this.d.setPadding(0, 0, 0, 0);
        return;
    L4:
        this.h.setImageResource(2131255589);
        com.bytedance.ee.util.ui.l.c(this.h, 2131106614);
        this.i.setBackgroundResource(2131105552);
        this.b.setBackgroundResource(2131233870);
        this.b.setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4));
        this.d.setBackgroundResource(2131233870);
        this.d.setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4));
    }

    private void setSingleLine(boolean r5) {
        TextView r0 = this.c;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        TextView r2 = this.b;
        if (r5 == false) goto L9;
    L14:
        int r4 = 8;
    L15:
        r2.setVisibility(r4);
        LinearLayout r6 = this.j;
        if (r5 == false) goto L18;
        int r7 = 8;
    L19:
        r6.setVisibility(r7);
        TextView r8 = this.d;
        if (r5 == true) goto L22;
    L27:
        int r9 = 8;
    L28:
        r8.setVisibility(r9);
        TextView r10 = this.e;
        if (r5 == false) goto L31;
        int r11 = 0;
    L32:
        r10.setVisibility(r11);
        TextView r12 = this.f;
        if (r5 == false) goto L35;
    L37:
        int r13 = 8;
    L38:
        r12.setVisibility(r13);
        TextView r14 = this.g;
        if (r5 == true) goto L41;
    L43:
        r14.setVisibility(r1);
        return;
    L41:
        if (this.r == false) goto L43;
        r1 = 0;
        goto L43
    L35:
        if (this.r == false) goto L37;
        r13 = 0;
        goto L38
    L31:
        r11 = 8;
        goto L32
    L22:
        if (this.r == true) goto L27;
        if (this.s == true) goto L27;
        r9 = 0;
        goto L28
    L18:
        r7 = 0;
        goto L19
    L9:
        if (this.r == true) goto L14;
        if (this.s == true) goto L14;
        r4 = 0;
        goto L15
    L5:
        r3 = 0;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3.getId() != 2131385745) goto L5;
    L27:
        b r4 = this.q;
        if (r4 == null) goto L38;
        r4.a();
        return;
    L38:
        return;
    L5:
        if (r3.getId() == 2131377116) goto L27;
        if (r3.getId() != 2131385715) goto L10;
    L24:
        b r5 = this.q;
        if (r5 == null) goto L36;
        r5.d();
        return;
    L36:
        return;
    L10:
        if (r3.getId() == 2131377115) goto L24;
        if (r3.getId() != 2131366997) goto L18;
        b r6 = this.q;
        if (r6 == null) goto L31;
        r6.c();
        return;
    L31:
        return;
    L18:
        if (r3.getId() != 2131367655) goto L20;
    L21:
        b r7 = this.q;
        if (r7 == null) goto L34;
        r7.b();
        return;
    L34:
        return;
    L20:
        if (r3.getId() == 2131377112) goto L21;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        c();
    }

    public void setClick(b r1) {
        this.q = r1;
    }

    public SecretSetBannerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
        b();
    }

    public final void d(boolean r3, String r4) {
        this.k = true;
        this.f.setVisibility(8);
        this.a.setText(r4);
        setBackgroundColor(r3);
        if (this.r == false) goto L5;
        this.f.setVisibility(0);
        this.d.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    L5:
        c();
    }

    public SecretSetBannerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.k = false;
        this.n = 0.0f;
        this.o = new Handler(Looper.getMainLooper());
        this.p = false;
        this.r = false;
        this.s = false;
        b();
    }

    public final void e(boolean r3, String r4, Boolean r5) {
        this.k = true;
        if (r3 == false) goto L9;
        if (r5.booleanValue() == false) goto L7;
        String r6 = xo5.a.c(getContext(), 2131889916, "secure_label", r4);
    L12:
        this.a.setText(r6);
        setBackgroundColor(r5.booleanValue());
        c();
        return;
    L7:
        r6 = xo5.a.c(getContext(), 2131889948, "securityLevel", r4);
        goto L12
    L9:
        if (r5.booleanValue() == false) goto L11;
        r6 = getContext().getString(2131889917);
        goto L12
    L11:
        r6 = getContext().getString(2131889950);
        goto L12
    }
}
