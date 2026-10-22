package com.larus.image.loader;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.common.apphost.AppHost;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.nova.R;
import com.larus.platform.api.f2;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f350967a = false;

    static {
        f350967a = AppHost.f326268a.isTestChannel();
    }

    public static final boolean c(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = y0.f(r100, "x-expires");
        if (r101 == null) goto L8;
        Long r102 = StringsKt.toLongOrNull(r101);
    L9:
        if (r102 != null) goto L11;
        String r103 = y0.f(r100, "biz_tag");
        com.larus.platform.service.g r104 = com.larus.platform.service.g.f365738a;
        JSONObject r105 = new JSONObject();
        r105.put("url", o0.a(y0.k(r100)));
        r105.put("biz_tag", o0.a(r103));
        Unit r106 = Unit.INSTANCE;
        r104.monitorEventForSlardar("image_expire_check", r105, null, null);
    L11:
        if (r102 != null) goto L13;
        return false;
    L13:
        if (r102.longValue() >= (AppHost.f326268a.getAppClock().currentTimeMillis() / ((long) 1000))) goto L17;
        return true;
    L17:
        return false;
    L8:
        r102 = null;
        goto L9
    }

    public static /* synthetic */ g e(String r100) {
        return d(r100, f2.f365106a.enableIndependentImageCache());
    }

    public static final g d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customCache");
        if (r101 == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r100, CacheHandlerBiz.BIZ_MEDIA_FRESCO_CACHE) == false) goto L8;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L26;
        if (f2.f365106a.n() == true) goto L18;
    L24:
        return null;
    L18:
        if (ImagePipelineFactory.hasBeenInitialized() == false) goto L24;
        HashMap<String, DiskCacheConfig> r103 = ImagePipelineFactory.getInstance().getImagePipelineConfig().getCustomImageDiskCacheConfigMap();
        if (r103 == null) goto L22;
        DiskCacheConfig r104 = r103.get(r100);
    L23:
        if (r104 != null) goto L26;
    L22:
        r104 = null;
    L26:
        return new g(r100, ImageRequest.CacheChoice.CUSTOM);
    L8:
        if (Intrinsics.areEqual(r100, CacheHandlerBiz.BIZ_IM_FRESCO_CACHE) == true) goto L13;
        if (Intrinsics.areEqual(r100, CacheHandlerBiz.BIZ_ACCOUNT_AVATAR_FRESCO_CACHE) == true) goto L13;
        r102 = false;
        goto L14
    }

    public static final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        monitor-enter(r100);
        r100.setTag(R.id.flow_sdk_fresco_view_bind_key, r101);     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static final Uri b(String r100, String r101, m r102) {
        Uri r103 = y0.i(r100);
        if (y0.d(r103) == true) goto L5;
        return r103;
    L5:
        boolean r104 = true;
        if (y0.f(r103, "biz_tag") == null) goto L8;
        boolean r105 = true;
    L10:
        if (f350967a == false) goto L31;
        if (r105 == true) goto L31;
        if (r101 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L31;
        StringBuilder r107 = new StringBuilder(">>>>debug check, bizTag cannot be empty!!!>>>>\ncall stack=");
        if (r102 == null) goto L28;
        StringBuilder r108 = new StringBuilder("[");
        List<StackTraceElement> r109 = r102.f350988f;
        if (r109 == null) goto L27;
        Iterator r110 = ((ArrayList) r109).iterator();
    L25:
        if (r110.hasNext() == false) goto L27;
        StackTraceElement r111 = (StackTraceElement) r110.next();
        r108.append("\n");
        r108.append(r111.toString());
    L27:
        r108.append("\n]");
        String r112 = r108.toString();
    L29:
        r107.append(r112);
        throw new RuntimeException(r107.toString());
    L28:
        r112 = null;
        goto L29
    L14:
        if (r101.length() == 0) goto L17;
        r106 = false;
    L31:
        if (r105 == true) goto L41;
        if (r101 != null) goto L34;
    L37:
        if (r104 == false) goto L39;
        return r103;
    L39:
        return r103.buildUpon().appendQueryParameter("biz_tag", r101).build();
    L34:
        if (r101.length() == 0) goto L37;
        r104 = false;
        goto L37
    L41:
        return r103;
    L8:
        r105 = false;
        goto L10
    }

    public static Uri a(String r100, String r101, boolean r102, boolean r103, int r104) {
        boolean r105 = false;
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        Uri r106 = y0.j(r100);
        if (r106 != null) goto L11;
        return r106;
    L11:
        if (r101.length() != 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L17;
        return r106;
    L17:
        if (y0.d(r106) == true) goto L20;
        if (r103 == true) goto L20;
        return r106;
    L20:
        String r108 = y0.f(r106, "biz_tag");
        if (r108 != null) goto L23;
    L24:
        r105 = true;
    L25:
        if (r105 == true) goto L31;
        if (r102 == true) goto L29;
        return r106;
    L29:
        return y0.g(r106, "biz_tag", r101);
    L31:
        return y0.b(r106, "biz_tag", r101);
    L23:
        if (r108.length() != 0) goto L25;
    L13:
        r107 = false;
        goto L14
    }

    public static Object f(ImageRequest r100, Object r101, boolean r102, Bitmap.Config r103, ContinuationImpl r104, int r105) {
        if ((r105 & 4) == 0) goto L5;
        CallerThreadExecutor r106 = CallerThreadExecutor.getInstance();
    L7:
        if ((r105 & 8) == 0) goto L10;
        r102 = false;
    L10:
        if ((r105 & 16) == 0) goto L12;
        r103 = null;
    L12:
        kotlinx.coroutines.j r107 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r104), 1);
        r107.C();
        DataSource<CloseableReference<CloseableImage>> r108 = Fresco.getImagePipeline().fetchDecodedImage(r100, r101);
        r107.i(new z(r108));
        r108.subscribe(new a0(r107, r102, r103), r106);
        Object r109 = r107.B();
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r104);
    L15:
        return r109;
    L5:
        r106 = null;
        goto L7
    }
}
