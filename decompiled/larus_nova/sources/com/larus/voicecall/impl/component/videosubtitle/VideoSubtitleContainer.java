package com.larus.voicecall.impl.component.videosubtitle;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/voicecall/impl/component/videosubtitle/VideoSubtitleContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", "onFinishInflate", "", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSubtitleContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f377763a;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = getChildAt(0);
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r101 = (TextView) r100;
    L6:
        this.f377763a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public VideoSubtitleContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public VideoSubtitleContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r101), 0));
        TextView r102 = this.f377763a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getLayout().getLineCount() <= 2) goto L18;
        int r103 = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 34) goto L9;
        int r104 = (r102.getLayout().getLineBottom(1, false) - r102.getLayout().getLineTop(0)) + getPaddingBottom();
        int r105 = getPaddingTop();
    L10:
        int r106 = r104 + r105;
        AppHost.Companion r107 = AppHost.f326268a;
        if (r107.isTestChannel() == false) goto L13;
    L14:
        int r108 = c68.b.f22600a;
        c68.b.d("VideoSubtitleContainer", "onMeasure: targetWidth = " + r103 + ", targetHeight = " + r106);
    L15:
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        return;
    L13:
        if (r107.isDebugChannel() == false) goto L15;
    L9:
        r104 = ((r102.getLayout().getLineBottom(1) - ((int) r102.getLayout().getSpacingAdd())) - r102.getLayout().getLineTop(0)) + getPaddingBottom();
        r105 = getPaddingTop();
        goto L10
    }
}
