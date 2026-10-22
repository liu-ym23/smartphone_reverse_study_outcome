package com.ss.android.lark.storage.file.migration;

import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements VFSPath.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f441003a;

    public e(d.a r100) {
        this.f441003a = r100;
    }

    @Override // com.ss.android.lark.vfs.VFSPath.a
    public final String transform(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originPath");
        return this.f441003a.f441001b;
    }
}
