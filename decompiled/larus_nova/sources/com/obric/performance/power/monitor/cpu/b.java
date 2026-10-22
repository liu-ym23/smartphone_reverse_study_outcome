package com.obric.performance.power.monitor.cpu;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.File;
import java.io.FilenameFilter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements FilenameFilter {
    public b() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        Intrinsics.checkNotNullParameter(r101, "name");
        if (StringsKt.startsWith$default(r101, "cpu", false, 2, null) == true) goto L5;
    L17:
        return false;
    L5:
        if (r101.length() < 4) goto L17;
        int r102 = r101.length();
        int r103 = 3;
    L7:
        if (r103 >= r102) goto L15;
        if (Intrinsics.compare(r101.charAt(r103), 48) < 0) goto L14;
        if (Intrinsics.compare(r101.charAt(r103), 57) > 0) goto L14;
        r103 = r103 + 1;
    L14:
        return false;
    L15:
        return true;
    }
}
