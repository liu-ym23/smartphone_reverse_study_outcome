package com.ss.ugc.effectplatform.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoConvertModel;", "", "data", "", "Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoModel;", "total", "", "(Ljava/util/List;I)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getTotal", "()I", "setTotal", "(I)V", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingDesignerInfoConvertModel {
    private List<? extends RankingDesignerInfoModel> data;
    private int total;

    /* JADX WARN: Multi-variable type inference failed */
    public RankingDesignerInfoConvertModel() {
        List r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public String toString() {
        return "RankingDesignerInfoConvertModel(data=" + getData() + ", total=" + getTotal() + ')';
    }

    public List<RankingDesignerInfoModel> getData() {
        return this.data;
    }

    public int getTotal() {
        return this.total;
    }

    public void setData(List<? extends RankingDesignerInfoModel> r100) {
        this.data = r100;
    }

    public void setTotal(int r100) {
        this.total = r100;
    }

    public RankingDesignerInfoConvertModel(List<? extends RankingDesignerInfoModel> r100, int r101) {
        this.data = r100;
        this.total = r101;
    }

    public /* synthetic */ RankingDesignerInfoConvertModel(List r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
