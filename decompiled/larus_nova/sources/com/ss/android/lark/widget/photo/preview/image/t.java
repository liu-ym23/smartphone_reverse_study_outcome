package com.ss.android.lark.widget.photo.preview.image;

import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public final class t<T> implements RxScheduledExecutor.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f446701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoItem f446702b;

    public t(n r100, PhotoItem r101) {
        this.f446701a = r100;
        this.f446702b = r101;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final Object produce() {
        return Boolean.valueOf(n.b(this.f446701a, this.f446702b));
    }
}
