package com.larus.suggest.impl.wcb.loading;

import com.larus.suggest.impl.wcb.render.n;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f369933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f369934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f369935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f369936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f369937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f369938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f369939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f369940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f369941i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f369942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f369943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f369944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile n.b f369945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f369946n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CompletableDeferred<Unit> f369947o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f369933a == r101.f369933a) goto L12;
        return false;
    L12:
        if (this.f369934b == r101.f369934b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f369935c, r101.f369935c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f369936d, r101.f369936d) == true) goto L21;
        return false;
    L21:
        if (this.f369937e == r101.f369937e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f369938f, r101.f369938f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f369939g, r101.f369939g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f369940h, r101.f369940h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f369941i, r101.f369941i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f369942j, r101.f369942j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f369943k, r101.f369943k) == true) goto L42;
        return false;
    L42:
        if (this.f369944l == r101.f369944l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f369933a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f369934b;
        int r103 = (((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f369935c.hashCode()) * 31) + this.f369936d.hashCode()) * 31) + this.f369937e) * 31;
        String r104 = this.f369938f;
        int r105 = 0;
        if (r104 != null) goto L5;
        int r106 = 0;
    L6:
        int r107 = (((((r103 + r106) * 31) + this.f369939g.hashCode()) * 31) + this.f369940h.hashCode()) * 31;
        String r108 = this.f369941i;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f369942j;
        if (r111 == null) goto L15;
        r105 = r111.hashCode();
    L15:
        return ((((r110 + r105) * 31) + this.f369943k.hashCode()) * 31) + this.f369944l;
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r106 = r104.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbLoadingSession(chatKey=" + this.f369933a + ", executionId=" + this.f369934b + ", conversationId=" + this.f369935c + ", botId=" + this.f369936d + ", expectedScene=" + this.f369937e + ", previousTargetLocalMessageId=" + this.f369938f + ", targetLocalMessageId=" + this.f369939g + ", displayLocalMessageId=" + this.f369940h + ", startMessageBoundaryId=" + this.f369941i + ", sectionId=" + this.f369942j + ", title=" + this.f369943k + ", titleStyle=" + this.f369944l + ')';
    }

    public b(long r100, long r101, String r102, String r103, int r104, String r105, String r110, String r111, String r112, String r113, String r114, int r115) {
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r110, "targetLocalMessageId");
        Intrinsics.checkNotNullParameter(r111, "displayLocalMessageId");
        Intrinsics.checkNotNullParameter(r114, "title");
        this.f369933a = r100;
        this.f369934b = r101;
        this.f369935c = r102;
        this.f369936d = r103;
        this.f369937e = r104;
        this.f369938f = r105;
        this.f369939g = r110;
        this.f369940h = r111;
        this.f369941i = r112;
        this.f369942j = r113;
        this.f369943k = r114;
        this.f369944l = r115;
        this.f369946n = true;
        this.f369947o = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }
}
