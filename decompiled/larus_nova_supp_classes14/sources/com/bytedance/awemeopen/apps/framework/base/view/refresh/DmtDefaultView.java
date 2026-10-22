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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DmtDefaultView extends ScrollView implements f, h {
    public static final /* synthetic */ int B = 0;
    public boolean A;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.a a;
    public int b;
    public int c;
    public LinearLayout d;
    public ImageView e;
    public DmtTextView f;
    public DmtTextView g;
    public DmtTextView h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public View.OnClickListener v;
    public int w;
    public boolean x;
    public int y;
    public int z;

    public class a implements Runnable {
        public final /* synthetic */ DmtDefaultView a;

        @Override // java.lang.Runnable
        public final void run() {
            DmtDefaultView r0 = this.a;     // Catch: Throwable -> L9
            int r1 = DmtDefaultView.B;     // Catch: Throwable -> L9
            if (r0.a != null) goto L5;
        L14:
            return;
        L5:
            if (r0.s == false) goto L7;
            r0.g();     // Catch: Throwable -> L9
            goto L14
        L7:
            r0.i();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(DmtDefaultView r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getButtonString() {
        DmtTextView r0 = this.h;
        if (r0 != 0) goto L5;
        return "";
    L5:
        if ((r0 instanceof DmtIconButton) == true) goto L7;
        CharSequence r1 = r0.getText();
        if (r1 != null) goto L12;
        return "";
    L12:
        return r1.toString();
    L7:
        return ((DmtIconButton) r0).getTextString();
    }

    public String getDescString() {
        DmtTextView r0 = this.g;
        if (r0 != null) goto L6;
        return "";
    L6:
        if (r0.getText() != null) goto L9;
        return "";
    L9:
        return this.g.getText().toString();
    }

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
        if (this.d != null) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        return;
    L8:
        Resources r0 = getResources();
        if (this.f == null) goto L15;
        this.a.getClass();
        AppCompatTextView r1 = this.f;
        if (this.w != 0) goto L13;
        int r4 = r0.getColor(2131100357);
    L14:
        r1.setTextColor(r4);
        goto L15
    L13:
        r4 = r0.getColor(2131100356);
    L15:
        AppCompatTextView r2 = this.g;
        if (r2 != null) goto L18;
    L22:
        AppCompatTextView r3 = this.h;
        if (r3 != null) goto L25;
        return;
    L25:
        if ((r3 instanceof DmtIconButton) == false) goto L27;
        ((DmtIconButton) r3).a(this.w);
        return;
    L27:
        ButtonStyle r5 = this.a.c;
        ButtonStyle r6 = ButtonStyle.SOLID;
        if (r5 != r6) goto L35;
        if (this.w != 0) goto L32;
        int r7 = 2131231622;
    L33:
        r3.setBackgroundResource(r7);
    L39:
        this.a.getClass();
        if (this.a.c != r6) goto L47;
        if (this.w != 0) goto L44;
        int r8 = r0.getColor(2131100355);
    L45:
        r3.setTextColor(r8);
        return;
    L44:
        r8 = r0.getColor(2131100354);
        goto L45
    L47:
        if (this.w != 0) goto L49;
        int r9 = r0.getColor(2131100357);
    L50:
        r3.setTextColor(r9);
        return;
    L49:
        r9 = r0.getColor(2131100356);
        goto L50
    L32:
        r7 = 2131231621;
        goto L33
    L35:
        if (this.w != 0) goto L37;
        int r10 = 2131231620;
    L38:
        r3.setBackgroundResource(r10);
        goto L39
    L37:
        r10 = 2131231618;
        goto L38
    L18:
        if (this.w != 0) goto L20;
        int r11 = r0.getColor(2131100359);
    L21:
        r2.setTextColor(r11);
        goto L22
    L20:
        r11 = r0.getColor(2131100343);
        goto L21
    }

    public final void c() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L12;
        int r1 = r0.height;
        if (r1 < 0) goto L8;
        this.b = r1;
    L8:
        if (r1 == (-2)) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("DmtDefaultView doesn't support layout_height set to WRAP_CONTENT!");
    }

    public final void g() {
        c();
        if (this.x == false) goto L5;
        this.b = d0.c(getContext()) - this.z;
        int[] r0 = new int[2];
        getLocationOnScreen(r0);
        this.y = r0[1];
    L5:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r1 = this.a;
        if (r1 == null) goto L45;
        int r2 = this.b;
        if (r2 >= this.i) goto L11;
        return;
    L11:
        if (r1.f == false) goto L25;
        int r3 = (int) ((r2 * 0.2f) + 0.5f);
        if (this.x == false) goto L15;
        r3 = r3 - this.y;
    L15:
        k(this.e, r3);
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r4 = this.a;
        if (r4.i == true) goto L18;
    L39:
        this.g.requestLayout();
        if (this.y != 0) goto L42;
        return;
    L42:
        if (this.A == false) goto L47;
        this.d.setVisibility(0);
        return;
    L47:
        return;
    L18:
        if (r4.j == false) goto L20;
        k(this.h, this.p);
        goto L39
    L20:
        int r5 = (((((((this.b - r3) - this.r) - this.j) - f(this.f)) - this.k) - f(this.g)) - this.m) - this.l;
        if (this.x == false) goto L23;
        r5 = r5 - this.y;
    L23:
        setButtonMargin(r5);
        goto L39
    L25:
        if (r1.g == false) goto L35;
        int r6 = (int) ((r2 * 0.3f) + 0.5f);
        if (this.x == false) goto L29;
        r6 = r6 - this.y;
    L29:
        k(this.f, r6);
        if (this.a.i == false) goto L39;
        int r7 = (((((this.b - r6) - f(this.f)) - this.k) - f(this.g)) - this.m) - this.l;
        if (this.x == false) goto L34;
        r7 = r7 - this.y;
    L34:
        setButtonMargin(r7);
        goto L39
    L35:
        int r8 = (int) ((r2 * 0.3f) + 0.5f);
        if (this.x == false) goto L38;
        r8 = r8 - this.y;
    L38:
        k(this.g, r8);
        goto L39
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final void h() {
        ?? r0 = (DmtTextView) findViewById(2131391606);
        this.f = r0;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r1 = this.a;
        if (r1.g == false) goto L5;
        r0.setText(r1.a);
    L5:
        this.a.getClass();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r2 = this.a;
        boolean r3 = r2.i;
        if (r3 == false) goto L17;
        ?? r4 = this.d;
        ?? r5 = 0;
        if (r3 == true) goto L11;
        AppCompatTextView r6 = null;
    L14:
        if (r6 == null) goto L16;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(this.n, this.m);
        r7.gravity = 1;
        r4.addView(r6, r7);
        r6.setText(r2.d);
        r6.setOnClickListener(null);
        r5 = r6;
    L16:
        this.h = r5;
        goto L17
    L11:
        if (r2.c != ButtonStyle.SOLID) goto L13;
        r6 = new DmtTextView(new ContextThemeWrapper(getContext(), 2131954200));
        goto L14
    L13:
        r6 = new DmtTextView(new ContextThemeWrapper(getContext(), 2131954199));
    L17:
        ?? r8 = (DmtTextView) findViewById(2131390479);
        this.g = r8;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r9 = this.a;
        if (r9.h == false) goto L21;
        r8.setText(r9.b);
        this.a.getClass();
        return;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView] */
    public final void i() {
        c();
        removeAllViews();
        setScrollY(0);
        if (this.x == false) goto L5;
        this.b = d0.c(getContext()) - this.z;
    L5:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r1 = this.a;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.b >= this.i) goto L11;
        return;
    L11:
        if (r1.f == false) goto L22;
        LayoutInflater.from(getContext()).inflate(2131558669, this, true);
        this.d = (LinearLayout) findViewById(2131377557);
        ImageView r2 = (ImageView) findViewById(2131376208);
        this.e = r2;
        Context r3 = getContext();     // Catch: NullPointerException -> L15
        this.a.getClass();     // Catch: NullPointerException -> L15
        r2.setImageDrawable(ContextCompat.getDrawable(r3, 0));     // Catch: NullPointerException -> L15
    L17:
        h();
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r4 = this.a;
        if (r4.j == false) goto L20;
        LinearLayout r5 = this.d;
        AppCompatTextView r6 = new DmtTextView(new ContextThemeWrapper(getContext(), 2131954202));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        r7.topMargin = this.o;
        r5.addView(r6, r7);
        r6.setText(r4.e);
        this.a.getClass();
        r6.setOnClickListener(null);
    L20:
        b(this.d);
    L28:
        View.OnClickListener r8 = this.v;
        if (r8 == null) goto L31;
        this.d.setOnClickListener(r8);
    L31:
        this.s = true;
        j();
        if (this.A == false) goto L34;
        this.d.setVisibility(4);
    L34:
        boolean r9 = this.t;
        if (r9 == false) goto L37;
        d(Boolean.valueOf(r9));
    L41:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L43;
        setLayoutDirection(0);
        this.d.setLayoutDirection(1);
    L43:
        g();
        return;
    L37:
        boolean r10 = this.u;
        if (r10 == false) goto L41;
        e(Boolean.valueOf(r10));
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L22:
        if (r1.g == false) goto L24;
        LayoutInflater.from(getContext()).inflate(2131558668, this, true);
        this.d = (LinearLayout) findViewById(2131377557);
        h();
        b(this.d);
        goto L28
    L24:
        LayoutInflater.from(getContext()).inflate(2131558667, this, true);
        this.d = (LinearLayout) findViewById(2131377557);
        ?? r11 = (DmtTextView) findViewById(2131390479);
        this.g = r11;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r12 = this.a;
        if (r12.h == false) goto L27;
        r11.setText(r12.b);
        this.a.getClass();
    L27:
        b(this.d);
        goto L28
    }

    public DmtDefaultView(Context r2) {
        this(r2, null);
    }

    private void setButtonMargin(int r4) {
        int r0 = this.l;
        if (r4 >= r0) goto L5;
        k(this.h, r0);
        return;
    L5:
        int r1 = (int) ((this.b * 0.2f) + 0.5f);
        if (r1 >= r0) goto L8;
        k(this.h, r4);
        return;
    L8:
        int r5 = r4 - (r1 - r0);
        if (r5 <= r0) goto L11;
        k(this.h, r5);
        return;
    L11:
        k(this.h, r0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.f
    public final void a(int r2) {
        if (this.w == r2) goto L6;
        this.w = r2;
        j();
        return;
    }

    public final void b(LinearLayout r4) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, this.l);
        r4.addView(new Space(getContext()), r0);
    }

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
    public final void d(Boolean r4) {
        this.t = r4.booleanValue();
        if (r4.booleanValue() == false) goto L18;
        AppCompatTextView r5 = this.f;
        if (r5 == null) goto L7;
        r5.setTextColor(ContextCompat.getColor(getContext(), 2131100272));
    L7:
        AppCompatTextView r6 = this.g;
        if (r6 == null) goto L10;
        r6.setTextColor(ContextCompat.getColor(getContext(), 2131100273));
    L10:
        AppCompatTextView r7 = this.h;
        if (r7 != null) goto L13;
        return;
    L13:
        if (this.a.c != ButtonStyle.SOLID) goto L15;
        r7.setBackground(ContextCompat.getDrawable(getContext(), 2131231621));
    L16:
        this.a.getClass();
        this.h.setTextColor(ContextCompat.getColor(getContext(), 2131100272));
        return;
    L15:
        r7.setBackground(ContextCompat.getDrawable(getContext(), 2131231619));
        goto L16
    }

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
    public final void e(Boolean r4) {
        this.u = r4.booleanValue();
        if (r4.booleanValue() == false) goto L18;
        AppCompatTextView r5 = this.f;
        if (r5 == null) goto L7;
        r5.setTextColor(ContextCompat.getColor(getContext(), 2131100340));
    L7:
        AppCompatTextView r6 = this.g;
        if (r6 == null) goto L10;
        r6.setTextColor(ContextCompat.getColor(getContext(), 2131100342));
    L10:
        AppCompatTextView r7 = this.h;
        if (r7 != null) goto L13;
        return;
    L13:
        if (this.a.c != ButtonStyle.SOLID) goto L15;
        r7.setBackground(ContextCompat.getDrawable(getContext(), 2131231622));
    L16:
        this.a.getClass();
        this.h.setTextColor(ContextCompat.getColor(getContext(), 2131100340));
        return;
    L15:
        r7.setBackground(ContextCompat.getDrawable(getContext(), 2131231620));
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int f(DmtTextView r3) {
        r3.measure(View.MeasureSpec.makeMeasureSpec(this.c - (this.q * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r3.getMeasuredHeight();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        this.v = r2;
        LinearLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setStatus(com.bytedance.awemeopen.apps.framework.base.view.refresh.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.a = r2;
        if (r2.i == false) goto L14;
        if (r2.g == false) goto L12;
        if (r2.h == true) goto L14;
    L12:
        throw new IllegalArgumentException("button must with title and description!");
    L14:
        if (r2.j == true) goto L16;
    L30:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r3 = this.a;
        if (r3.g == false) goto L38;
        if (TextUtils.isEmpty(r3.a) == true) goto L36;
    L48:
        this.s = false;
        if (this.b <= 0) goto L52;
        i();
        return;
    L52:
        return;
    L36:
        throw new IllegalArgumentException("title text should not be empty String!");
    L38:
        if (r3.h == false) goto L48;
        if (TextUtils.isEmpty(r3.b) == true) goto L47;
        if (this.a.f == false) goto L48;
        throw new IllegalArgumentException("desc text should only have itself!");
    L47:
        throw new IllegalArgumentException("desc text should not be empty String!");
    L16:
        if (TextUtils.isEmpty(r2.e) == true) goto L29;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r4 = this.a;
        if (r4.f == false) goto L27;
        if (r4.g == false) goto L27;
        if (r4.h == false) goto L27;
        if (r4.i == true) goto L30;
    L27:
        throw new IllegalArgumentException("extra text must with all elements!");
    L29:
        throw new IllegalArgumentException("extra text should not be empty String!");
    }

    public void setSupportDelayVisible(boolean r1) {
        this.A = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.h
    public void setUseScreenHeight(int r2) {
        this.x = true;
        this.z = r2;
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.s == false) goto L7;
        g();
        return;
    L7:
        i();
    }

    public DmtDefaultView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static void k(View r0, int r1) {
        ((LinearLayout.LayoutParams) r0.getLayoutParams()).topMargin = r1;
    }

    public DmtDefaultView(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.b = 0;
        this.c = 0;
        this.s = false;
        this.t = false;
        this.u = false;
        this.w = 1;
        c();
        if (r6 == null) goto L29;
        Context r0 = getContext();
        TypedArray r8 = r0.obtainStyledAttributes(r6, new int[]{2130969727, 2130969728, 2130969730, 2130969735, 2130969737, 2130969741});
        if (r8 == null) goto L29;
        com.bytedance.awemeopen.apps.framework.base.view.refresh.a r1 = new com.bytedance.awemeopen.apps.framework.base.view.refresh.a();
        if (r8.hasValue(4) == false) goto L10;
        r0.getResources().getDrawable(r8.getResourceId(4, 0));
        r1.f = true;
    L10:
        if (r8.hasValue(1) == false) goto L13;
        r1.d = r8.getString(1);
        r1.i = true;
    L13:
        if (r8.hasValue(0) == false) goto L20;
        if (r8.getInt(0, 1) != 1) goto L17;
        ButtonStyle r9 = ButtonStyle.SOLID;
    L18:
        r1.c = r9;
        r1.i = true;
        goto L20
    L17:
        r9 = ButtonStyle.BORDER;
    L20:
        if (r8.hasValue(5) == false) goto L23;
        r1.a = r8.getString(5);
        r1.g = true;
    L23:
        if (r8.hasValue(2) == false) goto L26;
        r1.b = r8.getString(2);
        r1.h = true;
    L26:
        if (r8.hasValue(3) == false) goto L28;
        r1.e = r8.getString(3);
        r1.j = true;
    L28:
        r8.recycle();
    L30:
        Resources r10 = getContext().getResources();
        this.i = r10.getDimensionPixelSize(2131165325);
        this.j = r10.getDimensionPixelSize(2131165327);
        this.k = r10.getDimensionPixelSize(2131165320);
        this.l = r10.getDimensionPixelSize(2131165326);
        this.n = r10.getDimensionPixelSize(2131165319);
        this.m = r10.getDimensionPixelSize(2131165317);
        this.o = r10.getDimensionPixelSize(2131165321);
        this.p = r10.getDimensionPixelSize(2131165318);
        this.q = r10.getDimensionPixelSize(2131165328);
        this.r = r10.getDimensionPixelSize(2131165322);
        if (r1 != null) goto L33;
        return;
    L33:
        if (r1.f == false) goto L35;
    L42:
        setStatus(r1);
        return;
    L35:
        if (r1.i == true) goto L42;
        if (r1.g == true) goto L42;
        if (r1.h == true) goto L42;
        if (r1.j == true) goto L42;
        return;
    L29:
        r1 = null;
        goto L30
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.b == r2) goto L5;
    L6:
        this.c = r1;
        this.b = r2;
        LinearLayout r5 = this.d;
        if (r5 != null) goto L9;
        post(new b(this));
        return;
    L9:
        r5.post(new a(this));
        return;
    L5:
        if (this.c != r1) goto L6;
    }
}
