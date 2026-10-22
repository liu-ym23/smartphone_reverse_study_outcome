package com.obric.assistant.interaction.impl;

import android.content.ComponentName;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.larus.audio.utils.g1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.ISystemKeySettings;
import com.obric.assistant.system.ITaskStackService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/impl/SystemKeySettingsImpl;", "Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "<init>", "()V", "PRESS_START_TIMEOUT_VALUE", "", "", "[Ljava/lang/Long;", "singleClickAction", "", "doubleClickAction", "pressStartTimeout", "enableAiKeyWhenScreenOff", "", "observe", "", "updateSettings", "getSingleClickAction", "getDoubleClickAction", "getPressStartTimeout", "isAiKeyEnabledWhenScreenOff", "isAiKeyFingerPrintEnrolling", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemKeySettingsImpl implements ISystemKeySettings {
    private static final String AI_KEY_FINGER_PRINT_ENROLLING_CLASS = "com.android.settings.fingerprint.AIPoweredFingerprintEnrollingActivity";
    public static final Companion Companion = null;
    private static final int DEFAULT_DOUBLE_CLICK_ACTION = 1;
    private static final int DEFAULT_PRESS_START_TIMEOUT = 0;
    private static final int DEFAULT_SINGLE_CLICK_ACTION = 0;
    private static final String DOUBLE_CLICK_KEY = "double_click_key";
    private static final String ENABLE_AI_KEY_WHEN_SCREEN_OFF_KEY = "enable_ai_key_when_screen_off";
    private static final String PRESS_START_TIMEOUT_KEY = "ai_key_sensitivity";
    private static final String SINGLE_CLICK_KEY = "single_click_key";
    private static final String TAG = "AIKeySettingsImpl";
    private final Long[] PRESS_START_TIMEOUT_VALUE;
    private int doubleClickAction;
    private boolean enableAiKeyWhenScreenOff;
    private int pressStartTimeout;
    private int singleClickAction;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/SystemKeySettingsImpl$Companion;", "", "<init>", "()V", "TAG", "", "DOUBLE_CLICK_KEY", "SINGLE_CLICK_KEY", "ENABLE_AI_KEY_WHEN_SCREEN_OFF_KEY", "PRESS_START_TIMEOUT_KEY", "DEFAULT_SINGLE_CLICK_ACTION", "", "DEFAULT_DOUBLE_CLICK_ACTION", "DEFAULT_PRESS_START_TIMEOUT", "AI_KEY_FINGER_PRINT_ENROLLING_CLASS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void observe() {
        Handler r100 = g1.f290034a;
        final Handler r101 = g1.f290034a;
        ContentObserver r102 = new SystemKeySettingsImpl$observe$observer$1(this, r101);
        AppHost.Companion r103 = AppHost.f326268a;
        r103.getApplication().getContentResolver().registerContentObserver(Settings.Global.getUriFor(SINGLE_CLICK_KEY), false, r102);
        r103.getApplication().getContentResolver().registerContentObserver(Settings.Global.getUriFor(DOUBLE_CLICK_KEY), false, r102);
        r103.getApplication().getContentResolver().registerContentObserver(Settings.Global.getUriFor(ENABLE_AI_KEY_WHEN_SCREEN_OFF_KEY), false, r102);
        r103.getApplication().getContentResolver().registerContentObserver(Settings.Global.getUriFor(PRESS_START_TIMEOUT_KEY), false, r102);
    }

    private final void updateSettings() {
        AppHost.Companion r100 = AppHost.f326268a;
        this.singleClickAction = Settings.Global.getInt(r100.getApplication().getContentResolver(), SINGLE_CLICK_KEY, 0);
        this.doubleClickAction = Settings.Global.getInt(r100.getApplication().getContentResolver(), DOUBLE_CLICK_KEY, 1);
        if (Settings.Global.getInt(r100.getApplication().getContentResolver(), ENABLE_AI_KEY_WHEN_SCREEN_OFF_KEY, 1) != 1) goto L5;
        boolean r101 = true;
    L6:
        this.enableAiKeyWhenScreenOff = r101;
        this.pressStartTimeout = Settings.Global.getInt(r100.getApplication().getContentResolver(), PRESS_START_TIMEOUT_KEY, 0);
        if (ISystemKeySettings.Companion.getSUPPORTED_DOUBLE_CLICK_FUNCTIONS().contains(Integer.valueOf(this.doubleClickAction)) == true) goto L9;
        FLogger.f375446a.w(TAG, "doubleClickFunction is not supported, use default value: 1");
        this.doubleClickAction = 1;
    L9:
        FLogger.f375446a.w(TAG, "updateSettings, singleClickAction = " + this.singleClickAction + ", doubleClickAction = " + this.doubleClickAction + ", enableAiKeyWhenScreenOff = " + this.enableAiKeyWhenScreenOff + ", pressStartTimeout = " + this.pressStartTimeout);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.obric.assistant.interaction.api.ISystemKeySettings
    public long getPressStartTimeout() {
        int r100 = this.pressStartTimeout;
        if (r100 < 0) goto L8;
        Long[] r101 = this.PRESS_START_TIMEOUT_VALUE;
        if (r100 >= r101.length) goto L8;
        return r101[r100].longValue();
    L8:
        return this.PRESS_START_TIMEOUT_VALUE[0].longValue();
    }

    @Override // com.obric.assistant.interaction.api.ISystemKeySettings
    public boolean isAiKeyFingerPrintEnrolling() {
        ITaskStackService r100 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r100 == null) goto L7;
        ComponentName r101 = r100.c();
        if (r101 == null) goto L7;
        String r102 = r101.getClassName();
    L9:
        return Intrinsics.areEqual(r102, AI_KEY_FINGER_PRINT_ENROLLING_CLASS);
    L7:
        r102 = null;
        goto L9
    }

    public SystemKeySettingsImpl() {
        this.PRESS_START_TIMEOUT_VALUE = new Long[]{300L, 600L, 1000L};
        this.doubleClickAction = 1;
        this.enableAiKeyWhenScreenOff = true;
        updateSettings();
        observe();
    }

    @Override // com.obric.assistant.interaction.api.ISystemKeySettings
    public int getDoubleClickAction() {
        return this.doubleClickAction;
    }

    @Override // com.obric.assistant.interaction.api.ISystemKeySettings
    public int getSingleClickAction() {
        return this.singleClickAction;
    }

    @Override // com.obric.assistant.interaction.api.ISystemKeySettings
    public boolean isAiKeyEnabledWhenScreenOff() {
        return this.enableAiKeyWhenScreenOff;
    }

    public static final /* synthetic */ void access$updateSettings(SystemKeySettingsImpl r100) {
        r100.updateSettings();
    }
}
