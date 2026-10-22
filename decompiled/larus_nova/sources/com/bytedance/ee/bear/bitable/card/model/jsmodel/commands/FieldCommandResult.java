package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "result", "", "reason", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getResult", "()Ljava/lang/Integer;", "setResult", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReason", "setReason", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldCommandResult implements NonProguard {
    private Integer reason;
    private Integer result;

    public final Integer getReason() {
        return this.reason;
    }

    public final Integer getResult() {
        return this.result;
    }

    public final void setReason(Integer r100) {
        this.reason = r100;
    }

    public final void setResult(Integer r100) {
        this.result = r100;
    }

    public FieldCommandResult(Integer r100, Integer r101) {
        this.result = r100;
        this.reason = r101;
    }
}
