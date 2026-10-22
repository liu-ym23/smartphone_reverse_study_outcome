package com.ss.android.ugc.tools.view.widget.statusview;

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
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.shortvideo.ScreenUtils;
import com.ss.android.ugc.tools.view.style.StyleTextView;

/* JADX INFO: loaded from: classes40.dex */
public class AVDefaultView extends ScrollView implements c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f455144x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f455145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f455146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f455147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f455148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f455149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public StyleTextView f455150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StyleTextView f455151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public StyleTextView f455152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f455153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f455154j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f455155k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f455156l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f455157m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f455158n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f455159o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f455160p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f455161q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f455162r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View.OnClickListener f455163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f455164t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f455165u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f455166v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f455167w;

    public final void a() {
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L12;
        int r101 = r100.height;
        if (r101 < 0) goto L8;
        this.f455146b = r101;
    L8:
        if (r101 == (-2)) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("DmtDefaultView doesn't support layout_height set to WRAP_CONTENT!");
    }

    public final void c() {
        a();
        if (this.f455165u == false) goto L5;
        this.f455146b = ScreenUtils.a(getContext()) - this.f455167w;
        int[] r100 = new int[2];
        getLocationOnScreen(r100);
        this.f455166v = r100[1];
    L5:
        a r101 = this.f455145a;
        if (r101 == null) goto L43;
        int r102 = this.f455146b;
        if (r102 >= this.f455153i) goto L11;
        return;
    L11:
        if (r101.f455195g == false) goto L25;
        int r103 = (int) ((r102 * 0.2f) + 0.5f);
        if (this.f455165u == false) goto L15;
        r103 = r103 - this.f455166v;
    L15:
        f(this.f455149e, r103);
        a r104 = this.f455145a;
        if (r104.f455198j == true) goto L18;
    L39:
        StyleTextView r105 = this.f455151g;
        if (r105 == null) goto L44;
        r105.requestLayout();
        return;
    L44:
        return;
    L18:
        if (r104.f455199k == false) goto L20;
        f(this.f455152h, this.f455159o);
        goto L39
    L20:
        int r106 = (((((((this.f455146b - r103) - this.f455161q) - this.f455154j) - b(this.f455150f)) - this.f455155k) - b(this.f455151g)) - this.f455157m) - this.f455156l;
        if (this.f455165u == false) goto L23;
        r106 = r106 - this.f455166v;
    L23:
        setButtonMargin(r106);
        goto L39
    L25:
        if (r101.f455196h == false) goto L35;
        int r107 = (int) ((r102 * 0.3f) + 0.5f);
        if (this.f455165u == false) goto L29;
        r107 = r107 - this.f455166v;
    L29:
        f(this.f455150f, r107);
        if (this.f455145a.f455198j == false) goto L39;
        int r108 = (((((this.f455146b - r107) - b(this.f455150f)) - this.f455155k) - b(this.f455151g)) - this.f455157m) - this.f455156l;
        if (this.f455165u == false) goto L34;
        r108 = r108 - this.f455166v;
    L34:
        setButtonMargin(r108);
        goto L39
    L35:
        int r109 = (int) ((r102 * 0.3f) + 0.5f);
        if (this.f455165u == false) goto L38;
        r109 = r109 - this.f455166v;
    L38:
        f(this.f455151g, r109);
        goto L39
    }

    public final void d() {
        StyleTextView r100 = (StyleTextView) findViewById(R.id.tv_title);
        this.f455150f = r100;
        a r101 = this.f455145a;
        if (r101.f455196h == false) goto L5;
        r100.setText(r101.f455190b);
    L5:
        a r102 = this.f455145a;
        boolean r103 = r102.f455198j;
        if (r103 == false) goto L17;
        LinearLayout r104 = this.f455148d;
        StyleTextView r105 = null;
        if (r103 == true) goto L11;
        StyleTextView r106 = null;
    L14:
        if (r106 == null) goto L16;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(this.f455158n, this.f455157m);
        r107.gravity = 1;
        r104.addView(r106, r107);
        r106.setText(r102.f455193e);
        r106.setOnClickListener(null);
        r105 = r106;
    L16:
        this.f455152h = r105;
        goto L17
    L11:
        if (r102.f455192d != ButtonStyle.SOLID) goto L13;
        r106 = new StyleTextView(new ContextThemeWrapper(getContext(), R.style.tools_default_button_solid));
        goto L14
    L13:
        r106 = new StyleTextView(new ContextThemeWrapper(getContext(), R.style.tools_default_button_border));
    L17:
        StyleTextView r108 = (StyleTextView) findViewById(R.id.tv_desc);
        this.f455151g = r108;
        a r109 = this.f455145a;
        if (r109.f455197i == false) goto L21;
        r108.setText(r109.f455191c);
        return;
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
    public final void e() {
        a();
        removeAllViews();
        setScrollY(0);
        if (this.f455165u == false) goto L5;
        this.f455146b = ScreenUtils.a(getContext()) - this.f455167w;
    L5:
        a r100 = this.f455145a;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f455146b >= this.f455153i) goto L11;
        return;
    L11:
        if (r100.f455195g == false) goto L14;
        LayoutInflater.from(getContext()).inflate(R.layout.tools_layout_default_with_pic, this, true);
        this.f455148d = (LinearLayout) findViewById(R.id.layout_parent);
        ImageView r101 = (ImageView) findViewById(R.id.iv_empty);
        this.f455149e = r101;
        r101.setImageDrawable(this.f455145a.f455189a);
        d();
        LinearLayout r102 = this.f455148d;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-1, this.f455156l);
        r102.addView(new Space(getContext()), r103);
    L20:
        View.OnClickListener r104 = this.f455163s;
        if (r104 == null) goto L23;
        this.f455148d.setOnClickListener(r104);
    L23:
        this.f455162r = true;
        if (this.f455148d == null) goto L85;
        if (this.f455145a == null) goto L85;
        Resources r105 = getResources();
        StyleTextView r106 = this.f455150f;
        if (r106 != null) goto L32;
    L36:
        StyleTextView r107 = this.f455151g;
        if (r107 != null) goto L39;
    L43:
        StyleTextView r108 = this.f455152h;
        if (r108 == 0) goto L85;
        boolean r109 = r108 instanceof AVIconButton;
        int r110 = R.drawable.tools_bg_default_button_solid_light;
        int r111 = R.drawable.tools_bg_default_state_view_button_border;
        if (r109 == false) goto L65;
        AVIconButton r112 = (AVIconButton) r108;
        int r113 = this.f455164t;
        if (r112.f455168a == r113) goto L85;
        r112.f455168a = r113;
        if (r112.f455171d != ButtonStyle.SOLID) goto L57;
        if (r113 != 0) goto L53;
        r112.setBackgroundResource(R.drawable.tools_bg_default_button_solid_light);
    L54:
        r112.f455170c.setTextColor(ResourcesCompat.getColor(r112.getContext().getResources(), R.color.tools_const_tInverse, null));
        if (r112.f455172e == (-1)) goto L85;
        d.a(r112.getContext(), r112.f455169b, r112.f455172e, R.color.tools_const_tInverse);
        goto L85
    L53:
        r112.setBackgroundResource(R.drawable.tools_bg_default_button_solid_dark);
        goto L54
    L57:
        if (r113 != 0) goto L61;
        r112.setBackgroundResource(R.drawable.tools_bg_default_state_view_button_border);
        r112.f455170c.setTextColor(ResourcesCompat.getColor(r112.getContext().getResources(), R.color.tools_reverse_tPrimary_light, null));
        if (r112.f455172e == (-1)) goto L85;
        d.a(r112.getContext(), r112.f455169b, r112.f455172e, R.color.tools_reverse_tPrimary_light);
        goto L85
    L61:
        r112.setBackgroundResource(R.drawable.tools_bg_default_button_border_dark);
        r112.f455170c.setTextColor(ResourcesCompat.getColor(r112.getContext().getResources(), R.color.tools_reverse_tPrimary_dark, null));
        if (r112.f455172e == (-1)) goto L85;
        d.a(r112.getContext(), r112.f455169b, r112.f455172e, R.color.tools_reverse_tPrimary_dark);
        goto L85
    L65:
        if (this.f455145a.f455192d != ButtonStyle.SOLID) goto L76;
        if (this.f455164t == 0) goto L70;
        r110 = R.drawable.tools_bg_default_button_solid_dark;
    L70:
        r108.setBackgroundResource(r110);
        if (this.f455164t != 0) goto L73;
        int r114 = ResourcesCompat.getColor(r105, R.color.tools_tInverse_light, null);
    L74:
        r108.setTextColor(r114);
        goto L85
    L73:
        r114 = ResourcesCompat.getColor(r105, R.color.tools_tInverse_dark, null);
        goto L74
    L76:
        if (this.f455164t == 0) goto L79;
        r111 = R.drawable.tools_bg_default_button_border_dark;
    L79:
        r108.setBackgroundResource(r111);
        if (this.f455164t != 0) goto L82;
        int r115 = ResourcesCompat.getColor(r105, R.color.tools_tPrimary_light, null);
    L83:
        r108.setTextColor(r115);
        goto L85
    L82:
        r115 = ResourcesCompat.getColor(r105, R.color.tools_tPrimary_dark, null);
        goto L83
    L39:
        if (this.f455164t != 0) goto L41;
        int r116 = ResourcesCompat.getColor(r105, R.color.tools_tSecondary_light, null);
    L42:
        r107.setTextColor(r116);
        goto L43
    L41:
        r116 = ResourcesCompat.getColor(r105, R.color.tools_tSecondary_dark, null);
        goto L42
    L32:
        if (this.f455164t != 0) goto L34;
        int r117 = ResourcesCompat.getColor(r105, R.color.tools_tPrimary_light, null);
    L35:
        r106.setTextColor(r117);
        goto L36
    L34:
        r117 = ResourcesCompat.getColor(r105, R.color.tools_tPrimary_dark, null);
    L85:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L87;
        setLayoutDirection(0);
        this.f455148d.setLayoutDirection(1);
    L87:
        c();
        return;
    L14:
        if (r100.f455196h == false) goto L16;
        LayoutInflater.from(getContext()).inflate(R.layout.tools_layout_default_text_only, this, true);
        this.f455148d = (LinearLayout) findViewById(R.id.layout_parent);
        d();
    L19:
        LinearLayout r118 = this.f455148d;
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(-1, this.f455156l);
        r118.addView(new Space(getContext()), r119);
        goto L20
    L16:
        LayoutInflater.from(getContext()).inflate(R.layout.tools_layout_default_desc_only, this, true);
        this.f455148d = (LinearLayout) findViewById(R.id.layout_parent);
        StyleTextView r120 = (StyleTextView) findViewById(R.id.tv_desc);
        this.f455151g = r120;
        a r121 = this.f455145a;
        if (r121.f455197i == false) goto L19;
        r120.setText(r121.f455191c);
        goto L19
    }

    public AVDefaultView(Context r100) {
        this(r100, null);
    }

    private void setButtonMargin(int r100) {
        int r101 = this.f455156l;
        if (r100 >= r101) goto L5;
        f(this.f455152h, r101);
        return;
    L5:
        int r102 = (int) ((this.f455146b * 0.2f) + 0.5f);
        if (r102 >= r101) goto L8;
        f(this.f455152h, r100);
        return;
    L8:
        int r103 = r100 - (r102 - r101);
        if (r103 <= r101) goto L11;
        f(this.f455152h, r103);
        return;
    L11:
        f(this.f455152h, r101);
    }

    public final int b(StyleTextView r100) {
        r100.measure(View.MeasureSpec.makeMeasureSpec(this.f455147c - (this.f455160p * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r100.getMeasuredHeight();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f455163s = r100;
        LinearLayout r101 = this.f455148d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setStatus(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f455145a = r100;
        if (r100.f455198j == false) goto L14;
        if (r100.f455196h == false) goto L12;
        if (r100.f455197i == true) goto L14;
    L12:
        throw new IllegalArgumentException("button must with title and description!");
    L14:
        if (r100.f455199k == true) goto L16;
    L30:
        a r101 = this.f455145a;
        if (r101.f455196h == false) goto L42;
        if (TextUtils.isEmpty(r101.f455190b) == true) goto L40;
        if (this.f455145a.f455197i == false) goto L38;
    L52:
        this.f455162r = false;
        if (this.f455146b <= 0) goto L56;
        e();
        return;
    L56:
        return;
    L38:
        throw new IllegalArgumentException("title text must have a description!");
    L40:
        throw new IllegalArgumentException("title text should not be empty String!");
    L42:
        if (r101.f455197i == false) goto L52;
        if (TextUtils.isEmpty(r101.f455191c) == true) goto L51;
        if (this.f455145a.f455195g == false) goto L52;
        throw new IllegalArgumentException("desc text should only have itself!");
    L51:
        throw new IllegalArgumentException("desc text should not be empty String!");
    L16:
        if (TextUtils.isEmpty(r100.f455194f) == true) goto L29;
        a r102 = this.f455145a;
        if (r102.f455195g == false) goto L27;
        if (r102.f455196h == false) goto L27;
        if (r102.f455197i == false) goto L27;
        if (r102.f455198j == true) goto L30;
    L27:
        throw new IllegalArgumentException("extra text must with all elements!");
    L29:
        throw new IllegalArgumentException("extra text should not be empty String!");
    }

    @Override // com.ss.android.ugc.tools.view.widget.statusview.c
    public void setUseScreenHeight(int r100) {
        this.f455165u = true;
        this.f455167w = r100;
        if (this.f455145a != null) goto L5;
        return;
    L5:
        if (this.f455162r == false) goto L7;
        c();
        return;
    L7:
        e();
    }

    public AVDefaultView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void f(View r100, int r101) {
        ((LinearLayout.LayoutParams) r100.getLayoutParams()).topMargin = r101;
    }

    public AVDefaultView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f455146b = 0;
        this.f455147c = 0;
        this.f455162r = false;
        this.f455164t = 1;
        a();
        a r103 = null;
        if (r101 == null) goto L29;
        Context r104 = getContext();
        TypedArray r105 = r104.obtainStyledAttributes(r101, new int[]{R.attr.avDefaultButtonStyle, R.attr.avDefaultButtonText, R.attr.avDefaultDescText, R.attr.avDefaultExtraText, R.attr.avDefaultImagePlaceHolder, R.attr.avDefaultTitleText});
        if (r105 == null) goto L29;
        a r106 = new a();
        if (r105.hasValue(4) == false) goto L10;
        r106.f455189a = ResourcesCompat.getDrawable(r104.getResources(), r105.getResourceId(4, 0), null);
        r106.f455195g = true;
    L10:
        if (r105.hasValue(1) == false) goto L13;
        r106.f455193e = r105.getString(1);
        r106.f455198j = true;
    L13:
        if (r105.hasValue(0) == false) goto L20;
        if (r105.getInt(0, 1) != 1) goto L17;
        ButtonStyle r107 = ButtonStyle.SOLID;
    L18:
        r106.f455192d = r107;
        r106.f455198j = true;
        goto L20
    L17:
        r107 = ButtonStyle.BORDER;
    L20:
        if (r105.hasValue(5) == false) goto L23;
        r106.f455190b = r105.getString(5);
        r106.f455196h = true;
    L23:
        if (r105.hasValue(2) == false) goto L26;
        r106.f455191c = r105.getString(2);
        r106.f455197i = true;
    L26:
        if (r105.hasValue(3) == false) goto L28;
        r106.f455194f = r105.getString(3);
        r106.f455199k = true;
    L28:
        r105.recycle();
        r103 = r106;
    L29:
        Resources r108 = getContext().getResources();
        this.f455153i = r108.getDimensionPixelSize(R.dimen.av_default_min_height);
        this.f455154j = r108.getDimensionPixelSize(R.dimen.av_default_title_margin);
        this.f455155k = r108.getDimensionPixelSize(R.dimen.av_default_desc_margin);
        this.f455156l = r108.getDimensionPixelSize(R.dimen.av_default_min_margin);
        this.f455158n = r108.getDimensionPixelSize(R.dimen.av_default_button_width);
        this.f455157m = r108.getDimensionPixelSize(R.dimen.av_default_button_height);
        this.f455159o = r108.getDimensionPixelSize(R.dimen.av_default_button_margin_with_extra);
        this.f455160p = r108.getDimensionPixelSize(R.dimen.av_empty_page_padding);
        this.f455161q = r108.getDimensionPixelSize(R.dimen.av_default_image_height);
        if (r103 != null) goto L32;
        return;
    L32:
        if (r103.f455195g == false) goto L34;
    L41:
        setStatus(r103);
        return;
    L34:
        if (r103.f455198j == true) goto L41;
        if (r103.f455196h == true) goto L41;
        if (r103.f455197i == true) goto L41;
        if (r103.f455199k == true) goto L41;
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f455146b == r101) goto L5;
    L6:
        this.f455147c = r100;
        this.f455146b = r101;
        LinearLayout r104 = this.f455148d;
        if (r104 == null) goto L9;
        r104.post(new b(this));
        return;
    L9:
        if (this.f455145a != null) goto L11;
        return;
    L11:
        if (this.f455162r == false) goto L13;
        c();
        return;
    L13:
        e();
        return;
    L5:
        if (this.f455147c != r100) goto L6;
    }
}
