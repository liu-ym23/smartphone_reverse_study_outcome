package com.bytedance.ee.bear.imageviewer;

import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class d implements Function {
    public final /* synthetic */ ImageData a;

    public /* synthetic */ d(ImageData r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        ImageData r0 = this.a;
        String r4 = (String) r3;
        if (r0 != null) goto L5;
        return null;
    L5:
        e.a(r0.getImage());
        List<ImageData.Image> r5 = r0.getImageList();
        if (r5 != null) goto L8;
        return r0;
    L8:
        if (r5.isEmpty() == true) goto L16;
        Iterator<ImageData.Image> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L17;
        e.a(r6.next());
        goto L11
    L17:
        return r0;
    L16:
        return r0;
    }
}
