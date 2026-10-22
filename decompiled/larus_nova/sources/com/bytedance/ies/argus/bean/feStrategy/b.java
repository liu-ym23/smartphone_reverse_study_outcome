package com.bytedance.ies.argus.bean.feStrategy;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f246027b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f246028a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f246028a, ((b) r100).f246028a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f246028a.hashCode();
    }

    public final String toString() {
        return "ArgusJSBAuthRecoveryConfig(closeAuthUrls=" + this.f246028a + ')';
    }

    public b() {
        this(CollectionsKt.emptyList());
    }

    public b(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "closeAuthUrls");
        this.f246028a = r100;
    }
}
