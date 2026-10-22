package com.bytedance.kmp.ec.yata.store.node;

import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f251788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.b f251789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f251790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f251791e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f251787a, r101.f251787a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251788b, r101.f251788b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f251789c, r101.f251789c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f251790d, r101.f251790d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f251791e, r101.f251791e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f251787a.hashCode() * 31;
        p r101 = this.f251788b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        com.bytedance.kmp.ec.yata.common.protocol.data.b r105 = this.f251789c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f251790d.hashCode()) * 31;
        Map<String, Object> r108 = this.f251791e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NodeInfo(key=" + this.f251787a + ", nodeData=" + this.f251788b + ", nodeContainer=" + this.f251789c + ", nodeChildrenKey=" + this.f251790d + ", globalFields=" + this.f251791e + ')';
    }

    public e(String r100, p r101, com.bytedance.kmp.ec.yata.common.protocol.data.b r102, List<String> r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r103, "nodeChildrenKey");
        this.f251787a = r100;
        this.f251788b = r101;
        this.f251789c = r102;
        this.f251790d = r103;
        this.f251791e = r104;
    }
}
