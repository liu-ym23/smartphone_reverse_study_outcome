package nn;

import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
public final class e extends com.bytedance.android.ec.store.utils.playable.controller.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ln.c> f519623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f519624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<PlayAbleType, Integer> f519625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<PlayAbleType, Integer> f519626d;

    public static final class a extends ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f519627a;

        public a(e r100) {
            this.f519627a = r100;
        }

        @Override // ln.b
        public final void c(ln.c r100) {
            Intrinsics.checkNotNullParameter(r100, "playable");
            Intrinsics.checkNotNullParameter(r100, "playable");
            e r101 = this.f519627a;
            int r102 = 0;
            List r103 = CollectionsKt.listOf(new PlayAbleType[]{PlayAbleType.MAIN_IMAGE, PlayAbleType.VIDEO});
            Iterator r104 = ((ArrayList) r101.f519623a).iterator();
        L4:
            if (r104.hasNext() == false) goto L9;
            if (Intrinsics.areEqual((ln.c) r104.next(), r100) == true) goto L10;
            r102 = r102 + 1;
        L10:
            if (r102 == (-1)) goto L17;
        L12:
            r102 = r102 + 1;
            if (r102 >= ((ArrayList) r101.f519623a).size()) goto L17;
            ln.c r105 = (ln.c) ListProtector.get(r101.f519623a, r102);
            if (r103.contains(r105.P()) == false) goto L12;
        L18:
            if (r105 == null) goto L26;
            r105.startPlay();
            return;
        L26:
            return;
        L17:
            r105 = null;
            goto L18
        L9:
            r102 = -1;
            goto L10
        }
    }

    @Override // com.bytedance.android.ec.store.utils.playable.controller.a
    public final void d() {
    }

    @Override // com.bytedance.android.ec.store.utils.playable.controller.a
    public final List<ln.c> a() {
        return CollectionsKt.toList(this.f519623a);
    }

    @Override // com.bytedance.android.ec.store.utils.playable.controller.a
    public final void b() {
        Iterator<T> r100 = this.f519623a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ln.c) r100.next()).pausePlay();
        goto L4
    }

    @Override // com.bytedance.android.ec.store.utils.playable.controller.a
    public final void f() {
        Iterator r100 = ((ArrayList) this.f519623a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ln.c r101 = (ln.c) r100.next();
        r101.stopPlay();
        r101.k1(null);
        goto L4
    L6:
        ((ArrayList) this.f519623a).clear();
    }

    public e() {
        this.f519623a = new ArrayList();
        this.f519624b = new a(this);
        this.f519625c = MapsKt.mapOf(new Pair[]{TuplesKt.to(PlayAbleType.VIDEO, 1), TuplesKt.to(PlayAbleType.MAIN_IMAGE, 1), TuplesKt.to(PlayAbleType.SELL_POINT, Integer.MAX_VALUE), TuplesKt.to(PlayAbleType.OTHER, Integer.MAX_VALUE)});
        LinkedHashMap r100 = new LinkedHashMap();
        PlayAbleType[] r101 = PlayAbleType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100.put(r101[r103], 0);
        r103 = r103 + 1;
        goto L3
    L5:
        Unit r104 = Unit.INSTANCE;
        this.f519626d = r100;
    }

    @Override // com.bytedance.android.ec.store.utils.playable.controller.a
    public final void c() {
        f();
    }

    @Override // com.bytedance.android.ec.store.utils.playable.controller.a
    public final void e(List<? extends ln.c> r100, List<? extends ln.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "playableList");
        Intrinsics.checkNotNullParameter(r101, "excludedPlayableList");
        ((ArrayList) this.f519623a).clear();
        ArrayList r102 = (ArrayList) this.f519623a;
        r102.addAll(r100);
        Iterator r103 = ((LinkedHashMap) this.f519626d).keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        PlayAbleType r104 = (PlayAbleType) r103.next();
        this.f519626d.put(r104, 0);
        goto L4
    L6:
        List<? extends ln.c> r105 = r101;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        ln.c r107 = (ln.c) r106.next();
        if (r107.isPlaying() == false) goto L8;
        Map<PlayAbleType, Integer> r108 = this.f519626d;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        int r110 = k.f((Integer) r109.get(r107.P()));
        this.f519626d.put(r107.P(), Integer.valueOf(r110 + 1));
        goto L8
    L12:
        Iterator<T> r111 = r105.iterator();
    L14:
        if (r111.hasNext() == false) goto L16;
        ((ln.c) r111.next()).k1(this.f519624b);
        goto L14
    L16:
        Iterator<T> r112 = r100.iterator();
    L18:
        if (r112.hasNext() == false) goto L29;
        ln.c r113 = (ln.c) r112.next();
        r113.k1(this.f519624b);
        if (r101.contains(r113) == true) goto L18;
        if (r113.isPlaying() == true) goto L18;
        PlayAbleType r114 = r113.P();
        int r115 = k.f(this.f519625c.get(r114));
        if (k.f((Integer) ((LinkedHashMap) this.f519626d).get(r114)) >= r115) goto L26;
        this.f519626d.put(r114, Integer.valueOf(r115 + 1));
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
