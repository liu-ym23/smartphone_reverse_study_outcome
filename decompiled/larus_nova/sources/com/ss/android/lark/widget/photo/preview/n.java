package com.ss.android.lark.widget.photo.preview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.navigation.Navigation;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.entity.PhotoPreviewDrawable;
import com.ss.android.lark.widget.previewanimation.PreviewAnimation;
import com.ss.android.lark.widget.previewanimation.player.image.ImageScaleTransformPlayer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f447022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k.c f447023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f447024c;

    public n(Activity r100, k.c r101, int r102) {
        this.f447022a = r100;
        this.f447023b = r101;
        this.f447024c = r102;
    }

    public final void a() {
        Intent r100 = new Intent(this.f447022a, PhotoPagerActivity.class);
        r100.putExtras(this.f447023b.f446737a);
        if (CarUtils.b() == true) goto L57;
        k.c r101 = this.f447023b;
        Activity r102 = this.f447022a;
        List<? extends PhotoItem> r103 = r101.f446740d;
        Parcelable r104 = null;
        ImageView r105 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        if (r103 == null) goto L55;
        int r106 = r101.f446741e;
        if (r106 < 0) goto L55;
        if (r106 >= r103.size()) goto L55;
        PhotoItem r107 = (PhotoItem) ListProtector.get(r103, r101.f446741e);
        if (r107 == null) goto L55;
        View r108 = r101.f446738b;
        if (r108 == null) goto L55;
        PhotoPreviewDrawable r109 = new PhotoPreviewDrawable(r108.getContext(), r107);
        Intrinsics.checkNotNullParameter(r109, PickerReporterConstants.KEY.TARGET);
        ImageView.ScaleType r110 = ImageView.ScaleType.CENTER_CROP;
        ImageView.ScaleType r111 = ImageView.ScaleType.FIT_CENTER;
        Rect r112 = new Rect();
        if ((r108 instanceof ImageView) == false) goto L21;
        r105 = (ImageView) r108;
    L21:
        if (r105 == null) goto L24;
        ImageView.ScaleType r113 = r105.getScaleType();
        if (r113 == null) goto L24;
    L25:
        Intrinsics.checkNotNullParameter(r113, "scaleType");
        if (r107.getWidth() > 0) goto L28;
    L30:
        Pair r114 = TuplesKt.to(Integer.valueOf(r109.getIntrinsicWidth()), Integer.valueOf(r109.getIntrinsicHeight()));
    L31:
        int r115 = ((Number) r114.component1()).intValue();
        int r116 = ((Number) r114.component2()).intValue();
        if (r115 <= 0) goto L38;
        if (r116 <= 0) goto L38;
        if ((r116 / r115) <= 3.0f) goto L38;
        boolean r117 = true;
    L39:
        if (r117 == false) goto L41;
        ImageView.ScaleType r118 = ImageView.ScaleType.CENTER_CROP;
    L42:
        Intrinsics.checkNotNullParameter(r118, "scaleType");
        int[] r119 = new int[2];
        r108.getLocationOnScreen(r119);
        int r120 = r119[0];
        Rect r121 = new Rect(r120, r119[1], r108.getWidth() + r120, r119[1] + r108.getHeight());
        ActivityTransitionLauncher.LocationInfo r122 = r101.f446739c;
        if (r122 == null) goto L48;
        Log.i("PhotoPreviewNew", "Build ImageScaleTransformPlay from rect: " + r122.getLocation() + ", clickRect: " + r121);
        Rect r123 = r122.getLocation();
        if (r123 == null) goto L48;
        r121 = r123;
    L49:
        Intrinsics.checkNotNullParameter(r121, SVGRenderEngine.RECT);
        r112.set(r121);
        View r124 = r102.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L54;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r125 = ThreadMethodProxy.currentThread();
        if (r125 == com.larus.home.impl.utils.c.f346341a) goto L54;
        com.larus.home.impl.utils.c.a(r125, "getDecorView");
    L54:
        Intrinsics.checkNotNullParameter(r124, "<this>");
        int[] r126 = new int[2];
        r124.getLocationOnScreen(r126);
        Intrinsics.checkNotNullParameter(r126, "startPosition");
        ImageScaleTransformPlayer r127 = new ImageScaleTransformPlayer(r109);
        r127.f448015g = -16777216;
        r127.f448010b = r113;
        r127.f448011c = r118;
        r127.f448017i.set(r112);
        r127.f448019k = r126;
        PreviewAnimation r128 = new PreviewAnimation(r127);
        r128.f447989b = 300;
        r104 = r128;
    L48:
        Log.i("PhotoPreviewNew", "Build ImageScaleTransformPlay from clickRect: " + r121);
        goto L49
    L41:
        r118 = ImageView.ScaleType.FIT_CENTER;
    L38:
        r117 = false;
        goto L39
    L28:
        if (r107.getHeight() <= 0) goto L30;
        r114 = TuplesKt.to(Integer.valueOf(r107.getWidth()), Integer.valueOf(r107.getHeight()));
    L24:
        r113 = ImageView.ScaleType.FIT_CENTER;
    L55:
        if (r104 == null) goto L57;
        r100.putExtra("PreviewAnimation:key:name", r104);
    L57:
        Navigation.from(this.f447022a).openActivity(r100, this.f447024c);
        Log.i("PhotoPreviewNew", "openActivity");
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
