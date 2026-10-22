package com.ss.android.lark.chameleon.api;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.ReflectUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0015J!\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleon/api/AbsChameleonHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "getContext", "()Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "setContext", "(Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;)V", "name", "", "getName", "()Ljava/lang/String;", "createCallback", "Lcom/ss/android/lark/chameleon/api/Callback;", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "handle", "", HiAnalyticsConstant.Direction.REQUEST, "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/api/Callback;)V", "data", "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbsChameleonHandler<T> implements BridgeHandlerV2<T> {
    private IChameleonHandlerContext context;

    public AbsChameleonHandler() {
    }

    public abstract String getName();

    public final IChameleonHandlerContext getContext() {
        return this.context;
    }

    private final Callback createCallback(final CallBackFunction r100) {
        return new AnonymousClass1(r100);
    }

    public void handle(Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.error(new LarkAPIError(-1, "native handler not implement"));
    }

    public final void setContext(IChameleonHandlerContext r100) {
        this.context = r100;
    }

    @Override // com.ss.android.lark.chameleon.bridge.JSHandler
    public void handle(T r100, CallBackFunction r101) {
        Callback r102 = createCallback(r101);
        Class r103 = ReflectUtils.getGenericClass(this);
        if (r103 != null) goto L6;
        r103 = ReflectUtils.getGenericInterfaceClass(this);
    L6:
        if (Intrinsics.areEqual(r103, Unit.class) == true) goto L20;
        if (r100 != null) goto L18;
        r102.error(new LarkAPIError(-1, "params invalid can not parsed"));
        Log.e(getName(), "params invalid can not parsed");
        return;
    L18:
        handle(r100, r102);     // Catch: Throwable -> L16
        return;
    L16:
        r102.error(new LarkAPIError(-1, "handler call unknown error"));
        Log.e(getName(), "handler call unknown error");
        return;
    L20:
        handle(r102);     // Catch: Throwable -> L9
        return;
    L9:
        r102.error(new LarkAPIError(-1, "handler call unknown error"));
        Log.e(getName(), "handler call unknown error");
    }

    public void handle(T r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.error(new LarkAPIError(-1, "native handler not implement"));
    }
}
