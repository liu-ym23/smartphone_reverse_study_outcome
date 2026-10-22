package com.larus.common.mssdk.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001Jh\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0016\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H&J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H&J\b\u0010\u001a\u001a\u00020\u0007H&J\b\u0010\u001b\u001a\u00020\u0007H&¨\u0006\u001c"}, d2 = {"Lcom/larus/common/mssdk/api/IAppOpsService;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enable", "", "mockApi2OpsMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "blackListMode", "needStack", "maxCacheSize", "useNewTag", "createAttributionService", "serviceName", "createAttributionAdapter", "Landroid/bluetooth/BluetoothAdapter;", "setServiceBlackSet", "blackSet", "", "setServiceWhiteSet", "whiteSet", "isLocalTest", "isEnable", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppOpsService {
    void a(Set<String> r100);

    void b(Context r100, boolean r101, HashMap r102, boolean r103, int r104);

    void c(Set<String> r100);

    boolean isEnable();
}
