package sr4;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f543208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f543209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f543210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f543211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f543212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f543213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f543214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f543215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f543216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f543217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f543218k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f543219l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f543220m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f543221n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f543222o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f543223p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f543224q;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543225a;

        public a(b r100) {
            this.f543225a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f543225a;
            Integer r102 = r101.f543208a;
            if (r102 == null) goto L8;
            int r103 = r102.intValue();
            d r104 = r101.getRatingStarClickListener();
            if (r104 == null) goto L9;
            r104.a(r103);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: sr4.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7644b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543226a;

        public ViewOnClickListenerC7644b(b r100) {
            this.f543226a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f543226a;
            Integer r102 = r101.f543208a;
            if (r102 == null) goto L8;
            int r103 = r102.intValue();
            d r104 = r101.getRatingStarClickListener();
            if (r104 == null) goto L9;
            r104.a(r103);
            return;
        L9:
            return;
        }
    }

    public final void a() {
        e r100 = this.f543217j;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.f543228b;
    L6:
        int r103 = n.d(r102);
        int r104 = r103 / 2;
        if (this.f543209b == false) goto L31;
        this.f543219l = new FrameLayout(getContext());
        e r105 = this.f543217j;
        if (r105 == null) goto L11;
        int r106 = n.d(r105.f543227a) + r103;
    L12:
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(r106, r106);
        FrameLayout r108 = this.f543219l;
        if (r108 == null) goto L15;
        r108.setLayoutParams(r107);
    L15:
        this.f543220m = new ImageView(getContext());
        this.f543221n = new ImageView(getContext());
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-1, -1);
        ImageView r110 = this.f543220m;
        if (r110 == null) goto L18;
        r110.setLayoutParams(r109);
    L18:
        ImageView r111 = this.f543221n;
        if (r111 == null) goto L21;
        r111.setLayoutParams(r109);
    L21:
        FrameLayout r112 = this.f543219l;
        if (r112 == null) goto L24;
        r112.addView(this.f543221n);
    L24:
        FrameLayout r113 = this.f543219l;
        if (r113 == null) goto L27;
        r113.addView(this.f543220m);
    L27:
        FrameLayout r114 = this.f543219l;
        if (r114 == null) goto L30;
        r114.setPadding(r104, r104, r104, r104);
    L30:
        addView(this.f543219l);
    L43:
        if (this.f543223p == false) goto L65;
        e r115 = this.f543217j;
        if (r115 == null) goto L47;
        Integer r116 = r115.f543229c;
    L48:
        if (r116 == null) goto L65;
        TextView r117 = new TextView(getContext());
        this.f543222o = r117;
        r117.setText(String.valueOf(this.f543208a));
        TextView r118 = this.f543222o;
        if (r118 == null) goto L52;
        r118.setTextSize(14.0f);
    L52:
        TextView r119 = this.f543222o;
        if (r119 == null) goto L55;
        r119.setTextColor(getContext().getResources().getColor(R.color.text_title));
    L55:
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(-2, -2);
        e r121 = this.f543217j;
        if (r121 == null) goto L60;
        Integer r122 = r121.f543229c;
        if (r122 == null) goto L60;
        r101 = r122.intValue();
    L60:
        r120.topMargin = n.d(r101);
        TextView r123 = this.f543222o;
        if (r123 == null) goto L63;
        r123.setLayoutParams(r120);
    L63:
        addView(this.f543222o);
        goto L65
    L47:
        r116 = null;
    L65:
        if (this.f543211d == false) goto L67;
        return;
    L67:
        if (this.f543209b == false) goto L71;
        FrameLayout r124 = this.f543219l;
        if (r124 == null) goto L76;
        r124.setOnClickListener(new a(this));
        return;
    L76:
        return;
    L71:
        ImageView r125 = this.f543218k;
        if (r125 == null) goto L78;
        r125.setOnClickListener(new ViewOnClickListenerC7644b(this));
        return;
    L78:
        return;
    L11:
        r106 = 0;
        goto L12
    L31:
        this.f543218k = new ImageView(getContext());
        e r126 = this.f543217j;
        if (r126 == null) goto L34;
        int r127 = n.d(r126.f543227a) + r103;
    L35:
        LinearLayout.LayoutParams r128 = new LinearLayout.LayoutParams(r127, r127);
        ImageView r129 = this.f543218k;
        if (r129 == null) goto L38;
        r129.setLayoutParams(r128);
    L38:
        ImageView r130 = this.f543218k;
        if (r130 == null) goto L41;
        r130.setPadding(r104, r104, r104, r104);
    L41:
        addView(this.f543218k);
        goto L43
    L34:
        r127 = 0;
        goto L35
    L5:
        r102 = 0;
        goto L6
    }

    public final Integer getRating() {
        return this.f543208a;
    }

    public final d getRatingStarClickListener() {
        return this.f543224q;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f543223p = true;
        setOrientation(1);
        setGravity(1);
    }

    public final void b(boolean r100) {
        if (Intrinsics.areEqual(Boolean.valueOf(r100), this.f543210c) == true) goto L54;
        this.f543210c = Boolean.valueOf(r100);
        if (this.f543209b == false) goto L32;
        Integer r101 = this.f543215h;
        if (r101 == null) goto L11;
        int r102 = r101.intValue();
        ImageView r103 = this.f543220m;
        if (r103 == null) goto L11;
        r103.setImageResource(r102);
    L11:
        Integer r104 = this.f543214g;
        if (r104 == null) goto L17;
        int r105 = r104.intValue();
        ImageView r106 = this.f543221n;
        if (r106 == null) goto L17;
        r106.setImageResource(r105);
    L17:
        if (Intrinsics.areEqual(this.f543210c, Boolean.TRUE) == false) goto L24;
        ImageView r107 = this.f543221n;
        if (r107 == null) goto L21;
        r107.clearColorFilter();
    L21:
        TextView r108 = this.f543222o;
        if (r108 == null) goto L55;
        r108.setTextColor(getContext().getResources().getColor(R.color.text_title));
        return;
    L55:
        return;
    L24:
        TextView r109 = this.f543222o;
        if (r109 == null) goto L27;
        r109.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
    L27:
        Integer r110 = this.f543216i;
        if (r110 == null) goto L57;
        int r111 = r110.intValue();
        ImageView r112 = this.f543221n;
        if (r112 == null) goto L58;
        r112.setColorFilter(getContext().getResources().getColor(r111));
        return;
    L58:
        return;
    L57:
        return;
    L32:
        Integer r113 = this.f543212e;
        if (r113 == null) goto L38;
        int r114 = r113.intValue();
        ImageView r115 = this.f543218k;
        if (r115 == null) goto L38;
        r115.setImageResource(r114);
    L38:
        if (Intrinsics.areEqual(this.f543210c, Boolean.TRUE) == false) goto L45;
        ImageView r116 = this.f543218k;
        if (r116 == null) goto L42;
        r116.clearColorFilter();
    L42:
        TextView r117 = this.f543222o;
        if (r117 == null) goto L60;
        r117.setTextColor(getContext().getResources().getColor(R.color.text_title));
        return;
    L60:
        return;
    L45:
        TextView r118 = this.f543222o;
        if (r118 == null) goto L48;
        r118.setTextColor(getContext().getResources().getColor(R.color.text_placeholder));
    L48:
        Integer r119 = this.f543213f;
        if (r119 == null) goto L62;
        int r120 = r119.intValue();
        ImageView r121 = this.f543218k;
        if (r121 == null) goto L63;
        r121.setColorFilter(getContext().getResources().getColor(r120));
        return;
    L63:
        return;
    L62:
        return;
    }

    public final void setRatingStarClickListener(d r100) {
        this.f543224q = r100;
    }
}
