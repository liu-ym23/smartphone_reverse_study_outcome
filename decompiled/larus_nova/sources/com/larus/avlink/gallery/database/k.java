package com.larus.avlink.gallery.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes25.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f292473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f292474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f292475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f292476d;

    public class a implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f292477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f292478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f292479c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            StringBuilder r100 = StringUtil.newStringBuilder();
            r100.append("DELETE FROM thumbnail_metadata_table WHERE image_uuid IN (");
            int r101 = this.f292477a.size();
            StringUtil.appendPlaceholders(r100, r101);
            r100.append(") AND sn = ");
            r100.append("?");
            String r102 = r100.toString();
            SupportSQLiteStatement r103 = this.f292479c.f292473a.compileStatement(r102);
            Iterator r104 = this.f292477a.iterator();
            int r105 = 1;
        L4:
            if (r104.hasNext() == false) goto L6;
            r103.bindLong(r105, ((Long) r104.next()).longValue());
            r105 = r105 + 1;
            goto L4
        L6:
            int r106 = r101 + 1;
            String r107 = this.f292478b;
            if (r107 != null) goto L9;
            r103.bindNull(r106);
        L10:
            this.f292479c.f292473a.beginTransaction();
            Integer r108 = Integer.valueOf(r103.executeUpdateDelete());     // Catch: Throwable -> L14
            this.f292479c.f292473a.setTransactionSuccessful();     // Catch: Throwable -> L14
            this.f292479c.f292473a.endTransaction();
            return r108;
        L14:
            th = move-exception;
            this.f292479c.f292473a.endTransaction();
            throw th;
        L9:
            r103.bindString(r106, r107);
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public a(k r100, List r101, String r102) {
            this.f292479c = r100;
            this.f292477a = r101;
            this.f292478b = r102;
        }
    }

    public class b implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f292480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f292481b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            this.f292481b.f292473a.beginTransaction();
            long r100 = this.f292481b.f292474b.insertAndReturnId(this.f292480a);     // Catch: Throwable -> L6
            this.f292481b.f292473a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Long r101 = Long.valueOf(r100);     // Catch: Throwable -> L6
            this.f292481b.f292473a.endTransaction();
            return r101;
        L6:
            th = move-exception;
            this.f292481b.f292473a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Long call() throws Exception {
            return call();
        }

        public b(k r100, i r101) {
            this.f292481b = r100;
            this.f292480a = r101;
        }
    }

    public class c implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f292482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f292483b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            this.f292483b.f292473a.beginTransaction();
            int r100 = this.f292483b.f292475c.handle(this.f292482a) + 0;     // Catch: Throwable -> L6
            this.f292483b.f292473a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Integer r101 = Integer.valueOf(r100);     // Catch: Throwable -> L6
            this.f292483b.f292473a.endTransaction();
            return r101;
        L6:
            th = move-exception;
            this.f292483b.f292473a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public c(k r100, i r101) {
            this.f292483b = r100;
            this.f292482a = r101;
        }
    }

    public class d implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f292484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f292485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f292486c;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r100 = this.f292486c.f292476d.acquire();
            r100.bindLong(1, this.f292484a);
            String r101 = this.f292485b;
            if (r101 != null) goto L5;
            r100.bindNull(2);
        L6:
            this.f292486c.f292473a.beginTransaction();
            Integer r102 = Integer.valueOf(r100.executeUpdateDelete());     // Catch: Throwable -> L10
            this.f292486c.f292473a.setTransactionSuccessful();     // Catch: Throwable -> L10
            this.f292486c.f292473a.endTransaction();
            this.f292486c.f292476d.release(r100);
            return r102;
        L10:
            th = move-exception;
            this.f292486c.f292473a.endTransaction();
            this.f292486c.f292476d.release(r100);
            throw th;
        L5:
            r100.bindString(2, r101);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public d(k r100, long r101, String r102) {
            this.f292486c = r100;
            this.f292484a = r101;
            this.f292485b = r102;
        }
    }

    public class e implements Callable<List<i>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f292488b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<i> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292488b.f292473a, this.f292487a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L47
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "file_path");     // Catch: Throwable -> L47
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L47
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L47
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "sn");     // Catch: Throwable -> L47
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "image_uuid");     // Catch: Throwable -> L47
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L47
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L47
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L47
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L47
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L47
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "modify_time");     // Catch: Throwable -> L47
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "download_time");     // Catch: Throwable -> L47
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L47
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L45
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "processing_status");     // Catch: Throwable -> L45
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "is_synced");     // Catch: Throwable -> L45
            int r119 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L45
        L5:
            if (r100.moveToNext() == false) goto L43;
            if (r100.isNull(r101) == false) goto L10;
            String r210 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r211 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r212 = null;
        L19:
            long r213 = r100.getLong(r104);     // Catch: Throwable -> L45
            if (r100.isNull(r105) == false) goto L22;
            String r214 = null;
        L23:
            long r215 = r100.getLong(r106);     // Catch: Throwable -> L45
            if (r100.isNull(r110) == false) goto L26;
            String r216 = null;
        L27:
            int r310 = r100.getInt(r111);     // Catch: Throwable -> L45
            int r311 = r100.getInt(r112);     // Catch: Throwable -> L45
            long r312 = r100.getLong(r113);     // Catch: Throwable -> L45
            long r313 = r100.getLong(r114);     // Catch: Throwable -> L45
            long r314 = r100.getLong(r115);     // Catch: Throwable -> L45
            long r315 = r100.getLong(r107);     // Catch: Throwable -> L45
            int r120 = r119;
            if (r100.isNull(r120) == false) goto L31;
            String r410 = null;
        L30:
            int r411 = r116;
            int r121 = r101;
            if (r100.isNull(r411) == false) goto L36;
            String r412 = null;
        L35:
            int r413 = r117;
            int r414 = r100.getInt(r413);     // Catch: Throwable -> L45
            r118 = r118;
            if (r100.getInt(r118) == 0) goto L40;
            boolean r415 = true;
        L41:
            r109.add(new i(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r410, r412, r414, r415));     // Catch: Throwable -> L45
            r101 = r121;
            r116 = r411;
            r117 = r413;
            r119 = r120;
            goto L5
        L40:
            r415 = false;
            goto L41
        L36:
            r412 = r100.getString(r411);     // Catch: Throwable -> L45
            goto L35
        L31:
            r410 = r100.getString(r120);     // Catch: Throwable -> L45
            goto L30
        L26:
            r216 = r100.getString(r110);     // Catch: Throwable -> L45
            goto L27
        L22:
            r214 = r100.getString(r105);     // Catch: Throwable -> L45
            goto L23
        L18:
            r212 = r100.getString(r103);     // Catch: Throwable -> L45
            goto L19
        L14:
            r211 = r100.getString(r102);     // Catch: Throwable -> L45
            goto L16
        L10:
            r210 = r100.getString(r101);     // Catch: Throwable -> L45
            goto L12
        L43:
            r100.close();
            this.f292487a.release();
            return r109;
        L45:
            th = th;
            e r122 = this;
        L49:
            r100.close();
            r122.f292487a.release();
            throw th;
        L47:
            th = th;
            r122 = this;
            goto L49
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<i> call() throws Exception {
            return call2();
        }

        public e(k r100, RoomSQLiteQuery r101) {
            this.f292488b = r100;
            this.f292487a = r101;
        }
    }

    public class f implements Callable<List<i>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f292490b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<i> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292490b.f292473a, this.f292489a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L47
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "file_path");     // Catch: Throwable -> L47
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L47
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L47
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "sn");     // Catch: Throwable -> L47
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "image_uuid");     // Catch: Throwable -> L47
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L47
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L47
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L47
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L47
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L47
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "modify_time");     // Catch: Throwable -> L47
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "download_time");     // Catch: Throwable -> L47
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L47
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L45
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "processing_status");     // Catch: Throwable -> L45
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "is_synced");     // Catch: Throwable -> L45
            int r119 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L45
        L5:
            if (r100.moveToNext() == false) goto L43;
            if (r100.isNull(r101) == false) goto L10;
            String r210 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r211 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r212 = null;
        L19:
            long r213 = r100.getLong(r104);     // Catch: Throwable -> L45
            if (r100.isNull(r105) == false) goto L22;
            String r214 = null;
        L23:
            long r215 = r100.getLong(r106);     // Catch: Throwable -> L45
            if (r100.isNull(r110) == false) goto L26;
            String r216 = null;
        L27:
            int r310 = r100.getInt(r111);     // Catch: Throwable -> L45
            int r311 = r100.getInt(r112);     // Catch: Throwable -> L45
            long r312 = r100.getLong(r113);     // Catch: Throwable -> L45
            long r313 = r100.getLong(r114);     // Catch: Throwable -> L45
            long r314 = r100.getLong(r115);     // Catch: Throwable -> L45
            long r315 = r100.getLong(r107);     // Catch: Throwable -> L45
            int r120 = r119;
            if (r100.isNull(r120) == false) goto L31;
            String r410 = null;
        L30:
            int r411 = r116;
            int r121 = r101;
            if (r100.isNull(r411) == false) goto L36;
            String r412 = null;
        L35:
            int r413 = r117;
            int r414 = r100.getInt(r413);     // Catch: Throwable -> L45
            r118 = r118;
            if (r100.getInt(r118) == 0) goto L40;
            boolean r415 = true;
        L41:
            r109.add(new i(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r410, r412, r414, r415));     // Catch: Throwable -> L45
            r101 = r121;
            r116 = r411;
            r117 = r413;
            r119 = r120;
            goto L5
        L40:
            r415 = false;
            goto L41
        L36:
            r412 = r100.getString(r411);     // Catch: Throwable -> L45
            goto L35
        L31:
            r410 = r100.getString(r120);     // Catch: Throwable -> L45
            goto L30
        L26:
            r216 = r100.getString(r110);     // Catch: Throwable -> L45
            goto L27
        L22:
            r214 = r100.getString(r105);     // Catch: Throwable -> L45
            goto L23
        L18:
            r212 = r100.getString(r103);     // Catch: Throwable -> L45
            goto L19
        L14:
            r211 = r100.getString(r102);     // Catch: Throwable -> L45
            goto L16
        L10:
            r210 = r100.getString(r101);     // Catch: Throwable -> L45
            goto L12
        L43:
            r100.close();
            this.f292489a.release();
            return r109;
        L45:
            th = th;
            f r122 = this;
        L49:
            r100.close();
            r122.f292489a.release();
            throw th;
        L47:
            th = th;
            r122 = this;
            goto L49
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<i> call() throws Exception {
            return call2();
        }

        public f(k r100, RoomSQLiteQuery r101) {
            this.f292490b = r100;
            this.f292489a = r101;
        }
    }

    public k(AlbumDatabase r100) {
        this.f292473a = r100;
        this.f292474b = new l(r100);
        this.f292475c = new m(r100);
        this.f292476d = new n(r100);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object f(Continuation<? super List<i>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM thumbnail_metadata_table ORDER BY create_time DESC", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292473a, false, r102, new e(this, r101), r100);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object e(i r100, Continuation<? super Long> r101) {
        return CoroutinesRoom.execute(this.f292473a, true, new b(this, r100), r101);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object g(i r100, Continuation<? super Integer> r101) {
        return CoroutinesRoom.execute(this.f292473a, true, new c(this, r100), r101);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object a(long r100, String r101, Continuation<? super Integer> r102) {
        return CoroutinesRoom.execute(this.f292473a, true, new d(this, r100, r101), r102);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object b(long r100, String r101, ContinuationImpl r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM thumbnail_metadata_table WHERE image_uuid = ? AND sn = ? LIMIT 1", 2);
        r103.bindLong(1, r100);
        if (r101 != null) goto L5;
        r103.bindNull(2);
    L6:
        CancellationSignal r104 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292473a, false, r104, new o(this, r103), r102);
    L5:
        r103.bindString(2, r101);
        goto L6
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object c(List<Long> r100, String r101, Continuation<? super Integer> r102) {
        return CoroutinesRoom.execute(this.f292473a, true, new a(this, r100, r101), r102);
    }

    @Override // com.larus.avlink.gallery.database.j
    public final Object d(List<Long> r100, String r101, Continuation<? super List<i>> r102) {
        StringBuilder r103 = StringUtil.newStringBuilder();
        r103.append("SELECT * FROM thumbnail_metadata_table WHERE image_uuid IN (");
        int r104 = r100.size();
        StringUtil.appendPlaceholders(r103, r104);
        r103.append(") AND sn = ");
        r103.append("?");
        int r105 = r104 + 1;
        RoomSQLiteQuery r106 = RoomSQLiteQuery.acquire(r103.toString(), r105);
        Iterator<Long> r107 = r100.iterator();
        int r108 = 1;
    L4:
        if (r107.hasNext() == false) goto L6;
        r106.bindLong(r108, r107.next().longValue());
        r108 = r108 + 1;
        goto L4
    L6:
        if (r101 != null) goto L8;
        r106.bindNull(r105);
    L9:
        CancellationSignal r109 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292473a, false, r109, new f(this, r106), r102);
    L8:
        r106.bindString(r105, r101);
        goto L9
    }
}
