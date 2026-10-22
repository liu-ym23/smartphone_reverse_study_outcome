package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f387323b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f387324a;

    public static final class a {
    }

    static {
        f387323b = new g("cocreation_feedback_data.db", "feedback.database.observe");
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        h r101 = new h(r100.getApplicationContext());
        this.f387324a = r101;
        long r102 = System.currentTimeMillis() - 172800000;
        int r103 = r101.getWritableDatabase().delete("feedback_data", "created_at < ?", new String[]{String.valueOf(r102)});
        int r104 = s3.f387719a;
        s3.b("feedback.database", "deleteExpired reason=store_init, cutoff=" + r102 + ", deleted=" + r103);
        if (r103 <= 0) goto L6;
        f387323b.a("feedback_expired:" + r103);
        return;
    }

    public final void b(a5 r110) {
        Intrinsics.checkNotNullParameter(r110, "feedback");
        boolean r100 = false;
        if (r110.f387184b != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Long r102 = Long.valueOf(r110.f387188f);
        if (r102.longValue() <= 0) goto L11;
        r100 = true;
    L11:
        String r111 = null;
        if (r100 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        long r103 = r102.longValue();
    L18:
        a5 r112 = a5.a(r110, null, null, null, r101, r103, null, 207);
        this.f387324a.getWritableDatabase().insertWithOnConflict("feedback_data", null, k.b(r112), 5);
        int r104 = s3.f387719a;
        StringBuilder r105 = new StringBuilder("upsert recordId=");
        r105.append(r112.f387183a);
        r105.append(", vote=");
        Vote r106 = r112.f387184b;
        if (r106 == null) goto L21;
        r111 = r106.getRaw();
    L21:
        r105.append(r111);
        r105.append(", reasonCount=");
        r105.append(r112.f387185c.size());
        r105.append(", createdAt=");
        r105.append(r112.f387188f);
        s3.b("feedback.database", r105.toString());
        f387323b.a("feedback_upsert:" + r112.f387183a);
        return;
    L17:
        r103 = System.currentTimeMillis();
        goto L18
    L5:
        if ((!r110.f387185c.isEmpty()) == false) goto L7;
        r101 = true;
        goto L8
    }

    public final Map<String, a5> a(Set<String> r210, List<a5> r211) {
        Intrinsics.checkNotNullParameter(r210, "recordIds");
        Intrinsics.checkNotNullParameter(r211, "seedFeedbacks");
        SQLiteDatabase r100 = this.f387324a.getWritableDatabase();
        Intrinsics.checkNotNull(r100);
        if (r211.isEmpty() == true) goto L22;
        Cursor r101 = r100.rawQuery("SELECT COUNT(*) FROM feedback_data", new String[0]);
        Cursor r102 = r101;     // Catch: Throwable -> L48
        if (r102.moveToFirst() == false) goto L10;
        int r103 = r102.getInt(0);     // Catch: Throwable -> L48
    L11:
        CloseableKt.closeFinally(r101, null);
        if (r103 <= 0) goto L14;
        int r104 = s3.f387719a;
        s3.a("feedback.database", "seed skipped existing=" + r103);
        goto L22
    L14:
        r100.beginTransaction();
        Iterator<T> r105 = r211.iterator();     // Catch: Throwable -> L45
    L17:
        if (r105.hasNext() == false) goto L19;
        r100.insertWithOnConflict("feedback_data", null, k.b((a5) r105.next()), 5);     // Catch: Throwable -> L45
        goto L17
    L19:
        r100.setTransactionSuccessful();     // Catch: Throwable -> L45
        int r106 = s3.f387719a;     // Catch: Throwable -> L45
        s3.b("feedback.database", "seed inserted count=" + r211.size());     // Catch: Throwable -> L45
        r100.endTransaction();
    L45:
        th = move-exception;
        r100.endTransaction();
        throw th;
    L10:
        r103 = 0;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    L22:
        if (r210.isEmpty() == true) goto L24;
        String r107 = CollectionsKt.joinToString$default(r210, ",", null, null, 0, null, new i(), 30, null);
        LinkedHashMap r108 = new LinkedHashMap();
        Cursor r109 = r100.query("feedback_data", null, "record_id IN (" + r107 + ')', (String[]) r210.toArray(new String[0]), null, null, "created_at DESC, record_id ASC");
        Cursor r110 = r109;     // Catch: Throwable -> L39
    L28:
        if (r110.moveToNext() == false) goto L36;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L31
        a5 r112 = k.c(r110);     // Catch: Throwable -> L31
        r108.put(r112.f387183a, r112);     // Catch: Throwable -> L31
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L39
        if (r114 == null) goto L28;
        int r115 = s3.f387719a;     // Catch: Throwable -> L39
        s3.c("feedback.database", "skip invalid row error=" + r114.getMessage());     // Catch: Throwable -> L39
        goto L28
    L31:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L39
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L39
        goto L33
    L36:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r109, null);
        int r118 = s3.f387719a;
        s3.b("feedback.database", "query requested=" + r210.size() + ", hit=" + r108.size());
        return r108;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);
        throw th;
    L24:
        return MapsKt.emptyMap();
    }
}
