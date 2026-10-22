package com.bytedance.ee.bear.bitable.ddui.model;

import android.text.TextUtils;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentValueModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentValueItemModel;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "search", "Lcom/bytedance/ee/bear/bitable/ddui/model/InputWidgetModel;", "getSearch", "()Lcom/bytedance/ee/bear/bitable/ddui/model/InputWidgetModel;", "setSearch", "(Lcom/bytedance/ee/bear/bitable/ddui/model/InputWidgetModel;)V", "getFilterValueUIType", "Lcom/bytedance/ee/bear/bitable/ddui/model/FilterValueUIType;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StepContentValueModel extends BaseWidgetModel {
    private ArrayList<StepContentValueItemModel> data;
    private InputWidgetModel search;
    private String type;

    public final FilterValueUIType getFilterValueUIType() {
        FilterValueUIType.a r100 = FilterValueUIType.Companion;
        String r101 = this.type;
        r100.getClass();
        FilterValueUIType[] r102 = FilterValueUIType.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        FilterValueUIType r105 = r102[r104];
        if (TextUtils.equals(r105.getValue(), r101) == true) goto L12;
        r104 = r104 + 1;
        goto L3
    L12:
        return r105;
    L8:
        return null;
    }

    public StepContentValueModel() {
    }

    public final ArrayList<StepContentValueItemModel> getData() {
        return this.data;
    }

    public final InputWidgetModel getSearch() {
        return this.search;
    }

    public final String getType() {
        return this.type;
    }

    public final void setData(ArrayList<StepContentValueItemModel> r100) {
        this.data = r100;
    }

    public final void setSearch(InputWidgetModel r100) {
        this.search = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
