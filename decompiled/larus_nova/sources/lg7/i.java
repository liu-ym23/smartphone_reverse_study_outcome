package lg7;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v2.presistence.AppDatabase;
import com.bytedance.sync.v2.protocal.PacketStatus;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i extends EntityInsertionAdapter<mg7.d> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_history_synclog`(`sync_id`,`did`,`uid`,`sync_cursor`,`data`,`md5`,`business`,`consume_type`,`data_type`,`publish_ts`,`receive_ts`,`bucket`,`req_id`,`topic_type`,`packet_status`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public i(AppDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, mg7.d r101) {
        mg7.d r102 = r101;
        String r103 = r102.f513764a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f513765b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f513766c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        r100.bindLong(4, r102.f513767d);
        byte[] r106 = r102.f513768e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        String r107 = r102.f513769f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        r100.bindLong(7, r102.f513770g);
        r100.bindLong(8, r102.f513771h.getValue());
        DataType r108 = r102.f513772i;
        if (r108 != null) goto L25;
        int r109 = DataType.ORIGIN.getValue();
    L26:
        r100.bindLong(9, r109);
        r100.bindLong(10, r102.f513773j);
        r100.bindLong(11, r102.f513774k);
        r100.bindLong(12, kg7.a.a(r102.f513775l));
        String r110 = r102.f513776m;
        if (r110 != null) goto L29;
        r100.bindNull(13);
    L30:
        r100.bindLong(14, kg7.g.a(r102.f513777n));
        PacketStatus r111 = r102.f513778o;
        if (r111 != null) goto L33;
        int r112 = PacketStatus.Full.getValue();
    L34:
        r100.bindLong(15, r112);
        Map<String, String> r113 = r102.f513779p;
        String r114 = "";
        if (r113 == null) goto L39;
        r114 = new JSONObject(r113).toString();     // Catch: Exception -> L43
    L39:
        if (r114 != null) goto L41;
        r100.bindNull(16);
        return;
    L41:
        r100.bindString(16, r114);
        return;
    L33:
        r112 = r111.getValue();
        goto L34
    L29:
        r100.bindString(13, r110);
        goto L30
    L25:
        r109 = r108.getValue();
        goto L26
    L21:
        r100.bindString(6, r107);
        goto L22
    L17:
        r100.bindBlob(5, r106);
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
