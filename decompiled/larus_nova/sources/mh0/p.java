package mh0;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.animation.universalwidget.utils.ListDiffUtils;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.livesdk.config.i30;
import com.bytedance.android.livesdk.config.wb0;
import com.bytedance.android.livesdk.l2;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p extends lh0.a {
    public final ue0.c A;
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d B;
    public final eh0.b C;
    public final eh0.b D;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f513841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, LayoutConfigModel> f513842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, List<Integer>> f513843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Boolean> f513844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, Boolean> f513845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f513846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f513847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f513848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<? extends tf0.e> f513849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<? extends tf0.e> f513850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<? extends tf0.e> f513851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f513852p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<? extends tf0.e> f513853q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompositeDisposable f513854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IMultiScenePreviewStatistics f513855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a f513856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f513857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f513858v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f513859w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap<String, Boolean> f513860x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ih0.b f513861y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f513862z;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f513863a;

        public a(p r100) {
            this.f513863a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            p r101 = this.f513863a;
            p.f(r101, (Map) r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f513864a;

        public b(p r100) {
            this.f513864a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            p r101 = this.f513864a;
            p.f(r101, (Map) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f513865a;

        public c(p r100) {
            this.f513865a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            p r101 = this.f513865a;
            p.f(r101, (Map) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f513866a;

        public d(p r100) {
            this.f513866a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            p r101 = this.f513866a;
            r101.getClass();
            Iterator<T> r102 = ((List) r100).iterator();
            boolean r103 = false;
        L4:
            if (r102.hasNext() == false) goto L14;
            tf0.e r104 = (tf0.e) r102.next();
            if ((r104 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
            MultiLinkGuestViewBinder.a r105 = (MultiLinkGuestViewBinder.a) r104;
            String r106 = r105.f75934k.f23724a.getMInteractIdStr();
            if (r106 != null) goto L10;
            r106 = "";
        L10:
            boolean r107 = ch0.f.a(r105.f75934k);
            if ((!Intrinsics.areEqual(r101.f513844h.get(r106), Boolean.valueOf(r107))) == false) goto L13;
            r103 = true;
        L13:
            r101.f513844h.put(r106, Boolean.valueOf(r107));
            goto L4
        L14:
            if (r103 == true) goto L16;
            return;
        L16:
            if (i30.f120423a.getValue().longValue() > 0) goto L25;
            r101.m();
            return;
        }
    }

    @Override // lh0.a
    public final void c() {
        int r100 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.f76654a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.f513862z) == false) goto L11;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r101 = this.B;
        if (r101 == null) goto L19;
        BehaviorSubject<List<LinkmicPositionItem>> r102 = r101.g();
        if (r102 == null) goto L20;
        Disposable r103 = r102.subscribe(new o(this));
        if (r103 == null) goto L21;
        RxUtilKt.c(r103, this.f509220a);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L11:
        ue0.c r104 = this.A;
        if (r104 == null) goto L23;
        BehaviorSubject<List<LinkmicPositionItem>> r105 = r104.f549771e;
        if (r105 == null) goto L24;
        Disposable r106 = r105.subscribe(new n(this));
        if (r106 == null) goto L25;
        RxUtilKt.c(r106, this.f509220a);
        return;
    L25:
        return;
    L24:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m() {
        JsonArray r100 = new JsonArray();
        Iterator<Map.Entry<String, Boolean>> r101 = this.f513844h.entrySet().iterator();
        boolean r102 = false;
        boolean r103 = false;
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, Boolean> r104 = r101.next();
        String r105 = r104.getKey();
        boolean r106 = r104.getValue().booleanValue();
        if ((!Intrinsics.areEqual(this.f513845i.get(r105), Boolean.valueOf(r106))) == false) goto L8;
        this.f513845i.put(r105, Boolean.valueOf(r106));
        r103 = true;
    L8:
        JsonObject r107 = new JsonObject();
        r107.addProperty("linkmic_id_str", r105);
        r107.addProperty("is_speaking", Boolean.valueOf(r106));
        r100.add(r107);
        goto L4
    L9:
        if (r103 == false) goto L71;
        JsonObject r108 = new JsonObject();
        r108.add("sei_infos", r100);
        this.f513861y.Dk("seat", "seat_frequent", r108, false);
        int r109 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.f76654a;
        String r110 = null;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.f513862z) == false) goto L33;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r111 = this.B;
        if (r111 == null) goto L50;
        BehaviorSubject<List<ch0.e>> r112 = r111.f();
        if (r112 == null) goto L50;
        List<ch0.e> r113 = r112.getValue();
        if (r113 == null) goto L50;
        Iterator<T> r114 = r113.iterator();
    L20:
        if (r114.hasNext() == false) goto L27;
        Object r115 = r114.next();
        if (((ch0.e) r115).f23724a.isEnlarged() != true) goto L24;
        boolean r116 = true;
    L25:
        if (r116 == false) goto L20;
    L28:
        ch0.e r117 = (ch0.e) r115;
        if (r117 == null) goto L50;
        ILinkPlayerInfoBridge r118 = r117.f23724a;
        if (r118 == null) goto L50;
        r110 = r118.getInteractId();
        goto L50
    L24:
        r116 = false;
        goto L25
    L27:
        r115 = null;
    L50:
        boolean r119 = Intrinsics.areEqual(this.f513844h.get(r110), Boolean.TRUE);
        Integer r120 = this.f513858v;
        if (r120 != null) goto L54;
    L56:
        i(r102, r119);
        this.f513845i.clear();
        this.f513845i.putAll(this.f513844h);
        return;
    L54:
        if (r120.intValue() != 0) goto L56;
        r102 = true;
        goto L56
    L33:
        ue0.c r121 = this.A;
        if (r121 == null) goto L50;
        Iterator<T> r122 = r121.o().iterator();
    L37:
        if (r122.hasNext() == false) goto L44;
        Object r123 = r122.next();
        if (((ch0.e) r123).f23724a.isEnlarged() != true) goto L41;
        boolean r124 = true;
    L42:
        if (r124 == false) goto L37;
    L45:
        ch0.e r125 = (ch0.e) r123;
        if (r125 == null) goto L50;
        ILinkPlayerInfoBridge r126 = r125.f23724a;
        if (r126 == null) goto L50;
        r110 = r126.getInteractId();
        goto L50
    L41:
        r124 = false;
        goto L42
    L44:
        r123 = null;
        goto L45
    }

    public final MultiLinkFeedDynamicWidgetNew n() {
        ih0.b r100 = this.f513861y;
        if (r100 == null) goto L7;
        return (MultiLinkFeedDynamicWidgetNew) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew");
    }

    @Override // lh0.a
    public final void d() {
        super.d();
        if (l2.f146986a.getValue().booleanValue() == false) goto L7;
        Disposable r100 = this.f513846j;
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        this.f513847k.clear();
        this.f513854r.clear();
    }

    public final boolean g(List<? extends tf0.e> r100) {
        Iterator<T> r101 = r100.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L24;
        tf0.e r103 = (tf0.e) r101.next();
        if ((r103 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
        MultiLinkGuestViewBinder.a r104 = (MultiLinkGuestViewBinder.a) r103;
        IBaseUser r105 = r104.f75934k.f23724a.getUser();
        if (r105 == null) goto L11;
        String r106 = r105.getIdString();
        if (r106 == null) goto L11;
    L13:
        if (r106.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L4;
        MultiLinkFrequencyOptConfig r108 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.f75889a;
        ch0.e r109 = r104.f75934k;
        IRoom r110 = b();
        if (r110 == null) goto L20;
        String r111 = r110.getOwnerUserIdString();
    L21:
        boolean r112 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r109, r111);
        if ((!Intrinsics.areEqual(this.f513860x.get(r106), Boolean.valueOf(r112))) == false) goto L4;
        this.f513860x.put(r106, Boolean.valueOf(r112));
        r102 = true;
        goto L4
    L20:
        r111 = null;
        goto L21
    L15:
        r107 = false;
    L11:
        r106 = "";
        goto L13
    L24:
        return r102;
    }

    public final void h(int r100) {
        this.f513847k.clear();
        int r101 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.f76654a;
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(this.f513862z) == true) goto L5;
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r102 = this.f513856t;
        if (r102 == null) goto L36;
        BehaviorSubject<List<tf0.e>> r103 = r102.f76379b;
        if (r103 == null) goto L36;
        Disposable r104 = r103.subscribe(new d(this));
        if (r104 == null) goto L36;
        RxUtilKt.c(r104, this.f513847k);
    L36:
        i30 r105 = i30.f120423a;
        if (r105.getValue().longValue() <= 0) goto L44;
        Disposable r106 = this.f513846j;
        if (r106 == null) goto L42;
        r106.dispose();
    L42:
        Disposable r107 = Observable.interval(0, r105.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this));
        RxUtilKt.c(r107, this.f513847k);
        this.f513846j = r107;
        return;
    L44:
        return;
    L5:
        if (aj0.b.c(r100) == false) goto L14;
        eh0.b r108 = this.C;
        if (r108 == null) goto L36;
        BehaviorSubject<Map<String, Boolean>> r109 = r108.o();
        if (r109 == null) goto L36;
        Disposable r110 = r109.subscribe(new a(this));
        if (r110 == null) goto L36;
        RxUtilKt.c(r110, this.f513847k);
        goto L36
    L14:
        if (r100 != 15) goto L22;
        eh0.b r111 = this.D;
        if (r111 == null) goto L36;
        BehaviorSubject<Map<String, Boolean>> r112 = r111.o();
        if (r112 == null) goto L36;
        Disposable r113 = r112.subscribe(new b(this));
        if (r113 == null) goto L36;
        RxUtilKt.c(r113, this.f513847k);
        goto L36
    L22:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r114 = this.B;
        if (r114 == null) goto L36;
        BehaviorSubject<Map<String, Boolean>> r115 = r114.j1();
        if (r115 == null) goto L36;
        Disposable r116 = r115.subscribe(new c(this));
        if (r116 == null) goto L36;
        RxUtilKt.c(r116, this.f513847k);
        goto L36
    }

    public final void j(List<? extends tf0.e> r110) {
        int r100 = ListDiffUtils.f71374a;
        if (ListDiffUtils.a(this.f513853q, r110) == true) goto L6;
        this.f513853q = r110;
        n().fg(new nh0.f("fanticket", null, r110, null, null, null, false, 246));
        return;
    }

    public final void k(List<? extends tf0.e> r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        List<? extends tf0.e> r100 = r210;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
        boolean r103 = false;
        int r110 = 0;
    L6:
        String r111 = null;
        if (r102.hasNext() == false) goto L22;
        Object r104 = r102.next();
        int r105 = r110 + 1;
        if (r110 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Object r106 = (tf0.e) r104;
        if ((r106 instanceof MultiLinkGuestViewBinder.a) == false) goto L20;
        tc0.c r107 = tc0.c.h();
        MultiLinkGuestViewBinder.a r108 = (MultiLinkGuestViewBinder.a) r106;
        IBaseUser r109 = r108.f75934k.f23724a.getUser();
        if (r109 == null) goto L16;
        r111 = r109.getIdString();
    L16:
        Map.Entry<Long, ? extends g2> r112 = r107.g(r111);
        if (r112 == null) goto L19;
        r108.f75934k.f23724a.setOtherRoomInfo(r112);
    L19:
        r103 = true;
    L21:
        r101.add(r106);
        r110 = r105;
        goto L6
    L20:
        r106 = new MultiLinkNormalEmptyViewBinder.a(r110, null, null, false, false, false, false, false, false, 1022);
        goto L21
    L22:
        boolean r113 = g(r101);
        int r114 = ListDiffUtils.f71374a;
        if (ListDiffUtils.c(this.f513849m, r101) == false) goto L27;
        if (r113 == true) goto L27;
        ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change same guest list return");
    L41:
        boolean r115 = g(r210);
        if (ListDiffUtils.c(this.f513850n, r210) == false) goto L46;
        if (r115 == true) goto L46;
        ALogger.d("BaseMultiLinkWindowManager", "windowListObservable change same seat list return");
        return;
    L46:
        this.f513850n = r210;
        if (r.a(null, 3) == true) goto L60;
        MultiLinkFeedDynamicWidgetNew r116 = n();
        String r117 = "seat";
        nh0.e r118 = null;
        sf0.b r119 = null;
        JsonObject r120 = null;
        String r121 = null;
        if (MultiLinkLoadWidgetUtils.j() == true) goto L51;
    L53:
        boolean r122 = false;
    L54:
        r116.fg(new nh0.f(r117, r118, r210, r119, r120, r121, r122, 118));
        return;
    L51:
        if (this.f513857u == false) goto L53;
        r122 = true;
        goto L54
    L60:
        return;
    L27:
        this.f513849m = r101;
        if (wb0.f121512a.getValue().booleanValue() == false) goto L30;
        if (r103 == false) goto L41;
    L30:
        MultiLinkFeedDynamicWidgetNew r123 = n();
        String r124 = "guest_list";
        nh0.e r125 = null;
        sf0.b r126 = null;
        JsonObject r127 = null;
        IRoom r128 = b();
        if (r128 == null) goto L33;
        String r129 = r128.getOwnerUserIdString();
    L35:
        if (MultiLinkLoadWidgetUtils.j() == true) goto L37;
    L39:
        boolean r130 = false;
    L40:
        r123.fg(new nh0.f(r124, r125, r210, r126, r127, r129, r130, 54));
        goto L41
    L37:
        if (this.f513857u == false) goto L39;
        r130 = true;
        goto L40
    L33:
        r129 = null;
        goto L35
    }

    public final void l(List<? extends tf0.e> r110) {
        InteractiveSongContext r100 = InteractiveSongContext.Companion.getContext();
        String r101 = "";
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r102 = r100.getSingingGuestId();
        if (r102 == null) goto L8;
        String r103 = r102.getValue();
        if (r103 == null) goto L8;
    L9:
        int r104 = ListDiffUtils.f71374a;
        List<? extends tf0.e> r105 = this.f513851o;
        int r106 = this.f513852p;
        Integer r107 = this.f509223d.a();
        if (r107 == null) goto L12;
        int r108 = r107.intValue();
    L14:
        if (ListDiffUtils.b(r105, r106, r110, r108) == true) goto L16;
    L17:
        this.f513851o = r110;
        this.f513859w = r103;
        Integer r109 = this.f509223d.a();
        if (r109 == null) goto L20;
        int r111 = r109.intValue();
    L21:
        this.f513852p = r111;
        IRoom r112 = this.f509223d.r();     // Catch: Exception -> L53
        if (r112 == null) goto L30;
        z5 r113 = r112.getLinkerDetail();     // Catch: Exception -> L53
        if (r113 == null) goto L30;
        String r114 = r113.getClientUiInfo();     // Catch: Exception -> L53
        if (r114 == null) goto L30;
        r101 = r114;
    L30:
        ClientUIInfo r115 = (ClientUIInfo) GsonHelper.get().fromJson(r101, ClientUIInfo.class);     // Catch: Exception -> L53
        Integer r116 = this.f509223d.a();     // Catch: Exception -> L53
        if (r116 == null) goto L33;
        int r117 = r116.intValue();     // Catch: Exception -> L53
    L35:
        if (r115 == null) goto L37;
        List<Integer> r118 = r115.getUiFeatureList();     // Catch: Exception -> L53
    L39:
        if ((r118 instanceof ArrayList) == true) goto L41;
        r118 = null;
    L41:
        ArrayList r119 = (ArrayList) r118;     // Catch: Exception -> L53
        if (r119 == null) goto L44;
    L43:
        ArrayList r120 = r119;
        IRoom r121 = this.f509223d.r();     // Catch: Exception -> L53
        if (r121 == null) goto L50;
        z5 r122 = r121.getLinkerDetail();     // Catch: Exception -> L53
        if (r122 == null) goto L50;
        List<Long> r123 = r122.getFeatureList();     // Catch: Exception -> L53
    L51:
        n().fg(new nh0.f("order_sing_visual", new nh0.e(0, r117, null, 0, 0, null, r120, r123, 61), r110, null, null, null, false, 244));     // Catch: Exception -> L53
        return;
    L50:
        r123 = null;
        goto L51
    L44:
        r119 = new ArrayList();     // Catch: Exception -> L53
        goto L43
    L37:
        r118 = null;
        goto L39
    L33:
        r117 = 0;
    L53:
        e = move-exception;
        ALogger.e(this.f513841e, "sendOrderSingVisualToLynx " + e.getMessage());
        return;
    L20:
        r111 = 0;
        goto L21
    L16:
        if ((!Intrinsics.areEqual(this.f513859w, r103)) == true) goto L17;
        return;
    L12:
        r108 = 0;
    L8:
        r103 = "";
        goto L9
    }

    public static final void f(p r100, Map r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        Iterator r103 = r101.entrySet().iterator();
        boolean r104 = false;
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r103.next();
        String r106 = (String) r105.getKey();
        boolean r107 = ((Boolean) r105.getValue()).booleanValue();
        if ((!Intrinsics.areEqual(r100.f513844h.get(r106), Boolean.valueOf(r107))) == false) goto L8;
        r104 = true;
    L8:
        r102.put(r106, Boolean.valueOf(r107));
        goto L4
    L9:
        r100.f513844h.clear();
        r100.f513844h.putAll(r102);
        if (r104 == true) goto L12;
        return;
    L12:
        if (i30.f120423a.getValue().longValue() > 0) goto L19;
        r100.m();
        return;
    }

    public final void i(boolean r100, boolean r101) {
        JsonObject r102 = new JsonObject();
        r102.addProperty("type", "big_head");
        JsonObject r103 = new JsonObject();
        r103.addProperty("display", Boolean.valueOf(r100));
        r103.addProperty("talking", Boolean.valueOf(r101));
        Unit r104 = Unit.INSTANCE;
        r102.add("data", r103);
        this.f513861y.Dk("avatar", "avatar_event", r102, false);
    }

    public p(Context r100, DataCenter r101, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r102, ih0.b r103, int r104, ue0.c r105, com.bytedance.android.live.liveinteract.plantform.datamerge.d r106, eh0.b r107, eh0.b r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r102, "feedInfoProvider");
        Intrinsics.checkNotNullParameter(r103, "service");
        super(r100, r101, r102);
        this.f513861y = r103;
        this.f513862z = r104;
        this.A = r105;
        this.B = r106;
        this.C = r107;
        this.D = r110;
        this.f513841e = "MicSeatFeedDynamicHandler";
        this.f513842f = new LinkedHashMap();
        this.f513843g = new LinkedHashMap();
        this.f513844h = new HashMap();
        this.f513845i = new HashMap();
        this.f513847k = new CompositeDisposable();
        this.f513854r = new CompositeDisposable();
        this.f513859w = "";
        this.f513860x = new HashMap();
    }
}
