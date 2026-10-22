package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverClickAction;", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "<init>", "()V", "activeIndex", "", "getActiveIndex", "()Ljava/lang/Integer;", "setActiveIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryCoverClickAction extends ActionPayload {
    private Integer activeIndex;

    public GalleryCoverClickAction() {
    }

    public final Integer getActiveIndex() {
        return this.activeIndex;
    }

    public final void setActiveIndex(Integer r100) {
        this.activeIndex = r100;
    }
}
