package com.bytedance.android.livesdk.live.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Deprecated(message = "弃用")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/live/model/LiveInnerUrl;", "", "", "component1", "component2", "component3", "key", "reqFrom", "innerUrl", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getReqFrom", "getInnerUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerUrl {
    public static final a Companion = null;

    @SerializedName("inner_url")
    private final String innerUrl;

    @SerializedName("key")
    private final String key;

    @SerializedName("req_from")
    private final String reqFrom;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LiveInnerUrl copy$default(LiveInnerUrl r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.reqFrom;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.innerUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.reqFrom;
    }

    public final String component3() {
        return this.innerUrl;
    }

    public final LiveInnerUrl copy(String r2, String r3, String r4) {
        return new LiveInnerUrl(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveInnerUrl) == false) goto L12;
        LiveInnerUrl r4 = (LiveInnerUrl) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reqFrom, r4.reqFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.innerUrl, r4.innerUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.reqFrom;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.innerUrl;
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

    public String toString() {
        return "LiveInnerUrl(key=" + this.key + ", reqFrom=" + this.reqFrom + ", innerUrl=" + this.innerUrl + ")";
    }

    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getReqFrom() {
        return this.reqFrom;
    }

    public LiveInnerUrl(String r1, String r2, String r3) {
        this.key = r1;
        this.reqFrom = r2;
        this.innerUrl = r3;
    }
}
