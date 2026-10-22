package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECFloatPanelExpandedUtils {
    public static final MutableLiveData<Boolean> a = null;

    static {
        a = new MutableLiveData();
    }

    public static boolean a() {
        Boolean r0 = (Boolean) a.getValue();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public static void b(final boolean r2) {
        a.setValue(Boolean.valueOf(r2));
        UtilityKotlinExtentionsKt.i(new ECFloatPanelExpandedUtils$updatePanelExpanded$1(r2));
    }
}
