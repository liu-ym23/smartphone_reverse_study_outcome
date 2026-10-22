package com.bytedance.gamecenter.base.order.cache;

import android.content.SharedPreferences;
import com.bytedance.gamecenter.base.r;
import com.bytedance.gamecenter.base.v;
import com.bytedance.gamecenter.base.w;
import com.google.gson.Gson;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class TriggerDownloadRecordCacheImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f245034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f245035b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TriggerDownloadRecordCacheImpl f245036c = null;

    public TriggerDownloadRecordCacheImpl() {
    }

    static {
        f245036c = new TriggerDownloadRecordCacheImpl();
        Lazy r100 = LazyKt.lazy(TriggerDownloadRecordCacheImpl$sp$2.INSTANCE);
        f245034a = r100;
        LinkedHashSet r101 = new LinkedHashSet();
        f245035b = r101;
        if (w.d() == false) goto L28;
        String r102 = ((SharedPreferences) r100.getValue()).getString("game_ids", "");
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("TriggerDownloadCache", "tag");
        boolean r104 = false;
        if (r102 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L29;
        Set r106 = (Set) new Gson().fromJson(r102, Set.class);     // Catch: Exception -> L23
        String.valueOf(r106);     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter("TriggerDownloadCache", "tag");     // Catch: Exception -> L23
        Set r107 = r106;     // Catch: Exception -> L23
        if (r107 != null) goto L17;
    L18:
        r104 = true;
    L19:
        if (r104 == true) goto L27;
        r101.addAll(r106);     // Catch: Exception -> L23
        Objects.toString(r101);     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter("TriggerDownloadCache", "tag");     // Catch: Exception -> L23
        return;
    L27:
        return;
    L17:
        if (r107.isEmpty() == false) goto L19;
    L23:
        Intrinsics.checkNotNullParameter("TriggerDownloadCache", "tag");
        return;
    L29:
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r105 = false;
        goto L12
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L24;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L22:
        monitor-exit(this);
        return;
    L11:
        if (w.d() == false) goto L22;
        Set<String> r102 = f245035b;     // Catch: Throwable -> L15 Exception -> L17
        r102.remove(r100);     // Catch: Throwable -> L15 Exception -> L17
        ((SharedPreferences) f245034a.getValue()).edit().putString("game_ids", v.a(r102)).apply();     // Catch: Throwable -> L15 Exception -> L17
        Objects.toString(r102);     // Catch: Throwable -> L15 Exception -> L17
        boolean r103 = r.f245056a;     // Catch: Throwable -> L15 Exception -> L17
        Intrinsics.checkNotNullParameter("TriggerDownloadCache", "tag");     // Catch: Throwable -> L15 Exception -> L17
    L18:
        monitor-exit(this);
        return;
    L17:
        boolean r104 = r.f245056a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter("TriggerDownloadCache", "tag");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L24:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
