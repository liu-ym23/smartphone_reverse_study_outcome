package com.bytedance.ee.bear.bitable.card.viewmodel.cell;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorCellValue;", "getValue", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorCellValue;", "setValue", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorCellValue;)V", "finder", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorFinder;", "getFinder", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorFinder;", "setFinder", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/IButtonEditorFinder;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IButtonEditorModel implements NonProguard {
    private IButtonEditorFinder finder;
    private IButtonEditorCellValue value;

    public IButtonEditorModel() {
    }

    public final IButtonEditorFinder getFinder() {
        return this.finder;
    }

    public final IButtonEditorCellValue getValue() {
        return this.value;
    }

    public final void setFinder(IButtonEditorFinder r100) {
        this.finder = r100;
    }

    public final void setValue(IButtonEditorCellValue r100) {
        this.value = r100;
    }
}
