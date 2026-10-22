package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public abstract class WidgetRun implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f399767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f399768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f399769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f399770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f399771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f399773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DependencyNode f399774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DependencyNode f399775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RunType f399776j;

    public static final enum RunType extends Enum<RunType> {
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RunType[] f399777a = null;

        static {
            RunType r100 = new RunType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            RunType r101 = new RunType(GXAnimation.STATE_START, 1);
            START = r101;
            RunType r102 = new RunType(GXAnimation.STATE_END, 2);
            END = r102;
            RunType r103 = new RunType("CENTER", 3);
            CENTER = r103;
            f399777a = new RunType[]{r100, r101, r102, r103};
        }

        public static RunType[] values() {
            return (RunType[]) f399777a.clone();
        }

        public static RunType valueOf(String r100) {
            return (RunType) r27.a.a(RunType.class, r100);
        }

        public RunType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399778a = null;

        static {
            int[] r100 = new int[ConstraintAnchor.Type.values().length];
            f399778a = r100;
            r100[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f399778a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f399778a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f399778a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f399778a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract boolean j();

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r100) {
    }

    public long i() {
        f r100 = this.f399771e;
        if (r100.f399763j == true) goto L5;
        return 0;
    L5:
        return r100.f399760g;
    }

    public WidgetRun(ConstraintWidget r100) {
        this.f399771e = new f(this);
        this.f399772f = 0;
        this.f399773g = false;
        this.f399774h = new DependencyNode(this);
        this.f399775i = new DependencyNode(this);
        this.f399776j = RunType.NONE;
        this.f399768b = r100;
    }

    public static DependencyNode g(ConstraintAnchor r100) {
        ConstraintAnchor r101 = r100.f399694f;
        if (r101 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r102 = r101.f399692d;
        ConstraintAnchor.Type r103 = r101.f399693e;
        int r104 = a.f399778a[r103.ordinal()];
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L25;
        if (r104 == 3) goto L24;
        if (r104 == 4) goto L23;
        if (r104 == 5) goto L22;
        return null;
    L22:
        return r102.f399709e.f399775i;
    L23:
        return r102.f399709e.f399808k;
    L24:
        return r102.f399709e.f399774h;
    L25:
        return r102.f399707d.f399775i;
    L21:
        return r102.f399707d.f399774h;
    }

    public static DependencyNode h(ConstraintAnchor r100, int r101) {
        ConstraintAnchor r102 = r100.f399694f;
        if (r102 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r103 = r102.f399692d;
        if (r101 != 0) goto L8;
        WidgetRun r104 = r103.f399707d;
    L9:
        ConstraintAnchor.Type r105 = r102.f399693e;
        int r106 = a.f399778a[r105.ordinal()];
        if (r106 == 1) goto L20;
        if (r106 == 2) goto L21;
        if (r106 == 3) goto L20;
        if (r106 == 5) goto L21;
        return null;
    L21:
        return r104.f399775i;
    L20:
        return r104.f399774h;
    L8:
        r104 = r103.f399709e;
        goto L9
    }

    public final int f(int r100, int r101) {
        if (r101 != 0) goto L8;
        ConstraintWidget r102 = this.f399768b;
        int r103 = r102.f399747x;
        int r104 = Math.max(r102.f399745w, r100);
        if (r103 <= 0) goto L6;
        r104 = Math.min(r103, r100);
    L6:
        if (r104 != r100) goto L13;
        return r100;
    L13:
        return r104;
    L8:
        ConstraintWidget r105 = this.f399768b;
        int r106 = r105.A;
        r104 = Math.max(r105.f399749z, r100);
        if (r106 <= 0) goto L11;
        r104 = Math.min(r106, r100);
    L11:
        if (r104 != r100) goto L13;
        return r100;
    }

    public static void a(DependencyNode r100, DependencyNode r101, int r102) {
        ((ArrayList) r100.f399765l).add(r101);
        r100.f399759f = r102;
        ((ArrayList) r101.f399764k).add(r100);
    }

    public final void k(ConstraintAnchor r110, ConstraintAnchor r111, int r112) {
        DependencyNode r100 = g(r110);
        DependencyNode r101 = g(r111);
        if (r100.f399763j == true) goto L5;
        return;
    L5:
        if (r101.f399763j == false) goto L66;
        int r102 = r100.f399760g + r110.e();
        int r113 = r101.f399760g - r111.e();
        int r114 = r113 - r102;
        f r103 = this.f399771e;
        if (r103.f399763j == true) goto L51;
        ConstraintWidget.DimensionBehaviour r104 = this.f399770d;
        ConstraintWidget.DimensionBehaviour r105 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r104 != r105) goto L51;
        int r106 = this.f399767a;
        if (r106 != 0) goto L14;
        r103.c(f(r114, r112));
        goto L51
    L14:
        if (r106 != 1) goto L16;
        this.f399771e.c(Math.min(f(r103.f399802m, r112), r114));
        goto L51
    L16:
        if (r106 != 2) goto L18;
        ConstraintWidget r107 = this.f399768b;
        ConstraintWidget r108 = r107.X;
        if (r108 == null) goto L51;
        if (r112 != 0) goto L42;
        WidgetRun r109 = r108.f399707d;
    L43:
        f r115 = r109.f399771e;
        if (r115.f399763j == false) goto L51;
        if (r112 != 0) goto L47;
        float r116 = r107.f399748y;
    L48:
        r103.c(f((int) ((r115.f399760g * r116) + 0.5f), r112));
        goto L51
    L47:
        r116 = r107.B;
        goto L48
    L42:
        r109 = r108.f399709e;
        goto L43
    L18:
        if (r106 != 3) goto L51;
        ConstraintWidget r117 = this.f399768b;
        WidgetRun r118 = r117.f399707d;
        if (r118.f399770d == r105) goto L23;
    L29:
        if (r112 != 0) goto L31;
        r118 = r117.f399709e;
    L31:
        f r119 = r118.f399771e;
        if (r119.f399763j == false) goto L51;
        float r120 = r117.f399702a0;
        if (r112 != 1) goto L36;
        int r121 = (int) ((r119.f399760g / r120) + 0.5f);
    L37:
        r103.c(r121);
        goto L51
    L36:
        r121 = (int) ((r120 * r119.f399760g) + 0.5f);
        goto L37
    L23:
        if (r118.f399767a != 3) goto L29;
        m r122 = r117.f399709e;
        if (r122.f399770d != r105) goto L29;
        if (r122.f399767a != 3) goto L29;
    L51:
        f r123 = this.f399771e;
        if (r123.f399763j == true) goto L54;
        return;
    L54:
        int r124 = r123.f399760g;
        if (r124 != r114) goto L58;
        this.f399774h.c(r102);
        this.f399775i.c(r113);
        return;
    L58:
        if (r112 != 0) goto L60;
        float r125 = this.f399768b.f399716h0;
    L61:
        if (r100 != r101) goto L63;
        r102 = r100.f399760g;
        r113 = r101.f399760g;
        r125 = 0.5f;
    L63:
        this.f399774h.c((int) ((r102 + 0.5f) + (((r113 - r102) - r124) * r125)));
        this.f399775i.c(this.f399774h.f399760g + this.f399771e.f399760g);
        return;
    L60:
        r125 = this.f399768b.f399718i0;
        goto L61
    }

    public final void b(DependencyNode r100, DependencyNode r101, int r102, f r103) {
        ((ArrayList) r100.f399765l).add(r101);
        List<DependencyNode> r104 = r100.f399765l;
        ArrayList r105 = (ArrayList) r104;
        r105.add(this.f399771e);
        r100.f399761h = r102;
        r100.f399762i = r103;
        ((ArrayList) r101.f399764k).add(r100);
        ((ArrayList) r103.f399764k).add(r100);
    }
}
