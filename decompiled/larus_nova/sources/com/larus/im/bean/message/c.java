package com.larus.im.bean.message;

import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;
import yc9.k1;

/* JADX INFO: loaded from: classes29.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f347103f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<TextTagInfo> f347105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f347106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f347107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f347108e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347109a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347110b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347110b;
        }

        static {
            a r100 = new a();
            f347109a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ThinkingItem", r100, 5);
            r101.j("text", true);
            r101.j("text_tags", true);
            r101.j("position", true);
            r101.j(EventConstant.Key.IS_FINISH, true);
            r101.j("messageId", true);
            f347110b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy<d<Object>>[] r100 = c.f347103f;
            v2 r101 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r100[1].getValue()), kuc.a.d(w0.f520792a), kuc.a.d(i.f520705a), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347110b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<d<Object>>[] r102 = c.f347103f;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            List r106 = (List) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, null);
            Boolean r108 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, null);
            List r110 = r106;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            Integer r212 = r107;
            Boolean r213 = r108;
            String r111 = r105;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new c(r112, r111, r110, r212, r213, r211);
        L5:
            List r113 = null;
            Integer r114 = null;
            Boolean r115 = null;
            String r116 = null;
            int r109 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L24;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 == 0) goto L21;
            if (r118 == 1) goto L19;
            if (r118 == 2) goto L18;
            if (r118 == 3) goto L17;
            if (r118 != 4) goto L16;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r116);
            r109 = r109 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r118);
        L17:
            r115 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, r115);
            r109 = r109 | 8;
            goto L6
        L18:
            r114 = (Integer) r101.decodeNullableSerializableElement(r100, 2, w0.f520792a, r114);
            r109 = r109 | 4;
            goto L6
        L19:
            r113 = (List) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r113);
            r109 = r109 | 2;
            goto L6
        L21:
            r109 = r109 | 1;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            goto L6
        L24:
            r112 = r109;
            r111 = r103;
            r110 = r113;
            r212 = r114;
            r213 = r115;
            r211 = r116;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347110b;
            muc.d r104 = r100.beginStructure(r103);
            c.d(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<c> serializer() {
            return a.f347109a;
        }
    }

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f347104a, r101.f347104a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347105b, r101.f347105b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f347106c, r101.f347106c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f347107d, r101.f347107d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f347104a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<TextTagInfo> r104 = this.f347105b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f347106c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f347107d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ThinkingItem(text=" + this.f347104a + ", textTags=" + this.f347105b + ", position=" + this.f347106c + ", isFinish=" + this.f347107d + ')';
    }

    static {
        Companion = new b();
        f347103f = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new k1()), null, null, null};
    }

    public final String b() {
        String r100 = this.f347104a;
        if (r100 != null) goto L6;
        return null;
    L6:
        com.larus.im.internal.stream.b r101 = com.larus.im.internal.stream.b.f350138a;
        String r102 = this.f347108e;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        Integer r103 = this.f347106c;
        if (r103 == null) goto L12;
        int r104 = r103.intValue();
    L13:
        Integer r105 = r101.d(r102, r104);
        if (r105 == null) goto L24;
        int r106 = r105.intValue();
        if (r106 >= 0) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == true) goto L23;
        return r100;
    L23:
        return r100.substring(0, r106 + 1);
    L18:
        if (r106 >= r100.length()) goto L20;
        r107 = true;
        goto L21
    L24:
        return r100;
    L12:
        r104 = -1;
        goto L13
    }

    public final List<TextTagInfo> c() {
        return this.f347105b;
    }

    @JvmStatic
    public static final /* synthetic */ void d(c r100, muc.d r101, g2 r102) {
        Lazy<d<Object>>[] r103 = f347103f;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L7:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.f347104a);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L16:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.f347105b);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L25:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, w0.f520792a, r100.f347106c);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L34:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, i.f520705a, r100.f347107d);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L43:
        r104 = true;
    L44:
        if (r104 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.f347108e);
        return;
    L47:
        return;
    L42:
        if (Intrinsics.areEqual(r100.f347108e, "") == true) goto L44;
    L33:
        if (r100.f347107d != null) goto L34;
        r108 = false;
        goto L36
    L24:
        if (r100.f347106c != null) goto L25;
        r107 = false;
        goto L27
    L15:
        if (r100.f347105b != null) goto L16;
        r106 = false;
        goto L18
    L6:
        if (r100.f347104a != null) goto L7;
        r105 = false;
        goto L9
    }

    public c(String r100, List<TextTagInfo> r101, Integer r102, Boolean r103) {
        this.f347104a = r100;
        this.f347105b = r101;
        this.f347106c = r102;
        this.f347107d = r103;
        this.f347108e = "";
    }

    public static c a(c r100, String r101, List r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f347104a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f347105b;
    L8:
        Boolean r104 = null;
        if ((r103 & 4) == 0) goto L11;
        Integer r105 = r100.f347106c;
    L13:
        if ((r103 & 8) == 0) goto L16;
        r104 = r100.f347107d;
    L16:
        return new c(r101, r102, r105, r104);
    L11:
        r105 = null;
        goto L13
    }

    public c(int r100, String r101, List r102, Integer r103, Boolean r104, String r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347110b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f347104a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f347105b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f347106c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f347107d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f347108e = "";
        return;
    L23:
        this.f347108e = r105;
        return;
    L19:
        this.f347107d = r104;
        goto L21
    L15:
        this.f347106c = r103;
        goto L17
    L11:
        this.f347105b = r102;
        goto L13
    L7:
        this.f347104a = r101;
        goto L9
    }
}
