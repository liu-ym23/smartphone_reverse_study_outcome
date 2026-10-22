package fu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wu.n2;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f478832a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f478833b = null;

    public interface a {
        void a(String r100, Object r101, boolean r102, String r103);

        void b(String r100, ImageInfo r101, Animatable r102, long r103, boolean r104);

        void c(String r100, ImageInfo r101);

        void d(String r100, Throwable r101, long r102, boolean r103);

        void onIntermediateImageFailed(String r100, Throwable r101);

        void onRelease(String r100);
    }

    public static class b implements a {
        public b() {
        }

        @Override // fu.d.a
        public final void a(String r100, Object r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "imageUrl");
        }

        @Override // fu.d.a
        public final void c(String r100, ImageInfo r101) {
        }

        @Override // fu.d.a
        public final void d(String r100, Throwable r101, long r102, boolean r103) {
        }

        @Override // fu.d.a
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // fu.d.a
        public final void onRelease(String r100) {
        }
    }

    public static final class c extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f478834a;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            LocalTestManager.a(new Class[]{uv.a.class});
            this.f478834a.invoke(null, null);
            if (r100 == null) goto L6;
            r100.close();
            return;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
            LocalTestManager.a(new Class[]{uv.a.class});     // Catch: Throwable -> L20 Exception -> L22
            if (r100 != null) goto L7;
            return;
        L7:
            if (r100.isFinished() == true) goto L10;
            r100.close();
            return;
        L10:
            CloseableReference<PooledByteBuffer> r101 = r100.getResult();     // Catch: Throwable -> L20 Exception -> L22
            if (r101 == null) goto L14;
            PooledByteBuffer r102 = r101.get();     // Catch: Throwable -> L20 Exception -> L22
        L15:
            if (r102 != null) goto L18;
            r100.close();
            return;
        L18:
            PooledByteBufferInputStream r103 = new PooledByteBufferInputStream(r102);     // Catch: Throwable -> L20 Exception -> L22
            Rect r104 = new Rect();     // Catch: Throwable -> L20 Exception -> L22
            BitmapFactory.Options r105 = new BitmapFactory.Options();     // Catch: Throwable -> L20 Exception -> L22
            r105.inDensity = 640;     // Catch: Throwable -> L20 Exception -> L22
            r105.inTargetDensity = y0.d().densityDpi;     // Catch: Throwable -> L20 Exception -> L22
            this.f478834a.invoke(BitmapFactory.decodeStream(r103, r104, r105), r104);     // Catch: Throwable -> L20 Exception -> L22
        L24:
            r100.close();
            return;
        L14:
            r102 = null;
        L20:
            th = move-exception;
            if (r100 == null) goto L28;
            r100.close();
        L28:
            throw th;
        L22:
            LocalTestManager.a(new Class[]{uv.a.class});     // Catch: Throwable -> L20
            if (r100 != null) goto L24;
        }

        public c(ImageRequest r100, Function2 r101) {
            this.f478834a = r101;
        }
    }

    public d() {
    }

    static {
        if (Build.VERSION.SDK_INT <= 26) goto L5;
        boolean r100 = true;
    L6:
        f478832a = r100;
        f478833b = n2.f561356a.getValue();
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static String e(GameImageBundler r100) {
        Intrinsics.checkNotNullParameter(r100, "imageBundler");
        Integer r101 = f478833b;
        boolean r102 = true;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        if (r101 != null) goto L16;
    L18:
        String r103 = r100.getOriginImageUrl();
    L20:
        if (r103.length() == 0) goto L23;
        r102 = false;
    L23:
        if (r102 == true) goto L25;
        return r103;
    L25:
        return r100.getOriginImageUrl();
    L16:
        if (r101.intValue() != 2) goto L18;
        r103 = r100.getThumbHeifImageUrl();
        goto L20
    L11:
        if (r101.intValue() != 1) goto L13;
        r103 = r100.getThumbImageUrl();
        goto L20
    L6:
        if (r101.intValue() != 0) goto L8;
        r103 = r100.getOriginImageUrl();
        goto L20
    }

    public static g d(String r100, Map r101) {
        return new g(r100, null, r101);
    }

    public static void c(String r100, Priority r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "priority");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        ImageRequest r103 = fu.a.a(r100, null, r101, null, 26);
        ImagePipelineFactory.getInstance().getImagePipeline().fetchEncodedImage(r103, null).subscribe(new c(r103, r102), UiThreadImmediateExecutorService.getInstance());
    }

    public static void b(SimpleDraweeView r100, GameImageBundler r101, Priority r102, g r103) {
        Bitmap.Config r104 = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageBundler");
        Intrinsics.checkNotNullParameter(r102, "priority");
        if (r100.getContext() == null) goto L19;
        String r105 = e(r101);
        if (r105.length() != 0) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L20;
        ImageRequest r107 = fu.a.a(r105, null, r102, r104, 8);
        LocalTestManager.a(new Class[]{uv.a.class});
        boolean r108 = Fresco.getImagePipeline().isInBitmapMemoryCache(r107);
        LocalTestManager.a(new Class[]{uv.a.class});
        Intrinsics.checkNotNullParameter(r105, "url");
        Intrinsics.checkNotNullParameter(r100, "view");
        f r109 = new f(r108, r103, r105, r100);
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r105, "url");
        Intrinsics.checkNotNullParameter(r107, "imageRequest");
        if (r100.getContext() != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r105) == true) goto L21;
        PipelineDraweeControllerBuilder r110 = Fresco.newDraweeControllerBuilder().setImageRequest(r107).setTapToRetryEnabled(true);
        r110.setControllerListener(r109);
        r100.setController(r110.build());
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r106 = false;
        goto L9
    }

    public static final void a(String r100, boolean r101, long r102, boolean r103, Map r104, String r105, String r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() != 0) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == true) goto L38;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L31
        LinkedHashMap r108 = new LinkedHashMap();     // Catch: Throwable -> L31
        if (r104 == null) goto L15;
        Iterator r109 = r104.entrySet().iterator();     // Catch: Throwable -> L31
    L13:
        if (r109.hasNext() == false) goto L15;
        Map.Entry r111 = (Map.Entry) r109.next();     // Catch: Throwable -> L31
        r108.put(r111.getKey(), r111.getValue());     // Catch: Throwable -> L31
    L15:
        r108.put("duration", String.valueOf(r102));     // Catch: Throwable -> L31
        if (r101 == false) goto L18;
        String r112 = "1";
    L19:
        r108.put("success", r112);     // Catch: Throwable -> L31
        if (r103 == false) goto L22;
        String r113 = "cache";
    L23:
        r108.put("result_from", r113);     // Catch: Throwable -> L31
        if (r101 == false) goto L26;
    L29:
        r108.put("image_optimize_type", String.valueOf(f478833b));     // Catch: Throwable -> L31
        r108.put("url", r110);     // Catch: Throwable -> L31
        r108.put(ILoadStallMonitor.START_TIME, String.valueOf(System.currentTimeMillis() - r102));     // Catch: Throwable -> L31
        HashMap<String, String> r114 = GamecpTracker.f56755a;     // Catch: Throwable -> L31
        GamecpTracker.z(null, r100, r108);     // Catch: Throwable -> L31
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
        return;
    L26:
        if (r105 != null) goto L28;
        r105 = "";
    L28:
        r108.put("fail_reason", r105);     // Catch: Throwable -> L31
        goto L29
    L22:
        r113 = "download";
        goto L23
    L18:
        r112 = "0";
    L31:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L38:
        return;
    L6:
        r106 = false;
        goto L7
    }

    public static void f(String r100, boolean r101, long r102, boolean r103, String r104, ImageInfo r105, int r110) {
        String r106 = "";
        if ((r110 & 16) == 0) goto L6;
        r104 = "";
    L6:
        if ((r110 & 32) == 0) goto L30;
        r105 = null;
    L30:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Throwable -> L27
        r112.put("image_url", r100);     // Catch: Throwable -> L27
        r112.put("duration", String.valueOf(r102));     // Catch: Throwable -> L27
        if (r101 == false) goto L11;
        String r107 = "1";
    L12:
        r112.put("success", r107);     // Catch: Throwable -> L27
        if (r103 == false) goto L15;
        String r108 = "cache";
    L16:
        r112.put("result_from", r108);     // Catch: Throwable -> L27
        if (r101 == false) goto L19;
    L23:
        if (r105 == null) goto L25;
        r112.put("image_width", String.valueOf(r105.getWidth()));     // Catch: Throwable -> L27
        r112.put("image_height", String.valueOf(r105.getHeight()));     // Catch: Throwable -> L27
    L25:
        r112.put("image_optimize_type", String.valueOf(f478833b));     // Catch: Throwable -> L27
        HashMap<String, String> r109 = GamecpTracker.f56755a;     // Catch: Throwable -> L27
        GamecpTracker.z(null, "dygame_tech_cloud_image_load", r112);     // Catch: Throwable -> L27
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return;
    L19:
        if (r104 == null) goto L22;
        r106 = r104;
    L22:
        r112.put("fail_reason", r106);     // Catch: Throwable -> L27
        goto L23
    L15:
        r108 = "download";
        goto L16
    L11:
        r107 = "0";
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
