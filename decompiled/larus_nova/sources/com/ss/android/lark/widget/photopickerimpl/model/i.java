package com.ss.android.lark.widget.photopickerimpl.model;

import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class i<T> implements RxScheduledExecutor.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<T> f447815a;

    public i(c<T> r100) {
        this.f447815a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final Object produce() {
        ArrayList r100 = new ArrayList(this.f447815a.f447792k);
        ((rdc.h) this.f447815a.f447784c).f537356a.b(r100);
        return r100;
    }
}
