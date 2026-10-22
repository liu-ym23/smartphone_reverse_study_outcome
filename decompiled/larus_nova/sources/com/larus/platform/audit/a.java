package com.larus.platform.audit;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorAuditOperation f365322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f365323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f365326e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f365322a == r101.f365322a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365323b, r101.f365323b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365324c, r101.f365324c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365325d, r101.f365325d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365326e, r101.f365326e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365322a.hashCode() * 31;
        b r101 = this.f365323b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f365324c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f365325d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f365326e.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BehaviorAuditEvent(operation=" + this.f365322a + ", fileInfo=" + this.f365323b + ", operatorId=" + this.f365324c + ", shareChannel=" + this.f365325d + ", extras=" + this.f365326e + ')';
    }

    public /* synthetic */ a(BehaviorAuditOperation r100, b r110, String r111, Map r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        b r101 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        r112 = MapsKt.emptyMap();
    L13:
        this(r100, r101, null, r102, r112);
        return;
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public a(BehaviorAuditOperation r100, b r101, String r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r104, "extras");
        this.f365322a = r100;
        this.f365323b = r101;
        this.f365324c = r102;
        this.f365325d = r103;
        this.f365326e = r104;
    }
}
