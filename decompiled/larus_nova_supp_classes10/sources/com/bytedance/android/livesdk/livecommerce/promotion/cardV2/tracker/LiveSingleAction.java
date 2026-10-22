package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/tracker/LiveSingleAction;", "Ljava/io/Serializable;", "actionName", "", LocationMonitorConst.INFO, "", "", "success", "", "error", "requestId", "schema", "(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "getError", "getInfo", "()Ljava/util/Map;", "getRequestId", "getSchema", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSingleAction implements Serializable {

    @SerializedName("action_name")
    private final String actionName;

    @SerializedName("error")
    private final String error;

    @SerializedName(LocationMonitorConst.INFO)
    private final Map<String, Object> info;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("success")
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveSingleAction copy$default(LiveSingleAction r4, String r5, Map r6, boolean r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.actionName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.info;
    L8:
        Map r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.success;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.error;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.requestId;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.schema;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.actionName;
    }

    public final Map<String, Object> component2() {
        return this.info;
    }

    public final boolean component3() {
        return this.success;
    }

    public final String component4() {
        return this.error;
    }

    public final String component5() {
        return this.requestId;
    }

    public final String component6() {
        return this.schema;
    }

    public final LiveSingleAction copy(String r9, Map<String, ? extends Object> r10, boolean r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "actionName");
        return new LiveSingleAction(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveSingleAction) == false) goto L18;
        LiveSingleAction r4 = (LiveSingleAction) r3;
        if (Intrinsics.areEqual(this.actionName, r4.actionName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.info, r4.info) == true) goto L10;
        return false;
    L10:
        if (this.success == r4.success) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.error, r4.error) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.requestId, r4.requestId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        String r0 = this.actionName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.info;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.success;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        String r10 = this.error;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        String r13 = this.requestId;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        String r16 = this.schema;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return r15 + r1;
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LiveSingleAction(actionName=" + this.actionName + ", info=" + this.info + ", success=" + this.success + ", error=" + this.error + ", requestId=" + this.requestId + ", schema=" + this.schema + ")";
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getError() {
        return this.error;
    }

    public final Map<String, Object> getInfo() {
        return this.info;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public LiveSingleAction(String r2, Map<String, ? extends Object> r3, boolean r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        this.actionName = r2;
        this.info = r3;
        this.success = r4;
        this.error = r5;
        this.requestId = r6;
        this.schema = r7;
    }

    public /* synthetic */ LiveSingleAction(String r10, Map r11, boolean r12, String r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r16 & 32) == 0) goto L13;
        String r8 = null;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}
