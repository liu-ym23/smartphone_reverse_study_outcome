package com.lynx.tasm.fontface;

import android.util.Pair;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer>> f383411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<FontFace> f383412b;

    public a() {
        this.f383411a = new ConcurrentLinkedQueue();
        this.f383412b = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
