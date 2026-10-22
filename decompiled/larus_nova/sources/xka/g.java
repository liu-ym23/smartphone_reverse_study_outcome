package xka;

import android.content.ContentValues;
import android.database.Cursor;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g implements vka.b<Boolean> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f564297d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f564299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f564300c;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Long r101 = this.f564299b;
        if (r101 == null) goto L6;
        long r102 = r101.longValue();
    L5:
        long r110 = r102;
        Long r103 = this.f564300c;
        if (r103 == null) goto L30;
        long r104 = r103.longValue();
        int r105 = 1;
    L51:
        ContentValues r106 = new ContentValues();
        r106.put("calendar_id", Long.valueOf(r104));
        ala.b r107 = new ala.b(null, "anonymous");
        String[] r108 = new String[r105];
        r108[0] = String.valueOf(r110);
        int r109 = r100.update(r107, r106, "calendar_id = ?", r108);
        com.bytedance.ai.utils.g r111 = com.bytedance.ai.utils.g.f37637a;
        r111.d("MergeCalendarOp", "merge events: affected " + r109 + " rows");
        r111.d("MergeCalendarOp", "delete calendar: affected " + r100.delete(new ala.a(Long.valueOf(r110), "anonymous"), null, null) + " rows");
        return Boolean.TRUE;
    L30:
        r105 = 1;
        Cursor r112 = r100.query(new ala.a(null, 3), new String[]{DBDefinition.ID}, "name = ? AND account_type = ?", new String[]{this.f564298a, AccountType.LOCAL}, null);
        if (r112 == null) goto L48;
        Cursor r113 = r112;
        Cursor r114 = r113;     // Catch: Throwable -> L42
        if (r114.moveToFirst() == true) goto L36;
    L40:
        Long r115 = null;
    L41:
        CloseableKt.closeFinally(r113, null);
    L49:
        if (r115 == null) goto L64;
        r104 = r115.longValue();
        goto L51
    L64:
        return Boolean.FALSE;
    L36:
        if (r114.isNull(0) == true) goto L40;
        r115 = Long.valueOf(r114.getLong(0));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);
        throw th;
    L48:
        r115 = null;
        goto L49
    L6:
        Cursor r116 = r100.query(new ala.a(null, 3), new String[]{DBDefinition.ID}, "name = ? AND account_name = ? AND account_type = ?", new String[]{"anonymous", "anonymous", AccountType.LOCAL}, null);
        if (r116 == null) goto L24;
        Cursor r117 = r116;
        Cursor r118 = r117;     // Catch: Throwable -> L18
        if (r118.moveToFirst() == true) goto L12;
    L16:
        Long r119 = null;
    L17:
        CloseableKt.closeFinally(r117, null);
    L25:
        if (r119 == null) goto L54;
        r102 = r119.longValue();
        goto L5
    L54:
        return Boolean.FALSE;
    L12:
        if (r118.isNull(0) == true) goto L16;
        r119 = Long.valueOf(r118.getLong(0));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);
        throw th;
    L24:
        r119 = null;
        goto L25
    }

    public g(String r100, Long r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "accountName");
        this.f564298a = r100;
        this.f564299b = r101;
        this.f564300c = r102;
    }
}
