package com.ss.android.lark.passport;

import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static boolean a() {
        return DevEnvUtil.isDebugMode(LarkAppContext.inst().getContext());
    }

    public static boolean b() {
        return LarkAppContext.inst().buildConfig().isMempopeApp();
    }
}
