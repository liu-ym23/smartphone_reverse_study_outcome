package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012,\b\u0002\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003JA\u0010\u0010\u001a\u00020\u00002,\b\u0002\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R:\u0010\u0002\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIScopeResp;", "Ljava/io/Serializable;", "tokensInfo", "Ljava/util/HashMap;", "", "Lcom/bytedance/ee/bear/document/ai/knowledgeai/KnowledgeAIScopeTokenInfo;", "Lkotlin/collections/HashMap;", "isVcMeetingNote", "", "<init>", "(Ljava/util/HashMap;Z)V", "getTokensInfo", "()Ljava/util/HashMap;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIScopeResp implements Serializable {

    @SerializedName("is_vc_meeting_note")
    private final boolean isVcMeetingNote;

    @SerializedName("tokens_info")
    private final HashMap<String, KnowledgeAIScopeTokenInfo> tokensInfo;

    public KnowledgeAIScopeResp() {
        HashMap r2 = null;
        this(r2, false, 3, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIScopeResp copy$default(KnowledgeAIScopeResp r0, HashMap r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.tokensInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isVcMeetingNote;
    L9:
        return r0.copy(r1, r2);
    }

    public final HashMap<String, KnowledgeAIScopeTokenInfo> component1() {
        return this.tokensInfo;
    }

    public final boolean component2() {
        return this.isVcMeetingNote;
    }

    public final KnowledgeAIScopeResp copy(HashMap<String, KnowledgeAIScopeTokenInfo> r2, boolean r3) {
        return new KnowledgeAIScopeResp(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KnowledgeAIScopeResp) == true) goto L8;
        return false;
    L8:
        KnowledgeAIScopeResp r6 = (KnowledgeAIScopeResp) r5;
        if (Intrinsics.areEqual(this.tokensInfo, r6.tokensInfo) == true) goto L12;
        return false;
    L12:
        if (this.isVcMeetingNote == r6.isVcMeetingNote) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        HashMap<String, KnowledgeAIScopeTokenInfo> r0 = this.tokensInfo;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.isVcMeetingNote == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeAIScopeResp(tokensInfo=" + this.tokensInfo + ", isVcMeetingNote=" + this.isVcMeetingNote + ')';
    }

    public final HashMap<String, KnowledgeAIScopeTokenInfo> getTokensInfo() {
        return this.tokensInfo;
    }

    public final boolean isVcMeetingNote() {
        return this.isVcMeetingNote;
    }

    public KnowledgeAIScopeResp(HashMap<String, KnowledgeAIScopeTokenInfo> r1, boolean r2) {
        this.tokensInfo = r1;
        this.isVcMeetingNote = r2;
    }

    public /* synthetic */ KnowledgeAIScopeResp(HashMap r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}
