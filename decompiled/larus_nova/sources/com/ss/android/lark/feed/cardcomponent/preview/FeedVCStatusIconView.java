package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0015\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\"J)\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\"J\u001a\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020 2\b\b\u0002\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\"H\u0014J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000202H\u0016J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedVCStatusIconView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dotIconSize", "", "dotIconEndMargin", "lottieIconSize", "lottieIconPadding", "lottieIconEndMargin", "recordingDotTranslationY", "", "uploadIconSize", "uploadIconEndMargin", "summarizingIconSize", "summarizingIconEndMargin", "dotIconDrawable", "Landroid/graphics/drawable/ShapeDrawable;", "connectedIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "uploadingIcon", "Lcom/ss/android/lark/feed/cardcomponent/preview/FileSyncingView;", "recordingIcon", "Lcom/ss/android/lark/feed/cardcomponent/preview/RecordingDotView;", "summarizingIcon", "Lcom/ss/android/lark/feed/cardcomponent/preview/SummarizingProgressView;", "iconSet", "", "Landroid/view/View;", "setRecordingMode", "", "setRecordingPausedMode", "setUploadMode", "progress", "(Ljava/lang/Float;)V", "setConnectedMode", "setSummarizingMode", "progressSpeed", "progressStartTime", "", "startProgress", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "setViewGone", "setViewVisible", "visibleView", "breathingEnabled", "", "onDetachedFromWindow", "onVisibilityAggregated", "isVisible", "startUploadingRotation", "stopUploadingRotation", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedVCStatusIconView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileSyncingView f420895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecordingDotView f420896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SummarizingProgressView f420897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<View> f420898d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        FileSyncingView r100 = this.f420895a;
        r100.getClass();
        Log.d("FileSyncingView", "startRotateAnim");
        MinuteHardwareSyncBarDashedLoadingView r101 = r100.f420899a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f420919o == false) goto L8;
        return;
    L8:
        if (r101.getVisibility() == 0) goto L10;
        return;
    L10:
        if (r101.f420920p == true) goto L13;
        return;
    L13:
        if (r101.getLayerType() == 2) goto L15;
        r101.setLayerType(2, null);
    L15:
        r101.f420919o = true;
        r101.removeCallbacks(r101.f420921q);
        r101.post(r101.f420921q);
    }

    public final void b() {
        FileSyncingView r100 = this.f420895a;
        r100.getClass();
        Log.d("FileSyncingView", "stopRotateAnim");
        MinuteHardwareSyncBarDashedLoadingView r101 = r100.f420899a;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f420896b.b();
        b();
        this.f420897c.getClass();
    }

    public FeedVCStatusIconView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r110) {
        if (r110 == true) goto L4;
    L6:
        if (r110 == true) goto L9;
        b();
    L9:
        if (this.f420897c.getVisibility() != 0) goto L16;
        if (r110 == false) goto L15;
        SummarizingProgressView r100 = this.f420897c;
        r100.getClass();
        if (r100.isShown() == false) goto L16;
        long r101 = System.currentTimeMillis() / 1000;
        int r102 = (int) RangesKt.coerceIn(((double) r100.f420937b) + (RangesKt.coerceAtLeast(r101 - r101, 0) * ((double) 0)), 1.0d, 99.0d);
        r100.getClass();
        r100.f420936a.setProgress(r102);
        goto L16
    L15:
        this.f420897c.getClass();
    L16:
        super.onVisibilityAggregated(r110);
        return;
    L4:
        if (this.f420895a.getVisibility() != 0) goto L6;
        a();
        goto L6
    }

    public final void setUploadMode(Float r100) {
        FileSyncingView r101 = this.f420895a;
        setVisibility(0);
        r101.setVisibility(0);
        Iterator<T> r102 = this.f420898d.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        View r103 = (View) r102.next();
        if (Intrinsics.areEqual(r103, r101) == true) goto L4;
        r103.setVisibility(8);
        goto L4
    L9:
        if (Intrinsics.areEqual(r101, this.f420895a) == false) goto L11;
        a();
    L13:
        if (Intrinsics.areEqual(r101, this.f420896b) == false) goto L15;
        this.f420896b.setBreathingEnabled(false);
    L17:
        if (Intrinsics.areEqual(r101, this.f420897c) == true) goto L19;
        SummarizingProgressView r104 = this.f420897c;
        r104.getClass();
        r104.f420937b = 1;
        r104.getClass();
        r104.f420936a.setProgress(0);
    L19:
        FileSyncingView r105 = this.f420895a;
        if (r100 == null) goto L22;
        float r106 = r100.floatValue();
    L23:
        r105.setProgress(r106);
        return;
    L22:
        r106 = 0.0f;
        goto L23
    L15:
        this.f420896b.b();
        goto L17
    L11:
        b();
        goto L13
    }

    public FeedVCStatusIconView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        int r100 = UIUtils.dp2px(r110, 6.0f);
        int r101 = UIUtils.dp2px(r110, 4.0f);
        int r102 = UIUtils.dp2px(r110, 16.0f);
        int r103 = UIUtils.dp2px(r110, 3.0f);
        int r104 = UIUtils.dp2px(r110, 2.0f);
        float r105 = UIUtils.dp2px(r110, 1.0f);
        int r106 = UIUtils.dp2px(r110, 16.0f);
        int r112 = UIUtils.dp2px(r110, 6.0f);
        int r113 = UIUtils.dp2px(r110, 14.0f);
        int r107 = UIUtils.dp2px(r110, 6.0f);
        ShapeDrawable r114 = new ShapeDrawable(new OvalShape());
        r114.setIntrinsicWidth(r100);
        r114.setIntrinsicHeight(r100);
        r114.getPaint().setColor(ContextCompat.getColor(r110, R.color.colorful_green));
        r114.setBounds(0, 0, r100, r100);
        LinkedHashSet r115 = new LinkedHashSet();
        this.f420898d = r115;
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -1);
        r116.gravity = 16;
        setLayoutParams(r116);
        AppCompatImageView r117 = new AppCompatImageView(r110);
        r117.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r117.setAdjustViewBounds(true);
        r117.setImageDrawable(r114);
        r117.setVisibility(8);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(r100, r100);
        r118.gravity = 16;
        r118.setMargins(0, 0, r101, 0);
        r117.setLayoutParams(r118);
        r117.setImageTintList(null);
        addView(r117);
        FileSyncingView r119 = new FileSyncingView(r110);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r106, r106);
        r108.gravity = 16;
        r108.setMargins(0, 0, r112, 0);
        r119.setLayoutParams(r108);
        r119.setVisibility(8);
        this.f420895a = r119;
        addView(r119);
        AttributeSet r120 = null;
        RecordingDotView r109 = new RecordingDotView(r110, r120, 6, 0);
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(r102, r102);
        r121.gravity = 16;
        r121.setMargins(0, 0, r104, 0);
        r109.setLayoutParams(r121);
        r109.setPadding(r103, r103, r103, r103);
        r109.setTranslationY(r105);
        r109.setVisibility(8);
        this.f420896b = r109;
        addView(r109);
        SummarizingProgressView r122 = new SummarizingProgressView(r110, null, 6, 0);
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(r113, r113);
        r123.gravity = 16;
        r123.setMargins(0, 0, r107, 0);
        r122.setLayoutParams(r123);
        r122.setVisibility(8);
        this.f420897c = r122;
        addView(r122);
        r115.add(r117);
        r115.add(r119);
        r115.add(r109);
        r115.add(r122);
    }
}
