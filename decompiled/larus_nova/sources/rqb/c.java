package rqb;

import com.huawei.hms.api.FailedBinderCallBack;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements LarkLynxBridgeCallContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Class<?>, Object> f538960b;

    @Override // com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext
    public final String getCallId() {
        return this.f538959a;
    }

    @Override // com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) this.f538960b.invoke(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, Function1<? super Class<?>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "serviceProvider");
        this.f538959a = r100;
        this.f538960b = r101;
    }
}
