package com.bytedance.ies.android.base.runtime.depend;

import android.content.Context;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.user.IAdUserDepend", imports = {}))
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IUserDepend;", "", "", "getUserId", "getSecUid", "getUniqueID", "getNickname", "getAvatarURL", "", "hasBoundPhone", "hasLogin", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/ies/android/base/runtime/depend/IUserDepend$a;", "loginStatusCallback", "", "login", "logout", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public interface IUserDepend {

    public interface a {
    }

    String getAvatarURL();

    String getNickname();

    String getSecUid();

    String getUniqueID();

    String getUserId();

    boolean hasBoundPhone();

    boolean hasLogin();

    void login(Context r100, a r101);

    void logout(Context r100);
}
