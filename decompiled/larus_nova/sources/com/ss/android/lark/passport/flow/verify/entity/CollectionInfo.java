package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012(\b\u0001\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J)\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bHÆ\u0003JG\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052(\b\u0003\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/CollectionInfo;", "Ljava/io/Serializable;", ReportConstant.COMMON_ACTION_TYPE, "", "eventKey", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(ILjava/lang/String;Ljava/util/HashMap;)V", "getActionType", "()I", "getEventKey", "()Ljava/lang/String;", "getParams", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionInfo implements Serializable {
    private final int actionType;
    private final String eventKey;
    private final HashMap<String, String> params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectionInfo copy$default(CollectionInfo r100, int r101, String r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.actionType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.eventKey;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.params;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.actionType;
    }

    public final String component2() {
        return this.eventKey;
    }

    public final HashMap<String, String> component3() {
        return this.params;
    }

    public final CollectionInfo copy(@JSONField(name = "action_type") int r100, @JSONField(name = LiveCommonConstants.LOG_PARAM_EVENT_KEY) String r101, @JSONField(name = "params") HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "eventKey");
        return new CollectionInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectionInfo) == true) goto L8;
        return false;
    L8:
        CollectionInfo r101 = (CollectionInfo) r100;
        if (this.actionType == r101.actionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.eventKey, r101.eventKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.actionType * 31) + this.eventKey.hashCode()) * 31;
        HashMap<String, String> r101 = this.params;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CollectionInfo(actionType=" + this.actionType + ", eventKey=" + this.eventKey + ", params=" + this.params + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getEventKey() {
        return this.eventKey;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public CollectionInfo(@JSONField(name = "action_type") int r100, @JSONField(name = LiveCommonConstants.LOG_PARAM_EVENT_KEY) String r101, @JSONField(name = "params") HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "eventKey");
        this.actionType = r100;
        this.eventKey = r101;
        this.params = r102;
    }

    public /* synthetic */ CollectionInfo(int r100, String r101, HashMap r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101, r102);
    }
}
