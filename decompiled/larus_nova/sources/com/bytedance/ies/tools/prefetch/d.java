package com.bytedance.ies.tools.prefetch;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f248809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f248810b;

    public d(c r100, List r101) {
        this.f248809a = r100;
        this.f248810b = r101;
    }

    public final void a() {
        Iterator r100 = this.f248810b.iterator();
    L4:
        if (r100.hasNext() == false) goto L25;
        String r101 = (String) r100.next();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L20
        u r103 = new u(new JSONObject(r101));     // Catch: Throwable -> L20
        this.f248809a.f248794b.put(r103.f248830a, r103);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r103.f248830a) == true) goto L9;
        this.f248809a.getClass();     // Catch: Throwable -> L20
    L10:
        c r104 = this.f248809a;     // Catch: Throwable -> L20
        if (r104.f248795c == false) goto L18;
        PrefetchDebugTool r105 = PrefetchDebugTool.f248732d;     // Catch: Throwable -> L20
        String r106 = r104.f248796d;     // Catch: Throwable -> L20
        r105.getClass();     // Catch: Throwable -> L20
        Lazy r107 = PrefetchDebugTool.f248730b;     // Catch: Throwable -> L20
        KProperty[] r108 = PrefetchDebugTool.f248729a;     // Catch: Throwable -> L20
        KProperty r109 = r108[0];     // Catch: Throwable -> L20
        if (((ConcurrentHashMap) r107.getValue()).containsKey(r106) == true) goto L15;
        KProperty r110 = r108[0];     // Catch: Throwable -> L20
        ((ConcurrentHashMap) r107.getValue()).put(r106, new ArrayList());     // Catch: Throwable -> L20
    L15:
        KProperty r111 = r108[0];     // Catch: Throwable -> L20
        ArrayList r112 = (ArrayList) ((ConcurrentHashMap) r107.getValue()).get(r106);     // Catch: Throwable -> L20
        if (r112 == null) goto L18;
        r112.add(new z());     // Catch: Throwable -> L20
    L18:
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L4;
        p.f248826a.b(r114);
        this.f248809a.getClass();
        goto L4
    L9:
        this.f248809a.getClass();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
