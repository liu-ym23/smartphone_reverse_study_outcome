package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00012Ba\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003Jc\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010%R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b,\u0010+R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b-\u0010+R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b.\u0010+¨\u00063"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcImpression;", "Ljava/io/Serializable;", "", "component1", "", "component2", "", "component3", "component4", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "component5", "component6", "component7", "component8", "id", "text", "count", "sentiment", "iconLight", "iconDark", "iconLightSel", "iconDarkSel", "copy", "toString", "hashCode", "", "other", "", "equals", "J", "getId", "()J", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "I", "getCount", "()I", "setCount", "(I)V", "getSentiment", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getIconLight", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getIconDark", "getIconLightSel", "getIconDarkSel", "<init>", "(JLjava/lang/String;IILcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiUgcImpression implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("count")
    private int count;

    @SerializedName("icon_dark")
    private final PoiImageUrlModel iconDark;

    @SerializedName("icon_dark_sel")
    private final PoiImageUrlModel iconDarkSel;

    @SerializedName("icon_light")
    private final PoiImageUrlModel iconLight;

    @SerializedName("icon_light_sel")
    private final PoiImageUrlModel iconLightSel;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final long f260857id;

    @SerializedName("sentiment")
    private final int sentiment;

    @SerializedName("text")
    private final String text;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PoiUgcImpression() {
        this(0, null, 0, 0, null, null, null, null, 255, null);
    }

    public static /* synthetic */ PoiUgcImpression copy$default(PoiUgcImpression r110, long r111, String r112, int r113, int r114, PoiImageUrlModel r115, PoiImageUrlModel r116, PoiImageUrlModel r117, PoiImageUrlModel r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.f260857id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.text;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.count;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.sentiment;
    L19:
        if ((r210 & 16) == 0) goto L21;
        PoiImageUrlModel r104 = r110.iconLight;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PoiImageUrlModel r105 = r110.iconDark;
    L27:
        if ((r210 & 64) == 0) goto L29;
        PoiImageUrlModel r106 = r110.iconLightSel;
    L31:
        if ((r210 & 128) == 0) goto L33;
        PoiImageUrlModel r107 = r110.iconDarkSel;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f260857id;
    }

    public final String component2() {
        return this.text;
    }

    public final int component3() {
        return this.count;
    }

    public final int component4() {
        return this.sentiment;
    }

    public final PoiImageUrlModel component5() {
        return this.iconLight;
    }

    public final PoiImageUrlModel component6() {
        return this.iconDark;
    }

    public final PoiImageUrlModel component7() {
        return this.iconLightSel;
    }

    public final PoiImageUrlModel component8() {
        return this.iconDarkSel;
    }

    public final PoiUgcImpression copy(long r110, String r111, int r112, int r113, PoiImageUrlModel r114, PoiImageUrlModel r115, PoiImageUrlModel r116, PoiImageUrlModel r210) {
        return new PoiUgcImpression(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcImpression) == true) goto L8;
        return false;
    L8:
        PoiUgcImpression r101 = (PoiUgcImpression) r100;
        if (this.f260857id == r101.f260857id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (this.count == r101.count) goto L18;
        return false;
    L18:
        if (this.sentiment == r101.sentiment) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconLight, r101.iconLight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconDark, r101.iconDark) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.iconLightSel, r101.iconLightSel) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconDarkSel, r101.iconDarkSel) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        long r100 = this.f260857id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.text;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (((((r101 + r104) * 31) + this.count) * 31) + this.sentiment) * 31;
        PoiImageUrlModel r106 = this.iconLight;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        PoiImageUrlModel r109 = this.iconDark;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        PoiImageUrlModel r112 = this.iconLightSel;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        PoiImageUrlModel r115 = this.iconDarkSel;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        return r114 + r103;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiUgcImpression(id=" + this.f260857id + ", text=" + this.text + ", count=" + this.count + ", sentiment=" + this.sentiment + ", iconLight=" + this.iconLight + ", iconDark=" + this.iconDark + ", iconLightSel=" + this.iconLightSel + ", iconDarkSel=" + this.iconDarkSel + ')';
    }

    public final int getCount() {
        return this.count;
    }

    public final PoiImageUrlModel getIconDark() {
        return this.iconDark;
    }

    public final PoiImageUrlModel getIconDarkSel() {
        return this.iconDarkSel;
    }

    public final PoiImageUrlModel getIconLight() {
        return this.iconLight;
    }

    public final PoiImageUrlModel getIconLightSel() {
        return this.iconLightSel;
    }

    public final long getId() {
        return this.f260857id;
    }

    public final int getSentiment() {
        return this.sentiment;
    }

    public final String getText() {
        return this.text;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public PoiUgcImpression(long r100, String r101, int r102, int r103, PoiImageUrlModel r104, PoiImageUrlModel r105, PoiImageUrlModel r106, PoiImageUrlModel r107) {
        this.f260857id = r100;
        this.text = r101;
        this.count = r102;
        this.sentiment = r103;
        this.iconLight = r104;
        this.iconDark = r105;
        this.iconLightSel = r106;
        this.iconDarkSel = r107;
    }

    public /* synthetic */ PoiUgcImpression(long r110, String r111, int r112, int r113, PoiImageUrlModel r114, PoiImageUrlModel r115, PoiImageUrlModel r116, PoiImageUrlModel r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = "";
    L10:
        int r102 = 0;
        if ((r210 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r210 & 8) != 0) goto L18;
        r102 = r113;
    L18:
        PoiImageUrlModel r104 = null;
        if ((r210 & 16) == 0) goto L21;
        PoiImageUrlModel r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PoiImageUrlModel r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        PoiImageUrlModel r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r104 = r117;
    L34:
        this(r100, r101, r103, r102, r105, r106, r107, r104);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
