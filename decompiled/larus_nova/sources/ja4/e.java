package ja4;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdp.bdpbase.util.o;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public abstract class e<V extends View> extends b<View> {
    public Typeface A;
    public View B;
    public ib4.e C;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f497858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f497859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f497860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f497861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f497862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f497863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f497864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CharSequence f497865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CharSequence f497866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f497867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f497868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f497869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f497870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f497871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f497872t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f497873u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f497874v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f497875w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f497876x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f497877y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f497878z;

    public abstract V e();

    public void f() {
    }

    @Override // ja4.b
    public final View c() {
        LinearLayout r100 = new LinearLayout(this.f497851a);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        GradientDrawable r101 = new GradientDrawable();
        r101.setShape(0);
        r101.setColor(this.f497875w);
        int r102 = 8;
        r101.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        r100.setBackground(r101);
        r100.setOrientation(1);
        r100.setGravity(17);
        r100.setPadding(0, 0, 0, 0);
        r100.setClipToPadding(false);
        RelativeLayout r103 = new RelativeLayout(this.f497851a);
        r103.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) o.a(this.f497851a, this.f497862j)));
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setColor(this.f497861i);
        r104.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        r103.setBackground(r104);
        r103.setGravity(16);
        TextView r105 = new TextView(this.f497851a);
        this.f497876x = r105;
        if (this.f497864l == false) goto L5;
        r102 = 0;
    L5:
        r105.setVisibility(r102);
        RelativeLayout.LayoutParams r106 = new RelativeLayout.LayoutParams(-2, -1);
        r106.addRule(9, -1);
        r106.addRule(15, -1);
        this.f497876x.setLayoutParams(r106);
        this.f497876x.setBackgroundColor(0);
        this.f497876x.setGravity(17);
        int r107 = (int) o.a(this.f497851a, this.f497863k);
        this.f497876x.setPadding(r107, 0, r107, 0);
        if (TextUtils.isEmpty(this.f497865m) == true) goto L8;
        this.f497876x.setText(this.f497865m);
    L8:
        this.f497876x.setTextColor(o.e(this.f497868p, this.f497871s));
        int r108 = this.f497872t;
        if (r108 == 0) goto L11;
        this.f497876x.setTextSize(r108);
    L11:
        this.f497876x.setOnClickListener(new c(this));
        r103.addView(this.f497876x);
        if (this.f497878z != null) goto L20;
        TextView r109 = new TextView(this.f497851a);
        RelativeLayout.LayoutParams r110 = new RelativeLayout.LayoutParams(-2, -2);
        int r111 = (int) o.a(this.f497851a, this.f497863k);
        r110.leftMargin = r111;
        r110.rightMargin = r111;
        r110.addRule(14, -1);
        r110.addRule(15, -1);
        r109.setLayoutParams(r110);
        r109.setGravity(17);
        if (TextUtils.isEmpty(this.f497867o) == true) goto L16;
        r109.setText(this.f497867o);
    L16:
        r109.setTextColor(this.f497870r);
        r109.setTypeface(this.A);
        int r112 = this.f497874v;
        if (r112 == 0) goto L19;
        r109.setTextSize(r112);
    L19:
        this.f497878z = r109;
    L20:
        r103.addView(this.f497878z);
        this.f497877y = new TextView(this.f497851a);
        RelativeLayout.LayoutParams r113 = new RelativeLayout.LayoutParams(-2, -1);
        r113.addRule(11, -1);
        r113.addRule(15, -1);
        this.f497877y.setLayoutParams(r113);
        this.f497877y.setBackgroundColor(0);
        this.f497877y.setGravity(17);
        this.f497877y.setPadding(r107, 0, r107, 0);
        if (TextUtils.isEmpty(this.f497866n) == true) goto L23;
        this.f497877y.setText(this.f497866n);
    L23:
        this.f497877y.setTextColor(o.e(this.f497869q, this.f497871s));
        int r114 = this.f497873u;
        if (r114 == 0) goto L26;
        this.f497877y.setTextSize(r114);
    L26:
        this.f497877y.setOnClickListener(new d(this));
        r103.addView(this.f497877y);
        r100.addView(r103);
        if (this.f497858f == false) goto L30;
        View r115 = new View(this.f497851a);
        r115.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f497860h));
        r115.setBackgroundColor(this.f497859g);
        r100.addView(r115);
    L30:
        if (this.B != null) goto L32;
        this.B = e();
    L32:
        this.B.setPadding(0, 0, 0, 0);
        ViewGroup r116 = (ViewGroup) this.B.getParent();
        if (r116 == null) goto L35;
        r116.removeView(this.B);
    L35:
        r100.addView(this.B, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return r100;
    }

    public e(Activity r100) {
        super(r100);
        this.f497858f = true;
        this.f497859g = -1513240;
        this.f497860h = 1;
        this.f497861i = -1;
        this.f497862j = 40;
        this.f497863k = 15;
        this.f497864l = true;
        this.f497865m = "";
        this.f497866n = "";
        this.f497867o = "";
        this.f497868p = -13987625;
        this.f497869q = -13987625;
        this.f497870r = -15329245;
        this.f497871s = -13987625;
        this.f497872t = 17;
        this.f497873u = 17;
        this.f497874v = 17;
        this.f497875w = -1;
        this.A = Typeface.DEFAULT;
        this.f497865m = r100.getString(R.string.bdp_permission_cancel);
        this.f497866n = r100.getString(R.string.bdp_determine);
    }
}
