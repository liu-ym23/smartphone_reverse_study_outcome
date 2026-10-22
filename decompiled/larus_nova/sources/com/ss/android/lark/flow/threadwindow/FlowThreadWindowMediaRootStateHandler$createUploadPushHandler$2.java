package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$2(Object r100) {
        super(1, r100, FlowThreadWindowMediaRootStateHandler.class, "onPushMediaUploadFailed", "onPushMediaUploadFailed(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        final FlowThreadWindowMediaRootStateHandler r101 = (FlowThreadWindowMediaRootStateHandler) this.receiver;
        if (r101.f424188f.invoke().booleanValue() == true) goto L7;
        CoreThreadPool.getDefault().getUIExecutor().execute(new FlowThreadWindowMediaRootStateHandler$onPushMediaUploadFailed$1(r101, r100));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
