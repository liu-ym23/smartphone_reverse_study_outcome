package v1c;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/profile_office/userprofile/model/DoubaoData;", "", "doubaoId", "", "doubaoNumber", "isUserInValid", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getDoubaoId", "()Ljava/lang/String;", "getDoubaoNumber", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("doubao_id")
    private final String doubaoId;

    @SerializedName("doubao_number")
    private final String doubaoNumber;

    @SerializedName("is_user_invalid")
    private final boolean isUserInValid;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.doubaoId, r101.doubaoId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doubaoNumber, r101.doubaoNumber) == true) goto L15;
        return false;
    L15:
        if (this.isUserInValid == r101.isUserInValid) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.doubaoId.hashCode() * 31) + this.doubaoNumber.hashCode()) * 31;
        if (this.isUserInValid == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoubaoData(doubaoId=" + this.doubaoId + ", doubaoNumber=" + this.doubaoNumber + ", isUserInValid=" + this.isUserInValid + ')';
    }

    public final String a() {
        return this.doubaoId;
    }

    public final String b() {
        return this.doubaoNumber;
    }

    public final boolean c() {
        return this.isUserInValid;
    }

    public /* synthetic */ a(int r100) {
        this("", "", false);
    }

    public a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "doubaoId");
        Intrinsics.checkNotNullParameter(r101, "doubaoNumber");
        this.doubaoId = r100;
        this.doubaoNumber = r101;
        this.isUserInValid = r102;
    }
}
