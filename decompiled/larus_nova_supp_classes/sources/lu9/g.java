package lu9;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J!\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003Jc\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/settings/provider/disk/GeckoCleanConfig;", XmlPullParser.NO_NAMESPACE, "enabled", XmlPullParser.NO_NAMESPACE, "expiredTargetGroups", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "expiredTargetChannels", XmlPullParser.NO_NAMESPACE, "regularExpireDays", XmlPullParser.NO_NAMESPACE, "lowDiskExpireDays", "<init>", "(ZLjava/util/Map;Ljava/util/Map;II)V", "getEnabled", "()Z", "getExpiredTargetGroups", "()Ljava/util/Map;", "getExpiredTargetChannels", "getRegularExpireDays", "()I", "getLowDiskExpireDays", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class g {

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("expired_target_channels")
    private final Map<String, List<String>> expiredTargetChannels;

    @SerializedName("expired_target_groups")
    private final Map<String, String> expiredTargetGroups;

    @SerializedName("low_disk_expire_days")
    private final int lowDiskExpireDays;

    @SerializedName("regular_expire_days")
    private final int regularExpireDays;

    public g() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expiredTargetGroups, r6.expiredTargetGroups) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.expiredTargetChannels, r6.expiredTargetChannels) == true) goto L18;
        return false;
    L18:
        if (this.regularExpireDays == r6.regularExpireDays) goto L21;
        return false;
    L21:
        if (this.lowDiskExpireDays == r6.lowDiskExpireDays) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Map<String, String> r2 = this.expiredTargetGroups;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        Map<String, List<String>> r6 = this.expiredTargetChannels;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return ((((r5 + r3) * 31) + this.regularExpireDays) * 31) + this.lowDiskExpireDays;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "GeckoCleanConfig(enabled=" + this.enabled + ", expiredTargetGroups=" + this.expiredTargetGroups + ", expiredTargetChannels=" + this.expiredTargetChannels + ", regularExpireDays=" + this.regularExpireDays + ", lowDiskExpireDays=" + this.lowDiskExpireDays + ')';
    }

    public final boolean a() {
        return this.enabled;
    }

    public final Map<String, List<String>> b() {
        return this.expiredTargetChannels;
    }

    public final Map<String, String> c() {
        return this.expiredTargetGroups;
    }

    public final int d() {
        return this.lowDiskExpireDays;
    }

    public final int e() {
        return this.regularExpireDays;
    }

    public g(Object r3) {
        Map<String, String> r4 = MapsKt.emptyMap();
        Map<String, List<String>> r0 = MapsKt.emptyMap();
        this.enabled = false;
        this.expiredTargetGroups = r4;
        this.expiredTargetChannels = r0;
        this.regularExpireDays = 1;
        this.lowDiskExpireDays = 1;
    }
}
