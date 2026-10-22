package com.bytedance.awemeopen.infra.base.net;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/IAoNetCall;", "", "cancel", "", "execute", "Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "getRequest", "Lcom/bytedance/awemeopen/infra/base/net/AoNetRequest;", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAoNetCall {
    void cancel();

    AoNetResponse execute();

    AoNetRequest getRequest();
}
