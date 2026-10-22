package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.api.d;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.shopping.store.utils.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b \u0010!R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedLynxCardView;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getLoadingImageView", "()Landroid/widget/ImageView;", "setLoadingImageView", "(Landroid/widget/ImageView;)V", "loadingImageView", "b", "Landroid/widget/FrameLayout;", "getLynxContainer", "()Landroid/widget/FrameLayout;", "setLynxContainer", "(Landroid/widget/FrameLayout;)V", "lynxContainer", "Lkotlin/Function1;", "", "", "c", "Lkotlin/jvm/functions/Function1;", "getOnLoadLynxSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLoadLynxSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "onLoadLynxSuccessCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShopFeedLynxCardView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public ImageView a;
    public FrameLayout b;
    public Function1<? super Integer, Unit> c;
    public ShopFeedItemCard d;
    public ECLynxCard e;

    public static final class a {
    }

    public static final class b implements IECLynxCardLifeCycle {
        public final /* synthetic */ AbsShopFeedLynxCardView a;
        public final /* synthetic */ int b;

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

        public final void onTimingSetupPref(k r1) {
        }

        public final void onTimingUpdatePref(k r1) {
        }

        public final void onTransDataTime(long r1, long r3) {
        }

        public final void onLoadSuccess() {
            ImageView r0 = this.a.getLoadingImageView();
            if (r0 == null) goto L5;
            r0.setVisibility(8);
        L5:
            this.a.getOnLoadLynxSuccessCallback().invoke(Integer.valueOf(this.b));
            dm.a.a("AbsShopFeedLynxCardView").a("bindData onLoadSuccess");
        }

        public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r2) {
            Intrinsics.checkNotNullParameter(r2, "cache");
            Intrinsics.checkNotNullParameter(r2, "cache");
        }

        public b(AbsShopFeedLynxCardView r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onLoadFailed(ECLynxCardErrorType r4, Integer r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "type");
            dm.a.a("AbsShopFeedLynxCardView").a("bindData onLoadFailed errType: " + r4 + ", errorCode: " + r5 + " errMsg: " + r6);
        }
    }

    static {
    }

    public AbsShopFeedLynxCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AbsShopFeedLynxCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public Map b(ShopFeedItemCard r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "card");
        Intrinsics.checkNotNullParameter(r2, "passThroughParams");
        return null;
    }

    public final ImageView getLoadingImageView() {
        return this.a;
    }

    public final FrameLayout getLynxContainer() {
        return this.b;
    }

    public final Function1<Integer, Unit> getOnLoadLynxSuccessCallback() {
        return this.c;
    }

    public final void setLoadingImageView(ImageView r1) {
        this.a = r1;
    }

    public final void setLynxContainer(FrameLayout r1) {
        this.b = r1;
    }

    public final void setOnLoadLynxSuccessCallback(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void c(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "params");
        dm.a.a("AbsShopFeedLynxCardView").a("item: " + hashCode() + ", sendJsEvent, event: " + r4 + ", params: " + r5);
        ECLynxCard r0 = this.e;
        if (r0 == null) goto L6;
        r0.o(r4, r5);
        return;
    }

    public AbsShopFeedLynxCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = AbsShopFeedLynxCardView$onLoadLynxSuccessCallback$1.INSTANCE;
    }

    public /* synthetic */ AbsShopFeedLynxCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(ShopFeedItemCard r7, String r8, int r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "card");
        Intrinsics.checkNotNullParameter(r8, "passThroughParams");
        FrameLayout r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        this.d = r7;
        LinkedHashMap r1 = new LinkedHashMap();
        String r2 = r7.getItemId();
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r1.put("item_id", r2);
        r1.put("card_index", Integer.valueOf(r9));
        String r4 = r7.getLynxCardData();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r1.put("lynx_item_data", r4);
        r1.put("is_current_show", Boolean.valueOf(r10));
        r1.put("pass_through_params", r8);
        Map r11 = b(r7, r8, r10);
        if (r11 == null) goto L17;
        String r12 = f.b(r11);
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        r1.put("extra", r12);
    L17:
        ECLynxCard r13 = this.e;
        if (r13 == null) goto L26;
        int r14 = d.e;
        r13.e(d.a.a(r1), true);
        ShopFeedItemCard r15 = this.d;
        if (r15 == null) goto L37;
        Map<String, Object> r16 = r15.getExtraLynxCardData();
        if (r16 == null) goto L38;
        ECLynxCard r17 = this.e;
        if (r17 == null) goto L39;
        r17.e(d.a.c("", r16), false);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L26:
        this.e = new ECLynxCard();
        Context r5 = getContext();
        String r6 = r7.getLynxCardSchema();
        if (r6 == null) goto L30;
        r3 = r6;
    L30:
        ECLynxLoadParam.a r18 = new ECLynxLoadParam.a(r5, r3, r0);
        ViewGroup.LayoutParams r19 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r19, "ecLayoutParams");
        r18.u = r19;
        r18.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ec.lynxCardSetData", new LynxStatefulBridgeProxy(new AbsShopFeedLynxCardView$makeJsBridgeMap$1(this), "ec.lynxCardSetData")), TuplesKt.to("openNativeSKU", new LynxStatefulBridgeProxy(new AbsShopFeedLynxCardView$makeJsBridgeMap$2(this), "openNativeSKU"))}));
        r18.j = f.b(r1);
        Map<String, Object> r20 = r7.getExtraLynxCardData();
        if (r20 != null) goto L33;
        r20 = MapsKt.emptyMap();
    L33:
        Intrinsics.checkNotNullParameter(r20, "appendData");
        r18.m = r20;
        b r21 = new b(this, r9);
        Intrinsics.checkNotNullParameter(r21, "lifecycle");
        r18.o = r21;
        ECLynxLoadParam r22 = new ECLynxLoadParam(r18);
        ECLynxCard r23 = this.e;
        if (r23 == null) goto L41;
        r23.j(r22);
        return;
    }
}
