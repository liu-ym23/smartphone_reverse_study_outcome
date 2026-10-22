package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.ECShopGroupAnimation;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.product.ECStoreProductTabFragment;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.TabKitPresenter;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopFrameworkType;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.apm.ApmAgent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\t\nJ\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopTopTabPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout$OnTabSelectedListener;", "Lcom/bytedance/android/shopping/store/tabkit/g;", "", "onResume", "onStop", "onDestroy", "a", "ScrollState", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopTopTabPresenter extends ECShopBasePresenter implements LifecycleObserver, ECTabLayout.OnTabSelectedListener, com.bytedance.android.shopping.store.tabkit.g {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final com.bytedance.android.shopping.store.tabkit.f B;
    public long u;
    public ECTabLayout v;
    public boolean w;
    public uj3.j x;
    public Drawable y;
    public int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopTopTabPresenter$ScrollState;", "", "SHOW", "HIDE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState HIDE = null;
        public static final ScrollState SHOW = null;
        public static final /* synthetic */ ScrollState[] a = null;

        static {
            ScrollState r1 = new ScrollState("SHOW", 0);
            SHOW = r1;
            ScrollState r2 = new ScrollState("HIDE", 1);
            HIDE = r2;
            a = new ScrollState[]{r1, r2};
        }

        public static ScrollState valueOf(String r1) {
            return (ScrollState) r27.a.a(ScrollState.class, r1);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) a.clone();
        }

        public ScrollState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopTopTabPresenter a;

        public b(ECShopTopTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            com.bytedance.android.shopping.store.home.entity.n r8 = (com.bytedance.android.shopping.store.home.entity.n) r7;
            if (r8 == null) goto L43;
            ECShopTopTabPresenter r0 = this.a;
            if (r8.d() == false) goto L8;
        L11:
            ECShopTopTabPresenter r9 = this.a;
            int r1 = ECShopTopTabPresenter.C;
            ECTabLayout r10 = (ECTabLayout) r9.w().b(2131371149).f();
        L12:
            r0.v = r10;
            ECTabLayout r11 = this.a.v;
            if (r11 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        L16:
            if (r11 == null) goto L18;
            r11.setVisibility(0);
        L18:
            ECShopTopTabPresenter r12 = this.a;
            ECTabLayout r2 = r12.v;
            if (r2 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        L21:
            r12.W().getLifecycle().addObserver(r12);
            com.bytedance.android.shopping.store.tabkit.f r3 = r12.B;
            if (r3 == null) goto L26;
            TabKitPresenter r4 = r3.Mc();
            if (r4 == null) goto L26;
            r4.g = r2;
        L26:
            ECTabLayout r5 = r12.v;
            if (r5 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        L29:
            r5.addOnTabSelectedListener(r12);
            Drawable r6 = r12.y().getContext().getDrawable(2131234844);
            TabKitViewModel r13 = null;
            if (r6 == null) goto L32;
            Drawable r14 = r6.mutate();
        L33:
            r12.y = r14;
            r12.T().getCollapseFactor().a(r12.W(), new s3(r12), false);
            ECTabLayout r15 = r12.v;
            if (r15 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        L36:
            r15.setNeedHideIndicatorWhenSingleTab(true);
            com.bytedance.android.shopping.store.tabkit.f r16 = r12.B;
            if (r16 == null) goto L39;
            r13 = r16.getTabKitViewModel();
        L39:
            if (r13 == null) goto L42;
            r13.addTabKitLifeListener(r12);
            return;
        L42:
            return;
        L32:
            r14 = null;
            goto L33
        L8:
            if (r8.a() == ShopFrameworkType.MIDDLE_TAB.getType()) goto L11;
            ECShopTopTabPresenter r17 = this.a;
            int r18 = ECShopTopTabPresenter.C;
            r10 = (ECTabLayout) r17.w().b(2131371148).f();
            goto L12
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopTopTabPresenter a;

        public c(ECShopTopTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            int r0 = this.a.z;
            if (r5 == null) goto L9;
            if (r5.intValue() != r0) goto L9;
            return;
        L9:
            if (this.a.A == true) goto L33;
            boolean r1 = true;
            if (r5 != null) goto L15;
        L17:
            if (r5 != null) goto L20;
        L30:
            ECShopTopTabPresenter r2 = this.a;
            r2.z = r5.intValue();
            return;
        L20:
            if (r5.intValue() != (-1)) goto L30;
            ECShopGroupAnimation r3 = this.a.T().getAnimator();
            r3.b = true;
            if (r3.a.getValues() == null) goto L30;
            if (r3.a.getValues().length == 0) goto L27;
            r1 = false;
        L27:
            if (r1 == true) goto L30;
            r3.a.reverse();
            goto L30
        L15:
            if (r5.intValue() != 1) goto L17;
            this.a.T().getAnimator().b();
            goto L30
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopTopTabPresenter a;

        public d(ECShopTopTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Pair) r3) == null) goto L10;
            ECShopTopTabPresenter r4 = this.a;
            if (r4.z != (-1)) goto L9;
            r4.T().getAnimator().b();
            this.a.z = 1;
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopTopTabPresenter a;

        public e(ECShopTopTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ECStoreTabAreaVO r4 = (ECStoreTabAreaVO) r3;
            int r5 = com.bytedance.android.shopping.store.home.e0.a;
            if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() != 1) goto L5;
        L8:
            boolean r6 = true;
        L9:
            if (r6 == true) goto L11;
            return;
        L11:
            if (this.a.K() == false) goto L15;
            this.a.T().getAnimator().a(1, new t3(this));
            return;
        L15:
            return;
        L5:
            if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() == 2) goto L8;
            r6 = false;
            goto L9
        }
    }

    static {
    }

    public ECShopTopTabPresenter() {
        this(null);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r1) {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        uj3.j r0 = this.x;
        if (r0 == null) goto L12;
        ECStoreViewModel r1 = T();
        String r2 = r0.a(y());
        PageFinder r3 = PageFinder.via(y());
        Map<String, String> r4 = r0.n;
        if (r4 != null) goto L7;
        r4 = MapsKt.emptyMap();
    L7:
        uj3.j r5 = T().getCurrentTab();
        if (r5 == null) goto L10;
        String r6 = r5.b();
    L11:
        r1.doAnyEventActionWithBtm(r2, r3, "stay_store_page_tab", MapsKt.plus(r4, MapsKt.mapOf(TuplesKt.to("tab_name", r6))), new Pair[0]);
        goto L12
    L10:
        r6 = null;
    L12:
        this.u = 0;
    }

    /* JADX WARN: Type inference failed for: r4v24, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.facebook.drawee.view.GenericDraweeView] */
    public final void r0() {
        ECTabLayout r1 = this.v;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L5:
        int r2 = r1.getTabCount();
        com.bytedance.android.shopping.store.tabkit.f r3 = this.B;
        if (r3 == null) goto L8;
        TabKitViewModel r4 = r3.getTabKitViewModel();
    L10:
        if (r4 == null) goto L18;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.k> r5 = r4.getCurrentHomeTab();
        if (r5 == null) goto L18;
        com.bytedance.android.shopping.store.tabkit.model.k r6 = (com.bytedance.android.shopping.store.tabkit.model.k) r5.getValue();
        if (r6 == null) goto L18;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r7 = r6.m();
        if (r7 == null) goto L18;
        int r8 = r7.size();
    L19:
        boolean r9 = true;
        if (r8 <= 1) goto L26;
        ECTabLayout r10 = this.v;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L24:
        r10.setVisibility(0);
    L36:
        int r11 = 0;
    L37:
        if (r11 >= r2) goto L197;
        ECTabLayout r12 = this.v;
        if (r12 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L41:
        ECTabLayout.Tab r13 = r12.getTabAt(r11);
        if (r13 == null) goto L44;
        View r14 = r13.getCustomView();
    L46:
        if ((r14 instanceof TopTabItemView) == true) goto L48;
        r14 = null;
    L48:
        TopTabItemView r15 = (TopTabItemView) r14;
        if (r15 == null) goto L195;
        com.bytedance.android.shopping.store.tabkit.model.k r16 = r15.getTab();
        ECStoreViewModel r17 = T();
        if (r16 == null) goto L54;
        Integer r18 = r16.n();
    L55:
        uj3.j r19 = r17.getTab(r18);
        if (r19 == null) goto L195;
        boolean r110 = Intrinsics.areEqual(r19, this.x);
        uj3.j r111 = this.x;
        if (r111 != null) goto L61;
    L63:
        boolean r112 = false;
    L64:
        boolean r113 = r19.d();
        TextView r114 = r15.getTitleTV();
        r114.setText(r19.e);
        boolean r115 = p0();
        int r116 = com.bytedance.android.ec.core.utils.s.a;
        com.bytedance.android.shopping.store.home.entity.n r20 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r20 == null) goto L69;
        com.bytedance.android.shopping.store.home.entity.p r21 = r20.h;
        if (r21 == null) goto L69;
        String r22 = r21.g();
    L70:
        Integer r23 = com.bytedance.android.ec.core.utils.s.b(r22);
        if (r110 == false) goto L96;
        if (q0() == true) goto L91;
        com.bytedance.android.shopping.extensions.f.e(r114, 500);
        if (r23 != null) goto L77;
        if (r112 == false) goto L86;
        if (r115 == false) goto L86;
        r114.setTextColor(-1);
    L115:
        ?? r24 = r15.getIconView();
        if (q0() == false) goto L121;
        r24.setAdjustMode(1);
        if (r110 == false) goto L120;
        wg.a.d(r24, com.bytedance.android.shopping.extensions.b.b(18));
        goto L121
    L120:
        wg.a.d(r24, com.bytedance.android.shopping.extensions.b.b(16));
    L121:
        r24.setAutoPlayAnimation(true);
        if (r110 == false) goto L136;
        if (r16 == null) goto L130;
        com.bytedance.android.shopping.store.tabkit.model.x r25 = r16.o();
        if (r25 == null) goto L130;
        com.bytedance.android.shopping.store.tabkit.model.w r26 = r25.c();
        if (r26 == null) goto L130;
        ECUrlModel r27 = r26.a();
        if (r27 == null) goto L130;
    L150:
        if (r113 == true) goto L152;
    L168:
        ECUrlModel r117 = r27;
    L169:
        if (r117 == null) goto L179;
        String r28 = r117.getFirstUrl();
        if (r28 != null) goto L173;
    L176:
        boolean r29 = true;
    L177:
        if (r29 == true) goto L179;
        boolean r30 = true;
    L180:
        if (r30 == false) goto L191;
        r114.setVisibility(8);
        r15.setPadding(0, 0, 0, 0);
        r24.setVisibility(0);
        r24.setAlpha(1.0f);
        com.bytedance.android.ec.core.imagex.h0.d(r24, r117, T().getImageCallerContext(), null, null, null, null, 120);
        if (this.w == true) goto L184;
    L189:
        int r31 = 0;
        r24.setColorFilter(0);
    L193:
        if (q0() == false) goto L195;
        r15.setPadding(com.bytedance.android.shopping.extensions.b.b(16), r31, com.bytedance.android.shopping.extensions.b.b(16), r31);
        goto L195
    L184:
        if (q0() == true) goto L189;
        r24.setColorFilter(-1);
        if (r110 == true) goto L188;
        r24.setAlpha(0.75f);
    L188:
        r31 = 0;
        goto L193
    L191:
        r31 = 0;
        r114.setVisibility(0);
        r24.setVisibility(8);
        y().requestLayout();
        goto L193
    L173:
        if (StringsKt.isBlank(r28) == true) goto L176;
        r29 = false;
    L179:
        r30 = false;
        goto L180
    L152:
        if (this.w == false) goto L168;
        if (r110 == true) goto L168;
        if (r16 == null) goto L161;
        com.bytedance.android.shopping.store.tabkit.model.x r32 = r16.o();
        if (r32 == null) goto L161;
        com.bytedance.android.shopping.store.tabkit.model.w r33 = r32.c();
        if (r33 == null) goto L161;
        r27 = r33.a();
        if (r27 != null) goto L168;
    L161:
        if (r16 == null) goto L167;
        com.bytedance.android.shopping.store.tabkit.model.x r34 = r16.o();
        if (r34 == null) goto L167;
        com.bytedance.android.shopping.store.tabkit.model.w r35 = r34.c();
        if (r35 == null) goto L167;
        r27 = r35.b();
    L167:
        r117 = null;
    L130:
        if (r16 == null) goto L149;
        com.bytedance.android.shopping.store.tabkit.model.x r36 = r16.o();
        if (r36 == null) goto L149;
        com.bytedance.android.shopping.store.tabkit.model.w r37 = r36.c();
        if (r37 == null) goto L149;
        r27 = r37.b();
    L149:
        r27 = null;
        goto L150
    L136:
        if (r16 == null) goto L143;
        com.bytedance.android.shopping.store.tabkit.model.x r38 = r16.o();
        if (r38 == null) goto L143;
        com.bytedance.android.shopping.store.tabkit.model.w r39 = r38.b();
        if (r39 == null) goto L143;
        r27 = r39.a();
        if (r27 != null) goto L150;
    L143:
        if (r16 == null) goto L149;
        com.bytedance.android.shopping.store.tabkit.model.x r40 = r16.o();
        if (r40 == null) goto L149;
        com.bytedance.android.shopping.store.tabkit.model.w r41 = r40.b();
        if (r41 == null) goto L149;
        r27 = r41.b();
    L86:
        if (this.w == true) goto L88;
    L90:
        r114.setTextColor(-15329245);
        goto L115
    L88:
        if (q0() == true) goto L90;
        r114.setTextColor(-1);
        goto L115
    L77:
        if (this.w == true) goto L79;
    L81:
        r114.setTextColor(r23.intValue());
        r114.setAlpha(1.0f);
        goto L115
    L79:
        if (q0() == true) goto L81;
        r114.setTextColor(-1);
        goto L115
    L91:
        r114.setTextColor(-14477802);
        com.bytedance.android.shopping.extensions.f.e(r114, 600);
        if (j0() == false) goto L94;
        r114.setTextSize(2, 17.0f);
        goto L115
    L94:
        r114.setTextSize(2, 19.0f);
        goto L115
    L96:
        if (q0() == true) goto L114;
        com.bytedance.android.shopping.extensions.f.e(r114, 500);
        if (r23 != null) goto L100;
        if (r112 == false) goto L109;
        if (r115 == false) goto L109;
        r114.setTextColor(-1056964609);
    L109:
        if (this.w == true) goto L111;
    L113:
        r114.setTextColor(-1089071069);
        goto L115
    L111:
        if (q0() == true) goto L113;
        r114.setTextColor(-1056964609);
        goto L115
    L100:
        if (this.w == true) goto L102;
    L104:
        r114.setTextColor(r23.intValue());
        r114.setAlpha(0.75f);
        goto L115
    L102:
        if (q0() == true) goto L104;
        r114.setTextColor(-1056964609);
        goto L115
    L114:
        r114.setTextColor(-1726605277);
        r114.setTextSize(2, 16.0f);
        com.bytedance.android.shopping.extensions.f.e(r114, 400);
    L69:
        r22 = null;
        goto L70
    L61:
        if (r111.d() != r9) goto L63;
        r112 = true;
        goto L64
    L54:
        r18 = null;
    L195:
        r11 = r11 + 1;
        r9 = true;
        goto L37
    L44:
        r14 = null;
        goto L46
    L197:
        if (q0() == true) goto L199;
        String r42 = null;
        int r43 = com.bytedance.android.ec.core.utils.s.a;
        com.bytedance.android.shopping.store.home.entity.n r44 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r44 == null) goto L225;
        com.bytedance.android.shopping.store.home.entity.p r45 = r44.h;
        if (r45 == null) goto L225;
        String r46 = r45.g();
    L226:
        Integer r47 = com.bytedance.android.ec.core.utils.s.b(r46);
        uj3.j r48 = this.x;
        if (r48 == null) goto L231;
        String r49 = r48.m;
        if (r49 == null) goto L231;
        Integer r50 = com.bytedance.android.ec.core.utils.s.b(r49);
    L232:
        com.bytedance.android.shopping.store.home.entity.n r51 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r51 == null) goto L237;
        com.bytedance.android.shopping.store.home.entity.p r52 = r51.h;
        if (r52 == null) goto L237;
        r42 = r52.f();
    L237:
        Integer r53 = com.bytedance.android.ec.core.utils.s.b(r42);
        uj3.j r54 = this.x;
        if (r54 != null) goto L240;
    L242:
        if (r50 == null) goto L245;
        r47 = r50;
    L245:
        boolean r55 = this.w;
        if (r55 == true) goto L258;
        if (r47 == null) goto L258;
        Drawable r56 = this.y;
        if (r56 == null) goto L278;
        LayerDrawable r57 = (LayerDrawable) r56;
        Drawable r58 = r57.getDrawable(0);
        if (r58 == null) goto L257;
        ((GradientDrawable) r58).setColor(r47.intValue());
        ECTabLayout r59 = this.v;
        if (r59 != null) goto L255;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L255:
        r59.setSelectedTabIndicator(r57);
        return;
    L257:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L278:
        return;
    L258:
        if (r55 == false) goto L260;
    L266:
        ECTabLayout r60 = this.v;
        if (r60 != null) goto L269;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L269:
        r60.setSelectedTabIndicator(2131234844);
        return;
    L260:
        if (p0() == true) goto L266;
        ECTabLayout r61 = this.v;
        if (r61 != null) goto L265;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L265:
        r61.setSelectedTabIndicator(2131234843);
        return;
    L240:
        if (r54.d() != true) goto L242;
        r47 = r53;
    L231:
        r50 = null;
    L225:
        r46 = null;
        goto L226
    L199:
        if (j0() == false) goto L216;
        Drawable r62 = this.y;
        if (r62 == null) goto L275;
        LayerDrawable r63 = (LayerDrawable) r62;
        Drawable r64 = r63.getDrawable(0);
        if (r64 == null) goto L215;
        GradientDrawable r65 = (GradientDrawable) r64;
        Integer r66 = com.bytedance.android.ec.core.utils.s.b("#FF003C");
        if (r66 == null) goto L207;
        r65.setColor(r66.intValue());
    L207:
        ECTabLayout r67 = this.v;
        if (r67 != null) goto L210;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L210:
        r67.setSelectedTabIndicator(r63);
        ECTabLayout r68 = this.v;
        if (r68 != null) goto L213;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L213:
        r68.setIndicatorBottomMargin(com.bytedance.android.shopping.extensions.b.b(4));
        return;
    L215:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L275:
        return;
    L216:
        ECTabLayout r69 = this.v;
        if (r69 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L219:
        r69.setSelectedTabIndicator(null);
        return;
    L26:
        if (q0() == false) goto L32;
        ECTabLayout r70 = this.v;
        if (r70 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L30:
        r70.setVisibility(8);
        return;
    L32:
        ECTabLayout r71 = this.v;
        if (r71 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L35:
        r71.setVisibility(4);
    L18:
        r8 = 0;
        goto L19
    L8:
        r4 = null;
        goto L10
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        T().setTabStartTimestamp(SystemClock.elapsedRealtime());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        ECStoreViewModel r0 = T();
        if (r0.getCurrentTab() == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        this.u += SystemClock.elapsedRealtime() - T().getTabStartTimestamp();
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean q0() {
        if (Intrinsics.areEqual((Boolean) T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L5;
    L8:
        return true;
    L5:
        if (T().isMiddleTabFramework() == true) goto L8;
        return false;
    }

    public ECShopTopTabPresenter(com.bytedance.android.shopping.store.tabkit.f r2) {
        if ((r2 instanceof Fragment) == true) goto L5;
        com.bytedance.android.shopping.store.tabkit.f r0 = null;
    L6:
        super((Fragment) r0);
        this.B = r2;
        return;
    L5:
        r0 = r2;
        goto L6
    }

    public final void A(QModel r4) {
        T().getHeaderArea().a(W(), new b(this), false);
        if (T().getStoreParam().isSplitMode() == false) goto L5;
        View r5 = y().findViewById(2131371148);
        com.bytedance.android.ec.core.utils.d2.d(r5, 0, 0, 0, 0);
        wg.a.d(r5, com.bytedance.android.shopping.extensions.b.b(44));
    L5:
        T().getProductScrollState().a(W(), new c(this), false);
        T().getSelectedTabLocation().a(W(), new d(this), false);
        T().getTabArea().a(W(), new e(this), false);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void f(ECTabLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        r0();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void k(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void l(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void o(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "tab");
        if (r11.getCustomView() == null) goto L5;
        boolean r13 = true;
    L6:
        Map<String, String> r2 = null;
        if (r13 == true) goto L10;
        r11 = null;
    L10:
        if (r11 == null) goto L91;
        ECStoreViewModel r14 = T();
        View r15 = r11.getCustomView();
        if (r15 == null) goto L90;
        com.bytedance.android.shopping.store.tabkit.model.k r16 = ((TopTabItemView) r15).getTab();
        if (r16 == null) goto L16;
        Integer r17 = r16.n();
    L17:
        uj3.j r18 = r14.getTab(r17);
        if (r18 != null) goto L20;
        return;
    L20:
        this.x = r18;
        r0();
        com.bytedance.android.shopping.store.tabkit.f r19 = this.B;
        if (r19 == null) goto L23;
        TabKitViewModel r110 = r19.getTabKitViewModel();
    L24:
        if (r110 == null) goto L26;
        TabKitTabFragment r111 = r110.getCurrentSelectedFragment();
    L27:
        ECStoreViewModel r3 = T();
        com.bytedance.android.shopping.store.tabkit.f r4 = this.B;
        if (r4 == null) goto L30;
        TabKitViewModel r5 = r4.getTabKitViewModel();
    L31:
        if (r5 == null) goto L35;
        com.bytedance.android.shopping.store.tabkit.model.k r6 = r5.getLastTab();
        if (r6 == null) goto L35;
        Integer r7 = r6.n();
    L36:
        uj3.j r8 = r3.getTab(r7);
        if (T().getStoreParam().getProductBasicRequestParam().getCustomIds() == null) goto L49;
        if (r18.i() == false) goto L49;
        if ((r111 instanceof ECStoreProductTabFragment) == false) goto L49;
        if (T().getShowedFlag() == true) goto L49;
        if (T().getStoreParam().getViewProductTab() == true) goto L47;
        T().getStoreParam().setViewProductTab(true);
        goto L49
    L47:
        y().post(new u3(r111));
        T().getStoreParam().setViewProductTab(false);
        T().setShowedFlag(true);
    L49:
        if (r18.d != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L51;
        boolean r112 = true;
    L53:
        if (r8 == null) goto L64;
        if (r112 == false) goto L56;
    L58:
        boolean r9 = false;
    L59:
        if (r9 == false) goto L61;
        uj3.j r10 = r8;
    L62:
        if (r10 == null) goto L64;
        com.bytedance.android.ec.core.monitor.q r20 = new com.bytedance.android.ec.core.monitor.q(MonitorScenes.EC_STORE_FPS, r10.b(), null);
        Map r21 = com.bytedance.android.ec.core.monitor.c.a;
        Intrinsics.checkNotNullParameter(r20, "monitorSceneWrapper");
        ApmAgent.removePerfTag("e_commerce", r20.a);
        com.bytedance.android.ec.core.monitor.c.i(r20);
        goto L64
    L61:
        r10 = null;
        goto L62
    L56:
        if (r8.e() == false) goto L58;
        r9 = true;
    L64:
        if (r112 == false) goto L66;
    L68:
        boolean r22 = false;
    L69:
        if (r22 == true) goto L72;
        r18 = null;
    L72:
        if (r18 == null) goto L74;
        com.bytedance.android.ec.core.monitor.q r23 = new com.bytedance.android.ec.core.monitor.q(MonitorScenes.EC_STORE_FPS, r18.b(), null);
        Map r113 = com.bytedance.android.ec.core.monitor.c.a;
        Intrinsics.checkNotNullParameter(r23, "monitorSceneWrapper");
        ApmAgent.addPerfTag("e_commerce", r23.a);
        com.bytedance.android.ec.core.monitor.c.g(r23);
    L74:
        if (r112 == false) goto L76;
        T().getStoreEventContext().post("click_consultation", new Map[]{MapsKt.mapOf(TuplesKt.to("click_area", "bottom_bar"))});
    L76:
        if (r112 == true) goto L92;
        this.u += SystemClock.elapsedRealtime() - T().getTabStartTimestamp();
        ECStoreViewModel r24 = T();
        if (r8 == null) goto L80;
        String r114 = r8.a(y());
    L81:
        if (r114 != null) goto L83;
        r114 = "";
    L83:
        String r25 = r114;
        PageFinder r26 = PageFinder.via(y());
        if (r8 == null) goto L86;
        r2 = r8.n;
    L86:
        if (r2 != null) goto L88;
        r2 = MapsKt.emptyMap();
    L88:
        r24.doAnyEventActionWithBtm(r25, r26, "stay_store_page_tab", MapsKt.plus(r2, MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(this.u)))), new Pair[0]);
        this.u = 0;
        T().setTabStartTimestamp(SystemClock.elapsedRealtime());
        return;
    L80:
        r114 = null;
        goto L81
    L92:
        return;
    L66:
        if (r18.e() == false) goto L68;
        r22 = true;
        goto L69
    L51:
        r112 = false;
    L35:
        r7 = null;
        goto L36
    L30:
        r5 = null;
        goto L31
    L26:
        r111 = null;
        goto L27
    L23:
        r110 = null;
        goto L24
    L16:
        r17 = null;
        goto L17
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.view.TopTabItemView");
    L91:
        return;
    L5:
        r13 = false;
        goto L6
    }
}
