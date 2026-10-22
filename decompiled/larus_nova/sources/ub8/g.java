package ub8;

import com.larus.im.bean.bot.ModelItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModelItem f549382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f549383c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f549381a == r101.f549381a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549382b, r101.f549382b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549383c, r101.f549383c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f549381a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f549382b.hashCode()) * 31;
        Long r102 = this.f549383c;
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
        return "ModelUpdateResult(success=" + this.f549381a + ", modelItem=" + this.f549382b + ", errCode=" + this.f549383c + ')';
    }

    public g(boolean r100, ModelItem r101, Long r102) {
        Intrinsics.checkNotNullParameter(r101, "modelItem");
        this.f549381a = r100;
        this.f549382b = r101;
        this.f549383c = r102;
    }
}
