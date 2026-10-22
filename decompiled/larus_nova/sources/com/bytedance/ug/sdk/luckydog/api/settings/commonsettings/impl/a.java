package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl;

import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f271627a = null;

    static {
        int[] r100 = new int[ILuckyDogCommonSettingsService.Channel.values().length];
        f271627a = r100;
        r100[ILuckyDogCommonSettingsService.Channel.STATIC.ordinal()] = 1;
        r100[ILuckyDogCommonSettingsService.Channel.DYNAMIC.ordinal()] = 2;
        r100[ILuckyDogCommonSettingsService.Channel.POLL.ordinal()] = 3;
    }
}
