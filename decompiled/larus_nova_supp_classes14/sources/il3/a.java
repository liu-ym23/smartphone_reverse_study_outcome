package il3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lil3/a;", "", "", "popupCode", "Ljava/lang/String;", "getPopupCode", "()Ljava/lang/String;", "setPopupCode", "(Ljava/lang/String;)V", "nodeKey", "getNodeKey", "setNodeKey", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("id")
    private String nodeKey;

    @SerializedName("params")
    private Map<String, Object> params;

    @SerializedName("popup_code")
    private String popupCode;

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.popupCode, r4.popupCode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nodeKey, r4.nodeKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.popupCode;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.nodeKey;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.params;
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
        return "HybridPopupConfig(popupCode=" + this.popupCode + ", nodeKey=" + this.nodeKey + ", params=" + this.params + ")";
    }

    public final String b() {
        String r0 = this.nodeKey;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r4 = null;
        if (r3 == false) goto L19;
        Map<String, Object> r2 = this.params;
        if (r2 == null) goto L14;
        Object r5 = r2.get("key");
    L16:
        if ((r5 instanceof String) == true) goto L18;
        r5 = null;
    L18:
        r0 = (String) r5;
        goto L19
    L14:
        r5 = null;
    L19:
        if (r0 != null) goto L21;
    L22:
        r1 = true;
    L23:
        if (r1 == false) goto L28;
        UUID r6 = UUID.randomUUID();
        if (r6 == null) goto L27;
        r4 = r6.toString();
    L27:
        r0 = r4;
    L28:
        Intrinsics.checkNotNull(r0);
        return r0;
    L21:
        if (r0.length() != 0) goto L23;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final <ParamType> ParamType a(String r3, ParamType r4) {
        Map<String, Object> r0 = this.params;
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r5 = r0.get(r3);
    L7:
        if ((r5 instanceof Object) == false) goto L10;
        r1 = r5;
    L10:
        if (r1 != null) goto L13;
        return r4;
    L13:
        return (ParamType) r1;
    L5:
        r5 = null;
        goto L7
    }

    public a(String r1, String r2, Map<String, Object> r3) {
        this.popupCode = r1;
        this.nodeKey = r2;
        this.params = r3;
    }
}
