package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public static final LruCache<String, Bitmap> a = null;
    public static final LruCache<String, Bitmap> b = null;
    public static final LruCache<String, Bitmap> c = null;
    public static Bitmap d;
    public static Bitmap e;
    public static boolean f;

    public static final class a implements Postprocessor {
        public final /* synthetic */ Postprocessor a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Integer d;

        public final String getName() {
            return this.a.getName();
        }

        public final CacheKey getPostprocessorCacheKey() {
            return this.a.getPostprocessorCacheKey();
        }

        public final CloseableReference<Bitmap> process(Bitmap r5, PlatformBitmapFactory r6) {
            CloseableReference<Bitmap> r7 = this.a.process(r5, r6);
            Bitmap r8 = (Bitmap) r7.get();
            if (r8 != null) goto L5;
        L19:
            return r7;
        L5:
            if (com.bytedance.android.shopping.extensions.k.c(this.c) == false) goto L19;
            if (this.b != 0) goto L19;
            Integer r0 = this.d;
            if (r0 != null) goto L12;
        L16:
            Bitmap.Config r1 = r8.getConfig();
            if (r1 == null) goto L19;
            LruCache<String, Bitmap> r2 = l.a;
            Bitmap r9 = l.b.put(this.c, r8.copy(r1, false));
            goto L19
        L12:
            if (r0.intValue() != 0) goto L16;
            Bitmap.Config r3 = r8.getConfig();
            if (r3 == null) goto L16;
            LruCache<String, Bitmap> r4 = l.a;
            l.e = r8.copy(r3, false);
            goto L16
        }

        public a(IterativeBoxBlurPostProcessor r1, int r2, String r3, Integer r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public l() {
    }

    static {
        a = new LruCache(5);
        b = new LruCache(5);
        c = new LruCache(3);
    }

    public static /* synthetic */ void c(Integer r7, ECUrlModel r8, SimpleDraweeView r9, com.bytedance.android.ec.core.imagex.r r10) {
        b(r7, r8, 0, r9, r10, null, null);
    }

    public static void a(Integer r11, ECUrlModel r12, int r13, SimpleDraweeView r14, com.bytedance.android.ec.core.imagex.r r15, Bitmap r16) {
        Bitmap r1 = r16;
        Intrinsics.checkNotNullParameter(r14, "blurIV");
        if (f == true) goto L8;
        if (r1 == null) goto L6;
        r14.getHierarchy().setPlaceholderImage(new BitmapDrawable(r14.getResources(), r1));
    L6:
        h0.d(r14, r12, r15, null, null, h0.h(2), null, 88);
        return;
    L8:
        Bitmap r2 = null;
        if (r12 == null) goto L13;
        List r5 = r12.getUrlList();
        if (r5 == null) goto L13;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L14:
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L23;
        r2 = b.get(r6);
    L23:
        if (r2 != null) goto L29;
        if (r11 == null) goto L29;
        if (r11.intValue() != 0) goto L29;
        r2 = e;
    L29:
        if (r2 == null) goto L32;
        r1 = r2;
    L32:
        if (r1 == null) goto L35;
        r14.getHierarchy().setPlaceholderImage(new BitmapDrawable(r14.getResources(), r1));
        h0.d(r14, r12, r15, null, null, h0.h(2), null, 88);
        return;
    L35:
        h0.d(r14, r12, r15, null, null, new a(h0.h(2), r13, r6, r11), null, 88);
        return;
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
    L13:
        r6 = null;
        goto L14
    }

    public static void b(Integer r12, ECUrlModel r13, int r14, SimpleDraweeView r15, com.bytedance.android.ec.core.imagex.r r16, j r17, Bitmap r18) {
        Bitmap r2 = r18;
        Intrinsics.checkNotNullParameter(r15, FreqActions.ACTION_VIEW);
        if (f == true) goto L8;
        if (r2 == null) goto L6;
        r15.getHierarchy().setPlaceholderImage(new BitmapDrawable(r15.getResources(), r2));
    L6:
        h0.d(r15, r13, r16, null, null, null, r17, 24);
        return;
    L8:
        m r3 = null;
        if (r13 == null) goto L13;
        List r5 = r13.getUrlList();
        if (r5 == null) goto L13;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L14:
        boolean r7 = true;
        if (r6 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == false) goto L23;
        Bitmap r9 = null;
    L24:
        if (r9 != null) goto L27;
        r3 = new m(r14, r6, r12);
    L27:
        m r10 = r3;
        if (r14 != 0) goto L39;
        if (r6 != null) goto L31;
    L34:
        if (r7 == true) goto L39;
        Bitmap r1 = c.get(r6);
        if (r1 == null) goto L39;
        r9 = r1;
        goto L39
    L31:
        if (r6.length() == 0) goto L34;
        r7 = false;
    L39:
        if (r9 != null) goto L45;
        if (r12 == null) goto L45;
        if (r12.intValue() != 0) goto L45;
        r9 = d;
    L45:
        if (r9 == null) goto L48;
        r2 = r9;
    L48:
        if (r2 == null) goto L50;
        r15.getHierarchy().setPlaceholderImage(new BitmapDrawable(r15.getResources(), r2));
    L50:
        h0.d(r15, r13, r16, null, null, r10, r17, 24);
        return;
    L23:
        r9 = a.get(r6);
        goto L24
    L17:
        if (r6.length() == 0) goto L20;
        r8 = false;
    L13:
        r6 = null;
        goto L14
    }
}
