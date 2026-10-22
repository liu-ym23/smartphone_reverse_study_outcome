package j52;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<h52.c> f497445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497446b;

    public a(int r100) {
        this.f497446b = r100;
        this.f497445a = new ArrayDeque();
    }

    public void a(h52.c r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Queue<h52.c> r103 = this.f497445a;
        int r104 = this.f497446b;
        Intrinsics.checkNotNullParameter(r103, "$this$addWithCheckMaxSize");
        ArrayDeque r105 = (ArrayDeque) r103;
        r105.add(r100);
        if (r105.size() <= r104) goto L12;
        ArrayList r106 = new ArrayList();
        int r107 = r105.size() - r104;
        if (r107 <= 0) goto L16;
        int r108 = 0;
    L7:
        if (r108 >= r107) goto L17;
        Object r109 = r105.poll();
        if (r109 == null) goto L11;
        r106.add(r109);
    L11:
        r108 = r108 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    }
}
