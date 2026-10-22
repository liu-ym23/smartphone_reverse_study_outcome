package xka;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.google.gson.JsonArray;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f564313e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f564314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f564315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f564316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f564317d;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(vka.f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        vka.k r100 = new vka.k();
        r100.a("event_id", this.f564315b);
        Pair<String, String[]> r101 = r100.b();
        String r102 = r101.component1();
        String[] r103 = r101.component2();
        Uri.Builder r104 = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(r104, this.f564316c);
        ContentUris.appendId(r104, this.f564317d);
        Uri r105 = r104.build();
        ContentResolver r106 = vka.f.d();
        String[] r107 = this.f564314a;
        f06.c r108 = new f06.c();
        Object[] r109 = {r105, r107, r102, r103, null};
        f06.b r110 = new f06.b();
        f06.d r111 = r108.b(240004, "android/content/ContentResolver", "query", r106, r109, "android.database.Cursor", r110);
        if (r111.f474982a == false) goto L5;
        r108.a(240004, "android/content/ContentResolver", "query", r106, r109, null, r110, false);
        Cursor r112 = (Cursor) r111.f474983b;
    L6:
        Cursor r113 = r112;
        JsonArray r114 = vka.n.b(r113, false);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r113, null);
        return r114;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);
        throw th;
    L5:
        Cursor r115 = r106.query(r105, r107, r102, r103, null);
        r108.a(240004, "android/content/ContentResolver", "query", r106, r109, r115, r110, true);
        r112 = r115;
        goto L6
    }

    public j(String[] r100, Long r101, long r102, long r103) {
        this.f564314a = r100;
        this.f564315b = r101;
        this.f564316c = r102;
        this.f564317d = r103;
    }
}
