package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR.\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R.\u0010\"\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseRecordData;", "K", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "comment", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getComment", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setComment", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "highlightColor", "", "getHighlightColor", "()Ljava/lang/String;", "setHighlightColor", "(Ljava/lang/String;)V", "longPressMenu", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLongPressMenu", "()Ljava/util/ArrayList;", "setLongPressMenu", "(Ljava/util/ArrayList;)V", "clickAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "cardRecordCells", "getCardRecordCells", "setCardRecordCells", "recordCells", "getRecordCells", "setRecordCells", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseRecordData<K extends BaseCellData> implements NonProguard {
    private ArrayList<K> cardRecordCells;
    private ActionPayload clickAction;
    private SimpleItemModel comment;
    private String highlightColor;
    private ArrayList<SimpleItemModel> longPressMenu;
    private ArrayList<K> recordCells;

    public BaseRecordData() {
    }

    public final ArrayList<K> recordCells() {
        ArrayList<K> r100 = this.recordCells;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.cardRecordCells;
    }

    public final ArrayList<K> getCardRecordCells() {
        return this.cardRecordCells;
    }

    public final ActionPayload getClickAction() {
        return this.clickAction;
    }

    public final SimpleItemModel getComment() {
        return this.comment;
    }

    public final String getHighlightColor() {
        return this.highlightColor;
    }

    public final ArrayList<SimpleItemModel> getLongPressMenu() {
        return this.longPressMenu;
    }

    public final ArrayList<K> getRecordCells() {
        return this.recordCells;
    }

    public final void setCardRecordCells(ArrayList<K> r100) {
        this.cardRecordCells = r100;
    }

    public final void setClickAction(ActionPayload r100) {
        this.clickAction = r100;
    }

    public final void setComment(SimpleItemModel r100) {
        this.comment = r100;
    }

    public final void setHighlightColor(String r100) {
        this.highlightColor = r100;
    }

    public final void setLongPressMenu(ArrayList<SimpleItemModel> r100) {
        this.longPressMenu = r100;
    }

    public final void setRecordCells(ArrayList<K> r100) {
        this.recordCells = r100;
    }
}
