package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `private_status` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public d0(ChatDatabase r100) {
        super(r100);
    }
}
