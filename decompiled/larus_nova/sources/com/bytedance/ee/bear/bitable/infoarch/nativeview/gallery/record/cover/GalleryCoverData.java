package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "covers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "Lkotlin/collections/ArrayList;", "getCovers", "()Ljava/util/ArrayList;", "setCovers", "(Ljava/util/ArrayList;)V", "clickAction", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverClickAction;", "getClickAction", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverClickAction;", "setClickAction", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverClickAction;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "largeSize", "", "getLargeSize", "()Z", "setLargeSize", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryCoverData implements NonProguard {
    private GalleryCoverClickAction clickAction;
    private ArrayList<AttachmentEntity> covers;
    private int index;
    private boolean largeSize;

    public GalleryCoverData() {
    }

    public final GalleryCoverClickAction getClickAction() {
        return this.clickAction;
    }

    public final ArrayList<AttachmentEntity> getCovers() {
        return this.covers;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getLargeSize() {
        return this.largeSize;
    }

    public final void setClickAction(GalleryCoverClickAction r100) {
        this.clickAction = r100;
    }

    public final void setCovers(ArrayList<AttachmentEntity> r100) {
        this.covers = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setLargeSize(boolean r100) {
        this.largeSize = r100;
    }
}
