package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Pair<String, String>, CopyOnWriteArrayList<WeakReference<a>>> f209089a = null;

    static {
        f209089a = new ConcurrentHashMap();
    }
}
