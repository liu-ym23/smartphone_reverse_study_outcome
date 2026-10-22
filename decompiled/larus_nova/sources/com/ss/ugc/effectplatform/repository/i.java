package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IDownloadInfoStickerEffectProgressListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements hlc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDownloadInfoStickerEffectProgressListener f457507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InfoStickerEffect f457508b;

    @Override // hlc.d
    public final void onStart(Effect r100) {
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        IDownloadInfoStickerEffectProgressListener r101 = this.f457507a;
        if (r101 == null) goto L6;
        r101.onSuccess(this.f457508b);
        return;
    }

    public i(IDownloadInfoStickerEffectProgressListener r100, InfoStickerEffect r101) {
        this.f457507a = r100;
        this.f457508b = r101;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        IDownloadInfoStickerEffectProgressListener r102 = this.f457507a;
        if (r102 == null) goto L6;
        r102.onFail(this.f457508b, r101);
        return;
    }

    @Override // hlc.d
    public final void onProgress(Effect r100, int r101, long r102) {
        IDownloadInfoStickerEffectProgressListener r103 = this.f457507a;
        if (r103 == null) goto L6;
        r103.onProgress(this.f457508b, r101, r102);
        return;
    }
}
