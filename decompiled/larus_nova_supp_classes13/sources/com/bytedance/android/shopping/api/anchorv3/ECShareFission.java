package com.bytedance.android.shopping.api.anchorv3;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u001f\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J!\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECShareFission;", "Ljava/io/Serializable;", "", "component1", "component2", "shareScene", "secActivityInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getShareScene", "()Ljava/lang/String;", "getSecActivityInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECShareFission implements Serializable {
    public static final a Companion = null;
    public static final String SHARE_BUTTON_BUBBLE_TIMES = "share_button_bubble_times";
    public static final String SHARE_CONTROL_TIMES = "share_control_times";
    private final String secActivityInfo;
    private final String shareScene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECShareFission() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ECShareFission copy$default(ECShareFission r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.shareScene;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.secActivityInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.shareScene;
    }

    public final String component2() {
        return this.secActivityInfo;
    }

    public final ECShareFission copy(String r2, String r3) {
        return new ECShareFission(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECShareFission) == false) goto L10;
        ECShareFission r4 = (ECShareFission) r3;
        if (Intrinsics.areEqual(this.shareScene, r4.shareScene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secActivityInfo, r4.secActivityInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.shareScene;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.secActivityInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ECShareFission(shareScene=" + this.shareScene + ", secActivityInfo=" + this.secActivityInfo + ")";
    }

    public final String getSecActivityInfo() {
        return this.secActivityInfo;
    }

    public final String getShareScene() {
        return this.shareScene;
    }

    public ECShareFission(String r1, String r2) {
        this.shareScene = r1;
        this.secActivityInfo = r2;
    }

    public /* synthetic */ ECShareFission(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
