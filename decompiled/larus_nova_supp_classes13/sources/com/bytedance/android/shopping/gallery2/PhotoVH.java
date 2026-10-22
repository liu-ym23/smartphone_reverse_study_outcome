package com.bytedance.android.shopping.gallery2;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.utils.f;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.facebook.drawee.controller.BaseControllerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.b;
import u53.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/PhotoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoVH extends TransitionViewHolder {
    public final TransitionPhotoDraweeView a;
    public final ECStatusView b;
    public String c;

    public static final class a extends BaseControllerListener<Object> {
        public long a;
        public final /* synthetic */ PhotoVH b;

        public a(PhotoVH r1) {
            this.b = r1;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            ECStatusView r3 = this.b.b;
            r3.setVisibility(0);
            b r4 = r3.a;
            if (r4 == null) goto L6;
            r4.e();
            return;
        }

        public final void onSubmit(String r1, Object r2) {
            super.onSubmit(r1, r2);
            this.a = System.currentTimeMillis();
            this.b.b.c();
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            super.onFinalImageSet(r3, r4, r5);
            if (this.a > 0) goto L5;
        L7:
            this.b.b.a();
            return;
        L5:
            if (f.b == false) goto L7;
            t53.b r6 = t53.b.a;
            long r7 = System.currentTimeMillis() - this.a;
            int r0 = f.a;
            r6.getClass();
            g r8 = new g();
            r8.a = 1;
            r8.b = r7;
            r8.c = r0;
            r8.post(null, null);
            f.a = 0;
            goto L7
        }
    }

    public PhotoVH(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        TransitionPhotoDraweeView r0 = r4.findViewById(2131382247);
        this.a = r0;
        ECStatusView r1 = r4.findViewById(2131371035);
        this.b = r1;
        r1.a();
        r1.b(r4.getContext(), null, null);
        ImageExtensionsKt.D(r0, new r("ec_comment", "previewCell"));
        r0.setControllerListener(new a(this));
    }
}
