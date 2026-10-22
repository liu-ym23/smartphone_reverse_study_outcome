package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.photoview.PhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passportc.entity.UserSession;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k95.i;
import k95.j;
import m95.e;
import n95.h;
import q95.f;
import r95.d;

/* JADX INFO: loaded from: classes16.dex */
public class ProgressivePhotoView extends PhotoView implements d, m85.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f225028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f225029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f225030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PreviewViewModel f225031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DriveComponentRenderVM f225032g;

    public class a implements k95.b<ImageView, Bitmap, byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressivePhotoView f225033a;

        public a(ProgressivePhotoView r100) {
            this.f225033a = r100;
        }
    }

    @Override // r95.d
    public final /* synthetic */ void d() {
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "ProgressivePhotoView";
    }

    @Override // r95.d
    public String getViewTag() {
        return "ProgressivePhotoView";
    }

    @Override // m85.a
    public final void onRelease() {
        if (TextUtils.isEmpty(this.f225028c) == true) goto L15;
        PreviewViewModel r100 = this.f225031f;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isBlockViewChanging() == true) goto L17;
        i r101 = i.f502154e;
        f.a();
        i r102 = i.f502154e;
        String r103 = this.f225028c;
        r102.getClass();
        f.a();
        j r104 = r102.f502157c;
        WeakReference<Request> r105 = r104.f502159a.get(r103);
        if (r105 == null) goto L18;
        tt5.a.h("ProgressiveImageLoader", String.format("cancel request, key = %s", new Object[]{r103}));
        Request r106 = r105.get();
        if (r106 == null) goto L13;
        r106.cancel();
    L13:
        r104.f502159a.remove(r103);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225032g.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(b r100) {
        this.f225029d = r100;
    }

    @Override // r95.d
    public final void c(z r110, UserSession r111) {
        LinkedHashMap<String, String> r112 = r110.f225838f;
        if (r112 != null) goto L5;
    L7:
        String r113 = null;
    L8:
        h.a r114 = new h.a();
        Map<String, String> r100 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).oc(r113);
        if (hu5.a.e(r100) == true) goto L19;
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L13:
        if (r101.hasNext() == false) goto L19;
        Map.Entry<String, String> r102 = r101.next();
        if (TextUtils.isEmpty(r102.getKey()) == true) goto L13;
        if (TextUtils.isEmpty(r102.getValue()) == true) goto L13;
        r114.a(r102.getKey(), r102.getValue());
    L19:
        r114.a("doc-device-id", ((b0) org.koin.java.a.a(b0.class)).getDeviceId());
        r114.f518409a = true;
        n95.a r103 = new n95.a(r113, new h(r114.f518410b));
        i r115 = i.f502154e;
        f.a();
        i r116 = i.f502154e;
        a r104 = new a(this);
        r116.getClass();
        f.a();
        String r117 = r103.a();
        if (r117 == null) goto L28;
        String r118 = UriProtector.parse(r117).getScheme();
        if (r118 == null) goto L28;
        if ("http".equals(r118) == false) goto L26;
    L27:
        boolean r119 = true;
    L30:
        if (r119 == false) goto L32;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r120 = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.b(r103, new p95.a(this), r104, new e(r116.f502155a, r116.f502156b), r116.f502158d);
        String r105 = String.valueOf(System.currentTimeMillis());
        r116.f502157c.f502159a.put(r105, new WeakReference(r120));
        tt5.a.h("ProgressiveImageLoader", String.format("run request, key = %s", new Object[]{r105}));
        r120.a();
    L33:
        this.f225028c = r105;
        return;
    L32:
        tt5.a.h("ProgressiveImageLoader", "not a network url, or target is null");
        r105 = "";
        goto L33
    L26:
        if ("https".equals(r118) == true) goto L27;
    L28:
        r119 = false;
        goto L30
    L5:
        if (r112.isEmpty() == true) goto L7;
        r113 = r112.values().iterator().next();
        goto L8
    }

    public ProgressivePhotoView(Context r100, PreviewViewModel r101, DriveComponentRenderVM r102) {
        super(r100);
        this.f225030e = false;
        this.f225031f = r101;
        this.f225032g = r102;
        r102.bindReleaseListener(this);
    }

    public ProgressivePhotoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225030e = false;
    }
}
