package ry1;

import android.graphics.Rect;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import com.lynx.serval.svg.SVGRenderEngine;
import j80.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements DraggableContainerView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j80.d f539884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f539885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<? extends RegionId, j80.d> f539886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Pair<? extends RegionId, j80.d> f539887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner f539888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DraggableContainerView f539889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c<ry1.b> f539890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f539891h;

    /* JADX INFO: renamed from: ry1.a$a, reason: collision with other inner class name */
    public static final class C7548a {
    }

    public interface b {
        void a(Pair<? extends RegionId, j80.d> r100);

        void b(Pair<? extends RegionId, j80.d> r100);

        void c(RegionId r100);
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView.b
    public final void a() {
        this.f539888e.a(Boolean.FALSE);
        jy0.b.a("DragCallback", "onDragStop, lastPosition=" + this.f539887d);
        jy0.b.a("DragCallback", "onDragStop, distance=(" + this.f539886c + ", " + this.f539887d + ')');
        Pair<? extends RegionId, j80.d> r100 = this.f539886c;
        j80.d r101 = null;
        if (r100 == null) goto L5;
        RegionId r102 = r100.getFirst();
    L6:
        Pair<? extends RegionId, j80.d> r103 = this.f539887d;
        if (r103 == null) goto L9;
        RegionId r104 = r103.getFirst();
    L10:
        boolean r105 = true;
        if (r102 != r104) goto L23;
        Pair<? extends RegionId, j80.d> r106 = this.f539886c;
        if (r106 == null) goto L15;
        j80.d r107 = r106.getSecond();
    L16:
        Pair<? extends RegionId, j80.d> r108 = this.f539887d;
        if (r108 == null) goto L20;
        r101 = r108.getSecond();
    L20:
        if ((!Intrinsics.areEqual(r107, r101)) == true) goto L23;
        r105 = false;
        goto L23
    L15:
        r107 = null;
    L23:
        jy0.b.a("DragCallback", "onDragStop, hasPositionChange=(" + r105 + ')');
        b r109 = this.f539891h;
        if (r109 == null) goto L27;
        r109.a(this.f539887d);
        return;
    L27:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView.b
    public final void onDragStart() {
        this.f539884a = j80.b.a(this.f539889f);
        Iterator r100 = this.f539890g.f539895a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ry1.b r101 = (ry1.b) r100.next();
        d.a(r101.f539894c, r101.f539892a);
        goto L4
    L6:
        d.a(this.f539889f, this.f539885b);
        Rect r102 = this.f539885b;
        Pair<ry1.b, Rect> r103 = c(r102, r102);
        if (r103 == null) goto L9;
        Pair<? extends RegionId, j80.d> r104 = TuplesKt.to(r103.getFirst().f539893b, r103.getFirst().c(r103.getSecond()));
    L10:
        this.f539886c = r104;
        jy0.b.a("DragCallback", "onDragStart, startPosition=" + this.f539886c);
        this.f539888e.a(Boolean.TRUE);
        b r105 = this.f539891h;
        if (r105 == null) goto L15;
        r105.b(this.f539886c);
        return;
    L15:
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView.b
    public final void b(j80.d r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        this.f539884a = j80.c.e(this.f539884a, r100);
        d.a(this.f539889f, this.f539885b);
        Rect r101 = new Rect(this.f539885b);
        j80.b.d(r101, j80.c.f(this.f539884a));
        Pair<ry1.b, Rect> r102 = c(this.f539885b, r101);
        if (r102 == null) goto L18;
        ry1.b r103 = r102.component1();
        Rect r104 = r102.component2();
        j80.d r105 = j80.c.h(j80.b.b(r104));
        j80.d r106 = r103.c(r104);
        j80.b.e(this.f539889f, r105);
        Pair<? extends RegionId, j80.d> r107 = TuplesKt.to(r103.f539893b, r106);
        Pair<? extends RegionId, j80.d> r108 = this.f539887d;
        if (r108 != null) goto L7;
        r108 = this.f539886c;
    L7:
        if (r108 == null) goto L9;
        RegionId r109 = r108.getFirst();
    L11:
        if (r109 == r107.getFirst()) goto L17;
        jy0.b.a("DragCallback", "onDragMove, region Change, last:" + r108 + ", current:" + r107);
        b r110 = this.f539891h;
        if (r110 == null) goto L17;
        if (r108 == null) goto L16;
        RegionId r111 = r108.getFirst();
    L16:
        r110.c(r107.getFirst());
    L17:
        this.f539887d = r107;
        goto L18
    L9:
        r109 = null;
    L18:
        StringBuilder r112 = new StringBuilder("onDragMove, real move = ");
        if (r102 == null) goto L21;
        boolean r113 = true;
    L22:
        r112.append(r113);
        r112.append(", lastPosition = ");
        r112.append(this.f539887d);
        jy0.b.a("DragCallback", r112.toString());
        return;
    L21:
        r113 = false;
        goto L22
    }

    public final Pair<ry1.b, Rect> c(Rect r110, Rect r111) {
        e r100 = j80.c.c(j80.b.b(r111), j80.b.b(r110));
        float r101 = j80.c.d(j80.c.h(r100));
        c<ry1.b> r102 = this.f539890g;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, SVGRenderEngine.RECT);
        HashSet r103 = r102.f539895a;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if (((c.a) r106).a().contains(r110) == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        Iterator r107 = r104.iterator();
        Object r108 = null;
        float r109 = Float.MIN_VALUE;
        Pair<ry1.b, Rect> r112 = null;
    L10:
        if (r107.hasNext() == false) goto L17;
        ry1.b r113 = (ry1.b) r107.next();
        if (r113.f539892a.contains(r111) == true) goto L13;
        Rect r114 = r113.b(r111);
        float r115 = j80.c.g(j80.c.c(j80.b.b(r114), j80.b.b(r110)), r100) / r101;
        if (r115 <= r109) goto L10;
        r112 = TuplesKt.to(r113, r114);
        r109 = r115;
        goto L10
    L13:
        r112 = TuplesKt.to(r113, new Rect(r111));
    L17:
        if (r112 != null) goto L52;
        j80.d r116 = j80.c.h(j80.b.b(r110));
        HashSet r117 = this.f539890g.f539895a;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r119 = r117.iterator();
    L20:
        if (r119.hasNext() == false) goto L22;
        ry1.b r120 = (ry1.b) r119.next();
        r118.add(TuplesKt.to(r120, r120.b(r110)));
        goto L20
    L22:
        Iterator r121 = r118.iterator();
        if (r121.hasNext() == false) goto L34;
        r108 = r121.next();
        if (r121.hasNext() == false) goto L34;
        float r122 = j80.c.a(r116, j80.c.h(j80.b.b((Rect) ((Pair) r108).component2())));
    L29:
        Object r123 = r121.next();
        float r124 = j80.c.a(r116, j80.c.h(j80.b.b((Rect) ((Pair) r123).component2())));
        if (Float.compare(r122, r124) <= 0) goto L33;
        r108 = r123;
        r122 = r124;
    L33:
        if (r121.hasNext() == true) goto L29;
    L34:
        Pair r125 = (Pair) r108;
        if (r125 != null) goto L37;
        return r112;
    L37:
        return TuplesKt.to((ry1.b) r125.component1(), (Rect) r125.component2());
    L52:
        return r112;
    }

    public a(DraggableContainerView r100, c r101, vy1.c r102) {
        Intrinsics.checkNotNullParameter(r100, "draggableView");
        Intrinsics.checkNotNullParameter(r101, "regionManager");
        this.f539889f = r100;
        this.f539890g = r101;
        this.f539891h = r102;
        this.f539884a = new j80.d(0.0f, 0.0f);
        this.f539885b = new Rect();
        this.f539888e = new PropertyOwner(Boolean.FALSE);
    }
}
