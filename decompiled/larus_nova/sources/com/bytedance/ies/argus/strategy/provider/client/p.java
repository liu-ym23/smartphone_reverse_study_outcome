package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.bean.ArgusWebContentVerifyReason;
import com.bytedance.ies.argus.bean.config.ContentVerifyRuleItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentVerifyRuleItem f246232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f246234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f246235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContentVerifyRuleItem.ContentType f246236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.o f246237f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f246232a, r101.f246232a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246233b, r101.f246233b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246234c, r101.f246234c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246235d, r101.f246235d) == true) goto L21;
        return false;
    L21:
        if (this.f246236e == r101.f246236e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f246237f, r101.f246237f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f246232a.hashCode() * 31) + this.f246233b.hashCode()) * 31) + this.f246234c.hashCode()) * 31) + this.f246235d.hashCode()) * 31) + this.f246236e.hashCode()) * 31) + this.f246237f.hashCode();
    }

    public final String toString() {
        return "SecurityRuleMatchResult(rule=" + this.f246232a + ", verifyContent=" + this.f246233b + ", matchedPattern=" + this.f246234c + ", matchedRiskContent=" + this.f246235d + ", verifyContentType=" + this.f246236e + ", reason=" + this.f246237f + ')';
    }

    public p(ContentVerifyRuleItem r100, String r101, String r102, String r103, ContentVerifyRuleItem.ContentType r104, ArgusWebContentVerifyReason r105) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        Intrinsics.checkNotNullParameter(r101, "verifyContent");
        Intrinsics.checkNotNullParameter(r102, "matchedPattern");
        Intrinsics.checkNotNullParameter(r103, "matchedRiskContent");
        Intrinsics.checkNotNullParameter(r104, "verifyContentType");
        Intrinsics.checkNotNullParameter(r105, "reason");
        this.f246232a = r100;
        this.f246233b = r101;
        this.f246234c = r102;
        this.f246235d = r103;
        this.f246236e = r104;
        this.f246237f = r105;
    }
}
