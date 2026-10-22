package com.larus.im.internal.network.chunk.cache;

import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.protocol.bean.UplinkMessageChannel;
import gd9.z;
import java.util.Iterator;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;
import vt7.b;
import zd9.i;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<C4363a> f349088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vt7.a<String, Integer> f349089b = null;

    /* JADX INFO: renamed from: com.larus.im.internal.network.chunk.cache.a$a, reason: collision with other inner class name */
    @Serializable
    public static final class C4363a {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f349090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f349091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f349092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f349093d;

        /* JADX INFO: renamed from: com.larus.im.internal.network.chunk.cache.a$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C4364a implements m0<C4363a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4364a f349094a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f349095b = null;

            public C4364a() {
            }

            @Override // nuc.m0
            public final d<?>[] childSerializers() {
                v2 r100 = v2.f520790a;
                return new d[]{r100, r100, r100, w0.f520792a};
            }

            @Override // juc.d, juc.n, juc.c
            public final f getDescriptor() {
                return f349095b;
            }

            static {
                C4364a r100 = new C4364a();
                f349094a = r100;
                g2 r101 = new g2("com.larus.im.internal.network.chunk.cache.ChunkCache.Task", r100, 4);
                r101.j("messageId", true);
                r101.j("token", true);
                r101.j("cvsId", true);
                r101.j("protocol", true);
                f349095b = r101;
            }

            @Override // nuc.m0
            public final d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f349095b;
                c r101 = r110.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                String r102 = r101.decodeStringElement(r100, 0);
                String r103 = r101.decodeStringElement(r100, 1);
                String r111 = r102;
                String r112 = r101.decodeStringElement(r100, 2);
                String r113 = r103;
                int r114 = r101.decodeIntElement(r100, 3);
                int r115 = 15;
            L21:
                r101.endStructure(r100);
                return new C4363a(r115, r111, r113, r112, r114);
            L5:
                String r104 = null;
                String r105 = null;
                String r106 = null;
                int r107 = 0;
                int r116 = 0;
                boolean r117 = true;
            L6:
                if (r117 == false) goto L20;
                int r118 = r101.decodeElementIndex(r100);
                if (r118 != (-1)) goto L9;
                r117 = false;
                goto L6
            L9:
                if (r118 != 0) goto L10;
                r104 = r101.decodeStringElement(r100, 0);
                r116 = r116 | 1;
                goto L6
            L10:
                if (r118 != 1) goto L11;
                r106 = r101.decodeStringElement(r100, 1);
                r116 = r116 | 2;
                goto L6
            L11:
                if (r118 != 2) goto L12;
                r105 = r101.decodeStringElement(r100, 2);
                r116 = r116 | 4;
                goto L6
            L12:
                if (r118 != 3) goto L15;
                r107 = r101.decodeIntElement(r100, 3);
                r116 = r116 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r118);
            L20:
                r111 = r104;
                r112 = r105;
                r113 = r106;
                r114 = r107;
                r115 = r116;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                C4363a r102 = (C4363a) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f349095b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = C4363a.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeStringElement(r103, 0, r102.f349090a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeStringElement(r103, 1, r102.f349091b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeStringElement(r103, 2, r102.f349092c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                r106 = true;
            L35:
                if (r106 == false) goto L37;
                r104.encodeIntElement(r103, 3, r102.f349093d);
            L37:
                r104.endStructure(r103);
                return;
            L33:
                if (r102.f349093d == UplinkMessageChannel.DEFAULT.value) goto L35;
            L24:
                if (Intrinsics.areEqual(r102.f349092c, "") == false) goto L25;
                r109 = false;
                goto L27
            L15:
                if (Intrinsics.areEqual(r102.f349091b, "") == false) goto L16;
                r108 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r102.f349090a, "") == false) goto L7;
                r107 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.im.internal.network.chunk.cache.a$a$b */
        public static final class b {
            public b() {
            }

            public final d<C4363a> serializer() {
                return C4364a.f349094a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4363a) == true) goto L8;
            return false;
        L8:
            C4363a r101 = (C4363a) r100;
            if (Intrinsics.areEqual(this.f349090a, r101.f349090a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349091b, r101.f349091b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349092c, r101.f349092c) == true) goto L18;
            return false;
        L18:
            if (this.f349093d == r101.f349093d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f349090a.hashCode() * 31) + this.f349091b.hashCode()) * 31) + this.f349092c.hashCode()) * 31) + this.f349093d;
        }

        public final String toString() {
            return "Task(messageId=" + this.f349090a + ", token=" + this.f349091b + ", cvsId=" + this.f349092c + ", protocol=" + this.f349093d + ')';
        }

        static {
            Companion = new b();
        }

        public C4363a() {
            this("", "", "", UplinkMessageChannel.DEFAULT.value);
        }

        public C4363a(String r100, String r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r102, "cvsId");
            this.f349090a = r100;
            this.f349091b = r101;
            this.f349092c = r102;
            this.f349093d = r103;
        }

        public C4363a(int r100, String r101, String r102, String r103, int r104) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, C4364a.f349095b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f349090a = "";
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f349091b = "";
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f349092c = "";
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f349093d = UplinkMessageChannel.DEFAULT.value;
            return;
        L19:
            this.f349093d = r104;
            return;
        L15:
            this.f349092c = r103;
            goto L17
        L11:
            this.f349091b = r102;
            goto L13
        L7:
            this.f349090a = r101;
            goto L9
        }
    }

    static {
        b<C4363a> r100 = new b();
        c1 r101 = c1.f348202a;
        List r102 = i.b(z.a.b("chunk_task", ""), C4363a.Companion.serializer());
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        r100.addAll(r102);
        f349088a = r100;
        f349089b = new vt7.a();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        vt7.a<String, Integer> r101 = f349089b;
        Integer r102 = r101.get(r100);
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.put(r100, Integer.valueOf(r103 + 1));
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public static int b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L10;
        return Integer.MIN_VALUE;
    L10:
        return c1.f348202a.f(r100.concat("-seq"), Integer.MIN_VALUE, "");
    L5:
        r101 = false;
        goto L7
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        vt7.a<String, Integer> r101 = f349089b;
        Integer r102 = r101.get(r100);
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.put(r100, Integer.valueOf(r103 - 1));
        return;
    L5:
        r103 = 1;
        goto L6
    }

    public static void e(C4363a r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        b<C4363a> r101 = f349088a;
        if (r101.contains(r100) == true) goto L5;
        return;
    L5:
        r101.remove(r100);
        d(r100.f349092c);
        c1 r102 = c1.f348202a;
        z.a.c("chunk_task", com.larus.im.internal.core.message.converter.a.a(CollectionsKt.toList(r101), kuc.a.b(C4363a.Companion.serializer())));
    }

    public static String c(String r100, UplinkMessageChannel r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "protocol");
        Iterator<C4363a> r102 = f349088a.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        C4363a r103 = r102.next();
        C4363a r104 = r103;
        if (Intrinsics.areEqual(r104.f349090a, r100) == true) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L4;
    L14:
        C4363a r106 = r103;
        if (r106 != null) goto L17;
        return null;
    L17:
        return r106.f349091b;
    L8:
        if (r104.f349093d != r101.value) goto L10;
        r105 = true;
        goto L11
    L13:
        r103 = null;
        goto L14
    }

    public static void f(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        c1 r103 = c1.f348202a;
        String r104 = r100.concat("-seq");
        c1.f348202a.j(r104, r101, "");
        return;
    L5:
        r102 = false;
        goto L6
    }
}
