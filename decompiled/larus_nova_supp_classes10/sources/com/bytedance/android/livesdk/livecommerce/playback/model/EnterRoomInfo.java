package com.bytedance.android.livesdk.livecommerce.playback.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB5\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J7\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/model/EnterRoomInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "", "component4", "roomId", "enterRoomSchema", "enterRoomText", "liveStatus", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "getEnterRoomSchema", "getEnterRoomText", "Z", "getLiveStatus", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterRoomInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final String enterRoomSchema;
    private final String enterRoomText;
    private final boolean liveStatus;
    private final String roomId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EnterRoomInfo() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ EnterRoomInfo copy$default(EnterRoomInfo r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.roomId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.enterRoomSchema;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.enterRoomText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.liveStatus;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.enterRoomSchema;
    }

    public final String component3() {
        return this.enterRoomText;
    }

    public final boolean component4() {
        return this.liveStatus;
    }

    public final EnterRoomInfo copy(String r2, String r3, String r4, boolean r5) {
        return new EnterRoomInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EnterRoomInfo) == false) goto L14;
        EnterRoomInfo r4 = (EnterRoomInfo) r3;
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterRoomSchema, r4.enterRoomSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterRoomText, r4.enterRoomText) == true) goto L12;
        return false;
    L12:
        if (this.liveStatus == r4.liveStatus) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.roomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.enterRoomSchema;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.enterRoomText;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.liveStatus;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "EnterRoomInfo(roomId=" + this.roomId + ", enterRoomSchema=" + this.enterRoomSchema + ", enterRoomText=" + this.enterRoomText + ", liveStatus=" + this.liveStatus + ")";
    }

    public final String getEnterRoomSchema() {
        return this.enterRoomSchema;
    }

    public final String getEnterRoomText() {
        return this.enterRoomText;
    }

    public final boolean getLiveStatus() {
        return this.liveStatus;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public EnterRoomInfo(String r1, String r2, String r3, boolean r4) {
        this.roomId = r1;
        this.enterRoomSchema = r2;
        this.enterRoomText = r3;
        this.liveStatus = r4;
    }

    public /* synthetic */ EnterRoomInfo(String r2, String r3, String r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
