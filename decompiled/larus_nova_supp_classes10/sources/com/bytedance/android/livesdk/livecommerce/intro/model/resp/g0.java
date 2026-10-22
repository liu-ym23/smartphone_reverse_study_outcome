package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/g0;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h0;", "title", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h0;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/f0;", "propertyTable", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/f0;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/f0;", "", "", "eventParams", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "showType", "I", "c", "()I", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("property_table")
    private final f0 propertyTable;

    @SerializedName("show_type")
    private final int showType;

    @SerializedName("title")
    private final h0 title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g0) == false) goto L14;
        g0 r4 = (g0) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.propertyTable, r4.propertyTable) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventParams, r4.eventParams) == true) goto L12;
        return false;
    L12:
        if (this.showType == r4.showType) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        h0 r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        f0 r4 = this.propertyTable;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.eventParams;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + this.showType;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroProductSecondFrame(title=" + this.title + ", propertyTable=" + this.propertyTable + ", eventParams=" + this.eventParams + ", showType=" + this.showType + ")";
    }

    public g0() {
        this.title = null;
        this.propertyTable = null;
        this.eventParams = null;
        this.showType = 1;
    }

    public final Map<String, String> a() {
        return this.eventParams;
    }

    public final f0 b() {
        return this.propertyTable;
    }

    public final int c() {
        return this.showType;
    }

    public final h0 d() {
        return this.title;
    }
}
