package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import si2.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements QModel {
    public final MutableLiveData<com.bytedance.android.livesdk.livecommerce.iron.listheader.b> a;
    public final MutableLiveData b;
    public b c;
    public com.bytedance.android.livesdk.livecommerce.largemode.b d;
    public boolean e;
    public Function3<? super String, ? super String, ? super com.bytedance.android.btm.api.model.d, Unit> f;
    public gi2.a g;
    public Pair<Boolean, Boolean> h;

    public static final class a {
    }

    public interface b {
        ECLottieAnimationView b();
    }

    static {
    }

    public final int modelType() {
        return 12;
    }

    public final List<ECRitTag> b() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.a.getValue();
        if (r0 == null) goto L9;
        Map<String, List<ECRitTag>> r1 = r0.a;
        if (r1 == null) goto L9;
        List<ECRitTag> r2 = r1.get("live_room_good_list_header");
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new ArrayList();
    }

    public final List<ECRitTag> c() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.a.getValue();
        if (r0 == null) goto L9;
        Map<String, List<ECRitTag>> r1 = r0.a;
        if (r1 == null) goto L9;
        List<ECRitTag> r2 = r1.get("live_room_good_list_header_before");
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new ArrayList();
    }

    public final com.bytedance.android.livesdk.livecommerce.iron.listheader.b d() {
        return (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.a.getValue();
    }

    public final r e() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.a.getValue();
        r r1 = new r();
        Map<String, String> r2 = null;
        if (r0 == null) goto L8;
        ECPromotionList.f r3 = r0.d;
        if (r3 == null) goto L8;
        String r4 = r3.name;
        if (r4 == null) goto L8;
    L13:
        String r5 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.a = r4;
        if (r0 == null) goto L21;
        ECPromotionList.v r6 = r0.c;
        if (r6 == null) goto L21;
        String r7 = r6.suffixText;
    L22:
        r1.b = r7;
        boolean r8 = true;
        if (r0 == null) goto L34;
        ECPromotionList.f r9 = r0.d;
        if (r9 == null) goto L34;
        Long r10 = Long.valueOf(r9.fontSize);
        if (r10.longValue() <= 0) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == true) goto L33;
        r10 = null;
    L33:
        if (r10 == null) goto L34;
    L44:
        if (r10 == null) goto L46;
        long r12 = r10.longValue();
    L47:
        r1.c = r12;
        if (r0 == null) goto L52;
        ECPromotionList.f r13 = r0.d;
        if (r13 == null) goto L52;
        List<ECRitTag> r14 = r13.tags;
    L53:
        r1.d = r14;
        if (r0 == null) goto L59;
        ECPromotionList.f r15 = r0.d;
        if (r15 == null) goto L59;
        String r16 = r15.jumpUrl;
        if (r16 == null) goto L59;
    L64:
        if (r16 == null) goto L67;
        r5 = r16;
    L67:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.e = r5;
        if (r0 == null) goto L72;
        ECPromotionList.f r17 = r0.d;
        if (r17 == null) goto L72;
        List<Integer> r18 = r17.liveParamsType;
    L73:
        r1.f = r18;
        if (r0 == null) goto L78;
        ECPromotionList.f r19 = r0.d;
        if (r19 == null) goto L78;
        ECPromotionList.i r20 = r19.changeStoreIcon;
    L79:
        r1.g = r20;
        if (r0 == null) goto L82;
        ECPromotionList.f r21 = r0.d;
    L82:
        if (r0 == null) goto L89;
        ECPromotionList.f r22 = r0.d;
        if (r22 == null) goto L89;
        Map<String, String> r23 = r22.eventParams;
        if (r23 == null) goto L89;
        r2 = r23;
    L93:
        r1.h = r2;
        return r1;
    L89:
        if (r0 == null) goto L93;
        ECPromotionList.v r24 = r0.c;
        if (r24 == null) goto L93;
        r2 = r24.eventParams;
    L78:
        r20 = null;
    L72:
        r18 = null;
    L59:
        if (r0 == null) goto L63;
        ECPromotionList.v r25 = r0.c;
        if (r25 == null) goto L63;
        r16 = r25.jumpUrl;
    L63:
        r16 = null;
    L52:
        r14 = null;
        goto L53
    L46:
        r12 = 14;
        goto L47
    L29:
        r11 = false;
    L34:
        if (r0 == null) goto L43;
        ECPromotionList.v r26 = r0.c;
        if (r26 == null) goto L43;
        r10 = Long.valueOf(r26.fontSize);
        if (r10.longValue() > 0) goto L41;
        r8 = false;
    L41:
        if (r8 == true) goto L44;
    L43:
        r10 = null;
    L21:
        r7 = null;
    L8:
        if (r0 == null) goto L12;
        ECPromotionList.v r27 = r0.c;
        if (r27 == null) goto L12;
        r4 = r27.text;
    L12:
        r4 = null;
        goto L13
    }

    public final boolean f() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.a.getValue();
        ECPromotionList.d r1 = null;
        if (r0 == null) goto L5;
        ECPromotionList.f r2 = r0.d;
    L6:
        if (r2 != null) goto L15;
        if (r0 == null) goto L9;
        ECPromotionList.v r3 = r0.c;
    L10:
        if (r3 != null) goto L15;
        if (r0 == null) goto L13;
        r1 = r0.b;
    L13:
        if (r1 == null) goto L15;
        return true;
    L9:
        r3 = null;
    L15:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final String g() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r0 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) this.a.getValue();
        ECPromotionList.v r1 = null;
        if (r0 == null) goto L5;
        ECPromotionList.f r2 = r0.d;
    L6:
        if (r2 == null) goto L8;
        return "shop";
    L8:
        if (r0 == null) goto L10;
        r1 = r0.c;
    L10:
        if (r1 == null) goto L12;
        return "window";
    L12:
        return "";
    L5:
        r2 = null;
        goto L6
    }

    public i() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData(null);
        Boolean r1 = Boolean.FALSE;
        this.h = new Pair(r1, r1);
    }
}
