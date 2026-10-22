package com.larus.kmp.voice_setting.voice.dialog.v2.api;

import com.larus.im.bean.bot.IconItem;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f353045d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<String>> f353046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IconItem> f353047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f353048c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f353049a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f353050b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f353050b;
        }

        static {
            a r100 = new a();
            f353049a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.dialog.v2.api.VoiceMaterialResponse", r100, 3);
            r101.j("voice_material", true);
            r101.j("voice_icon_list", true);
            r101.j("has_ugc_voice_record", true);
            f353050b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = d.f353045d;
            return new juc.d[]{kuc.a.d(r100[0].getValue()), kuc.a.d(r100[1].getValue()), kuc.a.d(i.f520705a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f353050b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = d.f353045d;
            Map r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            Map r103 = (Map) r111.decodeNullableSerializableElement(r100, 0, r101[0].getValue(), null);
            List r104 = (List) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), null);
            Boolean r105 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, i.f520705a, null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new d(r106, r103, r104, r105);
        L5:
            List r107 = null;
            Boolean r108 = null;
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
            r102 = (Map) r111.decodeNullableSerializableElement(r100, 0, r101[0].getValue(), r102);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (List) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (Boolean) r111.decodeNullableSerializableElement(r100, 2, i.f520705a, r108);
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
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f353050b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = d.f353045d;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f353046a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, r105[1].getValue(), r102.f353047b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, i.f520705a, r102.f353048c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f353048c == null) goto L26;
        L15:
            if (r102.f353047b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f353046a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f353049a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f353046a, r101.f353046a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353047b, r101.f353047b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353048c, r101.f353048c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Map<String, List<String>> r100 = this.f353046a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<IconItem> r104 = this.f353047b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f353048c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceMaterialResponse(voiceMaterial=" + this.f353046a + ", voiceIconList=" + this.f353047b + ", hasUgcVoiceRecord=" + this.f353048c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f353045d = new Lazy[]{LazyKt.lazy(r100, new com.larus.kmp.voice_setting.voice.dialog.v2.api.b()), LazyKt.lazy(r100, new c()), null};
    }

    public d() {
        this.f353046a = null;
        this.f353047b = null;
        this.f353048c = null;
    }

    public d(int r100, Map r101, List r102, Boolean r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f353050b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f353046a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f353047b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f353048c = null;
        return;
    L15:
        this.f353048c = r103;
        return;
    L11:
        this.f353047b = r102;
        goto L13
    L7:
        this.f353046a = r101;
        goto L9
    }
}
