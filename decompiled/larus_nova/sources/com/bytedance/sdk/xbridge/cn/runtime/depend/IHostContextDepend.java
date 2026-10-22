package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Application;
import android.content.Context;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \"2\u00020\u0001:\u0001#J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0004H&J\b\u0010\u0016\u001a\u00020\u0012H&J\b\u0010\u0017\u001a\u00020\u0004H&J\b\u0010\u0018\u001a\u00020\u0012H&J\b\u0010\u0019\u001a\u00020\u0012H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&J\b\u0010!\u001a\u00020 H\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "", "Landroid/app/Application;", "getApplication", "", "getDeviceId", "", "getAppId", "getAppName", "getChannel", "", "getVersionCode", "getVersionName", "getUpdateVersion", "getLanguage", "getSkinType", "getSkinName", "getPackageName", "", "isDebuggable", "isBoeEnable", "getBoeChannel", "isPPEEnable", "getPPEChannel", "isTeenMode", "isBaseMode", "getCurrentTelcomCarrier", "", "Lre7/a;", "settingKeys", "Lre7/b;", "getSettings", "Landroid/content/Context;", "getApplicationContext", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostContextDepend {
    public static final a Companion = null;
    public static final String SKIN_TYPE_BLACK = "black";
    public static final String SKIN_TYPE_WHITE = "white";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f270092a = null;

        static {
            f270092a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f270092a;
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

    List<re7.b> getSettings(List<re7.a> r100);

    String getSkinName();

    String getSkinType();

    String getUpdateVersion();

    long getVersionCode();

    String getVersionName();

    boolean isBaseMode();

    boolean isBoeEnable();

    boolean isDebuggable();

    boolean isPPEEnable();

    boolean isTeenMode();
}
