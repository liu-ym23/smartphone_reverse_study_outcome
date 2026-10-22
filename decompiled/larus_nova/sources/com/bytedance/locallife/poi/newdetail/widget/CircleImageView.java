package com.bytedance.locallife.poi.newdetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes21.dex */
public class CircleImageView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f263298a;

    public class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleImageView f263299a;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        public a(CircleImageView r100) {
            this.f263299a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, Object r101) {
            ImageInfo r102 = (ImageInfo) r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            this.f263299a.getClass();
        }
    }

    public final void j() {
    }

    public final void f() {
        RoundingParams r100 = getHierarchy().getRoundingParams();
        if (r100 != null) goto L5;
        r100 = new RoundingParams();
    L5:
        r100.setRoundAsCircle(true);
        getHierarchy().setRoundingParams(r100);
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        j();
    }

    public ControllerListener<ImageInfo> getControllerListener() {
        return this.f263298a;
    }

    public CircleImageView(Context r100) {
        super(r100);
        new Paint();
        this.f263298a = new a(this);
        f();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(DraweeController r100) {
        super.setController(r100);
    }

    public CircleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        new Paint();
        this.f263298a = new a(this);
        f();
    }

    public CircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new Paint();
        this.f263298a = new a(this);
        f();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        j();
    }
}
