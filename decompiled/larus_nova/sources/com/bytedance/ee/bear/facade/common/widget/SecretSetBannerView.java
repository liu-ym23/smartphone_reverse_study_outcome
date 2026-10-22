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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SecretSetBannerView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f226538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f226539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f226540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f226541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f226542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f226543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f226544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f226545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f226546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f226547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f226548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f226549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f226550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f226551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f226552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f226553p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f226554q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f226555r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f226556s;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SecretSetBannerView f226557a;

        @Override // java.lang.Runnable
        public final void run() {
            SecretSetBannerView.a(this.f226557a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SecretSetBannerView r100) {
            this.f226557a = r100;
        }
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public final void b() {
        if (this.f226553p == false) goto L5;
        return;
    L5:
        this.f226550m = FrameLayout.inflate(getContext(), R.layout.secret_setting_banner_tips_layout, this);
        this.f226538a = (TextView) findViewById(R.id.secret_banner_txt);
        this.f226539b = (TextView) findViewById(R.id.secret_set);
        this.f226540c = (TextView) findViewById(R.id.see_detail);
        this.f226545h = (ImageView) findViewById(R.id.secret_icon);
        this.f226546i = (ViewGroup) findViewById(R.id.secret_banner_container);
        this.f226541d = (TextView) findViewById(R.id.land_secret_set);
        this.f226542e = (TextView) findViewById(R.id.land_see_detail);
        this.f226547j = (LinearLayout) findViewById(R.id.click_layout);
        this.f226539b.setOnClickListener(this);
        this.f226540c.setOnClickListener(this);
        this.f226542e.setOnClickListener(this);
        this.f226541d.setOnClickListener(this);
        this.f226549l = (ImageView) findViewById(R.id.close_icon);
        this.f226543f = (TextView) findViewById(R.id.confirm_button);
        this.f226544g = (TextView) findViewById(R.id.land_confirm_button);
        this.f226549l.setOnClickListener(this);
        this.f226543f.setOnClickListener(this);
        this.f226544g.setOnClickListener(this);
        this.f226553p = true;
    }

    public final void c() {
        this.f226552o.removeCallbacks(null);
        this.f226552o.post(new a(this));
    }

    public SecretSetBannerView(Context r100) {
        this(r100, null);
        b();
    }

    public static void a(SecretSetBannerView r110) {
        r110.getClass();
    L25:
        th = move-exception;
        tt5.a.f("SecretSetBannerView", th, false);
        return;
    L4:
        if (r110.f226548k == false) goto L29;
        float r100 = r110.f226538a.getPaint().measureText(r110.f226538a.getText().toString());     // Catch: Throwable -> L25
        if (r110.f226540c.getVisibility() != 0) goto L9;
        TextView r101 = r110.f226540c;     // Catch: Throwable -> L25
    L11:
        if (r110.f226539b.getVisibility() != 0) goto L13;
        TextView r102 = r110.f226539b;     // Catch: Throwable -> L25
    L14:
        float r103 = r110.f226545h.getMeasuredWidth();     // Catch: Throwable -> L25
        float r104 = r101.getPaint().measureText(r110.getContext().getString(R.string.LarkCCM_Workspace_Security_Learnmore_mob)) + r102.getPaint().measureText(r110.getContext().getString(R.string.LarkCCM_Workspace_Security_Button_SelectSecureLevel_mob));     // Catch: Throwable -> L25
        if (r104 <= r110.f226551n) goto L17;
        r110.f226551n = r104;     // Catch: Throwable -> L25
    L17:
        float r105 = r110.f226551n;     // Catch: Throwable -> L25
        float r106 = ((r103 + r100) + r105) + com.bytedance.ee.util.ui.n.d(73);     // Catch: Throwable -> L25
        float r107 = r110.getMeasuredWidth();     // Catch: Throwable -> L25
        if (r107 != 0.0f) goto L20;
        r107 = com.bytedance.ee.util.ui.n.v();     // Catch: Throwable -> L25
    L20:
        tt5.a.b("SecretSetBannerView", r100 + "," + r105 + "," + r106 + ",.." + r107 + ",.." + com.bytedance.ee.util.ui.n.v());     // Catch: Throwable -> L25
        if (r107 <= r106) goto L23;
        r110.setSingleLine(true);     // Catch: Throwable -> L25
        return;
    L23:
        r110.setSingleLine(false);     // Catch: Throwable -> L25
        return;
    L13:
        r102 = r110.f226541d;     // Catch: Throwable -> L25
        goto L14
    L9:
        r101 = r110.f226542e;     // Catch: Throwable -> L25
        goto L11
    }

    private void setBackgroundColor(boolean r100) {
        if (r100 == false) goto L4;
        this.f226545h.setImageResource(R.drawable.ud_icon_warning_colorful);
        this.f226545h.setColorFilter(null);
        this.f226546i.setBackgroundResource(R.color.ud_O100);
        this.f226539b.setBackgroundResource(R.color.color_transparent);
        this.f226539b.setPadding(0, 0, 0, 0);
        this.f226541d.setBackgroundResource(R.color.color_transparent);
        this.f226541d.setPadding(0, 0, 0, 0);
        return;
    L4:
        this.f226545h.setImageResource(R.drawable.ud_icon_safe_filled);
        com.bytedance.ee.util.ui.l.c(this.f226545h, R.color.text_link_hover);
        this.f226546i.setBackgroundResource(R.color.primary_fill_solid_01);
        this.f226539b.setBackgroundResource(R.drawable.doc_template_tag_bg);
        this.f226539b.setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4));
        this.f226541d.setBackgroundResource(R.drawable.doc_template_tag_bg);
        this.f226541d.setPadding(com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4), com.bytedance.ee.util.ui.n.d(8), com.bytedance.ee.util.ui.n.d(4));
    }

    private void setSingleLine(boolean r100) {
        TextView r101 = this.f226540c;
        int r102 = 8;
        if (r100 == false) goto L5;
        int r103 = 8;
    L6:
        r101.setVisibility(r103);
        TextView r104 = this.f226539b;
        if (r100 == false) goto L9;
    L14:
        int r105 = 8;
    L15:
        r104.setVisibility(r105);
        LinearLayout r106 = this.f226547j;
        if (r100 == false) goto L18;
        int r107 = 8;
    L19:
        r106.setVisibility(r107);
        TextView r108 = this.f226541d;
        if (r100 == true) goto L22;
    L27:
        int r109 = 8;
    L28:
        r108.setVisibility(r109);
        TextView r110 = this.f226542e;
        if (r100 == false) goto L31;
        int r111 = 0;
    L32:
        r110.setVisibility(r111);
        TextView r112 = this.f226543f;
        if (r100 == false) goto L35;
    L37:
        int r113 = 8;
    L38:
        r112.setVisibility(r113);
        TextView r114 = this.f226544g;
        if (r100 == true) goto L41;
    L43:
        r114.setVisibility(r102);
        return;
    L41:
        if (this.f226555r == false) goto L43;
        r102 = 0;
        goto L43
    L35:
        if (this.f226555r == false) goto L37;
        r113 = 0;
        goto L38
    L31:
        r111 = 8;
        goto L32
    L22:
        if (this.f226555r == true) goto L27;
        if (this.f226556s == true) goto L27;
        r109 = 0;
        goto L28
    L18:
        r107 = 0;
        goto L19
    L9:
        if (this.f226555r == true) goto L14;
        if (this.f226556s == true) goto L14;
        r105 = 0;
        goto L15
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100.getId() != R.id.see_detail) goto L5;
    L27:
        b r101 = this.f226554q;
        if (r101 == null) goto L38;
        r101.a();
        return;
    L38:
        return;
    L5:
        if (r100.getId() == R.id.land_see_detail) goto L27;
        if (r100.getId() != R.id.secret_set) goto L10;
    L24:
        b r102 = this.f226554q;
        if (r102 == null) goto L36;
        r102.d();
        return;
    L36:
        return;
    L10:
        if (r100.getId() == R.id.land_secret_set) goto L24;
        if (r100.getId() != R.id.close_icon) goto L18;
        b r103 = this.f226554q;
        if (r103 == null) goto L31;
        r103.c();
        return;
    L31:
        return;
    L18:
        if (r100.getId() != R.id.confirm_button) goto L20;
    L21:
        b r104 = this.f226554q;
        if (r104 == null) goto L34;
        r104.b();
        return;
    L34:
        return;
    L20:
        if (r100.getId() == R.id.land_confirm_button) goto L21;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        c();
    }

    public void setClick(b r100) {
        this.f226554q = r100;
    }

    public SecretSetBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
        b();
    }

    public final void d(boolean r100, String r101) {
        this.f226548k = true;
        this.f226543f.setVisibility(8);
        this.f226538a.setText(r101);
        setBackgroundColor(r100);
        if (this.f226555r == false) goto L5;
        this.f226543f.setVisibility(0);
        this.f226541d.setVisibility(8);
        this.f226539b.setVisibility(8);
        this.f226540c.setVisibility(0);
    L5:
        c();
    }

    public SecretSetBannerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226548k = false;
        this.f226551n = 0.0f;
        this.f226552o = new Handler(Looper.getMainLooper());
        this.f226553p = false;
        this.f226555r = false;
        this.f226556s = false;
        b();
    }

    public final void e(boolean r100, String r101, Boolean r102) {
        this.f226548k = true;
        if (r100 == false) goto L9;
        if (r102.booleanValue() == false) goto L7;
        String r103 = xo5.a.c(getContext(), R.string.LarkCCM_Workspace_SecLeviI_RequirWithDefault_Banner, "secure_label", r101);
    L12:
        this.f226538a.setText(r103);
        setBackgroundColor(r102.booleanValue());
        c();
        return;
    L7:
        r103 = xo5.a.c(getContext(), R.string.LarkCCM_Workspace_Security_DefaultSetting_mob, "securityLevel", r101);
        goto L12
    L9:
        if (r102.booleanValue() == false) goto L11;
        r103 = getContext().getString(R.string.LarkCCM_Workspace_SecLeviI_Requir_Banner);
        goto L12
    L11:
        r103 = getContext().getString(R.string.LarkCCM_Workspace_Security_SecurityStrategyReq_mob);
        goto L12
    }
}
