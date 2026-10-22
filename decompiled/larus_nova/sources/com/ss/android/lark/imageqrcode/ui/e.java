package com.ss.android.lark.imageqrcode.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f426662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f426663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ QRCodeShowParam f426664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ImageQRCodeSelectActivity f426665d;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f426662a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f426662a.removeAllViews();
        int r100 = com.ss.android.lark.imageqrcode.utils.a.f426671a;
        FrameLayout r101 = this.f426662a;
        Bitmap r102 = this.f426663b;
        QRCodeShowParam.ScaleType r103 = this.f426664c.getScaleType();
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "bgBitmap");
        Intrinsics.checkNotNullParameter(r103, "scaleType");
        RectF r104 = new RectF();
        int r105 = r101.getWidth();
        int r106 = r101.getHeight();
        float r107 = r105;
        float r108 = r102.getWidth();
        float r109 = r107 / r108;
        float r110 = r106;
        float r111 = r102.getHeight();
        float r112 = r110 / r111;
        if (r103 != QRCodeShowParam.ScaleType.FIT_CENTER) goto L5;
        float r113 = RangesKt.coerceAtMost(r109, r112);
    L6:
        float r114 = r108 * r113;
        float r115 = r111 * r113;
        float r116 = (r107 - r114) / 2.0f;
        r104.left = r116;
        float r117 = (r110 - r115) / 2.0f;
        r104.top = r117;
        r104.right = r116 + r114;
        r104.bottom = r117 + r115;
        Bitmap r118 = BitmapFactory.decodeResource(this.f426662a.getResources(), R.drawable.qrcode_bubble);
        ArrayList<QRCodeContentInfo> r119 = this.f426664c.getContentList();
        ImageQRCodeSelectActivity r120 = this.f426665d;
        FrameLayout r121 = this.f426662a;
        Iterator<T> r122 = r119.iterator();
    L8:
        if (r122.hasNext() == false) goto L10;
        QRCodeContentInfo r123 = (QRCodeContentInfo) r122.next();
        Intrinsics.checkNotNull(r118);
        QRCodeShowParam r124 = ImageQRCodeSelectActivity.f426641d;
        r120.getClass();
        RectF r125 = new RectF();
        r125.left = r104.left + (r123.getLeftRatio() * r104.width());
        r125.top = r104.top + (r123.getTopRatio() * r104.height());
        r125.right = r104.left + (r123.getRightRatio() * r104.width());
        r125.bottom = r104.top + (r123.getBottomRatio() * r104.height());
        r125.intersect(r104);
        AppCompatImageView r126 = new AppCompatImageView(r120);
        r126.setImageBitmap(r118);
        int r127 = ImageQRCodeSelectActivity.f426642e;
        FrameLayout.LayoutParams r128 = new FrameLayout.LayoutParams(r127, r127);
        double r129 = ((double) r127) / 2.0d;
        r128.leftMargin = (int) (((double) r125.centerX()) - r129);
        r128.topMargin = (int) (((double) r125.centerY()) - r129);
        r121.addView(r126, r128);
        r126.setOnClickListener(new a(r120, r123));
        AnimatorSet r130 = new AnimatorSet();
        ObjectAnimator r131 = ObjectAnimator.ofFloat(r126, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.8f, 1.0f, 0.8f, 1.0f}).setDuration(1320);
        r130.play(r131).with(ObjectAnimator.ofFloat(r126, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.8f, 1.0f, 0.8f, 1.0f}).setDuration(1320));
        r130.addListener(new f(r120, r130));
        r120.f426644b.add(r130);
        r130.start();
        goto L8
    L10:
        return;
    L5:
        r113 = RangesKt.coerceAtLeast(r109, r112);
        goto L6
    }

    public e(FrameLayout r100, Bitmap r101, QRCodeShowParam r102, ImageQRCodeSelectActivity r103) {
        this.f426662a = r100;
        this.f426663b = r101;
        this.f426664c = r102;
        this.f426665d = r103;
    }
}
