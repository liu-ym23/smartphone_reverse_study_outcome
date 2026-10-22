package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSliceCommonCardPresenter extends QFragmentPresenter implements ln.c {
    public static final /* synthetic */ int p = 0;
    public final Lazy f;
    public com.bytedance.android.ec.store.repository.vo.j g;
    public String h;
    public final Lazy i;
    public ln.b j;
    public final float k;
    public boolean l;
    public final com.bytedance.android.shopping.store.hybridproduct.holder.e m;
    public final ECStoreViewModel n;
    public final nn.b o;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/presenter/ShopSliceCommonCardPresenter$PlayState;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "PLAY", "STOP", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlayState extends Enum<PlayState> {
        public static final PlayState DEFAULT = null;
        public static final PlayState PLAY = null;
        public static final PlayState STOP = null;
        public static final /* synthetic */ PlayState[] a = null;
        private final int value;

        static {
            PlayState r1 = new PlayState("DEFAULT", 0, 0);
            DEFAULT = r1;
            PlayState r2 = new PlayState("PLAY", 1, 1);
            PLAY = r2;
            PlayState r3 = new PlayState("STOP", 2, 2);
            STOP = r3;
            a = new PlayState[]{r1, r2, r3};
        }

        public static PlayState valueOf(String r1) {
            return (PlayState) r27.a.a(PlayState.class, r1);
        }

        public static PlayState[] values() {
            return (PlayState[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public PlayState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final Rect r() {
        return null;
    }

    public final void v() {
    }

    public final void B() {
        if (this.l == true) goto L5;
        return;
    L5:
        this.l = false;
        d0(PlayState.STOP);
    }

    public final void R() {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        d0(PlayState.PLAY);
    }

    public final void c0() {
        com.bytedance.android.shopping.store.hybridproduct.holder.e r0 = this.m;
        if (r0 == null) goto L10;
        com.bytedance.android.ecom.arch.slice.render.r r1 = r0.a;
        if (r1 == null) goto L11;
        SlcTemplateContext r2 = r1.b;
        if (r2 == null) goto L12;
        r2.u(this.h);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void startPlay() {
        R();
        x();
    }

    public final void stopPlay() {
        B();
        z();
    }

    public final void M() {
        ln.c.a.a(this);
    }

    public final PlayAbleType P() {
        return PlayAbleType.OTHER;
    }

    public final boolean isPlaying() {
        return this.l;
    }

    public final ln.b m() {
        return this.j;
    }

    public final void pausePlay() {
        M();
    }

    public final void x() {
        ln.c.a.b(this);
    }

    public final void z() {
        ln.c.a.c(this);
    }

    public final List<ln.c> L(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleArea");
        com.bytedance.android.shopping.store.hybridproduct.holder.e r0 = this.m;
        if (r0 == null) goto L19;
        com.bytedance.android.ecom.arch.slice.render.r r1 = r0.a;
        if (r1 == null) goto L19;
        View r2 = r1.c;
        if (r2 == null) goto L19;
        if (this.l == false) goto L11;
        float r4 = this.k;
    L13:
        if (ln.e.a(r2, r3, r4) == true) goto L17;
        ln.c.a.f(this);
        return CollectionsKt.emptyList();
    L17:
        return CollectionsKt.listOf(this);
    L11:
        r4 = 0.8f;
    L19:
        return CollectionsKt.emptyList();
    }

    public final void b0(QModel r6) {
        String r1 = null;
        if ((r6 instanceof com.bytedance.android.ec.store.repository.vo.j) == true) goto L5;
        QModel r0 = null;
    L7:
        if (((com.bytedance.android.ec.store.repository.vo.j) r0) != null) goto L9;
        return;
    L9:
        com.bytedance.android.ec.store.repository.vo.j r7 = (com.bytedance.android.ec.store.repository.vo.j) r6;
        this.g = r7;
        Map r2 = r7.g;
        if (r2 == null) goto L12;
        r2.put("index", Integer.valueOf(r7.j));
        r2.put("display_state", 0);
        r2.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    L12:
        Map r3 = r7.b();
        com.bytedance.android.shopping.store.hybridproduct.holder.e r4 = this.m;
        if (r4 == null) goto L17;
        com.bytedance.android.ecom.arch.slice.render.r r5 = r4.a;
        if (r5 == null) goto L17;
        r5.b((ShopSliceCommonCardPresenter$actionHandler$2.a) this.i.getValue());
    L17:
        Map r8 = (Map) CollectionsKt.firstOrNull(r7.a);
        if (r8 == null) goto L20;
        Object r9 = r8.get("base_info");
    L22:
        if ((r9 instanceof Map) == true) goto L24;
        r9 = null;
    L24:
        Map r10 = (Map) r9;
        if (r10 == null) goto L27;
        String r11 = (String) r10.get("product_id");
    L29:
        if ((r11 instanceof String) == false) goto L32;
        r1 = r11;
    L32:
        if (r1 != null) goto L34;
        r1 = String.valueOf(r7.a.hashCode());
    L34:
        this.h = r1;
        com.bytedance.android.shopping.store.hybridproduct.holder.e r12 = this.m;
        if (r12 == null) goto L39;
        com.bytedance.android.ecom.arch.slice.render.r r13 = r12.a;
        if (r13 == null) goto L39;
        r13.a(r3, r1);
    L39:
        this.o.a = this;
        this.l = false;
        dm.a.a("ShopSliceCommonCardPresenter").a("onBind: $" + this.h + ",time:" + System.currentTimeMillis());
        return;
    L27:
        r11 = null;
        goto L29
    L20:
        r9 = null;
        goto L22
    L5:
        r0 = r6;
        goto L7
    }

    public final void d0(PlayState r5) {
        dm.a.a("测试播放范围:轻览卖点测试").a("currntId:" + this.h + ",updatePlayStates: " + r5);
        com.bytedance.android.ec.store.repository.vo.j r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L5:
        Map r1 = r0.g;
        if (r1 == null) goto L8;
        r1.put("display_state", Integer.valueOf(r5.getValue()));
        r1.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    L8:
        com.bytedance.android.shopping.store.hybridproduct.holder.e r6 = this.m;
        if (r6 == null) goto L17;
        com.bytedance.android.ecom.arch.slice.render.r r7 = r6.a;
        if (r7 == null) goto L18;
        com.bytedance.android.ec.store.repository.vo.j r2 = this.g;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("currentItem");
    L15:
        r7.a(r2.b(), this.h);
        return;
    L18:
        return;
    }

    public final void k1(nn.e.a r1) {
        this.j = r1;
    }

    public ShopSliceCommonCardPresenter(final Fragment r2, com.bytedance.android.shopping.store.hybridproduct.holder.e r3, ECStoreViewModel r4, nn.b r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        Intrinsics.checkNotNullParameter(r5, "playProxy");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.f = LazyKt.lazy(new ShopSliceCommonCardPresenter$viewModel$2(this, r2));
        this.h = "";
        this.i = LazyKt.lazy(new ShopSliceCommonCardPresenter$actionHandler$2(this, r2));
        this.k = 0.2f;
    }
}
