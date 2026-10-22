package com.larus.home.impl.sdk;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.im.IInstantMessenger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 implements com.larus.platform.api.p2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.im.f f346223b;

    @Override // com.larus.platform.api.p2
    public final int c() {
        com.larus.im.f r100 = this.f346223b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.p2
    public final int getChannelId() {
        com.larus.im.f r100 = this.f346223b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getChannelId();
    }

    @Override // com.larus.platform.api.p2
    public final int getServiceId() {
        com.larus.im.f r100 = this.f346223b;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getServiceId();
    }

    public p1(int r100) {
        IInstantMessenger r101 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        if (r101 == null) goto L5;
        com.larus.im.network.f r102 = r101.a(r100);
    L6:
        this.f346223b = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void b(Function1<? super byte[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.im.f r101 = this.f346223b;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // com.larus.platform.api.p2
    public final void d(Function1<? super byte[], Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.im.f r101 = this.f346223b;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.larus.platform.api.p2
    public final void g(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.im.f r101 = this.f346223b;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    @Override // com.larus.platform.api.p2
    public final void i(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.im.f r101 = this.f346223b;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.larus.platform.api.p2
    public final void a(br9.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        com.larus.im.f r102 = this.f346223b;
        if (r102 == null) goto L9;
        if (r100 == null) goto L6;
        ed9.a r103 = new ed9.a(r100.f20155a, r100.f20156b, r100.f20157c, r100.f20158d);
    L7:
        r102.l(r103, r101);
        return;
    L6:
        r103 = null;
        goto L7
    }

    @Override // com.larus.platform.api.p2
    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.im.f r102 = this.f346223b;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.p2
    public final void f(byte[] r100, Map<String, String> r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        com.larus.im.f r103 = this.f346223b;
        if (r103 == null) goto L10;
        if (r101 == null) goto L7;
        Map<String, String> r104 = MapsKt.toMutableMap(r101);
        if (r104 == null) goto L7;
    L8:
        r104.putAll(ic9.d.a());
        r103.f(r100, r104, r102);
        return;
    L7:
        r104 = new LinkedHashMap();
        goto L8
    }
}
