package rna;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.obric.assistant.voice.l;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import sna.h;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f538735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f538736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f538737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Regex> f538738d = null;

    /* JADX INFO: loaded from: classes34.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f538739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f538740b;

        public a() {
            this(false, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f538739a == r101.f538739a) goto L12;
            return false;
        L12:
            if (this.f538740b == r101.f538740b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f538739a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f538740b;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "BreathTrackerConfig(enable=" + this.f538739a + ", maxCacheSize=" + this.f538740b + ')';
        }

        public a(boolean r100, int r101) {
            this.f538739a = r100;
            this.f538740b = r101;
        }
    }

    /* JADX INFO: renamed from: rna.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes34.dex */
    public static final class C7506b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f538741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f538742b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7506b) == true) goto L8;
            return false;
        L8:
            C7506b r101 = (C7506b) r100;
            if (Intrinsics.areEqual(this.f538741a, r101.f538741a) == true) goto L12;
            return false;
        L12:
            if (this.f538742b == r101.f538742b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f538741a.hashCode() * 31;
            long r101 = this.f538742b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "VoiceWakeupSidThresholdSnapshot(config=" + this.f538741a + ", cachedAt=" + this.f538742b + ')';
        }

        public C7506b(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f538741a = r100;
            this.f538742b = r101;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f538743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f538744b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f538743a == r101.f538743a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f538744b, r101.f538744b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f538743a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f538744b.hashCode();
        }

        public final String toString() {
            return "VoiceprintFailRecord(failTime=" + this.f538743a + ", wakeupId=" + this.f538744b + ')';
        }

        public c(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, InteractConst.WAKEUP_WAKEUP_ID);
            this.f538743a = r100;
            this.f538744b = r101;
        }
    }

    static {
        f538735a = "";
        f538736b = "";
        f538737c = "";
        f538738d = CollectionsKt.listOf(new Regex[]{new Regex("(\"uid\"\\s*:\\s*\")([^\"]*)(\")"), new Regex("(\\buid\\s*=\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buid\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buid:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buserId\\s*=\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bmyID\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bgivenUid\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\buuid\\s*:\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bcachedUUID\\s*=\\s*)([^,\\s)\\]}]+)"), new Regex("(\\bsCachedUUID\\s*=\\s*)([^,\\s)\\]}]+)")});
    }

    @JvmStatic
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "doubaoDid");
        h r101 = h.f542678a;
        Intrinsics.checkNotNullParameter(r100, "doubaoDid");
        if (StringsKt.isBlank(r100) == false) goto L5;
    L8:
        h.b("saveDoubaoDid ignored invalid value, valueLength=" + r100.length());
        return false;
    L5:
        if (Intrinsics.areEqual(r100, "0") == true) goto L8;
        h.a().storeString("doubao_did", r100);
        h.b("saveDoubaoDid success, valueLength=" + r100.length());
        return true;
    }

    @JvmStatic
    public static final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "osDeviceId");
        h r101 = h.f542678a;
        Intrinsics.checkNotNullParameter(r100, "osDeviceId");
        if (StringsKt.isBlank(r100) == false) goto L5;
    L8:
        h.b("saveOsDeviceId ignored invalid value, valueLength=" + r100.length());
        return false;
    L5:
        if (Intrinsics.areEqual(r100, "0") == true) goto L8;
        h.a().storeString("os_device_id", r100);
        h.b("saveOsDeviceId success, valueLength=" + r100.length());
        return true;
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        h r101 = h.f542678a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "config");     // Catch: Throwable -> L7
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L7
        h.a().storeString("voice_wakeup_sid_threshold_config", r100);     // Catch: Throwable -> L7
        h.a().storeLong("voice_wakeup_sid_threshold_cached_at", r102);     // Catch: Throwable -> L7
        h.b("saveSidThreshold success, configLength=" + r100.length() + ", cachedAt=" + r102);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final String d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f538737c.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        Bundle r102 = r100.getContentResolver().call(l.f394381a, "get-app-id", null, null);
        String r103 = "";
        if (r102 == null) goto L13;
        String r104 = r102.getString("appid", "");
        if (r104 == null) goto L13;
        r103 = r104;
    L13:
        f538737c = r103;
    L15:
        return f538737c;
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final String e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f538736b.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        Bundle r102 = r100.getContentResolver().call(l.f394381a, "get-app-version-name", null, null);
        String r103 = "";
        if (r102 == null) goto L13;
        String r104 = r102.getString("version", "");
        if (r104 == null) goto L13;
        r103 = r104;
    L13:
        f538736b = r103;
    L15:
        return f538736b;
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final String f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bundle r101 = r100.getContentResolver().call(l.f394381a, "get-build-channel", null, null);
        String r102 = "debug";
        if (r101 == null) goto L9;
        String r103 = r101.getString("channel", "debug");
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        return r102;
    }

    @JvmStatic
    public static final String g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        h r101 = h.f542678a;
        String r102 = "";
        String r103 = h.a().getString("doubao_did", "");
        if (r103 == null) goto L6;
        r102 = r103;
    L6:
        StringBuilder r104 = new StringBuilder("getDoubaoDid ");
        if (r102.length() != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        String r106 = "cache miss";
    L13:
        r104.append(r106);
        r104.append(", valueLength=");
        r104.append(r102.length());
        h.b(r104.toString());
        q(r102);
        return r102;
    L12:
        r106 = "success";
        goto L13
    L9:
        r105 = false;
        goto L10
    }

    @JvmStatic
    public static final String h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bundle r101 = r100.getContentResolver().call(l.f394381a, "stage1_user_config_setting", null, null);     // Catch: Exception -> L10
        if (r101 == null) goto L7;
        String r102 = r101.getString("data", "");     // Catch: Exception -> L10
        if (r102 == null) goto L7;
    L8:
        TextUtils.isEmpty(r102);     // Catch: Exception -> L10
        return r102;
    L7:
        r102 = "";
    L10:
        e = move-exception;
        e.getMessage();
        return "";
    }

    @JvmStatic
    public static final String i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = f538735a;
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (k(StringsKt.substringBefore(r101, '-', ""), StringsKt.substringAfter(r101, '-', "")) == false) goto L8;
    L17:
        l(f538735a);
        return f538735a;
    L8:
        if (f538735a.length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        l(f538735a);
        f538735a = "";
    L13:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String[] r104 = j(r100);
        if (k((String) ArraysKt.getOrNull(r104, 0), (String) ArraysKt.getOrNull(r104, 1)) == false) goto L16;
        r102 = r104[0] + '-' + r104[1];
    L16:
        f538735a = r102;
        l(r102);
        l(f538735a);
        goto L17
    L10:
        r103 = false;
        goto L11
    }

    @JvmStatic
    public static final String[] j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bundle r101 = r100.getContentResolver().call(l.f394381a, ST.UUID_DEVICE, null, null);     // Catch: Exception -> L14
        if (r101 == null) goto L7;
        String r102 = r101.getString("uid", "");     // Catch: Exception -> L14
        if (r102 == null) goto L7;
    L8:
        if (r101 == null) goto L11;
        String r103 = r101.getString(com.bytedance.android.ec.core.event.a.KEY_DID, "");     // Catch: Exception -> L14
        if (r103 == null) goto L11;
    L12:
        k(r102, r103);     // Catch: Exception -> L14
        l(r102);     // Catch: Exception -> L14
        q(r103);     // Catch: Exception -> L14
        return new String[]{r102, r103};
    L11:
        r103 = "";
    L7:
        r102 = "";
    L14:
        e = move-exception;
        e.getMessage();
        return new String[]{"", ""};
    }

    @JvmStatic
    public static final String l(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        boolean r101 = true;
        if (r100.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return "";
    L11:
        String r103 = StringsKt.substringBefore(r100, '-', r100);
        String r104 = StringsKt.substringAfter(r100, '-', "");
        if (r104.length() == 0) goto L16;
        r101 = false;
    L16:
        if (r101 == false) goto L19;
        return "****" + StringsKt.takeLast(r103, 4);
    L19:
        return "****" + StringsKt.takeLast(r103, 4) + '-' + r104;
    L8:
        r102 = false;
        goto L9
    }

    @JvmStatic
    public static final int m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r102 = r100.getContentResolver().call(l.f394381a, "migrate-legacy-phone-enroll", null, null);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        int r103 = r102.getInt("ret", Integer.MIN_VALUE);     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        r105.getMessage();
    L15:
        if (Result.m9455isFailureimpl(r104) == false) goto L18;
        r104 = Integer.MIN_VALUE;
    L18:
        return ((Number) r104).intValue();
    L6:
        r103 = Integer.MIN_VALUE;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void q(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        StringsKt.takeLast(r100, 4);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean k(String r100, String r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r100, "0") == true) goto L22;
        if (r101 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == true) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (StringsKt.isBlank(r101) == true) goto L17;
        r103 = false;
        goto L18
    L22:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    @JvmStatic
    public static final void n(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        if (StringsKt.isBlank(r101) == false) goto L13;
        return;
    L13:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r103 = new Bundle();     // Catch: Throwable -> L7
        r103.putString("package_name", r101);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(r100.getContentResolver().call(l.f394381a, "on-app-installed", null, r103));     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        r105.getMessage();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void o(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        if (StringsKt.isBlank(r101) == false) goto L13;
        return;
    L13:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r103 = new Bundle();     // Catch: Throwable -> L7
        r103.putString("package_name", r101);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(r100.getContentResolver().call(l.f394381a, "on-app-uninstalled", null, r103));     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        r105.getMessage();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final boolean p(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, InteractConst.WAKEUP_WAKEUP_ID);
        h r102 = h.f542678a;
        Intrinsics.checkNotNullParameter(r101, InteractConst.WAKEUP_WAKEUP_ID);
        if (r100 > 0) goto L5;
        h.b("saveVoiceprintFailRecord ignored invalid failTime=" + r100);
        return false;
    L5:
        h.a().storeLong("voiceprint_fail_time", r100);
        h.a().storeString("voiceprint_fail_wakeup_id", r101);
        h.b("saveVoiceprintFailRecord success, failTime=" + r100 + ", wakeupIdLength=" + r101.length());
        return true;
    }
}
