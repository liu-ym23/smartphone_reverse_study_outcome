package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader.PDFPageModel;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k0 implements com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a {
    public final String a;
    public final TTPdfReader b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a
    public final void pause() {
        if (com.bytedance.ee.util.ui.b.b(this.b.getView().getContext()) == true) goto L5;
        return;
    L5:
        Glide.with(this.b.getView().getContext()).pauseRequests();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a
    public final void resume() {
        if (com.bytedance.ee.util.ui.b.b(this.b.getView().getContext()) == true) goto L5;
        return;
    L5:
        Glide.with(this.b.getView().getContext()).resumeRequests();
    }

    public k0(String r2, TTPdfReader r3) {
        Intrinsics.checkNotNullParameter(r2, "fileId");
        Intrinsics.checkNotNullParameter(r3, "ttPdfReader");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a
    public final void b(ImageView r12, com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a.C0184a r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "loadConfig");
        if (com.bytedance.ee.util.ui.b.b(r12.getContext()) == true) goto L5;
        return;
    L5:
        tt5.a.h("PDFPageLoaderImpl", "loadPageToView, page: " + r13.a + ", size: " + r13.b + Permission.EXECUTE + r13.c);
        Glide.with(r12.getContext()).load(new PDFPageModel(this.b, this.a, r13.a, r13.b, r13.c, r13.d, r13.e, r13.f)).diskCacheStrategy(DiskCacheStrategy.NONE).into(r12);
    }
}
