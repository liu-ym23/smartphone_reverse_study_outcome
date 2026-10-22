package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/task/BenefitInitTask;", "Lcom/bytedance/ee/bear/task/BaseTask;", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Companion", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BenefitInitTask extends BaseTask {

    public static final class a {
    }

    static {
    }

    public BenefitInitTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseTask, com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        tt5.a.h("BenefitInitTask", "BenefitInitTask execute");
        org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6);
    }
}
