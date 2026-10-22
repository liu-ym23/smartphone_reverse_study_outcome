package com.bytedance.security.android.aopcheck.settings;

import android.content.Context;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.ss.android.lark.utils.statistics.PerfLog;
import g37.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/SettingContoller;", "", "()V", "initSettingSdk", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class SettingContoller {
    public static final SettingContoller INSTANCE = null;

    private SettingContoller() {
    }

    static {
        INSTANCE = new SettingContoller();
    }

    @JvmStatic
    public static final void initSettingSdk(final Context r100) {
        a r101 = a.c(Constant.KEY_SETTING_ID);
        r101.f479824a = new AnonymousClass1(r100);
        a.c(Constant.KEY_SETTING_ID).e(true);
    }
}
