package com.ss.android.lark.forsetiutils.leak;

import androidx.fragment.app.Fragment;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, WeakReference<Fragment>> f424774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f424775b = null;

    static {
        f424774a = new LinkedHashMap();
        new ReferenceQueue();
        f424775b = new LinkedHashMap();
    }
}
