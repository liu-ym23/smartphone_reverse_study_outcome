package com.obric.miniapp.lynx;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class j2 implements Function1 {
    public /* synthetic */ j2() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        View r101 = (View) r100;
        int r102 = LynxOUIDatePickerViewUI.f397901w;
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r101;
    L6:
        if (r103 == null) goto L9;
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
    L9:
        return Unit.INSTANCE;
    L5:
        r103 = null;
        goto L6
    }
}
