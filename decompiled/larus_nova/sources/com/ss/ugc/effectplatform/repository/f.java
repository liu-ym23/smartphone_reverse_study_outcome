package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements IEffectPlatformBaseListener<CategoryPageModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f457501a;

    public f(g r100) {
        this.f457501a = r100;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(CategoryPageModel r100) {
        CategoryPageModel r101 = r100;
        IEffectPlatformBaseListener r102 = this.f457501a.f457505d;
        if (r102 == null) goto L6;
        r102.onSuccess(r101);
        return;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(CategoryPageModel r110, ExceptionResult r111) {
        g r112 = this.f457501a;
        r112.f457502a.b(r112.f457503b, r112.f457504c, 0, 0, 0, "0", false, null, r112.f457505d);
    }
}
