package com.bytedance.bdp.appbase.base.ui.viewwindow;

import android.app.Activity;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<WeakReference<g>> f200649a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Activity, Integer> f200650b = null;

    static {
        ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication().registerActivityLifecycleCallbacks(new e());
        f200649a = Collections.synchronizedList(new ArrayList());
        f200650b = new WeakHashMap();
    }
}
