package qvb;

import com.larksuite.framework.utils.NetworkUtils;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.i;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f534934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<C7398a> f534935b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f534936c = null;

    /* JADX INFO: renamed from: qvb.a$a, reason: collision with other inner class name */
    public static final class C7398a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f534937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MmRecordingCommonParam f534938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f534939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f534940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecordingSessionType f534941e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7398a) == true) goto L8;
            return false;
        L8:
            C7398a r101 = (C7398a) r100;
            if (Intrinsics.areEqual(this.f534937a, r101.f534937a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f534938b, r101.f534938b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f534939c, r101.f534939c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f534940d, r101.f534940d) == true) goto L21;
            return false;
        L21:
            if (this.f534941e == r101.f534941e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f534937a.hashCode() * 31) + this.f534938b.hashCode()) * 31) + this.f534939c.hashCode()) * 31) + this.f534940d.hashCode()) * 31;
            RecordingSessionType r101 = this.f534941e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "AlertContext(sessionId=" + this.f534937a + ", commonParam=" + this.f534938b + ", conversationId=" + this.f534939c + ", messageId=" + this.f534940d + ", sessionType=" + this.f534941e + ')';
        }

        public C7398a(String r100, MmRecordingCommonParam r101, String r102, String r103, RecordingSessionType r104) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, "commonParam");
            Intrinsics.checkNotNullParameter(r102, "conversationId");
            Intrinsics.checkNotNullParameter(r103, "messageId");
            this.f534937a = r100;
            this.f534938b = r101;
            this.f534939c = r102;
            this.f534940d = r103;
            this.f534941e = r104;
        }
    }

    public a() {
    }

    static {
        f534934a = new a();
        f534935b = new AtomicReference(null);
        f534936c = SetsKt.setOf(new String[]{"rtc", "audio", "upload"});
    }

    public final void h(String r110) {
        if (r110 != null) goto L5;
        String r100 = "";
    L6:
        c(this, "subtitle", "error", null, r100, null, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6132);
        return;
    L5:
        r100 = r110;
        goto L6
    }

    public static void a(String r100, MmRecordingCommonParam r101, DoubaoBizInfo r110, RecordingSessionType r111) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "commonParam");
        AtomicReference<C7398a> r102 = f534935b;
        String r103 = null;
        if (r110 == null) goto L5;
        String r104 = r110.getConversationId();
    L7:
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        if (r110 == null) goto L12;
        r103 = r110.getMessageId();
    L12:
        if (r103 != null) goto L14;
        String r106 = "";
    L15:
        r102.set(new C7398a(r100, r101, r105, r106, r111));
        return;
    L14:
        r106 = r103;
        goto L15
    L9:
        r105 = r104;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public static void g(String r110, String r111, String r112, int r113) {
        a r100 = f534934a;
        if ((r113 & 4) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r102 = "error";
    L10:
        Intrinsics.checkNotNullParameter(r110, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "responseName");
        Intrinsics.checkNotNullParameter(r102, "severity");
        c(r100, "state_sync", r102, null, r110, r101, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
        return;
    L9:
        r102 = r112;
        goto L10
    L5:
        r101 = r111;
        goto L7
    }

    public final void d(Integer r110, String r111, String r112, String r210) {
        Intrinsics.checkNotNullParameter(r111, "errorMsg");
        Intrinsics.checkNotNullParameter(r112, "responseName");
        Intrinsics.checkNotNullParameter(r210, "severity");
        c(this, "entry", r210, r110, r111, r112, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
    }

    public static void b(Integer r110, String r111, String r112, String r113, int r114) {
        a r100 = f534934a;
        if ((r114 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r114 & 8) == 0) goto L13;
        String r103 = "error";
    L14:
        Intrinsics.checkNotNullParameter(r111, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "responseName");
        Intrinsics.checkNotNullParameter(r103, "severity");
        c(r100, "audio", r103, r101, r111, r102, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), null, 6112);
        return;
    L13:
        r103 = r113;
        goto L14
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static /* synthetic */ void e(Integer r100, String r101, String r102, String r103, int r104) {
        a r105 = f534934a;
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "warn";
    L11:
        r105.d(r100, r101, r102, r103);
    }

    public final void f(String r110, Integer r111, Integer r112, String r210, Integer r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "requestPath");
        Intrinsics.checkNotNullParameter(r212, "errorMessage");
        boolean r100 = NetworkUtils.d(LarkContext.getApplication());
        if (r210 != null) goto L5;
        String r113 = "";
    L6:
        c(this, "request", "error", null, null, null, r110, r111, r112, r113, r211, r212, Boolean.valueOf(r100), null, 4124);
        return;
    L5:
        r113 = r210;
        goto L6
    }

    public static void c(a r310, String r311, String r312, Integer r313, String r314, String r315, String r316, Integer r410, Integer r411, String r412, Integer r413, String r414, Boolean r415, Long r416, int r417) {
        if ((r417 & 4) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r417 & 8) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r417 & 16) == 0) goto L13;
        String r110 = "";
    L15:
        if ((r417 & 32) == 0) goto L17;
        String r102 = "";
    L19:
        if ((r417 & 64) == 0) goto L21;
        Integer r103 = null;
    L23:
        if ((r417 & 128) == 0) goto L25;
        Integer r104 = null;
    L27:
        if ((r417 & 256) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r417 & 512) == 0) goto L33;
        Integer r112 = null;
    L35:
        if ((r417 & 1024) == 0) goto L37;
        String r113 = "";
    L39:
        if ((r417 & 2048) == 0) goto L41;
        Boolean r114 = null;
    L43:
        if ((r417 & 4096) == 0) goto L45;
        Long r115 = null;
    L46:
        r310.getClass();
        C7398a r105 = f534935b.get();
        if (r105 != null) goto L51;
        r105 = new C7398a("", new MmRecordingCommonParam(null, null, false, null, null, null, k0.a(16), null, null, null, null, 1983, null), "", "", null);
        lvb.a.h("MmRecordingErrorTracker", "[createFallbackAlertContext] context missing, fallbackTraceId=" + r105.f534938b.getRecordingTraceId());
    L51:
        if (r105.f534941e == RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L53;
    L55:
        List<String> r106 = i.f435443b;
        MmRecordingCommonParam r107 = r105.f534938b;
        MmRecordingSource r108 = r107.getSource();
        if (r108 == null) goto L58;
        String r109 = r108.getValue();
    L59:
        if (r109 != null) goto L61;
        String r116 = "";
    L62:
        i.a.c(r107, r116, r311, r312, r100, r101, r102, r103, r104, r111, r112, r113, r114, r110, r115, 24576);
        return;
    L61:
        r116 = r109;
        goto L62
    L58:
        r109 = null;
        goto L59
    L53:
        if (f534936c.contains(r311) == true) goto L55;
        lvb.a.e("MmRecordingErrorTracker", "[trackContextException] skip pre-meeting diagnosis, stage=" + r311 + ", errorMsg=" + r101);
        return;
    L45:
        r115 = r416;
        goto L46
    L41:
        r114 = r415;
        goto L43
    L37:
        r113 = r414;
        goto L39
    L33:
        r112 = r413;
        goto L35
    L29:
        r111 = r412;
        goto L31
    L25:
        r104 = r411;
        goto L27
    L21:
        r103 = r410;
        goto L23
    L17:
        r102 = r316;
        goto L19
    L13:
        r110 = r315;
        goto L15
    L9:
        r101 = r314;
        goto L11
    L5:
        r100 = r313;
        goto L7
    }
}
