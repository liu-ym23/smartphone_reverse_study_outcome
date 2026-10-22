package kh9;

import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
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
public final class q {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f503542c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f503543a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f503544b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{r100, r100, w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f503544b;
        }

        static {
            a r100 = new a();
            f503543a = r100;
            g2 r101 = new g2("com.larus.kmp.voice_setting.voice.request.UgcVoiceMixItemRequest", r100, 3);
            r101.j("voice_id", false);
            r101.j("style_id", false);
            r101.j(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, false);
            f503544b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f503544b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = r111.decodeStringElement(r100, 0);
            String r102 = r111.decodeStringElement(r100, 1);
            int r103 = r111.decodeIntElement(r100, 2);
            int r104 = 7;
        L19:
            r111.endStructure(r100);
            return new q(r104, r101, r102, r103);
        L5:
            r101 = null;
            String r105 = null;
            int r106 = 0;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L18;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r101 = r111.decodeStringElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L11;
            r105 = r111.decodeStringElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r109 != 2) goto L14;
            r106 = r111.decodeIntElement(r100, 2);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r109);
        L18:
            r103 = r106;
            r102 = r105;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            q r102 = (q) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f503544b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f503540a);
            r104.encodeStringElement(r103, 1, r102.f503541b);
            r104.encodeIntElement(r103, 2, r102.f503542c);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<q> serializer() {
            return a.f503543a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f503540a, r101.f503540a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503541b, r101.f503541b) == true) goto L15;
        return false;
    L15:
        if (this.f503542c == r101.f503542c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f503540a.hashCode() * 31) + this.f503541b.hashCode()) * 31) + this.f503542c;
    }

    public final String toString() {
        return "UgcVoiceMixItemRequest(voiceId=" + this.f503540a + ", styleId=" + this.f503541b + ", percentage=" + this.f503542c + ')';
    }

    static {
        Companion = new b();
    }

    public q(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceId");
        Intrinsics.checkNotNullParameter(r101, "styleId");
        this.f503540a = r100;
        this.f503541b = r101;
        this.f503542c = r102;
    }

    public q(int r100, String r101, String r102, int r103) {
        if (7 != (r100 & 7)) goto L6;
        this.f503540a = r101;
        this.f503541b = r102;
        this.f503542c = r103;
        return;
    L6:
        b2.b(r100, 7, a.f503544b);
        throw null;
    }
}
