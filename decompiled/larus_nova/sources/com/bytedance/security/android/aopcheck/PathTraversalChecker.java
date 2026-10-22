package com.bytedance.security.android.aopcheck;

import android.net.Uri;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.reporter.InfoMon;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007J\u0012\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010,H\u0007J\u0012\u0010)\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010.\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00103\u001a\u00020/2\b\u0010*\u001a\u0004\u0018\u00010,H\u0007J\u0012\u00104\u001a\u00020/2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010¨\u00065"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PathTraversalChecker;", "", "()V", "PathTraversalActionTypeArg1", "", "getPathTraversalActionTypeArg1", "()Ljava/lang/String;", "PathTraversalActionTypeArg2", "getPathTraversalActionTypeArg2", "PathTraversalActionTypeUri", "getPathTraversalActionTypeUri", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableContentResolverIntercept", "getEnableContentResolverIntercept", "setEnableContentResolverIntercept", "enableFileInputStreamIntercept", "getEnableFileInputStreamIntercept", "setEnableFileInputStreamIntercept", "enableFileIntercept", "getEnableFileIntercept", "setEnableFileIntercept", "enableFileOutputStreamIntercept", "getEnableFileOutputStreamIntercept", "setEnableFileOutputStreamIntercept", "enableFileReaderIntercept", "getEnableFileReaderIntercept", "setEnableFileReaderIntercept", "enableFileWriterIntercept", "getEnableFileWriterIntercept", "setEnableFileWriterIntercept", "enableIntercept", "getEnableIntercept", "setEnableIntercept", "enableZipFileIntercept", "getEnableZipFileIntercept", "setEnableZipFileIntercept", "check", "uri", "Landroid/net/Uri;", "Ljava/net/URI;", "path", "check1", "", "check2", "parent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "checkURI", "checkUri", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class PathTraversalChecker {
    public static final PathTraversalChecker INSTANCE = null;
    private static final String PathTraversalActionTypeArg1 = "path_traversal_string_arg1";
    private static final String PathTraversalActionTypeArg2 = "path_traversal_string_arg2";
    private static final String PathTraversalActionTypeUri = "path_traversal_uri";
    private static boolean enable;
    private static boolean enableContentResolverIntercept;
    private static boolean enableFileInputStreamIntercept;
    private static boolean enableFileIntercept;
    private static boolean enableFileOutputStreamIntercept;
    private static boolean enableFileReaderIntercept;
    private static boolean enableFileWriterIntercept;
    private static boolean enableIntercept;
    private static boolean enableZipFileIntercept;

    private PathTraversalChecker() {
    }

    @JvmStatic
    public static final void check1(String r100) {
    }

    @JvmStatic
    public static final void check2(String r100, String r101) {
    }

    @JvmStatic
    public static final void checkURI(URI r100) {
    }

    @JvmStatic
    public static final void checkUri(Uri r100) {
    }

    static {
        INSTANCE = new PathTraversalChecker();
        PathTraversalActionTypeArg1 = "path_traversal_string_arg1";
        PathTraversalActionTypeArg2 = "path_traversal_string_arg2";
        PathTraversalActionTypeUri = "path_traversal_uri";
        enable = true;
    }

    public final boolean getEnable() {
        return enable;
    }

    public final boolean getEnableContentResolverIntercept() {
        return enableContentResolverIntercept;
    }

    public final boolean getEnableFileInputStreamIntercept() {
        return enableFileInputStreamIntercept;
    }

    public final boolean getEnableFileIntercept() {
        return enableFileIntercept;
    }

    public final boolean getEnableFileOutputStreamIntercept() {
        return enableFileOutputStreamIntercept;
    }

    public final boolean getEnableFileReaderIntercept() {
        return enableFileReaderIntercept;
    }

    public final boolean getEnableFileWriterIntercept() {
        return enableFileWriterIntercept;
    }

    public final boolean getEnableIntercept() {
        return enableIntercept;
    }

    public final boolean getEnableZipFileIntercept() {
        return enableZipFileIntercept;
    }

    public final String getPathTraversalActionTypeArg1() {
        return PathTraversalActionTypeArg1;
    }

    public final String getPathTraversalActionTypeArg2() {
        return PathTraversalActionTypeArg2;
    }

    public final String getPathTraversalActionTypeUri() {
        return PathTraversalActionTypeUri;
    }

    @JvmStatic
    public static final boolean check(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (enable == true) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith$default(r100, "../", false, 2, null) == false) goto L11;
    L14:
        InfoMon.doPathTraversalReport(r100, "", PathTraversalActionTypeArg1);
        return true;
    L11:
        if (StringsKt.contains$default(r100, "/../", false, 2, null) == true) goto L14;
        return false;
    }

    public final void setEnable(boolean r100) {
        enable = r100;
    }

    public final void setEnableContentResolverIntercept(boolean r100) {
        enableContentResolverIntercept = r100;
    }

    public final void setEnableFileInputStreamIntercept(boolean r100) {
        enableFileInputStreamIntercept = r100;
    }

    public final void setEnableFileIntercept(boolean r100) {
        enableFileIntercept = r100;
    }

    public final void setEnableFileOutputStreamIntercept(boolean r100) {
        enableFileOutputStreamIntercept = r100;
    }

    public final void setEnableFileReaderIntercept(boolean r100) {
        enableFileReaderIntercept = r100;
    }

    public final void setEnableFileWriterIntercept(boolean r100) {
        enableFileWriterIntercept = r100;
    }

    public final void setEnableIntercept(boolean r100) {
        enableIntercept = r100;
    }

    public final void setEnableZipFileIntercept(boolean r100) {
        enableZipFileIntercept = r100;
    }

    @JvmStatic
    public static final boolean check(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getPath();
        if (r101 != null) goto L8;
        return false;
    L8:
        return check(r101);
    }

    @JvmStatic
    public static final boolean check(URI r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return check(r100.getPath());
    }
}
