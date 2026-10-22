package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "component1", "editCartData", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "getEditCartData", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEditCartResponse extends g implements Serializable {

    @SerializedName("data")
    private final ECEditCartData editCartData;

    public ECEditCartResponse() {
        ECEditCartData r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ ECEditCartResponse copy$default(ECEditCartResponse r0, ECEditCartData r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.editCartData;
    L6:
        return r0.copy(r1);
    }

    public final ECEditCartData component1() {
        return this.editCartData;
    }

    public final ECEditCartResponse copy(ECEditCartData r2) {
        return new ECEditCartResponse(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof ECEditCartResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.editCartData, ((ECEditCartResponse) r2).editCartData) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        ECEditCartData r0 = this.editCartData;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "ECEditCartResponse(editCartData=" + this.editCartData + ")";
    }

    public final ECEditCartData getEditCartData() {
        return this.editCartData;
    }

    public ECEditCartResponse(ECEditCartData r1) {
        this.editCartData = r1;
    }

    public /* synthetic */ ECEditCartResponse(ECEditCartData r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
