package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.bean.AspectConfigItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AspectConfigItem f246106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f246107c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f246105a, r101.f246105a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246106b, r101.f246106b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246107c, r101.f246107c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246105a.hashCode() * 31;
        AspectConfigItem r101 = this.f246106b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f246107c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AspectConfigInfo(cId=" + this.f246105a + ", config=" + this.f246106b + ", version=" + this.f246107c + ')';
    }

    public a(String r100, AspectConfigItem r101) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        this.f246105a = r100;
        this.f246106b = r101;
        this.f246107c = null;
    }
}
