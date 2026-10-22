package com.bytedance.ies.bullet.service.monitor;

import android.view.View;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f247969a = null;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.service.monitor.a$a, reason: collision with other inner class name */
    public static final class RunnableC3544a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f247970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f247972c;

        public RunnableC3544a(String r100, String r101, String r102) {
            this.f247970a = r100;
            this.f247971b = r101;
            this.f247972c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ContainerStandardMonitor.INSTANCE.addContext(this.f247970a, this.f247971b, this.f247972c);     // Catch: Throwable -> L4
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f247973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f247974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f247975c;

        public b(String r100, View r101, String r102) {
            this.f247973a = r100;
            this.f247974b = r101;
            this.f247975c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ContainerStandardMonitor.INSTANCE.attach(this.f247973a, this.f247974b, this.f247975c);     // Catch: Throwable -> L4
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f247976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f247978c;

        public c(String r100, String r101, Object r102) {
            this.f247976a = r100;
            this.f247977b = r101;
            this.f247978c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ContainerStandardMonitor.INSTANCE.collect(this.f247976a, this.f247977b, this.f247978c);     // Catch: Throwable -> L4
            return;
        }
    }

    static {
        f247969a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ContainerStandardMonitorWrapper"));
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        f247969a.execute(new RunnableC3544a(r100, r101, r102));
    }

    public static void b(String r100, View r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "type");
        f247969a.execute(new b(r100, r101, r102));
    }

    public static void c(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "data");
        f247969a.execute(new c(r100, r101, r102));
    }

    public static void d(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        Intrinsics.checkNotNullParameter("88888", "virtualAid");
        Intrinsics.checkNotNullParameter("", "biz");
        ContainerStandardMonitor.INSTANCE.reportError(r100, r101, 100, r102, "88888", "");
    }
}
