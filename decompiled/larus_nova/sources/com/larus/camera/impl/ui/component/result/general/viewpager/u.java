package com.larus.camera.impl.ui.component.result.general.viewpager;

import com.larus.camera.api.params.OutputParam;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class u {
    public static final boolean a(OutputParam r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        OutputParam.ResultType r102 = r100.getResultType();
    L7:
        if (r102 != OutputParam.ResultType.PHOTO) goto L14;
        String r103 = r100.getPath();
        if (r103 == null) goto L12;
        r101 = StringsKt.substringAfterLast(r103, '.', "");
    L12:
        if (StringsKt.equals(r101, "gif", true) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = null;
        goto L7
    }
}
