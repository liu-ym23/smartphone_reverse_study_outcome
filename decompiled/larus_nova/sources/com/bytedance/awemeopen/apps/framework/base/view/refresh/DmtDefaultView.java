package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class DmtDefaultView extends ScrollView implements f, h {
    public static final /* synthetic */ int B = 0;
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.a f193249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f193250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f193251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f193252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f193253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DmtTextView f193254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DmtTextView f193255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DmtTextView f193256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f193257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f193258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f193259k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f193260l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f193261m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f193262n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f193263o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f193264p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f193265q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f193266r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f193267s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f193268t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f193269u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View.OnClickListener f193270v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f193271w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f193272x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f193273y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f193274z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DmtDefaultView f193275a;

        @Override // java.lang.Runnable
        public final void run() {
            DmtDefaultView r100 = this.f193275a;     // Catch: Throwable -> L9
            int r101 = DmtDefaultView.B;     // Catch: Throwable -> L9
            if (r100.f193249a != null) goto L5;
        L14:
            return;
        L5:
            if (r100.f193267s == false) goto L7;
            r100.g();     // Catch: Throwable -> L9
            goto L14
        L7:
            r100.i();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(DmtDefaultView r100) {
            this.f193275a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getButtonString() {
        DmtTextView r100 = this.f193256h;
        if (r100 != 0) goto L5;
        return "";
    L5:
        if ((r100 instanceof DmtIconButton) == true) goto L7;
        CharSequence r101 = r100.getText();
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101.toString();
    L7:
        return ((DmtIconButton) r100).getTextString();
    }

    public String getDescString() {
        DmtTextView r100 = this.f193255g;
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.getText() != null) goto L9;
        return "";
    L9:
        return this.f193255g.getText().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void j() {
        if (this.f193252d != null) goto L6;
        return;
    L6:
        if (this.f193249a != null) goto L8;
        return;
    L8:
        Resources r100 = getResources();
        if (this.f193254f == null) goto L15;
        this.f193249a.getClass();
        DmtTextView r101 = this.f193254f;
        if (this.f193271w != 0) goto L13;
        int r102 = r100.getColor(R.color.aos_uikit_t_primary_light);
    L14:
        r101.setTextColor(r102);
        goto L15
    L13:
        r102 = r100.getColor(R.color.aos_uikit_t_primary_dark);
    L15:
        DmtTextView r103 = this.f193255g;
        if (r103 != null) goto L18;
    L22:
        DmtTextView r104 = this.f193256h;
        if (r104 != 0) goto L25;
        return;
    L25:
        if ((r104 instanceof DmtIconButton) == false) goto L27;
        ((DmtIconButton) r104).a(this.f193271w);
        return;
    L27:
        ButtonStyle r105 = this.f193249a.f193419c;
        ButtonStyle r106 = ButtonStyle.SOLID;
        if (r105 != r106) goto L35;
        if (this.f193271w != 0) goto L32;
        int r107 = R.drawable.aos_uikit_bg_default_button_solid_light;
    L33:
        r104.setBackgroundResource(r107);
    L39:
        this.f193249a.getClass();
        if (this.f193249a.f193419c != r106) goto L47;
        if (this.f193271w != 0) goto L44;
        int r108 = r100.getColor(R.color.aos_uikit_t_inverse_light);
    L45:
        r104.setTextColor(r108);
        return;
    L44:
        r108 = r100.getColor(R.color.aos_uikit_t_inverse_dark);
        goto L45
    L47:
        if (this.f193271w != 0) goto L49;
        int r109 = r100.getColor(R.color.aos_uikit_t_primary_light);
    L50:
        r104.setTextColor(r109);
        return;
    L49:
        r109 = r100.getColor(R.color.aos_uikit_t_primary_dark);
        goto L50
    L32:
        r107 = R.drawable.aos_uikit_bg_default_button_solid_dark;
        goto L33
    L35:
        if (this.f193271w != 0) goto L37;
        int r110 = R.drawable.aos_uikit_bg_default_button_border_light;
    L38:
        r104.setBackgroundResource(r110);
        goto L39
    L37:
        r110 = R.drawable.aos_uikit_bg_default_button_border_dark;
        goto L38
    L18:
        if (this.f193271w != 0) goto L20;
        int r111 = r100.getColor(R.color.aos_uikit_t_secondary_light);
    L21:
        r103.setTextColor(r111);
        goto L22
    L20:
        r111 = r100.getColor(R.color.aos_text_tertiary);
        goto L21
    }

    public final void c() {
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L12;
        int r101 = r100.height;
        if (r101 < 0) goto L8;
        this.f193250b = r101;
    L8:
        if (r101 == (-2)) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("DmtDefaultView doesn't support layout_height set to WRAP_CONTENT!");
    }

    public final void g() {
        c();
        if (this.f193272x == false) goto L5;
        this.f193250b = d0.c(getContext()) - this.f193274z;
        int[] r100 = new int[2];
        getLocationOnScreen(r100);
        this.f193273y = r100[1];
    L5:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r101 = this.f193249a;
        if (r101 == null) goto L45;
        int r102 = this.f193250b;
        if (r102 >= this.f193257i) goto L11;
        return;
    L11:
        if (r101.f193422f == false) goto L25;
        int r103 = (int) ((r102 * 0.2f) + 0.5f);
        if (this.f193272x == false) goto L15;
        r103 = r103 - this.f193273y;
    L15:
        k(this.f193253e, r103);
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r104 = this.f193249a;
        if (r104.f193425i == true) goto L18;
    L39:
        this.f193255g.requestLayout();
        if (this.f193273y != 0) goto L42;
        return;
    L42:
        if (this.A == false) goto L47;
        this.f193252d.setVisibility(0);
        return;
    L47:
        return;
    L18:
        if (r104.f193426j == false) goto L20;
        k(this.f193256h, this.f193264p);
        goto L39
    L20:
        int r105 = (((((((this.f193250b - r103) - this.f193266r) - this.f193258j) - f(this.f193254f)) - this.f193259k) - f(this.f193255g)) - this.f193261m) - this.f193260l;
        if (this.f193272x == false) goto L23;
        r105 = r105 - this.f193273y;
    L23:
        setButtonMargin(r105);
        goto L39
    L25:
        if (r101.f193423g == false) goto L35;
        int r106 = (int) ((r102 * 0.3f) + 0.5f);
        if (this.f193272x == false) goto L29;
        r106 = r106 - this.f193273y;
    L29:
        k(this.f193254f, r106);
        if (this.f193249a.f193425i == false) goto L39;
        int r107 = (((((this.f193250b - r106) - f(this.f193254f)) - this.f193259k) - f(this.f193255g)) - this.f193261m) - this.f193260l;
        if (this.f193272x == false) goto L34;
        r107 = r107 - this.f193273y;
    L34:
        setButtonMargin(r107);
        goto L39
    L35:
        int r108 = (int) ((r102 * 0.3f) + 0.5f);
        if (this.f193272x == false) goto L38;
        r108 = r108 - this.f193273y;
    L38:
        k(this.f193255g, r108);
        goto L39
    }

    public final void h() {
        DmtTextView r100 = (DmtTextView) findViewById(R.id.tv_title);
        this.f193254f = r100;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r101 = this.f193249a;
        if (r101.f193423g == false) goto L5;
        r100.setText(r101.f193417a);
    L5:
        this.f193249a.getClass();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r102 = this.f193249a;
        boolean r103 = r102.f193425i;
        if (r103 == false) goto L17;
        LinearLayout r104 = this.f193252d;
        DmtTextView r105 = null;
        if (r103 == true) goto L11;
        DmtTextView r106 = null;
    L14:
        if (r106 == null) goto L16;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(this.f193262n, this.f193261m);
        r107.gravity = 1;
        r104.addView(r106, r107);
        r106.setText(r102.f193420d);
        r106.setOnClickListener(null);
        r105 = r106;
    L16:
        this.f193256h = r105;
        goto L17
    L11:
        if (r102.f193419c != ButtonStyle.SOLID) goto L13;
        r106 = new DmtTextView(new ContextThemeWrapper(getContext(), R.style.default_button_solid));
        goto L14
    L13:
        r106 = new DmtTextView(new ContextThemeWrapper(getContext(), R.style.default_button_border));
    L17:
        DmtTextView r108 = (DmtTextView) findViewById(R.id.tv_desc);
        this.f193255g = r108;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r109 = this.f193249a;
        if (r109.f193424h == false) goto L21;
        r108.setText(r109.f193418b);
        this.f193249a.getClass();
        return;
    }

    public final void i() {
        c();
        removeAllViews();
        setScrollY(0);
        if (this.f193272x == false) goto L5;
        this.f193250b = d0.c(getContext()) - this.f193274z;
    L5:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r100 = this.f193249a;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f193250b >= this.f193257i) goto L11;
        return;
    L11:
        if (r100.f193422f == false) goto L22;
        LayoutInflater.from(getContext()).inflate(R.layout.aos_layout_default_with_pic, this, true);
        this.f193252d = (LinearLayout) findViewById(R.id.layout_parent);
        ImageView r101 = (ImageView) findViewById(R.id.iv_empty);
        this.f193253e = r101;
        Context r102 = getContext();     // Catch: NullPointerException -> L15
        this.f193249a.getClass();     // Catch: NullPointerException -> L15
        r101.setImageDrawable(ContextCompat.getDrawable(r102, 0));     // Catch: NullPointerException -> L15
    L17:
        h();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r103 = this.f193249a;
        if (r103.f193426j == false) goto L20;
        LinearLayout r104 = this.f193252d;
        DmtTextView r105 = new DmtTextView(new ContextThemeWrapper(getContext(), R.style.default_extra_text));
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-1, -2);
        r106.topMargin = this.f193263o;
        r104.addView(r105, r106);
        r105.setText(r103.f193421e);
        this.f193249a.getClass();
        r105.setOnClickListener(null);
    L20:
        b(this.f193252d);
    L28:
        View.OnClickListener r107 = this.f193270v;
        if (r107 == null) goto L31;
        this.f193252d.setOnClickListener(r107);
    L31:
        this.f193267s = true;
        j();
        if (this.A == false) goto L34;
        this.f193252d.setVisibility(4);
    L34:
        boolean r108 = this.f193268t;
        if (r108 == false) goto L37;
        d(Boolean.valueOf(r108));
    L41:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L43;
        setLayoutDirection(0);
        this.f193252d.setLayoutDirection(1);
    L43:
        g();
        return;
    L37:
        boolean r109 = this.f193269u;
        if (r109 == false) goto L41;
        e(Boolean.valueOf(r109));
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L22:
        if (r100.f193423g == false) goto L24;
        LayoutInflater.from(getContext()).inflate(R.layout.aos_layout_default_text_only, this, true);
        this.f193252d = (LinearLayout) findViewById(R.id.layout_parent);
        h();
        b(this.f193252d);
        goto L28
    L24:
        LayoutInflater.from(getContext()).inflate(R.layout.aos_layout_default_desc_only, this, true);
        this.f193252d = (LinearLayout) findViewById(R.id.layout_parent);
        DmtTextView r110 = (DmtTextView) findViewById(R.id.tv_desc);
        this.f193255g = r110;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r111 = this.f193249a;
        if (r111.f193424h == false) goto L27;
        r110.setText(r111.f193418b);
        this.f193249a.getClass();
    L27:
        b(this.f193252d);
        goto L28
    }

    public DmtDefaultView(Context r100) {
        this(r100, null);
    }

    private void setButtonMargin(int r100) {
        int r101 = this.f193260l;
        if (r100 >= r101) goto L5;
        k(this.f193256h, r101);
        return;
    L5:
        int r102 = (int) ((this.f193250b * 0.2f) + 0.5f);
        if (r102 >= r101) goto L8;
        k(this.f193256h, r100);
        return;
    L8:
        int r103 = r100 - (r102 - r101);
        if (r103 <= r101) goto L11;
        k(this.f193256h, r103);
        return;
    L11:
        k(this.f193256h, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r100) {
        if (this.f193271w == r100) goto L6;
        this.f193271w = r100;
        j();
        return;
    }

    public final void b(LinearLayout r100) {
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-1, this.f193260l);
        r100.addView(new Space(getContext()), r101);
    }

    public final void d(Boolean r100) {
        this.f193268t = r100.booleanValue();
        if (r100.booleanValue() == false) goto L18;
        DmtTextView r101 = this.f193254f;
        if (r101 == null) goto L7;
        r101.setTextColor(ContextCompat.getColor(getContext(), R.color.aos_const_text_inverse2));
    L7:
        DmtTextView r102 = this.f193255g;
        if (r102 == null) goto L10;
        r102.setTextColor(ContextCompat.getColor(getContext(), R.color.aos_const_text_inverse4));
    L10:
        DmtTextView r103 = this.f193256h;
        if (r103 != null) goto L13;
        return;
    L13:
        if (this.f193249a.f193419c != ButtonStyle.SOLID) goto L15;
        r103.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.aos_uikit_bg_default_button_solid_dark));
    L16:
        this.f193249a.getClass();
        this.f193256h.setTextColor(ContextCompat.getColor(getContext(), R.color.aos_const_text_inverse2));
        return;
    L15:
        r103.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.aos_uikit_bg_default_button_border_force_dark));
        goto L16
    }

    public final void e(Boolean r100) {
        this.f193269u = r100.booleanValue();
        if (r100.booleanValue() == false) goto L18;
        DmtTextView r101 = this.f193254f;
        if (r101 == null) goto L7;
        r101.setTextColor(ContextCompat.getColor(getContext(), R.color.aos_text_reverse));
    L7:
        DmtTextView r102 = this.f193255g;
        if (r102 == null) goto L10;
        r102.setTextColor(ContextCompat.getColor(getContext(), R.color.aos_text_reverse3));
    L10:
        DmtTextView r103 = this.f193256h;
        if (r103 != null) goto L13;
        return;
    L13:
        if (this.f193249a.f193419c != ButtonStyle.SOLID) goto L15;
        r103.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.aos_uikit_bg_default_button_solid_light));
    L16:
        this.f193249a.getClass();
        this.f193256h.setTextColor(ContextCompat.getColor(getContext(), R.color.aos_text_reverse));
        return;
    L15:
        r103.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.aos_uikit_bg_default_button_border_light));
        goto L16
    }

    public final int f(DmtTextView r100) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(this.f193251c - (this.f193265q * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredHeight();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f193270v = r100;
        LinearLayout r101 = this.f193252d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setStatus(com.bytedance.awemeopen.apps.framework.base.view.refresh.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f193249a = r100;
        if (r100.f193425i == false) goto L14;
        if (r100.f193423g == false) goto L12;
        if (r100.f193424h == true) goto L14;
    L12:
        throw new IllegalArgumentException("button must with title and description!");
    L14:
        if (r100.f193426j == true) goto L16;
    L30:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r101 = this.f193249a;
        if (r101.f193423g == false) goto L38;
        if (TextUtils.isEmpty(r101.f193417a) == true) goto L36;
    L48:
        this.f193267s = false;
        if (this.f193250b <= 0) goto L52;
        i();
        return;
    L52:
        return;
    L36:
        throw new IllegalArgumentException("title text should not be empty String!");
    L38:
        if (r101.f193424h == false) goto L48;
        if (TextUtils.isEmpty(r101.f193418b) == true) goto L47;
        if (this.f193249a.f193422f == false) goto L48;
        throw new IllegalArgumentException("desc text should only have itself!");
    L47:
        throw new IllegalArgumentException("desc text should not be empty String!");
    L16:
        if (TextUtils.isEmpty(r100.f193421e) == true) goto L29;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r102 = this.f193249a;
        if (r102.f193422f == false) goto L27;
        if (r102.f193423g == false) goto L27;
        if (r102.f193424h == false) goto L27;
        if (r102.f193425i == true) goto L30;
    L27:
        throw new IllegalArgumentException("extra text must with all elements!");
    L29:
        throw new IllegalArgumentException("extra text should not be empty String!");
    }

    public void setSupportDelayVisible(boolean r100) {
        this.A = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.h
    public void setUseScreenHeight(int r100) {
        this.f193272x = true;
        this.f193274z = r100;
        if (this.f193249a != null) goto L5;
        return;
    L5:
        if (this.f193267s == false) goto L7;
        g();
        return;
    L7:
        i();
    }

    public DmtDefaultView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void k(View r100, int r101) {
        ((LinearLayout.LayoutParams) r100.getLayoutParams()).topMargin = r101;
    }

    public DmtDefaultView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193250b = 0;
        this.f193251c = 0;
        this.f193267s = false;
        this.f193268t = false;
        this.f193269u = false;
        this.f193271w = 1;
        c();
        if (r101 == null) goto L29;
        Context r103 = getContext();
        TypedArray r104 = r103.obtainStyledAttributes(r101, new int[]{R.attr.defaultButtonStyle, R.attr.defaultButtonText, R.attr.defaultDescText, R.attr.defaultExtraText, R.attr.defaultImagePlaceHolder, R.attr.defaultTitleText});
        if (r104 == null) goto L29;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r105 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.a();
        if (r104.hasValue(4) == false) goto L10;
        r103.getResources().getDrawable(r104.getResourceId(4, 0));
        r105.f193422f = true;
    L10:
        if (r104.hasValue(1) == false) goto L13;
        r105.f193420d = r104.getString(1);
        r105.f193425i = true;
    L13:
        if (r104.hasValue(0) == false) goto L20;
        if (r104.getInt(0, 1) != 1) goto L17;
        ButtonStyle r106 = ButtonStyle.SOLID;
    L18:
        r105.f193419c = r106;
        r105.f193425i = true;
        goto L20
    L17:
        r106 = ButtonStyle.BORDER;
    L20:
        if (r104.hasValue(5) == false) goto L23;
        r105.f193417a = r104.getString(5);
        r105.f193423g = true;
    L23:
        if (r104.hasValue(2) == false) goto L26;
        r105.f193418b = r104.getString(2);
        r105.f193424h = true;
    L26:
        if (r104.hasValue(3) == false) goto L28;
        r105.f193421e = r104.getString(3);
        r105.f193426j = true;
    L28:
        r104.recycle();
    L30:
        Resources r107 = getContext().getResources();
        this.f193257i = r107.getDimensionPixelSize(R.dimen.aos_default_min_height);
        this.f193258j = r107.getDimensionPixelSize(R.dimen.aos_default_title_margin);
        this.f193259k = r107.getDimensionPixelSize(R.dimen.aos_default_desc_margin);
        this.f193260l = r107.getDimensionPixelSize(R.dimen.aos_default_min_margin);
        this.f193262n = r107.getDimensionPixelSize(R.dimen.aos_default_button_width);
        this.f193261m = r107.getDimensionPixelSize(R.dimen.aos_default_button_height);
        this.f193263o = r107.getDimensionPixelSize(R.dimen.aos_default_extra_margin);
        this.f193264p = r107.getDimensionPixelSize(R.dimen.aos_default_button_margin_with_extra);
        this.f193265q = r107.getDimensionPixelSize(R.dimen.aos_empty_page_padding);
        this.f193266r = r107.getDimensionPixelSize(R.dimen.aos_default_image_height);
        if (r105 != null) goto L33;
        return;
    L33:
        if (r105.f193422f == false) goto L35;
    L42:
        setStatus(r105);
        return;
    L35:
        if (r105.f193425i == true) goto L42;
        if (r105.f193423g == true) goto L42;
        if (r105.f193424h == true) goto L42;
        if (r105.f193426j == true) goto L42;
        return;
    L29:
        r105 = null;
        goto L30
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f193250b == r101) goto L5;
    L6:
        this.f193251c = r100;
        this.f193250b = r101;
        LinearLayout r104 = this.f193252d;
        if (r104 != null) goto L9;
        post(new b(this));
        return;
    L9:
        r104.post(new a(this));
        return;
    L5:
        if (this.f193251c != r100) goto L6;
    }
}
