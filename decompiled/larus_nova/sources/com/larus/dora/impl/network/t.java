package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.entity.NotificationRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/network/NotificationRuleActionResponse;", "", com.heytap.mcssdk.constant.b.f276366p, "Lcom/larus/dora/api/entity/NotificationRule;", "success", "", "<init>", "(Lcom/larus/dora/api/entity/NotificationRule;Ljava/lang/Boolean;)V", "getRule", "()Lcom/larus/dora/api/entity/NotificationRule;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Lcom/larus/dora/api/entity/NotificationRule;Ljava/lang/Boolean;)Lcom/larus/dora/impl/network/NotificationRuleActionResponse;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t {

    @SerializedName(com.heytap.mcssdk.constant.b.f276366p)
    private final NotificationRule rule;

    @SerializedName("success")
    private final Boolean success;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.rule, r101.rule) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        NotificationRule r100 = this.rule;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.success;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NotificationRuleActionResponse(rule=" + this.rule + ", success=" + this.success + ')';
    }

    public t() {
        Boolean r100 = Boolean.FALSE;
        this.rule = null;
        this.success = r100;
    }

    public final Boolean a() {
        return this.success;
    }
}
