package net.sqlcipher.database;

/* JADX INFO: loaded from: classes42.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f518942s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f518942s);
    }
}
