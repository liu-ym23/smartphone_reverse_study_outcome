package com.larus.bmhome.chat.layout.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewGroupKt;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.chat.common.databinding.LarusWidgetLoadingBinding;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000eJ\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 J\u0006\u0010*\u001a\u00020 J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u000bJ\u0010\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u00020 H\u0002J\u0018\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u000eH\u0002J\b\u00106\u001a\u00020 H\u0014J\b\u00107\u001a\u00020 H\u0014J\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/MessageLoading;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/layout/widget/LoadingAnimationLifecycleAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "minAlpha", "", "maxAlpha", "animatorHasStart", "", "value", "curDuration", "getCurDuration", "()F", "setCurDuration", "(F)V", "animator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "binding", "Lcom/larus/chat/common/databinding/LarusWidgetLoadingBinding;", "registered", "isAppForeground", "init", "", "setProgressVisible", "visible", "setDotSize", "scale", "scaleDot", "view", "Landroid/view/View;", "setFailStatus", "startLoading", "cancelLoading", "onAppForeground", "onAppBackground", "setColor", "argb", "setLoadingText", "content", "", "setupUIToDuration", "setupChildUIToDuration", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "duration", "onDetachedFromWindow", "onAttachedToWindow", "setProgress", "progress", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageLoading extends LinearLayout implements q0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f304827i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f304828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f304829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f304830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f304831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObjectAnimator f304832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusWidgetLoadingBinding f304833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f304834g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f304835h;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f304836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MessageLoading f304837b;

        public a(View r100, MessageLoading r101) {
            this.f304836a = r100;
            this.f304837b = r101;
        }

        public final void a() {
            if (this.f304837b.f304834g == true) goto L5;
            CopyOnWriteArrayList<WeakReference<q0>> r100 = s0.f305249a;
            s0.a(this.f304837b);
            this.f304837b.f304835h = !AppHost.f326268a.a().isAppBackground();
            this.f304837b.f304834g = true;
        L5:
            MessageLoading r101 = this.f304837b;
            if (r101.f304835h == false) goto L9;
            r101.f304832e.start();
            this.f304837b.f304830c = true;
            return;
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

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppBackground() {
        this.f304835h = false;
        this.f304832e.cancel();
        this.f304830c = false;
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppForeground() {
        this.f304835h = true;
        c();
    }

    public final void c() {
        OneShotPreDrawListener.add(this, new a(this, this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f304830c == false) goto L6;
        c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f304832e.cancel();
    }

    public final float getCurDuration() {
        return this.f304831d;
    }

    public MessageLoading(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f304828a = 0.1f;
        this.f304829b = 1.0f;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r101.setRepeatCount(-1);
        r101.setDuration(800);
        this.f304832e = r101;
        this.f304835h = true;
        a(r100, null);
    }

    public final void setColor(int r100) {
        Iterator r101 = SequencesKt.filter(ViewGroupKt.getChildren(this), new x0()).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Drawable r102 = ((View) r101.next()).getBackground();
        if ((r102 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r103 = (GradientDrawable) r102;
    L9:
        if (r103 == null) goto L4;
        r103.setColor(r100);
        goto L4
    L8:
        r103 = null;
        goto L9
    }

    public final void setCurDuration(float r110) {
        this.f304831d = r110;
        IntProgression r100 = RangesKt.reversed(RangesKt.until(0, getChildCount()));
        int r101 = r100.getFirst();
        int r102 = r100.getLast();
        int r103 = r100.getStep();
        if (r103 <= 0) goto L5;
        if (r101 > r102) goto L5;
    L7:
        View r104 = getChildAt(r101);
        if (r104.getId() == R.id.tv_loading_text) goto L34;
        Intrinsics.checkNotNull(r104);
        if (r110 >= 0.0f) goto L14;
        float r105 = 0.0f;
    L17:
        boolean r106 = true;
        if (0.0f <= r105) goto L20;
    L22:
        boolean r107 = false;
    L23:
        if (r107 == false) goto L26;
        float r108 = this.f304829b;
        r104.setAlpha(r108 - (((r108 - this.f304828a) * r105) / 0.5f));
    L33:
        r110 = r110 + 0.167f;
        goto L34
    L26:
        if (0.5f <= r105) goto L28;
    L30:
        r106 = false;
    L31:
        if (r106 == false) goto L33;
        float r109 = this.f304828a;
        r104.setAlpha(r109 + (((this.f304829b - r109) * (r105 - 0.5f)) / 0.5f));
        goto L33
    L28:
        if (r105 > 1.0f) goto L30;
    L20:
        if (r105 > 0.5f) goto L22;
        r107 = true;
        goto L23
    L14:
        if (r110 <= 1.0f) goto L16;
        r105 = r110 - 1.0f;
        goto L17
    L16:
        r105 = r110;
    L34:
        if (r101 == r102) goto L40;
        r101 = r101 + r103;
        goto L7
    L40:
        return;
    L5:
        if (r103 >= 0) goto L36;
        if (r102 <= r101) goto L7;
        return;
    }

    public final void setDotSize(float r100) {
        LarusWidgetLoadingBinding r101 = this.f304833f;
        if (r101 == null) goto L6;
        b(r101.f324093d, r100);
        b(r101.f324094e, r100);
        b(r101.f324095f, r100);
        return;
    }

    public final void setLoadingText(String r100) {
        LarusWidgetLoadingBinding r101 = this.f304833f;
        if (r101 == null) goto L20;
        TextView r102 = r101.f324092c;
        if (r102 == null) goto L21;
        if (r100 == null) goto L8;
        String r103 = r100;
    L9:
        r102.setText(r103);
        if (r100 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        com.larus.utils.e1.o(r102);
        return;
    L18:
        com.larus.utils.e1.x(r102);
        return;
    L12:
        if (r100.length() == 0) goto L15;
        r104 = false;
        goto L16
    L8:
        r103 = "";
        goto L9
    L21:
        return;
    }

    public final void setProgress(int r100) {
        LarusWidgetLoadingBinding r101 = this.f304833f;
        if (r101 == null) goto L8;
        TextView r102 = r101.f324091b;
        if (r102 == null) goto L9;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append('%');
        r102.setText(r103.toString());
        return;
    L9:
        return;
    }

    public final void setProgressVisible(boolean r100) {
        LarusWidgetLoadingBinding r101 = this.f304833f;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        com.larus.utils.e1.x(r101.f324091b);
        com.larus.utils.e1.o(r101.f324093d);
        com.larus.utils.e1.o(r101.f324094e);
        com.larus.utils.e1.o(r101.f324095f);
        return;
    L6:
        com.larus.utils.e1.o(r101.f324091b);
        com.larus.utils.e1.x(r101.f324093d);
        com.larus.utils.e1.x(r101.f324094e);
        com.larus.utils.e1.x(r101.f324095f);
        return;
    }

    public MessageLoading(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f304828a = 0.1f;
        this.f304829b = 1.0f;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r102.setRepeatCount(-1);
        r102.setDuration(800);
        this.f304832e = r102;
        this.f304835h = true;
        a(r100, r101);
    }

    public static void b(View r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L7;
        r102.width = (int) (i5.r0() * r101);
        r102.height = (int) (i5.r0() * r101);
        r100.setLayoutParams(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void a(Context r110, AttributeSet r111) {
        setGravity(17);
        LayoutInflater.from(r110).inflate(R.layout.larus_widget_loading, this);
        int r100 = R.id.progress_text_view;
        TextView r101 = (TextView) ViewBindings.findChildViewById(this, R.id.progress_text_view);
        if (r101 == null) goto L15;
        r100 = R.id.tv_loading_text;
        TextView r102 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_loading_text);
        if (r102 == null) goto L15;
        r100 = R.id.v_dot1;
        View r103 = ViewBindings.findChildViewById(this, R.id.v_dot1);
        if (r103 == null) goto L15;
        r100 = R.id.v_dot2;
        View r104 = ViewBindings.findChildViewById(this, R.id.v_dot2);
        if (r104 == null) goto L15;
        r100 = R.id.v_dot3;
        View r105 = ViewBindings.findChildViewById(this, R.id.v_dot3);
        if (r105 == null) goto L15;
        this.f304833f = new LarusWidgetLoadingBinding(this, r101, r102, r103, r104, r105);
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.color});
        setColor(r112.getColor(0, ContextCompat.getColor(r110, R.color.larus_static_white)));
        r112.recycle();
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r100)));
    }

    public MessageLoading(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304828a = 0.1f;
        this.f304829b = 1.0f;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r103.setRepeatCount(-1);
        r103.setDuration(800);
        this.f304832e = r103;
        this.f304835h = true;
        a(r100, r101);
    }
}
