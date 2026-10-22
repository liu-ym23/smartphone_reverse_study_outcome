package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/UserServiceInfo;", "Ljava/io/Serializable;", "()V", "leftItem", "Lcom/ss/android/ugc/aweme/discover/model/UserService;", "getLeftItem", "()Lcom/ss/android/ugc/aweme/discover/model/UserService;", "rightItem", "getRightItem", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserServiceInfo implements Serializable {

    @SerializedName("left_item")
    private final UserService leftItem;

    @SerializedName("right_item")
    private final UserService rightItem;

    public UserServiceInfo() {
    }

    public final UserService getLeftItem() {
        return this.leftItem;
    }

    public final UserService getRightItem() {
        return this.rightItem;
    }
}
