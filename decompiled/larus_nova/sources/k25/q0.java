package k25;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes16.dex */
public final class q0 implements Callable<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f501564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f501565b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<String> call2() throws Exception {
        Cursor r100 = DBUtil.query(this.f501565b.f501476a, this.f501564a, false, null);
        ArrayList r101 = new ArrayList(r100.getCount());     // Catch: Throwable -> L10
    L5:
        if (r100.moveToNext() == false) goto L8;
        r101.add(r100.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r100.close();
        return r101;
    L10:
        th = move-exception;
        r100.close();
        throw th;
    }

    public final void finalize() {
        this.f501564a.release();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<String> call() throws Exception {
        return call2();
    }

    public q0(b1 r100, RoomSQLiteQuery r101) {
        this.f501565b = r100;
        this.f501564a = r101;
    }
}
