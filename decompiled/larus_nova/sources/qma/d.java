package qma;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f533946a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.f533946a), Float.valueOf(((a) r100).f533946a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f533946a);
        }

        public final String toString() {
            return "DimensionDp(value=" + this.f533946a + ')';
        }

        public a(float r100) {
            this.f533946a = r100;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f533947a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.f533947a), Float.valueOf(((b) r100).f533947a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f533947a);
        }

        public final String toString() {
            return "FloatValue(value=" + this.f533947a + ')';
        }

        public b(float r100) {
            this.f533947a = r100;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f533948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f533949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f533950c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f533948a, r101.f533948a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f533949b, r101.f533949b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f533950c), Float.valueOf(r101.f533950c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f533948a.hashCode() * 31) + this.f533949b.hashCode()) * 31) + Float.floatToIntBits(this.f533950c);
        }

        public final String toString() {
            return "InterpolatedDimension(from=" + this.f533948a + ", to=" + this.f533949b + ", progress=" + this.f533950c + ')';
        }

        public c(d r100, d r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            this.f533948a = r100;
            this.f533949b = r101;
            this.f533950c = r102;
        }
    }

    /* JADX INFO: renamed from: qma.d$d, reason: collision with other inner class name */
    public static final class C7363d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f533951a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7363d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.f533951a), Float.valueOf(((C7363d) r100).f533951a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f533951a);
        }

        public final String toString() {
            return "LayerWidth(extraDp=" + this.f533951a + ')';
        }

        public C7363d() {
            this.f533951a = 0.0f;
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f533952a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.f533952a), Float.valueOf(((e) r100).f533952a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f533952a);
        }

        public final String toString() {
            return "ParentWidth(extraDp=" + this.f533952a + ')';
        }

        public e() {
            this.f533952a = 0.0f;
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f533953a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.f533953a), Float.valueOf(((f) r100).f533953a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f533953a);
        }

        public final String toString() {
            return "TextWidthRatio(ratio=" + this.f533953a + ')';
        }

        public f(float r100) {
            this.f533953a = r100;
        }
    }

    public d() {
    }
}
