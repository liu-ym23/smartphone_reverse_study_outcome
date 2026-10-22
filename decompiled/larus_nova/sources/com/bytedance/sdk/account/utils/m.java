package com.bytedance.sdk.account.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection<String> f269549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<String> f269550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Collection<String> f269551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection<String> f269552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f269553e;

    public final Collection<String> a() {
        if (this.f269553e == false) goto L11;
        if (Build.VERSION.SDK_INT < 24) goto L9;
        return ConcurrentHashMap.newKeySet(8);
    L9:
        return Collections.newSetFromMap(new ConcurrentHashMap(8));
    L11:
        return new CopyOnWriteArraySet();
    }

    public final void b(JSONArray r100) {
        this.f269550b.clear();
        if (r100 != null) goto L5;
        HashSet r101 = null;
    L13:
        if (r101 != null) goto L15;
        this.f269550b.addAll(this.f269552d);
    L17:
        if (this.f269553e == false) goto L25;
        monitor-enter(this);
        Collection<String> r102 = a();     // Catch: Throwable -> L22
        r102.addAll(this.f269549a);     // Catch: Throwable -> L22
        r102.addAll(this.f269550b);     // Catch: Throwable -> L22
        this.f269551c = r102;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L25:
        Collection<String> r103 = a();
        r103.addAll(this.f269549a);
        r103.addAll(this.f269550b);
        this.f269551c = r103;
        return;
    L15:
        this.f269550b.addAll(r101);
        goto L17
    L5:
        HashSet r104 = new HashSet();
        int r105 = 0;
    L7:
        if (r105 >= r100.length()) goto L12;
        String r106 = r100.optString(r105, "");
        if (TextUtils.isEmpty(r106) == true) goto L11;
        r104.add(r106);
    L11:
        r105 = r105 + 1;
        goto L7
    L12:
        r101 = r104;
        goto L13
    }

    public final void c(JSONArray r100) {
        if (this.f269553e == false) goto L11;
        monitor-enter(this);
        b(r100);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        b(r100);
    }

    public m(Collection<String> r100, Collection<String> r101, boolean r102) {
        this.f269553e = r102;
        if (r100 != null) goto L5;
        r100 = new HashSet();
    L5:
        this.f269552d = r100;
        Collection<String> r103 = a();
        this.f269549a = r103;
        Collection<String> r104 = a();
        this.f269550b = r104;
        this.f269551c = a();
        if (r101 == null) goto L11;
        if (r101.isEmpty() == true) goto L11;
        r103.addAll(r101);
    L11:
        if (r100.isEmpty() == true) goto L13;
        r104.addAll(r100);
    L13:
        if (r102 == false) goto L21;
        monitor-enter(this);
        Collection<String> r105 = a();     // Catch: Throwable -> L18
        r105.addAll(r103);     // Catch: Throwable -> L18
        r105.addAll(r104);     // Catch: Throwable -> L18
        this.f269551c = r105;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        Collection<String> r106 = a();
        r106.addAll(r103);
        r106.addAll(r104);
        this.f269551c = r106;
    }
}
