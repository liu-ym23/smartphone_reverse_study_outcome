package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.image.entity.Image;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Collections;

/* JADX INFO: loaded from: classes35.dex */
public final class u1 implements ObservableOnSubscribe<Image> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dcb.a f416581a;

    public u1(dcb.a r100) {
        this.f416581a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Image> r100) throws Exception {
        int[] r101 = com.ss.android.lark.utils.p.g(this.f416581a.f467909a);
        int r102 = r101[0];
        int r103 = 80;
        if (r102 > 0) goto L5;
        r102 = 80;
    L5:
        int r104 = r101[1];
        if (r104 <= 0) goto L9;
        r103 = r104;
    L9:
        Image r105 = new Image();
        r105.setWidth(r102);
        r105.setHeight(r103);
        r105.setToken(this.f416581a.f467910b);
        r105.setUrls(Collections.singletonList(this.f416581a.f467909a));
        r100.onNext(r105);
        r100.onComplete();
    }
}
