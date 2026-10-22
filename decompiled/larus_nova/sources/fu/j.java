package fu;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.gamecp.common.utils.y;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    public interface a<T> {
        void accept(T r100);
    }

    public static class b implements ControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageModel f478850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y.a f478851b;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        public b(ImageModel r100, y.a r101) {
            this.f478850a = r100;
            this.f478851b = r101;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            y.a r102 = this.f478851b;
            if (r102 == null) goto L6;
            new RuntimeException(r101);
            r102.onLoadFailed();
            return;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            y.a r102 = this.f478851b;
            if (r102 == null) goto L6;
            r102.a();
            return;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
            ImageInfo r103 = r101;
            if (r103 == null) goto L5;
            r103.getWidth();
        L5:
            if (r103 == null) goto L7;
            r103.getHeight();
        L7:
            ImageModel r104 = this.f478850a;
            if (r104 == null) goto L10;
            r104.setLoaded(true);
        L10:
            y.a r105 = this.f478851b;
            if (r105 == null) goto L14;
            r105.onLoadSuccess();
            return;
        }
    }

    public interface c {
        void onResult(boolean r100, String r101);
    }

    public static void f(GenericDraweeView r100) {
        if (r100 == null) goto L7;
        GenericDraweeHierarchy r101 = r100.getHierarchy();
        if (r101 == null) goto L8;
        r101.setFadeDuration(0);
        return;
    L8:
        return;
    }

    public static void a(GenericDraweeView r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setImageURI(ImageRequestBuilder.newBuilderWithResourceId(r101).build().getSourceUri());
    }

    public static void b(GenericDraweeView r100, ImageModel r101) {
        Boolean r102 = Boolean.valueOf(d.f478832a);
        if (r102 != null) goto L5;
    L18:
        f r103 = null;
    L19:
        d(r100, r101, null, r103);
        return;
    L5:
        if (r102.booleanValue() == false) goto L18;
        if (r101 == null) goto L18;
        List<String> r104 = r101.getUrls();
        if (r104 == null) goto L18;
        if (r104.isEmpty() == true) goto L18;
        String r105 = (String) ListProtector.get(r104, 0);
        if (r105 == null) goto L18;
        boolean r106 = Fresco.getImagePipeline().isInBitmapMemoryCache(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r105)).build());     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r105, "url");     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r100, "view");     // Catch: Exception -> L21
        r103 = new f(r106, null, r105, r100);     // Catch: Exception -> L21
        goto L19
    }

    public static void e(GenericDraweeView r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        ImageRequest r102 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).build();
        r100.setController(Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setImageRequest(r102).build());
        return;
    }

    public static void c(GenericDraweeView r100, ImageModel r101, int r102) {
        ResizeOptions r103 = null;
        if (r102 > 0) goto L5;
        Drawable r104 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r101.getUrls() != null) goto L10;
        return;
    L10:
        if (r101.getUrls().size() == 0) goto L56;
        int r105 = r100.getMeasuredWidth();
        int r106 = r100.getMeasuredHeight();
        if (r105 <= 0) goto L17;
        if (r106 <= 0) goto L17;
        r103 = new ResizeOptions(r105, r106);
    L17:
        if (r101.getUrls() != null) goto L19;
    L35:
        ImageRequest[] r107 = new ImageRequest[0];
    L36:
        if (r107 != null) goto L38;
        return;
    L38:
        if (r107.length == 0) goto L57;
        PipelineDraweeControllerBuilder r108 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(r107);
        if (r104 != null) goto L43;
    L46:
        r100.setController(r108.build());
        return;
    L43:
        if (r100.getHierarchy() != null) goto L45;
        r100.setHierarchy(new GenericDraweeHierarchyBuilder(r100.getContext().getResources()).setFadeDuration(300).setPlaceholderImage(r104).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
        goto L46
    L45:
        GenericDraweeHierarchy r109 = r100.getHierarchy();
        r109.setFadeDuration(300);
        r109.setPlaceholderImage(r104);
        r100.setHierarchy(r109);
        goto L46
    L57:
        return;
    L19:
        if (r101.getUrls().size() == 0) goto L35;
        ArrayList r110 = new ArrayList();
        Iterator<String> r111 = r101.getUrls().iterator();
    L23:
        if (r111.hasNext() == false) goto L32;
        String r112 = r111.next();
        if (StringUtils.isEmpty(r112) == true) goto L23;
        ImageRequestBuilder r113 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r112));
        if (r103 == null) goto L30;
        r113.setResizeOptions(r103);
    L30:
        r110.add(r113.build());
        goto L23
    L32:
        if (r110.size() != 0) goto L34;
        r107 = new ImageRequest[0];
        goto L36
    L34:
        r107 = (ImageRequest[]) r110.toArray(new ImageRequest[r110.size()]);
        goto L36
    L56:
        return;
    L5:
        r104 = y0.getContext().getResources().getDrawable(r102);
        goto L6
    }

    public static void d(GenericDraweeView r100, ImageModel r101, com.bytedance.android.gamecp.business.gamedetail.component.scaffold.d r102, f r103) {
        if (r100 == null) goto L43;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getUrls() != null) goto L7;
        return;
    L7:
        if (r101.getUrls().size() != 0) goto L10;
        return;
    L10:
        if (r101.getUrls() != null) goto L12;
    L28:
        ImageRequest[] r104 = new ImageRequest[0];
    L29:
        if (r104 != null) goto L31;
        return;
    L31:
        if (r104.length == 0) goto L48;
        PipelineDraweeControllerBuilder r105 = Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setFirstAvailableImageRequests(r104);
        if (r103 == null) goto L36;
        r105.setControllerListener(r103);
    L36:
        r100.setController(r105.build());
        return;
    L48:
        return;
    L12:
        if (r101.getUrls().size() == 0) goto L28;
        ArrayList r106 = new ArrayList();
        Iterator<String> r107 = r101.getUrls().iterator();
    L16:
        if (r107.hasNext() == false) goto L25;
        String r108 = r107.next();
        if (StringUtils.isEmpty(r108) == true) goto L16;
        ImageRequestBuilder r109 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r108));
        if (r102 == null) goto L23;
        r109.setPostprocessor(r102);
    L23:
        r106.add(r109.build());
        goto L16
    L25:
        if (r106.size() != 0) goto L27;
        r104 = new ImageRequest[0];
        goto L29
    L27:
        r104 = (ImageRequest[]) r106.toArray(new ImageRequest[r106.size()]);
        goto L29
    }
}
