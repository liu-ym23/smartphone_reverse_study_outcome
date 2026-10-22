package com.ss.android.lark.sticker.core.impl;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$uploadStickers$2$1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends dlb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f440815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<com.ss.android.lark.image.uploader.entity.b> f440816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<c6c.b> f440817c;

    @Override // dlb.b
    public final void a(List<com.ss.android.lark.image.uploader.entity.b> r110, com.ss.android.lark.image.uploader.entity.c r111) {
        Intrinsics.checkNotNullParameter(r110, "imageList");
        Intrinsics.checkNotNullParameter(r111, "result");
        long r100 = SystemClock.elapsedRealtime() - this.f440815a;
        int r112 = com.ss.android.lark.sticker.core.utils.b.f440837a;
        com.ss.android.lark.sticker.core.utils.b.a(com.ss.android.lark.sticker.core.utils.b.a.C5303a.f440838a, this.f440816b.size(), r100, 0, null);
        Log.i("CustomStickerService", "uploadStickers success, size=" + this.f440816b.size());
        this.f440817c.onSuccess(new c6c.b(new ArrayList(), r111.f426411b));
    }

    @Override // dlb.b
    public final void i(int r110, String r111) {
        Log.e("CustomStickerService", "uploadStickers fail, errorCode=" + r110 + ", errorMsg=" + r111);
        long r100 = SystemClock.elapsedRealtime() - this.f440815a;
        int r101 = com.ss.android.lark.sticker.core.utils.b.f440837a;
        com.ss.android.lark.sticker.core.utils.b.a.C5303a r102 = com.ss.android.lark.sticker.core.utils.b.a.C5303a.f440838a;
        int r103 = this.f440816b.size();
        if (r110 != 0) goto L5;
        int r104 = -1;
    L6:
        com.ss.android.lark.sticker.core.utils.b.a(r102, r103, r100, r104, r111);
        IGetDataCallback<c6c.b> r105 = this.f440817c;
        Exception r106 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r107 = new ErrorResult(0);
        ErrorResult.access$002(r107, r110);
        ErrorResult.access$102(r107, -9999);
        ErrorResult.access$202(r107, 0);
        ErrorResult.access$302(r107, r106);
        ErrorResult.access$402(r107, "");
        ErrorResult.access$502(r107, r111);
        ErrorResult.access$602(r107, r111);
        ErrorResult.access$702(r107, "");
        ErrorResult.access$802(r107, 0);
        ErrorResult.access$902(r107, null);
        ErrorResult.access$1002(r107, null);
        ErrorResult.access$1102(r107, null);
        r105.onError(r107);
        return;
    L5:
        r104 = r110;
        goto L6
    }

    public e(long r100, List r101, OfficeCustomStickerModel$uploadStickers$2$1 r102) {
        this.f440815a = r100;
        this.f440816b = r101;
        this.f440817c = r102;
    }
}
