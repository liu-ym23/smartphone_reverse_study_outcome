package lq8;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.bmhome.interactionpanel.InteractionPanelSource;
import com.larus.bmhome.interactionpanel.o;
import com.larus.bmhome.interactionpanel.source.InteractionPanelPayloadTarget;
import com.larus.bmhome.interactionpanel.t;
import com.larus.bmhome.interactionpanel.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f510318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InteractionPanelSource f510319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InteractionPanelPayloadTarget f510320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f510321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f510322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f510323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f510324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f510325h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f510318a, r101.f510318a) == true) goto L12;
        return false;
    L12:
        if (this.f510319b == r101.f510319b) goto L15;
        return false;
    L15:
        if (this.f510320c == r101.f510320c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510321d, r101.f510321d) == true) goto L21;
        return false;
    L21:
        if (this.f510322e == r101.f510322e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f510323f, r101.f510323f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f510324g, r101.f510324g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f510325h, r101.f510325h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f510318a.hashCode() * 31) + this.f510319b.hashCode()) * 31) + this.f510320c.hashCode()) * 31) + this.f510321d.hashCode()) * 31;
        long r101 = this.f510322e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.f510323f;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        c r107 = this.f510324g;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        w r110 = this.f510325h;
        if (r110 == null) goto L15;
        r104 = r110.hashCode();
    L15:
        return r109 + r104;
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionPanelUpsertInput(key=" + this.f510318a + ", source=" + this.f510319b + ", payloadTarget=" + this.f510320c + ", payload=" + this.f510321d + ", updateTimeMs=" + this.f510322e + ", expireAtMs=" + this.f510323f + ", sourceId=" + this.f510324g + ", trackContext=" + this.f510325h + ')';
    }

    public d(o r100, InteractionPanelSource r101, InteractionPanelPayloadTarget r102, t r103, long r104, Long r105, c r110, w r111, int r112) {
        if ((r112 & 32) == 0) goto L6;
        r105 = null;
    L6:
        if ((r112 & 64) == 0) goto L9;
        r110 = null;
    L9:
        if ((r112 & 128) == 0) goto L11;
        r111 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "payloadTarget");
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        this.f510318a = r100;
        this.f510319b = r101;
        this.f510320c = r102;
        this.f510321d = r103;
        this.f510322e = r104;
        this.f510323f = r105;
        this.f510324g = r110;
        this.f510325h = r111;
    }
}
