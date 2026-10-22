package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.loader;

import android.graphics.RectF;
import com.bumptech.glide.load.model.GlideUrl;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import du5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/loader/PDFPageModel;", "Lcom/bumptech/glide/load/model/GlideUrl;", "pdfReader", "Lcom/bytedance/ee/plugin/common/ttpdfreader/TTPdfReader;", "fileId", "", "page", "", "width", "height", "bounds", "Landroid/graphics/RectF;", "bestQuality", "", "annotationRendering", "<init>", "(Lcom/bytedance/ee/plugin/common/ttpdfreader/TTPdfReader;Ljava/lang/String;IIILandroid/graphics/RectF;ZZ)V", "getPdfReader", "()Lcom/bytedance/ee/plugin/common/ttpdfreader/TTPdfReader;", "getFileId", "()Ljava/lang/String;", "getPage", "()I", "getWidth", "getHeight", "getBounds", "()Landroid/graphics/RectF;", "getBestQuality", "()Z", "getAnnotationRendering", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PDFPageModel extends GlideUrl {
    private final boolean annotationRendering;
    private final boolean bestQuality;
    private final RectF bounds;
    private final String fileId;
    private final int height;
    private final int page;
    private final TTPdfReader pdfReader;
    private final int width;

    public final boolean getAnnotationRendering() {
        return this.annotationRendering;
    }

    public final boolean getBestQuality() {
        return this.bestQuality;
    }

    public final RectF getBounds() {
        return this.bounds;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getPage() {
        return this.page;
    }

    public final TTPdfReader getPdfReader() {
        return this.pdfReader;
    }

    public final int getWidth() {
        return this.width;
    }

    public PDFPageModel(TTPdfReader r3, String r4, int r5, int r6, int r7, RectF r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r3, "pdfReader");
        Intrinsics.checkNotNullParameter(r4, "fileId");
        Intrinsics.checkNotNullParameter(r8, "bounds");
        super(d.a("PDFPageModel(fileId=" + r4 + ", page=" + r5 + ", width=" + r6 + ", height=" + r6 + ", bestQuality=" + r9 + ", annotationRendering=" + r10 + ')'));
        this.pdfReader = r3;
        this.fileId = r4;
        this.page = r5;
        this.width = r6;
        this.height = r7;
        this.bounds = r8;
        this.bestQuality = r9;
        this.annotationRendering = r10;
    }
}
