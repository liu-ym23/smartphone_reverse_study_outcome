package io.opentelemetry.sdk.trace;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f492794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ltc.b f492795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f492796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f492797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mtc.c f492798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Supplier<p> f492799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final io.opentelemetry.sdk.trace.samplers.e f492800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f492801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public volatile ltc.d f492802i;

    public s(ltc.f r100, d r101, mtc.c r102, n r103, io.opentelemetry.sdk.trace.samplers.c r104, List r105) {
        this.f492794a = new Object();
        this.f492802i = null;
        this.f492795b = r100;
        this.f492796c = r101;
        this.f492797d = r101 instanceof RandomIdGenerator;
        this.f492798e = r102;
        this.f492799f = r103;
        this.f492800g = r104;
        ArrayList r106 = new ArrayList();
        Iterator r107 = ((ArrayList) r105).iterator();
    L4:
        if (r107.hasNext() == false) goto L7;
        r106.add((q) r107.next());
        goto L4
    L7:
        if (r106.isEmpty() == false) goto L10;
        q r108 = f.f492751a;
    L13:
        this.f492801h = r108;
        return;
    L10:
        if (r106.size() != 1) goto L12;
        r108 = (q) ListProtector.get(r106, 0);
        goto L13
    L12:
        r108 = new e(new ArrayList(r106));
        goto L13
    }
}
