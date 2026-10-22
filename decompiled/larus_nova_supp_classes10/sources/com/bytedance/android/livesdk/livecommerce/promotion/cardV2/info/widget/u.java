package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.model.response.a0;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u extends LinearLayout implements q83.a {
    public static final /* synthetic */ int k = 0;
    public final ECDraweeView a;
    public final TextView b;
    public a0 c;
    public boolean d;
    public boolean e;
    public long f;
    public final Paint g;
    public final RectF h;
    public Function0<Unit> i;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a j;

    public static final class a {
    }

    static {
    }

    private final long getCountDownSeconds() {
        a0 r0 = this.c;
        if (r0 == null) goto L16;
        com.bytedance.android.ec.model.response.k r1 = r0.b();
        if (r1 == null) goto L16;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2 = this.j;
        if (r2 == null) goto L13;
        long r3 = r1.c();
        long r4 = r1.a();
        boolean r6 = this.e;
        if (this.f != 3) goto L11;
        boolean r7 = true;
    L12:
        Long r5 = r2.d(r3, r4, r6, r7);
    L14:
        if (r5 == null) goto L16;
        long r8 = r5.longValue();
    L18:
        return (r8 - getCurrentMillis()) / ((long) 1000);
    L11:
        r7 = false;
        goto L12
    L13:
        r5 = null;
    L16:
        r8 = 0;
        goto L18
    }

    private final String getCountDownText() {
        a0 r0 = this.c;
        if (r0 == null) goto L39;
        com.bytedance.android.ec.model.response.k r1 = r0.b();
        if (r1 == null) goto L39;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2 = this.j;
        if (r2 == null) goto L39;
        long r3 = r1.c();
        long r5 = r1.a();
        boolean r7 = this.e;
        if (this.f != 3) goto L12;
        boolean r8 = true;
    L13:
        Long r4 = r2.d(r3, r5, r7, r8);
        if (r4 == null) goto L39;
        long r6 = r4.longValue() - getCurrentMillis();
        long r9 = 1000;
        if (r6 >= r9) goto L18;
        return null;
    L18:
        a0 r10 = this.c;
        if (r10 == null) goto L39;
        com.bytedance.android.ec.model.response.k r11 = r10.b();
        if (r11 == null) goto L39;
        StringBuilder r12 = new StringBuilder();
        String r13 = r11.b();
        String r14 = "";
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        r12.append(r13);
        long r15 = r6 / r9;
        long r16 = 60;
        long r17 = r15 % r16;
        long r18 = r15 / r16;
        StringBuilder r19 = new StringBuilder();
        long r20 = 10;
        if (r18 >= r20) goto L28;
        String r21 = BDLocationException.ERROR_TIMEOUT + r18;
    L29:
        r19.append(r21);
        r19.append(':');
        if (r17 >= r20) goto L32;
        String r22 = BDLocationException.ERROR_TIMEOUT + r17;
    L33:
        r19.append(r22);
        r12.append(r19.toString());
        String r23 = r11.d();
        if (r23 == null) goto L37;
        r14 = r23;
    L37:
        r12.append(r14);
        return r12.toString();
    L32:
        r22 = String.valueOf(r17);
        goto L33
    L28:
        r21 = String.valueOf(r18);
        goto L29
    L12:
        r8 = false;
    L39:
        return null;
    }

    public final boolean b() {
        if (this.c != null) goto L5;
        return false;
    L5:
        if (getCountDownSeconds() <= 10) goto L7;
        return false;
    L7:
        return true;
    }

    private final long getCurrentMillis() {
        return SystemClock.elapsedRealtime();
    }

    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a getAbility() {
        return this.j;
    }

    public final void a(a0 r4) {
        String r0 = getCountDownText();
        if (r0 == null) goto L14;
        this.b.setVisibility(0);
        this.b.setText(r0);
        String r5 = r4.a();
        TextView r1 = this.b;
        if (this.d == true) goto L12;
        if (r5 == null) goto L12;
        if (b() == false) goto L11;
        int r6 = -52412;
    L13:
        r1.setTextColor(r6);
        return;
    L11:
        r6 = ColorProtector.parseColor(r5);
    L12:
        r6 = -1;
        goto L13
    L14:
        this.b.setVisibility(8);
    }

    public final boolean c(Long r15) {
        if (r15 == null) goto L4;
        long r0 = r15.longValue();
    L5:
        a0 r16 = this.c;
        if (r16 != null) goto L8;
    L27:
        return false;
    L8:
        if (r16.b() == null) goto L27;
        a0 r17 = this.c;
        if (r17 == null) goto L23;
        com.bytedance.android.ec.model.response.k r18 = r17.b();
        if (r18 == null) goto L23;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r4 = this.j;
        if (r4 == null) goto L20;
        long r5 = r18.c();
        long r7 = r18.a();
        boolean r9 = this.e;
        if (this.f != 3) goto L18;
        boolean r10 = true;
    L19:
        Long r19 = r4.d(r5, r7, r9, r10);
    L21:
        if (r19 == null) goto L23;
        long r6 = r19.longValue();
    L25:
        if ((r6 - r0) < 1000) goto L27;
        return true;
    L18:
        r10 = false;
        goto L19
    L20:
        r19 = null;
    L23:
        r6 = 0;
        goto L25
    L4:
        r0 = getCurrentMillis();
        goto L5
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        if (this.b.getVisibility() != 0) goto L19;
        Paint r0 = this.g;
        if (this.a.getVisibility() != 8) goto L8;
        int r1 = 855638016;
    L17:
        r0.setColor(r1);
        float r2 = UIUtils.dip2Px(getContext(), 4.0f);
        this.h.set(0.0f, 0.0f, getWidth(), getHeight());
        r6.drawRoundRect(this.h, r2, r2, this.g);
        return;
    L8:
        if (this.d == false) goto L14;
        if (b() == false) goto L12;
        r1 = 1476342596;
        goto L17
    L12:
        r1 = 1459617792;
        goto L17
    L14:
        if (b() == false) goto L16;
        r1 = 234491406;
        goto L17
    L16:
        r1 = 135665699;
        goto L17
    }

    public final boolean onTick(long r7) {
        if (c(Long.valueOf(r7)) == false) goto L19;
        a0 r8 = this.c;
        if (r8 == null) goto L26;
        a(r8);
        if (getCountDownSeconds() == 10) goto L9;
        return true;
    L9:
        if (this.f == 3) goto L28;
        HashMap r9 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r0 = com.bytedance.android.ec.core.hybrid.utils.j.d("ecom_auction_toast_timestamp");
        if (r0 == null) goto L13;
        long r2 = JSONObjectProtectorUtils.getLong(r0, LocationMonitorConst.TIMESTAMP);
    L15:
        if ((System.currentTimeMillis() - r2) <= 2000) goto L29;
        Toast.makeText(getContext(), th.a.g(getContext(), 2131913892), 0).show();
        JSONObject r10 = new JSONObject();
        r10.put(LocationMonitorConst.TIMESTAMP, System.currentTimeMillis());
        Unit r1 = Unit.INSTANCE;
        com.bytedance.android.ec.core.hybrid.utils.j.h("ecom_auction_toast_timestamp", r10);
        return true;
    L29:
        return true;
    L13:
        r2 = 0;
        goto L15
    L28:
        return true;
    L26:
        return true;
    L19:
        a0 r11 = this.c;
        if (r11 == null) goto L22;
        a(r11);
    L22:
        Function0<Unit> r12 = this.i;
        if (r12 == null) goto L25;
        Unit r13 = (Unit) r12.invoke();
    L25:
        return false;
    }

    public u(Context r9, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, null);
        this.j = r10;
        this.g = new Paint(1);
        this.h = new RectF();
        setOrientation(0);
        setWillNotDraw(false);
        ECDraweeView r7 = new ECDraweeView(r9, null, 0, 6, null);
        this.a = r7;
        r7.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r7.setAdjustMode(1);
        r7.setVisibility(8);
        Unit r4 = Unit.INSTANCE;
        addView(r7);
        TextView r5 = new TextView(r9);
        this.b = r5;
        r5.setIncludeFontPadding(false);
        r5.setVisibility(8);
        r5.setGravity(16);
        int r11 = (int) UIUtils.dip2Px(r9, 4.0f);
        r5.setPadding(r11, 0, r11, 0);
        r5.setTextColor(-1);
        r5.setTextSize(1, 10.0f);
        c0.b(r5, MonitorLevel.FATAL);
        r5.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(r5);
    }
}
