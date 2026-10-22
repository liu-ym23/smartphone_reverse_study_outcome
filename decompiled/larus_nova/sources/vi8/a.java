package vi8;

import com.ttnet.org.chromium.base.TimeUtils;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f555347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f555348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f555349c;

    /* JADX INFO: renamed from: vi8.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C8011a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8011a f555350a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f555351b = null;

        public C8011a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            i r100 = i.f520705a;
            return new d[]{g1.f520681a, r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f555351b;
        }

        static {
            C8011a r100 = new C8011a();
            f555350a = r100;
            g2 r101 = new g2("com.larus.bmhome.chat.servicebot.ServiceBotConfig", r100, 3);
            r101.j("timestamp_interval", true);
            r101.j("enable_service_bot", true);
            r101.j("enable_service_bot_on_oversea", true);
            f555351b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f555351b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            long r102 = r101.decodeLongElement(r100, 0);
            boolean r111 = r101.decodeBooleanElement(r100, 1);
            boolean r112 = r101.decodeBooleanElement(r100, 2);
            long r113 = r102;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new a(r114, r113, r111, r112);
        L5:
            long r103 = 0;
            boolean r104 = false;
            boolean r105 = false;
            int r106 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L18;
            int r116 = r101.decodeElementIndex(r100);
            if (r116 != (-1)) goto L9;
            r115 = false;
            goto L6
        L9:
            if (r116 != 0) goto L10;
            r103 = r101.decodeLongElement(r100, 0);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r116 != 1) goto L11;
            r104 = r101.decodeBooleanElement(r100, 1);
            r106 = r106 | 2;
            goto L6
        L11:
            if (r116 != 2) goto L14;
            r105 = r101.decodeBooleanElement(r100, 2);
            r106 = r106 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r116);
        L18:
            r111 = r104;
            r112 = r105;
            r114 = r106;
            r113 = r103;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            a r111 = (a) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f555351b;
            muc.d r102 = r100.beginStructure(r101);
            b r103 = a.Companion;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeLongElement(r101, 0, r111.f555347a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeBooleanElement(r101, 1, r111.f555348b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
        L25:
            r104 = true;
        L26:
            if (r104 == false) goto L28;
            r102.encodeBooleanElement(r101, 2, r111.f555349c);
        L28:
            r102.endStructure(r101);
            return;
        L24:
            if (r111.f555349c == false) goto L26;
        L15:
            if (r111.f555348b == true) goto L16;
            r106 = false;
            goto L18
        L6:
            if (r111.f555347a != TimeUtils.SECONDS_PER_HOUR) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<a> serializer() {
            return C8011a.f555350a;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f555347a == r101.f555347a) goto L12;
        return false;
    L12:
        if (this.f555348b == r101.f555348b) goto L15;
        return false;
    L15:
        if (this.f555349c == r101.f555349c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f555347a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f555348b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        if (this.f555349c == true) goto L11;
        r102 = 1237;
    L11:
        return r104 + r102;
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "ServiceBotConfig(timestampInterval=" + this.f555347a + ", enableServiceBot=" + this.f555348b + ", enableServiceBotOnOversea=" + this.f555349c + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r100) {
        this.f555347a = TimeUtils.SECONDS_PER_HOUR;
        this.f555348b = false;
        this.f555349c = false;
    }

    public a(int r100, long r101, boolean r102, boolean r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, C8011a.f555351b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = TimeUtils.SECONDS_PER_HOUR;
    L7:
        this.f555347a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f555348b = false;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f555349c = false;
        return;
    L14:
        this.f555349c = r103;
        return;
    L10:
        this.f555348b = r102;
        goto L12
    }
}
