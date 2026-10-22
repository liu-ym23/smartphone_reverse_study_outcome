package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, CloseableReference<CloseableImage>> f372044a;

    public final void b() {
        Iterator<T> r100 = this.f372044a.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = (String) r100.next();
        CloseableReference<CloseableImage> r102 = this.f372044a.get(r101);
        if (r102 == null) goto L4;
        CloseableReference.closeSafely(r102);
        goto L4
    L8:
        this.f372044a.clear();
    }

    public c() {
        this.f372044a = new ConcurrentHashMap();
    }

    public final void a(String r100, CloseableReference<CloseableImage> r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f372044a.put(r100, r101);
    }
}
