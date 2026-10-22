package com.larus.community.impl.share;

import android.graphics.Bitmap;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.m0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J$\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002J&\u0010$\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001aH\u0002J\u0006\u0010+\u001a\u00020\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/community/impl/share/SharePuzzleImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/LifecycleCoroutineScope;)V", "getLifecycleCoroutineScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "shadowLayout", "Lcom/larus/common_ui/widget/ShadowLayout;", "frescoCloseableHolder", "Lcom/larus/community/impl/share/FrescoCloseableHolder;", "currentResultBitmap", "Landroid/graphics/Bitmap;", "bindJob", "Lkotlinx/coroutines/Job;", "progressBar", "Landroid/widget/ProgressBar;", "itemWidth", "", "itemHeight", "bind", "", "shareImagePuzzleItem", "Lcom/larus/community/impl/share/ShareImagePuzzleItem;", "isCurrentBind", "", "closeableHolder", "isOwnedResultBitmap", "resultBitmap", "rawBitmap", "refBitmap", "recycleOwnedResultBitmap", "fetchBitmap", "url", "", "cacheKey", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/community/impl/share/FrescoCloseableHolder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupBitmaps", MapMonitorConst.EVENT_DESTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SharePuzzleImageItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f329796j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleCoroutineScope f329797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f329798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShadowLayout f329799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f329800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f329801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f329802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f329803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f329804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f329805i;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), i5.r0());
        }
    }

    public final void U3() {
        Job r100 = this.f329802f;
        final m r101 = this.f329800d;
        boolean r102 = true;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f329802f = null;
        this.f329800d = null;
        this.f329798b.setImageDrawable(null);
        if (r100 != null) goto L8;
    L10:
        r102 = false;
    L11:
        if (r102 == false) goto L13;
        r100.invokeOnCompletion(new s(r101));
    L15:
        this.f329801e = null;
        return;
    L13:
        if (r101 == null) goto L15;
        r101.b();
        goto L15
    L8:
        if (r100.isCompleted() == true) goto L10;
        goto L10
    }

    public SharePuzzleImageItemViewHolder(View r100, LifecycleCoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "lifecycleCoroutineScope");
        super(r100);
        this.f329797a = r101;
        AppCompatImageView r102 = (AppCompatImageView) r100.findViewById(R.id.share_puzzle_image_view);
        this.f329798b = r102;
        this.f329799c = (ShadowLayout) r100.findViewById(R.id.shadow_layout);
        this.f329803g = (ProgressBar) r100.findViewById(R.id.progress);
        this.f329804h = UIUtils.getScreenWidth(r100.getContext()) - i5.l0();
        int r103 = m0.f375450a;
        this.f329805i = (int) ((((double) m0.a(r100.getContext())) * 0.8d) - ((double) i5.P()));
        r102.setOutlineProvider(new a());
        r102.setClipToOutline(true);
    }

    public static final Object T3(SharePuzzleImageItemViewHolder r100, String r101, String r102, m r103, Continuation r104) {
        r100.getClass();
        if ((r104 instanceof SharePuzzleImageItemViewHolder$fetchBitmap$1) == false) goto L7;
        SharePuzzleImageItemViewHolder$fetchBitmap$1 r105 = (SharePuzzleImageItemViewHolder$fetchBitmap$1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        if (r109 == 0) goto L16;
        if (r109 != 1) goto L15;
        r103 = (m) r105.L$1;
        r102 = (String) r105.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Throwable -> L31
    L20:
        CloseableReference<CloseableImage> r110 = (CloseableReference) r107;     // Catch: Throwable -> L31
        if (r110 == null) goto L28;
        r103.a(r102, r110);     // Catch: Throwable -> L31
        CloseableImage r111 = r110.get();     // Catch: Throwable -> L31
        if ((r111 instanceof CloseableStaticBitmap) == false) goto L25;
        CloseableStaticBitmap r112 = (CloseableStaticBitmap) r111;     // Catch: Throwable -> L31
    L26:
        if (r112 == null) goto L28;
        Bitmap r113 = r112.getUnderlyingBitmap();     // Catch: Throwable -> L31
    L29:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L31
    L33:
        Object r115 = r114;
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L40;
        if ((r116 instanceof CancellationException) == false) goto L40;
        throw r116;
    L40:
        if (Result.m9455isFailureimpl(r115) == true) goto L42;
        return r115;
    L42:
        return null;
    L25:
        r112 = null;
    L28:
        r113 = null;
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r107);
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L31
        r105.L$0 = r102;     // Catch: Throwable -> L31
        r105.L$1 = r103;     // Catch: Throwable -> L31
        r105.label = 1;     // Catch: Throwable -> L31
        r107 = ImageLoaderKt.i(r101, "creation_share", null, r105, 60);     // Catch: Throwable -> L31
        if (r107 != r108) goto L20;
        return r108;
    L31:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r105 = new SharePuzzleImageItemViewHolder$fetchBitmap$1(r100, r104);
        goto L8
    }
}
