package dja;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes33.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: dja.a$a, reason: collision with other inner class name */
    public static final class C5678a<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f468965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f468966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f468967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KClass<T> f468968d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final gja.a<T> f468969e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Float f468970f;

        @Override // dja.a
        public final bja.a<T> a() {
            return new bja.a(this.f468965a, this.f468966b, this.f468967c, this.f468969e, this.f468970f, this.f468968d);
        }

        public final int hashCode() {
            String r100 = this.f468965a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            T r104 = this.f468966b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            T r107 = this.f468967c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            KClass<T> r110 = this.f468968d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            gja.a<T> r113 = this.f468969e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Float r116 = this.f468970f;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SpringAnimationCommand(property=" + this.f468965a + ", initialValue=" + this.f468966b + ", targetValue=" + this.f468967c + ", valueClass=" + this.f468968d + ", spec=" + this.f468969e + ", initialVelocity=" + this.f468970f + ")";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C5678a) == false) goto L18;
            C5678a r101 = (C5678a) r100;
            if (Intrinsics.areEqual(this.f468965a, r101.f468965a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f468966b, r101.f468966b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f468967c, r101.f468967c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f468968d, r101.f468968d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f468969e, r101.f468969e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f468970f, r101.f468970f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public C5678a(String r100, T r101, T r102, KClass<T> r103, gja.a<T> r104, Float r105) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "initialValue");
            Intrinsics.checkNotNullParameter(r102, "targetValue");
            Intrinsics.checkNotNullParameter(r103, "valueClass");
            Intrinsics.checkNotNullParameter(r104, "spec");
            this.f468965a = r100;
            this.f468966b = r101;
            this.f468967c = r102;
            this.f468968d = r103;
            this.f468969e = r104;
            this.f468970f = r105;
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f468971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f468972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f468973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KClass<T> f468974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final gja.a<T> f468975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Float f468976f;

        @Override // dja.a
        public final bja.a<T> a() {
            return new bja.a(this.f468971a, this.f468972b, this.f468973c, this.f468975e, this.f468976f, this.f468974d);
        }

        public final int hashCode() {
            String r100 = this.f468971a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            T r104 = this.f468972b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            T r107 = this.f468973c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            KClass<T> r110 = this.f468974d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            gja.a<T> r113 = this.f468975e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Float r116 = this.f468976f;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "TweenAnimationCommand(property=" + this.f468971a + ", initialValue=" + this.f468972b + ", targetValue=" + this.f468973c + ", valueClass=" + this.f468974d + ", spec=" + this.f468975e + ", initialVelocity=" + this.f468976f + ")";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L18;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f468971a, r101.f468971a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f468972b, r101.f468972b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f468973c, r101.f468973c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f468974d, r101.f468974d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f468975e, r101.f468975e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f468976f, r101.f468976f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public b(String r100, T r101, T r102, KClass<T> r103, gja.a<T> r104, Float r105) {
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "initialValue");
            Intrinsics.checkNotNullParameter(r102, "targetValue");
            Intrinsics.checkNotNullParameter(r103, "valueClass");
            Intrinsics.checkNotNullParameter(r104, "spec");
            this.f468971a = r100;
            this.f468972b = r101;
            this.f468973c = r102;
            this.f468974d = r103;
            this.f468975e = r104;
            this.f468976f = r105;
        }
    }

    public a() {
    }

    public abstract bja.a<T> a();
}
