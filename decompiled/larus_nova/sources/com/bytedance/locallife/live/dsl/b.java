package com.bytedance.locallife.live.dsl;

import android.graphics.Bitmap;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.bytedance.locallife.live.experiment.k0;
import com.bytedance.mt.protector.impl.UriProtector;
import df6.q;
import df6.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements GXRegisterCenterApi.GXImageLoader {

    public static final class a extends hf6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GXRegisterCenterApi.GXImageDownloadCallback f259420a;

        public a(GXRegisterCenterApi.GXImageDownloadCallback r100) {
            this.f259420a = r100;
        }

        @Override // hf6.i
        public final void onCompleted(Bitmap r100) {
            if (r100 == null) goto L4;
            this.f259420a.onSuccess(r100);
            return;
        L4:
            this.f259420a.onError();
        }

        @Override // hf6.i
        public final void onFailed(Throwable r100) {
            this.f259420a.onError();
        }
    }

    public b() {
    }

    @Override // com.alibaba.gaiax.api.GXRegisterCenterApi.GXImageLoader
    public final void loadImage(String r100, GXRegisterCenterApi.GXImageDownloadCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        Intrinsics.checkNotNullParameter(r101, "callback");
        int r102 = com.bytedance.locallife.live.util.d.f260695a;
        Bitmap r103 = com.bytedance.locallife.live.util.d.a(UriProtector.parse(r100));
        if (k0.a() == false) goto L8;
        if (r103 == null) goto L8;
        if (r103.isRecycled() == true) goto L8;
        r101.onSuccess(r103);
        return;
    L8:
        u r104 = q.e(r100);
        if (k0.a() == false) goto L11;
        r104.f468287m = Bitmap.Config.ARGB_8888;
    L11:
        r104.e(new a(r101));
    }
}
