package com.obric.assistant.activation.presentation.runtime.precheck;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricChildListeningPrecheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<fba.b> f385453a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/precheck/ObricChildListeningPrecheck$Reason;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "HOST_STATE_MISSING", "NOT_LOGGED_IN", "USER_GUIDE_NOT_COMPLETED", "SCREEN_OFF_DISABLED", "SCREEN_LANDSCAPE", "IN_CALL", "MIC_PERMISSION_MISSING", "MIC_IN_USE", "NETWORK_UNAVAILABLE", "KEYGUARD_BLOCKED", "OVERLAY_PERMISSION_MISSING", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason HOST_STATE_MISSING = null;
        public static final Reason IN_CALL = null;
        public static final Reason KEYGUARD_BLOCKED = null;
        public static final Reason MIC_IN_USE = null;
        public static final Reason MIC_PERMISSION_MISSING = null;
        public static final Reason NETWORK_UNAVAILABLE = null;
        public static final Reason NONE = null;
        public static final Reason NOT_LOGGED_IN = null;
        public static final Reason OVERLAY_PERMISSION_MISSING = null;
        public static final Reason SCREEN_LANDSCAPE = null;
        public static final Reason SCREEN_OFF_DISABLED = null;
        public static final Reason USER_GUIDE_NOT_COMPLETED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f385454a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f385455b = null;

        public static EnumEntries<Reason> getEntries() {
            return f385455b;
        }

        static {
            Reason r100 = new Reason(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Reason r101 = new Reason("HOST_STATE_MISSING", 1);
            HOST_STATE_MISSING = r101;
            Reason r102 = new Reason("NOT_LOGGED_IN", 2);
            NOT_LOGGED_IN = r102;
            Reason r103 = new Reason("USER_GUIDE_NOT_COMPLETED", 3);
            USER_GUIDE_NOT_COMPLETED = r103;
            Reason r104 = new Reason("SCREEN_OFF_DISABLED", 4);
            SCREEN_OFF_DISABLED = r104;
            Reason r105 = new Reason("SCREEN_LANDSCAPE", 5);
            SCREEN_LANDSCAPE = r105;
            Reason r110 = new Reason("IN_CALL", 6);
            IN_CALL = r110;
            Reason r111 = new Reason("MIC_PERMISSION_MISSING", 7);
            MIC_PERMISSION_MISSING = r111;
            Reason r112 = new Reason("MIC_IN_USE", 8);
            MIC_IN_USE = r112;
            Reason r113 = new Reason("NETWORK_UNAVAILABLE", 9);
            NETWORK_UNAVAILABLE = r113;
            Reason r114 = new Reason("KEYGUARD_BLOCKED", 10);
            KEYGUARD_BLOCKED = r114;
            Reason r115 = new Reason("OVERLAY_PERMISSION_MISSING", 11);
            OVERLAY_PERMISSION_MISSING = r115;
            Reason[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
            f385454a = r106;
            f385455b = EnumEntriesKt.enumEntries(r106);
        }

        public static Reason[] values() {
            return (Reason[]) f385454a.clone();
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public Reason(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/precheck/ObricChildListeningPrecheck$Status;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "PASSED", "BLOCKED", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status BLOCKED = null;
        public static final Status NOT_STARTED = null;
        public static final Status PASSED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f385456a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f385457b = null;

        public static EnumEntries<Status> getEntries() {
            return f385457b;
        }

        static {
            Status r100 = new Status("NOT_STARTED", 0);
            NOT_STARTED = r100;
            Status r101 = new Status("PASSED", 1);
            PASSED = r101;
            Status r102 = new Status("BLOCKED", 2);
            BLOCKED = r102;
            Status[] r103 = {r100, r101, r102};
            f385456a = r103;
            f385457b = EnumEntriesKt.enumEntries(r103);
        }

        public static Status[] values() {
            return (Status[]) f385456a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f385458c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f385459d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Status f385460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reason f385461b;

        public static final class a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f385460a == r101.f385460a) goto L12;
            return false;
        L12:
            if (this.f385461b == r101.f385461b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f385460a.hashCode() * 31) + this.f385461b.hashCode();
        }

        public final String toString() {
            return "Result(status=" + this.f385460a + ", reason=" + this.f385461b + ')';
        }

        static {
            f385458c = new b(Status.NOT_STARTED);
            f385459d = new b(Status.PASSED);
        }

        public /* synthetic */ b(Status r100) {
            this(r100, Reason.NONE);
        }

        public b(Status r100, Reason r101) {
            Intrinsics.checkNotNullParameter(r100, "status");
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f385460a = r100;
            this.f385461b = r101;
        }
    }

    static {
    }

    public ObricChildListeningPrecheck() {
        throw null;
    }

    public ObricChildListeningPrecheck(final Context r100) {
        Function0<fba.b> r101 = new fba.a(r100);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "runtimeFactsProvider");
        this.f385453a = r101;
    }
}
