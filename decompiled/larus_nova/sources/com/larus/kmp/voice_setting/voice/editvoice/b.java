package com.larus.kmp.voice_setting.voice.editvoice;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class b {
    public static final C4387b Companion = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f353243e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f353244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f353245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f353247d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f353248a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f353249b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f353249b;
        }

        static {
            a r100 = new a();
            f353248a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.editvoice.MixPreviewCreateRequest", r100, 4);
            r101.j("pitch_f64", false);
            r101.j("speech_rate_f64", false);
            r101.j("bot_language", false);
            r101.j("voice_list", false);
            f353249b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = b.f353243e;
            l0 r101 = l0.f520731a;
            return new juc.d[]{r101, r101, v2.f520790a, r100[3].getValue()};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f353249b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = b.f353243e;
            if (r101.decodeSequentially() == false) goto L5;
            float r103 = r101.decodeFloatElement(r100, 0);
            float r104 = r101.decodeFloatElement(r100, 1);
            String r105 = r101.decodeStringElement(r100, 2);
            List r110 = (List) r101.decodeSerializableElement(r100, 3, r102[3].getValue(), null);
            float r111 = r103;
            String r112 = r105;
            float r113 = r104;
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new b(r114, r111, r113, r112, r110);
        L5:
            float r106 = 0.0f;
            String r115 = null;
            List r116 = null;
            float r107 = 0.0f;
            int r108 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r106 = r101.decodeFloatElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r107 = r101.decodeFloatElement(r100, 1);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = r101.decodeStringElement(r100, 2);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (List) r101.decodeSerializableElement(r100, 3, r102[3].getValue(), r116);
            r108 = r108 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r111 = r106;
            r113 = r107;
            r114 = r108;
            r112 = r115;
            r110 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f353249b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = b.f353243e;
            r104.encodeFloatElement(r103, 0, r102.f353244a);
            r104.encodeFloatElement(r103, 1, r102.f353245b);
            r104.encodeStringElement(r103, 2, r102.f353246c);
            r104.encodeSerializableElement(r103, 3, r105[3].getValue(), r102.f353247d);
            r104.endStructure(r103);
        }
    }

    /* JADX INFO: renamed from: com.larus.kmp.voice_setting.voice.editvoice.b$b, reason: collision with other inner class name */
    public static final class C4387b {
        public C4387b() {
        }

        public final juc.d<b> serializer() {
            return a.f353248a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Float.compare(this.f353244a, r101.f353244a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f353245b, r101.f353245b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353246c, r101.f353246c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353247d, r101.f353247d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f353244a) * 31) + Float.floatToIntBits(this.f353245b)) * 31) + this.f353246c.hashCode()) * 31) + this.f353247d.hashCode();
    }

    public final String toString() {
        return "MixPreviewCreateRequest(pitchF64=" + this.f353244a + ", speechRateF64=" + this.f353245b + ", botLanguage=" + this.f353246c + ", voiceList=" + this.f353247d + ')';
    }

    static {
        Companion = new C4387b();
        f353243e = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new com.larus.kmp.voice_setting.voice.editvoice.a())};
    }

    public b(float r100, float r101, String r102, List<d> r103) {
        Intrinsics.checkNotNullParameter(r102, "botLanguage");
        Intrinsics.checkNotNullParameter(r103, "voiceList");
        this.f353244a = r100;
        this.f353245b = r101;
        this.f353246c = r102;
        this.f353247d = r103;
    }

    public b(int r100, float r101, float r102, String r103, List r104) {
        if (15 != (r100 & 15)) goto L6;
        this.f353244a = r101;
        this.f353245b = r102;
        this.f353246c = r103;
        this.f353247d = r104;
        return;
    L6:
        b2.b(r100, 15, a.f353249b);
        throw null;
    }
}
