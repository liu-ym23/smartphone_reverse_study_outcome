package com.bytedance.ee.bear.drive.biz.bubblemenu;

import android.os.Bundle;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final List<TTReaderSelectionInfo> a;
    public final Bundle b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<TTReaderSelectionInfo> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Bundle r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("SelectionData(selectionInfoCount='");
        List<TTReaderSelectionInfo> r1 = this.a;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.size());
    L6:
        r0.append(r2);
        r0.append("', extra=");
        r0.append(this.b);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public d(List<? extends TTReaderSelectionInfo> r1, Bundle r2) {
        this.a = r1;
        this.b = r2;
    }
}
