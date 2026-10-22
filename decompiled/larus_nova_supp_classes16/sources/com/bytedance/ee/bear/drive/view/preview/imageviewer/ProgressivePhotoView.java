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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ProgressivePhotoView extends PhotoView implements d, m85.a {
    public String c;
    public b d;
    public boolean e;
    public final PreviewViewModel f;
    public final DriveComponentRenderVM g;

    public class a implements k95.b<ImageView, Bitmap, byte[]> {
        public final /* synthetic */ ProgressivePhotoView a;

        public a(ProgressivePhotoView r1) {
            this.a = r1;
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
        if (TextUtils.isEmpty(this.c) == true) goto L15;
        PreviewViewModel r0 = this.f;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isBlockViewChanging() == true) goto L17;
        i r1 = i.e;
        f.a();
        i r2 = i.e;
        String r3 = this.c;
        r2.getClass();
        f.a();
        j r4 = r2.c;
        WeakReference r5 = (WeakReference) r4.a.get(r3);
        if (r5 == null) goto L18;
        tt5.a.h("ProgressiveImageLoader", String.format("cancel request, key = %s", new Object[]{r3}));
        Request r6 = (Request) r5.get();
        if (r6 == null) goto L13;
        r6.cancel();
    L13:
        r4.a.remove(r3);
        return;
    L18:
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        if (this.g.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(b r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r95.d
    public final void c(z r10, UserSession r11) {
        LinkedHashMap<String, String> r12 = r10.f;
        if (r12 != null) goto L5;
    L7:
        String r13 = null;
    L8:
        h.a r14 = new h.a();
        Map<String, String> r0 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).oc(r13);
        if (hu5.a.e(r0) == true) goto L19;
        Iterator<Map.Entry<String, String>> r1 = r0.entrySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L19;
        Map.Entry<String, String> r2 = r1.next();
        if (TextUtils.isEmpty(r2.getKey()) == true) goto L13;
        if (TextUtils.isEmpty(r2.getValue()) == true) goto L13;
        r14.a(r2.getKey(), r2.getValue());
    L19:
        r14.a("doc-device-id", ((b0) org.koin.java.a.a(b0.class)).getDeviceId());
        r14.a = true;
        n95.a r3 = new n95.a(r13, new h(r14.b));
        i r16 = i.e;
        f.a();
        i r17 = i.e;
        a r5 = new a(this);
        r17.getClass();
        f.a();
        String r18 = r3.a();
        if (r18 == null) goto L28;
        String r19 = UriProtector.parse(r18).getScheme();
        if (r19 == null) goto L28;
        if ("http".equals(r19) == false) goto L26;
    L27:
        boolean r110 = true;
    L30:
        if (r110 == false) goto L32;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r111 = new com.bytedance.ee.bear.drive.view.preview.image.progressloader.b(r3, new p95.a(this), r5, new e(r17.a, r17.b), r17.d);
        String r4 = String.valueOf(System.currentTimeMillis());
        r17.c.a.put(r4, new WeakReference(r111));
        tt5.a.h("ProgressiveImageLoader", String.format("run request, key = %s", new Object[]{r4}));
        r111.a();
    L33:
        this.c = r4;
        return;
    L32:
        tt5.a.h("ProgressiveImageLoader", "not a network url, or target is null");
        r4 = "";
        goto L33
    L26:
        if ("https".equals(r19) == true) goto L27;
    L28:
        r110 = false;
        goto L30
    L5:
        if (r12.isEmpty() == true) goto L7;
        r13 = r12.values().iterator().next();
        goto L8
    }

    public ProgressivePhotoView(Context r1, PreviewViewModel r2, DriveComponentRenderVM r3) {
        super(r1);
        this.e = false;
        this.f = r2;
        this.g = r3;
        r3.bindReleaseListener(this);
    }

    public ProgressivePhotoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = false;
    }
}
