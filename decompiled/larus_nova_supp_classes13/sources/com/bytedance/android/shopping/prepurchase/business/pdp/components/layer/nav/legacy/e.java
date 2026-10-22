package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottom.SkuMeta;
import com.bytedance.android.shopping.anchorv4.bottom.j0;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.BottomButtonView;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ BottomNavigationComponentV1 a;

    public e(BottomNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r36) {
        BottomButtonVO r1 = (BottomButtonVO) r36;
        BottomNavigationComponentV1 r2 = this.a;
        if (r1 == null) goto L150;
        r2.m = r1;
        vg3.y r3 = (vg3.y) r2.N1(vg3.y.class);
        if (r3 == null) goto L8;
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r4 = r3.V();
    L9:
        if (r4 == null) goto L11;
        r4.c();
    L11:
        BottomButtonComponent r5 = BottomNavigationComponentV1.h2(this.a);
        r5.a = r1;
        BottomButtonView r6 = r5.h;
        if (r6 == null) goto L14;
        r6.setVisibility(0);
    L14:
        BottomButtonView r7 = r5.h;
        if (r7 == null) goto L17;
        r7.c(r1, r5.f);
        Unit r8 = Unit.INSTANCE;
    L18:
        if (r8 != null) goto L22;
        BottomButtonView r9 = r5.h;
        if (r9 == null) goto L22;
        r9.setVisibility(8);
        Unit r10 = Unit.INSTANCE;
    L22:
        BottomButtonView r11 = r5.h;
        if (r11 == null) goto L25;
        ExtensionsKt.e(r11, r5);
    L25:
        rg.a r12 = r1.getShowSkuAction();
        if (r12 == null) goto L28;
        fi3.n r13 = (fi3.n) r12.a();
    L29:
        if (r13 != null) goto L31;
    L144:
        r5.f.U(r5, r1);
        if (r4 == null) goto L149;
        r4.d();
        return;
    L149:
        return;
    L31:
        if (r13.b() == null) goto L144;
        if (r13.b().intValue() <= 0) goto L144;
        BottomButtonView r14 = r5.h;
        if (r14 == null) goto L143;
        Activity r15 = d0.a.getActivity(r14);
        CommonMeta r16 = r5.f.a();
        LinkedTreeMap<String, Object> r17 = r5.f.b();
        if (r17 == null) goto L141;
        FragmentManager r18 = r5.g;
        if (r18 == null) goto L139;
        if (r5.f.j() == false) goto L43;
        String r19 = "full_screen";
    L44:
        String r110 = r19;
        String r111 = r5.f.f();
        long r112 = r5.f.p();
        V4NativeParams r20 = r5.f.c();
        if (r20 == null) goto L47;
        Boolean r21 = Boolean.valueOf(r20.isFromFeedProductGuessULike());
    L48:
        boolean r113 = com.bytedance.android.shopping.extensions.k.i(r21);
        Integer r22 = r13.b();
        int r114 = 1;
        if (r22 != null) goto L52;
    L54:
        boolean r23 = false;
    L55:
        Integer r24 = r13.b();
        if (r24 != null) goto L59;
    L61:
        if (r24 != null) goto L64;
    L66:
        if (r24 == null) goto L71;
        r114 = 3;
        if (r24.intValue() != 3) goto L71;
    L77:
        Integer r25 = Integer.valueOf(r114);
        Integer r26 = r13.e();
        fi3.m r27 = r13.d();
        if (r27 == null) goto L82;
        Boolean r28 = r27.j();
        if (r28 == null) goto L82;
        boolean r29 = r28.booleanValue();
    L87:
        fi3.m r30 = r13.d();
        if (r30 == null) goto L92;
        Boolean r31 = r30.i();
        if (r31 == null) goto L92;
        boolean r210 = r31.booleanValue();
    L93:
        fi3.m r32 = r13.d();
        if (r32 == null) goto L96;
        String r211 = r32.e();
    L97:
        fi3.m r33 = r13.d();
        if (r33 == null) goto L100;
        Boolean r212 = r33.d();
    L101:
        fi3.m r34 = r13.d();
        if (r34 == null) goto L104;
        Integer r213 = r34.f();
    L105:
        fi3.m r35 = r13.d();
        if (r35 == null) goto L108;
        List<String> r214 = r35.b();
    L109:
        fi3.m r37 = r13.d();
        if (r37 == null) goto L112;
        Integer r38 = r37.c();
    L113:
        fi3.m r39 = r13.d();
        if (r39 == null) goto L116;
        String r310 = r39.a();
    L117:
        j0 r311 = new j0(r18, r112, r111, r110, r113, r29, r23, r25, r26, r210, null, r211, r212, r213, r214, 0, r38, r310, null, 295936);
        BottomButtonVO r40 = r5.a;
        if (r40 == null) goto L122;
        BottomButtonMeta r41 = r40.getBottomButtonMetaValue();
        if (r41 == null) goto L122;
        SkuMeta r42 = r41.getSkuMeta();
    L123:
        com.bytedance.android.btm.api.model.d r115 = new com.bytedance.android.btm.api.model.d();
        com.bytedance.android.ec.core.btm.a r43 = r13.c();
        if (r43 == null) goto L126;
        String r44 = r43.b();
    L127:
        if (r44 != null) goto L129;
        r44 = "";
    L129:
        r115.a = r44;
        r115.b = PageFinder.via(r5.h);
        BcmParams r45 = new BcmParams();
        com.bytedance.android.ec.core.btm.a r46 = r13.c();
        if (r46 == null) goto L137;
        Map r47 = r46.a();
        if (r47 == null) goto L137;
        Iterator r48 = r47.entrySet().iterator();
    L135:
        if (r48.hasNext() == false) goto L137;
        Map.Entry r49 = (Map.Entry) r48.next();
        r45.put((String) r49.getKey(), r49.getValue());
    L137:
        Unit r50 = Unit.INSTANCE;
        r115.c = r45;
        BottomButtonComponent.e(r5, r14, r15, r16, r17, r311, r42, false, r115, null, null, 768);
        goto L144
    L126:
        r44 = null;
    L122:
        r42 = null;
        goto L123
    L116:
        r310 = null;
        goto L117
    L112:
        r38 = null;
        goto L113
    L108:
        r214 = null;
        goto L109
    L104:
        r213 = null;
        goto L105
    L100:
        r212 = null;
        goto L101
    L96:
        r211 = null;
    L92:
        r210 = false;
    L82:
        CommonMeta r51 = r5.f.a();
        if (r51 == null) goto L85;
        String r52 = r51.getGroupId();
    L86:
        r29 = a2.b(r52);
        goto L87
    L85:
        r52 = null;
    L71:
        if (r24 == null) goto L76;
        r114 = 4;
        if (r24.intValue() == 4) goto L77;
    L76:
        r114 = 0;
        goto L77
    L64:
        if (r24.intValue() != 2) goto L66;
        r114 = 2;
        goto L77
    L59:
        if (r24.intValue() != 1) goto L61;
    L52:
        if (r22.intValue() != 2) goto L54;
        r23 = true;
        goto L55
    L47:
        r21 = null;
        goto L48
    L43:
        r19 = "half_screen";
        goto L44
    L139:
        throw new IllegalStateException("Required value was null.".toString());
    L141:
        throw new IllegalStateException("Required value was null.".toString());
    L143:
        throw new IllegalStateException("Required value was null.".toString());
    L28:
        r13 = null;
        goto L29
    L17:
        r8 = null;
        goto L18
    L8:
        r4 = null;
        goto L9
    }
}
