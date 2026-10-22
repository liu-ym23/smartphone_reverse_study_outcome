package com.bytedance.ee.bear.templates;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.data.ThumbnailExtra;
import com.bytedance.ee.bear.thumbnail.LeftCropForView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.u;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.dtf.face.api.IDTFacade;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import dd5.w0;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u000267B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010%\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\b\u00104\u001a\u000205H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewHolder2;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "view", "Landroid/view/View;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", "createType", "", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/templates/LayoutType;I)V", "operationTagImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "thumbnailImg", "typeIcon", "templateNameTxt", "Landroid/widget/TextView;", "labelTxt", "moreIv", "topView", "showTemplate", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "deleteListener", "Lkotlin/Function0;", "displayMixture", "loadCover", CJPayFingerprintSharedPrefUtils.KEY_IV, "getCoverDownloadUrl", "", "coverDownloadUrl", "coverToken", "showTopColor", "type", "showMoreIv", "getShareSource", "showCustomPanel", "displayThumbnail", "loadThumbnail", "objToken", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "showTemplateIconAndName", "getTemplateBlankName", "objType", "showBottomLabel", "getUseDesStr", "heat", "", "getWHeatStr", "getKHeatStr", "getTransformation", "Lcom/bytedance/ee/bear/thumbnail/LeftCropForView;", "Companion", "ViewTarget", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewHolder2 extends ITemplateViewHolder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f238812j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f238813k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f238814l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f238815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f238816n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f238817o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f238818p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final List<String> f238819q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f238820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutType f238821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f238822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f238823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f238824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f238825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f238826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f238827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f238828i;

    public static final class a {
    }

    public final class b extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f238829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f238830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public lt7.d f238831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f238832d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RunnableC3428b f238833e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f238834f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TemplateViewHolder2 f238835g;

        public static final class a implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f238836a;

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View r100) {
                Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            }

            public a(b r100) {
                this.f238836a = r100;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View r100) {
                Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
                b r101 = this.f238836a;
                r101.f238829a.removeCallbacks(r101.f238833e);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.TemplateViewHolder2$b$b, reason: collision with other inner class name */
        public static final class RunnableC3428b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f238837a;

            public RunnableC3428b(b r100) {
                this.f238837a = r100;
            }

            public final void a() {
                b r100 = this.f238837a;
                if (r100.f238832d == true) goto L11;
                int r101 = r100.f238835g.f238821b.getThumbnailSkeletonLayId();
                if (r100.f238835g.f238821b != LayoutType.TYPE_RECOMMEND2) goto L8;
                View r102 = r100.f238829a;
            L9:
                lt7.d.a r103 = u.a(r102);
                r103.f510707b = r101;
                r103.a(R.color.bg_body_overlay);
                r100.f238831c = r103.b();
                return;
            L8:
                Object r104 = r100.f238829a.getParent();
                Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.View");
                r102 = (View) r104;
                goto L9
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

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f238832d = true;
            tt5.a.d("TemplateViewHolder2", "onLoadFailed(): ");
            lt7.d r101 = this.f238831c;     // Catch: Exception -> L8
            if (r101 == null) goto L6;
            r101.a();     // Catch: Exception -> L8
        L6:
            this.f238829a.removeOnAttachStateChangeListener(this.f238834f);     // Catch: Exception -> L8
        L11:
            if (Intrinsics.areEqual(this.f238829a.getTag(R.id.thumbnail_tag), this.f238830b) == false) goto L13;
            this.f238829a.setScaleType(ImageView.ScaleType.CENTER);
            this.f238829a.setImageDrawable(r100);
            return;
        L13:
            tt5.a.d("TemplateViewHolder2", "onResourceReady()... tag not equals");
            return;
        L8:
            e = move-exception;
            tt5.a.e("TemplateViewHolder2", "hideSkeletonAnim(): ", e, false);
            goto L11
        }

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public final void onLoadStarted(Drawable r100) {
            super.onLoadStarted(r100);
            this.f238829a.postDelayed(this.f238833e, 100);
            this.f238829a.addOnAttachStateChangeListener(this.f238834f);
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object r100, Transition r101) {
            Bitmap r102 = (Bitmap) r100;
            Intrinsics.checkNotNullParameter(r102, "resource");
            this.f238832d = true;
            lt7.d r103 = this.f238831c;     // Catch: Exception -> L8
            if (r103 == null) goto L6;
            r103.a();     // Catch: Exception -> L8
        L6:
            this.f238829a.removeOnAttachStateChangeListener(this.f238834f);     // Catch: Exception -> L8
        L11:
            if (Intrinsics.areEqual(this.f238829a.getTag(R.id.thumbnail_tag), this.f238830b) == false) goto L13;
            this.f238829a.setImageBitmap(r102);
            return;
        L13:
            tt5.a.d("TemplateViewHolder2", "onResourceReady()... tag not equals");
            return;
        L8:
            e = move-exception;
            tt5.a.e("TemplateViewHolder2", "hideSkeletonAnim(): ", e, false);
            goto L11
        }

        public b(TemplateViewHolder2 r100, ImageView r101, String r102, TemplateV4 r103) {
            Intrinsics.checkNotNullParameter(r101, "destImg");
            Intrinsics.checkNotNullParameter(r102, "tag");
            Intrinsics.checkNotNullParameter(r103, ThumbGlideUrl.SOURCE_TEMPLATE);
            this.f238835g = r100;
            this.f238829a = r101;
            this.f238830b = r102;
            this.f238833e = new RunnableC3428b(this);
            this.f238834f = new a(this);
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238838a = null;

        static {
            int[] r100 = new int[LayoutType.values().length];
            r100[LayoutType.TYPE_RECOMMEND2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f238838a = r100;
        }
    }

    public static final class d implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateViewHolder2 f238839a;

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
            return true;
        }

        public d(TemplateViewHolder2 r100) {
            this.f238839a = r100;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
            this.f238839a.f238822c.setVisibility(0);
            ImageView r105 = this.f238839a.f238822c;
            r105.setImageDrawable(r100);
            return true;
        }
    }

    static {
        int r100 = cu5.c.b(16);
        f238812j = r100;
        int r101 = cu5.c.b(32);
        f238813k = r101;
        int r102 = w0.f468013a;
        int r103 = w0.b(eu5.b.f474075a);
        f238814l = r103;
        f238815m = (((cu5.c.d() - r101) - r100) / r103) - cu5.c.b(12);
        f238816n = cu5.c.b(89);
        f238817o = cu5.c.b(128);
        f238818p = cu5.c.b(76);
        f238819q = CollectionsKt.listOf(new String[]{"zh", IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA});
    }

    public final LeftCropForView V3() {
        LayoutType r100 = this.f238821b;
        if (c.f238838a[r100.ordinal()] != 1) goto L6;
        return new LeftCropForView(f238818p, f238817o);
    L6:
        return new LeftCropForView(f238816n, f238815m);
    }

    public TemplateViewHolder2(View r100, LayoutType r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutType");
        super(r100);
        this.f238820a = r100;
        this.f238821b = r101;
        Context r102 = r100.getContext();
        if (com.bytedance.ee.util.ui.b.b(r102) == true) goto L5;
    L12:
        this.f238822c = (ImageView) r100.findViewById(R.id.operationLabelImg);
        this.f238823d = (ImageView) r100.findViewById(R.id.templateImg);
        this.f238824e = (ImageView) r100.findViewById(R.id.typeIcon);
        this.f238825f = (TextView) r100.findViewById(R.id.templateNameTxt);
        this.f238826g = (TextView) r100.findViewById(R.id.labelTxt);
        this.f238827h = (ImageView) r100.findViewById(R.id.moreIv);
        this.f238828i = r100.findViewById(R.id.template_top);
        return;
    L5:
        if ((r102 instanceof Activity) == false) goto L12;
        View r103 = ((Activity) r102).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L11:
        f238815m = (((r103.getWidth() - f238813k) - f238812j) / f238814l) - cu5.c.b(12);
        goto L12
    }

    @Override // com.bytedance.ee.bear.templates.ITemplateViewHolder
    public final void T3(TemplateV4 r210, Function0<Unit> r211) {
        Intrinsics.checkNotNullParameter(r210, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r211, "deleteListener");
        View r100 = this.f238820a;
        if (r210.getEnable() == false) goto L5;
        float r101 = 1.0f;
    L6:
        r100.setAlpha(r101);
        boolean r102 = false;
        if (r210.isSceneTemplate() == false) goto L9;
        this.f238823d.setPadding(0, 0, 0, 0);
    L11:
        if (r210.getDisplayType() != 2) goto L13;
        String r103 = r210.getObjToken();
        int r110 = r210.getObjType();
        ThumbnailExtra r111 = r210.getThumbnailExtra();
        ThumbGlideUrl r112 = new ThumbGlideUrl("", r111.getThumbnail(), r110, r111.getType(), r111.getDecryptKey(), "", ThumbGlideUrl.SOURCE_TEMPLATE, true, "v4.1", this.f238823d);
        this.f238823d.setTag(R.id.thumbnail_tag, r210.getObjToken());
        Glide.with(this.f238823d.getContext()).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).transform(V3()).error(R.drawable.template_load_fail).load(r112).into(new b(this, this.f238823d, r103, r210));
    L21:
        if (this.f238827h != null) goto L24;
    L27:
        this.f238822c.setVisibility(8);
        if (r210.getOperationalLabelV2().length() <= 0) goto L30;
        boolean r104 = true;
    L31:
        if (r104 == false) goto L33;
        Glide.with(this.f238820a.getContext()).load(new BearGlideUrl(r210.getOperationalLabelV2())).centerInside().addListener(new d(this)).override(cu5.c.b(100), cu5.c.b(14)).into(this.f238822c);
    L33:
        int r105 = r210.getObjType();
        sbb.e r106 = sbb.e.f541296g;
        if (r105 != r106.f541317b) goto L37;
    L50:
        int r107 = R.drawable.ud_icon_file_doc_colorful;
    L52:
        if (r210.isSceneTemplate() == false) goto L54;
        this.f238824e.setVisibility(8);
    L55:
        this.f238824e.setImageResource(kac.a.b(r107));
        mbb.c.d(this.f238824e, r210.getObjToken(), r210.getObjType(), r210.getIcon(), IconShape.SQUARE, new obb.a(IconScene.TEMPLATE));
        if (r210.isCipherInvalid() == false) goto L59;
        this.f238825f.setText(this.f238820a.getContext().getString(R.string.CreationDoc_Template_KeyInvalid));
    L74:
        int r108 = r210.getObjType();
        View r109 = this.f238828i;
        Resources r113 = this.f238820a.getContext().getResources();
        if (r108 != r106.f541317b) goto L78;
    L86:
        int r114 = R.color.ud_B300;
    L87:
        r109.setBackgroundColor(r113.getColor(r114));
        String r115 = this.f238820a.getContext().getString(R.string.Doc_List_template_shared_by_failed);
        int r116 = r210.getBottomLabelType();
        if (r116 != (-1)) goto L90;
        TextView r117 = this.f238826g;
        if (r117 == null) goto L157;
        r117.setVisibility(8);
    L157:
        this.f238820a.getLayoutParams().height = cu5.c.b(134);
        return;
    L90:
        if (r116 == 1) goto L132;
        if (r116 != 2) goto L94;
        TextView r118 = this.f238826g;
        if (r118 != null) goto L127;
        return;
    L127:
        if (r210.getCreateTime() <= 0) goto L130;
        r115 = xo5.a.c(this.f238820a.getContext(), R.string.Doc_List_template_custom_created_by_me_v2, "time", zu5.a.f(this.f238820a.getContext(), r210.getCreateTime() * ((long) 1000)));
    L130:
        r118.setText(r115);
        return;
    L94:
        if (r116 == 3) goto L113;
        if (r116 != 4) goto L97;
        TextView r119 = this.f238826g;
        if (r119 != null) goto L109;
        return;
    L109:
        if (r210.getUpdateTime() <= 0) goto L112;
        r115 = xo5.a.c(this.f238820a.getContext(), R.string.CreationMobile_Template_RecentlyUsedTime, "time", zu5.a.f(this.f238820a.getContext(), r210.getLastUsedTime() * ((long) 1000)));
    L112:
        r119.setText(r115);
        return;
    L97:
        if (r116 != 5) goto L169;
        TextView r120 = this.f238826g;
        if (r120 != null) goto L102;
        return;
    L102:
        if (r210.getUpdateTime() <= 0) goto L105;
        r115 = xo5.a.c(this.f238820a.getContext(), R.string.CreationMobile_Operation_CreatedonSomeTime, "time", zu5.a.f(this.f238820a.getContext(), r210.getUpdateTime() * ((long) 1000)));
    L105:
        r120.setText(r115);
        return;
    L169:
        return;
    L113:
        TextView r121 = this.f238826g;
        if (r121 != null) goto L116;
        return;
    L116:
        if (r210.getUserName().length() != 0) goto L118;
        r102 = true;
    L118:
        if (r102 == false) goto L120;
    L123:
        r121.setText(r115);
        return;
    L120:
        if (r210.getShareTime() <= 0) goto L123;
        r115 = xo5.a.c(this.f238820a.getContext(), R.string.Doc_List_template_custom_shared_by_v2, "share_name", r210.getUserName());
        goto L123
    L132:
        if (r210.getAuthorName().length() != 0) goto L134;
        r102 = true;
    L134:
        if (r102 == false) goto L136;
        String r122 = "";
    L137:
        TextView r123 = this.f238826g;
        if (r123 == null) goto L167;
        StringBuilder r124 = new StringBuilder();
        r124.append(r122);
        if (r210.getHeat() < 0) goto L153;
        long r125 = r210.getHeat();
        if (f238819q.contains(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()) == false) goto L149;
        if (r125 >= 10000) goto L147;
        String r126 = xo5.a.c(this.f238820a.getContext(), R.string.Doc_List_TemplateUseNUmber, "TemplateUsedPeople", String.valueOf(r125));
    L152:
        r115 = r126;
        goto L153
    L147:
        DecimalFormat r127 = new DecimalFormat("0.#");
        r127.setRoundingMode(RoundingMode.HALF_UP);
        r126 = xo5.a.c(this.f238820a.getContext(), R.string.LarkCCM_Template_Usedby10kPeople, "number", r127.format(Float.valueOf(r125 / 10000)));
        Intrinsics.checkNotNull(r126);
        goto L152
    L149:
        if (r125 >= 1000) goto L151;
        r126 = xo5.a.c(this.f238820a.getContext(), R.string.Doc_List_TemplateUseNUmber, "TemplateUsedPeople", String.valueOf(r125));
        goto L152
    L151:
        DecimalFormat r128 = new DecimalFormat("0.#");
        r128.setRoundingMode(RoundingMode.HALF_UP);
        r126 = xo5.a.c(this.f238820a.getContext(), R.string.LarkCCM_Template_Usedby10kPeople, "number", r128.format(Float.valueOf(r125 / 1000)));
        Intrinsics.checkNotNull(r126);
    L153:
        r124.append(r115);
        r123.setText(r124.toString());
        return;
    L167:
        return;
    L136:
        r122 = this.f238820a.getContext().getText(R.string.Doc_Doc_Author) + ": " + r210.getAuthorName() + " | ";
        goto L137
    L78:
        if (r108 != sbb.e.f541297h.f541317b) goto L81;
        r114 = R.color.ud_G300;
        goto L87
    L81:
        if (r108 != sbb.e.f541300k.f541317b) goto L83;
        r114 = R.color.ud_W300;
        goto L87
    L83:
        if (r108 != 8) goto L85;
        r114 = R.color.ud_P300;
        goto L87
    L85:
        int r129 = sbb.e.f541304o.f541317b;
        goto L86
    L59:
        if (r210.getName().length() <= 0) goto L61;
        boolean r130 = true;
    L62:
        if (r130 == false) goto L64;
        this.f238825f.setText(r210.getName());
        goto L74
    L64:
        TextView r131 = this.f238825f;
        int r132 = r210.getObjType();
        if (r132 != sbb.e.f541297h.f541317b) goto L68;
        int r133 = R.string.Doc_Contract_UntitledSheet;
    L73:
        r131.setText(r133);
        goto L74
    L68:
        if (r132 != sbb.e.f541300k.f541317b) goto L70;
        r133 = R.string.Doc_Contract_UntitledMindnote;
        goto L73
    L70:
        if (r132 != 8) goto L72;
        r133 = R.string.Doc_Contract_UntitledBitable;
        goto L73
    L72:
        r133 = R.string.Doc_Contract_UntitledDocument;
        goto L73
    L61:
        r130 = false;
        goto L62
    L54:
        this.f238824e.setVisibility(0);
        goto L55
    L37:
        if (r105 != sbb.e.f541297h.f541317b) goto L40;
        r107 = R.drawable.ud_icon_file_sheet_colorful;
        goto L52
    L40:
        if (r105 != sbb.e.f541300k.f541317b) goto L42;
        r107 = R.drawable.ud_icon_file_mindnote_colorful;
        goto L52
    L42:
        if (r105 != 8) goto L48;
        if (h.a(r210.getTemplateSource()) == false) goto L46;
        r107 = R.drawable.ud_icon_file_form_colorful;
        goto L52
    L46:
        r107 = R.drawable.ud_icon_file_bitable_colorful;
        goto L52
    L48:
        if (r105 != sbb.e.f541304o.f541317b) goto L50;
        r107 = R.drawable.ud_icon_file_docx_colorful;
        goto L52
    L30:
        r104 = false;
        goto L31
    L24:
        if (r210.getSource() == 2) goto L26;
        this.f238827h.setVisibility(8);
        goto L27
    L26:
        this.f238827h.setVisibility(0);
        this.f238827h.setOnClickListener(new l(r210, this, r211));
        this.f238827h.post(new m(this));
        goto L27
    L13:
        ImageView r134 = this.f238823d;
        r134.setTag(R.id.thumbnail_tag, r210.getObjToken());
        String r135 = r210.getCoverDownloadUrl();
        String r136 = r210.getCoverToken();
        if (r135.length() != 0) goto L16;
        boolean r137 = true;
    L17:
        if (r137 == false) goto L19;
        tt5.a.k("TemplateViewHolder2", "coverDownloadUrl is empty, join url by coverToken");
        r135 = "https://" + p.f540584u + "/space/api/box/stream/download/all/" + r136;
    L19:
        Glide.with(this.f238820a.getContext()).asBitmap().load(new BearGlideUrl(UriProtector.parse(r135).buildUpon().appendQueryParameter(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, FileInfoPuller.CALLER_EXPLORER).build().toString())).error(R.drawable.template_load_fail).transform(V3()).into(new b(this, r134, r210.getObjToken(), r210));
        goto L21
    L16:
        r137 = false;
        goto L17
    L9:
        this.f238823d.setPadding(cu5.c.b(6), cu5.c.b(4), cu5.c.b(6), 0);
        goto L11
    L5:
        r101 = 0.3f;
        goto L6
    }
}
