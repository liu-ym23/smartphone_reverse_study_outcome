package com.larus.kmp.voice_setting.voice.component;

import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes30.dex */
public final class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Object, q5> f352509a = null;

    static {
        f352509a = new LinkedHashMap();
    }

    public static q5 a(LifecycleOwner r100) {
        LinkedHashMap r101 = (LinkedHashMap) f352509a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new q5(r100);
        r101.put(r100, r102);
    L6:
        return (q5) r102;
    }
}
