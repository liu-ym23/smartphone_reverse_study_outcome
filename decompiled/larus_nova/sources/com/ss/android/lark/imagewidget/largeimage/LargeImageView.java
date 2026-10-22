package com.ss.android.lark.imagewidget.largeimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.GlideCommonUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.LogSafetyTools;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.imagewidget.largeimage.transform.CropAndRotationTransformation;
import com.ss.android.lark.imagewidget.largeimage.transform.WhiteBgTransformation;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageDecoder;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.RotateLoadingView;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nlb.e;
import nlb.g;
import olb.d;

/* JADX INFO: loaded from: classes36.dex */
public class LargeImageView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f426673f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f426674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SubsamplingScaleImageView f426675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public olb.a f426676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f426677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f426678e;

    public class a implements SubsamplingScaleImageView.j {
        public a() {
        }

        @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.j
        public final PointF a(PointF r100) {
            return new PointF(0.0f, 0.0f);
        }

        @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.j
        public final float b(int r100, int r101, int r102, int r103) {
            if (r100 <= 0) goto L13;
            if (r101 <= 0) goto L13;
            if (r102 <= 0) goto L13;
            if (r103 <= 0) goto L13;
            float r104 = (r100 * 1.0f) / r102;
            float r105 = (r101 * 1.0f) / r103;
            if ((r103 / r102) <= 3) goto L12;
            return Math.max(r104, r105);
        L12:
            return Math.min(r104, r105);
        L13:
            return 1.0f;
        }
    }

    public class b extends rkb.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f426679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LargeImageView f426680c;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            LargeImageView r101 = this.f426680c;
            g r102 = this.f426679b;
            int r103 = LargeImageView.f426673f;
            r101.s(r102);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            this.f426680c.t(this.f426679b);
        }

        public b(LargeImageView r100, ImageView r101, g r102) {
            this.f426680c = r100;
            this.f426679b = r102;
            super(r101);
        }
    }

    public interface c {
        void a();

        void b();

        void c(int r100, ErrorResult r101);
    }

    public void setScaleImageViewInfo(g r100) {
    }

    public Drawable getImageDrawable() {
        if (this.f426674a.getVisibility() != 0) goto L11;
        Drawable r100 = this.f426674a.getDrawable();
        if (r100 == null) goto L11;
        if (r100.getConstantState() == null) goto L11;
        return r100.getConstantState().newDrawable();
    L11:
        return this.f426675b.getImageDrawable();
    }

    public SubsamplingScaleImageView.j getSizeChangedStrategy() {
        return new a();
    }

    public final void v() {
        r("show error");
        this.f426674a.setVisibility(0);
        this.f426675b.setVisibility(8);
        g r100 = this.f426677d;
        Drawable r101 = null;
        if (r100 == null) goto L9;
        Drawable r102 = r100.f519576b;
        if (r102 == null) goto L7;
        r101 = r102;
    L8:
        s(this.f426677d);
        goto L9
    L7:
        r100.getClass();
    L9:
        this.f426674a.setImageDrawable(r101);
    }

    public final void w() {
        if (this.f426676c != null) goto L5;
        RotateLoadingView r100 = new RotateLoadingView(getContext());
        int r101 = UIUtils.dp2px(getContext(), 42.0f);
        addView(r100, new FrameLayout.LayoutParams(r101, r101, 17));
        this.f426676c = new olb.a(r100);
    L5:
        olb.a r102 = this.f426676c;
        r102.getClass();
        Log.i("LazyLoadingHelper", DyPayConstant.KEY_SHOW_LOADING);
        d.a(r102.f524190b);
        d.a(r102.f524191c);
        olb.c r103 = r102.f524190b;
        d.f524194a.postDelayed(r103, 250);
    }

    public ImageView getImageView() {
        return this.f426674a;
    }

    public c getLoadPreviewListener() {
        return this.f426678e;
    }

    public SubsamplingScaleImageView getScaleImageView() {
        return this.f426675b;
    }

    public LargeImageView(Context r100) {
        this(r100, null);
    }

    public SubsamplingScaleImageView l(Context r100) {
        return new SubsamplingScaleImageView(r100);
    }

    public List<BitmapTransformation> m(g r100) {
        ArrayList r101 = new ArrayList();
        com.ss.android.lark.imagewidget.largeimage.transform.b r102 = r100.f519578d;
        if (r102 == null) goto L5;
        r101.add(new CropAndRotationTransformation(r102.f426684c, r102.f426683b));
    L5:
        r101.add(new WhiteBgTransformation());
        return r101;
    }

    public final boolean n(g r100) {
        if (r100 == this.f426677d) goto L6;
        r("result is not final load file: " + r100.f519575a.getRealPath());
        return true;
    L6:
        return false;
    }

    public final void o(final g r100) {
        if (r100.f519575a.toFile().canRead() == true) goto L6;
        r("file can not read, info: " + r100.f519575a.getRealPath());
        return;
    L6:
        this.f426677d = r100;
        RxScheduledExecutor.execInIO(new nlb.d(this, r100), new e(this));
    }

    public final void p(g r100) {
        r("loadAnimationDrawable");
        this.f426674a.setVisibility(0);
        this.f426675b.setVisibility(8);
        IRequestCreator r101 = ImageLoader.with(getContext()).load(r100.f519575a.toFile()).placeholder(r100.f519576b).error(null).diskCacheStrategy(DiskCacheStrategy.NONE).dontAnimate(false);
        Iterator<BitmapTransformation> r102 = m(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.transform(r102.next());
        goto L4
    L6:
        r101.into(new b(this, this.f426674a, r100));
    }

    public final void r(String r100) {
        Log.i("LargeImageView", r100);
    }

    public final void s(g r100) {
        r("onLoadPreviewFail, info: " + r100.f519575a.getRealPath());
        olb.a r101 = this.f426676c;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        c r102 = this.f426678e;
        if (r102 == null) goto L9;
        r102.c(PerfPhotoViewMonitor.ErrorReason.PIC_LOAD_LOCAL_FILE_FAILED, null);
        return;
    }

    public void setImageBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
    L10:
        Log.e("LargeImageView", "setImageBitmap failed, bitmap is invalid");
        return;
    L4:
        if (r100.isRecycled() == true) goto L10;
        if (r100.getWidth() <= 0) goto L10;
        if (r100.getHeight() <= 0) goto L10;
        this.f426674a.setVisibility(8);
        this.f426675b.setVisibility(0);
        this.f426675b.setImage(qlb.a.a(r100));
    }

    public void setLoadPreviewListener(c r100) {
        this.f426678e = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f426674a.setOnClickListener(r100);
        this.f426675b.setOnClickListener(r100);
    }

    @Override // android.view.View
    public void setOnGenericMotionListener(View.OnGenericMotionListener r100) {
        super.setOnGenericMotionListener(r100);
        this.f426674a.setOnGenericMotionListener(r100);
        this.f426675b.setOnGenericMotionListener(r100);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        super.setOnLongClickListener(r100);
        this.f426674a.setOnLongClickListener(r100);
        this.f426675b.setOnLongClickListener(r100);
    }

    public final void t(g r100) {
        r("onLoadPreviewSuccess, info: " + r100.f519575a.getRealPath());
        olb.a r101 = this.f426676c;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        c r102 = this.f426678e;
        if (r102 == null) goto L9;
        r102.b();
        return;
    }

    public final void u(g r110) {
        File r100 = r110.f519575a.toFile();
        File r101 = GlideCommonUtils.getDecryptFile(r100);
        if (r101 == null) goto L5;
        r110.f519575a = VFSFiles.f444819b.z(r101.getPath());
        r100 = r101;
    L5:
        r110.f519581g = ImageUtils.c(r100);
        r110.f519582h = ImageUtils.e(r100);
        com.ss.android.lark.imagewidget.largeimage.transform.b r102 = r110.f519578d;
        if (r102 == null) goto L10;
        Rect r103 = r102.f426682a;
        if (r103 == null) goto L10;
        r110.f519579e = r103.width();
        r110.f519580f = r110.f519578d.f426682a.height();
        return;
    L10:
        boolean r104 = r110.f519577c;
        String r105 = r100.getPath();
        BitmapFactory.Options r106 = new BitmapFactory.Options();
        r106.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100.getPath(), r106);
        int r107 = r106.outWidth;
        int r108 = r106.outHeight;
        if ((p.h(r100.getPath()) % 180) != 90) goto L14;
        r107 = r106.outHeight;
        r108 = r106.outWidth;
    L14:
        if (r104 == false) goto L18;
        if (r107 == 0) goto L22;
        if (r108 == 0) goto L22;
    L21:
        boolean r109 = false;
    L24:
        if (r109 == false) goto L26;
        Log.e("LargeImageHelper", "getImageResolution failed, width: " + r107 + ", height: " + r108);
        int r111 = nlb.c.g(this);
        int r112 = nlb.c.f(this);
        int[] r113 = ImageUtils.g(0, 0, r111, r112, r111 >> 2, r112 >> 2);
        r107 = r113[0];
        r108 = r113[1];
    L26:
        Log.i("LargeImageHelper", "getImageResolution, width: " + r107 + ", height: " + r108 + ", file: " + LogSafetyTools.a(r105));
        Pair r114 = new Pair(Integer.valueOf(r107), Integer.valueOf(r108));
        r110.f519579e = ((Integer) r114.first).intValue();
        r110.f519580f = ((Integer) r114.second).intValue();
        return;
    L22:
        r109 = true;
        goto L24
    L18:
        if (r107 <= 0) goto L22;
        if (r108 > 0) goto L21;
        goto L21
    }

    public LargeImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void q(g r100, Bitmap r101) {
        r("start load large image");
        SubsamplingScaleImageView r102 = this.f426675b;
        boolean r103 = r100.f519577c;
        r102.setBitmapDecoderFactory(new nlb.a(MSkiaImageDecoder.class, r100, r103));
        r102.setRegionDecoderFactory(new nlb.b(MSkiaImageRegionDecoder.class, r100, r103));
        nlb.c.i(this.f426675b, r100, r101);
        SubsamplingScaleImageView r104 = this.f426675b;
        int r105 = r100.f519579e;
        int r106 = r100.f519580f;
        int r107 = nlb.c.g(r104);
        int r108 = nlb.c.f(r104);
        float r109 = nlb.c.b(r107, r108, r105, r106);
        float r110 = nlb.c.c(r107, r108, r105, r106);
        float r111 = nlb.c.d(r107, r108, r105, r106);
        Log.i("LargeImageHelper", "doubleTabScale:" + r109 + ", maxScale:" + r110 + ", minScale:" + r111);
        r104.setDoubleTapZoomScale(r109);
        r104.setMaxScale(r110);
        r104.M(r111, new PointF(0.0f, 0.0f));
        if ((r106 / r105) <= 3) goto L5;
        r104.setMinimumScaleType(1);
    L5:
        r104.setMinScale(r111);
        t(r100);
    }

    public LargeImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f426674a = new ImageView(getContext());
        this.f426675b = l(getContext());
        addView(this.f426674a, new FrameLayout.LayoutParams(-1, -1));
        addView(this.f426675b, new FrameLayout.LayoutParams(-1, -1));
        this.f426675b.setExecutor(CoreThreadPool.getDefault().getCachedThreadPool());
        this.f426675b.setOrientation(-1);
        this.f426675b.setTileBackgroundColor(UIHelper.getColor(R.color.lkui_N100));
        this.f426675b.setOnSizeChangedStrategy(getSizeChangedStrategy());
    }
}
