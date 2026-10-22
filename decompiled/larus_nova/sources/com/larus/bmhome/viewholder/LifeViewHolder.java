package com.larus.bmhome.viewholder;

import android.view.View;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.t1;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uo8.j;
import yt8.b;
import yt8.c;
import yt8.d;
import yt8.e;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010)\u001a\u00020\u001bH\u0016J\"\u0010*\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0,J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0016JV\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u0006\u00105\u001a\u00020\u0014H\u0016J\u001a\u00106\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00107\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0002J>\u00109\u001a\u00020\u001b2\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!H\u0002J\b\u0010=\u001a\u00020\u001bH\u0016J\b\u0010>\u001a\u00020\u001bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0006R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006?"}, d2 = {"Lcom/larus/bmhome/viewholder/LifeViewHolder;", "Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Lcom/larus/bmhome/viewholder/ITransitionHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "TAG", "", "selectionObserver", "Landroidx/lifecycle/Observer;", "", "unselectionObserver", "processView", "getProcessView", "()Landroid/view/View;", "setProcessView", "itemData", "Lcom/larus/bmhome/bigimg/MediaItem;", "uriUpdateListener", "Lcom/larus/bmhome/common_ui/image/OnUriUpdateListener;", "getUriUpdateListener", "()Lcom/larus/bmhome/common_ui/image/OnUriUpdateListener;", "setUriUpdateListener", "(Lcom/larus/bmhome/common_ui/image/OnUriUpdateListener;)V", "onImageLoadSuccessListener", "Lkotlin/Function1;", "", "getOnImageLoadSuccessListener", "()Lkotlin/jvm/functions/Function1;", "setOnImageLoadSuccessListener", "(Lkotlin/jvm/functions/Function1;)V", "onImageLongPressListener", "Lkotlin/Function0;", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "onDismiss", "observeSelection", "unselectedLiveData", "Landroidx/lifecycle/LiveData;", "selectedLiveData", "updateSelectionState", "selected", "", "realBindData", "imagePreviewDownloadUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "orNull", "updateListener", "bindMediaData", "setProgressUI", Keys.API_PARAM_KEY_MEDIA_INFO, "bindListeners", "imageLoadSuccessListener", "longPressListener", "scaleListener", "onFullyAttach", "onFullyDetach", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LifeViewHolder extends TransitionViewHolder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f317571j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f317572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f317573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f317574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t1 f317575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f317576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Integer, Unit> f317577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f317578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f317579i;

    public void V3() {
    }

    public void W3() {
    }

    public void Y3(boolean r100) {
    }

    public LifeViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f317574d = r100.findViewById(R.id.gallery_process);
        this.f317577g = new d();
    }

    public void U3(n1 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "imagePreviewDownloadUrl");
        t1 r102 = r100.f296031b;
        this.f317575e = r102;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.d() == false) goto L10;
        View r103 = this.f317574d;
        if (r103 == null) goto L14;
        e1.x(r103);
        return;
    L14:
        return;
    L10:
        View r104 = this.f317574d;
        if (r104 == null) goto L16;
        e1.o(r104);
        return;
    }

    public final void X3(n1 r100, String r101, Function1 r102, Function0 r103, Function0 r104, uo8.b r105) {
        Intrinsics.checkNotNullParameter(r100, "imagePreviewDownloadUrl");
        Intrinsics.checkNotNullParameter(r102, "onImageLoadSuccessListener");
        Intrinsics.checkNotNullParameter(r105, "updateListener");
        this.f317576f = r105;
        this.f317577g = r102;
        this.f317578h = r103;
        this.f317579i = r104;
        U3(r100, r101);
        T3().c(new e(this));
    }
}
