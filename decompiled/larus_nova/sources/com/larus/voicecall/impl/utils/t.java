package com.larus.voicecall.impl.utils;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f2a.d f379556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f379557b = null;

    static {
        f379556a = new f2a.d("voice_call", "subtitle");
        f379557b = new LinkedHashMap();
    }

    public static final void a(String r100, long r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "uniTag");
        Intrinsics.checkNotNullParameter(r102, "block");
        Map<String, Long> r103 = f379557b;
        Long r104 = (Long) ((LinkedHashMap) r103).get(r100);
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L6:
        long r106 = SystemClock.elapsedRealtime();
        if ((r106 - r105) < r101) goto L10;
        r102.invoke();
        r103.put(r100, Long.valueOf(r106));
        return;
    L10:
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
