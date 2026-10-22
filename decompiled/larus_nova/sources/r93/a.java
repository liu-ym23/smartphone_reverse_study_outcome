package r93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lr93/a;", "", "", "cardType", "Ljava/lang/Integer;", "getCardType", "()Ljava/lang/Integer;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final Integer cardType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f536704id;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f536704id, r101.f536704id) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.cardType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f536704id;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallCardImpression(cardType=" + this.cardType + ", id=" + this.f536704id + ")";
    }

    public a(Integer r100, String r101) {
        this.cardType = r100;
        this.f536704id = r101;
    }
}
