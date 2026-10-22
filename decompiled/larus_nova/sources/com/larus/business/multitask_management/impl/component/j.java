package com.larus.business.multitask_management.impl.component;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f320815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f320816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SectionCardStyle f320818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f320819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f320820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f320821g;

    public j() {
        this(null, false, 0, null, 0, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f320815a, r101.f320815a) == true) goto L12;
        return false;
    L12:
        if (this.f320816b == r101.f320816b) goto L15;
        return false;
    L15:
        if (this.f320817c == r101.f320817c) goto L18;
        return false;
    L18:
        if (this.f320818d == r101.f320818d) goto L21;
        return false;
    L21:
        if (this.f320819e == r101.f320819e) goto L24;
        return false;
    L24:
        if (this.f320820f == r101.f320820f) goto L27;
        return false;
    L27:
        if (this.f320821g == r101.f320821g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f320815a.hashCode() * 31;
        if (this.f320816b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((((((r100 + r101) * 31) + this.f320817c) * 31) + this.f320818d.hashCode()) * 31) + this.f320819e) * 31) + this.f320820f) * 31) + this.f320821g;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SectionRenderConfig(title=" + this.f320815a + ", showTitle=" + this.f320816b + ", spanCount=" + this.f320817c + ", cardStyle=" + this.f320818d + ", topMargin=" + this.f320819e + ", horizontalSpacing=" + this.f320820f + ", verticalSpacing=" + this.f320821g + ')';
    }

    public final j a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = r110.getResources().getDimensionPixelSize(this.f320819e);
        int r101 = r110.getResources().getDimensionPixelSize(this.f320820f);
        int r102 = r110.getResources().getDimensionPixelSize(this.f320821g);
        String r103 = this.f320815a;
        boolean r104 = this.f320816b;
        int r105 = this.f320817c;
        SectionCardStyle r106 = this.f320818d;
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r106, "cardStyle");
        return new j(r103, r104, r105, r106, r100, r101, r102);
    }

    public /* synthetic */ j(String r100, boolean r110, int r111, SectionCardStyle r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        boolean r102 = true;
    L10:
        if ((r114 & 4) == 0) goto L12;
        int r103 = 1;
    L14:
        if ((r114 & 8) == 0) goto L16;
        r112 = SectionCardStyle.SMALL;
    L16:
        SectionCardStyle r104 = r112;
        if ((r114 & 16) == 0) goto L19;
        r113 = v19.c.b(R.attr.larus_dp_28, null, R.dimen.larus_dp_28);
    L19:
        int r105 = r113;
        if ((r114 & 32) == 0) goto L22;
        int r106 = v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12);
    L24:
        if ((r114 & 64) == 0) goto L26;
        int r107 = v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12);
    L27:
        this(r101, r102, r103, r104, r105, r106, r107);
        return;
    L26:
        r107 = 0;
        goto L27
    L22:
        r106 = 0;
        goto L24
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = r110;
        goto L10
    }

    public j(String r100, boolean r101, int r102, SectionCardStyle r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r103, "cardStyle");
        this.f320815a = r100;
        this.f320816b = r101;
        this.f320817c = r102;
        this.f320818d = r103;
        this.f320819e = r104;
        this.f320820f = r105;
        this.f320821g = r106;
    }
}
