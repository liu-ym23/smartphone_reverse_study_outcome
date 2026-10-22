package com.bytedance.ee.bear.templates;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.data.ThumbnailExtra;
import com.bytedance.ee.bear.thumbnail.LeftCropForView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.u;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u000267B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010%\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\b\u00104\u001a\u000205H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateViewHolder2;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "view", "Landroid/view/View;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", "createType", "", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/templates/LayoutType;I)V", "operationTagImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "thumbnailImg", "typeIcon", "templateNameTxt", "Landroid/widget/TextView;", "labelTxt", "moreIv", "topView", "showTemplate", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "deleteListener", "Lkotlin/Function0;", "displayMixture", "loadCover", "iv", "getCoverDownloadUrl", "", "coverDownloadUrl", "coverToken", "showTopColor", ResourceData.KEY_TYPE, "showMoreIv", "getShareSource", "showCustomPanel", "displayThumbnail", "loadThumbnail", "objToken", "thumbnailExtra", "Lcom/bytedance/ee/bear/templates/data/ThumbnailExtra;", "showTemplateIconAndName", "getTemplateBlankName", "objType", "showBottomLabel", "getUseDesStr", "heat", "", "getWHeatStr", "getKHeatStr", "getTransformation", "Lcom/bytedance/ee/bear/thumbnail/LeftCropForView;", "Companion", "ViewTarget", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateViewHolder2 extends ITemplateViewHolder {
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static int m;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public static final List<String> q = null;
    public final View a;
    public final LayoutType b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    public final View i;

    public static final class a {
    }

    public final class b extends SimpleTarget<Bitmap> {
        public final ImageView a;
        public final String b;
        public lt7.d c;
        public boolean d;
        public final RunnableC0181b e;
        public final a f;
        public final /* synthetic */ TemplateViewHolder2 g;

        public static final class a implements View.OnAttachStateChangeListener {
            public final /* synthetic */ b a;

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View r2) {
                Intrinsics.checkNotNullParameter(r2, "v");
            }

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View r2) {
                Intrinsics.checkNotNullParameter(r2, "v");
                b r3 = this.a;
                r3.a.removeCallbacks(r3.e);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.TemplateViewHolder2$b$b, reason: collision with other inner class name */
        public static final class RunnableC0181b implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0181b(b r1) {
                this.a = r1;
            }

            public final void a() {
                b r0 = this.a;
                if (r0.d == true) goto L11;
                int r1 = r0.g.b.getThumbnailSkeletonLayId();
                if (r0.g.b != LayoutType.TYPE_RECOMMEND2) goto L8;
                View r2 = r0.a;
            L9:
                lt7.d.a r3 = u.a(r2);
                r3.b = r1;
                r3.a(2131100549);
                r0.c = r3.b();
                return;
            L8:
                Object r4 = r0.a.getParent();
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
                r2 = (View) r4;
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

        public final void onLoadFailed(Drawable r5) {
            super/*com.bumptech.glide.request.target.BaseTarget*/.onLoadFailed(r5);
            this.d = true;
            tt5.a.d("TemplateViewHolder2", "onLoadFailed(): ");
            lt7.d r1 = this.c;     // Catch: Exception -> L8
            if (r1 == null) goto L6;
            r1.a();     // Catch: Exception -> L8
        L6:
            this.a.removeOnAttachStateChangeListener(this.f);     // Catch: Exception -> L8
        L11:
            if (Intrinsics.areEqual(this.a.getTag(2131388628), this.b) == false) goto L13;
            this.a.setScaleType(ImageView.ScaleType.CENTER);
            this.a.setImageDrawable(r5);
            return;
        L13:
            tt5.a.d("TemplateViewHolder2", "onResourceReady()... tag not equals");
            return;
        L8:
            e = move-exception;
            tt5.a.e("TemplateViewHolder2", "hideSkeletonAnim(): ", e, false);
            goto L11
        }

        public final void onLoadStarted(Drawable r4) {
            super/*com.bumptech.glide.request.target.BaseTarget*/.onLoadStarted(r4);
            this.a.postDelayed(this.e, 100);
            this.a.addOnAttachStateChangeListener(this.f);
        }

        public final void onResourceReady(Object r4, Transition r5) {
            Bitmap r6 = (Bitmap) r4;
            Intrinsics.checkNotNullParameter(r6, "resource");
            this.d = true;
            lt7.d r0 = this.c;     // Catch: Exception -> L8
            if (r0 == null) goto L6;
            r0.a();     // Catch: Exception -> L8
        L6:
            this.a.removeOnAttachStateChangeListener(this.f);     // Catch: Exception -> L8
        L11:
            if (Intrinsics.areEqual(this.a.getTag(2131388628), this.b) == false) goto L13;
            this.a.setImageBitmap(r6);
            return;
        L13:
            tt5.a.d("TemplateViewHolder2", "onResourceReady()... tag not equals");
            return;
        L8:
            e = move-exception;
            tt5.a.e("TemplateViewHolder2", "hideSkeletonAnim(): ", e, false);
            goto L11
        }

        public b(TemplateViewHolder2 r2, ImageView r3, String r4, TemplateV4 r5) {
            Intrinsics.checkNotNullParameter(r3, "destImg");
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r5, ThumbGlideUrl.SOURCE_TEMPLATE);
            this.g = r2;
            this.a = r3;
            this.b = r4;
            this.e = new RunnableC0181b(this);
            this.f = new a(this);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LayoutType.values().length];
            r0[LayoutType.TYPE_RECOMMEND2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class d implements RequestListener<Drawable> {
        public final /* synthetic */ TemplateViewHolder2 a;

        public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
            return true;
        }

        public d(TemplateViewHolder2 r1) {
            this.a = r1;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            this.a.c.setVisibility(0);
            ImageView r6 = this.a.c;
            r6.setImageDrawable((Drawable) r1);
            return true;
        }
    }

    static {
        int r0 = cu5.c.b(16);
        j = r0;
        int r1 = cu5.c.b(32);
        k = r1;
        int r2 = w0.a;
        int r3 = w0.b(eu5.b.a);
        l = r3;
        m = (((cu5.c.d() - r1) - r0) / r3) - cu5.c.b(12);
        n = cu5.c.b(89);
        o = cu5.c.b(128);
        p = cu5.c.b(76);
        q = CollectionsKt.listOf(new String[]{"zh", "ja"});
    }

    public final LeftCropForView V3() {
        LayoutType r0 = this.b;
        if (c.a[r0.ordinal()] != 1) goto L6;
        return new LeftCropForView(p, o);
    L6:
        return new LeftCropForView(n, m);
    }

    public TemplateViewHolder2(View r4, LayoutType r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "layoutType");
        super(r4);
        this.a = r4;
        this.b = r5;
        Context r6 = r4.getContext();
        if (com.bytedance.ee.util.ui.b.b(r6) == true) goto L5;
    L12:
        this.c = (ImageView) r4.findViewById(2131381558);
        this.d = (ImageView) r4.findViewById(2131388318);
        this.e = (ImageView) r4.findViewById(2131391756);
        this.f = (TextView) r4.findViewById(2131388319);
        this.g = (TextView) r4.findViewById(2131377094);
        this.h = (ImageView) r4.findViewById(2131380292);
        this.i = r4.findViewById(2131388353);
        return;
    L5:
        if ((r6 instanceof Activity) == false) goto L12;
        View r7 = ((Activity) r6).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L11:
        m = (((r7.getWidth() - k) - j) / l) - cu5.c.b(12);
        goto L12
    }

    @Override // com.bytedance.ee.bear.templates.ITemplateViewHolder
    public final void T3(TemplateV4 r24, Function0<Unit> r25) {
        Intrinsics.checkNotNullParameter(r24, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r25, "deleteListener");
        View r3 = this.a;
        if (r24.getEnable() == false) goto L5;
        float r4 = 1.0f;
    L6:
        r3.setAlpha(r4);
        boolean r5 = false;
        if (r24.isSceneTemplate() == false) goto L9;
        this.d.setPadding(0, 0, 0, 0);
    L11:
        if (r24.getDisplayType() != 2) goto L13;
        String r6 = r24.getObjToken();
        int r14 = r24.getObjType();
        ThumbnailExtra r11 = r24.getThumbnailExtra();
        ThumbGlideUrl r15 = new ThumbGlideUrl("", r11.getThumbnail(), r14, r11.getType(), r11.getDecryptKey(), "", ThumbGlideUrl.SOURCE_TEMPLATE, true, "v4.1", this.d);
        this.d.setTag(2131388628, r24.getObjToken());
        Glide.with(this.d.getContext()).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).transform(V3()).error(2131248373).load(r15).into(new b(this, this.d, r6, r24));
    L21:
        if (this.h != null) goto L24;
    L27:
        this.c.setVisibility(8);
        if (r24.getOperationalLabelV2().length() <= 0) goto L30;
        boolean r2 = true;
    L31:
        if (r2 == false) goto L33;
        Glide.with(this.a.getContext()).load(new BearGlideUrl(r24.getOperationalLabelV2())).centerInside().addListener(new d(this)).override(cu5.c.b(100), cu5.c.b(14)).into(this.c);
    L33:
        int r7 = r24.getObjType();
        sbb.e r8 = sbb.e.g;
        if (r7 != r8.b) goto L37;
    L50:
        int r9 = 2131254431;
    L52:
        if (r24.isSceneTemplate() == false) goto L54;
        this.e.setVisibility(8);
    L55:
        this.e.setImageResource(kac.a.b(r9));
        mbb.c.d(this.e, r24.getObjToken(), r24.getObjType(), r24.getIcon(), IconShape.SQUARE, new obb.a(IconScene.TEMPLATE));
        if (r24.isCipherInvalid() == false) goto L59;
        this.f.setText(this.a.getContext().getString(2131887110));
    L74:
        int r10 = r24.getObjType();
        View r12 = this.i;
        Resources r13 = this.a.getContext().getResources();
        if (r10 != r8.b) goto L78;
    L86:
        int r16 = 2131108615;
    L87:
        r12.setBackgroundColor(r13.getColor(r16));
        String r17 = this.a.getContext().getString(2131888015);
        int r18 = r24.getBottomLabelType();
        if (r18 != (-1)) goto L90;
        TextView r1 = this.g;
        if (r1 == null) goto L157;
        r1.setVisibility(8);
    L157:
        this.a.getLayoutParams().height = cu5.c.b(134);
        return;
    L90:
        if (r18 == 1) goto L132;
        if (r18 != 2) goto L94;
        TextView r19 = this.g;
        if (r19 != null) goto L127;
        return;
    L127:
        if (r24.getCreateTime() <= 0) goto L130;
        r17 = xo5.a.c(this.a.getContext(), 2131888013, SheetInputData.InputData.DateType.TIME, zu5.a.f(this.a.getContext(), r24.getCreateTime() * ((long) CCMLynxCardView.ViewType.BANNER)));
    L130:
        r19.setText(r17);
        return;
    L94:
        if (r18 == 3) goto L113;
        if (r18 != 4) goto L97;
        TextView r20 = this.g;
        if (r20 != null) goto L109;
        return;
    L109:
        if (r24.getUpdateTime() <= 0) goto L112;
        r17 = xo5.a.c(this.a.getContext(), 2131887442, SheetInputData.InputData.DateType.TIME, zu5.a.f(this.a.getContext(), r24.getLastUsedTime() * ((long) CCMLynxCardView.ViewType.BANNER)));
    L112:
        r20.setText(r17);
        return;
    L97:
        if (r18 != 5) goto L169;
        TextView r21 = this.g;
        if (r21 != null) goto L102;
        return;
    L102:
        if (r24.getUpdateTime() <= 0) goto L105;
        r17 = xo5.a.c(this.a.getContext(), 2131887353, SheetInputData.InputData.DateType.TIME, zu5.a.f(this.a.getContext(), r24.getUpdateTime() * ((long) CCMLynxCardView.ViewType.BANNER)));
    L105:
        r21.setText(r17);
        return;
    L169:
        return;
    L113:
        TextView r22 = this.g;
        if (r22 != null) goto L116;
        return;
    L116:
        if (r24.getUserName().length() != 0) goto L118;
        r5 = true;
    L118:
        if (r5 == false) goto L120;
    L123:
        r22.setText(r17);
        return;
    L120:
        if (r24.getShareTime() <= 0) goto L123;
        r17 = xo5.a.c(this.a.getContext(), 2131888014, "share_name", r24.getUserName());
        goto L123
    L132:
        if (r24.getAuthorName().length() != 0) goto L134;
        r5 = true;
    L134:
        if (r5 == false) goto L136;
        String r23 = "";
    L137:
        TextView r26 = this.g;
        if (r26 == null) goto L167;
        StringBuilder r27 = new StringBuilder();
        r27.append(r23);
        if (r24.getHeat() < 0) goto L153;
        long r28 = r24.getHeat();
        if (q.contains(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()) == false) goto L149;
        if (r28 >= 10000) goto L147;
        String r29 = xo5.a.c(this.a.getContext(), 2131888001, "TemplateUsedPeople", String.valueOf(r28));
    L152:
        r17 = r29;
        goto L153
    L147:
        DecimalFormat r30 = new DecimalFormat("0.#");
        r30.setRoundingMode(RoundingMode.HALF_UP);
        r29 = xo5.a.c(this.a.getContext(), 2131889776, SheetInputData.InputData.FormatType.NUMBER, r30.format(Float.valueOf(r28 / 10000)));
        Intrinsics.checkNotNull(r29);
        goto L152
    L149:
        if (r28 >= 1000) goto L151;
        r29 = xo5.a.c(this.a.getContext(), 2131888001, "TemplateUsedPeople", String.valueOf(r28));
        goto L152
    L151:
        DecimalFormat r31 = new DecimalFormat("0.#");
        r31.setRoundingMode(RoundingMode.HALF_UP);
        r29 = xo5.a.c(this.a.getContext(), 2131889776, SheetInputData.InputData.FormatType.NUMBER, r31.format(Float.valueOf(r28 / CCMLynxCardView.ViewType.BANNER)));
        Intrinsics.checkNotNull(r29);
    L153:
        r27.append(r17);
        r26.setText(r27.toString());
        return;
    L167:
        return;
    L136:
        r23 = this.a.getContext().getText(2131887654) + ": " + r24.getAuthorName() + " | ";
        goto L137
    L78:
        if (r10 != sbb.e.h.b) goto L81;
        r16 = 2131108649;
        goto L87
    L81:
        if (r10 != sbb.e.k.b) goto L83;
        r16 = 2131108846;
        goto L87
    L83:
        if (r10 != 8) goto L85;
        r16 = 2131108764;
        goto L87
    L85:
        int r32 = sbb.e.o.b;
        goto L86
    L59:
        if (r24.getName().length() <= 0) goto L61;
        boolean r33 = true;
    L62:
        if (r33 == false) goto L64;
        this.f.setText(r24.getName());
        goto L74
    L64:
        TextView r34 = this.f;
        int r35 = r24.getObjType();
        if (r35 != sbb.e.h.b) goto L68;
        int r36 = 2131887643;
    L73:
        r34.setText(r36);
        goto L74
    L68:
        if (r35 != sbb.e.k.b) goto L70;
        r36 = 2131887642;
        goto L73
    L70:
        if (r35 != 8) goto L72;
        r36 = 2131887639;
        goto L73
    L72:
        r36 = 2131887640;
        goto L73
    L61:
        r33 = false;
        goto L62
    L54:
        this.e.setVisibility(0);
        goto L55
    L37:
        if (r7 != sbb.e.h.b) goto L40;
        r9 = 2131254696;
        goto L52
    L40:
        if (r7 != sbb.e.k.b) goto L42;
        r9 = 2131254561;
        goto L52
    L42:
        if (r7 != 8) goto L48;
        if (h.a(r24.getTemplateSource()) == false) goto L46;
        r9 = 2131254460;
        goto L52
    L46:
        r9 = 2131254400;
        goto L52
    L48:
        if (r7 != sbb.e.o.b) goto L50;
        r9 = 2131254436;
        goto L52
    L30:
        r2 = false;
        goto L31
    L24:
        if (r24.getSource() == 2) goto L26;
        this.h.setVisibility(8);
        goto L27
    L26:
        this.h.setVisibility(0);
        this.h.setOnClickListener(new l(r24, this, r25));
        this.h.post(new m(this));
        goto L27
    L13:
        ImageView r37 = this.d;
        r37.setTag(2131388628, r24.getObjToken());
        String r38 = r24.getCoverDownloadUrl();
        String r39 = r24.getCoverToken();
        if (r38.length() != 0) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == false) goto L19;
        tt5.a.k("TemplateViewHolder2", "coverDownloadUrl is empty, join url by coverToken");
        r38 = "https://" + p.u + "/space/api/box/stream/download/all/" + r39;
    L19:
        Glide.with(this.a.getContext()).asBitmap().load(new BearGlideUrl(UriProtector.parse(r38).buildUpon().appendQueryParameter("mount_point", "explorer").build().toString())).error(2131248373).transform(V3()).into(new b(this, r37, r24.getObjToken(), r24));
        goto L21
    L16:
        r110 = false;
        goto L17
    L9:
        this.d.setPadding(cu5.c.b(6), cu5.c.b(4), cu5.c.b(6), 0);
        goto L11
    L5:
        r4 = 0.3f;
        goto L6
    }
}
