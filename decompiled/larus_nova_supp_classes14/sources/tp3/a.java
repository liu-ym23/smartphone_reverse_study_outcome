package tp3;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.shop.j;
import com.bytedance.android.ec.window.base.utils.c;
import com.bytedance.android.ec.window.base.utils.i;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s83.e;
import s83.g;
import uq3.o;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends PopupWindow implements View.OnClickListener {
    public static final String e = null;
    public ECWindowViewModel a;
    public View b;
    public int c;
    public final Activity d;

    /* JADX INFO: renamed from: tp3.a$a, reason: collision with other inner class name */
    public static final class C0173a {
    }

    static {
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L5;
        String r1 = "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_mall_awemelite%2Fhomepage%2Ftemplate.js%3Fenter_from%3Dpersonal_homepage%26origin_type%3D9902090000&page=ecom_mall&hide_nav_bar=1&hide_status_bar=0&status_bar_color=black&show_close=0&trans_status_bar=1&hide_loading=1&enable_share=0&web_bg_color=ffffff&show_back=0&inject_config_channel=ecom_mall_awemelite&inject_scene=default&enable_latch=1";
    L6:
        e = r1;
        return;
    L5:
        r1 = "sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2Fecom_mall%2Fhomepage%2Ftemplate.js%3Fenter_from%3Dpersonal_homepage%26origin_type%3D9902090000&page=ecom_mall&hide_nav_bar=1&hide_status_bar=0&status_bar_color=black&show_close=0&trans_status_bar=1&hide_loading=1&enable_share=0&show_back=0&web_bg_color=%23ffffffff&load_taro=0&top_level=1";
        goto L6
    }

    public final boolean a() {
        ECWindowViewModel r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        uq3.a r1 = (uq3.a) r0.getHeaderResponse().getValue();
        if (r1 == null) goto L12;
        o r2 = r1.c;
        if (r2 == null) goto L12;
        WindowCartEntryConfig r3 = r2.b;
        if (r3 == null) goto L12;
        String r4 = r3.getJumpUrl();
    L14:
        return k.c(r4);
    L12:
        r4 = null;
        goto L14
    }

    public a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.d = r2;
    }

    public final void b(View r6) {
        Intrinsics.checkNotNullParameter(r6, "anchor");
        int r0 = this.c;
        OverlaySource r1 = PopupWindowLancet.resolveSource(r6);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r6, r1) == true) goto L7;
        showAsDropDown(r6, r0, 0, 8388613);
        PopupWindowLancet.trackAfterShow(this, r1, r6);
    L7:
        if (a() == false) goto L16;
        ECWindowViewModel r7 = this.a;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        Pair[] r2 = new Pair[4];
        r2[0] = TuplesKt.to("page_name", "store_page");
        r2[1] = TuplesKt.to("store_type", "window");
        r2[2] = TuplesKt.to("click_area", "menu");
        ECWindowViewModel r3 = this.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r2[3] = TuplesKt.to("author_id", r3.getShopParam().getAuthorId());
        r7.doEventAction("show_cart_entrance", r2);
        return;
    }

    public final void c(ECWindowViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        this.a = r10;
        boolean r11 = true;
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable());
        Context r1 = th.a.e(this.d, true);
        this.c = r1.getResources().getDimensionPixelSize(2131166445);
        int r2 = r1.getResources().getDimensionPixelOffset(2131166420);
        setWidth((this.c * 2) + r2);
        setHeight(-2);
        String r6 = null;
        View r3 = th.a.d(r1, 2131560898, null, 4);
        LinearLayout r4 = (LinearLayout) r3.findViewById(2131370933);
        GradientDrawable r5 = new GradientDrawable();
        r5.setColor(-1);
        r5.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(8));
        Unit r8 = Unit.INSTANCE;
        c.d(r4, r5);
        r4.setShowDividers(2);
        r4.setDividerDrawable(new b(r2));
        View r7 = r3.findViewById(2131370937);
        Lazy r9 = ECAppInfoService.a;
        if (we.a.a == true) goto L29;
        ECWindowViewModel r12 = this.a;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        uq3.a r13 = (uq3.a) r12.getHeaderResponse().getValue();
        if (r13 == null) goto L29;
        o r14 = r13.c;
        if (r14 == null) goto L13;
        Boolean r15 = r14.d;
    L15:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == true) goto L17;
    L19:
        boolean r16 = false;
    L20:
        if (r16 == true) goto L23;
        r13 = null;
    L23:
        if (r13 == null) goto L29;
        r7.setVisibility(0);
        TextView r17 = (TextView) r7.findViewById(2131370939);
        o r18 = r13.c;
        if (r18 == null) goto L27;
        String r19 = r18.a;
    L28:
        r17.setText(r19);
        r7.setOnClickListener(this);
        goto L29
    L27:
        r19 = null;
        goto L28
    L17:
        if (r7.getVisibility() != 8) goto L19;
        r16 = true;
        goto L20
    L13:
        r15 = null;
    L29:
        View r20 = r3.findViewById(2131370935);
        Lazy r21 = ECAppInfoService.a;
        if (we.a.a == false) goto L42;
        ECWindowViewModel r22 = this.a;
        if (r22 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        uq3.a r0 = (uq3.a) r22.getHeaderResponse().getValue();
        if (r0 == null) goto L40;
        o r23 = r0.c;
        if (r23 == null) goto L40;
        r6 = r23.c;
    L40:
        if (k.c(r6) == false) goto L42;
    L44:
        if (ECAppInfoService.l() == false) goto L47;
    L46:
        r11 = false;
    L47:
        if (r11 == false) goto L49;
        r20.setVisibility(0);
        r20.setOnClickListener(this);
    L50:
        View r110 = r3.findViewById(2131370934);
        if (a() == false) goto L53;
        r110.setVisibility(0);
        r110.setOnClickListener(this);
    L54:
        r3.findViewById(2131370936).setOnClickListener(this);
        if (we.a.a == false) goto L57;
        r3.findViewById(2131370936).setVisibility(8);
    L57:
        this.b = r3;
        setContentView(r3);
        return;
    L53:
        r110.setVisibility(8);
        goto L54
    L49:
        r20.setVisibility(8);
    L42:
        if (ECAppInfoService.h() == false) goto L46;
        goto L46
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r15) {
        Intrinsics.checkNotNullParameter(r15, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r15.getId()) == false) goto L5;
        return;
    L5:
        int r1 = r15.getId();
        if (r1 != 2131370935) goto L27;
        ECWindowViewModel r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        uq3.a r3 = (uq3.a) r2.getHeaderResponse().getValue();
        if (r3 == null) goto L15;
        o r4 = r3.c;
        if (r4 == null) goto L15;
        String r5 = r4.c;
    L16:
        String r6 = a2.d(r5);
        if (r6 != null) goto L19;
        boolean r7 = ECServiceManager.a;
        r6 = ((g) ECServiceManager.c(g.class)).a();
    L19:
        int r8 = f.a;
        String r9 = a2.d(r6);
        if (r9 != null) goto L22;
        r9 = e;
    L22:
        p.a.openSchema(this.d, f.c(r9, "a1.b7635.c2240.d3515", PageFinder.via(r15), null));
        ECWindowViewModel r16 = this.a;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        int r10 = i.a;
        r16.doEventAction("click_order_entrance", new Pair[]{TuplesKt.to("enter_from", "others_store_page"), i.a("a1.b7635.c2240.d3515", false)});
    L87:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        dismiss();
        return;
    L15:
        r5 = null;
        goto L16
    L27:
        if (r1 != 2131370937) goto L30;
        boolean r17 = ECServiceManager.a;
        ((g) ECServiceManager.c(g.class)).y();
        goto L87
    L30:
        if (r1 != 2131370934) goto L55;
        ECWindowViewModel r18 = this.a;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        uq3.a r19 = (uq3.a) r18.getHeaderResponse().getValue();
        if (r19 == null) goto L87;
        o r110 = r19.c;
        if (r110 == null) goto L87;
        WindowCartEntryConfig r111 = r110.b;
        if (r111 == null) goto L87;
        String r112 = r111.getJumpUrl();
        if (r112 == null) goto L87;
        if ((!StringsKt.isBlank(r112)) == true) goto L46;
        r112 = null;
    L46:
        if (r112 == null) goto L87;
        ECWindowViewModel r11 = this.a;
        if (r11 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        Pair[] r12 = new Pair[5];
        r12[0] = TuplesKt.to("page_name", "store_page");
        r12[1] = TuplesKt.to("store_type", "window");
        r12[2] = TuplesKt.to("click_area", "menu");
        ECWindowViewModel r13 = this.a;
        if (r13 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L53:
        r12[3] = TuplesKt.to("author_id", r13.getShopParam().getAuthorId());
        int r14 = i.a;
        r12[4] = i.a("a1.b7635.c2240.d60817", false);
        r11.doEventAction("click_cart_entrance", r12);
        p r20 = p.a;
        Activity r21 = this.d;
        int r22 = f.a;
        r20.openSchema(r21, f.c(r112, "a1.b7635.c2240.d60817", PageFinder.via(r21), null));
        goto L87
    L55:
        if (r1 != 2131370936) goto L87;
        boolean r113 = ECServiceManager.a;
        e r114 = ((g) ECServiceManager.c(g.class)).W();
        if (r114 == null) goto L74;
        Activity r23 = this.d;
        View r24 = this.b;
        if (r24 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L61:
        ECWindowViewModel r25 = this.a;
        if (r25 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L64:
        String r115 = r25.getShopParam().getAuthorId();
        ECWindowViewModel r26 = this.a;
        if (r26 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L67:
        String r116 = r26.getShopParam().getSecAuthorId();
        ECWindowViewModel r27 = this.a;
        if (r27 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L70:
        ECUrlModel r117 = r27.getShopParam().getShareInfo().getAvatarMedium();
        ECWindowViewModel r28 = this.a;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        r114.c(r23, r24, r115, r116, r117, r28.getShopParam().getShareInfo().getNickName());
    L74:
        ECWindowViewModel r29 = this.a;
        if (r29 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L77:
        int r30 = i.a;
        r29.doEventAction("share_store", new Pair[]{i.a("a1.b7635.c2240.d5363", false)});
        if (r114 == null) goto L86;
        ECWindowViewModel r31 = this.a;
        if (r31 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L82:
        tf3.k r32 = new tf3.k(r31.getShopParam().getAuthorId(), null, 2);
        ECWindowViewModel r33 = this.a;
        if (r33 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L85:
        r114.d(r32, PinchEnterMethod.CLICK, r33.getShopParam().getPageName());
    L86:
        boolean r118 = j.a;
        j.b("window_click_share_window", PostActionType.DO);
        goto L87
    }
}
