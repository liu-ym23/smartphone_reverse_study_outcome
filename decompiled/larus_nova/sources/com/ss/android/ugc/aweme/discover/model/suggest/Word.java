package com.ss.android.ugc.aweme.discover.model.suggest;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B\u0007\b\u0016¢\u0006\u0002\u0010\bJ\u0006\u0010E\u001a\u00020\u0000J\u0013\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010HH\u0097\u0002J\b\u0010I\u001a\u00020:H\u0017J\b\u0010J\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R \u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010?\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001c\u0010B\u001a\u00020:8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>¨\u0006K"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/suggest/Word;", "Ljava/io/Serializable;", "id", "", EffectConfiguration.KEY_SEARCH_WORD, "(Ljava/lang/String;Ljava/lang/String;)V", "imprId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "_wordType", "forceUpdateRank", "", "getForceUpdateRank", "()Ljava/lang/Boolean;", "setForceUpdateRank", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getImprId", "setImprId", "isCachedWord", "()Z", "setCachedWord", "(Z)V", "isCardEffect", "setCardEffect", "isLocalWord", "setLocalWord", "isMasked", "setMasked", "isShowed", "setShowed", "isSpringTask", "setSpringTask", "params", "Lcom/ss/android/ugc/aweme/discover/model/suggest/Params;", "getParams", "()Lcom/ss/android/ugc/aweme/discover/model/suggest/Params;", "setParams", "(Lcom/ss/android/ugc/aweme/discover/model/suggest/Params;)V", "productId", "getProductId", "setProductId", "requestId", "getRequestId", "setRequestId", "getWord", "setWord", "wordImg", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getWordImg", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setWordImg", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "wordPosition", "", "getWordPosition", "()I", "setWordPosition", "(I)V", "wordSource", "getWordSource", "setWordSource", "wordType", "getWordType", "setWordType", "copyForStore", "equals", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Word implements Serializable {

    @SerializedName("words_type")
    private String _wordType;

    @SerializedName("force_update_rank")
    private Boolean forceUpdateRank;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(alternate = {"group_id"}, value = "id")
    private String f450569id;

    @SerializedName("impr_id")
    private String imprId;
    private boolean isCachedWord;
    private boolean isCardEffect;
    private boolean isLocalWord;
    private boolean isMasked;
    private boolean isShowed;
    private boolean isSpringTask;

    @SerializedName("params")
    private Params params;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName(alternate = {"words_content"}, value = EffectConfiguration.KEY_SEARCH_WORD)
    private String word;

    @SerializedName("words_image")
    private UrlModel wordImg;

    @SerializedName("words_position")
    private int wordPosition;

    @SerializedName("words_source")
    private String wordSource;
    private int wordType;

    public final Word copyForStore() {
        Word r100 = new Word();
        r100.f450569id = this.f450569id;
        r100.word = this.word;
        r100.wordPosition = this.wordPosition;
        r100.wordSource = this.wordSource;
        Params r101 = this.params;
        if (r101 == null) goto L5;
        Params r102 = r101.copyForStore();
    L6:
        r100.params = r102;
        r100.imprId = this.imprId;
        r100.wordImg = this.wordImg;
        r100.forceUpdateRank = this.forceUpdateRank;
        r100.productId = this.productId;
        r100._wordType = this._wordType;
        r100.requestId = this.requestId;
        r100.isShowed = this.isShowed;
        r100.isMasked = this.isMasked;
        r100.isLocalWord = this.isLocalWord;
        r100.isSpringTask = this.isSpringTask;
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    @AllowImpl
    public final int getWordType() {
        String r100 = this._wordType;
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    @AllowImpl
    public int hashCode() {
        String r100 = this.word;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new GsonBuilder().create(), this);
    }

    public Word() {
        this._wordType = "0";
        this.requestId = "";
    }

    public final Boolean getForceUpdateRank() {
        return this.forceUpdateRank;
    }

    public final String getId() {
        return this.f450569id;
    }

    public final String getImprId() {
        return this.imprId;
    }

    public final Params getParams() {
        return this.params;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getWord() {
        return this.word;
    }

    public final UrlModel getWordImg() {
        return this.wordImg;
    }

    public final int getWordPosition() {
        return this.wordPosition;
    }

    public final String getWordSource() {
        return this.wordSource;
    }

    public final boolean isCachedWord() {
        return this.isCachedWord;
    }

    public final boolean isCardEffect() {
        return this.isCardEffect;
    }

    public final boolean isLocalWord() {
        return this.isLocalWord;
    }

    public final boolean isMasked() {
        return this.isMasked;
    }

    public final boolean isShowed() {
        return this.isShowed;
    }

    public final boolean isSpringTask() {
        return this.isSpringTask;
    }

    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(Word.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(this.word, ((Word) r100).word)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.discover.model.suggest.Word");
    L8:
        r101 = null;
        goto L10
    }

    public final void setCachedWord(boolean r100) {
        this.isCachedWord = r100;
    }

    public final void setCardEffect(boolean r100) {
        this.isCardEffect = r100;
    }

    public final void setForceUpdateRank(Boolean r100) {
        this.forceUpdateRank = r100;
    }

    public final void setId(String r100) {
        this.f450569id = r100;
    }

    public final void setImprId(String r100) {
        this.imprId = r100;
    }

    public final void setLocalWord(boolean r100) {
        this.isLocalWord = r100;
    }

    public final void setMasked(boolean r100) {
        this.isMasked = r100;
    }

    public final void setParams(Params r100) {
        this.params = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    public final void setShowed(boolean r100) {
        this.isShowed = r100;
    }

    public final void setSpringTask(boolean r100) {
        this.isSpringTask = r100;
    }

    public final void setWord(String r100) {
        this.word = r100;
    }

    public final void setWordImg(UrlModel r100) {
        this.wordImg = r100;
    }

    public final void setWordPosition(int r100) {
        this.wordPosition = r100;
    }

    public final void setWordSource(String r100) {
        this.wordSource = r100;
    }

    public final void setWordType(int r100) {
        this.wordType = r100;
    }

    public Word(String r100, String r101) {
        this._wordType = "0";
        this.requestId = "";
        this.f450569id = r100;
        this.word = r101;
    }

    public Word(String r100, String r101, String r102) {
        this._wordType = "0";
        this.requestId = "";
        this.f450569id = r100;
        this.word = r101;
        this.imprId = r102;
    }
}
