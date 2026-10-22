package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/IAiScopeItemI18nText;", "Ljava/io/Serializable;", "fallbackText", "", "getFallbackText", "()Ljava/lang/String;", "i18nKey", "getI18nKey", "defaultText", "getDefaultText", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAiScopeItemI18nText extends Serializable {
    String getDefaultText();

    String getFallbackText();

    String getI18nKey();
}
