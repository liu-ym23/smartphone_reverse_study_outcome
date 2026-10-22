package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/search/dto/info/AnswerInChatSearchInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "llmQuery", "", "<init>", "(Ljava/lang/String;)V", "getLlmQuery", "()Ljava/lang/String;", "getId", "getTagForReport", "getResultTypeForReport", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnswerInChatSearchInfo extends SearchBaseInfo {
    public static final a Companion = null;
    public static final String HAS_RESULT_ID = "enterprise_qa_result";
    public static final String NO_RESULT_ID = "enterprise_qa_no_result";
    private final String llmQuery;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getId() {
        return "enterprise_qa_result";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return SearchAiInfo.DEFAULT_ID;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        return "enterprise_qa_section";
    }

    public final String getLlmQuery() {
        return this.llmQuery;
    }

    public AnswerInChatSearchInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "llmQuery");
        this.llmQuery = r100;
    }
}
