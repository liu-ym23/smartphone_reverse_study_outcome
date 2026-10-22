package nr1;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.helper.EnterRoomTimeTracer;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements wr1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnterRoomTimeTracer f520167a;

    @Override // wr1.d
    public final void cancelTrace() {
        this.f520167a.p();
    }

    @Override // wr1.d
    public final void f() {
        this.f520167a.f106384k = PaidReplayConstants.VALUE_FROM_CONTENT_TYPE;
    }

    public b(EnterRoomTimeTracer r100) {
        Intrinsics.checkNotNullParameter(r100, "enterRoomTimeTracer");
        this.f520167a = r100;
    }

    @Override // wr1.d
    public final void a(boolean r100) {
        this.f520167a.f106390q = r100;
    }

    @Override // wr1.d
    public final void b(Bundle r100) {
        this.f520167a.q(r100);
    }

    @Override // wr1.d
    public final void c(Map<String, String> r100) {
        this.f520167a.f106389p = r100;
    }

    @Override // wr1.d
    public final void e(Map<String, String> r100) {
        this.f520167a.n(0, r100, null);
    }

    @Override // wr1.d
    public final long g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventNameString");
        EnterRoomTimeTracer.EventName r101 = EnterRoomTimeTracer.EventName.valueOf(r100);
        EnterRoomTimeTracer.a r102 = this.f520167a.f106379f.get(r101.ordinal());
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.f106402b;
    }

    @Override // wr1.d
    public final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "eventNameString");
        EnterRoomTimeTracer.EventName r102 = EnterRoomTimeTracer.EventName.valueOf(r100);
        this.f520167a.m(r102, r101);
    }
}
