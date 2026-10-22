package com.bytedance.ee.bear.bitable.infoarch.nativeview.card.record.cover;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/cover/CardCoverData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "cover", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "getCover", "()Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "setCover", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;)V", "clickAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardCoverData implements NonProguard {
    private ActionPayload clickAction;
    private AttachmentEntity cover;
    private int index;

    public CardCoverData() {
    }

    public final ActionPayload getClickAction() {
        return this.clickAction;
    }

    public final AttachmentEntity getCover() {
        return this.cover;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setClickAction(ActionPayload r100) {
        this.clickAction = r100;
    }

    public final void setCover(AttachmentEntity r100) {
        this.cover = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }
}
