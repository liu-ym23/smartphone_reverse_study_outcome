package com.volcengine.zeus;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class e extends ContextThemeWrapper {
    private File mCacheDir;
    private File mCodeCacheDir;
    private File mDataDir;
    private File mExternalCacheDir;
    private File mFilesDir;
    private File mNoBackupFilesDir;
    private File mObbDir;
    private final Object mSync;

    public String getPluginPkg() {
        return null;
    }

    public String getPluginDirName() {
        return "zeus_" + getPluginPkg();
    }

    public e() {
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (getPluginDirName() == null) goto L5;
        String[] r0 = super.databaseList();
        int r1 = r0.length;
        boolean[] r2 = new boolean[r1];
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r0.length) goto L14;
        if (r0[r4].startsWith(getPluginDirName()) == false) goto L12;
        r2[r4] = true;
        r5 = r5 + 1;
    L13:
        r4 = r4 + 1;
        goto L8
    L12:
        r2[r4] = false;
        goto L13
    L14:
        String[] r6 = new String[r5];
        int r7 = 0;
    L15:
        if (r3 >= r1) goto L20;
        if (r2[r3] == false) goto L19;
        r6[r7] = r0[r3];
        r7 = r7 + 1;
    L19:
        r3 = r3 + 1;
        goto L15
    L20:
        return r6;
    L5:
        return super.databaseList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mCacheDir != null) goto L11;
        this.mCacheDir = new PolarisFileWrapper(super.getCacheDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mCacheDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mCodeCacheDir != null) goto L11;
        this.mCodeCacheDir = new PolarisFileWrapper(super.getCodeCacheDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mCodeCacheDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getCodeCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mDataDir != null) goto L11;
        this.mDataDir = new PolarisFileWrapper(getHostDataDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mDataDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getDataDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mExternalCacheDir != null) goto L11;
        this.mExternalCacheDir = new PolarisFileWrapper(super.getExternalCacheDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mExternalCacheDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getExternalCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) goto L5;
        File[] r0 = super.getExternalCacheDirs();
        File[] r1 = new File[r0.length];
        int r2 = 0;
    L8:
        if (r2 >= r0.length) goto L10;
        r1[r2] = ensurePrivateDirExists(new PolarisFileWrapper(r0[r2], getPluginDirName()));
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        return super.getExternalCacheDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) goto L5;
        File[] r0 = super.getExternalMediaDirs();
        File[] r1 = new File[r0.length];
        int r2 = 0;
    L8:
        if (r2 >= r0.length) goto L10;
        r1[r2] = ensurePrivateDirExists(new PolarisFileWrapper(r0[r2], getPluginDirName()));
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        return super.getExternalMediaDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mFilesDir != null) goto L11;
        this.mFilesDir = new PolarisFileWrapper(super.getFilesDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mFilesDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getFilesDir();
    }

    public File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mNoBackupFilesDir != null) goto L11;
        this.mNoBackupFilesDir = new PolarisFileWrapper(super.getNoBackupFilesDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mNoBackupFilesDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getNoBackupFilesDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        if (getPluginDirName() == null) goto L5;
        Object r0 = this.mSync;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mObbDir != null) goto L11;
        this.mObbDir = new PolarisFileWrapper(super.getObbDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r1 = ensurePrivateDirExists(this.mObbDir);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r1;
    L5:
        return super.getObbDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getPluginDirName() == null) goto L5;
        File[] r0 = super.getObbDirs();
        File[] r1 = new File[r0.length];
        int r2 = 0;
    L8:
        if (r2 >= r0.length) goto L10;
        r1[r2] = ensurePrivateDirExists(new PolarisFileWrapper(r0[r2], getPluginDirName()));
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        return super.getObbDirs();
    }

    private static File ensurePrivateDirExists(File r1) {
        if (r1.exists() == true) goto L5;
        r1.mkdirs();
    L5:
        return r1;
    }

    private String makeSubName(String r3) {
        return getPluginDirName() + "_" + r3;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String r2) {
        if (getPluginDirName() != null) goto L7;
        return super.deleteDatabase(r2);
    L7:
        return super.deleteDatabase(makeSubName(r2));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String r2) {
        return makeFilename(getFilesDir(), r2).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String r2) {
        if (getPluginDirName() != null) goto L7;
        return super.deleteSharedPreferences(r2);
    L7:
        return super.deleteSharedPreferences(makeSubName(r2));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String r2) {
        if (getPluginDirName() != null) goto L7;
        return super.getDatabasePath(r2);
    L7:
        return super.getDatabasePath(makeSubName(r2));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String r3) {
        if (getPluginDirName() != null) goto L7;
        return super.getExternalFilesDir(r3);
    L7:
        return ensurePrivateDirExists(new PolarisFileWrapper(super.getExternalFilesDir(r3), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String r6) {
        if (getPluginDirName() == null) goto L5;
        File[] r7 = super.getExternalFilesDirs(r6);
        File[] r0 = new File[r7.length];
        int r1 = 0;
    L8:
        if (r1 >= r7.length) goto L10;
        r0[r1] = ensurePrivateDirExists(new PolarisFileWrapper(r7[r1], getPluginDirName()));
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L5:
        return super.getExternalFilesDirs(r6);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String r2) throws FileNotFoundException {
        if (getPluginDirName() != null) goto L7;
        return super.openFileInput(r2);
    L7:
        return new PolarisFileInputStreamWrapper(makeFilename(getFilesDir(), r2));
    }

    public e(Context r1, int r2) {
        super(r1, r2);
        this.mSync = new Object();
    }

    private static File makeFilename(File r2, String r3) {
        if (r3.indexOf(File.separatorChar) >= 0) goto L7;
        return new PolarisFileWrapper(r2, r3);
    L7:
        throw new IllegalArgumentException("File " + r3 + " contains a path separator");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String r2, int r3) {
        if (r3 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return ensurePrivateDirExists(new PolarisFileWrapper(super.getDir(r2, r3), getPluginDirName()));
    L9:
        return super.getDir(r2, r3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String r2, int r3) {
        if (r3 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return super.getSharedPreferences(makeSubName(r2), r3);
    L9:
        return super.getSharedPreferences(r2, r3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context r2, String r3) {
        if (getPluginDirName() != null) goto L7;
        return super.moveDatabaseFrom(r2, r3);
    L7:
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String r2, int r3) throws FileNotFoundException {
        if (r3 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return new PolarisFileOutputStreamWrapper(makeFilename(getFilesDir(), r2), false);
    L9:
        return super.openFileOutput(r2, r3);
    }

    public e(Context r1, Resources.Theme r2) {
        super(r1, r2);
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String r2, int r3, SQLiteDatabase.CursorFactory r4) {
        if (r3 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return super.openOrCreateDatabase(makeSubName(r2), r3, r4);
    L9:
        return super.openOrCreateDatabase(r2, r3, r4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String r2, int r3, SQLiteDatabase.CursorFactory r4, DatabaseErrorHandler r5) {
        if (r3 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return super.openOrCreateDatabase(makeSubName(r2), r3, r4, r5);
    L9:
        return super.openOrCreateDatabase(r2, r3, r4, r5);
    }
}
