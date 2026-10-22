package com.larus.avlink.activeSummary;

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

/* JADX INFO: loaded from: classes24.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f291453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f291454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f291455c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f291456a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f291457b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.f520790a), kuc.a.d(o.a.f291497a), kuc.a.d(w0.f520792a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f291457b;
        }

        static {
            a r100 = new a();
            f291456a = r100;
            g2 r101 = new g2("com.larus.avlink.activeSummary.ProactiveSummaryInfoRequest", r100, 3);
            r101.j("summary_id", true);
            r101.j("push_info", true);
            r101.j("dora_sub_biz", true);
            f291457b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f291457b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            o r103 = (o) r111.decodeNullableSerializableElement(r100, 1, o.a.f291497a, null);
            Integer r104 = (Integer) r111.decodeNullableSerializableElement(r100, 2, w0.f520792a, null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new c(r105, r102, r103, r104);
        L5:
            o r106 = null;
            Integer r107 = null;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r112 = r111.decodeElementIndex(r100);
            if (r112 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r112 != 0) goto L10;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r101);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r106 = (o) r111.decodeNullableSerializableElement(r100, 1, o.a.f291497a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r112 != 2) goto L14;
            r107 = (Integer) r111.decodeNullableSerializableElement(r100, 2, w0.f520792a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r112);
        L18:
            r105 = r108;
            r102 = r101;
            r103 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f291457b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = c.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f291453a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, o.a.f291497a, r102.f291454b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, w0.f520792a, r102.f291455c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (r102.f291455c == null) goto L26;
        L15:
            if (r102.f291454b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f291453a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f291456a;
        }
    }

    public c() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f291453a, r101.f291453a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f291454b, r101.f291454b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291455c, r101.f291455c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f291453a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.f291454b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f291455c;
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
        return "ProactiveSummaryInfoRequest(summaryId=" + this.f291453a + ", pushInfo=" + this.f291454b + ", doraSubBiz=" + this.f291455c + ')';
    }

    static {
        Companion = new b();
    }

    public c(int r100, String r101, o r102, Integer r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f291457b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f291453a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f291454b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f291455c = null;
        return;
    L15:
        this.f291455c = r103;
        return;
    L11:
        this.f291454b = r102;
        goto L13
    L7:
        this.f291453a = r101;
        goto L9
    }

    public c(String r100, o r101, Integer r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f291453a = r100;
        this.f291454b = r101;
        this.f291455c = r102;
    }
}
