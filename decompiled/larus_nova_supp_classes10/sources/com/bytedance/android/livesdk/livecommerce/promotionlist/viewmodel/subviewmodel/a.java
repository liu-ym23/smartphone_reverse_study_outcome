package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.iron.ui.j;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageBottomData;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.b implements j {
    public volatile boolean c;
    public final MutableLiveData<LivePromotionPageBottomData> d;
    public final MutableLiveData e;
    public boolean f;
    public final Function0<LivePromotionListParams> g;
    public final Function0<List<ql.a>> h;
    public final Function0<ql.a> i;
    public final Function0<PromotionCategory> j;
    public final Function0<gi2.a> k;
    public final Function0<RoomContextController> l;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a$a, reason: collision with other inner class name */
    public static final class C0098a<T> implements Observer {
        public final /* synthetic */ Function1 a;

        public C0098a(Function1 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LivePromotionPageBottomData r3 = (LivePromotionPageBottomData) r2;
            Function1 r0 = this.a;
            if (r3 == null) goto L5;
            xi2.j r4 = r3.getBottomInfo();
        L6:
            r0.invoke(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final RoomContextController b() {
        return (RoomContextController) this.l.invoke();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final boolean c() {
        if (this.j.invoke() == null) goto L20;
        LivePromotionPageBottomData r0 = (LivePromotionPageBottomData) this.e.getValue();
        if (r0 == null) goto L10;
        xi2.j r1 = r0.getBottomInfo();
        if (r1 == null) goto L10;
        if (r1.d() != true) goto L10;
        return true;
    L10:
        PromotionCategory r2 = (PromotionCategory) this.j.invoke();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r2.isAllTab() != true) goto L15;
        r3 = true;
        goto L16
    L20:
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final String e() {
        if (this.j.invoke() == null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L16;
        LivePromotionPageBottomData r1 = (LivePromotionPageBottomData) this.e.getValue();
        if (r1 == null) goto L11;
        xi2.j r2 = r1.getBottomInfo();
    L12:
        if (r2 == null) goto L16;
        LivePromotionPageBottomData r3 = (LivePromotionPageBottomData) this.e.getValue();
        if (r3 != null) goto L21;
        return null;
    L21:
        return r3.getBottomRecommendTitle();
    L11:
        r2 = null;
    L16:
        LivePromotionPageBottomData r4 = (LivePromotionPageBottomData) this.e.getValue();
        if (r4 != null) goto L19;
        return null;
    L19:
        return r4.getBottomTitle();
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final xi2.j f() {
        LivePromotionPageBottomData r0 = (LivePromotionPageBottomData) this.e.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBottomInfo();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final List<String> g() {
        PromotionCategory r0 = (PromotionCategory) this.j.invoke();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isAllTab() != true) goto L7;
    L8:
        ArrayList r2 = null;
        if (r1 == false) goto L11;
        return null;
    L11:
        List r3 = (List) this.h.invoke();
        if (r3 == null) goto L17;
        List r4 = r3;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r2.add(((ql.a) r5.next()).getProductId());
    L17:
        return r2;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final String getRoomId() {
        LivePromotionListParams r0 = (LivePromotionListParams) this.g.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomId();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final gi2.a j() {
        return (gi2.a) this.k.invoke();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final void h(boolean r3) {
        if (this.f == r3) goto L12;
        this.f = r3;
        if (r3 == false) goto L13;
        int r4 = ECSdk.a;
        b93.c r5 = (b93.c) ECSdk.a(b93.c.class);
        if (r5 == null) goto L14;
        b93.b r6 = r5.b();
        if (r6 == null) goto L15;
        r6.sendEvent("list_footer_show", new JSONObject());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.ui.j
    public final void d(LifecycleOwner r3, Function1<? super xi2.j, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.e.observe(r3, new C0098a(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<LivePromotionListParams> r2, Function0<? extends List<? extends ql.a>> r3, Function0<? extends ql.a> r4, Function0<PromotionCategory> r5, Function0<gi2.a> r6, Function0<RoomContextController> r7) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "currentPromotions");
        Intrinsics.checkNotNullParameter(r4, "getRecentExplainPromotion");
        Intrinsics.checkNotNullParameter(r5, "getCurrentCategory");
        Intrinsics.checkNotNullParameter(r6, "promotionListParams");
        Intrinsics.checkNotNullParameter(r7, "roomContextController");
        super(0);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        MutableLiveData<LivePromotionPageBottomData> r8 = new MutableLiveData();
        this.d = r8;
        this.e = r8;
    }
}
