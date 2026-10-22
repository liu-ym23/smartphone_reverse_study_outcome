package com.bytedance.android.livesdk.livecommerce.iron.ui.top.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.t;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.j0;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.z0;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.b;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEnhancedSearchEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionSearchHint;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/search/ECPromotionListSearchBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEnhancedSearchEntry;", "searchEntry", "", "setHintWithBoundCheck", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListSearchBarView extends ConstraintLayout {
    public final ImageView a;
    public final TextView b;
    public final View c;
    public final ECDraweeView d;
    public Function0<Unit> e;
    public Map<String, String> f;

    public ECPromotionListSearchBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECPromotionListSearchBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setHintWithBoundCheck(ECPromotionEnhancedSearchEntry r10) {
        if (r10 == null) goto L10;
        ECPromotionSearchHint r0 = r10.getHint();
        if (r0 == null) goto L10;
        ECUrlModel r1 = r0.getTagIcon();
        if (r1 == null) goto L10;
        h0.d(this.d, r1, null, Integer.valueOf(UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.getWidth()))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.getHeight()))), null, null, 96);
        ViewGroup.LayoutParams r2 = this.d.getLayoutParams();
        if (r2 == null) goto L10;
        r2.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.getHeight()));
        r2.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r1.getWidth()));
    L10:
        if (r10 == null) goto L29;
        ECPromotionSearchHint r3 = r10.getHint();
        if (r3 == null) goto L29;
        String r4 = r3.getHintText();
        if (r4 == null) goto L29;
        if (r4.length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L29;
        this.b.setText(r4);
        this.c.setVisibility(0);
        t r11 = r10.getHint().getShowTrackInfo();
        if (r11 == null) goto L31;
        String r6 = r11.b();
        if (r6 != null) goto L28;
        r6 = "trending_words_show";
    L28:
        j0 r7 = new j0(r6);
        r7.f("enter_from_second", l0.d());
        r7.n(r11.c());
        r7.k();
        return;
    L31:
        return;
    L18:
        r5 = false;
    L29:
        this.c.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPromotionListSearchBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560773, this, true);
        this.a = (ImageView) findViewById(2131376585);
        this.b = (TextView) findViewById(2131391355);
        this.c = findViewById(2131376687);
        this.d = findViewById(2131376656);
    }

    public /* synthetic */ ECPromotionListSearchBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ECPromotionEnhancedSearchEntry r3, Map<String, String> r4, boolean r5, b r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "onClicked");
        this.e = r7;
        this.f = r4;
        if (r6 == null) goto L10;
        ComponentLargeModeConfig r8 = r6.b("List", "List.Header.SearchBar.Icon");
        if (r8 == null) goto L7;
        int r0 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r8, this.a);
    L7:
        ComponentLargeModeConfig r9 = r6.b("List", "List.Header.SearchBar.Hint");
        if (r9 == null) goto L10;
        int r10 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r9, this.b);
    L10:
        setHintWithBoundCheck(r3);
        String r11 = null;
        if (r3 == null) goto L13;
        final String r12 = r3.getSchema();
    L14:
        final Map<String, String> r13 = this.f;
        if (r12 == null) goto L17;
        f.c(this, null, "bind_key_live_promotion_list", new ECPromotionListSearchBarView$setClickListener$$inlined$let$lambda$1(r12, this, r13), 1);
    L17:
        z0 r14 = new z0(true);
        if (r5 == false) goto L20;
        Intrinsics.checkNotNullParameter("live_instant_store", "pageName");
        r14.f("page_name", "live_instant_store");
    L20:
        ECLiveABUtils r15 = ECLiveABUtils.INSTANCE;
        if (r15.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L27;
        if (r3 == null) goto L26;
        String r16 = r3.getSchema();
        if (r16 == null) goto L26;
        r11 = StringsKt.take(r16, r15.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue());
    L26:
        r14.o(r11);
    L27:
        r14.l("a1.b0715.c9204.d70073", BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        return;
    L13:
        r12 = null;
        goto L14
    }
}
