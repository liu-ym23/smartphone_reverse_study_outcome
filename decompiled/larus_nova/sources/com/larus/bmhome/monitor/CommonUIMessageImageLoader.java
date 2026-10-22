package com.larus.bmhome.monitor;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.video.j;
import com.larus.image.loader.g;
import hr8.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jp\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142,\u0010\u0015\u001a(\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n0\u0016¢\u0006\u0002\b\u001cH\u0017R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/monitor/CommonUIMessageImageLoader;", "Lcom/larus/bmhome/monitor/ICommonUIMessageImageLoaderService;", "<init>", "()V", "service", "getService", "()Lcom/larus/bmhome/monitor/ICommonUIMessageImageLoaderService;", "service$delegate", "Lkotlin/Lazy;", "loadImageByImageLoader", "", "messageId", "", "type", "Lcom/larus/bmhome/monitor/CommonUIMessageImageType;", "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", "url", "bizTag", "extra", "Lcom/larus/image/loader/ImageExtra;", "builder", "Lkotlin/Function2;", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "Landroid/net/Uri;", "Lkotlin/ParameterName;", "name", "imageUri", "Lkotlin/ExtensionFunctionType;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonUIMessageImageLoader implements ICommonUIMessageImageLoaderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommonUIMessageImageLoader f312707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f312708b = null;

    private CommonUIMessageImageLoader() {
    }

    static {
        f312707a = new CommonUIMessageImageLoader();
        f312708b = LazyKt.lazy(new a());
    }

    @Override // com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService
    public final void a(String r110, CommonUIMessageImageType r111, SimpleDraweeView r112, String r113, String r114, g r115, j r116) {
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r116, "builder");
        ICommonUIMessageImageLoaderService r100 = (ICommonUIMessageImageLoaderService) f312708b.getValue();
        if (r100 == null) goto L6;
        r100.a(r110, r111, r112, r113, r114, r115, r116);
        return;
    }
}
