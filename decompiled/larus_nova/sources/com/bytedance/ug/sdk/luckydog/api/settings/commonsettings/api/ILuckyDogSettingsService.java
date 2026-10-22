package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api;

import am7.b;
import com.bytedance.ug.sdk.luckydog.api.ab.ABService;
import com.bytedance.ug.sdk.luckydog.api.ab.ABServiceEffectTime;
import com.bytedance.ug.sdk.luckydog.api.ab.ABServiceType;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.c;
import fk7.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ABService(effectTime = ABServiceEffectTime.ColdLaunch, serviceType = ABServiceType.SETTINGS)
public interface ILuckyDogSettingsService extends d, ILuckyDogCommonSettingsService {
    /* synthetic */ boolean allStageIsForbidden();

    /* synthetic */ boolean firstSettingHasRequestBack(ILuckyDogCommonSettingsService.Channel r100);

    /* synthetic */ ArrayList<b.c> getCurrentPollingSettingsDataByStageName(String r100);

    /* synthetic */ b.c getCurrentPollingSettingsDataByStageNameAndCid(String r100, int r101);

    /* synthetic */ b getPollingSettingsData();

    /* synthetic */ Object getSettingsByKey(ILuckyDogCommonSettingsService.Channel r100, String r101);

    /* synthetic */ <T> T getSettingsByKey(ILuckyDogCommonSettingsService.Channel r100, String r101, Class<T> r102);

    /* synthetic */ <T> T getSettingsByKey(ILuckyDogCommonSettingsService.Channel r100, String r101, Type r102);

    /* synthetic */ void getSettingsByKey(ILuckyDogCommonSettingsService.Channel r100, List<String> r101, xk7.b r102);

    /* synthetic */ void init();

    /* synthetic */ boolean registerPollingSettingFinishDataHandler(boolean r100, c r101);

    /* synthetic */ boolean registerUpdateSettingFinishHandler(ILuckyDogCommonSettingsService.Channel r100, com.bytedance.ug.sdk.luckydog.api.settings.d r101);

    /* synthetic */ void release();

    /* synthetic */ boolean unRegisterPollingSettingFinishDataHandlerWithKey(c r100);

    /* synthetic */ boolean unRegisterUpdateSettingFinishHandlerWithKey(ILuckyDogCommonSettingsService.Channel r100, com.bytedance.ug.sdk.luckydog.api.settings.d r101);

    /* synthetic */ void updateSettingIfNeededFromScene(ILuckyDogCommonSettingsService.Channel r100, String r101);
}
