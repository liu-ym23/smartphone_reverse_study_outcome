package com.ss.android.lark.setting.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.bytedance.lark.pb.im.v1.ContentType;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.setting.api.entity.ParcelableLanguageInfo;
import com.ss.android.lark.setting.api.entity.ParcelableTranslateSettingConfig;
import java.util.List;
import java.util.Locale;
import z4c.a;
import z4c.c;
import z4c.d;
import z4c.e;
import z4c.f;

/* JADX INFO: loaded from: classes38.dex */
public interface ISettingApi {
    void addFontSettingChangeListener(a r100);

    void addLocaleSelectListener(f r100);

    void addSettingsUpdateListener(d r100);

    void changeLanguageSetting(Context r100, Locale r101, IGetDataCallback<Boolean> r102);

    Context configFontForApplication(Context r100);

    void detectSourceLanguage(String[] r100, IGetDataCallback<ParcelableLanguageInfo> r101);

    void detectSourceLanguageRemote(String[] r100, IGetDataCallback<ParcelableLanguageInfo> r101);

    String getSettingAppLinkPath();

    void getTargetLangList(IGetDataCallback<List<ParcelableLanguageInfo>> r100);

    void getTargetLangListRemote(IGetDataCallback<List<ParcelableLanguageInfo>> r100);

    e getUiModeService();

    void getWebTranslateSetting(String r100, String r101, IGetDataCallback<ParcelableTranslateSettingConfig> r102);

    void getWebTranslateSettingRemote(String r100, String r101, IGetDataCallback<ParcelableTranslateSettingConfig> r102);

    void goMineTranslationSettingPage(Context r100);

    void initFontFGSetting();

    void notifySettingsAndRestartApp(Activity r100);

    void openLanguageSettingPage(Context r100, Bundle r101);

    void openNetworkDiagnoseSetting(Context r100, String r101);

    void registerMultiNetChangedListener(Context r100, c r101);

    void removeFontSettingChangeListener(a r100);

    void removeLocaleSelectListener(f r100);

    void removeSettingsUpdateListener(d r100);

    void sendInitGear();

    void sendTranslateRequest(String r100, String r101, String[] r102, ContentType r103, IGetDataCallback<List<String>> r104);

    void sendTranslateRequestRemote(String r100, String r101, String[] r102, ContentType r103, IGetDataCallback<List<String>> r104);

    void setAutoTranslate(boolean r100, IGetDataCallback<Void> r101);

    void setAutoTranslateRemote(boolean r100, IGetDataCallback<Void> r101);

    void setUnTranslateThisLanguage(ParcelableLanguageInfo r100, boolean r101, IGetDataCallback<Void> r102);

    void setUnTranslateThisLanguageRemote(ParcelableLanguageInfo r100, boolean r101, IGetDataCallback<Void> r102);

    void setUnTranslateThisSite(String r100, boolean r101, IGetDataCallback<Void> r102);

    void setUnTranslateThisSiteRemote(String r100, boolean r101, IGetDataCallback<Void> r102);

    void showConfirmLanguageSettingDialog(Context r100, Locale r101, DialogInterface.OnClickListener r102);

    void startLanguageAndTranslate(Activity r100);

    void startSettingPage(Context r100);

    void unregisterMultiNetChangedListener(Context r100, c r101);
}
