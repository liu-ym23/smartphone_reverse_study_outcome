package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/widget/newauction/AuctionStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lq83/a;", "", "getCountDownText", "", "getCountDownSeconds", "Landroid/graphics/drawable/GradientDrawable;", "c", "Lkotlin/Lazy;", "getCallRoundBg", "()Landroid/graphics/drawable/GradientDrawable;", "callRoundBg", "d", "getNormalRoundBg", "normalRoundBg", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionStatusView extends ConstraintLayout implements q83.a {
    public final ECDraweeView a;
    public final TextView b;
    public final Lazy c;
    public final Lazy d;
    public long e;
    public Function0<Unit> f;
    public ECAuctionInfo g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.AuctionStatusView$getCountDownText$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"format", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, String> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final String invoke(long r2) {
            return StringsKt.padStart(String.valueOf(r2), 2, '0');
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3) {
            return invoke(((Number) r3).longValue());
        }
    }

    static {
    }

    public AuctionStatusView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AuctionStatusView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final GradientDrawable getCallRoundBg() {
        return (GradientDrawable) this.c.getValue();
    }

    private final GradientDrawable getNormalRoundBg() {
        return (GradientDrawable) this.d.getValue();
    }

    private final long getCountDownSeconds() {
        return (this.e - SystemClock.elapsedRealtime()) / 1000;
    }

    private final String getCountDownText() {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        long r1 = this.e - SystemClock.elapsedRealtime();     // Catch: Exception -> L8
        if (r1 < 1000) goto L13;
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L8
        AnonymousClass1 r6 = AnonymousClass1.INSTANCE;     // Catch: Exception -> L8
        long r9 = 60;
        r5.append(r6.invoke((r1 / 1000) / r9));     // Catch: Exception -> L8
        r5.append(':');     // Catch: Exception -> L8
        r5.append(r6.invoke((r1 / 1000) % r9));     // Catch: Exception -> L8
        return r5.toString();
    L13:
        return null;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ECAuctionInfo r9) {
        ECDraweeView r0 = this.a;
        ECUrlModel r1 = r9.getStatusIcon();
        int r2 = r.h;
        h0.d(r0, r1, r.a.b("auction_card_status_icon"), null, null, null, null, 120);
        setBackgroundColor(0);
        if (r9.getStatus() != 2) goto L24;
        String r3 = getCountDownText();
        if (r3 != null) goto L7;
    L22:
        this.b.setVisibility(8);
        Unit r10 = Unit.INSTANCE;
        return;
    L7:
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L22;
        this.b.setVisibility(0);
        this.b.setText(r3);
        if (r9.getStatus() == 2) goto L17;
        setBackgroundColor(0);
        return;
    L17:
        if (((this.e - SystemClock.elapsedRealtime()) / 1000) > 10) goto L19;
        GradientDrawable r11 = getCallRoundBg();
    L20:
        setBackground(r11);
        return;
    L19:
        r11 = getNormalRoundBg();
        goto L20
    L9:
        r4 = false;
        goto L10
    }

    public final boolean S5(Long r7) {
        if (r7 == null) goto L4;
        long r0 = r7.longValue();
    L5:
        ECAuctionInfo r8 = this.g;
        if (r8 == null) goto L13;
        int r2 = wl.a.b;
        this.e = wl.a.a(r8.getEndTime());
        if (r8.getStatus() == 2) goto L10;
        return false;
    L10:
        if ((this.e - r0) < 1000) goto L16;
        return true;
    L16:
        return false;
    L13:
        return false;
    L4:
        r0 = SystemClock.elapsedRealtime();
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTick(long r8) {
        if (S5(Long.valueOf(r8)) == false) goto L17;
        ECAuctionInfo r9 = this.g;
        if (r9 == null) goto L17;
        R5(r9);
        if (getCountDownSeconds() != 10) goto L25;
        HashMap r10 = j.a;
        JSONObject r11 = j.d("ecom_auction_toast_timestamp");
        if (r11 == null) goto L11;
        long r1 = r11.optLong(LocationMonitorConst.TIMESTAMP);
    L13:
        if ((System.currentTimeMillis() - r1) <= SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS) goto L26;
        ECToast.showToast$default(ECToast.INSTANCE, getContext(), th.a.g(getContext(), 2131913892), null, 4, null);
        JSONObject r12 = new JSONObject();
        r12.put(LocationMonitorConst.TIMESTAMP, System.currentTimeMillis());
        Unit r0 = Unit.INSTANCE;
        j.h("ecom_auction_toast_timestamp", r12);
        return true;
    L26:
        return true;
    L11:
        r1 = 0;
        goto L13
    L25:
        return true;
    L17:
        ECAuctionInfo r13 = this.g;
        if (r13 == null) goto L20;
        R5(r13);
    L20:
        Function0<Unit> r14 = this.f;
        if (r14 == null) goto L27;
        Unit r15 = (Unit) r14.invoke();
        return false;
    L27:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuctionStatusView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(AuctionStatusView$callRoundBg$2.INSTANCE);
        this.d = LazyKt.lazy(AuctionStatusView$normalRoundBg$2.INSTANCE);
        LayoutInflater.from(r2).inflate(2131560383, this, true);
        this.a = findViewById(2131376636);
        this.b = (TextView) findViewById(2131391509);
    }

    public /* synthetic */ AuctionStatusView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
