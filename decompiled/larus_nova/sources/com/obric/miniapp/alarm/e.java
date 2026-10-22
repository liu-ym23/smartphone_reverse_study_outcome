package com.obric.miniapp.alarm;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes33.dex */
public final class e extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE alarm SET triggerTime = ?, currentRepeatCount = ? WHERE id = ? AND token = ?";
    }

    public e(AlarmDatabase r100) {
        super(r100);
    }
}
