package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002"}, d2 = {"Lcom/larus/init/task/InitAbTestExposureTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "<init>", "()V", "TAG", "", "run", "", "triggerGlobalExposure", "app_mainlandRelease", "globalExposureStarters", "", "Lcom/larus/abtest/api/IGlobalExposureStarter;"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitAbTestExposureTask extends bf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351004a;

    public InitAbTestExposureTask() {
        this.f351004a = "InitAbTestExposure";
    }

    @Override // java.lang.Runnable
    public final void run() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InitAbTestExposureTask$triggerGlobalExposure$1(this, null), 3, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
