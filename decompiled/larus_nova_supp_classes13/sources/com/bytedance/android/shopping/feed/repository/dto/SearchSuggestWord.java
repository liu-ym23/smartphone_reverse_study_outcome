package com.bytedance.android.shopping.feed.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/SearchSuggestWord;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "params", "Lcom/bytedance/android/shopping/feed/repository/dto/SuggestWordParams;", "getParams", "()Lcom/bytedance/android/shopping/feed/repository/dto/SuggestWordParams;", "word", "getWord", "wordsType", "getWordsType", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWord implements Serializable {

    @SerializedName("id")
    private final String id;
    private int index;

    @SerializedName("params")
    private final SuggestWordParams params;

    @SerializedName("word")
    private final String word;

    @SerializedName("words_type")
    private final String wordsType;

    public SearchSuggestWord() {
    }

    public final String getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final SuggestWordParams getParams() {
        return this.params;
    }

    public final String getWord() {
        return this.word;
    }

    public final String getWordsType() {
        return this.wordsType;
    }

    public final void setIndex(int r1) {
        this.index = r1;
    }
}
