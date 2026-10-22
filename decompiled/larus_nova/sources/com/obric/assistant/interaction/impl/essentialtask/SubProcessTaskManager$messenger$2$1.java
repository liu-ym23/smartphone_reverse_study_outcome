package com.obric.assistant.interaction.impl.essentialtask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/assistant/interaction/impl/essentialtask/SubProcessTaskManager$messenger$2$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubProcessTaskManager$messenger$2$1 extends Handler {
    public static /* synthetic */ void a() {
        handleMessage$lambda$0();
    }

    private static final void handleMessage$lambda$0() {
        SubProcessTaskManager.access$getExecuteSucceedState$p().setValue(Boolean.TRUE);
    }

    public SubProcessTaskManager$messenger$2$1(Looper r100) {
        super(r100);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 1) goto L6;
        FLogger.f375446a.w("EssentialTaskSubProcessTaskManager", "handleMessage: MSG_ON_EXECUTE_SUCCEED");
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, "EssentialTaskSubProcessTaskManager", "handleMessage: MSG_ON_EXECUTE_SUCCEED", null, 4, null);
        t0.e(new h());
        return;
    }
}
