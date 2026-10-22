package com.bytedance.locallife.live.lynx.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.locallife.common.utils.k;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/locallife/live/lynx/api/LiveLifeCountDownView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnAttachStateChangeListener;", "", "textColor", "", "setTextColor", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", CommonCmd.AIDL_PLATFORM_TYPE_TV, "", "c", "J", "getCurrent", "()J", "setCurrent", "(J)V", "current", "d", "getEnd", "setEnd", "end", "e", "getCallTime", "setCallTime", "callTime", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "runnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeCountDownView extends FrameLayout implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f260534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f260535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f260536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f260537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f260538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f260539f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeCountDownView f260540a;

        public a(LiveLifeCountDownView r100) {
            this.f260540a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f260540a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeCountDownView f260541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f260542b;

        public b(LiveLifeCountDownView r100, Ref.LongRef r101) {
            this.f260541a = r100;
            this.f260542b = r101;
        }

        public final void a() {
            TextView r100 = this.f260541a.getTv();
            LiveLifeCountDownView r101 = this.f260541a;
            long r102 = this.f260542b.element;
            boolean r103 = !r101.f260535b;
            StringBuilder r104 = new StringBuilder();
            long r105 = BaseConstants.Time.HOUR;
            long r106 = r102 / r105;
            long r110 = 60000;
            long r111 = (r102 / r110) % ((long) 60);
            long r107 = ((r102 % r105) % r110) / ((long) 1000);
            if (r106 > 0) goto L5;
            if (r103 == false) goto L11;
            r104.append("00:");
        L11:
            long r108 = 10;
            if (r111 < r108) goto L15;
            r104.append(r111);
        L18:
            r104.append(":");
            if (r107 < r108) goto L22;
            r104.append(r107);
        L25:
            r100.setText(r104.toString());
            return;
        L22:
            if (r107 <= 0) goto L24;
            r104.append(0);
            r104.append(r107);
            goto L25
        L24:
            r104.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
            goto L25
        L15:
            if (r111 <= 0) goto L17;
            r104.append(0);
            r104.append(r111);
            goto L18
        L17:
            r104.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
            goto L18
        L5:
            if (r106 < 10) goto L7;
            r104.append(r106);
        L8:
            r104.append(":");
            goto L11
        L7:
            r104.append(0);
            r104.append(r106);
            goto L8
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

    public LiveLifeCountDownView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveLifeCountDownView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        Ref.LongRef r100 = new Ref.LongRef();
        long r101 = this.f260537d - ((System.currentTimeMillis() - this.f260538e) + this.f260536c);
        r100.element = r101;
        if (r101 >= 0) goto L5;
        r100.element = 0;
    L5:
        k.d(new b(this, r100));
        if (r100.element <= 0) goto L9;
        k.a(this.f260539f);
        k.c(this.f260539f, 1000);
        return;
    }

    public final long getCallTime() {
        return this.f260538e;
    }

    public final long getCurrent() {
        return this.f260536c;
    }

    public final long getEnd() {
        return this.f260537d;
    }

    public final Runnable getRunnable() {
        return this.f260539f;
    }

    public final TextView getTv() {
        return this.f260534a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        k.a(this.f260539f);
    }

    public final void setCallTime(long r100) {
        this.f260538e = r100;
    }

    public final void setCurrent(long r100) {
        this.f260536c = r100;
    }

    public final void setEnd(long r100) {
        this.f260537d = r100;
    }

    public final void setTextColor(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f260534a.setTextColor(ColorProtector.parseColor(r100));
    }

    public LiveLifeCountDownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = new TextView(r100);
        this.f260534a = r103;
        this.f260539f = new a(this);
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

    public /* synthetic */ LiveLifeCountDownView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
