package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/FormatterTextCellValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "formatterValue", "", "getFormatterValue", "()Ljava/lang/String;", "setFormatterValue", "(Ljava/lang/String;)V", "isInEditLoadingStatus", "", "()Z", "setInEditLoadingStatus", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FormatterTextCellValue implements NonProguard {
    private String formatterValue;
    private boolean isInEditLoadingStatus;

    public FormatterTextCellValue() {
        this.formatterValue = "";
    }

    public final String getFormatterValue() {
        return this.formatterValue;
    }

    public final boolean isInEditLoadingStatus() {
        return this.isInEditLoadingStatus;
    }

    public final void setFormatterValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.formatterValue = r100;
    }

    public final void setInEditLoadingStatus(boolean r100) {
        this.isInEditLoadingStatus = r100;
    }
}
