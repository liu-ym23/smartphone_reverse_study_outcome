package lr;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.ec.host.api.core.api.IECImageXService;
import com.bytedance.android.ec.host.api.core.api.ImagePreloadConfig;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class y implements IECImageXService {
    public y() {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final boolean bindByImageX(GenericDraweeView r100, ControllerListener<? super ImageInfo> r101, String r102, String r103, String r104, HashMap<String, Object> r105, String r106) {
        return false;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final boolean bindByImageX(GenericDraweeView r100, ControllerListener<? super ImageInfo> r101, String r102, String r103, String r104, HashMap<String, Object> r105, String r106, Function0<? extends Map<String, ?>> r107) {
        return false;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void bindImageByRequest(GenericDraweeView r100, List<? extends ImageRequest> r101, ImageRequest r102, Object r103) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final boolean bindImageXWithSize(GenericDraweeView r100, ControllerListener<? super ImageInfo> r101, String r102, String r103, String r104, Integer r105, Integer r106, HashMap<String, Object> r107, String r108, Function0<? extends Map<String, ?>> r110) {
        return false;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final boolean downloadByImageX(String r100, String r101, String r102, Integer r103, Integer r104, Postprocessor r105, Function1<? super Bitmap, Unit> r106) {
        return false;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void initFirstScreenImageRecord() {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void preloadImage(String r100, Priority r101, String r102, String r103, HashMap<String, Object> r104, boolean r105, String r106, BaseRequestListener r107, Integer r108, Integer r110) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void preloadImages(JSONObject r100, JSONObject r101, ImagePreloadConfig r102) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final Pair<List<ImageRequest>, Object> prepareImageRequest(String r100, String r101, String r102, Function0<? extends Map<String, ?>> r103) {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final Object provideImageCallerContext(String r100, String r101) {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final Object provideSlcImageHook() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final pi.c providerNetImagePreloader() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void recordFirstScreenEnd(boolean r100) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void saveFirstScreenImageSet(Context r100) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void savePreloadConfig(ImagePreloadConfig r100) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final String transformImageUrl(String r100, String r101, String r102) {
        return "";
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECImageXService
    public final void urlPreConnect(String r100) {
    }
}
