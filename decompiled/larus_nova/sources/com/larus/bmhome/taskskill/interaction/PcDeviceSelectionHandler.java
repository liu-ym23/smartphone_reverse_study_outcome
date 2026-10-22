package com.larus.bmhome.taskskill.interaction;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import bs8.g;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: classes26.dex */
public final class PcDeviceSelectionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f314305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f314306b;

    public interface a {
        void a(PcDevice r100);

        void b(String r100);

        void c(PcDevice r100);
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f314307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f314308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f314309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f314310d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f314307a == r101.f314307a) goto L12;
            return false;
        L12:
            if (this.f314308b == r101.f314308b) goto L15;
            return false;
        L15:
            if (this.f314309c == r101.f314309c) goto L18;
            return false;
        L18:
            if (this.f314310d == r101.f314310d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f314307a * 31) + this.f314308b) * 31) + this.f314309c) * 31) + this.f314310d;
        }

        public final String toString() {
            return "ToastResources(offline=" + this.f314307a + ", needUpgrade=" + this.f314308b + ", controlDisabled=" + this.f314309c + ", verifyFailed=" + this.f314310d + ')';
        }

        public c(int r100) {
            this.f314307a = r100;
            this.f314308b = R.string.larus_dispatch_requires_newer_desktop_doubao_upgrade_cn;
            this.f314309c = R.string.larus_dispatch_open_control_permission_in_desktop_settings_cn;
            this.f314310d = R.string.larus_dispatch_verification_failed_cn;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314311a = null;

        static {
            int[] r100 = new int[PcDeviceUiState.values().length];
            r100[PcDeviceUiState.OFFLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PcDeviceUiState.NEED_UPGRADE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PcDeviceUiState.CONTROL_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PcDeviceUiState.UNAUTHORIZED_AVAILABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f314311a = r100;
        }
    }

    static {
    }

    public PcDeviceSelectionHandler(c r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "toastRes");
        this.f314305a = r100;
        this.f314306b = r101;
    }

    public final void b(Context r110, LifecycleCoroutineScope r111, PcDevice r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "scope");
        Intrinsics.checkNotNullParameter(r112, "device");
        int r100 = d.f314311a[g.b(r112).ordinal()];
        if (r100 == 1) goto L29;
        if (r100 != 2) goto L7;
        s r113 = s.f544207a;
        int r114 = this.f314305a.f314308b;
        r113.getClass();
        s.s(r110, r114);
        return;
    L7:
        if (r100 != 3) goto L9;
        s r115 = s.f544207a;
        int r101 = this.f314305a.f314309c;
        r115.getClass();
        s.s(r110, r101);
        String r116 = r112.getDeviceId();
        if (r116 != null) goto L24;
        r116 = "";
    L24:
        if (StringsKt.isBlank(r116) == false) goto L26;
        FLogger.f375446a.w("PcDeviceSelectionHandler", "[requestEnableControlPermission] empty deviceId");
        return;
    L26:
        TaskModeService.f314424a.e(r116);
        return;
    L9:
        if (r100 == 4) goto L13;
        a r117 = this.f314306b;
        if (r117 == null) goto L35;
        r117.a(r112);
        return;
    L35:
        return;
    L13:
        a r102 = this.f314306b;
        if (r102 == null) goto L17;
        r102.b(r112.getDeviceId());
    L17:
        if (TaskModeService.f314424a.b() == true) goto L19;
        FLogger.f375446a.i("PcDeviceSelectionHandler", "[handleUnauthorizedDeviceClick] skip mfa, deviceId=" + r112.getDeviceId());
        a(r110, r111, r112, "", true);
        return;
    L19:
        FLogger.f375446a.i("PcDeviceSelectionHandler", "[startMfaVerify] deviceId=" + r112.getDeviceId());
        AccountService.f365697a.u(new com.larus.bmhome.taskskill.interaction.a(r112, this, r110, r111));
        return;
    L29:
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == false) goto L33;
        a r118 = this.f314306b;
        if (r118 == null) goto L42;
        r118.a(r112);
        return;
    L42:
        return;
    L33:
        s r119 = s.f544207a;
        int r120 = this.f314305a.f314307a;
        r119.getClass();
        s.s(r110, r120);
    }

    public final void a(Context r110, CoroutineScope r111, PcDevice r112, String r113, boolean r114) {
        String r100 = r112.getDeviceId();
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        if (r113 != null) goto L8;
        String r102 = "";
    L10:
        if (StringsKt.isBlank(r101) == true) goto L17;
        if (r114 == false) goto L13;
    L15:
        BuildersKt.launch$default(r111, null, null, new PcDeviceSelectionHandler$authorizeDevice$1(this, r112, r101, r110, r102, null), 3, null);
        return;
    L13:
        if (StringsKt.isBlank(r102) == false) goto L15;
    L17:
        FLogger.f375446a.w("PcDeviceSelectionHandler", "[authorizeDevice] invalid params, targetDeviceId=" + r101 + ", ticketBlank=" + StringsKt.isBlank(r102));
        a r103 = this.f314306b;
        if (r103 == null) goto L20;
        r103.b(null);
    L20:
        s r104 = s.f544207a;
        int r105 = this.f314305a.f314310d;
        r104.getClass();
        s.s(r110, r105);
        return;
    L8:
        r102 = r113;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }
}
