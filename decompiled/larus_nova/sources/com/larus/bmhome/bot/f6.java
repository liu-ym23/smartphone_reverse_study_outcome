package com.larus.bmhome.bot;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q5> f296598a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f6) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f296598a, ((f6) r100).f296598a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f296598a.hashCode();
    }

    public final String toString() {
        return "ServiceBotSettingUiState(blocks=" + this.f296598a + ')';
    }

    public f6() {
        this(CollectionsKt.emptyList());
    }

    public f6(List<q5> r100) {
        Intrinsics.checkNotNullParameter(r100, "blocks");
        this.f296598a = r100;
    }
}
