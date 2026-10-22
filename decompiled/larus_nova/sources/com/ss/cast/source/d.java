package com.ss.cast.source;

import com.byted.cast.common.config.IInitListener;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements IInitListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteCastSourceImpl f456570a;

    @Override // com.byted.cast.common.config.IInitListener
    public final void onFail(int r100, String r101, Exception r102) {
    }

    @Override // com.byted.cast.common.config.IInitListener
    public final void onSuccess() {
        this.f456570a.f456482b.d("ByteCastSourceImpl", "lelink bind success");
        ByteCastSourceImpl.f456478b0 = true;
    }

    public d(ByteCastSourceImpl r100) {
        this.f456570a = r100;
    }

    @Override // com.byted.cast.common.config.IInitListener
    public final void onError(int r100, String r101) {
        this.f456570a.f456482b.d("ByteCastSourceImpl", "lelink bind error");
        ByteCastSourceImpl.f456478b0 = false;
    }
}
