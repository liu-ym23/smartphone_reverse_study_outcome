package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SidingInfoItem;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortItem;", "", "fromFormat", "Ljava/lang/String;", "getFromFormat", "()Ljava/lang/String;", "setFromFormat", "(Ljava/lang/String;)V", "toFormat", "getToFormat", "setToFormat", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "fromImage", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getFromImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setFromImage", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "toImage", "getToImage", "setToImage", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SidingInfoItem extends SortItem {

    @SerializedName(SubInfo.KEY_FORMAT)
    private String fromFormat;

    @SerializedName("image")
    private UrlModel fromImage;

    @SerializedName("to_format")
    private String toFormat;

    @SerializedName("to_image")
    private UrlModel toImage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SidingInfoItem$Companion;", "", "()V", "CHANGE_FORMAT", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public SidingInfoItem() {
    }
}
