package com.larus.bmhome.chat.model.repo;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.bmhome.chat.bean.ChatBot;
import com.larus.bmhome.chat.bean.ChatConversation;

/* JADX INFO: loaded from: classes25.dex */
public final class k1 implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f307824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatConversation.b f307825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatBot.b f307826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f307827d;

    public class a extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `member_list` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }
    }

    public class a0 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `priority` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public a0(RoomDatabase r100) {
            super(r100);
        }
    }

    public class b extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `tags` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public b(RoomDatabase r100) {
            super(r100);
        }
    }

    public class b0 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `status` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public b0(RoomDatabase r100) {
            super(r100);
        }
    }

    public class c extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_section` = ?\n        WHERE `conversation_id` = ?\n        AND `last_section` != ?\n    ";
        }

        public c(RoomDatabase r100) {
            super(r100);
        }
    }

    public class c0 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `name` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public c0(RoomDatabase r100) {
            super(r100);
        }
    }

    public class d extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `config` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public d(RoomDatabase r100) {
            super(r100);
        }
    }

    public class d0 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `owner` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public d0(RoomDatabase r100) {
            super(r100);
        }
    }

    public class e extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `prefer` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public e(RoomDatabase r100) {
            super(r100);
        }
    }

    public class e0 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `avatar` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public e0(RoomDatabase r100) {
            super(r100);
        }
    }

    public class f extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_message_index` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public f(RoomDatabase r100) {
            super(r100);
        }
    }

    public class f0 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `templates` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public f0(RoomDatabase r100) {
            super(r100);
        }
    }

    public class g extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_message_index` = ?\n        WHERE `conversation_id` = ? AND `last_message_index` = ?\n    ";
        }

        public g(RoomDatabase r100) {
            super(r100);
        }
    }

    public class h extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `last_message_id` = ?, `last_message_time` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public h(RoomDatabase r100) {
            super(r100);
        }
    }

    public class i extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE `chat_conversation` SET `conversation_id` = ? WHERE `conversation_id` = ?";
        }

        public i(RoomDatabase r100) {
            super(r100);
        }
    }

    public class j extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE `chat_conversation` SET `is_local` = ? WHERE `conversation_id` = ?";
        }

        public j(RoomDatabase r100) {
            super(r100);
        }
    }

    public class k extends EntityInsertionAdapter<ChatConversation> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1 f307828a;

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `chat_conversation` (`id`,`conversation_id`,`conversation_type`,`name`,`avatar`,`icon_image`,`time`,`update_time`,`type`,`status`,`owner`,`priority`,`last_section`,`last_message_id`,`last_message_time`,`member_list`,`last_message_index`,`prefer`,`config`,`is_local`,`recommend_bot_index`,`subtitle_message_id`,`tags`,`pinned`,`conversation_page`,`templates`,`bio`,`bot_stats`,`bot_type`,`bg_img_url`,`bg_img_avg_hue`,`bot_conversation_type`,`content_dist_type`,`default_onboarding`,`creator_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        public k(k1 r100, RoomDatabase r101) {
            this.f307828a = r100;
            super(r101);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, ChatConversation r101) {
            ChatConversation r102 = r101;
            r102.getClass();
            r100.bindNull(1);
            r100.bindNull(2);
            r100.bindNull(3);
            r100.bindNull(4);
            r100.bindNull(5);
            this.f307828a.f307825b.getClass();
            r100.bindNull(6);
            r100.bindNull(7);
            r100.bindNull(8);
            if (r102.getType() != null) goto L5;
            r100.bindNull(9);
        L6:
            r100.bindNull(10);
            r100.bindNull(11);
            r100.bindNull(12);
            r100.bindNull(13);
            r100.bindNull(14);
            r100.bindNull(15);
            this.f307828a.f307825b.getClass();
            r100.bindNull(16);
            r100.bindNull(17);
            this.f307828a.f307825b.getClass();
            r100.bindNull(18);
            this.f307828a.f307825b.getClass();
            r100.bindNull(19);
            r100.bindNull(20);
            r100.bindNull(21);
            r100.bindNull(22);
            this.f307828a.f307825b.getClass();
            r100.bindNull(23);
            r100.bindNull(24);
            this.f307828a.f307826c.getClass();
            r100.bindNull(25);
            this.f307828a.f307825b.getClass();
            r100.bindNull(26);
            r100.bindNull(27);
            this.f307828a.f307826c.getClass();
            r100.bindNull(28);
            r100.bindNull(29);
            r100.bindNull(30);
            r100.bindNull(31);
            r100.bindNull(32);
            r100.bindNull(33);
            r100.bindNull(34);
            this.f307828a.f307826c.getClass();
            r100.bindNull(35);
            return;
        L5:
            r100.bindString(9, r102.getType());
            goto L6
        }
    }

    public class l extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `subtitle_message_id` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public l(RoomDatabase r100) {
            super(r100);
        }
    }

    public class m extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `pinned` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public m(RoomDatabase r100) {
            super(r100);
        }
    }

    public class n extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bio` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public n(RoomDatabase r100) {
            super(r100);
        }
    }

    public class o extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bot_stats` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public o(RoomDatabase r100) {
            super(r100);
        }
    }

    public class p extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `icon_image` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public p(RoomDatabase r100) {
            super(r100);
        }
    }

    public class q extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        DELETE FROM `chat_conversation`\n        WHERE `conversation_id` = ? \n    ";
        }

        public q(RoomDatabase r100) {
            super(r100);
        }
    }

    public class r extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        DELETE FROM `chat_conversation`\n        WHERE `is_local` = 1 AND `priority` = 40\n    ";
        }

        public r(RoomDatabase r100) {
            super(r100);
        }
    }

    public class s extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `conversation_page` = ?\n        WHERE `conversation_id` = ?\n        ";
        }

        public s(RoomDatabase r100) {
            super(r100);
        }
    }

    public class t extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bot_type` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public t(RoomDatabase r100) {
            super(r100);
        }
    }

    public class u extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bg_img_url` = ?, `bg_img_avg_hue` = ? \n        WHERE `conversation_id` = ?\n    ";
        }

        public u(RoomDatabase r100) {
            super(r100);
        }
    }

    public class v extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `update_time` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public v(RoomDatabase r100) {
            super(r100);
        }
    }

    public class w extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `bot_conversation_type` = ?, `content_dist_type` = ?, `default_onboarding` = ? \n        WHERE `conversation_id` = ?\n    ";
        }

        public w(RoomDatabase r100) {
            super(r100);
        }
    }

    public class x extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `creator_info` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public x(RoomDatabase r100) {
            super(r100);
        }
    }

    public class y extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM `chat_conversation`";
        }

        public y(RoomDatabase r100) {
            super(r100);
        }
    }

    public class z extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "\n        UPDATE `chat_conversation`\n        SET `time` = ?\n        WHERE `conversation_id` = ?\n    ";
        }

        public z(RoomDatabase r100) {
            super(r100);
        }
    }

    @Override // com.larus.bmhome.chat.model.repo.j1
    public final void clear() {
        this.f307824a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f307827d.acquire();
        this.f307824a.beginTransaction();
        r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f307824a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f307824a.endTransaction();
        this.f307827d.release(r100);
        return;
    L6:
        th = move-exception;
        this.f307824a.endTransaction();
        this.f307827d.release(r100);
        throw th;
    }

    public k1(RoomDatabase r100) {
        this.f307825b = new ChatConversation.b();
        this.f307826c = new ChatBot.b();
        this.f307824a = r100;
        new k(this, r100);
        new v(r100);
        new z(r100);
        new a0(r100);
        new b0(r100);
        new c0(r100);
        new d0(r100);
        new e0(r100);
        new f0(r100);
        new a(r100);
        new b(r100);
        new c(r100);
        new d(r100);
        new e(r100);
        new f(r100);
        new g(r100);
        new h(r100);
        new i(r100);
        new j(r100);
        new l(r100);
        new m(r100);
        new n(r100);
        new o(r100);
        new p(r100);
        new q(r100);
        new r(r100);
        new s(r100);
        new t(r100);
        new u(r100);
        new w(r100);
        new x(r100);
        this.f307827d = new y(r100);
    }
}
