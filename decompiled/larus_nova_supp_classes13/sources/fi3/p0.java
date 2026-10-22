package fi3;

import android.net.Uri;
import android.os.SystemClock;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p0 implements ea3.b {
    public final j73.d a;
    public final Uri b;
    public boolean c;
    public final Function0<Unit> d;

    @Override // ea3.b
    public final void a() {
        Function0<Unit> r0 = this.d;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    @Override // ea3.b
    public final void b(SkuShowAndDismissState r9) {
        Intrinsics.checkNotNullParameter(r9, "showAndDismissState");
        if (r9.isShow() == true) goto L24;
        SkuRestoreState r0 = r9.getRestoreState();
        if (r0 == null) goto L8;
        this.a.e0(r0);
        this.a.k(r0);
    L8:
        if (com.bytedance.android.ec.core.abtest.d.D() == true) goto L10;
    L12:
        int r1 = ul.h.a;
        JSONObject r2 = z1.g(UriProtector.getQueryParameter(this.b, "biz_context"));
        int r3 = 0;
        if (r2 == null) goto L18;
        String r4 = r2.optString("action_type");
        if (r4 == null) goto L18;
        r3 = mq.b.b(r4, 0);
    L18:
        if (ul.h.a(0, Integer.valueOf(r3), false, null, false, 28) == 102) goto L26;
        SkuRestoreState r10 = r9.getRestoreState();
        if (r10 != null) goto L22;
    L23:
        this.a.h(CollectionsKt.listOf("top_right_report"));
        this.a.v();
        return;
    L22:
        if (r10.getBackType() != 1) goto L23;
        return;
    L26:
        return;
    L10:
        if (this.a.h0() == true) goto L12;
        this.a.f0();
        goto L12
    L24:
        this.a.z();
    }

    @Override // ea3.b
    public final void c(SkuProductDetailInfo r20) {
        CommonMeta r1 = this.a.a();
        if (r1 == null) goto L5;
        List r2 = r1.getSkuSpecInfo();
    L6:
        if (r2 == null) goto L49;
        CommonMeta r3 = this.a.a();
        if (r3 == null) goto L10;
        String r4 = r3.getChoosePanelText();
    L12:
        if (a2.b(r4) == true) goto L14;
    L16:
        if (r20 == null) goto L61;
        String[] r13 = r20.getSpecArray();
        if (r13 == null) goto L62;
        int r14 = r13.length;
        int r5 = 0;
        int r10 = 0;
    L20:
        if (r10 >= r14) goto L64;
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
        if (r11 == null) goto L39;
        j73.d r12 = this.a;
        String[] r15 = r20.getSpecArray();
        if (r15 != null) goto L38;
        r15 = new String[0];
    L38:
        r11.setSelectSkuKeys(r15);
        Unit r17 = Unit.INSTANCE;
        r12.q(r11, !com.bytedance.android.ec.core.abtest.d.D());
    L47:
        this.a.l(SkuProductDetailInfo.copy$default(r20, null, null, null, null, true, null, false, 111, null));
        this.c = false;
    L48:
        r10 = r10 + 1;
        r5 = r16;
        goto L20
    L39:
        j73.d r18 = this.a;
        String[] r19 = r20.getSpecArray();
        if (r19 == null) goto L42;
        int r21 = r19.length;
    L43:
        SkuRestoreState r22 = new SkuRestoreState(r21);
        String[] r23 = r20.getSpecArray();
        if (r23 != null) goto L46;
        r23 = new String[0];
    L46:
        r22.setSelectSkuKeys(r23);
        Unit r24 = Unit.INSTANCE;
        r18.q(r22, !com.bytedance.android.ec.core.abtest.d.D());
        goto L47
    L42:
        r21 = 0;
        goto L43
    L30:
        if (this.c == false) goto L48;
    L26:
        r9 = null;
        goto L28
    L64:
        return;
    L62:
        return;
    L61:
        return;
    L14:
        if (this.a.X() == true) goto L16;
        this.a.l(r20);
        return;
    L10:
        r4 = null;
        goto L12
    L49:
        CommonMeta r25 = this.a.a();
        if (r25 == null) goto L52;
        String r110 = r25.getChoosePanelText();
    L54:
        if (a2.b(r110) == false) goto L63;
        this.a.l(r20);
        return;
    L63:
        return;
    L52:
        r110 = null;
        goto L54
    L5:
        r2 = null;
        goto L6
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

    public p0(j73.d r2, Uri r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "uri");
        this.a = r2;
        this.b = r3;
        this.c = false;
        this.d = r4;
    }
}
