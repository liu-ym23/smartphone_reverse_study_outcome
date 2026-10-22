package nn;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ln.b f519619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ln.c> f519620b;

    @Override // ln.c
    public final void B() {
        Iterator<T> r100 = this.f519620b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ln.c) r100.next()).stopPlay();
        goto L4
    }

    @Override // ln.c
    public final void R() {
        Iterator<T> r100 = this.f519620b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ln.c) r100.next()).startPlay();
        goto L4
    }

    @Override // ln.c
    public final boolean isPlaying() {
        List<ln.c> r100 = this.f519620b;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((ln.c) r101.next()).isPlaying() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    @Override // ln.c
    public final void v() {
        Iterator<T> r100 = this.f519620b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ln.c) r100.next()).pausePlay();
        goto L4
    }

    @Override // ln.c
    public final ln.b m() {
        return this.f519619a;
    }

    public a(List<ln.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "playableList");
        this.f519620b = r100;
    }

    @Override // ln.c
    public final List<ln.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = this.f519620b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        c.a(r100, (ln.c) r102.next(), r101);
        goto L4
    L6:
        dm.a.a("测试播放").a("list 寻找可播放组件：" + r101.size());
        return r101;
    }

    @Override // ln.c
    public final void k1(e.a r100) {
        this.f519619a = r100;
        Iterator<T> r101 = this.f519620b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((ln.c) r101.next()).k1(r100);
        goto L4
    }
}
