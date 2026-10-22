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
public final class c implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f397586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CalendarEntity f397587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f397588c;

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CalendarEntity r101 = this.f397587b;
        Long r102 = r101.f397498a;
        String r103 = r101.f397500c;
        String r104 = r101.f397506i;
        String r105 = r101.f397504g;
        Integer r106 = r101.f397514q;
        k r107 = new k();
        r107.a(DBDefinition.ID, r102);
        r107.a("name", r103);
        r107.a("calendar_displayName", r104);
        r107.a("account_name", r105);
        r107.a("ownerAccount", r105);
        r107.a("deleted", Boolean.valueOf(this.f397588c));
        r107.a("dirty", this.f397586a);
        r107.a("visible", r106);
        Pair<String, String[]> r108 = r107.b();
        String r109 = r108.component1();
        String[] r110 = r108.component2();
        JsonArray r111 = new JsonArray();
        Cursor r112 = r100.query(new ala.a(null, 3), CalendarEntity.E, r109, r110, null);
        if (r112 == null) goto L17;
        Cursor r113 = r112;
        Cursor r114 = r113;     // Catch: Throwable -> L12
    L7:
        if (r114.moveToNext() == false) goto L10;
        String[] r115 = CalendarEntity.E;     // Catch: Exception -> L18 Throwable -> L12
        r111.add(CalendarEntity.a.a(r114).a());     // Catch: Exception -> L18 Throwable -> L12
        goto L7
    L10:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r113, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);
        throw th;
    L17:
        return r111;
    }

    public c(Boolean r100, Long r101, CalendarEntity r102) {
        Intrinsics.checkNotNullParameter(r102, "entity");
        this.f397586a = r101;
        this.f397587b = r102;
        if (r100 == null) goto L5;
        boolean r103 = r100.booleanValue();
    L6:
        this.f397588c = r103;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
