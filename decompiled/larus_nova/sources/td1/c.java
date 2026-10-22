package td1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltd1/c;", "", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "createTime", "J", "b", "()J", "", "duration", "I", "c", "()I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("content")
    private final String content;

    @SerializedName(alternate = {"create_time"}, value = "createtime")
    private final long createTime;

    @SerializedName("duration")
    private final int duration;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (this.createTime == r101.createTime) goto L10;
        return false;
    L10:
        if (this.duration == r101.duration) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.content;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.createTime;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.duration;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "AdminSendPrompt(content=" + this.content + ", createTime=" + this.createTime + ", duration=" + this.duration + ")";
    }

    public final String a() {
        return this.content;
    }

    public final long b() {
        return this.createTime;
    }

    public final int c() {
        return this.duration;
    }
}
