package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f433756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f433757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f433758c;

    public final synchronized void a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);     // Catch: Throwable -> L12
        if (this.f433758c.remove(r100) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f433758c.isEmpty() == false) goto L10;
        this.f433757b.release();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public c(b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "delegate");
        this.f433756a = r100;
        this.f433757b = r101;
        this.f433758c = new LinkedHashSet();
    }

    public final synchronized void b(String r100, MmRecordingSource r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r101, "source");     // Catch: Throwable -> L15
        if (this.f433756a.f433755a.contains(r101) == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.f433758c.add(r100) == false) goto L13;
        if (this.f433758c.size() != 1) goto L11;
        this.f433757b.a(r101);     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
