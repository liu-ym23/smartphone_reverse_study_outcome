package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J$\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIControlInfoResponse;", "Ljava/io/Serializable;", "askUseable", "", "isEnable", "<init>", "(Ljava/lang/Boolean;Z)V", "getAskUseable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "component1", "component2", "copy", "(Ljava/lang/Boolean;Z)Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIControlInfoResponse;", "equals", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIControlInfoResponse implements Serializable {

    @SerializedName("ask_useable")
    private final Boolean askUseable;

    @SerializedName(MapMonitorConst.IS_ENABLE)
    private final boolean isEnable;

    /* JADX WARN: Multi-variable type inference failed */
    public KnowledgeAIControlInfoResponse() {
        Boolean r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ KnowledgeAIControlInfoResponse copy$default(KnowledgeAIControlInfoResponse r100, Boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.askUseable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isEnable;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.askUseable;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final KnowledgeAIControlInfoResponse copy(Boolean r100, boolean r101) {
        return new KnowledgeAIControlInfoResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KnowledgeAIControlInfoResponse) == true) goto L8;
        return false;
    L8:
        KnowledgeAIControlInfoResponse r101 = (KnowledgeAIControlInfoResponse) r100;
        if (Intrinsics.areEqual(this.askUseable, r101.askUseable) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r101.isEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.askUseable;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.isEnable == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeAIControlInfoResponse(askUseable=" + this.askUseable + ", isEnable=" + this.isEnable + ')';
    }

    public final Boolean getAskUseable() {
        return this.askUseable;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public KnowledgeAIControlInfoResponse(Boolean r100, boolean r101) {
        this.askUseable = r100;
        this.isEnable = r101;
    }

    public /* synthetic */ KnowledgeAIControlInfoResponse(Boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
