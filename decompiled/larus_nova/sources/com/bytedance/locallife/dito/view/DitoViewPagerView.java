package com.bytedance.locallife.dito.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.utils.l;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001<B%\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R5\u00103\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020/0-\u0012\u0004\u0012\u0002000.0-8F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006="}, d2 = {"Lcom/bytedance/locallife/dito/view/DitoViewPagerView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/dito/view/b;", "Lcom/bytedance/locallife/dito/view/f;", "", "getNodeTagWhenNestedScroll", "Landroid/view/View;", "y", "Landroid/view/View;", "getNestedContainerView", "()Landroid/view/View;", "nestedContainerView", "Lcom/bytedance/locallife/dito/view/DitoTabsAdapter;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Lcom/bytedance/locallife/dito/view/DitoTabsAdapter;", "getAdapter", "()Lcom/bytedance/locallife/dito/view/DitoTabsAdapter;", "setAdapter", "(Lcom/bytedance/locallife/dito/view/DitoTabsAdapter;)V", "adapter", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONObject;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Lazy;", "getPageSelectLiveData", "()Landroidx/lifecycle/MutableLiveData;", "pageSelectLiveData", "B", "getPageScrolledLiveData", "pageScrolledLiveData", "C", "getPageScrollStateLiveData", "pageScrollStateLiveData", "D", "getSetCurrentLiveData", "setCurrentLiveData", ExifInterface.LONGITUDE_EAST, "getViewPagerReady", "viewPagerReady", "Landroidx/viewpager2/widget/ViewPager2;", FaceService.girlLabel, "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "", "Lkotlin/Function1;", "", "Landroidx/fragment/app/Fragment;", "getPageMap", "()Ljava/util/Map;", "pageMap", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoViewPagerView extends BaseDitoView<com.bytedance.locallife.dito.view.b> implements f {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final ViewPager2 F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DitoViewPagerView f258737y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public DitoTabsAdapter f258738z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoViewPagerView f258739a;

        public b(DitoViewPagerView r100) {
            this.f258739a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            int r101 = JSONObjectProtectorUtils.getInt((JSONObject) r100, "position");
            this.f258739a.getViewPager().setCurrentItem(r101);
        }
    }

    static {
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final boolean h() {
        return false;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final boolean j() {
        return false;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final boolean o() {
        return true;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final List<com.bytedance.locallife.dito.view.a> r() {
        return null;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final void s() {
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final boolean B() {
        Dito r100 = Dito.f257280a;
        return l.k().getFixNestedV2ScrollError();
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final boolean c() {
        Dito r100 = Dito.f257280a;
        return l.k().getFixDragItemNotResetNestedReadyState();
    }

    public final MutableLiveData<JSONObject> getPageScrollStateLiveData() {
        return (MutableLiveData) this.C.getValue();
    }

    public final MutableLiveData<JSONObject> getPageScrolledLiveData() {
        return (MutableLiveData) this.B.getValue();
    }

    public final MutableLiveData<JSONObject> getPageSelectLiveData() {
        return (MutableLiveData) this.A.getValue();
    }

    public final MutableLiveData<JSONObject> getSetCurrentLiveData() {
        return (MutableLiveData) this.D.getValue();
    }

    public final MutableLiveData<JSONObject> getViewPagerReady() {
        return (MutableLiveData) this.E.getValue();
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        if (this.F.getAdapter() != null) goto L12;
        DitoFragment r100 = getDitoViewModel().f258035a;
        if (r100 != null) goto L7;
        return;
    L7:
        ViewPager2 r101 = this.F;
        Map<String, Function1<Map<String, ? extends Object>, Fragment>> r102 = getPageMap();
        com.bytedance.locallife.dito.view.b r103 = getModel();
        if (r103 == null) goto L10;
        DitoViewPagerData r104 = r103.c();
    L11:
        DitoTabsAdapter r105 = new DitoTabsAdapter(r102, r104, r100);
        this.f258738z = r105;
        r101.setAdapter(r105);
        getViewPagerReady().setValue(new JSONObject().put("view", this.F));
        goto L12
    L10:
        r104 = null;
    L12:
        com.bytedance.locallife.dito.view.b r106 = getModel();
        int r107 = 0;
        if (r106 == null) goto L33;
        DitoViewPagerData r108 = r106.c();
        if (r108 == null) goto L33;
        List<DitoPagerData> r109 = r108.getPageData();
        if (r109 == null) goto L33;
        Iterator<DitoPagerData> r110 = r109.iterator();
        int r111 = 0;
    L20:
        if (r110.hasNext() == false) goto L33;
        DitoPagerData r112 = r110.next();
        com.bytedance.locallife.dito.view.b r113 = getModel();
        if (r113 == null) goto L28;
        DitoViewPagerData r114 = r113.c();
        if (r114 == null) goto L28;
        DitoViewPagerConfig r115 = r114.getConfig();
        if (r115 == null) goto L28;
        String r116 = r115.getDefaultPageID();
    L30:
        if (Intrinsics.areEqual(r116, r112.getPage_id()) == true) goto L34;
        r111 = r111 + 1;
    L34:
        if (r111 == (-1)) goto L47;
        com.bytedance.locallife.dito.view.b r117 = getModel();
        if (r117 == null) goto L42;
        DitoViewPagerData r118 = r117.c();
        if (r118 == null) goto L42;
        List<DitoPagerData> r119 = r118.getPageData();
        if (r119 == null) goto L42;
        r107 = r119.size();
    L42:
        if (r111 >= r107) goto L48;
        this.F.setCurrentItem(r111);
        return;
    L48:
        return;
    L47:
        return;
    L28:
        r116 = null;
    L33:
        r111 = -1;
        goto L34
    }

    @Override // com.bytedance.locallife.dito.view.f
    public View getNestedScrollTarget() {
        getNestedContainerView();
        return l(getNestedContainerView());
    }

    @Override // com.bytedance.locallife.dito.view.f
    public String getNodeTagWhenNestedScroll() {
        com.bytedance.locallife.dito.view.b r100 = getModel();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f258493b.f258222b;
    }

    public final Map<String, Function1<Map<String, ? extends Object>, Fragment>> getPageMap() {
        return getDitoViewModel().f258035a.U;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        addView(this.F);
        Dito r100 = Dito.f257280a;
        if (l.k().getEnableViewPagerFullHeight() == false) goto L5;
        addOnAttachStateChangeListener(new c(this));
    L5:
        DitoFragment r101 = getDitoViewModel().f258035a;
        if (l.k().getEnableViewPagerFullHeight() == false) goto L8;
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-1, -1);
    L13:
        setLayoutParams(r102);
        this.F.setOffscreenPageLimit(l.k().getPagerOffscreenLimit());
        this.F.registerOnPageChangeCallback(new AnonymousClass2(this));
        getSetCurrentLiveData().observe(this, new b(this));
        return;
    L8:
        RecyclerView r103 = r101.f257790l;
        if (r103 == null) goto L11;
        int r104 = r103.getHeight();
    L12:
        r102 = new ViewGroup.LayoutParams(-1, r104);
        goto L13
    L11:
        r104 = com.bytedance.locallife.dito.utils.e.b(200);
        goto L12
    }

    public final DitoTabsAdapter getAdapter() {
        return this.f258738z;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public View getNestedContainerView() {
        return this.f258737y;
    }

    public final ViewPager2 getViewPager() {
        return this.F;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final NestedJudgmentEdge k() {
        return NestedJudgmentEdge.Both;
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final RecyclerView l(View r100) {
        return f.a.a(this, r100);
    }

    public final void setAdapter(DitoTabsAdapter r100) {
        this.f258738z = r100;
    }

    public DitoViewPagerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f258737y = this;
        this.A = LazyKt.lazy(new DitoViewPagerView$pageSelectLiveData$2(this));
        this.B = LazyKt.lazy(new DitoViewPagerView$pageScrolledLiveData$2(this));
        this.C = LazyKt.lazy(new DitoViewPagerView$pageScrollStateLiveData$2(this));
        this.D = LazyKt.lazy(new DitoViewPagerView$setCurrentLiveData$2(this));
        this.E = LazyKt.lazy(new DitoViewPagerView$viewPagerReady$2(this));
        this.F = new ViewPager2(r100);
    }

    @Override // com.bytedance.locallife.dito.view.f
    public final void a(RecyclerView r100, ListEdge r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "rv");
        Intrinsics.checkNotNullParameter(r101, "listEdge");
    }
}
