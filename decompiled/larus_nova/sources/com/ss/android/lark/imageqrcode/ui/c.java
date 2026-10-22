package com.ss.android.lark.imageqrcode.ui;

import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements RxScheduledExecutor.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ QRCodeShowParam f426658a;

    public c(QRCodeShowParam r100) {
        this.f426658a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final Object produce() {
        int r100 = com.ss.android.lark.imageqrcode.utils.a.f426671a;
        return com.ss.android.lark.imageqrcode.utils.a.a(this.f426658a.getPath());
    }
}
