package com.larus.office.base.share;

import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi$Result;
import com.larus.utils.logger.FLogger;
import kotlin.Result;

/* JADX INFO: loaded from: classes29.dex */
public final class i implements ut5.a<UpdatePublicPermissionApi$Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f361143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f361144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f361145c;

    @Override // ut5.a
    public final void onResult(UpdatePublicPermissionApi$Result r100) {
        if (this.f361143a.isActive() == false) goto L6;
        kotlinx.coroutines.i<Boolean> r101 = this.f361143a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
        return;
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r101) {
        FLogger.f375446a.w("OfficeSdkSharePanelProvider", "updatePublicPermission(v2): failed, token=" + this.f361144b + ", docType=" + this.f361145c + ", code=" + r100, r101);
        if (this.f361143a.isActive() == false) goto L6;
        kotlinx.coroutines.i<Boolean> r102 = this.f361143a;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
        return;
    }

    public i(kotlinx.coroutines.j r100, String r101, int r102) {
        this.f361143a = r100;
        this.f361144b = r101;
        this.f361145c = r102;
    }
}
