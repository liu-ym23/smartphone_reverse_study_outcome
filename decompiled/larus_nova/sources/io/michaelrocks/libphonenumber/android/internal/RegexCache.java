package io.michaelrocks.libphonenumber.android.internal;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
public final class RegexCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LRUCache<String, Pattern> f492255a;

    public static class LRUCache<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<K, V> f492256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f492257b;

        public LRUCache(int r100) {
            this.f492257b = r100;
            final boolean r101 = true;
            final int r102 = ((r100 * 4) / 3) + 1;
            final float r103 = 0.75f;
            this.f492256a = new AnonymousClass1(this, r102, r103, r101);
        }

        public final synchronized void a(K r100, V r101) {
            monitor-enter(this);
            this.f492256a.put(r100, r101);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public RegexCache(int r100) {
        this.f492255a = new LRUCache(r100);
    }

    public final Pattern a(String r100) {
        LRUCache<String, Pattern> r101 = this.f492255a;
        monitor-enter(r101);
        Pattern r102 = r101.f492256a.get(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);
        Pattern r103 = r102;
        if (r103 != null) goto L15;
        Pattern r104 = PatternProtector.compile(r100);
        this.f492255a.a(r100, r104);
        return r104;
    L15:
        return r103;
    L10:
        th = move-exception;
        throw th;
    }
}
