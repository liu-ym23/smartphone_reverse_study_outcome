package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class d3 extends EntityInsertionAdapter<b3> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `WikiSpace` (`space_id`,`user_id`,`space_name`,`space_icon`,`attr`,`description`,`is_star`,`browse_time`,`wiki_token`,`obj_type`,`obj_token`,`origin`,`thumbnail`,`cover_key`,`is_graph_dark`,`color_value`,`wiki_scope`,`space_type`,`open_sharing`,`tag_type`,`tag_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d3(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, b3 r101) {
        b3 r102 = r101;
        String r103 = r102.f512923a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f512924b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f512925c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f512926d;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        r100.bindLong(5, r102.f512927e);
        String r107 = r102.f512928f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        r100.bindLong(7, r102.f512929g ? 1 : 0);
        String r108 = r102.f512930h;
        if (r108 != null) goto L25;
        r100.bindNull(8);
    L26:
        String r109 = r102.f512931i;
        if (r109 != null) goto L29;
        r100.bindNull(9);
    L30:
        r100.bindLong(10, r102.f512932j);
        String r110 = r102.f512933k;
        if (r110 != null) goto L33;
        r100.bindNull(11);
    L34:
        String r111 = r102.f512934l;
        if (r111 != null) goto L37;
        r100.bindNull(12);
    L38:
        String r112 = r102.f512935m;
        if (r112 != null) goto L41;
        r100.bindNull(13);
    L42:
        String r113 = r102.f512936n;
        if (r113 != null) goto L45;
        r100.bindNull(14);
    L46:
        r100.bindLong(15, r102.f512937o ? 1 : 0);
        String r114 = r102.f512938p;
        if (r114 != null) goto L49;
        r100.bindNull(16);
    L50:
        r100.bindLong(17, r102.f512939q);
        r100.bindLong(18, r102.f512940r);
        r100.bindLong(19, r102.f512941s);
        r100.bindLong(20, r102.f512942t);
        String r115 = r102.f512943u;
        if (r115 != null) goto L53;
        r100.bindNull(21);
        return;
    L53:
        r100.bindString(21, r115);
        return;
    L49:
        r100.bindString(16, r114);
        goto L50
    L45:
        r100.bindString(14, r113);
        goto L46
    L41:
        r100.bindString(13, r112);
        goto L42
    L37:
        r100.bindString(12, r111);
        goto L38
    L33:
        r100.bindString(11, r110);
        goto L34
    L29:
        r100.bindString(9, r109);
        goto L30
    L25:
        r100.bindString(8, r108);
        goto L26
    L21:
        r100.bindString(6, r107);
        goto L22
    L17:
        r100.bindString(4, r106);
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
