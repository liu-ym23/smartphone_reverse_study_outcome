package hm9;

import com.larus.apm.api.IApmTrace;
import com.larus.network.interceptor.http.DoraTaskStatus;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.larus.platform.api.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f485957a = null;

    static {
        f485957a = new f();
    }

    public f() {
    }

    @Override // com.larus.platform.api.o
    public final void a(int r100) {
    }

    @Override // com.larus.platform.api.o
    public final void onStateChange(int r100) {
        if (r100 != 1) goto L5;
    L10:
        FLogger.f375446a.j("Dora call", "Dora WAKE_OFF or DISCONNECTED");
        IApmTrace.f286937a.e("DORA_QUERY");
        s r101 = j.f485966h;
        DoraTaskStatus r102 = DoraTaskStatus.WAKE_OFF_OR_DISCONNECTED;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f485992v = r102;
    L11:
        j.f485959a.b();
        return;
    L5:
        if (r100 != 2) goto L7;
        FLogger.f375446a.j("Dora call", "Dora WAKE_UP");
        IApmTrace.f286937a.g("DORA_QUERY");
        s r103 = j.f485966h;
        DoraTaskStatus r104 = DoraTaskStatus.WAKE_UP;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f485992v = r104;
        goto L11
    L7:
        if (r100 == 4) goto L10;
        FLogger.f375446a.j("Dora call", "Dora " + r100);
        goto L11
    }
}
