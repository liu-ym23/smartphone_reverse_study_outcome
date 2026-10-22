package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionHeaderStoreEntranceType;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;
import si2.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/IronListHeaderInfoLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronListHeaderInfoLayout extends LinearLayout {
    public static final /* synthetic */ int e = 0;
    public final CustomEllipsisPositionTextView a;
    public final LinearLayout b;
    public final ImageView c;
    public final ECDraweeView d;

    public static final class a {
    }

    static {
    }

    public IronListHeaderInfoLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IronListHeaderInfoLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "block");
        Iterator r0 = CollectionsKt.listOf(new View[]{this.a, this.b, this.c}).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View r1 = (View) r0.next();
        if (r1 == null) goto L4;
        com.bytedance.android.ec.core.widget.f.c(r1, null, "bind_key_live_promotion_list", new IronListHeaderInfoLayout$onClickedInfo$$inlined$forEach$lambda$1(r7), 1);
        goto L4
    }

    public IronListHeaderInfoLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560772, this, true);
        this.a = (CustomEllipsisPositionTextView) findViewById(2131375290);
        this.b = (LinearLayout) findViewById(2131375289);
        this.c = (ImageView) findViewById(2131375283);
        this.d = findViewById(2131375280);
    }

    public /* synthetic */ IronListHeaderInfoLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Integer, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v6 */
    public final void a(r r29, final Map r30, final String r31, final int r32, final PromotionHeaderStoreEntranceType r33, final gi2.a r34, final Pair r35) {
        Intrinsics.checkNotNullParameter(r31, LocationMonitorConst.TYPE);
        Intrinsics.checkNotNullParameter(r33, "storeEntranceType");
        List<ECRitTag> r0 = r29.d;
        if (r0 == null) goto L21;
        List<ECRitTag> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L20;
        ECUrlModel r4 = ((ECRitTag) r3.next()).getIconUrlModel();
        if (r4 == null) goto L18;
        Integer r5 = Integer.valueOf(r4.getHeight());
        if (r5.intValue() == 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        int r7 = UtilityKotlinExtentionsKt.d(Float.valueOf((r4.getWidth() * 14.0f) / r5.intValue())) + UtilityKotlinExtentionsKt.d(4);
    L19:
        r2.add(Integer.valueOf(r7));
        goto L6
    L12:
        r6 = false;
    L18:
        r7 = 0;
        goto L19
    L20:
        int r8 = CollectionsKt.sumOfInt(r2);
    L22:
        ECPromotionList.i r9 = r29.g;
        if (r9 == null) goto L27;
        ECUrlModel r10 = r9.icon;
        if (r10 == null) goto L27;
        int r11 = r10.getWidth() + 4;
    L28:
        int r12 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r11));
        CustomEllipsisPositionTextView r13 = this.a;
        if (r13 == null) goto L42;
        r13.setTextSize(1, r29.c);
        if (r29.g == null) goto L33;
        boolean r14 = true;
    L34:
        r13.setNeedCompat(r14);
        StringBuilder r15 = new StringBuilder();
        r15.append(r29.a);
        String r16 = r29.b;
        if (r16 != null) goto L37;
        r16 = "";
    L37:
        r15.append(r16);
        String r17 = r15.toString();
        String r18 = r29.b;
        if (r18 == null) goto L40;
        int r19 = r18.length();
    L41:
        r13.y(r17, r19, (r32 - r12) - r8, true);
        goto L42
    L40:
        r19 = Integer.MAX_VALUE;
        goto L41
    L33:
        r14 = false;
    L42:
        LinearLayout r20 = this.b;
        if (r20 == null) goto L45;
        r20.removeAllViews();
    L45:
        ImageView r21 = this.c;
        if (r21 != null) goto L48;
    L55:
        final ECPromotionList.i r22 = r29.g;
        if (r22 == null) goto L73;
        ImageView r23 = this.c;
        if (r23 == null) goto L60;
        r23.setVisibility(8);
    L60:
        final ECDraweeView r24 = this.d;
        if (r24 == null) goto L72;
        r24.setVisibility(0);
        ECUrlModel r25 = r22.icon;
        if (r25 == null) goto L65;
        ViewGroup.LayoutParams r26 = r24.getLayoutParams();
        r26.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r25.getWidth()));
        r26.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r25.getHeight()));
        h0.d(r24, r25, null, null, null, null, null, 120);
    L65:
        final String r27 = r22.schema;
        if (r27 == null) goto L68;
        final boolean r110 = false;
        List<ECRitTag> r111 = null;
        com.bytedance.android.ec.core.widget.f.c(r24, null, null, new IronListHeaderInfoLayout$bindData$$inlined$let$lambda$1(r27, r24, r22, this, r32, r34, r30, r31, r110, r33, r35), 3);
    L69:
        String r28 = r22.trackName;
        Map<String, String> r36 = r22.eventParams;
        if (r34 == null) goto L77;
        v r37 = new v(r28 + "show", r34);
        r37.d(r36);
        r37.i("a1.b0715.c9204.d975243");
    L77:
        List<ECRitTag> r38 = r111;
    L78:
        List<ECRitTag> r112 = r29.d;
        if (r112 == null) goto L116;
        if ((!r112.isEmpty()) == true) goto L84;
        r112 = r38;
    L84:
        if (r112 == null) goto L116;
        Iterator r39 = r112.iterator();
        int r40 = 0;
    L87:
        if (r39.hasNext() == false) goto L116;
        Object r41 = r39.next();
        int r42 = r40 + 1;
        if (r40 >= 0) goto L91;
        CollectionsKt.throwIndexOverflow();
    L91:
        ECRitTag r43 = (ECRitTag) r41;
        LinearLayout r44 = this.b;
        if (r44 == null) goto L94;
        int r45 = 0;
        r44.setVisibility(0);
    L95:
        ECUrlModel r46 = r43.getIconUrlModel();
        if (r46 == null) goto L114;
        SimpleDraweeView r47 = new SimpleDraweeView(getContext());
        ?? r113 = Integer.valueOf(r46.getHeight());
        if (r113.intValue() <= 0) goto L100;
        boolean r48 = true;
    L101:
        if (r48 == true) goto L104;
        r113 = r38;
    L104:
        if (r113 != 0) goto L119;
    L111:
        LinearLayout r49 = this.b;
        if (r49 == null) goto L114;
        r49.addView(r47);
        goto L114
    L119:
        LinearLayout.LayoutParams r50 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf((r46.getWidth() * 14.0f) / r113.intValue())), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));     // Catch: Exception -> L108
        r50.leftMargin = UtilityKotlinExtentionsKt.d(4);     // Catch: Exception -> L108
        setOrientation(r45);     // Catch: Exception -> L108
        r50.gravity = 17;     // Catch: Exception -> L108
        Unit r51 = Unit.INSTANCE;     // Catch: Exception -> L108
        r47.setLayoutParams(r50);     // Catch: Exception -> L108
    L110:
        r47.setImageURI(r46.getFirstUrl());
    L108:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L110
    L100:
        r48 = false;
    L114:
        r40 = r42;
        goto L87
    L94:
        r45 = 0;
    L116:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_STORE_ENTRANCE_SHOW().booleanValue() == true) goto L128;
        f.d(this, r30, r31, "top_avatar", r33.getValue(), r29.e, r34, r35, r29.h);
        return;
    L128:
        return;
    L68:
        r111 = null;
        goto L69
    L72:
        r38 = null;
        goto L78
    L73:
        r111 = null;
        ECDraweeView r52 = this.d;
        if (r52 == null) goto L76;
        r52.setVisibility(8);
    L76:
        Unit r53 = Unit.INSTANCE;
        goto L77
    L48:
        if (r29.e.length() != 0) goto L50;
        boolean r54 = true;
    L51:
        if (r54 == false) goto L53;
        int r55 = 8;
    L54:
        r21.setVisibility(r55);
        goto L55
    L53:
        r55 = 0;
        goto L54
    L50:
        r54 = false;
    L27:
        r11 = 14;
        goto L28
    L21:
        r8 = 0;
        goto L22
    }
}
