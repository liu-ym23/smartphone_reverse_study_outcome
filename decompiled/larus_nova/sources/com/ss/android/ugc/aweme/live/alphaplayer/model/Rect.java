package com.ss.android.ugc.aweme.live.alphaplayer.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/model/Rect;", "", "Companion", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final class Rect {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Rect f451167f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f451168g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f451169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f451170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f451171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f451172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f451173e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/model/Rect$Companion;", "", "<init>", "()V", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @JvmStatic
        public static Rect a(DataSource.Area r100, boolean r101) {
            float r102 = r100.f451131a;
            if (r101 == true) goto L5;
            float r103 = r100.f451132b;
        L6:
            float r104 = r100.f451133c - r102;
            if (r101 == true) goto L9;
            float r105 = r100.f451134d;
            float r106 = r100.f451132b;
        L11:
            return new Rect(r102, r103, r104, r105 - r106);
        L9:
            r105 = r100.f451132b;
            r106 = r100.f451134d;
            goto L11
        L5:
            r103 = r100.f451134d;
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451174a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f451175b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f451176c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f451177d = null;

        static {
            int[] r100 = new int[Axis.values().length];
            f451174a = r100;
            Axis r101 = Axis.X;
            r100[r101.ordinal()] = 1;
            Axis r102 = Axis.Y;
            r100[r102.ordinal()] = 2;
            Axis r103 = Axis.Longer;
            r100[r103.ordinal()] = 3;
            Axis r104 = Axis.Shorter;
            r100[r104.ordinal()] = 4;
            int[] r105 = new int[Align.values().length];
            f451175b = r105;
            Align r106 = Align.Start;
            r105[r106.ordinal()] = 1;
            Align r110 = Align.End;
            r105[r110.ordinal()] = 2;
            Align r111 = Align.Center;
            r105[r111.ordinal()] = 3;
            int[] r107 = new int[Align.values().length];
            f451176c = r107;
            r107[r106.ordinal()] = 1;
            r107[r110.ordinal()] = 2;
            r107[r111.ordinal()] = 3;
            int[] r108 = new int[Axis.values().length];
            f451177d = r108;
            r108[r101.ordinal()] = 1;
            r108[r102.ordinal()] = 2;
            r108[r103.ordinal()] = 3;
            r108[r104.ordinal()] = 4;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Rect) == false) goto L14;
        Rect r101 = (Rect) r100;
        if (Float.compare(this.f451170b, r101.f451170b) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f451171c, r101.f451171c) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f451172d, r101.f451172d) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f451173e, r101.f451173e) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f451170b) * 31) + Float.floatToIntBits(this.f451171c)) * 31) + Float.floatToIntBits(this.f451172d)) * 31) + Float.floatToIntBits(this.f451173e);
    }

    public final String toString() {
        return "Rect(x=" + this.f451170b + ", y=" + this.f451171c + ", width=" + this.f451172d + ", height=" + this.f451173e + ")";
    }

    static {
        f451168g = new Companion(0);
        f451167f = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final Rect b(Rect r100, Axis r101) {
        int r102 = WhenMappings.f451174a[r101.ordinal()];
        if (r102 != 1) goto L5;
        float r103 = r100.f451172d / this.f451172d;
        return e(r103, r103).a(r100, r101, Align.Start);
    L5:
        if (r102 != 2) goto L7;
        float r104 = r100.f451173e / this.f451173e;
        return e(r104, r104).a(r100, r101, Align.Start);
    L7:
        if (r102 == 3) goto L18;
        if (r102 != 4) goto L16;
        if (r100.f451169a < this.f451169a) goto L13;
        Axis r105 = Axis.X;
    L25:
        return b(r100, r105);
    L13:
        r105 = Axis.Y;
        goto L25
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r100.f451169a >= this.f451169a) goto L20;
        Axis r106 = Axis.X;
    L26:
        return b(r100, r106);
    L20:
        r106 = Axis.Y;
        goto L26
    }

    public final Rect c(float r100, float r101) {
        return new Rect(this.f451170b + r100, this.f451171c + r101, this.f451172d, this.f451173e);
    }

    public final Rect d(float r100, float r101) {
        return new Rect(this.f451170b / r100, this.f451171c / r101, this.f451172d / r100, this.f451173e / r101);
    }

    public final Rect e(float r100, float r101) {
        return new Rect(this.f451170b, this.f451171c, this.f451172d * r100, this.f451173e * r101);
    }

    public final Rect a(Rect r100, Axis r101, Align r102) {
        int r103 = WhenMappings.f451177d[r101.ordinal()];
        if (r103 == 1) goto L29;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L16;
        if (r103 != 4) goto L14;
        if (r100.f451169a < this.f451169a) goto L11;
        Axis r104 = Axis.X;
    L39:
        return a(r100, r104, r102);
    L11:
        r104 = Axis.Y;
        goto L39
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r100.f451169a >= this.f451169a) goto L18;
        Axis r105 = Axis.X;
    L40:
        return a(r100, r105, r102);
    L18:
        r105 = Axis.Y;
        goto L40
    L20:
        int r106 = WhenMappings.f451176c[r102.ordinal()];
        if (r106 == 1) goto L43;
        if (r106 == 2) goto L42;
        if (r106 != 3) goto L26;
        return c(0.0f, ((-this.f451171c) + r100.f451171c) + ((r100.f451173e - this.f451173e) / 2));
    L26:
        throw new NoWhenBranchMatchedException();
    L42:
        return c(0.0f, ((-this.f451171c) + r100.f451171c) + (r100.f451173e - this.f451173e));
    L43:
        return c(0.0f, (-this.f451171c) + r100.f451171c);
    L29:
        int r107 = WhenMappings.f451175b[r102.ordinal()];
        if (r107 == 1) goto L38;
        if (r107 == 2) goto L45;
        if (r107 != 3) goto L35;
        return c(((-this.f451170b) + r100.f451170b) + ((r100.f451172d - this.f451172d) / 2), 0.0f);
    L35:
        throw new NoWhenBranchMatchedException();
    L45:
        return c(((-this.f451170b) + r100.f451170b) + (r100.f451172d - this.f451172d), 0.0f);
    L38:
        return c((-this.f451170b) + r100.f451170b, 0.0f);
    }

    public Rect(float r100, float r101, float r102, float r103) {
        this.f451170b = r100;
        this.f451171c = r101;
        this.f451172d = r102;
        this.f451173e = r103;
        this.f451169a = r102 / r103;
    }
}
