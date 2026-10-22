package com.ss.android.lark.audit.userscope.auth;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class PermissionDataService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.storage.a f409526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f409529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f409530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f409531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f409532g;

    @Inject
    public PermissionDataService(com.ss.android.lark.storage.kv.storage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "globalKV");
        this.f409526a = r100;
        this.f409527b = "Authz_Permission_Repo";
        this.f409528c = "_perm_data";
        this.f409529d = "AuthSdkStrictMode";
        this.f409530e = "AuthSdkForceClear";
        this.f409531f = LazyKt.lazy(new PermissionDataService$kvRepo$2(this));
        this.f409532g = LazyKt.lazy(new PermissionDataService$auditModeSP$2(this));
    }
}
