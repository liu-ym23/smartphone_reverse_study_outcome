package com.larus.business.debug.base.register.favorite.network.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceUpdateRequestBean;", "", "uid", "", "platform", "data", "Lorg/json/JSONArray;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)V", "getUid", "()Ljava/lang/String;", "getPlatform", "getData", "()Lorg/json/JSONArray;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FavoriteEntranceUpdateRequestBean {

    @SerializedName("data")
    private final JSONArray data;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("uid")
    private final String uid;

    public FavoriteEntranceUpdateRequestBean() {
        this(null, null, null, 7, null);
    }

    public final JSONArray getData() {
        return this.data;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getUid() {
        return this.uid;
    }

    public FavoriteEntranceUpdateRequestBean(String r100, String r101, JSONArray r102) {
        this.uid = r100;
        this.platform = r101;
        this.data = r102;
    }

    public /* synthetic */ FavoriteEntranceUpdateRequestBean(String r100, String r101, JSONArray r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new JSONArray();
    L11:
        this(r100, r101, r102);
    }
}
