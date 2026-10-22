package io.michaelrocks.libphonenumber.android;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f492242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f492244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Phonemetadata$PhoneMetadata> f492245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Phonemetadata$PhoneMetadata> f492246e;

    public f(a r100) {
        this.f492245d = new ConcurrentHashMap();
        this.f492246e = new ConcurrentHashMap();
        this.f492242a = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto";
        this.f492243b = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto";
        this.f492244c = new d(r100);
    }
}
