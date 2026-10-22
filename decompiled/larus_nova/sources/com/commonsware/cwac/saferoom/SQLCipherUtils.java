package com.commonsware.cwac.saferoom;

import android.content.Context;
import android.text.Editable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public class SQLCipherUtils {

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DOES_NOT_EXIST = null;
        public static final State ENCRYPTED = null;
        public static final State UNENCRYPTED = null;

        static {
            State r100 = new State("DOES_NOT_EXIST", 0);
            DOES_NOT_EXIST = r100;
            State r101 = new State("UNENCRYPTED", 1);
            UNENCRYPTED = r101;
            State r102 = new State("ENCRYPTED", 2);
            ENCRYPTED = r102;
            $VALUES = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SQLCipherUtils() {
    }

    public static State getDatabaseState(File r100) {
        if (r100.exists() == false) goto L18;
        SQLiteDatabase r101 = null;
        r101 = SQLiteDatabase.openDatabase(r100.getAbsolutePath(), "", null, 1);     // Catch: Throwable -> L8 Exception -> L10
        r101.getVersion();     // Catch: Throwable -> L8 Exception -> L10
        State r102 = State.UNENCRYPTED;     // Catch: Throwable -> L8 Exception -> L10
        r101.close();
        return r102;
    L10:
        State r103 = State.ENCRYPTED;     // Catch: Throwable -> L8
        if (r101 == null) goto L13;
        r101.close();
    L13:
        return r103;
    L8:
        th = move-exception;
        if (r101 == null) goto L16;
        r101.close();
    L16:
        throw th;
    L18:
        return State.DOES_NOT_EXIST;
    }

    public static State getDatabaseState(Context r100, String r101) {
        SQLiteDatabase.loadLibs(r100);
        return getDatabaseState(r100.getDatabasePath(r101));
    }

    public static void decrypt(Context r100, File r101, byte[] r102) throws IOException {
        SQLiteDatabase.loadLibs(r100);
        if (r101.exists() == false) goto L7;
        File r103 = File.createTempFile("sqlcipherutils", "tmp", r100.getCacheDir());
        SQLiteDatabase r104 = SQLiteDatabase.openDatabase(r101.getAbsolutePath(), r102, null, 0, null, null);
        SQLiteStatement r105 = r104.compileStatement("ATTACH DATABASE ? AS plaintext KEY ''");
        r105.bindString(1, r103.getAbsolutePath());
        r105.execute();
        r104.rawExecSQL("SELECT sqlcipher_export('plaintext')");
        r104.rawExecSQL("DETACH DATABASE plaintext");
        int r106 = r104.getVersion();
        r105.execute();
        r104.close();
        SQLiteDatabase r107 = SQLiteDatabase.openDatabase(r103.getAbsolutePath(), "", null, 0);
        r107.setVersion(r106);
        r107.close();
        r101.delete();
        r103.renameTo(r101);
        return;
    L7:
        throw new FileNotFoundException(r101.getAbsolutePath() + " not found");
    }

    public static void encrypt(Context r100, File r101, byte[] r110) throws IOException {
        SQLiteDatabase.loadLibs(r100);
        if (r101.exists() == false) goto L7;
        File r102 = File.createTempFile("sqlcipherutils", "tmp", r100.getCacheDir());
        SQLiteDatabase r103 = SQLiteDatabase.openDatabase(r101.getAbsolutePath(), "", null, 0);
        int r104 = r103.getVersion();
        r103.close();
        SQLiteDatabase r111 = SQLiteDatabase.openDatabase(r102.getAbsolutePath(), r110, null, 0, null, null);
        SQLiteStatement r105 = r111.compileStatement("ATTACH DATABASE ? AS plaintext KEY ''");
        r105.bindString(1, r101.getAbsolutePath());
        r105.execute();
        r111.rawExecSQL("SELECT sqlcipher_export('main', 'plaintext')");
        r111.rawExecSQL("DETACH DATABASE plaintext");
        r111.setVersion(r104);
        r105.execute();
        r111.close();
        r101.delete();
        r102.renameTo(r101);
        return;
    L7:
        throw new FileNotFoundException(r101.getAbsolutePath() + " not found");
    }

    public static void decrypt(Context r100, File r101, char[] r102) throws IOException {
        decrypt(r100, r101, SQLiteDatabase.getBytes(r102));
    }

    public static void encrypt(Context r100, String r101, Editable r102) throws IOException {
        char[] r103 = new char[r102.length()];
        r102.getChars(0, r102.length(), r103, 0);
        encrypt(r100, r101, r103);
    }

    public static void encrypt(Context r100, String r101, char[] r102) throws IOException {
        encrypt(r100, r100.getDatabasePath(r101), SQLiteDatabase.getBytes(r102));
    }

    public static void encrypt(Context r100, File r101, char[] r102) throws IOException {
        encrypt(r100, r101, SQLiteDatabase.getBytes(r102));
    }

    public static void encrypt(Context r100, String r101, byte[] r102) throws IOException {
        encrypt(r100, r100.getDatabasePath(r101), r102);
    }
}
