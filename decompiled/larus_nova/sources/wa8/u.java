package wa8;

import com.larus.platform.model.SlashMentionConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class u {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wa8.b f558890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f558891b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f558892a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f558893b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(wa8.b.a.f558837a), kuc.a.d(p.a.f558881a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f558893b;
        }

        static {
            a r100 = new a();
            f558892a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarImageUploadButton", r100, 2);
            r101.j("basic_info", true);
            r101.j(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, true);
            f558893b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f558893b;
            muc.c r111 = r110.beginStructure(r100);
            p r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            wa8.b r102 = (wa8.b) r111.decodeNullableSerializableElement(r100, 0, wa8.b.a.f558837a, null);
            p r103 = (p) r111.decodeNullableSerializableElement(r100, 1, p.a.f558881a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new u(r104, r102, r103);
        L5:
            wa8.b r105 = null;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r108 = r111.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = (wa8.b) r111.decodeNullableSerializableElement(r100, 0, wa8.b.a.f558837a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (p) r111.decodeNullableSerializableElement(r100, 1, p.a.f558881a, r101);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r108);
        L16:
            r104 = r106;
            r103 = r101;
            r102 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            u r102 = (u) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f558893b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = u.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, wa8.b.a.f558837a, r102.f558890a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, p.a.f558881a, r102.f558891b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f558891b == null) goto L17;
        L6:
            if (r102.f558890a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<u> serializer() {
            return a.f558892a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f558890a, r101.f558890a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558891b, r101.f558891b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        wa8.b r100 = this.f558890a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        p r104 = this.f558891b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarImageUploadButton(basicInfoButton=" + this.f558890a + ", attachment=" + this.f558891b + ')';
    }

    static {
        Companion = new b();
    }

    public u() {
        this.f558890a = null;
        this.f558891b = null;
    }

    public final p a() {
        return this.f558891b;
    }

    public u(int r100, wa8.b r101, p r102) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f558893b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f558890a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f558891b = null;
        return;
    L11:
        this.f558891b = r102;
        return;
    L7:
        this.f558890a = r101;
        goto L9
    }
}
