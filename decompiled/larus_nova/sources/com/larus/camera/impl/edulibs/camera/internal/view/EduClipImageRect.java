package com.larus.camera.impl.edulibs.camera.internal.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class EduClipImageRect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mx8.a f321637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f321638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f321639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f321640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f321641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f321642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f321643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f321644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bitmap[] f321645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f321646j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipImageRect$Location;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "LEFT", "TOP", "RIGHT", "BOTTOM", "CENTER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Location extends Enum<Location> {
        public static final Location BOTTOM = null;
        public static final Location BOTTOM_LEFT = null;
        public static final Location BOTTOM_RIGHT = null;
        public static final Location CENTER = null;
        public static final a Companion = null;
        public static final Location LEFT = null;
        public static final Location RIGHT = null;
        public static final Location TOP = null;
        public static final Location TOP_LEFT = null;
        public static final Location TOP_RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Location[] f321647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f321648b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Location> getEntries() {
            return f321648b;
        }

        static {
            Location r100 = new Location("TOP_LEFT", 0);
            TOP_LEFT = r100;
            Location r101 = new Location("TOP_RIGHT", 1);
            TOP_RIGHT = r101;
            Location r102 = new Location("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r102;
            Location r103 = new Location("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r103;
            Location r104 = new Location("LEFT", 4);
            LEFT = r104;
            Location r105 = new Location("TOP", 5);
            TOP = r105;
            Location r110 = new Location("RIGHT", 6);
            RIGHT = r110;
            Location r111 = new Location("BOTTOM", 7);
            BOTTOM = r111;
            Location r112 = new Location("CENTER", 8);
            CENTER = r112;
            Location[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
            f321647a = r113;
            f321648b = EnumEntriesKt.enumEntries(r113);
            Companion = new a();
        }

        public static Location[] values() {
            return (Location[]) f321647a.clone();
        }

        public static Location valueOf(String r100) {
            return (Location) r27.a.a(Location.class, r100);
        }

        public Location(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f321649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f321650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f321651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f321652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RectF f321653e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f321654f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final RectF[] f321655g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RectF[] f321656h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Path f321657i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Path f321658j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final RectF f321659k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Matrix[] f321660l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f321661m;

        public final void b(Matrix r100) {
            Intrinsics.checkNotNullParameter(r100, "matrix");
            r100.mapRect(this.f321653e, this.f321652d);
            this.f321654f.set(this.f321653e);
            RectF r101 = this.f321654f;
            float r102 = -this.f321650b;
            r101.inset(r102, r102);
            int r103 = this.f321655g.length;
            int r104 = 0;
            int r105 = 0;
        L4:
            if (r105 >= r103) goto L13;
            if ((r105 % 3) != 0) goto L8;
            float r106 = this.f321654f.left;
        L9:
            if (r105 > 1) goto L11;
            float r107 = this.f321654f.top;
        L12:
            RectF r108 = this.f321655g[r105];
            float r109 = this.f321649a;
            r108.set(r106, r107, r106 + r109, r109 + r107);
            r105 = r105 + 1;
            goto L4
        L11:
            r107 = this.f321654f.bottom - this.f321649a;
            goto L12
        L8:
            r106 = this.f321654f.right - this.f321649a;
            goto L9
        L13:
            int r110 = this.f321656h.length;
        L14:
            if (r104 >= r110) goto L27;
            RectF r111 = this.f321656h[r104];
            r111.set(this.f321653e);
            if (r104 == 0) goto L25;
            if (r104 == 1) goto L24;
            if (r104 != 2) goto L20;
            r111.left = r111.right;
            r111.inset((-this.f321651c) / 2, 0.0f);
        L26:
            r104 = r104 + 1;
            goto L14
        L20:
            if (r104 != 3) goto L26;
            r111.top = r111.bottom;
            r111.inset(0.0f, (-this.f321651c) / 2);
            goto L26
        L24:
            r111.bottom = r111.top;
            r111.inset(0.0f, (-this.f321651c) / 2);
            goto L26
        L25:
            r111.right = r111.left;
            r111.inset((-this.f321651c) / 2, 0.0f);
            goto L26
        }

        public final Location a(float r110, float r111) {
            RectF[] r100 = this.f321655g;
            int r101 = r100.length;
            boolean r102 = false;
            int r103 = 0;
        L3:
            int r104 = -1;
            if (r103 >= r101) goto L9;
            if (r100[r103].contains(r110, r111) == true) goto L10;
            r103 = r103 + 1;
        L10:
            Integer r105 = Integer.valueOf(r103);
            if (r105.intValue() < 0) goto L13;
            boolean r106 = true;
        L14:
            Location r107 = null;
            if (r106 == true) goto L18;
            r105 = null;
        L18:
            if (r105 != null) goto L33;
            RectF[] r108 = this.f321656h;
            int r109 = r108.length;
            int r112 = 0;
        L20:
            if (r112 >= r109) goto L25;
            if (r108[r112].contains(r110, r111) == true) goto L23;
            r112 = r112 + 1;
            goto L20
        L23:
            r104 = r112;
        L25:
            Integer r113 = Integer.valueOf(r104);
            if (r113.intValue() < 0) goto L28;
            r102 = true;
        L28:
            if (r102 == true) goto L31;
            r113 = null;
        L31:
            if (r113 == null) goto L33;
            r105 = Integer.valueOf(r113.intValue() + this.f321655g.length);
        L33:
            if (r105 == null) goto L35;
        L37:
            Location.Companion.getClass();
            if (r105 == null) goto L44;
            Location r114 = (Location) ArraysKt.getOrNull(Location.values(), r105.intValue());
            if (r114 == null) goto L44;
            r107 = r114;
        L44:
            return r107;
        L35:
            if (this.f321653e.contains(r110, r111) == false) goto L37;
            return Location.CENTER;
        L13:
            r106 = false;
            goto L14
        L9:
            r103 = -1;
            goto L10
        }

        public a(float r100, float r101, float r102) {
            this.f321649a = r100;
            this.f321650b = r101;
            this.f321651c = r102;
            this.f321652d = new RectF();
            this.f321653e = new RectF();
            this.f321654f = new RectF();
            RectF[] r103 = new RectF[4];
            int r104 = 0;
            int r105 = 0;
        L3:
            if (r105 >= 4) goto L5;
            r103[r105] = new RectF();
            r105 = r105 + 1;
            goto L3
        L5:
            this.f321655g = r103;
            RectF[] r106 = new RectF[4];
            int r107 = 0;
        L6:
            if (r107 >= 4) goto L8;
            r106[r107] = new RectF();
            r107 = r107 + 1;
            goto L6
        L8:
            this.f321656h = r106;
            this.f321657i = new Path();
            this.f321658j = new Path();
            this.f321659k = new RectF();
            Matrix[] r108 = new Matrix[4];
        L9:
            if (r104 >= 4) goto L11;
            r108[r104] = new Matrix();
            r104 = r104 + 1;
            goto L9
        L11:
            this.f321660l = r108;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f321662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f321663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f321664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f321665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f321666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f321667f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f321668g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f321669h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f321670i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f321671j;

        public b(Bitmap r100, float r101, int r102, int r103, float r104, float r105, float r106, float r107, float r108, int r110) {
            this.f321662a = r100;
            this.f321663b = r101;
            this.f321664c = r102;
            this.f321665d = r103;
            this.f321666e = r104;
            this.f321667f = r105;
            this.f321668g = r106;
            this.f321669h = r107;
            this.f321670i = r108;
            this.f321671j = r110;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Location f321672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f321673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f321674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f321675d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f321676e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f321677f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final RectF f321678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RectF f321679h;

        public c(Location r100, float r101, a r102, RectF r103, float r104, float r105) {
            Intrinsics.checkNotNullParameter(r100, "moveType");
            Intrinsics.checkNotNullParameter(r102, "rectHolder");
            Intrinsics.checkNotNullParameter(r103, "bound");
            this.f321672a = r100;
            this.f321673b = r101;
            this.f321674c = r102;
            this.f321675d = r103;
            this.f321676e = r104;
            this.f321677f = r105;
            this.f321678g = r102.f321653e;
            this.f321679h = new RectF();
        }
    }

    public final void a(Function1<? super a, Unit> r100) {
        if (this.f321644h == false) goto L8;
        Iterator r101 = ((ArrayList) this.f321643g).iterator();
    L6:
        if (r101.hasNext() == false) goto L14;
        r100.invoke((a) r101.next());
        goto L6
    L14:
        return;
    L8:
        a r102 = this.f321642f;
        if (r102 == null) goto L13;
        r100.invoke(r102);
        return;
    }

    public final void c(boolean r110) {
        Matrix r100 = this.f321637a.f516319d;
        Iterator r101 = ((ArrayList) this.f321643g).iterator();
    L4:
        if (r101.hasNext() == false) goto L20;
        a r102 = (a) r101.next();
        r102.b(r100);
        RectF r103 = b(this, r102.f321653e, r110);
        if (Intrinsics.areEqual(r102.f321653e, r103) == true) goto L8;
        r102.f321653e.set(r103);
        Matrix r104 = this.f321637a.f516320e;
        Intrinsics.checkNotNullParameter(r104, "invertMatrix");
        r104.mapRect(r102.f321652d, r102.f321653e);
    L8:
        Matrix r105 = new Matrix();
        r102.f321657i.reset();
        r102.f321658j.reset();
        RectF r106 = new RectF(r102.f321652d);
        r105.reset();
        mx8.a r107 = this.f321637a;
        float r108 = r107.f516325j / 2.0f;
        float r109 = r107.f516326k / 2.0f;
        float r111 = r107.f516317b;
        r105.postScale(r111, r111, r108, r109);
        r105.postTranslate((r107.f516323h / 2.0f) - r108, (r107.f516324i / 2.0f) - r109);
        r105.mapRect(r106);
        Path r112 = r102.f321657i;
        float r113 = this.f321638b.f321663b;
        r112.addRoundRect(r106, r113, r113, Path.Direction.CW);
        float r114 = this.f321638b.f321670i / 2.0f;
        r106.inset(Math.min(r106.width() / 2.0f, r114), Math.min(r106.height() / 2.0f, r114));
        Path r115 = r102.f321658j;
        float r116 = this.f321638b.f321663b;
        r115.addRoundRect(r106, r116, r116, Path.Direction.CW);
        r105.reset();
        mx8.a r117 = this.f321637a;
        r105.postRotate(r117.f516318c, r117.f516323h / 2.0f, r117.f516324i / 2.0f);
        r102.f321657i.transform(r105);
        r102.f321658j.transform(r105);
        Bitmap[] r118 = this.f321645i;
        if (r118 != null) goto L11;
    L17:
        boolean r119 = true;
    L18:
        if (r119 == true) goto L4;
        int r120 = r118[0].getWidth();
        int r121 = this.f321645i[0].getHeight();
        r102.f321659k.set(r102.f321652d);
        r105.reset();
        mx8.a r122 = this.f321637a;
        float r123 = r122.f516325j / 2.0f;
        float r124 = r122.f516326k / 2.0f;
        float r125 = r122.f516317b;
        r105.postScale(r125, r125, r123, r124);
        r105.postTranslate((r122.f516323h / 2.0f) - r123, (r122.f516324i / 2.0f) - r124);
        r105.mapRect(r102.f321659k);
        RectF r126 = r102.f321659k;
        float r127 = -this.f321638b.f321664c;
        r126.inset(r127, r127);
        RectF r128 = r102.f321659k;
        r128.right -= r120;
        r128.bottom -= r121;
        Matrix r129 = r102.f321660l[0];
        r129.reset();
        RectF r130 = r102.f321659k;
        r129.setTranslate(r130.left, r130.top);
        mx8.a r131 = this.f321637a;
        r129.postRotate(r131.f516318c, r131.f516323h / 2.0f, r131.f516324i / 2.0f);
        Matrix r132 = r102.f321660l[1];
        r132.reset();
        RectF r133 = r102.f321659k;
        r132.setTranslate(r133.right, r133.top);
        mx8.a r134 = this.f321637a;
        r132.postRotate(r134.f516318c, r134.f516323h / 2.0f, r134.f516324i / 2.0f);
        Matrix r135 = r102.f321660l[2];
        r135.reset();
        RectF r136 = r102.f321659k;
        r135.setTranslate(r136.right, r136.bottom);
        mx8.a r137 = this.f321637a;
        r135.postRotate(r137.f516318c, r137.f516323h / 2.0f, r137.f516324i / 2.0f);
        Matrix r138 = r102.f321660l[3];
        r138.reset();
        RectF r139 = r102.f321659k;
        r138.setTranslate(r139.left, r139.bottom);
        mx8.a r140 = this.f321637a;
        r138.postRotate(r140.f516318c, r140.f516323h / 2.0f, r140.f516324i / 2.0f);
        goto L4
    L11:
        if (r118.length != 0) goto L13;
        boolean r141 = true;
    L14:
        if (r141 == true) goto L17;
        r119 = false;
        goto L18
    L13:
        r141 = false;
        goto L14
    }

    public EduClipImageRect(mx8.a r110, b r111) {
        Intrinsics.checkNotNullParameter(r110, "drawHelper");
        Intrinsics.checkNotNullParameter(r111, "config");
        this.f321637a = r110;
        this.f321638b = r111;
        Paint r112 = new Paint();
        r112.setAlpha(255);
        this.f321639c = r112;
        Paint r113 = new Paint();
        r113.setStrokeWidth(r111.f321670i);
        r113.setColor(r111.f321671j);
        this.f321640d = r113;
        this.f321641e = r111.f321665d;
        this.f321643g = new ArrayList();
        Matrix r114 = new Matrix();
        Bitmap r115 = r111.f321662a;
        if (r115 == null) goto L10;
        Bitmap[] r100 = new Bitmap[4];
        int r101 = 0;
    L5:
        if (r101 >= 4) goto L11;
        if (r101 != 0) goto L8;
        Bitmap r102 = r115;
    L9:
        r100[r101] = r102;
        r101 = r101 + 1;
        goto L5
    L8:
        r114.postRotate(90.0f);
        r102 = Bitmap.createBitmap(r115, 0, 0, r115.getWidth(), r115.getHeight(), r114, true);
        Intrinsics.checkNotNull(r102);
    L11:
        this.f321645i = r100;
        return;
    L10:
        r100 = null;
        goto L11
    }

    public static RectF b(EduClipImageRect r100, RectF r101, boolean r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "showedRect");
        RectF r103 = new RectF();
        r103.set(r101);
        if (r103.width() >= r100.f321638b.f321669h) goto L6;
        r103.inset((r103.width() - r100.f321638b.f321669h) / 2, 0.0f);
    L6:
        if (r103.height() >= r100.f321638b.f321669h) goto L8;
        r103.inset(0.0f, (r103.height() - r100.f321638b.f321669h) / 2);
    L8:
        if (r102 == false) goto L21;
        RectF r104 = new RectF(r100.f321637a.f516322g);
        float r105 = r100.f321638b.f321664c;
        r104.inset(r105, r105);
        float r106 = r103.left;
        float r107 = r104.left;
        if (r106 >= r107) goto L12;
        r103.left = r107;
    L12:
        float r108 = r103.right;
        float r109 = r104.right;
        if (r108 <= r109) goto L15;
        r103.right = r109;
    L15:
        float r110 = r103.top;
        float r111 = r104.top;
        if (r110 >= r111) goto L18;
        r103.top = r111;
    L18:
        float r112 = r103.bottom;
        float r113 = r104.bottom;
        if (r112 <= r113) goto L21;
        r103.bottom = r113;
    L21:
        return r103;
    }
}
