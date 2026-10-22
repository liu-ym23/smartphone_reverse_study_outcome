package com.bytedance.android.shopping.mall.utils;

import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.api.mall.opt.e;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import yj.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallVideoPreLoader {
    public final HashSet<VideoCardData> a;
    public final Lazy b;
    public final Lazy c;
    public final Map<VideoCardData, String> d;

    public final void a() {
        if (((e) this.c.getValue()).c() == true) goto L5;
        return;
    L5:
        HashSet<VideoCardData> r0 = this.a;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        ArrayList r2 = new ArrayList(this.a);
        this.a.clear();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r3.add(b((VideoCardData) r4.next()));
        goto L16
    L18:
        d r5 = (d) this.b.getValue();
        if (r5 == null) goto L23;
        r5.a();
        return;
    L23:
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public ECMallVideoPreLoader() {
        this.a = new HashSet();
        this.b = LazyKt.lazy(ECMallVideoPreLoader$preLoader$2.INSTANCE);
        this.c = LazyKt.lazy(ECMallVideoPreLoader$videoPreloadConfig$2.INSTANCE);
        this.d = new LinkedHashMap();
    }

    public final String b(VideoCardData r3) {
        String r0 = (String) ((LinkedHashMap) this.d).get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Gson r1 = p.a;
        String r2 = p.c(r3.getVideo());
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.d.put(r3, r2);
        return r2;
    }
}
