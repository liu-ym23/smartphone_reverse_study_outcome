package l54;

import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfigBuilder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f507502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f507503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f507504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f507505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f507506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FeedPageConfig f507507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<j54.a> f507508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f507509i;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f507501a, r101.f507501a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f507502b, r101.f507502b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f507503c, r101.f507503c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f507504d, r101.f507504d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f507505e, r101.f507505e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f507506f, r101.f507506f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f507507g, r101.f507507g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(null, null) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f507508h, r101.f507508h) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f507501a.hashCode() * 31;
        JSONObject r101 = this.f507502b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        JSONObject r104 = this.f507503c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f507504d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f507505e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        JSONObject r113 = this.f507506f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L23:
        return ((((((((r112 + r114) * 31) + this.f507507g.hashCode()) * 31) + 0) * 31) + this.f507508h.hashCode()) * 31) + 0;
    L21:
        r114 = r113.hashCode();
        goto L23
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoCardConfig(hostEnterFrom=" + this.f507501a + ", ecEntranceInfo=" + this.f507502b + ", videoEventExtraParams=" + this.f507503c + ", localLifeExtraParams=" + this.f507504d + ", localLifeSchemaParams=" + this.f507505e + ", liveEventExtraParams=" + this.f507506f + ", pageConfig=" + this.f507507g + ", uiConfig=null, hostExtensionInfo=" + this.f507508h + ", searchConfig=null)";
    }

    public a(String r100) {
        FeedPageConfigBuilder.Companion.getClass();
        FeedPageConfig r101 = new FeedPageConfigBuilder().withHostCommonParams(new JSONObject().putOpt("host_enter_from", r100)).withFullscreenButtonAppearDelayMs(100).withCardMode(true).withIgnoreUserPauseOrPlay(false).build();
        List<j54.a> r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "hostEnterFrom");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        Intrinsics.checkNotNullParameter(r102, "hostExtensionInfo");
        this.f507501a = r100;
        this.f507502b = null;
        this.f507503c = null;
        this.f507504d = null;
        this.f507505e = null;
        this.f507506f = null;
        this.f507507g = r101;
        this.f507508h = r102;
        this.f507509i = true;
    }
}
