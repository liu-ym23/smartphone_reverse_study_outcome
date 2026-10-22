package vd0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import xd0.b;
import xd0.c;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f554147g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<xd0.a> f554148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f554149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wd0.b f554150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wd0.a f554151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, List<c>> f554152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f554153f;

    /* JADX INFO: renamed from: vd0.a$a, reason: collision with other inner class name */
    public static final class C7981a {
        public static a a(DataCenter r100) {
            a r101 = null;
            if (r100 == null) goto L5;
            r101 = (a) r100.get("data_live_bg_view_manager", null);
        L5:
            if (r101 == null) goto L7;
            return r101;
        L7:
            a r102 = new a(r100);
            if (r100 == null) goto L10;
            r100.put("data_live_bg_view_manager", r102);
        L10:
            return r102;
        }
    }

    static {
    }

    public final void c() {
        this.f554151d.a(this.f554150c, this.f554148a, this.f554149b);
    }

    public a(DataCenter r100) {
        this.f554153f = r100;
        this.f554148a = new ArrayList();
        this.f554149b = new b();
        this.f554150c = new wd0.b();
        this.f554151d = new wd0.a();
        this.f554152e = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1000, new ArrayList()), TuplesKt.to(2000, new ArrayList()), TuplesKt.to(3000, new ArrayList())});
    }

    public final void d(boolean r100) {
        if ((!Intrinsics.areEqual(this.f554150c.f559276g, Boolean.valueOf(r100))) == false) goto L6;
        this.f554150c.f559276g = Boolean.valueOf(r100);
        this.f554151d.a(this.f554150c, this.f554148a, this.f554149b);
        return;
    }

    public final void e(IRoom r100) {
        wd0.b r101 = this.f554150c;
        r101.f559271b = r100;
        r101.f559270a = this.f554153f;
        this.f554151d.a(r101, this.f554148a, this.f554149b);
    }

    public final void f(int r100) {
        Integer r101 = this.f554150c.f559272c;
        if (r101 != null) goto L6;
    L7:
        wd0.b r102 = this.f554150c;
        r102.f559272c = Integer.valueOf(r100);
        this.f554151d.a(this.f554150c, this.f554148a, this.f554149b);
        return;
    L6:
        if (r101.intValue() != r100) goto L7;
    }

    public final void g(boolean r100) {
        if ((!Intrinsics.areEqual(this.f554150c.f559274e, Boolean.valueOf(r100))) == false) goto L6;
        this.f554150c.f559274e = Boolean.valueOf(r100);
        this.f554151d.a(this.f554150c, this.f554148a, this.f554149b);
        return;
    }

    public final void h(int r100) {
        Integer r101 = this.f554150c.f559273d;
        if (r101 != null) goto L6;
    L7:
        wd0.b r102 = this.f554150c;
        r102.f559273d = Integer.valueOf(r100);
        this.f554151d.a(this.f554150c, this.f554148a, this.f554149b);
        return;
    L6:
        if (r101.intValue() != r100) goto L7;
    }

    public final void a(int r100, zd0.b r101) {
        Intrinsics.checkNotNullParameter(r101, "layerViewGroup");
        Iterator r102 = ((ArrayList) this.f554148a).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((xd0.a) r103).f563272b != r100) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        xd0.a r105 = (xd0.a) r103;
        if (r105 == null) goto L15;
        ((ArrayList) this.f554148a).remove(r105);
    L15:
        List<xd0.a> r106 = this.f554148a;
        ArrayList r107 = (ArrayList) r106;
        r107.add(new xd0.a(r100, r101));
        List<c> r108 = this.f554152e.remove(Integer.valueOf(r100));
        if (r108 == null) goto L21;
        Iterator<T> r109 = r108.iterator();
    L19:
        if (r109.hasNext() == false) goto L28;
        c r110 = (c) r109.next();
        b(r100, r110.f563275a, r110.f563276b);
        goto L19
    L28:
        return;
    L21:
        return;
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }

    public final void b(int r100, int r101, yd0.b r102) {
        Intrinsics.checkNotNullParameter(r102, "bgView");
        Iterator<T> r103 = this.f554148a.iterator();
    L3:
        yd0.c<? extends yd0.b> r104 = null;
        if (r103.hasNext() == false) goto L11;
        Object r105 = r103.next();
        if (((xd0.a) r105).f563272b != r100) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L3;
    L12:
        xd0.a r107 = (xd0.a) r105;
        if (r107 == null) goto L38;
        Iterator<T> r108 = r107.f563271a.iterator();
    L16:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        if (((c) r109).f563275a != r101) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L16;
    L24:
        c r111 = (c) r109;
        if (r111 == null) goto L31;
        Intrinsics.checkNotNullParameter(r111, "subLiveBgLayer");
        ((ArrayList) r107.f563271a).remove(r111);
        yd0.c<? extends yd0.b> r112 = r107.f563273c;
        if ((r112 instanceof yd0.c) == true) goto L29;
        r112 = null;
    L29:
        if (r112 == null) goto L31;
        r112.a(r111.f563276b);
    L31:
        c r113 = new c(r101, r102);
        Intrinsics.checkNotNullParameter(r113, "subLiveBgLayer");
        yd0.c<? extends yd0.b> r114 = r107.f563273c;
        if ((r114 instanceof yd0.c) == false) goto L35;
        r104 = r114;
    L35:
        if (r104 == null) goto L37;
        r104.b(r113.f563276b);
    L37:
        ((ArrayList) r107.f563271a).add(r113);
        return;
    L20:
        r110 = false;
        goto L21
    L23:
        r109 = null;
        goto L24
    L38:
        List<c> r115 = this.f554152e.get(Integer.valueOf(r100));
        if (r115 == null) goto L53;
        r115.add(new c(r101, r102));
        return;
    L53:
        return;
    L8:
        r106 = false;
        goto L9
    L11:
        r105 = null;
        goto L12
    }
}
