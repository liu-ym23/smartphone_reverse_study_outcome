package ng1;

import com.bytedance.android.livesdk.chatroom.distribution.preload.PreloadModelState;
import com.bytedance.android.livesdkapi.distribution.InitParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, c> f519047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InitParams f519048c;

    public final void a() {
        og1.c.a("PreloadTaskManager executeAllPreloadTask");
        Iterator<T> r100 = this.f519047b.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((c) r100.next()).b();
        goto L4
    }

    public final void c() {
        og1.c.a("PreloadTaskManager executeRemoveContainerTask");
        Iterator<c> r100 = this.f519047b.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L16;
        c r101 = r100.next();
        if (r101.f519042c != null) goto L8;
    L13:
        boolean r102 = false;
    L14:
        if (r102 != true) goto L4;
        r100.remove();
        goto L4
    L8:
        if (r101.f519045f != PreloadModelState.PENDING_REMOVE) goto L13;
        int r103 = og1.c.f523182a;
        og1.c.a("VirtualContainerPreloadModel invokeRemovePreloadContainerTask , uniqueKey: " + r101.f519040a);
        b r104 = r101.f519042c;
        if (r104 == null) goto L12;
        r104.run();
    L12:
        r102 = true;
        goto L14
    }

    public d(InitParams r100) {
        Intrinsics.checkNotNullParameter(r100, "initParams");
        this.f519048c = r100;
        this.f519046a = 3;
        this.f519047b = new LinkedHashMap();
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        int r101 = og1.c.f523182a;
        og1.c.a("PreloadTaskManager executePreloadTask, uniqueKey:" + r100);
        c r102 = this.f519047b.get(r100);
        if (r102 == null) goto L6;
        r102.b();
        return;
    }
}
