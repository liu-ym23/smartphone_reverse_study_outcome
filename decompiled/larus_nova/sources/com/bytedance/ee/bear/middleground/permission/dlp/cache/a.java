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

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f233829c = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f233830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, DlpCacheModel.NodeData> f233831b;

    public final void a() {
        Map<String, DlpCacheModel.NodeData> r100 = this.f233831b.snapshot();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L14;
        final DlpCacheModel r101 = new DlpCacheModel();
        CopyOnWriteArrayList<DlpCacheModel.NodeData> r102 = new CopyOnWriteArrayList();
        Iterator<DlpCacheModel.NodeData> r103 = r100.values().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(r103.next());
        goto L8
    L10:
        r101.setData(r102);
        Flowable.just("").subscribeOn(d.b()).map(new i(this, r101)).subscribe(new g(), new j());
        return;
    }

    public a() {
        this.f233831b = new LruCache(50);
        String r100 = ((b0) org.koin.java.a.a(b0.class)).getUid();
        f233829c = r100;
        if (this.f233830a != null) goto L7;
        b(r100);
        return;
    }

    public final void b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        f233829c = r100;
        this.f233830a = new b("dlp_cache" + du5.b.g(r100));
    L6:
        Flowable.just("").subscribeOn(d.b()).map(new f(this)).subscribe(new mh5.g(), new h());
        return;
    L5:
        this.f233830a = new b("dlp_cache");
        goto L6
    }

    public final synchronized DlpCacheModel.NodeData c(String r100) {
        monitor-enter(this);
        DlpCacheModel.NodeData r101 = this.f233831b.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final void d(DlpPolicyModel r100, String r101, String r102) {
        DlpCacheModel.NodeData r103 = this.f233831b.get(r101);
        if (r103 != null) goto L6;
        r103 = new DlpCacheModel.NodeData();
    L6:
        if (r100.getPolicy() == null) goto L8;
        r100.getPolicy().setDlpUpdateTime(System.currentTimeMillis());
    L8:
        r103.setPolicyModel(r100);
        r103.setEntityType(r102);
        this.f233831b.put(r101, r103);
    }
}
