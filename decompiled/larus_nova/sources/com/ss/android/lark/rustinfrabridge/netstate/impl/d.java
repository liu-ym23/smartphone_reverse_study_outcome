package com.ss.android.lark.rustinfrabridge.netstate.impl;

import com.bytedance.lark.pb.basic.v1.GetWebSocketStatusResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<h3c.a> f439712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f439713b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f439714c = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f439715a = null;

        static {
            int[] r100 = new int[GetWebSocketStatusResponse.Status.values().length];
            f439715a = r100;
            r100[GetWebSocketStatusResponse.Status.CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f439715a[GetWebSocketStatusResponse.Status.OPENING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f439715a[GetWebSocketStatusResponse.Status.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f439716a = null;

        static {
            f439716a = new d();
        }
    }

    static {
        f439712a = new CopyOnWriteArrayList();
        ExecutorService r100 = CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("thread-pool-wschannel");
        f439713b = r100;
        f439714c = r100;
    }

    public d() {
    }
}
