package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/o;", "", "", "seriesId", "Ljava/lang/String;", "getSeriesId", "()Ljava/lang/String;", "setSeriesId", "(Ljava/lang/String;)V", "seriesName", "getSeriesName", "setSeriesName", "coverUrl", "getCoverUrl", "setCoverUrl", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class o {

    @SerializedName("cover_url")
    private String coverUrl;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("series_id")
    private String seriesId;

    @SerializedName("series_name")
    private String seriesName;

    public o() {
    }
}
