package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/d;", "", "", "btm", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "bcm", "Ljava/util/Map;", "getBcm", "()Ljava/util/Map;", "containerId", "getContainerId", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("bcm")
    private final Map<String, Object> bcm;

    @SerializedName("btm")
    private final String btm;

    @SerializedName("container_id")
    private final String containerId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.btm, r4.btm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bcm, r4.bcm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.containerId, r4.containerId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.btm;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.bcm;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.containerId;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HybridBtmModel(btm=" + this.btm + ", bcm=" + this.bcm + ", containerId=" + this.containerId + ")";
    }

    public d() {
        this.btm = null;
        this.bcm = null;
        this.containerId = null;
    }

    public final String a() {
        return this.btm;
    }

    public final void b(PageFinder r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultPageFinder");
        if (this.containerId == null) goto L6;
        com.bytedance.android.ec.sdk.helper.d.b.getECLynxHostService();
        return;
    }

    public final com.bytedance.android.btm.api.model.d c(PageFinder r4) {
        Intrinsics.checkNotNullParameter(r4, "defaultPageFinder");
        String r0 = this.btm;
        BcmParams.a r1 = BcmParams.Companion;
        Map<String, Object> r2 = this.bcm;
        r1.getClass();
        BcmParams r3 = BcmParams.a.c(r2);
        b(r4);
        return BtmUtilsKt.d(r0, r3, r4);
    }
}
