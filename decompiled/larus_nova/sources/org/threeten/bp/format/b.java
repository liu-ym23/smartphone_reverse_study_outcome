package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.b f526404b;

    public b(h.b r100) {
        this.f526404b = r100;
    }

    @Override // org.threeten.bp.format.f
    public final Iterator<Map.Entry<String, Long>> b(org.threeten.bp.temporal.f r100, TextStyle r101, Locale r102) {
        List r103 = (List) ((HashMap) this.f526404b.f526437b).get(r101);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.iterator();
    }

    @Override // org.threeten.bp.format.f
    public final String a(org.threeten.bp.temporal.f r100, long r101, TextStyle r102, Locale r103) {
        Map<Long, String> r104 = this.f526404b.f526436a.get(r102);
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.get(Long.valueOf(r101));
    }
}
