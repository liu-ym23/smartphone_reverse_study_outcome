package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CardProtocolType;", "Ljava/io/Serializable;", "()V", "cardType", "", "getCardType", "()Ljava/lang/String;", "setCardType", "(Ljava/lang/String;)V", "genreType", "Lcom/ss/android/ugc/aweme/discover/model/GenreType;", "getGenreType", "()Lcom/ss/android/ugc/aweme/discover/model/GenreType;", "setGenreType", "(Lcom/ss/android/ugc/aweme/discover/model/GenreType;)V", "kindType", "getKindType", "setKindType", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardProtocolType implements Serializable {
    public static final String AI_PRODUCT = "ai_product";
    public static final String COMMODITY = "commodity";
    public static final String COT = "cot";
    public static final Companion Companion = null;
    public static final String ECOM_GOODS = "ecom_goods";
    public static final String LIVE = "live";
    public static final String SUMMARY = "summary";
    public static final String VIDEO = "video";

    @SerializedName(a.KEY_CARD_TYPE)
    private String cardType;

    @SerializedName("genre_type")
    private GenreType genreType;

    @SerializedName("kind_type")
    private String kindType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CardProtocolType$Companion;", "", "()V", "AI_PRODUCT", "", "COMMODITY", "COT", "ECOM_GOODS", "LIVE", "SUMMARY", "VIDEO", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public CardProtocolType() {
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final GenreType getGenreType() {
        return this.genreType;
    }

    public final String getKindType() {
        return this.kindType;
    }

    public final void setCardType(String r100) {
        this.cardType = r100;
    }

    public final void setGenreType(GenreType r100) {
        this.genreType = r100;
    }

    public final void setKindType(String r100) {
        this.kindType = r100;
    }
}
