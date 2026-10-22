package fi3;

import android.net.Uri;
import android.os.SystemClock;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q0 implements ea3.b {
    public final j73.d a;
    public final Uri b;
    public boolean c;

    @Override // ea3.b
    public final void a() {
    }

    @Override // ea3.b
    public final void b(SkuShowAndDismissState r12) {
        Intrinsics.checkNotNullParameter(r12, "showAndDismissState");
        if (r12.isShow() == true) goto L24;
        SkuRestoreState r0 = r12.getRestoreState();
        if (r0 == null) goto L8;
        this.a.e0(r0);
        this.a.k(r0);
    L8:
        if (com.bytedance.android.ec.core.abtest.d.D() == true) goto L10;
    L12:
        int r1 = ul.h.a;
        JSONObject r2 = z1.g(UriProtector.getQueryParameter(this.b, "biz_context"));
        if (r2 == null) goto L15;
        String r3 = r2.optString("action_type");
    L17:
        if (ul.h.a(0, Integer.valueOf(mq.b.b(r3, 0)), false, null, false, 28) == 102) goto L23;
        SkuRestoreState r13 = r12.getRestoreState();
        if (r13 != null) goto L21;
    L22:
        this.a.h(CollectionsKt.listOf("top_right_report"));
        this.a.v();
        goto L23
    L21:
        if (r13.getBackType() != 1) goto L22;
    L23:
        JSONObject r14 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r14, "identifier", this.a.getSessionId());
        KtSafeMethodExtensionKt.safePut(r14, "hide", "1");
        Unit r4 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom_pdp_sku_panel_status_change", r14);
        return;
    L15:
        r3 = null;
        goto L17
    L10:
        if (this.a.h0() == true) goto L12;
        this.a.f0();
        goto L12
    L24:
        this.a.z();
        JSONObject r15 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r15, "identifier", this.a.getSessionId());
        KtSafeMethodExtensionKt.safePut(r15, "hide", "0");
        Unit r5 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom_pdp_sku_panel_status_change", r15);
    }

    @Override // ea3.b
    public final void c(SkuProductDetailInfo r20) {
        CommonMeta r1 = this.a.a();
        if (r1 == null) goto L5;
        List r2 = r1.getSkuSpecInfo();
    L6:
        if (r2 == null) goto L39;
        CommonMeta r3 = this.a.a();
        if (r3 == null) goto L10;
        String r4 = r3.getChoosePanelText();
    L12:
        if (a2.b(r4) == true) goto L14;
    L16:
        if (r20 == null) goto L51;
        String[] r13 = r20.getSpecArray();
        if (r13 == null) goto L52;
        int r14 = r13.length;
        int r5 = 0;
        int r10 = 0;
    L20:
        if (r10 >= r14) goto L54;
        String r6 = r13[r10];
        int r16 = r5 + 1;
        SkuRestoreState r7 = this.a.P();
        if (r7 == null) goto L26;
        String[] r8 = r7.getSelectSkuKeys();
        if (r8 == null) goto L26;
        String r9 = (String) ArraysKt.getOrNull(r8, r5);
    L28:
        if ((!Intrinsics.areEqual(r9, r6)) == false) goto L30;
    L33:
        SkuRestoreState r11 = this.a.P();
        if (r11 == null) goto L36;
        j73.d r12 = this.a;
        String[] r15 = r20.getSpecArray();
        Intrinsics.checkNotNull(r15);
        r11.setSelectSkuKeys(r15);
        Unit r17 = Unit.INSTANCE;
        r12.q(r11, !com.bytedance.android.ec.core.abtest.d.D());
    L37:
        this.a.l(SkuProductDetailInfo.copy$default(r20, null, null, null, null, true, null, false, 111, null));
        this.c = false;
    L38:
        r10 = r10 + 1;
        r5 = r16;
        goto L20
    L36:
        j73.d r18 = this.a;
        String[] r19 = r20.getSpecArray();
        Intrinsics.checkNotNull(r19);
        SkuRestoreState r21 = new SkuRestoreState(r19.length);
        String[] r22 = r20.getSpecArray();
        Intrinsics.checkNotNull(r22);
        r21.setSelectSkuKeys(r22);
        Unit r23 = Unit.INSTANCE;
        r18.q(r21, !com.bytedance.android.ec.core.abtest.d.D());
        goto L37
    L30:
        if (this.c == false) goto L38;
    L26:
        r9 = null;
        goto L28
    L54:
        return;
    L52:
        return;
    L51:
        return;
    L14:
        if (this.a.X() == true) goto L16;
        this.a.l(r20);
        return;
    L10:
        r4 = null;
        goto L12
    L39:
        CommonMeta r24 = this.a.a();
        if (r24 == null) goto L42;
        String r110 = r24.getChoosePanelText();
    L44:
        if (a2.b(r110) == false) goto L53;
        this.a.l(r20);
        return;
    L53:
        return;
    L42:
        r110 = null;
        goto L44
    L5:
        r2 = null;
        goto L6
    }

    public q0(j73.d r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "uri");
        this.a = r2;
        this.b = r3;
        this.c = false;
    }

    @Override // ea3.b
    public final void d(SkuParams r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "skuParams");
        int r0 = com.bytedance.android.shopping.anchorv3.utils.a.a;
        ECAdLogExtra r1 = r9.getAdLogExtra();
        String r2 = r9.getPromotionId();
        CommonMeta r3 = this.a.a();
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf((int) r3.getPromotionSource());
    L6:
        com.bytedance.android.shopping.anchorv3.utils.a.b(r1, r2, r4, Long.valueOf(r10), SystemClock.uptimeMillis() - r9.getResumeTime(), "large_stabilization");
        return;
    L5:
        r4 = null;
        goto L6
    }
}
