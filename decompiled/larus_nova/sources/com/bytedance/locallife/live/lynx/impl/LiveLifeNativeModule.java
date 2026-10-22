package com.bytedance.locallife.live.lynx.impl;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/live/lynx/impl/LiveLifeNativeModule;", "Lcom/lynx/jsbridge/LynxModule;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", NotificationCompat.CATEGORY_CALL, "", "methodName", "", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "callSync", "Lcom/lynx/react/bridge/WritableMap;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveLifeNativeModule extends LynxModule {
    private final Context context;

    public final Context getContext() {
        return this.context;
    }

    public LiveLifeNativeModule(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.context = r100;
    }

    @LynxMethod
    public final WritableMap callSync(String r100, ReadableMap r101) {
        JavaOnlyMap r102 = new JavaOnlyMap();
        ConcurrentHashMap<Class<?>, Object> r103 = LifeServiceManager.f162660a;
        com.bytedance.locallife.live.service.a r104 = (com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class);
        if (r101 == null) goto L5;
        HashMap<String, Object> r105 = r101.toHashMap();
    L6:
        r102.putAll(r104.e(r100, r105));
        return r102;
    L5:
        r105 = null;
        goto L6
    }

    @LynxMethod
    public final void call(String r100, ReadableMap r101, final Callback r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        ConcurrentHashMap<Class<?>, Object> r103 = LifeServiceManager.f162660a;
        com.bytedance.locallife.live.service.a r104 = (com.bytedance.locallife.live.service.a) LifeServiceManager.b(com.bytedance.locallife.live.service.a.class);
        if (r101 == null) goto L5;
        HashMap<String, Object> r105 = r101.toHashMap();
    L6:
        r104.f(r100, r105, new AnonymousClass1(r102));
        return;
    L5:
        r105 = null;
        goto L6
    }
}
