package com.bytedance.sdk.xbridge.cn.permission.idl_bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<he7.a.c> f269951a;

    public a(CompletionBlock<he7.a.c> r100) {
        this.f269951a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
    public final void onResult(boolean r100, Map<String, ? extends PermissionState> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        CompletionBlock<he7.a.c> r102 = this.f269951a;
        XBaseModel r103 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r104 = (he7.a.c) r103;
        if (r100 == false) goto L5;
        String r105 = "permitted";
    L15:
        r104.setStatus(r105);
        r104.setLocationStatus("unknown");
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r101, "result");
        Iterator<T> r106 = r101.values().iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        if (((PermissionState) r106.next()) != PermissionState.REJECTED) goto L7;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L14;
        r105 = "undetermined";
        goto L15
    L14:
        r105 = "denied";
        goto L15
    L11:
        r107 = false;
        goto L12
    }
}
