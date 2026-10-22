package com.larus.bmhome.chat.screenshot;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c extends f {
    @Override // com.larus.bmhome.chat.screenshot.f
    public final void b() {
        this.f308588c = System.currentTimeMillis();
        String[] r100 = {"_data", "date_added"};
        Context r101 = getContext().get();
        if (r101 != null) goto L5;
        return;
    L5:
        ContentResolver r110 = r101.getContentResolver();
        Uri r102 = this.f308586a;
        f06.c r111 = new f06.c();
        Object[] r103 = {r102, r100, null, null, "date_modified desc"};
        f06.b r112 = new f06.b();
        f06.d r113 = r111.b(240004, "android/content/ContentResolver", "query", r110, r103, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L8;
        r111.a(240004, "android/content/ContentResolver", "query", r110, r103, null, r112, false);
        Cursor r104 = (Cursor) r113.f474983b;
    L9:
        if (r104 == null) goto L26;
        Cursor r105 = r104;
        Cursor r106 = r105;     // Catch: Throwable -> L20
        int r107 = r106.getCount();     // Catch: Throwable -> L20
        if (this.f308589d < r107) goto L14;
        this.f308589d = r107;     // Catch: Throwable -> L20
    L18:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r105, null);
        return;
    L14:
        this.f308589d = r107;     // Catch: Throwable -> L20
        if (r106.moveToFirst() == false) goto L18;
        int r109 = r106.getColumnIndex("date_added");     // Catch: Throwable -> L20
        int r114 = r106.getColumnIndex("_data");     // Catch: Throwable -> L20
        int r115 = r106.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L20
        long r116 = r106.getLong(r109);     // Catch: Throwable -> L20
        String r117 = r106.getString(r114);     // Catch: Throwable -> L20
        Uri r118 = ContentUris.withAppendedId(this.f308586a, r106.getLong(r115));     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r117);     // Catch: Throwable -> L20
        a(r117, r116, r118);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L26:
        return;
    L8:
        r104 = r110.query(r102, r100, null, null, "date_modified desc");
        r111.a(240004, "android/content/ContentResolver", "query", r110, r103, r104, r112, true);
        goto L9
    }

    public c(Uri r100, WeakReference<Context> r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
