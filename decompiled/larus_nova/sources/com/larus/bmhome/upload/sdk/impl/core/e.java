package com.larus.bmhome.upload.sdk.impl.core;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import is8.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, d> f314866a;

    public e() {
        this.f314866a = new ConcurrentHashMap();
    }

    public final void a(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "state");
        d r102 = this.f314866a.get(r100);
        if (r102 == null) goto L8;
        z0<j> r103 = r102.f314863c;
        if (r103 == null) goto L9;
        r103.setValue(r101);
        return;
    L9:
        return;
    }
}
