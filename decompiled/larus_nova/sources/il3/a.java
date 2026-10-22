package il3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.popupCode, r101.popupCode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nodeKey, r101.nodeKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.popupCode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.nodeKey;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.params;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HybridPopupConfig(popupCode=" + this.popupCode + ", nodeKey=" + this.nodeKey + ", params=" + this.params + ")";
    }

    public final String b() {
        String r100 = this.nodeKey;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        String r103 = null;
        if (r102 == false) goto L19;
        Map<String, Object> r104 = this.params;
        if (r104 == null) goto L14;
        Object r105 = r104.get("key");
    L16:
        if ((r105 instanceof String) == true) goto L18;
        r105 = null;
    L18:
        r100 = (String) r105;
        goto L19
    L14:
        r105 = null;
    L19:
        if (r100 != null) goto L21;
    L22:
        r101 = true;
    L23:
        if (r101 == false) goto L28;
        UUID r106 = UUID.randomUUID();
        if (r106 == null) goto L27;
        r103 = r106.toString();
    L27:
        r100 = r103;
    L28:
        Intrinsics.checkNotNull(r100);
        return r100;
    L21:
        if (r100.length() != 0) goto L23;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final <ParamType> ParamType a(String r100, ParamType r101) {
        Map<String, Object> r102 = this.params;
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get(r100);
    L7:
        if ((r104 instanceof Object) == false) goto L10;
        r103 = r104;
    L10:
        if (r103 != null) goto L13;
        return r101;
    L13:
        return (ParamType) r103;
    L5:
        r104 = null;
        goto L7
    }

    public a(String r100, String r101, Map<String, Object> r102) {
        this.popupCode = r100;
        this.nodeKey = r101;
        this.params = r102;
    }
}
