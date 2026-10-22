package com.larus.bootprotector;

import com.bytedance.android.ec.core.event.a;
import com.larus.bootprotector.entity.LastException;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/bootprotector/IBootProtectorBizCallback;", "", "getBizTag", "", "getObservedCrashPortrait", "", "Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "getMinRequiredCrashCount", "", "onAppCrash", "", "currentCrashCount", "matchedPortrait", a.KEY_EXCEPTION, "Lcom/larus/bootprotector/entity/LastException;", "onAppRestartAfterCrash", "onBootProtectorOptBtnClick", "", "onBootProtectorDownloadBtnClick", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBootProtectorBizCallback {
    void a(LastException r100);

    List<CrashPortrait> b();

    void c(int r100, CrashPortrait r101, LastException r102);

    int d();

    void e(LastException r100);

    void f(int r100, CrashPortrait r101, LastException r102);

    String getBizTag();
}
