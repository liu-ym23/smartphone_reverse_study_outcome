package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "maxLine", "J", "a", "()J", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", LocationMonitorConst.TAG, "Ljava/util/List;", "c", "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SerializedName("max_line")
    private final long maxLine;

    @SerializedName("name")
    private String name;

    @SerializedName(LocationMonitorConst.TAG)
    private final List<ECRitTag> tag;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o0) == false) goto L12;
        o0 r7 = (o0) r6;
        if (Intrinsics.areEqual(this.name, r7.name) == true) goto L8;
        return false;
    L8:
        if (this.maxLine == r7.maxLine) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tag, r7.tag) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.maxLine;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        List<ECRitTag> r5 = this.tag;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroTitle(name=" + this.name + ", maxLine=" + this.maxLine + ", tag=" + this.tag + ")";
    }

    public o0() {
        this.name = null;
        this.maxLine = 0;
        this.tag = null;
    }

    public final long a() {
        return this.maxLine;
    }

    public final String b() {
        return this.name;
    }

    public final List<ECRitTag> c() {
        return this.tag;
    }

    public final void d(String r1) {
        this.name = r1;
    }
}
