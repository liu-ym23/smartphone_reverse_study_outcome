package com.bytedance.ee.bear.bitable.infoarch.nativeview.card;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.record.cover.CardCoverData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseRecordData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseRecordData;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardCellData;", "<init>", "()V", "cardCover", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/cover/CardCoverData;", "getCardCover", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/cover/CardCoverData;", "setCardCover", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/cover/CardCoverData;)V", "title", "getTitle", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardCellData;", d.f25925o, "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardCellData;)V", "subTitle", "getSubTitle", "setSubTitle", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardRecordData extends BaseRecordData<CardCellData> {
    private CardCoverData cardCover;
    private CardCellData subTitle;
    private CardCellData title;

    public CardRecordData() {
    }

    public final CardCoverData getCardCover() {
        return this.cardCover;
    }

    public final CardCellData getSubTitle() {
        return this.subTitle;
    }

    public final CardCellData getTitle() {
        return this.title;
    }

    public final void setCardCover(CardCoverData r100) {
        this.cardCover = r100;
    }

    public final void setSubTitle(CardCellData r100) {
        this.subTitle = r100;
    }

    public final void setTitle(CardCellData r100) {
        this.title = r100;
    }
}
