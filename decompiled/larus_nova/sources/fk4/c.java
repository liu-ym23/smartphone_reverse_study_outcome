package fk4;

import androidx.collection.SieveCacheKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f477621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f477622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f477623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f477624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f477625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f477626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f477627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f477628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f477629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f477630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f477631n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f477632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f477633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f477634q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f477635r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f477636s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f477637t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f477638u;

    public c(String r100, String r101, String r102, int r110, long r111, long r112, long r113, long r114, long r115, int r210, int r211, int r212, int r213, int r214, int r215, String r216, long r217, String r310) {
        this.f477618a = r100;
        this.f477619b = r101;
        this.f477620c = r102;
        this.f477621d = r110;
        this.f477622e = r111;
        this.f477623f = r112;
        this.f477624g = r113;
        this.f477625h = r114;
        this.f477626i = r115;
        this.f477627j = r210;
        this.f477628k = r211;
        this.f477629l = r212;
        this.f477630m = r213;
        int r103 = 0;
        if (r213 > 0) goto L5;
        int r104 = 0;
    L6:
        this.f477631n = r104;
        this.f477632o = r214;
        this.f477633p = r215;
        if (r215 <= 0) goto L11;
        if (r104 <= 0) goto L11;
        r103 = (int) Math.min(SieveCacheKt.NodeLinkMask, (((long) r215) * KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) / ((long) r104));
    L11:
        this.f477634q = r103;
        this.f477635r = "opus";
        this.f477636s = r216;
        this.f477637t = r217;
        if (r310 != null) goto L14;
        String r105 = "";
    L15:
        this.f477638u = r105;
        return;
    L14:
        r105 = r310;
        goto L15
    L5:
        r104 = r213 / 48;
        goto L6
    }
}
