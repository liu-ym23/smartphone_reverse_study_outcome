package com.ss.android.lark.chameleonv2.lkapi.biz.profile;

import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements RxScheduledExecutor.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BizProfile f411429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBizProfile$OpenProfileRequest f411430b;

    public a(BizProfile r100, IBizProfile$OpenProfileRequest r101) {
        this.f411429a = r100;
        this.f411430b = r101;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final Object produce() {
        h r100 = (h) this.f411429a.f411426a.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.ue(this.f411430b.getUserId());
    }
}
