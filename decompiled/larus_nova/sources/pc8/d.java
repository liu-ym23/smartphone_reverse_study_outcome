package pc8;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BubbleBannerSource f528568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.bmhome.chat.bubble.floating.a f528571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f528572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f528573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f528574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f528575h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f528568a == r101.f528568a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528569b, r101.f528569b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528570c, r101.f528570c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528571d, r101.f528571d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528572e, r101.f528572e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528573f, r101.f528573f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f528574g, r101.f528574g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f528575h, r101.f528575h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528568a.hashCode() * 31) + this.f528569b.hashCode()) * 31;
        String r101 = this.f528570c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f528571d.hashCode()) * 31;
        String r105 = this.f528572e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f528573f.hashCode()) * 31;
        c r108 = this.f528574g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        a r111 = this.f528575h;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerInput(source=" + this.f528568a + ", conversationId=" + this.f528569b + ", bannerSource=" + this.f528570c + ", uiStyle=" + this.f528571d + ", queryMessageId=" + this.f528572e + ", strategy=" + this.f528573f + ", extraInfo=" + this.f528574g + ", clickAction=" + this.f528575h + ')';
    }

    public d(BubbleBannerSource r100, String r101, String r102, com.larus.bmhome.chat.bubble.floating.a r103, String r104, h r105, c r106, a r107) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "uiStyle");
        Intrinsics.checkNotNullParameter(r105, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f528568a = r100;
        this.f528569b = r101;
        this.f528570c = r102;
        this.f528571d = r103;
        this.f528572e = r104;
        this.f528573f = r105;
        this.f528574g = r106;
        this.f528575h = r107;
    }
}
