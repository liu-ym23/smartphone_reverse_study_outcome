package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R,\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusSingerInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "visibility", "", "setSelfVisibility", "Lkotlin/Function0;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/a;", "j", "Lkotlin/jvm/functions/Function0;", "getGetCurUserChorusDataCB", "()Lkotlin/jvm/functions/Function0;", "setGetCurUserChorusDataCB", "(Lkotlin/jvm/functions/Function0;)V", "getCurUserChorusDataCB", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusSingerInfoView extends ConstraintLayout {
    public boolean a;
    public float b;
    public float c;
    public String d;
    public String e;
    public NumberScrollViewFlipper f;
    public View g;
    public TextView h;
    public ImageView i;
    public Function0<com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a> j;

    public static final class a {
    }

    static {
    }

    public RealTimeChorusSingerInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealTimeChorusSingerInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Function0<com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a> getGetCurUserChorusDataCB() {
        return this.j;
    }

    public final void S5(String r4) {
        Intrinsics.checkNotNullParameter(r4, "chorusScore");
        TextView r0 = this.h;
        if (r0 == null) goto L6;
        r0.setText(s1.C(2131922297, new Object[]{r4}));
        return;
    }

    public final void setGetCurUserChorusDataCB(Function0<com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a> r1) {
        this.j = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSelfVisibility(int r1) {
        setVisibility(r1);
    }

    public final void R5(final String r13, final String r14) {
        Intrinsics.checkNotNullParameter(r13, "chorusNum");
        Intrinsics.checkNotNullParameter(r14, "colorString");
        if (r13.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        NumberScrollViewFlipper r3 = this.f;
        if (r3 == null) goto L57;
        this.d = r13;
        this.e = r14;
    L21:
        float r5 = 0.0f;
    L22:
        this.c = r5;
        if (r5 >= this.b) goto L26;
        this.b = r5;
    L26:
        if (this.a == false) goto L28;
        return;
    L28:
        NumberScrollViewFlipper r6 = this.f;
        if (r6 == null) goto L31;
        r6.setTextColor(r14);
    L31:
        float r7 = this.b;
        float r8 = this.c;
        Intrinsics.checkNotNullParameter(r13, "chorusNum");
        if (StringsKt.contains(r13, "w", true) == true) goto L34;
        long r0 = d5.c(r13);
        if (100 > r0) goto L45;
        if (10000 < r0) goto L45;
        if ((r8 - r7) > 100.0f) goto L46;
    L47:
        boolean r1 = false;
    L48:
        if (r1 == false) goto L50;
        this.b = r8;
    L50:
        if (r1 == true) goto L52;
        r3.a(r13, false, RealTimeChorusSingerInfoView$updateChorusNumAndTextColor$1$2.INSTANCE);
        return;
    L52:
        if (this.a == true) goto L58;
        this.a = true;
        r3.a(r13, true, new RealTimeChorusSingerInfoView$updateChorusNumAndTextColor$$inlined$let$lambda$1(this, r13, r14));
        return;
    L58:
        return;
    L46:
        r1 = true;
    L45:
        if ((r8 - r7) <= 10.0f) goto L47;
    L34:
        if ((r8 - r7) <= 0.1f) goto L47;
    L12:
        if (StringsKt.contains(r13, "w", true) == false) goto L18;
        int r9 = StringsKt.indexOf$default(r13, "w", 0, false, 6, null);     // Catch: Exception -> L21
        if (r13 == null) goto L17;
        String r10 = r13.substring(0, r9);     // Catch: Exception -> L21
    L19:
        r5 = CastFloatProtector.parseFloat(r10);     // Catch: Exception -> L21
        goto L22
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L21
    L18:
        r10 = r13;
        goto L19
    L57:
        return;
    L5:
        r2 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealTimeChorusSingerInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = BDLocationException.ERROR_TIMEOUT;
        this.e = "#ffffff";
        LayoutInflater.from(r2).inflate(2131567253, this);
        this.f = (NumberScrollViewFlipper) findViewById(2131365697);
        TextView r5 = (TextView) findViewById(2131365696);
        this.g = findViewById(2131369232);
        this.h = (TextView) findViewById(2131365705);
        this.i = (ImageView) findViewById(2131365682);
        setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new RealTimeChorusSingerInfoView$initView$1(this)));
        R5(BDLocationException.ERROR_TIMEOUT, "#00FFE0");
        S5(BDLocationException.ERROR_TIMEOUT);
    }

    public /* synthetic */ RealTimeChorusSingerInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
