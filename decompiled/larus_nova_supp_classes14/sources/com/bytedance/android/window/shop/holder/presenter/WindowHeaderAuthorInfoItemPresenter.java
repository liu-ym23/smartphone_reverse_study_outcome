package com.bytedance.android.window.shop.holder.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.transition.Fade;
import androidx.transition.Scene;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.repository.vo.WindowAuthorReputationVO;
import com.bytedance.android.ec.window.base.setting.WindowSettingKeys;
import com.bytedance.android.ec.window.base.view.ECWindowLiveCircleView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.header.WindowHybridListOperationPlugin;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.dto.b1;
import com.bytedance.android.window.shop.repository.dto.z;
import com.bytedance.android.window.shop.repository.header.utils.WindowHeaderStrategy;
import com.bytedance.android.window.shop.repository.vo.WindowLabelType;
import com.bytedance.android.window.shop.widget.WindowHeaderNumItemCard;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/holder/presenter/WindowHeaderAuthorInfoItemPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBaseFragmentPresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/window/shop/home/header/WindowHybridListOperationPlugin$b;", "expandState", "", "updateExpandState", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderAuthorInfoItemPresenter extends ECWindowHolderBaseFragmentPresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int q = 0;
    public View i;
    public ViewGroup j;
    public SimpleDraweeView k;
    public LinearLayout l;
    public oq3.a m;
    public boolean n;
    public final Set<Integer> o;
    public final LinkedHashSet<ECWindowHolderBaseFragmentPresenter> p;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ uq3.d a;
        public final /* synthetic */ WindowHeaderAuthorInfoItemPresenter b;
        public final /* synthetic */ ViewGroup c;

        public b(uq3.d r1, WindowHeaderAuthorInfoItemPresenter r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            uq3.d r7 = this.a;
            if (r7 == null) goto L7;
            String r8 = r7.a;
            if (r8 == null) goto L7;
        L8:
            int r0 = zq3.f.a;
            WindowHeaderAuthorInfoItemPresenter r1 = this.b;
            int r2 = WindowHeaderAuthorInfoItemPresenter.q;
            Context r3 = null;
            String r9 = zq3.f.c(r8, "a1.b7635.c2240.d52491", PageFinder.via(r1.a0()), null);
            com.bytedance.android.ec.sdk.helper.p r4 = com.bytedance.android.ec.sdk.helper.p.a;
            QContext r5 = this.b.Y();
            Context r10 = l0.c(r5.c());
            if ((r10 instanceof FragmentActivity) == false) goto L12;
            r3 = r10;
        L12:
            if (r3 != null) goto L14;
            r3 = r5.a();
        L14:
            r4.openSchema(r3, r9);
            return;
        L7:
            r8 = "";
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter
    public final View h0() {
        View r0 = this.f;
        if (r0 != null) goto L11;
        View r1 = a0();
        if ((r1 instanceof ViewGroup) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L10;
        r0 = r2.getChildAt(0);
        goto L11
    L10:
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return a0();
    }

    public final void c0() {
        s0.e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final void b0(QModel r28) {
        this.f = a0();
        s0.c(this);
        QModel r1 = r28;
        if ((r1 instanceof oq3.a) == true) goto L5;
        r1 = null;
    L5:
        oq3.a r2 = (oq3.a) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        if (this.n == true) goto L289;
        this.m = r2;
        e0().getLifecycle().addObserver(this);
        this.i = h0().findViewById(2131371309);
        this.k = h0().findViewById(2131376605);
        this.j = (ViewGroup) h0().findViewById(2131378860);
        this.l = (LinearLayout) h0().findViewById(2131371296);
        h0().findViewById(2131376606).setOnClickListener(this);
        h0().findViewById(2131393031).setOnClickListener(this);
        h0().findViewById(2131371296).setOnClickListener(this);
        h0().findViewById(2131371306).setOnClickListener(this);
        uq3.a r3 = (uq3.a) d0().getHeaderResponse().getValue();
        if (r3 == null) goto L12;
        uq3.o r4 = r3.c;
    L13:
        TextView r5 = (TextView) h0().findViewById(2131391420);
        TextView r6 = (TextView) h0().findViewById(2131390976);
        SimpleDraweeView r7 = h0().findViewById(2131371272);
        if (r4 == null) goto L16;
        String r8 = r4.l;
    L17:
        r6.setText(r8);
        z r15 = r2.s;
        if (r15 == null) goto L20;
        ?? r9 = 0;
        h0.d(r7, r15.d(), d0().getImageCallerContext(), null, null, null, null, 120);
        r7.setOnClickListener(new g(r15, this));
        r7.setVisibility(0);
    L22:
        if (r2.r == null) goto L24;
    L25:
        r5.setTextSize(1, 18.0f);
        r6.setTextSize(1, 18.0f);
    L26:
        if (r4 == null) goto L28;
        String r10 = r4.k;
    L30:
        if (r10 != null) goto L32;
        r10 = "";
    L32:
        r5.setText(r10);
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == true) goto L35;
        r11 = null;
    L35:
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r12 == null) goto L38;
        ((ViewGroup.MarginLayoutParams) r12).width = r9;
        r5.setLayoutParams(r12);
    L38:
        ViewGroup r13 = this.j;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("shopNameWrapper");
    L41:
        r13.post(new h(this, r5, r4));
        LinearLayout r14 = (LinearLayout) h0().findViewById(2131371255);
        if (r14 == 0) goto L62;
        r14.removeAllViews();
        List<uq3.d> r16 = r2.q;
        List<uq3.d> r17 = r16;
        if (r17 != null) goto L47;
    L50:
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
        r14.setVisibility(8);
        goto L62
    L53:
        r14.setVisibility(r9);
        Iterator<T> r19 = r16.iterator();
    L55:
        if (r19.hasNext() == false) goto L62;
        List<uq3.i> r20 = ((uq3.d) r19.next()).c;
        if (r20 == null) goto L55;
        Iterator<T> r21 = r20.iterator();
    L60:
        if (r21.hasNext() == false) goto L55;
        i0(r14, (uq3.i) r21.next());
        goto L60
    L47:
        if (r17.isEmpty() == true) goto L50;
        r18 = false;
    L62:
        View r22 = this.i;
        if (r22 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("liveClickArea");
    L65:
        r22.setOnClickListener(this);
        b1 r23 = r2.g;
        if (r23 == null) goto L68;
        Integer r24 = Integer.valueOf(r23.d());
    L70:
        if (r24 != null) goto L73;
    L74:
        boolean r25 = true;
    L76:
        if (r25 == true) goto L79;
        r24 = null;
    L79:
        if (r24 == null) goto L84;
        int r26 = r24.intValue();
        View r27 = this.i;
        if (r27 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("liveClickArea");
    L83:
        wg.a.d(r27, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r26)));
    L84:
        com.bytedance.android.ec.hybrid.list.entity.j r29 = r2.h;
        if (r29 == null) goto L100;
        Double r30 = r29.c;
        if (r30 == null) goto L100;
        if (r30.doubleValue() <= ((double) r9)) goto L91;
        boolean r31 = true;
    L92:
        if (r31 == true) goto L95;
        r30 = null;
    L95:
        if (r30 == null) goto L100;
        double r32 = r30.doubleValue();
        View r33 = this.i;
        if (r33 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("liveClickArea");
    L99:
        wg.a.d(r33, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r32)));
        goto L100
    L91:
        r31 = false;
    L100:
        uq3.a r34 = (uq3.a) d0().getHeaderResponse().getValue();
        if (r34 == null) goto L103;
        uq3.o r35 = r34.c;
    L104:
        b1 r36 = r2.g;
        if (r36 == null) goto L107;
        int r37 = r36.d();
    L112:
        Integer r38 = Integer.valueOf(r37);
    L114:
        if (r35 == null) goto L128;
        if (r35.a() != true) goto L128;
        if (com.bytedance.android.shopping.extensions.k.g(r38, r9) <= 52) goto L128;
        View r39 = h0().findViewById(2131371263);
        ImageView r40 = (ImageView) h0().findViewById(2131371314);
        SimpleDraweeView r41 = h0().findViewById(2131371264);
        r39.setVisibility(r9);
        r40.setVisibility(r9);
        a0().requestLayout();
        ImageRequest r42 = ImageRequestBuilder.newBuilderWithResourceId(2131234909).build();
        r41.setController(Fresco.newDraweeControllerBuilder().setImageRequest(r42).setAutoPlayAnimations(true).build());
        Boolean r43 = (Boolean) d0().getLiveManager().m.a();
        if (r43 == null) goto L122;
        boolean r44 = r43.booleanValue();
    L123:
        if (r44 == false) goto L125;
        int r45 = 2131234890;
    L126:
        r40.setImageResource(r45);
        r40.setOnClickListener(new d(this));
        d0().getLiveManager().m.c(e0(), new e(this, r40), r9);
        goto L128
    L125:
        r45 = 2131234891;
        goto L126
    L122:
        r44 = true;
    L128:
        if (Intrinsics.areEqual(((QFragmentPresenter) this).e.getTag(), String.valueOf(WindowHeaderStrategy.ONLY_SHOW_IN_SPLIT.getStrategy())) == false) goto L138;
        int r46 = com.bytedance.android.shopping.extensions.b.b(44);
        SimpleDraweeView r47 = this.k;
        if (r47 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("headImg");
    L132:
        ViewParent r48 = r47.getParent();
        if ((r48 instanceof RoundedFrameLayout) == true) goto L135;
        r48 = null;
    L135:
        RoundedFrameLayout r49 = (RoundedFrameLayout) r48;
        if (r49 == null) goto L138;
        wg.a.i(r49, r46);
        wg.a.d(r49, r46);
        r49.setRadius(r46 / 2);
    L138:
        SimpleDraweeView r50 = this.k;
        if (r50 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("headImg");
    L141:
        h0.d(r50, r2.k, d0().getImageCallerContext(), null, null, null, null, 120);
        SimpleDraweeView r51 = this.k;
        if (r51 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("headImg");
    L144:
        r51.setOnClickListener(this);
        GenericDraweeView r52 = (ECDraweeView) h0().findViewById(2131371273);
        if (r52 == 0) goto L150;
        z r53 = r2.n;
        if (r53 == null) goto L149;
        ECUrlModel r210 = r53.a();
        String r54 = r53.b();
        r52.setVisibility(r9);
        h0.d(r52, r210, d0().getImageCallerContext(), null, null, null, null, 120);
        r52.setOnClickListener(new f(r54, this));
        goto L150
    L149:
        r52.setVisibility(8);
    L150:
        LinearLayout r55 = (LinearLayout) h0().findViewById(2131370949);
        List<uq3.d> r56 = r2.p;
        if (r56 == null) goto L170;
        Iterator<T> r57 = r56.iterator();
        int r110 = 0;
    L154:
        if (r57.hasNext() == false) goto L168;
        Object r111 = r57.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L158;
        CollectionsKt.throwIndexOverflow();
    L158:
        uq3.d r113 = (uq3.d) r111;
        if (r110 < 1) goto L161;
        View r114 = new View(Y().c());
        r114.setBackgroundColor(Y().c().getResources().getColor(2131105934));
        r55.addView(r114, new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(1), com.bytedance.android.shopping.extensions.b.b(12)));
        wg.a.f(r114, com.bytedance.android.shopping.extensions.b.b(6), com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), com.bytedance.android.shopping.extensions.b.b(6), r9);
    L161:
        List<uq3.i> r58 = r113.c;
        if (r58 == null) goto L167;
        Iterator<T> r59 = r58.iterator();
    L165:
        if (r59.hasNext() == false) goto L167;
        uq3.i r115 = (uq3.i) r59.next();
        TextView r116 = new TextView(Y().c());
        r116.setPadding(r115.d, r9, r115.e, r9);
        r116.setText(r115.b);
        r116.setTextSize(1, 12.0f);
        r116.setTextColor(r115.c);
        r116.setMaxLines(1);
        r116.setEllipsize(TextUtils.TruncateAt.END);
        r55.addView(r116, new ViewGroup.LayoutParams(-2, -2));
    L167:
        r110 = r112;
        goto L154
    L168:
        Unit r60 = Unit.INSTANCE;
    L177:
        List<uq3.d> r61 = r2.q;
        if (r61 != null) goto L180;
    L183:
        boolean r62 = true;
    L184:
        if (r62 == true) goto L194;
        Iterator r63 = com.bytedance.commerce.base.view.b.a(r55).iterator();
    L187:
        if (r63.hasNext() == false) goto L191;
        int r117 = 8;
        if (((View) r63.next()).getVisibility() == 8) goto L187;
        boolean r64 = true;
    L192:
        if (r64 == true) goto L194;
        r55.setVisibility(r117);
        goto L194
    L191:
        r117 = 8;
        r64 = false;
    L194:
        Boolean r65 = r2.j;
        Boolean r66 = Boolean.TRUE;
        if (Intrinsics.areEqual(r65, r66) == true) goto L203;
        if (Intrinsics.areEqual(r65, Boolean.FALSE) == false) goto L200;
        k0(r2);
        goto L203
    L200:
        if (r65 != null) goto L203;
        k0(r2);
    L203:
        if (d0().couldLive() == true) goto L206;
    L222:
        Boolean r67 = r2.j;
        if (Intrinsics.areEqual(r67, r66) == false) goto L268;
        List<uq3.r> r68 = r2.o;
        if (r68 == null) goto L263;
        List r69 = CollectionsKt.take(r68, 2);
        ArrayList r70 = new ArrayList();
        Iterator r71 = r69.iterator();
        int r72 = 0;
    L228:
        if (r71.hasNext() == false) goto L264;
        Object r73 = r71.next();
        int r74 = r72 + 1;
        if (r72 >= 0) goto L232;
        CollectionsKt.throwIndexOverflow();
    L232:
        uq3.r r75 = (uq3.r) r73;
        StringBuilder r76 = new StringBuilder();
        String r118 = r75.c;
        if (r118 != null) goto L235;
        r118 = "";
    L235:
        r76.append(r118);
        String r119 = r75.a;
        if (r119 != null) goto L238;
        r119 = "";
    L238:
        r76.append(r119);
        String r120 = r75.b;
        if (r120 != null) goto L241;
        r120 = "";
    L241:
        r76.append(r120);
        String r77 = r76.toString();
        if (r77 != null) goto L244;
    L247:
        boolean r78 = true;
    L248:
        if (r78 == false) goto L250;
        uq3.d r79 = null;
    L260:
        if (r79 == null) goto L262;
        r70.add(r79);
    L262:
        r72 = r74;
        goto L228
    L250:
        uq3.i[] r121 = new uq3.i[3];
        String r122 = r75.c;
        if (r122 != null) goto L253;
        r122 = "";
    L253:
        r121[r9] = new uq3.i(r122, -1, 6, r9);
        String r123 = r75.a;
        if (r123 != null) goto L256;
        r123 = "";
    L256:
        r121[1] = new uq3.i(r123, -1, 2, r9);
        String r80 = r75.b;
        if (r80 != null) goto L259;
        r80 = "";
    L259:
        r121[2] = new uq3.i(r80, -1, r9, 6);
        r79 = new uq3.d(CollectionsKt.listOf(r121));
        goto L260
    L244:
        if (StringsKt.isBlank(r77) == true) goto L247;
        r78 = false;
    L264:
        m0(r70);
        if (r70 == null) goto L272;
        r70.isEmpty();
    L272:
        j0("store_experience_score_show", null);
        this.n = true;
        return;
    L263:
        r70 = null;
        goto L264
    L268:
        if (Intrinsics.areEqual(r67, Boolean.FALSE) == true) goto L272;
        if (r67 != null) goto L272;
        m0(r2.r);
        goto L272
    L206:
        if (Intrinsics.areEqual((Boolean) d0().isLiveOn().getValue(), Boolean.FALSE) == true) goto L222;
        if (d0().isCroppedStyle() == true) goto L218;
        View r81 = h0().findViewById(2131393031);
        ViewGroup.LayoutParams r82 = r81.getLayoutParams();
        if ((r82 instanceof ViewGroup.MarginLayoutParams) == true) goto L213;
        r82 = null;
    L213:
        ViewGroup.MarginLayoutParams r83 = (ViewGroup.MarginLayoutParams) r82;
        if (r83 == null) goto L217;
        r83.setMarginStart(com.bytedance.android.shopping.extensions.b.b(4));
        r81.setLayoutParams(r83);
    L217:
        ECWindowLiveCircleView r84 = (ECWindowLiveCircleView) h0().findViewById(2131371289);
        r84.setVisibility(r9);
        r84.a();
        h0().findViewById(2131371290).setVisibility(r9);
    L218:
        SimpleDraweeView r85 = this.k;
        if (r85 != null) goto L221;
        Intrinsics.throwUninitializedPropertyAccessException("headImg");
    L221:
        r85.setOnClickListener(this);
        goto L222
    L180:
        if (r61.isEmpty() == true) goto L183;
        r62 = false;
        goto L184
    L170:
        if (r2.w == null) goto L174;
        TextView r86 = (TextView) h0().findViewById(2131393278);
        if (r86 == 0) goto L177;
        r86.setText(r2.w);
        r86.setVisibility(r9);
        goto L177
    L174:
        TextView r87 = (TextView) h0().findViewById(2131393278);
        if (r87 == null) goto L177;
        r87.setVisibility(8);
        Unit r88 = Unit.INSTANCE;
        goto L177
    L107:
        com.bytedance.android.ec.hybrid.list.entity.j r89 = r2.h;
        if (r89 == null) goto L113;
        Double r90 = r89.c;
        if (r90 == null) goto L113;
        r37 = (int) r90.doubleValue();
    L113:
        r38 = null;
        goto L114
    L103:
        r35 = null;
        goto L104
    L73:
        if (r24.intValue() != (-1)) goto L74;
        r25 = false;
        goto L76
    L68:
        r24 = null;
        goto L70
    L28:
        r10 = null;
        goto L30
    L24:
        if (Intrinsics.areEqual(((QFragmentPresenter) this).e.getTag(), String.valueOf(WindowHeaderStrategy.ONLY_SHOW_IN_SPLIT.getStrategy())) == false) goto L26;
    L20:
        r9 = 0;
        r7.setVisibility(8);
        Unit r91 = Unit.INSTANCE;
        goto L22
    L16:
        r8 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, com.bytedance.android.window.shop.widget.WindowHeaderNumItemCard] */
    public final void k0(oq3.a r9) {
        LinearLayout r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newReputationContainer");
    L5:
        r0.removeAllViews();
        List<uq3.r> r10 = r9.o;
        if (r10 == null) goto L59;
        List r11 = CollectionsKt.take(r10, 3);
        if (r11 == null) goto L59;
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L66;
        uq3.r r2 = (uq3.r) r12.next();
        Object r5 = null;
        View r3 = LayoutInflater.from(Y().c()).inflate(2131560998, null, false);
        if ((r3 instanceof WindowHeaderNumItemCard) == false) goto L16;
        r5 = r3;
    L16:
        ?? r6 = (WindowHeaderNumItemCard) r5;
        if (r6 == 0) goto L48;
        Intrinsics.checkNotNullParameter(r2, "data");
        String r4 = r2.a;
        if (r4 == null) goto L24;
        TextView r7 = r6.a;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("amountView");
    L23:
        r7.setText(r4);
    L28:
        String r8 = r2.b;
        if (r8 == null) goto L34;
        TextView r13 = r6.b;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("unitView");
    L33:
        r13.setText(r8);
    L38:
        String r14 = r2.c;
        if (r14 == null) goto L44;
        TextView r15 = r6.c;
        if (r15 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L43:
        r15.setText(r14);
        goto L48
    L44:
        TextView r16 = r6.c;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L47:
        r16.setVisibility(8);
        Unit r17 = Unit.INSTANCE;
        goto L48
    L34:
        TextView r18 = r6.b;
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("unitView");
    L37:
        r18.setVisibility(8);
        Unit r19 = Unit.INSTANCE;
        goto L38
    L24:
        TextView r20 = r6.a;
        if (r20 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("amountView");
    L27:
        r20.setVisibility(8);
        Unit r21 = Unit.INSTANCE;
    L48:
        LinearLayout r22 = this.l;
        if (r22 != 0) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("newReputationContainer");
    L51:
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(80), -2);
        r23.setMargins(0, com.bytedance.android.shopping.extensions.b.b(2), 0, 0);
        Unit r24 = Unit.INSTANCE;
        r22.addView(r6, r23);
        LinearLayout r25 = this.l;
        if (r25 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("newReputationContainer");
    L54:
        r25.setVisibility(0);
        View r26 = h0().findViewById(2131370894);
        ConstraintLayout.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L58;
        ConstraintLayout.LayoutParams r28 = r27;
        r28.bottomToBottom = 2131371296;
        r28.topToTop = 2131371296;
        ((ViewGroup.MarginLayoutParams) r28).height = com.bytedance.android.shopping.extensions.b.b(28);
        ((ViewGroup.MarginLayoutParams) r28).width = com.bytedance.android.shopping.extensions.b.b(68);
        r26.setLayoutParams(r27);
        goto L11
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L66:
        return;
    L59:
        LinearLayout r29 = this.l;
        if (r29 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("newReputationContainer");
    L62:
        r29.setVisibility(8);
    }

    public final void l0(String r8) {
        boolean r0 = d0().couldLive();
        Function1<hp3.b, Boolean> r1 = d0().getEventDeliverer();
        boolean r2 = true;
        if (r1 == null) goto L8;
        if (((Boolean) r1.invoke(jp3.a.b)).booleanValue() != true) goto L8;
        return;
    L8:
        if (r0 == false) goto L14;
        Function3<String, Boolean, String, Unit> r3 = d0().getJump2Live();
        if (r3 == null) goto L12;
        Unit r9 = (Unit) r3.invoke("live_cell_head", Boolean.FALSE, r8);
    L12:
        j0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to("click_area", "1031")));
        return;
    L14:
        if (d0().isCroppedStyle() == false) goto L27;
        Integer r10 = (Integer) d0().getCroppedState().getValue();
        if (r10 != null) goto L20;
    L26:
        r2 = false;
        goto L27
    L20:
        if (r10.intValue() != 2) goto L26;
        if (d0().getCollapseProgress().getValue() == null) goto L26;
        Object r11 = d0().getCollapseProgress().getValue();
        Intrinsics.checkNotNull(r11);
        if (Float.compare(((Number) r11).floatValue(), 0.75f) <= 0) goto L26;
    L27:
        if (r2 == true) goto L30;
    L38:
        j0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to("click_area", "1032")));
        return;
    L30:
        if (com.bytedance.android.shopping.extensions.k.c(d0().getShopParam().getAuthorId()) == false) goto L38;
        String r12 = "aweme://user/profile/" + d0().getShopParam().getAuthorId();
        int r4 = zq3.f.a;
        Context r5 = null;
        String r13 = zq3.f.c(r12, "a1.b7635.c2240.d0", PageFinder.via(a0()), null);
        com.bytedance.android.ec.sdk.helper.p r6 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r7 = Y();
        Context r14 = l0.c(r7.c());
        if ((r14 instanceof FragmentActivity) == false) goto L35;
        r5 = r14;
    L35:
        if (r5 != null) goto L37;
        r5 = r7.a();
    L37:
        r6.openSchema(r5, r13);
        goto L38
    }

    public final void m0(List<uq3.d> r11) {
        List<uq3.d> r0 = r11;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        ViewGroup r2 = (ViewGroup) h0().findViewById(2131371310);
        if (r2 == null) goto L14;
        r2.removeAllViews();
    L14:
        if (r2 == null) goto L16;
        r2.setVisibility(0);
    L16:
        Iterator<T> r12 = r11.iterator();
        int r3 = 0;
    L18:
        if (r12.hasNext() == false) goto L44;
        Object r4 = r12.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        uq3.d r6 = (uq3.d) r4;
        if (r6.b != WindowLabelType.Hybrid) goto L25;
        int r7 = 2131561015;
    L26:
        View r8 = th.a.d(th.a.e(Y().c(), true), r7, null, 4);
        if (r8 == null) goto L43;
        LinearLayout r9 = (LinearLayout) r8;
        List<uq3.i> r10 = r6.c;
        if (r10 == null) goto L35;
        Iterator<T> r13 = r10.iterator();
    L32:
        if (r13.hasNext() == false) goto L35;
        i0(r9, (uq3.i) r13.next());
    L35:
        if (r6.a == null) goto L37;
        r9.setOnClickListener(new b(r6, this, r2));
    L37:
        if (r2 == null) goto L39;
        r2.addView(r9);
    L39:
        if (r3 < 1) goto L41;
        wg.a.f(r9, com.bytedance.android.shopping.extensions.b.b(6), 0, 0, 0);
    L41:
        r3 = r5;
        goto L18
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    L25:
        r7 = 2131561016;
        goto L26
    L44:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r9.getId()) == false) goto L5;
        return;
    L5:
        Lazy r1 = ECAppInfoService.a;
        Context r3 = null;
        if (we.a.a == false) goto L50;
        int r2 = zq3.l.a;
        Gson r4 = zq3.c.a;
        Object r5 = Boolean.TRUE;
        if (zq3.c.b == false) goto L19;
        int r6 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        jj4.b r8 = jj4.b.b;     // Catch: Throwable -> L14
        Object r10 = jj4.a.a("ecom_window_saas_supported_jump_to_live", Boolean.class, r5, false);     // Catch: Throwable -> L14
        if (r10 != null) goto L46;
        Intrinsics.throwNpe();     // Catch: Throwable -> L14
    L46:
        if (((Boolean) r10).booleanValue() == false) goto L50;
        if (this.o.contains(Integer.valueOf(r9.getId())) == true) goto L50;
        return;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r12 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r12) == true) goto L44;
    L18:
        r5 = r12;
    L44:
        r10 = r5;
        goto L46
    L19:
        String r13 = hq7.d.b("debug.shopping.mock.ecom_window_saas_supported_jump_to_live");
        if (r13 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == false) goto L92;
    L34:
        r10 = null;
    L35:
        if (r10 != null) goto L46;
        int r15 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L41
        jj4.b r17 = jj4.b.b;     // Catch: Throwable -> L41
        r10 = jj4.a.a("ecom_window_saas_supported_jump_to_live", Boolean.class, r5, false);     // Catch: Throwable -> L41
        if (r10 != null) goto L46;
        Intrinsics.throwNpe();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r12) == false) goto L18;
    L92:
        r10 = zq3.c.a.fromJson(r13, new zq3.i().getType());     // Catch: Exception -> L32
        if (r10 == null) goto L34;
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L34
    L22:
        if (StringsKt.isBlank(r13) == true) goto L25;
        r14 = false;
    L50:
        int r19 = r9.getId();
        if (r19 != 2131371309) goto L59;
        if (d0().couldLive() == false) goto L96;
        Function3<String, Boolean, String, Unit> r20 = d0().getJump2Live();
        if (r20 == null) goto L57;
        Unit r21 = (Unit) r20.invoke(null, Boolean.FALSE, "a1.b7635.c4706.d3124");
    L57:
        d0().doEventAction("livesdk_livecell_click", new Pair[]{TuplesKt.to("enter_from_merge", "store_page"), TuplesKt.to("enter_method", "live_cell"), TuplesKt.to("click_type", PinchEnterMethod.CLICK), TuplesKt.to("btm_id", BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c4706.d3124", Boolean.FALSE).withView(a0()).build()))});
        return;
    L96:
        return;
    L59:
        if (r19 != 2131376605) goto L62;
        l0("a1.b7635.c2240.d9930");
        return;
    L62:
        if (r19 != 2131371306) goto L65;
        l0("a1.b7635.c4706.d3124");
        return;
    L65:
        if (r19 != 2131378860) goto L67;
    L70:
        Function1<hp3.b, Boolean> r22 = d0().getEventDeliverer();
        if (r22 != null) goto L73;
    L75:
        ECWindowParam r23 = d0().getShopParam();
        BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7635.c2240.d8972", Boolean.TRUE).withView(a0()).build());
        uq3.a r24 = (uq3.a) ECQuickUtilKt.d(Y(), ECWindowViewModel.class, ECWindowDialogFragment.class).getHeaderResponse().getValue();
        if (r24 == null) goto L81;
        uq3.o r25 = r24.c;
        if (r25 == null) goto L81;
        String r26 = r25.o;
        if (r26 == null) goto L81;
    L82:
        int r27 = zq3.f.a;
        String r28 = zq3.f.c(r26, "a1.b7635.c2240.d8972", PageFinder.via(a0()), null);
        com.bytedance.android.ec.sdk.helper.p r29 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r30 = Y();
        Context r31 = l0.c(r30.c());
        if ((r31 instanceof FragmentActivity) == false) goto L86;
        r3 = r31;
    L86:
        if (r3 != null) goto L88;
        r3 = r30.a();
    L88:
        r29.openSchema(r3, r28);
        j0("store_experience_score_click", MapsKt.mapOf(TuplesKt.to("click_area", CommentServiceId.HOT_SPOT)));
        return;
    L81:
        int r32 = WindowSettingKeys.a.a;
        r26 = WindowSettingKeys.a.b(r23.getPageName(), r23.getAuthorId(), r23.getSecAuthorId(), r23.getFollowStatus());
        goto L82
    L73:
        if (((Boolean) r22.invoke(jp3.b.b)).booleanValue() != true) goto L75;
        return;
    L67:
        if (r19 == 2131393031) goto L70;
        if (r19 == 2131371296) goto L70;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void updateExpandState(WindowHybridListOperationPlugin.b r11) {
        Intrinsics.checkNotNullParameter(r11, "expandState");
        if (e0().getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) >= 0) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r11.b, d0().getShopParam().getSecAuthorId())) == false) goto L8;
        return;
    L8:
        String r12 = r11.a;
        int r0 = r12.hashCode();
        if (r0 == (-1939100487)) goto L17;
        if (r0 == 1880183383) goto L14;
    L19:
        Boolean r13 = null;
    L20:
        if (r13 == null) goto L64;
        boolean r14 = r13.booleanValue();
        this.n = false;
        oq3.a r2 = this.m;
        if (r2 == null) goto L67;
        List<uq3.r> r4 = r2.o;
        if (r4 != null) goto L27;
    L30:
        boolean r5 = true;
    L31:
        if (r5 == false) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(r2.j, Boolean.valueOf(r14)) == true) goto L69;
        r2.v = d0().getShopParam().getFollowStatus();
        r2.j = Boolean.valueOf(r14);
        View r15 = a0();
        if ((r15 instanceof ViewGroup) == true) goto L39;
        r15 = null;
    L39:
        ViewGroup r16 = (ViewGroup) r15;
        if (r16 == null) goto L66;
        View r6 = r16.getChildAt(0);
        if ((r6 instanceof ViewGroup) == true) goto L44;
        r6 = null;
    L44:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L70;
        ShoppingAsyncInflater.a r8 = ShoppingAsyncInflater.e;
        Context r9 = a0().getContext();
        r8.getClass();
        View r3 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r9), 2131561013, null, 6);
        if (r3 == null) goto L63;
        ViewGroup r10 = (ViewGroup) r3;
        this.f = r10;
        int r17 = mp3.a.a;
        long r18 = WindowConstDef.d;
        Intrinsics.checkNotNullParameter(r16, "container");
        Intrinsics.checkNotNullParameter(r7, "startView");
        Intrinsics.checkNotNullParameter(r10, "endView");
        ArrayList r19 = new ArrayList();
        mp3.a.a(r7, r19);
        ArrayList r20 = new ArrayList();
        mp3.a.a(r10, r20);
        Set r21 = CollectionsKt.intersect(r19, r20);
        Set r22 = CollectionsKt.subtract(r20, r19);
        Set r23 = CollectionsKt.subtract(r19, r20);
        Scene r24 = new Scene(r16, r10);
        TransitionSet r110 = new TransitionSet().setOrdering(0).setDuration(r18);
        Fade r1 = mp3.a.b(new Fade(1), r21);
        if (r1 == null) goto L52;
        r110.addTransition(r1);
    L52:
        Fade r25 = mp3.a.b(new Fade(), r22);
        if (r25 == null) goto L55;
        r110.addTransition(r25);
    L55:
        Fade r26 = mp3.a.b(new Fade(), r23);
        if (r26 == null) goto L58;
        r110.addTransition(r26);
    L58:
        TransitionManager.go(r24, r110);
        Iterator<T> r111 = this.p.iterator();
    L60:
        if (r111.hasNext() == false) goto L71;
        ECWindowHolderBaseFragmentPresenter r27 = (ECWindowHolderBaseFragmentPresenter) r111.next();
        r27.c0();
        r27.b0(r2);
        goto L60
    L71:
        return;
    L63:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L70:
        return;
    L66:
        return;
    L69:
        return;
    L27:
        if (r4.isEmpty() == true) goto L30;
        r5 = false;
        goto L31
    L67:
        return;
    L64:
        return;
    L14:
        if (r12.equals("collapsed") == false) goto L19;
        r13 = Boolean.TRUE;
        goto L20
    L17:
        if (r12.equals("expanded") == false) goto L19;
        r13 = Boolean.FALSE;
        goto L20
    }

    public WindowHeaderAuthorInfoItemPresenter(Fragment r2, LinkedHashSet<ECWindowHolderBaseFragmentPresenter> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "bindNotifiers");
        super(r2);
        this.p = r3;
        r3.add(this);
        this.o = SetsKt.setOf(new Integer[]{2131371309, 2131376605});
    }

    public final void i0(LinearLayout r12, uq3.i r13) {
        ECUrlModel r8 = r13.a;
        if (r8 == null) goto L15;
        GenericDraweeView r9 = new ECDraweeView(Y().c(), null, 0, 6, null);
        h0.d(r9, r8, d0().getImageCallerContext(), null, null, null, null, 120);
        if (r8.getHeight() <= 0) goto L7;
        float r0 = r8.getWidth() / r8.getHeight();
    L8:
        int r2 = 14;
        if (r8.getHeight() < 14) goto L11;
    L13:
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf((int) (r2 * r0))), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2)));
        r1.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.d));
        r1.rightMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.e));
        r12.addView(r9, r1);
        goto L15
    L11:
        if (r8.getHeight() <= 0) goto L13;
        r2 = r8.getHeight();
        goto L13
    L7:
        r0 = 1.0f;
    L15:
        if (StringsKt.isBlank(r13.b) == true) goto L18;
        TextView r3 = new TextView(Y().c());
        r3.setPadding(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.d)), 0, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.e)), 0);
        r3.setText(r13.b);
        r3.setTextSize(1, 12.0f);
        r3.setTextColor(r13.c);
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        r12.addView(r3, new ViewGroup.LayoutParams(-2, -2));
        return;
    }

    public final void j0(String r11, Map<String, String> r12) {
        uq3.a r0 = (uq3.a) d0().getHeaderResponse().getValue();
        String r1 = null;
        if (r0 == null) goto L5;
        uq3.o r2 = r0.c;
    L6:
        if (r2 == null) goto L8;
        List<uq3.p> r3 = r2.r;
    L9:
        List<uq3.p> r4 = r3;
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        boolean r6 = !r5;
        if (r2 == null) goto L19;
        ECUrlModel r7 = r2.g;
    L20:
        if (r7 == null) goto L22;
        String r8 = CommentServiceId.HOT_SPOT;
    L23:
        ECWindowViewModel r9 = d0();
        Pair[] r10 = new Pair[10];
        r10[0] = TuplesKt.to("store_type", "window");
        oq3.a r13 = this.m;
        if (r13 == null) goto L28;
        uq3.k r14 = r13.m;
        if (r14 == null) goto L28;
        String r15 = r14.a;
    L29:
        r10[1] = TuplesKt.to("fans_cnt", r15);
        Integer r16 = d0().getShopParam().getFollowStatus();
        if (r16 == null) goto L32;
        String r17 = String.valueOf(r16.intValue());
    L33:
        r10[2] = TuplesKt.to("follow_status", r17);
        r10[3] = TuplesKt.to("author_id", d0().getShopParam().getAuthorId());
        r10[4] = TuplesKt.to("entrance_info", d0().getEntranceInfo());
        if (r2 == null) goto L40;
        WindowAuthorReputationVO r18 = r2.e;
        if (r18 == null) goto L40;
        Double r19 = r18.getScore();
        if (r19 == null) goto L40;
        String r20 = String.valueOf(r19.doubleValue());
    L41:
        r10[5] = TuplesKt.to("experience_score", r20);
        oq3.a r21 = this.m;
        if (r21 == null) goto L48;
        uq3.q r22 = r21.l;
        if (r22 == null) goto L48;
        Integer r23 = r22.a;
        if (r23 == null) goto L48;
        String r24 = String.valueOf(r23.intValue());
    L49:
        r10[6] = TuplesKt.to("author_level", r24);
        oq3.a r25 = this.m;
        if (r25 == null) goto L54;
        uq3.q r26 = r25.l;
        if (r26 == null) goto L54;
        r1 = r26.b;
    L54:
        r10[7] = TuplesKt.to("author_type", r1);
        if (r6 == false) goto L57;
        String r27 = CommentScene.COMMENTSCENE_NO_AWEME;
    L58:
        r10[8] = TuplesKt.to("is_fans_comment", r27);
        r10[9] = TuplesKt.to("background_picture_type", r8);
        r9.doEventAction(r11, r12, r10);
        return;
    L57:
        r27 = "0";
    L48:
        r24 = null;
    L40:
        r20 = null;
        goto L41
    L32:
        r17 = null;
    L28:
        r15 = null;
        goto L29
    L22:
        r8 = "102";
        goto L23
    L19:
        r7 = null;
        goto L20
    L12:
        if (r4.isEmpty() == true) goto L15;
        r5 = false;
        goto L16
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
