package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowFloatLayerPresenter;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "unregisterJsv", "registerJsb", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowFloatLayerPresenter extends AbsECWindowPresenter implements LifecycleObserver {
    public static final /* synthetic */ int r = 0;
    public boolean m;
    public ECWindowFloatLayerPresenter$createDefaultFloatLayout$1 n;
    public WindowFloatLayout o;
    public final c p;
    public final b q;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECWindowFloatLayerPresenter a;

        public b(ECWindowFloatLayerPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            String r4 = r3.optString("module");
            com.bytedance.android.ec.window.base.repository.dto.s r5 = (com.bytedance.android.ec.window.base.repository.dto.s) GsonProtectorUtils.fromJson(new Gson(), r4, com.bytedance.android.ec.window.base.repository.dto.s.class);
            int r0 = com.bytedance.android.ec.window.base.repository.vo.d.a;
            com.bytedance.android.ec.window.base.repository.vo.d r6 = com.bytedance.android.ec.window.base.repository.vo.d.a.a(r5);
            ECWindowFloatLayerPresenter r1 = this.a;
            ECWindowFloatLayerPresenter.Z(r1, r6, r1.O().getMetaInfo());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowFloatLayerPresenter a;

        public c(ECWindowFloatLayerPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            JSONObject r0 = new JSONObject();
            if (r6 == null) goto L8;
        L13:
            ECWindowFloatLayerPresenter$createDefaultFloatLayout$1 r7 = this.a.n;
            if (r7 == null) goto L18;
            Intrinsics.checkNotNullParameter("ecom_window_scroll", "event");
            Intrinsics.checkNotNullParameter(r0, "params");
            ti.l r8 = ((WindowFloatLayout) r7).a;
            if (r8 == null) goto L18;
            r8.sendJsEvent("ecom_window_scroll", r0);
        L18:
            WindowFloatLayout r9 = this.a.o;
            if (r9 == null) goto L26;
            Intrinsics.checkNotNullParameter("ecom_window_scroll", "event");
            Intrinsics.checkNotNullParameter(r0, "params");
            ti.l r10 = r9.a;
            if (r10 == null) goto L27;
            r10.sendJsEvent("ecom_window_scroll", r0);
            return;
        L27:
            return;
        L26:
            return;
        L7:
            if (r6.intValue() != 0) goto L8;
            boolean r11 = false;
        L10:
            r0.put("scroll_state_scrolling", r11);     // Catch: Exception -> L12
        L8:
            r11 = true;
            goto L10
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void registerJsb() {
        ECLiveHybridUtil.m("ecom.store.create_float_lynx_container", this.q);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void unregisterJsv() {
        ECLiveHybridUtil.p("ecom.store.create_float_lynx_container", this.q);
    }

    public ECWindowFloatLayerPresenter() {
        this.p = new c(this);
        this.q = new b(this);
    }

    public final void C() {
        O().getComponentResponse().d(U());
        O().getCroppedState().removeObservers(U());
        U().getLifecycle().removeObserver(this);
    }

    public final void c0() {
        O().getScrollState().b(this.p);
        O().getScrollState().a(U(), this.p, false);
    }

    public final void A(QModel r4) {
        O().getCroppedState().observe(U(), new w0(this), true);
        if (O().getShopParam().isCroppedStyle() == false) goto L5;
        O().getCroppedState().observe(U(), new x0(this));
    L5:
        U().getLifecycle().addObserver(this);
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout, com.bytedance.android.window.shop.home.presenter.ECWindowFloatLayerPresenter$createDefaultFloatLayout$1] */
    public static final void Z(final ECWindowFloatLayerPresenter r14, final com.bytedance.android.ec.window.base.repository.vo.d r15, Map r16) {
        r14.getClass();
        List r0 = r15.f();
        String r1 = null;
        if (r0 == null) goto L18;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        Integer r4 = ((com.bytedance.android.ec.window.base.repository.dto.t) r3).a();
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L6;
    L17:
        com.bytedance.android.ec.window.base.repository.dto.t r6 = (com.bytedance.android.ec.window.base.repository.dto.t) r3;
    L19:
        List r7 = r15.f();
        if (r7 == null) goto L35;
        Iterator r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L33;
        Object r9 = r8.next();
        Integer r10 = ((com.bytedance.android.ec.window.base.repository.dto.t) r9).a();
        if (r10 != null) goto L28;
    L30:
        boolean r11 = false;
    L31:
        if (r11 == false) goto L23;
    L34:
        com.bytedance.android.ec.window.base.repository.dto.t r12 = (com.bytedance.android.ec.window.base.repository.dto.t) r9;
    L36:
        if (r6 != null) goto L39;
        if (r12 != null) goto L39;
        final long r13 = System.currentTimeMillis();
        final Context r17 = r14.u().c();
        final ECWindowDialogFragment r18 = r14.I();
        final JSONObject r19 = com.bytedance.android.ec.core.utils.z1.g(r15.c());
        final String r20 = r15.e();
        ?? r21 = new ECWindowFloatLayerPresenter$createDefaultFloatLayout$1(r14, r15, r17, r18, r19, r20);
        r14.n = r21;
        r14.c0();
        r21.e(r15.d(), MapsKt.mapOf(new Pair[]{TuplesKt.to("metaInfo", r16), TuplesKt.to("data", r15.c()), TuplesKt.to("name", r15.e()), TuplesKt.to("component", com.bytedance.android.shopping.extensions.k.v(r15))}), new ECWindowFloatLayerPresenter$createDefaultFloatLayout$3(r14, r15, r13));
        return;
    L39:
        String r22 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (r6 == null) goto L42;
        Integer r23 = r6.c();
    L44:
        if (r23 != null) goto L47;
    L49:
        String r24 = r22;
    L50:
        if (r12 == null) goto L52;
        Integer r25 = r12.c();
    L53:
        if (r25 != null) goto L56;
    L58:
        String r26 = r22;
    L59:
        if (r6 == null) goto L61;
        String r27 = r6.d();
    L62:
        Intrinsics.checkNotNullParameter("shop", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r27 != null) goto L65;
        String r28 = "shop";
    L66:
        if (r12 == null) goto L68;
        r1 = r12.d();
    L68:
        Intrinsics.checkNotNullParameter("shop", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r1 != null) goto L71;
        String r29 = "shop";
    L72:
        jo.a r30 = jo.a.a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(jo.a.b(r15.e(), com.bytedance.android.ec.sdk.helper.r.a.f(), r24)).subscribe(new v0(r14, r28, r29, r6, r12, r15, r24, r26, r16)), r14.O());
        return;
    L71:
        r29 = r1;
        goto L72
    L65:
        r28 = r27;
        goto L66
    L61:
        r27 = null;
        goto L62
    L56:
        if (r25.intValue() != 0) goto L58;
        r26 = "all";
        goto L59
    L52:
        r25 = null;
        goto L53
    L47:
        if (r23.intValue() != 0) goto L49;
        r24 = "all";
        goto L50
    L42:
        r23 = null;
        goto L44
    L28:
        if (r10.intValue() != 1) goto L30;
        r11 = true;
        goto L31
    L33:
        r9 = null;
        goto L34
    L35:
        r12 = null;
        goto L36
    L11:
        if (r4.intValue() != 0) goto L13;
        r5 = true;
        goto L14
    L16:
        r3 = null;
        goto L17
    L18:
        r6 = null;
        goto L19
    }

    public static final Map a0(ECWindowFloatLayerPresenter r3, List r4, String r5, int r6) {
        r3.getClass();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L13;
        Object r0 = r8.next();
        io.a r1 = (io.a) r0;
        if (Intrinsics.areEqual(r1.d, r5) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L4;
        r7.add(r0);
        goto L4
    L8:
        if (r1.e != r6) goto L10;
        r2 = true;
        goto L11
    L13:
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r10 = r7.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        r9.put(((io.a) r11).d, r11);
        goto L15
    L17:
        return r9;
    }

    public static final void b0(ECWindowFloatLayerPresenter r9, io.a r10, String r11, String r12, int r13, String r14) {
        r9.getClass();
        if (r10 == null) goto L5;
        r10.g++;
        jo.a r15 = jo.a.a;
        bg4.b.b(jo.a.c(r10)).subscribe();
        return;
    L5:
        io.a r16 = new io.a(0, r11, com.bytedance.android.ec.sdk.helper.r.a.f(), r12, r13, r14, 1);
        jo.a r17 = jo.a.a;
        bg4.b.b(jo.a.a(r16)).subscribe();
    }
}
