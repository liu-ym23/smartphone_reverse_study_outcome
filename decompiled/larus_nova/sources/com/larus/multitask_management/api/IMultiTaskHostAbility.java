package com.larus.multitask_management.api;

import kl9.d;
import kl9.n;
import kl9.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import pd6.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H&¨\u0006\u0018"}, d2 = {"Lcom/larus/multitask_management/api/IMultiTaskHostAbility;", "Lcom/bytedance/kmp/spi/IKmpService;", "closeMultiTaskPage", "", "presentingTaskListType", "showConfirmDialog", "", "taskBasicInfo", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "index", "", "confirmConfig", "Lcom/larus/multitask_management/api/data/ConfirmConfig;", "(Lcom/larus/multitask_management/api/data/TaskBasicInfo;ILcom/larus/multitask_management/api/data/ConfirmConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServerTime", "", "getLanguage", "isMultiTaskManagementEnabled", "getMultiTaskManagementConfig", "Lcom/larus/multitask_management/api/data/MultiTaskManagementConfig;", "showNetworkErrorToast", "", "showPinExceedLimitToast", "msg", "multitask_management_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMultiTaskHostAbility extends a {
    boolean P0();

    void e2();

    Object g1(u r100, int r101, d r102, Continuation<? super Boolean> r103);

    String getLanguage();

    n getMultiTaskManagementConfig();

    long getServerTime();

    String i();

    void i0(String r100);

    String m();
}
