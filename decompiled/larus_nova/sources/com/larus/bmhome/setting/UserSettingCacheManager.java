package com.larus.bmhome.setting;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes4.dex */
public final class UserSettingCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UserSettingCacheManager f313814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile UserConfigItem f313815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Keva f313816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Keva f313817d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutableSharedFlow<UserConfigKey> f313818e = null;

    public UserSettingCacheManager() {
    }

    static {
        f313814a = new UserSettingCacheManager();
        f313815b = new UserConfigItem(Integer.valueOf(UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue()), "0", 0L);
        StringBuilder r100 = new StringBuilder();
        r100.append(AccountService.f365697a.getSecUserId());
        r100.append('_');
        o2 r101 = o2.f365782a;
        r100.append(r101.e());
        f313816c = Keva.getRepo(r100.toString(), 0);
        f313817d = Keva.getRepo(r101.e(), 0);
        f313818e = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static boolean a() {
        FeatureKitDelegate r100 = FeatureKitDelegate.f295792b;
        if (r100.i0().b() == false) goto L5;
        UserConfigItem r101 = j(UserConfigKey.ANSWER_WITH_SUGGEST);
        if (r101 == null) goto L9;
        FLogger.f375446a.d("UserSettingCacheManager", "getAnswerWithSuggest(" + r101.c() + ") in user setting");
        boolean r102 = Intrinsics.areEqual(r101.c(), "1");
    L10:
        FLogger.f375446a.w("UserSettingCacheManager", "getAnswerWithSuggest, result(" + r102 + ')');
        return r102;
    L9:
        r102 = r100.i0().a();
        goto L10
    L5:
        return r100.i0().a();
    }

    public static int b() {
        FLogger r100 = FLogger.f375446a;
        r100.d("UserSettingCacheManager", "getAnswerWithVideo");
        boolean r101 = AppHost.f326268a.isOversea();
        FeatureDetail r102 = FeatureKitDelegate.f295792b.S();
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
    L11:
        int r103 = 0;
    L13:
        if (r102.b() == true) goto L15;
        return r103;
    L15:
        UserConfigItem r104 = j(UserConfigKey.ANSWER_WITH_VIDEO);
        Object r105 = null;
        if (r104 == null) goto L18;
        String r106 = r104.c();
    L19:
        if (r106 == null) goto L36;
        r100.d("UserSettingCacheManager", "answer_with_video(" + r104.c() + ") in user setting");
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L27
        String r108 = r104.c();     // Catch: Throwable -> L27
        if (r108 == null) goto L24;
        Integer r109 = Integer.valueOf(CastIntegerProtector.parseInt(r108));     // Catch: Throwable -> L27
    L25:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r110) == true) goto L33;
        r105 = r110;
    L33:
        Integer r111 = (Integer) r105;
        if (r111 == null) goto L36;
        int r112 = r111.intValue();
    L37:
        FLogger.f375446a.d("UserSettingCacheManager", "getAnswerWithVideo, use default value(" + r103 + ')');
        return r112;
    L24:
        r109 = null;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L36:
        r112 = r103;
        goto L37
    L18:
        r106 = null;
        goto L19
    L9:
        if (r102.a() == false) goto L11;
        r103 = 1;
        goto L13
    L5:
        if (r102.a() == false) goto L7;
        r103 = 2;
        goto L13
    }

    public static DefaultActiveModeSettingValue d() {
        UserConfigItem r100 = j(UserConfigKey.DEFAULT_ACTIVE_MODE_APP);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("getDefaultActiveModeSettingValue hasValue=");
        if (r100 == null) goto L5;
        String r103 = r100.c();
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        r102.append(!r104);
        r101.d("UserSettingCacheManager", r102.toString());
        if (r100 == null) goto L29;
        String r105 = r100.c();     // Catch: Exception -> L24
        if (r105 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r105)) == true) goto L21;
        r105 = null;
    L21:
        if (r105 == null) goto L31;
        return (DefaultActiveModeSettingValue) new Gson().fromJson(r105, DefaultActiveModeSettingValue.class);
    L31:
        return null;
    L24:
        e = move-exception;
        FLogger.f375446a.e("UserSettingCacheManager", "getDefaultActiveModeSettingValue, error(" + e + ')', e);
        return null;
    L29:
        return null;
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public static DefaultReplyMenuDataV2 e() {
        UserConfigItem r100 = j(UserConfigKey.DEFAULT_ACTIVE_MODEL_MENU);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("getDefaultActiveModelMenu hasValue=");
        if (r100 == null) goto L5;
        String r103 = r100.c();
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        r102.append(!r104);
        r101.d("UserSettingCacheManager", r102.toString());
        if (r100 == null) goto L29;
        String r105 = r100.c();     // Catch: Exception -> L24
        if (r105 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r105)) == true) goto L21;
        r105 = null;
    L21:
        if (r105 == null) goto L31;
        return (DefaultReplyMenuDataV2) new Gson().fromJson(r105, DefaultReplyMenuDataV2.class);
    L31:
        return null;
    L24:
        e = move-exception;
        FLogger.f375446a.e("UserSettingCacheManager", "getDefaultActiveModelMenu, error(" + e + ')', e);
        return null;
    L29:
        return null;
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public static String f() {
        FLogger r100 = FLogger.f375446a;
        r100.d("UserSettingCacheManager", "getHighlightKeyword");
        if (AppHost.f326268a.isOversea() == false) goto L5;
        String r101 = "1";
    L6:
        FeatureKitDelegate r102 = FeatureKitDelegate.f295792b;
        if (r102.s0().a() == true) goto L11;
        r101 = "0";
    L11:
        if (r102.s0().b() == true) goto L13;
        return r101;
    L13:
        UserConfigItem r103 = j(UserConfigKey.HIGHLIGHT_KEYWORD);
        if (r103 == null) goto L19;
        r100.d("UserSettingCacheManager", "getHighlightKeyword(" + r103.c() + ") in user setting");
        String r104 = r103.c();
        if (r104 == null) goto L19;
        r101 = r104;
    L19:
        r100.w("UserSettingCacheManager", "getHighlightKeyword, value(" + r101 + ')');
        return r101;
    L5:
        r101 = "2";
        goto L6
    }

    public static ArrayList g() {
        ArrayList r100 = new ArrayList();
        UserConfigKey[] r101 = UserConfigKey.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        UserConfigKey r104 = r101[r103];
        if (r104 == UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH) goto L10;
        UserConfigItem r105 = j(r104);
        if (r105 == null) goto L10;
        r100.add(r105);
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return r100;
    }

    public static boolean h() {
        UserConfigItem r100 = j(UserConfigKey.PERSONAL_RECOMMEND);
        if (r100 == null) goto L5;
        FLogger.f375446a.d("UserSettingCacheManager", "getPersonalizedRecommend(" + r100.c() + ") in user setting");
        boolean r101 = Intrinsics.areEqual(r100.c(), "1");
    L6:
        FLogger.f375446a.w("UserSettingCacheManager", "getPersonalizedRecommend, result(" + r101 + ')');
        return r101;
    L5:
        r101 = true;
        goto L6
    }

    public static boolean i() {
        FeatureKitDelegate r100 = FeatureKitDelegate.f295792b;
        if (r100.n0().b() == false) goto L5;
        UserConfigItem r101 = j(UserConfigKey.RELATED_VIDEO);
        if (r101 == null) goto L9;
        FLogger.f375446a.d("UserSettingCacheManager", "getRelatedVideoEnabled(" + r101.c() + ") in user setting");
        boolean r102 = Intrinsics.areEqual(r101.c(), "1");
    L10:
        FLogger.f375446a.w("UserSettingCacheManager", "getRelatedVideoEnabled, result(" + r102 + ')');
        return r102;
    L9:
        r102 = true;
        goto L10
    L5:
        return r100.n0().a();
    }

    public static String c(UserConfigKey r100) {
        return "user_setting_" + r100.name().toLowerCase();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static UserConfigItem j(UserConfigKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r100 == UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH) goto L29;
        Keva r101 = f313816c;
        Object r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.getString(c(r100), "");
    L9:
        if (r103 == null) goto L13;
        boolean r104 = true;
        if (o0.d(r103) != true) goto L13;
    L14:
        if (r104 == false) goto L26;
        Gson r105 = new Gson();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        Object r107 = Result.m9449constructorimpl((UserConfigItem) r105.fromJson(r103, UserConfigItem.class));     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r107) == true) goto L24;
        r102 = r107;
    L24:
        r102 = (UserConfigItem) r102;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L26:
        return r102;
    L13:
        r104 = false;
        goto L14
    L8:
        r103 = null;
        goto L9
    L29:
        return UserConfigItem.a(f313815b);
    }

    public final Object k(boolean r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof UserSettingCacheManager$saveExpertSwitchState$1) == false) goto L7;
        UserSettingCacheManager$saveExpertSwitchState$1 r102 = (UserSettingCacheManager$saveExpertSwitchState$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L21:
        boolean r107 = ((Boolean) r104).booleanValue();
        FLogger.f375446a.w("UserSettingCacheManager", "saveExpertSwitchState, request server result(" + r107 + ')');
        return r104;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.w("UserSettingCacheManager", "saveExpertSwitchState, switch:(" + r100 + ')');
        UserConfigKey r108 = UserConfigKey.EXPERT_SWITCH;
        if (r100 == false) goto L17;
        String r109 = "1";
    L18:
        r102.label = 1;
        r104 = p(r108, r109, r102);
        if (r104 != r105) goto L21;
        return r105;
    L17:
        r109 = "0";
    L7:
        r102 = new UserSettingCacheManager$saveExpertSwitchState$1(this, r101);
        goto L8
    }

    public final Object l(boolean r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof UserSettingCacheManager$saveGpt4SwitchState$1) == false) goto L7;
        UserSettingCacheManager$saveGpt4SwitchState$1 r102 = (UserSettingCacheManager$saveGpt4SwitchState$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L21:
        boolean r107 = ((Boolean) r104).booleanValue();
        FLogger.f375446a.w("UserSettingCacheManager", "saveSaveOgfSwitchState, request server result(" + r107 + ')');
        return r104;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.w("UserSettingCacheManager", "saveSaveOgfSwitchState, switch:(" + r100 + ')');
        UserConfigKey r108 = UserConfigKey.USE_OFG_SWITCH;
        if (r100 == false) goto L17;
        String r109 = "1";
    L18:
        r102.label = 1;
        r104 = p(r108, r109, r102);
        if (r104 != r105) goto L21;
        return r105;
    L17:
        r109 = "0";
    L7:
        r102 = new UserSettingCacheManager$saveGpt4SwitchState$1(this, r101);
        goto L8
    }

    public static Object m(String r100, boolean r101, Continuation r102) {
        FLogger.f375446a.w("UserSettingCacheManager", "saveHighlightKeyword, value(" + r100 + ')');
        return p(UserConfigKey.HIGHLIGHT_KEYWORD, r100, r102);
    }

    public static Object n(UserSettingCacheManager r100, boolean r101, Continuation r102) {
        r100.getClass();
        FLogger.f375446a.w("UserSettingCacheManager", "savePersonalizedRecommend, value(" + r101 + ')');
        UserConfigKey r103 = UserConfigKey.PERSONAL_RECOMMEND;
        if (r101 == false) goto L5;
        String r104 = "1";
    L7:
        return p(r103, r104, r102);
    L5:
        r104 = "0";
        goto L7
    }

    public static Object p(UserConfigKey r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserSettingCacheManager$syncServerAndSaveUserSetting$2(r100, r101, null), r102);
    }

    public static void o(UserSettingCacheManager r110, List r111, boolean r112, String r113, int r114) {
        if ((r114 & 2) == 0) goto L6;
        r112 = false;
    L6:
        if ((r114 & 4) == 0) goto L8;
        r113 = null;
    L8:
        r110.getClass();
        if (r111 != null) goto L11;
        List r115 = CollectionsKt.emptyList();
    L12:
        List r116 = r115;
        if ((r116 instanceof Collection) == true) goto L15;
    L17:
        Iterator r117 = r116.iterator();
    L19:
        if (r117.hasNext() == false) goto L29;
        Integer r118 = ((UserConfigItem) r117.next()).b();
        int r100 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH.getValue();
        if (r118 != null) goto L24;
    L26:
        boolean r119 = false;
    L27:
        if (r119 == false) goto L19;
        boolean r120 = true;
    L30:
        if (r112 == false) goto L54;
        if (r111 == null) goto L54;
        List r121 = r111;
        if ((r121 instanceof Collection) == true) goto L35;
    L37:
        Iterator r122 = r121.iterator();
    L39:
        if (r122.hasNext() == false) goto L49;
        Integer r123 = ((UserConfigItem) r122.next()).b();
        int r101 = UserConfigKey.STARTUP_OPEN_NEW_CHAT.getValue();
        if (r123 != null) goto L44;
    L46:
        boolean r124 = false;
    L47:
        if (r124 == false) goto L39;
        boolean r125 = false;
    L50:
        if (r125 == false) goto L54;
        Keva r126 = f313816c;
        if (r126 == null) goto L54;
        r126.erase(c(UserConfigKey.STARTUP_OPEN_NEW_CHAT));
        goto L54
    L44:
        if (r123.intValue() != r101) goto L46;
        r124 = true;
    L49:
        r125 = true;
        goto L50
    L35:
        if (r121.isEmpty() == false) goto L37;
    L54:
        List r127 = r111;
        if (r127 != null) goto L57;
    L60:
        boolean r128 = true;
    L61:
        if (r128 == true) goto L117;
        Iterator r129 = r111.iterator();
    L65:
        if (r129.hasNext() == false) goto L143;
        UserConfigItem r130 = (UserConfigItem) r129.next();
        Integer r131 = r130.b();
        if (r131 == null) goto L65;
        int r132 = r131.intValue();
        UserConfigKey.Companion.getClass();
        UserConfigKey r133 = UserConfigKey.a.a(r132);
        if (r133 == null) goto L65;
        UserConfigKey r102 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH;
        if (r133 != r102) goto L73;
    L77:
        boolean r103 = true;
    L78:
        if (r113 != null) goto L80;
    L83:
        boolean r104 = true;
    L84:
        if (r104 == false) goto L86;
    L88:
        boolean r105 = false;
    L90:
        if (r103 == false) goto L100;
        if (r105 == true) goto L100;
        if (r113 != null) goto L94;
    L97:
        boolean r134 = true;
    L98:
        if (r134 == true) goto L65;
        FLogger.f375446a.w("UserSettingCacheManager", "saveUserSettings, ignore stale account config, key=" + r133.getValue());
        goto L65
    L94:
        if (r113.length() == 0) goto L97;
        r134 = false;
    L100:
        f313814a.getClass();
        if (r133 != r102) goto L103;
        f313815b = UserConfigItem.a(r130);
    L116:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UserSettingCacheManager$saveUserSettings$2$1$1$1(r133, null), 3, null);
        goto L65
    L103:
        Gson r106 = new Gson();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L106
        Object r108 = Result.m9449constructorimpl(r106.toJson(r130));     // Catch: Throwable -> L106
    L109:
        if (Result.m9455isFailureimpl(r108) == false) goto L111;
        r108 = null;
    L111:
        String r109 = (String) r108;
        if (r109 == null) goto L116;
        FLogger.f375446a.d("UserSettingCacheManager", "saveUserSetting(" + r130 + ')');
        Keva r135 = f313816c;
        if (r135 == null) goto L116;
        f313814a.getClass();
        r135.storeString(c(r133), r109);
    L106:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L109
    L86:
        if (Intrinsics.areEqual(r113, AccountService.f365697a.getSecUserId()) == false) goto L88;
        r105 = true;
        goto L90
    L80:
        if (r113.length() == 0) goto L83;
        r104 = false;
        goto L84
    L73:
        if (r133 != UserConfigKey.IN_APP_BANNER_SHOW_DETAIL) goto L76;
        if (r120 == true) goto L77;
    L76:
        r103 = false;
        goto L78
    L143:
        return;
    L117:
        return;
    L57:
        if (r127.isEmpty() == true) goto L60;
        r128 = false;
        goto L61
    L24:
        if (r118.intValue() != r100) goto L26;
        r119 = true;
    L29:
        r120 = false;
        goto L30
    L15:
        if (r116.isEmpty() == false) goto L17;
    L11:
        r115 = r111;
        goto L12
    }
}
