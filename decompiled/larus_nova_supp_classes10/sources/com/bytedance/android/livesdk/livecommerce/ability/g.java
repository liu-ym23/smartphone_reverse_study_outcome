package com.bytedance.android.livesdk.livecommerce.ability;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/ability/g;", "", "", "service", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "action", "a", "params", "b", "Lc93/b;", "scheduler", "Lc93/b;", "c", "()Lc93/b;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("action")
    private final String action;

    @SerializedName("params")
    private final String params;

    @SerializedName("scheduler")
    private final c93.b scheduler;

    @SerializedName("service")
    private final String service;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L14;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.service, r4.service) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r4.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scheduler, r4.scheduler) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.service;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.action;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.params;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        c93.b r10 = this.scheduler;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveAtomicActionDsl(service=" + this.service + ", action=" + this.action + ", params=" + this.params + ", scheduler=" + this.scheduler + ")";
    }

    public final String a() {
        return this.action;
    }

    public final String b() {
        return this.params;
    }

    public final c93.b c() {
        return this.scheduler;
    }

    public final String d() {
        return this.service;
    }
}
