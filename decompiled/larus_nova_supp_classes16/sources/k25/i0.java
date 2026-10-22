package k25;

import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i0 implements ju5.m {
    public final /* synthetic */ e0 a;

    public i0(e0 r1) {
        this.a = r1;
    }

    public final int a(List<String> r5) {
        j25.p r0 = (j25.p) this.a.q().d();
        r0.a.assertNotSuspendingTransaction();
        StringBuilder r1 = StringUtil.newStringBuilder();
        r1.append("DELETE FROM file_model WHERE token IN(");
        StringUtil.appendPlaceholders(r1, r5.size());
        r1.append(")");
        String r2 = r1.toString();
        SupportSQLiteStatement r3 = r0.a.compileStatement(r2);
        Iterator<String> r6 = r5.iterator();
        int r4 = 1;
    L4:
        if (r6.hasNext() == false) goto L10;
        String r7 = r6.next();
        if (r7 != null) goto L8;
        r3.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r3.bindString(r4, r7);
        goto L9
    L10:
        r0.a.beginTransaction();
        int r8 = r3.executeUpdateDelete();     // Catch: Throwable -> L14
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        r0.a.endTransaction();
        return r8;
    L14:
        th = move-exception;
        r0.a.endTransaction();
        throw th;
    }
}
