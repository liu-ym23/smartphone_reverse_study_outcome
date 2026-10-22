package com.ss.android.lark.lynxkit.xbridge;

import android.app.Activity;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.huawei.hms.api.FailedBinderCallBack;
import com.lynx.tasm.LynxView;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolBuilderContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import g66.c;
import g66.d;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p56.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J'\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u0014¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntime;", "namespace", "", "<init>", "(Ljava/lang/String;)V", "finder", "Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitMethodFinder;", "contextProvider", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "configure", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", LynxViewpagerItem.BIND_ON_ATTACH, "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "registerLynxMethod", e.f25671s, "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "registerService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "service", "(Ljava/lang/Class;Ljava/lang/Object;)V", "loadMethod", "Lcom/ss/android/lark/lynxkit/xbridge/XBridge2To3Adapter;", "methodName", "createCallContext", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeCallContext;", "detach", "Companion", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridgeLynxKitRuntime implements ILarkLynxBridgeRuntime {
    public static final Companion Companion = null;
    private static final String TAG = "XBridgeLynxKitRuntime";
    private final c contextProvider;
    private XBridgeLynxKitMethodFinder finder;
    private final String namespace;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime$Companion;", "", "<init>", "()V", "TAG", "", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XBridgeLynxKitRuntime() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final LarkLynxBridgeCallContext createCallContext() {
        LarkLynxBridgeCallContext.a r100 = LarkLynxBridgeCallContext.Companion;
        String r101 = UUID.randomUUID().toString();
        Function1<Class<?>, Object> r102 = new C119231(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r102, "serviceProvider");
        return new rqb.c(r101, r102);
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle
    public void detach() {
        Throwable r100 = null;
        XBridgeLynxKitMethodFinder r101 = this.finder;     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        r101.release();     // Catch: Throwable -> L7
    L6:
        this.contextProvider.g();
        this.finder = null;
        Log.i(TAG, "detach");
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        throw r100;
    L7:
        th = move-exception;
        this.contextProvider.g();
        this.finder = null;
        Log.i(TAG, "detach");
        r100 = th;
        goto L9
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime
    public void dispose() {
        detach();
    }

    public XBridgeLynxKitRuntime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        this.namespace = r100;
        this.contextProvider = new c();
    }

    public static final /* synthetic */ c access$getContextProvider$p(XBridgeLynxKitRuntime r100) {
        return r100.contextProvider;
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime
    public void attach(final LarkLynxBridgeProtocolContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.finder == null) goto L13;
        this.contextProvider.e(LynxView.class, new d(r100.getLynxView()));
        if (this.contextProvider.b(b.class) == true) goto L8;
        this.contextProvider.e(b.class, new g66.b(new AnonymousClass1(r100)));
    L8:
        if (this.contextProvider.b(XBridgeMethod.b.class) == true) goto L10;
        this.contextProvider.e(XBridgeMethod.b.class, new g66.b(new XBridgeLynxJsEventDelegate(new AnonymousClass2(r100))));
    L10:
        Log.i(TAG, "attach: containerId=" + r100.getContainerId());
        return;
    L13:
        throw new IllegalStateException("XBridge method finder is not configured".toString());
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime
    public void configure(LarkLynxBridgeProtocolBuilderContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        XBridgeInitializer.ensureInitialized(r100.getContext());
        this.contextProvider.e(Context.class, new d(r100.getContext()));
        Context r101 = r100.getContext();
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r101;
    L6:
        if (r102 == null) goto L8;
        this.contextProvider.e(Activity.class, new d(r102));
    L8:
        ILynxContainerContext r103 = r100.getContainerContext();
        if (r103 == null) goto L11;
        this.contextProvider.e(ILynxContainerContext.class, new g66.b(r103));
    L11:
        XBridgeLynxKitMethodFinder r104 = new XBridgeLynxKitMethodFinder(this.contextProvider, this.namespace);
        r100.getLynxViewBuilder().registerModule("bridge", XBridgeLynxModule.class, this);
        this.finder = r104;
        Log.i(TAG, "configure: containerId=" + r100.getContainerId() + ", namespace=" + this.namespace);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final XBridge2To3Adapter loadMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        XBridgeLynxKitMethodFinder r101 = this.finder;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.loadMethod(r100);
    }

    public final void registerLynxMethod(XBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        XBridgeLynxKitMethodFinder r101 = this.finder;
        if (r101 == null) goto L6;
        r101.registerLynxMethod(r100);
        return;
    }

    public final <T> void registerService(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.contextProvider.e(r100, new g66.b(r101));
    }

    public /* synthetic */ XBridgeLynxKitRuntime(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
