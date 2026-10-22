package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0013\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0086\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\bJ\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016¨\u00065"}, d2 = {"Lcom/larus/bmhome/auth/BgImageConfig;", "Landroid/os/Parcelable;", "abParam", "Lcom/larus/bmhome/auth/BgImageAbParam;", "drawStyle", "", "Lcom/larus/bmhome/auth/ImageAndContent;", "showBgImageCnt", "", "showBgImageMaxCnt", "userBotType", "userBotGender", "showCopyMyVoice", "", "genBgImageEstimatedTime", "<init>", "(Lcom/larus/bmhome/auth/BgImageAbParam;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getAbParam", "()Lcom/larus/bmhome/auth/BgImageAbParam;", "getDrawStyle", "()Ljava/util/List;", "getShowBgImageCnt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowBgImageMaxCnt", "getUserBotType", "getUserBotGender", "getShowCopyMyVoice", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGenBgImageEstimatedTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/larus/bmhome/auth/BgImageAbParam;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/bmhome/auth/BgImageConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgImageConfig implements Parcelable {
    public static final Parcelable.Creator<BgImageConfig> CREATOR = null;

    @SerializedName("ab_param")
    private final BgImageAbParam abParam;

    @SerializedName("draw_style")
    private final List<ImageAndContent> drawStyle;

    @SerializedName("gen_bg_image_estimated_time")
    private final Integer genBgImageEstimatedTime;

    @SerializedName("show_bg_image_cnt")
    private final Integer showBgImageCnt;

    @SerializedName("show_bg_image_max_cnt")
    private final Integer showBgImageMaxCnt;

    @SerializedName("show_copy_my_voice")
    private final Boolean showCopyMyVoice;

    @SerializedName("user_bot_gender")
    private final List<ImageAndContent> userBotGender;

    @SerializedName("user_bot_type")
    private final List<ImageAndContent> userBotType;

    public static final class a implements Parcelable.Creator<BgImageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageConfig createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Integer r100 = null;
            if (r110.readInt() != 0) goto L5;
            BgImageAbParam r101 = null;
        L6:
            BgImageAbParam r102 = r101;
            boolean r103 = false;
            if (r110.readInt() != 0) goto L9;
            ArrayList r104 = null;
        L17:
            if (r110.readInt() != 0) goto L19;
            Integer r105 = null;
        L21:
            if (r110.readInt() != 0) goto L23;
            Integer r106 = null;
        L25:
            if (r110.readInt() != 0) goto L27;
            ArrayList r107 = null;
        L35:
            if (r110.readInt() != 0) goto L37;
            ArrayList r108 = null;
        L45:
            if (r110.readInt() != 0) goto L48;
            Boolean r109 = null;
        L52:
            if (r110.readInt() == 0) goto L56;
            r100 = Integer.valueOf(r110.readInt());
        L56:
            return new BgImageConfig(r102, r104, r105, r106, r107, r108, r109, r100);
        L48:
            if (r110.readInt() == 0) goto L50;
            r103 = true;
        L50:
            r109 = Boolean.valueOf(r103);
            goto L52
        L37:
            int r111 = r110.readInt();
            r108 = new ArrayList(r111);
            int r112 = 0;
        L38:
            if (r112 == r111) goto L45;
            if (r110.readInt() != 0) goto L42;
            ImageAndContent r113 = null;
        L43:
            r108.add(r113);
            r112 = r112 + 1;
            goto L38
        L42:
            r113 = ImageAndContent.CREATOR.createFromParcel(r110);
            goto L43
        L27:
            int r114 = r110.readInt();
            r107 = new ArrayList(r114);
            int r115 = 0;
        L28:
            if (r115 == r114) goto L35;
            if (r110.readInt() != 0) goto L32;
            ImageAndContent r116 = null;
        L33:
            r107.add(r116);
            r115 = r115 + 1;
            goto L28
        L32:
            r116 = ImageAndContent.CREATOR.createFromParcel(r110);
            goto L33
        L23:
            r106 = Integer.valueOf(r110.readInt());
            goto L25
        L19:
            r105 = Integer.valueOf(r110.readInt());
            goto L21
        L9:
            int r117 = r110.readInt();
            r104 = new ArrayList(r117);
            int r118 = 0;
        L10:
            if (r118 == r117) goto L17;
            if (r110.readInt() != 0) goto L14;
            ImageAndContent r119 = null;
        L15:
            r104.add(r119);
            r118 = r118 + 1;
            goto L10
        L14:
            r119 = ImageAndContent.CREATOR.createFromParcel(r110);
            goto L15
        L5:
            r101 = BgImageAbParam.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BgImageConfig[] newArray(int r100) {
            return new BgImageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BgImageConfig() {
        this(null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgImageConfig) == true) goto L8;
        return false;
    L8:
        BgImageConfig r101 = (BgImageConfig) r100;
        if (Intrinsics.areEqual(this.abParam, r101.abParam) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.drawStyle, r101.drawStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showBgImageCnt, r101.showBgImageCnt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showBgImageMaxCnt, r101.showBgImageMaxCnt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userBotType, r101.userBotType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userBotGender, r101.userBotGender) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.showCopyMyVoice, r101.showCopyMyVoice) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.genBgImageEstimatedTime, r101.genBgImageEstimatedTime) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        BgImageAbParam r100 = this.abParam;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<ImageAndContent> r104 = this.drawStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.showBgImageCnt;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.showBgImageMaxCnt;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<ImageAndContent> r113 = this.userBotType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<ImageAndContent> r116 = this.userBotGender;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.showCopyMyVoice;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.genBgImageEstimatedTime;
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
        return "BgImageConfig(abParam=" + this.abParam + ", drawStyle=" + this.drawStyle + ", showBgImageCnt=" + this.showBgImageCnt + ", showBgImageMaxCnt=" + this.showBgImageMaxCnt + ", userBotType=" + this.userBotType + ", userBotGender=" + this.userBotGender + ", showCopyMyVoice=" + this.showCopyMyVoice + ", genBgImageEstimatedTime=" + this.genBgImageEstimatedTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        BgImageAbParam r102 = this.abParam;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        List<ImageAndContent> r103 = this.drawStyle;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L16:
        Integer r104 = this.showBgImageCnt;
        if (r104 != null) goto L19;
        r100.writeInt(0);
    L20:
        Integer r105 = this.showBgImageMaxCnt;
        if (r105 != null) goto L23;
        r100.writeInt(0);
    L24:
        List<ImageAndContent> r106 = this.userBotType;
        if (r106 != null) goto L27;
        r100.writeInt(0);
    L34:
        List<ImageAndContent> r107 = this.userBotGender;
        if (r107 != null) goto L37;
        r100.writeInt(0);
    L44:
        Boolean r108 = this.showCopyMyVoice;
        if (r108 != null) goto L47;
        r100.writeInt(0);
    L48:
        Integer r109 = this.genBgImageEstimatedTime;
        if (r109 != null) goto L51;
        r100.writeInt(0);
        return;
    L51:
        r100.writeInt(1);
        r100.writeInt(r109.intValue());
        return;
    L47:
        r100.writeInt(1);
        r100.writeInt(r108.booleanValue() ? 1 : 0);
        goto L48
    L37:
        r100.writeInt(1);
        r100.writeInt(r107.size());
        Iterator<ImageAndContent> r110 = r107.iterator();
    L39:
        if (r110.hasNext() == false) goto L44;
        ImageAndContent r111 = r110.next();
        if (r111 == null) goto L42;
        r100.writeInt(1);
        r111.writeToParcel(r100, r101);
        goto L39
    L42:
        r100.writeInt(0);
        goto L39
    L27:
        r100.writeInt(1);
        r100.writeInt(r106.size());
        Iterator<ImageAndContent> r112 = r106.iterator();
    L29:
        if (r112.hasNext() == false) goto L34;
        ImageAndContent r113 = r112.next();
        if (r113 == null) goto L32;
        r100.writeInt(1);
        r113.writeToParcel(r100, r101);
        goto L29
    L32:
        r100.writeInt(0);
        goto L29
    L23:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        goto L24
    L19:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L20
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<ImageAndContent> r114 = r103.iterator();
    L11:
        if (r114.hasNext() == false) goto L16;
        ImageAndContent r115 = r114.next();
        if (r115 == null) goto L14;
        r100.writeInt(1);
        r115.writeToParcel(r100, r101);
        goto L11
    L14:
        r100.writeInt(0);
        goto L11
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final BgImageAbParam a() {
        return this.abParam;
    }

    public final List<ImageAndContent> b() {
        return this.drawStyle;
    }

    public final Integer c() {
        return this.showBgImageCnt;
    }

    public final Integer d() {
        return this.showBgImageMaxCnt;
    }

    public BgImageConfig(BgImageAbParam r100, List<ImageAndContent> r101, Integer r102, Integer r103, List<ImageAndContent> r104, List<ImageAndContent> r105, Boolean r106, Integer r107) {
        this.abParam = r100;
        this.drawStyle = r101;
        this.showBgImageCnt = r102;
        this.showBgImageMaxCnt = r103;
        this.userBotType = r104;
        this.userBotGender = r105;
        this.showCopyMyVoice = r106;
        this.genBgImageEstimatedTime = r107;
    }
}
