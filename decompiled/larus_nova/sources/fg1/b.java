package fg1;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements s00.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d f476788a;

    @Override // s00.c
    public final void run() {
        dg1.a r100 = this.f476788a.f105452i;
        r100.getClass();
        Iterator<T> r101 = eg1.a.f472603a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        hs1.c r102 = (hs1.c) r101.next();
        r102.getClass();
        r100.a(new hs1.b(r102));
        goto L4
    }

    @Override // s00.c
    public final r00.a getName() {
        return k.b.f476798a;
    }

    public b(com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f476788a = r100;
    }
}
