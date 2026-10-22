package com.larus.common_ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.image.loader.ImageLoaderKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import z19.e;
import z19.f;
import z19.k;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014JH\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0013J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/larus/common_ui/widget/CircleSimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "path", "Landroid/graphics/Path;", "currentUrl", "", "getCurrentUrl", "()Ljava/lang/String;", "setCurrentUrl", "(Ljava/lang/String;)V", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "setAvatarUrl", "uri", "Landroid/net/Uri;", "lowResUri", "traceController", "Lcom/larus/common_ui/widget/ImageTraceController;", "imageExtra", "Lcom/larus/image/loader/ImageExtra;", "width", "height", "setGifRound", "placeHolder", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleSimpleDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f328421c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f328422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f328423b;

    public static final class a {
    }

    static {
    }

    public final String getCurrentUrl() {
        return this.f328423b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.clipPath(this.f328422a);
        super.onDraw(r100);
    }

    public final void setCurrentUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f328423b = r100;
    }

    public final void setGifRound(int r100) {
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        final ImageDecodeOptions r101 = ImageDecodeOptions.newBuilder().setForceStaticImage(true).build();
        ImageLoaderKt.y(this, "res://" + getContext().getPackageName() + '/' + r100, null, new f(this, r101), 6);
    }

    public CircleSimpleDraweeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328422a = new Path();
        this.f328423b = "";
        RoundingParams r102 = RoundingParams.asCircle();
        getHierarchy().setRoundingParams(r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = Math.min(r100, r101) / 2.0f;
        this.f328422a.reset();
        this.f328422a.addCircle(r100 / 2.0f, r101 / 2.0f, r104, Path.Direction.CCW);
    }

    public static void f(final CircleSimpleDraweeView r110, Uri r111, Uri r112, k r113, int r114, int r115, int r116) {
        final ImageRequest r100 = null;
        if ((r116 & 2) == 0) goto L5;
        Uri r101 = null;
    L7:
        if ((r116 & 4) == 0) goto L9;
        final k r102 = null;
    L10:
        int r103 = 0;
        if ((r116 & 16) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r116 & 32) != 0) goto L18;
        r103 = r115;
    L18:
        r110.getClass();
        if (r111 == null) goto L33;
        final Ref.BooleanRef r105 = new Ref.BooleanRef();
        if (Intrinsics.areEqual(StringsKt.substringBeforeLast$default(r111.toString(), "&x-signature=", null, 2, null), StringsKt.substringBeforeLast$default(r110.f328423b, "&x-signature=", null, 2, null)) == true) goto L34;
        r110.f328423b = r111.toString();
        final ImageDecodeOptions r106 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        if (r101 == null) goto L31;
        ImageRequestBuilder r107 = ImageRequestBuilder.newBuilderWithSource(r101).setImageDecodeOptions(r106);
        if (r104 == 0) goto L30;
        if (r103 == 0) goto L30;
        r107.setResizeOptions(new ResizeOptions(r104, r103));
    L30:
        r100 = r107.build();
    L31:
        ImageLoaderKt.x(r110, r111, null, null, new e(r100, r106, r102, r105, r110), 2);
        return;
    L34:
        return;
    L33:
        return;
    L13:
        r104 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L10
    L5:
        r101 = r112;
        goto L7
    }
}
