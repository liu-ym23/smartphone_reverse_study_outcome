package ck5;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Callable<List<Notification>> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ h b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Notification> call2() throws Exception {
        Cursor r0 = DBUtil.query(this.b.a, this.a, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r0, ResourceData.KEY_ID);     // Catch: Throwable -> L14
        int r2 = CursorUtil.getColumnIndexOrThrow(r0, "start_time");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r0, "end_time");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r0, "content");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r0, "product");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r0, "close");     // Catch: Throwable -> L14
        ArrayList r8 = new ArrayList(r0.getCount());     // Catch: Throwable -> L14
    L5:
        if (r0.moveToNext() == false) goto L12;
        Notification r9 = new Notification();     // Catch: Throwable -> L14
        r9.setId(r0.getString(r1));     // Catch: Throwable -> L14
        r9.setStart_time(r0.getLong(r2));     // Catch: Throwable -> L14
        r9.setEnd_time(r0.getLong(r4));     // Catch: Throwable -> L14
        String r10 = r0.getString(r5);     // Catch: Throwable -> L14
        this.b.c.getClass();     // Catch: Throwable -> L14
        r9.setContent((Notification.ContentBean) JSON.parseObject(r10, Notification.ContentBean.class));     // Catch: Throwable -> L14
        String r11 = r0.getString(r6);     // Catch: Throwable -> L14
        this.b.c.getClass();     // Catch: Throwable -> L14
        r9.setProducts((List) JSON.parseObject(r11, new a.C0012a().getType(), new Feature[0]));     // Catch: Throwable -> L14
        if (r0.getInt(r7) == 0) goto L9;
        boolean r12 = true;
    L10:
        r9.setClose(r12);     // Catch: Throwable -> L14
        r8.add(r9);     // Catch: Throwable -> L14
        goto L5
    L9:
        r12 = false;
        goto L10
    L12:
        r0.close();
        return r8;
    L14:
        th = move-exception;
        r0.close();
        throw th;
    }

    public final void finalize() {
        this.a.release();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Notification> call() throws Exception {
        return call2();
    }

    public g(h r1, RoomSQLiteQuery r2) {
        this.b = r1;
        this.a = r2;
    }
}
