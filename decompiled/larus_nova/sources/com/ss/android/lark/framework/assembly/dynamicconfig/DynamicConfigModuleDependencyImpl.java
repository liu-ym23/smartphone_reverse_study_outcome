package com.ss.android.lark.framework.assembly.dynamicconfig;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import hcb.a;
import yzb.b;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(a.class)
public class DynamicConfigModuleDependencyImpl implements a {
    private static final String TAG = "DynamicConfigModuleDependencyImpl";
    b mUserListApi;

    public DynamicConfigModuleDependencyImpl() {
    }

    private b getUserListApi() {
        if (this.mUserListApi != null) goto L6;
        this.mUserListApi = (b) LarkContext.spiByDwarf(b.class);
    L6:
        return this.mUserListApi;
    }

    @Override // hcb.a
    public int getEnv2Type() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).envType();
    }

    @Override // hcb.a
    public InitSDKRequest.EnvType getEnvType() {
        monitor-enter(DynamicConfigModuleDependencyImpl.class);
        int r100 = getEnv2Type();     // Catch: Throwable -> L22
        if (r100 != 1) goto L7;
        InitSDKRequest.EnvType r101 = InitSDKRequest.EnvType.ONLINE;     // Catch: Throwable -> L22
        monitor-exit(DynamicConfigModuleDependencyImpl.class);     // Catch: Throwable -> L22
        return r101;
    L7:
        if (r100 != 2) goto L9;
        InitSDKRequest.EnvType r102 = InitSDKRequest.EnvType.STAGING;     // Catch: Throwable -> L22
        monitor-exit(DynamicConfigModuleDependencyImpl.class);     // Catch: Throwable -> L22
        return r102;
    L9:
        if (r100 == 3) goto L13;
        InitSDKRequest.EnvType r103 = InitSDKRequest.EnvType.ONLINE;     // Catch: Throwable -> L22
        monitor-exit(DynamicConfigModuleDependencyImpl.class);     // Catch: Throwable -> L22
        return r103;
    L13:
        InitSDKRequest.EnvType r104 = InitSDKRequest.EnvType.PRE_RELEASE;     // Catch: Throwable -> L22
        monitor-exit(DynamicConfigModuleDependencyImpl.class);     // Catch: Throwable -> L22
        return r104;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // hcb.a
    public String getTenantBrand() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).getTenantBrand();
    }

    @Override // hcb.a
    public String getUserUnit() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).getUserUnit();
    }

    public boolean isLogin() {
        return ((b) LarkContext.spiByDwarf(b.class)).isLogin();
    }

    @Override // hcb.a
    public boolean isPrivateKA() {
        if (PackageChannelManager.isKABuildPackage(com.larksuite.framework.utils.b.f285948a) == true) goto L5;
    L7:
        return false;
    L5:
        if (PackageChannelManager.getDeployMode(com.larksuite.framework.utils.b.f285948a) == 1) goto L7;
        return true;
    }

    @Override // hcb.a
    public Context getContext() {
        return LarkContext.getApplication();
    }

    @Override // hcb.a
    public String getUserId() {
        return getUserListApi().c();
    }
}
