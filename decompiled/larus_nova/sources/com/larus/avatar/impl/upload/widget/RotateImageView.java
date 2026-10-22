package com.larus.avatar.impl.upload.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/avatar/impl/upload/widget/RotateImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "rotateAnimator", "Landroid/animation/ObjectAnimator;", "isAnimating", "", "updateLoadingIcon", "", "icon", "onAttachedToWindow", "onDetachedFromWindow", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "startAnimation", "cancelAnimation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RotateImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectAnimator f291369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f291370b;

    public RotateImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RotateImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        if (Looper.myLooper() != null) goto L11;
        return;
    L11:
        if (this.f291370b == true) goto L17;
        ObjectAnimator r101 = this.f291369a;
        if (r101 == null) goto L18;
        r101.start();
        this.f291370b = true;
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Looper.myLooper() == null) goto L10;
        this.f291370b = false;
        ObjectAnimator r100 = this.f291369a;
        if (r100 == null) goto L9;
        r100.cancel();
        return;
    L9:
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        if (Looper.myLooper() != null) goto L11;
        return;
    L11:
        if (this.f291370b == true) goto L22;
        ObjectAnimator r102 = this.f291369a;
        if (r102 == null) goto L23;
        r102.start();
        this.f291370b = true;
        return;
    L23:
        return;
    L22:
        return;
    L16:
        if (Looper.myLooper() == null) goto L27;
        this.f291370b = false;
        ObjectAnimator r103 = this.f291369a;
        if (r103 == null) goto L25;
        r103.cancel();
        return;
    L25:
        return;
    L27:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public RotateImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});
        r103.setInterpolator(new LinearInterpolator());
        r103.setRepeatCount(-1);
        r103.setDuration(1000);
        this.f291369a = r103;
    }

    public /* synthetic */ RotateImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
