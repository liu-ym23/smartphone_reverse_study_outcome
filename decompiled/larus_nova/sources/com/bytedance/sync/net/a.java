package com.bytedance.sync.net;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import xf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3780a f270377a = null;

    /* JADX INFO: renamed from: com.bytedance.sync.net.a$a, reason: collision with other inner class name */
    public static class C3780a extends n<ExecutorService> {
        public C3780a() {
        }

        @Override // xf7.n
        public final ExecutorService a(Object[] r100) {
            return PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("NetThreadPool$1"));
        }
    }

    static {
        f270377a = new C3780a();
    }
}
