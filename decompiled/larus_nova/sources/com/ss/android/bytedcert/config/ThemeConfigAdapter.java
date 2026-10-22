package com.ss.android.bytedcert.config;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class ThemeConfigAdapter implements ThemeConfig {
    private final Map<String, Integer> dict;
    protected int mBeautyIntensity;

    public ThemeConfigAdapter() {
        this(null);
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public Drawable faceLiveBackImage() {
        return null;
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public int faceLiveNavBarColor() {
        if (this.dict.get(ThemeConfig.NAV_BAR_COLOR) != null) goto L5;
        return -1;
    L5:
        return this.dict.get(ThemeConfig.NAV_BAR_COLOR).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public int faceLiveProgressBgColor() {
        if (this.dict.get(ThemeConfig.PROGRESS_BG_COLOR) != null) goto L5;
        return FakePickerAvatarCreator.LTGRAY;
    L5:
        return this.dict.get(ThemeConfig.PROGRESS_BG_COLOR).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public int faceLiveProgressColor() {
        if (this.dict.get(ThemeConfig.PROGRESS_COLOR) != null) goto L5;
        return -13987625;
    L5:
        return this.dict.get(ThemeConfig.PROGRESS_COLOR).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public float faceLiveProgressGap() {
        if (this.dict.get(ThemeConfig.PROGRESS_GAP) != null) goto L5;
        return -1.0f;
    L5:
        return this.dict.get(ThemeConfig.PROGRESS_GAP).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public float faceLiveProgressWidth() {
        if (this.dict.get(ThemeConfig.PROGRESS_WIDTH) != null) goto L5;
        return -1.0f;
    L5:
        return this.dict.get(ThemeConfig.PROGRESS_WIDTH).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public int faceLiveScreenBgColor() {
        if (this.dict.get(ThemeConfig.SCREEN_COLOR) != null) goto L5;
        return -1;
    L5:
        return this.dict.get(ThemeConfig.SCREEN_COLOR).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public int faceLiveTextColor() {
        if (this.dict.get(ThemeConfig.TEXT_COLOR) != null) goto L5;
        return -16777216;
    L5:
        return this.dict.get(ThemeConfig.TEXT_COLOR).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public float faceLiveTextSize() {
        if (this.dict.get(ThemeConfig.TEXT_SIZE) != null) goto L5;
        return -1.0f;
    L5:
        return this.dict.get(ThemeConfig.TEXT_SIZE).intValue();
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public boolean isFaceLiveBack() {
        if (this.dict.get(ThemeConfig.RETURN_STYPE) != null) goto L5;
        return true;
    L5:
        if (this.dict.get(ThemeConfig.RETURN_STYPE).intValue() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public boolean isInitNeedLoading() {
        if (this.dict.get(ThemeConfig.SDK_INIT_LOADING) != null) goto L5;
        return true;
    L5:
        if (this.dict.get(ThemeConfig.SDK_INIT_LOADING).intValue() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public boolean isWebDarkMode() {
        if (this.dict.get(ThemeConfig.WEB_THEME_MODE) != null) goto L5;
        return false;
    L5:
        if (this.dict.get(ThemeConfig.WEB_THEME_MODE).intValue() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public int getBeautyIntensity() {
        return this.mBeautyIntensity;
    }

    public ThemeConfigAdapter(Map<String, Integer> r100) {
        this.mBeautyIntensity = 0;
        if (r100 != null) goto L5;
        this.dict = new HashMap();
        return;
    L5:
        this.dict = r100;
    }

    @Override // com.ss.android.bytedcert.config.ThemeConfig
    public void setBeautyIntensity(int r100) {
        this.mBeautyIntensity = r100;
    }
}
