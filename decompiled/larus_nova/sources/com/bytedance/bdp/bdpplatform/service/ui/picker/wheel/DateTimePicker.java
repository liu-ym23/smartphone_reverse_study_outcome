package com.bytedance.bdp.bdpplatform.service.ui.picker.wheel;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.tencent.connect.common.Constants;
import ib4.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public class DateTimePicker extends com.bytedance.bdp.bdpplatform.service.ui.picker.wheel.d {
    public final List<WeakReference<WheelView>> G1;
    public final int H0;
    public int L0;
    public int P0;
    public final ArrayList<String> R;
    public final ArrayList<String> S;
    public final ArrayList<String> T;
    public final ArrayList<String> U;
    public final ArrayList<String> V;
    public int V0;
    public int W;
    public int X;
    public int Y;
    public String Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f201425b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int f201426g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f201427h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f201428k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f201429k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int f201430p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f201431p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f201432v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f201433x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final boolean f201434y1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DateMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeMode {
    }

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f201435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WheelView f201436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DateTimePicker f201437c;

        @Override // ib4.g
        public final void a(int r100) {
            DateTimePicker r101 = this.f201437c;
            r101.W = r100;
            String r102 = (String) ListProtector.get(r101.R, r100);
            this.f201437c.getClass();
            DateTimePicker r103 = this.f201437c;
            if (r103.f201434y1 == false) goto L5;
            r103.X = 0;
            r103.Y = 0;
        L5:
            int r104 = com.bytedance.bdp.bdpbase.util.d.b(r102);
            this.f201437c.j(r104);
            WheelView r105 = this.f201435a;
            DateTimePicker r106 = this.f201437c;
            r105.e(r106.S, r106.X);
            this.f201437c.getClass();
            DateTimePicker r107 = this.f201437c;
            r107.h(r104, com.bytedance.bdp.bdpbase.util.d.b((String) ListProtector.get(r107.S, r107.X)));
            WheelView r108 = this.f201436b;
            DateTimePicker r109 = this.f201437c;
            r108.e(r109.T, r109.Y);
            this.f201437c.getClass();
        }

        public a(DateTimePicker r100, WheelView r101, WheelView r102) {
            this.f201437c = r100;
            this.f201435a = r101;
            this.f201436b = r102;
        }
    }

    public class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f201438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DateTimePicker f201439b;

        @Override // ib4.g
        public final void a(int r100) {
            int r101 = this.f201439b.S.size();
            if (r100 < r101) goto L5;
            r100 = r101 - 1;
        L5:
            if (r100 >= 0) goto L7;
            return;
        L7:
            DateTimePicker r102 = this.f201439b;
            r102.X = r100;
            String r103 = (String) ListProtector.get(r102.S, r100);
            this.f201439b.getClass();
            DateTimePicker r104 = this.f201439b;
            int r105 = r104.f201430p0;
            if (r105 == 0) goto L12;
            if (r105 == 2) goto L12;
            return;
        L12:
            if (r104.f201434y1 == false) goto L14;
            r104.Y = 0;
        L14:
            if (r105 != 0) goto L16;
            int r106 = com.bytedance.bdp.bdpbase.util.d.b(r104.l());
        L17:
            this.f201439b.h(r106, com.bytedance.bdp.bdpbase.util.d.b(r103));
            WheelView r107 = this.f201438a;
            DateTimePicker r108 = this.f201439b;
            r107.e(r108.T, r108.Y);
            this.f201439b.getClass();
            return;
        L16:
            r106 = Calendar.getInstance(Locale.getDefault()).get(1);
            goto L17
        }

        public b(DateTimePicker r100, WheelView r101) {
            this.f201439b = r100;
            this.f201438a = r101;
        }
    }

    public class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DateTimePicker f201440a;

        public c(DateTimePicker r100) {
            this.f201440a = r100;
        }

        @Override // ib4.g
        public final void a(int r100) {
            int r101 = this.f201440a.T.size();
            if (r100 < r101) goto L5;
            r100 = r101 - 1;
        L5:
            if (r100 >= 0) goto L7;
            return;
        L7:
            this.f201440a.Y = r100;
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f201441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DateTimePicker f201442b;

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
        @Override // ib4.g
        public final void a(int r100) {
            DateTimePicker r101 = this.f201442b;
            r101.Z = (String) ListProtector.get(r101.U, r100);
            this.f201442b.getClass();
            DateTimePicker r102 = this.f201442b;
            r102.i(com.bytedance.bdp.bdpbase.util.d.b(r102.Z));
            WheelView r103 = this.f201441a;
            DateTimePicker r104 = this.f201442b;
            ArrayList<String> r105 = r104.V;
            String r106 = r104.f201428k0;
            r103.getClass();
            int r107 = r105.indexOf(r106);
            if (r107 != (-1)) goto L5;
            r107 = 0;
        L5:
            r103.e(r105, r107);
        }

        public d(DateTimePicker r100, WheelView r101) {
            this.f201442b = r100;
            this.f201441a = r101;
        }
    }

    public class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DateTimePicker f201443a;

        public e(DateTimePicker r100) {
            this.f201443a = r100;
        }

        @Override // ib4.g
        public final void a(int r100) {
            int r101 = this.f201443a.V.size();
            if (r100 < r101) goto L5;
            r100 = r101 - 1;
        L5:
            if (r100 >= 0) goto L7;
            return;
        L7:
            DateTimePicker r102 = this.f201443a;
            r102.f201428k0 = (String) ListProtector.get(r102.V, r100);
            this.f201443a.getClass();
        }
    }

    @Override // ja4.e
    public final void f() {
    }

    @Override // ja4.e
    public final View e() {
        int r100 = this.f201430p0;
        int r101 = 0;
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L7;
        if (r100 == 5) goto L7;
    L27:
        int r102 = this.f201430p0;
        if (r102 == 0) goto L32;
        if (r102 == 1) goto L31;
    L33:
        int r103 = this.f201430p0;
        if (r103 == 0) goto L38;
        if (r103 == 2) goto L38;
    L45:
        if (this.H0 == (-1)) goto L70;
        if (this.U.size() != 0) goto L70;
        this.U.clear();
        if (this.f201434y1 == false) goto L51;
        int r104 = 0;
    L55:
        int r105 = this.f201429k1;
    L57:
        if (r105 > this.f201432v1) goto L64;
        String r106 = com.bytedance.bdp.bdpbase.util.d.a(r105);
        if (this.f201434y1 == true) goto L62;
        if (r105 != r104) goto L62;
        this.Z = r106;
    L62:
        this.U.add(r106);
        r105 = r105 + 1;
        goto L57
    L64:
        if (this.U.indexOf(this.Z) != (-1)) goto L67;
        this.Z = (String) ListProtector.get(this.U, 0);
    L67:
        if (this.f201434y1 == true) goto L70;
        this.f201428k0 = com.bytedance.bdp.bdpbase.util.d.a(Calendar.getInstance().get(12));
        goto L70
    L51:
        if (this.H0 != 3) goto L53;
        r104 = Calendar.getInstance().get(11);
        goto L55
    L53:
        r104 = Calendar.getInstance().get(10);
    L70:
        if (this.H0 != (-1)) goto L72;
    L74:
        LinearLayout r107 = new LinearLayout(this.f497851a);
        r107.setOrientation(0);
        r107.setGravity(17);
        r107.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        WheelView r108 = g();
        WheelView r109 = g();
        WheelView r110 = g();
        WheelView r111 = g();
        WheelView r112 = g();
        ((ArrayList) this.G1).add(new WeakReference(r108));
        ((ArrayList) this.G1).add(new WeakReference(r109));
        ((ArrayList) this.G1).add(new WeakReference(r110));
        ((ArrayList) this.G1).add(new WeakReference(r111));
        ((ArrayList) this.G1).add(new WeakReference(r112));
        int r113 = this.f201430p0;
        if (r113 == 0) goto L78;
        if (r113 == 1) goto L78;
        if (r113 == 5) goto L78;
    L79:
        int r114 = this.f201430p0;
        if (r114 == 0) goto L82;
        if (r114 == 1) goto L82;
    L84:
        if (this.f201430p0 != 0) goto L87;
        r110.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r110.e(this.T, this.Y);
        r110.setOnItemSelectListener(new c(this));
        r107.addView(r110);
    L87:
        if (this.H0 == (-1)) goto L96;
        r111.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        ArrayList<String> r115 = this.U;
        int r116 = r115.indexOf(this.Z);
        if (r116 != (-1)) goto L91;
        r116 = 0;
    L91:
        r111.e(r115, r116);
        r111.setOnItemSelectListener(new d(this, r112));
        r107.addView(r111);
        r112.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        ArrayList<String> r117 = this.V;
        int r118 = r117.indexOf(this.f201428k0);
        if (r118 == (-1)) goto L95;
        r101 = r118;
    L95:
        r112.e(r117, r101);
        r112.setOnItemSelectListener(new e(this));
        r107.addView(r112);
    L96:
        return r107;
    L82:
        r109.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r109.e(this.S, this.X);
        r109.setOnItemSelectListener(new b(this, r110));
        r107.addView(r109);
    L78:
        r108.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r108.e(this.R, this.W);
        r108.setOnItemSelectListener(new a(this, r109, r110));
        r107.addView(r108);
        goto L79
    L72:
        if (this.V.size() != 0) goto L74;
        i(com.bytedance.bdp.bdpbase.util.d.b(this.Z));
    L38:
        if (this.T.size() != 0) goto L45;
        if (this.f201430p0 != 0) goto L42;
        int r119 = com.bytedance.bdp.bdpbase.util.d.b(l());
    L43:
        h(r119, com.bytedance.bdp.bdpbase.util.d.b(k()));
        goto L45
    L42:
        r119 = Calendar.getInstance(Locale.getDefault()).get(1);
        goto L43
    L31:
        if (this.S.size() != 0) goto L33;
    L32:
        j(com.bytedance.bdp.bdpbase.util.d.b(l()));
    L7:
        if (this.R.size() != 0) goto L27;
        this.R.clear();
        int r120 = this.L0;
        int r121 = this.f201425b1;
        if (r120 != r121) goto L11;
        this.R.add(String.valueOf(r120));
    L19:
        if (this.f201434y1 == true) goto L27;
        int r122 = this.f201430p0;
        if (r122 == 0) goto L23;
        if (r122 != 1) goto L27;
    L23:
        int r123 = this.R.indexOf(com.bytedance.bdp.bdpbase.util.d.a(Calendar.getInstance().get(1)));
        if (r123 != (-1)) goto L26;
        this.W = 0;
        goto L27
    L26:
        this.W = r123;
        goto L27
    L11:
        if (r120 >= r121) goto L16;
    L13:
        if (r120 > this.f201425b1) goto L19;
        this.R.add(String.valueOf(r120));
        r120 = r120 + 1;
    L16:
        if (r120 < this.f201425b1) goto L19;
        this.R.add(String.valueOf(r120));
        r120 = r120 - 1;
        goto L16
    }

    public final String k() {
        if (this.f201430p0 != (-1)) goto L5;
        return "";
    L5:
        if (this.S.size() > this.X) goto L8;
        this.X = this.S.size() - 1;
    L8:
        return (String) ListProtector.get(this.S, this.X);
    }

    public final String l() {
        int r100 = this.f201430p0;
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L11;
        if (r100 == 5) goto L11;
        return "";
    L11:
        if (this.R.size() > this.W) goto L14;
        this.W = this.R.size() - 1;
    L14:
        return (String) ListProtector.get(this.R, this.W);
    }

    public final void i(int r100) {
        this.V.clear();
        int r101 = this.f201429k1;
        int r102 = this.f201432v1;
        if (r101 != r102) goto L12;
        int r103 = this.f201431p1;
        int r104 = this.f201433x1;
        if (r103 <= r104) goto L7;
        this.f201431p1 = r104;
        this.f201433x1 = r103;
    L7:
        int r105 = this.f201431p1;
    L9:
        if (r105 > this.f201433x1) goto L25;
        this.V.add(com.bytedance.bdp.bdpbase.util.d.a(r105));
        r105 = r105 + 1;
    L25:
        if (this.V.indexOf(this.f201428k0) != (-1)) goto L32;
        this.f201428k0 = (String) ListProtector.get(this.V, 0);
        return;
    L32:
        return;
    L12:
        if (r100 != r101) goto L16;
        int r106 = this.f201431p1;
    L14:
        if (r106 > 59) goto L25;
        this.V.add(com.bytedance.bdp.bdpbase.util.d.a(r106));
        r106 = r106 + 1;
        goto L14
    L16:
        if (r100 != r102) goto L21;
        int r107 = 0;
    L19:
        if (r107 > this.f201433x1) goto L25;
        this.V.add(com.bytedance.bdp.bdpbase.util.d.a(r107));
        r107 = r107 + 1;
        goto L19
    L21:
        int r108 = 0;
    L22:
        if (r108 > 59) goto L25;
        this.V.add(com.bytedance.bdp.bdpbase.util.d.a(r108));
        r108 = r108 + 1;
        goto L22
    }

    public final void j(int r100) {
        int r101 = 1;
        if (this.f201434y1 == true) goto L8;
        int r102 = this.S.size();
        int r103 = this.X;
        if (r102 <= r103) goto L7;
        String r104 = (String) ListProtector.get(this.S, r103);
    L9:
        this.S.clear();
        int r105 = this.P0;
        if (r105 < 1) goto L42;
        int r106 = this.f201426g1;
        if (r106 < 1) goto L42;
        if (r105 > 12) goto L42;
        if (r106 > 12) goto L42;
        int r107 = this.L0;
        int r108 = this.f201425b1;
        if (r107 != r108) goto L25;
        if (r105 <= r106) goto L23;
    L20:
        if (r106 < this.P0) goto L35;
        this.S.add(com.bytedance.bdp.bdpbase.util.d.a(r106));
        r106 = r106 - 1;
    L35:
        if (this.f201434y1 == true) goto L48;
        int r109 = this.S.indexOf(r104);
        if (r109 != (-1)) goto L39;
        r109 = 0;
    L39:
        this.X = r109;
        return;
    L48:
        return;
    L23:
        if (r105 > this.f201426g1) goto L35;
        this.S.add(com.bytedance.bdp.bdpbase.util.d.a(r105));
        r105 = r105 + 1;
        goto L23
    L25:
        if (r100 != r107) goto L28;
    L26:
        if (r105 > 12) goto L35;
        this.S.add(com.bytedance.bdp.bdpbase.util.d.a(r105));
        r105 = r105 + 1;
        goto L26
    L28:
        if (r100 == r108) goto L30;
    L32:
        if (r101 > 12) goto L35;
        this.S.add(com.bytedance.bdp.bdpbase.util.d.a(r101));
        r101 = r101 + 1;
    L30:
        if (r101 > this.f201426g1) goto L35;
        this.S.add(com.bytedance.bdp.bdpbase.util.d.a(r101));
        r101 = r101 + 1;
    L42:
        throw new IllegalArgumentException("Month out of range [1-12]");
    L7:
        r104 = com.bytedance.bdp.bdpbase.util.d.a(Calendar.getInstance().get(2) + 1);
        goto L9
    L8:
        r104 = "";
        goto L9
    }

    public DateTimePicker(Activity r100, int r101) {
        super(r100);
        this.R = new ArrayList();
        this.S = new ArrayList();
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = "";
        this.f201428k0 = "";
        this.f201430p0 = 0;
        this.H0 = 3;
        this.L0 = 2010;
        this.P0 = 1;
        this.V0 = 1;
        this.f201425b1 = 2020;
        this.f201426g1 = 12;
        this.f201427h1 = 31;
        this.f201431p1 = 0;
        this.f201433x1 = 59;
        this.f201434y1 = true;
        this.G1 = new ArrayList(5);
        r100.getString(R.string.bdp_year);
        r100.getString(R.string.bdp_month);
        r100.getString(R.string.bdp_day);
        r100.getString(R.string.bdp_hour);
        r100.getString(R.string.bdp_minute);
        if (r101 == (-1)) goto L11;
        this.f201430p0 = -1;
        if (r101 != 4) goto L7;
        this.f201429k1 = 1;
        this.f201432v1 = 12;
    L8:
        this.H0 = r101;
        return;
    L7:
        this.f201429k1 = 0;
        this.f201432v1 = 23;
        goto L8
    L11:
        throw new IllegalArgumentException("The modes are NONE at the same time");
    }

    public final void h(int r100, int r110) {
        int r101 = com.bytedance.bdp.bdpbase.util.d.f201334a;
        String[] r102 = {"1", "3", "5", "7", "8", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "12"};
        String[] r103 = {"4", "6", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "11"};
        List r104 = Arrays.asList(r102);
        List r105 = Arrays.asList(r103);
        if (r104.contains(String.valueOf(r110)) == false) goto L6;
        int r106 = 31;
    L20:
        if (this.f201434y1 == false) goto L22;
        String r107 = "";
    L29:
        this.T.clear();
        int r108 = this.L0;
        if (r100 == r108) goto L32;
    L41:
        if (r100 == r108) goto L43;
    L47:
        int r109 = 1;
        if (r100 != this.f201425b1) goto L54;
        if (r110 != this.f201426g1) goto L54;
    L52:
        if (r109 > this.f201427h1) goto L57;
        this.T.add(com.bytedance.bdp.bdpbase.util.d.a(r109));
        r109 = r109 + 1;
    L57:
        if (this.f201434y1 == true) goto L68;
        int r111 = this.T.indexOf(r107);
        if (r111 != (-1)) goto L61;
        r111 = 0;
    L61:
        this.Y = r111;
        return;
    L68:
        return;
    L54:
        if (r109 > r106) goto L57;
        this.T.add(com.bytedance.bdp.bdpbase.util.d.a(r109));
        r109 = r109 + 1;
        goto L54
    L43:
        if (r110 != this.P0) goto L47;
        int r112 = this.V0;
    L45:
        if (r112 > r106) goto L57;
        this.T.add(com.bytedance.bdp.bdpbase.util.d.a(r112));
        r112 = r112 + 1;
        goto L45
    L32:
        if (r110 != this.P0) goto L41;
        if (r100 != this.f201425b1) goto L41;
        if (r110 != this.f201426g1) goto L41;
        int r113 = this.V0;
    L39:
        if (r113 > this.f201427h1) goto L57;
        this.T.add(com.bytedance.bdp.bdpbase.util.d.a(r113));
        r113 = r113 + 1;
        goto L39
    L22:
        if (this.Y < r106) goto L24;
        this.Y = r106 - 1;
    L24:
        int r114 = this.T.size();
        int r115 = this.Y;
        if (r114 <= r115) goto L27;
        r107 = (String) ListProtector.get(this.T, r115);
        goto L29
    L27:
        r107 = com.bytedance.bdp.bdpbase.util.d.a(Calendar.getInstance().get(5));
        goto L29
    L6:
        if (r105.contains(String.valueOf(r110)) == false) goto L8;
        r106 = 30;
        goto L20
    L8:
        r106 = 29;
        if (r100 <= 0) goto L20;
        if ((r100 % 4) != 0) goto L16;
        if ((r100 % 100) != 0) goto L20;
    L16:
        if ((r100 % 400) == 0) goto L20;
        r106 = 28;
        goto L20
    }
}
