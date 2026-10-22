package pea;

import android.app.PendingIntent;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.google.gson.JsonObject;
import com.obric.assistant.live.gr.island.island.GRLiveCardType;
import com.obric.assistant.live.gr.island.island.impl.GRIslandImpl;
import com.obric.assistant.live.strategy.GRIslandStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j {
    public final Boolean A;
    public final Integer B;
    public final Boolean C;
    public final Integer D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f528801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f528802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f528803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PendingIntent f528804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nea.a f528805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f528806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f528807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GRLiveCardType f528808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f528809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f528810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final JsonObject f528811k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f528812l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f528813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f528814n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f528815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f528816p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f528817q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Integer f528818r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f528819s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f528820t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f528821u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Integer f528822v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f528823w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f528824x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Integer f528825y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Integer f528826z;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "GRIslandSession(collapseWidget=" + this.f528801a + ", expandWidget=" + this.f528802b + ", smallCollapseWidget=" + this.f528803c + ", intent=" + this.f528804d + ", callback=" + this.f528805e + ", autoDismissDuration=" + this.f528806f + ", taskId=" + this.f528807g + ", type=" + this.f528808h + ", currWidget=" + this.f528809i + ", canFrontShow=" + this.f528810j + ", ext=" + this.f528811k + ", flags=" + this.f528812l + ", sessionContext=" + this.f528813m + ", business=" + this.f528814n + ", enableFloat=" + this.f528815o + ", islandFirstFloat=" + this.f528816p + ", updatable=" + this.f528817q + ", timeout=" + this.f528818r + ", reopen=" + this.f528819s + ", ticker=" + this.f528820t + ", tickerPic=" + this.f528821u + ", tickerPicResId=" + this.f528822v + ", aodTitle=" + this.f528823w + ", aodPic=" + this.f528824x + ", aodPicResId=" + this.f528825y + ", islandProperty=" + this.f528826z + ", islandOrder=" + this.A + ", islandTimeout=" + this.B + ", dismissIsland=" + this.C + ", expandedTime=" + this.D + ')';
    }

    public final boolean a() {
        if ((this.f528812l & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        nea.c.f518909a.a();
        GRIslandImpl r100 = nea.b.f518907c;
        if (r100 == null) goto L6;
        r100.e(this);
        return;
    }

    public final int hashCode() {
        long r100 = this.f528807g;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final GRLiveCardType getType() {
        return this.f528808h;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(j.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.entity.GRIslandSession");
        if (this.f528807g == ((j) r100).f528807g) goto L17;
        return false;
    L17:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void update(k r100) {
        Intrinsics.checkNotNullParameter(r100, "targetWidget");
        nea.c.f518909a.a();
        GRIslandImpl r101 = nea.b.f518907c;
        if (r101 == null) goto L6;
        r101.f(this, r100);
        return;
    }

    public j(k r110, k r111, k r112, PendingIntent r113, GRIslandStrategy.b r114, GRLiveCardType r115, JsonObject r116, long r117, String r210, String r211, String r212) {
        Boolean r100 = Boolean.FALSE;
        Integer r101 = Integer.valueOf(AnnouncementViewModel.HOUR_DURATION);
        Intrinsics.checkNotNullParameter(r110, "collapseWidget");
        Intrinsics.checkNotNullParameter(r112, "smallCollapseWidget");
        Intrinsics.checkNotNullParameter(r210, "business");
        this.f528801a = r110;
        this.f528802b = r111;
        this.f528803c = r112;
        this.f528804d = r113;
        this.f528805e = r114;
        this.f528806f = null;
        this.f528807g = 0;
        this.f528808h = r115;
        this.f528809i = null;
        this.f528810j = r100;
        this.f528811k = r116;
        this.f528812l = r117;
        this.f528813m = null;
        this.f528814n = r210;
        this.f528815o = false;
        this.f528816p = false;
        this.f528817q = true;
        this.f528818r = 720;
        this.f528819s = JSEventListener.ACTION_REOPEN;
        this.f528820t = r211;
        this.f528821u = null;
        this.f528822v = null;
        this.f528823w = r212;
        this.f528824x = null;
        this.f528825y = null;
        this.f528826z = 2;
        this.A = null;
        this.B = r101;
        this.C = r100;
        this.D = 10;
    }
}
