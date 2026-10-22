package ei3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lei3/a;", "", "", "adRefer", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "adLabel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventName", "c", "", "params", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "groupId", "e", "", "eventType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "timestampKey", ce.f26391f, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472765a = 0;

    @SerializedName("ad_label")
    private final String adLabel;

    @SerializedName("ad_refer")
    private final String adRefer;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private final String eventName;

    @SerializedName("event_type")
    private final Integer eventType;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("timestamp_key")
    private final String timestampKey;

    /* JADX INFO: renamed from: ei3.a$a, reason: collision with other inner class name */
    public static final class C5780a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.adRefer, r101.adRefer) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.adLabel, r101.adLabel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timestampKey, r101.timestampKey) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.adRefer;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.adLabel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.eventName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.params;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.groupId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.eventType;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.timestampKey;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AdLogAction(adRefer=" + this.adRefer + ", adLabel=" + this.adLabel + ", eventName=" + this.eventName + ", params=" + this.params + ", groupId=" + this.groupId + ", eventType=" + this.eventType + ", timestampKey=" + this.timestampKey + ")";
    }

    public final String a() {
        return this.adLabel;
    }

    public final String b() {
        return this.adRefer;
    }

    public final String c() {
        return this.eventName;
    }

    public final Integer d() {
        return this.eventType;
    }

    public final String e() {
        return this.groupId;
    }

    public final Map<String, Object> f() {
        return this.params;
    }

    public final String g() {
        return this.timestampKey;
    }

    public a(String r100, String r101, String r102, Map r103, Integer r104, String r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.adRefer = r100;
        this.adLabel = r101;
        this.eventName = r102;
        this.params = r103;
        this.groupId = null;
        this.eventType = r104;
        this.timestampKey = r105;
    }
}
