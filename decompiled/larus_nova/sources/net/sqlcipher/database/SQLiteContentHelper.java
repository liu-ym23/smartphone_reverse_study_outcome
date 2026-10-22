package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import net.sqlcipher.Cursor;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteContentHelper {
    public SQLiteContentHelper() {
    }

    public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase r100, String r101, String[] r102) throws FileNotFoundException {
        MemoryFile r103 = simpleQueryForBlobMemoryFile(r100, r101, r102);     // Catch: IOException -> L13
        if (r103 == null) goto L12;
        Method r104 = r103.getClass().getDeclaredMethod("getParcelFileDescriptor", new Class[0]);     // Catch: Exception -> L7
        r104.setAccessible(true);     // Catch: Exception -> L7
        ParcelFileDescriptor r105 = (ParcelFileDescriptor) r104.invoke(r103, new Object[0]);     // Catch: Exception -> L7
    L10:
        return new AssetFileDescriptor(r105, 0, r103.length());
    L7:
        e = move-exception;
        e.toString();     // Catch: IOException -> L13
        r105 = null;
        goto L10
    L12:
        throw new FileNotFoundException("No results.");     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw new FileNotFoundException(e.toString());
    }

    private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase r100, String r101, String[] r102) throws IOException {
        Cursor r103 = r100.rawQuery(r101, r102);
        if (r103 != null) goto L20;
        return null;
    L20:
    L17:
        th = move-exception;
        r103.close();
        throw th;
    L6:
        if (r103.moveToFirst() == true) goto L10;
        r103.close();
        return null;
    L10:
        byte[] r104 = r103.getBlob(0);     // Catch: Throwable -> L17
        if (r104 != null) goto L14;
        r103.close();
        return null;
    L14:
        MemoryFile r105 = new MemoryFile(null, r104.length);     // Catch: Throwable -> L17
        r105.writeBytes(r104, 0, 0, r104.length);     // Catch: Throwable -> L17
        r103.close();
        return r105;
    }
}
