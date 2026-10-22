package com.obric.sva.sdk.controller;

import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/sva/sdk/controller/ManufactureFeatures;", "", "<init>", "()V", "TAG", "", "BREATH_WAKEUP_DEFAULT_VALUE", "", "FASTER_VOICE_COMMAND_DEFAULT_VALUE", "VIP_PID_DEFAULT_VALUE", "breathFeatureMaps", "", "voiceCommandFasterFeatureMaps", "vipPidFeatureMaps", "isFeatureBreathWakeupEnable", "isFeatureVoiceCommandFasterFeatureEnable", "isFeatureVipPidEnable", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManufactureFeatures {
    private static final boolean BREATH_WAKEUP_DEFAULT_VALUE = true;
    private static final boolean FASTER_VOICE_COMMAND_DEFAULT_VALUE = true;
    public static final ManufactureFeatures INSTANCE = null;
    public static final String TAG = "ManufactureFeatures";
    private static final boolean VIP_PID_DEFAULT_VALUE = true;
    private static final Map<String, Boolean> breathFeatureMaps = null;
    private static final Map<String, Boolean> vipPidFeatureMaps = null;
    private static final Map<String, Boolean> voiceCommandFasterFeatureMaps = null;

    private ManufactureFeatures() {
    }

    static {
        INSTANCE = new ManufactureFeatures();
        Boolean r100 = Boolean.TRUE;
        Boolean r101 = Boolean.FALSE;
        breathFeatureMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", r100), TuplesKt.to("genesis-r", r101)});
        voiceCommandFasterFeatureMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", r100), TuplesKt.to("genesis-r", r101)});
        vipPidFeatureMaps = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("default", r100), TuplesKt.to("genesis-r", r101)});
    }

    @JvmStatic
    public static final boolean isFeatureBreathWakeupEnable() {
        Map<String, Boolean> r100 = breathFeatureMaps;
        KtUtils r101 = KtUtils.INSTANCE;
        Boolean r102 = r100.get(r101.getPlatformName());
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        LogUtils.d(TAG, "isFeatureBreathWakeupEnable " + r103 + " with platform " + r101.getPlatformName(), new Object[0]);
        return r103;
    L5:
        r103 = true;
        goto L6
    }

    @JvmStatic
    public static final boolean isFeatureVipPidEnable() {
        Map<String, Boolean> r100 = vipPidFeatureMaps;
        KtUtils r101 = KtUtils.INSTANCE;
        Boolean r102 = r100.get(r101.getPlatformName());
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        LogUtils.d(TAG, "isFeatureVipPidEnable " + r103 + " with platform " + r101.getPlatformName(), new Object[0]);
        return r103;
    L5:
        r103 = true;
        goto L6
    }

    @JvmStatic
    public static final boolean isFeatureVoiceCommandFasterFeatureEnable() {
        Map<String, Boolean> r100 = voiceCommandFasterFeatureMaps;
        KtUtils r101 = KtUtils.INSTANCE;
        Boolean r102 = r100.get(r101.getPlatformName());
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        LogUtils.d(TAG, "isFeatureVoiceCommandFasterFeatureEnable " + r103 + " with platform " + r101.getPlatformName(), new Object[0]);
        return r103;
    L5:
        r103 = true;
        goto L6
    }
}
