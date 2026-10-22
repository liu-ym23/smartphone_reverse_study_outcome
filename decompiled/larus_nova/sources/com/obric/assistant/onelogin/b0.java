package com.obric.assistant.onelogin;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b0 extends com.ss.android.account.group_onekey.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f390918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f390919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f390920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Function4<ua7.h, String, String, String, Unit> f390921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function3<ua7.h, String, String, Unit> f390922h;

    @Override // com.ss.android.account.group_onekey.e
    public final void a(ua7.h r100, com.ss.android.account.group_onekey.e.a r101) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "extra");
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("AccountGroupAuthService.startAuth onError, loginId=");
        r103.append(this.f390918d);
        r103.append(", source=");
        r103.append(this.f390919e);
        r103.append(", msg: ");
        String r104 = r100.toString();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        g2a.e r105 = g2a.e.f479755a;
        r103.append(g2a.f.a(r104, false, false));
        r102.e("ObricOneLoginUtils", r103.toString());
        this.f390920f.invoke();
        this.f390921g.invoke(r100, String.valueOf(r100.f549253g), "start_auth", "start_auth");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(String r100, String r101, Function0<Unit> r102, Function4<? super ua7.h, ? super String, ? super String, ? super String, Unit> r103, Function3<? super ua7.h, ? super String, ? super String, Unit> r104, Context r105, String r106) {
        this.f390918d = r100;
        this.f390919e = r101;
        this.f390920f = r102;
        this.f390921g = r103;
        this.f390922h = r104;
        Intrinsics.checkNotNull(r105);
        super(r105, r106);
    }
}
