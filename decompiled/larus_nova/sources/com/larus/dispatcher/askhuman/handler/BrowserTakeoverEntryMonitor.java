package com.larus.dispatcher.askhuman.handler;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class BrowserTakeoverEntryMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f330869e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f330872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BrowserTakeoverOpenResult f330873d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/larus/dispatcher/askhuman/handler/BrowserTakeoverEntryMonitor$Reason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "ALREADY_OPEN", "PC_UNAVAILABLE", "ACTIVITY_UNAVAILABLE", "INVALID_REQUEST", "TARGET_UNAVAILABLE", "DEVICE_ID_MISSING", "INVALID_APP_ID", "DEVICE_CACHE_ERROR", "DEVICE_CACHE_MISSING", "DEVICE_NOT_FOUND", "DEVICE_AMBIGUOUS", "DEVICE_OFFLINE", "NOT_AUTHORIZED", "CONTROL_DISABLED", "CAPABILITY_MISSING", "EXPERIMENT_DISABLED", "TARGET_DISABLED", "SESSION_BUSY", "PAGE_OPEN_FAILED", "SERVICE_UNAVAILABLE", "OPEN_REJECTED", "PC_GUIDE_UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason ACTIVITY_UNAVAILABLE = null;
        public static final Reason ALREADY_OPEN = null;
        public static final Reason CAPABILITY_MISSING = null;
        public static final Reason CONTROL_DISABLED = null;
        public static final Reason DEVICE_AMBIGUOUS = null;
        public static final Reason DEVICE_CACHE_ERROR = null;
        public static final Reason DEVICE_CACHE_MISSING = null;
        public static final Reason DEVICE_ID_MISSING = null;
        public static final Reason DEVICE_NOT_FOUND = null;
        public static final Reason DEVICE_OFFLINE = null;
        public static final Reason EXPERIMENT_DISABLED = null;
        public static final Reason INVALID_APP_ID = null;
        public static final Reason INVALID_REQUEST = null;
        public static final Reason NONE = null;
        public static final Reason NOT_AUTHORIZED = null;
        public static final Reason OPEN_REJECTED = null;
        public static final Reason PAGE_OPEN_FAILED = null;
        public static final Reason PC_GUIDE_UNAVAILABLE = null;
        public static final Reason PC_UNAVAILABLE = null;
        public static final Reason SERVICE_UNAVAILABLE = null;
        public static final Reason SESSION_BUSY = null;
        public static final Reason TARGET_DISABLED = null;
        public static final Reason TARGET_UNAVAILABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f330874a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f330875b = null;
        private final String value;

        public static EnumEntries<Reason> getEntries() {
            return f330875b;
        }

        static {
            Reason r100 = new Reason(UserProfileEvent.POSITION_NONE, 0, "none");
            NONE = r100;
            Reason r101 = new Reason("ALREADY_OPEN", 1, "already_open");
            ALREADY_OPEN = r101;
            Reason r102 = new Reason("PC_UNAVAILABLE", 2, "pc_unavailable");
            PC_UNAVAILABLE = r102;
            Reason r103 = new Reason("ACTIVITY_UNAVAILABLE", 3, "activity_unavailable");
            ACTIVITY_UNAVAILABLE = r103;
            Reason r104 = new Reason("INVALID_REQUEST", 4, "invalid_request");
            INVALID_REQUEST = r104;
            Reason r105 = new Reason("TARGET_UNAVAILABLE", 5, "target_unavailable");
            TARGET_UNAVAILABLE = r105;
            Reason r110 = new Reason("DEVICE_ID_MISSING", 6, "device_id_missing");
            DEVICE_ID_MISSING = r110;
            Reason r111 = new Reason("INVALID_APP_ID", 7, "invalid_app_id");
            INVALID_APP_ID = r111;
            Reason r112 = new Reason("DEVICE_CACHE_ERROR", 8, "device_cache_error");
            DEVICE_CACHE_ERROR = r112;
            Reason r113 = new Reason("DEVICE_CACHE_MISSING", 9, "device_cache_missing");
            DEVICE_CACHE_MISSING = r113;
            Reason r114 = new Reason("DEVICE_NOT_FOUND", 10, "device_not_found");
            DEVICE_NOT_FOUND = r114;
            Reason r106 = new Reason("DEVICE_AMBIGUOUS", 11, "device_ambiguous");
            DEVICE_AMBIGUOUS = r106;
            Reason r107 = new Reason("DEVICE_OFFLINE", 12, "device_offline");
            DEVICE_OFFLINE = r107;
            Reason r108 = new Reason("NOT_AUTHORIZED", 13, "not_authorized");
            NOT_AUTHORIZED = r108;
            Reason r109 = new Reason("CONTROL_DISABLED", 14, "control_disabled");
            CONTROL_DISABLED = r109;
            Reason r115 = new Reason("CAPABILITY_MISSING", 15, "capability_missing");
            CAPABILITY_MISSING = r115;
            Reason r116 = new Reason("EXPERIMENT_DISABLED", 16, "experiment_disabled");
            EXPERIMENT_DISABLED = r116;
            Reason r117 = new Reason("TARGET_DISABLED", 17, "target_disabled");
            TARGET_DISABLED = r117;
            Reason r118 = new Reason("SESSION_BUSY", 18, "session_busy");
            SESSION_BUSY = r118;
            Reason r119 = new Reason("PAGE_OPEN_FAILED", 19, "page_open_failed");
            PAGE_OPEN_FAILED = r119;
            Reason r120 = new Reason("SERVICE_UNAVAILABLE", 20, "service_unavailable");
            SERVICE_UNAVAILABLE = r120;
            Reason r121 = new Reason("OPEN_REJECTED", 21, "open_rejected");
            OPEN_REJECTED = r121;
            Reason r122 = new Reason("PC_GUIDE_UNAVAILABLE", 22, "pc_guide_unavailable");
            PC_GUIDE_UNAVAILABLE = r122;
            Reason[] r123 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122};
            f330874a = r123;
            f330875b = EnumEntriesKt.enumEntries(r123);
        }

        public static Reason[] values() {
            return (Reason[]) f330874a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public Reason(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330876a = null;

        static {
            int[] r100 = new int[BrowserTakeoverOpenResult.values().length];
            r100[BrowserTakeoverOpenResult.ACTIVITY_UNAVAILABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[BrowserTakeoverOpenResult.EXPERIMENT_DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[BrowserTakeoverOpenResult.TARGET_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[BrowserTakeoverOpenResult.INVALID_REQUEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[BrowserTakeoverOpenResult.SESSION_BUSY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[BrowserTakeoverOpenResult.PAGE_OPEN_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[BrowserTakeoverOpenResult.SERVICE_UNAVAILABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f330876a = r100;
        }
    }

    static {
    }

    public BrowserTakeoverEntryMonitor(String r100) {
        this.f330870a = r100;
        this.f330871b = UUID.randomUUID().toString();
        this.f330872c = new AtomicBoolean(false);
    }

    public final void a(boolean r100, Reason r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (r100 == false) goto L5;
        String r102 = "fallback";
    L6:
        if (r100 == true) goto L9;
        r101 = Reason.PC_GUIDE_UNAVAILABLE;
    L9:
        b(r102, r101);
        return;
    L5:
        r102 = "fail";
        goto L6
    }

    public final void b(String r100, Reason r101) {
        if (this.f330872c.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        com.larus.platform.service.o r103 = com.larus.platform.service.o.f365780a;     // Catch: Throwable -> L10
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L10
        String r105 = this.f330870a;     // Catch: Throwable -> L10
        if (r105 == null) goto L8;
        r104.put(PickerReporterConstants.KEY.TARGET, r105);     // Catch: Throwable -> L10
    L8:
        r104.put("result", r100);     // Catch: Throwable -> L10
        r104.put("reason", r101.getValue());     // Catch: Throwable -> L10
        r104.put("takeover_id", this.f330871b);     // Catch: Throwable -> L10
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r103.reportEvent("browser_takeover_entry", r104);     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
