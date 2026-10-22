package ug;

import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEvent;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<DumpedEvent> f549980a;

    /* JADX INFO: renamed from: ug.a$a, reason: collision with other inner class name */
    public static final class C7881a {
    }

    static {
    }

    public a() {
        this.f549980a = new LinkedList();
    }

    public final void a(DumpedEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "dumpedEvent");
        if (this.f549980a.size() < 200) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f549980a.remove(0);
    L8:
        this.f549980a.add(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
