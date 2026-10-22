package com.bytedance.ee.bear.bitable.card.view.cell.link;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkContent;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "primaryValue", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getPrimaryValue", "()Ljava/util/HashMap;", "setPrimaryValue", "(Ljava/util/HashMap;)V", "primaryFieldType", "", "getPrimaryFieldType", "()I", "setPrimaryFieldType", "(I)V", "recordIds", "Ljava/util/ArrayList;", "getRecordIds", "()Ljava/util/ArrayList;", "setRecordIds", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkContent implements NonProguard {
    private int primaryFieldType;
    private HashMap<String, String> primaryValue;
    private ArrayList<String> recordIds;

    public LinkContent() {
        this.primaryValue = new HashMap();
        this.recordIds = new ArrayList();
    }

    public final int getPrimaryFieldType() {
        return this.primaryFieldType;
    }

    public final HashMap<String, String> getPrimaryValue() {
        return this.primaryValue;
    }

    public final ArrayList<String> getRecordIds() {
        return this.recordIds;
    }

    public final void setPrimaryFieldType(int r100) {
        this.primaryFieldType = r100;
    }

    public final void setPrimaryValue(HashMap<String, String> r100) {
        this.primaryValue = r100;
    }

    public final void setRecordIds(ArrayList<String> r100) {
        this.recordIds = r100;
    }
}
