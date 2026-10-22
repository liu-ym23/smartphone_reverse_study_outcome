package com.larus.dora.impl.noti_v3;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.dora.device.DoraDevice;
import com.google.gson.Gson;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.f0;
import com.larus.dora.impl.network.g0;
import com.larus.dora.impl.network.s;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.notification_rule.data.DoraNotificationRuleRepo;
import com.larus.dora.impl.util.b0;
import com.larus.platform.model.NotificationBusiness;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.common.Constants;
import g49.d;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class NotificationBroadcastV3Tracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationBroadcastV3Tracker f336406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f336407b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f336408c = null;

    public NotificationBroadcastV3Tracker() {
    }

    static {
        f336406a = new NotificationBroadcastV3Tracker();
        f336407b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        Boolean r100 = Boolean.TRUE;
        Boolean r101 = Boolean.FALSE;
        f336408c = MapsKt.mapOf(new Pair[]{TuplesKt.to("finance_security", r100), TuplesKt.to(MonitorConstants.SCHEDULE, r100), TuplesKt.to("life_service", r100), TuplesKt.to("news_info", r101), TuplesKt.to("entertainment_recommendation", r101)});
    }

    public static void g() {
        BuildersKt.launch$default(f336407b, null, null, new NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1(null), 3, null);
    }

    public static String e(String r100) {
        if (r100 != null) goto L5;
        r100 = "1";
    L5:
        if (Intrinsics.areEqual(r100, "0") == false) goto L8;
        return "all";
    L8:
        if (Intrinsics.areEqual(r100, "2") == false) goto L10;
        return "off";
    L10:
        return "important_only";
    }

    public static String f(Boolean r100) {
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L5;
        return "on";
    L5:
        return "off";
    }

    public final Object c(Continuation<? super f0> r100) {
        if ((r100 instanceof NotificationBroadcastV3Tracker$loadFreshUserSettings$1) == false) goto L7;
        NotificationBroadcastV3Tracker$loadFreshUserSettings$1 r101 = (NotificationBroadcastV3Tracker$loadFreshUserSettings$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L22;
        d.c("NotificationBroadcastV3Tracker", "loadFreshUserSettings failed, fallback to cache", r107);
        DoraUserSettingsManager r108 = DoraUserSettingsManager.f336185a;
        return DoraUserSettingsManager.f336187c;
    L22:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        DoraNetworkApi r109 = DoraNetworkApi.f336157a;
        r101.label = 1;
        r106 = r109.v(true, r101);
        if (r106 != r104) goto L17;
        return r104;
    L7:
        r101 = new NotificationBroadcastV3Tracker$loadFreshUserSettings$1(this, r100);
        goto L8
    }

    public final Object d(Continuation<? super Integer> r100) {
        if ((r100 instanceof NotificationBroadcastV3Tracker$loadSelectedRuleCount$1) == false) goto L7;
        NotificationBroadcastV3Tracker$loadSelectedRuleCount$1 r101 = (NotificationBroadcastV3Tracker$loadSelectedRuleCount$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        d.c("NotificationBroadcastV3Tracker", "loadSelectedRuleCount failed", r107);
        r106 = CollectionsKt.emptyList();
    L21:
        List r108 = (List) r106;
        int r109 = 0;
        if ((r108 instanceof Collection) == true) goto L24;
    L26:
        Iterator r110 = r108.iterator();
    L28:
        if (r110.hasNext() == false) goto L35;
        if (Intrinsics.areEqual(((NotificationRule) r110.next()).getStatus(), Boxing.boxBoolean(true)) == false) goto L28;
        r109 = r109 + 1;
        if (r109 >= 0) goto L28;
        CollectionsKt.throwCountOverflow();
    L35:
        return Boxing.boxInt(r109);
    L24:
        if (r108.isEmpty() == false) goto L26;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        DoraNotificationRuleRepo r111 = DoraNotificationRuleRepo.f336288a;
        r101.label = 1;
        r106 = r111.e(r101);
        if (r106 != r104) goto L17;
        return r104;
    L7:
        r101 = new NotificationBroadcastV3Tracker$loadSelectedRuleCount$1(this, r100);
        goto L8
    }

    public final Object b(DoraDevice r100, Continuation<? super Map<String, ? extends Object>> r101) {
        if ((r101 instanceof NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1) == false) goto L7;
        NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1 r102 = (NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1) r101;
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
        Object r107 = ((Result) r104).m9458unboximpl();
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L22;
        d.c("NotificationBroadcastV3Tracker", "loadFreshDeviceInfo failed, fallback to memory state", r108);
        return null;
    L22:
        return ((com.larus.dora.impl.network.d) r107).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        List<String> r109 = q59.c.f531753a;
        List<String> r110 = CollectionsKt.plus(q59.c.f531753a, "wearing_reminder_switch");
        DoraNetworkApi r111 = DoraNetworkApi.f336157a;
        r102.label = 1;
        r107 = r111.l(r100, r110, r102);
        if (r107 != r105) goto L17;
        return r105;
    L7:
        r102 = new NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1(this, r101);
        goto L8
    }

    public static final Object a(NotificationBroadcastV3Tracker r110, DoraDevice r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof NotificationBroadcastV3Tracker$buildSettingsParams$1) == false) goto L7;
        NotificationBroadcastV3Tracker$buildSettingsParams$1 r100 = (NotificationBroadcastV3Tracker$buildSettingsParams$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        List r105 = (List) r100.L$4;
        Map<String, Boolean> r106 = (Map) r100.L$3;
        q59.a r107 = (q59.a) r100.L$2;
        Map r113 = (Map) r100.L$1;
        f0 r108 = (f0) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L66:
        int r114 = ((Number) r102).intValue();
        Pair[] r115 = new Pair[15];
        g0 r109 = r108.d();
        if (r109 == null) goto L69;
        String r116 = r109.g();
    L70:
        String r117 = "on";
        if (Intrinsics.areEqual(r116, "1") == false) goto L73;
        Object r118 = "on";
    L74:
        r115[0] = TuplesKt.to("broadcast_switch", r118);
        r115[1] = TuplesKt.to("private_chat_mode", e(r107.f531748c));
        r115[2] = TuplesKt.to("group_chat_mode", e(r107.f531749d));
        String r119 = r107.f531751f;
        if (r119 != null) goto L77;
    L80:
        boolean r120 = true;
    L81:
        if (r120 == false) goto L185;
        int r121 = 0;
    L109:
        r115[3] = TuplesKt.to("special_contact_cnt", Boxing.boxInt(r121));
        r115[4] = TuplesKt.to("finance_security_on", f(r106.get("finance_security")));
        r115[5] = TuplesKt.to("schedule_on", f(r106.get(MonitorConstants.SCHEDULE)));
        r115[6] = TuplesKt.to("life_service_on", f(r106.get("life_service")));
        r115[7] = TuplesKt.to("news_info_on", f(r106.get("news_info")));
        r115[8] = TuplesKt.to("entertainment_on", f(r106.get("entertainment_recommendation")));
        List r122 = r105;
        if ((r122 instanceof Collection) == true) goto L112;
    L114:
        Iterator r123 = r122.iterator();
        int r124 = 0;
    L116:
        if (r123.hasNext() == false) goto L125;
        if (((s) r123.next()).e() != 2) goto L120;
        boolean r125 = true;
    L121:
        if (r125 == false) goto L116;
        r124 = r124 + 1;
        if (r124 >= 0) goto L116;
        CollectionsKt.throwCountOverflow();
        goto L116
    L120:
        r125 = false;
    L125:
        r115[9] = TuplesKt.to("disabled_app_cnt", Boxing.boxInt(r124));
        r115[10] = TuplesKt.to("custom_rule_selected_cnt", Boxing.boxInt(r114));
        String r126 = r107.f531747b;
        if (r126 != null) goto L128;
        r126 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
    L128:
        int r127 = r126.hashCode();
        if (r127 == 48) goto L143;
        if (r127 == 51) goto L140;
        if (r127 == 1629) goto L136;
    L144:
        String r128 = "summary_10s";
    L146:
        r115[11] = TuplesKt.to("broadcast_rhythm", r128);
        String r129 = r107.f531746a;
        if (r129 != null) goto L150;
        r129 = "1";
    L150:
        if (Intrinsics.areEqual(r129, "0") == false) goto L152;
        String r130 = "not_broadcast";
    L153:
        r115[12] = TuplesKt.to("broadcast_conflict_mode", r130);
        int r131 = kj4.a.g().D();
        b0.f338123a.getClass();
        if (b0.r() == true) goto L156;
    L158:
        boolean r132 = false;
    L159:
        r115[13] = TuplesKt.to("shake_head_stop_switch", f(Boxing.boxBoolean(r132)));
        if (r113 == null) goto L164;
        Object r133 = r113.get("wearing_reminder_switch");
        if (r133 == null) goto L164;
        String r134 = r133.toString();
    L165:
        if (r134 == null) goto L182;
        int r135 = r134.hashCode();
        if (r135 == 49) goto L181;
        if (r135 == 50) goto L177;
        if (r135 != 1444) goto L182;
        if (r134.equals("-1") == false) goto L182;
    L179:
        r117 = "off";
    L183:
        r115[14] = TuplesKt.to("wear_greeting_switch", r117);
        return MapsKt.mapOf(r115);
    L177:
        if (r134.equals("2") == true) goto L179;
    L181:
        if (r134.equals("1") == true) goto L183;
    L182:
        r117 = f(Boolean.valueOf(Intrinsics.areEqual(DoraUserSettingsManager.f336207w.getValue(), Boolean.TRUE)));
    L164:
        r134 = null;
        goto L165
    L156:
        if (r131 != 2) goto L158;
        r132 = true;
        goto L159
    L152:
        r130 = "lower_media";
        goto L153
    L136:
        if (r126.equals(BDLocationException.ERROR_SDK_NO_PERMISSION) == false) goto L144;
        r128 = "summary_30s";
        goto L146
    L140:
        if (r126.equals("3") == false) goto L144;
    L145:
        r128 = NotificationBusiness.REAL_TIME;
        goto L146
    L143:
        if (r126.equals("0") == true) goto L145;
    L112:
        if (r122.isEmpty() == false) goto L114;
        r124 = 0;
        goto L125
    L185:
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L102
        Type r137 = new a().getType();     // Catch: Throwable -> L102
        List r138 = (List) new Gson().fromJson(r119, r137);     // Catch: Throwable -> L102
        if (r138 == null) goto L99;
        List r139 = r138;     // Catch: Throwable -> L102
        if ((r139 instanceof Collection) == true) goto L88;
    L90:
        Iterator r140 = r139.iterator();     // Catch: Throwable -> L102
        int r141 = 0;
    L92:
        if (r140.hasNext() == false) goto L100;
        if (Intrinsics.areEqual(((y59.a) r140.next()).e(), Boolean.TRUE) == false) goto L92;
        r141 = r141 + 1;     // Catch: Throwable -> L102
        if (r141 >= 0) goto L92;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L102
    L100:
        Object r142 = Result.m9449constructorimpl(Integer.valueOf(r141));     // Catch: Throwable -> L102
    L104:
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L108;
        d.c("NotificationBroadcastV3Tracker", "countSelectedSpecialContacts failed", r143);
        r142 = 0;
    L108:
        r121 = ((Number) r142).intValue();
        goto L109
    L88:
        if (r139.isEmpty() == false) goto L90;
    L99:
        r141 = 0;
    L102:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L104
    L77:
        if (StringsKt.isBlank(r119) == true) goto L80;
        r120 = false;
        goto L81
    L73:
        r118 = "off";
        goto L74
    L69:
        r116 = null;
        goto L70
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        f0 r145 = (f0) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L24:
        r113 = (Map) r102;
        if (r113 == null) goto L27;
        q59.a r146 = q59.b.b(r113);
    L28:
        q59.a r147 = r146;
        String r148 = r147.f531752g;
        if (r148 != null) goto L31;
    L34:
        boolean r149 = true;
    L35:
        if (r149 == false) goto L187;
        Map<String, Boolean> r150 = f336408c;
    L56:
        List<s> r151 = r145.c();
        if (r151 == null) goto L61;
        List r152 = CollectionsKt.filterNotNull(r151);
        if (r152 == null) goto L61;
    L62:
        r100.L$0 = r145;
        r100.L$1 = r113;
        r100.L$2 = r147;
        r100.L$3 = r150;
        r100.L$4 = r152;
        r100.label = 3;
        Object r153 = r110.d(r100);
        if (r153 == r103) goto L208;
        r106 = r150;
        r102 = r153;
        r108 = r145;
        r107 = r147;
        r105 = r152;
        goto L66
    L208:
        return r103;
    L61:
        r152 = (List) DoraUserSettingsManager.f336195k.getValue();
        goto L62
    L187:
        Result.Companion r154 = Result.Companion;     // Catch: Throwable -> L49
        Type r155 = new b().getType();     // Catch: Throwable -> L49
        List r156 = (List) new Gson().fromJson(r148, r155);     // Catch: Throwable -> L49
        if (r156 != null) goto L40;
        r156 = CollectionsKt.emptyList();     // Catch: Throwable -> L49
    L40:
        Map r157 = MapsKt.toMutableMap(f336408c);     // Catch: Throwable -> L49
        Iterator r158 = r156.iterator();     // Catch: Throwable -> L49
    L42:
        if (r158.hasNext() == false) goto L47;
        c r159 = (c) r158.next();     // Catch: Throwable -> L49
        String r160 = r159.b();     // Catch: Throwable -> L49
        if (r160 == null) goto L42;
        r157.put(r160, Boolean.valueOf(r159.a()));     // Catch: Throwable -> L49
        goto L42
    L47:
        Object r161 = Result.m9449constructorimpl(r157);     // Catch: Throwable -> L49
    L51:
        Throwable r162 = Result.m9452exceptionOrNullimpl(r161);
        if (r162 == null) goto L55;
        d.c("NotificationBroadcastV3Tracker", "parseServiceConfigList failed, fallback to defaults", r162);
        r161 = f336408c;
    L55:
        r150 = (Map) r161;
    L49:
        th = move-exception;
        Result.Companion r163 = Result.Companion;
        r161 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L31:
        if (StringsKt.isBlank(r148) == true) goto L34;
        r149 = false;
        goto L35
    L27:
        r146 = (q59.a) DoraUserSettingsManager.f336197m.getValue();
        goto L28
    L17:
        DoraDevice r164 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r165 = r102;
        DoraDevice r166 = r164;
    L21:
        r145 = (f0) r165;
        r100.L$0 = r145;
        r100.label = 2;
        r102 = r110.b(r166, r100);
        if (r102 != r103) goto L24;
        return r103;
    L18:
        ResultKt.throwOnFailure(r102);
        r166 = r111;
        r100.L$0 = r166;
        r100.label = 1;
        r165 = r110.c(r100);
        if (r165 != r103) goto L21;
        return r103;
    L7:
        r100 = new NotificationBroadcastV3Tracker$buildSettingsParams$1(r110, r112);
        goto L8
    }
}
