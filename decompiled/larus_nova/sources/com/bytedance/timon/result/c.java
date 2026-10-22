package com.bytedance.timon.result;

import android.content.Intent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f270688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pair<Integer, Intent>> f270689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Function2<Integer, Intent, Unit>> f270690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f270691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String> f270692e;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f270688a = true;
        this.f270689b = new ConcurrentHashMap();
        this.f270690c = new ConcurrentHashMap();
        this.f270691d = new ConcurrentHashMap();
        this.f270692e = new ConcurrentHashMap();
    }

    public final void a(String r100) {
        Integer r101 = this.f270691d.get(r100);
        this.f270690c.remove(r100);
        this.f270691d.remove(r100);
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        this.f270689b.remove(Integer.valueOf(r102));
        this.f270692e.remove(Integer.valueOf(r102));
        return;
    }
}
