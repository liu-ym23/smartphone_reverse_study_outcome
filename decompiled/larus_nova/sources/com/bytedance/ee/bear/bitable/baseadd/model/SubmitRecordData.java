package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitRecordData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "recordID", "", "getRecordID", "()Ljava/lang/String;", "setRecordID", "(Ljava/lang/String;)V", com.heytap.mcssdk.constant.b.f276354d, "", "getTaskID", "()Ljava/lang/Integer;", "setTaskID", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "taskIDStr", "getTaskIDStr", "setTaskIDStr", "pollStrategy", "Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitPollStrategy;", "getPollStrategy", "()Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitPollStrategy;", "setPollStrategy", "(Lcom/bytedance/ee/bear/bitable/baseadd/model/SubmitPollStrategy;)V", "permittedFields", "Ljava/util/ArrayList;", "getPermittedFields", "()Ljava/util/ArrayList;", "setPermittedFields", "(Ljava/util/ArrayList;)V", "changedFields", "getChangedFields", "setChangedFields", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmitRecordData implements NonProguard {
    private ArrayList<String> changedFields;
    private ArrayList<String> permittedFields;
    private SubmitPollStrategy pollStrategy;
    private String recordID;
    private Integer taskID;
    private String taskIDStr;

    public SubmitRecordData() {
        this.pollStrategy = new SubmitPollStrategy();
        this.permittedFields = new ArrayList();
        this.changedFields = new ArrayList();
    }

    public final ArrayList<String> getChangedFields() {
        return this.changedFields;
    }

    public final ArrayList<String> getPermittedFields() {
        return this.permittedFields;
    }

    public final SubmitPollStrategy getPollStrategy() {
        return this.pollStrategy;
    }

    public final String getRecordID() {
        return this.recordID;
    }

    public final Integer getTaskID() {
        return this.taskID;
    }

    public final String getTaskIDStr() {
        return this.taskIDStr;
    }

    public final void setChangedFields(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.changedFields = r100;
    }

    public final void setPermittedFields(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.permittedFields = r100;
    }

    public final void setPollStrategy(SubmitPollStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pollStrategy = r100;
    }

    public final void setRecordID(String r100) {
        this.recordID = r100;
    }

    public final void setTaskID(Integer r100) {
        this.taskID = r100;
    }

    public final void setTaskIDStr(String r100) {
        this.taskIDStr = r100;
    }
}
