package m11;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lm11/b;", "", "", "id", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "belongUserId", "b", "setBelongUserId", "(Ljava/lang/String;)V", "", "talking", "I", "e", "()I", ce.f26391f, "(I)V", "silenceStatus", "d", "f", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("belong_user_id")
    private String belongUserId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f511573id;

    @SerializedName("silence_status")
    private int silenceStatus;

    @SerializedName("talking")
    private int talking;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f511573id, r101.f511573id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.belongUserId, r101.belongUserId) == true) goto L10;
        return false;
    L10:
        if (this.talking == r101.talking) goto L12;
        return false;
    L12:
        if (this.silenceStatus == r101.silenceStatus) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f511573id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.belongUserId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((((r103 + r101) * 31) + this.talking) * 31) + this.silenceStatus;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AiAssistantTalkStatus(id=" + this.f511573id + ", belongUserId=" + this.belongUserId + ", talking=" + this.talking + ", silenceStatus=" + this.silenceStatus + ")";
    }

    public final String b() {
        return this.belongUserId;
    }

    public final String c() {
        return this.f511573id;
    }

    public final int d() {
        return this.silenceStatus;
    }

    public final int e() {
        return this.talking;
    }

    public static b a(b r100) {
        String r101 = r100.f511573id;
        String r102 = r100.belongUserId;
        int r103 = r100.talking;
        int r104 = r100.silenceStatus;
        r100.getClass();
        return new b(r101, r102, r103, r104);
    }

    public final void f(int r100) {
        this.silenceStatus = r100;
    }

    public final void g(int r100) {
        this.talking = r100;
    }

    public b(String r100, String r101, int r102, int r103) {
        this.f511573id = r100;
        this.belongUserId = r101;
        this.talking = r102;
        this.silenceStatus = r103;
    }
}
