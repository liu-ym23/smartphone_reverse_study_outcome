package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f267953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y2 f267954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r4 f267955c;

    public a5() {
        this.f267953a = new q2();
        this.f267954b = new y2();
        this.f267955c = new r4();
    }

    public final void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        if ((!Intrinsics.areEqual(this.f267953a.f268306b, "sslocal://annie_redirect?entry=initialize")) == true) goto L5;
        return;
    L5:
        q2 r102 = this.f267953a;
        r102.f268305a = 0;
        r102.f268314j = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f268318n = r101;
        String r103 = this.f267953a.a();
        r4 r104 = this.f267955c;
        r104.getClass();
        int r105 = or3.a.f524932a;
        JSONObject r106 = new JSONObject();
        com.bytedance.anniex.bd.foundation.impl.o.r(r106, "duration", Long.valueOf(r104.f268348a));
        String r107 = com.bytedance.anniex.bd.foundation.impl.o.a(r106);
        y2 r108 = this.f267954b;
        r108.getClass();
        JSONObject r109 = new JSONObject();
        com.bytedance.anniex.bd.foundation.impl.o.r(r109, "entry_config", r108.f268520a);
        String r110 = com.bytedance.anniex.bd.foundation.impl.o.a(r109);
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "report Error: \n category: " + r103 + ";\n metric: " + r107 + ";\n extras: " + r110 + ";\n");
        int r111 = i5.f268119a;
        i5.a.a("annie_schema_redirect_status", 1, com.bytedance.anniex.bd.foundation.impl.o.d(r103), com.bytedance.anniex.bd.foundation.impl.o.d(r107), com.bytedance.anniex.bd.foundation.impl.o.d(r110));
        i5.a.a("annie_schema_redirect_error", 0, com.bytedance.anniex.bd.foundation.impl.o.d(r103), com.bytedance.anniex.bd.foundation.impl.o.d(r107), com.bytedance.anniex.bd.foundation.impl.o.d(r110));
    }
}
