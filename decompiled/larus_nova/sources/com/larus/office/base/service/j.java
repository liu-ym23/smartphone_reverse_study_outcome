package com.larus.office.base.service;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes29.dex */
public final class j implements IGetWaterMarkResourceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f361112a;

    @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
    public final void onGetFailed() {
        this.f361112a.invoke(null);
    }

    public j(uo9.h r100) {
        this.f361112a = r100;
    }

    @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
    public final void onGetSuccess(String r100, ByteString r101) {
        Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
        this.f361112a.invoke(r100);
    }
}
