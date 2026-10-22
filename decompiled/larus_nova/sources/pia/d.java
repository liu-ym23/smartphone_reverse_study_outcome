package pia;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f529409a = null;

    static {
        f529409a = LazyKt.lazy(new c());
    }

    public static Keva i() {
        return (Keva) f529409a.getValue();
    }

    public static Set e() {
        Set<String> r100 = i().getStringSet("voice_print_enrolled_uids", SetsKt.emptySet());
        if (r100 == null) goto L5;
        return r100;
    L5:
        return SetsKt.emptySet();
    }

    public static Set f() {
        Set<String> r100 = i().getStringSet("voice_print_pending_cloud_op_uids", SetsKt.emptySet());
        if (r100 == null) goto L5;
        return r100;
    L5:
        return SetsKt.emptySet();
    }

    public static Set h() {
        Set<String> r100 = i().getStringSet("voice_print_pending_trainable_uids", SetsKt.emptySet());
        if (r100 == null) goto L5;
        return r100;
    L5:
        return SetsKt.emptySet();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Set r101 = e();
        if (r101.contains(r100) == false) goto L8;
        return;
    L8:
        LinkedHashSet r102 = new LinkedHashSet(r101);
        r102.add(r100);
        i().storeStringSet("voice_print_enrolled_uids", r102);
        FLogger.f375446a.i("VoiceEnrollUidStore", "addEnrolledUid uid=" + j(r100) + " size=" + r102.size());
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Set r101 = f();
        if (r101.contains(r100) == false) goto L8;
        return;
    L8:
        LinkedHashSet r102 = new LinkedHashSet(r101);
        r102.add(r100);
        i().storeStringSet("voice_print_pending_cloud_op_uids", r102);
        FLogger.f375446a.i("VoiceEnrollUidStore", "addPendingCloudOpUid uid=" + j(r100) + " size=" + r102.size());
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter("none", "defValue");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return "none";
    L6:
        return i().getString("default_voice_print_cloud_actual_op_" + r100, "none");
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter("none", "defValue");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return "none";
    L6:
        return i().getString("default_voice_print_cloud_desired_op_" + r100, "none");
    }

    public static Boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        String r101 = "default_voice_print_trainable_pending_" + r100;
        if (i().contains(r101) == true) goto L9;
        return null;
    L9:
        return Boolean.valueOf(i().getBoolean(r101, false));
    }

    public static String j(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L7;
        return "";
    L7:
        return "****" + StringsKt.takeLast(r100, 4);
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Set r101 = e();
        if (r101.contains(r100) == true) goto L8;
        return;
    L8:
        LinkedHashSet r102 = new LinkedHashSet(r101);
        r102.remove(r100);
        i().storeStringSet("voice_print_enrolled_uids", r102);
        FLogger.f375446a.i("VoiceEnrollUidStore", "removeEnrolledUid uid=" + j(r100) + " size=" + r102.size());
    }

    public static void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Set r101 = f();
        if (r101.contains(r100) == true) goto L8;
        return;
    L8:
        LinkedHashSet r102 = new LinkedHashSet(r101);
        r102.remove(r100);
        i().storeStringSet("voice_print_pending_cloud_op_uids", r102);
        FLogger.f375446a.i("VoiceEnrollUidStore", "removePendingCloudOpUid uid=" + j(r100) + " size=" + r102.size());
    }

    public static void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        i().erase("default_voice_print_trainable_pending_" + r100);
        if (StringsKt.isBlank(r100) == true) goto L12;
        Set r101 = h();
        if (r101.contains(r100) == false) goto L12;
        LinkedHashSet r102 = new LinkedHashSet(r101);
        r102.remove(r100);
        i().storeStringSet("voice_print_pending_trainable_uids", r102);
        FLogger.f375446a.i("VoiceEnrollUidStore", "removePendingVoicePrintTrainableUid uid=" + j(r100) + " size=" + r102.size());
    L12:
        FLogger.f375446a.i("VoiceEnrollUidStore", "removePendingVoicePrintTrainable uid=" + j(r100));
    }

    public static void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        String r101 = "";
        String r102 = i().getString("voice_print_owner_did", "");
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        if (Intrinsics.areEqual(r101, r100) == false) goto L12;
        return;
    L12:
        i().storeString("voice_print_owner_did", r100);
        FLogger.f375446a.i("VoiceEnrollUidStore", "setVoicePrintOwnerDid didLen=" + r100.length());
    }

    public static void n(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        i().storeBoolean("breath_wakeup_enabled_" + r100, r101);
        FLogger.f375446a.i("VoiceEnrollUidStore", "setBreathWakeupEnabled uid=" + j(r100) + " enabled=" + r101);
    }

    public static void o(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        i().storeString("default_voice_print_cloud_actual_op_".concat(r100), r101);
        if (Intrinsics.areEqual(r101, d(r100)) == false) goto L9;
        l(r100);
        return;
    }

    public static void p(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        i().storeString("default_voice_print_cloud_desired_op_".concat(r100), r101);
        int r102 = r101.hashCode();
        if (r102 == (-1335458389)) goto L20;
        if (r102 == (-838595071)) goto L17;
        if (r102 == 3387192) goto L13;
        return;
    L13:
        if (r101.equals("none") == false) goto L26;
        l(r100);
        return;
    L26:
        return;
    L17:
        if (r101.equals("upload") == false) goto L27;
    L21:
        b(r100);
        return;
    L27:
        return;
    L20:
        if (r101.equals("delete") == true) goto L21;
    }

    public static void r(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        i().storeBoolean("voice_wakeup_enabled_" + r100, r101);
        FLogger.f375446a.i("VoiceEnrollUidStore", "setVoiceWakeupEnabled uid=" + j(r100) + " enabled=" + r101);
    }
}
