package com.bytedance.mira.util;

import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;

/* JADX INFO: loaded from: classes21.dex */
public class IntentUtils {
    public IntentUtils() {
    }

    public static boolean checkHasUnknownClass(Intent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L12;
        return false;
    L12:
        r101.getParcelable("");     // Catch: BadParcelableException -> L10
        return false;
    L10:
        return true;
    }
}
