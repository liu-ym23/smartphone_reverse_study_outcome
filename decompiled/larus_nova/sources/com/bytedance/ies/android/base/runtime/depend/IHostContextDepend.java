package com.bytedance.ies.android.base.runtime.depend;

import android.app.Application;
import android.content.Context;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "不同方法拆分到了各个API，参考com.bytedance.android.ad.sdk.api下的所有class", imports = {}))
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u001f2\u00020\u0001:\u0001 J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0014\u001a\u00020\u0013H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0016\u001a\u00020\u0013H&J\b\u0010\u0017\u001a\u00020\u0013H&J\b\u0010\u0018\u001a\u00020\u0004H&J\b\u0010\u0019\u001a\u00020\u0013H&J\b\u0010\u001a\u001a\u00020\u0004H&J\b\u0010\u001b\u001a\u00020\u0013H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u001e\u001a\u00020\u001dH\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IHostContextDepend;", "", "Landroid/app/Application;", "getApplication", "", "getDeviceId", "", "getAppId", "getAppName", "getRegion", "getChannel", "", "getVersionCode", "getVersionName", "getUpdateVersion", "getLanguage", "getSkinType", "getSkinName", "getPackageName", "", "isDebuggable", "getUserAgent", "isMiniAppEnable", "isBoeEnable", "getBoeChannel", "isPPEEnable", "getPPEChannel", "isTeenMode", "getCurrentTelcomCarrier", "Landroid/content/Context;", "getApplicationContext", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public interface IHostContextDepend {
    public static final a Companion = null;
    public static final String SKIN_TYPE_BLACK = "black";
    public static final String SKIN_TYPE_WHITE = "white";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f245615a = null;

        public a() {
        }

        static {
            f245615a = new a();
        }
    }

    static {
        Companion = a.f245615a;
    }

    int getAppId();

    String getAppName();

    Application getApplication();

    Context getApplicationContext();

    String getBoeChannel();

    String getChannel();

    String getCurrentTelcomCarrier();

    String getDeviceId();

    String getLanguage();

    String getPPEChannel();

    String getPackageName();

    String getRegion();

    String getSkinName();

    String getSkinType();

    String getUpdateVersion();

    String getUserAgent();

    long getVersionCode();

    String getVersionName();

    boolean isBoeEnable();

    boolean isDebuggable();

    boolean isMiniAppEnable();

    boolean isPPEEnable();

    boolean isTeenMode();
}
