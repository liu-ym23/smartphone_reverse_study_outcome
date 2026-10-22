package d63;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RB\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Ld63/u;", "", "", "title", "Ljava/lang/String;", "d", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "", "contents", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "", "type", "I", "getType", "()I", "setType", "(I)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "links", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "setLinks", "(Ljava/util/HashMap;)V", "", "defaultShow", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("content")
    private List<String> contents;

    @SerializedName("default_show")
    private final Boolean defaultShow;

    @SerializedName("links")
    private HashMap<String, String> links;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private int type;

    public u() {
        this(null, null, 0, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L16;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.contents, r101.contents) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.links, r101.links) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.defaultShow, r101.defaultShow) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.contents;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.type) * 31;
        HashMap<String, String> r107 = this.links;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.defaultShow;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UnifiedTipsVO(title=" + this.title + ", contents=" + this.contents + ", type=" + this.type + ", links=" + this.links + ", defaultShow=" + this.defaultShow + ")";
    }

    public final List<String> a() {
        return this.contents;
    }

    public final Boolean b() {
        return this.defaultShow;
    }

    public final HashMap<String, String> c() {
        return this.links;
    }

    public final String d() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public u(String r100, List<String> r101, int r102, HashMap<String, String> r103, Boolean r104) {
        this.title = r100;
        this.contents = r101;
        this.type = r102;
        this.links = r103;
        this.defaultShow = r104;
    }
}
