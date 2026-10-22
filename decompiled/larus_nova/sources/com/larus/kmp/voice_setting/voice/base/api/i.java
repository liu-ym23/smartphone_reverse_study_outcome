package com.larus.kmp.voice_setting.voice.base.api;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class i {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f351777c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f351778a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f351779b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f351779b;
        }

        static {
            a r100 = new a();
            f351778a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.base.api.VoiceListTabInfoCopied", r100, 3);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, true);
            r101.j("tab_key", true);
            r101.j("voice_recommend_type", true);
            f351779b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f351779b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            v2 r101 = v2.f520790a;
            String r102 = (String) r111.decodeNullableSerializableElement(r100, 0, r101, null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, r101, null);
            int r104 = r111.decodeIntElement(r100, 2);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new i(r105, r102, r103, r104);
        L5:
            String r106 = null;
            String r107 = null;
            int r108 = 0;
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
            r106 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r106);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = r111.decodeIntElement(r100, 2);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r104 = r108;
            r105 = r109;
            r102 = r106;
            r103 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            i r102 = (i) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f351779b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = i.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f351775a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f351776b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeIntElement(r103, 2, r102.f351777c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f351777c == 0) goto L26;
        L15:
            if (r102.f351776b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f351775a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<i> serializer() {
            return a.f351778a;
        }
    }

    public i() {
        this(null, null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f351775a, r101.f351775a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351776b, r101.f351776b) == true) goto L15;
        return false;
    L15:
        if (this.f351777c == r101.f351777c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f351775a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f351776b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f351777c;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceListTabInfoCopied(tabName=" + this.f351775a + ", tabKey=" + this.f351776b + ", recommendType=" + this.f351777c + ')';
    }

    static {
        Companion = new b();
    }

    public i(String r100, String r101, int r102) {
        this.f351775a = r100;
        this.f351776b = r101;
        this.f351777c = r102;
    }

    public i(int r100, String r101, String r102, int r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f351779b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f351775a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f351776b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f351777c = 0;
        return;
    L15:
        this.f351777c = r103;
        return;
    L11:
        this.f351776b = r102;
        goto L13
    L7:
        this.f351775a = r101;
        goto L9
    }
}
