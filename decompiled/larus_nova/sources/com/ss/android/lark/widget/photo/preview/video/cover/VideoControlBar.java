package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aJ\u001a\u0010\"\u001a\u00020\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cH\u0014J\u0006\u0010(\u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001cJ\u0014\u0010+\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0-J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203J\u0016\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001cJ\u0006\u00107\u001a\u00020\u001cR#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/video/cover/VideoControlBar;", "Landroidx/appcompat/widget/LinearLayoutCompat;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pauseDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getPauseDrawable", "()Landroid/graphics/drawable/Drawable;", "pauseDrawable$delegate", "Lkotlin/Lazy;", "playDrawable", "getPlayDrawable", "playDrawable$delegate", "mTogglePlayBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "mCurrentPlayTime", "Landroid/widget/TextView;", "mSeekBar", "Landroid/widget/SeekBar;", "mVideoDuration", "mPipModeProgressBar", "Landroid/widget/ProgressBar;", "mBufferPercentage", "", "mOnVisibilityChangedListener", "Lkotlin/Function1;", "", "initWithPipProgress", "pipModeProgressBar", "init", "onVisibilityChangedListener", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, BasicTestActionHandler.TEST_ACTION_RESET, "setBufferPercentage", "bufferPercentage", "setOnTogglePlay", "action", "Lkotlin/Function0;", "updateTogglePlayIcon", "showPauseIcon", "", "setOnSeekBarChangeListener", "listener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "updateProgress", "curr", "duration", "getProgress", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoControlBar extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f447166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f447167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f447168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f447169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SeekBar f447170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f447171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ProgressBar f447172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f447173h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f447174a;

        public b(Function0<Unit> r100) {
            this.f447174a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f447174a.invoke();
        }
    }

    static {
    }

    private final Drawable getPauseDrawable() {
        return (Drawable) this.f447166a.getValue();
    }

    private final Drawable getPlayDrawable() {
        return (Drawable) this.f447167b.getValue();
    }

    public final int getProgress() {
        SeekBar r100 = this.f447170e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        r100 = null;
    L6:
        return r100.getProgress();
    }

    public final void e(boolean r100) {
        AppCompatImageView r101 = this.f447168c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTogglePlayBtn");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        Drawable r102 = getPauseDrawable();
    L8:
        r101.setImageDrawable(r102);
        return;
    L7:
        r102 = getPlayDrawable();
        goto L8
    }

    public final void setBufferPercentage(int r100) {
        this.f447173h = r100;
    }

    public final void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        SeekBar r101 = this.f447170e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        r101 = null;
    L5:
        r101.setOnSeekBarChangeListener(r100);
    }

    public final void setOnTogglePlay(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        AppCompatImageView r101 = this.f447168c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTogglePlayBtn");
        r101 = null;
    L5:
        r101.setOnClickListener(new b(r100));
    }

    public VideoControlBar(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f447166a = LazyKt.lazy(new VideoControlBar$pauseDrawable$2(r100));
        this.f447167b = LazyKt.lazy(new VideoControlBar$playDrawable$2(r100));
    }

    public final void d(int r100, int r101) {
        float r102 = (this.f447173h / 100.0f) * r101;
        SeekBar r103 = this.f447170e;
        TextView r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        r103 = null;
    L5:
        r103.setMax(r101);
        SeekBar r105 = this.f447170e;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        r105 = null;
    L8:
        r105.setProgress(r100);
        SeekBar r106 = this.f447170e;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        r106 = null;
    L11:
        int r107 = (int) r102;
        r106.setSecondaryProgress(r107);
        ProgressBar r108 = this.f447172g;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPipModeProgressBar");
        r108 = null;
    L14:
        r108.setMax(r101);
        ProgressBar r109 = this.f447172g;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mPipModeProgressBar");
        r109 = null;
    L17:
        r109.setSecondaryProgress(r107);
        ProgressBar r110 = this.f447172g;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPipModeProgressBar");
        r110 = null;
    L20:
        r110.setProgress(r100);
        TextView r111 = this.f447169d;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentPlayTime");
        r111 = null;
    L23:
        if (r100 <= 0) goto L25;
        r100 = r100 + 500;
    L25:
        r111.setText(com.larksuite.framework.utils.e.f(r100));
        TextView r112 = this.f447171f;
        if (r112 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoDuration");
    L29:
        if (r101 <= 0) goto L31;
        r101 = r101 + 500;
    L31:
        r104.setText(com.larksuite.framework.utils.e.f(r101));
        return;
    L28:
        r104 = r112;
        goto L29
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
    }
}
