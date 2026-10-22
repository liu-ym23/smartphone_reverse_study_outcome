package com.ss.android.lark.flow.threadwindow;

import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$1 extends FunctionReferenceImpl implements Function3<String, Integer, Long, Unit> {
    public FlowThreadWindowMediaRootStateHandler$createUploadPushHandler$1(Object r100) {
        super(3, r100, FlowThreadWindowMediaRootStateHandler.class, "onPushMediaUploadProgress", "onPushMediaUploadProgress(Ljava/lang/String;IJ)V", 0);
    }

    public final void invoke(final String r100, final int r110, final long r111) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        final FlowThreadWindowMediaRootStateHandler r101 = (FlowThreadWindowMediaRootStateHandler) this.receiver;
        if (r101.f424188f.invoke().booleanValue() == true) goto L7;
        CoreThreadPool.getDefault().getUIExecutor().execute(new FlowThreadWindowMediaRootStateHandler$onPushMediaUploadProgress$1(r101, r100, r110, r111));
        return;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Integer r101, Long r102) {
        invoke(r100, r101.intValue(), r102.longValue());
        return Unit.INSTANCE;
    }
}
