package y84;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class j {
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final juc.d<Object>[] f566898d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, t84.b> f566900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t84.c f566901c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f566902a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f566903b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f566903b;
        }

        static {
            a r100 = new a();
            f566902a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.yaw.YawConfig", r100, 3);
            r101.j("profile", true);
            r101.j("strategy_threshold", true);
            r101.j("universal_threshold", true);
            f566903b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.f520790a), j.f566898d[1], t84.c.a.f545035a};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f566903b;
            muc.c r111 = r110.beginStructure(r100);
            juc.d<Object>[] r101 = j.f566898d;
            String r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            Map r104 = (Map) r111.decodeSerializableElement(r100, 1, r101[1], null);
            t84.c r105 = (t84.c) r111.decodeSerializableElement(r100, 2, t84.c.a.f545035a, null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new j(r106, r103, r104, r105);
        L5:
            Map r107 = null;
            t84.c r108 = null;
            int r109 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L18;
            int r113 = r111.decodeElementIndex(r100);
            if (r113 != (-1)) goto L9;
            r112 = false;
            goto L6
        L9:
            if (r113 != 0) goto L10;
            r102 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (Map) r111.decodeSerializableElement(r100, 1, r101[1], r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (t84.c) r111.decodeSerializableElement(r100, 2, t84.c.a.f545035a, r108);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r106 = r109;
            r103 = r102;
            r104 = r107;
            r105 = r108;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            j r102 = (j) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f566903b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = j.f566898d;
            int r106 = 0;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f566899a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeSerializableElement(r103, 1, r105[1], r102.f566900b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = 1;
        L26:
            if (r106 == 0) goto L28;
            r104.encodeSerializableElement(r103, 2, t84.c.a.f545035a, r102.f566901c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (Intrinsics.areEqual(r102.f566901c, new t84.c(r106)) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r102.f566900b, MapsKt.emptyMap()) == false) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f566899a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.f566902a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f566899a, r101.f566899a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566900b, r101.f566900b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566901c, r101.f566901c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f566899a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f566900b.hashCode()) * 31) + this.f566901c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    static {
        Companion = new b();
        f566898d = new juc.d[]{null, new a1(v2.f520790a, t84.b.a.f545022a), null};
    }

    public final String toString() {
        return "YawConfig{profile='" + this.f566899a + "', universalThreshold='" + this.f566901c + "', dynamicThreshold='" + this.f566900b + "'}";
    }

    public j() {
        this(null, MapsKt.emptyMap(), new t84.c(0));
    }

    public j(String r100, Map<String, t84.b> r101, t84.c r102) {
        Intrinsics.checkNotNullParameter(r101, "dynamicThreshold");
        Intrinsics.checkNotNullParameter(r102, "universalThreshold");
        this.f566899a = r100;
        this.f566900b = r101;
        this.f566901c = r102;
    }

    public j(int r100, String r101, Map r102, t84.c r103) {
        int r104 = 0;
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f566903b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f566899a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        this.f566900b = r102;
        if ((r100 & 4) != 0) goto L14;
        r103 = new t84.c(r104);
    L14:
        this.f566901c = r103;
        return;
    L7:
        this.f566899a = r101;
        goto L9
    }
}
