package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.dataplatform.config.SettingPanel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\rR\u001a\u0010 \u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\rR\u001a\u0010&\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/LiveSettingKeys;", "", "()V", "EC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST", "", "", "getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST$annotations", "getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST", "()Ljava/util/List;", "EC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE", "", "getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE$annotations", "getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE", "()Z", "EC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE", "", "getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE$annotations", "getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE", "()I", "EC_LIVE_CARD_STYLE_CONFIG", "getEC_LIVE_CARD_STYLE_CONFIG$annotations", "getEC_LIVE_CARD_STYLE_CONFIG", "()Ljava/lang/String;", "EC_LIVE_CARD_USE_NEW_PRICE", "getEC_LIVE_CARD_USE_NEW_PRICE$annotations", "getEC_LIVE_CARD_USE_NEW_PRICE", "EC_LIVE_EVENT_BUS_REGISTER_OPT", "getEC_LIVE_EVENT_BUS_REGISTER_OPT$annotations", "getEC_LIVE_EVENT_BUS_REGISTER_OPT", "EC_LIVE_FIX_INSURANCE_ORDER_SCHEMA", "getEC_LIVE_FIX_INSURANCE_ORDER_SCHEMA$annotations", "getEC_LIVE_FIX_INSURANCE_ORDER_SCHEMA", "EC_LIVE_LAYOUT_CONFIG", "getEC_LIVE_LAYOUT_CONFIG$annotations", "getEC_LIVE_LAYOUT_CONFIG", "EC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE", "getEC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE$annotations", "getEC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE", "EC_LIVE_SKIN_CONFIG", "getEC_LIVE_SKIN_CONFIG$annotations", "getEC_LIVE_SKIN_CONFIG", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
@OptSetting(business = "livecommerce专用")
public final class LiveSettingKeys {
    public static final LiveSettingKeys INSTANCE = null;

    private LiveSettingKeys() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_CARD_STYLE_CONFIG$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_CARD_USE_NEW_PRICE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_EVENT_BUS_REGISTER_OPT$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_FIX_INSURANCE_ORDER_SCHEMA$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_LAYOUT_CONFIG$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEC_LIVE_SKIN_CONFIG$annotations() {
    }

    static {
        INSTANCE = new LiveSettingKeys();
    }

    @SettingPanel("电商场景Gecko激活-channels")
    public static final List<String> getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_CHANNELS_LIST() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = CollectionsKt.emptyList();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_annie_access_resource_channels_list", List.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (List) r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("电商场景Gecko激活-开关")
    public static final boolean getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_annie_access_resource_enable", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("电商场景Gecko激活-开关-实验组类型")
    public static final int getEC_ANNIE_PRELOAD_ACCESS_RESOURCE_ENABLE_TYPE() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r2 = 0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r1 = jj4.a.a("ec_annie_access_resource_enable_type", Integer.class, r2, false);     // Catch: Throwable -> L7
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r1).intValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r2 = r6;
    L12:
        r1 = r2;
        goto L14
    }

    @SettingPanel("直播电商新商品卡style配置")
    public static final String getEC_LIVE_CARD_STYLE_CONFIG() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = "";
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_live_card_style_config", String.class, "", false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("直播讲解卡营销算价链路控制")
    public static final int getEC_LIVE_CARD_USE_NEW_PRICE() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = 1;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_live_card_use_new_price", Integer.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Number) r4).intValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("电商eventbus注册优化")
    public static final boolean getEC_LIVE_EVENT_BUS_REGISTER_OPT() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ecom_live_event_bus_register_opt_enable", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("保险提单参数拼接逻辑修正")
    public static final boolean getEC_LIVE_FIX_INSURANCE_ORDER_SCHEMA() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_live_enable_fix_insurance_order", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("直播电商布局配置")
    public static final String getEC_LIVE_LAYOUT_CONFIG() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = "{\"promotion_card\":{\"side_bar_short_buy\":{\"button\":{\"height\":26,\"width\":52},\"cover\":{\"height\":96,\"left_margin\":6,\"top_margin\":8,\"width\":96},\"hot_atmosphere\":{\"left_margin\":-4},\"parent\":{\"bottom_padding\":6,\"left_margin\":6,\"right_margin\":6},\"price\":{\"right_padding\":12},\"stepper_icon\":{\"height\":22,\"width\":22},\"title\":{\"left_margin\":8,\"right_margin\":6}}}}";
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_live_layout_config_android", String.class, "{\"promotion_card\":{\"side_bar_short_buy\":{\"button\":{\"height\":26,\"width\":52},\"cover\":{\"height\":96,\"left_margin\":6,\"top_margin\":8,\"width\":96},\"hot_atmosphere\":{\"left_margin\":-4},\"parent\":{\"bottom_padding\":6,\"left_margin\":6,\"right_margin\":6},\"price\":{\"right_padding\":12},\"stepper_icon\":{\"height\":22,\"width\":22},\"title\":{\"left_margin\":8,\"right_margin\":6}}}}", false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("商详讲解回放点击商品卡关闭自身页面")
    public static final boolean getEC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = Boolean.FALSE;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_live_playback_detail_close_page", Boolean.class, r1, false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r4).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }

    @SettingPanel("直播电商换肤配置")
    public static final String getEC_LIVE_SKIN_CONFIG() {
        int r0 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r1 = "";
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r4 = jj4.a.a("ec_live_skin_config", String.class, "", false);     // Catch: Throwable -> L7
        if (r4 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return (String) r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == true) goto L12;
        r1 = r6;
    L12:
        r4 = r1;
        goto L14
    }
}
