package nr1;

import com.bytedance.android.livesdk.chatroom.monitor.e;
import kotlin.jvm.internal.Intrinsics;
import vr1.b0;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f520169a;

    @Override // vr1.b0
    public final void b() {
        e r100 = this.f520169a;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    @Override // vr1.b0
    public final void stop() {
        e r100 = this.f520169a;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    public d() {
        this.f520169a = com.bytedance.android.livesdk.chatroom.monitor.a.a();
    }

    @Override // vr1.b0
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaName");
        e r101 = this.f520169a;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }
}
