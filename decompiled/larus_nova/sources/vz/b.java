package vz;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010\u0011R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018¨\u0006-"}, d2 = {"Lvz/b;", "", "", "policyId", "Ljava/lang/String;", "getPolicyId", "()Ljava/lang/String;", "policyName", "getPolicyName", "owner", "getOwner", "description", "getDescription", "", "liveRoomStatePolicyPriority", "Ljava/lang/Integer;", "getLiveRoomStatePolicyPriority", "()Ljava/lang/Integer;", "category", "getCategory", "", "event", "Ljava/util/Set;", "getEvent", "()Ljava/util/Set;", "intent", "getIntent", "source", "getSource", "", "conditions", "Ljava/util/Map;", "getConditions", "()Ljava/util/Map;", "", "permission", "Ljava/lang/Boolean;", "getPermission", "()Ljava/lang/Boolean;", "reason", "getReason", "affectedStrategy", "getAffectedStrategy", "affectedResources", "getAffectedResources", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("affectedResources")
    private final Set<Integer> affectedResources;

    @SerializedName("affectedStrategy")
    private final Integer affectedStrategy;

    @SerializedName("category")
    private final String category;

    @SerializedName("conditions")
    private final Map<String, String> conditions;

    @SerializedName("description")
    private final String description;

    @SerializedName("event")
    private final Set<Integer> event;

    @SerializedName("intent")
    private final Integer intent;

    @SerializedName("liveRoomStatePolicyPriority")
    private final Integer liveRoomStatePolicyPriority;

    @SerializedName("owner")
    private final String owner;

    @SerializedName("permission")
    private final Boolean permission;

    @SerializedName("policyId")
    private final String policyId;

    @SerializedName("policyName")
    private final String policyName;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("source")
    private final String source;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L34;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.policyId, r101.policyId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.policyName, r101.policyName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.owner, r101.owner) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveRoomStatePolicyPriority, r101.liveRoomStatePolicyPriority) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.event, r101.event) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.intent, r101.intent) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.conditions, r101.conditions) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.permission, r101.permission) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.affectedStrategy, r101.affectedStrategy) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.affectedResources, r101.affectedResources) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        String r100 = this.policyId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.policyName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.owner;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.description;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.liveRoomStatePolicyPriority;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.category;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Set<Integer> r119 = this.event;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.intent;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.source;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.conditions;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.permission;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.reason;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.affectedStrategy;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Set<Integer> r140 = this.affectedResources;
        if (r140 == null) goto L58;
        r101 = r140.hashCode();
    L58:
        return r139 + r101;
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "RoomStatusPolicyConfig(policyId=" + this.policyId + ", policyName=" + this.policyName + ", owner=" + this.owner + ", description=" + this.description + ", liveRoomStatePolicyPriority=" + this.liveRoomStatePolicyPriority + ", category=" + this.category + ", event=" + this.event + ", intent=" + this.intent + ", source=" + this.source + ", conditions=" + this.conditions + ", permission=" + this.permission + ", reason=" + this.reason + ", affectedStrategy=" + this.affectedStrategy + ", affectedResources=" + this.affectedResources + ")";
    }
}
