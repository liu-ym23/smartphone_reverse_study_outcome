package com.ss.android.lark.flow.notification.online;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ohb.c;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/flow/notification/online/InitFlowNotificationTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "registerPush", "Companion", "flow-notification_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitFlowNotificationTask extends AbstractLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    public InitFlowNotificationTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        thb.a.b("InitFlowNotificationTask", "register user scope notification push now!");
        int r101 = ohb.a.f523340a;
        ((zsb.a) k.a(LarkContext.getApplication(), zsb.a.class)).t4(new c());
    }
}
