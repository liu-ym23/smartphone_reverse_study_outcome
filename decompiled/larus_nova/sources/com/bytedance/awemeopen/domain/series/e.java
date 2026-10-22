package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/e;", "", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/Integer;", "getChannelId", "()Ljava/lang/Integer;", "setChannelId", "(Ljava/lang/Integer;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "", "Lcom/bytedance/awemeopen/domain/series/j;", "openAlbumInfo", "Ljava/util/List;", "getOpenAlbumInfo", "()Ljava/util/List;", "setOpenAlbumInfo", "(Ljava/util/List;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class e implements Cloneable {

    @SerializedName(RemoteMessageConst.Notification.CHANNEL_ID)
    private Integer channelId;

    @SerializedName("series_info")
    private List<j> openAlbumInfo;

    @SerializedName("title")
    private String title;

    public e() {
    }

    public final Object clone() {
        return super.clone();
    }
}
