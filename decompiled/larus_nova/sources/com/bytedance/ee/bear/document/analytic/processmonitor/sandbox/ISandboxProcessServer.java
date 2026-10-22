package com.bytedance.ee.bear.document.analytic.processmonitor.sandbox;

import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@RemoteService(hostProcess = "sandboxed_process0")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/ee/bear/document/analytic/processmonitor/sandbox/ISandboxProcessServer;", "Lee/android/framework/manis/interfaces/IHookInterface;", "getSandboxCPUTime", "", "getCurrentCpuRate", "Lcom/bytedance/ee/bear/document/analytic/processmonitor/entity/CpuInfo;", "processName", "", "enableThread", "", "getSandboxMemory", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISandboxProcessServer extends IHookInterface {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ CpuInfo getCurrentCpuRate$default(ISandboxProcessServer r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = false;
        L7:
            return r100.getCurrentCpuRate(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrentCpuRate");
        }
    }

    CpuInfo getCurrentCpuRate(String r100, boolean r101);

    long getSandboxCPUTime();

    long getSandboxMemory();
}
