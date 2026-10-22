package gi3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lgi3/a;", "", "", "url", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "initData", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "logData", "d", "extraData", "b", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", "a", "()Lcom/bytedance/android/ec/core/btm/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public static final /* synthetic */ int b = 0;
    public final String a;

    @SerializedName("btm_fields")
    private final com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("extra_data")
    private final Map<String, Object> extraData;

    @SerializedName("init_data")
    private final Map<String, Object> initData;

    @SerializedName("log_data")
    private final Map<String, Object> logData;

    @SerializedName("url")
    private final String url;

    /* JADX INFO: renamed from: gi3.a$a, reason: collision with other inner class name */
    public static final class C0200a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.initData, r4.initData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logData, r4.logData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extraData, r4.extraData) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.btmFields, r4.btmFields) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.a;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.initData;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.logData;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, Object> r13 = this.extraData;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        com.bytedance.android.ec.core.btm.a r16 = this.btmFields;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "HybridDialogParam(url=" + this.url + ", settingsKey=" + this.a + ", initData=" + this.initData + ", logData=" + this.logData + ", extraData=" + this.extraData + ", btmFields=" + this.btmFields + ")";
    }

    public final com.bytedance.android.ec.core.btm.a a() {
        return this.btmFields;
    }

    public final Map<String, Object> b() {
        return this.extraData;
    }

    public final Map<String, Object> c() {
        return this.initData;
    }

    public final Map<String, Object> d() {
        return this.logData;
    }

    public final String e() {
        return this.url;
    }

    public a(String r1, String r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4, Map<String, ? extends Object> r5, com.bytedance.android.ec.core.btm.a r6) {
        this.url = r1;
        this.a = r2;
        this.initData = r3;
        this.logData = r4;
        this.extraData = r5;
        this.btmFields = r6;
    }
}
