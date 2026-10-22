package com.bytedance.ee.bear.list.cover;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.n;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CoverLoader implements com.bytedance.ee.bear.list.cover.a {
    public static final Lazy<b0> a = null;
    public static final Lazy<String> b = null;
    public static final HashSet<String> c = null;

    public static final class a {
    }

    public static final class b implements RequestListener<Drawable> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ Function0<Unit> c;

        public b(String r1, Function0<Unit> r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
            tt5.a.e("CoverLoader", "loadCover onLoadFailed: " + du5.b.l(this.a), r1, false);
            Function0<Unit> r5 = this.b;
            if (r5 == null) goto L5;
            r5.invoke();
        L5:
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            Drawable r6 = (Drawable) r1;
            tt5.a.h("CoverLoader", "loadCover onResourceReady: " + du5.b.l(this.a));
            Function0<Unit> r7 = this.c;
            if (r7 == null) goto L7;
            r7.invoke();
            return false;
        L7:
            return false;
        }
    }

    public CoverLoader() {
    }

    static {
        a = LazyKt.lazy(CoverLoader$Companion$infoProvideService$2.INSTANCE);
        b = LazyKt.lazy(CoverLoader$Companion$apiDomain$2.INSTANCE);
        c = SetsKt.hashSetOf(new String[]{"jpg", "jpeg", "png", "bmp", "tif", "tiff", "svg", "raw", "gif", "ico", "heic", "heif", "webp"});
    }

    @Override // com.bytedance.ee.bear.list.cover.a
    public final String a(String r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "policy");
        return "https://" + ((String) b.getValue()) + "/space/api/box/stream/download/v2/cover/" + r3 + "?width=" + r5 + "&height=" + r4 + "&policy=" + r6;
    L5:
        e = move-exception;
        tt5.a.e("CoverLoader", "getCoverUrl error", e, false);
        return "";
    }

    public final String b(Context r13, ImageView r14, String r15, int r16, int r17, String r18, int r19) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "policy");
        return c(r13, r14, r15, r16, r17, r18, r19, AppCompatResources.getDrawable(r13, kac.a.b(2131254464)), AppCompatResources.getDrawable(r13, kac.a.b(2131254464)), null, null);
    }

    public static void d(Context r2, ImageView r3, String r4, int r5, Drawable r6, Drawable r7, Function0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_URL);
        tt5.a.h("CoverLoader", "loadCover from url: " + du5.b.l(r4) + ", cornerRadius: " + r5);
        RequestBuilder r10 = Glide.with(r2).load(new BearGlideUrl(r4));
        if (r6 == null) goto L5;
        RequestBuilder r11 = r10.placeholder(r6);
    L5:
        if (r7 == null) goto L7;
        RequestBuilder r12 = r10.error(r7);
    L7:
        RequestBuilder r13 = r10.listener(new b(r4, r9, r8));
        if (r5 <= 0) goto L13;
        int r14 = n.d(r5);
        if (r3.getScaleType() != ImageView.ScaleType.CENTER_CROP) goto L12;
        BaseRequestOptions r15 = r13.transform(new Transformation[]{new CenterCrop(), new RoundedCorners(r14)});
        Intrinsics.checkNotNull(r15);
        r13 = (RequestBuilder) r15;
        goto L13
    L12:
        BaseRequestOptions r16 = r13.transform(new RoundedCorners(r14));
        Intrinsics.checkNotNull(r16);
        r13 = (RequestBuilder) r16;
    L13:
        r13.into(r3);
    }

    public final String c(Context r15, ImageView r16, String r17, int r18, int r19, String r20, int r21, Drawable r22, Drawable r23, Function0<Unit> r24, Function0<Unit> r25) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r20, "policy");
        tt5.a.h("CoverLoader", "loadCover, token: " + du5.b.k(r17) + ", height: " + r18 + ", width: " + r19 + ", policy: " + r20 + ", cornerRadius: " + r21);
        String r13 = a(r17, r18, r19, r20);
        if (r16 == null) goto L11;
        if (r18 <= 0) goto L11;
        if (r19 <= 0) goto L11;
        if (TextUtils.isEmpty(r17) == true) goto L11;
        d(r15, r16, r13, r21, r22, r23, r24, r25);
        return r13;
    L11:
        tt5.a.e("CoverLoader", "loadCover param error", new IllegalArgumentException("invalid params: height=" + r18 + ", width=" + r19 + ", policy=" + r20), false);
        return r13;
    }
}
