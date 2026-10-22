package com.larus.bmhome.chat.model.repo;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class u extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `chat_bot` WHERE `bot_id` = ? AND `owner` = ?";
    }

    public u(ChatDatabase r100) {
        super(r100);
    }
}
