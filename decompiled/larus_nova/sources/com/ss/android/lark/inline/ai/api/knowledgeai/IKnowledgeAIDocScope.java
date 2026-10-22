package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIDocScope;", "Ljava/io/Serializable;", "objType", "", "getObjType", "()Ljava/lang/Long;", "docType", "getDocType", "hasChild", "", "getHasChild", "()Ljava/lang/Boolean;", "isShareFolder", "docSubType", "", "getDocSubType", "()Ljava/lang/Integer;", "spaceId", "", "getSpaceId", "()Ljava/lang/String;", "objToken", "getObjToken", "nodeToken", "getNodeToken", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKnowledgeAIDocScope extends Serializable {
    Integer getDocSubType();

    Long getDocType();

    Boolean getHasChild();

    String getNodeToken();

    String getObjToken();

    Long getObjType();

    String getSpaceId();

    Boolean isShareFolder();
}
