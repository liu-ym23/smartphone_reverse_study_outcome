package com.larus.avlink;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes24.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f293389a = null;

    static {
        f293389a = PThreadExecutorsUtils.newSingleThreadExecutor(new k0());
    }
}
