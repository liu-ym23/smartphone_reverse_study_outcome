package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f443814c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f443812a, r101.f443812a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443813b, r101.f443813b) == true) goto L15;
        return false;
    L15:
        if (this.f443814c == r101.f443814c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f443812a.hashCode() * 31) + this.f443813b.hashCode()) * 31;
        if (this.f443814c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AtChatterBean(chatterId=" + this.f443812a + ", displayName=" + this.f443813b + ", isOuter=" + this.f443814c + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        this.f443812a = r100;
        this.f443813b = r101;
        this.f443814c = false;
    }
}
