package k25;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q0 implements Callable<List<String>> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ b1 b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<String> call2() throws Exception {
        Cursor r0 = DBUtil.query(this.b.a, this.a, false, null);
        ArrayList r1 = new ArrayList(r0.getCount());     // Catch: Throwable -> L10
    L5:
        if (r0.moveToNext() == false) goto L8;
        r1.add(r0.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r0.close();
        return r1;
    L10:
        th = move-exception;
        r0.close();
        throw th;
    }

    public final void finalize() {
        this.a.release();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<String> call() throws Exception {
        return call2();
    }

    public q0(b1 r1, RoomSQLiteQuery r2) {
        this.b = r1;
        this.a = r2;
    }
}
