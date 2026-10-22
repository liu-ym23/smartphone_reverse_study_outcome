package com.larus.kmp.voice_setting.voice.list.p011public;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t1a.f;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f353587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f353588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublicVoiceListFooterState f353589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f353591e;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f353587a, r101.f353587a) == true) goto L12;
        return false;
    L12:
        if (this.f353588b == r101.f353588b) goto L15;
        return false;
    L15:
        if (this.f353589c == r101.f353589c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353590d, r101.f353590d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353591e, r101.f353591e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f353587a.hashCode() * 31;
        if (this.f353588b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((r100 + r101) * 31) + this.f353589c.hashCode()) * 31) + this.f353590d.hashCode()) * 31) + this.f353591e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PublicVoiceListScreenUiState(rows=" + this.f353587a + ", showEmptyState=" + this.f353588b + ", footerState=" + this.f353589c + ", footerText=" + this.f353590d + ", emptyState=" + this.f353591e + ')';
    }

    public /* synthetic */ p(int r100) {
        this(CollectionsKt.emptyList(), false, PublicVoiceListFooterState.HIDDEN, "", new a(0));
    }

    public p(List<b> r100, boolean r101, PublicVoiceListFooterState r102, String r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "rows");
        Intrinsics.checkNotNullParameter(r102, "footerState");
        Intrinsics.checkNotNullParameter(r103, "footerText");
        Intrinsics.checkNotNullParameter(r104, "emptyState");
        this.f353587a = r100;
        this.f353588b = r101;
        this.f353589c = r102;
        this.f353590d = r103;
        this.f353591e = r104;
    }
}
