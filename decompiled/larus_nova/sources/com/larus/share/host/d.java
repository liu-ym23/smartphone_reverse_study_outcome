package com.larus.share.host;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends in7.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f368571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f368572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f368573c;

    @Override // in7.h
    public final void a(kn7.b r100) {
        Integer r101 = Integer.valueOf(r100.f504255a);
        if (r101 != null) goto L6;
    L10:
        if (r101 != null) goto L13;
    L17:
        FLogger.f375446a.i("ShareRuntimeServiceImpl", "share result channel=" + this.f368572b + " type=" + this.f368573c + " code=" + Integer.valueOf(r100.f504255a));
        return;
    L13:
        if (r101.intValue() != 10002) goto L17;
        Function1<Integer, Unit> r102 = this.f368571a;
        if (r102 == null) goto L17;
        r102.invoke(2);
        goto L17
    L6:
        if (r101.intValue() != 10000) goto L10;
        Function1<Integer, Unit> r103 = this.f368571a;
        if (r103 == null) goto L17;
        r103.invoke(1);
        goto L17
    }

    public d(com.larus.share.impl.sdk.b r100, String r101, String r102) {
        this.f368571a = r100;
        this.f368572b = r101;
        this.f368573c = r102;
    }
}
