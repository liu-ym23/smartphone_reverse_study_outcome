package com.bytedance.ee.bear.banner;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.creativex.mediaimport.preview.internal.main.g;
import com.bytedance.ee.bear.banner.bean.BannerScene;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.pb.ug_reach.BannerMaterial;
import com.ss.android.lark.ug.banner.BannerReachPoint;
import com.ss.android.lark.ug.facade.UgReachSdk;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f206442i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BannerReachPoint f206443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<ViewGroup> f206444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Context> f206445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f206446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Object> f206447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BannerScene f206448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CCMLynxCardView f206449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, com.ss.android.lark.ug.banner.c> f206450h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.banner.a$a, reason: collision with other inner class name */
    public static final class C2975a {
    }

    public static final class b implements mn4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f206451a;

        public b(a r100) {
            this.f206451a = r100;
        }

        @Override // mn4.a
        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ((ArrayList) this.f206451a.f206447e).remove(r100);
        }

        @Override // mn4.a
        public final void b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ((ArrayList) this.f206451a.f206447e).add(r100);
        }
    }

    public static final class c implements BannerReachPoint.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f206452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f206453b;

        @Override // com.ss.android.lark.ug.banner.BannerReachPoint.b, com.ss.android.lark.ug.banner.BannerReachPoint.a
        public Context getContext() {
            return this.f206452a;
        }

        /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.String] */
        @Override // com.ss.android.lark.ug.banner.BannerReachPoint.a
        public final void a(BannerMaterial r100) {
            Intrinsics.checkNotNullParameter(r100, "bannerInfo");
            tt5.a.h("DocsBanner_DocsBannerManagerV2", "bannerReachPoint#onShow()...");
            final a r101 = this.f206453b;
            int r102 = a.f206442i;
            r101.getClass();
            final Ref.ObjectRef r103 = new Ref.ObjectRef();
            r103.element = JSON.toJSONString(r100, JSON.DEFAULT_GENERATE_FEATURE & (~SerializerFeature.WriteEnumUsingToString.mask), new SerializerFeature[0]);
            WeakReference<ViewGroup> r104 = r101.f206444b;
            Intrinsics.checkNotNull(r104);
            final ViewGroup r105 = r104.get();
            WeakReference<Context> r106 = r101.f206445c;
            Intrinsics.checkNotNull(r106);
            final Context r107 = r106.get();
            ((com.bytedance.ee.bear.lynx.api.b) org.koin.java.a.c(com.bytedance.ee.bear.lynx.api.b.class, null, null, 6)).init(eu5.b.f474075a);
            j.c(new DocsBannerManagerV2$showLynxBanner$1(r107, r105, r101, r103));
        }

        @Override // com.ss.android.lark.ug.banner.BannerReachPoint.a
        public final void onHide(boolean r100) {
            tt5.a.h("DocsBanner_DocsBannerManagerV2", "bannerReachPoint#onHide()... manual = " + r100);
            a r101 = this.f206453b;
            int r102 = a.f206442i;
            r101.getClass();
            j.c(new com.bytedance.ee.bear.banner.b(r101));
        }

        public c(Context r100, a r101) {
            this.f206452a = r100;
            this.f206453b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final mn4.a a() {
        if (this.f206446d != null) goto L6;
        this.f206446d = new b(this);
    L6:
        return this.f206446d;
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void d() {
        tt5.a.h("DocsBanner_DocsBannerManagerV2", "loadBanners()...");
        UgReachSdk.tryExpose$default(UgReachSdk.INSTANCE, this.f206448f.getScenarioId(), null, 2, null);
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void destroy() {
        tt5.a.h("DocsBanner_DocsBannerManagerV2", "destroy()...");
        BannerReachPoint r100 = this.f206443a;
        if (r100 == null) goto L5;
        UgReachSdk.INSTANCE.recycleReachPoint(r100);
    L5:
        this.f206443a = null;
    }

    public a() {
        this.f206447e = new ArrayList();
        this.f206448f = BannerScene.COMMON;
        this.f206450h = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void b(BannerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f206448f = r100;
    }

    @Override // com.bytedance.ee.bear.banner.d
    public final void c(ViewGroup r100, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "bannerContainer");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("DocsBanner_DocsBannerManagerV2", "init()...");
        this.f206444b = new WeakReference(r100);
        this.f206445c = new WeakReference(r110);
        BannerReachPoint r101 = (BannerReachPoint) UgReachSdk.obtainReachPointById$default(UgReachSdk.INSTANCE, this.f206448f.getReachId(), BannerReachPoint.class, null, 4, null);
        this.f206443a = r101;
        if (r101 == null) goto L11;
        c r102 = new c(r110, this);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        r101.f444353f = r102;
        WeakReference<k9c.b> r111 = r101.f508141d;
        if (r111 == null) goto L9;
        k9c.b r112 = r111.get();
        if (r112 == null) goto L9;
        r112.a(new m9c.a(r101.f508138a, r101.f508139b, new m9c.a.C6784a("onReady", true), null, 24));
    L9:
        r101.f("setDependency", "onReady");
        return;
    }
}
