package com.ss.android.lark.framework.assembly.rust;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.basic.v1.LeanModeCfg;
import com.bytedance.lark.pb.basic.v1.LockScreenCfg;
import com.bytedance.lark.pb.tool.v1.LeanModeConfig;
import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.bytedance.lark.pb.tool.v1.NamedUserExtraInfo;
import com.bytedance.lark.pb.tool.v1.UserDeviceInfo;
import com.bytedance.lark.pb.tool.v1.UserLoginState;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.account.LeanModeInfo;
import com.ss.android.lark.passport.signinsdk_api.env.EnvironmentType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jdb.e f425706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final apb.a f425707b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f425708a = null;

        static {
            int[] r100 = new int[EnvironmentType.values().length];
            r100[EnvironmentType.RELEASE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EnvironmentType.PRE_RELEASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EnvironmentType.STAGING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f425708a = r100;
        }
    }

    static {
    }

    @Inject
    public p(jdb.e r100, apb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "globalFgService");
        Intrinsics.checkNotNullParameter(r101, "globalLanguageService");
        this.f425706a = r100;
        this.f425707b = r101;
    }

    public final MakeUserOnlineV2Request.Builder a(String r110, String r210, String r211, int r212, LeanModeInfo r213, kzb.a r214, Pair<String, String> r215) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r210, "userId");
        Intrinsics.checkNotNullParameter(r214, "userEnvironment");
        if (r215 != null) goto L5;
        Log.e("RustSDK", "deviceId installId is null");
    L5:
        String r100 = this.f425707b.g();
        String r101 = com.suite.lark.platform.component.storage.file.dirs.k.f460651a.a(LarkContext.getApplication(), "ImSdkInit");
        if (r213 != null) goto L8;
        LeanModeConfig r102 = null;
    L12:
        NamedUserExtraInfo.Builder r111 = new NamedUserExtraInfo.Builder();
        Map<String, Boolean> r112 = this.f425706a.getUsedFGMap(r210, "_normal_fg");
        if (CollectionUtils.isEmpty(r112) == true) goto L15;
        Log.e("RustSDK", "usedFGMap: " + r112);
        r111.used_immutable_feature_gating(r112);
    L16:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L25;
        Set<String> r113 = this.f425706a.getRuntimeFGSPCache(r210, "_normal_fg");
        if (CollectionUtils.isNotEmpty(r113) == false) goto L25;
        HashMap r114 = new HashMap();
        Iterator<String> r115 = r113.iterator();
    L22:
        if (r115.hasNext() == false) goto L24;
        r114.put(r115.next(), "");
        goto L22
    L24:
        r111.client_fg_data(r114);
    L25:
        r111.tenant_tag(NamedUserExtraInfo.TenantTag.fromValue(r212));
        InitSDKRequest.EnvV2.Builder r116 = new InitSDKRequest.EnvV2.Builder();
        r116.geo = r214.f506826c;
        r116.unit = r214.f506825b;
        r116.brand = r214.f506824a;
        int r117 = b.f425708a[r214.getType().ordinal()];
        if (r117 != 1) goto L28;
        r116.type = InitSDKRequest.EnvV2.Type.RELEASE;
    L36:
        r116.type = InitSDKRequest.EnvV2.Type.fromValue(r214.getType().ordinal() + 1);
        UserDeviceInfo.Builder r103 = new UserDeviceInfo.Builder();
        if (r215 == null) goto L39;
        r103.device_id = r215.getFirst();
        Log.i("RustSDK", "deviceId is " + r215.getFirst());
        r103.install_id = r215.getSecond();
        Log.i("RustSDK", "installId is " + r215.getSecond());
    L39:
        r103.device_platform = "android";
        r103.app_name = UIHelper.getAppName();
        r103.settings_queries(f3c.a.a());
        MakeUserOnlineV2Request.Builder r104 = new MakeUserOnlineV2Request.Builder().user_id(Long.valueOf(CastLongProtector.parseLong(r210))).access_token(r110).locale_identifier(r100);
        LarkAppContext.Companion.getClass();
        MakeUserOnlineV2Request.Builder r105 = r104.enable_background_mode(Boolean.valueOf(LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK())).client_avatar_path(r101).user_extra_info(r111.build());
        if (r102 == null) goto L42;
        Log.i("RustSDK", "asyncMakeUserOnline isValid: leanModeConfig not null");
        r105.lean_mode_config(r102);
    L42:
        if (r211 != null) goto L44;
    L46:
        r105.prior_user_state = UserLoginState.OFFLINE;
        r105.env_v2 = r116.build();
        r105.user_device_info = r103.build();
        int r106 = c0.f425692a;
        Intrinsics.checkNotNullParameter(r210, "userId");
        opb.e r107 = opb.e.a.f524824a;
        r107.getClass();
        long r108 = System.currentTimeMillis();
        if (r107.f524823h == true) goto L49;
        boolean r109 = false;
    L56:
        if (r109 == false) goto L58;
        r107.c();
        List<String> r118 = CollectionsKt.toList(r107.f524817b);
    L59:
        if (r118 == null) goto L61;
        r105.settings_fields(r118);
    L61:
        AtomicLong r119 = com.bytedance.lark.sdk.refactor.p.f254275a;
        Intrinsics.checkNotNullParameter(r210, "userId");
        long r120 = com.bytedance.lark.sdk.refactor.p.f254275a.incrementAndGet();
        com.bytedance.lark.sdk.refactor.p.f254276b.put(r210, Long.valueOf(r120));
        r105.client_session_id = Long.valueOf(r120);
        return r105;
    L58:
        r118 = null;
        goto L59
    L49:
        com.ss.android.lark.storage.kv.repo.a r121 = spb.a.a();
        long r122 = r121.getLong("settings_last_version_code", 0);
        long r123 = ApkUtil.getAppVersionCode(LarkContext.getApplication());
        String r124 = "sync_update_settings_" + r210 + "_" + r123;
        if (r123 == r122) goto L52;
        r121.remove("sync_update_settings_" + r210 + "_" + r122);
        r121.putLong("settings_last_version_code", r123);
    L52:
        boolean r125 = r121.getBoolean(r124, true);
        r107.f524823h = r125;
        if (r125 == false) goto L55;
        r121.putBoolean(r124, false);
    L55:
        Log.i("AppSettingService", "isUserFirstLogin: " + r107.f524823h + ", cost: " + (System.currentTimeMillis() - r108) + " ms");
        r109 = r107.f524823h;
        goto L56
    L44:
        if (Intrinsics.areEqual(r211, "") == true) goto L46;
        r105.tenant_id(Long.valueOf(CastLongProtector.parseLong(r211)));
        goto L46
    L28:
        if (r117 != 2) goto L30;
        r116.type = InitSDKRequest.EnvV2.Type.PRE_RELEASE;
        goto L36
    L30:
        if (r117 != 3) goto L33;
        r116.type = InitSDKRequest.EnvV2.Type.STAGING;
        goto L36
    L33:
        throw new NoWhenBranchMatchedException();
    L15:
        Log.e("RustSDK", "usedFGMap: empty");
        goto L16
    L8:
        if (TextUtils.isEmpty(r213.lockScreenPwd) == false) goto L10;
        r213.lockScreenPwd = "";
    L10:
        r102 = new LeanModeConfig.Builder().lean_mode_cfg(new LeanModeCfg.Builder().device_have_authority(Boolean.valueOf(r213.deviceHaveAuthority)).can_use_lean_mode(Boolean.valueOf(r213.canUseLeanMode)).lean_mode_cfg_updated_at_micro_sec(Long.valueOf(r213.leanModeCfgUpdateTime)).all_devices_in_lean_mode(Boolean.valueOf(r213.allDevicesInLeanMode)).build()).lock_screen_cfg(new LockScreenCfg.Builder().is_lock_screen_enabled(Boolean.valueOf(r213.isLockScreenEnabled)).lock_screen_password(r213.lockScreenPwd).lock_screen_cfg_updated_at_micro_sec(Long.valueOf(r213.lockScreenCfgUpdateTime)).build()).build();
        goto L12
    }
}
