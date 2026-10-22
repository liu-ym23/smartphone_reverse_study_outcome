package com.bytedance.sdk.xbridge.cn.permission.idl_bridge;

import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IHostPermissionDepend f269952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f269953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<he7.a.c> f269954c;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r100, Map<String, ? extends PermissionState> r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        String r101 = "permitted";
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (r100 == true) goto L9;
        if (this.f269952a.isPermissionAllGranted(this.f269953b, new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}) == false) goto L9;
        CompletionBlock<he7.a.c> r102 = this.f269954c;
        XBaseModel r111 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r103 = (he7.a.c) r111;
        r103.setStatus("permitted");
        r103.setLocationStatus("unknown");
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r111, null, 2, null);
        return;
    L9:
        CompletionBlock<he7.a.c> r104 = this.f269954c;
        XBaseModel r105 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r106 = (he7.a.c) r105;
        if (r100 == true) goto L22;
        Intrinsics.checkNotNullParameter(r110, "result");
        Iterator<T> r107 = r110.values().iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        if (((PermissionState) r107.next()) != PermissionState.REJECTED) goto L14;
        boolean r108 = true;
    L19:
        if (r108 == true) goto L21;
        r101 = "undetermined";
        goto L22
    L21:
        r101 = "denied";
        goto L22
    L18:
        r108 = false;
    L22:
        r106.setStatus(r101);
        r106.setLocationStatus("unknown");
        CompletionBlock.DefaultImpls.onSuccess$default(r104, (XBaseResultModel) r105, null, 2, null);
    }

    public b(IHostPermissionDepend r100, Context r101, CompletionBlock<he7.a.c> r102) {
        this.f269952a = r100;
        this.f269953b = r101;
        this.f269954c = r102;
    }
}
