package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonArray;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.k;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f397591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f397592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventEntity f397593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397594d;

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        EventEntity r101 = this.f397593c;
        Long r102 = r101.f397528a;
        Long r103 = r101.f397532c;
        Long r104 = r101.f397536e;
        Long r105 = r101.M;
        if (r105 == null) goto L5;
        String r106 = r105.toString();
    L6:
        EventEntity r107 = this.f397593c;
        Long r108 = r107.O;
        String r109 = r107.f397553m0;
        k r110 = new k();
        r110.a(DBDefinition.ID, r102);
        r110.a("calendar_id", r104);
        r110.a("_sync_id", r103);
        r110.a("original_id", r106);
        r110.a("originalInstanceTime", r108);
        r110.a("sync_data2", r109);
        r110.a("deleted", Boolean.valueOf(this.f397594d));
        r110.a("dirty", this.f397592b);
        Boolean r111 = this.f397591a;
        if (r111 == null) goto L9;
        r110.a("visible", r111);
    L9:
        Pair<String, String[]> r112 = r110.b();
        String r113 = r112.component1();
        String[] r114 = r112.component2();
        JsonArray r115 = new JsonArray();
        Cursor r116 = r100.query(new ala.b(null, 3), EventEntity.f397526w0, r113, r114, null);
        if (r116 == null) goto L24;
        Cursor r117 = r116;
        Cursor r118 = r117;     // Catch: Throwable -> L19
    L14:
        if (r118.moveToNext() == false) goto L17;
        String[] r119 = EventEntity.f397526w0;     // Catch: Exception -> L25 Throwable -> L19
        r115.add(EventEntity.a.a(r118).a());     // Catch: Exception -> L25 Throwable -> L19
        goto L14
    L17:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r117, null);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);
        throw th;
    L24:
        return r115;
    L5:
        r106 = null;
        goto L6
    }

    public e(Boolean r100, Boolean r101, Long r102, EventEntity r103) {
        Intrinsics.checkNotNullParameter(r103, "entity");
        this.f397591a = r101;
        this.f397592b = r102;
        this.f397593c = r103;
        if (r100 == null) goto L5;
        boolean r104 = r100.booleanValue();
    L6:
        this.f397594d = r104;
        return;
    L5:
        r104 = false;
        goto L6
    }
}
