package com.larus.avlink.gallery.database;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes25.dex */
public final class n extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM thumbnail_metadata_table WHERE image_uuid = ? AND sn = ?";
    }

    public n(AlbumDatabase r100) {
        super(r100);
    }
}
