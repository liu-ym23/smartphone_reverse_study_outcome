package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.TextConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", "Ljava/io/Serializable;", "()V", "picConfig", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/PicConfig;", "getPicConfig", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/PicConfig;", "textConfig", "Lcom/ss/android/ugc/aweme/discover/model/TextConfig;", "getTextConfig", "()Lcom/ss/android/ugc/aweme/discover/model/TextConfig;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardTitle implements Serializable {

    @SerializedName("pic_config")
    private final PicConfig picConfig;

    @SerializedName("text_config")
    private final TextConfig textConfig;

    public CardTitle() {
    }

    public final PicConfig getPicConfig() {
        return this.picConfig;
    }

    public final TextConfig getTextConfig() {
        return this.textConfig;
    }
}
