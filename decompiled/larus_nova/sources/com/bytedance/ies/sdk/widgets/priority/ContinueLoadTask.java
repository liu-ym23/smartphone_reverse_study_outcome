package com.bytedance.ies.sdk.widgets.priority;

import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class ContinueLoadTask implements Runnable {
    private Runnable task;
    private Widget widget;
    private int widgetHash;
    private String widgetName;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_ies_sdk_widgets_priority_ContinueLoadTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ies_sdk_widgets_priority_ContinueLoadTask__run$___twin___() {
        GroupSchedule.getInstance().enqueueContinueLoad(this.widget, new AnonymousClass1(this));
    }

    public static /* synthetic */ Runnable access$000(ContinueLoadTask r100) {
        return r100.task;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ies_sdk_widgets_priority_ContinueLoadTask_com_larus_apm_impl_protector_RunnableLancet_run(ContinueLoadTask r100) {
        r100.com_bytedance_ies_sdk_widgets_priority_ContinueLoadTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ContinueLoadTask(Widget r100, Runnable r101) {
        this.widgetName = r100.getClass().getSimpleName();
        this.widgetHash = r100.hashCode();
        this.widget = r100;
        this.task = r101;
    }
}
