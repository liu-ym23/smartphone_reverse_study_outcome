package kd7;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.checkAppsInfo")
public final class c extends a {
    public c() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a.c r102 = (a.c) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Activity r103 = r100.getOwnerActivity();
        if (r103 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "context can not convert to activity", null, 4, null);
        return;
    L5:
        List<String> r104 = r102.getPkg_list();
        Context r105 = r103.getApplicationContext();
        LinkedHashMap r106 = new LinkedHashMap();
        if (r104 != null) goto L42;
    L35:
        XBaseModel r107 = e.c(Reflection.getOrCreateKotlinClass(a.d.class));     // Catch: Throwable -> L37
        ((a.d) r107).setApps_info(r106);     // Catch: Throwable -> L37
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r107, null, 2, null);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "runtime exception: error message = " + th, null, 4, null);
        return;
    L42:
        Iterator<String> r108 = r104.iterator();     // Catch: Throwable -> L37
    L9:
        if (r108.hasNext() == false) goto L35;
        String r109 = r108.next();     // Catch: Throwable -> L37
        b r111 = new b();     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r109) == true) goto L34;
        PackageInfo r112 = r105.getPackageManager().getPackageInfo(r109, 0);     // Catch: Exception -> L33 Throwable -> L37
        if (r112 != null) goto L16;
        r111.f502853a = 0;     // Catch: Exception -> L33 Throwable -> L37
        goto L34
    L16:
        if (Build.VERSION.SDK_INT < 28) goto L18;
        r111.f502854b = String.valueOf(r112.getLongVersionCode());     // Catch: Exception -> L33 Throwable -> L37
    L19:
        String r113 = r112.versionName;     // Catch: Exception -> L33 Throwable -> L37
        if (r113 == null) goto L22;
        r111.f502855c = r113;     // Catch: Exception -> L33 Throwable -> L37
    L22:
        ApplicationInfo r114 = r112.applicationInfo;     // Catch: Exception -> L33 Throwable -> L37
        if (r114 != null) goto L25;
    L27:
        boolean r115 = false;
    L28:
        if (r115 == false) goto L30;
        r111.f502853a = 1;     // Catch: Exception -> L33 Throwable -> L37
        goto L34
    L30:
        r111.f502853a = 0;     // Catch: Exception -> L33 Throwable -> L37
        goto L34
    L25:
        if (r114.enabled != true) goto L27;
        r115 = true;
        goto L28
    L18:
        r111.f502854b = String.valueOf(r112.versionCode);     // Catch: Exception -> L33 Throwable -> L37
        goto L19
    L33:
        r111.f502853a = 0;     // Catch: Throwable -> L37
    L34:
        r106.put(r109, r111);     // Catch: Throwable -> L37
        goto L9
    }
}
