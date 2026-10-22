package com.larus.bmhome.chat.bubble.floating.runtime;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, pc8.e> f297556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f297557b;

    public l() {
        this.f297556a = new LinkedHashMap();
        this.f297557b = new LinkedHashMap();
    }

    public final synchronized pc8.e a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "promptId");     // Catch: Throwable -> L6
        pc8.e r101 = this.f297556a.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final pc8.e b(String r100) {
        String r101 = (String) ((LinkedHashMap) this.f297557b).get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        pc8.e r102 = this.f297556a.get(r101);
        if (r102 != null) goto L8;
    L11:
        this.f297557b.remove(r100);
        return null;
    L8:
        if (Intrinsics.areEqual(r102.f528577b.f528569b, r100) == false) goto L11;
        return r102;
    }

    public final synchronized void c(String r110, long r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "promptId");     // Catch: Throwable -> L24
        pc8.e r100 = this.f297556a.get(r110);     // Catch: Throwable -> L24
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        LinkedHashMap<String, pc8.e> r101 = this.f297556a;     // Catch: Throwable -> L24
        BubbleBannerState r102 = BubbleBannerState.VISIBLE;     // Catch: Throwable -> L24
        if (r100.f528581f == false) goto L11;
        long r103 = 0;
    L21:
        r101.put(r110, pc8.e.a(r100, r102, null, r103, false, false, true, null, null, null, null, 3947));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L11:
        Long r104 = Long.valueOf(r100.f528580e);     // Catch: Throwable -> L24
        if (r104.longValue() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L20;
        r103 = r104.longValue();     // Catch: Throwable -> L24
        goto L21
    L20:
        r103 = r111;
        goto L21
    L14:
        r105 = false;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(String r110, pc8.i r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "promptId");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r111, "transition");     // Catch: Throwable -> L11
        pc8.e r100 = this.f297556a.get(r110);     // Catch: Throwable -> L11
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f297556a.put(r110, pc8.e.a(r100, BubbleBannerState.ENTERING, null, 0, false, false, false, null, r111, null, null, 3579));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
