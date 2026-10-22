package jd9;

import com.larus.im.internal.utils.a0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d extends a0<c> {
    public d() {
        c.f r100 = c.f.f498762c;
    }

    @Override // com.larus.im.internal.utils.a0
    public final c a(Object r100, Object r101) {
        c r102 = (c) r100;
        c r103 = (c) r101;
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        c.f r104 = c.f.f498762c;
        if (Intrinsics.areEqual(r102, r104) == false) goto L8;
        if (Intrinsics.areEqual(r102, r103) == false) goto L25;
        return r102;
    L25:
        return r103;
    L8:
        if (Intrinsics.areEqual(r102, c.e.f498761c) == false) goto L11;
        return r102;
    L11:
        if ((r102 instanceof c.d) == false) goto L20;
        if ((r103 instanceof c.d) == false) goto L25;
        c.d r105 = (c.d) r103;
        c.d r106 = (c.d) r102;
        if (r105.f498756c != r106.f498756c) goto L25;
        if (r105.f498757d != r106.f498757d) goto L25;
        return r102;
    L20:
        if (Intrinsics.areEqual(r103, r104) == false) goto L22;
        return r102;
    L22:
        if (Intrinsics.areEqual(r103, r102) == false) goto L25;
        return r102;
    }
}
