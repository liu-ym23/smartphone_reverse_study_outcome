package qh9;

import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f533012a = null;

    static {
        f533012a = new AtomicBoolean(false);
    }

    public static e3 a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.D();
        return x1.f346268a;
    L5:
        return null;
    }
}
