package com.larus.community.impl.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.e1;
import com.larus.utils.w0;
import com.lynx.tasm.LynxError;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001IB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JJ\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0017H\u0002J\u001a\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010)\u001a\u00020'2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002JK\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010\u001b2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105J<\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>0=2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020>2\u0006\u0010B\u001a\u00020CH\u0002J\u0015\u0010E\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "waterMarkIcon", "Landroid/widget/ImageView;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconTemplate", "textView", "Landroid/widget/TextView;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getImageInfo", "Lcom/larus/platform/api/ImageInfo;", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "resetTemplateIcon", "", "creationFeedType", "", "bindData", "position", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "handleIconTemplate", "handleDownLoadIcon", "userCreation", "shouldUseProfileSelfNoWatermarkThumb", "", "imageInfo", "shouldUseProfileSelfNoWatermark", "shouldUseCreationFeedArgb", "config", "Lcom/larus/platform/model/chat/CreationPreviewPerformanceOptConfig;", "buildCreationFeedCoverSrPostProcessor", "Lcom/bytedance/fresco/sr/SRPostProcessor;", "sourceWidth", "sourceHeight", "targetWidth", "targetHeight", "enableFeedArgb", "isReviewBan", "(Lcom/larus/platform/model/chat/CreationPreviewPerformanceOptConfig;Ljava/lang/Integer;Ljava/lang/Integer;IIZZ)Lcom/bytedance/fresco/sr/SRPostProcessor;", "createSrFallbackBitmap", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "sourceBitmap", "bitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "extraMap", "", "", LynxError.LYNX_THROWABLE, "", "selectCreationFeedCoverSrScaleType", "scaleRatio", "", "selectCreationFeedCoverSrScaleTypeName", "toPositiveInt", "", "(Ljava/lang/Long;)Ljava/lang/Integer;", "onViewRecycled", "CreationFeedCoverSrTraceReporter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreationImageViewHolder extends RecyclerView.ViewHolder implements zp9.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f329966h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonDownLoadLayout f329967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f329968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f329969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f329970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f329971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CommonAuthorInfoLayout f329972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LifecycleCoroutineScope f329973g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f329974a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicInteger f329975b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AtomicInteger f329976c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f329977d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final AtomicInteger f329978e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final AtomicInteger f329979f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final AtomicInteger f329980g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AtomicInteger f329981h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final AtomicInteger f329982i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final AtomicInteger f329983j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final AtomicInteger f329984k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final AtomicInteger f329985l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final AtomicInteger f329986m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final AtomicInteger f329987n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final AtomicInteger f329988o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final AtomicInteger f329989p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final AtomicInteger f329990q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final AtomicInteger f329991r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final AtomicBoolean f329992s = null;

        public a() {
        }

        static {
            f329974a = new a();
            f329975b = new AtomicInteger();
            f329976c = new AtomicInteger();
            f329977d = new AtomicInteger();
            f329978e = new AtomicInteger();
            f329979f = new AtomicInteger();
            f329980g = new AtomicInteger();
            f329981h = new AtomicInteger();
            f329982i = new AtomicInteger();
            f329983j = new AtomicInteger();
            f329984k = new AtomicInteger();
            f329985l = new AtomicInteger();
            f329986m = new AtomicInteger();
            f329987n = new AtomicInteger();
            f329988o = new AtomicInteger();
            f329989p = new AtomicInteger();
            f329990q = new AtomicInteger();
            f329991r = new AtomicInteger();
            f329992s = new AtomicBoolean(false);
        }

        public static void a() {
            int r100 = f329975b.getAndSet(0);
            int r101 = f329976c.getAndSet(0);
            int r102 = f329977d.getAndSet(0);
            if (r100 > 0) goto L15;
            if (r102 > 0) goto L15;
            return;
        L15:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
            by7.a r104 = new by7.a("creation_feed_cover_sr_trace");     // Catch: Throwable -> L8
            r104.d("request_count", Integer.valueOf(r100));     // Catch: Throwable -> L8
            r104.d("postprocessor_created_count", Integer.valueOf(r101));     // Catch: Throwable -> L8
            r104.d("process_triggered_count", Integer.valueOf(r102));     // Catch: Throwable -> L8
            r104.d("process_success_count", Integer.valueOf(f329978e.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("process_fallback_count", Integer.valueOf(f329979f.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("process_error_count", Integer.valueOf(f329980g.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("skip_argb_disable_count", Integer.valueOf(f329981h.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("skip_review_ban_count", Integer.valueOf(f329982i.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("skip_invalid_source_count", Integer.valueOf(f329983j.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("skip_invalid_target_count", Integer.valueOf(f329984k.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("skip_scale_too_small_count", Integer.valueOf(f329985l.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("scale_type_1_1_count", Integer.valueOf(f329986m.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("scale_type_1_2_count", Integer.valueOf(f329987n.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("scale_type_1_3_count", Integer.valueOf(f329988o.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("scale_type_1_4_count", Integer.valueOf(f329989p.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("scale_type_1_5_count", Integer.valueOf(f329990q.getAndSet(0)));     // Catch: Throwable -> L8
            r104.d("scale_type_2_count", Integer.valueOf(f329991r.getAndSet(0)));     // Catch: Throwable -> L8
            r104.b();     // Catch: Throwable -> L8
            Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
            if (r106 == null) goto L17;
            boolean r107 = m29.a.f511679a;
            m29.a.b("CreationImageViewHolder", "report feed cover sr trace error: " + r106.getLocalizedMessage());
            return;
        L17:
            return;
        L8:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public static void d() {
            if ((f329975b.get() + f329977d.get()) >= 50) goto L5;
            return;
        L5:
            AtomicBoolean r100 = f329992s;
            if (r100.compareAndSet(false, true) == true) goto L14;
            return;
        L14:
            a();     // Catch: Throwable -> L11
            r100.set(false);
            return;
        L11:
            th = move-exception;
            f329992s.set(false);
            throw th;
        }

        public static void b(String r100, boolean r101) {
            f329977d.incrementAndGet();
            if (r101 == false) goto L6;
            f329980g.incrementAndGet();
        L9:
            d();
            return;
        L6:
            if (Intrinsics.areEqual(r100, "0") == false) goto L8;
            f329978e.incrementAndGet();
            goto L9
        L8:
            f329979f.incrementAndGet();
            goto L9
        }

        public static void c(a r100, String r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.getClass();
            f329975b.incrementAndGet();
            if (r101 != null) goto L11;
            f329976c.incrementAndGet();
            if (r102 == null) goto L63;
            int r104 = r102.hashCode();
            if (r104 == (-1805472659)) goto L60;
            switch(r104) {
                case 107564318: goto L56;
                case 107564319: goto L52;
                case 107564320: goto L48;
                case 107564321: goto L44;
                case 107564322: goto L40;
                default: goto L63;
            };
        L40:
            if (r102.equals("TYPE_1_5") == false) goto L63;
            f329990q.incrementAndGet();
            goto L63
        L44:
            if (r102.equals("TYPE_1_4") == false) goto L63;
            f329989p.incrementAndGet();
            goto L63
        L48:
            if (r102.equals("TYPE_1_3") == false) goto L63;
            f329988o.incrementAndGet();
            goto L63
        L52:
            if (r102.equals("TYPE_1_2") == false) goto L63;
            f329987n.incrementAndGet();
            goto L63
        L56:
            if (r102.equals("TYPE_1_1") == false) goto L63;
            f329986m.incrementAndGet();
            goto L63
        L60:
            if (r102.equals("TYPE_2") == false) goto L63;
            f329991r.incrementAndGet();
        L63:
            d();
            return;
        L11:
            switch(r101.hashCode()) {
                case -1937450585: goto L30;
                case -1895811416: goto L26;
                case -170811549: goto L22;
                case -155211559: goto L18;
                case 873729653: goto L14;
                default: goto L63;
            };
        L14:
            if (r101.equals("argb_disable") == false) goto L63;
            f329981h.incrementAndGet();
            goto L63
        L18:
            if (r101.equals("invalid_target") == false) goto L63;
            f329984k.incrementAndGet();
            goto L63
        L22:
            if (r101.equals("invalid_source") == false) goto L63;
            f329983j.incrementAndGet();
            goto L63
        L26:
            if (r101.equals("review_ban") == false) goto L63;
            f329982i.incrementAndGet();
            goto L63
        L30:
            if (r101.equals("scale_too_small") == false) goto L63;
            f329985l.incrementAndGet();
            goto L63
        }
    }

    public static final class b extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f329993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Integer> f329994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CreationImageViewHolder f329995c;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            m29.a.c("CreationImageViewHolder", "cover image failed");
            super.onFailure(r100, r101);
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            super.onSubmit(r100, r101);
        }

        public b(boolean r100, Ref.ObjectRef<Integer> r101, CreationImageViewHolder r102) {
            this.f329993a = r100;
            this.f329994b = r101;
            this.f329995c = r102;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, r101, r102);
            boolean r103 = r0.f330105a;
            if (r0.f330105a == true) goto L5;
            return;
        L5:
            if (this.f329993a == false) goto L7;
            return;
        L7:
            if (this.f329994b.element == null) goto L12;
            e1.x(this.f329995c.f329968b);
            return;
        }
    }

    @Override // zp9.q
    public final void onViewRecycled() {
        this.f329967a.onDestroy();
    }

    public CreationImageViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f329967a = (CommonDownLoadLayout) r100.findViewById(R.id.download_icon);
        this.f329968b = (ImageView) r100.findViewById(R.id.water_mark_icon);
        this.f329969c = (SimpleDraweeView) r100.findViewById(R.id.item_image);
        View r101 = r100.findViewById(R.id.icon_do_same_style);
        ICommunityService.Companion r102 = ICommunityService.f328743a;
        if (r102.f1().e() != 0) goto L5;
        r101.setBackgroundResource(R.drawable.larus_bg_same_template_button);
    L6:
        this.f329970d = r101;
        TextView r103 = (TextView) r100.findViewById(R.id.do_same_style_text);
        if (r102.f1().e() != 0) goto L9;
        r103.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.larus_static_white));
    L10:
        this.f329971e = r103;
        this.f329972f = (CommonAuthorInfoLayout) r100.findViewById(R.id.layout_author_info);
        w0.e(r100, i5.Y());
        return;
    L9:
        r103.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.larus_static_black));
        goto L10
    L5:
        r101.setBackgroundResource(R.drawable.larus_bg_same_template_new_button);
        goto L6
    }

    public static Integer W3(Long r100) {
        long r101 = r100.longValue();
        if (1 <= r101) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L12;
        r100 = null;
    L12:
        if (r100 != null) goto L14;
        return null;
    L14:
        return Integer.valueOf((int) r100.longValue());
    L5:
        if (r101 >= com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_RESERVE_BYTES) goto L7;
        r102 = true;
        goto L9
    }

    public ImageInfo V3(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "creation");
        UserCreationContent r101 = r100.f364991e;
        if (r101 == null) goto L7;
        UserCreationImage r102 = r101.f365006a;
        if (r102 == null) goto L7;
        return r102.f365014a;
    L7:
        return null;
    }

    public static final CloseableReference T3(CreationImageViewHolder r100, Bitmap r101, PlatformBitmapFactory r102, Map r103, Throwable r104) {
        r100.getClass();
        if (r104 == null) goto L6;
        String r105 = r104.getLocalizedMessage();
        if (r105 == null) goto L6;
    L12:
        if (r103.containsKey("sr_status") == true) goto L15;
        r103.put("sr_status", "1");
    L15:
        if (r103.containsKey("sr_err") == true) goto L17;
        r103.put("sr_err", r105);
    L17:
        boolean r106 = m29.a.f511679a;
        m29.a.b("CreationImageViewHolder", "[feed_cover_sr_process_fallback] srError=" + r105 + ", srExtra=" + r103);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L20
        Object r108 = Result.m9449constructorimpl(r102.createBitmap(r101));     // Catch: Throwable -> L20
    L22:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L25;
        boolean r110 = m29.a.f511679a;
        m29.a.b("CreationImageViewHolder", "[feed_cover_sr_process_fallback_failed] " + r109.getLocalizedMessage());
        if (r104 == null) goto L29;
        throw r104;
    L29:
        throw r109;
    L25:
        return (CloseableReference) r108;
    L20:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L6:
        if (r104 == null) goto L8;
        r105 = r104.getClass().getSimpleName();
    L9:
        if (r105 != null) goto L12;
        r105 = "process_error";
        goto L12
    L8:
        r105 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36, types: [T, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r1v51 */
    public void U3(int r210, final UserCreation r211, final int r212, g29.i r213, LifecycleCoroutineScope r214, @CreationFeedType int r215, zp9.f r216) {
        if (r211 != null) goto L5;
        return;
    L5:
        this.f329973g = r214;
        if (r215 == 1) goto L8;
    L10:
        if (r215 == 1) goto L13;
        if (r215 == 2) goto L13;
        e1.x(this.f329970d);
        e1.o(this.f329967a);
    L15:
        if (this.f329967a.getVisibility() != 0) goto L17;
        boolean r100 = true;
    L19:
        if (r100 == false) goto L36;
        ImageInfo r101 = V3(r211);
        if (r101 == null) goto L36;
        Image r102 = r101.f364798a;
        if (r102 == null) goto L36;
        String r103 = r102.f364791a;
        if (r103 == null) goto L36;
        if (r103.length() <= 0) goto L30;
        boolean r104 = true;
    L31:
        if (r104 == true) goto L34;
        r103 = null;
    L34:
        if (r103 == null) goto L36;
        this.f329967a.S5(this.f329973g, new com.larus.bmhome.bigimg.download.d.a(r103));
        goto L36
    L30:
        r104 = false;
    L36:
        z2 r105 = z2.f365865a;
        if (r105.m() == true) goto L39;
    L62:
        e1.o(this.f329970d);
    L63:
        ImageInfo r106 = V3(r211);
        if (CollectionsKt.listOf(new Integer[]{1, 2}).contains(Integer.valueOf(r215)) == true) goto L66;
    L68:
        boolean r107 = false;
    L69:
        if (r107 == false) goto L76;
        CreationNoWatermarkManager r108 = CreationNoWatermarkManager.f373832a;
        if (r108.D() == true) goto L73;
        boolean r109 = false;
    L74:
        if (r109 == false) goto L76;
        boolean r110 = true;
    L77:
        if (r110 == false) goto L81;
        if (r106 == null) goto L86;
        Image r111 = r106.f364799b;
    L87:
        Integer r112 = r211.f364989c;
        if (r112 != null) goto L91;
    L93:
        boolean r113 = false;
    L94:
        AuthorInfo r114 = r211.f364993g;
        if (r111 == null) goto L97;
        final Long r115 = Long.valueOf(r111.f364794d);
    L98:
        if (r111 == null) goto L100;
        final Long r116 = Long.valueOf(r111.f364793c);
    L101:
        boolean r117 = r0.f330105a;
        if (r116 == null) goto L104;
        Integer r118 = Integer.valueOf((int) r116.longValue());
    L105:
        if (r115 == null) goto L107;
        Integer r119 = Integer.valueOf((int) r115.longValue());
    L108:
        final int r120 = r0.b(r118, r119, r212, "CreationImageViewHolder" + r210);
        e1.o(this.f329968b);
        this.f329968b.setImageDrawable(null);
        final Ref.ObjectRef r121 = new Ref.ObjectRef();
        SimpleDraweeView r122 = this.f329969c;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        r123.height = r120;
        r122.setLayoutParams(r123);
        if (r0.f330105a == false) goto L129;
        float r124 = r212;
        if ((r124 / r120) <= 1.3f) goto L117;
        ImageView r125 = this.f329968b;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if (r126 == null) goto L115;
        r126.width = (int) (r124 / 6.0f);
    L116:
        r125.setLayoutParams(r126);
    L123:
        if (r105.u3() == false) goto L125;
        ?? r127 = Integer.valueOf(R.drawable.larus_community_watermark_doubao);
    L126:
        r121.element = r127;
        if (r127 == 0) goto L129;
        this.f329968b.setImageResource(r127.intValue());
        e1.q(this.f329968b);
        goto L129
    L125:
        r127 = 0;
        goto L126
    L115:
        r126 = null;
        goto L116
    L117:
        ImageView r128 = this.f329968b;
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
        if (r129 == null) goto L120;
        r129.width = (int) (r124 / 5.0f);
    L121:
        r128.setLayoutParams(r129);
        goto L123
    L120:
        r129 = null;
    L129:
        SimpleDraweeView r130 = this.f329969c;
        if (r113 == false) goto L132;
        String r131 = UriProtector.parse("res://" + AppHost.f326268a.getApplication().getPackageName() + "/2131240129").toString();
    L134:
        String r132 = r131;
    L136:
        final boolean r133 = r113;
        final boolean r134 = r110;
        ImageLoaderKt.y(r130, r132, "community_creation_photo", new m(this, r116, r115, r212, r120, r133, r134, r121), 4);
        if (r216 == null) goto L156;
        boolean r135 = r216.f573236p;
        Long r136 = r211.f364992f;
        if (r136 == null) goto L141;
        long r137 = r136.longValue();
    L142:
        CommonAuthorInfoLayout r138 = this.f329972f;
        if (r135 == false) goto L145;
        int r139 = 0;
    L146:
        r138.setVisibility(r139);
        CommonAuthorInfoLayout r140 = this.f329972f;
        if (r114 == null) goto L149;
        AuthorInfo r141 = r114;
        String r142 = r141.f364898c;
    L150:
        r140.a(r142, r0.a());
        CommonAuthorInfoLayout r143 = this.f329972f;
        if (r141 == null) goto L154;
        String r144 = r141.f364896a;
        if (r144 == null) goto L154;
    L155:
        r143.setAuthorName(r144);
        this.f329972f.setUseCount(r137);
        final int r145 = r210;
        final g29.i r146 = r213;
        e1.d(this.f329972f, new n(r146, r145));
        this.f329972f.setOnLongClickListener(new o(r146, this, r145));
        SimpleDraweeView r147 = this.f329969c;
        StringCompanionObject r148 = StringCompanionObject.INSTANCE;
        int r149 = com.larus.utils.j0.f375426a;
        boolean r150 = true;
        r147.setContentDescription(String.format(com.larus.utils.j0.d(R.string.larus_accessibility_creationFeed_photo), Arrays.copyOf(new Object[]{this.f329972f.getAuthorName(), this.f329972f.getUseCount()}, 2)));
    L157:
        this.itemView.setClickable(r150);
        e1.d(this.f329969c, new p(r146, r145));
        e1.d(this.f329970d, new q(r146, r145));
        e1.d(this.f329967a, new r(r146, r211, this));
        this.f329969c.setOnLongClickListener(new s(r146, this, r145, r211));
        Integer r151 = r211.f364989c;
        if (r151 != null) goto L161;
        return;
    L161:
        if (r151.intValue() != 5) goto L164;
        this.f329969c.setOnClickListener(null);
        this.f329972f.setOnClickListener(null);
        this.f329970d.setOnClickListener(null);
        this.f329967a.setOnClickListener(null);
        this.f329969c.setOnLongClickListener(null);
        this.f329972f.setOnClickListener(null);
        this.f329970d.setOnClickListener(null);
        this.f329967a.setOnClickListener(null);
        return;
    L164:
        return;
    L154:
        r144 = "";
        goto L155
    L149:
        r141 = r114;
        r142 = null;
        goto L150
    L145:
        r139 = 8;
        goto L146
    L141:
        r137 = 0;
        goto L142
    L156:
        r145 = r210;
        r146 = r213;
        r150 = true;
        e1.o(this.f329972f);
        goto L157
    L132:
        if (r111 == null) goto L135;
        r131 = r111.f364791a;
        goto L134
    L135:
        r132 = null;
        goto L136
    L107:
        r119 = null;
        goto L108
    L104:
        r118 = null;
        goto L105
    L100:
        r116 = null;
        goto L101
    L97:
        r115 = null;
        goto L98
    L91:
        if (r112.intValue() != 5) goto L93;
        r113 = true;
    L86:
        r111 = null;
        goto L87
    L81:
        if (r0.f330105a == false) goto L84;
        if (r106 == null) goto L86;
        r111 = r106.f364807j;
        goto L87
    L84:
        if (r106 == null) goto L86;
        r111 = r106.f364799b;
        goto L87
    L73:
        r109 = r108.y(CreationNoWatermarkManager.t0(r106));
    L76:
        r110 = false;
        goto L77
    L66:
        if (CreationNoWatermarkManager.f373832a.D() == false) goto L68;
        r107 = true;
        goto L69
    L39:
        if (r105.getCreationMakeSameConfigV2().b() == true) goto L62;
        if (this.f329970d.getVisibility() != 0) goto L44;
        boolean r152 = true;
    L45:
        if (r152 == false) goto L63;
        if (r211.b() == false) goto L50;
        this.f329971e.setText(R.string.larus_creation_tag_customize);
        goto L63
    L50:
        CreationDynamicInfo r153 = r211.f364994h;
        if (r153 == null) goto L53;
        String r154 = r153.f364913c;
    L55:
        if (com.larus.utils.o0.d(r154) == false) goto L61;
        TextView r155 = this.f329971e;
        CreationDynamicInfo r156 = r211.f364994h;
        if (r156 == null) goto L59;
        String r157 = r156.f364913c;
    L60:
        r155.setText(r157);
        goto L63
    L59:
        r157 = null;
        goto L60
    L61:
        this.f329971e.setText(R.string.larus_discoverTab_showcaseScreen_btn_try);
        goto L63
    L53:
        r154 = null;
        goto L55
    L44:
        r152 = false;
        goto L45
    L17:
        r100 = false;
    L13:
        e1.o(this.f329967a);
        e1.o(this.f329970d);
        goto L15
    L8:
        if (com.larus.bmhome.utils.u.b() == false) goto L10;
        e1.x(this.f329967a);
        this.f329967a.setDownloadIcon(R.drawable.larus_community_ic_download_icon);
        e1.o(this.f329970d);
        goto L15
    }
}
