package com.larus.bach.impl;

import com.larus.platform.api.creation.IBachService;
import com.larus.platform.api.creation.PreLoadScene;
import com.larus.utils.logger.FLogger;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements IEffectPlatformBaseListener<String[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreLoadScene f294832a;

    public h(PreLoadScene r100) {
        this.f294832a = r100;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        FLogger.f375446a.i("BachUtils", "scene:" + this.f294832a + " downloadModel onSuccess");
        if (this.f294832a != PreLoadScene.DIGITAL_AVTAR) goto L6;
        IBachService.f364935a.b().postValue(Boolean.TRUE);
        return;
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(String[] r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        FLogger.f375446a.e("BachUtils", "scene:" + this.f294832a + " downloadModel onFail, " + r101);
        if (this.f294832a != PreLoadScene.DIGITAL_AVTAR) goto L6;
        IBachService.f364935a.b().postValue(Boolean.FALSE);
        return;
    }
}
