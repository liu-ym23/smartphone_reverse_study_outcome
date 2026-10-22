package com.larus.bmhome.chat.model.repo;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "deprecated new database is IMDatabase")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/ChatDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "chatDao", "Lcom/larus/bmhome/chat/model/repo/ChatDao;", "conversationDao", "Lcom/larus/bmhome/chat/model/repo/ConversationDao;", "botDao", "Lcom/larus/bmhome/chat/model/repo/BotDao;", "Companion", "Migrations", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChatDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<ChatDatabase> f307593a = null;

    public static final class Migrations {
        public static final ChatDatabase$Migrations$MIGRATION_30_31$1 A = null;
        public static final ChatDatabase$Migrations$MIGRATION_31_32$1 B = null;
        public static final ChatDatabase$Migrations$MIGRATION_32_33$1 C = null;
        public static final ChatDatabase$Migrations$MIGRATION_33_34$1 D = null;
        public static final ChatDatabase$Migrations$MIGRATION_34_35$1 E = null;
        public static final ChatDatabase$Migrations$MIGRATION_35_36$1 F = null;
        public static final ChatDatabase$Migrations$MIGRATION_36_37$1 G = null;
        public static final ChatDatabase$Migrations$MIGRATION_37_38$1 H = null;
        public static final ChatDatabase$Migrations$MIGRATION_38_39$1 I = null;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_39_40$1 f307594J = null;
        public static final ChatDatabase$Migrations$MIGRATION_40_41$1 K = null;
        public static final ChatDatabase$Migrations$MIGRATION_41_42$1 L = null;
        public static final ChatDatabase$Migrations$MIGRATION_42_43$1 M = null;
        public static final ChatDatabase$Migrations$MIGRATION_43_44$1 N = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_1_2$1 f307595a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_2_3$1 f307596b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_3_4$1 f307597c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_5_6$1 f307598d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_8_9$1 f307599e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_9_10$1 f307600f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_10_11$1 f307601g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_11_12$1 f307602h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_13_14$1 f307603i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_14_15$1 f307604j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_15_16$1 f307605k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_14_16$1 f307606l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_16_17$1 f307607m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_17_18$1 f307608n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_18_19$1 f307609o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_19_20$1 f307610p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_20_21$1 f307611q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_21_22$1 f307612r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_22_23$1 f307613s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_23_24$1 f307614t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_24_25$1 f307615u = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_25_26$1 f307616v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_26_27$1 f307617w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_27_28$1 f307618x = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_28_29$1 f307619y = null;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final ChatDatabase$Migrations$MIGRATION_29_30$1 f307620z = null;

        public Migrations() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_1_2$1] */
        /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_14_15$1] */
        /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_15_16$1] */
        /* JADX WARN: Type inference failed for: r0v12, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_14_16$1] */
        /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_16_17$1] */
        /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_17_18$1] */
        /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_18_19$1] */
        /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_19_20$1] */
        /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_20_21$1] */
        /* JADX WARN: Type inference failed for: r0v18, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_21_22$1] */
        /* JADX WARN: Type inference failed for: r0v19, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_22_23$1] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_2_3$1] */
        /* JADX WARN: Type inference failed for: r0v20, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_23_24$1] */
        /* JADX WARN: Type inference failed for: r0v21, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_24_25$1] */
        /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_25_26$1] */
        /* JADX WARN: Type inference failed for: r0v23, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_26_27$1] */
        /* JADX WARN: Type inference failed for: r0v24, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_27_28$1] */
        /* JADX WARN: Type inference failed for: r0v25, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_28_29$1] */
        /* JADX WARN: Type inference failed for: r0v26, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_29_30$1] */
        /* JADX WARN: Type inference failed for: r0v27, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_30_31$1] */
        /* JADX WARN: Type inference failed for: r0v28, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_31_32$1] */
        /* JADX WARN: Type inference failed for: r0v29, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_32_33$1] */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_3_4$1] */
        /* JADX WARN: Type inference failed for: r0v30, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_33_34$1] */
        /* JADX WARN: Type inference failed for: r0v31, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_34_35$1] */
        /* JADX WARN: Type inference failed for: r0v32, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_35_36$1] */
        /* JADX WARN: Type inference failed for: r0v33, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_36_37$1] */
        /* JADX WARN: Type inference failed for: r0v34, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_37_38$1] */
        /* JADX WARN: Type inference failed for: r0v35, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_38_39$1] */
        /* JADX WARN: Type inference failed for: r0v36, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_39_40$1] */
        /* JADX WARN: Type inference failed for: r0v37, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_40_41$1] */
        /* JADX WARN: Type inference failed for: r0v38, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_41_42$1] */
        /* JADX WARN: Type inference failed for: r0v39, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_42_43$1] */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_5_6$1] */
        /* JADX WARN: Type inference failed for: r0v40, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_43_44$1] */
        /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_8_9$1] */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_9_10$1] */
        /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_10_11$1] */
        /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_11_12$1] */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.bmhome.chat.model.repo.ChatDatabase$Migrations$MIGRATION_13_14$1] */
        static {
            f307595a = new ChatDatabase$Migrations$MIGRATION_1_2$1();
            f307596b = new ChatDatabase$Migrations$MIGRATION_2_3$1();
            f307597c = new ChatDatabase$Migrations$MIGRATION_3_4$1();
            f307598d = new ChatDatabase$Migrations$MIGRATION_5_6$1();
            f307599e = new ChatDatabase$Migrations$MIGRATION_8_9$1();
            f307600f = new ChatDatabase$Migrations$MIGRATION_9_10$1();
            f307601g = new ChatDatabase$Migrations$MIGRATION_10_11$1();
            f307602h = new ChatDatabase$Migrations$MIGRATION_11_12$1();
            f307603i = new ChatDatabase$Migrations$MIGRATION_13_14$1();
            f307604j = new ChatDatabase$Migrations$MIGRATION_14_15$1();
            f307605k = new ChatDatabase$Migrations$MIGRATION_15_16$1();
            f307606l = new ChatDatabase$Migrations$MIGRATION_14_16$1();
            f307607m = new ChatDatabase$Migrations$MIGRATION_16_17$1();
            f307608n = new ChatDatabase$Migrations$MIGRATION_17_18$1();
            f307609o = new ChatDatabase$Migrations$MIGRATION_18_19$1();
            f307610p = new ChatDatabase$Migrations$MIGRATION_19_20$1();
            f307611q = new ChatDatabase$Migrations$MIGRATION_20_21$1();
            f307612r = new ChatDatabase$Migrations$MIGRATION_21_22$1();
            f307613s = new ChatDatabase$Migrations$MIGRATION_22_23$1();
            f307614t = new ChatDatabase$Migrations$MIGRATION_23_24$1();
            f307615u = new ChatDatabase$Migrations$MIGRATION_24_25$1();
            f307616v = new ChatDatabase$Migrations$MIGRATION_25_26$1();
            f307617w = new ChatDatabase$Migrations$MIGRATION_26_27$1();
            f307618x = new ChatDatabase$Migrations$MIGRATION_27_28$1();
            f307619y = new ChatDatabase$Migrations$MIGRATION_28_29$1();
            f307620z = new ChatDatabase$Migrations$MIGRATION_29_30$1();
            A = new ChatDatabase$Migrations$MIGRATION_30_31$1();
            B = new ChatDatabase$Migrations$MIGRATION_31_32$1();
            C = new ChatDatabase$Migrations$MIGRATION_32_33$1();
            D = new ChatDatabase$Migrations$MIGRATION_33_34$1();
            E = new ChatDatabase$Migrations$MIGRATION_34_35$1();
            F = new ChatDatabase$Migrations$MIGRATION_35_36$1();
            G = new ChatDatabase$Migrations$MIGRATION_36_37$1();
            H = new ChatDatabase$Migrations$MIGRATION_37_38$1();
            I = new ChatDatabase$Migrations$MIGRATION_38_39$1();
            f307594J = new ChatDatabase$Migrations$MIGRATION_39_40$1();
            K = new ChatDatabase$Migrations$MIGRATION_40_41$1();
            L = new ChatDatabase$Migrations$MIGRATION_41_42$1();
            M = new ChatDatabase$Migrations$MIGRATION_42_43$1();
            N = new ChatDatabase$Migrations$MIGRATION_43_44$1();
        }

        public static final boolean a(SupportSQLiteDatabase r100, String r101, String r102) {
            Cursor r103 = r100.query("PRAGMA table_info(" + r101 + ')');
            int r104 = r103.getColumnIndex("name");
            if (r104 != (-1)) goto L6;
            r103.close();
        L11:
            return false;
        L6:
            if (r103.moveToNext() == false) goto L10;
            if (StringsKt.equals(r103.getString(r104), r102, true) == false) goto L6;
            r103.close();
            return true;
        L10:
            r103.close();
            goto L11
        }
    }

    public static final class a {
    }

    public abstract com.larus.bmhome.chat.model.repo.a c();

    public abstract j0 d();

    public abstract j1 e();

    static {
        f307593a = LazyKt.lazy(new l0());
    }

    public ChatDatabase() {
    }
}
