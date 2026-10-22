package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHomeStyleInfoVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/store/home/entity/p;", "decorationStyleDTO", "Lcom/bytedance/android/shopping/store/home/entity/p;", "getDecorationStyleDTO", "()Lcom/bytedance/android/shopping/store/home/entity/p;", "setDecorationStyleDTO", "(Lcom/bytedance/android/shopping/store/home/entity/p;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHomeStyleInfoVO implements Serializable {

    @SerializedName("decoration_style")
    private p decorationStyleDTO;

    public ECStoreHomeStyleInfoVO() {
    }

    public final p getDecorationStyleDTO() {
        return this.decorationStyleDTO;
    }

    public final void setDecorationStyleDTO(p r1) {
        this.decorationStyleDTO = r1;
    }
}
