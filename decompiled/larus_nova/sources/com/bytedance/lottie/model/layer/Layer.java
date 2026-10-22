package com.bytedance.lottie.model.layer;

import com.bytedance.lottie.d;
import com.bytedance.lottie.model.content.Mask;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rz6.j;
import rz6.k;
import rz6.l;

/* JADX INFO: loaded from: classes21.dex */
public final class Layer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<sz6.b> f264502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f264503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f264504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f264505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayerType f264506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f264507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f264508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Mask> f264509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f264510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f264511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f264512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f264513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f264514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f264515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f264516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f264517p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j f264518q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k f264519r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final rz6.b f264520s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<xz6.a<Float>> f264521t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MatteType f264522u;

    public static final enum LayerType extends Enum<LayerType> {
        public static final LayerType Image = null;
        public static final LayerType Null = null;
        public static final LayerType PreComp = null;
        public static final LayerType Shape = null;
        public static final LayerType Solid = null;
        public static final LayerType Text = null;
        public static final LayerType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LayerType[] f264523a = null;

        static {
            LayerType r100 = new LayerType("PreComp", 0);
            PreComp = r100;
            LayerType r101 = new LayerType("Solid", 1);
            Solid = r101;
            LayerType r102 = new LayerType("Image", 2);
            Image = r102;
            LayerType r103 = new LayerType("Null", 3);
            Null = r103;
            LayerType r104 = new LayerType("Shape", 4);
            Shape = r104;
            LayerType r105 = new LayerType("Text", 5);
            Text = r105;
            LayerType r110 = new LayerType("Unknown", 6);
            Unknown = r110;
            f264523a = new LayerType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static LayerType[] values() {
            return (LayerType[]) f264523a.clone();
        }

        public static LayerType valueOf(String r100) {
            return (LayerType) r27.a.a(LayerType.class, r100);
        }

        public LayerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MatteType extends Enum<MatteType> {
        public static final MatteType Add = null;
        public static final MatteType Invert = null;
        public static final MatteType None = null;
        public static final MatteType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MatteType[] f264524a = null;

        static {
            MatteType r100 = new MatteType("None", 0);
            None = r100;
            MatteType r101 = new MatteType("Add", 1);
            Add = r101;
            MatteType r102 = new MatteType("Invert", 2);
            Invert = r102;
            MatteType r103 = new MatteType("Unknown", 3);
            Unknown = r103;
            f264524a = new MatteType[]{r100, r101, r102, r103};
        }

        public static MatteType[] values() {
            return (MatteType[]) f264524a.clone();
        }

        public static MatteType valueOf(String r100) {
            return (MatteType) r27.a.a(MatteType.class, r100);
        }

        public MatteType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return a("");
    }

    public final String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(this.f264504c);
        r101.append("\n");
        d r102 = this.f264503b;
        Layer r103 = r102.f264430g.get(this.f264507f);
        if (r103 == null) goto L9;
        r101.append("\t\tParents: ");
        r101.append(r103.f264504c);
        d r104 = this.f264503b;
        Layer r105 = r104.f264430g.get(r103.f264507f);
    L5:
        if (r105 == null) goto L7;
        r101.append("->");
        r101.append(r105.f264504c);
        d r106 = this.f264503b;
        r105 = r106.f264430g.get(r105.f264507f);
        goto L5
    L7:
        r101.append(r100);
        r101.append("\n");
    L9:
        if (this.f264509h.isEmpty() == true) goto L12;
        r101.append(r100);
        r101.append("\tMasks: ");
        r101.append(this.f264509h.size());
        r101.append("\n");
    L12:
        if (this.f264511j == 0) goto L17;
        if (this.f264512k == 0) goto L17;
        r101.append(r100);
        r101.append("\tBackground: ");
        r101.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(this.f264511j), Integer.valueOf(this.f264512k), Integer.valueOf(this.f264513l)}));
    L17:
        if (this.f264502a.isEmpty() == true) goto L23;
        r101.append(r100);
        r101.append("\tShapes:\n");
        Iterator<sz6.b> r107 = this.f264502a.iterator();
    L20:
        if (r107.hasNext() == false) goto L23;
        sz6.b r108 = r107.next();
        r101.append(r100);
        r101.append("\t\t");
        r101.append(r108);
        r101.append("\n");
    L23:
        return r101.toString();
    }

    public Layer(List<sz6.b> r100, d r101, String r102, long r103, LayerType r104, long r110, String r111, List<Mask> r112, l r113, int r114, int r115, int r116, float r117, float r118, int r210, int r211, j r212, k r213, List<xz6.a<Float>> r214, MatteType r215, rz6.b r216) {
        this.f264502a = r100;
        this.f264503b = r101;
        this.f264504c = r102;
        this.f264505d = r103;
        this.f264506e = r104;
        this.f264507f = r110;
        this.f264508g = r111;
        this.f264509h = r112;
        this.f264510i = r113;
        this.f264511j = r114;
        this.f264512k = r115;
        this.f264513l = r116;
        this.f264514m = r117;
        this.f264515n = r118;
        this.f264516o = r210;
        this.f264517p = r211;
        this.f264518q = r212;
        this.f264519r = r213;
        this.f264521t = r214;
        this.f264522u = r215;
        this.f264520s = r216;
    }
}
