package zi4;

import android.graphics.drawable.Animatable;
import com.bytedance.creativex.mediaimport.view.internal.viewholder.MediaSelectViewHolder;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ui4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaSelectViewHolder f572245a;

    public d(MediaSelectViewHolder r100) {
        this.f572245a = r100;
    }

    @Override // ui4.a
    public final void v0(String r100, Throwable r101, int r102) {
        if ((this.f572245a.getBindingAdapter() instanceof ui4.a) == false) goto L6;
        Object r103 = this.f572245a.getBindingAdapter();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.creativex.mediaimport.view.internal.bindhandler.IThumbnailLoaderListener");
        ((ui4.a) r103).v0(r100, r101, r102);
        return;
    }

    @Override // ui4.a
    public final void L1(String r110, ImageInfo r111, Animatable r112, int r113, long r114, String r115) {
        Intrinsics.checkNotNullParameter(r115, "uri");
        if ((this.f572245a.getBindingAdapter() instanceof ui4.a) == false) goto L6;
        Object r100 = this.f572245a.getBindingAdapter();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.creativex.mediaimport.view.internal.bindhandler.IThumbnailLoaderListener");
        ((ui4.a) r100).L1(r110, r111, r112, r113, r114, r115);
        return;
    }
}
