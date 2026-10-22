package sj3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lsj3/j;", "", "", "giftType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "giftData", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/android/ec/store/repository/dto/d;", "giftDecorationModule", "Lcom/bytedance/android/ec/store/repository/dto/d;", "b", "()Lcom/bytedance/android/ec/store/repository/dto/d;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("gift_data")
    private final String giftData;

    @SerializedName("gift_decoration_module")
    private final com.bytedance.android.ec.store.repository.dto.d giftDecorationModule;

    @SerializedName("gift_type")
    private final Integer giftType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.giftType, r101.giftType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.giftData, r101.giftData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.giftDecorationModule, r101.giftDecorationModule) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.giftType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.giftData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.android.ec.store.repository.dto.d r107 = this.giftDecorationModule;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreV3FollowGiftDTO(giftType=" + this.giftType + ", giftData=" + this.giftData + ", giftDecorationModule=" + this.giftDecorationModule + ")";
    }

    public j() {
        this.giftType = null;
        this.giftData = null;
        this.giftDecorationModule = null;
    }

    public final String a() {
        return this.giftData;
    }

    public final com.bytedance.android.ec.store.repository.dto.d b() {
        return this.giftDecorationModule;
    }

    public final Integer c() {
        return this.giftType;
    }
}
