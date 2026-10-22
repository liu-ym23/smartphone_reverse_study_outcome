package com.larus.avlink.gallery.database;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class h extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM 'media_metadata_table' WHERE id = ?";
    }

    public h(AlbumDatabase r100) {
        super(r100);
    }
}
