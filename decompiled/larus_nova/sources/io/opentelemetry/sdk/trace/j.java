package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.trace.samplers.SamplingDecision;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class j implements jtc.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f492773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ltc.e f492774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f492775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f492776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public io.opentelemetry.context.b f492777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SpanKind f492778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public AttributesMap f492779g;

    @Override // jtc.j
    public final jtc.i a() {
        io.opentelemetry.context.b r100 = this.f492777e;
        if (r100 != null) goto L8;
        io.opentelemetry.context.c r101 = io.opentelemetry.context.g.f492702b;
        io.opentelemetry.context.b r102 = r101.current();
        if (r102 == null) goto L7;
        r100 = r102;
        goto L8
    L7:
        r100 = r101.root();
    L8:
        jtc.i r103 = jtc.h.a(r100);
        jtc.k r104 = r103.b();
        d r105 = this.f492775c.f492796c;
        String r110 = r105.generateSpanId();
        io.opentelemetry.api.internal.b r111 = (io.opentelemetry.api.internal.b) r104;
        if (r111.f492669g == true) goto L11;
        String r106 = r105.generateTraceId();
    L12:
        String r112 = r106;
        List<Object> r210 = Collections.emptyList();
        itc.g r107 = this.f492779g;
        if (r107 != null) goto L15;
        r107 = itc.b.f495767d;
    L15:
        itc.g r108 = r107;
        io.opentelemetry.context.b r109 = r100;
        io.opentelemetry.sdk.trace.samplers.a r113 = (io.opentelemetry.sdk.trace.samplers.a) this.f492775c.f492800g.shouldSample(r109, r112, this.f492773a, this.f492778f, r108, r210);
        SamplingDecision r114 = r113.f492806c;
        jtc.n r115 = r111.f492667e;
        SamplingDecision r116 = SamplingDecision.RECORD_AND_SAMPLE;
        if (r116.equals(r114) == false) goto L18;
        jtc.f r117 = jtc.f.f500394d;
    L19:
        jtc.f r118 = r117;
        if (this.f492775c.f492797d == true) goto L55;
        if (r110 != null) goto L23;
    L35:
        boolean r119 = false;
    L36:
        if (r119 == false) goto L54;
        if (r112 != null) goto L39;
    L51:
        boolean r120 = false;
    L52:
        if (r120 == false) goto L54;
    L39:
        if (r112.length() != 32) goto L51;
        if ("00000000000000000000000000000000".contentEquals(r112) == true) goto L51;
        char[] r121 = io.opentelemetry.api.internal.j.f492678a;
        int r122 = r112.length();
        int r123 = 0;
    L43:
        if (r123 >= r122) goto L48;
        char r124 = r112.charAt(r123);
        if (io.opentelemetry.api.internal.j.f492679b[r124] == false) goto L46;
        r123 = r123 + 1;
        goto L43
    L46:
        boolean r125 = false;
    L49:
        if (r125 == false) goto L51;
        r120 = true;
        goto L52
    L48:
        r125 = true;
    L54:
        io.opentelemetry.api.internal.b r126 = new io.opentelemetry.api.internal.b("00000000000000000000000000000000", "0000000000000000", r118, r115, false);
    L56:
        io.opentelemetry.api.internal.b r127 = r126;
        if (SamplingDecision.RECORD_ONLY.equals(r114) == false) goto L59;
    L62:
        boolean r128 = true;
    L63:
        if (r128 == false) goto L65;
        itc.g r129 = r113.f492807d;
        if (r129.isEmpty() == true) goto L72;
        r129.forEach(new i(this));
    L72:
        AttributesMap r130 = this.f492779g;
        this.f492779g = null;
        String r131 = this.f492773a;
        ltc.e r132 = this.f492774b;
        SpanKind r133 = this.f492778f;
        p r134 = this.f492776d;
        s r135 = this.f492775c;
        q r136 = r135.f492801h;
        ltc.b r137 = r135.f492795b;
        mtc.c r138 = r135.f492798e;
        Logger r139 = h.f492752t;
        if ((r103 instanceof h) == false) goto L75;
        a r140 = ((h) r103).f492760h;
        boolean r141 = false;
    L76:
        if (r141 == false) goto L78;
        long r142 = r140.f492729b;
    L79:
        jtc.k r143 = r103.b();
        a r211 = r140;
        h r144 = new h(r127, r131, r132, r133, r143, r134, r136, r211, r138, r130, r210, r142);
        r136.Zk(r100, r144);
        return r144;
    L78:
        r142 = r140.a();
        goto L79
    L75:
        ((ltc.f) r137).getClass();
        io.opentelemetry.sdk.internal.e.f492717a.getClass();
        r140 = new a(r137, TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()), System.nanoTime());
        r141 = true;
        goto L76
    L65:
        if (r127.f492669g == true) goto L68;
        return jtc.g.f500397b;
    L68:
        return new jtc.g(r127);
    L59:
        if (r116.equals(r114) == true) goto L62;
        r128 = false;
        goto L63
    L23:
        if (r110.length() != 16) goto L35;
        if ("0000000000000000".contentEquals(r110) == true) goto L35;
        char[] r145 = io.opentelemetry.api.internal.j.f492678a;
        int r146 = r110.length();
        int r147 = 0;
    L27:
        if (r147 >= r146) goto L32;
        char r148 = r110.charAt(r147);
        if (io.opentelemetry.api.internal.j.f492679b[r148] == false) goto L30;
        r147 = r147 + 1;
        goto L27
    L30:
        boolean r149 = false;
    L33:
        if (r149 == false) goto L35;
        r119 = true;
        goto L36
    L32:
        r149 = true;
    L55:
        r126 = new io.opentelemetry.api.internal.b(r112, r110, r118, r115, true);
        goto L56
    L18:
        r117 = jtc.f.f500393c;
        goto L19
    L11:
        r106 = r111.f492664b;
        goto L12
    }

    @Override // jtc.j
    public final jtc.j b(wx9.a r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        this.f492777e = r100;
        return this;
    }

    public j(String r100, ltc.e r101, s r102, p r103) {
        this.f492778f = SpanKind.INTERNAL;
        this.f492773a = r100;
        this.f492774b = r101;
        this.f492775c = r102;
        this.f492776d = r103;
    }
}
