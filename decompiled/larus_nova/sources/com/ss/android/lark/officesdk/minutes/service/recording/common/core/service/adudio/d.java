package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Unit;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f434361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f434362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f434363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f434364d;

    public d(b r100, String r101, long r102, long r103) {
        this.f434361a = r100;
        this.f434362b = r101;
        this.f434363c = r102;
        this.f434364d = r103;
    }

    public final void a() {
        b r100 = this.f434361a;
        String r101 = this.f434362b;
        long r102 = this.f434363c;
        long r103 = this.f434364d;
        monitor-enter(r100);
        VFSFile r110 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r101);     // Catch: Throwable -> L15
        if (r110.exists() == true) goto L7;
    L12:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Cache directory does not exist or is not a valid directory: ".concat(r101));     // Catch: Throwable -> L15
        monitor-exit(r100);
        return;
    L7:
        if (r110.isDirectory() == false) goto L12;
        lvb.a.e("MmAudioCacheCleanupUtil", "Starting cache cleanup for directory: ".concat(r101));     // Catch: Throwable -> L15
        lvb.a.e("MmAudioCacheCleanupUtil", "Policy 1: Delete files older than " + r102 + " days.");     // Catch: Throwable -> L15
        lvb.a.e("MmAudioCacheCleanupUtil", "Policy 2: If directory size exceeds " + r103 + " MB, clean oldest files.");     // Catch: Throwable -> L15
        b.a(r100, r110, r102);     // Catch: Throwable -> L15
        b.b(r100, r110, r103 * 1048576);     // Catch: Throwable -> L15
        lvb.a.e("MmAudioCacheCleanupUtil", "Cache directory cleanup finished: ".concat(r101));     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r100);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
