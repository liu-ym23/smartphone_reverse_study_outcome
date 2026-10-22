package com.bytedance.sdk.account.impl;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements com.ss.android.token.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f268982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f268983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ua7.a f268984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.token.d f268985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f268986e;

    public class a extends ua7.a<ua7.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f268987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f268988b;

        @Override // ua7.a
        public final void onResponse(ua7.b r100) {
            ua7.c r101 = (ua7.c) r100;
            ua7.a r102 = this.f268988b.f268984c;
            if (r102 == null) goto L6;
            r102.dispatchOnResponse(r101);
        L6:
            if (com.ss.android.token.p.b() == null) goto L9;
            com.ss.android.token.p.b().a(this.f268988b.f268985d);
            return;
        }

        public a(e r100, Object r101) {
            this.f268988b = r100;
            this.f268987a = r101;
        }
    }

    public final void a(Map<String, String> r100, Object r101) {
        Map<String, String> r102 = this.f268982a;
        if (r100 != null) goto L5;
    L9:
        r100 = r102;
    L10:
        Context r103 = this.f268986e.f268995a;
        String r104 = this.f268983b;
        a r105 = new a(this, r101);
        int r106 = sa7.a.f541178m;
        lb7.a.C6671a r107 = new lb7.a.C6671a();
        r107.f508360a = ta7.d.a("/passport/user/logout/");
        r107.e("logout_from", r104);
        r107.f(r100);
        new sa7.a(r103, r107.h(), r104, r105).m();
        return;
    L5:
        if (r100.isEmpty() == true) goto L9;
        if (r102 == null) goto L10;
        r102.putAll(r100);
        goto L9
    }

    public e(g r100, String r101, ua7.a r102, com.ss.android.token.d r103) {
        this.f268986e = r100;
        this.f268982a = null;
        this.f268983b = r101;
        this.f268984c = r102;
        this.f268985d = r103;
    }
}
