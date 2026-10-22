package com.bytedance.locallife.photo.album.model;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlbumViewModel f261976a;

    public c(AlbumViewModel r100) {
        this.f261976a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        l r101 = (l) r100;
        MutableLiveData<tv6.b> r102 = this.f261976a.getCommonBottomLynxInfo();
        m r103 = r101.a();
        List<n> r104 = null;
        if (r103 == null) goto L5;
        tv6.b r105 = r103.a();
    L6:
        r102.setValue(r105);
        MutableLiveData<List<n>> r106 = this.f261976a.getRightMoreItems();
        m r107 = r101.a();
        if (r107 == null) goto L9;
        r104 = r107.b();
    L9:
        r106.setValue(r104);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
