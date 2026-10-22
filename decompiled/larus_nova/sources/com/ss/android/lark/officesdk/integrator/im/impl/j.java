package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class j implements IImBrowserService {
    @Inject
    public j() {
    }

    public static void a(Context r100, String r101) {
        Log.i("OfficeSdkImBrowserService", "openUrlByRouter url=" + r101);
        com.ss.android.lark.router.c.b(r100, r101);
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final IImBrowserService.b createSecLinkHelper(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "title");
        Log.i("OfficeSdkImBrowserService", "createSecLinkHelper ignored, url=" + r100 + ", title=" + r101);
        return null;
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r101);
        a(r100, r101);
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void sendLinkClickEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "location");
        Log.e("OfficeSdkImBrowserService", "sendLinkClickEvent ignored, scene=" + r100 + ", location=" + r101);
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101, int r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r101 + ", source=" + r102 + ", extraParams=" + r103);
        a(r100, r101);
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101, int r102, Bundle r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r104, "docsArgs");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r101 + ", source=" + r102 + ", extraParams=" + r103 + ", docsArgs=" + r104);
        a(r100, r101);
    }

    @Override // com.ss.android.lark.im.base.browser.IImBrowserService
    public final void openUrl(Context r100, String r101, int r102, Bundle r103, Map<String, String> r104, Map<String, String> r105, Fragment r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r104, "docsArgs");
        Log.i("OfficeSdkImBrowserService", "openUrl url=" + r101 + ", source=" + r102 + ", extraParams=" + r103 + ", docsArgs=" + r104 + ", extra=" + r105 + ", sourceFragment=" + r106);
        a(r100, r101);
    }
}
