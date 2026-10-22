package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes23.dex */
public class DirectApkSoSource extends SoSource {
    private final File mApkFile;
    private final Set<String> mDirectApkLdPaths;
    private final Map<String, Set<String>> mLibsInApkMap;

    private String LdPathsToString() {
        StringBuilder r100 = new StringBuilder("(");
        Iterator<String> r101 = this.mDirectApkLdPaths.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.append(r101.next());
        r100.append(", ");
        goto L4
    L6:
        r100.append(')');
        return r100.toString();
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getClass().getName() + "[root = " + LdPathsToString() + ']';
    }

    public DirectApkSoSource(Context r100) {
        this.mLibsInApkMap = new HashMap();
        this.mDirectApkLdPaths = getDirectApkLdPaths("");
        this.mApkFile = new PolarisFileWrapper(r100.getApplicationInfo().sourceDir);
    }

    private synchronized boolean contains(String r100) {
        monitor-enter(this);
        Iterator<Set<String>> r101 = this.mLibsInApkMap.values().iterator();     // Catch: Throwable -> L14
    L5:
        if (r101.hasNext() == false) goto L11;
        if (r101.next().contains(r100) == false) goto L5;
        monitor-exit(this);
        return true;
    L11:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public static Set<String> getDirectApkLdPaths(String r100) {
        HashSet r101 = new HashSet();
        String r102 = SysUtil.Api14Utils.getClassLoaderLdLoadLibrary();
        if (r102 == null) goto L10;
        String[] r103 = r102.split(":");
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        String r106 = r103[r105];
        if (r106.contains(r100 + ".apk!/") == false) goto L9;
        r101.add(r106);
    L9:
        r105 = r105 + 1;
    L10:
        return r101;
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int r100) throws IOException {
        Iterator<String> r101 = this.mDirectApkLdPaths.iterator();
        String r102 = null;
    L4:
        if (r101.hasNext() == false) goto L36;
        String r103 = r101.next();
        if (TextUtils.isEmpty(r103) == true) goto L13;
        int r104 = r103.indexOf(33);
        if (r104 < 0) goto L13;
        int r105 = r104 + 2;
        if (r105 >= r103.length()) goto L13;
        r102 = r103.substring(r105);
    L13:
        if (TextUtils.isEmpty(r102) == true) goto L4;
        PolarisZipFileWrapper r106 = new PolarisZipFileWrapper(this.mApkFile);
        Enumeration<? extends ZipEntry> r107 = r106.entries();     // Catch: Throwable -> L30
    L18:
        if (r107.hasMoreElements() == false) goto L29;
        ZipEntry r108 = r107.nextElement();     // Catch: Throwable -> L30
        if (r108 == null) goto L18;
        if (r108.getName().startsWith(r102) == false) goto L18;
        if (r108.getName().endsWith(".so") == false) goto L18;
        if (r108.getMethod() != 0) goto L18;
        append(r103, r108.getName().substring(r102.length() + 1));     // Catch: Throwable -> L30
        goto L18
    L29:
        r106.close();
    L30:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L33
    L35:
        throw th;
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String r100) throws IOException {
        throw new UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    public DirectApkSoSource(File r100) {
        this.mLibsInApkMap = new HashMap();
        this.mDirectApkLdPaths = getDirectApkLdPaths(SysUtil.getBaseName(r100.getName()));
        this.mApkFile = r100;
    }

    private synchronized void append(String r100, String r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mLibsInApkMap.containsKey(r100) == true) goto L6;
        this.mLibsInApkMap.put(r100, new HashSet());     // Catch: Throwable -> L9
    L6:
        this.mLibsInApkMap.get(r100).add(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    private static String[] getDependencies(String r100, ElfByteChannel r101) throws IOException {
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

    private void loadDependencies(String r100, int r101, StrictMode.ThreadPolicy r110) throws IOException {
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(this.mApkFile);
        Enumeration<? extends ZipEntry> r103 = r102.entries();     // Catch: Throwable -> L30
    L5:
        if (r103.hasMoreElements() == false) goto L28;
        ZipEntry r104 = r103.nextElement();     // Catch: Throwable -> L30
        if (r104 == null) goto L5;
        if (r104.getName().endsWith(HTTP.URL_DEFAULT + r100) == false) goto L5;
        ElfZipFileChannel r105 = new ElfZipFileChannel(r102, r104);     // Catch: Throwable -> L30
        String[] r106 = getDependencies(r100, r105);     // Catch: Throwable -> L22
        int r107 = r106.length;     // Catch: Throwable -> L22
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L20;
        String r109 = r106[r108];     // Catch: Throwable -> L22
        if (contains(r109) == true) goto L19;
        if (r109.startsWith(HTTP.URL_DEFAULT) == true) goto L19;
        SoLoader.loadLibraryBySoName(r109, r101 | 1, r110);     // Catch: Throwable -> L22
    L19:
        r108 = r108 + 1;
        goto L12
    L20:
        r105.close();     // Catch: Throwable -> L30
    L22:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Throwable -> L30
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L30
    L28:
        r102.close();
        return;
    L30:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L33
    L35:
        throw th;
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String r100, int r101, StrictMode.ThreadPolicy r102) throws IOException {
        if (SoLoader.sSoFileLoader == null) goto L22;
        Iterator<String> r103 = this.mDirectApkLdPaths.iterator();
    L6:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        Set<String> r105 = this.mLibsInApkMap.get(r104);
        if (TextUtils.isEmpty(r104) == true) goto L6;
        if (r105 == null) goto L6;
        if (r105.contains(r100) == false) goto L6;
        loadDependencies(r100, r101, r102);
        r101 = r101 | 4;     // Catch: UnsatisfiedLinkError -> L17
        SoLoader.sSoFileLoader.load(r104 + File.separator + r100, r101);     // Catch: UnsatisfiedLinkError -> L17
        return 1;
    L19:
        return 0;
    L22:
        throw new IllegalStateException("SoLoader.init() not yet called");
    }
}
