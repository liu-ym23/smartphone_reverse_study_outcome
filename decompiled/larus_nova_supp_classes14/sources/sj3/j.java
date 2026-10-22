package sj3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lsj3/j;", "", "", "giftType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "giftData", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/store/repository/dto/d;", "giftDecorationModule", "Lcom/bytedance/android/ec/store/repository/dto/d;", "b", "()Lcom/bytedance/android/ec/store/repository/dto/d;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("gift_data")
    private final String giftData;

    @SerializedName("gift_decoration_module")
    private final com.bytedance.android.ec.store.repository.dto.d giftDecorationModule;

    @SerializedName("gift_type")
    private final Integer giftType;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L12;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.giftType, r4.giftType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.giftData, r4.giftData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.giftDecorationModule, r4.giftDecorationModule) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.giftType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.giftData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        com.bytedance.android.ec.store.repository.dto.d r7 = this.giftDecorationModule;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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
