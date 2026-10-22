package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmSubtitleScrollMode f436391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f436392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f436393c;

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
        if (this.f436391a == r101.f436391a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f436392b, r101.f436392b) == true) goto L15;
        return false;
    L15:
        if (this.f436393c == r101.f436393c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f436391a.hashCode() * 31) + this.f436392b.hashCode()) * 31;
        if (this.f436393c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmSubtitleVMState(scrollMode=" + this.f436391a + ", subtitleList=" + this.f436392b + ", isSubtitleDegraded=" + this.f436393c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(MmSubtitleScrollMode.FOLLOW, CollectionsKt.emptyList(), false);
    }

    public a(MmSubtitleScrollMode r100, List<h> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scrollMode");
        Intrinsics.checkNotNullParameter(r101, "subtitleList");
        this.f436391a = r100;
        this.f436392b = r101;
        this.f436393c = r102;
    }

    public static a a(a r100, MmSubtitleScrollMode r101, List r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f436391a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f436392b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f436393c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "scrollMode");
        Intrinsics.checkNotNullParameter(r102, "subtitleList");
        return new a(r101, r102, r103);
    }
}
