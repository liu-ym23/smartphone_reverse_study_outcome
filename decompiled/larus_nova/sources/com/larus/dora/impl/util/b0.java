package com.larus.dora.impl.util;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f338123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f338124b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f338125c = null;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/util/DoraRepo$getNotificationRules$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/dora/api/entity/NotificationRule;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends NotificationRule>> {
        public a() {
        }
    }

    public b0() {
    }

    public static DoraSimpleDevice k() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        String r102 = j().getString("dora_last_bound_device", "");     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L12
        if (r102.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        DoraSimpleDevice r104 = (DoraSimpleDevice) h().fromJson(r102, DoraSimpleDevice.class);     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r105) == true) goto L19;
        r100 = r105;
    L19:
        return (DoraSimpleDevice) r100;
    L9:
        r104 = null;
        goto L10
    L6:
        r103 = false;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    static {
        f338123a = new b0();
        f338124b = LazyKt.lazy(new z());
        f338125c = LazyKt.lazy(new a0());
    }

    public static List d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        String r101 = j().getString("cloud_slardar_cmd_types", "");     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L10
        List r102 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L10
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L10
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L10
    L4:
        if (r104.hasNext() == false) goto L8;
        Integer r105 = StringsKt.toIntOrNull((String) r104.next());     // Catch: Throwable -> L10
        if (r105 == null) goto L4;
        r103.add(r105);     // Catch: Throwable -> L10
        goto L4
    L8:
        Object r106 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r106) == false) goto L16;
        r106 = null;
    L16:
        return (List) r106;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static Gson h() {
        return (Gson) f338125c.getValue();
    }

    public static Keva j() {
        return (Keva) f338124b.getValue();
    }

    public static DoraSimpleDevice l() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        String[] r102 = j().getStringArray("dora_history_devices", new String[0]);     // Catch: Throwable -> L12
        if (r102 != null) goto L6;
        r102 = new String[0];     // Catch: Throwable -> L12
    L6:
        String r103 = (String) ArraysKt.firstOrNull(r102);     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        DoraSimpleDevice r104 = (DoraSimpleDevice) h().fromJson(j().getString("dora_last_connected_device_".concat(r103), ""), DoraSimpleDevice.class);     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r105) == true) goto L19;
        r100 = r105;
    L19:
        return (DoraSimpleDevice) r100;
    L9:
        r104 = null;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static boolean x() {
        String r100 = AccountService.f365697a.getUserId();
        return j().getBoolean("dora_record_location_enabled_".concat(r100), false);
    }

    public static boolean y() {
        String r100 = AccountService.f365697a.getUserId();
        return j().getBoolean("dora_save_to_gallery_enabled_".concat(r100), true);
    }

    public static void A() {
        if (j().getBoolean("dora_keep_alive_page_shown", false) == true) goto L6;
        j().storeBoolean("dora_keep_alive_page_shown", true);
        return;
    }

    public static void F() {
        j().storeLong("dora_nl_confirm_timestamp", new Date().getTime());
    }

    public static int c() {
        int r100 = j().getInt("dora_auto_stop_time_config", 12);
        if (w() == false) goto L8;
        if (r100 != 5) goto L8;
        return 12;
    L8:
        return r100;
    }

    public static List e() {
        String[] r100 = j().getStringArray("dora_history_devices", new String[0]);
        if (r100 == null) goto L7;
        List r101 = ArraysKt.toList(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public static List i() {
        int r100 = 0;
        String[] r101 = j().getStringArray("key_keep_alive_balloon_recent_shown_time", new String[0]);
        Intrinsics.checkNotNull(r101);
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
    L3:
        if (r100 >= r103) goto L5;
        String r104 = r101[r100];
        Intrinsics.checkNotNull(r104);
        r102.add(Long.valueOf(CastLongProtector.parseLong(r104)));
        r100 = r100 + 1;
        goto L3
    L5:
        return r102;
    }

    public static boolean r() {
        return j().getBoolean("dora_head_gesture_control_enabled", false);
    }

    public static boolean s() {
        return j().getBoolean("dora_location_poll_enabled", true);
    }

    public static boolean w() {
        if (j().getInt("dora_quick_continuous_conversation_switch_state", 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    public static void H(int r100) {
        Keva r101 = j();
        if (w() == true) goto L5;
    L7:
        r101.storeInt("dora_auto_stop_time_config", r100);
        return;
    L5:
        if (r100 != 5) goto L7;
        r100 = 12;
        goto L7
    }

    public static void I(List r110) {
        Intrinsics.checkNotNullParameter(r110, "types");
        j().storeString("cloud_slardar_cmd_types", CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null));
    }

    public static void K(boolean r100) {
        j().storeBoolean("dora_head_gesture_control_enabled", r100);
    }

    public static void M(boolean r100) {
        j().storeInt("dora_quick_continuous_conversation_switch_state", r100 ? 1 : 0);
        if (r100 == true) goto L5;
        return;
    L5:
        if (j().contains("dora_auto_stop_time_config") == true) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L15;
        H(12);
        return;
    L15:
        return;
    L7:
        if (j().getInt("dora_auto_stop_time_config", 12) < 12) goto L10;
        r101 = false;
        goto L11
    }

    public static void N(boolean r100) {
        String r101 = AccountService.f365697a.getUserId();
        j().storeBoolean("dora_record_location_enabled_".concat(r101), r100);
    }

    public static void a(long r100) {
        String[] r101 = j().getStringArray("key_keep_alive_balloon_recent_shown_time", new String[0]);
        Intrinsics.checkNotNull(r101);
        List r102 = ArraysKt.toMutableList(r101);
        if (r102.size() < 5) goto L5;
        ListProtector.remove(r102, 0);
    L5:
        r102.add(String.valueOf(r100));
        j().storeStringArray("key_keep_alive_balloon_recent_shown_time", (String[]) r102.toArray(new String[0]));
    }

    public static boolean f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return j().getBoolean("dora_soda_banner_need_show" + r100, false);
    }

    public static e0 g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = j().getString("dora_sound_ambient_volume_user_config_".concat(r100), null);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        e0 r104 = (e0) h().fromJson(r103, e0.class);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r101 = r105;
    L16:
        return (e0) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static List m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        String r102 = j().getString("dora_notification_rules_" + r100, "");     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L12
        if (r102.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        Object r104 = Result.m9449constructorimpl((List) h().fromJson(r102, new a().getType()));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        r104 = null;
    L17:
        List r105 = (List) r104;
        if (r105 == null) goto L20;
        return r105;
    L20:
        return CollectionsKt.emptyList();
    L9:
        return CollectionsKt.emptyList();
    L6:
        r103 = false;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static sk4.e n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = j().getString("dora_device_protocol_info" + r100, null);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        sk4.e r104 = (sk4.e) h().fromJson(r103, sk4.e.class);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r101 = r105;
    L16:
        return (sk4.e) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static int o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return j().getInt(r100.concat("_dora_newcomer_wakeup_count"), 0);
    }

    public static boolean p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return j().getBoolean("dora_enable_bluetooth_rtc_" + r100, false);
    }

    public static boolean q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return j().getBoolean("dora_settings_first_use_lab_entry" + r100, true);
    }

    public static boolean t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return j().getBoolean("dora_multi_user_mode_state_" + r100, false);
    }

    public static boolean u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return j().getBoolean("dora_enable_p2p_rtc_" + r100, false);
    }

    public static boolean v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return j().getBoolean("dora_settings_proactive_priority".concat(r100), true);
    }

    public static void z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mac");
        g(r100);
        e0 r101 = new e0(true);
        Intrinsics.checkNotNullParameter(r100, "mac");
        Intrinsics.checkNotNullParameter(r101, "config");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        j().storeString("dora_sound_ambient_volume_user_config_".concat(r100), h().toJson(r101));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void B(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "mac");
        j().erase(r100 + '_' + r101 + "_dora_earbuds_need_bind");
    }

    public static void C(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "mac");
        j().storeBoolean(r100 + '_' + r101 + "_dora_earbuds_need_bind", true);
    }

    public static void D(String r100, DoraSimpleDevice r110) {
        Intrinsics.checkNotNullParameter(r100, "address");
        Intrinsics.checkNotNullParameter(r110, "device");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        int r102 = 0;
        String[] r103 = j().getStringArray("dora_history_devices", new String[0]);     // Catch: Throwable -> L17
        if (r103 != null) goto L7;
        r103 = new String[0];     // Catch: Throwable -> L17
    L7:
        if (Intrinsics.areEqual(ArraysKt.firstOrNull(r103), r100) == true) goto L15;
        String[] r104 = {r100};     // Catch: Throwable -> L17
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L17
        int r106 = r103.length;     // Catch: Throwable -> L17
    L9:
        if (r102 >= r106) goto L14;
        String r107 = r103[r102];     // Catch: Throwable -> L17
        if ((!Intrinsics.areEqual(r107, r100)) == false) goto L13;
        r105.add(r107);     // Catch: Throwable -> L17
    L13:
        r102 = r102 + 1;     // Catch: Throwable -> L17
        goto L9
    L14:
        j().storeStringArray("dora_history_devices", (String[]) ArraysKt.plus(r104, r105));     // Catch: Throwable -> L17
    L15:
        j().storeString("dora_last_connected_device_" + r100, h().toJson(r110));     // Catch: Throwable -> L17
        j().storeString("dora_last_bound_device", h().toJson(r110));     // Catch: Throwable -> L17
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void E(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        j().storeBoolean("dora_multi_user_mode_state_" + r100, r101);
    }

    public static void G(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "rules");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        j().storeString("dora_notification_rules_" + r100, h().toJson(r101));     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void J(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uid");
        j().storeBoolean("dora_soda_banner_need_show" + r101, r100);
    }

    public static void L(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        j().storeBoolean("dora_settings_proactive_priority".concat(r100), r101);
    }

    public static void O(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        String r103 = h().toJson(r101);     // Catch: Throwable -> L5
        j().storeString("dora_user_settings_v2_" + r100, r103);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "mac");
        return j().getBoolean(r100 + '_' + r101 + "_dora_earbuds_need_bind", false);
    }
}
