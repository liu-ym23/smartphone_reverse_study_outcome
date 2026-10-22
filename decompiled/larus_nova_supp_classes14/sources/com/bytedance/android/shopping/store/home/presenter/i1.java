package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.Blcok;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.entity.Module;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i1 extends ECShopBasePresenter {
    public ECLynxCard u;
    public ViewGroup v;

    public static final class a {
    }

    public static final class b implements IECLynxCardLifeCycle {
        public final /* synthetic */ i1 a;

        public final void createViewDuration(long r1) {
        }

        public final void onCreateKitViewEnd(long r1) {
        }

        public final void onDestroy() {
        }

        public final void onFirstScreen() {
        }

        public final void onLoadStart() {
        }

        public final void onPreCreateView(boolean r1) {
        }

        public final void onRealSuccess() {
        }

        public final void onReceivedError(com.bytedance.lynx.service.model.b r1) {
        }

        public final void onRuntimeReady() {
        }

        public final void onTimingSetup(Map<String, ? extends Object> r1) {
        }

        public final void onTimingSetupPref(com.bytedance.android.ec.hybrid.card.util.k r1) {
        }

        public final void onTimingUpdatePref(com.bytedance.android.ec.hybrid.card.util.k r1) {
        }

        public final void onTransDataTime(long r1, long r3) {
        }

        public final void onLoadSuccess() {
            ECLynxCard r1 = this.a.u;
            if (r1 == null) goto L6;
            ECLynxCard.m(r1, true, "", "", true, false, false, 0, 240);
            return;
        }

        public b(i1 r1) {
            this.a = r1;
        }

        public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
            Intrinsics.checkNotNullParameter(r2, "cache");
            Intrinsics.checkNotNullParameter(r2, "cache");
        }

        public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r1, "type");
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ i1 a;

        public c(i1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            jm.a<Integer> r10 = this.a.T().getLynxProductComponentHeight();
            ViewGroup r11 = this.a.v;
            if (r11 == null) goto L5;
            Integer r12 = Integer.valueOf(r11.getHeight());
        L6:
            r10.setValue(r12);
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ i1 a;

        public d(i1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            Pair r10 = (Pair) r9;
            ECStoreTabAreaVO r0 = (ECStoreTabAreaVO) this.a.T().getTabArea().getValue();
            if (r0 == null) goto L67;
            List<uj3.j> r1 = r0.b;
            if (r1 == null) goto L68;
            uj3.j r11 = (uj3.j) ListProtector.get(r1, ((Number) r10.getFirst()).intValue());
            if (r11 == null) goto L69;
            i1 r2 = this.a;
            r2.getClass();
            if (r11.i() == true) goto L11;
            ViewGroup r3 = r2.v;
            if (r3 == null) goto L64;
            ExtensionsKt.gone(r3);
        L64:
            if (r11.d == TabEnum.PRODUCT_TAB.getType()) goto L70;
            this.a.T().getLynxProductComponentHeight().setValue(0);
            return;
        L70:
            return;
        L11:
            if (r2.u == null) goto L13;
            ViewGroup r4 = r2.v;
            if (r4 == null) goto L64;
            ExtensionsKt.visible(r4);
            goto L64
        L13:
            if (r2.v == null) goto L64;
            Map<String, ? extends Object> r5 = r11.D;
            Module r6 = null;
            if (r5 == null) goto L18;
            Object r7 = r5.get("url");
        L20:
            if ((r7 instanceof String) == true) goto L22;
            r7 = null;
        L22:
            String r8 = (String) r7;
            boolean r12 = true;
            if (r8 != null) goto L25;
        L28:
            boolean r13 = true;
        L29:
            if (r13 == true) goto L31;
            r2.q0(r8, GsonProtectorUtils.toJson(new Gson(), r5));
            goto L64
        L31:
            ECShopHeadInfoBlock r14 = r11.E;
            if (r14 == null) goto L34;
            Blcok r15 = r14.getBlock();
        L35:
            if (r15 == null) goto L44;
            List<Module> r16 = r15.getModuleList();
            if (r16 == null) goto L44;
            Module r17 = (Module) CollectionsKt.firstOrNull(r16);
            if (r17 == null) goto L44;
            Map<String, String> r18 = r15.getGlobalData();
            if (r18 == null) goto L44;
            String r19 = r18.get(r17.getName() + "_bundle_url");
        L45:
            if (r15 == null) goto L49;
            List<Module> r20 = r15.getModuleList();
            if (r20 == null) goto L49;
            r6 = (Module) CollectionsKt.firstOrNull(r20);
        L49:
            if (r19 != null) goto L51;
        L54:
            if (r12 == true) goto L64;
            if (r6 == null) goto L64;
            r2.q0(r19, GsonProtectorUtils.toJson(new Gson(), r6));
            goto L64
        L51:
            if (StringsKt.isBlank(r19) == true) goto L54;
            r12 = false;
        L44:
            r19 = null;
            goto L45
        L34:
            r15 = null;
            goto L35
        L25:
            if (StringsKt.isBlank(r8) == true) goto L28;
            r13 = false;
            goto L29
        L18:
            r7 = null;
            goto L20
        L69:
            return;
        L68:
            return;
        }
    }

    static {
    }

    public i1(Fragment r1) {
        super(r1);
    }

    public final void A(QModel r4) {
        ViewGroup r5 = (ViewGroup) y().findViewById(2131370929);
        this.v = r5;
        if (r5 == null) goto L5;
        r5.addOnLayoutChangeListener(new c(this));
    L5:
        T().getSelectedTabLocation().a(W(), new d(this), false);
    }

    public final void q0(String r8, String r9) {
        this.u = new ECLynxCard();
        ViewGroup r0 = this.v;
        if (r0 == null) goto L5;
        ExtensionsKt.visible(r0);
    L5:
        ECStoreParam r1 = T().getStoreParam();
        Pair[] r2 = new Pair[6];
        r2[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        r2[1] = TuplesKt.to("author_id", r1.getStoreAccountParam().getUserId());
        r2[2] = TuplesKt.to("shop_id", r1.getShopId());
        r2[3] = TuplesKt.to("store_type", "shop");
        r2[4] = TuplesKt.to("follow_status", String.valueOf(T().getStoreParam().getFollowStatus()));
        String r3 = T().getEntranceInfo();
        if (r3 == null) goto L8;
        JSONObject r4 = com.bytedance.android.ec.core.utils.z1.g(r3);
    L9:
        r2[5] = TuplesKt.to("entrance_info", r4);
        Map r5 = MapsKt.mutableMapOf(r2);
        Context r6 = y().getContext();
        ViewGroup r7 = this.v;
        Intrinsics.checkNotNull(r7);
        ECLynxLoadParam.a r10 = new ECLynxLoadParam.a(r6, r8, r7);
        r10.j(2000);
        r10.j = r9;
        b r11 = new b(this);
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        r10.o = r11;
        r10.h(T().getSceneId());
        r10.e(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("meta_info", r5)}));
        ECLynxLoadParam r12 = new ECLynxLoadParam(r10);
        ECLynxCard r13 = this.u;
        if (r13 == null) goto L13;
        r13.j(r12);
        return;
    L13:
        return;
    L8:
        r4 = null;
        goto L9
    }
}
