package com.bytedance.ee.bear.facade.glide;

import android.content.Context;
import android.graphics.Bitmap;
import ba5.c;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.LibraryGlideModule;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader.PDFPageModel;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageGlideUrl;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.framework.utils.z;
import go5.d;
import java.io.InputStream;
import lr5.b;
import lr5.f;
import sa5.h;
import sa5.l;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BearGlideModule extends LibraryGlideModule {
    private static final String TAG = "BearGlideModule";

    public BearGlideModule() {
    }

    public static boolean isInDocsProcess(Context r3) {
        String r4 = z.b(r3);     // Catch: Throwable -> L9
        if (r4.endsWith(":docs") == true) goto L7;
        if (r4.endsWith(":p0") == true) goto L7;
        return false;
    L7:
        return true;
    L9:
        th = move-exception;
        a.i(TAG, "isInDocsProcess()", th);
        return false;
    }

    public void registerComponents(Context r3, Glide r4, Registry r5) {
        super.registerComponents(r3, r4, r5);
        a.h(TAG, "registerComponents");
        if (z.e(r3) == false) goto L5;
    L8:
        a.h(TAG, "dependency is ccm dependency");
        qu5.a.a r6 = new h();
    L9:
        lr5.a r7 = b.b().b();
        l r0 = new l(r6);
        r7.a.cookieJar(r0);
        f r8 = r7.a();
        r5.prepend(BearGlideUrl.class, InputStream.class, new go5.b.a(r8));
        r5.prepend(ThumbGlideUrl.class, InputStream.class, new d.a(r8));
        r5.prepend(CommentImageGlideUrl.class, InputStream.class, new if5.h.a(r8));
        r5.prepend(PDFPageModel.class, PagePart.class, new c.a());
        r5.prepend(PagePart.class, Bitmap.class, new ba5.b());
        return;
    L5:
        if (isInDocsProcess(r3) == true) goto L8;
        a.h(TAG, "dependency is dependency wrapper");
        r6 = new xa5.a();
        goto L9
    }
}
