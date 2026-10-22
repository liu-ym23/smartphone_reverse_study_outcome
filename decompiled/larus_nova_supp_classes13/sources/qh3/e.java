package qh3;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import cf.t;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.btm.api.model.q;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.inner.container.SkuYataFragment;
import com.bytedance.android.shopping.sku.inner.container.SkuYataQueryFrom;
import com.bytedance.android.shopping.sku.inner.repo.SkuYataQueryFetcher;
import com.bytedance.android.shopping.sku.inner.slice.SkuYataTemplateManager;
import com.bytedance.android.shopping.sku.outer.action.SkuOuterPanelAction;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ul.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final FragmentManager a;
    public final SkuParams b;
    public final l c;
    public final Object d;
    public final Function2<SkuParams, Long, Unit> e;
    public final Function1<String, Unit> f;
    public final Function1<SkuShowAndDismissState, Unit> g;
    public final Function1<SkuProductDetailInfo, Unit> h;
    public final Function1<SkuCartResult, Unit> i;
    public final Function1<SkuCheckResult, Unit> j;
    public final i k;
    public final Function0<Unit> l;

    public final SkuYataFragment a(FragmentManager r15) {
        int r0 = SkuYataFragment.v;
        Serializable r1 = this.b;
        com.bytedance.android.btm.api.model.d r11 = this.c;
        Object r2 = this.d;
        if ((r2 instanceof t) == true) goto L5;
        r2 = null;
    L5:
        SkuOuterPanelAction r12 = new SkuOuterPanelAction(r1, (t) r2, this.e, this.f, this.g, this.h, this.i, this.j, this.l);
        i r3 = this.k;
        if ((r3 instanceof SkuSchemaParams) == true) goto L8;
        r3 = null;
    L8:
        SkuSchemaParams r4 = (SkuSchemaParams) r3;
        Intrinsics.checkNotNullParameter(r15, "fragmentManager");
        Intrinsics.checkNotNullParameter(r1, "skuParams");
        Intrinsics.checkNotNullParameter(r12, "skuPanelAction");
        String r5 = r1.getUniqueId();
        if (r5 != null) goto L11;
        r5 = UUID.randomUUID().toString();
    L11:
        ECParamTrackerCenter.d("Sku", r5);
        r1.setUniqueId(r5);
        SkuPerformanceOpt.a();
        new SkuYataQueryFetcher(r5, r1, null, r4).b(SkuYataQueryFrom.FIRST_SCREEN);
        if ((r11 instanceof com.bytedance.android.btm.api.model.d) == false) goto L15;
        String r6 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r11);
        String r7 = "BtmModel";
    L18:
        if (r11 != null) goto L24;
        Map<String, mh3.a> r8 = mh3.a.m;
        mh3.a r9 = mh3.a.C0219a.c(r1.getMonitorId());
        if (r9 == null) goto L24;
        com.bytedance.android.shopping.sku.common.monitor.error.a r10 = r9.c;
        if (r10 == null) goto L24;
        SkuErrorMonitorType r13 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        String r14 = "sourceBtmToken is null  btmModelTag:".concat(r7);
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r16 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r10.a(r13, r14, null);
    L24:
        SkuYataFragment r17 = new SkuYataFragment();
        if (r17.getArguments() != null) goto L27;
        Bundle r18 = new Bundle();
    L28:
        r17.setArguments(r18);
        Bundle r19 = r17.getArguments();
        if (r19 == null) goto L34;
        r19.putSerializable("sku_params", r1);
        if (r4 == null) goto L33;
        r19.putSerializable("sku_schema_params", r4);
    L33:
        r19.putString("source_btm_token", r6);
        r19.putString("session_id", r5);
    L34:
        r17.n = r12;
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L41
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, "SkuYataFragmentPage", r20);     // Catch: Exception -> L41
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r17, r20) == false) goto L54;
    L47:
        Context r110 = ECAppInfoService.e.getApplicationContext();
        if (r110 == null) goto L50;
        SkuYataTemplateManager.b(r110);
    L50:
        return r17;
    L54:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L39:
        r17.showNow(r15, "SkuYataFragmentPage");     // Catch: Exception -> L41
    L41:
        e = move-exception;
        Map<String, mh3.a> r21 = mh3.a.m;
        mh3.a r22 = mh3.a.C0219a.c(r1.getMonitorId());
        if (r22 == null) goto L47;
        com.bytedance.android.shopping.sku.common.monitor.error.a r23 = r22.c;
        if (r23 == null) goto L47;
        SkuErrorMonitorType r24 = SkuErrorMonitorType.CRASH;
        String r111 = "SkuYataFragmentPage-fragment.showNow: " + e.getMessage() + ' ';
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r25 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r23.a(r24, r111, null);
        goto L47
    L27:
        r18 = r17.getArguments();
        goto L28
    L15:
        if ((r11 instanceof q) == false) goto L17;
        r6 = ((q) r11).a;
        r7 = "TokenModel";
        goto L18
    L17:
        r7 = "null";
        r6 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(FragmentManager r1, SkuParams r2, l r3, Object r4, Function2<? super SkuParams, ? super Long, Unit> r5, Function1<? super String, Unit> r6, Function1<? super SkuShowAndDismissState, Unit> r7, Function1<? super SkuProductDetailInfo, Unit> r8, Function1<? super SkuCartResult, Unit> r9, Function1<? super SkuCheckResult, Unit> r10, i r11, Function0<Unit> r12, Context r13) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
