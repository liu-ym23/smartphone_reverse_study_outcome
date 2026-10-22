package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class w extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `update_time` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public w(ChatDatabase r100) {
        super(r100);
    }
}
