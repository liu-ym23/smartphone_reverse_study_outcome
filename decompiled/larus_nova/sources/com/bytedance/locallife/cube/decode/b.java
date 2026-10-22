package com.bytedance.locallife.cube.decode;

import android.util.LruCache;
import com.bytedance.locallife.cube.api.model.DecodeInfo;
import com.bytedance.locallife.cube.api.model.DecodeRecord;
import com.bytedance.locallife.cube.api.model.GeckoInfo;
import com.bytedance.locallife.cube.c;
import fp6.e;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<GeckoInfo, DecodeInfo> f257197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, DecodeInfo> f257198b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<GeckoInfo, DecodeRecord> f257199c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, DecodeRecord> f257200d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<String>> f257201e = null;

    static {
        e r100 = c.a();
        int r101 = 30;
        if (r100 == null) goto L5;
        int r102 = ((com.bytedance.locallife.biz.base.cube.a) r100).a("poi_cube_pre_decode_cache_pool_size", 30);
    L6:
        f257197a = new LruCache(r102);
        e r103 = c.a();
        if (r103 == null) goto L9;
        r101 = ((com.bytedance.locallife.biz.base.cube.a) r103).a("poi_cube_pre_decode_cache_pool_size", 30);
    L9:
        f257198b = new LruCache(r101);
        f257199c = new ConcurrentHashMap();
        f257200d = new ConcurrentHashMap();
        f257201e = new ConcurrentHashMap();
        return;
    L5:
        r102 = 30;
        goto L6
    }

    public static DecodeInfo a(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L19;
        if (r101 != null) goto L12;
    L15:
        if (r102 == false) goto L18;
        return null;
    L18:
        return f257197a.get(new GeckoInfo(r100, r101));
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
        goto L15
    L19:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
