package com.bytedance.ee.bear.middleground.permission.dlp.cache;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;
import fo5.d;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mh5.f;
import mh5.h;
import mh5.i;
import mh5.j;
import ml5.b;
import pc5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static String c = "";
    public b a;
    public final LruCache<String, DlpCacheModel.NodeData> b;

    public final void a() {
        Map<String, DlpCacheModel.NodeData> r0 = this.b.snapshot();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L14;
        final DlpCacheModel r1 = new DlpCacheModel();
        CopyOnWriteArrayList<DlpCacheModel.NodeData> r2 = new CopyOnWriteArrayList();
        Iterator<DlpCacheModel.NodeData> r3 = r0.values().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r2.add(r3.next());
        goto L8
    L10:
        r1.setData(r2);
        Flowable.just("").subscribeOn(d.b()).map(new i(this, r1)).subscribe(new g(), new j());
        return;
    }

    public a() {
        this.b = new LruCache(50);
        String r0 = ((b0) org.koin.java.a.a(b0.class)).getUid();
        c = r0;
        if (this.a != null) goto L7;
        b(r0);
        return;
    }

    public final void b(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        c = r4;
        this.a = new b("dlp_cache" + du5.b.g(r4));
    L6:
        Flowable.just("").subscribeOn(d.b()).map(new f(this)).subscribe(new mh5.g(), new h());
        return;
    L5:
        this.a = new b("dlp_cache");
        goto L6
    }

    public final synchronized DlpCacheModel.NodeData c(String r2) {
        monitor-enter(this);
        DlpCacheModel.NodeData r3 = this.b.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final void d(DlpPolicyModel r5, String r6, String r7) {
        DlpCacheModel.NodeData r0 = this.b.get(r6);
        if (r0 != null) goto L6;
        r0 = new DlpCacheModel.NodeData();
    L6:
        if (r5.getPolicy() == null) goto L8;
        r5.getPolicy().setDlpUpdateTime(System.currentTimeMillis());
    L8:
        r0.setPolicyModel(r5);
        r0.setEntityType(r7);
        this.b.put(r6, r0);
    }
}
