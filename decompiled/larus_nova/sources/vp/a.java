package vp;

import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import com.bytedance.android.ec.window.base.utils.playable.impl.video.f;
import com.bytedance.android.shopping.extensions.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.ec.window.base.utils.playable.controller.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<tp.c> f556536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C8029a f556537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<WindowPlayAbleType, Integer> f556538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<WindowPlayAbleType, Integer> f556539d;

    /* JADX INFO: renamed from: vp.a$a, reason: collision with other inner class name */
    public static final class C8029a extends tp.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f556540a;

        public C8029a(a r100) {
            this.f556540a = r100;
        }

        @Override // tp.b
        public final void b(f r100) {
            Intrinsics.checkNotNullParameter(r100, "playable");
            Intrinsics.checkNotNullParameter(r100, "playable");
            a r101 = this.f556540a;
            WindowPlayAbleType r102 = WindowPlayAbleType.VIDEO;
            Iterator r103 = ((ArrayList) r101.f556536a).iterator();
            int r104 = 0;
        L4:
            if (r103.hasNext() == false) goto L9;
            if (Intrinsics.areEqual((tp.c) r103.next(), r100) == true) goto L10;
            r104 = r104 + 1;
        L10:
            tp.c r105 = null;
            if (r104 == (-1)) goto L21;
        L13:
            r104 = r104 + 1;
            if (r104 >= ((ArrayList) r101.f556536a).size()) goto L21;
            tp.c r106 = (tp.c) CollectionsKt.getOrNull(r101.f556536a, r104);
            if (r106 == null) goto L18;
            WindowPlayAbleType r107 = r106.P();
        L19:
            if (r107 != r102) goto L13;
            r105 = r106;
            goto L21
        L18:
            r107 = null;
        L21:
            if (r105 == null) goto L31;
            r105.startPlay();
            return;
        L31:
            return;
        L9:
            r104 = -1;
            goto L10
        }
    }

    @Override // com.bytedance.android.ec.window.base.utils.playable.controller.a
    public final List<tp.c> a() {
        return CollectionsKt.toList(this.f556536a);
    }

    @Override // com.bytedance.android.ec.window.base.utils.playable.controller.a
    public final void b() {
        Iterator<T> r100 = this.f556536a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((tp.c) r100.next()).pausePlay();
        goto L4
    }

    @Override // com.bytedance.android.ec.window.base.utils.playable.controller.a
    public final boolean d() {
        Iterator<T> r100 = this.f556536a.iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L17;
        tp.c r102 = (tp.c) r100.next();
        if (r102.D3() == true) goto L10;
        if (r101 == true) goto L10;
        r101 = false;
    L12:
        if (r102.D3() == true) goto L13;
        if (r102.P() == WindowPlayAbleType.VIDEO) goto L4;
        r102.startPlay();
        goto L4
    L13:
        r102.resumePlay();
    L10:
        r101 = true;
        goto L12
    L17:
        return r101;
    }

    @Override // com.bytedance.android.ec.window.base.utils.playable.controller.a
    public final void f() {
        Iterator<T> r100 = this.f556536a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        tp.c r101 = (tp.c) r100.next();
        r101.stopPlay();
        r101.o2(null);
        goto L4
    L6:
        ((ArrayList) this.f556536a).clear();
    }

    public a() {
        this.f556536a = new ArrayList();
        this.f556537b = new C8029a(this);
        this.f556538c = MapsKt.mapOf(new Pair[]{TuplesKt.to(WindowPlayAbleType.VIDEO, 1), TuplesKt.to(WindowPlayAbleType.OTHER, Integer.MAX_VALUE)});
        LinkedHashMap r100 = new LinkedHashMap();
        WindowPlayAbleType[] r101 = WindowPlayAbleType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r101[r103], 0);
        r103 = r103 + 1;
        goto L3
    L5:
        Unit r104 = Unit.INSTANCE;
        this.f556539d = r100;
    }

    @Override // com.bytedance.android.ec.window.base.utils.playable.controller.a
    public final void c() {
        f();
    }

    @Override // com.bytedance.android.ec.window.base.utils.playable.controller.a
    public final void e(List<? extends tp.c> r100, List<? extends tp.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "playableList");
        Intrinsics.checkNotNullParameter(r101, "excludedPlayableList");
        ((ArrayList) this.f556536a).clear();
        ArrayList r102 = (ArrayList) this.f556536a;
        r102.addAll(r100);
        Iterator r103 = ((LinkedHashMap) this.f556539d).keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        WindowPlayAbleType r104 = (WindowPlayAbleType) r103.next();
        this.f556539d.put(r104, 0);
        goto L4
    L6:
        List<? extends tp.c> r105 = r101;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        tp.c r107 = (tp.c) r106.next();
        if (r107.isPlaying() == false) goto L8;
        Map<WindowPlayAbleType, Integer> r108 = this.f556539d;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        int r110 = k.f((Integer) r109.get(r107.P()));
        this.f556539d.put(r107.P(), Integer.valueOf(r110 + 1));
        goto L8
    L12:
        Iterator<T> r111 = r105.iterator();
    L14:
        if (r111.hasNext() == false) goto L16;
        ((tp.c) r111.next()).o2(this.f556537b);
        goto L14
    L16:
        Iterator<T> r112 = r100.iterator();
    L18:
        if (r112.hasNext() == false) goto L29;
        tp.c r113 = (tp.c) r112.next();
        r113.o2(this.f556537b);
        if (r101.contains(r113) == true) goto L18;
        if (r113.isPlaying() == true) goto L18;
        WindowPlayAbleType r114 = r113.P();
        int r115 = k.f(this.f556538c.get(r114));
        if (k.f((Integer) ((LinkedHashMap) this.f556539d).get(r114)) >= r115) goto L26;
        this.f556539d.put(r114, Integer.valueOf(r115 + 1));
        boolean r116 = true;
    L27:
        if (r116 == false) goto L18;
        r113.startPlay();
        goto L18
    L26:
        r116 = false;
        goto L27
    }
}
