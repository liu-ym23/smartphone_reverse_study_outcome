package com.bytedance.badger.z;

import android.os.Build;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class l extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f199482a = null;

    static {
        f199482a = new l();
    }

    public l() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return "";
    L7:
        return Build.SOC_MODEL;
    }
}
