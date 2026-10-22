package com.ss.android.ugc.aweme.dependence.download.persistence.task;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003R$\u0010\n\u001a\u0004\u0018\u00018\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/dependence/download/persistence/task/SerialTask;", "Param", "Target", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "result", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class SerialTask<Param, Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Target f450011a;

    public final void setResult(Target r100) {
        this.f450011a = r100;
    }
}
