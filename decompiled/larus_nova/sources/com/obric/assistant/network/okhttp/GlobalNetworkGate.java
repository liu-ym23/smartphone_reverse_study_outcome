package com.obric.assistant.network.okhttp;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import hm9.j;
import hm9.s;
import iaa.e;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalNetworkGate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f390350a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f390351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Set<String> f390352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Set<String> f390353d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/network/okhttp/GlobalNetworkGate$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "BLOCK_DROP", "BLOCK_DELAY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Decision extends Enum<Decision> {
        public static final Decision ALLOW = null;
        public static final Decision BLOCK_DELAY = null;
        public static final Decision BLOCK_DROP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Decision[] f390354a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f390355b = null;

        public static EnumEntries<Decision> getEntries() {
            return f390355b;
        }

        static {
            Decision r100 = new Decision("ALLOW", 0);
            ALLOW = r100;
            Decision r101 = new Decision("BLOCK_DROP", 1);
            BLOCK_DROP = r101;
            Decision r102 = new Decision("BLOCK_DELAY", 2);
            BLOCK_DELAY = r102;
            Decision[] r103 = {r100, r101, r102};
            f390354a = r103;
            f390355b = EnumEntriesKt.enumEntries(r103);
        }

        public static Decision[] values() {
            return (Decision[]) f390354a.clone();
        }

        public static Decision valueOf(String r100) {
            return (Decision) r27.a.a(Decision.class, r100);
        }

        public Decision(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        AppHost.Companion r100 = AppHost.f326268a;
        boolean r101 = false;
        if (r100.isDebug() == false) goto L5;
    L10:
        boolean r102 = true;
    L11:
        f390350a = r102;
        s r103 = j.f485966h;
        if (r103.f485974d == true) goto L14;
    L16:
        f390351b = r101;
        f390352c = SetsKt.emptySet();
        f390353d = SetsKt.setOf("faas/services/ttsqtr/invoke/push_event_batch");
        return;
    L14:
        if (r103.f485995y != 2) goto L16;
        r101 = true;
        goto L16
    L5:
        if (StringsKt.equals("local_test", r100.getBuildChannel(), true) == true) goto L10;
        if (Intrinsics.areEqual(e.b("persist.sys.ttnet_debug", "false"), "true") == true) goto L10;
        r102 = false;
        goto L11
    }

    public static String b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return "";
    L13:
        return StringsKt.trim(StringsKt.trim(r100).toString(), new char[]{'/'}).toLowerCase(Locale.ROOT);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static String c(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return "";
    L13:
        return StringsKt.trim(StringsKt.trim(r100).toString(), new char[]{'/'});
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static Decision a(String r100, String r101) {
        if (f390350a == false) goto L6;
        FLogger.f375446a.d("GlobalNetworkGate", "decide host=" + r100 + " path=" + r101 + " enable=" + f390351b + " hostWhitelist=" + f390352c + " pathWhitelist=" + f390353d);
    L6:
        if (f390351b == false) goto L8;
        boolean r102 = false;
        if (r100 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L18;
        if (r100 == null) goto L39;
        int r104 = r100.hashCode();
        if (r104 == (-1204607085)) goto L34;
        if (r104 == 57585) goto L31;
        if (r104 != 1505998205) goto L39;
        if (r100.equals("127.0.0.1") == false) goto L39;
    L37:
        return Decision.ALLOW;
    L31:
        if (r100.equals("::1") == true) goto L37;
    L34:
        if (r100.equals("localhost") == true) goto L37;
    L39:
        if ((!f390352c.isEmpty()) == true) goto L41;
    L44:
        if (r101 != null) goto L46;
    L47:
        r102 = true;
    L48:
        if (r102 == true) goto L56;
        if ((!f390353d.isEmpty()) == false) goto L56;
        if (f390353d.contains(c(r101)) == false) goto L56;
        return Decision.ALLOW;
    L56:
        if (j.f485966h.B == false) goto L60;
        return Decision.BLOCK_DROP;
    L60:
        return Decision.ALLOW;
    L46:
        if (r101.length() != 0) goto L48;
    L41:
        if (f390352c.contains(b(r100)) == false) goto L44;
        return Decision.ALLOW;
    L18:
        return Decision.ALLOW;
    L12:
        if (r100.length() == 0) goto L15;
        r103 = false;
        goto L16
    L8:
        return Decision.ALLOW;
    }

    @JvmStatic
    public static final void d(Decision r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "decision");
        if (r100 != Decision.ALLOW) goto L5;
        return;
    L5:
        FLogger.f375446a.i("GlobalNetworkGate", "decision=" + r100 + " host=" + r101 + " path=" + r102);
    }
}
