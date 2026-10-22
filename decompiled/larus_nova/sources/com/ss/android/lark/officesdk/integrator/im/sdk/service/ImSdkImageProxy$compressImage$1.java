package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/officesdk/integrator/im/sdk/service/ImSdkImageProxy$compressImage$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/image/entity/ImageFileInfo;", "onSuccess", "", "imageFileInfo", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImSdkImageProxy$compressImage$1 implements IGetDataCallback<com.ss.android.lark.image.entity.d> {
    final /* synthetic */ IGetDataCallback<dcb.b> $callback;

    public ImSdkImageProxy$compressImage$1(IGetDataCallback<dcb.b> r100) {
        this.$callback = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        IGetDataCallback<dcb.b> r101 = this.$callback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void onSuccess(com.ss.android.lark.image.entity.d r100) {
        Intrinsics.checkNotNullParameter(r100, "imageFileInfo");
        File r101 = r100.f426349a;
        if (r101 == null) goto L5;
        String r102 = r101.getPath();
    L6:
        dcb.b r103 = new dcb.b(r102, r100.f426349a, r100.f426350b);
        IGetDataCallback<dcb.b> r104 = this.$callback;
        if (r104 == null) goto L10;
        r104.onSuccess(r103);
        return;
    L10:
        return;
    L5:
        r102 = "";
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((com.ss.android.lark.image.entity.d) r100);
    }
}
