package com.larus.avlink.gallery.database;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `media_metadata_table` (`id`,`media_id`,`system_gallery_id`,`file_name`,`file_size`,`media_type`,`width`,`height`,`duration`,`out_video_width`,`out_video_height`,`output_video_crop`,`create_time`,`geo_location_info`,`algorithm_type`,`lifecycle_state`,`failure_stage`,`failure_reason`,`download_file_path`,`temp_file_path`,`unpack_dir_path`,`processed_file_path`,`final_file_path`,`active_mask`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public f(AlbumDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        String r103 = r102.f292401a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f292402b);
        Long r104 = r102.f292403c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f292404d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        Long r106 = r102.f292405e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        String r107 = r102.f292406f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        r100.bindLong(7, r102.f292407g);
        r100.bindLong(8, r102.f292408h);
        r100.bindLong(9, r102.f292409i);
        r100.bindLong(10, r102.f292410j);
        r100.bindLong(11, r102.f292411k);
        r100.bindDouble(12, r102.f292412l);
        r100.bindLong(13, r102.f292413m);
        String r108 = r102.f292414n;
        if (r108 != null) goto L25;
        r100.bindNull(14);
    L26:
        String r109 = r102.f292415o;
        if (r109 != null) goto L29;
        r100.bindNull(15);
    L30:
        r100.bindLong(16, r102.f292416p);
        Integer r110 = r102.f292417q;
        if (r110 != null) goto L33;
        r100.bindNull(17);
    L34:
        String r111 = r102.f292418r;
        if (r111 != null) goto L37;
        r100.bindNull(18);
    L38:
        String r112 = r102.f292419s;
        if (r112 != null) goto L41;
        r100.bindNull(19);
    L42:
        String r113 = r102.f292420t;
        if (r113 != null) goto L45;
        r100.bindNull(20);
    L46:
        String r114 = r102.f292421u;
        if (r114 != null) goto L49;
        r100.bindNull(21);
    L50:
        String r115 = r102.f292422v;
        if (r115 != null) goto L53;
        r100.bindNull(22);
    L54:
        String r116 = r102.f292423w;
        if (r116 != null) goto L57;
        r100.bindNull(23);
    L58:
        r100.bindLong(24, r102.f292424x);
        return;
    L57:
        r100.bindString(23, r116);
        goto L58
    L53:
        r100.bindString(22, r115);
        goto L54
    L49:
        r100.bindString(21, r114);
        goto L50
    L45:
        r100.bindString(20, r113);
        goto L46
    L41:
        r100.bindString(19, r112);
        goto L42
    L37:
        r100.bindString(18, r111);
        goto L38
    L33:
        r100.bindLong(17, r110.intValue());
        goto L34
    L29:
        r100.bindString(15, r109);
        goto L30
    L25:
        r100.bindString(14, r108);
        goto L26
    L21:
        r100.bindString(6, r107);
        goto L22
    L17:
        r100.bindLong(5, r106.longValue());
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindLong(3, r104.longValue());
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
