package com.bytedance.ee.bear.document.analytic.processmonitor.sandbox;

import android.content.Context;
import android.os.Process;
import com.bytedance.apm.util.b;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.bytedance.monitor.collector.c;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu5.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@RemoteServiceImpl(service = ISandboxProcessServer.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/analytic/processmonitor/sandbox/SandboxProcessServer;", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/sandbox/ISandboxProcessServer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getSandboxCPUTime", "", "getCurrentCpuRate", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/CpuInfo;", "processName", "", "enableThread", "", "getSandboxMemory", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SandboxProcessServer implements ISandboxProcessServer {
    public static final a Companion = null;
    private static final String TAG = "SandboxProcessServerImpl";
    private static volatile boolean alreadyTryLoad;
    private final Context context;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxCPUTime() {
        tt5.a.h(TAG, "getPidCPUTime start");
        long r100 = b.d(Process.myPid());
        tt5.a.h(TAG, "getPidCPUTime=" + r100);
        return r100;
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxMemory() {
        tt5.a.h(TAG, "getSandboxMemory... id = " + Process.myPid());
        return g.b(Process.myPid());
    }

    public static final /* synthetic */ boolean access$getAlreadyTryLoad$cp() {
        return alreadyTryLoad;
    }

    public SandboxProcessServer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
    }

    public static final /* synthetic */ void access$setAlreadyTryLoad$cp(boolean r100) {
        alreadyTryLoad = r100;
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public CpuInfo getCurrentCpuRate(String r100, boolean r101) {
        tt5.a.h(TAG, "getCurrentCpuRate");
        if (c.f265641j == false) goto L5;
    L12:
        int r102 = c05.b.f21942b;
        return c05.b.a.a(r100, r101);
    L5:
        if (alreadyTryLoad == true) goto L12;
        tt5.a.h(TAG, "getCurrentCpuRate loadLibrary");
        c.h(LarkContext.getApplication());     // Catch: Throwable -> L9
    L11:
        alreadyTryLoad = true;
    L9:
        th = move-exception;
        tt5.a.f(TAG, th, false);
        goto L11
    }
}
