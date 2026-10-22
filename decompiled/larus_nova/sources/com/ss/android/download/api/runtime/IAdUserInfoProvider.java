package com.ss.android.download.api.runtime;

import android.content.Context;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import q6.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&¨\u0006\u000f"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdUserInfoProvider;", "", "Lcom/ss/android/download/api/model/AppInfo;", "getAppUserInfo", "", "hasLogin", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lq6/a$a;", "callback", "", "login", "logout", "", "getCurrentTelecomCarrier", "download-api_release"}, k = 1, mv = {1, 4, 0})
public interface IAdUserInfoProvider {
    AppInfo getAppUserInfo();

    String getCurrentTelecomCarrier();

    boolean hasLogin();

    void login(Context r100, a.InterfaceC7282a r101);

    void logout(Context r100);
}
