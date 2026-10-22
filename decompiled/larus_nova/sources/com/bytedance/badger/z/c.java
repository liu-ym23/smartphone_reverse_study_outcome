package com.bytedance.badger.z;

import android.content.Context;
import android.os.Looper;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends u0 {
    public c() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r100, BadgerModuleBase.BadgerRequestData r101) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        List r102 = com.bytedance.badger.y.g.f199442a;
        Object r103 = a74.e.f1992b;
        monitor-enter(r103);
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L32
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L32
        JSONArray r106 = new JSONArray();     // Catch: Throwable -> L32
        Iterator r107 = a74.e.f1997g.iterator();     // Catch: Throwable -> L32
    L10:
        if (r107.hasNext() == false) goto L12;
        r105.put((String) r107.next());     // Catch: Throwable -> L32
        goto L10
    L12:
        Iterator r108 = a74.e.f1998h.iterator();     // Catch: Throwable -> L32
    L14:
        if (r108.hasNext() == false) goto L36;
        r106.put((String) r108.next());     // Catch: Throwable -> L32
        goto L14
    L36:
        if (r105.length() <= 0) goto L21;
        r104.putOpt("1", r105);     // Catch: JSONException -> L35 Throwable -> L32
    L21:
        if (r106.length() <= 0) goto L24;
        r104.putOpt("2", r106);     // Catch: JSONException -> L35 Throwable -> L32
    L24:
        com.bytedance.badger.e.f("event_behavior# ", "consume size= " + a74.e.f1995e);     // Catch: Throwable -> L32
        monitor-exit(r103);     // Catch: Throwable -> L32
        if (r104.length() > 0) goto L31;
        return new BadgerResult.Failure(-1000, "empty");
    L31:
        return new BadgerResult.Success(new DataJson(r104));
    L32:
        th = move-exception;
        throw th;
    L5:
        return new BadgerResult.Failure(-999, "cannot be called on the main thread.");
    }
}
