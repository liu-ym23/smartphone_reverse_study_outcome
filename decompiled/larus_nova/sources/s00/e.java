package s00;

import com.bytedance.android.live.core.log.ALogger;
import fg1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class e extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f540007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r00.a f540008c;

    @Override // s00.c
    public final r00.a getName() {
        return this.f540008c;
    }

    public e(k r100) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        this.f540008c = r100;
    }

    @Override // s00.b
    public final f a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        if (this.f540007b == false) goto L7;
        return f.c.f540010a;
    L7:
        return f.b.f540009a;
    }

    public final void b(r00.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        ALogger.i("KeyNodeCheckTask", "KeyNodeCheckTask " + this.f540008c + " onTrigger.");
        this.f540007b = true;
        r100.b(this);
    }
}
