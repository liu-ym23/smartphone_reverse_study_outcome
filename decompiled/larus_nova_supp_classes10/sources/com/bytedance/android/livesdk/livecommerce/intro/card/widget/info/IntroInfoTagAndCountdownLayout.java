package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.k;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoTagAndCountdownLayout;", "Landroid/widget/LinearLayout;", "", "Lq83/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class IntroInfoTagAndCountdownLayout extends LinearLayout implements q83.a {
    public static final /* synthetic */ int j = 0;
    public oh2.c a;
    public final ECDraweeView b;
    public final TextView c;
    public r d;
    public boolean e;
    public long f;
    public final Paint g;
    public final RectF h;
    public Function0<Unit> i;

    public static final class a {
    }

    static {
    }

    public IntroInfoTagAndCountdownLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(r r13) {
        r r0 = this.d;
        if (r0 == null) goto L34;
        k r1 = r0.c();
        if (r1 == null) goto L34;
        oh2.c r2 = this.a;
        if (r2 == null) goto L34;
        Long r3 = r2.b(r1.c(), r1.a());
        if (r3 == null) goto L34;
        long r4 = r3.longValue() - SystemClock.elapsedRealtime();
        long r5 = 1000;
        if (r4 < r5) goto L34;
        r r6 = this.d;
        if (r6 == null) goto L34;
        k r7 = r6.c();
        if (r7 == null) goto L34;
        StringBuilder r8 = new StringBuilder();
        String r9 = r7.b();
        String r10 = "";
        if (r9 != null) goto L21;
        r9 = "";
    L21:
        r8.append(r9);
        long r11 = r4 / r5;
        long r12 = 60;
        long r14 = r11 % r12;
        long r15 = r11 / r12;
        StringBuilder r16 = new StringBuilder();
        long r17 = 10;
        if (r15 >= r17) goto L24;
        String r18 = BDLocationException.ERROR_TIMEOUT + r15;
    L25:
        r16.append(r18);
        r16.append(':');
        if (r14 >= r17) goto L28;
        String r19 = BDLocationException.ERROR_TIMEOUT + r14;
    L29:
        r16.append(r19);
        r8.append(r16.toString());
        String r20 = r7.d();
        if (r20 == null) goto L33;
        r10 = r20;
    L33:
        r8.append(r10);
        String r21 = r8.toString();
    L36:
        if (r21 != null) goto L38;
    L41:
        boolean r22 = true;
    L43:
        if (r22 == true) goto L51;
        this.c.setVisibility(0);
        this.c.setText(r21);
        this.b.setTopRightCornerRadius(0.0f);
        this.b.setBottomRightCornerRadius(0.0f);
        String r110 = r13.b();
        TextView r23 = this.c;
        if (this.e == true) goto L49;
        if (r110 == null) goto L49;
        int r111 = s.a(r110, -52412);
    L50:
        r23.setTextColor(r111);
        return;
    L49:
        r111 = -1;
        goto L50
    L51:
        this.c.setVisibility(8);
        setPadding(0, 0, 0, 0);
        ViewExtensionsKt.g(this.b, 0.0f, UtilityKotlinExtentionsKt.c(3), 0.0f, UtilityKotlinExtentionsKt.c(3));
        ViewGroup.LayoutParams r112 = this.b.getLayoutParams();
        if (r112 == null) goto L56;
        ((LinearLayout.LayoutParams) r112).setMargins(0, 0, 0, 0);
        return;
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L38:
        if (r21.length() == 0) goto L41;
        r22 = false;
        goto L43
    L28:
        r19 = String.valueOf(r14);
        goto L29
    L24:
        r18 = String.valueOf(r15);
    L34:
        r21 = null;
        goto L36
    }

    public final boolean b(Long r8) {
        if (r8 == null) goto L4;
        long r0 = r8.longValue();
    L5:
        r r9 = this.d;
        if (r9 != null) goto L8;
        return false;
    L8:
        if (r9.c() == null) goto L26;
        r r10 = this.d;
        if (r10 == null) goto L19;
        k r11 = r10.c();
        if (r11 == null) goto L19;
        oh2.c r2 = this.a;
        if (r2 == null) goto L16;
        Long r12 = r2.b(r11.c(), r11.a());
    L17:
        if (r12 == null) goto L19;
        long r3 = r12.longValue();
    L21:
        if ((r3 - r0) < 1000) goto L27;
        return true;
    L27:
        return false;
    L16:
        r12 = null;
    L19:
        r3 = 0;
        goto L21
    L26:
        return false;
    L4:
        r0 = SystemClock.elapsedRealtime();
        goto L5
    }

    public final void c(String r4) {
        this.c.setTextColor(s.a(r4, s.a("#CCFFFFFF", -1)));
        int r5 = c0.a;
        c0.b(this.c, MonitorLevel.FATAL);
        d2.e(this, 0);
        this.c.setTypeface(Typeface.defaultFromStyle(0));
        setPadding(0, 0, UtilityKotlinExtentionsKt.d(4), 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        if (this.c.getVisibility() != 0) goto L13;
        Paint r0 = this.g;
        if (this.b.getVisibility() != 8) goto L8;
        int r1 = 855638016;
    L11:
        r0.setColor(r1);
        float r2 = UIUtils.dip2Px(getContext(), 4.0f);
        this.h.set(0.0f, 0.0f, getWidth(), getHeight());
        r6.drawRoundRect(this.h, r2, r2, this.g);
        return;
    L8:
        if (this.e == false) goto L10;
        r1 = 1459617792;
        goto L11
    L10:
        r1 = 135665699;
        goto L11
    }

    public final boolean onTick(long r11) {
        if (b(Long.valueOf(r11)) == false) goto L29;
        r r12 = this.d;
        if (r12 == null) goto L37;
        a(r12);
        r r13 = this.d;
        long r0 = 0;
        if (r13 == null) goto L16;
        k r14 = r13.c();
        if (r14 == null) goto L16;
        oh2.c r15 = this.a;
        if (r15 == null) goto L13;
        Long r16 = r15.b(r14.c(), r14.a());
    L14:
        if (r16 == null) goto L16;
        long r17 = r16.longValue();
    L18:
        if (((r17 - SystemClock.elapsedRealtime()) / ((long) 1000)) == 10) goto L20;
        return true;
    L20:
        if (this.f == 3) goto L39;
        HashMap r18 = j.a;
        JSONObject r19 = j.d("ecom_auction_toast_timestamp");
        if (r19 == null) goto L25;
        r0 = r19.optLong(LocationMonitorConst.TIMESTAMP);
    L25:
        if ((System.currentTimeMillis() - r0) <= 2000) goto L40;
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), th.a.g(getContext(), 2131913892), 0, null, 8, null);
        JSONObject r110 = new JSONObject();
        r110.put(LocationMonitorConst.TIMESTAMP, System.currentTimeMillis());
        Unit r1 = Unit.INSTANCE;
        j.h("ecom_auction_toast_timestamp", r110);
        return true;
    L40:
        return true;
    L39:
        return true;
    L13:
        r16 = null;
    L16:
        r17 = 0;
        goto L18
    L37:
        return true;
    L29:
        r r111 = this.d;
        if (r111 == null) goto L32;
        a(r111);
    L32:
        Function0<Unit> r112 = this.i;
        if (r112 == null) goto L41;
        Unit r113 = (Unit) r112.invoke();
        return false;
    L41:
        return false;
    }

    public IntroInfoTagAndCountdownLayout(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.g = new Paint(1);
        this.h = new RectF();
        setOrientation(0);
        setWillNotDraw(false);
        ECDraweeView r6 = new ECDraweeView(r8, null, 0, 6, null);
        this.b = r6;
        r6.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r6.setAdjustMode(1);
        r6.setVisibility(8);
        Unit r3 = Unit.INSTANCE;
        addView(r6);
        TextView r4 = new TextView(r8);
        this.c = r4;
        r4.setIncludeFontPadding(false);
        r4.setVisibility(8);
        r4.setGravity(16);
        r4.setTextColor(-1);
        r4.setTextSize(1, 10.0f);
        c0.b(r4, MonitorLevel.FATAL);
        r4.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(r4);
    }

    public /* synthetic */ IntroInfoTagAndCountdownLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
