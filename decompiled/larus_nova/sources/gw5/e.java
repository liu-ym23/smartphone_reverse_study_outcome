package gw5;

import com.bytedance.flow_audio.api.business.asr.config.FlowAsrMockSamiCoreEventType;
import com.larus.audio.h0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f483044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f483045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowAsrMockSamiCoreEventType f483046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f483047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f483048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f483049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f483050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f483051h;

    public e() {
        this(false, null, null, 0, 0, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f483044a == r101.f483044a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483045b, r101.f483045b) == true) goto L15;
        return false;
    L15:
        if (this.f483046c == r101.f483046c) goto L18;
        return false;
    L18:
        if (this.f483047d == r101.f483047d) goto L21;
        return false;
    L21:
        if (this.f483048e == r101.f483048e) goto L24;
        return false;
    L24:
        if (this.f483049f == r101.f483049f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f483050g, r101.f483050g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f483051h, r101.f483051h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        if (this.f483044a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.f483045b.hashCode()) * 31) + this.f483046c.hashCode()) * 31;
        long r102 = this.f483047d;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f483048e;
        return ((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f483049f) * 31) + this.f483050g.hashCode()) * 31) + this.f483051h.hashCode();
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowAsrMockSamiCoreConfig(enabled=" + this.f483044a + ", getAndUpdateMockCount=" + this.f483045b + ", eventType=" + this.f483046c + ", delayMs=" + this.f483047d + ", asrEndForceDelayMs=" + this.f483048e + ", statusCode=" + this.f483049f + ", statusText=" + this.f483050g + ", errorMessage=" + this.f483051h + ')';
    }

    public e(boolean r100, h0 r101, FlowAsrMockSamiCoreEventType r102, long r103, long r110, int r111) {
        int r104 = 0;
        if ((r111 & 1) == 0) goto L5;
        r100 = false;
    L5:
        Function0<Integer> r105 = r101;
        if ((r111 & 2) == 0) goto L9;
        r105 = new d();
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = FlowAsrMockSamiCoreEventType.NONE;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r110 = 0;
    L18:
        if ((r111 & 32) == 0) goto L20;
        r104 = -1;
    L20:
        String r106 = null;
        if ((r111 & 64) == 0) goto L23;
        String r107 = "mock error";
    L25:
        if ((r111 & 128) == 0) goto L27;
        r106 = "mock error message";
    L27:
        Intrinsics.checkNotNullParameter(r105, "getAndUpdateMockCount");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Intrinsics.checkNotNullParameter(r107, "statusText");
        Intrinsics.checkNotNullParameter(r106, "errorMessage");
        this.f483044a = r100;
        this.f483045b = r105;
        this.f483046c = r102;
        this.f483047d = r103;
        this.f483048e = r110;
        this.f483049f = r104;
        this.f483050g = r107;
        this.f483051h = r106;
        return;
    L23:
        r107 = null;
        goto L25
    }
}
