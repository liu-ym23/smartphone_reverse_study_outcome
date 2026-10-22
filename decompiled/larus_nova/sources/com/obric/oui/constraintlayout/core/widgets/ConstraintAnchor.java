package com.obric.oui.constraintlayout.core.widgets;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class ConstraintAnchor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f399689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f399690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f399691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f399692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Type f399693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f399694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SolverVariable f399697i;

    public static final enum Type extends Enum<Type> {
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type CENTER = null;
        public static final Type CENTER_X = null;
        public static final Type CENTER_Y = null;
        public static final Type LEFT = null;
        public static final Type NONE = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f399698a = null;

        static {
            Type r100 = new Type(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Type r101 = new Type("LEFT", 1);
            LEFT = r101;
            Type r102 = new Type("TOP", 2);
            TOP = r102;
            Type r103 = new Type("RIGHT", 3);
            RIGHT = r103;
            Type r104 = new Type("BOTTOM", 4);
            BOTTOM = r104;
            Type r105 = new Type("BASELINE", 5);
            BASELINE = r105;
            Type r110 = new Type("CENTER", 6);
            CENTER = r110;
            Type r111 = new Type("CENTER_X", 7);
            CENTER_X = r111;
            Type r112 = new Type("CENTER_Y", 8);
            CENTER_Y = r112;
            f399698a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static Type[] values() {
            return (Type[]) f399698a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399699a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f399699a = r100;
            r100[Type.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f399699a[Type.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f399699a[Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f399699a[Type.TOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f399699a[Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f399699a[Type.BASELINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f399699a[Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f399699a[Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f399699a[Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public final int d() {
        if (this.f399691c == true) goto L7;
        return 0;
    L7:
        return this.f399690b;
    }

    public final int e() {
        if (this.f399692d.f399722k0 != 8) goto L6;
        return 0;
    L6:
        int r100 = this.f399696h;
        if (r100 == Integer.MIN_VALUE) goto L14;
        ConstraintAnchor r101 = this.f399694f;
        if (r101 == null) goto L14;
        if (r101.f399692d.f399722k0 != 8) goto L14;
        return r100;
    L14:
        return this.f399695g;
    }

    public final ConstraintAnchor f() {
        switch(a.f399699a[this.f399693e.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(this.f399693e.name());
    L7:
        return this.f399692d.M;
    L9:
        return this.f399692d.O;
    L11:
        return this.f399692d.L;
    L13:
        return this.f399692d.N;
    }

    public final boolean g() {
        HashSet<ConstraintAnchor> r100 = this.f399689a;
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<ConstraintAnchor> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().f().h() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean h() {
        if (this.f399694f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j() {
        ConstraintAnchor r100 = this.f399694f;
        if (r100 == null) goto L9;
        HashSet<ConstraintAnchor> r101 = r100.f399689a;
        if (r101 == null) goto L9;
        r101.remove(this);
        if (this.f399694f.f399689a.size() != 0) goto L9;
        this.f399694f.f399689a = null;
    L9:
        this.f399689a = null;
        this.f399694f = null;
        this.f399695g = 0;
        this.f399696h = Integer.MIN_VALUE;
        this.f399691c = false;
        this.f399690b = 0;
    }

    public final void k() {
        SolverVariable r100 = this.f399697i;
        if (r100 != null) goto L5;
        this.f399697i = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        return;
    L5:
        r100.c();
    }

    public final String toString() {
        return this.f399692d.f399726m0 + ":" + this.f399693e.toString();
    }

    public Type getType() {
        return this.f399693e;
    }

    public final boolean i(ConstraintAnchor r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        Type r102 = r100.getType();
        Type r103 = this.f399693e;
        if (r102 != r103) goto L16;
        if (r103 == Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r100.f399692d.G == true) goto L12;
    L13:
        return false;
    L12:
        if (this.f399692d.G == true) goto L14;
    L16:
        switch(a.f399699a[r103.ordinal()]) {
            case 1: goto L58;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(this.f399693e.name());
    L21:
        if (r102 != Type.LEFT) goto L23;
    L26:
        return false;
    L23:
        if (r102 == Type.RIGHT) goto L26;
        return true;
    L28:
        if (r102 != Type.TOP) goto L30;
    L33:
        boolean r104 = true;
    L35:
        if ((r100.f399692d instanceof f) == false) goto L65;
        if (r104 == false) goto L38;
    L39:
        r101 = true;
    L41:
        return r101;
    L38:
        if (r102 != Type.CENTER_Y) goto L41;
    L65:
        return r104;
    L30:
        if (r102 == Type.BOTTOM) goto L33;
        r104 = false;
        goto L35
    L43:
        if (r102 != Type.LEFT) goto L45;
    L48:
        boolean r105 = true;
    L50:
        if ((r100.f399692d instanceof f) == false) goto L66;
        if (r105 == false) goto L53;
    L54:
        r101 = true;
    L56:
        return r101;
    L53:
        if (r102 != Type.CENTER_X) goto L56;
    L66:
        return r105;
    L45:
        if (r102 == Type.RIGHT) goto L48;
        r105 = false;
        goto L50
    L58:
        if (r102 != Type.BASELINE) goto L60;
        return false;
    L60:
        if (r102 != Type.CENTER_X) goto L62;
        return false;
    L62:
        if (r102 == Type.CENTER_Y) goto L69;
        return true;
    L69:
        return false;
    }

    public final void l(int r100) {
        this.f399690b = r100;
        this.f399691c = true;
    }

    public ConstraintAnchor(ConstraintWidget r100, Type r101) {
        this.f399689a = null;
        this.f399695g = 0;
        this.f399696h = Integer.MIN_VALUE;
        this.f399692d = r100;
        this.f399693e = r101;
    }

    public final void a(ConstraintAnchor r100, int r101) {
        b(r100, r101, Integer.MIN_VALUE, false);
    }

    public final void c(int r100, ArrayList<n> r101, n r102) {
        HashSet<ConstraintAnchor> r103 = this.f399689a;
        if (r103 == null) goto L8;
        Iterator<ConstraintAnchor> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r104.next().f399692d, r100, r101, r102);
        goto L6
    L10:
        return;
    }

    public final boolean b(ConstraintAnchor r100, int r101, int r102, boolean r103) {
        if (r100 != null) goto L6;
        j();
        return true;
    L6:
        if (r103 == false) goto L8;
    L11:
        this.f399694f = r100;
        if (r100.f399689a != null) goto L14;
        r100.f399689a = new HashSet();
    L14:
        HashSet<ConstraintAnchor> r104 = this.f399694f.f399689a;
        if (r104 == null) goto L17;
        r104.add(this);
    L17:
        this.f399695g = r101;
        this.f399696h = r102;
        return true;
    L8:
        if (i(r100) == true) goto L11;
        return false;
    }
}
