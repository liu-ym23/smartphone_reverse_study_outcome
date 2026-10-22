package com.ss.android.ugc.effectmanager.common.cachemanager;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.ugc.effectmanager.common.utils.FileUtils;
import java.io.File;
import java.io.InputStream;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/cachemanager/FileICache;", "Lcom/ss/android/ugc/effectmanager/common/cachemanager/ICache;", "cacheDir", "", "(Ljava/lang/String;)V", "getCacheDir", "()Ljava/lang/String;", "setCacheDir", "clear", "", "generatePath", "key", "has", "", "queryToStream", "Ljava/io/InputStream;", "queryToValue", "remove", "removePattern", "pattern", "Ljava/util/regex/Pattern;", "patternStr", SVGRenderEngine.SAVE, "", "inputStream", "value", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class FileICache implements ICache {
    private String cacheDir;

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public void clear() {
        FileUtils.INSTANCE.removeDir(this.cacheDir);
    }

    public final String getCacheDir() {
        return this.cacheDir;
    }

    public FileICache(String r100) {
        this.cacheDir = r100;
    }

    private final String generatePath(String r100) {
        return this.cacheDir + File.separator + r100;
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public boolean has(String r100) {
        return FileUtils.INSTANCE.checkFileExists(generatePath(r100));
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public InputStream queryToStream(String r100) {
        String r101 = generatePath(r100);
        monitor-enter(FileICache.class);
        InputStream r102 = FileUtils.INSTANCE.getFileStream(r101);     // Catch: Throwable -> L7
        monitor-exit(FileICache.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public String queryToValue(String r100) {
        String r101 = generatePath(r100);
        monitor-enter(FileICache.class);
        String r102 = FileUtils.INSTANCE.getFileContent(r101);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r102) == false) goto L7;
        r102 = "";
    L7:
        monitor-exit(FileICache.class);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public boolean remove(String r100) {
        monitor-enter(FileICache.class);
        boolean r101 = FileUtils.INSTANCE.removeFile(generatePath(r100));     // Catch: Throwable -> L7
        monitor-exit(FileICache.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public void removePattern(final Pattern r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        monitor-enter(FileICache.class);
        File[] r101 = new PolarisFileWrapper(this.cacheDir).listFiles(new FileICache$removePattern$$inlined$apply$lambda$1(r100, this));     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        int r102 = r101.length;     // Catch: Throwable -> L15
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L10;
        r101[r103].delete();     // Catch: Throwable -> L15
        r103 = r103 + 1;     // Catch: Throwable -> L15
        goto L8
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(FileICache.class);
        return;
    L13:
        monitor-exit(FileICache.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void setCacheDir(String r100) {
        this.cacheDir = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public void removePattern(String r100) {
        removePattern(PatternProtector.compile(r100));
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public long save(String r100, InputStream r101) {
        monitor-enter(FileICache.class);
        long r102 = FileUtils.INSTANCE.writeToExternal(r101, generatePath(r100));     // Catch: Throwable -> L7
        monitor-exit(FileICache.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.effectmanager.common.cachemanager.ICache
    public long save(String r100, String r101) {
        monitor-enter(FileICache.class);
        long r102 = FileUtils.INSTANCE.writeToExternal(r101, generatePath(r100));     // Catch: Throwable -> L7
        monitor-exit(FileICache.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }
}
