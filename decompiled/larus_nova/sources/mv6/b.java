package mv6;

import com.amap.api.col.s.ce;
import com.bytedance.locallife.host.model.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lmv6/b;", "", "", "atmosphereType", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "num", "f", "", "text", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "componentId", "c", "cardId", "getCardId", "", "availableAb", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/locallife/host/model/UrlModel;", "imageInfo", "Lcom/bytedance/locallife/host/model/UrlModel;", "d", "()Lcom/bytedance/locallife/host/model/UrlModel;", "", "needDelete", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("atmosphere_type")
    private final Integer atmosphereType;

    @SerializedName("available_ab")
    private final List<Integer> availableAb;

    @SerializedName("card_id")
    private final String cardId;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("image_info")
    private final UrlModel imageInfo;

    @SerializedName("need_delete")
    private final Boolean needDelete;

    @SerializedName("num")
    private final Integer num;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.atmosphereType, r101.atmosphereType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.num, r101.num) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardId, r101.cardId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.availableAb, r101.availableAb) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageInfo, r101.imageInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.needDelete, r101.needDelete) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.atmosphereType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.num;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.componentId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cardId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<Integer> r116 = this.availableAb;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        UrlModel r119 = this.imageInfo;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.needDelete;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AtmosphereInfo(atmosphereType=" + this.atmosphereType + ", num=" + this.num + ", text=" + this.text + ", componentId=" + this.componentId + ", cardId=" + this.cardId + ", availableAb=" + this.availableAb + ", imageInfo=" + this.imageInfo + ", needDelete=" + this.needDelete + ')';
    }

    public final Integer a() {
        return this.atmosphereType;
    }

    public final List<Integer> b() {
        return this.availableAb;
    }

    public final String c() {
        return this.componentId;
    }

    public final UrlModel d() {
        return this.imageInfo;
    }

    public final Boolean e() {
        return this.needDelete;
    }

    public final Integer f() {
        return this.num;
    }

    public final String g() {
        return this.text;
    }
}
