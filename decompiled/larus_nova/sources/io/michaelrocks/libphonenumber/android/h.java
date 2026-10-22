package io.michaelrocks.libphonenumber.android;

import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements Iterable<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CharSequence f492250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f492251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PhoneNumberUtil.Leniency f492252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f492253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PhoneNumberUtil f492254e;

    @Override // java.lang.Iterable
    public final Iterator<g> iterator() {
        return new PhoneNumberMatcher(this.f492254e, this.f492250a, this.f492251b, this.f492252c, this.f492253d);
    }

    public h(PhoneNumberUtil r100, CharSequence r101, String r102, PhoneNumberUtil.Leniency r103) {
        this.f492254e = r100;
        this.f492250a = r101;
        this.f492251b = r102;
        this.f492252c = r103;
        this.f492253d = Long.MAX_VALUE;
    }
}
