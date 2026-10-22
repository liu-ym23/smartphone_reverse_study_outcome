package com.ss.android.lark.gadget.lifecycle.launch.entrance;

import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import java.util.Locale;
import njb.a;

/* JADX INFO: loaded from: classes36.dex */
public interface IAppbrandSupport {
    String getTmaJssdkVersion(Context r100, IAppContext r101);

    String getTmaJssdkVersion(IAppContext r100);

    boolean isSDKSupport();

    boolean isSDKSupport(Context r100);

    void openAppbrand(Context r100, a r101);

    void openAppbrand(a r100);

    boolean openShortcut(Intent r100);

    void preloadEmptyProcess();

    void switchLang(Locale r100);
}
