package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IDownloadInfoStickerEffectProgressListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements hlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDownloadInfoStickerEffectProgressListener f457509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InfoStickerEffect f457510b;

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(ProviderEffect r100) {
        IDownloadInfoStickerEffectProgressListener r101 = this.f457509a;
        if (r101 == null) goto L6;
        r101.onSuccess(this.f457510b);
        return;
    }

    public j(IDownloadInfoStickerEffectProgressListener r100, InfoStickerEffect r101) {
        this.f457509a = r100;
        this.f457510b = r101;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(ProviderEffect r100, ExceptionResult r101) {
        IDownloadInfoStickerEffectProgressListener r102 = this.f457509a;
        if (r102 == null) goto L6;
        r102.onFail(this.f457510b, r101);
        return;
    }

    @Override // hlc.b
    public final void onProgress(ProviderEffect r100, int r101, long r102) {
        IDownloadInfoStickerEffectProgressListener r103 = this.f457509a;
        if (r103 == null) goto L6;
        r103.onProgress(this.f457510b, r101, r102);
        return;
    }
}
