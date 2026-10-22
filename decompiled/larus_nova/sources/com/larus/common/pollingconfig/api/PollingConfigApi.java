package com.larus.common.pollingconfig.api;

import kotlin.Metadata;
import s09.a;
import s09.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/larus/common/pollingconfig/api/PollingConfigApi;", "", "init", "", "registerListener", "listener", "Lcom/larus/common/pollingconfig/api/PollingConfigListener;", "unregisterListener", "getConfigOrCache", "Lcom/larus/common/pollingconfig/api/PollingConfig;", "getConfigOrCacheByKey", "", "key", "getConfigOrNull", "getConfigOrNullByKey", "getCurrentTimeStamp", "", "()Ljava/lang/Long;", "compensationCallIfNeverSucceeded", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PollingConfigApi {
    Long c();

    a d();

    String e();

    String f(String r100);

    void g();

    a h();

    void i(b r100);

    void init();

    void j(b r100);
}
