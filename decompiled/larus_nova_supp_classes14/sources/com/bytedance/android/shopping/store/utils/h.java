package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final int a;
    public int b;
    public boolean c;
    public final PolarisFileWrapper d;
    public PolarisFileReaderWrapper e;
    public final LinkedList<String> f;
    public final String g;

    public final void a() {
        PolarisFileReaderWrapper r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = e.a;
        ArrayList r2 = new ArrayList();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        BufferedReader r4 = new BufferedReader(r0);     // Catch: Throwable -> L11
        String r5 = r4.readLine();     // Catch: Throwable -> L11
    L7:
        if (r5 == null) goto L9;
        r2.add(r5);     // Catch: Throwable -> L11
        r5 = r4.readLine();     // Catch: Throwable -> L11
        goto L7
    L9:
        r4.close();     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        this.b = r2.size();
        this.f.addAll(r2);
        return;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void b() {
        Iterator<String> r0 = this.f.iterator();
        this.b = this.f.size();
    L4:
        if (this.b <= this.a) goto L9;
        String r1 = r0.next();
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.g, r1 + ".js");
        int r3 = e.a;
        Intrinsics.checkNotNullParameter(r2, "$this$deleteIfExists");
        if (r2.exists() == false) goto L8;
        r2.delete();
    L8:
        r0.remove();
        this.b--;
        goto L4
    }

    public h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "filesDir");
        this.g = r4;
        Lazy r5 = ECStoreSettings.a;
        int r6 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r0 = 100;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r2 = jj4.b.b;     // Catch: Throwable -> L7
        Object r7 = jj4.a.a("ec_shop_isv_cache_size", Integer.class, r0, false);     // Catch: Throwable -> L7
        if (r7 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        this.a = ((Number) r7).intValue();
        PolarisFileWrapper r8 = new PolarisFileWrapper(this.g);
        PolarisFileWrapper r3 = new PolarisFileWrapper(r8, "lru_info");
        this.d = r3;
        this.f = new LinkedList();
    L22:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L15:
        if (r8.exists() == true) goto L18;
        r8.mkdir();     // Catch: Throwable -> L22
    L18:
        if (r3.exists() == true) goto L20;
        r3.createNewFile();     // Catch: Throwable -> L22
    L20:
        this.e = new PolarisFileReaderWrapper(r3);     // Catch: Throwable -> L22
        a();     // Catch: Throwable -> L22
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
        return;
    L7:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Object r11 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r11) == true) goto L12;
        r0 = r11;
    L12:
        r7 = r0;
        goto L13
    }
}
