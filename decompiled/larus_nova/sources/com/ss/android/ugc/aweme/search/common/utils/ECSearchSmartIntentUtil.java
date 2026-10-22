package com.ss.android.ugc.aweme.search.common.utils;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchSmartIntentUtil {
    public static boolean a(Intent r100) {
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L5;
        return false;
    L5:
        Object r102 = r101.get("no_crop_images_card");
        if (r102 != null) goto L9;
        return false;
    L9:
        if ((r102 instanceof String) == true) goto L18;
        return ((Boolean) r102).booleanValue();
    L15:
        return false;
    L18:
        return Boolean.parseBoolean((String) r102);
    L12:
        return false;
    }

    public static int b(Intent r100, String r101, int r102) {
        Bundle r103 = r100.getExtras();
        if (r103 != null) goto L5;
        return r102;
    L5:
        Object r104 = r103.get(r101);
        if (r104 != null) goto L9;
        return r102;
    L9:
        if ((r104 instanceof String) == false) goto L18;
        return CastIntegerProtector.parseInt((String) r104);
    L12:
        return r102;
    L18:
        return ((Integer) r104).intValue();
    L15:
        return r102;
    }
}
