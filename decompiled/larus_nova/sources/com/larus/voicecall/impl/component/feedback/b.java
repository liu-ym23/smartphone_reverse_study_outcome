package com.larus.voicecall.impl.component.feedback;

import com.larus.bmhome.auth.FeedbackMeta;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f377442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<FeedbackMeta> f377443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f377444c;

    public b() {
        this(7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f377442a == r101.f377442a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f377443b, r101.f377443b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f377444c, r101.f377444c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f377442a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f377443b.hashCode()) * 31;
        String r102 = this.f377444c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DislikeFeedbackData(isSubmit=" + this.f377442a + ", selectedTags=" + this.f377443b + ", content=" + this.f377444c + ')';
    }

    public /* synthetic */ b(int r100) {
        if ((r100 & 2) == 0) goto L5;
        List r101 = CollectionsKt.emptyList();
    L6:
        this(false, r101, null);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public b(boolean r100, List<FeedbackMeta> r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "selectedTags");
        this.f377442a = r100;
        this.f377443b = r101;
        this.f377444c = r102;
    }
}
