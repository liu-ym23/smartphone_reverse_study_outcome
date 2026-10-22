package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003Jb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/platform/model/ReachConfig;", "", "p0PriorityThreshold", "", "reachFeedShowInitEnable", "", "bridgeTopBannerScenes", "", "", "bridgeBottomBannerSources", "legacyTopBannerQueueBusinesses", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getP0PriorityThreshold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReachFeedShowInitEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBridgeTopBannerScenes", "()Ljava/util/List;", "getBridgeBottomBannerSources", "getLegacyTopBannerQueueBusinesses", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/larus/platform/model/ReachConfig;", "equals", "other", "hashCode", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w3 {

    @SerializedName("bridge_bottom_banner_sources")
    private final List<String> bridgeBottomBannerSources;

    @SerializedName("bridge_top_banner_scenes")
    private final List<String> bridgeTopBannerScenes;

    @SerializedName("legacy_top_banner_queue_businesses")
    private final List<String> legacyTopBannerQueueBusinesses;

    @SerializedName("p0_priority_threshold")
    private final Integer p0PriorityThreshold;

    @SerializedName("reach_feed_show_init_enable")
    private final Boolean reachFeedShowInitEnable;

    public static final class a {
    }

    static {
    }

    public w3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w3) == true) goto L8;
        return false;
    L8:
        w3 r101 = (w3) r100;
        if (Intrinsics.areEqual(this.p0PriorityThreshold, r101.p0PriorityThreshold) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reachFeedShowInitEnable, r101.reachFeedShowInitEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bridgeTopBannerScenes, r101.bridgeTopBannerScenes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bridgeBottomBannerSources, r101.bridgeBottomBannerSources) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.legacyTopBannerQueueBusinesses, r101.legacyTopBannerQueueBusinesses) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.p0PriorityThreshold;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.reachFeedShowInitEnable;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.bridgeTopBannerScenes;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.bridgeBottomBannerSources;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.legacyTopBannerQueueBusinesses;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachConfig(p0PriorityThreshold=" + this.p0PriorityThreshold + ", reachFeedShowInitEnable=" + this.reachFeedShowInitEnable + ", bridgeTopBannerScenes=" + this.bridgeTopBannerScenes + ", bridgeBottomBannerSources=" + this.bridgeBottomBannerSources + ", legacyTopBannerQueueBusinesses=" + this.legacyTopBannerQueueBusinesses + ')';
    }

    public final List<String> a() {
        return this.bridgeBottomBannerSources;
    }

    public final List<String> b() {
        return this.bridgeTopBannerScenes;
    }

    public final List<String> c() {
        return this.legacyTopBannerQueueBusinesses;
    }

    public final Integer d() {
        return this.p0PriorityThreshold;
    }

    public final Boolean e() {
        return this.reachFeedShowInitEnable;
    }

    public w3(Object r100) {
        Boolean r101 = Boolean.TRUE;
        List<String> r102 = CollectionsKt.emptyList();
        List<String> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.emptyList();
        this.p0PriorityThreshold = 100;
        this.reachFeedShowInitEnable = r101;
        this.bridgeTopBannerScenes = r102;
        this.bridgeBottomBannerSources = r103;
        this.legacyTopBannerQueueBusinesses = r104;
    }
}
