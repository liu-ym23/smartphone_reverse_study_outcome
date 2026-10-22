package com.obric.assistant.security.provision.check.api;

import android.content.Context;
import android.os.Bundle;
import com.obric.assistant.security.provision.check.bean.CheckState;
import com.obric.assistant.security.provision.check.bean.ProvisionResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/security/provision/check/api/ISecurityProvisionChecker;", "", "checkState", "Lcom/obric/assistant/security/provision/check/bean/CheckState;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startKeyProvision", "Lcom/obric/assistant/security/provision/check/bean/ProvisionResult;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISecurityProvisionChecker {
    CheckState a(Context r100);

    Object b(Context r100, Bundle r101, Continuation<? super ProvisionResult> r102);
}
