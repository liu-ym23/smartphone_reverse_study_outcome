package com.ivy.ivykit.api.bridge;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f278299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f278300b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f278299a == r101.f278299a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f278300b, r101.f278300b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f278299a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f278300b.hashCode();
    }

    public final String toString() {
        return "BridgeConfig(enableJSBPermission=" + this.f278299a + ", authHostWhiteList=" + this.f278300b + ")";
    }

    public /* synthetic */ a(int r100) {
        this(true, CollectionsKt.emptyList());
    }

    public a(boolean r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "authHostWhiteList");
        this.f278299a = r100;
        this.f278300b = r101;
    }
}
