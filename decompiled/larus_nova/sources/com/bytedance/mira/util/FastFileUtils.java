package com.bytedance.mira.util;

import android.system.OsConstants;
import com.bytedance.mira.plugin.trip.natvierutime.utils.UtilsExt;

/* JADX INFO: loaded from: classes3.dex */
public class FastFileUtils {
    public FastFileUtils() {
    }

    public static boolean isExist(String r100) {
        return UtilsExt.access(r100, OsConstants.F_OK);
    L4:
        return false;
    }

    public static boolean isSymLinkExist(String r100) {
        return UtilsExt.symlinkExists(r100);
    }
}
