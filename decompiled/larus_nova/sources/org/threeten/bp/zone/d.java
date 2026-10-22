package org.threeten.bp.zone;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<d> f526486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<String, d> f526487b = null;

    public abstract ZoneRules b(String r100, boolean r101);

    public abstract Set<String> c();

    static {
        f526486a = new CopyOnWriteArrayList();
        f526487b = new ConcurrentHashMap(512, 0.75f, 2);
        if (b.f526484a.getAndSet(true) == true) goto L13;
        AtomicReference<b> r100 = b.f526485b;
        b.C7103b r101 = new b.C7103b();
    L6:
        if (r100.compareAndSet(null, r101) == true) goto L10;
        if (r100.get() == null) goto L6;
    L10:
        b.f526485b.get().a();
        return;
    L13:
        throw new IllegalStateException("Already initialized");
    }

    public d() {
    }

    public static void d(d r100) {
        zwc.d.d(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Iterator<String> r101 = r100.c().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();
        zwc.d.d(r102, "zoneId");
        if (((d) ((ConcurrentHashMap) f526487b).putIfAbsent(r102, r100)) == null) goto L4;
        throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + r102 + ", currently loading from provider: " + r100);
    L10:
        f526486a.add(r100);
    }

    public static ZoneRules a(String r100, boolean r101) {
        zwc.d.d(r100, "zoneId");
        ConcurrentHashMap r102 = (ConcurrentHashMap) f526487b;
        d r103 = (d) r102.get(r100);
        if (r103 != null) goto L11;
        if (r102.isEmpty() == false) goto L9;
        throw new ZoneRulesException("No time-zone data files registered");
    L9:
        throw new ZoneRulesException("Unknown time-zone ID: ".concat(r100));
    L11:
        return r103.b(r100, r101);
    }
}
