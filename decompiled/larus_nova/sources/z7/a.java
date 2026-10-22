package z7;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c7.a f570634a;

    @Override // b7.a, b7.b
    public final void onRelease() {
        super.onRelease();
        c7.a r100 = this.f570634a;
        if (r100 == null) goto L8;
        String r101 = r100.getMonitorID();
        if (r101 == null) goto L9;
        ConcurrentHashMap<String, com.bytedance.android.monitorV2.event.c> r102 = e.f570636a;
        Intrinsics.checkNotNullParameter(r101, "monitorID");
        e.f570636a.remove(r101);
        return;
    L9:
        return;
    }

    public a() {
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
        super.onInit(r100);
        this.f570634a = r100;
    }
}
