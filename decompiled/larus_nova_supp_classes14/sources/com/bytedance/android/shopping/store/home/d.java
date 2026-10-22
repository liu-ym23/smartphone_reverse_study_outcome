package com.bytedance.android.shopping.store.home;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.model.ECShopShareQrCodeInfo;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.entity.CouponRedPackEntryInfo;
import com.bytedance.android.shopping.store.home.entity.ECShopBlockInfoDTO;
import com.bytedance.android.shopping.store.home.entity.ECShopToolsInfo;
import com.bytedance.android.shopping.store.home.entity.ShopCommitIMResponse;
import com.bytedance.android.shopping.store.home.entity.ToolEntryInfo;
import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d {
    public static final /* synthetic */ int f = 0;
    public final s83.e a;
    public ShopCommitIMResponse b;
    public com.bytedance.android.shopping.store.home.entity.f c;
    public String d;
    public final Fragment e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            d r0 = this.a;
            int r1 = com.bytedance.android.shopping.store.home.entity.f.c;
            r0.c = com.bytedance.android.shopping.store.home.entity.f.a.a((ECShopBlockInfoDTO) r3);
            d.a(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            d r0 = this.a;
            r0.b = (ShopCommitIMResponse) r2;
            d.a(r0);
        }
    }

    static {
    }

    public abstract com.bytedance.android.shopping.store.home.a c();

    public abstract f0 d();

    public final View e() {
        return this.e.getView();
    }

    public d(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.e = r2;
        boolean r3 = ECServiceManager.a;
        this.a = ((s83.g) ECServiceManager.c(s83.g.class)).W();
        this.d = "";
    }

    public static final void a(final d r22) {
        ShopCommitIMResponse r1 = r22.b;
        if (r1 == null) goto L157;
        com.bytedance.android.shopping.store.home.entity.f r2 = r22.c;
        if (r2 == null) goto L158;
        r22.b = null;
        ECShopShareQrCodeInfo r15 = r2.a;
        com.bytedance.android.ec.model.i r16 = new com.bytedance.android.ec.model.i();
        final ECShopToolsInfo r3 = r2.b;
        ArrayList r14 = new ArrayList();
        com.bytedance.android.shopping.store.home.entity.f r4 = r22.c;
        boolean r17 = false;
        if (r4 == null) goto L22;
        ECShopToolsInfo r5 = r4.b;
        if (r5 == null) goto L22;
        ToolEntryInfo r6 = r5.getCustomServiceEntry();
        if (r6 == null) goto L22;
        String r7 = r6.getSchema();
        if (r7 == null) goto L22;
        if (com.bytedance.android.shopping.extensions.k.c(r7) != true) goto L22;
        com.bytedance.android.shopping.store.home.a r8 = r22.c();
        if (r8 == null) goto L21;
        r8.g();
    L21:
        boolean r9 = true;
    L24:
        if (r9 == false) goto L35;
        Function0<Unit> r10 = new ECShopBaseShareHelper$buildEntryList$$inlined$apply$lambda$1(r22, r3);
        if (r3 == null) goto L33;
        ToolEntryInfo r11 = r3.getCustomServiceEntry();
        if (r11 == null) goto L33;
        String r12 = r11.getEntryText();
        if (r12 == null) goto L33;
        String r13 = r12;
    L34:
        r14.add(new com.bytedance.android.ec.model.h(r10, 2131237483, "shop_custom_service", r13, ToolType.CUSTOM_SERVICE.getType()));
    L33:
        r13 = "";
    L35:
        int r18 = g0.a;
        com.bytedance.android.shopping.store.home.entity.f r19 = r22.c;
        if (r19 == null) goto L48;
        ECShopToolsInfo r20 = r19.b;
        if (r20 == null) goto L48;
        CouponRedPackEntryInfo r21 = r20.getCouponRedPackEntry();
        if (r21 == null) goto L48;
        String r23 = r21.getSchema();
        if (r23 == null) goto L48;
        if (com.bytedance.android.shopping.extensions.k.c(r23) != true) goto L48;
        if (ECShopABSettings.a() <= 0) goto L48;
        boolean r24 = true;
    L49:
        Function0<Unit> r25 = new ECShopBaseShareHelper$buildEntryList$$inlined$apply$lambda$2(r22, r3);
        if (r3 == null) goto L57;
        CouponRedPackEntryInfo r26 = r3.getCouponRedPackEntry();
        if (r26 == null) goto L57;
        String r27 = r26.getEntryText();
        if (r27 == null) goto L57;
        String r28 = r27;
    L58:
        Function0<Unit> r29 = new ECShopBaseShareHelper$buildEntryList$$inlined$apply$lambda$3(r22, r3);
        com.bytedance.android.shopping.store.home.entity.f r30 = r22.c;
        if (r30 == null) goto L72;
        ECShopToolsInfo r31 = r30.b;
        if (r31 == null) goto L72;
        ToolEntryInfo r32 = r31.getCartEntry();
        if (r32 == null) goto L72;
        String r33 = r32.getSchema();
        if (r33 == null) goto L72;
        if (com.bytedance.android.shopping.extensions.k.c(r33) != true) goto L72;
        com.bytedance.android.shopping.store.home.a r34 = r22.c();
        if (r34 == null) goto L71;
        r34.e();
    L71:
        boolean r35 = true;
    L73:
        if (r3 == null) goto L80;
        ToolEntryInfo r36 = r3.getCartEntry();
        if (r36 == null) goto L80;
        String r37 = r36.getEntryText();
        if (r37 == null) goto L80;
        String r110 = r37;
    L81:
        Function0<Unit> r111 = new ECShopBaseShareHelper$buildEntryList$$inlined$apply$lambda$4(r22, r3);
        Lazy r38 = ECAppInfoService.a;
        if (ECAppInfoService.l() == true) goto L87;
        com.bytedance.android.shopping.store.home.a r39 = r22.c();
        if (r39 == null) goto L86;
        r39.f();
    L86:
        boolean r112 = true;
    L88:
        if (r3 == null) goto L95;
        ToolEntryInfo r40 = r3.getOrderEntry();
        if (r40 == null) goto L95;
        String r41 = r40.getEntryText();
        if (r41 == null) goto L95;
        String r113 = r41;
    L96:
        String r114 = r113;
        g0.a(r14, r24, r25, r28, r29, r35, r110, r111, r112, r114, new ECShopBaseShareHelper$buildEntryList$$inlined$apply$lambda$5(r22, r3));
        com.bytedance.android.shopping.store.home.entity.f r42 = r22.c;
        if (r42 == null) goto L110;
        ECShopToolsInfo r43 = r42.b;
        if (r43 == null) goto L110;
        ToolEntryInfo r44 = r43.getMemberEntry();
        if (r44 == null) goto L110;
        String r45 = r44.getSchema();
        if (r45 == null) goto L110;
        if (com.bytedance.android.shopping.extensions.k.c(r45) != true) goto L110;
        com.bytedance.android.shopping.store.home.a r46 = r22.c();
        if (r46 == null) goto L109;
        r46.i();
    L109:
        r17 = true;
    L110:
        if (r17 == false) goto L121;
        Function0<Unit> r47 = new ECShopBaseShareHelper$buildEntryList$$inlined$apply$lambda$6(r22, r3);
        if (r3 == null) goto L119;
        ToolEntryInfo r48 = r3.getMemberEntry();
        if (r48 == null) goto L119;
        String r49 = r48.getEntryText();
        if (r49 == null) goto L119;
        String r50 = r49;
    L120:
        r14.add(new com.bytedance.android.ec.model.h(r47, 2131237484, "shop_member", r50, ToolType.MEMBER.getType()));
    L119:
        r50 = "";
    L121:
        FragmentActivity r51 = CommonUtils.a();
        if (r51 != null) goto L124;
        r51 = r22.e.getActivity();
    L124:
        FragmentActivity r52 = r51;
        if (r52 == null) goto L159;
        View r53 = r22.e();
        if (r53 == null) goto L160;
        s83.e r54 = r22.a;
        if (r54 == null) goto L149;
        String r55 = r22.d().getShopId();
        if (r55 != null) goto L135;
        String r56 = "";
    L136:
        String r115 = r22.d;
        com.bytedance.android.shopping.store.home.entity.f r57 = r22.c;
        if (r57 == null) goto L141;
        ECShopShareQrCodeInfo r58 = r57.a;
        if (r58 == null) goto L141;
        ECUrlModel r116 = r58.getShopLogo();
    L142:
        com.bytedance.android.shopping.store.home.entity.f r59 = r22.c;
        if (r59 == null) goto L147;
        ECShopShareQrCodeInfo r60 = r59.a;
        if (r60 == null) goto L147;
        String r117 = r60.getShopName();
    L148:
        r54.k(true, true, r52, r53, r56, r115, r116, r117, r1.getMsgType(), r1.getContent(), r15, r16);
    L147:
        r117 = null;
    L141:
        r116 = null;
        goto L142
    L135:
        r56 = r55;
    L149:
        com.bytedance.android.shopping.store.home.a r61 = r22.c();
        if (r61 == null) goto L152;
        r61.a();
    L152:
        s83.e r62 = r22.a;
        if (r62 == null) goto L155;
        r62.d(new tf3.k(null, r22.d().getShopId(), 1), PinchEnterMethod.CLICK, r22.d().getShopId());
    L155:
        boolean r0 = gm.a.a;
        gm.a.b("shop_share_shop", PostActionType.DO);
        return;
    L160:
        return;
    L159:
        return;
    L95:
        r113 = "";
        goto L96
    L87:
        r112 = false;
    L80:
        r110 = "";
    L72:
        r35 = false;
    L57:
        r28 = "";
    L48:
        r24 = false;
    L22:
        r9 = false;
        goto L24
    L158:
        return;
    }

    public final void b(ToolType r2) {
        if (ECShopABSettings.a() != 0) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.store.home.a r0 = c();
        if (r0 == null) goto L9;
        r0.h(r2);
        return;
    }

    public final void f(String r2) {
        if (r2 != null) goto L4;
        r2 = d().b();
    L4:
        this.d = r2;
        if (this.c != null) goto L11;
        int r0 = com.bytedance.android.shopping.store.utils.i.a;
        Observable r3 = com.bytedance.android.shopping.store.utils.i.a(r2, d().getPassThroughApi());
        if (r3 == null) goto L11;
        Observable r4 = bg4.b.b(r3);
        if (r4 == null) goto L11;
        r4.subscribe(new b(this));
    L11:
        int r5 = com.bytedance.android.shopping.store.utils.i.a;
        Observable r6 = com.bytedance.android.shopping.store.utils.i.b(this.d, e());
        if (r6 == null) goto L17;
        Observable r7 = bg4.b.b(r6);
        if (r7 == null) goto L18;
        r7.subscribe(new c(this));
        return;
    L18:
        return;
    }
}
