package com.ss.android.lark.chameleon.idependency;

import android.app.Application;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/IEnv;", "", "getAppId", "", "getApplication", "Landroid/app/Application;", "getCacheLanguageSetting", "Ljava/util/Locale;", "getDeviceId", "", "getFontSize", "getGeckoDomain", "getUserAgent", "getUserId", "isDarkMode", "", "isDebug", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEnv {
    int getAppId();

    Application getApplication();

    Locale getCacheLanguageSetting();

    String getDeviceId();

    int getFontSize();

    String getGeckoDomain();

    String getUserAgent();

    String getUserId();

    boolean isDarkMode();

    boolean isDebug();
}
