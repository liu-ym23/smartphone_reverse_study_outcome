package com.bytedance.locallife.poi.memory;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f262947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<LifecycleOwner, Function0<Unit>> f262948b = null;

    public c() {
    }

    static {
        f262947a = new c();
        f262948b = new LinkedHashMap();
    }

    @Override // com.bytedance.locallife.poi.memory.d
    public final void a(FragmentActivity r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "onHighPressure");
        f262948b.put(r100, r101);
        r100.getLifecycle().addObserver(new b(r100));
    }
}
