package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.JsonArray;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f397584b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397585a;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonArray r101 = new JsonArray();
        Cursor r102 = r100.query(new ala.b(null, 3), EventEntity.f397526w0, "visible != 0 AND deleted != 1 AND (description LIKE ? OR eventLocation LIKE ? OR title LIKE ?)", new String[]{GXTemplateKey.GAIAX_PE + this.f397585a + '%', GXTemplateKey.GAIAX_PE + this.f397585a + '%', GXTemplateKey.GAIAX_PE + this.f397585a + '%'}, null);
        if (r102 == null) goto L17;
        Cursor r103 = r102;
        Cursor r104 = r103;     // Catch: Throwable -> L12
    L7:
        if (r104.moveToNext() == false) goto L10;
        String[] r105 = EventEntity.f397526w0;     // Catch: Exception -> L18 Throwable -> L12
        r101.add(EventEntity.a.a(r104).a());     // Catch: Exception -> L18 Throwable -> L12
        goto L7
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r103, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L17:
        return r101;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        this.f397585a = r100;
    }
}
