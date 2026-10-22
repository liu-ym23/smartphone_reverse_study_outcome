package com.obric.assistant.omnidetailpage.blockview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l implements com.larus.platform.api.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f390661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ifa.c.b f390662b;

    @Override // com.larus.platform.api.n0
    public final void b(Integer r100, Integer r101) {
    }

    @Override // com.larus.platform.api.n0
    public final void c(int r100) {
    }

    @Override // com.larus.platform.api.n0
    public final void d(int r100) {
    }

    @Override // com.larus.platform.api.n0
    public final void onCompletion() {
    }

    @Override // com.larus.platform.api.n0
    public final void onPrepare() {
    }

    @Override // com.larus.platform.api.n0
    public final void onPrepared() {
    }

    @Override // com.larus.platform.api.n0
    public final void onVideoStatusException(int r100) {
    }

    @Override // com.larus.platform.api.n0
    public final void onRenderStart() {
        ifa.c.b r100 = this.f390661a.f390643k;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f489661a;
    L7:
        if (Intrinsics.areEqual(r102, this.f390662b.f489661a) == false) goto L16;
        ifa.c.b r103 = this.f390661a.f390643k;
        if (r103 == null) goto L12;
        r101 = r103.f489663c;
    L12:
        if (Intrinsics.areEqual(r101, this.f390662b.f489663c) == false) goto L17;
        j r104 = this.f390661a;
        r104.f390648p = true;
        r104.f390646n = true;
        r104.f390639g.setVisibility(8);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public l(j r100, ifa.c.b r101) {
        this.f390661a = r100;
        this.f390662b = r101;
    }

    @Override // com.larus.platform.api.n0
    public final void a(Integer r100, Integer r101) {
        ifa.c.b r102 = this.f390661a.f390643k;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f489661a;
    L7:
        if (Intrinsics.areEqual(r104, this.f390662b.f489661a) == false) goto L18;
        ifa.c.b r105 = this.f390661a.f390643k;
        if (r105 == null) goto L12;
        r103 = r105.f489663c;
    L12:
        if (Intrinsics.areEqual(r103, this.f390662b.f489663c) == false) goto L20;
        j r106 = this.f390661a;
        r106.f390646n = false;
        if (r106.f390643k == null) goto L19;
        r106.f390639g.setVisibility(0);
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r104 = null;
        goto L7
    }
}
