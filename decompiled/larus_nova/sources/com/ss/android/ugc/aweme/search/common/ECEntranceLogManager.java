package com.ss.android.ugc.aweme.search.common;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ECEntranceLogManager;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEntranceLogManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f451374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f451375b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ECEntranceLogManager f451376c = null;

    private ECEntranceLogManager() {
    }

    static {
        f451376c = new ECEntranceLogManager();
        f451375b = new LinkedHashSet();
    }

    @JvmStatic
    public static final String b() {
        ECEntranceLogManager r100 = f451376c;
        monitor-enter(r100);
        String r101 = f451374a;     // Catch: Throwable -> L10
        if (r101 != null) goto L7;
        r101 = UUID.randomUUID().toString();     // Catch: Throwable -> L10
    L7:
        f451374a = r101;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public static void a(int r100) {
        Set<Integer> r101 = f451375b;
        if (r101.remove(Integer.valueOf(r100)) == true) goto L5;
        return;
    L5:
        if (r101.isEmpty() == false) goto L9;
        f451374a = null;
        return;
    }
}
