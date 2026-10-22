package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.internal.AttributesMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements jtc.i, g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Logger f492752t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f492753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jtc.k f492754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jtc.k f492755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f492756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Object> f492757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SpanKind f492759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f492760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final mtc.c f492761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ltc.e f492762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f492763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f492764l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f492765m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public AttributesMap f492766n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<ntc.c> f492767o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f492768p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ntc.b f492769q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f492770r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f492771s;

    static {
        f492752t = Logger.getLogger(h.class.getName());
    }

    public final c e() {
        Object r100 = this.f492764l;
        monitor-enter(r100);
        List<Object> r101 = this.f492757e;     // Catch: Throwable -> L29
        if (((ArrayList) this.f492767o).isEmpty() == false) goto L9;
        List r102 = Collections.emptyList();     // Catch: Throwable -> L29
    L7:
        List r103 = r102;
        AttributesMap r104 = this.f492766n;     // Catch: Throwable -> L29
        if (r104 != null) goto L15;
    L21:
        itc.g r105 = itc.b.f495767d;     // Catch: Throwable -> L29
    L22:
        itc.g r106 = r105;
        AttributesMap r107 = this.f492766n;     // Catch: Throwable -> L29
        if (r107 != null) goto L25;
        int r108 = 0;
    L26:
        c r110 = new c(this, r101, r103, r106, r108, this.f492768p, this.f492769q, this.f492765m, this.f492770r, this.f492771s);     // Catch: Throwable -> L29
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r110;
    L25:
        r108 = r107.getTotalAddedValues();     // Catch: Throwable -> L29
        goto L26
    L15:
        if (r104.isEmpty() == true) goto L21;
        if (this.f492771s == false) goto L20;
        r105 = this.f492766n;     // Catch: Throwable -> L29
        goto L22
    L20:
        r105 = this.f492766n.immutableCopy();     // Catch: Throwable -> L29
        goto L22
    L9:
        if (this.f492771s == false) goto L11;
        r102 = Collections.unmodifiableList(this.f492767o);     // Catch: Throwable -> L29
        goto L7
    L11:
        r102 = Collections.unmodifiableList(new ArrayList(this.f492767o));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    @Override // jtc.i
    public final void end() {
        long r100 = this.f492760h.a();
        Object r101 = this.f492764l;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f492771s == false) goto L9;
        f492752t.log(Level.FINE, "Calling end() on an ended Span.");     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L9:
        this.f492770r = r100;     // Catch: Throwable -> L13
        this.f492771s = true;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        this.f492756d.Yl(this);
    }

    public final String toString() {
        Object r100 = this.f492764l;
        monitor-enter(r100);
        String r101 = this.f492765m;     // Catch: Throwable -> L8
        String r102 = String.valueOf(this.f492766n);     // Catch: Throwable -> L8
        String r103 = String.valueOf(this.f492769q);     // Catch: Throwable -> L8
        long r104 = this.f492768p;     // Catch: Throwable -> L8
        long r105 = this.f492770r;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return "SdkSpan{traceId=" + ((io.opentelemetry.api.internal.b) this.f492754b).f492664b + ", spanId=" + ((io.opentelemetry.api.internal.b) this.f492754b).f492665c + ", parentSpanContext=" + this.f492755c + ", name=" + r101 + ", kind=" + this.f492759g + ", attributes=" + r102 + ", status=" + r103 + ", totalRecordedEvents=" + r104 + ", totalRecordedLinks=" + this.f492758f + ", startEpochNanos=" + this.f492763k + ", endEpochNanos=" + r105 + com.alipay.sdk.m.u.i.f25855d;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // jtc.i
    public final jtc.k b() {
        return this.f492754b;
    }

    @Override // jtc.i
    public final jtc.i c(String r100) {
        if (r100 == null) goto L5;
        long r101 = this.f492760h.a();
        d(new ntc.a(r100, itc.b.f495767d, r101, 0));
    L5:
        return this;
    }

    public final void d(ntc.a r100) {
        Object r101 = this.f492764l;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f492771s == false) goto L10;
        f492752t.log(Level.FINE, "Calling addEvent() on an ended Span.");     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L10:
        if (((ArrayList) this.f492767o).size() >= this.f492753a.e()) goto L12;
        ((ArrayList) this.f492767o).add(r100);     // Catch: Throwable -> L15
    L12:
        this.f492768p++;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
    }

    @Override // jtc.i
    public final jtc.i a(io.opentelemetry.api.internal.i r100, Object r101) {
        if (r100.f492676b.isEmpty() == true) goto L22;
        if (r101 == null) goto L22;
        Object r102 = this.f492764l;
        monitor-enter(r102);
    L19:
        th = move-exception;
        throw th;
    L9:
        if (this.f492771s == false) goto L14;
        f492752t.log(Level.FINE, "Calling setAttribute() on an ended Span.");     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        goto L22
    L14:
        if (this.f492766n != null) goto L16;
        this.f492766n = AttributesMap.create(this.f492753a.b(), this.f492753a.a());     // Catch: Throwable -> L19
    L16:
        this.f492766n.put(r100, r101);     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
    L22:
        return this;
    }

    public h(io.opentelemetry.api.internal.b r100, String r101, ltc.e r102, SpanKind r103, jtc.k r104, p r105, q r106, a r110, mtc.c r111, @Nullable AttributesMap r112, List r113, long r114) {
        this.f492764l = new Object();
        this.f492768p = 0;
        this.f492769q = ntc.e.f520574a;
        this.f492754b = r100;
        this.f492762j = r102;
        this.f492755c = r104;
        this.f492757e = r113;
        this.f492758f = 0;
        this.f492765m = r101;
        this.f492759g = r103;
        this.f492756d = r106;
        this.f492761i = r111;
        this.f492771s = false;
        this.f492760h = r110;
        this.f492763k = r114;
        this.f492766n = r112;
        this.f492767o = new ArrayList();
        this.f492753a = r105;
    }
}
