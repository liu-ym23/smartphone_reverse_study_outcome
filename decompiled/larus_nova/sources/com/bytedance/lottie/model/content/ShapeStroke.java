package com.bytedance.lottie.model.content;

import android.graphics.Paint;
import com.bytedance.lottie.LottieDrawable;
import java.util.List;
import nz6.q;
import rz6.d;
import sz6.b;

/* JADX INFO: loaded from: classes21.dex */
public final class ShapeStroke implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f264472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rz6.b f264473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<rz6.b> f264474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rz6.a f264475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f264476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rz6.b f264477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LineCapType f264478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LineJoinType f264479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f264480i;

    public static final enum LineCapType extends Enum<LineCapType> {
        public static final LineCapType Butt = null;
        public static final LineCapType Round = null;
        public static final LineCapType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LineCapType[] f264481a = null;

        static {
            LineCapType r100 = new LineCapType("Butt", 0);
            Butt = r100;
            LineCapType r101 = new LineCapType("Round", 1);
            Round = r101;
            LineCapType r102 = new LineCapType("Unknown", 2);
            Unknown = r102;
            f264481a = new LineCapType[]{r100, r101, r102};
        }

        public static LineCapType[] values() {
            return (LineCapType[]) f264481a.clone();
        }

        public Paint.Cap toPaintCap() {
            int r100 = a.f264483a[ordinal()];
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return Paint.Cap.SQUARE;
        L9:
            return Paint.Cap.ROUND;
        L11:
            return Paint.Cap.BUTT;
        }

        public static LineCapType valueOf(String r100) {
            return (LineCapType) r27.a.a(LineCapType.class, r100);
        }

        public LineCapType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LineJoinType extends Enum<LineJoinType> {
        public static final LineJoinType Bevel = null;
        public static final LineJoinType Miter = null;
        public static final LineJoinType Round = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LineJoinType[] f264482a = null;

        static {
            LineJoinType r100 = new LineJoinType("Miter", 0);
            Miter = r100;
            LineJoinType r101 = new LineJoinType("Round", 1);
            Round = r101;
            LineJoinType r102 = new LineJoinType("Bevel", 2);
            Bevel = r102;
            f264482a = new LineJoinType[]{r100, r101, r102};
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) f264482a.clone();
        }

        public Paint.Join toPaintJoin() {
            int r100 = a.f264484b[ordinal()];
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return Paint.Join.ROUND;
        L13:
            return Paint.Join.MITER;
        L15:
            return Paint.Join.BEVEL;
        }

        public static LineJoinType valueOf(String r100) {
            return (LineJoinType) r27.a.a(LineJoinType.class, r100);
        }

        public LineJoinType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f264483a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f264484b = null;

        static {
            int[] r100 = new int[LineJoinType.values().length];
            f264484b = r100;
            r100[LineJoinType.Bevel.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            f264484b[LineJoinType.Miter.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            f264484b[LineJoinType.Round.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[LineCapType.values().length];
            f264483a = r101;
            r101[LineCapType.Butt.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            f264483a[LineCapType.Round.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            f264483a[LineCapType.Unknown.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    @Override // sz6.b
    public final nz6.b a(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101) {
        return new q(r100, r101, this);
    }

    public ShapeStroke(String r100, rz6.b r101, List<rz6.b> r102, rz6.a r103, d r104, rz6.b r105, LineCapType r106, LineJoinType r107, float r108) {
        this.f264472a = r100;
        this.f264473b = r101;
        this.f264474c = r102;
        this.f264475d = r103;
        this.f264476e = r104;
        this.f264477f = r105;
        this.f264478g = r106;
        this.f264479h = r107;
        this.f264480i = r108;
    }
}
