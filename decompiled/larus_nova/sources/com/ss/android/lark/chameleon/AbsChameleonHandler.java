package com.ss.android.lark.chameleon;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.officesdk.utils.ReflectUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "getContext", "()Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "setContext", "(Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "(Ljava/lang/Object;Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;)V", HiAnalyticsConstant.Direction.REQUEST, "Lcom/ss/android/lark/chameleon/Callback;", "(Ljava/lang/Object;Lcom/ss/android/lark/chameleon/Callback;)V", "createCallback", "authType", "Lcom/bytedance/ee/bear/jsbridge/auth/BridgeAuthType;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsChameleonHandler<T> implements i<T> {
    private IChameleonHandlerContext context;

    public AbsChameleonHandler() {
    }

    public abstract String getName();

    @Override // tb5.i, tb5.o
    public BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public final IChameleonHandlerContext getContext() {
        return this.context;
    }

    private final Callback createCallback(final m r100) {
        return new AnonymousClass1(r100);
    }

    public void handle(Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.error(new LKAPIError(-1, "native handler not implement"));
    }

    public final void setContext(IChameleonHandlerContext r100) {
        this.context = r100;
    }

    @Override // tb5.i, tb5.o
    public void handle(T r100, m r101) {
        Callback r102 = createCallback(r101);
        Class r103 = ReflectUtils.a(this);
        if (r103 != null) goto L6;
        r103 = ReflectUtils.b(this);
    L6:
        if (Intrinsics.areEqual(r103, Unit.class) == true) goto L20;
        if (r100 != null) goto L18;
        r102.error(new LKAPIError(-1, "params invalid can not parsed"));
        j.b(getName(), "params invalid can not parsed");
        return;
    L18:
        handle(r100, r102);     // Catch: Throwable -> L16
        return;
    L16:
        r102.error(new LKAPIError(-1, "handler call unknown error"));
        j.b(getName(), "handler call unknown error");
        return;
    L20:
        handle(r102);     // Catch: Throwable -> L9
        return;
    L9:
        r102.error(new LKAPIError(-1, "handler call unknown error"));
        j.b(getName(), "handler call unknown error");
    }

    public void handle(T r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.error(new LKAPIError(-1, "native handler not implement"));
    }
}
