package com.bytedance.android.shopping.prepurchase.business.pdp.services.sku;

import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVO;
import com.bytedance.android.shopping.anchorv4.voavhs.head.SlidesGroup;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPreviewMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import com.bytedance.android.shopping.prepurchase.arch.container.state.ObservableData;
import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.m0;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/x;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.PdpSKUService$onAttach$1", f = "PdpSKUService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PdpSKUService$onAttach$1 extends SuspendLambda implements Function3<CoroutineScope, x, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpSKUService this$0;

    public static final class a<T> implements g {
        public final /* synthetic */ PdpSKUService$onAttach$1 a;

        public a(PdpSKUService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            List r6 = (List) r5;
            if (r6 == null) goto L27;
            Iterator<T> r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L36;
            com.bytedance.android.ecom.arch.slice.adapter.b r0 = (com.bytedance.android.ecom.arch.slice.adapter.b) r7.next();
            boolean r3 = false;
            if ((r0 instanceof AnchorV4HeadVO) == true) goto L9;
            if ((r0 instanceof AnchorV4HeadV2VO) == false) goto L6;
            PdpSKUService r1 = this.a.this$0;
            HeaderPreviewMeta r2 = ((AnchorV4HeadV2VO) r0).getPreviewMeta();
            if (r2 == null) goto L20;
            List<String> r4 = r2.getSkuTabs();
        L21:
            List<String> r8 = r4;
            if (r8 != null) goto L24;
        L25:
            r3 = true;
        L26:
            r1.n = !r3;
            goto L6
        L24:
            if (r8.isEmpty() == false) goto L26;
        L20:
            r4 = null;
            goto L21
        L9:
            PdpSKUService r9 = this.a.this$0;
            List<SlidesGroup> r10 = ((AnchorV4HeadVO) r0).getSkuTabItems();
            if (r10 != null) goto L12;
        L13:
            r3 = true;
        L14:
            r9.n = !r3;
            goto L6
        L12:
            if (r10.isEmpty() == false) goto L14;
        L36:
            return;
        }
    }

    public static final class b implements m0 {
        public final /* synthetic */ PdpSKUService$onAttach$1 a;

        public b(PdpSKUService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // vg3.m0
        public final void a(PdpPackRequestParam r6) {
            Intrinsics.checkNotNullParameter(r6, "param");
            PdpSKUService r0 = this.a.this$0;
            int r1 = PdpSKUService.v;
            x r2 = r0.c2();
            List r3 = null;
            if (r2 == null) goto L9;
            PdpDataStore r4 = r2.getData();
            if (r4 == null) goto L9;
            ObservableData r5 = r4.b;
            if (r5 == null) goto L9;
            PageMeta r7 = (PageMeta) r5.a();
        L10:
            if (r7 == null) goto L14;
            CommonMeta r8 = r7.getCommonMeta();
            if (r8 == null) goto L14;
            String r9 = r8.getForbidSkuSwitch();
        L15:
            boolean r10 = Intrinsics.areEqual(r9, "1");
            String r11 = "";
            if (r7 == null) goto L32;
            h73.b r12 = r7.getSkuMeta();
            if (r12 == null) goto L32;
            Map r13 = r12.a();
            if (r13 == null) goto L32;
            SkuRestoreState r14 = this.a.this$0.j;
            if (r14 == null) goto L25;
            String r15 = r14.joinedKey();
        L26:
            if (r15 != null) goto L28;
            r15 = "";
        L28:
            String r16 = (String) r13.get(r15);
            if (r16 == null) goto L32;
            r11 = r16;
            goto L32
        L25:
            r15 = null;
        L32:
            if (r10 == true) goto L34;
            r6.updateNormalSkuId(r11);
        L34:
            r6.updateSkuSwitch(r11);
            SkuRestoreState r17 = this.a.this$0.j;
            if (r17 == null) goto L39;
            String[] r18 = r17.getSelectSkuKeys();
            if (r18 == null) goto L39;
            r3 = ArraysKt.toList(r18);
        L39:
            r6.updateSelectedIds(r3);
            return;
        L14:
            r9 = null;
        L9:
            r7 = null;
            goto L10
        }
    }

    public static final class c<T> implements g {
        public final /* synthetic */ PdpSKUService$onAttach$1 a;

        public c(PdpSKUService$onAttach$1 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            CommonMeta r3 = (CommonMeta) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getEnablePDPOptimize() != true) goto L9;
            Function1<? super SkuProductDetailInfo, Unit> r4 = this.a.this$0;
            int r0 = PdpSKUService.v;
            r4.u(r4);
            return;
        }
    }

    public static final class d<T> implements g {
        public final /* synthetic */ PdpSKUService$onAttach$1 a;
        public final /* synthetic */ x b;

        public d(PdpSKUService$onAttach$1 r1, x r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            k r3 = (k) r2;
            Intrinsics.checkNotNullParameter(r3, "state");
            if ((r3 instanceof k.d) == true) goto L5;
            return;
        L5:
            if ((r3 instanceof k.d.a) == true) goto L10;
            this.a.this$0.O1().b().e1(new com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.a(this));
            return;
        }
    }

    public PdpSKUService$onAttach$1(PdpSKUService r1, Continuation r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(CoroutineScope r2, x r3, Continuation<? super Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "it");
        Intrinsics.checkNotNullParameter(r4, "continuation");
        PdpSKUService$onAttach$1 r5 = new PdpSKUService$onAttach$1(this.this$0, r4);
        r5.L$0 = r3;
        return r5;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (x) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        x r5 = (x) this.L$0;
        e.a.a(r5.getData().b(), this.this$0, new a(this));
        PdpSKUService r0 = this.this$0;
        int r1 = PdpSKUService.v;
        x r2 = r0.c2();
        if (r2 == null) goto L7;
        r2.w1(new b(this));
    L7:
        e.a.a(r5.getData().a(), this.this$0, new c(this));
        e.a.a(r5.q0(), this.this$0, new d(this, r5));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
