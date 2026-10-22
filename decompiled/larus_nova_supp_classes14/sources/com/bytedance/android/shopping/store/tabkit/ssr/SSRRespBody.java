package com.bytedance.android.shopping.store.tabkit.ssr;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/ssr/SSRRespBody;", "", "result", "", "data", "status", "", "message", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getMessage", "getResult", "getStatus", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SSRRespBody {

    @SerializedName("initData")
    private final String data;

    @SerializedName("message")
    private final String message;

    @SerializedName("ssrResult")
    private final String result;

    @SerializedName("status")
    private final int status;

    public SSRRespBody() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ SSRRespBody copy$default(SSRRespBody r0, String r1, String r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.result;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.status;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.message;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.result;
    }

    public final String component2() {
        return this.data;
    }

    public final int component3() {
        return this.status;
    }

    public final String component4() {
        return this.message;
    }

    public final SSRRespBody copy(String r2, String r3, int r4, String r5) {
        return new SSRRespBody(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SSRRespBody) == false) goto L14;
        SSRRespBody r4 = (SSRRespBody) r3;
        if (Intrinsics.areEqual(this.result, r4.result) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L10;
        return false;
    L10:
        if (this.status == r4.status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.result;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.data;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.status) * 31;
        String r7 = this.message;
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
        return "SSRRespBody(result=" + this.result + ", data=" + this.data + ", status=" + this.status + ", message=" + this.message + ")";
    }

    public final String getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getResult() {
        return this.result;
    }

    public final int getStatus() {
        return this.status;
    }

    public SSRRespBody(String r1, String r2, int r3, String r4) {
        this.result = r1;
        this.data = r2;
        this.status = r3;
        this.message = r4;
    }

    public /* synthetic */ SSRRespBody(String r2, String r3, int r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
