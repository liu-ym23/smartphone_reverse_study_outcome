package com.obric.audio.enroll.trace;

import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class VoiceEnrollTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f395572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f395573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f395574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f395575d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<a> f395576e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f395577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f395578g = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f395579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f395580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f395581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f395582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f395583e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f395579a, r101.f395579a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f395580b, r101.f395580b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f395581c, r101.f395581c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f395582d, r101.f395582d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f395583e, r101.f395583e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f395579a.hashCode() * 31) + this.f395580b.hashCode()) * 31) + this.f395581c.hashCode()) * 31) + this.f395582d.hashCode()) * 31;
            String r101 = this.f395583e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingEnrollResult(eventName=" + this.f395579a + ", voiceWakeupSwitch=" + this.f395580b + ", audioCollectSwitch=" + this.f395581c + ", isSuccess=" + this.f395582d + ", enterFrom=" + this.f395583e + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "voiceWakeupSwitch");
            Intrinsics.checkNotNullParameter(r102, "audioCollectSwitch");
            Intrinsics.checkNotNullParameter(r103, "isSuccess");
            this.f395579a = r100;
            this.f395580b = r101;
            this.f395581c = r102;
            this.f395582d = r103;
            this.f395583e = r104;
        }
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            CoroutineScope r100 = VoiceEnrollTrace.f395572a;
            Object r101 = VoiceEnrollTrace.f395575d;
            monitor-enter(r101);
            List<a> r102 = VoiceEnrollTrace.f395576e;     // Catch: Throwable -> L15
            if (((ArrayList) r102).isEmpty() == false) goto L7;
            List r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
        L9:
            monitor-exit(r101);
            if (r103.isEmpty() == true) goto L19;
            FLogger.f375446a.i("VoiceEnrollTrace", "report pending enroll results when app foreground, size = " + r103.size());
            BuildersKt.launch$default(VoiceEnrollTrace.f395572a, null, null, new VoiceEnrollTrace$reportPendingEnrollResults$1(r103, null), 3, null);
            return;
        L19:
            return;
        L7:
            List r104 = CollectionsKt.toList(r102);     // Catch: Throwable -> L15
            ((ArrayList) r102).clear();     // Catch: Throwable -> L15
            r103 = r104;
        L15:
            th = move-exception;
            throw th;
        }
    }

    public VoiceEnrollTrace() {
    }

    static {
        f395572a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f395575d = new Object();
        f395576e = new ArrayList();
        f395578g = new b();
    }

    public static final void a(a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("voice_wakeup_switch", r100.f395580b);
        r101.put("audio_collect_switch", r100.f395581c);
        r101.put("is_success", r100.f395582d);
        String r102 = r100.f395583e;
        if (r102 == null) goto L5;
        r101.put("enter_from", r102);
    L5:
        IApplog.f287053a.reportEvent(r100.f395579a, r101);
    }

    public static void c(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "currentPage");
        if (Intrinsics.areEqual(r111, r110) == false) goto L5;
        return;
    L5:
        if (f395574c == true) goto L10;
        BuildersKt.launch$default(f395572a, null, null, new VoiceEnrollTrace$trackEnterPage$1(r110, r111, r112, null, null), 3, null);
        return;
    }

    public static void d(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "currentPage");
        FLogger.f375446a.i("VoiceEnrollTrace", "trackPageClick, currentPage = " + r110 + ", actionType = " + r111 + ", enterFrom = " + r112 + ", extraParams = null");
        if (f395574c == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(f395572a, null, null, new VoiceEnrollTrace$trackPageClick$1(r110, r111, r112, null, null), 3, null);
    }

    public static void b(final String r100, String r101, String r102, String r110, String r111) {
        a r103 = new a(r100, r101, r102, r110, r111);
        AppHost.Companion r104 = AppHost.f326268a;
        if (r104.a().isAppBackground() == true) goto L6;
        BuildersKt.launch$default(f395572a, null, null, new VoiceEnrollTrace$reportEnrollResultWhenForeground$1(r103, null), 3, null);
        return;
    L6:
        Object r105 = f395575d;
        monitor-enter(r105);
        List<a> r112 = f395576e;     // Catch: Throwable -> L16
        CollectionsKt.removeAll(r112, new com.obric.audio.enroll.trace.a(r100));     // Catch: Throwable -> L16
        ((ArrayList) r112).add(r103);     // Catch: Throwable -> L16
        if (f395577f == true) goto L12;
        r104.a().j(f395578g);     // Catch: Throwable -> L16
        f395577f = true;     // Catch: Throwable -> L16
    L12:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r105);
        FLogger.f375446a.i("VoiceEnrollTrace", "delay report " + r100 + " until app foreground");
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
