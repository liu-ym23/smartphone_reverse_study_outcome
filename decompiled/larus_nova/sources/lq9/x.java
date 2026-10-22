package lq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JZ\u0010\u001c\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallPreloadConfig;", "", "preloadImageList", "", "", "startPreloadTimeMillis", "", "endPreloadTimeMillis", "hostWhiteList", "enableHostWhiteList", "", "<init>", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;)V", "getPreloadImageList", "()Ljava/util/List;", "getStartPreloadTimeMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndPreloadTimeMillis", "getHostWhiteList", "getEnableHostWhiteList", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/platform/model/audio/RealtimeCallPreloadConfig;", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class x {

    @SerializedName("host_white_list_enable")
    private final Boolean enableHostWhiteList;

    @SerializedName("end_time_millis")
    private final Long endPreloadTimeMillis;

    @SerializedName("host_white_list")
    private final List<String> hostWhiteList;

    @SerializedName("preload_image_list")
    private final List<String> preloadImageList;

    @SerializedName("start_time_millis")
    private final Long startPreloadTimeMillis;

    public x() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.preloadImageList, r101.preloadImageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startPreloadTimeMillis, r101.startPreloadTimeMillis) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endPreloadTimeMillis, r101.endPreloadTimeMillis) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostWhiteList, r101.hostWhiteList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enableHostWhiteList, r101.enableHostWhiteList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.preloadImageList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.startPreloadTimeMillis;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.endPreloadTimeMillis;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.hostWhiteList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.enableHostWhiteList;
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
        return "RealtimeCallPreloadConfig(preloadImageList=" + this.preloadImageList + ", startPreloadTimeMillis=" + this.startPreloadTimeMillis + ", endPreloadTimeMillis=" + this.endPreloadTimeMillis + ", hostWhiteList=" + this.hostWhiteList + ", enableHostWhiteList=" + this.enableHostWhiteList + ')';
    }

    public final Boolean a() {
        return this.enableHostWhiteList;
    }

    public final Long b() {
        return this.endPreloadTimeMillis;
    }

    public final List<String> c() {
        return this.hostWhiteList;
    }

    public final List<String> d() {
        return this.preloadImageList;
    }

    public final Long e() {
        return this.startPreloadTimeMillis;
    }

    public x(Object r100) {
        this.preloadImageList = null;
        this.startPreloadTimeMillis = null;
        this.endPreloadTimeMillis = null;
        this.hostWhiteList = null;
        this.enableHostWhiteList = null;
    }
}
