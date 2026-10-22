package com.ss.android.lark.widget.photo.preview.image;

import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;

/* JADX INFO: loaded from: classes38.dex */
public final class r<T> implements RxScheduledExecutor.Producer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f446696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoItem f446697b;

    public r(n r100, PhotoItem r101) {
        this.f446696a = r100;
        this.f446697b = r101;
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Producer
    public final Object produce() {
        return Boolean.valueOf(n.b(this.f446696a, this.f446697b));
    }
}
