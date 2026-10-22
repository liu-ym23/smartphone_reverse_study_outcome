package com.larus.business.debug.base.register.favorite.network.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/business/debug/base/register/favorite/network/bean/FavoriteEntranceUpdateResponseBean;", "", "success", "", "message", "", "data", "Lorg/json/JSONObject;", "<init>", "(ZLjava/lang/String;Lorg/json/JSONObject;)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getData", "()Lorg/json/JSONObject;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FavoriteEntranceUpdateResponseBean {

    @SerializedName("data")
    private final JSONObject data;

    @SerializedName("message")
    private final String message;

    @SerializedName("success")
    private final boolean success;

    public FavoriteEntranceUpdateResponseBean() {
        this(false, null, null, 7, null);
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public FavoriteEntranceUpdateResponseBean(boolean r100, String r101, JSONObject r102) {
        this.success = r100;
        this.message = r101;
        this.data = r102;
    }

    public /* synthetic */ FavoriteEntranceUpdateResponseBean(boolean r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
