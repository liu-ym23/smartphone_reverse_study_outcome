package com.bytedance.android.shopping.deepfeed.ui.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final Map<String, List<Long>> h = null;
    public static final ed3.c i = null;
    public static Boolean j;
    public final ViewStub a;
    public CardView b;
    public SimpleDraweeView c;
    public int d;
    public AppCompatTextView e;
    public final View f;
    public final com.bytedance.android.shopping.deepfeed.action.h g;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.ui.view.g$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/g$a$a;", "", "", "", "showTimes", "Ljava/util/List;", "a", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0062a {

            @SerializedName("show_times")
            private final List<Long> showTimes;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0062a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.showTimes, ((C0062a) r2).showTimes) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                List<Long> r0 = this.showTimes;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "ShowTimeInfo(showTimes=" + this.showTimes + ")";
            }

            public C0062a() {
                this(new ArrayList());
            }

            public final List<Long> a() {
                return this.showTimes;
            }

            public C0062a(List<Long> r1) {
                this.showTimes = r1;
            }
        }
    }

    static {
        h = new LinkedHashMap();
        i = new ed3.c();
    }

    public final void a() {
        int r0 = this.d;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != 1) goto L17;
        CardView r1 = this.b;
        if (r1 == null) goto L12;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L12;
        r2.cancel();
    L12:
        CardView r3 = this.b;
        if (r3 == null) goto L15;
        ExtensionsKt.gone(r3);
    L15:
        this.d = 0;
        return;
    L17:
        CardView r4 = this.b;
        if (r4 == null) goto L21;
        r4.animate().alpha(0.0f).setDuration(280).start();
        return;
    }

    public g(View r2, com.bytedance.android.shopping.deepfeed.action.b r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "deepFeedContext");
        this.f = r2;
        this.g = r3;
        this.a = (ViewStub) r2.findViewById(2131368701);
        r3.getClass();
    }

    public final void b(int r12, double r13, int r15) {
        Intrinsics.checkNotNullParameter("deep_feed_swipe_show_time", "tipsName");
        Intrinsics.checkNotNullParameter("下一条相关商品", "tipsDesc");
        List<Long> r0 = (List) ((LinkedHashMap) h).get("deep_feed_swipe_show_time");
        if (r0 != null) goto L18;
        i.getClass();
        Intrinsics.checkNotNullParameter("deep_feed_swipe_version", "key");
        if ((-1) >= r12) goto L105;
        Intrinsics.checkNotNullParameter("deep_feed_swipe_version", "key");
        Intrinsics.checkNotNullParameter("deep_feed_swipe_show_time", "key");
        r0 = new ArrayList();
        goto L18
    L105:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("deep_feed_swipe_show_time", "key");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("{}", "defaultValue");     // Catch: Throwable -> L12
        List<Long> r16 = ((a.C0062a) u0.b("", a.C0062a.class)).a();     // Catch: Throwable -> L12
        if (r16 != null) goto L10;
        r16 = new ArrayList();     // Catch: Throwable -> L12
    L10:
        r0 = r16;
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r17) == null) goto L18;
        r0 = new ArrayList();
    L12:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        if (r0 != null) goto L20;
    L39:
        boolean r18 = false;
    L40:
        if (r18 == true) goto L42;
        return;
    L42:
        if (this.b != null) goto L89;
        ViewStub r19 = this.a;
        SimpleDraweeView r110 = null;
        if (r19 == null) goto L46;
        View r111 = r19.inflate();
    L48:
        if ((r111 instanceof CardView) == true) goto L50;
        r111 = null;
    L50:
        CardView r112 = (CardView) r111;
        this.b = r112;
        if (r112 == null) goto L53;
        r112.setElevation(20.0f);
    L53:
        CardView r113 = this.b;
        if (r113 == null) goto L56;
        r113.setMaxCardElevation(20.0f);
    L56:
        CardView r114 = this.b;
        if (r114 == null) goto L59;
        AppCompatTextView r115 = (AppCompatTextView) r114.findViewById(2131368703);
    L60:
        this.e = r115;
        if (Build.VERSION.SDK_INT < 28) goto L68;
        CardView r116 = this.b;
        if (r116 == null) goto L65;
        r116.setOutlineSpotShadowColor(ColorProtector.parseColor("#66000000"));
    L65:
        CardView r117 = this.b;
        if (r117 == null) goto L68;
        r117.setOutlineAmbientShadowColor(ColorProtector.parseColor("#66000000"));
    L68:
        CardView r118 = this.b;
        if (r118 == null) goto L71;
        r110 = (SimpleDraweeView) r118.findViewById(2131368704);
    L71:
        this.c = r110;
        if (r110 == null) goto L76;
        ViewGroup.LayoutParams r119 = r110.getLayoutParams();
        if (r119 == null) goto L76;
        com.bytedance.android.shopping.deepfeed.ui.view.a r120 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r119.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(this.f.getContext(), 24);
        r119.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(this.f.getContext(), 24);
    L76:
        CardView r121 = this.b;
        if (r121 == null) goto L81;
        AppCompatTextView r122 = (ProductTextView) r121.findViewById(2131368702);
        if (r122 == null) goto L81;
        com.bytedance.android.shopping.deepfeed.ui.view.a r1 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r122.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r122.getContext(), 14));
    L81:
        CardView r123 = this.b;
        if (r123 == null) goto L86;
        AppCompatTextView r124 = (ProductTextView) r123.findViewById(2131368703);
        if (r124 == null) goto L86;
        com.bytedance.android.shopping.deepfeed.ui.view.a r125 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r124.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r124.getContext(), 14));
    L86:
        CardView r126 = this.b;
        if (r126 == null) goto L89;
        r126.setAlpha(0.0f);
        goto L89
    L59:
        r115 = null;
        goto L60
    L46:
        r111 = null;
    L89:
        AppCompatTextView r127 = this.e;
        if (r127 == null) goto L93;
        r127.setText("下一条相关商品");
    L93:
        if (this.d != 2) goto L95;
        boolean r128 = true;
    L96:
        if (r128 == true) goto L114;
        CardView r129 = this.b;
        if (r129 == null) goto L101;
        r129.setVisibility(0);
    L101:
        AbstractDraweeController r130 = Fresco.newDraweeControllerBuilder().setUri("asset:///deep_feed_swipe_tips_anim.webp").setAutoPlayAnimations(true).setControllerListener(new i(this)).build();
        SimpleDraweeView r131 = this.c;
        if (r131 == null) goto L113;
        r131.setController(r130);
        return;
    L113:
        return;
    L114:
        return;
    L95:
        r128 = false;
        goto L96
    L20:
        if (r0.size() >= r15) goto L23;
    L38:
        r18 = true;
        goto L40
    L23:
        if ((!r0.isEmpty()) == true) goto L25;
    L27:
        ArrayList r4 = new ArrayList();
        Iterator r2 = r0.iterator();
    L29:
        if (r2.hasNext() == false) goto L36;
        Object r5 = r2.next();
        if ((System.currentTimeMillis() - ((Number) r5).longValue()) > (86400000 * r13)) goto L33;
        boolean r6 = true;
    L34:
        if (r6 == false) goto L29;
        r4.add(r5);
        goto L29
    L33:
        r6 = false;
        goto L34
    L36:
        List<Long> r132 = CollectionsKt.toMutableList(r4);
        h.put("deep_feed_swipe_show_time", r132);
        if (r132.size() >= r15) goto L39;
    L25:
        if (r13 >= 0) goto L27;
        goto L27
    }
}
