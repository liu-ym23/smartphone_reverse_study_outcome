package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.entity.StoreUITheme;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.home.view.SearchHotWordFlipperAdapter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopTopBarSearchPresenterV2 extends ECShopBasePresenter implements View.OnClickListener {
    public static final int N = 0;
    public static final int O = 0;
    public boolean A;
    public Pair<Integer, Integer> B;
    public Integer C;
    public Integer D;
    public Pair<Integer, Integer> E;
    public Pair<Integer, Integer> F;
    public Pair<Integer, Integer> G;
    public int[] H;
    public int[] I;
    public final int[] J;
    public final Function2<Integer, Integer, Unit> K;
    public final Lazy L;
    public Integer M;
    public ECStoreCollapsibleTextView u;
    public LinearLayout v;
    public ImageView w;
    public ECViewFlipper x;
    public View y;
    public final SearchHotWordFlipperAdapter z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

        public b(ECShopTopBarSearchPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ImageView r0 = (ImageView) this.a.y().findViewById(2131371064);
            if (((Boolean) r3).booleanValue() == false) goto L5;
            r0.setImageResource(2131248082);
            return;
        L5:
            r0.setImageResource(2131248088);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

        public c(ECShopTopBarSearchPresenterV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Lazy r2 = ECStoreFoldPhoneHelper.a;
            ECStoreFoldPhoneHelper.c(this.a.h);
        }
    }

    public static final class d implements ECStoreCollapsibleTextView.c {
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

        public static final class a implements Runnable {
            public final /* synthetic */ TextView a;

            public a(TextView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Lazy r0 = TransitionAnimationHelper.a;     // Catch: Throwable -> L4
                TextView r1 = this.a;     // Catch: Throwable -> L4
                TransitionAnimationHelper.e(r1, r1.getHeight() / 2, false);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements ECViewFlipper.IOnPositionChangeListener {
            public final /* synthetic */ d a;

            public b(d r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper.IOnPositionChangeListener
            public final void onPositionChange(int r1, int r2) {
                ECViewFlipper r3 = this.a.a.x;
                if (r3 == null) goto L5;
                int r4 = r3.getCurrentPos();
            L6:
                if (r4 != (-1)) goto L8;
                return;
            L8:
                SearchSuggestWord r5 = this.a.a.z.y2(r4);
                if (r5 != null) goto L11;
                return;
            L11:
                this.a.a.v0(r5);
                return;
            L5:
                r4 = -1;
                goto L6
            }
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final Drawable b() {
            return ECShopTopBarSearchPresenterV2.q0(this.a);
        }

        public d(ECShopTopBarSearchPresenterV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final TextView c(ECStoreCollapsibleTextView r5) {
            Intrinsics.checkNotNullParameter(r5, "parentView");
            TextView r0 = new TextView(r5.getContext());
            if (this.a.u0() == false) goto L5;
        L8:
            LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
            r6.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
        L9:
            r0.setLayoutParams(r6);
            if (this.a.u0() == false) goto L12;
            r0.setPadding(com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3));
        L13:
            r0.post(new a(r0));
            return r0;
        L12:
            r0.setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(4));
            goto L13
        L5:
            if (ECShopABSettings.getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() != 0) goto L8;
            r6 = new LinearLayout.LayoutParams(-2, -2);
            r6.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper] */
        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final View d(ECStoreCollapsibleTextView r13) {
            Intrinsics.checkNotNullParameter(r13, "parentView");
            if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L8;
            LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(0), -1);
            r0.weight = 1.0f;
            FrameLayout r1 = new FrameLayout(r13.getContext());
            r1.setLayoutParams(r0);
            ?? r2 = new ECViewFlipper(r13.getContext(), null, 0, 6, null);
            this.a.x = r2;
            r2.setPositionChangeListener(new b(this));
            r2.setScrollSpeed(800);
            r2.setInterval(3000);
            r2.setViewFlipperAdapter(this.a.z);
            Unit r3 = Unit.INSTANCE;
            r1.addView(r2);
            if (this.a.T().needShowServiceEntryInNavigationBar() == true) goto L7;
            ECShopTopBarSearchPresenterV2 r4 = this.a;
            View r5 = new View(r13.getContext());
            FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(14), -1);
            r14.topMargin = com.bytedance.android.shopping.extensions.b.b(2);
            r14.bottomMargin = com.bytedance.android.shopping.extensions.b.b(2);
            r14.gravity = 8388613;
            r5.setBackground(new com.bytedance.android.shopping.store.home.view.t(new int[]{0, -1}));
            r1.addView(r5, r14);
            r4.y = r5;
        L7:
            return r1;
        L8:
            TextView r6 = new TextView(r13.getContext());
            r6.setTextSize(2, 13.0f);
            LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(0), -2);
            r15.weight = 1.0f;
            r6.setMaxLines(1);
            r6.setEllipsize(null);
            r6.setLayoutParams(r15);
            return r6;
        }

        @Override // com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView.c
        public final void a(ECStoreCollapsibleTextView r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Drawable r7 = r5.getBackground();
            if ((r7 instanceof com.bytedance.android.shopping.store.home.view.a) == true) goto L5;
            Drawable r0 = null;
        L6:
            com.bytedance.android.shopping.store.home.view.a r1 = (com.bytedance.android.shopping.store.home.view.a) r0;
            if (r1 == null) goto L10;
            r1.h = r6 / 2.0f;
            r1.invalidateSelf();
        L10:
            if ((r7 instanceof GradientDrawable) == true) goto L12;
            r7 = null;
        L12:
            GradientDrawable r8 = (GradientDrawable) r7;
            if (r8 == null) goto L16;
            r8.setCornerRadius(r6 / 2.0f);
            return;
        L16:
            return;
        L5:
            r0 = r7;
            goto L6
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

        public e(ECShopTopBarSearchPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r20) {
            com.bytedance.android.shopping.store.home.entity.n r1 = (com.bytedance.android.shopping.store.home.entity.n) r20;
            if (r1 == null) goto L191;
            ViewParent r3 = null;
            this.a.M = null;
            if (r1.c() == false) goto L16;
            ECStoreCollapsibleTextView r2 = this.a.u;
            if (r2 == null) goto L10;
            r2.setVisibility(8);
        L10:
            LinearLayout r4 = this.a.v;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
        L13:
            if (r4 == null) goto L16;
            r4.setVisibility(8);
        L16:
            if (r1.d() == false) goto L25;
            ECStoreCollapsibleTextView r5 = this.a.u;
            if (r5 == null) goto L20;
            r5.setVisibility(8);
        L20:
            LinearLayout r6 = this.a.v;
            if (r6 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
        L23:
            if (r6 == null) goto L185;
            r6.setVisibility(8);
            return;
        L185:
            return;
        L25:
            ECShopTopBarSearchPresenterV2 r7 = this.a;
            com.bytedance.android.shopping.store.home.entity.g r8 = r1.e;
            boolean r9 = true;
            if (r8 != null) goto L28;
        L30:
            boolean r10 = false;
        L31:
            r7.getClass();
            if (r10 == true) goto L40;
            ECStoreCollapsibleTextView r11 = r7.u;
            if (r11 == null) goto L36;
            r11.setVisibility(8);
        L36:
            LinearLayout r12 = this.a.v;
            if (r12 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
        L39:
            r12.setVisibility(8);
            return;
        L40:
            ECStoreCollapsibleTextView r13 = r7.u;
            if (r13 == null) goto L75;
            r13.g(0.0f);
            Lazy r14 = ECAppInfoService.a;
            if (we.a.a == false) goto L45;
        L52:
            r13.c(th.a.e(r7.u().c(), true).getResources().getString(2131895924), false);
            if (r7.u0() == false) goto L74;
            SimpleDraweeView r15 = r13.c;
            if (r15 == null) goto L64;
            ViewGroup.LayoutParams r16 = r15.getLayoutParams();
            if ((r16 instanceof LinearLayout.LayoutParams) == true) goto L59;
            r16 = null;
        L59:
            LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r16;
            if (r17 == null) goto L62;
            int r18 = com.bytedance.android.shopping.extensions.b.b(8);
            int r19 = ECStoreCollapsibleTextView.q;
            r17.setMargins(r18, r19, com.bytedance.android.shopping.extensions.b.b(2), r19);
            Unit r21 = Unit.INSTANCE;
        L63:
            r15.setLayoutParams(r17);
            goto L64
        L62:
            r17 = null;
        L64:
            TextView r22 = r13.g;
            if (r22 == null) goto L74;
            r22.setPadding(com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(4), com.bytedance.android.shopping.extensions.b.b(3));
            ViewGroup.LayoutParams r110 = r22.getLayoutParams();
            if ((r110 instanceof LinearLayout.LayoutParams) == true) goto L69;
            r110 = null;
        L69:
            LinearLayout.LayoutParams r111 = (LinearLayout.LayoutParams) r110;
            if (r111 == null) goto L72;
            r111.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
            Unit r23 = Unit.INSTANCE;
        L73:
            r22.setLayoutParams(r111);
            goto L74
        L72:
            r111 = null;
        L74:
            r13.setSearchTextViewListener(new e3(r7));
            goto L75
        L45:
            if (r7.u0() == true) goto L52;
            r13.b(2131247539, null);
            r13.a(null);
            if (r7.F() == false) goto L49;
        L51:
            r13.setSearchCameraClickListener(new d3(r7));
            goto L52
        L49:
            if (r7.A == true) goto L51;
            r7.T().doAnyEventActionWithBtm("a1.b6269.c5887.d51683", PageFinder.via(r7.y()), "photo_search_icon_show", MapsKt.mapOf(TuplesKt.to("current_page", "shop_search_page")), new Pair[0]);
            r7.A = true;
        L75:
            r7.T().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_store")});
            r7.T().doEventAction("shop_search_entrance_show", new Pair[]{TuplesKt.to("enter_from", "search_store"), TuplesKt.to("type", "bar")});
            ECStoreCollapsibleTextView r24 = r7.u;
            if (r24 == null) goto L164;
            int r25 = com.bytedance.android.ec.core.utils.s.a;
            com.bytedance.android.shopping.store.home.entity.e r26 = r1.b;
            if (r26 == null) goto L84;
            com.bytedance.android.shopping.store.home.entity.s r27 = r26.l;
            if (r27 == null) goto L84;
            com.bytedance.android.shopping.store.home.entity.u r28 = r27.a();
            if (r28 == null) goto L84;
            String r29 = r28.b();
        L85:
            r7.C = com.bytedance.android.ec.core.utils.s.b(r29);
            com.bytedance.android.shopping.store.home.entity.e r30 = r1.b;
            if (r30 == null) goto L92;
            com.bytedance.android.shopping.store.home.entity.s r31 = r30.l;
            if (r31 == null) goto L92;
            com.bytedance.android.shopping.store.home.entity.u r32 = r31.a();
            if (r32 == null) goto L92;
            String r33 = r32.a();
        L93:
            r7.D = com.bytedance.android.ec.core.utils.s.b(r33);
            int[] r34 = new int[2];
            Integer r35 = r7.C;
            int r36 = 16664938;
            if (r35 == null) goto L96;
            int r37 = r35.intValue();
        L97:
            r34[0] = r37;
            Integer r38 = r7.C;
            if (r38 == null) goto L100;
            r36 = r38.intValue();
        L100:
            r34[1] = r36;
            r7.I = r34;
            int[] r39 = new int[2];
            Integer r40 = r7.C;
            int r41 = 3951489;
            if (r40 == null) goto L103;
            int r42 = r40.intValue();
        L104:
            r39[0] = r42;
            Integer r43 = r7.C;
            if (r43 == null) goto L107;
            r41 = r43.intValue();
        L107:
            r39[1] = r41;
            r7.H = r39;
            int r44 = (int) 3205896227L;
            boolean r45 = r7.p0();
            boolean r46 = r7.F();
            com.bytedance.android.shopping.store.home.entity.n r112 = (com.bytedance.android.shopping.store.home.entity.n) r7.T().getHeaderArea().getValue();
            if (r112 == null) goto L112;
            com.bytedance.android.shopping.store.home.entity.p r113 = r112.h;
            if (r113 == null) goto L112;
            String r114 = r113.g();
        L113:
            Integer r115 = com.bytedance.android.ec.core.utils.s.b(r114);
            int r116 = -15329245;
            if (r45 == false) goto L116;
            r7.B = new Pair(Integer.valueOf(r44), 1461065763);
            int r47 = (int) 3875536895L;
            r7.F = new Pair(Integer.valueOf(r47), Integer.valueOf(r47));
        L118:
            int r48 = -1073741825;
        L121:
            if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L124;
            r7.F = new Pair(-1, -1);
        L124:
            if (r115 == null) goto L126;
            r116 = r115.intValue();
        L126:
            r7.G = new Pair(Integer.valueOf(r116), Integer.valueOf(r48));
            Integer r49 = r7.T().getStoreParam().getStoreUITheme();
            int r50 = StoreUITheme.DefaultDark.ordinal();
            if (r49 == null) goto L141;
            if (r49.intValue() != r50) goto L141;
            Integer r51 = r7.D;
            if (r51 == null) goto L134;
            int r52 = r51.intValue();
        L135:
            Integer r53 = Integer.valueOf(r52);
            Integer r54 = r7.D;
            if (r54 == null) goto L138;
            int r55 = r54.intValue();
        L139:
            r7.E = new Pair(r53, Integer.valueOf(r55));
        L156:
            ECStoreCollapsibleTextView.b r56 = new ECStoreCollapsibleTextView.b(((Number) r7.F.getFirst()).intValue(), ((Number) r7.F.getSecond()).intValue(), ((Number) r7.B.getFirst()).intValue(), ((Number) r7.B.getSecond()).intValue(), (Integer) r7.E.getFirst(), (Integer) r7.E.getSecond(), null, null);
            if (ECShopABSettings.getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() == 0) goto L163;
            r56.g = null;
            Integer r57 = com.bytedance.android.ec.core.utils.s.b("#FFFF7075");
            Integer r117 = com.bytedance.android.ec.core.utils.s.b("#FFFF3344");
            if (r57 == null) goto L162;
            if (r117 == null) goto L162;
            r56.h = new com.bytedance.android.shopping.store.home.view.t(new int[]{r57.intValue(), r117.intValue()});
        L162:
            r56.e = com.bytedance.android.ec.core.utils.s.b("#FFFF3344");
            r56.f = com.bytedance.android.ec.core.utils.s.b("#FFFFFFFF");
        L163:
            Unit r58 = Unit.INSTANCE;
            r24.setStyleConfig(r56);
            goto L164
        L138:
            r55 = (int) 4294916946L;
            goto L139
        L134:
            r52 = (int) 4294916946L;
        L141:
            if (Intrinsics.areEqual(r7.T().isFlagShip(), Boolean.TRUE) == false) goto L151;
            Integer r59 = r7.D;
            if (r59 == null) goto L145;
            int r60 = r59.intValue();
        L146:
            Integer r61 = Integer.valueOf(r60);
            Integer r118 = r7.D;
            if (r118 == null) goto L149;
            int r62 = r118.intValue();
        L150:
            r7.E = new Pair(r61, Integer.valueOf(r62));
            goto L156
        L149:
            r62 = (int) 4282141569L;
            goto L150
        L145:
            r60 = (int) 4282141569L;
            goto L146
        L151:
            Integer r63 = r7.D;
            if (r63 == null) goto L154;
            int r64 = r63.intValue();
        L155:
            r7.E = new Pair(Integer.valueOf(r64), Integer.valueOf(r44));
            goto L156
        L154:
            r64 = (int) 4294916946L;
            goto L155
        L116:
            if (r46 == false) goto L119;
            r7.B = new Pair(Integer.valueOf(r44), 1447971);
            r7.F = new Pair(-1, -1);
            goto L118
        L119:
            r7.B = new Pair(Integer.valueOf(r44), 1461065763);
            r7.F = new Pair(-1, -1);
            r48 = -15329245;
        L112:
            r114 = null;
            goto L113
        L103:
            r42 = 3951489;
            goto L104
        L96:
            r37 = 16664938;
        L92:
            r33 = null;
        L84:
            r29 = null;
        L164:
            ECStoreCollapsibleTextView r65 = r7.u;
            if (r65 != null) goto L167;
        L173:
            r7.w0();
            r7.T().getTopSearchInfo().a(r7.W(), new g3(r7), false);
            r7.T().getSelectedTabLocation().a(r7.W(), new h3(r7), false);
            r7.T().getCollapseFactor().a(r7.W(), new i3(r7), false);
            r7.T().getLiveState().a(r7.W(), new j3(r7), false);
            r7.T().getHeaderArea().a(r7.W(), new k3(r7), false);
            if (r7.T().needShowServiceEntryInNavigationBar() == false) goto L188;
            View r66 = r7.y;
            if (r66 == null) goto L189;
            ViewParent r67 = r66.getParent();
            if ((r67 instanceof ViewGroup) == false) goto L181;
            r3 = r67;
        L181:
            ViewGroup r68 = (ViewGroup) r3;
            if (r68 == null) goto L190;
            r68.removeView(r66);
            return;
        L190:
            return;
        L189:
            return;
        L188:
            return;
        L167:
            if (r7.G() == false) goto L169;
        L172:
            r65.setCollapseEnable(r9);
            goto L173
        L169:
            if (r7.T().couldVideoV2() == true) goto L172;
            r9 = false;
            goto L172
        L28:
            if (r8.e != true) goto L30;
            r10 = true;
            goto L31
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

        public f(ECShopTopBarSearchPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Float r9 = (Float) r8;
            if (this.a.T().needShopProfilePin2Top() == false) goto L86;
            this.a.w().b(2131371160).f().setVisibility(0);
            if (r9 == null) goto L8;
            float r10 = r9.floatValue();
        L9:
            float r11 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r10, 0.0f), 1.0f);
            int r3 = this.a.t0();
            int r4 = (int) ((((com.bytedance.android.shopping.extensions.b.b(102) + r3) - com.bytedance.android.shopping.extensions.b.b(48)) * r11) + com.bytedance.android.shopping.extensions.b.b(48));
            this.a.x0(r11, r3);
            ECShopTopBarSearchPresenterV2.r0(this.a, r11, r3);
            ECShopTopBarSearchPresenterV2 r5 = this.a;
            if (r5.u0() == true) goto L14;
            ECStoreCollapsibleTextView r6 = r5.u;
            if (r6 == null) goto L14;
            com.bytedance.android.ec.core.utils.d2.c(r6, r4);
        L14:
            boolean r7 = true;
            if (ECShopABSettings.getEC_SHOP_SEARCH_BAR_UI_OPTIMIZE() == 0) goto L63;
            float r0 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - (2 * r11), 1.0f), 0.0f);
            ECStoreCollapsibleTextView r2 = this.a.u;
            if (r2 == null) goto L19;
            r2.h(r0);
        L19:
            ECStoreCollapsibleTextView r12 = this.a.u;
            if (r12 == null) goto L54;
            if (r11 <= 0.5f) goto L25;
            r7 = false;
        L25:
            float r13 = Math.abs(r0);
            ECStoreCollapsibleTextView.b r14 = r12.b;
            Integer r15 = null;
            if (r14 == null) goto L34;
            if (r7 == false) goto L31;
            Drawable r16 = r14.g;
            if (r16 != null) goto L35;
            r16 = new ColorDrawable(0);
        L35:
            if (r16 == null) goto L39;
            TextView r1 = r12.g;
            if (r1 == null) goto L39;
            r1.setBackground(r16);
        L39:
            if (r7 == false) goto L43;
            ECStoreCollapsibleTextView.b r17 = r12.b;
            if (r17 == null) goto L46;
            r15 = r17.e;
        L46:
            if (r15 == null) goto L50;
            int r18 = r15.intValue();
            TextView r19 = r12.g;
            if (r19 == null) goto L50;
            r19.setTextColor(r18);
        L50:
            TextView r20 = r12.g;
            if (r20 == null) goto L54;
            r20.setAlpha(r13);
            goto L54
        L43:
            ECStoreCollapsibleTextView.b r21 = r12.b;
            if (r21 == null) goto L46;
            r15 = r21.f;
            goto L46
        L31:
            r16 = r14.h;
            if (r16 != null) goto L35;
            r16 = new ColorDrawable(0);
            goto L35
        L34:
            r16 = null;
        L54:
            if (this.a.u0() == false) goto L59;
            ECStoreCollapsibleTextView r22 = this.a.u;
            if (r22 == null) goto L77;
            r22.f(r11);
            return;
        L77:
            return;
        L59:
            if (this.a.T().needShowServiceEntryInNavigationBar() == false) goto L79;
            ECShopTopBarSearchPresenterV2 r23 = this.a;
            ECStoreCollapsibleTextView r24 = r23.u;
            if (r24 == null) goto L80;
            r24.j(r0, r23.K);
            return;
        L80:
            return;
        L79:
            return;
        L63:
            float r25 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - (3 * r11), 1.0f), 0.0f);
            ECStoreCollapsibleTextView r26 = this.a.u;
            if (r26 == null) goto L67;
            r26.h(r25);
        L67:
            if (this.a.u0() == false) goto L72;
            ECStoreCollapsibleTextView r27 = this.a.u;
            if (r27 == null) goto L82;
            r27.f(r11);
            return;
        L82:
            return;
        L72:
            if (this.a.T().needShowServiceEntryInNavigationBar() == false) goto L84;
            ECShopTopBarSearchPresenterV2 r28 = this.a;
            ECStoreCollapsibleTextView r29 = r28.u;
            if (r29 == null) goto L85;
            r29.j(r25, r28.K);
            return;
        L85:
            return;
        L84:
            return;
        L8:
            r10 = 0.0f;
            goto L9
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

        public g(ECShopTopBarSearchPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            Pair r8 = (Pair) r7;
            if (this.a.T().needShopProfilePin2Top() == false) goto L32;
            Float r9 = (Float) this.a.T().getUpglideFactor().getValue();
            if (r9 == null) goto L8;
            float r10 = r9.floatValue();
        L9:
            float r11 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r10, 0.0f), 1.0f);
            int r2 = this.a.t0();
            int r3 = (int) ((((com.bytedance.android.shopping.extensions.b.b(102) + r2) - com.bytedance.android.shopping.extensions.b.b(48)) * r11) + com.bytedance.android.shopping.extensions.b.b(48));
            float r0 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - (3 * r11), 1.0f), 0.0f);
            this.a.x0(r11, r2);
            ECShopTopBarSearchPresenterV2.r0(this.a, r11, r2);
            ECShopTopBarSearchPresenterV2 r1 = this.a;
            if (r1.u0() == true) goto L14;
            ECStoreCollapsibleTextView r4 = r1.u;
            if (r4 == null) goto L14;
            com.bytedance.android.ec.core.utils.d2.c(r4, r3);
        L14:
            ECStoreCollapsibleTextView r5 = this.a.u;
            if (r5 == null) goto L18;
            r5.h(r0);
        L18:
            if (this.a.u0() == false) goto L23;
            ECStoreCollapsibleTextView r6 = this.a.u;
            if (r6 == null) goto L28;
            r6.f(r11);
            return;
        L28:
            return;
        L23:
            if (this.a.T().needShowServiceEntryInNavigationBar() == false) goto L30;
            ECShopTopBarSearchPresenterV2 r12 = this.a;
            ECStoreCollapsibleTextView r13 = r12.u;
            if (r13 == null) goto L31;
            r13.j(r0, r12.K);
            return;
        L31:
            return;
        L30:
            return;
        L8:
            r10 = 0.0f;
            goto L9
        }
    }

    public final boolean u0() {
        return ((Boolean) this.L.getValue()).booleanValue();
    }

    static {
        N = com.bytedance.android.shopping.extensions.b.b(72);
        O = com.bytedance.android.shopping.extensions.b.b(114);
    }

    public final int t0() {
        com.bytedance.android.shopping.store.viewmodel.i r0 = T().getViewTransitShipment().a.get(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.g.class));
        Integer r2 = null;
        if ((r0 instanceof com.bytedance.android.shopping.store.viewmodel.g) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.shopping.store.viewmodel.g r1 = (com.bytedance.android.shopping.store.viewmodel.g) r0;
        if (u0() == false) goto L35;
        Integer r3 = this.M;
        if (r3 != null) goto L10;
        if (r1 == null) goto L15;
        ECShopMarqueeTextView r4 = r1.getView();
        if (r4 == null) goto L15;
        CharSequence r5 = r4.getText();
    L16:
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
        if (r1 == null) goto L29;
        View r7 = r1.getContainerView();
        if (r7 == null) goto L29;
        r2 = Integer.valueOf(ArraysKt.first(com.bytedance.android.shopping.store.utils.d.a(r7)));
    L29:
        int r8 = com.bytedance.android.shopping.extensions.k.g(r2, 0);
        if (r8 <= 0) goto L34;
        int r9 = RangesKt.coerceAtMost(r8, O);
        this.M = Integer.valueOf(r9);
        return r9;
    L34:
        return O;
    L24:
        return O;
    L18:
        if (StringsKt.isBlank(r5) == true) goto L21;
        r6 = false;
    L15:
        r5 = null;
        goto L16
    L10:
        return r3.intValue();
    L35:
        if (r1 == null) goto L39;
        AppCompatTextView r10 = r1.getView();
        if (r10 == null) goto L39;
        Integer r11 = Integer.valueOf(ArraysKt.first(com.bytedance.android.shopping.store.utils.d.a(r10)));
    L40:
        int r12 = com.bytedance.android.shopping.extensions.k.g(r11, 0);
        if (r1 == null) goto L46;
        ECTagListView r13 = r1.b();
        if (r13 == null) goto L46;
        r2 = Integer.valueOf(r13.getMeasuredWidth());
    L46:
        return Math.max(r12, com.bytedance.android.shopping.extensions.k.g(r2, 0));
    L39:
        r11 = null;
        goto L40
    }

    public final void w0() {
        Integer r0 = T().getStoreParam().getStoreUITheme();
        int r1 = StoreUITheme.DefaultDark.ordinal();
        if (r0 == null) goto L11;
        if (r0.intValue() != r1) goto L11;
        ECStoreCollapsibleTextView r2 = this.u;
        if (r2 == null) goto L19;
        r2.setStrokeColor(this.J);
        return;
    L19:
        return;
    L11:
        if (Intrinsics.areEqual(T().isFlagShip(), Boolean.TRUE) == false) goto L15;
        ECStoreCollapsibleTextView r3 = this.u;
        if (r3 == null) goto L21;
        r3.setStrokeColor(this.H);
        return;
    L21:
        return;
    L15:
        ECStoreCollapsibleTextView r4 = this.u;
        if (r4 == null) goto L23;
        r4.setStrokeColor(this.I);
        return;
    }

    public ECShopTopBarSearchPresenterV2(Fragment r7) {
        super(r7);
        this.z = new SearchHotWordFlipperAdapter();
        this.B = new Pair(Integer.valueOf((int) 2568362019L), 1447971);
        this.E = new Pair(Integer.valueOf((int) 4294916946L), 16726866);
        int r1 = (int) 4294967295L;
        this.F = new Pair(Integer.valueOf(r1), Integer.valueOf(r1));
        this.G = new Pair(-15329245, -1073741825);
        int r2 = (int) 4282141569L;
        this.H = new int[]{r2, r2};
        int r3 = (int) 4294855018L;
        this.I = new int[]{r3, r3};
        this.J = new int[]{16777215, 16777215};
        this.K = new ECShopTopBarSearchPresenterV2$reportSearchTextShow$1(this);
        this.L = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECShopTopBarSearchPresenterV2$isAppletTopBarMode$2.INSTANCE);
    }

    public static final com.bytedance.android.shopping.store.home.view.a q0(ECShopTopBarSearchPresenterV2 r7) {
        com.bytedance.android.shopping.store.home.entity.n r0 = (com.bytedance.android.shopping.store.home.entity.n) r7.T().getHeaderArea().getValue();
        com.bytedance.android.shopping.store.home.view.a r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.e r2 = r0.b;
        if (r2 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.s r3 = r2.l;
        if (r3 == null) goto L11;
        com.bytedance.android.shopping.store.home.entity.u r4 = r3.a();
        if (r4 == null) goto L11;
        Integer r5 = r4.c();
    L13:
        if (r5 == null) goto L19;
        if (r5.intValue() != 1) goto L19;
        int r6 = (int) 4294930546L;
        r1 = new com.bytedance.android.shopping.store.home.view.a(new int[]{r6, (int) 4294948713L, (int) 4294938805L, (int) 4294938768L, r6}, com.bytedance.android.shopping.extensions.b.b(1), -1);
    L19:
        if ((r1 instanceof com.bytedance.android.shopping.store.home.view.a) == false) goto L27;
        ECStoreCollapsibleTextView r8 = r7.u;
        if (r8 == null) goto L23;
        float r9 = r8.getHeight() / 2;
    L25:
        if (r9 <= 0) goto L27;
        r1.h = r9;
        r1.invalidateSelf();
        goto L27
    L23:
        r9 = 0.0f;
    L27:
        return r1;
    L11:
        r5 = null;
        goto L13
    }

    public final void A(QModel r6) {
        ECStoreCollapsibleTextView r7 = (ECStoreCollapsibleTextView) w().b(2131371165).f();
        this.u = r7;
        r7.setComponentCreator(new d(this));
        this.v = (LinearLayout) y().findViewById(2131371166);
        this.w = (ImageView) y().findViewById(2131371167);
        if (T().getStoreParam().isSplitMode() == false) goto L5;
        View r8 = y().findViewById(2131371063);
        T().isBrandShop().a(W(), new b(this), false);
        r8.setVisibility(0);
        r8.setOnClickListener(new c(this));
        com.bytedance.android.ec.core.utils.d2.d(y().findViewById(2131371165), com.bytedance.android.shopping.extensions.b.b(44), 0, 0, 0);
    L6:
        ECStoreCollapsibleTextView r9 = this.u;
        if (r9 == null) goto L9;
        r9.setOnClickListener(this);
    L9:
        ImageView r10 = this.w;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallIconView");
    L12:
        r10.setOnClickListener(this);
        Lazy r11 = ECAppInfoService.a;
        if (we.a.a == false) goto L18;
        ImageView r12 = this.w;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallIconView");
    L17:
        r12.setImageResource(2131234841);
    L18:
        T().getHeaderArea().a(W(), new e(this), false);
        T().getUpglideFactor().a(W(), new f(this), false);
        T().getSelectedTabLocation().a(W(), new g(this), false);
        return;
    L5:
        y().findViewById(2131371063).setVisibility(8);
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        Intrinsics.checkNotNullParameter(r13, "v");
        int r0 = kn.a.a;
        if (kn.a.a(r13.getId()) == false) goto L5;
        return;
    L5:
        if (V() == true) goto L8;
        return;
    L8:
        if (T().getStoreParam().isPreview() == false) goto L11;
        return;
    L11:
        if (ECShopABSettings.getEC_SHOP_SEARCH_HOT_WORD_SCROLL() == 0) goto L13;
        boolean r1 = true;
    L14:
        String r10 = null;
        String r11 = "";
        if (r1 == false) goto L34;
        SearchHotWordFlipperAdapter r2 = this.z;
        ECViewFlipper r3 = this.x;
        if (r3 == null) goto L27;
        Integer r4 = Integer.valueOf(r3.getCurrentPos());
        if (r4.intValue() < 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        int r6 = r4.intValue();
    L28:
        SearchSuggestWord r7 = r2.y2(r6);
        if (r7 == null) goto L34;
        String r8 = r7.getWord();
        if (r8 == null) goto L34;
        String r9 = r8;
    L35:
        ECShopBasePresenter.l0(this, "", r9, Integer.valueOf(r13.getId()), null, null, 24);
        ECViewFlipper r14 = this.x;
        if (r14 == null) goto L38;
        int r15 = r14.getCurrentPos();
    L39:
        if (r15 >= 0) goto L41;
    L43:
        SearchSuggestWord r16 = null;
    L44:
        if (r16 == null) goto L46;
        ECUrlModel r12 = r16.getIcon();
    L47:
        if (r12 == null) goto L49;
        boolean r17 = true;
    L50:
        ECStoreViewModel r18 = T();
        Pair<String, String>[] r19 = new Pair[4];
        r19[0] = TuplesKt.to("enter_from", "search_store");
        r19[1] = TuplesKt.to("type", "text");
        if (r16 == null) goto L53;
        r10 = r16.getWord();
    L53:
        if (r10 == null) goto L56;
        r11 = r10;
    L56:
        r19[2] = TuplesKt.to("hint", r11);
        if (r17 == false) goto L59;
        String r110 = CommentScene.COMMENTSCENE_NO_AWEME;
    L60:
        r19[3] = TuplesKt.to("hot_icon_type", r110);
        r18.doEventAction("shop_search_entrance_click", r19);
        return;
    L59:
        r110 = "0";
        goto L60
    L49:
        r17 = false;
        goto L50
    L46:
        r12 = null;
        goto L47
    L41:
        if (r15 >= this.z.getItemCount()) goto L43;
        r16 = this.z.y2(r15);
        goto L44
    L38:
        r15 = -1;
        goto L39
    L21:
        r5 = false;
    L27:
        r6 = 0;
    L34:
        r9 = "";
        goto L35
    L13:
        r1 = false;
        goto L14
    }

    public final void v0(SearchSuggestWord r9) {
        ECStoreViewModel r0 = T();
        PageFinder r2 = PageFinder.via(this.u);
        Pair[] r4 = new Pair[3];
        r4[0] = TuplesKt.to("module_name", "top_title_bar_search_hint_word");
        r4[1] = TuplesKt.to("shop_id", T().getStoreParam().getShopId());
        String r10 = r9.getWord();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r4[2] = TuplesKt.to("words_content", r10);
        r0.doAnyEventActionWithBtm("a1.b6269.c5887.d2396", r2, "show_ecom_component", MapsKt.mapOf(r4), new Pair[0]);
    }

    public static final void s0(ECShopTopBarSearchPresenterV2 r9, float r10) {
        if (r10 >= 0.0f) goto L5;
        r9.getClass();
        return;
    L5:
        float r2 = 1.0f - r9.a0(0.5f);
        if (r2 == 1.0f) goto L8;
    L35:
        r9.w0();
    L37:
        if (r10 != 0.0f) goto L39;
    L44:
        View r11 = r9.y;
        if (r11 == null) goto L47;
        r11.setVisibility(0);
    L47:
        ECStoreCollapsibleTextView r12 = r9.u;
        if (r12 == null) goto L50;
        r12.e(r2);
    L50:
        int r13 = ColorUtils.blendARGB(((Number) r9.G.getFirst()).intValue(), ((Number) r9.G.getSecond()).intValue(), r2);
        ImageView r1 = r9.w;
        if (r1 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallIconView");
    L53:
        r1.setColorFilter(r13);
        if (r2 == 0.0f) goto L56;
        return;
    L56:
        if (r9.A == true) goto L66;
        Map r14 = BtmSDK.INSTANCE.createReportParams("a1.b6269.c5887.d51683", PageFinder.via(r9.y()));
        ArrayList r0 = new ArrayList(r14.size());
        Iterator r15 = r14.entrySet().iterator();
    L59:
        if (r15.hasNext() == false) goto L61;
        Map.Entry r3 = (Map.Entry) r15.next();
        r0.add(TuplesKt.to(r3.getKey(), String.valueOf(r3.getValue())));
        goto L59
    L61:
        r9.T().doEventAction("photo_search_icon_show", MapsKt.toMap(r0), new Pair[]{TuplesKt.to("current_page", "shop_search_page")});
        r9.A = true;
        return;
    L66:
        return;
    L39:
        if (r10 == 1.0f) goto L44;
        View r16 = r9.y;
        if (r16 == null) goto L47;
        r16.setVisibility(8);
        goto L47
    L8:
        if (r9.T().isCroppedStyle() == true) goto L35;
        ECStoreCollapsibleTextView r5 = r9.u;
        if (r5 == null) goto L12;
        r5.setStrokeColor(r9.J);
    L12:
        ECStoreCollapsibleTextView r6 = r9.u;
        Integer r7 = null;
        if (r6 == null) goto L15;
        Drawable r8 = r6.getBackground();
    L16:
        com.bytedance.android.shopping.store.home.entity.n r17 = (com.bytedance.android.shopping.store.home.entity.n) r9.T().getHeaderArea().getValue();
        if (r17 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.e r18 = r17.b;
        if (r18 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.s r19 = r18.l;
        if (r19 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.u r20 = r19.a();
        if (r20 == null) goto L25;
        r7 = r20.c();
    L25:
        if (r7 == null) goto L37;
        if (r7.intValue() != 1) goto L37;
        if ((r8 instanceof com.bytedance.android.shopping.store.home.view.a) == false) goto L37;
        com.bytedance.android.shopping.store.home.view.a r21 = (com.bytedance.android.shopping.store.home.view.a) r8;
        int[] r22 = r9.J;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "colors");
        if (r22.length < 2) goto L37;
        r21.g = r22;
        r21.a();
        r21.invalidateSelf();
        goto L37
    L15:
        r8 = null;
        goto L16
    }

    public final void x0(float r3, int r4) {
        if (u0() == true) goto L5;
        return;
    L5:
        View r0 = y().findViewById(2131371160);
        int r5 = RangesKt.coerceAtLeast((int) (r4 * r3), 0);
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.width != r5) goto L11;
        return;
    L11:
        r6.width = r5;
        r0.setLayoutParams(r6);
    }

    public static final void r0(ECShopTopBarSearchPresenterV2 r3, float r4, int r5) {
        if (r3.u0() == false) goto L21;
        ECStoreCollapsibleTextView r6 = r3.u;
        if (r6 == null) goto L22;
        int r0 = N + ((int) (r5 * RangesKt.coerceIn(r4, 0.0f, 1.0f)));
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r7 = null;
    L11:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 != null) goto L15;
        return;
    L15:
        if (r8.leftMargin == r0) goto L17;
    L19:
        r8.leftMargin = r0;
        r8.setMarginStart(r0);
        r6.setLayoutParams(r8);
        return;
    L17:
        if (r8.getMarginStart() != r0) goto L19;
        return;
    L22:
        return;
    }
}
