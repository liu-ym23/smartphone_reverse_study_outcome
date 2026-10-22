package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class m extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "\n        UPDATE `chat_bot`\n        SET `hover_answer_actions` = ?\n        WHERE `bot_id` = ? AND `owner` = ?\n        ";
    }

    public m(ChatDatabase r100) {
        super(r100);
    }
}
