package com.ss.android.lark.chat.cot.detail;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class u implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.c f415008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<v> f415009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f415010c;

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f415008a, r101.f415008a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415009b, r101.f415009b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f415010c, r101.f415010c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        com.ss.android.lark.chat.cot.c r100 = this.f415008a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f415009b.hashCode()) * 31;
        String r104 = this.f415010c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CotToolCallDetailExtra(iconSpec=" + this.f415008a + ", resultAreas=" + this.f415009b + ", parentGroupId=" + this.f415010c + ')';
    }

    public /* synthetic */ u(com.ss.android.lark.chat.cot.c r100, List r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(com.ss.android.lark.chat.cot.c r100, List<? extends v> r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "resultAreas");
        this.f415008a = r100;
        this.f415009b = r101;
        this.f415010c = r102;
    }
}
