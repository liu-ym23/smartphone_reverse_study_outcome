package xh8;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements Cursor {
    public a() {
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // android.database.Cursor
    public final void copyStringToBuffer(int r100, CharArrayBuffer r101) {
    }

    @Override // android.database.Cursor
    public final void deactivate() {
    }

    @Override // android.database.Cursor
    public final byte[] getBlob(int r100) {
        return new byte[0];
    }

    @Override // android.database.Cursor
    public final int getColumnCount() {
        return 0;
    }

    @Override // android.database.Cursor
    public final int getColumnIndex(String r100) {
        return 0;
    }

    @Override // android.database.Cursor
    public final int getColumnIndexOrThrow(String r100) throws IllegalArgumentException {
        return 0;
    }

    @Override // android.database.Cursor
    public final String getColumnName(int r100) {
        return null;
    }

    @Override // android.database.Cursor
    public final String[] getColumnNames() {
        return new String[0];
    }

    @Override // android.database.Cursor
    public final int getCount() {
        return 0;
    }

    @Override // android.database.Cursor
    public final double getDouble(int r100) {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // android.database.Cursor
    public final Bundle getExtras() {
        return null;
    }

    @Override // android.database.Cursor
    public final float getFloat(int r100) {
        return 0.0f;
    }

    @Override // android.database.Cursor
    public final int getInt(int r100) {
        return 0;
    }

    @Override // android.database.Cursor
    public final long getLong(int r100) {
        return 0;
    }

    @Override // android.database.Cursor
    public final Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return 0;
    }

    @Override // android.database.Cursor
    public final short getShort(int r100) {
        return 0;
    }

    @Override // android.database.Cursor
    public final String getString(int r100) {
        return null;
    }

    @Override // android.database.Cursor
    public int getType(int r100) {
        return 0;
    }

    @Override // android.database.Cursor
    public final boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isClosed() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isNull(int r100) {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean move(int r100) {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int r100) {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return false;
    }

    @Override // android.database.Cursor
    public final void registerContentObserver(ContentObserver r100) {
    }

    @Override // android.database.Cursor
    public final void registerDataSetObserver(DataSetObserver r100) {
    }

    @Override // android.database.Cursor
    public final boolean requery() {
        return false;
    }

    @Override // android.database.Cursor
    public final Bundle respond(Bundle r100) {
        return null;
    }

    @Override // android.database.Cursor
    public final void setExtras(Bundle r100) {
    }

    @Override // android.database.Cursor
    public final void setNotificationUri(ContentResolver r100, Uri r101) {
    }

    @Override // android.database.Cursor
    public final void unregisterContentObserver(ContentObserver r100) {
    }

    @Override // android.database.Cursor
    public final void unregisterDataSetObserver(DataSetObserver r100) {
    }
}
