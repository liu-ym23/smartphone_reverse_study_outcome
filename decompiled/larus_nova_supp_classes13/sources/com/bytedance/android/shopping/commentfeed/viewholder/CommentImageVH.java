package com.bytedance.android.shopping.commentfeed.viewholder;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentImageVH;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentImageVH extends CommentBaseViewHolder {
    public final View b;
    public final SimpleDraweeView c;
    public final DoubleColorBallStatusView d;
    public final a e;

    public static final class a implements ControllerListener<ImageInfo> {
        public final /* synthetic */ CommentImageVH a;

        public final void onFailure(String r1, Throwable r2) {
        }

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onSubmit(String r1, Object r2) {
        }

        public a(CommentImageVH r1) {
            this.a = r1;
        }

        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
            ImageInfo r3 = (ImageInfo) r2;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            this.a.d.a();
        }
    }

    public CommentImageVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super(r2);
        this.b = r2.findViewById(2131370531);
        this.c = r2.findViewById(2131370635);
        this.d = r2.findViewById(2131370615);
        this.e = new a(this);
    }
}
