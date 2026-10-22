package mj4;

import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f514214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f514215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f514216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f514217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f514218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f514219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f514220g;

    public final String toString() {
        return "BudsAbility{protocolVersion=" + this.f514214a + ", maxFrameSize=" + this.f514215b + ", maxTransitUnit=" + this.f514216c + ", interval=" + this.f514217d + ", supportServicesReq=" + Arrays.toString(this.f514218e) + ", supportServicesResp=" + Arrays.toString(this.f514219f) + ", status=" + this.f514220g + '}';
    }

    public a(int r100, int r101, int r102, int r103, byte[] r104, byte[] r105, int r106) {
        this.f514214a = r100;
        this.f514215b = r101;
        this.f514216c = r102;
        this.f514217d = r103;
        this.f514218e = r104;
        this.f514219f = r105;
        this.f514220g = r106;
    }
}
