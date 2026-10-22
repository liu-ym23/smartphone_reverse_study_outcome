package com.ss.android.ugc.effectmanager.common.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/utils/EPUtils;", "", "()V", "getPlatformSDKVersion", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EPUtils {
    public static final EPUtils INSTANCE = null;

    private EPUtils() {
    }

    @JvmStatic
    public static final String getPlatformSDKVersion() {
        return "760.0.1.196-alpha.3";
    }

    static {
        INSTANCE = new EPUtils();
    }
}
