package com.larus.home.impl.main.side_bar.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.home.impl.databinding.LarusFragmentSideBarContentBinding;
import com.larus.home.impl.databinding.LarusLayoutSideBarBottomActionBinding;
import com.larus.home.impl.main.side_bar.data.ComponentTypeEnum;
import com.larus.home.impl.main.side_bar.data.IconTypeEnum;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.SideBarContentFragment$onBottomChanged$1", f = "SideBarContentFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SideBarContentFragment$onBottomChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.home.impl.main.side_bar.data.p $bottomComponent;
    int label;
    final /* synthetic */ SideBarContentFragment this$0;

    public SideBarContentFragment$onBottomChanged$1(SideBarContentFragment r100, com.larus.home.impl.main.side_bar.data.p r101, Continuation<? super SideBarContentFragment$onBottomChanged$1> r102) {
        this.this$0 = r100;
        this.$bottomComponent = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SideBarContentFragment$onBottomChanged$1(this.this$0, this.$bottomComponent, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SideBarContentFragment$onBottomChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v18, types: [com.larus.home.impl.main.side_bar.view.l1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L309;
        ResultKt.throwOnFailure(r210);
        final SideBarContentFragment r100 = this.this$0;
        com.larus.home.impl.main.side_bar.data.p r101 = this.$bottomComponent;
        int r102 = SideBarContentFragment.f344768k1;
        r100.getClass();
        if (r101 == null) goto L19;
        List<com.larus.home.impl.main.side_bar.data.p> r103 = r101.e();
        if (r103 == null) goto L19;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (((com.larus.home.impl.main.side_bar.data.p) r105).getType() != ComponentTypeEnum.PROFILE.getType()) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L10;
    L18:
        com.larus.home.impl.main.side_bar.data.p r107 = (com.larus.home.impl.main.side_bar.data.p) r105;
    L21:
        if (r107 == null) goto L156;
        e10 r108 = e10.f368561a;
        e10.l0();
        String r109 = r107.m();
        if (r109 != null) goto L25;
    L28:
        boolean r110 = true;
    L29:
        if (r110 == false) goto L31;
        String r111 = AccountService.f365697a.getNickname();
    L32:
        String r112 = com.larus.home.impl.main.side_bar.data.q.c(r107);
        if (r112 != null) goto L35;
    L38:
        boolean r113 = true;
    L39:
        if (r113 == false) goto L41;
        String r114 = AccountService.f365697a.s();
    L42:
        String r115 = r107.k();
        if (r115 != null) goto L45;
    L48:
        boolean r116 = true;
    L49:
        if (r116 == false) goto L51;
        String r117 = AccountService.f365697a.getTenantName();
    L52:
        LarusFragmentSideBarContentBinding r118 = r100.f344771d;
        if (e10.l0().a() == true) goto L55;
        r101 = r101;
        r107 = r107;
        r114 = r114;
    L80:
        LarusFragmentSideBarContentBinding r119 = r100.f344771d;
        if (r119 == null) goto L85;
        LinearLayout r120 = r119.f344263k;
        if (r120 == null) goto L85;
        com.larus.utils.e1.x(r120);
    L85:
        LarusFragmentSideBarContentBinding r121 = r100.f344771d;
        if (r121 == null) goto L90;
        TextView r122 = r121.f344270r;
        if (r122 == null) goto L90;
        r122.setText(r111);
    L90:
        r100.Ma0(r117);
        LarusFragmentSideBarContentBinding r123 = r100.f344771d;
        if (r123 == null) goto L97;
        RoundAvatarImageView r124 = r123.f344255c;
        if (r124 == null) goto L97;
        RoundAvatarImageView.f(r124, r114, "side_bar.avatar", true, 8);
    L97:
        if (e10.h0().a() == false) goto L130;
        LarusFragmentSideBarContentBinding r125 = r100.f344771d;
        if (r125 == null) goto L103;
        ImageView r126 = r125.f344271s;
        if (r126 == null) goto L103;
        com.larus.utils.e1.x(r126);
    L103:
        LarusFragmentSideBarContentBinding r127 = r100.f344771d;
        if (r127 == null) goto L108;
        RoundAvatarImageView r128 = r127.f344255c;
        if (r128 == null) goto L108;
        final com.larus.home.impl.main.side_bar.data.p r129 = r107;
        com.larus.utils.e1.d(r128, new g(r129, r100));
    L109:
        LarusFragmentSideBarContentBinding r130 = r100.f344771d;
        if (r130 == null) goto L114;
        ConstraintLayout r131 = r130.f344272t;
        if (r131 == null) goto L114;
        com.larus.utils.e1.d(r131, new r(r100));
    L114:
        LarusFragmentSideBarContentBinding r132 = r100.f344771d;
        if (r132 == null) goto L125;
        final LinearLayout r133 = r132.f344263k;
        if (r133 == null) goto L125;
        final RoundAvatarImageView r134 = r132.f344255c;
        if (r134 == null) goto L125;
        final ConstraintLayout r135 = r132.f344272t;
        if (r135 == null) goto L125;
        r133.post(new c0(r133, r134, r135));
    L125:
        LarusFragmentSideBarContentBinding r136 = r100.f344771d;
        if (r136 == null) goto L151;
        LinearLayout r137 = r136.f344263k;
        if (r137 == null) goto L151;
        r137.setOnClickListener(null);
    L151:
        LarusFragmentSideBarContentBinding r138 = r100.f344771d;
        if (r138 == null) goto L166;
        LinearLayout r139 = r138.f344263k;
        if (r139 == null) goto L166;
        r139.setTag(new com.larus.home.impl.main.side_bar.data.l0(r129.h(), r129.h()));
    L166:
        if (r101 == null) goto L180;
        List<com.larus.home.impl.main.side_bar.data.p> r140 = r101.e();
        if (r140 == null) goto L180;
        Iterator<T> r141 = r140.iterator();
    L171:
        if (r141.hasNext() == false) goto L178;
        Object r142 = r141.next();
        if (((com.larus.home.impl.main.side_bar.data.p) r142).getType() != ComponentTypeEnum.CONTAINER.getType()) goto L175;
        boolean r143 = true;
    L176:
        if (r143 == false) goto L171;
    L179:
        com.larus.home.impl.main.side_bar.data.p r144 = (com.larus.home.impl.main.side_bar.data.p) r142;
    L182:
        if (r144 == null) goto L296;
        LarusFragmentSideBarContentBinding r145 = r100.f344771d;
        if (r145 == null) goto L188;
        LinearLayout r146 = r145.f344254b;
        if (r146 == null) goto L188;
        com.larus.utils.e1.x(r146);
    L188:
        LarusFragmentSideBarContentBinding r147 = r100.f344771d;
        if (r147 == null) goto L193;
        LinearLayout r148 = r147.f344254b;
        if (r148 == null) goto L193;
        r148.removeAllViews();
    L193:
        List<com.larus.home.impl.main.side_bar.data.p> r149 = r144.e();
        if (r149 == null) goto L301;
        Iterator<T> r150 = r149.iterator();
        final int r151 = 0;
        boolean r152 = false;
    L197:
        if (r150.hasNext() == false) goto L294;
        Object r153 = r150.next();
        int r154 = r151 + 1;
        if (r151 >= 0) goto L201;
        CollectionsKt.throwIndexOverflow();
    L201:
        final com.larus.home.impl.main.side_bar.data.p r155 = (com.larus.home.impl.main.side_bar.data.p) r153;
        final Context r156 = r100.getContext();
        if (r156 == null) goto L293;
        LayoutInflater r157 = LayoutInflater.from(r156);
        LarusFragmentSideBarContentBinding r158 = r100.f344771d;
        if (r158 == null) goto L206;
        LinearLayout r159 = r158.f344254b;
    L207:
        View r160 = r157.inflate(R.layout.larus_layout_side_bar_bottom_action, r159, false);
        r159.addView(r160);
        int r161 = R.id.icon;
        SimpleDraweeView r162 = (SimpleDraweeView) ViewBindings.findChildViewById(r160, R.id.icon);
        if (r162 == null) goto L292;
        FrameLayout r163 = (FrameLayout) r160;
        RedDotTextView r164 = (RedDotTextView) ViewBindings.findChildViewById(r160, R.id.red_dot);
        if (r164 == null) goto L290;
        final LarusLayoutSideBarBottomActionBinding r165 = new LarusLayoutSideBarBottomActionBinding(r163, r162, r163, r164);
        Intrinsics.checkNotNullParameter(r155, "<this>");
        List<com.larus.home.impl.main.side_bar.data.i> r166 = r155.g();
        if (r166 == null) goto L221;
        List r167 = CollectionsKt.filterNotNull(r166);
        if (r167 == null) goto L221;
        Iterator r168 = r167.iterator();
    L217:
        if (r168.hasNext() == false) goto L221;
        com.larus.home.impl.main.side_bar.data.i r169 = (com.larus.home.impl.main.side_bar.data.i) r168.next();
        if (Intrinsics.areEqual(r169.getType(), IconTypeEnum.ICON_IMAGE.getType()) == false) goto L217;
        int r170 = r169.f344505a;
    L222:
        if (r170 == 0) goto L224;
        r165.f344337b.setImageResource(r170);
    L225:
        r165.f344336a.setTag(new com.larus.home.impl.main.side_bar.data.l0(r144.h(), r155.h()));
        String r171 = com.larus.home.impl.main.side_bar.data.q.f(r155);
        if (r171 == null) goto L246;
        int r172 = r171.hashCode();
        if (r172 == (-408512186)) goto L243;
        if (r172 == 342341017) goto L239;
        if (r172 != 1584320934) goto L246;
        if (r171.equals("//flow/camera/scan") == false) goto L246;
        r165.f344336a.setContentDescription(r156.getString(R.string.larus_accessibility_icon_scan));
        goto L246
    L239:
        if (r171.equals("//flow/notify_activity?is_side_bar=1") == false) goto L246;
        r165.f344336a.setContentDescription(r156.getString(R.string.larus_accessibility_tabBar_notification));
        goto L246
    L243:
        if (r171.equals("//flow/app_setting?is_side_bar=1") == false) goto L246;
        r165.f344336a.setContentDescription(r156.getString(R.string.larus_accessibility_icon_settings));
    L246:
        com.larus.utils.e1.d(r165.f344336a, new y0(r155, r156, r100, r165, r151));
        if (r155.getType() != ComponentTypeEnum.NOTICE.getType()) goto L256;
        LarusLayoutSideBarBottomActionBinding r173 = r165;
        r173.f344339d.setTag(r100.V0);
        int r174 = r100.f344770b1;
        if (r174 == 0) goto L252;
        r173.f344339d.z(r174);
    L252:
        if (r100.f344775g1 != null) goto L255;
        INotifyService.Companion r175 = INotifyService.f307709a;
        INotifyRedDotLifecycleObserver r176 = r175.g(LifecycleOwnerKt.getLifecycleScope(r100));
        FLogger.f375446a.i("SideBarContentFragment", "addNoticeObserver: " + r176.hashCode());
        r100.getLifecycle().addObserver(r176);
        r100.f344775g1 = r176;
        r175.e().a().observe(r100.getViewLifecycleOwner(), new t1(new l1(r100)));
    L255:
        r152 = true;
    L257:
        e10 r177 = e10.f368561a;
        if (e10.l0().a() == false) goto L293;
        Context r178 = r100.getContext();
        if (r178 != null) goto L263;
        r178 = AppHost.f326268a.getApplication();
    L263:
        Resources r179 = r178.getResources();
        SimpleDraweeView r180 = r173.f344337b;
        if (r180 == null) goto L276;
        ViewGroup.LayoutParams r181 = r180.getLayoutParams();
        if (r181 == null) goto L275;
        if ((r181 instanceof FrameLayout.LayoutParams) == false) goto L270;
        FrameLayout.LayoutParams r182 = (FrameLayout.LayoutParams) r181;
    L271:
        if (r182 == null) goto L273;
        r182.gravity = 17;
    L273:
        r180.setLayoutParams(r181);
        goto L276
    L270:
        r182 = null;
        goto L271
    L275:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L276:
        FrameLayout r183 = r173.f344338c;
        if (r183 == null) goto L293;
        ViewGroup.LayoutParams r184 = r183.getLayoutParams();
        if (r184 == null) goto L289;
        r184.width = r179.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_36, null, R.dimen.larus_dp_36));
        if ((r184 instanceof ViewGroup.MarginLayoutParams) == false) goto L283;
        ViewGroup.MarginLayoutParams r185 = (ViewGroup.MarginLayoutParams) r184;
    L285:
        if (r185 == null) goto L287;
        r185.setMarginEnd(0);
    L287:
        r183.setLayoutParams(r184);
        goto L293
    L283:
        r185 = null;
        goto L285
    L289:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L256:
        r173 = r165;
        goto L257
    L224:
        ImageLoaderKt.u(r165.f344337b, com.larus.home.impl.main.side_bar.data.q.d(r155), "side_bar.icon");
    L221:
        r170 = 0;
        goto L222
    L290:
        r161 = R.id.red_dot;
    L292:
        throw new NullPointerException("Missing required view with ID: ".concat(r160.getResources().getResourceName(r161)));
    L206:
        r159 = null;
    L293:
        r151 = r154;
        goto L197
    L294:
        boolean r186 = r152;
    L302:
        if (r186 == true) goto L307;
        INotifyRedDotLifecycleObserver r187 = r100.f344775g1;
        if (r187 == null) goto L307;
        FLogger.f375446a.i("SideBarContentFragment", "removeNoticeObserver: " + r187.hashCode());
        r100.getLifecycle().removeObserver(r187);
        r187.onCleared();
        r100.f344775g1 = null;
    L307:
        return Unit.INSTANCE;
    L301:
        r186 = false;
        goto L302
    L296:
        LarusFragmentSideBarContentBinding r188 = r100.f344771d;
        if (r188 == null) goto L301;
        LinearLayout r189 = r188.f344254b;
        if (r189 == null) goto L301;
        com.larus.utils.e1.o(r189);
        goto L301
    L175:
        r143 = false;
        goto L176
    L178:
        r142 = null;
    L180:
        r144 = null;
    L108:
        r129 = r107;
        goto L109
    L130:
        r129 = r107;
        LarusFragmentSideBarContentBinding r190 = r100.f344771d;
        if (r190 == null) goto L135;
        ImageView r191 = r190.f344271s;
        if (r191 == null) goto L135;
        com.larus.utils.e1.o(r191);
    L135:
        LarusFragmentSideBarContentBinding r192 = r100.f344771d;
        if (r192 == null) goto L140;
        RoundAvatarImageView r193 = r192.f344255c;
        if (r193 == null) goto L140;
        boolean r194 = false;
        r193.setClickable(false);
    L141:
        LarusFragmentSideBarContentBinding r195 = r100.f344771d;
        if (r195 == null) goto L146;
        ConstraintLayout r196 = r195.f344272t;
        if (r196 == null) goto L146;
        r196.setClickable(r194);
    L146:
        LarusFragmentSideBarContentBinding r197 = r100.f344771d;
        if (r197 == null) goto L151;
        LinearLayout r198 = r197.f344263k;
        if (r198 == null) goto L151;
        com.larus.utils.e1.d(r198, new n0(r129, r100));
    L140:
        r194 = false;
        goto L141
    L55:
        Context r199 = r100.getContext();
        if (r199 != null) goto L58;
        r199 = AppHost.f326268a.getApplication();
    L58:
        Resources r1100 = r199.getResources();
        if (r118 == null) goto L64;
        LinearLayout r1101 = r118.f344263k;
        if (r1101 == null) goto L64;
        int r200 = r1100.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        int r1102 = r1100.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_24, null, R.dimen.larus_dp_24));
        int r1103 = r1101.getPaddingStart();
        int r201 = r1101.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r1101.getClass().getSimpleName() + ",source:,start:" + r1103 + ",top:" + r200 + ",end:" + r201 + ",bottom:" + r1102);
        r1101.setPaddingRelative(r1103, r200, r201, r1102);
    L64:
        if (r118 == null) goto L72;
        RoundAvatarImageView r202 = r118.f344255c;
        if (r202 == null) goto L72;
        ViewGroup.LayoutParams r203 = r202.getLayoutParams();
        if (r203 == null) goto L71;
        int r204 = r1100.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_28, null, R.dimen.larus_dp_28));
        r203.width = r204;
        r203.height = r204;
        r202.setLayoutParams(r203);
        goto L72
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L72:
        if (r118 == null) goto L80;
        LinearLayout r205 = r118.f344254b;
        if (r205 == null) goto L80;
        int r206 = r1100.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r205.getClass().getSimpleName() + ",source:,start:0,top:0,end:" + r206 + ",bottom:0");
        r205.setPaddingRelative(0, 0, r206, 0);
        ViewGroup.LayoutParams r207 = r205.getLayoutParams();
        if (r207 == null) goto L79;
        ViewGroup.MarginLayoutParams r208 = (ViewGroup.MarginLayoutParams) r207;
        r208.bottomMargin = r1100.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        r205.setLayoutParams(r208);
        goto L80
    L79:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L51:
        r117 = r107.k();
        goto L52
    L45:
        if (r115.length() == 0) goto L48;
        r116 = false;
        goto L49
    L41:
        r114 = com.larus.home.impl.main.side_bar.data.q.c(r107);
        goto L42
    L35:
        if (r112.length() == 0) goto L38;
        r113 = false;
        goto L39
    L31:
        r111 = r107.m();
        goto L32
    L25:
        if (r109.length() == 0) goto L28;
        r110 = false;
        goto L29
    L156:
        r101 = r101;
        LarusFragmentSideBarContentBinding r209 = r100.f344771d;
        if (r209 == null) goto L161;
        LinearLayout r211 = r209.f344263k;
        if (r211 == null) goto L161;
        com.larus.utils.e1.o(r211);
    L161:
        r100.P0 = null;
        LarusFragmentSideBarContentBinding r212 = r100.f344771d;
        if (r212 == null) goto L166;
        TextView r213 = r212.f344269q;
        if (r213 == null) goto L166;
        com.larus.utils.e1.o(r213);
        goto L166
    L14:
        r106 = false;
        goto L15
    L17:
        r105 = null;
    L19:
        r107 = null;
        goto L21
    L309:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
