package com.ss.android.lark.picker.base.widget.utils;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0007J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/utils/FG;", "", "<init>", "()V", "CHAT_PREVIEW", "", "MY_AI", "FG_SPOTLIGHT", "FG_CHAT_PICKER_BLOCK", "FG_SPOTLIGHT_LOADING", "FG_DISABLE_SPOTLIGHT_EMPTY_SEARCH_MERGE", "FEATURE_KEY_ENABLE_SDK_PARAM_OPT", "enable", "", AppConstants.APP_FG, "default", "isCurrentEnable", "key", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FG {
    public static final String CHAT_PREVIEW = "core.forward.target_preview";
    public static final String FEATURE_KEY_ENABLE_SDK_PARAM_OPT = "lark.search.enable.sdk_param_opt_v2";
    public static final String FG_CHAT_PICKER_BLOCK = "core.picker.recovery.chatpicker_user_block";
    public static final String FG_DISABLE_SPOTLIGHT_EMPTY_SEARCH_MERGE = "core.picker.spotlight_empty_search_merge";
    public static final String FG_SPOTLIGHT = "core.picker.spotlight";
    public static final String FG_SPOTLIGHT_LOADING = "core.picker.spotlight_loading";
    public static final FG INSTANCE = null;
    public static final String MY_AI = "lark.my_ai.main_switch";

    static {
        INSTANCE = new FG();
    }

    private FG() {
    }

    @JvmStatic
    public static final boolean enable(String r100) {
        Intrinsics.checkNotNullParameter(r100, AppConstants.APP_FG);
        return enable$default(r100, false, 2, null);
    }

    public final boolean isCurrentEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r100);
    }

    @JvmStatic
    public static final boolean enable(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, AppConstants.APP_FG);
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100, r101);
    }

    public static /* synthetic */ boolean enable$default(String r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = false;
    L6:
        return enable(r100, r101);
    }
}
