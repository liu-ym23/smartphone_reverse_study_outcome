package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppClientVarsFetcher.Payload>, Unit> f209766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAppClientVarsFetcher f209767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f209768c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppClientVarsFetcher.Payload>, Unit> r100, BaseAppClientVarsFetcher r101, long r102) {
        this.f209766a = r100;
        this.f209767b = r101;
        this.f209768c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r210) {
        com.bytedance.ee.bear.bitable.rust.c.a r100 = (com.bytedance.ee.bear.bitable.rust.c.a) r210;
        if (r100 == null) goto L5;
        String r101 = r100.f215263b;
    L6:
        boolean r102 = false;
        if (Intrinsics.areEqual(r101, "preload") == true) goto L9;
    L14:
        if (r100 == null) goto L24;
        String r103 = r100.f215267f;
        if (r103 == null) goto L24;
        if (r103.length() <= 0) goto L20;
        r102 = true;
    L20:
        if (r102 == true) goto L23;
        r103 = null;
    L23:
        if (r103 == null) goto L24;
    L25:
        Function1<com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<BaseAppClientVarsFetcher.Payload>, Unit> r110 = this.f209766a;
        BitableAppData r111 = new BitableAppData("", this.f209767b.f209739c, null);
        if (r100 == null) goto L28;
        long r104 = r100.f215265d;
    L29:
        if (r100 == null) goto L31;
        int r105 = r100.f215266e;
    L32:
        if (r100 == null) goto L34;
        String r106 = r100.f215268g;
    L35:
        if (r106 != null) goto L37;
        String r107 = "";
    L38:
        if (r100 == null) goto L40;
        String r108 = r100.f215263b;
    L41:
        if (r108 != null) goto L43;
        String r112 = "";
    L44:
        if (r100 == null) goto L46;
        long r109 = r100.f215264c;
    L47:
        r110.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new BaseAppClientVarsFetcher.Payload(r111, new BaseAppClientVarsFetcher.b(r104, r105, r103, r107, r112, r109, "miss"), new Exception(r103)), null));
        return;
    L46:
        r109 = 0;
        goto L47
    L43:
        r112 = r108;
        goto L44
    L40:
        r108 = null;
        goto L41
    L37:
        r107 = r106;
        goto L38
    L34:
        r106 = null;
        goto L35
    L31:
        r105 = -1;
        goto L32
    L28:
        r104 = this.f209768c;
    L24:
        r103 = "No preload clientVars available";
        goto L25
    L9:
        if (r100.f215262a.length() <= 0) goto L11;
        boolean r113 = true;
    L12:
        if (r113 == false) goto L14;
        this.f209766a.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new BaseAppClientVarsFetcher.Payload(new BitableAppData(r100.f215262a, this.f209767b.f209739c, null), new BaseAppClientVarsFetcher.b(r100.f215265d, r100.f215266e, r100.f215267f, r100.f215268g, r100.f215263b, r100.f215264c, BaseHttpRequestInfo.KEY_HIT), null), null));
        return;
    L11:
        r113 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
