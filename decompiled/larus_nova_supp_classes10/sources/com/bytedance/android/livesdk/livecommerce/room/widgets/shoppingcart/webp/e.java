package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp;

import android.text.TextUtils;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends yk2.d {
    public final List<String> a;

    @Override // yk2.d
    public final <T> T a() {
        if (this.a == null) goto L41;
        List<String> r0 = this.a;
        if (r0 != null) goto L8;
    L30:
        ImageRequest[] r1 = null;
    L32:
        if ((r1 instanceof Object) == true) goto L35;
        return null;
    L35:
        return (T) r1;
    L8:
        if (r0.size() == 0) goto L30;
        if (ECLiveImageUtils.k() == false) goto L19;
        Pair r2 = ImageExtensionsKt.m(r0, null, null, null, null);
        if (r2 == null) goto L19;
        if (r2.getFirst() == null) goto L19;
        if (((List) r2.getFirst()).isEmpty() == true) goto L19;
        r1 = (ImageRequest[]) ((List) r2.getFirst()).toArray(new ImageRequest[0]);
    L19:
        ArrayList r3 = new ArrayList();
        Iterator<String> r4 = r0.iterator();
    L21:
        if (r4.hasNext() == false) goto L27;
        String r5 = r4.next();
        if (TextUtils.isEmpty(r5) == true) goto L21;
        r3.add(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r5)).build());
        goto L21
    L27:
        if (r3.size() == 0) goto L30;
        r1 = (ImageRequest[]) r3.toArray(new ImageRequest[r3.size()]);
        goto L32
    L41:
        return null;
    }

    @Override // yk2.d
    public final List<String> b() {
        return this.a;
    }

    public e(List<String> r1) {
        this.a = r1;
    }
}
