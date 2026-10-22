package com.larus.bmhome.chat.layout.holder.progressloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/ImageWebpLoadingBgView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawPartType", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ImageLoadingDrawPartType;", "isDrawPartMode", "", "matrix", "Landroid/graphics/Matrix;", "init", "", "loadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "bizType", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageWebpLoadingBgView extends SimpleDraweeView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f304021d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageLoadingDrawPartType f304022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f304023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f304024c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f304025a = null;

        static {
            int[] r100 = new int[ImageLoadingDrawPartType.values().length];
            r100[ImageLoadingDrawPartType.LEFT_TOP_PART.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ImageLoadingDrawPartType.RIGHT_TOP_PART.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ImageLoadingDrawPartType.LEFT_BOTTOM_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ImageLoadingDrawPartType.RIGHT_BOTTOM_PART.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f304025a = r100;
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageWebpLoadingBgView f304026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f304027b;

        public c(ImageWebpLoadingBgView r100, e r101) {
            this.f304026a = r100;
            this.f304027b = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            FLogger.f375446a.e("ImageWebpLoadingBgView", "load webp fail " + r101);
            this.f304026a.setActualImageResource(((e.b) this.f304027b).f304045b);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "id");
            if (r102 == null) goto L6;
            r102.start();
            return;
        }
    }

    static {
    }

    public ImageWebpLoadingBgView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ImageWebpLoadingBgView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f304023b == false) goto L22;
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        Matrix r103 = this.f304024c;
        r103.reset();
        r103.postScale(2.0f, 2.0f);
        ImageLoadingDrawPartType r104 = this.f304022a;
        if (r104 != null) goto L7;
        int r105 = -1;
    L9:
        if (r105 != 1) goto L11;
        r103.postTranslate(0.0f, 0.0f);
    L21:
        r100.save();
        r100.concat(this.f304024c);
        getDrawable().draw(r100);
        r100.restore();
        return;
    L11:
        if (r105 != 2) goto L13;
        r103.postTranslate(-r101, 0.0f);
        goto L21
    L13:
        if (r105 != 3) goto L15;
        r103.postTranslate(0.0f, -r102);
        goto L21
    L15:
        if (r105 != 4) goto L21;
        r103.postTranslate(-r101, -r102);
        goto L21
    L7:
        r105 = b.f304025a[r104.ordinal()];
        goto L9
    L22:
        super.onDraw(r100);
    }

    public ImageWebpLoadingBgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304024c = new Matrix();
    }

    public /* synthetic */ ImageWebpLoadingBgView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void f(final e r100, boolean r101, ImageLoadingDrawPartType r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "loadingResource");
        Intrinsics.checkNotNullParameter(r110, "bizType");
        this.f304023b = r101;
        this.f304022a = r102;
        if (r101 == false) goto L5;
        ImageView.ScaleType r103 = ImageView.ScaleType.MATRIX;
    L6:
        setScaleType(r103);
        if ((r100 instanceof e.a) == false) goto L10;
        setActualImageResource(((e.a) r100).f304043a);
        return;
    L10:
        if ((r100 instanceof e.b) == false) goto L14;
        setAlpha(0.7f);
        ImageLoaderKt.x(this, Uri.fromFile(new PolarisFileWrapper(((e.b) r100).f304044a)), r110, null, new d(this, r100), 4);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r103 = ImageView.ScaleType.CENTER_CROP;
        goto L6
    }
}
