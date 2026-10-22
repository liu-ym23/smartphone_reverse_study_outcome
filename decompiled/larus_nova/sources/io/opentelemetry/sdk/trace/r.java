package io.opentelemetry.sdk.trace;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public abstract class r implements ntc.f {
    public r() {
    }

    public abstract itc.g f();

    public abstract h g();

    public abstract long h();

    public abstract boolean i();

    public abstract String j();

    public abstract List<ntc.c> k();

    public abstract List<Object> l();

    public abstract ntc.g m();

    public abstract int n();

    public abstract int o();

    public final String toString() {
        return "SpanData{spanContext=" + g().f492754b + ", parentSpanContext=" + g().f492755c + ", resource=" + g().f492761i + ", instrumentationScopeInfo=" + e() + ", name=" + j() + ", kind=" + g().f492759g + ", startEpochNanos=" + c() + ", endEpochNanos=" + h() + ", attributes=" + f() + ", totalAttributeCount=" + n() + ", events=" + k() + ", totalRecordedEvents=" + o() + ", links=" + l() + ", totalRecordedLinks=" + g().f492758f + ", status=" + m() + ", hasEnded=" + i() + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // ntc.f
    public final String a() {
        return ((io.opentelemetry.api.internal.b) g().f492754b).f492665c;
    }

    @Override // ntc.f
    public final String b() {
        return ((io.opentelemetry.api.internal.b) g().f492755c).f492665c;
    }

    @Override // ntc.f
    public final long c() {
        return g().f492763k;
    }

    @Override // ntc.f
    public final long d() {
        return h();
    }

    @Override // ntc.f
    public final ltc.e e() {
        return g().f492762j;
    }

    @Override // ntc.f
    public final itc.g getAttributes() {
        return f();
    }

    @Override // ntc.f
    public final List<ntc.c> getEvents() {
        return k();
    }

    @Override // ntc.f
    public final String getName() {
        return j();
    }

    @Override // ntc.f
    public final String getTraceId() {
        return ((io.opentelemetry.api.internal.b) g().f492754b).f492664b;
    }
}
