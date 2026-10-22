package xl1;

import com.bytedance.android.livesdk.chatroom.replay.paid.c;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f564435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564436c;

    public final void a() {
        Iterator<T> r100 = this.f564435b.a(this.f564436c).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c.a) r100.next()).a();
        goto L4
    }

    public final void b() {
        Iterator<T> r100 = this.f564435b.a(this.f564436c).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c.a) r100.next()).b();
        goto L4
    }

    public b(int r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "replayPaidStateHolder");
        this.f564435b = r101;
        this.f564436c = r100;
    }
}
