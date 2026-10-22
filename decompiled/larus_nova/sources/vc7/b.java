package vc7;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<a>> f554126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f554127b;

    public b() {
        this.f554126a = new ConcurrentHashMap();
        this.f554127b = new ConcurrentHashMap();
    }
}
