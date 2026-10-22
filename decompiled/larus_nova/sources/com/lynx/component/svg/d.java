package com.lynx.component.svg;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.component.svg.parser.SVG;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.n;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<UISvg> f381008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxContext f381009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Bitmap> f381010c;

    public class a extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataSource f381011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f381012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f381013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f381014d;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            this.f381013c.onFailed();
            if (r100 == null) goto L6;
            r100.close();
            return;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            if (this.f381011a.isFinished() == false) goto L11;
            if (r100 == null) goto L12;
            LLog.d("UISVG Bitmap", "has come");
            this.f381014d.f381010c.put(this.f381012b, Bitmap.createBitmap(r100));
            this.f381011a.close();
            WeakReference<UISvg> r101 = this.f381014d.f381008a;
            if (r101 == null) goto L13;
            UISvg r102 = r101.get();
            if (r102 == null) goto L14;
            LLog.i("lynx_UISvg", "fetch bitmap the image url is :" + this.f381012b + " ui-svg hashCode:" + r102.hashCode());
            r102.S();
            return;
        L14:
            return;
        L13:
            return;
        L12:
            return;
        }

        public a(d r100, DataSource r101, String r102, b r103) {
            this.f381014d = r100;
            this.f381011a = r101;
            this.f381012b = r102;
            this.f381013c = r103;
        }
    }

    public interface b {
        void onFailed();

        void onSuccess(Bitmap r100);
    }

    public interface c extends InterfaceC4557d {
        void a(String r100, SVG r101);
    }

    /* JADX INFO: renamed from: com.lynx.component.svg.d$d, reason: collision with other inner class name */
    public interface InterfaceC4557d {
        void onError(String r100);

        void onStart();

        void onSuccess();
    }

    public final void a() {
        Iterator<Map.Entry<String, Bitmap>> r100 = this.f381010c.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        r100.next().getValue().recycle();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        th.toString();
        goto L4
    L10:
        this.f381010c.clear();
    }

    public d(LynxContext r100) {
        this.f381008a = null;
        this.f381009b = r100;
        this.f381010c = new HashMap();
    }

    public d(LynxContext r100, UISvg r101) {
        this.f381008a = null;
        this.f381009b = r100;
        this.f381010c = new HashMap();
        this.f381008a = new WeakReference(r101);
    }

    public final void b(String r100, b r101) {
        if (this.f381010c.containsKey(r100) == false) goto L6;
        LLog.d("UISVG", "requestBitmapSync got from bitmap cache ");
        r101.onSuccess(this.f381010c.get(r100));
        return;
    L6:
        ImageRequestBuilder r102 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(this.f381009b, r100, false)));
        m8a.e.a(r102);
        ImageRequest r103 = r102.build();
        DataSource<CloseableReference<CloseableImage>> r104 = Fresco.getImagePipeline().fetchDecodedImage(r103, "lynx_SvgResourceManager");
        r104.subscribe(new a(this, r104, r100, r101), UiThreadImmediateExecutorService.getInstance());
    }

    public final void c(String r100, c r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        r101.onError("src is empty!");
        return;
    L7:
        if (this.f381009b.getGenericResourceFetcher() == null) goto L10;
        r101.onStart();
        LynxResourceRequest r102 = new LynxResourceRequest(r100, LynxResourceRequest.LynxResourceType.LynxResourceTypeSVG);
        this.f381009b.getGenericResourceFetcher().a(r102, new e(r101, r100));
        return;
    L10:
        String r103 = d7a.a.b(this.f381009b, r100, false);
        if (TextUtils.isEmpty(r103) == false) goto L15;
        r101.onError("url is empty!");
        return;
    L15:
        if (TextUtils.isEmpty(UriProtector.parse(r103).getScheme()) == false) goto L18;
        r101.onError("scheme is Empty!");
        return;
    L18:
        r101.onStart();
        d8a.h r104 = new d8a.h(r103, this.f381009b.getLynxExtraData());
        n.a().b(r104, new f(r101));
    }
}
