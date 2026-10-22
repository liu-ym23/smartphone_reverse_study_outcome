package com.ss.android.lark.security.compliance.infra.util;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@RemoteService
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/security/compliance/infra/util/ILogMonitorService;", "Lee/android/framework/manis/interfaces/IHookInterface;", "traceId", "", "getTraceId", "()Ljava/lang/String;", RemoteMessageConst.MSGID, "", "getMsgId", "()I", "security-compliance-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILogMonitorService extends IHookInterface {
    int getMsgId();

    String getTraceId();
}
