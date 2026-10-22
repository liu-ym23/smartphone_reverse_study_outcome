package com.bytedance.android.window.shop.home.tab;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBasePresenter;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.WindowCategoryConfigDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import yj.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowLynxTabPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPause", "onResume", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowLynxTabPresenter extends ECWindowHolderBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ KProperty[] q = null;
    public final Lazy g;
    public boolean h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final d l;
    public final com.bytedance.android.window.shop.home.tab.c m;
    public final Lazy n;
    public final Function2<v, ECLynxCardEvent, Unit> o;
    public final Fragment p;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ WindowLynxTabPresenter a;

        public b(WindowLynxTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            WindowHybridTabDataListResponseDTO r8 = (WindowHybridTabDataListResponseDTO) r7;
            Iterator<T> r0 = r8.categories().iterator();
        L3:
            String r2 = null;
            if (r0.hasNext() == false) goto L12;
            T r1 = r0.next();
            String r3 = ((p) r1).b();
            WindowLynxTabPresenter r4 = this.a;
            KProperty[] r5 = WindowLynxTabPresenter.q;
            BaseWindowTabViewModel r6 = r4.I();
            if (r6 == null) goto L8;
            String r9 = r6.getLastCategoryId();
        L10:
            if (Intrinsics.areEqual(r3, r9) == false) goto L3;
        L13:
            p r10 = r1;
            if (r10 == null) goto L32;
            WindowLynxTabPresenter r11 = this.a;
            String r12 = r8.getCategoryData();
            WindowLynxTabPresenter r13 = this.a;
            KProperty[] r14 = WindowLynxTabPresenter.q;
            BaseWindowTabViewModel r15 = r13.I();
            if (r15 == null) goto L19;
            String r16 = r15.getLastCategoryId();
        L20:
            BaseWindowTabViewModel r17 = r11.I();
            if (r17 == null) goto L23;
            String r18 = r17.getLastCategoryId();
        L25:
            if (Intrinsics.areEqual(r16, r18) == false) goto L27;
            r2 = r12;
        L27:
            WindowLynxTabPresenter.F(r11, r10, r2);
            return;
        L23:
            r18 = null;
            goto L25
        L19:
            r16 = null;
            goto L20
        L32:
            return;
        L8:
            r9 = null;
            goto L10
        L12:
            r1 = (T) null;
            goto L13
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ WindowLynxTabPresenter a;

        public c(WindowLynxTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            WindowTabDataListResponseDTODeprecated r8 = (WindowTabDataListResponseDTODeprecated) r7;
            Iterator<T> r0 = r8.categories().iterator();
        L3:
            String r2 = null;
            if (r0.hasNext() == false) goto L12;
            T r1 = r0.next();
            String r3 = ((p) r1).b();
            WindowLynxTabPresenter r4 = this.a;
            KProperty[] r5 = WindowLynxTabPresenter.q;
            BaseWindowTabViewModel r6 = r4.I();
            if (r6 == null) goto L8;
            String r9 = r6.getLastCategoryId();
        L10:
            if (Intrinsics.areEqual(r3, r9) == false) goto L3;
        L13:
            p r10 = r1;
            if (r10 == null) goto L32;
            WindowLynxTabPresenter r11 = this.a;
            String r12 = r8.getCategoryData();
            WindowLynxTabPresenter r13 = this.a;
            KProperty[] r14 = WindowLynxTabPresenter.q;
            BaseWindowTabViewModel r15 = r13.I();
            if (r15 == null) goto L19;
            String r16 = r15.getLastCategoryId();
        L20:
            BaseWindowTabViewModel r17 = r11.I();
            if (r17 == null) goto L23;
            String r18 = r17.getLastCategoryId();
        L25:
            if (Intrinsics.areEqual(r16, r18) == false) goto L27;
            r2 = r12;
        L27:
            WindowLynxTabPresenter.F(r11, r10, r2);
            return;
        L23:
            r18 = null;
            goto L25
        L19:
            r16 = null;
            goto L20
        L32:
            return;
        L8:
            r9 = null;
            goto L10
        L12:
            r1 = (T) null;
            goto L13
        }
    }

    static {
        q = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(WindowLynxTabPresenter.class, "lynxCard", "getLynxCard()Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", 0))};
    }

    public final ECLynxCard G() {
        return (ECLynxCard) this.m.getValue(this, q[0]);
    }

    public final BaseWindowTabViewModel I() {
        return (BaseWindowTabViewModel) this.i.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        ((ECWindowViewModel) this.j.getValue()).getScrollPositionFarEnough().setValue(Boolean.FALSE);
        ECLynxCard r2 = G();
        if (r2 == null) goto L6;
        ECLynxCard.m(r2, true, "", "", false, false, false, 0, 240);
        return;
    }

    public final void C() {
        this.p.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        ECLynxCard r0 = G();
        if (r0 == null) goto L6;
        ECLynxCard.m(r0, true, "", "", false, false, false, 0, 240);
        return;
    }

    public WindowLynxTabPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.o = null;
        this.p = r2;
        this.g = LazyKt.lazy(new WindowLynxTabPresenter$cardPool$2(this));
        this.i = LazyKt.lazy(new WindowLynxTabPresenter$windowTabViewModel$2(this));
        this.j = LazyKt.lazy(new WindowLynxTabPresenter$windowViewModel$2(this));
        this.k = LazyKt.lazy(new WindowLynxTabPresenter$container$2(this));
        this.l = new d(this);
        Delegates r3 = Delegates.INSTANCE;
        this.m = new com.bytedance.android.window.shop.home.tab.c(this);
        this.n = LazyKt.lazy(new WindowLynxTabPresenter$sharedPrefHelper$2(this));
    }

    public final void A(QModel r4) {
        FrameLayout r5 = (FrameLayout) this.k.getValue();
        this.p.getLifecycle().addObserver(this);
        D().getHeaderSubTabsParam().d.a(E(), new b(this), true);
        D().getHeaderSubTabsParam().c.a(E(), new c(this), true);
    }

    public static final void F(final WindowLynxTabPresenter r16, p r17, String r18) {
        r16.getClass();
        WindowCategoryConfigDTO r1 = r17.a();
        if (r1 == null) goto L61;
        String r2 = r1.b();
        if (r2 != null) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r2) == false) goto L11;
        ECLynxCardErrorType r3 = ECLynxCardErrorType.FAILED;
        r16.m.setValue(r16, q[0], null);
        return;
    L11:
        if (r16.G() != null) goto L14;
        r16.m.setValue(r16, q[0], new ECLynxCard());
    L14:
        if (yq3.a.e() != 1) goto L16;
        r2 = r2.concat("&loader_name=forest");
    L16:
        String r8 = "";
        if (yq3.a.b() != 1) goto L32;
        Intrinsics.checkNotNullParameter("ec_window", "bizTag");
        Intrinsics.checkNotNullParameter("ec_window_lynx_tab", "sceneTag");
        if (r2 != null) goto L21;
    L24:
        boolean r9 = true;
    L25:
        if (r9 == false) goto L27;
        String r13 = "";
    L33:
        ECLynxLoadParam.a r4 = new ECLynxLoadParam.a(r16.y().getContext(), r13, (FrameLayout) r16.k.getValue());
        r4.j(2000);
        r4.i = r16.p.getLifecycle();
        r4.j = r18;
        ViewGroup.LayoutParams r5 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r5, "ecLayoutParams");
        r4.u = r5;
        BaseWindowTabViewModel r6 = r16.I();
        if (r6 != null) goto L36;
        Map r7 = MapsKt.emptyMap();
    L41:
        Map r10 = MapsKt.mapOf(TuplesKt.to("ec_lynx_props_extra", k.b(r7)));
        Intrinsics.checkNotNullParameter(r10, "appendData");
        r4.m = r10;
        r4.f(r16.l);
        r4.i(ECLynxLoadType.PRE_CREATE_VIEW);
        int r11 = zq3.d.a;
        List r12 = null;
        r4.e(zq3.d.b(r16.D(), null, null));
        r4.g("ec_window_lynx_tab");
        r4.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ecom.window.click_product", new LynxStatefulBridgeProxy(new WindowLynxTabPresenter$makeJsBridgeMap$1(r16), "ecom.window.click_product")), TuplesKt.to("ecom.window.show_bubble", new LynxStatefulBridgeProxy(new WindowLynxTabPresenter$makeJsBridgeMap$2(r16), "ecom.window.show_bubble"))}));
        Integer r14 = Integer.valueOf(yq3.a.b());
        if (r14.intValue() != 1) goto L44;
        boolean r15 = true;
    L45:
        if (r15 == true) goto L48;
        r14 = null;
    L48:
        if (r14 == null) goto L53;
        r14.intValue();
        t r19 = com.bytedance.android.ec.hybrid.a.g();
        if (r19 == null) goto L52;
        r12 = r19.getImageBehaviors("ec_window", "ec_window_lynx_tab", MapsKt.emptyMap(), r13, false, false);
    L52:
        if (r12 == null) goto L53;
    L54:
        r4.a(r12);
        ECLynxCard r20 = r16.G();
        if (r20 == null) goto L57;
        r20.j(new ECLynxLoadParam(r4));
    L57:
        r16.D().getExtraSchemaClosed().a(r16.E(), new e(r16), false);
        ECLynxCard r21 = r16.G();
        if (r21 == null) goto L63;
        ECLynxCard.m(r21, true, "list", "", false, false, false, 0, 240);
        return;
    L63:
        return;
    L53:
        r12 = CollectionsKt.emptyList();
        goto L54
    L44:
        r15 = false;
        goto L45
    L36:
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put("tab_id", r6.getLastCategoryId());
        String r23 = r6.getCategoryName();
        if (r23 == null) goto L40;
        r8 = r23;
    L40:
        r22.put("classification_tab", r8);
        r7 = r22;
        goto L41
    L27:
        Uri r24 = UriProtector.parse(r2);
        if (UriProtector.getQueryParameterNames(r24).contains("surl") == false) goto L30;
        String r25 = UriProtector.getQueryParameter(r24, "surl");
        int r110 = p0.a;
        Object r26 = p0.e(r24, "surl", p0.b(r25, MapsKt.mapOf(new Pair[]{TuplesKt.to("use_ecom_image", CommentScene.COMMENTSCENE_NO_AWEME), TuplesKt.to("ec_custom_load_image", "2"), TuplesKt.to("biz_tag", "ec_window"), TuplesKt.to("scene_tag", "ec_window_lynx_tab")})));
    L31:
        r2 = String.valueOf(r26);
        goto L32
    L30:
        int r27 = p0.a;
        r26 = p0.b(r2, MapsKt.mapOf(new Pair[]{TuplesKt.to("use_ecom_image", CommentScene.COMMENTSCENE_NO_AWEME), TuplesKt.to("ec_custom_load_image", "2"), TuplesKt.to("biz_tag", "ec_window"), TuplesKt.to("scene_tag", "ec_window_lynx_tab")}));
        goto L31
    L21:
        if (r2.length() == 0) goto L24;
        r9 = false;
    L32:
        r13 = r2;
        goto L33
    }
}
