package com.obric.assistant.live.island;

import androidx.collection.LruCache;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.livecard.api.entity.IslandSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f390117e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f390118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f390119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<IslandSession> f390120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LruCache<String, Boolean> f390121d;

    public static final class a {
    }

    static {
    }

    public final List<IslandSession> b() {
        Object r100 = this.f390119b;
        monitor-enter(r100);
        List<IslandSession> r101 = CollectionsKt.toList(this.f390120c);     // Catch: Throwable -> L7
        this.f390120c.clear();     // Catch: Throwable -> L7
        this.f390121d.evictAll();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public i() {
        this.f390118a = 2;
        this.f390119b = new Object();
        this.f390120c = new ArrayDeque();
        this.f390121d = new LruCache(10);
    }

    public final List<IslandSession> a(IslandSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Object r101 = this.f390119b;
        monitor-enter(r101);
        this.f390120c.addLast(r100);     // Catch: Throwable -> L14
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L14
    L6:
        if (this.f390120c.size() <= this.f390118a) goto L12;
        IslandSession r103 = this.f390120c.pollFirst();     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        r102.add(r103);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
        return r102;
    L14:
        th = move-exception;
        throw th;
    }

    public final IslandSession c(String r100, IslandSession r101) {
        Object r102 = this.f390119b;
        monitor-enter(r102);
        IslandSession r103 = null;
        if (r101 != null) goto L29;
        if (r100 != null) goto L37;
    L32:
        monitor-exit(r102);
        return r103;
    L37:
    L34:
        th = move-exception;
        throw th;
    L8:
        if ((!StringsKt.isBlank(r100)) == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L32;
        Iterator<IslandSession> r104 = this.f390120c.iterator();     // Catch: Throwable -> L34
    L15:
        if (r104.hasNext() == false) goto L25;
        IslandSession r105 = r104.next();     // Catch: Throwable -> L34
        IslandSession r106 = r105;     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L34
        JsonObject r107 = r106.getExt();     // Catch: Throwable -> L34
        if (r107 == null) goto L21;
        JsonElement r108 = r107.get("ext_task_id");     // Catch: Throwable -> L34
        if (r108 == null) goto L21;
        String r109 = r108.getAsString();     // Catch: Throwable -> L34
    L23:
        if (Intrinsics.areEqual(r109, r100) == false) goto L15;
    L26:
        r101 = r105;     // Catch: Throwable -> L34
        if (r101 != null) goto L29;
    L21:
        r109 = null;
        goto L23
    L25:
        r105 = null;
    L29:
        if (this.f390120c.remove(r101) == false) goto L32;
        r103 = r101;
        goto L32
    }
}
