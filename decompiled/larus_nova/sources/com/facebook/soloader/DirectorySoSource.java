package com.facebook.soloader;

import android.os.StrictMode;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    protected final List<String> denyList;
    protected final int flags;
    protected final File soDirectory;

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String r100 = String.valueOf(this.soDirectory.getCanonicalPath());     // Catch: IOException -> L4
    L6:
        return getClass().getName() + "[root = " + r100 + " flags = " + this.flags + ']';
    L4:
        r100 = this.soDirectory.getName();
        goto L6
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> r100) {
        r100.add(this.soDirectory.getAbsolutePath());
    }

    public ElfByteChannel getChannel(File r100) throws IOException {
        return new ElfFileChannel(r100);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String r100) throws IOException {
        File r101 = getSoFileByName(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        ElfByteChannel r102 = getChannel(r101);
        String[] r103 = getDependencies(r100, r102);     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        r102.close();
    L10:
        return r103;
    L11:
        th = move-exception;
        if (r102 != null) goto L20;
    L17:
        throw th;
    L20:
        r102.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String r100) throws IOException {
        File r101 = getSoFileByName(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getCanonicalPath();
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File getSoFileByName(String r100) throws IOException {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.soDirectory, r100);
        if (r101.exists() == false) goto L5;
        return r101;
    L5:
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String r100) throws IOException {
        return getSoFileByName(r100);
    }

    public DirectorySoSource(File r100, int r101) {
        this(r100, r101, new String[0]);
    }

    public String[] getDependencies(String r100, ElfByteChannel r101) throws IOException {
        boolean r102 = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (r102 == false) goto L14;
        Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", r100, "]");
    L14:
        String[] r103 = NativeDeps.getDependencies(r100, r101);     // Catch: Throwable -> L9
        if (r102 == false) goto L8;
        Api18TraceUtils.endSection();
    L8:
        return r103;
    L9:
        th = move-exception;
        if (SoLoader.SYSTRACE_LIBRARY_LOADING == false) goto L13;
        Api18TraceUtils.endSection();
    L13:
        throw th;
    }

    public DirectorySoSource(File r100, int r101, String[] r102) {
        this.soDirectory = r100;
        this.flags = r101;
        this.denyList = Arrays.asList(r102);
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String r100, int r101, StrictMode.ThreadPolicy r102) throws IOException {
        return loadLibraryFrom(r100, r101, this.soDirectory, r102);
    }

    private void loadDependencies(String r100, ElfByteChannel r101, int r102, StrictMode.ThreadPolicy r103) throws IOException {
        String[] r104 = getDependencies(r100, r101);
        Arrays.toString(r104);
        int r105 = r104.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        String r107 = r104[r106];
        if (r107.startsWith(HTTP.URL_DEFAULT) == true) goto L8;
        SoLoader.loadLibraryBySoName(r107, r102 | 1, r103);
    L8:
        r106 = r106 + 1;
        goto L3
    }

    public int loadLibraryFrom(String r100, int r101, File r102, StrictMode.ThreadPolicy r103) throws IOException {
        if (SoLoader.sSoFileLoader == null) goto L47;
        boolean r104 = false;
        if (this.denyList.contains(r100) == false) goto L8;
        r102.getCanonicalPath();
        return 0;
    L8:
        File r105 = getSoFileByName(r100);
        if (r105 != null) goto L12;
        r102.getCanonicalPath();
        return 0;
    L12:
        r102.getCanonicalPath();
        if ((r101 & 1) == 0) goto L19;
        if ((this.flags & 2) == 0) goto L19;
        return 2;
    L19:
        if ((this.flags & 1) == 0) goto L21;
        r104 = true;
    L21:
        boolean r106 = r105.getName().equals(r100);
        ElfByteChannel r107 = null;
        if (r104 == true) goto L48;
        if (r106 == false) goto L48;
    L25:
        if (r104 == false) goto L49;
        loadDependencies(r100, r107, r101, r103);     // Catch: Throwable -> L42
    L49:
        if (r106 == false) goto L30;
        SoLoader.sSoFileLoader.load(r105.getAbsolutePath(), r101);     // Catch: UnsatisfiedLinkError -> L34 Throwable -> L42
    L31:
        if (r107 == null) goto L33;
        r107.close();
    L33:
        return 1;
    L30:
        SoLoader.sSoFileLoader.loadBytes(r105.getAbsolutePath(), r107, r101);     // Catch: UnsatisfiedLinkError -> L34 Throwable -> L42
    L34:
        e = move-exception;
        if (e.getMessage().contains("bad ELF magic") == false) goto L41;
        if (r107 == null) goto L51;
        r107.close();
        return 3;
    L51:
        return 3;
    L41:
        throw e;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r107 == null) goto L45;
        r107.close();
    L45:
        throw th;
    L48:
        r107 = getChannel(r105);     // Catch: Throwable -> L42
        goto L25
    L47:
        throw new IllegalStateException("SoLoader.init() not yet called");
    }
}
