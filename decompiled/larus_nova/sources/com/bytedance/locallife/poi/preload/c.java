package com.bytedance.locallife.poi.preload;

import android.util.LruCache;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LruCache<String, b> f264214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f264215b = null;

    static {
        f264215b = new ArrayList();
    }

    public static String a(PoiBundle r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.poiId + '_' + r100.enterMethod + '_' + r100.previousEnterFrom;
    }
}
