package com.bytedance.locallife.live.anchor;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f259150a;

    public f(List<String> r100) {
        this.f259150a = r100;
    }

    public static ImageRequest[] b(List r100) {
        List r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L20;
        String r105 = (String) r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r103.add(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r105)).build());
        goto L14
    L20:
        if (r103.size() != 0) goto L22;
        return null;
    L22:
        Object[] r106 = r103.toArray(new ImageRequest[0]);
        if (r106 == null) goto L27;
        return (ImageRequest[]) r106;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }
}
