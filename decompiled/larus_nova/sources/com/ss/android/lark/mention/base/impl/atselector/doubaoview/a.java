package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431739a = 0;

    static {
    }

    public static boolean a(BaseAtBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "doubaoChatterId");
        if (r100.getType() != 8) goto L5;
        return true;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
    L12:
        return false;
    L10:
        if (Intrinsics.areEqual(r100.getId(), r101) == false) goto L12;
        return true;
    L7:
        r102 = false;
        goto L8
    }
}
