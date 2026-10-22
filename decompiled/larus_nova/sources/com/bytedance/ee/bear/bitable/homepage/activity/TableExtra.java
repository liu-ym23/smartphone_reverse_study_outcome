package com.bytedance.ee.bear.bitable.homepage.activity;

import com.bytedance.ee.util.io.NonProguard;
import com.larus.trace.CopyContentTypeString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/TableExtra;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", CopyContentTypeString.TABLE, "", "getTable", "()Ljava/lang/String;", "setTable", "(Ljava/lang/String;)V", "view", "getView", "setView", "record", "getRecord", "setRecord", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableExtra implements NonProguard {
    private String record;
    private String table;
    private String view;

    public TableExtra() {
        this.table = "";
        this.view = "";
        this.record = "";
    }

    public final String getRecord() {
        return this.record;
    }

    public final String getTable() {
        return this.table;
    }

    public final String getView() {
        return this.view;
    }

    public final void setRecord(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.record = r100;
    }

    public final void setTable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.table = r100;
    }

    public final void setView(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.view = r100;
    }
}
