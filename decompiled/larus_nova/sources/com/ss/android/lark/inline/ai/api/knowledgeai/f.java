package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f426836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IKnowledgeAIScopeItemInfo> f426837b;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f426836a == r101.f426836a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426837b, r101.f426837b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f426836a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f426837b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "KnowledgeAIMeetingInfoModel(isVcMeetingNote=" + this.f426836a + ", scopeItemInfos=" + this.f426837b + ')';
    }

    public /* synthetic */ f(int r100) {
        this(false, CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(boolean r100, List<? extends IKnowledgeAIScopeItemInfo> r101) {
        Intrinsics.checkNotNullParameter(r101, "scopeItemInfos");
        this.f426836a = r100;
        this.f426837b = r101;
    }
}
