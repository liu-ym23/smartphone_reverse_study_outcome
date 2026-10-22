package s47;

import android.text.TextUtils;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
public class a implements e47.b, l47.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f540615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f540616c;

    @Override // l47.c
    public void release() {
        if (this.f540615b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Enumeration<Object> r100 = this.f540616c.elements();
    L7:
        if (r100.hasMoreElements() == false) goto L13;
        Object r101 = r100.nextElement();     // Catch: Throwable -> L12
        if ((r101 instanceof l47.c) == false) goto L7;
        ((l47.c) r101).release();     // Catch: Throwable -> L12
        goto L7
    L13:
        this.f540616c.clear();
    }

    public a() {
        this.f540615b = new AtomicBoolean(false);
        this.f540616c = new ConcurrentHashMap();
    }

    @Override // e47.b
    public final String b(l47.c r100) {
        if (this.f540615b.get() == false) goto L6;
        return null;
    L6:
        String r101 = c(r100);
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.f540616c.putIfAbsent(r101, r100);
    L9:
        return r101;
    }

    public final String c(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.hashCode() + String.valueOf(hashCode());
    }

    @Override // e47.b
    public final Object get(String r100) {
        if (this.f540615b.get() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        return this.f540616c.get(r100);
    }

    @Override // e47.b
    public final Object remove(String r100) {
        if (this.f540615b.get() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        return this.f540616c.remove(r100);
    }

    @Override // e47.b
    public final String a(Object r100, String r101) {
        if (this.f540615b.get() == false) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
    L11:
        return null;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        this.f540616c.putIfAbsent(r101, r100);
        return r101;
    }
}
