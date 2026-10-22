package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseRecordData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover.GalleryCoverData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryCellData;", "<init>", "()V", "cover", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverData;", "getCover", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverData;", "setCover", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverData;)V", "title", "getTitle", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryCellData;", d.f25925o, "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/GalleryCellData;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryRecordData extends BaseRecordData<GalleryCellData> {
    private GalleryCoverData cover;
    private GalleryCellData title;

    public GalleryRecordData() {
    }

    public final GalleryCoverData getCover() {
        return this.cover;
    }

    public final GalleryCellData getTitle() {
        return this.title;
    }

    public final void setCover(GalleryCoverData r100) {
        this.cover = r100;
    }

    public final void setTitle(GalleryCellData r100) {
        this.title = r100;
    }
}
