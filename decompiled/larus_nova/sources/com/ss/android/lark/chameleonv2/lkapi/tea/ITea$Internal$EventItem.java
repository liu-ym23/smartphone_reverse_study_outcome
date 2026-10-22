package com.ss.android.lark.chameleonv2.lkapi.tea;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J%\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jt\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/tea/ITea$Internal$EventItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "eventName", "", "instanceId", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "timestamp", "", "userId", "appId", "", "reportUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getInstanceId", "getParams", "()Ljava/util/HashMap;", "getTimestamp", "()J", "getUserId", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReportUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/tea/ITea$Internal$EventItem;", "equals", "", "other", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITea$Internal$EventItem implements NonProguard {
    private final Integer appId;
    private final String eventName;
    private final String instanceId;
    private final HashMap<String, Object> params;
    private final String reportUrl;
    private final long timestamp;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITea$Internal$EventItem copy$default(ITea$Internal$EventItem r100, String r110, String r111, HashMap r112, long r113, String r114, Integer r115, String r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.eventName;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.instanceId;
    L11:
        if ((r117 & 4) == 0) goto L13;
        HashMap r103 = r100.params;
    L15:
        if ((r117 & 8) == 0) goto L17;
        long r104 = r100.timestamp;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.userId;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Integer r106 = r100.appId;
    L27:
        if ((r117 & 64) == 0) goto L29;
        String r107 = r100.reportUrl;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.eventName;
    }

    public final String component2() {
        return this.instanceId;
    }

    public final HashMap<String, Object> component3() {
        return this.params;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final String component5() {
        return this.userId;
    }

    public final Integer component6() {
        return this.appId;
    }

    public final String component7() {
        return this.reportUrl;
    }

    public final ITea$Internal$EventItem copy(String r110, String r111, HashMap<String, Object> r112, long r113, String r114, Integer r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "instanceId");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r114, "userId");
        return new ITea$Internal$EventItem(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ITea$Internal$EventItem) == true) goto L8;
        return false;
    L8:
        ITea$Internal$EventItem r101 = (ITea$Internal$EventItem) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.instanceId, r101.instanceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L18;
        return false;
    L18:
        if (this.timestamp == r101.timestamp) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.reportUrl, r101.reportUrl) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.eventName.hashCode() * 31) + this.instanceId.hashCode()) * 31) + this.params.hashCode()) * 31;
        long r101 = this.timestamp;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.userId.hashCode()) * 31;
        Integer r103 = this.appId;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.reportUrl;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "EventItem(eventName=" + this.eventName + ", instanceId=" + this.instanceId + ", params=" + this.params + ", timestamp=" + this.timestamp + ", userId=" + this.userId + ", appId=" + this.appId + ", reportUrl=" + this.reportUrl + ')';
    }

    public final Integer getAppId() {
        return this.appId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final HashMap<String, Object> getParams() {
        return this.params;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public ITea$Internal$EventItem(String r100, String r101, HashMap<String, Object> r102, long r103, String r104, Integer r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "instanceId");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r104, "userId");
        this.eventName = r100;
        this.instanceId = r101;
        this.params = r102;
        this.timestamp = r103;
        this.userId = r104;
        this.appId = r105;
        this.reportUrl = r106;
    }
}
