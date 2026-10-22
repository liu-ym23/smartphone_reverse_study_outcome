package com.bytedance.helios.sdk.detector;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f245545b = null;

    @Override // com.bytedance.helios.sdk.detector.b
    public final int[] e() {
        return new int[0];
    }

    static {
        f245545b = new p();
        Iterator<T> r100 = e06.f.f470646b.values().iterator();     // Catch: Throwable -> L8
    L5:
        if (r100.hasNext() == false) goto L15;
        qz5.a r101 = (qz5.a) r100.next();     // Catch: Throwable -> L8
        p r102 = f245545b;     // Catch: Throwable -> L8
        int r103 = r101.f535345a;     // Catch: Throwable -> L8
        q r104 = new q(r101.f535348d, r101.f535347c, r101.f535345a);     // Catch: Throwable -> L8
        r102.f245516a.put(r103, r104);     // Catch: Throwable -> L8
        goto L5
    L15:
        return;
    L8:
        th = move-exception;
        hz5.l.b(new iz5.b(null, th, "label_custom_detector_init", null, 25));
    }

    public p() {
    }

    @Override // com.bytedance.helios.sdk.detector.b
    public final void g(PrivacyEvent r100) {
        hz5.l.b(r100);
    }

    @Override // com.bytedance.helios.sdk.detector.b
    public final void f(PrivacyEvent r100, Throwable r101) {
        HashMap<String, Integer> r102 = e06.f.f470645a;
        qz5.a r103 = e06.f.a(r100.f245366c);
        String r104 = p.class.getCanonicalName();
        String r105 = r100.f245367d;
        if (r103 == null) goto L5;
        String r106 = r103.f535347c;
    L6:
        b.c(r101, r104, r105, Intrinsics.stringPlus(r106, ".kt"));
        r100.b(r101);
        hz5.l.b(r100);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
