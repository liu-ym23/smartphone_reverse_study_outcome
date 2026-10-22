package com.larus.kmp.voice_setting.voice.dialog;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements t1a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f352802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f352803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f352804c;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f352802a, r101.f352802a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352803b, r101.f352803b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352804c, r101.f352804c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f352802a.hashCode() * 31) + this.f352803b.hashCode()) * 31) + this.f352804c.hashCode();
    }

    public final String toString() {
        return "UgcVoiceAuthorizeDialogUiState(title=" + this.f352802a + ", items=" + this.f352803b + ", confirmText=" + this.f352804c + ')';
    }

    public /* synthetic */ h(int r100) {
        this("", CollectionsKt.emptyList(), "");
    }

    public h(String r100, List<d> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r102, "confirmText");
        this.f352802a = r100;
        this.f352803b = r101;
        this.f352804c = r102;
    }
}
