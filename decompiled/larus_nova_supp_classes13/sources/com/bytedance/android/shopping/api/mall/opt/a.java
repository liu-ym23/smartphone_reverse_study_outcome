package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/a;", "", "", "enable", "Z", "b", "()Z", "", "", "domains", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "expireDuration", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("domains")
    private final List<String> domains;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("expire_duration")
    private final Long expireDuration;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.opt.a$a, reason: collision with other inner class name */
    public static final class C0023a {
    }

    static {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.domains, r4.domains) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.expireDuration, r4.expireDuration) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.domains;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        Long r7 = this.expireDuration;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "ECMallDomainPreConnectConfig(enable=" + this.enable + ", domains=" + this.domains + ", expireDuration=" + this.expireDuration + ")";
    }

    public final List<String> a() {
        return this.domains;
    }

    public final boolean b() {
        return this.enable;
    }

    public final Long c() {
        return this.expireDuration;
    }

    public a(Object r1) {
        this.enable = false;
        this.domains = null;
        this.expireDuration = null;
    }
}
