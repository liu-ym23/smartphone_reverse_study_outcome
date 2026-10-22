package com.bytedance.awemeopen.apps.framework.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static boolean a(t14.a r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (com.bytedance.awemeopen.infra.util.d.a(r2.g()) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r2.g(), 0)) == false) goto L11;
        return false;
    L11:
        return true;
    }
}
