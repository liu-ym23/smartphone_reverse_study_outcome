package com.bytedance.android.shopping.store.repository.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\n¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/vo/SearchSuggestWord;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "id", "", "getId", "()Ljava/lang/String;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isDefaultWord", "", "()Z", "setDefaultWord", "(Z)V", "params", "Lcom/bytedance/android/shopping/store/repository/vo/SuggestWordParams;", "getParams", "()Lcom/bytedance/android/shopping/store/repository/vo/SuggestWordParams;", "trimWord", "getTrimWord", "setTrimWord", "(Ljava/lang/String;)V", "word", "getWord", "setWord", "wordsType", "getWordsType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWord implements Serializable {

    @SerializedName("words_icon")
    private final ECUrlModel icon;

    @SerializedName("id")
    private final String id;
    private int index;
    private boolean isDefaultWord;

    @SerializedName("params")
    private final SuggestWordParams params;
    private String trimWord;

    @SerializedName("word")
    private String word;

    @SerializedName("words_type")
    private final String wordsType;

    public SearchSuggestWord() {
    }

    public final ECUrlModel getIcon() {
        return this.icon;
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

    public final String getTrimWord() {
        return this.trimWord;
    }

    public final String getWord() {
        return this.word;
    }

    public final String getWordsType() {
        return this.wordsType;
    }

    public final boolean isDefaultWord() {
        return this.isDefaultWord;
    }

    public final void setDefaultWord(boolean r1) {
        this.isDefaultWord = r1;
    }

    public final void setIndex(int r1) {
        this.index = r1;
    }

    public final void setTrimWord(String r1) {
        this.trimWord = r1;
    }

    public final void setWord(String r1) {
        this.word = r1;
    }
}
