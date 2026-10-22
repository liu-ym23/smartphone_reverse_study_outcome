package ou6;

import android.app.Activity;
import android.content.Context;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f526748a = null;

    static {
        f526748a = new b();
    }

    public b() {
    }

    public final Context getContext(IBDXBridgeContext r100) {
        if (r100 == null) goto L6;
        Activity r101 = r100.getOwnerActivity();
        if (r101 == null) goto L6;
        return r101;
    L6:
        ss6.c r102 = HostServiceUtilsKt.E();
        Activity r103 = r102.getCurrentActivity();
        if (r103 == null) goto L10;
        return r103;
    L10:
        return r102.getApplicationContext();
    }
}
