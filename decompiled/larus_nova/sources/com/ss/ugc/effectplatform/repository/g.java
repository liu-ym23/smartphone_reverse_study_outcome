package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.EffectPlatform;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements IEffectPlatformBaseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f457502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f457503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f457504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IEffectPlatformBaseListener f457505d;

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(Boolean r210) {
        if (r210.booleanValue() == false) goto L5;
        this.f457502a.b(this.f457503b, this.f457504c, 0, 0, 0, "0", false, null, this.f457505d);
        return;
    L5:
        this.f457502a.b(this.f457503b, this.f457504c, 0, 0, 0, "0", true, null, new f(this));
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(Boolean r110, ExceptionResult r111) {
        this.f457502a.b(this.f457503b, this.f457504c, 0, 0, 0, "0", false, null, this.f457505d);
    }

    public g(e r100, String r101, String r102, EffectPlatform.d r103) {
        this.f457502a = r100;
        this.f457503b = r101;
        this.f457504c = r102;
        this.f457505d = r103;
    }
}
