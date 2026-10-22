package com.ss.android.dypay.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0016\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0016\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0016\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\bR\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\bR\u0016\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\bR\u0016\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\bR\u0016\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u000bR\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\bR\u0016\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\bR\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\bR\u0016\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\bR\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\bR\u0016\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\bR\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\bR\u0016\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\bR\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\bR\u0016\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\bR\u0016\u0010+\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u000b¨\u0006."}, d2 = {"Lcom/ss/android/dypay/api/DyPayConstant;", "", "", "errorMsg", "", "getErrorResult", "(Ljava/lang/String;)Ljava/util/Map;", "KEY_RESULT_MSG", "Ljava/lang/String;", "", "RESULT_CODE_CANCEL", "I", "KEY_EXTRA_PARAMS", "V_PAY_SOURCE_OUTER_BDPAY", "RESULT_CODE_FAILED", "DY_PAY_SDK_ACTIVITY_REMOVE_OUT_ANIMATION_KEY", "KEY_START_TIME", "K_PAY_INFO_PARAM_APPID", "K_PAY_INFO_PARAM_EVOKE_URL", "CJ_PAY_SDK_VERSION_ERROR", "KEY_PAY_SOURCE", "K_PAY_INFO_PARAM_PARTNERID", "K_PAY_INFO_PARAM_SIGN", "K_PAY_INFO_PARAM_PREPAYID", "RESULT_CODE_LOGIN_OPT", "RESULT_CODE_PROCESSING", "RESULT_CODE_LOGIN_OPT_HOTSOON", "K_PAY_INFO_PAYSCORE_APPLY_TOKEN", "DY_PAY_SDK_ACTIVITY_FADE_IN_ANIMATION_KEY", "KEY_SHOW_LOADING", "KEY_RESULT_CODE", "KEY_PAY_INFO", "RESULT_CODE_DUPLICATED_BLOCK", "K_PAY_INFO_PARAM_TIMESTAMP", "DY_PAY_SDK_ACTIVITY_FADE_OUT_ANIMATION_KEY", "KEY_VERSION", "K_PAY_INFO_PARAM_NONCESTR", "DY_PAY_SDK_ACTIVITY_ADD_IN_ANIMATION_KEY", "K_PAY_INFO_PARAM_PRE_ENTRUSTWEB_ID", "K_PAY_INFO_PARAM_PACKAGE", "KEY_OUTER_DID", "KEY_TOKEN", "KEY_USER_UNIQUE_ID", "RESULT_CODE_SUCCESS", "<init>", "()V", "dy-pay-sdk_withoutLogRelease"}, k = 1, mv = {1, 1, 15})
public final class DyPayConstant {
    public static final int CJ_PAY_SDK_VERSION_ERROR = 100;
    public static final String DY_PAY_SDK_ACTIVITY_ADD_IN_ANIMATION_KEY = "dy_pay_sdk_activity_add_in_animation_key";
    public static final String DY_PAY_SDK_ACTIVITY_FADE_IN_ANIMATION_KEY = "dy_pay_sdk_activity_fade_in_animation_key";
    public static final String DY_PAY_SDK_ACTIVITY_FADE_OUT_ANIMATION_KEY = "dy_pay_sdk_activity_fade_out_animation_key";
    public static final String DY_PAY_SDK_ACTIVITY_REMOVE_OUT_ANIMATION_KEY = "dy_pay_sdk_activity_remove_out_animation_key";
    public static final DyPayConstant INSTANCE = null;
    public static final String KEY_EXTRA_PARAMS = "extraParams";
    public static final String KEY_OUTER_DID = "outer_did";
    public static final String KEY_PAY_INFO = "payInfo";
    public static final String KEY_PAY_SOURCE = "pay_source";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final String KEY_RESULT_MSG = "errorMsg";
    public static final String KEY_SHOW_LOADING = "showLoading";
    public static final String KEY_START_TIME = "startTime";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_USER_UNIQUE_ID = "user_unique_id";
    public static final String KEY_VERSION = "version";
    public static final String K_PAY_INFO_PARAM_APPID = "appid";
    public static final String K_PAY_INFO_PARAM_EVOKE_URL = "evoke_url";
    public static final String K_PAY_INFO_PARAM_NONCESTR = "noncestr";
    public static final String K_PAY_INFO_PARAM_PACKAGE = "package";
    public static final String K_PAY_INFO_PARAM_PARTNERID = "partnerid";
    public static final String K_PAY_INFO_PARAM_PREPAYID = "prepayid";
    public static final String K_PAY_INFO_PARAM_PRE_ENTRUSTWEB_ID = "pre_entrustweb_id";
    public static final String K_PAY_INFO_PARAM_SIGN = "sign";
    public static final String K_PAY_INFO_PARAM_TIMESTAMP = "timestamp";
    public static final String K_PAY_INFO_PAYSCORE_APPLY_TOKEN = "payscore_apply_token";
    public static final int RESULT_CODE_CANCEL = 1;
    public static final int RESULT_CODE_DUPLICATED_BLOCK = 103;
    public static final int RESULT_CODE_FAILED = 2;
    public static final int RESULT_CODE_LOGIN_OPT = 201;
    public static final int RESULT_CODE_LOGIN_OPT_HOTSOON = 202;
    public static final int RESULT_CODE_PROCESSING = 3;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String V_PAY_SOURCE_OUTER_BDPAY = "outer_bdpay";

    static {
        INSTANCE = new DyPayConstant();
    }

    private DyPayConstant() {
    }

    public static /* synthetic */ Map getErrorResult$default(DyPayConstant r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = "";
    L6:
        return r100.getErrorResult(r101);
    }

    public final Map<String, String> getErrorResult(String r100) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("resultCode", String.valueOf(2)), TuplesKt.to("errorMsg", r100)});
    }
}
