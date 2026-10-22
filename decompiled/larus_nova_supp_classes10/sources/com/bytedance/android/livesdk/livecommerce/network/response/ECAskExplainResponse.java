package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\t\u0010\n\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000b\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECAskExplainResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "", "component2", "askExplainStatus", "userCount", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAskExplainStatus", "()Ljava/lang/String;", "I", "getUserCount", "()I", "<init>", "(Ljava/lang/String;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAskExplainResponse extends g implements Serializable {

    @SerializedName("ask_explain_status")
    private final String askExplainStatus;

    @SerializedName("user_count")
    private final int userCount;

    public ECAskExplainResponse() {
        String r2 = null;
        this(r2, 0, 3, r2);
    }

    public static /* synthetic */ ECAskExplainResponse copy$default(ECAskExplainResponse r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.askExplainStatus;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.userCount;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.askExplainStatus;
    }

    public final int component2() {
        return this.userCount;
    }

    public final ECAskExplainResponse copy(String r2, int r3) {
        return new ECAskExplainResponse(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECAskExplainResponse) == false) goto L10;
        ECAskExplainResponse r4 = (ECAskExplainResponse) r3;
        if (Intrinsics.areEqual(this.askExplainStatus, r4.askExplainStatus) == true) goto L8;
        return false;
    L8:
        if (this.userCount == r4.userCount) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.askExplainStatus;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.userCount;
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "ECAskExplainResponse(askExplainStatus=" + this.askExplainStatus + ", userCount=" + this.userCount + ")";
    }

    public final String getAskExplainStatus() {
        return this.askExplainStatus;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    public ECAskExplainResponse(String r1, int r2) {
        this.askExplainStatus = r1;
        this.userCount = r2;
    }

    public /* synthetic */ ECAskExplainResponse(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
