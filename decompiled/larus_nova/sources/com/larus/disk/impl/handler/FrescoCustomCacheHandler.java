package com.larus.disk.impl.handler;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class FrescoCustomCacheHandler implements com.larus.disk.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f330690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f330691d;

    @Override // com.larus.disk.api.c
    public final String business() {
        return "fresco_cache";
    }

    @Override // com.larus.disk.api.d
    public final boolean e(boolean r100) {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return true;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return aa9.a.f2357a.b(this.f330688a, false).getAbsolutePath();
    }

    @Override // com.larus.disk.api.d
    public final long d() {
        return k.b(new PolarisFileWrapper(a()));
    }

    @Override // com.larus.disk.api.d
    public final boolean g() {
        Lazy r100 = com.larus.disk.impl.d.f330625a;
        lu9.a r101 = com.larus.disk.impl.d.a();
        if (this.f330691d == true) goto L5;
    L9:
        return false;
    L5:
        if (r101.k() == false) goto L9;
        if (r101.j() == false) goto L9;
        return true;
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(a());
        if (r100.exists() == true) goto L5;
        return 0;
    L5:
        return RangesKt.coerceAtLeast(com.larus.utils.r.r(r100), 0);
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return this.f330689b;
    }

    @Override // com.larus.disk.api.d
    public final boolean f() {
        return this.f330690c;
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        if (g() == true) goto L5;
        return 0;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(a());
        final long r102 = com.larus.disk.impl.d.f(r100);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        if (r101.exists() == false) goto L15;
        Iterator r103 = SequencesKt.filter(FilesKt.walkTopDown(r101), new i(r102)).iterator();
        long r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L13;
        r104 = r104 + RangesKt.coerceAtLeast(com.larus.utils.r.r((File) r103.next()), 0);
        goto L10
    L13:
        return r104;
    L15:
        return 0;
    }

    @Override // com.larus.disk.api.d
    public final boolean c(boolean r100, boolean r101) {
        return com.larus.disk.api.d.a.a(this, r100, r101);
    }

    @Override // com.larus.disk.api.c
    public final void h(final boolean r100, boolean r101) {
        if (r101 == false) goto L5;
        k.a(new FrescoCustomCacheHandler$cleanCache$1(this), new l(this));
        return;
    L5:
        if (g() == false) goto L9;
        k.a(new m(this, r100), new n(this, r100));
        return;
    }

    public FrescoCustomCacheHandler(String r100, String r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r103 & 8) == 0) goto L9;
        r102 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, "cacheName");
        Intrinsics.checkNotNullParameter(r101, "cacheBizTag");
        this.f330688a = r100;
        this.f330689b = r101;
        this.f330690c = r104;
        this.f330691d = r102;
        return;
    L5:
        r104 = false;
        goto L7
    }
}
