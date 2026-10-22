package ij3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lij3/c;", "", "", "nickName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "userAvatars", "Ljava/util/List;", "d", "()Ljava/util/List;", "marqueeText", "a", "", "marqueeType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("marquee_text")
    private final String marqueeText;

    @SerializedName("marquee_type")
    private final Integer marqueeType;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("user_avatars")
    private final List<ECUrlModel> userAvatars;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userAvatars, r4.userAvatars) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.marqueeText, r4.marqueeText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marqueeType, r4.marqueeType) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.nickName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ECUrlModel> r4 = this.userAvatars;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.marqueeText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.marqueeType;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECStoreTopMultiMarqueeItemDTO(nickName=" + this.nickName + ", userAvatars=" + this.userAvatars + ", marqueeText=" + this.marqueeText + ", marqueeType=" + this.marqueeType + ")";
    }

    public c() {
        this.nickName = null;
        this.userAvatars = null;
        this.marqueeText = null;
        this.marqueeType = null;
    }

    public final String a() {
        return this.marqueeText;
    }

    public final Integer b() {
        return this.marqueeType;
    }

    public final String c() {
        return this.nickName;
    }

    public final List<ECUrlModel> d() {
        return this.userAvatars;
    }
}
