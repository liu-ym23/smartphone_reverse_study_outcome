package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class z extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `caller_name_setting` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n    ";
    }

    public z(ChatDatabase r100) {
        super(r100);
    }
}
