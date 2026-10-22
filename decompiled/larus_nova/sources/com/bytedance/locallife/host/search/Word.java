package com.bytedance.locallife.host.search;

import com.bytedance.locallife.host.model.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007B\u0007\b\u0016¢\u0006\u0002\u0010\bJ\u0013\u0010:\u001a\u00020\u000b2\b\u0010;\u001a\u0004\u0018\u00010<H\u0096\u0002J\b\u0010=\u001a\u00020/H\u0016R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\u001c\u00107\u001a\u00020/8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103¨\u0006>"}, d2 = {"Lcom/bytedance/locallife/host/search/Word;", "Ljava/io/Serializable;", "id", "", EffectConfiguration.KEY_SEARCH_WORD, "(Ljava/lang/String;Ljava/lang/String;)V", "imprId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "_wordType", "forceUpdateRank", "", "getForceUpdateRank", "()Ljava/lang/Boolean;", "setForceUpdateRank", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getImprId", "setImprId", "isMasked", "()Z", "setMasked", "(Z)V", "isShowed", "setShowed", "params", "Lcom/bytedance/locallife/host/search/Params;", "getParams", "()Lcom/bytedance/locallife/host/search/Params;", "setParams", "(Lcom/bytedance/locallife/host/search/Params;)V", "productId", "getProductId", "setProductId", "getWord", "setWord", "wordImg", "Lcom/bytedance/locallife/host/model/UrlModel;", "getWordImg", "()Lcom/bytedance/locallife/host/model/UrlModel;", "setWordImg", "(Lcom/bytedance/locallife/host/model/UrlModel;)V", "wordPosition", "", "getWordPosition", "()I", "setWordPosition", "(I)V", "wordSource", "getWordSource", "setWordSource", "wordType", "getWordType", "setWordType", "equals", "other", "", "hashCode", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Word implements Serializable {

    @SerializedName("words_type")
    private String _wordType;

    @SerializedName("force_update_rank")
    private Boolean forceUpdateRank;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(alternate = {"group_id"}, value = "id")
    private String f258918id;

    @SerializedName("impr_id")
    private String imprId;
    private boolean isMasked;
    private boolean isShowed;

    @SerializedName("params")
    private Params params;

    @SerializedName("product_id")
    private String productId;

    @SerializedName(alternate = {"words_content"}, value = EffectConfiguration.KEY_SEARCH_WORD)
    private String word;

    @SerializedName("words_image")
    private UrlModel wordImg;

    @SerializedName("words_position")
    private int wordPosition;

    @SerializedName("words_source")
    private String wordSource;
    private int wordType;

    public final int getWordType() {
        String r100 = this._wordType;
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public int hashCode() {
        String r100 = this.word;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public Word() {
        this._wordType = "0";
    }

    public final Boolean getForceUpdateRank() {
        return this.forceUpdateRank;
    }

    public final String getId() {
        return this.f258918id;
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

    public final boolean isMasked() {
        return this.isMasked;
    }

    public final boolean isShowed() {
        return this.isShowed;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(Word.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.host.search.Word");
        if (Intrinsics.areEqual(this.word, ((Word) r100).word) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setForceUpdateRank(Boolean r100) {
        this.forceUpdateRank = r100;
    }

    public final void setId(String r100) {
        this.f258918id = r100;
    }

    public final void setImprId(String r100) {
        this.imprId = r100;
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

    public final void setShowed(boolean r100) {
        this.isShowed = r100;
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
        this.f258918id = r100;
        this.word = r101;
    }

    public Word(String r100, String r101, String r102) {
        this._wordType = "0";
        this.f258918id = r100;
        this.word = r101;
        this.imprId = r102;
    }
}
