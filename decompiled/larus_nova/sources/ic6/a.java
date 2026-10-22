package ic6;

import java.util.Map;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<Object>[] f489173e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f489177d;

    /* JADX INFO: renamed from: ic6.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static final class C6252a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6252a f489178a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ g2 f489179b = null;

        public C6252a() {
        }

        static {
            C6252a r100 = new C6252a();
            f489178a = r100;
            g2 r101 = new g2("com.bytedance.kmp.live.profile.UserProfileEvent", r100, 4);
            r101.j("roomId", true);
            r101.j("userIdStr", true);
            r101.j("clickUserPosition", true);
            r101.j("extraFollowParams", true);
            f489179b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            d<Object>[] r100 = a.f489173e;
            v2 r101 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100[3])};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f489179b;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f489179b;
            c r101 = r210.beginStructure(r100);
            d<Object>[] r102 = a.f489173e;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            Map r110 = (Map) r101.decodeNullableSerializableElement(r100, 3, r102[3], null);
            String r111 = r107;
            String r112 = r106;
            String r113 = r105;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new a(r114, r113, r112, r111, r110);
        L5:
            String r108 = null;
            String r115 = null;
            Map r116 = null;
            int r109 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r108 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r108);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r109 = r109 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (Map) r101.decodeNullableSerializableElement(r100, 3, r102[3], r116);
            r109 = r109 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r114 = r109;
            r113 = r103;
            r112 = r108;
            r111 = r115;
            r110 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a r102 = (a) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f489179b;
            muc.d r104 = r100.beginStructure(r103);
            d<Object>[] r105 = a.f489173e;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f489174a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f489175b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f489176c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 3, r105[3], r102.f489177d);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f489177d == null) goto L35;
        L24:
            if (r102.f489176c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f489175b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f489174a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<a> serializer() {
            return C6252a.f489178a;
        }
    }

    static {
        Companion = new b();
        v2 r100 = v2.f520790a;
        f489173e = new d[]{null, null, null, new a1(r100, kuc.a.d(r100))};
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public a(int r100, @SerialName("roomId") String r101, @SerialName("userIdStr") String r102, @SerialName("clickUserPosition") String r103, Map r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, C6252a.f489179b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f489174a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f489175b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f489176c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f489177d = null;
        return;
    L19:
        this.f489177d = r104;
        return;
    L15:
        this.f489176c = r103;
        goto L17
    L11:
        this.f489175b = r102;
        goto L13
    L7:
        this.f489174a = r101;
        goto L9
    }
}
