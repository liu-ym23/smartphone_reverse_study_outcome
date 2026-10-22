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

/* JADX INFO: loaded from: classes.dex */
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
        String[] r100 = super.databaseList();
        int r101 = r100.length;
        boolean[] r102 = new boolean[r101];
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r100.length) goto L14;
        if (r100[r104].startsWith(getPluginDirName()) == false) goto L12;
        r102[r104] = true;
        r105 = r105 + 1;
    L13:
        r104 = r104 + 1;
        goto L8
    L12:
        r102[r104] = false;
        goto L13
    L14:
        String[] r106 = new String[r105];
        int r107 = 0;
    L15:
        if (r103 >= r101) goto L20;
        if (r102[r103] == false) goto L19;
        r106[r107] = r100[r103];
        r107 = r107 + 1;
    L19:
        r103 = r103 + 1;
        goto L15
    L20:
        return r106;
    L5:
        return super.databaseList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mCacheDir != null) goto L11;
        this.mCacheDir = new PolarisFileWrapper(super.getCacheDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mCacheDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mCodeCacheDir != null) goto L11;
        this.mCodeCacheDir = new PolarisFileWrapper(super.getCodeCacheDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mCodeCacheDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getCodeCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mDataDir != null) goto L11;
        this.mDataDir = new PolarisFileWrapper(getHostDataDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mDataDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getDataDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mExternalCacheDir != null) goto L11;
        this.mExternalCacheDir = new PolarisFileWrapper(super.getExternalCacheDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mExternalCacheDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getExternalCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (getPluginDirName() == null) goto L5;
        File[] r100 = super.getExternalCacheDirs();
        File[] r101 = new File[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = ensurePrivateDirExists(new PolarisFileWrapper(r100[r102], getPluginDirName()));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L5:
        return super.getExternalCacheDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (getPluginDirName() == null) goto L5;
        File[] r100 = super.getExternalMediaDirs();
        File[] r101 = new File[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = ensurePrivateDirExists(new PolarisFileWrapper(r100[r102], getPluginDirName()));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L5:
        return super.getExternalMediaDirs();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mFilesDir != null) goto L11;
        this.mFilesDir = new PolarisFileWrapper(super.getFilesDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mFilesDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getFilesDir();
    }

    public File getHostDataDir() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mNoBackupFilesDir != null) goto L11;
        this.mNoBackupFilesDir = new PolarisFileWrapper(super.getNoBackupFilesDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mNoBackupFilesDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getNoBackupFilesDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        if (getPluginDirName() == null) goto L5;
        Object r100 = this.mSync;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.mObbDir != null) goto L11;
        this.mObbDir = new PolarisFileWrapper(super.getObbDir(), getPluginDirName());     // Catch: Throwable -> L14
    L11:
        File r101 = ensurePrivateDirExists(this.mObbDir);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r101;
    L5:
        return super.getObbDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (getPluginDirName() == null) goto L5;
        File[] r100 = super.getObbDirs();
        File[] r101 = new File[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = ensurePrivateDirExists(new PolarisFileWrapper(r100[r102], getPluginDirName()));
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L5:
        return super.getObbDirs();
    }

    private static File ensurePrivateDirExists(File r100) {
        if (r100.exists() == true) goto L5;
        r100.mkdirs();
    L5:
        return r100;
    }

    private String makeSubName(String r100) {
        return getPluginDirName() + "_" + r100;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String r100) {
        if (getPluginDirName() != null) goto L7;
        return super.deleteDatabase(r100);
    L7:
        return super.deleteDatabase(makeSubName(r100));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String r100) {
        return makeFilename(getFilesDir(), r100).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String r100) {
        if (getPluginDirName() != null) goto L7;
        return super.deleteSharedPreferences(r100);
    L7:
        return super.deleteSharedPreferences(makeSubName(r100));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String r100) {
        if (getPluginDirName() != null) goto L7;
        return super.getDatabasePath(r100);
    L7:
        return super.getDatabasePath(makeSubName(r100));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String r100) {
        if (getPluginDirName() != null) goto L7;
        return super.getExternalFilesDir(r100);
    L7:
        return ensurePrivateDirExists(new PolarisFileWrapper(super.getExternalFilesDir(r100), getPluginDirName()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String r100) {
        if (getPluginDirName() == null) goto L5;
        File[] r101 = super.getExternalFilesDirs(r100);
        File[] r102 = new File[r101.length];
        int r103 = 0;
    L8:
        if (r103 >= r101.length) goto L10;
        r102[r103] = ensurePrivateDirExists(new PolarisFileWrapper(r101[r103], getPluginDirName()));
        r103 = r103 + 1;
        goto L8
    L10:
        return r102;
    L5:
        return super.getExternalFilesDirs(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String r100) throws FileNotFoundException {
        if (getPluginDirName() != null) goto L7;
        return super.openFileInput(r100);
    L7:
        return new PolarisFileInputStreamWrapper(makeFilename(getFilesDir(), r100));
    }

    public e(Context r100, int r101) {
        super(r100, r101);
        this.mSync = new Object();
    }

    private static File makeFilename(File r100, String r101) {
        if (r101.indexOf(File.separatorChar) >= 0) goto L7;
        return new PolarisFileWrapper(r100, r101);
    L7:
        throw new IllegalArgumentException("File " + r101 + " contains a path separator");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String r100, int r101) {
        if (r101 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return ensurePrivateDirExists(new PolarisFileWrapper(super.getDir(r100, r101), getPluginDirName()));
    L9:
        return super.getDir(r100, r101);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String r100, int r101) {
        if (r101 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return super.getSharedPreferences(makeSubName(r100), r101);
    L9:
        return super.getSharedPreferences(r100, r101);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context r100, String r101) {
        if (getPluginDirName() != null) goto L7;
        return super.moveDatabaseFrom(r100, r101);
    L7:
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String r100, int r101) throws FileNotFoundException {
        if (r101 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return new PolarisFileOutputStreamWrapper(makeFilename(getFilesDir(), r100), false);
    L9:
        return super.openFileOutput(r100, r101);
    }

    public e(Context r100, Resources.Theme r101) {
        super(r100, r101);
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String r100, int r101, SQLiteDatabase.CursorFactory r102) {
        if (r101 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return super.openOrCreateDatabase(makeSubName(r100), r101, r102);
    L9:
        return super.openOrCreateDatabase(r100, r101, r102);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String r100, int r101, SQLiteDatabase.CursorFactory r102, DatabaseErrorHandler r103) {
        if (r101 != 0) goto L9;
        if (getPluginDirName() == null) goto L9;
        return super.openOrCreateDatabase(makeSubName(r100), r101, r102, r103);
    L9:
        return super.openOrCreateDatabase(r100, r101, r102, r103);
    }
}
