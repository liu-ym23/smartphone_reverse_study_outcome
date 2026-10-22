package com.obric.miniapp.alarm;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes33.dex */
public final class f extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM alarm WHERE id = ? AND token = ?";
    }

    public f(AlarmDatabase r100) {
        super(r100);
    }
}
