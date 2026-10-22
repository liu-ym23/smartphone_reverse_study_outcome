package kec;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ss/android/lark/widget/richtext/json/property/ImagePropertyParser$ImagePropertyBean;", "", "urls", "", "", "token", "originKey", "originHeight", "", "originWidth", "isOriginSource", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getUrls", "()Ljava/util/List;", "getToken", "()Ljava/lang/String;", "getOriginKey", "getOriginHeight", "()I", "getOriginWidth", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("isOriginSource")
    private final boolean isOriginSource;

    @SerializedName("originHeight")
    private final int originHeight;

    @SerializedName("originKey")
    private final String originKey;

    @SerializedName("originWidth")
    private final int originWidth;

    @SerializedName("token")
    private final String token;

    @SerializedName("urls")
    private final List<String> urls;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.urls, r101.urls) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.originKey, r101.originKey) == true) goto L18;
        return false;
    L18:
        if (this.originHeight == r101.originHeight) goto L21;
        return false;
    L21:
        if (this.originWidth == r101.originWidth) goto L24;
        return false;
    L24:
        if (this.isOriginSource == r101.isOriginSource) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.urls.hashCode() * 31) + this.token.hashCode()) * 31) + this.originKey.hashCode()) * 31) + this.originHeight) * 31) + this.originWidth) * 31;
        if (this.isOriginSource == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ImagePropertyBean(urls=" + this.urls + ", token=" + this.token + ", originKey=" + this.originKey + ", originHeight=" + this.originHeight + ", originWidth=" + this.originWidth + ", isOriginSource=" + this.isOriginSource + ')';
    }

    public b() {
        List<String> r100 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "urls");
        Intrinsics.checkNotNullParameter("", "token");
        Intrinsics.checkNotNullParameter("", "originKey");
        this.urls = r100;
        this.token = "";
        this.originKey = "";
        this.originHeight = 0;
        this.originWidth = 0;
        this.isOriginSource = false;
    }
}
