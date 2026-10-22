package com.larus.dorag.widget;

import android.app.Application;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.dorag.widget.provider.DoraWidget2x2Provider;
import com.larus.dorag.widget.provider.DoraWidget4x2Provider;
import com.larus.dorag.widget.provider.DoraWidgetDiaryProvider;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f340998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f340999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f341000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f341001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f341002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f341003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f341004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f341005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static e f341006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static d f341007j;

    public f() {
    }

    static {
        f340998a = "";
    }

    public static void a() {
        if (f341000c == false) goto L6;
        FLogger.f375446a.i("DoraWidgetCenter", "screen is off, cancel refresh widget");
        return;
    L6:
        Application r100 = AppHost.f326268a.getApplication();
        Intent r101 = new Intent(r100, DoraWidget4x2Provider.class);
        r101.setAction("com.larus.avlink.impl.ACTION_DORA_WIDGET_4X2_REFRESH");
        r100.sendBroadcast(r101);
        Intent r102 = new Intent(r100, DoraWidget2x2Provider.class);
        r102.setAction("com.larus.avlink.impl.ACTION_DORA_WIDGET_2X2_REFRESH");
        r100.sendBroadcast(r102);
        Intent r103 = new Intent(r100, DoraWidgetDiaryProvider.class);
        r103.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        r100.sendBroadcast(r103);
        FLogger.f375446a.i("DoraWidgetCenter", "send broadcast to refresh widget");
    }
}
