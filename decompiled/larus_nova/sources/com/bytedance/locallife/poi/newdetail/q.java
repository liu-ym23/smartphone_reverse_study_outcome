package com.bytedance.locallife.poi.newdetail;

import android.graphics.Typeface;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ep6.b f263292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Typeface> f263293b = null;

    static {
        ConcurrentHashMap<Class<?>, Object> r100 = LifeServiceManager.f162660a;
        f263292a = (ep6.b) LifeServiceManager.b(ep6.b.class);
        f263293b = new ConcurrentHashMap();
    }
}
