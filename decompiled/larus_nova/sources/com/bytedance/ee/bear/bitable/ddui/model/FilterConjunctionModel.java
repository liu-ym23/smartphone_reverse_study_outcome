package com.bytedance.ee.bear.bitable.ddui.model;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/FilterConjunctionModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "datas", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionEditItemModel;", "Lkotlin/collections/ArrayList;", "getDatas", "()Ljava/util/ArrayList;", "setDatas", "(Ljava/util/ArrayList;)V", "title", "Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", "getTitle", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", d.f25925o, "(Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;)V", "into", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelModel;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterConjunctionModel extends BaseWidgetModel {
    private ArrayList<ConditionEditItemModel> datas;
    private TitleWidgetModel title;

    public final BitablePanelModel into() {
        BitablePanelModel r100 = new BitablePanelModel();
        TitleWidgetModel r101 = this.title;
        ArrayList<BitablePanelItem> r102 = null;
        if (r101 == null) goto L7;
        TextWidgetModel r103 = r101.getCenterText();
        if (r103 == null) goto L7;
        String r104 = r103.getText();
    L8:
        r100.setTitle(r104);
        ArrayList<ConditionEditItemModel> r105 = this.datas;
        if (r105 == null) goto L14;
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r102.add(((ConditionEditItemModel) r106.next()).intoPanelItem());
    L14:
        r100.setData(r102);
        return r100;
    L7:
        r104 = null;
        goto L8
    }

    public FilterConjunctionModel() {
    }

    public final ArrayList<ConditionEditItemModel> getDatas() {
        return this.datas;
    }

    public final TitleWidgetModel getTitle() {
        return this.title;
    }

    public final void setDatas(ArrayList<ConditionEditItemModel> r100) {
        this.datas = r100;
    }

    public final void setTitle(TitleWidgetModel r100) {
        this.title = r100;
    }
}
