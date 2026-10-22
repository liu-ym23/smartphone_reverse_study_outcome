package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", "", "", "actionName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "actionParam", "getActionParam", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("action_name")
    private final String actionName;

    @SerializedName("action_param")
    private final String actionParam;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r0) == false) goto L10;
        r0 r4 = (r0) r3;
        if (Intrinsics.areEqual(this.actionName, r4.actionName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionParam, r4.actionParam) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.actionName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.actionParam;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveIntroControlAction(actionName=" + this.actionName + ", actionParam=" + this.actionParam + ")";
    }

    public r0() {
        this.actionName = null;
        this.actionParam = null;
    }

    public final String a() {
        return this.actionName;
    }
}
