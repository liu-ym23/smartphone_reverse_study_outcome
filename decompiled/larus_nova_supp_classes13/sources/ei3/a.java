package ei3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lei3/a;", "", "", "adRefer", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "adLabel", "a", "eventName", "c", "", "params", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "groupId", "e", "", "eventType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "timestampKey", "g", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public static final /* synthetic */ int a = 0;

    @SerializedName("ad_label")
    private final String adLabel;

    @SerializedName("ad_refer")
    private final String adRefer;

    @SerializedName("event_name")
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
    public static final class C0194a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.adRefer, r4.adRefer) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.adLabel, r4.adLabel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventName, r4.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.groupId, r4.groupId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.eventType, r4.eventType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timestampKey, r4.timestampKey) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.adRefer;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.adLabel;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.eventName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.params;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.groupId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.eventType;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.timestampKey;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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

    public a(String r3, String r4, String r5, Map r6, Integer r7, String r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r9 & 64) == 0) goto L20;
        r8 = null;
    L20:
        this.adRefer = r3;
        this.adLabel = r4;
        this.eventName = r5;
        this.params = r6;
        this.groupId = null;
        this.eventType = r7;
        this.timestampKey = r8;
    }
}
