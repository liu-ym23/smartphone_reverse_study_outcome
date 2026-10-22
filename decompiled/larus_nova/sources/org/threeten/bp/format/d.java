package org.threeten.bp.format;

import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends zwc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ org.threeten.bp.chrono.a f526419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ org.threeten.bp.temporal.b f526420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ org.threeten.bp.chrono.e f526421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f526422d;

    @Override // org.threeten.bp.temporal.b
    public final long getLong(org.threeten.bp.temporal.f r100) {
        if (this.f526419a == null) goto L9;
        if (r100.isDateBased() == false) goto L9;
        return this.f526419a.getLong(r100);
    L9:
        return this.f526420b.getLong(r100);
    }

    @Override // org.threeten.bp.temporal.b
    public final boolean isSupported(org.threeten.bp.temporal.f r100) {
        if (this.f526419a == null) goto L9;
        if (r100.isDateBased() == false) goto L9;
        return this.f526419a.isSupported(r100);
    L9:
        return this.f526420b.isSupported(r100);
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public <R> R query(org.threeten.bp.temporal.h<R> r100) {
        if (r100 != org.threeten.bp.temporal.g.f526469b) goto L7;
        return (R) this.f526421c;
    L7:
        if (r100 != org.threeten.bp.temporal.g.f526468a) goto L11;
        return (R) this.f526422d;
    L11:
        if (r100 != org.threeten.bp.temporal.g.f526470c) goto L15;
        return (R) this.f526420b.query(r100);
    L15:
        return r100.a(this);
    }

    @Override // zwc.c, org.threeten.bp.temporal.b
    public final ValueRange range(org.threeten.bp.temporal.f r100) {
        if (this.f526419a == null) goto L9;
        if (r100.isDateBased() == false) goto L9;
        return this.f526419a.range(r100);
    L9:
        return this.f526420b.range(r100);
    }

    public d(org.threeten.bp.chrono.a r100, org.threeten.bp.temporal.b r101, org.threeten.bp.chrono.e r102, ZoneId r103) {
        this.f526419a = r100;
        this.f526420b = r101;
        this.f526421c = r102;
        this.f526422d = r103;
    }
}
