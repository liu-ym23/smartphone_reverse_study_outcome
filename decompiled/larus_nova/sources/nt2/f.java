package nt2;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lnt2/f;", "", "", "messageName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "messageDataUrl", "b", "testData", "d", "", "effectImmediately", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName(BasicTestActionHandler.TAKE_EFFECT_NOW)
    private final boolean effectImmediately;

    @SerializedName("data_url")
    private final String messageDataUrl;

    @SerializedName("name")
    private final String messageName;

    @SerializedName("test_data")
    private final String testData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.messageName, r101.messageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.messageDataUrl, r101.messageDataUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.testData, r101.testData) == true) goto L12;
        return false;
    L12:
        if (this.effectImmediately == r101.effectImmediately) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.messageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageDataUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.testData;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.effectImmediately;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SchemaMessageBean(messageName=" + this.messageName + ", messageDataUrl=" + this.messageDataUrl + ", testData=" + this.testData + ", effectImmediately=" + this.effectImmediately + ")";
    }

    public final boolean a() {
        return this.effectImmediately;
    }

    public final String b() {
        return this.messageDataUrl;
    }

    public final String c() {
        return this.messageName;
    }

    public final String d() {
        return this.testData;
    }
}
