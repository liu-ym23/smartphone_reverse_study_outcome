package vp;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tp.b f556541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<tp.c> f556542b;

    @Override // tp.c
    public final void B() {
        Iterator<T> r100 = this.f556542b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tp.c) r100.next()).stopPlay();
        goto L4
    }

    @Override // tp.c
    public final boolean D3() {
        List<tp.c> r100 = this.f556542b;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((tp.c) r101.next()).D3() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    @Override // tp.c
    public final void R() {
        Iterator<T> r100 = this.f556542b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tp.c) r100.next()).startPlay();
        goto L4
    }

    @Override // tp.c
    public final boolean g0() {
        Iterator<T> r100 = this.f556542b.iterator();
    L3:
        boolean r101 = false;
    L5:
        if (r100.hasNext() == false) goto L10;
        if (((tp.c) r100.next()).resumePlay() == true) goto L9;
        if (r101 == false) goto L3;
    L9:
        r101 = true;
        goto L5
    L10:
        return r101;
    }

    @Override // tp.c
    public final boolean isPlaying() {
        List<tp.c> r100 = this.f556542b;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((tp.c) r101.next()).isPlaying() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    @Override // tp.c
    public final void v() {
        Iterator<T> r100 = this.f556542b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tp.c) r100.next()).pausePlay();
        goto L4
    }

    @Override // tp.c
    public final tp.b m() {
        return this.f556541a;
    }

    public b(List<tp.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "playableList");
        this.f556542b = r100;
    }

    @Override // tp.c
    public final List<tp.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = this.f556542b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        d.a(r100, (tp.c) r102.next(), r101);
        goto L4
    L6:
        dm.a.a("测试播放").a("list 寻找可播放组件：" + r101.size());
        return r101;
    }

    @Override // tp.c
    public final void o2(tp.b r100) {
        this.f556541a = r100;
        Iterator<T> r101 = this.f556542b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((tp.c) r101.next()).o2(r100);
        goto L4
    }
}
