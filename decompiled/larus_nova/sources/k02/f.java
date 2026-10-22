package k02;

import ca0.h;
import ca0.i;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import fr2.i0;
import fr2.p;
import fr2.w;
import fr2.w1;
import fr2.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import or2.j;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f501251e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k02.a f501252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f501253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f501254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f501255d;

    public static final class a {
    }

    public static final class b implements js0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f501256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vc0.a f501257b;

        @Override // js0.b
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
            k02.a r101 = this.f501256a.f501252a;
            p r102 = i0.a(this.f501257b);
            Intrinsics.checkNotNull(r102);
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "livecore");
            r101.f501246a = r102;
        }

        public b(f r100, vc0.a r101) {
            this.f501256a = r100;
            this.f501257b = r101;
        }
    }

    static {
    }

    @Override // ca0.i
    public final boolean d() {
        Intrinsics.checkNotNullParameter("", "exculdeScene");
        Iterator<T> r100 = this.f501254c.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if ((!Intrinsics.areEqual((String) r101, "")) == false) goto L4;
    L9:
        if (r101 != null) goto L16;
        return false;
    L16:
        return true;
    L8:
        r101 = null;
        goto L9
    }

    @Override // ca0.i
    public final boolean f() {
        Intrinsics.checkNotNullParameter("", "scene");
        return this.f501254c.contains("");
    }

    public f() {
        this.f501252a = new k02.a();
        this.f501253b = new c();
        this.f501254c = new LinkedHashSet();
        this.f501255d = new LinkedHashSet();
    }

    @Override // ca0.i
    public final void e(vc0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "livecore");
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new b(this, r100)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("GiftRenderFilterWrapper");
    }

    @Override // ca0.i
    public final void g(boolean r100) {
        if (r100 == false) goto L20;
        k02.a r101 = this.f501252a;
        if (r101.b(false) == true) goto L7;
    L31:
        this.f501254c.clear();
        this.f501255d.clear();
        return;
    L7:
        if (r101.f501247b == false) goto L31;
        p r102 = r101.f501246a;
        if (r102 == null) goto L14;
        w1 r103 = r102.E();
        if (r103 == null) goto L14;
        r103.m(false);
    L14:
        p r104 = r101.f501246a;
        if (r104 == null) goto L19;
        w1 r105 = r104.E();
        if (r105 == null) goto L19;
        r105.release();
    L19:
        r101.f501247b = false;
        r101.f501246a = null;
        goto L31
    L20:
        c r106 = this.f501253b;
        if (r106.f501248a == false) goto L31;
        if (c.b() == false) goto L31;
        or2.e r107 = (or2.e) vh6.c.b(or2.e.class);
        if (r107 == null) goto L30;
        j r108 = r107.getCurrentClient();
        if (r108 == null) goto L30;
        r108.g();
    L30:
        r106.f501248a = false;
        goto L31
    }

    @Override // ca0.i
    public final void h(boolean r100) {
        k02.a r101 = this.f501252a;
        p r102 = r101.f501246a;
        if (r102 == null) goto L5;
        w1 r103 = r102.E();
    L7:
        if (r103 == null) goto L13;
        int r104 = x8.a.f562881a;
        x8.a.d("zsben", "setEffectEnable enable:" + r100, false);
        p r105 = r101.f501246a;
        if (r105 == null) goto L15;
        w1 r106 = r105.E();
        if (r106 == null) goto L16;
        r106.e(r100);
        return;
    L16:
        return;
    L15:
        return;
    L13:
        x8.a.b("zsben", "livecore?.renderFilter is null", false);
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // ca0.i
    public final boolean i(boolean r100) {
        if (r100 == false) goto L11;
        k02.a r101 = this.f501252a;
        if (r101.b(true) == false) goto L11;
        p r102 = r101.f501246a;
        if (r102 == null) goto L11;
        w1 r103 = r102.E();
        if (r103 == null) goto L11;
        return r103.y0();
    L11:
        return false;
    }

    @Override // ca0.i
    public final void j(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter("LiveGrids", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r101 == false) goto L14;
        k02.a r102 = this.f501252a;
        r102.getClass();
        Intrinsics.checkNotNullParameter("LiveGrids", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        if (r102.b(true) == false) goto L30;
        p r103 = r102.f501246a;
        if (r103 == null) goto L23;
        w1 r104 = r103.E();
        if (r104 == null) goto L24;
        w r105 = r104.j0();
        if (r105 == null) goto L25;
        ((y1) r105).e0("LiveGrids", r100);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L30:
        return;
    L14:
        this.f501253b.getClass();
        Intrinsics.checkNotNullParameter("LiveGrids", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        if (c.b() == true) goto L17;
        ALogger.i("zsben", "setRenderCacheStringValue error not init. isInit:" + c.b() + ", isEnable:" + c.a() + ", value:" + r100);
        return;
    L17:
        or2.e r106 = (or2.e) vh6.c.b(or2.e.class);
        if (r106 == null) goto L28;
        j r107 = r106.getCurrentClient();
        if (r107 == null) goto L29;
        r107.j(r100);
        return;
    L29:
        return;
    }

    @Override // ca0.i
    public final void c(String[] r100, h r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r102 == false) goto L11;
        k02.a r103 = this.f501252a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r103.b(true) == true) goto L7;
        r101.onResult(-1);
        return;
    L7:
        r100.toString();
        ca0.b r104 = k02.a.a();
        if (r104 == null) goto L10;
        r104.x(r100);
    L10:
        r101.onResult(0);
        return;
    L11:
        this.f501253b.getClass();
        Intrinsics.checkNotNullParameter(r100, "nodes");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (c.b() == true) goto L14;
    L21:
        r101.onResult(-1);
        return;
    L14:
        if (c.a() == false) goto L21;
        r100.toString();
        String[] r105 = c.c(r100);
        or2.e r106 = (or2.e) vh6.c.b(or2.e.class);
        if (r106 == null) goto L25;
        j r107 = r106.getCurrentClient();
        if (r107 == null) goto L26;
        r107.h(r105, new e(r101));
        return;
    L26:
        return;
    }

    @Override // ca0.i
    public final void k(int r100, int r101, boolean r102) {
        if (r102 == false) goto L18;
        k02.a r103 = this.f501252a;
        if (r103.b(true) == false) goto L24;
        p r104 = r103.f501246a;
        if (r104 == null) goto L9;
        w1 r105 = r104.E();
    L11:
        if (r105 == null) goto L17;
        int r106 = x8.a.f562881a;
        x8.a.d("zsben", "setMixOutput livecore:" + r103.f501246a, false);
        p r107 = r103.f501246a;
        if (r107 == null) goto L20;
        w1 r108 = r107.E();
        if (r108 == null) goto L21;
        r108.M3(r100, r101);
        return;
    L21:
        return;
    L20:
        return;
    L17:
        x8.a.b("zsben", "livecore?.renderFilter is null", false);
        return;
    L9:
        r105 = null;
        goto L11
    L24:
        return;
    L18:
        this.f501253b.getClass();
    }

    @Override // ca0.i
    public final void a(String[] r110, String[] r111, h r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "nodes");
        Intrinsics.checkNotNullParameter(r111, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (r113 == false) goto L18;
        k02.a r114 = this.f501252a;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r110, "nodes");
        Intrinsics.checkNotNullParameter(r111, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (r114.b(true) == true) goto L7;
        r112.onResult(-1);
    L7:
        r110.toString();
        Intrinsics.checkNotNullParameter(r110, "nodes");
        ArrayList r115 = new ArrayList();
        int r100 = r110.length;
        int r101 = 0;
    L8:
        if (r101 >= r100) goto L10;
        r115.add(StringsKt.replace$default(r110[r101], MSkiaImageRegionDecoder.FILE_PREFIX, "", false, 4, null));
        r101 = r101 + 1;
        goto L8
    L10:
        Object[] r116 = r115.toArray(new String[0]);
        if (r116 == null) goto L17;
        String[] r117 = (String[]) r116;
        ca0.b r118 = k02.a.a();
        if (r118 == null) goto L15;
        r118.d(r117, r111);
    L15:
        r112.onResult(0);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L18:
        this.f501253b.getClass();
        Intrinsics.checkNotNullParameter(r110, "nodes");
        Intrinsics.checkNotNullParameter(r111, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (c.b() == true) goto L21;
    L28:
        r112.onResult(-1);
        return;
    L21:
        if (c.a() == false) goto L28;
        r110.toString();
        String[] r119 = c.c(r110);
        or2.e r120 = (or2.e) vh6.c.b(or2.e.class);
        if (r120 == null) goto L32;
        j r121 = r120.getCurrentClient();
        if (r121 == null) goto L33;
        r121.a(r119, r111, new d(r112));
        return;
    L33:
        return;
    }

    @Override // ca0.i
    public final void m(boolean r100, boolean r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "scene");
        if (r100 == false) goto L5;
        this.f501255d.add(r102);
    L10:
        if (r101 == false) goto L27;
        k02.a r104 = this.f501252a;
        if (r104.b(true) == false) goto L31;
        String.valueOf(r100);
        p r105 = r104.f501246a;
        if (r105 == null) goto L17;
        w1 r106 = r105.E();
    L19:
        if (r106 == null) goto L25;
        int r107 = x8.a.f562881a;
        x8.a.d("zsben", "singleinput livecore:" + r104.f501246a, false);
        p r108 = r104.f501246a;
        if (r108 == null) goto L28;
        w1 r109 = r108.E();
        if (r109 == null) goto L29;
        r109.m(r100);
        return;
    L29:
        return;
    L28:
        return;
    L25:
        x8.a.b("zsben", "livecore?.renderFilter is null", false);
        return;
    L17:
        r106 = null;
        goto L19
    L31:
        return;
    L27:
        return;
    L5:
        if (r103 == false) goto L7;
        this.f501255d.clear();
        goto L10
    L7:
        this.f501255d.remove(r102);
        if ((!this.f501255d.isEmpty()) == false) goto L10;
    }

    @Override // ca0.i
    public final void b(int r100, int r101, int r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "arg3");
        if (r104 == false) goto L10;
        k02.a r105 = this.f501252a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r103, "arg3");
        if (r105.b(true) == false) goto L26;
        ca0.b r106 = k02.a.a();
        if (r106 == null) goto L21;
        r106.j(r100, r101, r102, r103);
        return;
    L21:
        return;
    L26:
        return;
    L10:
        this.f501253b.getClass();
        Intrinsics.checkNotNullParameter(r103, "arg3");
        if (c.b() == true) goto L13;
        return;
    L13:
        if (c.a() == false) goto L27;
        or2.e r107 = (or2.e) vh6.c.b(or2.e.class);
        if (r107 == null) goto L24;
        j r108 = r107.getCurrentClient();
        if (r108 == null) goto L25;
        r108.sendMessage(r100, r101, r102, r103);
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // ca0.i
    public final void l(boolean r100, ca0.f r101, h r102, boolean r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r104, "scene");
        if (r100 == false) goto L5;
        this.f501254c.add(r104);
    L11:
        w1 r106 = null;
        if (r103 == false) goto L39;
        k02.a r107 = this.f501252a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r101 == null) goto L16;
        r107.getClass();
    L16:
        p r108 = r107.f501246a;
        if (r108 == null) goto L19;
        r106 = r108.E();
    L19:
        if (r100 == true) goto L24;
        if (r107.b(true) == true) goto L24;
        r102.onResult(-1);
        return;
    L24:
        if (r107.b(true) == true) goto L36;
        ca0.b r109 = k02.a.a();
        if (r109 == null) goto L28;
        r109.h(new k02.b());
    L28:
        ca0.b r110 = k02.a.a();
        if (r110 == null) goto L31;
        r110.g();
    L31:
        r107.f501247b = true;
        if (r106 == null) goto L34;
        r106.l(r100);
    L34:
        r102.onResult(0);
        return;
    L36:
        if (r106 == null) goto L38;
        r106.l(r100);
    L38:
        r102.onResult(0);
        return;
    L39:
        c r111 = this.f501253b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r102, "callback");
        jy0.b.a("GiftPlayerRenderFilter", "setEnable, enable = " + r100 + ", listener = " + r101 + ", callback = " + r102);
        if (r101 == null) goto L42;
        r111.getClass();
    L42:
        boolean r112 = c.b();
        if (r100 == true) goto L46;
        if (r112 == true) goto L46;
        jy0.b.c("GiftPlayerRenderFilter", "setEnable fail because isInit == false and enable == false", null, 4);
        r102.onResult(-1);
        return;
    L46:
        if (r112 == true) goto L51;
        jy0.b.a("GiftPlayerRenderFilter", "isInit == false, begin setup");
        com.bytedance.android.livesdk.revenue.service.effect.c r113 = (com.bytedance.android.livesdk.revenue.service.effect.c) vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        if (r113 == null) goto L50;
        r113.providerResourceFinder();
    L50:
        jy0.b.c("GiftPlayerRenderFilter", "setEnable fail because resourceFinder is null", null, 4);
        r102.onResult(-1);
        return;
    L51:
        jy0.b.a("GiftPlayerRenderFilter", "isInit == true, proceed");
        j r114 = ((or2.e) vh6.c.b(or2.e.class)).getCurrentClient();
        if (r114 != null) goto L54;
        jy0.b.c("GiftPlayerRenderFilter", "setEnable fail, currentClient is null", null, 4);
    L54:
        if (r114 == null) goto L56;
        r114.i(r100);
    L56:
        r102.onResult(0);
        return;
    L5:
        if (r105 == false) goto L7;
        this.f501254c.clear();
    L10:
        this.f501255d.clear();
        goto L11
    L7:
        this.f501254c.remove(r104);
        if ((!this.f501254c.isEmpty()) == false) goto L10;
    }
}
