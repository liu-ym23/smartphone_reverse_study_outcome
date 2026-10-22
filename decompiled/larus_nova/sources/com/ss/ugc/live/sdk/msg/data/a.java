package com.ss.ugc.live.sdk.msg.data;

import com.ss.ugc.live.sdk.msg.network.g;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tlc.d;
import tlc.f;

/* JADX INFO: loaded from: classes36.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f458229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f458230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f458231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SdkResponse f458232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f458233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f458234f;

    public final String a() {
        g r100 = this.f458229a;
        String r101 = null;
        if (r100 == null) goto L6;
        if (r100 == null) goto L10;
        List<com.ss.ugc.live.sdk.msg.network.d> r102 = r100.f458313c;
    L11:
        int r103 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        if (r102 == null) goto L23;
        Iterator<T> r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        if (StringsKt.equals("im-cursor", ((com.ss.ugc.live.sdk.msg.network.d) r105).f458296a, true) == false) goto L15;
    L20:
        com.ss.ugc.live.sdk.msg.network.d r106 = (com.ss.ugc.live.sdk.msg.network.d) r105;
        if (r106 == null) goto L23;
        r101 = r106.f458297b;
        goto L23
    L19:
        r105 = null;
    L23:
        if (r101 == null) goto L26;
        return r101;
    L26:
        return this.f458232d.cursor;
    L10:
        r102 = null;
        goto L11
    L6:
        f r107 = this.f458230b;
        if (r107 == null) goto L10;
        if (r107 == null) goto L10;
        r102 = r107.f546765f;
        goto L11
    }

    public final String b() {
        g r100 = this.f458229a;
        List<com.ss.ugc.live.sdk.msg.network.d> r101 = null;
        if (r100 == null) goto L6;
        if (r100 == null) goto L10;
        r101 = r100.f458313c;
    L10:
        String r102 = com.ss.ugc.live.sdk.msg.utils.c.a(r101);
        if (r102 == null) goto L14;
        return r102;
    L14:
        return this.f458232d.internal_ext;
    L6:
        f r103 = this.f458230b;
        if (r103 == null) goto L10;
        if (r103 == null) goto L10;
        r101 = r103.f546765f;
        goto L10
    }

    public /* synthetic */ a(SdkResponse r100, List r101) {
        this(r100, r101, new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(SdkResponse r100, List<? extends d> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "decodeMessages");
        Intrinsics.checkNotNullParameter(r102, "sdkStat");
        this.f458232d = r100;
        this.f458233e = r101;
        this.f458234f = r102;
    }
}
