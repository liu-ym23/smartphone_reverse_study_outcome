package com.ss.android.lark.lynxkit.bridge;

import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeRuntimeProtocol;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderConfigurator;", "factory", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "<init>", "(Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;)V", "configure", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", LynxViewpagerItem.BIND_ON_ATTACH, "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolHandle;", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "RuntimeBuilderHandle", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLynxBridgeRuntimeProtocol implements ILarkLynxBridgeProtocol, ILarkLynxBridgeProtocolBuilderConfigurator {
    private final ILarkLynxBridgeRuntimeFactory factory;

    public static final class a implements ILarkLynxBridgeProtocolBuilderHandle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILarkLynxBridgeRuntime f431427a;

        @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolBuilderHandle
        public final void dispose() {
            this.f431427a.dispose();
        }

        public a(ILarkLynxBridgeRuntime r100) {
            Intrinsics.checkNotNullParameter(r100, "runtime");
            this.f431427a = r100;
        }
    }

    public LarkLynxBridgeRuntimeProtocol(ILarkLynxBridgeRuntimeFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        this.factory = r100;
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol
    public ILarkLynxBridgeProtocolHandle attach(LarkLynxBridgeProtocolContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILarkLynxBridgeProtocolBuilderHandle r101 = r100.getBuilderHandle();
        if ((r101 instanceof a) == false) goto L5;
        a r102 = (a) r101;
    L6:
        if (r102 == null) goto L10;
        r102.f431427a.attach(r100);
        return r102.f431427a;
    L10:
        throw new IllegalStateException("bridge runtime builder handle missing");
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolBuilderConfigurator
    public ILarkLynxBridgeProtocolBuilderHandle configure(LarkLynxBridgeProtocolBuilderContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILarkLynxBridgeRuntime r101 = this.factory.create(r100);
        r101.configure(r100);     // Catch: Throwable -> L6
        return new a(r101);
    L6:
        th = move-exception;
        r101.dispose();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L11
    }
}
