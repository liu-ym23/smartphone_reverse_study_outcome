package com.ss.android.lark.intent.export.entity.input;

import java.io.Serializable;
import knb.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/QueryKnowledgeAIIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "query", "", "topicId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getTopicId", "toString", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryKnowledgeAIIntentInput extends IntentInput implements Serializable {
    private final String query;
    private final String topicId;

    public String toString() {
        StringBuilder r100 = new StringBuilder("QueryKnowledgeAIIntentInput(query=");
        String r101 = this.query;
        String r102 = "null";
        if (r101 == null) goto L6;
        String r103 = a.a(r101);
        if (r103 == null) goto L6;
    L7:
        r100.append(r103);
        r100.append(", topicId=");
        String r104 = this.topicId;
        if (r104 == null) goto L11;
        r102 = r104;
    L11:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L6:
        r103 = "null";
        goto L7
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public QueryKnowledgeAIIntentInput(String r100, String r101) {
        super(IntentInput.IntentType.QUERY_KNOWLEDGE_AI);
        this.query = r100;
        this.topicId = r101;
    }
}
