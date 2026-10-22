package com.obric.oui.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class DependencyNode implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WidgetRun f399754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f399755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f399756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WidgetRun f399757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Type f399758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f399762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f399763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<d> f399764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<DependencyNode> f399765l;

    public static final enum Type extends Enum<Type> {
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type HORIZONTAL_DIMENSION = null;
        public static final Type LEFT = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;
        public static final Type UNKNOWN = null;
        public static final Type VERTICAL_DIMENSION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f399766a = null;

        static {
            Type r100 = new Type("UNKNOWN", 0);
            UNKNOWN = r100;
            Type r101 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r101;
            Type r102 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r102;
            Type r103 = new Type("LEFT", 3);
            LEFT = r103;
            Type r104 = new Type("RIGHT", 4);
            RIGHT = r104;
            Type r105 = new Type("TOP", 5);
            TOP = r105;
            Type r110 = new Type("BOTTOM", 6);
            BOTTOM = r110;
            Type r111 = new Type("BASELINE", 7);
            BASELINE = r111;
            f399766a = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Type[] values() {
            return (Type[]) f399766a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void b() {
        ((ArrayList) this.f399765l).clear();
        ((ArrayList) this.f399764k).clear();
        this.f399763j = false;
        this.f399760g = 0;
        this.f399756c = false;
        this.f399755b = false;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f399757d.f399768b.f399726m0);
        r100.append(":");
        r100.append(this.f399758e);
        r100.append("(");
        if (this.f399763j == false) goto L5;
        Object r101 = Integer.valueOf(this.f399760g);
    L6:
        r100.append(r101);
        r100.append(") <t=");
        r100.append(((ArrayList) this.f399765l).size());
        r100.append(":d=");
        r100.append(((ArrayList) this.f399764k).size());
        r100.append(">");
        return r100.toString();
    L5:
        r101 = "unresolved";
        goto L6
    }

    public DependencyNode(WidgetRun r100) {
        this.f399754a = null;
        this.f399755b = false;
        this.f399756c = false;
        this.f399758e = Type.UNKNOWN;
        this.f399761h = 1;
        this.f399762i = null;
        this.f399763j = false;
        this.f399764k = new ArrayList();
        this.f399765l = new ArrayList();
        this.f399757d = r100;
    }

    public final void a(d r100) {
        ((ArrayList) this.f399764k).add(r100);
        if (this.f399763j == false) goto L6;
        r100.update(r100);
        return;
    }

    public void c(int r100) {
        if (this.f399763j == false) goto L5;
        return;
    L5:
        this.f399763j = true;
        this.f399760g = r100;
        Iterator r101 = ((ArrayList) this.f399764k).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        d r102 = (d) r101.next();
        r102.update(r102);
        goto L7
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r100) {
        Iterator r101 = ((ArrayList) this.f399765l).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (((DependencyNode) r101.next()).f399763j == true) goto L4;
        return;
    L8:
        this.f399756c = true;
        WidgetRun r102 = this.f399754a;
        if (r102 == null) goto L12;
        r102.update(this);
    L12:
        if (this.f399755b == false) goto L15;
        this.f399757d.update(this);
        return;
    L15:
        Iterator r103 = ((ArrayList) this.f399765l).iterator();
        DependencyNode r104 = null;
        int r105 = 0;
    L17:
        if (r103.hasNext() == false) goto L22;
        DependencyNode r106 = (DependencyNode) r103.next();
        if ((r106 instanceof f) == true) goto L17;
        r105 = r105 + 1;
        r104 = r106;
        goto L17
    L22:
        if (r104 == null) goto L33;
        if (r105 != 1) goto L33;
        if (r104.f399763j == false) goto L33;
        f r107 = this.f399762i;
        if (r107 != null) goto L29;
    L32:
        c(r104.f399760g + this.f399759f);
        goto L33
    L29:
        if (r107.f399763j == false) goto L31;
        this.f399759f = this.f399761h * r107.f399760g;
        goto L32
    L31:
        return;
    L33:
        WidgetRun r108 = this.f399754a;
        if (r108 == null) goto L45;
        r108.update(this);
        return;
    }
}
