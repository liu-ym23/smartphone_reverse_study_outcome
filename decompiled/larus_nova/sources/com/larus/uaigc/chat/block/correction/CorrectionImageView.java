package com.larus.uaigc.chat.block.correction;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 32\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u00013B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J)\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020&2\u0006\u0010+\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020\u001fH\u0014J\b\u00102\u001a\u00020\u001fH\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/uaigc/chat/block/correction/CorrectionImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/uaigc/chat/block/correction/CorrectionImageViewInput;", "Lcom/larus/uaigc/chat/block/correction/CorrectionImageViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "retryContainer", "Landroid/widget/FrameLayout;", "failedContainer", "loadingContainer", "loadingImageCover", "Landroid/view/View;", "shimmerLoadingText", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "retryImageView", "Landroid/widget/ImageView;", "loadingImageView", "currentInput", "currentOutput", "latestSize", "Landroid/util/Size;", "latestStatus", "", "setupViews", "", "bindData", "input", BdpAppEventConstant.PARAMS_OUTPUT, "showLoadingState", "showFailedState", "waitForImageLoadComplete", "", "showNormalState", "fromLoadingToCompleteInDelay", "calculateSize", "width", "height", "maxContentWidth", "(Ljava/lang/Integer;Ljava/lang/Integer;I)Landroid/util/Size;", "shouldHideImageForSmallHeight", "startShimmerAnimation", "stopShimmerAnimation", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CorrectionImageView extends ConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f370405k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SimpleDraweeView f370406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f370407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f370408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f370409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f370410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShimmerTextView f370411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f370412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f370413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f370414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f370415j;

    public static final class a {
    }

    public static final class b implements ControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CorrectionImageView f370416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Size f370417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f370418c;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            final CorrectionImageView r102 = this.f370416a;
            final FrameLayout r103 = r102.f370407b;
            if (r103 == null) goto L17;
            Size r104 = this.f370417b;
            final m r105 = this.f370418c;
            ConstraintLayout r106 = r102.f370409d;
            if (r106 == null) goto L7;
            e1.q(r106);
        L7:
            e1.x(r103);
            if (r102.S5(r104.getHeight()) == false) goto L12;
            ImageView r107 = r102.f370412g;
            if (r107 == null) goto L15;
            e1.o(r107);
        L15:
            e1.d(r103, new k(r102, r105, r103));
            return;
        L12:
            ImageView r108 = r102.f370412g;
            if (r108 == null) goto L15;
            e1.x(r108);
            goto L15
        }

        public b(CorrectionImageView r100, Size r101, m r102) {
            this.f370416a = r100;
            this.f370417b = r101;
            this.f370418c = r102;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            if (r101 == null) goto L7;
            View r103 = this.f370416a.f370410e;
            if (r103 == null) goto L8;
            e1.x(r103);
            return;
        L8:
            return;
        }
    }

    public static final class c implements ControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CorrectionImageView f370419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Size f370420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f370421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n f370422d;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            CorrectionImageView r102 = this.f370419a;
            if (r102.f370415j == false) goto L5;
            r102.post(new j(r102));
        L5:
            final CorrectionImageView r103 = this.f370419a;
            r103.f370415j = false;
            final FrameLayout r104 = r103.f370407b;
            if (r104 == null) goto L20;
            Size r105 = this.f370420b;
            final m r106 = this.f370421c;
            final n r107 = this.f370422d;
            SimpleDraweeView r108 = r103.f370406a;
            if (r108 == null) goto L10;
            e1.q(r108);
        L10:
            e1.x(r104);
            if (r103.S5(r105.getHeight()) == false) goto L15;
            ImageView r109 = r103.f370412g;
            if (r109 == null) goto L18;
            e1.o(r109);
        L18:
            e1.d(r104, new l(r103, r106, r107, r104));
            return;
        L15:
            ImageView r110 = r103.f370412g;
            if (r110 == null) goto L18;
            e1.x(r110);
            goto L18
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            CorrectionImageView r103 = this.f370419a;
            if (r103.f370415j == false) goto L5;
            r103.post(new j(r103));
        L5:
            this.f370419a.f370415j = false;
        }

        public c(CorrectionImageView r100, Size r101, m r102, n r103) {
            this.f370419a = r100;
            this.f370420b = r101;
            this.f370421c = r102;
            this.f370422d = r103;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f370414i != 1) goto L5;
    L6:
        ShimmerTextView r100 = this.f370411f;
        if (r100 == null) goto L11;
        int r101 = ShimmerTextView.f304901h;
        r100.z(false);
        return;
    L11:
        return;
    L5:
        if (this.f370415j == true) goto L6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ShimmerTextView r100 = this.f370411f;
        if (r100 == null) goto L6;
        r100.x();
        return;
    }

    public CorrectionImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final boolean S5(int r100) {
        if (r100 >= getContext().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_62, getContext(), R.dimen.larus_dp_62))) goto L5;
        return true;
    L5:
        return false;
    }

    public final void T5(final m r110) {
        SimpleDraweeView r100 = this.f370406a;
        if (r100 == null) goto L5;
        e1.o(r100);
    L5:
        FrameLayout r101 = this.f370408c;
        if (r101 == null) goto L8;
        e1.o(r101);
    L8:
        ConstraintLayout r102 = this.f370409d;
        if (r102 == null) goto L11;
        e1.x(r102);
    L11:
        ImagePlaceHolder r103 = r110.f370456f;
        if (r103 == null) goto L46;
        Long r104 = r103.width;
        GenericDraweeView r105 = null;
        if (r104 == null) goto L16;
        Integer r106 = Integer.valueOf((int) r104.longValue());
    L17:
        Long r107 = r103.height;
        if (r107 == null) goto L20;
        Integer r108 = Integer.valueOf((int) r107.longValue());
    L21:
        final Size r109 = R5(r106, r108, r110.f370457g);
        ConstraintLayout r111 = this.f370409d;
        if (r111 == null) goto L25;
        r111.setLayoutParams(new ConstraintLayout.LayoutParams(r109.getWidth(), r109.getHeight()));
    L25:
        if (S5(r109.getHeight()) == false) goto L29;
        ImageView r112 = this.f370413h;
        if (r112 == null) goto L32;
        e1.o(r112);
    L32:
        ImageObj r113 = r110.f370454d;
        if (r113 == null) goto L42;
        String r114 = r113.url;
        MessageImageLoader r115 = MessageImageLoader.f308183a;
        Message r116 = r110.f370451a;
        if (r116 == null) goto L37;
        String r117 = r116.getMessageId();
    L38:
        MessageImageType r118 = MessageImageType.IMAGE;
        ConstraintLayout r119 = this.f370409d;
        if (r119 == null) goto L41;
        r105 = (GenericDraweeView) r119.findViewById(R.id.larus_correction_loading_image_view);
    L41:
        IMessageImageLoaderService.a.a(r115, r117, r118, r105, r114, "CorrectionImageView", new g(this, r109, r110), 32);
        goto L42
    L37:
        r117 = null;
    L42:
        ShimmerTextView r120 = this.f370411f;
        if (r120 == null) goto L47;
        int r121 = ShimmerTextView.f304901h;
        r120.z(false);
        return;
    L47:
        return;
    L29:
        ImageView r122 = this.f370413h;
        if (r122 == null) goto L32;
        e1.x(r122);
        goto L32
    L20:
        r108 = null;
        goto L21
    L16:
        r106 = null;
        goto L17
    }

    public CorrectionImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        new Size(0, 0);
        LayoutInflater.from(getContext()).inflate(R.layout.larus_correction_image_view, this, true);
        this.f370406a = (SimpleDraweeView) findViewById(R.id.larus_correction_image_view);
        this.f370407b = (FrameLayout) findViewById(R.id.larus_correction_retry_container);
        this.f370408c = (FrameLayout) findViewById(R.id.larus_correction_failed_container);
        this.f370409d = (ConstraintLayout) findViewById(R.id.larus_correction_loading_container);
        this.f370410e = findViewById(R.id.larus_correction_loading_image_view_cover);
        ShimmerTextView r102 = (ShimmerTextView) findViewById(R.id.larus_correction_loading_text);
        if (r102 == null) goto L5;
        ShimmerTextView.y(r102, ContextCompat.getColor(r102.getContext(), R.color.larus_static_white));
    L6:
        this.f370411f = r102;
        this.f370412g = (ImageView) findViewById(R.id.larus_correction_retry_image);
        this.f370413h = (ImageView) findViewById(R.id.larus_correction_loading_image);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void U5(final m r110, final n r111) {
        if (this.f370414i != 1) goto L5;
        boolean r100 = true;
    L6:
        SimpleDraweeView r101 = this.f370406a;
        if (r101 == null) goto L9;
        e1.x(r101);
    L9:
        FrameLayout r102 = this.f370408c;
        if (r102 == null) goto L12;
        e1.o(r102);
    L12:
        if (r100 == false) goto L18;
        SimpleDraweeView r103 = this.f370406a;
        if (r103 == null) goto L16;
        r103.setAlpha(0.0f);
    L16:
        this.f370415j = true;
    L25:
        ImageObj r104 = r110.f370454d;
        if (r104 != null) goto L28;
        return;
    L28:
        final Size r105 = R5(Integer.valueOf(r104.width), Integer.valueOf(r104.height), r110.f370457g);
        String r106 = r104.url;
        MessageImageLoader r107 = MessageImageLoader.f308183a;
        Message r108 = r110.f370451a;
        if (r108 == null) goto L31;
        String r109 = r108.getMessageId();
    L32:
        IMessageImageLoaderService.a.a(r107, r109, MessageImageType.IMAGE, this.f370406a, r106, "CorrectionImageView", new h(this, r105, r110, r111), 32);
        int r112 = r105.getWidth();
        int r113 = r105.getHeight();
        SimpleDraweeView r114 = this.f370406a;
        if (r114 == null) goto L35;
        r114.setLayoutParams(new ConstraintLayout.LayoutParams(r112, r113));
    L35:
        SimpleDraweeView r115 = this.f370406a;
        if (r115 == null) goto L38;
        e1.d(r115, new i(r111, this, r110));
    L38:
        SimpleDraweeView r116 = this.f370406a;
        if (r116 == null) goto L42;
        r111.b(r116);
        return;
    L42:
        return;
    L31:
        r109 = null;
        goto L32
    L18:
        if (this.f370415j == true) goto L25;
        ShimmerTextView r117 = this.f370411f;
        if (r117 == null) goto L22;
        r117.x();
    L22:
        ConstraintLayout r118 = this.f370409d;
        if (r118 == null) goto L25;
        e1.o(r118);
        goto L25
    L5:
        r100 = false;
        goto L6
    }

    public static Size R5(Integer r100, Integer r101, int r102) {
        boolean r103 = false;
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        float r104 = r100.intValue() / r101.intValue();
        if (r104 <= 1.0f) goto L10;
        return new Size(r102, (int) (r102 / r104));
    L10:
        if (r104 != 1.0f) goto L12;
        r103 = true;
    L12:
        if (r103 == false) goto L15;
        return new Size(r102, r102);
    L15:
        return new Size((int) (r102 * r104), r102);
    L17:
        return new Size(0, 0);
    }
}
