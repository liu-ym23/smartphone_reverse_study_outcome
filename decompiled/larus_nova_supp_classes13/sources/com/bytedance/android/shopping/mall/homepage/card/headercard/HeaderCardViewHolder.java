package com.bytedance.android.shopping.mall.homepage.card.headercard;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.api.mall.i;
import com.bytedance.android.shopping.api.mall.model.SkinConfig;
import com.bytedance.android.shopping.mall.homepage.card.headercard.components.LegouToolAreaComponent;
import com.bytedance.android.shopping.mall.homepage.card.headercard.components.ToolAreaComponent;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import ef3.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/HeaderCardViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderCardViewHolder extends BaseViewHolder {
    public static final /* synthetic */ int t = 0;
    public HeaderCardData o;
    public String p;
    public final List<e<HeaderCardData>> q;
    public final View r;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a s;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ HeaderCardViewHolder a;

        public b(HeaderCardViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HeaderCardViewHolder r0 = this.a;     // Catch: Throwable -> L4
            int r1 = HeaderCardViewHolder.t;     // Catch: Throwable -> L4
            r0.r4(false, "list", "");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ HeaderCardViewHolder a;

        public c(HeaderCardViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HeaderCardViewHolder r0 = this.a;     // Catch: Throwable -> L4
            int r1 = HeaderCardViewHolder.t;     // Catch: Throwable -> L4
            r0.r4(true, "list", "");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ HeaderCardViewHolder a;

        public d(HeaderCardViewHolder r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HeaderCardViewHolder r1 = this.a;     // Catch: Throwable -> L18
            int r0 = HeaderCardViewHolder.t;     // Catch: Throwable -> L18
            ECHybridListItemVO r2 = ((BaseViewHolder) r1).c;     // Catch: Throwable -> L18
            if (r2 == null) goto L5;
            String r3 = r2.g();     // Catch: Throwable -> L18
        L6:
            String r4 = r3;
            if (r4 != null) goto L9;
        L12:
            boolean r5 = true;
        L13:
            if (r5 == true) goto L21;
            int r6 = r1.getItemViewType();     // Catch: Throwable -> L18
            String r7 = r1.p;     // Catch: Throwable -> L18
            CoroutineScope r8 = r1.s.o;     // Catch: Throwable -> L18
            if (r8 == null) goto L25;
            BuildersKt.launch$default(r8, null, null, new HeaderCardViewHolder$sendDataToPageCard$1(r1, r4, r6, r7, null), 3, null);     // Catch: Throwable -> L18
            return;
        L25:
            return;
        L21:
            return;
        L9:
            if (r4.length() == 0) goto L12;
            r5 = false;
            goto L13
        L5:
            r3 = null;
        L18:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder$onCreate$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(HeaderCardViewHolder r8) {
            super(1, r8, HeaderCardViewHolder.class, "onThemeChange", "onThemeChange(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r2) {
            HeaderCardViewHolder.q4((HeaderCardViewHolder) ((CallableReference) this).receiver, r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder$onRelease$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(HeaderCardViewHolder r8) {
            super(1, r8, HeaderCardViewHolder.class, "onThemeChange", "onThemeChange(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r2) {
            HeaderCardViewHolder.q4((HeaderCardViewHolder) ((CallableReference) this).receiver, r2);
        }
    }

    static {
    }

    public final boolean C3() {
        return true;
    }

    public final void onCreate() {
        this.s.N2(this.r);
        Fragment r0 = this.s.h.A1.M();
        if ((r0 instanceof i) == true) goto L5;
        r0 = null;
    L5:
        i r1 = (i) r0;
        if (r1 == null) goto L8;
        new AnonymousClass1(this);
        r1.b();
    L8:
        Iterator r2 = ((ArrayList) this.q).iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((e) r2.next()).onCreate();
        goto L10
    }

    public final void onHide() {
        this.r.post(new b(this));
    }

    public final void onShow() {
        this.r.post(new c(this));
    }

    public final void onRelease() {
        super.onRelease();
        Iterator r0 = ((ArrayList) this.q).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).c();
        goto L4
    L6:
        Fragment r1 = this.s.h.A1.M();
        if ((r1 instanceof i) == true) goto L9;
        r1 = null;
    L9:
        i r2 = (i) r1;
        if (r2 == null) goto L12;
        new AnonymousClass2(this);
        r2.a();
    L12:
        this.s.onRelease();
    }

    public final View k4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.r.findViewWithTag(r2);
    }

    public HeaderCardViewHolder(View r5, com.bytedance.android.shopping.mall.homepage.card.headercard.a r6) {
        Intrinsics.checkNotNullParameter(r5, "cardView");
        Intrinsics.checkNotNullParameter(r6, "mallContext");
        super(r5);
        this.r = r5;
        this.s = r6;
        this.p = "";
        ArrayList r0 = new ArrayList();
        this.q = r0;
        kjc.c r1 = new kjc.c();
        if (5 != kjc.a.a()) goto L6;
        kjc.b r2 = r1.a;
        r0.add(new LegouToolAreaComponent(r5, r6));
        r0.add(new com.bytedance.android.shopping.mall.homepage.card.headercard.components.d(r5, r6));
        r0.add(new com.bytedance.android.shopping.mall.homepage.card.headercard.components.b(r5, r6));
        r2.a = Unit.INSTANCE;
        r1.b = true;
    L6:
        if (r1.b == true) goto L8;
        kjc.b r3 = r1.a;
        r0.add(new ToolAreaComponent(r5, r6));
        r0.add(new com.bytedance.android.shopping.mall.homepage.card.headercard.components.a(r5, r6));
        r3.a = Unit.INSTANCE;
    L8:
        Object r7 = r1.a.a;
    }

    public static final void q4(HeaderCardViewHolder r1, boolean r2) {
        r1.s.c = r2;
        Iterator r3 = ((ArrayList) r1.q).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) r3.next()).d();
        goto L4
    }

    public final void b4(Object r12, String r13, k.a r14) {
        Intrinsics.checkNotNullParameter(r13, "itemId");
        super.b4(r12, r13, r14);
        ECHybridListItemVO r15 = ((BaseViewHolder) this).c;
        BtmData r1 = null;
        if (r15 == null) goto L9;
        HashMap r16 = r15.E;
        if (r16 == null) goto L9;
        Object r17 = r16.get("isCacheData");
        if (r17 == null) goto L9;
        String r18 = r17.toString();
    L10:
        boolean r19 = Intrinsics.areEqual(r18, "1");
        ECHybridListItemVO r2 = ((BaseViewHolder) this).c;
        if (r2 == null) goto L15;
        HashMap r3 = r2.E;
        if (r3 == null) goto L15;
        Object r4 = r3.get("skin");
    L17:
        if ((r4 instanceof String) == true) goto L19;
        r4 = null;
    L19:
        String r5 = (String) r4;
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        boolean r6 = false;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L33
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L33
        if (r5.length() <= 0) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L29;
    L31:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        ECHybridListItemVO r0 = ((BaseViewHolder) this).d;
        ECHybridListItemVO r10 = ((BaseViewHolder) this).c;
        if (r0 != r10) goto L45;
        if (r10 == null) goto L39;
        Boolean r11 = r10.F;
    L41:
        if ((!Intrinsics.areEqual(r11, Boolean.TRUE)) == false) goto L45;
        Lazy r110 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "HeaderCardViewHolder onBind fail, data not change");
        return;
    L39:
        r11 = null;
    L45:
        if (r12 != this.o) goto L49;
        Lazy r111 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "HeaderCardViewHolder onBind fail, current mode not change");
        return;
    L49:
        if ((r12 instanceof HeaderCardData) == true) goto L52;
        Lazy r112 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "HeaderCardViewHolder onBind fail, data is not HeaderCardData");
        return;
    L52:
        HeaderCardData r113 = (HeaderCardData) r12;
        this.o = r113;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r20 = this.s;
        r20.e = r19;
        r20.l = r113;
        if (r113 == null) goto L55;
        String r114 = r113.getBffEcomSceneId();
    L56:
        if (r114 != null) goto L58;
    L61:
        boolean r21 = true;
    L62:
        if (r21 == true) goto L64;
        r20.b = r114;
    L64:
        HeaderCardData r115 = this.o;
        if (r115 == null) goto L71;
        HeaderCardData.MiddleArea r116 = r115.getMiddleArea();
        if (r116 == null) goto L71;
        HeaderCardData.ChannelCards r117 = r116.getActivityList();
        if (r117 == null) goto L71;
        BtmData r118 = r117.getBtmData();
    L72:
        if (r118 == null) goto L80;
        HeaderCardData r119 = this.o;
        if (r119 == null) goto L83;
        HeaderCardData.MiddleArea r120 = r119.getMiddleArea();
        if (r120 == null) goto L83;
        HeaderCardData.ChannelCards r121 = r120.getActivityList();
        if (r121 == null) goto L83;
        r1 = r121.getBtmData();
    L83:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r122 = this.s;
        if (r1 == null) goto L86;
        r122.j = r1;
    L87:
        Iterator r123 = ((ArrayList) this.q).iterator();
    L89:
        if (r123.hasNext() == false) goto L91;
        ((e) r123.next()).a(this.o, r13);
        goto L89
    L91:
        ECHybridListItemVO r124 = ((BaseViewHolder) this).c;
        if (r124 == null) goto L94;
        r124.F = Boolean.FALSE;
    L94:
        Lazy r125 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.b.f r126 = com.bytedance.android.ec.hybrid.log.mall.b.f.b;
        StringBuilder r127 = new StringBuilder("HeaderCardViewHolder onBind success isCacheData=");
        r127.append(r19);
        r127.append(", skin is empty: ");
        if (r5.length() != 0) goto L97;
        r6 = true;
    L97:
        r127.append(r6);
        ECMallLogUtil.c(r126, r127.toString());
        return;
    L86:
        r122.getClass();
        goto L87
    L80:
        HeaderCardData r128 = this.o;
        if (r128 == null) goto L83;
        r1 = r128.getBtmData();
    L71:
        r118 = null;
        goto L72
    L58:
        if (r114.length() == 0) goto L61;
        r21 = false;
        goto L62
    L55:
        r114 = null;
        goto L56
    L29:
        if ((!Intrinsics.areEqual(r5, this.p)) == false) goto L31;
        this.p = r5;     // Catch: Throwable -> L33
        Gson r22 = p.a;     // Catch: Throwable -> L33
        this.s.n = (SkinConfig) p.a(r5, SkinConfig.class);     // Catch: Throwable -> L33
        Lazy r23 = ECMallLogUtil.a;     // Catch: Throwable -> L33
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "HeaderCardViewHolder onBind skin parse cost=" + (System.currentTimeMillis() - r8));     // Catch: Throwable -> L33
        goto L31
    L26:
        r9 = false;
    L33:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        r4 = null;
    L9:
        r18 = null;
        goto L10
    }

    public final void d4(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "pageSource");
        r4(r2, r3, r4);
    }

    public final void r4(boolean r7, String r8, String r9) {
        if (r7 == false) goto L10;
        ECHybridListItemVO r1 = ((BaseViewHolder) this).c;
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.K != true) goto L10;
    L11:
        boolean r3 = this.s.e;
        if (r2 == false) goto L16;
        if (r7 == false) goto L16;
        if (r3 == true) goto L16;
        this.r.post(new d(this));
    L16:
        this.s.Q0(r7, Boolean.valueOf(r3), r2);
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "headerCard_visible: " + r7 + ", source:" + r8 + ", pageSource:" + r9 + ", isCacheData:" + r3 + ", isFirstShow:" + r2);
        if (r2 == false) goto L22;
        ECHybridListItemVO r10 = ((BaseViewHolder) this).c;
        if (r10 == null) goto L23;
        r10.K = false;
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r2 = false;
        goto L11
    }
}
