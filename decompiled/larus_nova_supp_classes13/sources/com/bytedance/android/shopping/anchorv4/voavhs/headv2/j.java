package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "", "", "containerId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "url", "e", "", "initData", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setInitData", "(Ljava/util/Map;)V", "", "needCache", "Z", "c", "()Z", "isOpen", "f", "needStatusBarPlace", "d", "needRoundFill", "getNeedRoundFill", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("container_id")
    private final String containerId;

    @SerializedName("init_data")
    private Map<String, String> initData;

    @SerializedName("is_open")
    private final boolean isOpen;

    @SerializedName("need_cache")
    private final boolean needCache;

    @SerializedName("need_round_fill")
    private final boolean needRoundFill;

    @SerializedName("need_status_bar_place")
    private final boolean needStatusBarPlace;

    @SerializedName("url")
    private final String url;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L20;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.containerId, r4.containerId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.initData, r4.initData) == true) goto L12;
        return false;
    L12:
        if (this.needCache == r4.needCache) goto L14;
        return false;
    L14:
        if (this.isOpen == r4.isOpen) goto L16;
        return false;
    L16:
        if (this.needStatusBarPlace == r4.needStatusBarPlace) goto L18;
        return false;
    L18:
        if (this.needRoundFill == r4.needRoundFill) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r0 = this.containerId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, String> r7 = this.initData;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.needCache;
        ?? r10 = 1;
        ?? r11 = r9;
        if (r9 == false) goto L16;
        r11 = 1;
    L16:
        int r12 = (r8 + r11) * 31;
        boolean r13 = this.isOpen;
        ?? r14 = r13;
        if (r13 == false) goto L19;
        r14 = 1;
    L19:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.needStatusBarPlace;
        ?? r17 = r16;
        if (r16 == false) goto L22;
        r17 = 1;
    L22:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.needRoundFill;
        if (r19 == true) goto L27;
        r10 = r19;
    L27:
        return r18 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HeaderLynxContainer(containerId=" + this.containerId + ", url=" + this.url + ", initData=" + this.initData + ", needCache=" + this.needCache + ", isOpen=" + this.isOpen + ", needStatusBarPlace=" + this.needStatusBarPlace + ", needRoundFill=" + this.needRoundFill + ")";
    }

    public j() {
        this.containerId = null;
        this.url = null;
        this.initData = null;
        this.needCache = false;
        this.isOpen = true;
        this.needStatusBarPlace = false;
        this.needRoundFill = true;
    }

    public final String a() {
        return this.containerId;
    }

    public final Map<String, String> b() {
        return this.initData;
    }

    public final boolean c() {
        return this.needCache;
    }

    public final boolean d() {
        return this.needStatusBarPlace;
    }

    public final String e() {
        return this.url;
    }

    public final boolean f() {
        return this.isOpen;
    }
}
