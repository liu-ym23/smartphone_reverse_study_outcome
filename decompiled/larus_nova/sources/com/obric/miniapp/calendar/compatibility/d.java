package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f397589b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventEntity.EventType f397590a;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonArray r101 = new JsonArray();
        StringBuilder r102 = new StringBuilder("visible != 0 AND deleted != 1");
        if (this.f397590a == null) goto L5;
        r102.append(" AND sync_data1 LIKE '{%\"eventType\":\"");
        r102.append(this.f397590a);
        r102.append("\"%}'");
    L5:
        String r103 = r102.toString();
        Cursor r104 = r100.query(new ala.b(null, 3), EventEntity.f397526w0, r103, null, null);
        if (r104 == null) goto L20;
        Cursor r105 = r104;
        Cursor r106 = r105;     // Catch: Throwable -> L15
    L10:
        if (r106.moveToNext() == false) goto L13;
        String[] r107 = EventEntity.f397526w0;     // Catch: Exception -> L21 Throwable -> L15
        r101.add(EventEntity.a.a(r106).a());     // Catch: Exception -> L21 Throwable -> L15
        goto L10
    L13:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r105, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L20:
        return r101;
    }

    public d(EventEntity.EventType r100) {
        this.f397590a = r100;
    }
}
