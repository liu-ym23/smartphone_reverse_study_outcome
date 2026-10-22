package com.ss.android.lark.biz.im.api.extension.list;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0002+,B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0014J0\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u0005H\u0014J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/list/SmoothScrollerV2;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "topOffset", "", "align", "Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollAlign;", "<init>", "(Landroid/content/Context;ILcom/ss/android/lark/biz/im/api/extension/scroll/ScrollAlign;)V", "onStopListener", "Lcom/ss/android/lark/biz/im/api/extension/list/SmoothScrollerV2$OnStopListener;", "getOnStopListener", "()Lcom/ss/android/lark/biz/im/api/extension/list/SmoothScrollerV2$OnStopListener;", "setOnStopListener", "(Lcom/ss/android/lark/biz/im/api/extension/list/SmoothScrollerV2$OnStopListener;)V", "immediately", "", "getImmediately", "()Z", "setImmediately", "(Z)V", "customSpeed", "getCustomSpeed", "()I", "setCustomSpeed", "(I)V", "snap", "onStop", "", "calculateDtToFit", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "getVerticalSnapPreference", "calculateTimeForScrolling", "dx", "OnStopListener", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmoothScrollerV2 extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScrollAlign f410166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f410167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f410168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f410169e;

    public static final class a {
    }

    public interface b {
        void onStop();
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f410170a = null;

        static {
            int[] r100 = new int[ScrollAlign.values().length];
            r100[ScrollAlign.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ScrollAlign.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f410170a = r100;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void onStop() {
        super.onStop();
        b r100 = this.f410167c;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int getVerticalSnapPreference() {
        return this.f410169e;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final float calculateSpeedPerPixel(DisplayMetrics r100) {
        int r101 = this.f410168d;
        if (r101 == (-1)) goto L9;
        if (r101 <= 0) goto L9;
        return 1.0f / r101;
    L9:
        return super.calculateSpeedPerPixel(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateTimeForScrolling(int r100) {
        return super.calculateTimeForScrolling(MathUtils.clamp(r100, 500, 1500));
    }

    public SmoothScrollerV2(Context r100, int r101, ScrollAlign r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f410165a = r101;
        this.f410166b = r102;
        int r103 = -1;
        this.f410168d = -1;
        if (r102 != null) goto L5;
        int r104 = -1;
    L7:
        if (r104 != 1) goto L9;
    L12:
        this.f410169e = r103;
        return;
    L9:
        if (r104 == 2) goto L11;
        r103 = 0;
        goto L12
    L11:
        r103 = 1;
        goto L12
    L5:
        r104 = c.f410170a[r102.ordinal()];
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        ScrollAlign r105 = this.f410166b;
        if (r105 == ScrollAlign.TOP) goto L16;
        if (r105 != ScrollAlign.CENTER) goto L10;
        if (Math.abs(r101 - r100) > Math.abs(r103 - r102)) goto L16;
    L10:
        if (this.f410166b != ScrollAlign.BOTTOM) goto L14;
        return (r103 - r101) + this.f410165a;
    L14:
        return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
    L16:
        return (r102 - r100) + this.f410165a;
    }
}
