package com.bytedance.android.shopping.commentv3.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentLynxComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentTemplate;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackerProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/CommentLynxView;", "Lcom/bytedance/android/ui/base/widget/round/RoundFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentLynxView extends com.bytedance.android.ui.base.widget.round.RoundFrameLayout {
    public l a;

    public CommentLynxView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentLynxView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(CommentLynxComponent r15, com.bytedance.android.shopping.commentv3.data.b r16) {
        Intrinsics.checkNotNullParameter(r15, "component");
        if (this.a == null) goto L5;
        return;
    L5:
        Map<String, Object> r1 = r15.getStyle();
        boolean r3 = false;
        if (r1 == null) goto L8;
        int r2 = nc3.a.b(r1, "min_height", 0);
    L9:
        setMinimumHeight(CJPayBasicExtensionKt.dp(r2));
        Map<String, Object> r4 = r15.getStyle();
        Integer r5 = null;
        if (r4 == null) goto L12;
        Object r6 = r4.get("margin");
    L13:
        if (r16 == null) goto L20;
        fc3.a r7 = r16.b;
        if (r7 == null) goto L20;
        fc3.a.C0195a r8 = r7.b;
        if (r8 == null) goto L20;
        Function1<Number, Integer> r9 = r8.e;
        if (r9 == null) goto L20;
    L21:
        nc3.b.b(this, r6, r9);
        CommentTemplate r10 = r15.getTemplate();
        if (r10 == null) goto L24;
        String r11 = r10.getUrl();
    L25:
        if (r11 != null) goto L27;
    L28:
        r3 = true;
    L29:
        if (r3 == false) goto L31;
        return;
    L31:
        HashMap r12 = new HashMap();
        r12.put("type", r10.getType());
        Map<String, Object> r13 = r15.getData();
        String r14 = "";
        if (r13 == null) goto L35;
        String r17 = nc3.a.e(r13, "content", null);
        if (r17 == null) goto L35;
    L36:
        r12.put("content", r17);
        Map<String, Object> r18 = r15.getData();
        if (r18 == null) goto L39;
        Object r19 = r18.get("extra_data");
    L40:
        r12.put("extra_data", r19);
        HashMap r20 = new HashMap();
        TrackerProvider.a r21 = TrackerProvider.Companion;
        Context r22 = getContext();
        if (r22 == null) goto L48;
        Activity r23 = d0.a.getActivity(r22);
        if ((r23 instanceof FragmentActivity) == true) goto L46;
        r23 = null;
    L46:
        FragmentActivity r24 = (FragmentActivity) r23;
        if (r24 == null) goto L48;
        Object r25 = ViewModelProviders.of(r24).get(TrackerProvider.class).getTracker();
        if ((r25 instanceof t53.a) == true) goto L52;
        r25 = null;
    L52:
        t53.a r26 = (t53.a) r25;
    L53:
        if (r26 == null) goto L55;
        HashMap r27 = r26.a;
    L57:
        if (r27 == null) goto L60;
        String r28 = (String) r27.get("EVENT_ORIGIN_FEATURE");
        if (r28 == null) goto L60;
    L61:
        r20.put("EVENT_ORIGIN_FEATURE", r28);
        if (r27 == null) goto L65;
        String r29 = (String) r27.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        if (r29 == null) goto L65;
    L66:
        r20.put(PdpOpenThirdParam.KEY_PRODUCT_ID, r29);
        if (r27 == null) goto L70;
        String r30 = (String) r27.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r30 == null) goto L70;
    L71:
        r20.put(PdpOpenThirdParam.KEY_PAGE_NAME, r30);
        if (r27 == null) goto L75;
        String r31 = (String) r27.get("comment_entrance");
        if (r31 == null) goto L75;
    L76:
        r20.put("comment_entrance", r31);
        if (r27 == null) goto L80;
        String r32 = (String) r27.get("carrier_source");
        if (r32 == null) goto L80;
    L81:
        r20.put("carrier_source", r32);
        if (r27 == null) goto L85;
        String r33 = (String) r27.get("source_method");
        if (r33 == null) goto L85;
    L86:
        r20.put("source_method", r33);
        if (r27 == null) goto L90;
        String r34 = (String) r27.get("previous_page");
        if (r34 == null) goto L90;
    L91:
        r20.put("previous_page", r34);
        if (r27 == null) goto L95;
        String r35 = (String) r27.get("ecom_group_type");
        if (r35 == null) goto L95;
    L96:
        r20.put("ecom_group_type", r35);
        if (r27 == null) goto L100;
        String r36 = (String) r27.get("store_type");
        if (r36 == null) goto L100;
    L101:
        r20.put("store_type", r36);
        if (r16 == null) goto L104;
        r5 = Integer.valueOf(r16.a());
    L104:
        r20.put("data_type", String.valueOf(r5));
        if (r16 == null) goto L110;
        String r0 = String.valueOf(r16.h.c);
        if (r0 == null) goto L110;
        r14 = r0;
    L110:
        r20.put("total_count", r14);
        r12.put("track_params", r20);
        this.a = ECLiveHybridUtil.b(getContext(), r11, r12, this, null, null, null, false, null, null, false, 4080);
        return;
    L100:
        r36 = "";
    L95:
        r35 = "";
    L90:
        r34 = "";
    L85:
        r33 = "";
    L80:
        r32 = "";
    L75:
        r31 = "";
    L70:
        r30 = "";
    L65:
        r29 = "";
    L60:
        r28 = "";
        goto L61
    L55:
        r27 = null;
    L48:
        r26 = null;
        goto L53
    L39:
        r19 = null;
    L35:
        r17 = "";
        goto L36
    L27:
        if (r11.length() != 0) goto L29;
    L24:
        r11 = null;
    L20:
        r9 = CommentLynxView$setStyle$slcDp$1.INSTANCE;
        goto L21
    L12:
        r6 = null;
        goto L13
    L8:
        r2 = 0;
        goto L9
    }

    public CommentLynxView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CommentLynxView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
