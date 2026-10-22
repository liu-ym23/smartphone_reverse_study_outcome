package com.bytedance.locallife.live.model;

import com.bytedance.locallife.host.model.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\"B7\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/live/model/CardAtmosphere;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "component2", "", "component3", "Lcom/bytedance/locallife/host/model/UrlModel;", "component4", "atmosphereType", "num", "text", "icon", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/locallife/host/model/UrlModel;)Lcom/bytedance/locallife/live/model/CardAtmosphere;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getAtmosphereType", "getNum", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/bytedance/locallife/host/model/UrlModel;", "getIcon", "()Lcom/bytedance/locallife/host/model/UrlModel;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/locallife/host/model/UrlModel;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class CardAtmosphere implements Serializable {
    public static final int ANIM_TYPE_FLAMES = 2;
    public static final int ANIM_TYPE_INIT = 0;
    public static final int ANIM_TYPE_MEDAL = 3;
    public static final int ANIM_TYPE_SMALL_BELL = 1;
    public static final a Companion = null;

    @SerializedName("atmosphere_type")
    private final Integer atmosphereType;

    @SerializedName("icon")
    private final UrlModel icon;

    @SerializedName("num")
    private final Integer num;

    @SerializedName("text")
    private final String text;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardAtmosphere() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CardAtmosphere copy$default(CardAtmosphere r100, Integer r101, Integer r102, String r103, UrlModel r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.atmosphereType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.num;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.text;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.icon;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.atmosphereType;
    }

    public final Integer component2() {
        return this.num;
    }

    public final String component3() {
        return this.text;
    }

    public final UrlModel component4() {
        return this.icon;
    }

    public final CardAtmosphere copy(Integer r100, Integer r101, String r102, UrlModel r103) {
        return new CardAtmosphere(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardAtmosphere) == true) goto L8;
        return false;
    L8:
        CardAtmosphere r101 = (CardAtmosphere) r100;
        if (Intrinsics.areEqual(this.atmosphereType, r101.atmosphereType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.num, r101.num) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
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
        UrlModel r110 = this.icon;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "CardAtmosphere(atmosphereType=" + this.atmosphereType + ", num=" + this.num + ", text=" + this.text + ", icon=" + this.icon + ')';
    }

    public final Integer getAtmosphereType() {
        return this.atmosphereType;
    }

    public final UrlModel getIcon() {
        return this.icon;
    }

    public final Integer getNum() {
        return this.num;
    }

    public final String getText() {
        return this.text;
    }

    public CardAtmosphere(Integer r100, Integer r101, String r102, UrlModel r103) {
        this.atmosphereType = r100;
        this.num = r101;
        this.text = r102;
        this.icon = r103;
    }

    public /* synthetic */ CardAtmosphere(Integer r100, Integer r101, String r102, UrlModel r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
