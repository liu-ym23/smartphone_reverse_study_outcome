package dmc;

import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<tlc.d> f469259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, LinkedList<tlc.d>> f469260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, LinkedList<tlc.d>> f469261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f469262d;

    public final void a() {
        int r100 = this.f469262d.f469264a;
        if (r100 != (-1)) goto L5;
        return;
    L5:
        if (r100 <= 0) goto L19;
        int r101 = this.f469259a.size() - this.f469262d.f469264a;
        if (r101 <= 0) goto L24;
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L25;
        if ((!this.f469259a.isEmpty()) == false) goto L18;
        tlc.d r103 = this.f469259a.removeFirst();
        LinkedList<tlc.d> r104 = this.f469260b.get(Integer.valueOf(r103.getIntType()));
        if (r104 == null) goto L15;
        r104.remove(r103);
    L15:
        LinkedList<tlc.d> r105 = this.f469261c.get(r103.getMessageMethod());
        if (r105 == null) goto L18;
        r105.remove(r103);
    L18:
        r102 = r102 + 1;
        goto L9
    L25:
        return;
    L24:
        return;
    }

    public b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "replayBufferConfig");
        this.f469262d = r100;
        this.f469259a = new LinkedList();
        this.f469260b = new HashMap();
        this.f469261c = new HashMap();
    }
}
