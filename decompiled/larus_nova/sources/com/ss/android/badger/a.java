package com.ss.android.badger;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements com.bytedance.badger.d {
    public a() {
    }

    @Override // com.bytedance.badger.d
    public final void b(List<? extends Pair<String, ? extends JSONObject>> r100) {
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Pair r102 = (Pair) r101.next();
        com.bytedance.sdk.account.monitor.a.a((String) r102.component1(), (JSONObject) r102.component2());
        goto L4
    }

    @Override // com.bytedance.badger.d
    public final void a(String r100, JSONObject r101) {
        com.bytedance.sdk.account.monitor.a.a(r100, r101);
    }

    @Override // com.bytedance.badger.d
    public final void d(String r100, String r101) {
        tb7.a.a(r100, r101);
    }

    @Override // com.bytedance.badger.d
    public final void e(String r100, String r101) {
        tb7.a.b(r100, r101);
    }

    @Override // com.bytedance.badger.d
    public final void i(String r100, String r101) {
        tb7.a.d(r100, r101);
    }

    @Override // com.bytedance.badger.d
    public final void w(String r100, String r101) {
        tb7.a.e(r100, r101);
    }

    @Override // com.bytedance.badger.d
    public final void e(String r100, String r101, Throwable r102) {
        tb7.a.c(r100, r101, r102);
    }

    @Override // com.bytedance.badger.d
    public final void i(String r100, String r101, Throwable r102) {
        tb7.a.d(r100, r101 + "\n" + Log.getStackTraceString(r102));
    }

    @Override // com.bytedance.badger.d
    public final void w(String r100, String r101, Throwable r102) {
        tb7.a.f(r100, r101, r102);
    }
}
