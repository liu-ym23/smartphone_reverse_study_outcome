package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/UserService;", "Ljava/io/Serializable;", "()V", "backgroudDark", "", "getBackgroudDark", "()Ljava/lang/String;", "backgroudLight", "getBackgroudLight", "buttonType", "getButtonType", "entryIcon", "Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "getEntryIcon", "()Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "textTag", "Lcom/ss/android/ugc/aweme/discover/model/TextTag;", "getTextTag", "()Lcom/ss/android/ugc/aweme/discover/model/TextTag;", "url", "getUrl", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserService implements Serializable {

    @SerializedName("background_dark")
    private final String backgroudDark;

    @SerializedName("background_light")
    private final String backgroudLight;

    @SerializedName(a.KEY_BUTTON_TYPE)
    private final String buttonType;

    @SerializedName("entry_icon")
    private final UrlStruct entryIcon;

    @SerializedName("text_tag")
    private final TextTag textTag;

    @SerializedName("url")
    private final String url;

    public UserService() {
    }

    public final String getBackgroudDark() {
        return this.backgroudDark;
    }

    public final String getBackgroudLight() {
        return this.backgroudLight;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final UrlStruct getEntryIcon() {
        return this.entryIcon;
    }

    public final TextTag getTextTag() {
        return this.textTag;
    }

    public final String getUrl() {
        return this.url;
    }
}
