package com.bytedance.ee.bear.imageviewer;

import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageData f226878a;

    public /* synthetic */ d(ImageData r100) {
        this.f226878a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ImageData r101 = this.f226878a;
        String r102 = (String) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        e.a(r101.getImage());
        List<ImageData.Image> r103 = r101.getImageList();
        if (r103 != null) goto L8;
        return r101;
    L8:
        if (r103.isEmpty() == true) goto L16;
        Iterator<ImageData.Image> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L17;
        e.a(r104.next());
        goto L11
    L17:
        return r101;
    L16:
        return r101;
    }
}
