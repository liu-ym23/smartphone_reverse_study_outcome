package com.larus.avlink.gallery.database;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class m extends EntityDeletionOrUpdateAdapter<i> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `thumbnail_metadata_table` SET `id` = ?,`file_path` = ?,`file_name` = ?,`file_size` = ?,`sn` = ?,`image_uuid` = ?,`media_type` = ?,`width` = ?,`height` = ?,`duration` = ?,`create_time` = ?,`modify_time` = ?,`download_time` = ?,`geo_location_info` = ?,`source_type` = ?,`processing_status` = ?,`is_synced` = ? WHERE `id` = ?";
    }

    public m(AlbumDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, i r101) {
        i r102 = r101;
        String r103 = r102.f292456a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f292457b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f292458c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        r100.bindLong(4, r102.f292459d);
        String r106 = r102.f292460e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        r100.bindLong(6, r102.f292461f);
        String r107 = r102.f292462g;
        if (r107 != null) goto L21;
        r100.bindNull(7);
    L22:
        r100.bindLong(8, r102.f292463h);
        r100.bindLong(9, r102.f292464i);
        r100.bindLong(10, r102.f292465j);
        r100.bindLong(11, r102.f292466k);
        r100.bindLong(12, r102.f292467l);
        r100.bindLong(13, r102.f292468m);
        String r108 = r102.f292469n;
        if (r108 != null) goto L25;
        r100.bindNull(14);
    L26:
        String r109 = r102.f292470o;
        if (r109 != null) goto L29;
        r100.bindNull(15);
    L30:
        r100.bindLong(16, r102.f292471p);
        r100.bindLong(17, r102.f292472q ? 1 : 0);
        String r110 = r102.f292456a;
        if (r110 != null) goto L33;
        r100.bindNull(18);
        return;
    L33:
        r100.bindString(18, r110);
        return;
    L29:
        r100.bindString(15, r109);
        goto L30
    L25:
        r100.bindString(14, r108);
        goto L26
    L21:
        r100.bindString(7, r107);
        goto L22
    L17:
        r100.bindString(5, r106);
        goto L18
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
