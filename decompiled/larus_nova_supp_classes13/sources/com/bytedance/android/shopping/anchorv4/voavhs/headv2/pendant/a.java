package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantNative;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.m;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.TabHighLightView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends FrameLayout implements o<HeaderPendantNative>, com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c {
    public static final /* synthetic */ int o = 0;
    public boolean a;
    public Boolean b;
    public boolean c;
    public int d;
    public List<m> e;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a f;
    public TabHighLightView g;
    public m h;
    public boolean i;
    public boolean j;
    public HeaderPendantNative k;
    public final Paint l;
    public final RectF m;
    public final s n;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.a$a, reason: collision with other inner class name */
    public static final class C0014a {
        public C0014a() {
        }

        public static TextView a(Context r3, String r4) {
            int r0 = a.o;
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "textValue");
            TextView r1 = new TextView(r3);
            ViewGroup.LayoutParams r5 = r1.getLayoutParams();
            if (r5 != null) goto L5;
            r5 = new ViewGroup.LayoutParams(-2, -2);
        L5:
            r5.width = -2;
            r5.height = -1;
            Unit r2 = Unit.INSTANCE;
            r1.setLayoutParams(r5);
            r1.setSingleLine(true);
            int r6 = (int) UIUtils.dip2Px(r1.getContext(), 8.0f);
            r1.setTextSize(10.0f);
            r1.setTypeface(Typeface.DEFAULT_BOLD);
            r1.setGravity(17);
            r1.setTextColor(-1);
            r1.setPadding(r6, 0, r6, 0);
            r1.setText(r4);
            return r1;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TabHighLightView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ View c;

        public b(TabHighLightView r1, boolean r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            this.a.animate().cancel();
            if (this.b == false) goto L5;
            this.a.animate().translationX(this.c.getX()).setDuration(250).start();
            return;
        L5:
            this.a.setTranslationX(this.c.getX());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a a;
        public final /* synthetic */ a b;

        public c(com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.b.a = false;
            this.a.removeAllViewsInLayout();
            a.i(this.b);
            this.b.n.w7().g(TabClickType.TYPE_EXPAND.getType(), null);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ m a;
        public final /* synthetic */ int b;
        public final /* synthetic */ a c;

        public d(m r1, int r2, a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.c.m(this.b, true);
            a r4 = this.c;
            m r0 = this.a;
            r4.h = r0;
            r4.n.eh().n(r0.e(), null);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a a;
        public final /* synthetic */ a b;

        public e(com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.a.isLayoutRequested() == true) goto L5;
            return;
        L5:
            if (this.b.isLayoutRequested() == true) goto L15;
            this.a.requestLayout();     // Catch: Throwable -> L8
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a a;
        public final /* synthetic */ a b;
        public final /* synthetic */ m c;
        public final /* synthetic */ Ref.IntRef d;

        public f(com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r1, a r2, m r3, Ref.IntRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.a.getChildCount();     // Catch: Throwable -> L7
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.a.getChildAt(r2).requestLayout();     // Catch: Throwable -> L7
            r2 = r2 + 1;     // Catch: Throwable -> L7
            goto L3
        L5:
            this.a.invalidate();     // Catch: Throwable -> L7
            this.b.j(this.d.element, this.c, false, true);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        new C0014a();
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
    private final void update() {
        List<m> r1 = this.e;
        int r3 = 0;
        if (r1 == null) goto L16;
        Iterator<T> r2 = r1.iterator();
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L16;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        m r7 = (m) r5;
        if (this.d < r7.e()) goto L15;
        if (this.d >= (r7.e() + r7.g())) goto L15;
    L17:
        List<m> r8 = this.e;
        if (r8 == null) goto L20;
        m r9 = (m) CollectionsKt.getOrNull(r8, r4);
    L22:
        if (r9 != null) goto L26;
        setVisibility(8);
        return;
    L26:
        if (getVisibility() != 8) goto L28;
        boolean r10 = true;
    L29:
        setVisibility(0);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        String r12 = r9.b(this.d);
        r11.element = r12;
        if (r12 != null) goto L32;
    L35:
        boolean r13 = true;
    L37:
        if (r13 == false) goto L51;
        StringBuilder r14 = new StringBuilder();
        r14.append((this.d - r9.e()) + 1);
        r14.append('/');
        r14.append(r9.g());
        String r15 = r14.toString();
        List<m> r16 = this.e;
        if (r16 == null) goto L44;
        if (r16.size() != 1) goto L44;
    L49:
        r11.element = r15;
    L44:
        if (r9.g() <= 1) goto L46;
        r15 = r9.d() + r15;
        goto L49
    L46:
        r15 = r9.d();
        if (r15 != null) goto L49;
        r15 = "";
    L51:
        if (this.a == false) goto L53;
    L110:
        Boolean r17 = this.b;
        Boolean r18 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r17, r18)) == false) goto L113;
        this.b = r18;
        this.f.removeAllViewsInLayout();
    L113:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r19 = this.f;
        if (r19.getChildCount() != 0) goto L131;
        TextView r20 = C0014a.a(r19.getContext(), (String) r11.element);
        ViewGroup.LayoutParams r110 = r20.getLayoutParams();
        if (r110 != null) goto L118;
        r110 = new ViewGroup.LayoutParams(-2, -2);
    L118:
        r110.width = -2;
        r110.height = -1;
        Unit r111 = Unit.INSTANCE;
        r20.setLayoutParams(r110);
        r20.setBackgroundResource(2131231273);
        r19.addView(r20);
        if (this.n.rR().l() == true) goto L121;
    L123:
        boolean r21 = false;
    L125:
        if (r21 == false) goto L127;
    L130:
        Context r22 = r19.getContext();
        Intrinsics.checkNotNullParameter(r22, "context");
        ImageView r112 = new ImageView(r22);
        r112.setImageResource(2131234457);
        int r23 = (int) UIUtils.dip2Px(r22, 4.0f);
        r112.setPadding(r23, r23, r23, r23);
        r19.addView(r112, -2, -1);
        goto L131
    L127:
        if (this.j == true) goto L130;
        Context r24 = r19.getContext();
        Intrinsics.checkNotNullParameter(r24, "context");
        ImageView r113 = new ImageView(r24);
        r113.setImageResource(2131234470);
        int r25 = (int) UIUtils.dip2Px(r24, 4.0f);
        r113.setPadding(r25, r25, r25, r25);
        r113.setOnClickListener(new c(r19, this));
        r19.addView(r113, -2, -1);
        goto L131
    L121:
        if (n() == false) goto L123;
        r21 = true;
    L131:
        View r26 = r19.getChildAt(1);
        if (r26 == null) goto L140;
        List<m> r27 = this.e;
        if (r27 != null) goto L136;
    L138:
        int r28 = 0;
    L139:
        r26.setVisibility(r28);
        goto L140
    L136:
        if (r27.size() != 1) goto L138;
        r28 = 8;
    L140:
        View r29 = r19.getChildAt(0);
        if ((r29 instanceof TextView) == true) goto L143;
        View r30 = null;
    L144:
        TextView r31 = (TextView) r30;
        if (r31 == null) goto L147;
        r31.setText((String) r11.element);
    L147:
        TabHighLightView r32 = this.g;
        if (r32 == null) goto L151;
        r32.setVisibility(8);
    L151:
        if ((!Intrinsics.areEqual(r9, this.h)) == true) goto L153;
    L155:
        this.h = r9;
        if (this.i == true) goto L166;
        this.i = true;
        List<m> r33 = this.e;
        if (r33 == null) goto L166;
        Iterator<T> r34 = r33.iterator();
    L161:
        if (r34.hasNext() == false) goto L166;
        Object r35 = r34.next();
        int r36 = r3 + 1;
        if (r3 >= 0) goto L165;
        CollectionsKt.throwIndexOverflow();
    L165:
        m r37 = (m) r35;
        this.n.w7().h(k(r3));
        r3 = r36;
    L166:
        b();
        return;
    L153:
        if (this.h == null) goto L155;
        m(r4, false);
        goto L155
    L143:
        r30 = r29;
        goto L144
    L53:
        if (this.n.rR().l() == true) goto L55;
    L57:
        boolean r114 = false;
    L58:
        if (r114 == true) goto L110;
        Boolean r38 = this.b;
        Boolean r115 = Boolean.FALSE;
        if ((!Intrinsics.areEqual(r38, r115)) == false) goto L64;
        this.b = r115;
        this.f.removeAllViewsInLayout();
    L64:
        if (this.g != null) goto L66;
        TabHighLightView r39 = new TabHighLightView(getContext());
        r39.setBackgroundResource(2131231273);
        this.g = r39;
        Unit r116 = Unit.INSTANCE;
        addView(r39, 0, new FrameLayout.LayoutParams(0, 0));
    L66:
        TabHighLightView r40 = this.g;
        if (r40 == null) goto L69;
        r40.setVisibility(0);
    L69:
        Ref.IntRef r41 = new Ref.IntRef();
        r41.element = -1;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r42 = this.f;
        List<m> r117 = this.e;
        if (r117 != null) goto L72;
    L73:
        r42.removeAllViewsInLayout();
        List<m> r118 = this.e;
        if (r118 == null) goto L86;
        Iterator<T> r119 = r118.iterator();
        int r120 = 0;
    L77:
        if (r119.hasNext() == false) goto L86;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L81;
        CollectionsKt.throwIndexOverflow();
    L81:
        m r123 = (m) r121;
        Context r124 = r42.getContext();
        String r125 = r123.d();
        if (r125 != null) goto L84;
        String r43 = "";
    L85:
        TextView r44 = C0014a.a(r124, r43);
        r44.setTag(r123);
        r44.setOnClickListener(new d(r123, r120, this));
        Unit r126 = Unit.INSTANCE;
        r42.addView(r44);
        r120 = r122;
        goto L77
    L84:
        r43 = r125;
    L86:
        int r45 = r42.getChildCount();
        int r127 = 0;
    L87:
        if (r127 >= r45) goto L106;
        View r128 = r42.getChildAt(r127);
        if (r128 == null) goto L105;
        TextView r129 = (TextView) r128;
        if ((!Intrinsics.areEqual(r129.getTag(), r9)) == false) goto L102;
        Object r130 = r129.getTag();
        if ((r130 instanceof m) == true) goto L95;
        r130 = null;
    L95:
        m r131 = (m) r130;
        if (r131 == null) goto L98;
        String r132 = r131.d();
    L99:
        if (r132 != null) goto L101;
        r132 = "";
    L101:
        r129.setText(r132);
    L103:
        r127 = r127 + 1;
        goto L87
    L98:
        r132 = null;
        goto L99
    L102:
        r41.element = r127;
        r129.setText((String) r11.element);
        goto L103
    L105:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L106:
        r42.post(new e(r42, this));
        if (r42.getHasMeasuredButNotLayout() == false) goto L109;
        r42.post(new f(r42, this, r9, r41));
    L109:
        j(r41.element, r9, !r10, false);
        goto L151
    L72:
        if (r117.size() == r42.getChildCount()) goto L86;
    L55:
        if (n() == false) goto L57;
        r114 = true;
        goto L58
    L32:
        if (r12.length() == 0) goto L35;
        r13 = false;
        goto L37
    L28:
        r10 = false;
        goto L29
    L20:
        r9 = null;
    L15:
        r4 = r6;
    L16:
        r4 = -1;
        goto L17
    }

    public final boolean n() {
        List<m> r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L6:
        HeaderPendantNative r2 = this.k;
        if (r2 == null) goto L11;
        Integer r3 = r2.getMaxTabNum();
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L13:
        if (r1 <= r4) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        return false;
    L18:
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L20;
    L21:
        return true;
    L20:
        if (this.n.s() == true) goto L21;
        return false;
    L15:
        r5 = false;
    L11:
        r4 = 4;
        goto L13
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void b() {
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L7;
    L11:
        int r0 = 0;
    L12:
        setVisibility(r0);
        return;
    L7:
        if (this.n.s() == true) goto L11;
        if (this.n.isExpanded() == true) goto L11;
        r0 = 4;
        goto L12
    }

    public static final /* synthetic */ void i(a r0) {
        r0.update();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void a(boolean r2) {
        if (getVisibility() != 0) goto L8;
        if (r2 == false) goto L6;
        ViewExtensionsKt.c(this, false, 3);
        return;
    L6:
        ViewExtensionsKt.i(this);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void c(boolean r1) {
        if (n() == false) goto L6;
        this.f.removeAllViewsInLayout();
        update();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void g(HeaderPendantNative r3) {
        this.k = r3;
        if (r3 == null) goto L5;
        List<m> r0 = r3.getHeaderTabs();
    L6:
        this.e = r0;
        if (this.c == false) goto L14;
        boolean r1 = false;
        this.c = false;
        if (r3 != null) goto L11;
    L12:
        r1 = true;
    L13:
        this.a = r1;
        goto L14
    L11:
        if (r3.getExpand() == true) goto L13;
    L14:
        update();
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final Map<String, Object> k(int r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        List<m> r1 = this.e;
        if (r1 == null) goto L9;
        m r2 = (m) CollectionsKt.getOrNull(r1, r3);
        if (r2 == null) goto L9;
        Map<String, Object> r4 = r2.h();
        if (r4 == null) goto L9;
        r0.putAll(r4);
        r0.put("tab_rank", Integer.valueOf(r3 + 1));
    L9:
        return r0;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        float r0 = getHeight() / 2.0f;
        float r1 = q.a(Double.valueOf(0.5d));
        this.m.set(0.0f, 0.0f, getWidth(), getHeight());
        this.m.inset(r1, r1);
        this.l.setStyle(Paint.Style.FILL);
        this.l.setColor(1461065763);
        r7.drawRoundRect(this.m, r0, r0, this.l);
        float r3 = (-r1) / 2;
        this.m.inset(r3, r3);
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setStrokeWidth(r1);
        this.l.setColor(536870911);
        r7.drawRoundRect(this.m, r0, r0, this.l);
        super.onDraw(r7);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void onPageSelected(int r2) {
        this.d = r2;
        boolean r0 = true;
        if ((!this.n.Rm().isEmpty()) == false) goto L8;
        Boolean r3 = this.n.Rm().get(Integer.valueOf(this.d));
        if (r3 == null) goto L7;
        r0 = r3.booleanValue();
    L15:
        if (r0 == this.a) goto L17;
        this.a = r0;
        this.j = r0;
        this.f.removeAllViews();
    L17:
        update();
        return;
    L7:
        r0 = this.a;
        goto L15
    L8:
        HeaderPendantNative r4 = this.k;
        if (r4 == null) goto L15;
        if (r4.getExpand() != true) goto L15;
        r0 = false;
        goto L15
    }

    public a(Context r3, s r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "headAbility");
        super(r3);
        this.n = r4;
        this.a = true;
        this.c = true;
        this.d = r4.getCurrentPosition();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a r5 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.indicator.a(r3);
        this.f = r5;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.FILL);
        r6.setStrokeCap(Paint.Cap.ROUND);
        Unit r0 = Unit.INSTANCE;
        this.l = r6;
        this.m = new RectF();
        addView(r5, new FrameLayout.LayoutParams(-2, -1));
        setWillNotDraw(false);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.c
    public final void d(boolean r2, int r3) {
        if (this.d == r3) goto L5;
        return;
    L5:
        if (r2 == this.a) goto L10;
        this.j = r2;
        this.a = r2;
        this.f.removeAllViewsInLayout();
        update();
        return;
    }

    public final void m(int r2, boolean r3) {
        List<m> r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((m) CollectionsKt.getOrNull(r0, r2)) == null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.a r1 = this.n.w7();
        if (r3 == false) goto L9;
        TabClickType r4 = TabClickType.TYPE_CLICK;
    L10:
        r1.g(r4.getType(), k(r2));
        return;
    L9:
        r4 = TabClickType.TYPE_DRAW;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(HeaderPendantNative r1, int r2, Integer r3) {
    }

    public final void j(int r3, m r4, boolean r5, boolean r6) {
        TabHighLightView r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        View r7 = this.f.getChildAt(r3);
        if (r7 == null) goto L21;
        if (r6 == true) goto L12;
        if (Intrinsics.areEqual(r0.getTag(), r4) == false) goto L12;
        return;
    L12:
        if (r0.getTag() == null) goto L15;
        if (r5 == false) goto L15;
        boolean r8 = true;
    L16:
        r0.setTag(r4);
        View r9 = r0.a;
        if (r9 == null) goto L19;
        r9.removeOnLayoutChangeListener(r0.f);
    L19:
        r7.addOnLayoutChangeListener(r0.f);
        r0.a = r7;
        r0.a(r7, false);
        r0.post(new b(r0, r8, r7));
        return;
    L15:
        r8 = false;
        goto L16
    }
}
