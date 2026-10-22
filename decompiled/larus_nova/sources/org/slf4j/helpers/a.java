package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements ywc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C7099a f526220a;

    /* JADX INFO: renamed from: org.slf4j.helpers.a$a, reason: collision with other inner class name */
    public class C7099a extends InheritableThreadLocal<Map<String, String>> {
        public C7099a() {
        }

        @Override // java.lang.InheritableThreadLocal
        public final Map<String, String> childValue(Map<String, String> r100) {
            Map<String, String> r101 = r100;
            if (r101 != null) goto L6;
            return null;
        L6:
            return new HashMap(r101);
        }
    }

    @Override // ywc.c
    public final Map<String, String> a() {
        Map<String, String> r100 = this.f526220a.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return new HashMap(r100);
    }

    @Override // ywc.c
    public final void clear() {
        Map<String, String> r100 = this.f526220a.get();
        if (r100 == null) goto L6;
        r100.clear();
        this.f526220a.remove();
        return;
    }

    public a() {
        new ThreadLocal();
        this.f526220a = new C7099a();
    }

    @Override // ywc.c
    public final void b(Map<String, String> r100) {
        if (r100 == null) goto L4;
        HashMap r101 = new HashMap(r100);
    L5:
        this.f526220a.set(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }
}
