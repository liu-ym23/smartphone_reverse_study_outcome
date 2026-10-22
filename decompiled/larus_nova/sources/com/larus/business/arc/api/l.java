package com.larus.business.arc.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes26.dex */
@Serializable
public final class l {
    public static final b Companion = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f319899c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f319900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<y> f319901b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f319902a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f319903b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f319903b;
        }

        static {
            a r100 = new a();
            f319902a = r100;
            g2 r101 = new g2("com.larus.business.arc.api.ArcCallStageSnapshot", r100, 2);
            r101.j("arcDurationMs", false);
            r101.j("stages", false);
            f319903b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{g1.f520681a, l.f319899c[1].getValue()};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f319903b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = l.f319899c;
            List r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            long r103 = r111.decodeLongElement(r100, 0);
            List r104 = (List) r111.decodeSerializableElement(r100, 1, r101[1].getValue(), null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new l(r105, r103, r104);
        L5:
            long r106 = 0;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L16;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r106 = r111.decodeLongElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r102 = (List) r111.decodeSerializableElement(r100, 1, r101[1].getValue(), r102);
            r107 = r107 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r109);
        L16:
            r105 = r107;
            r104 = r102;
            r103 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            l r102 = (l) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f319903b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = l.f319899c;
            r104.encodeLongElement(r103, 0, r102.f319900a);
            r104.encodeSerializableElement(r103, 1, r105[1].getValue(), r102.f319901b);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l> serializer() {
            return a.f319902a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f319900a == r101.f319900a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f319901b, r101.f319901b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f319900a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f319901b.hashCode();
    }

    public final String toString() {
        return "ArcCallStageSnapshot(arcDurationMs=" + this.f319900a + ", stages=" + this.f319901b + ')';
    }

    static {
        Companion = new b();
        f319899c = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new k())};
    }

    public l(long r100, List<y> r110) {
        Intrinsics.checkNotNullParameter(r110, "stages");
        this.f319900a = r100;
        this.f319901b = r110;
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L52;
        if (((ArrayList) r110).size() != ArcStage.values().length) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L50;
        Iterator<T> r103 = r110.iterator();
        Long r111 = null;
        int r112 = 0;
    L14:
        if (r103.hasNext() == false) goto L48;
        Object r104 = r103.next();
        int r105 = r112 + 1;
        if (r112 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        y r106 = (y) r104;
        if (r106.f319929a.ordinal() != r112) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L47;
        if (r106.b() == false) goto L26;
    L29:
        boolean r114 = true;
    L30:
        if (r114 == false) goto L45;
        if (r106.a() == false) goto L43;
        if (r111 != null) goto L35;
    L38:
        boolean r115 = true;
    L39:
        if (r115 == false) goto L42;
        r111 = Long.valueOf(r106.f319931c);
        goto L43
    L42:
        throw new IllegalArgumentException("executed Arc stages must be ordered and non-overlapping".toString());
    L35:
        if (r106.f319930b >= r111.longValue()) goto L38;
        r115 = false;
    L43:
        r112 = r105;
        goto L14
    L45:
        throw new IllegalArgumentException("executed stage offsets must be within arcDurationMs".toString());
    L26:
        if (r106.f319931c <= this.f319900a) goto L29;
        r114 = false;
        goto L30
    L47:
        throw new IllegalArgumentException("stages must be unique and in fixed enum order".toString());
    L21:
        r113 = false;
        goto L22
    L48:
        return;
    L50:
        throw new IllegalArgumentException("stages must contain every fixed Arc stage exactly once".toString());
    L10:
        r102 = false;
        goto L11
    L52:
        throw new IllegalArgumentException("arcDurationMs must be non-negative".toString());
    L5:
        r101 = false;
        goto L6
    }

    public l(int r100, long r110, List r111) {
        Long r101 = null;
        if (3 != (r100 & 3)) goto L55;
        this.f319900a = r110;
        this.f319901b = r111;
        if (r110 < 0) goto L7;
        boolean r112 = true;
    L8:
        if (r112 == false) goto L54;
        if (r111.size() != ArcStage.values().length) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L52;
        Iterator r114 = r111.iterator();
        int r115 = 0;
    L16:
        if (r114.hasNext() == false) goto L50;
        Object r116 = r114.next();
        int r102 = r115 + 1;
        if (r115 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        y r117 = (y) r116;
        if (r117.f319929a.ordinal() != r115) goto L23;
        boolean r118 = true;
    L24:
        if (r118 == false) goto L49;
        if (r117.b() == false) goto L28;
    L31:
        boolean r119 = true;
    L32:
        if (r119 == false) goto L47;
        if (r117.a() == false) goto L45;
        if (r101 != null) goto L37;
    L40:
        boolean r120 = true;
    L41:
        if (r120 == false) goto L44;
        r101 = Long.valueOf(r117.f319931c);
        goto L45
    L44:
        throw new IllegalArgumentException("executed Arc stages must be ordered and non-overlapping".toString());
    L37:
        if (r117.f319930b >= r101.longValue()) goto L40;
        r120 = false;
    L45:
        r115 = r102;
        goto L16
    L47:
        throw new IllegalArgumentException("executed stage offsets must be within arcDurationMs".toString());
    L28:
        if (r117.f319931c <= this.f319900a) goto L31;
        r119 = false;
        goto L32
    L49:
        throw new IllegalArgumentException("stages must be unique and in fixed enum order".toString());
    L23:
        r118 = false;
        goto L24
    L50:
        return;
    L52:
        throw new IllegalArgumentException("stages must contain every fixed Arc stage exactly once".toString());
    L12:
        r113 = false;
        goto L13
    L54:
        throw new IllegalArgumentException("arcDurationMs must be non-negative".toString());
    L7:
        r112 = false;
        goto L8
    L55:
        b2.b(r100, 3, a.f319903b);
        throw null;
    }
}
