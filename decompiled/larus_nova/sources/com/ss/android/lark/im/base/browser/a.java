package com.ss.android.lark.im.base.browser;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements IImBrowserService {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final IImBrowserService.b createSecLinkHelper(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "title");
        Log.i("DefaultImBrowserService", "createSecLinkHelper ignored");
        return null;
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Log.i("DefaultImBrowserService", "openUrl ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void sendLinkClickEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "location");
        Log.i("DefaultImBrowserService", "sendLinkClickEvent ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101, int r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Log.i("DefaultImBrowserService", "openUrl ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101, int r102, Bundle r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r104, "docsArgs");
        Log.i("DefaultImBrowserService", "openUrl ignored");
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101, int r102, Bundle r103, Map<String, String> r104, Map<String, String> r105, Fragment r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r104, "docsArgs");
        Log.i("DefaultImBrowserService", "openUrl ignore");
    }
}
