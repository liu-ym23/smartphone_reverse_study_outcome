package com.bytedance.locallife.live.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.locallife.live.experiment.f0;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010'\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010 R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/bytedance/locallife/live/view/LiveLifeCountDownView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/bytedance/locallife/live/util/c$a;", "", "isFitFormatLength", "", "adjustLayoutParams", "", "current", "end", "startCountDown", "", "textColor", "fontSize", "setTextStyle", "setTv", "onTick", "Landroid/view/View;", "p0", "onViewAttachedToWindow", "onViewDetachedFromWindow", "milliseconds", "milliSecondsToForceShowHourTime", "isFillHour", "milliSecondsToTime", "Landroid/widget/TextView;", CommonCmd.AIDL_PLATFORM_TYPE_TV, "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "Z", "J", "getCurrent", "()J", "setCurrent", "(J)V", "getEnd", "setEnd", "callTime", "getCallTime", "setCallTime", "onDetachTime", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public class LiveLifeCountDownView extends FrameLayout implements View.OnAttachStateChangeListener, com.bytedance.locallife.live.util.c.a {
    private long callTime;
    private long current;
    private long end;
    private boolean isFitFormatLength;
    private long onDetachTime;
    private final Runnable runnable;

    /* JADX INFO: renamed from: tv, reason: collision with root package name */
    private final TextView f260777tv;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeCountDownView f260778a;

        public a(LiveLifeCountDownView r100) {
            this.f260778a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f260778a.isAttachedToWindow() == false) goto L10;
            this.f260778a.setTv();     // Catch: Throwable -> L7
            return;
        }
    }

    public LiveLifeCountDownView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public LiveLifeCountDownView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public void setTv() {
    }

    @Override // com.bytedance.locallife.live.util.c.a
    public void onTick() {
        if (isAttachedToWindow() == false) goto L5;
    L8:
        setTv();
        return;
    L5:
        if (f0.a() == false) goto L8;
        com.bytedance.locallife.live.util.c.a(this);
    }

    public final long getCallTime() {
        return this.callTime;
    }

    public final long getCurrent() {
        return this.current;
    }

    public final long getEnd() {
        return this.end;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public final TextView getTv() {
        return this.f260777tv;
    }

    private final void adjustLayoutParams(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r101 = this.f260777tv.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == false) goto L7;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
    L8:
        if (r102 == null) goto L10;
        r102.gravity = 16;
    L10:
        this.f260777tv.setLayoutParams(r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final String milliSecondsToForceShowHourTime(long r100) {
        return milliSecondsToTime(r100, !this.isFitFormatLength);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        setTv();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        com.bytedance.locallife.common.utils.k.a(this.runnable);
        if (f0.a() == false) goto L6;
        com.bytedance.locallife.live.util.c.a(this);
        return;
    }

    public final void setCallTime(long r100) {
        this.callTime = r100;
    }

    public final void setCurrent(long r100) {
        this.current = r100;
    }

    public final void setEnd(long r100) {
        this.end = r100;
    }

    public final String milliSecondsToTime(long r110, boolean r111) {
        StringBuilder r100 = new StringBuilder();
        long r101 = BaseConstants.Time.HOUR;
        long r102 = r110 / r101;
        long r103 = 60000;
        long r104 = (r110 / r103) % ((long) 60);
        long r105 = ((r110 % r101) % r103) / ((long) 1000);
        if (r102 > 0) goto L5;
        if (r111 == false) goto L11;
        r100.append("00:");
    L11:
        long r106 = 10;
        if (r104 < r106) goto L15;
        r100.append(r104);
    L18:
        r100.append(":");
        if (r105 < r106) goto L22;
        r100.append(r105);
    L26:
        return r100.toString();
    L22:
        if (r105 <= 0) goto L24;
        r100.append(0);
        r100.append(r105);
        goto L26
    L24:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L26
    L15:
        if (r104 <= 0) goto L17;
        r100.append(0);
        r100.append(r104);
        goto L18
    L17:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L18
    L5:
        if (r102 < 10) goto L7;
        r100.append(r102);
    L8:
        r100.append(":");
        goto L11
    L7:
        r100.append(0);
        r100.append(r102);
        goto L8
    }

    public final void setTextStyle(String r100, String r101) {
        if (r2.a(r100) == false) goto L8;
        this.f260777tv.setTextColor(Color.parseColor(r100));     // Catch: Exception -> L6
    L8:
        if (r2.a(r101) == false) goto L23;
        TextView r102 = this.f260777tv;
        float r103 = 10.0f;
        if (r101 == null) goto L19;
        Float r104 = Float.valueOf(10.0f);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter("", "businessTag");
        Float r105 = StringsKt.toFloatOrNull(r101);
        if (r105 != null) goto L14;
        int r106 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("local_live_number_convert_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "safeToFloat"), TuplesKt.to("tag", "")}));
    L14:
        if (r105 == null) goto L17;
        r104 = r105;
    L17:
        if (r104 == null) goto L19;
        r103 = r104.floatValue();
    L19:
        r102.setTextSize(1, r103);
        return;
    }

    public LiveLifeCountDownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = new TextView(r100);
        this.f260777tv = r103;
        this.runnable = new a(this);
        r103.setTextColor(ColorProtector.parseColor("#57161823"));
        r103.setTextSize(1, 10.0f);
        r103.setGravity(17);
        addView(r103, -2, -1);
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
    L6:
        if (r105 == null) goto L8;
        r105.gravity = 8388629;
    L8:
        r103.setLayoutParams(r105);
        addOnAttachStateChangeListener(this);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void startCountDown(long r100, long r101, boolean r102) {
        this.current = r100;
        this.end = r101;
        this.isFitFormatLength = r102;
        this.callTime = System.currentTimeMillis();
        adjustLayoutParams(r102);
        if (f0.a() == false) goto L7;
        boolean r103 = com.bytedance.locallife.live.util.c.f260690a;
        Intrinsics.checkNotNullParameter(this, "onTickListener");
        com.bytedance.locallife.live.util.c.f260692c.add(this);
        if (com.bytedance.locallife.live.util.c.f260690a == true) goto L7;
        com.bytedance.locallife.live.util.c.f260690a = true;
        com.bytedance.locallife.live.util.c.f260691b.start();
    L7:
        setTv();
    }

    public /* synthetic */ LiveLifeCountDownView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void setTextStyle$default(LiveLifeCountDownView r100, String r101, String r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.setTextStyle(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTextStyle");
    }
}
