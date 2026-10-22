package wka;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.google.gson.JsonArray;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import f06.d;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import vka.f;
import vka.k;
import vka.n;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements vka.b<JsonArray> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f560147d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f560148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f560149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f560150c;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        k r100 = new k();
        r100.a("event_id", this.f560148a);
        Pair<String, String[]> r101 = r100.b();
        String r102 = r101.component1();
        String[] r103 = r101.component2();
        Uri.Builder r104 = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(r104, this.f560149b);
        ContentUris.appendId(r104, this.f560150c);
        Uri r105 = r104.build();
        ContentResolver r106 = f.d();
        String[] r107 = {"event_id", GearStrategyConsts.EV_SELECT_BEGIN, "end"};
        f06.c r108 = new f06.c();
        Object[] r109 = {r105, r107, r102, r103, null};
        f06.b r110 = new f06.b();
        d r111 = r108.b(240004, "android/content/ContentResolver", "query", r106, r109, "android.database.Cursor", r110);
        if (r111.f474982a == false) goto L5;
        r108.a(240004, "android/content/ContentResolver", "query", r106, r109, null, r110, false);
        Cursor r112 = (Cursor) r111.f474983b;
        boolean r113 = true;
    L6:
        Cursor r114 = r112;
        JsonArray r115 = n.b(r114, r113);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r114, null);
        return r115;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);
        throw th;
    L5:
        r112 = r106.query(r105, r107, r102, r103, null);
        r113 = true;
        r108.a(240004, "android/content/ContentResolver", "query", r106, r109, r112, r110, true);
        goto L6
    }

    public b(Long r100, long r101, long r102) {
        this.f560148a = r100;
        this.f560149b = r101;
        this.f560150c = r102;
    }
}
