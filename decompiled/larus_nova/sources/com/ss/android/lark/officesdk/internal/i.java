package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle;
import com.ss.android.lark.officesdk.api.OfficeSDKHostSession;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements IOfficeSDKUserHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeSDKHostSession f433368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserManagerImpl f433369b;

    @Override // com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle
    public final OfficeSDKUserApi getUserApiOrNull() {
        return this.f433369b.j(this.f433368a);
    }

    public i(OfficeSDKHostSession r100, UserManagerImpl r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "userManager");
        this.f433368a = r100;
        this.f433369b = r101;
    }

    @Override // com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle
    public final Object awaitUserApi(long r100, Continuation<? super OfficeSDKUserApi> r101) {
        return this.f433369b.e(this.f433368a, r100, r101);
    }
}
