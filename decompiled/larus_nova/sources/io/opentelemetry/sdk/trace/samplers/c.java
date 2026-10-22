package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.trace.SpanKind;
import itc.g;
import java.util.List;
import javax.annotation.Nullable;
import jtc.h;
import jtc.k;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f492810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f492811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f492812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f492813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f492814e;

    @Override // io.opentelemetry.sdk.trace.samplers.e
    public final String getDescription() {
        return String.format("ParentBased{root:%s,remoteParentSampled:%s,remoteParentNotSampled:%s,localParentSampled:%s,localParentNotSampled:%s}", new Object[]{this.f492810a.getDescription(), this.f492811b.getDescription(), this.f492812c.getDescription(), this.f492813d.getDescription(), this.f492814e.getDescription()});
    }

    public final int hashCode() {
        return (((((((this.f492810a.hashCode() * 31) + this.f492811b.hashCode()) * 31) + this.f492812c.hashCode()) * 31) + this.f492813d.hashCode()) * 31) + this.f492814e.hashCode();
    }

    public final String toString() {
        return getDescription();
    }

    public c(e r100) {
        this.f492810a = r100;
        AlwaysOnSampler r101 = AlwaysOnSampler.INSTANCE;
        this.f492811b = r101;
        AlwaysOffSampler r102 = AlwaysOffSampler.INSTANCE;
        this.f492812c = r102;
        this.f492813d = r101;
        this.f492814e = r102;
    }

    public final boolean equals(@Nullable Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f492810a.equals(r101.f492810a) == true) goto L11;
    L19:
        return false;
    L11:
        if (this.f492811b.equals(r101.f492811b) == false) goto L19;
        if (this.f492812c.equals(r101.f492812c) == false) goto L19;
        if (this.f492813d.equals(r101.f492813d) == false) goto L19;
        if (this.f492814e.equals(r101.f492814e) == false) goto L19;
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.e
    public final f shouldSample(io.opentelemetry.context.b r110, String r111, String r112, SpanKind r113, g r114, List<Object> r115) {
        k r100 = h.a(r110).b();
        io.opentelemetry.api.internal.b r101 = (io.opentelemetry.api.internal.b) r100;
        if (r101.f492669g == false) goto L5;
        boolean r102 = false;
        if (r101.f492668f == false) goto L15;
        io.opentelemetry.api.internal.h r103 = (io.opentelemetry.api.internal.h) r100;
        r103.getClass();
        if ((((jtc.f) ((io.opentelemetry.api.internal.b) r103).f492666d).f500396b & 1) == 0) goto L11;
        r102 = true;
    L11:
        if (r102 == false) goto L14;
        return this.f492811b.shouldSample(r110, r111, r112, r113, r114, r115);
    L14:
        return this.f492812c.shouldSample(r110, r111, r112, r113, r114, r115);
    L15:
        io.opentelemetry.api.internal.h r104 = (io.opentelemetry.api.internal.h) r100;
        r104.getClass();
        if ((((jtc.f) ((io.opentelemetry.api.internal.b) r104).f492666d).f500396b & 1) == 0) goto L18;
        r102 = true;
    L18:
        if (r102 == false) goto L21;
        return this.f492813d.shouldSample(r110, r111, r112, r113, r114, r115);
    L21:
        return this.f492814e.shouldSample(r110, r111, r112, r113, r114, r115);
    L5:
        return this.f492810a.shouldSample(r110, r111, r112, r113, r114, r115);
    }
}
