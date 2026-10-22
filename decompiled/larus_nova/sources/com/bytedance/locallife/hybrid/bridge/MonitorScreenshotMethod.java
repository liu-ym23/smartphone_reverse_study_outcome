package com.bytedance.locallife.hybrid.bridge;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/hybrid/bridge/MonitorScreenshotMethod;", "Lmt6/c;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "", "onResume", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-hybrid_release"}, k = 1, mv = {1, 4, 3})
public final class MonitorScreenshotMethod extends mt6.c implements LifecycleObserver, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f258988e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f258989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f258990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f258991d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonitorScreenshotMethod f258992a;

        public b(MonitorScreenshotMethod r100) {
            this.f258992a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MonitorScreenshotMethod r100 = this.f258992a;     // Catch: Throwable -> L11
            int r101 = MonitorScreenshotMethod.f258988e;     // Catch: Throwable -> L11
            Object r102 = r100.f258991d;     // Catch: Throwable -> L11
            Lifecycle r103 = null;
            if ((r102 instanceof LifecycleOwner) == false) goto L5;
            LifecycleOwner r104 = (LifecycleOwner) r102;     // Catch: Throwable -> L11
        L6:
            if (r104 == null) goto L8;
            r103 = r104.getLifecycle();     // Catch: Throwable -> L11
        L8:
            if (r103 == null) goto L14;
            r103.addObserver(this.f258992a);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L5:
            r104 = null;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "monitorScreenshot";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.f258990c = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        this.f258990c = false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        this.f258991d = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        v r100 = this.f258989b;
        if (r100 == null) goto L9;
        Context r101 = r100.f259054b;
        if (r101 == null) goto L9;
        ContentResolver r102 = r101.getContentResolver();
        if (r102 == null) goto L9;
        r102.unregisterContentObserver(r100);
    L9:
        this.f258989b = null;
    }

    public MonitorScreenshotMethod() {
        new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, final Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Context r103 = ou6.b.f526748a.getContext(r100);
        this.f258991d = r103;
        if ((r103 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r104 = (LifecycleOwner) r103;
    L6:
        if (r104 == null) goto L8;
        Lifecycle r105 = r104.getLifecycle();
    L9:
        if (r105 == null) goto L11;
        r105.addObserver(this);
    L11:
        Object r106 = r101.get(ReportConstant.COMMON_ACTION_TYPE);
        if ((r106 instanceof Integer) == false) goto L14;
        Integer r107 = (Integer) r106;
    L15:
        boolean r108 = false;
        if (r107 == null) goto L18;
        int r109 = r107.intValue();
    L19:
        if (r109 != 0) goto L21;
        v r110 = this.f258989b;
        if (r110 == null) goto L43;
        Context r111 = r110.f259054b;
        if (r111 == null) goto L43;
        ContentResolver r112 = r111.getContentResolver();
        if (r112 == null) goto L43;
        r112.unregisterContentObserver(r110);
    L43:
        this.f258989b = null;
    L44:
        r102.invoke(MapsKt.emptyMap());
        return;
    L21:
        if (r109 != 1) goto L44;
        if (this.f258989b != null) goto L26;
        this.f258989b = new v(new MonitorScreenshotMethod$registerMonitor$1(this, r101));
    L26:
        v r113 = this.f258989b;
        if (r113 == null) goto L44;
        Context r114 = r113.f259054b;
        if (r114 == null) goto L44;
        ContentResolver r115 = r114.getContentResolver();
        if (r115 == null) goto L44;
        Uri r116 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT <= 28) goto L35;
        r108 = true;
    L35:
        r115.registerContentObserver(r116, r108, r113);
        goto L44
    L18:
        r109 = 0;
        goto L19
    L14:
        r107 = null;
        goto L15
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
