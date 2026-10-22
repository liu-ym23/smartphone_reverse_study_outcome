package com.larus.appsflyer.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\tH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/appsflyer/api/IAppsflyerService;", "", "ugLandingTag", "", "getUgLandingTag", "()Ljava/lang/String;", "setUgLandingTag", "(Ljava/lang/String;)V", "init", "", "appContext", "Landroid/content/Context;", "start", PerfLog.PARAM_KEY_CONTEXT_ID, "setConsent", "scene", "", "reportInstanceId", "getStoreRegion", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppsflyerService {
    String a();

    void b();

    void c();

    void init();

    void start();
}
