package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.passport.v1.GetWaterMarkResourceRequest;
import com.bytedance.lark.pb.passport.v1.GetWaterMarkResourceResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.base.watermark.IWatermarkable;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class WatermarkModuleV3 implements com.ss.android.lark.passportc.api.r, com.ss.android.lark.watermark.userscope.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f445382g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f445383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WatermarkImplFactoryV3 f445384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f445385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f445386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f445387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f445388f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f445389a = null;

        static {
            f445389a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("watermarkV3", "afterUserOnline");     // Catch: Throwable -> L4
            int r100 = WatermarkModuleV3.f445382g;     // Catch: Throwable -> L4
            ((com.ss.android.lark.watermark.userscope.c) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.watermark.userscope.c.class)).v7();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c extends com.ss.android.lark.appcontext.applifecycle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WatermarkModuleV3 f445390a;

        public c(WatermarkModuleV3 r100) {
            this.f445390a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (com.ss.android.lark.watermark.b.c() == false) goto L5;
            this.f445390a.getClass();
            com.ss.android.lark.watermark.b.b(r100);
        L5:
            Log.i("watermarkV3", "onActivityCreated: " + r100.getLocalClassName());
            this.f445390a.a(r100);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public final com.ss.android.lark.watermark.v2.o b() {
        return (UiThreadExecutionWatermarkImplV3) this.f445384b.f445347c.getValue();
    }

    public final boolean c() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) this.f445387e.getValue()).booleanValue() == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void v7() {
        if (this.f445386d == false) goto L6;
        Log.i("watermarkV3", "WatermarkModuleV3 isInitialized, return");
        return;
    L6:
        boolean r100 = true;
        this.f445386d = true;
        UiThreadExecutionWatermarkImplV3 r101 = (UiThreadExecutionWatermarkImplV3) b();
        r101.getClass();
        Log.i("watermarkV3", "UiThreadExecutionWatermarkImplV3 reset");
        j.a(r101.d(), new i(r101));
        AppLifecycle r102 = AppLifecycle.a.f408803a;
        r102.b(this.f445388f);
        UiThreadExecutionWatermarkImplV3 r103 = (UiThreadExecutionWatermarkImplV3) b();
        r103.getClass();
        Log.i("watermarkV3", "UiThreadExecutionWatermarkImplV3 initialize");
        j.a(r103.d(), new h(r103));
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L9;
    L11:
        r100 = false;
    L12:
        Iterator r104 = ((HashMap) r102.f408783f).values().iterator();
    L14:
        if (r104.hasNext() == false) goto L20;
        Activity r105 = (Activity) ((WeakReference) r104.next()).get();
        if (r105 == null) goto L14;
        if (r100 == false) goto L19;
        com.ss.android.lark.watermark.b.b(r105);
    L19:
        a(r105);
        goto L14
    L20:
        return;
    L9:
        if (com.ss.android.lark.watermark.b.c() == false) goto L11;
        goto L11
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final int s() {
        return ((UiThreadExecutionWatermarkImplV3) b()).s();
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final com.ss.android.lark.passportc.api.m getPassport() {
        return this.f445383a;
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void C4(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.ss.android.lark.watermark.v2.o r101 = b();
        Boolean r102 = Boolean.FALSE;
        UiThreadExecutionWatermarkImplV3 r103 = (UiThreadExecutionWatermarkImplV3) r101;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        WatermarkImplV3 r104 = r103.f445332a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == true) goto L9;
        if (r102 == null) goto L6;
    L8:
        r104.e(r104.f().b(), r100);
        return;
    L6:
        if (r104.g() == false) goto L8;
    L9:
        r104.e(r104.f().f(), r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void N0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (c() == false) goto L13;
        com.ss.android.lark.watermark.v2.o r101 = b();
        Boolean r102 = Boolean.TRUE;
        UiThreadExecutionWatermarkImplV3 r103 = (UiThreadExecutionWatermarkImplV3) r101;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        WatermarkImplV3 r104 = r103.f445332a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        if (Intrinsics.areEqual(r102, r102) == true) goto L11;
        if (r102 == null) goto L8;
    L10:
        r104.e(r104.f().b(), r100);
        return;
    L8:
        if (r104.g() == false) goto L10;
    L11:
        r104.e(r104.f().f(), r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Activity r100) {
        if ((r100 instanceof IWatermarkable) == true) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (c() == false) goto L12;
        com.ss.android.lark.watermark.v2.o r101 = b();
        UiThreadExecutionWatermarkImplV3 r102 = (UiThreadExecutionWatermarkImplV3) r101;
        r102.c(r100, Boolean.TRUE, null);
        return;
    L12:
        return;
    L5:
        if (((IWatermarkable) r100).enableGlobalWatermark() == true) goto L8;
        Log.i("watermarkV3", "attachWatermark mainActivity return");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        CoreThreadPool.getDefault().getUIExecutor().execute(b.f445389a);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void attachGlobalWatermark(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (c() == false) goto L6;
        com.ss.android.lark.watermark.v2.o r101 = b();
        UiThreadExecutionWatermarkImplV3 r102 = (UiThreadExecutionWatermarkImplV3) r101;
        r102.a(r100, Boolean.TRUE);
        return;
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void h6(com.ss.android.lark.watermark.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        UiThreadExecutionWatermarkImplV3 r101 = (UiThreadExecutionWatermarkImplV3) b();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        WatermarkImplV3 r102 = r101.f445332a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r102.f().h(r100);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void hf(com.ss.android.lark.watermark.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        UiThreadExecutionWatermarkImplV3 r101 = (UiThreadExecutionWatermarkImplV3) b();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        WatermarkImplV3 r102 = r101.f445332a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r102.f().d(r100);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i("watermarkV3", "onUserOffline");
        UiThreadExecutionWatermarkImplV3 r101 = (UiThreadExecutionWatermarkImplV3) b();
        r101.getClass();
        Log.i("watermarkV3", "UiThreadExecutionWatermarkImplV3 reset");
        j.a(r101.d(), new i(r101));
        AppLifecycle.a.f408803a.j(this.f445388f);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void qa(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        UiThreadExecutionWatermarkImplV3 r101 = (UiThreadExecutionWatermarkImplV3) b();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        WatermarkImplV3 r102 = r101.f445332a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        com.ss.android.lark.watermark.v2.t r103 = r102.f445354f.remove(r100);
        if (r103 == null) goto L9;
        Observer<com.ss.android.lark.watermark.v2.v> r104 = r103.f445554a.get();
        if (r104 == null) goto L7;
        r102.f().f().removeObserver(r104);
        r102.f().b().removeObserver(r104);
    L7:
        com.ss.android.lark.watermark.v2.q<?> r105 = r103.f445555b;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r105.a(r100);
        return;
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final WatermarkInfo z0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UiThreadExecutionWatermarkImplV3 r101 = (UiThreadExecutionWatermarkImplV3) b();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        WatermarkImplV3 r102 = r101.f445332a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r102.f().a();
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final String cd(@Nonnull String r110, @Nonnull String r111) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, "path");
        GetWaterMarkResourceRequest.Builder r100 = new GetWaterMarkResourceRequest.Builder();
        r100.path = r111;
        r100.scene = r110;
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, GetWaterMarkResourceResponse.ADAPTER, Command.GET_WATER_MARK_RESOURCE, null, null, null, null, 248);
        GetWaterMarkResourceResponse r113 = (GetWaterMarkResourceResponse) com.bytedance.lark.rustclient.api.t.c(this.f445385c.h(r112).execute(), WatermarkModuleV3$syncGetWatermarkResourceByPath$1.INSTANCE);
        if (r113 == null) goto L8;
        String r114 = r113.path;
        if (r114 != null) goto L7;
        return r111;
    L7:
        return r114;
    L8:
        return r111;
    }

    @Inject
    public WatermarkModuleV3(com.ss.android.lark.passportc.api.m r100, WatermarkImplFactoryV3 r101, com.bytedance.lark.rustclient.api.l r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "watermarkImplFactoryV3");
        Intrinsics.checkNotNullParameter(r102, "userRustClient");
        this.f445383a = r100;
        this.f445384b = r101;
        this.f445385c = r102;
        this.f445387e = LazyKt.lazy(WatermarkModuleV3$enableDoubaoWatermark$2.INSTANCE);
        this.f445388f = new c(this);
        com.ss.android.lark.passportc.api.s.a(this);
    }

    @Override // com.ss.android.lark.watermark.userscope.c
    public final void w0(String r110, String r111, ByteString r112, final IGetWaterMarkResourceCallback r113) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r113, "callback");
        GetWaterMarkResourceRequest.Builder r100 = new GetWaterMarkResourceRequest.Builder();
        r100.data = r112;
        r100.path = r111;
        r100.scene = r110;
        com.bytedance.lark.rustclient.api.d r114 = new com.bytedance.lark.rustclient.api.d(r100, GetWaterMarkResourceResponse.ADAPTER, Command.GET_WATER_MARK_RESOURCE, null, null, null, null, 248);
        com.bytedance.lark.rustclient.api.t.a(this.f445385c.h(r114).a(), new WatermarkModuleV3$getWaterMarkResource$1(r113), new WatermarkModuleV3$getWaterMarkResource$2(r113), new WatermarkModuleV3$getWaterMarkResource$3(r113));
    }
}
