package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class r extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `digital_human_data` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public r(ChatDatabase r100) {
        super(r100);
    }
}
