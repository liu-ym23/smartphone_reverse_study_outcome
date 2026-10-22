package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class UpdatePopPromotionInterceptor extends com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a {
    public final Map<String, String> e;
    public final Map<String, String> f;
    public final Map<String, Boolean> g;
    public final Lazy h;
    public final com.bytedance.android.livesdk.livecommerce.room.utils.g i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/messagev2/interceptor/UpdatePopPromotionInterceptor$a;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "delayTime", "a", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("list_explain_cancel_msg_response_delay_time")
        private final int delayTime;

        @SerializedName("list_explain_msg_opt_type")
        private final int type;

        public a() {
        }

        public final int a() {
            return this.delayTime;
        }

        public final int getType() {
            return this.type;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ sg2.a a;
        public final /* synthetic */ Ref.BooleanRef b;

        public b(sg2.a r1, Ref.BooleanRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            sg2.v r0 = new sg2.v("livesdk_pop_msg_receive", com.bytedance.android.ec.common.api.jump.model.b.a);
            jf.b.f r1 = jf.b.f.b;
            r0.c("ecom_entrance_form", "live_list_card");
            r0.c("promotion_id", String.valueOf(((si2.a0) this.a).promotionId));
            if (this.b.element == false) goto L5;
            String r2 = "1";
        L6:
            r0.c("ignore", r2);
            r0.i(null);
            return;
        L5:
            r2 = BDLocationException.ERROR_TIMEOUT;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public UpdatePopPromotionInterceptor() {
        super(true);
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = LazyKt.lazy(UpdatePopPromotionInterceptor$explainMsgOptConfig$2.INSTANCE);
        this.i = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean d() {
        return !ECLiveABUtils.INSTANCE.getECOM_LIVE_MESSAGE_NO_LOGIN().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r18) {
        Intrinsics.checkNotNullParameter(r18, "message");
        if ((r18 instanceof si2.a0) == true) goto L5;
        return false;
    L5:
        final lj2.a r2 = (lj2.a) b(lj2.a.class, r18);
        StringBuilder r4 = new StringBuilder("explain_msg_opt_");
        sg2.b r5 = r18.getCommon();
        if (r5 == null) goto L8;
        String r6 = r5.e;
    L9:
        r4.append(r6);
        String r8 = r4.toString();
        sg2.b r7 = r18.getCommon();
        if (r7 == null) goto L12;
        final String r9 = r7.e;
    L13:
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = false;
        si2.a0 r11 = (si2.a0) r18;
        int r12 = r11.msgType;
        if (r12 == 0) goto L18;
    L42:
        if (r12 == 1) goto L44;
    L72:
        return false;
    L44:
        if (r11.bubbleType != 0) goto L46;
        boolean r1 = true;
    L47:
        if (r1 == false) goto L72;
        Boolean r3 = (Boolean) ((LinkedHashMap) this.g).get(r9);
        if (r3 == null) goto L51;
        boolean r13 = r3.booleanValue();
    L52:
        a r14 = (a) this.h.getValue();
        if (r14 == null) goto L55;
        long r15 = r14.a();
    L56:
        long r16 = r15 * ((long) 1000);
        if (r16 <= 0) goto L69;
        a r17 = (a) this.h.getValue();
        if (r17 != null) goto L61;
    L62:
        a r19 = (a) this.h.getValue();
        if (r19 == null) goto L69;
        if (r19.getType() != 1) goto L69;
        if (r13 == false) goto L69;
    L67:
        this.i.d(r8, r16, r16, new UpdatePopPromotionInterceptor$intercept$2(this, r2, r9));
        goto L72
    L61:
        if (r17.getType() == 2) goto L67;
    L69:
        if (r2 == null) goto L71;
        r2.t(null, null, null);
    L71:
        this.f.put(r9, null);
        goto L72
    L55:
        r15 = 0;
        goto L56
    L51:
        r13 = false;
        goto L52
    L46:
        r1 = false;
        goto L47
    L18:
        if (r11.bubbleType != 0) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L42;
        if (r11.promotionId <= 0) goto L42;
        a r20 = (a) this.h.getValue();
        if (r20 != null) goto L27;
    L28:
        a r21 = (a) this.h.getValue();
        if (r21 != null) goto L31;
    L38:
        if (r2 == null) goto L40;
        r2.t(String.valueOf(r11.promotionId), null, null);
    L40:
        this.f.put(r9, String.valueOf(r11.promotionId));
        this.e.put(r9, String.valueOf(r11.promotionId));
    L41:
        oh.a.c("pop_msg_recevie", new b(r18, r10));
        goto L72
    L31:
        if (r21.getType() != 1) goto L38;
    L32:
        this.i.f(r8);
        this.g.put(r9, Boolean.valueOf(Intrinsics.areEqual((String) ((LinkedHashMap) this.e).get(r9), String.valueOf(r11.promotionId))));
        if ((!Intrinsics.areEqual((String) ((LinkedHashMap) this.f).get(r9), String.valueOf(r11.promotionId))) == false) goto L37;
        if (r2 == null) goto L36;
        r2.t(String.valueOf(r11.promotionId), null, null);
    L36:
        this.f.put(r9, String.valueOf(r11.promotionId));
        this.e.put(r9, String.valueOf(r11.promotionId));
        goto L41
    L37:
        r10.element = true;
        goto L41
    L27:
        if (r20.getType() == 2) goto L32;
    L20:
        r110 = false;
        goto L21
    L12:
        r9 = null;
        goto L13
    L8:
        r6 = null;
        goto L9
    }
}
