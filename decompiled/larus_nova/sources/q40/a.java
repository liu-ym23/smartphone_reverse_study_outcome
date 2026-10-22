package q40;

import android.graphics.Rect;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements DraggableContainerView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k40.g f531599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f531600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<? extends RegionId, k40.g> f531601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Pair<? extends RegionId, k40.g> f531602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner f531603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DraggableContainerView f531604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q40.c<q40.b> f531605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f531606h;

    /* JADX INFO: renamed from: q40.a$a, reason: collision with other inner class name */
    public static final class C7276a {
    }

    public interface b {
        void a(Pair<? extends RegionId, k40.g> r100);

        void b(Pair<? extends RegionId, k40.g> r100);

        void c(RegionId r100);
    }

    public static final class c implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f531607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair f531608b;

        public c(Pair r100, Pair r101) {
            this.f531607a = r100;
            this.f531608b = r101;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragMove, region Change, last:" + this.f531607a + ", current:" + this.f531608b;
        }
    }

    public static final class d implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f531609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair f531610b;

        public d(a r100, Pair r101) {
            this.f531609a = r100;
            this.f531610b = r101;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            StringBuilder r100 = new StringBuilder("onDragMove, real move = ");
            if (this.f531610b == null) goto L5;
            boolean r101 = true;
        L6:
            r100.append(r101);
            r100.append(", lastPosition = ");
            r100.append(this.f531609a.f531602d);
            return r100.toString();
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class e implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f531611a;

        public e(a r100) {
            this.f531611a = r100;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStart, startPosition=" + this.f531611a.f531601c;
        }
    }

    public static final class f implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f531612a;

        public f(a r100) {
            this.f531612a = r100;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStop, lastPosition=" + this.f531612a.f531602d;
        }
    }

    public static final class g implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f531613a;

        public g(a r100) {
            this.f531613a = r100;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStop, distance=(" + this.f531613a.f531601c + ", " + this.f531613a.f531602d + ')';
        }
    }

    public static final class h implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f531614a;

        public h(boolean r100) {
            this.f531614a = r100;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStop, hasPositionChange=(" + this.f531614a + ')';
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView.b
    public final void a() {
        this.f531603e.a(Boolean.FALSE);
        ALogger.d("DraggableComponentCallback", new f(this));
        ALogger.d("DraggableComponentCallback", new g(this));
        Pair<? extends RegionId, k40.g> r100 = this.f531601c;
        k40.g r101 = null;
        if (r100 == null) goto L5;
        RegionId r102 = r100.getFirst();
    L6:
        Pair<? extends RegionId, k40.g> r103 = this.f531602d;
        if (r103 == null) goto L9;
        RegionId r104 = r103.getFirst();
    L10:
        boolean r105 = true;
        if (r102 != r104) goto L23;
        Pair<? extends RegionId, k40.g> r106 = this.f531601c;
        if (r106 == null) goto L15;
        k40.g r107 = r106.getSecond();
    L16:
        Pair<? extends RegionId, k40.g> r108 = this.f531602d;
        if (r108 == null) goto L20;
        r101 = r108.getSecond();
    L20:
        if ((!Intrinsics.areEqual(r107, r101)) == true) goto L23;
        r105 = false;
        goto L23
    L15:
        r107 = null;
    L23:
        ALogger.d("DraggableComponentCallback", new h(r105));
        b r109 = this.f531606h;
        if (r109 == null) goto L27;
        r109.a(this.f531602d);
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

    @Override // com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView.b
    public final void onDragStart() {
        DraggableContainerView r100 = this.f531604f;
        Intrinsics.checkNotNullParameter(r100, "$this$pos");
        this.f531599a = new k40.g(r100.getX(), r100.getY());
        Iterator r101 = this.f531605g.f531618a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        q40.b r102 = (q40.b) r101.next();
        k40.f.d(r102.f531617c, r102.f531615a);
        goto L4
    L6:
        k40.f.d(this.f531604f, this.f531600b);
        Rect r103 = this.f531600b;
        Pair<q40.b, Rect> r104 = c(r103, r103);
        if (r104 == null) goto L9;
        Pair<? extends RegionId, k40.g> r105 = TuplesKt.to(r104.getFirst().f531616b, r104.getFirst().c(r104.getSecond()));
    L10:
        this.f531601c = r105;
        ALogger.d("DraggableComponentCallback", new e(this));
        this.f531603e.a(Boolean.TRUE);
        b r106 = this.f531606h;
        if (r106 == null) goto L15;
        r106.b(this.f531601c);
        return;
    L15:
        return;
    L9:
        r105 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView.b
    public final void b(k40.g r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        k40.g r101 = this.f531599a;
        Intrinsics.checkNotNullParameter(r101, "$this$plus");
        Intrinsics.checkNotNullParameter(r100, "rhs");
        this.f531599a = new k40.g(r101.a().floatValue() + r100.a().floatValue(), r101.b().floatValue() + r100.b().floatValue());
        k40.f.d(this.f531604f, this.f531600b);
        Rect r102 = new Rect(this.f531600b);
        k40.g r103 = this.f531599a;
        Intrinsics.checkNotNullParameter(r103, "$this$roundToVec2i");
        k40.h r104 = new k40.h(MathKt.roundToInt(r103.a().floatValue()), MathKt.roundToInt(r103.b().floatValue()));
        Intrinsics.checkNotNullParameter(r102, "$this$pos");
        Intrinsics.checkNotNullParameter(r104, "value");
        r102.offsetTo(r104.a().intValue(), r104.b().intValue());
        Pair<q40.b, Rect> r105 = c(this.f531600b, r102);
        if (r105 == null) goto L18;
        q40.b r106 = r105.component1();
        Rect r107 = r105.component2();
        k40.g r108 = k40.f.g(k40.f.b(r107));
        k40.g r109 = r106.c(r107);
        DraggableContainerView r110 = this.f531604f;
        Intrinsics.checkNotNullParameter(r110, "$this$pos");
        Intrinsics.checkNotNullParameter(r108, "value");
        r110.setX(r108.a().floatValue());
        r110.setY(r108.b().floatValue());
        Pair<? extends RegionId, k40.g> r111 = TuplesKt.to(r106.f531616b, r109);
        Pair<? extends RegionId, k40.g> r112 = this.f531602d;
        if (r112 != null) goto L7;
        r112 = this.f531601c;
    L7:
        if (r112 == null) goto L9;
        RegionId r113 = r112.getFirst();
    L11:
        if (r113 == r111.getFirst()) goto L17;
        ALogger.d("DraggableComponentCallback", new c(r112, r111));
        b r114 = this.f531606h;
        if (r114 == null) goto L17;
        if (r112 == null) goto L16;
        RegionId r115 = r112.getFirst();
    L16:
        r114.c(r111.getFirst());
    L17:
        this.f531602d = r111;
        goto L18
    L9:
        r113 = null;
    L18:
        ALogger.d("DraggableComponentCallback", new d(this, r105));
    }

    public final Pair<q40.b, Rect> c(Rect r110, Rect r111) {
        k40.h r100 = k40.f.f(k40.f.b(r111), k40.f.b(r110));
        k40.g r101 = k40.f.g(r100);
        Intrinsics.checkNotNullParameter(r101, "$this$norm2");
        float r102 = (float) Math.sqrt((r101.a().floatValue() * r101.a().floatValue()) + (r101.b().floatValue() * r101.b().floatValue()));
        q40.c<q40.b> r103 = this.f531605g;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, SVGRenderEngine.RECT);
        HashSet r104 = r103.f531618a;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        Object r107 = r106.next();
        if (((q40.c.a) r107).a().contains(r110) == false) goto L4;
        r105.add(r107);
        goto L4
    L8:
        Iterator r108 = r105.iterator();
        Object r109 = null;
        float r112 = Float.MIN_VALUE;
        Pair<q40.b, Rect> r113 = null;
    L10:
        if (r108.hasNext() == false) goto L17;
        q40.b r114 = (q40.b) r108.next();
        if (r114.f531615a.contains(r111) == true) goto L13;
        Rect r115 = r114.b(r111);
        k40.h r116 = k40.f.f(k40.f.b(r115), k40.f.b(r110));
        Intrinsics.checkNotNullParameter(r116, "$this$times");
        Intrinsics.checkNotNullParameter(r100, "rhs");
        float r117 = ((r116.a().intValue() * r100.a().intValue()) + (r116.b().intValue() * r100.b().intValue())) / r102;
        if (r117 <= r112) goto L10;
        r113 = TuplesKt.to(r114, r115);
        r112 = r117;
        goto L10
    L13:
        r113 = TuplesKt.to(r114, new Rect(r111));
    L17:
        if (r113 != null) goto L52;
        k40.g r118 = k40.f.g(k40.f.b(r110));
        HashSet r119 = this.f531605g.f531618a;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L20:
        if (r121.hasNext() == false) goto L22;
        q40.b r122 = (q40.b) r121.next();
        r120.add(TuplesKt.to(r122, r122.b(r110)));
        goto L20
    L22:
        Iterator r123 = r120.iterator();
        if (r123.hasNext() == false) goto L34;
        r109 = r123.next();
        if (r123.hasNext() == false) goto L34;
        float r124 = k40.f.a(r118, k40.f.g(k40.f.b((Rect) ((Pair) r109).component2())));
    L29:
        Object r125 = r123.next();
        float r126 = k40.f.a(r118, k40.f.g(k40.f.b((Rect) ((Pair) r125).component2())));
        if (Float.compare(r124, r126) <= 0) goto L33;
        r109 = r125;
        r124 = r126;
    L33:
        if (r123.hasNext() == true) goto L29;
    L34:
        Pair r127 = (Pair) r109;
        if (r127 != null) goto L37;
        return r113;
    L37:
        return TuplesKt.to((q40.b) r127.component1(), (Rect) r127.component2());
    L52:
        return r113;
    }

    public a(DraggableContainerView r100, q40.c r101, p40.c r102) {
        Intrinsics.checkNotNullParameter(r100, "draggableView");
        Intrinsics.checkNotNullParameter(r101, "regionManager");
        this.f531604f = r100;
        this.f531605g = r101;
        this.f531606h = r102;
        this.f531599a = new k40.g(0.0f, 0.0f);
        this.f531600b = new Rect();
        this.f531603e = new PropertyOwner(Boolean.FALSE);
    }
}
