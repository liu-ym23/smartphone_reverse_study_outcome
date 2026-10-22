package xk7;

import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f564242a = null;

    static {
        int[] r100 = new int[ILuckyDogCommonSettingsService.Channel.values().length];
        f564242a = r100;
        r100[ILuckyDogCommonSettingsService.Channel.STATIC.ordinal()] = 1;
        r100[ILuckyDogCommonSettingsService.Channel.DYNAMIC.ordinal()] = 2;
        r100[ILuckyDogCommonSettingsService.Channel.POLL.ordinal()] = 3;
    }
}
