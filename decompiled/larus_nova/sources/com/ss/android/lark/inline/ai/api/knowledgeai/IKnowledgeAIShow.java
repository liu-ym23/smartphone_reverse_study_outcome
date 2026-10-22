package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIShow;", "Ljava/io/Serializable;", "show", "", "getShow", "()Z", "bizParams", "", "", "", "getBizParams", "()Ljava/util/Map;", "trackerParams", "getTrackerParams", "quote", "getQuote", "()Ljava/lang/String;", "query", "getQuery", "sendRequest", "getSendRequest", "disableScopeItem", "getDisableScopeItem", "()Ljava/lang/Boolean;", "scene", "", "getScene", "()Ljava/lang/Integer;", "topicId", "getTopicId", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKnowledgeAIShow extends Serializable {
    Map<String, Object> getBizParams();

    Boolean getDisableScopeItem();

    String getQuery();

    String getQuote();

    Integer getScene();

    boolean getSendRequest();

    boolean getShow();

    String getTopicId();

    Map<String, Object> getTrackerParams();
}
