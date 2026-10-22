package nwc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f521028a;

    public b(org.koin.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "_koin");
        this.f521028a = new ConcurrentHashMap();
    }
}
