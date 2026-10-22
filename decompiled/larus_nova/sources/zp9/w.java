package zp9;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes31.dex */
@Serializable
public final class w {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f573272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f573276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f573277f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f573278a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f573279b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{g1.f520681a, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f573279b;
        }

        static {
            a r100 = new a();
            f573278a = r100;
            g2 r101 = new g2("com.larus.platform.api.creation.TabTag", r100, 6);
            r101.j("tag_id", true);
            r101.j("tag_name", true);
            r101.j("tag_icon", true);
            r101.j("tag_dark_icon", true);
            r101.j("tag_color", true);
            r101.j("tag_dark_color", true);
            f573279b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f573279b;
            muc.c r101 = r210.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            long r110 = r101.decodeLongElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            String r112 = r105;
            String r113 = r107;
            String r114 = r106;
            long r108 = r110;
            int r109 = 63;
            String r115 = r104;
        L20:
            r101.endStructure(r100);
            return new w(r109, r108, r115, r112, r114, r113, r111);
        L5:
            r112 = null;
            r114 = null;
            long r116 = 0;
            int r117 = 0;
            boolean r118 = true;
            String r119 = null;
            r115 = null;
        L6:
            if (r118 == false) goto L19;
            int r120 = r101.decodeElementIndex(r100);
            switch(r120) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r120);
        L17:
            r116 = r101.decodeLongElement(r100, 0);
            r117 = r117 | 1;
            goto L6
        L18:
            r118 = false;
            goto L6
        L11:
            r117 = r117 | 32;
            r119 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r119);
            goto L6
        L12:
            r117 = r117 | 16;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r102);
            goto L6
        L13:
            r117 = r117 | 8;
            r114 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r114);
            goto L6
        L14:
            r117 = r117 | 4;
            r112 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r112);
            goto L6
        L15:
            r117 = r117 | 2;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r115);
            goto L6
        L19:
            r109 = r117;
            long r121 = r116;
            r113 = r102;
            r111 = r119;
            r108 = r121;
            goto L20
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            w r111 = (w) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f573279b;
            muc.d r102 = r100.beginStructure(r101);
            b r103 = w.Companion;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeLongElement(r101, 0, r111.f573272a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeNullableSerializableElement(r101, 1, v2.f520790a, r111.f573273b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
        L25:
            boolean r107 = true;
        L27:
            if (r107 == false) goto L30;
            r102.encodeNullableSerializableElement(r101, 2, v2.f520790a, r111.f573274c);
        L30:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
        L34:
            boolean r108 = true;
        L36:
            if (r108 == false) goto L39;
            r102.encodeNullableSerializableElement(r101, 3, v2.f520790a, r111.f573275d);
        L39:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
        L43:
            boolean r109 = true;
        L45:
            if (r109 == false) goto L48;
            r102.encodeNullableSerializableElement(r101, 4, v2.f520790a, r111.f573276e);
        L48:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
        L52:
            r104 = true;
        L53:
            if (r104 == false) goto L55;
            r102.encodeNullableSerializableElement(r101, 5, v2.f520790a, r111.f573277f);
        L55:
            r102.endStructure(r101);
            return;
        L51:
            if (r111.f573277f == null) goto L53;
        L42:
            if (r111.f573276e != null) goto L43;
            r109 = false;
            goto L45
        L33:
            if (r111.f573275d != null) goto L34;
            r108 = false;
            goto L36
        L24:
            if (r111.f573274c != null) goto L25;
            r107 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r111.f573273b, "") == false) goto L16;
            r106 = false;
            goto L18
        L6:
            if (r111.f573272a != 0) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<w> serializer() {
            return a.f573278a;
        }
    }

    public w() {
        long r100 = 0;
        this(r100, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f573272a == r101.f573272a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573273b, r101.f573273b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573274c, r101.f573274c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573275d, r101.f573275d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573276e, r101.f573276e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f573277f, r101.f573277f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f573272a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f573273b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f573274c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f573275d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f573276e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f573277f;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        return r114 + r103;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "TabTag(id=" + this.f573272a + ", name=" + this.f573273b + ", iconUrl=" + this.f573274c + ", darkIconUrl=" + this.f573275d + ", tagColor=" + this.f573276e + ", tagDarkColor=" + this.f573277f + ')';
    }

    static {
        Companion = new b();
    }

    public final boolean a() {
        if (this.f573272a != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ w(long r100, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r101 = r100;
        if ((r111 & 2) == 0) goto L8;
        r110 = "";
    L8:
        this(r101, r110, null, null, null, null);
    }

    public w(long r100, String r101, String r102, String r103, String r104, String r105) {
        this.f573272a = r100;
        this.f573273b = r101;
        this.f573274c = r102;
        this.f573275d = r103;
        this.f573276e = r104;
        this.f573277f = r105;
    }

    public w(int r100, long r101, String r102, String r103, String r104, String r105, String r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f573279b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 0;
    L7:
        this.f573272a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f573273b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f573274c = null;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f573275d = null;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f573276e = null;
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f573277f = null;
        return;
    L26:
        this.f573277f = r110;
        return;
    L22:
        this.f573276e = r105;
        goto L24
    L18:
        this.f573275d = r104;
        goto L20
    L14:
        this.f573274c = r103;
        goto L16
    L10:
        this.f573273b = r102;
        goto L12
    }
}
