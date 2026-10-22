package com.larus.bmhome.chat.helper;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f303099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<a, Unit> f303100b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set<String> f303101c;

    public interface a {
        void a(Set<String> r100);
    }

    static {
        f303099a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        new Handler(Looper.getMainLooper());
        new LinkedHashMap();
        f303100b = new WeakHashMap();
        f303101c = SetsKt.emptySet();
    }
}
