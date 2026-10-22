package com.larus.home.impl.ug;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.i3;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
public final class UGReturnWindowManager implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UGReturnWindowManager f346281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Application f346282b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f346283c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f346284d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f346285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f346286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f346287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f346288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Job f346289i;

    public UGReturnWindowManager() {
    }

    static {
        f346281a = new UGReturnWindowManager();
        f346282b = AppHost.f326268a.getApplication();
        f346283c = LazyKt.lazy(new p());
        f346284d = LazyKt.lazy(new q());
    }

    @Override // com.larus.home.impl.ug.c
    public final void a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "currentActivity");
        FLogger r101 = FLogger.f375446a;
        r101.i("UGReturnWindowManager", "[remove] currentActivity:" + r100);
        if (ChatWindowServiceDelegate.f392926b.d(r100) == false) goto L7;
        r101.i("UGReturnWindowManager", "[remove] skip O window fake activity");
        return;
    L7:
        if (f346285e == false) goto L9;
        ((l) f346283c.getValue()).c(r100);
    L9:
        f346285e = false;
    }

    @Override // com.larus.home.impl.ug.c
    public final void b(Activity r110) {
        Intrinsics.checkNotNullParameter(r110, "currentActivity");
        FLogger r100 = FLogger.f375446a;
        r100.i("UGReturnWindowManager", "[add] currentActivity:" + r110);
        if (ChatWindowServiceDelegate.f392926b.d(r110) == false) goto L6;
        r100.i("UGReturnWindowManager", "[add] skip O window fake activity");
        return;
    L6:
        Map<String, String> r101 = d.f346291a;
        Intrinsics.checkNotNullParameter(r110, "activity");
        Job r102 = d.f346293c;
        if (r102 == null) goto L9;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L9:
        CoroutineScope r103 = d.f346292b;
        d.f346293c = BuildersKt.launch$default(r103, null, null, new UGReturnEventHelper$updateEventParams$1(r110, null), 3, null);
        if (r110.getIntent().getBooleanExtra("block_ug_return_button", false) == false) goto L17;
        r100.i("UGReturnWindowManager", "[add] block");
        Job r111 = d.f346293c;
        if (r111 == null) goto L14;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
    L14:
        d.f346293c = BuildersKt.launch$default(r103, null, null, new UGReturnEventHelper$updateEventParamsOnBlock$1(null), 3, null);
        f346286f = true;
        return;
    L17:
        if (f346286f == false) goto L19;
    L20:
        BuildersKt.launch$default(r103, null, null, new UGReturnEventHelper$onButtonShow$1(null), 3, null);
        f346286f = false;
        f346287g = false;
    L21:
        f346285e = true;
        ((l) f346283c.getValue()).a(r110);
        Job r112 = f346289i;
        if (r112 == null) goto L24;
        Job.DefaultImpls.cancel$default(r112, null, 1, null);
    L24:
        f346289i = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new UGReturnWindowManager$assertAttachToWindow$1(null), 3, null);
        return;
    L19:
        if (f346287g == false) goto L21;
        goto L20
    }

    public static boolean c(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        n.f346328a.getClass();
        boolean r102 = n.a(r100, r101);
        int r103 = 0;
        if (r102 == true) goto L5;
        return false;
    L5:
        if (f346288h == false) goto L8;
        FLogger.f375446a.w("UGReturnWindowManager", "[onDeeplinkReceived] activated");
        return false;
    L8:
        FLogger r104 = FLogger.f375446a;
        r104.i("UGReturnWindowManager", "[startShow]");
        f346288h = true;
        f346287g = true;
        Map<String, String> r105 = d.f346291a;
        r104.i("UGReturnEventHelper", "[resetEventParams]");
        d.f346295e = new d.a(r103);
        f346282b.registerActivityLifecycleCallbacks((o) f346284d.getValue());
        if (i3.f365750a.f() == false) goto L13;
        r104.i("UGReturnWindowManager", "[startShow] hit tourist mode, show immediately");
        Activity r106 = AppHost.f326268a.a().getCurrentActivity();
        if (r106 == null) goto L13;
        f346281a.b(r106);
    L13:
        return true;
    }
}
