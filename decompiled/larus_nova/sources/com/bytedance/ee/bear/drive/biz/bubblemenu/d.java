package com.bytedance.ee.bear.drive.biz.bubblemenu;

import android.os.Bundle;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TTReaderSelectionInfo> f222610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f222611b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f222610a, r101.f222610a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f222611b, r101.f222611b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<TTReaderSelectionInfo> r100 = this.f222610a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bundle r104 = this.f222611b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("SelectionData(selectionInfoCount='");
        List<TTReaderSelectionInfo> r101 = this.f222610a;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append("', extra=");
        r100.append(this.f222611b);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends TTReaderSelectionInfo> r100, Bundle r101) {
        this.f222610a = r100;
        this.f222611b = r101;
    }
}
