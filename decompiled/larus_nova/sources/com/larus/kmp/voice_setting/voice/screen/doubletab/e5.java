package com.larus.kmp.voice_setting.voice.screen.doubletab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f354272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f354273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f354274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f354275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f354276e;

    public e5(n5 r100) {
        Intrinsics.checkNotNullParameter(r100, "logInfo");
        this.f354272a = r100;
        this.f354275d = new LinkedHashSet();
        this.f354276e = new LinkedHashMap();
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        return this.f354275d.contains(r100);
    }

    public final boolean a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Long r102 = (Long) ((LinkedHashMap) this.f354276e).get(r100);
        if (r102 != null) goto L6;
    L8:
        return false;
    L6:
        if (r102.longValue() != r101) goto L8;
        return true;
    }
}
