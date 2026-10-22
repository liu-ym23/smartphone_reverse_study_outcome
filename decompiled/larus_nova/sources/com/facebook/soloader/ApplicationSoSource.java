package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ApplicationSoSource extends SoSource {
    private Context applicationContext;
    private int flags;
    private DirectorySoSource soSource;

    public boolean checkAndMaybeUpdate() throws IOException {
        File r100 = this.soSource.soDirectory;
        Context r101 = getUpdatedContext();
        File r102 = getNativeLibDirFromContext(r101);
        if (r100.equals(r102) == true) goto L6;
        r100.toString();
        Objects.toString(r102);
        int r103 = this.flags | 1;
        this.flags = r103;
        DirectorySoSource r104 = new DirectorySoSource(r102, r103);
        this.soSource = r104;
        r104.prepare(this.flags);
        this.applicationContext = r101;
        return true;
    L6:
        return false;
    }

    public Context getUpdatedContext() {
        Context r100 = this.applicationContext;     // Catch: PackageManager.NameNotFoundException -> L4
        return r100.createPackageContext(r100.getPackageName(), 0);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return this.soSource.toString();
    }

    public static File getNativeLibDirFromContext(Context r100) {
        return new PolarisFileWrapper(r100.getApplicationInfo().nativeLibraryDir);
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> r100) {
        this.soSource.addToLdLibraryPath(r100);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String r100) throws IOException {
        return this.soSource.getLibraryDependencies(r100);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String r100) throws IOException {
        return this.soSource.getLibraryPath(r100);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File getSoFileByName(String r100) throws IOException {
        return this.soSource.getSoFileByName(r100);
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int r100) throws IOException {
        this.soSource.prepare(r100);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String r100) throws IOException {
        return this.soSource.unpackLibrary(r100);
    }

    public ApplicationSoSource(Context r100, int r101) {
        Context r102 = r100.getApplicationContext();
        this.applicationContext = r102;
        if (r102 != null) goto L5;
        String r103 = r100.getApplicationInfo().nativeLibraryDir;
        this.applicationContext = r100;
    L5:
        this.flags = r101;
        this.soSource = new DirectorySoSource(new PolarisFileWrapper(this.applicationContext.getApplicationInfo().nativeLibraryDir), r101);
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String r100, int r101, StrictMode.ThreadPolicy r102) throws IOException {
        return this.soSource.loadLibrary(r100, r101, r102);
    }
}
