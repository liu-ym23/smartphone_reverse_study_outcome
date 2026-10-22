package wka;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.google.gson.JsonArray;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.f;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f560143d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f560144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f560145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f560146c;

    /* JADX INFO: renamed from: wka.a$a, reason: collision with other inner class name */
    public static final class C8128a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinkedHashSet r100 = new LinkedHashSet();
        Uri.Builder r101 = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(r101, this.f560144a);
        ContentUris.appendId(r101, this.f560145b);
        Cursor r102 = a(f.d(), r101.build(), new String[]{"event_id"}, null);
        if (r102 == null) goto L18;
        Cursor r103 = r102;
        Cursor r104 = r103;     // Catch: Throwable -> L11
    L7:
        if (r104.moveToNext() == false) goto L9;
        r100.add(Long.valueOf(r104.getLong(0)));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r103, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L18:
        if (this.f560146c == true) goto L20;
    L36:
        JsonArray r106 = new JsonArray();
        Iterator r107 = r100.iterator();
    L38:
        if (r107.hasNext() == false) goto L40;
        r106.add((Number) r107.next());
        goto L38
    L40:
        return r106;
    L20:
        if ((!r100.isEmpty()) == false) goto L36;
        Cursor r108 = a(f.d(), CalendarContract.Reminders.CONTENT_URI, new String[]{"event_id"}, "event_id IN " + CollectionsKt.joinToString$default(r100, ",", "(", ")", 0, null, null, 56, null));
        if (r108 == null) goto L36;
        Cursor r109 = r108;
        Cursor r110 = r109;     // Catch: Throwable -> L30
        r100.clear();     // Catch: Throwable -> L30
    L26:
        if (r110.moveToNext() == false) goto L28;
        r100.add(Long.valueOf(r110.getLong(0)));     // Catch: Throwable -> L30
        goto L26
    L28:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r109, null);
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);
        throw th;
    }

    public a(long r100, long r101, boolean r102) {
        this.f560144a = r100;
        this.f560145b = r101;
        this.f560146c = r102;
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, null, null};
        f06.b r114 = new f06.b();
        d r115 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r114);
        if (r115.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r114, false);
        return (Cursor) r115.f474983b;
    L6:
        Cursor r116 = r110.query(r111, r112, r113, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r116, r114, true);
        return r116;
    }
}
